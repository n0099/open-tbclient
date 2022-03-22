package c.a.p0.p4.e;

import android.text.TextUtils;
import c.a.p0.p4.c.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.videoplay.VideoPlayView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f17050b;

    /* renamed from: c  reason: collision with root package name */
    public d f17051c;

    /* renamed from: d  reason: collision with root package name */
    public VideoPlayView.f f17052d;

    /* renamed from: e  reason: collision with root package name */
    public int f17053e;

    /* renamed from: f  reason: collision with root package name */
    public Set<String> f17054f;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.f17050b = 0;
        this.f17054f = new HashSet();
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f17053e = Math.min(7, TbConfig.PREFETCH_NEXT_VIDEO_NUM);
            this.f17050b = this.a + 1;
            b();
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f17051c == null || this.f17053e <= 0) {
            return;
        }
        while (this.f17050b < this.f17051c.k()) {
            VideoItemData s = this.f17051c.s(this.f17050b);
            this.f17050b++;
            if (s != null && !TextUtils.isEmpty(s.video_url)) {
                this.f17053e--;
                if (!this.f17054f.contains(s.video_url)) {
                    CyberPlayerManager.prefetch(s.video_url, null, null, TbConfig.PREFETCH_NEXT_VIDEO_SIZE, null);
                    this.f17054f.add(s.video_url);
                }
                if (this.f17053e <= 0) {
                    break;
                }
            }
        }
        if (this.f17053e <= 0 || this.f17052d == null || this.f17051c.k() - this.a >= 10) {
            return;
        }
        this.f17052d.a();
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.a = i;
        }
    }

    public void d(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) {
            this.f17051c = dVar;
        }
    }

    public void e(VideoPlayView.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) {
            this.f17052d = fVar;
        }
    }
}

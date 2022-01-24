package c.a.t0.m4.n;

import android.text.TextUtils;
import c.a.t0.m4.l.d;
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
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f19644b;

    /* renamed from: c  reason: collision with root package name */
    public d f19645c;

    /* renamed from: d  reason: collision with root package name */
    public VideoPlayView.f f19646d;

    /* renamed from: e  reason: collision with root package name */
    public int f19647e;

    /* renamed from: f  reason: collision with root package name */
    public Set<String> f19648f;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.f19644b = 0;
        this.f19648f = new HashSet();
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f19647e = Math.min(7, TbConfig.PREFETCH_NEXT_VIDEO_NUM);
            this.f19644b = this.a + 1;
            b();
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f19645c == null || this.f19647e <= 0) {
            return;
        }
        while (this.f19644b < this.f19645c.k()) {
            VideoItemData s = this.f19645c.s(this.f19644b);
            this.f19644b++;
            if (s != null && !TextUtils.isEmpty(s.video_url)) {
                this.f19647e--;
                if (!this.f19648f.contains(s.video_url)) {
                    CyberPlayerManager.prefetch(s.video_url, null, null, TbConfig.PREFETCH_NEXT_VIDEO_SIZE, null);
                    this.f19648f.add(s.video_url);
                }
                if (this.f19647e <= 0) {
                    break;
                }
            }
        }
        if (this.f19647e <= 0 || this.f19646d == null || this.f19645c.k() - this.a >= 10) {
            return;
        }
        this.f19646d.a();
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.a = i2;
        }
    }

    public void d(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) {
            this.f19645c = dVar;
        }
    }

    public void e(VideoPlayView.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) {
            this.f19646d = fVar;
        }
    }
}

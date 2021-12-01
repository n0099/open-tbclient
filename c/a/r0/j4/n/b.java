package c.a.r0.j4.n;

import android.text.TextUtils;
import c.a.r0.j4.l.d;
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
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f18430b;

    /* renamed from: c  reason: collision with root package name */
    public d f18431c;

    /* renamed from: d  reason: collision with root package name */
    public VideoPlayView.f f18432d;

    /* renamed from: e  reason: collision with root package name */
    public int f18433e;

    /* renamed from: f  reason: collision with root package name */
    public Set<String> f18434f;

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
        this.f18430b = 0;
        this.f18434f = new HashSet();
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f18433e = Math.min(7, TbConfig.PREFETCH_NEXT_VIDEO_NUM);
            this.f18430b = this.a + 1;
            b();
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f18431c == null || this.f18433e <= 0) {
            return;
        }
        while (this.f18430b < this.f18431c.k()) {
            VideoItemData s = this.f18431c.s(this.f18430b);
            this.f18430b++;
            if (s != null && !TextUtils.isEmpty(s.video_url)) {
                this.f18433e--;
                if (!this.f18434f.contains(s.video_url)) {
                    CyberPlayerManager.prefetch(s.video_url, null, null, TbConfig.PREFETCH_NEXT_VIDEO_SIZE, null);
                    this.f18434f.add(s.video_url);
                }
                if (this.f18433e <= 0) {
                    break;
                }
            }
        }
        if (this.f18433e <= 0 || this.f18432d == null || this.f18431c.k() - this.a >= 10) {
            return;
        }
        this.f18432d.a();
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
            this.f18431c = dVar;
        }
    }

    public void e(VideoPlayView.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) {
            this.f18432d = fVar;
        }
    }
}

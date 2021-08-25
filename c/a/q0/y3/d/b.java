package c.a.q0.y3.d;

import android.text.TextUtils;
import c.a.q0.y3.c.d;
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
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f29177a;

    /* renamed from: b  reason: collision with root package name */
    public int f29178b;

    /* renamed from: c  reason: collision with root package name */
    public d f29179c;

    /* renamed from: d  reason: collision with root package name */
    public VideoPlayView.e f29180d;

    /* renamed from: e  reason: collision with root package name */
    public int f29181e;

    /* renamed from: f  reason: collision with root package name */
    public Set<String> f29182f;

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
        this.f29177a = 0;
        this.f29178b = 0;
        this.f29182f = new HashSet();
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f29181e = Math.min(7, TbConfig.PREFETCH_NEXT_VIDEO_NUM);
            this.f29178b = this.f29177a + 1;
            b();
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f29179c == null || this.f29181e <= 0) {
            return;
        }
        while (this.f29178b < this.f29179c.j()) {
            VideoItemData p = this.f29179c.p(this.f29178b);
            this.f29178b++;
            if (p != null && !TextUtils.isEmpty(p.video_url)) {
                this.f29181e--;
                if (!this.f29182f.contains(p.video_url)) {
                    CyberPlayerManager.prefetch(p.video_url, null, null, TbConfig.PREFETCH_NEXT_VIDEO_SIZE, null);
                    this.f29182f.add(p.video_url);
                }
                if (this.f29181e <= 0) {
                    break;
                }
            }
        }
        if (this.f29181e <= 0 || this.f29180d == null || this.f29179c.j() - this.f29177a >= 10) {
            return;
        }
        this.f29180d.a();
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f29177a = i2;
        }
    }

    public void d(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) {
            this.f29179c = dVar;
        }
    }

    public void e(VideoPlayView.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, eVar) == null) {
            this.f29180d = eVar;
        }
    }
}

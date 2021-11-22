package b.a.r0.c4.m;

import android.text.TextUtils;
import b.a.r0.c4.l.d;
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
    public int f16685a;

    /* renamed from: b  reason: collision with root package name */
    public int f16686b;

    /* renamed from: c  reason: collision with root package name */
    public d f16687c;

    /* renamed from: d  reason: collision with root package name */
    public VideoPlayView.e f16688d;

    /* renamed from: e  reason: collision with root package name */
    public int f16689e;

    /* renamed from: f  reason: collision with root package name */
    public Set<String> f16690f;

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
        this.f16685a = 0;
        this.f16686b = 0;
        this.f16690f = new HashSet();
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f16689e = Math.min(7, TbConfig.PREFETCH_NEXT_VIDEO_NUM);
            this.f16686b = this.f16685a + 1;
            b();
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f16687c == null || this.f16689e <= 0) {
            return;
        }
        while (this.f16686b < this.f16687c.k()) {
            VideoItemData s = this.f16687c.s(this.f16686b);
            this.f16686b++;
            if (s != null && !TextUtils.isEmpty(s.video_url)) {
                this.f16689e--;
                if (!this.f16690f.contains(s.video_url)) {
                    CyberPlayerManager.prefetch(s.video_url, null, null, TbConfig.PREFETCH_NEXT_VIDEO_SIZE, null);
                    this.f16690f.add(s.video_url);
                }
                if (this.f16689e <= 0) {
                    break;
                }
            }
        }
        if (this.f16689e <= 0 || this.f16688d == null || this.f16687c.k() - this.f16685a >= 10) {
            return;
        }
        this.f16688d.a();
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f16685a = i2;
        }
    }

    public void d(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) {
            this.f16687c = dVar;
        }
    }

    public void e(VideoPlayView.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, eVar) == null) {
            this.f16688d = eVar;
        }
    }
}

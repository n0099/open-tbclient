package c.a.r0.a4.d;

import android.text.TextUtils;
import c.a.r0.a4.c.d;
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
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f15680a;

    /* renamed from: b  reason: collision with root package name */
    public int f15681b;

    /* renamed from: c  reason: collision with root package name */
    public d f15682c;

    /* renamed from: d  reason: collision with root package name */
    public VideoPlayView.e f15683d;

    /* renamed from: e  reason: collision with root package name */
    public int f15684e;

    /* renamed from: f  reason: collision with root package name */
    public Set<String> f15685f;

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
        this.f15680a = 0;
        this.f15681b = 0;
        this.f15685f = new HashSet();
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f15684e = Math.min(7, TbConfig.PREFETCH_NEXT_VIDEO_NUM);
            this.f15681b = this.f15680a + 1;
            b();
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f15682c == null || this.f15684e <= 0) {
            return;
        }
        while (this.f15681b < this.f15682c.k()) {
            VideoItemData s = this.f15682c.s(this.f15681b);
            this.f15681b++;
            if (s != null && !TextUtils.isEmpty(s.video_url)) {
                this.f15684e--;
                if (!this.f15685f.contains(s.video_url)) {
                    CyberPlayerManager.prefetch(s.video_url, null, null, TbConfig.PREFETCH_NEXT_VIDEO_SIZE, null);
                    this.f15685f.add(s.video_url);
                }
                if (this.f15684e <= 0) {
                    break;
                }
            }
        }
        if (this.f15684e <= 0 || this.f15683d == null || this.f15682c.k() - this.f15680a >= 10) {
            return;
        }
        this.f15683d.a();
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f15680a = i2;
        }
    }

    public void d(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) {
            this.f15682c = dVar;
        }
    }

    public void e(VideoPlayView.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, eVar) == null) {
            this.f15683d = eVar;
        }
    }
}

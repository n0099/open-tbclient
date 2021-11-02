package b.a.r0.b4.m;

import android.text.TextUtils;
import b.a.r0.b4.l.d;
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
    public int f15057a;

    /* renamed from: b  reason: collision with root package name */
    public int f15058b;

    /* renamed from: c  reason: collision with root package name */
    public d f15059c;

    /* renamed from: d  reason: collision with root package name */
    public VideoPlayView.e f15060d;

    /* renamed from: e  reason: collision with root package name */
    public int f15061e;

    /* renamed from: f  reason: collision with root package name */
    public Set<String> f15062f;

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
        this.f15057a = 0;
        this.f15058b = 0;
        this.f15062f = new HashSet();
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f15061e = Math.min(7, TbConfig.PREFETCH_NEXT_VIDEO_NUM);
            this.f15058b = this.f15057a + 1;
            b();
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f15059c == null || this.f15061e <= 0) {
            return;
        }
        while (this.f15058b < this.f15059c.k()) {
            VideoItemData s = this.f15059c.s(this.f15058b);
            this.f15058b++;
            if (s != null && !TextUtils.isEmpty(s.video_url)) {
                this.f15061e--;
                if (!this.f15062f.contains(s.video_url)) {
                    CyberPlayerManager.prefetch(s.video_url, null, null, TbConfig.PREFETCH_NEXT_VIDEO_SIZE, null);
                    this.f15062f.add(s.video_url);
                }
                if (this.f15061e <= 0) {
                    break;
                }
            }
        }
        if (this.f15061e <= 0 || this.f15060d == null || this.f15059c.k() - this.f15057a >= 10) {
            return;
        }
        this.f15060d.a();
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f15057a = i2;
        }
    }

    public void d(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) {
            this.f15059c = dVar;
        }
    }

    public void e(VideoPlayView.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, eVar) == null) {
            this.f15060d = eVar;
        }
    }
}

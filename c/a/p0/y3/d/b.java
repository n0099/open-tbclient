package c.a.p0.y3.d;

import android.text.TextUtils;
import c.a.p0.y3.c.d;
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
    public int f28836a;

    /* renamed from: b  reason: collision with root package name */
    public int f28837b;

    /* renamed from: c  reason: collision with root package name */
    public d f28838c;

    /* renamed from: d  reason: collision with root package name */
    public VideoPlayView.e f28839d;

    /* renamed from: e  reason: collision with root package name */
    public int f28840e;

    /* renamed from: f  reason: collision with root package name */
    public Set<String> f28841f;

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
        this.f28836a = 0;
        this.f28837b = 0;
        this.f28841f = new HashSet();
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f28840e = Math.min(7, TbConfig.PREFETCH_NEXT_VIDEO_NUM);
            this.f28837b = this.f28836a + 1;
            b();
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f28838c == null || this.f28840e <= 0) {
            return;
        }
        while (this.f28837b < this.f28838c.j()) {
            VideoItemData p = this.f28838c.p(this.f28837b);
            this.f28837b++;
            if (p != null && !TextUtils.isEmpty(p.video_url)) {
                this.f28840e--;
                if (!this.f28841f.contains(p.video_url)) {
                    CyberPlayerManager.prefetch(p.video_url, null, null, TbConfig.PREFETCH_NEXT_VIDEO_SIZE, null);
                    this.f28841f.add(p.video_url);
                }
                if (this.f28840e <= 0) {
                    break;
                }
            }
        }
        if (this.f28840e <= 0 || this.f28839d == null || this.f28838c.j() - this.f28836a >= 10) {
            return;
        }
        this.f28839d.a();
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f28836a = i2;
        }
    }

    public void d(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) {
            this.f28838c = dVar;
        }
    }

    public void e(VideoPlayView.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, eVar) == null) {
            this.f28839d = eVar;
        }
    }
}

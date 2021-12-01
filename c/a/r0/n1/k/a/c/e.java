package c.a.r0.n1.k.a.c;

import c.a.d.f.p.k;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.NewHottopic.TimeLineInfo;
/* loaded from: classes6.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public long f20675b;

    /* renamed from: c  reason: collision with root package name */
    public String f20676c;

    /* renamed from: d  reason: collision with root package name */
    public String f20677d;

    /* renamed from: e  reason: collision with root package name */
    public String f20678e;

    /* renamed from: f  reason: collision with root package name */
    public int f20679f;

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void a(TimeLineInfo timeLineInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, timeLineInfo) == null) || timeLineInfo == null) {
            return;
        }
        this.f20675b = timeLineInfo.tid.longValue();
        this.f20676c = timeLineInfo.title;
        this.f20677d = k.isEmpty(timeLineInfo.small_title) ? timeLineInfo.show_time : timeLineInfo.small_title;
        this.f20678e = timeLineInfo.bg_color;
    }
}

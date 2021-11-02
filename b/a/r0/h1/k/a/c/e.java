package b.a.r0.h1.k.a.c;

import b.a.e.e.p.k;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.NewHottopic.TimeLineInfo;
/* loaded from: classes4.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f17606a;

    /* renamed from: b  reason: collision with root package name */
    public long f17607b;

    /* renamed from: c  reason: collision with root package name */
    public String f17608c;

    /* renamed from: d  reason: collision with root package name */
    public String f17609d;

    /* renamed from: e  reason: collision with root package name */
    public String f17610e;

    /* renamed from: f  reason: collision with root package name */
    public int f17611f;

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
        this.f17607b = timeLineInfo.tid.longValue();
        this.f17608c = timeLineInfo.title;
        this.f17609d = k.isEmpty(timeLineInfo.small_title) ? timeLineInfo.show_time : timeLineInfo.small_title;
        this.f17610e = timeLineInfo.bg_color;
    }
}

package c.a.r0.g1.k.a.c;

import c.a.e.e.p.k;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.NewHottopic.TimeLineInfo;
/* loaded from: classes3.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f18499a;

    /* renamed from: b  reason: collision with root package name */
    public long f18500b;

    /* renamed from: c  reason: collision with root package name */
    public String f18501c;

    /* renamed from: d  reason: collision with root package name */
    public String f18502d;

    /* renamed from: e  reason: collision with root package name */
    public String f18503e;

    /* renamed from: f  reason: collision with root package name */
    public int f18504f;

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
        this.f18500b = timeLineInfo.tid.longValue();
        this.f18501c = timeLineInfo.title;
        this.f18502d = k.isEmpty(timeLineInfo.small_title) ? timeLineInfo.show_time : timeLineInfo.small_title;
        this.f18503e = timeLineInfo.bg_color;
    }
}

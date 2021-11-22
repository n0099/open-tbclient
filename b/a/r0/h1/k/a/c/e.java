package b.a.r0.h1.k.a.c;

import b.a.e.f.p.k;
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
    public long f19075a;

    /* renamed from: b  reason: collision with root package name */
    public long f19076b;

    /* renamed from: c  reason: collision with root package name */
    public String f19077c;

    /* renamed from: d  reason: collision with root package name */
    public String f19078d;

    /* renamed from: e  reason: collision with root package name */
    public String f19079e;

    /* renamed from: f  reason: collision with root package name */
    public int f19080f;

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
        this.f19076b = timeLineInfo.tid.longValue();
        this.f19077c = timeLineInfo.title;
        this.f19078d = k.isEmpty(timeLineInfo.small_title) ? timeLineInfo.show_time : timeLineInfo.small_title;
        this.f19079e = timeLineInfo.bg_color;
    }
}

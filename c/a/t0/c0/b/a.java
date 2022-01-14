package c.a.t0.c0.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.Search.DataRes;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public long f15252b;

    /* renamed from: c  reason: collision with root package name */
    public String f15253c;

    /* renamed from: d  reason: collision with root package name */
    public String f15254d;

    /* renamed from: e  reason: collision with root package name */
    public long f15255e;

    /* renamed from: f  reason: collision with root package name */
    public int f15256f;

    /* renamed from: g  reason: collision with root package name */
    public int f15257g;

    /* renamed from: h  reason: collision with root package name */
    public int f15258h;

    /* renamed from: i  reason: collision with root package name */
    public int f15259i;

    /* renamed from: j  reason: collision with root package name */
    public String f15260j;
    public boolean k;
    public long l;

    public a() {
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

    public void a(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, dataRes) == null) || dataRes == null) {
            return;
        }
        Long l = dataRes.uid;
        this.f15252b = l == null ? 0L : l.longValue();
        this.f15253c = dataRes.portrait;
        this.f15254d = dataRes.name_show;
        Long l2 = dataRes.apply_id;
        this.f15255e = l2 == null ? 0L : l2.longValue();
        Integer num = dataRes.vote_num;
        this.f15256f = num == null ? 0 : num.intValue();
        Integer num2 = dataRes.agree_num;
        this.f15257g = num2 == null ? 0 : num2.intValue();
        Integer num3 = dataRes.thread_num;
        this.f15258h = num3 == null ? 0 : num3.intValue();
        Integer num4 = dataRes.post_num;
        this.f15259i = num4 == null ? 0 : num4.intValue();
        Boolean bool = dataRes.is_vote;
        this.k = bool != null ? bool.booleanValue() : false;
        Long l3 = dataRes.tid;
        this.l = l3 != null ? l3.longValue() : 0L;
    }
}

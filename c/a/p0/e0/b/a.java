package c.a.p0.e0.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.Search.DataRes;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public long f13715b;

    /* renamed from: c  reason: collision with root package name */
    public String f13716c;

    /* renamed from: d  reason: collision with root package name */
    public String f13717d;

    /* renamed from: e  reason: collision with root package name */
    public long f13718e;

    /* renamed from: f  reason: collision with root package name */
    public int f13719f;

    /* renamed from: g  reason: collision with root package name */
    public int f13720g;

    /* renamed from: h  reason: collision with root package name */
    public int f13721h;
    public int i;
    public String j;
    public boolean k;
    public long l;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        this.f13715b = l == null ? 0L : l.longValue();
        this.f13716c = dataRes.portrait;
        this.f13717d = dataRes.name_show;
        Long l2 = dataRes.apply_id;
        this.f13718e = l2 == null ? 0L : l2.longValue();
        Integer num = dataRes.vote_num;
        this.f13719f = num == null ? 0 : num.intValue();
        Integer num2 = dataRes.agree_num;
        this.f13720g = num2 == null ? 0 : num2.intValue();
        Integer num3 = dataRes.thread_num;
        this.f13721h = num3 == null ? 0 : num3.intValue();
        Integer num4 = dataRes.post_num;
        this.i = num4 == null ? 0 : num4.intValue();
        Boolean bool = dataRes.is_vote;
        this.k = bool != null ? bool.booleanValue() : false;
        Long l3 = dataRes.tid;
        this.l = l3 != null ? l3.longValue() : 0L;
    }
}

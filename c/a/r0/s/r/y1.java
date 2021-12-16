package c.a.r0.s.r;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes6.dex */
public class y1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public v0 a;

    /* renamed from: b  reason: collision with root package name */
    public List<j> f13480b;

    /* renamed from: c  reason: collision with root package name */
    public List<k> f13481c;

    /* renamed from: d  reason: collision with root package name */
    public List<u0> f13482d;

    public y1() {
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

    public void a(SeniorLottery seniorLottery) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, seniorLottery) == null) || seniorLottery == null) {
            return;
        }
        v0 v0Var = new v0();
        this.a = v0Var;
        v0Var.a(seniorLottery.theme);
        this.f13480b = new ArrayList();
        int size = seniorLottery.award_info.size();
        for (int i2 = 0; i2 < size; i2++) {
            j jVar = new j();
            jVar.a(seniorLottery.award_info.get(i2));
            this.f13480b.add(jVar);
        }
        String str = seniorLottery.myaward;
        this.f13481c = new ArrayList();
        int size2 = seniorLottery.luck_users.size();
        for (int i3 = 0; i3 < size2; i3++) {
            k kVar = new k();
            kVar.a(seniorLottery.luck_users.get(i3));
            this.f13481c.add(kVar);
        }
        String str2 = seniorLottery.act_desc;
        this.f13482d = new ArrayList();
        int size3 = seniorLottery.act_regular.size();
        for (int i4 = 0; i4 < size3; i4++) {
            u0 u0Var = new u0();
            u0Var.a(seniorLottery.act_regular.get(i4));
            this.f13482d.add(u0Var);
        }
    }
}

package c.a.o0.r.r;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes2.dex */
public class v1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public t0 a;

    /* renamed from: b  reason: collision with root package name */
    public List<j> f10969b;

    /* renamed from: c  reason: collision with root package name */
    public List<k> f10970c;

    /* renamed from: d  reason: collision with root package name */
    public List<s0> f10971d;

    public v1() {
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

    public void a(SeniorLottery seniorLottery) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, seniorLottery) == null) || seniorLottery == null) {
            return;
        }
        t0 t0Var = new t0();
        this.a = t0Var;
        t0Var.a(seniorLottery.theme);
        this.f10969b = new ArrayList();
        int size = seniorLottery.award_info.size();
        for (int i = 0; i < size; i++) {
            j jVar = new j();
            jVar.a(seniorLottery.award_info.get(i));
            this.f10969b.add(jVar);
        }
        String str = seniorLottery.myaward;
        this.f10970c = new ArrayList();
        int size2 = seniorLottery.luck_users.size();
        for (int i2 = 0; i2 < size2; i2++) {
            k kVar = new k();
            kVar.a(seniorLottery.luck_users.get(i2));
            this.f10970c.add(kVar);
        }
        String str2 = seniorLottery.act_desc;
        this.f10971d = new ArrayList();
        int size3 = seniorLottery.act_regular.size();
        for (int i3 = 0; i3 < size3; i3++) {
            s0 s0Var = new s0();
            s0Var.a(seniorLottery.act_regular.get(i3));
            this.f10971d.add(s0Var);
        }
    }
}

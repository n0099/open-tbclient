package c.a.r0.o1.b;

import android.content.Intent;
import c.a.d.f.p.n;
import c.a.q0.a1.e.c;
import c.a.q0.c1.b0;
import c.a.q0.r.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.switchs.SocketAddCommonParamSwitch;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.ActivityPage.ActivityPageReqIdl;
import tbclient.ActivityPage.DataReq;
/* loaded from: classes2.dex */
public class a implements c<ActivityPageReqIdl> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public final c.a.q0.a1.d.a f19646b;

    public a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f19646b = new c.a.q0.a1.d.a(false);
        this.a = str2;
    }

    @Override // c.a.q0.a1.e.c
    public void a(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, intent) == null) {
        }
    }

    @Override // c.a.q0.a1.e.c
    public c.a.q0.a1.d.a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f19646b : (c.a.q0.a1.d.a) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.q0.a1.e.c
    /* renamed from: d */
    public ActivityPageReqIdl b(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
            try {
                DataReq.Builder builder = new DataReq.Builder();
                builder.activity_name = this.a;
                builder.pn = Integer.valueOf(this.f19646b.f12000c);
                builder.rn = 20;
                builder.scr_h = Integer.valueOf(n.i(TbadkCoreApplication.getInst()));
                builder.scr_w = Integer.valueOf(n.k(TbadkCoreApplication.getInst()));
                builder.scr_dip = Integer.valueOf((int) n.h(TbadkCoreApplication.getInst()));
                builder.q_type = Integer.valueOf(l.c().e());
                if (z || SocketAddCommonParamSwitch.getIsOn()) {
                    b0.a(builder, true);
                }
                ActivityPageReqIdl.Builder builder2 = new ActivityPageReqIdl.Builder();
                builder2.data = builder.build(false);
                return builder2.build(false);
            } catch (Exception unused) {
                return null;
            }
        }
        return (ActivityPageReqIdl) invokeZ.objValue;
    }
}

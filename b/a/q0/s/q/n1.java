package b.a.q0.s.q;

import android.content.Intent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class n1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f13404a;

    /* renamed from: b  reason: collision with root package name */
    public String f13405b;

    /* renamed from: c  reason: collision with root package name */
    public String f13406c;

    /* renamed from: d  reason: collision with root package name */
    public String f13407d;

    public n1() {
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

    public void a(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, intent) == null) || intent == null) {
            return;
        }
        this.f13404a = intent.getStringExtra(TiebaStatic.Params.RECOM_WEIGHT);
        this.f13405b = intent.getStringExtra("recom_source");
        this.f13406c = intent.getStringExtra("recom_abtag");
        this.f13407d = intent.getStringExtra(TiebaStatic.Params.RECOM_EXTRA);
    }

    public void b(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d2Var) == null) || d2Var == null) {
            return;
        }
        this.f13404a = d2Var.Y0;
        this.f13405b = d2Var.X0;
        this.f13406c = d2Var.Z0;
        this.f13407d = d2Var.a1;
    }

    public void c(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, intent) == null) || intent == null) {
            return;
        }
        intent.putExtra(TiebaStatic.Params.RECOM_WEIGHT, this.f13404a);
        intent.putExtra("recom_source", this.f13405b);
        intent.putExtra("recom_abtag", this.f13406c);
        intent.putExtra(TiebaStatic.Params.RECOM_EXTRA, this.f13407d);
    }

    public void d(b.a.r0.q2.p pVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, pVar) == null) || pVar == null) {
            return;
        }
        pVar.f22888g = this.f13404a;
        pVar.f22887f = this.f13405b;
        pVar.l = this.f13406c;
        pVar.o = this.f13407d;
    }
}

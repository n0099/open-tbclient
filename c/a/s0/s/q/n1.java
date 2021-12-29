package c.a.s0.s.q;

import android.content.Intent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class n1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f13774b;

    /* renamed from: c  reason: collision with root package name */
    public String f13775c;

    /* renamed from: d  reason: collision with root package name */
    public String f13776d;

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
        this.a = intent.getStringExtra(TiebaStatic.Params.RECOM_WEIGHT);
        this.f13774b = intent.getStringExtra("recom_source");
        this.f13775c = intent.getStringExtra("recom_abtag");
        this.f13776d = intent.getStringExtra(TiebaStatic.Params.RECOM_EXTRA);
    }

    public void b(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d2Var) == null) || d2Var == null) {
            return;
        }
        this.a = d2Var.a1;
        this.f13774b = d2Var.Z0;
        this.f13775c = d2Var.b1;
        this.f13776d = d2Var.c1;
    }

    public void c(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, intent) == null) || intent == null) {
            return;
        }
        intent.putExtra(TiebaStatic.Params.RECOM_WEIGHT, this.a);
        intent.putExtra("recom_source", this.f13774b);
        intent.putExtra("recom_abtag", this.f13775c);
        intent.putExtra(TiebaStatic.Params.RECOM_EXTRA, this.f13776d);
    }

    public void d(c.a.t0.z2.t tVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, tVar) == null) || tVar == null) {
            return;
        }
        tVar.f26875g = this.a;
        tVar.f26874f = this.f13774b;
        tVar.l = this.f13775c;
        tVar.o = this.f13776d;
    }
}

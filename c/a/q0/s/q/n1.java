package c.a.q0.s.q;

import android.content.Intent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class n1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f13018b;

    /* renamed from: c  reason: collision with root package name */
    public String f13019c;

    /* renamed from: d  reason: collision with root package name */
    public String f13020d;

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
        this.f13018b = intent.getStringExtra("recom_source");
        this.f13019c = intent.getStringExtra("recom_abtag");
        this.f13020d = intent.getStringExtra(TiebaStatic.Params.RECOM_EXTRA);
    }

    public void b(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d2Var) == null) || d2Var == null) {
            return;
        }
        this.a = d2Var.a1;
        this.f13018b = d2Var.Z0;
        this.f13019c = d2Var.b1;
        this.f13020d = d2Var.c1;
    }

    public void c(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, intent) == null) || intent == null) {
            return;
        }
        intent.putExtra(TiebaStatic.Params.RECOM_WEIGHT, this.a);
        intent.putExtra("recom_source", this.f13018b);
        intent.putExtra("recom_abtag", this.f13019c);
        intent.putExtra(TiebaStatic.Params.RECOM_EXTRA, this.f13020d);
    }

    public void d(c.a.r0.x2.p pVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, pVar) == null) || pVar == null) {
            return;
        }
        pVar.f25430g = this.a;
        pVar.f25429f = this.f13018b;
        pVar.l = this.f13019c;
        pVar.o = this.f13020d;
    }
}

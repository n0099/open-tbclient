package c.a.q0.s.q;

import android.content.Intent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class n1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f14290a;

    /* renamed from: b  reason: collision with root package name */
    public String f14291b;

    /* renamed from: c  reason: collision with root package name */
    public String f14292c;

    /* renamed from: d  reason: collision with root package name */
    public String f14293d;

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
        this.f14290a = intent.getStringExtra(TiebaStatic.Params.RECOM_WEIGHT);
        this.f14291b = intent.getStringExtra("recom_source");
        this.f14292c = intent.getStringExtra("recom_abtag");
        this.f14293d = intent.getStringExtra(TiebaStatic.Params.RECOM_EXTRA);
    }

    public void b(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d2Var) == null) || d2Var == null) {
            return;
        }
        this.f14290a = d2Var.Y0;
        this.f14291b = d2Var.X0;
        this.f14292c = d2Var.Z0;
        this.f14293d = d2Var.a1;
    }

    public void c(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, intent) == null) || intent == null) {
            return;
        }
        intent.putExtra(TiebaStatic.Params.RECOM_WEIGHT, this.f14290a);
        intent.putExtra("recom_source", this.f14291b);
        intent.putExtra("recom_abtag", this.f14292c);
        intent.putExtra(TiebaStatic.Params.RECOM_EXTRA, this.f14293d);
    }

    public void d(c.a.r0.q2.o oVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, oVar) == null) || oVar == null) {
            return;
        }
        oVar.f24003g = this.f14290a;
        oVar.f24002f = this.f14291b;
        oVar.l = this.f14292c;
        oVar.o = this.f14293d;
    }
}

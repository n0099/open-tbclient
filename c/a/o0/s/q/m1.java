package c.a.o0.s.q;

import android.content.Intent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class m1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f13993a;

    /* renamed from: b  reason: collision with root package name */
    public String f13994b;

    /* renamed from: c  reason: collision with root package name */
    public String f13995c;

    /* renamed from: d  reason: collision with root package name */
    public String f13996d;

    public m1() {
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
        this.f13993a = intent.getStringExtra(TiebaStatic.Params.RECOM_WEIGHT);
        this.f13994b = intent.getStringExtra("recom_source");
        this.f13995c = intent.getStringExtra("recom_abtag");
        this.f13996d = intent.getStringExtra(TiebaStatic.Params.RECOM_EXTRA);
    }

    public void b(c2 c2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c2Var) == null) || c2Var == null) {
            return;
        }
        this.f13993a = c2Var.V0;
        this.f13994b = c2Var.U0;
        this.f13995c = c2Var.W0;
        this.f13996d = c2Var.X0;
    }

    public void c(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, intent) == null) || intent == null) {
            return;
        }
        intent.putExtra(TiebaStatic.Params.RECOM_WEIGHT, this.f13993a);
        intent.putExtra("recom_source", this.f13994b);
        intent.putExtra("recom_abtag", this.f13995c);
        intent.putExtra(TiebaStatic.Params.RECOM_EXTRA, this.f13996d);
    }

    public void d(c.a.p0.o2.o oVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, oVar) == null) || oVar == null) {
            return;
        }
        oVar.f22890g = this.f13993a;
        oVar.f22889f = this.f13994b;
        oVar.l = this.f13995c;
        oVar.o = this.f13996d;
    }
}

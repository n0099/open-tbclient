package c.q.a;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.PBError;
/* loaded from: classes9.dex */
public class j5 implements s {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ d1 a;

    public j5(d1 d1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {d1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = d1Var;
    }

    @Override // com.win.opensdk.PBListener
    public void onClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.k = true;
            e1 e1Var = this.a.f30538e;
            if (e1Var != null) {
                e1Var.onClicked();
            }
        }
    }

    @Override // c.q.a.s
    public void onDisplayed() {
        e1 e1Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (e1Var = this.a.f30538e) == null) {
            return;
        }
        e1Var.onDisplayed();
    }

    @Override // com.win.opensdk.PBListener
    public void onFail(PBError pBError) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pBError) == null) {
            if (pBError == PBError.PID_INVALID) {
                e1 e1Var = this.a.f30538e;
                if (e1Var != null) {
                    e1Var.onFail(PBError.NO_FILL);
                    return;
                }
                return;
            }
            d1 d1Var = this.a;
            e1 e1Var2 = d1Var.f30538e;
            if (e1Var2 == null || d1Var.f30543j) {
                return;
            }
            e1Var2.onFail(PBError.NO_FILL);
        }
    }

    @Override // com.win.opensdk.PBListener
    public void onLoaded() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.a.f30535b.d()) {
            d1 d1Var = this.a;
            Context context = d1Var.a;
            u uVar = d1Var.f30535b.a;
            m2.s(context, (uVar == null || !uVar.f()) ? 0L : uVar.f30703c.getLo_timeout());
            String str = "";
            if (this.a.f30535b.c().equals("image")) {
                u uVar2 = this.a.f30535b.a;
                if (uVar2 != null && uVar2.f()) {
                    str = uVar2.f30703c.getLoad();
                }
                this.a.f(str);
            } else if (this.a.f30535b.c().equals("gif")) {
                u uVar3 = this.a.f30535b.a;
                if (uVar3 != null && uVar3.f()) {
                    str = uVar3.f30703c.getLoad();
                }
                this.a.c(str);
            } else {
                e1 e1Var = this.a.f30538e;
                if (e1Var != null) {
                    e1Var.onFail(PBError.LOAD_TYPE_ERROR);
                }
            }
        }
    }
}

package b.q.a;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.PBError;
/* loaded from: classes6.dex */
public class j5 implements s {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d1 f33367a;

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
        this.f33367a = d1Var;
    }

    @Override // com.win.opensdk.PBListener
    public void onClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f33367a.k = true;
            e1 e1Var = this.f33367a.f33284e;
            if (e1Var != null) {
                e1Var.onClicked();
            }
        }
    }

    @Override // b.q.a.s
    public void onDisplayed() {
        e1 e1Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (e1Var = this.f33367a.f33284e) == null) {
            return;
        }
        e1Var.onDisplayed();
    }

    @Override // com.win.opensdk.PBListener
    public void onFail(PBError pBError) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pBError) == null) {
            if (pBError == PBError.PID_INVALID) {
                e1 e1Var = this.f33367a.f33284e;
                if (e1Var != null) {
                    e1Var.onFail(PBError.NO_FILL);
                    return;
                }
                return;
            }
            d1 d1Var = this.f33367a;
            e1 e1Var2 = d1Var.f33284e;
            if (e1Var2 == null || d1Var.j) {
                return;
            }
            e1Var2.onFail(PBError.NO_FILL);
        }
    }

    @Override // com.win.opensdk.PBListener
    public void onLoaded() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.f33367a.f33281b.d()) {
            d1 d1Var = this.f33367a;
            Context context = d1Var.f33280a;
            u uVar = d1Var.f33281b.f33419a;
            m2.s(context, (uVar == null || !uVar.f()) ? 0L : uVar.f33504c.getLo_timeout());
            String str = "";
            if (this.f33367a.f33281b.c().equals("image")) {
                u uVar2 = this.f33367a.f33281b.f33419a;
                if (uVar2 != null && uVar2.f()) {
                    str = uVar2.f33504c.getLoad();
                }
                this.f33367a.f(str);
            } else if (this.f33367a.f33281b.c().equals("gif")) {
                u uVar3 = this.f33367a.f33281b.f33419a;
                if (uVar3 != null && uVar3.f()) {
                    str = uVar3.f33504c.getLoad();
                }
                this.f33367a.c(str);
            } else {
                e1 e1Var = this.f33367a.f33284e;
                if (e1Var != null) {
                    e1Var.onFail(PBError.LOAD_TYPE_ERROR);
                }
            }
        }
    }
}

package c.q.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.PBError;
/* loaded from: classes9.dex */
public class g implements g1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ f1 a;

    public g(f1 f1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {f1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = f1Var;
    }

    @Override // c.q.a.g1
    public void c(boolean z, long j2) {
        g1 g1Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j2)}) == null) || (g1Var = this.a.f30317b) == null) {
            return;
        }
        g1Var.c(z, j2);
    }

    @Override // c.q.a.g1
    public void d(String str) {
        g1 g1Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || (g1Var = this.a.f30317b) == null) {
            return;
        }
        g1Var.d(str);
    }

    @Override // c.q.a.g1
    public void f() {
        g1 g1Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (g1Var = this.a.f30317b) == null) {
            return;
        }
        g1Var.f();
    }

    @Override // c.q.a.g1
    public void g() {
        g1 g1Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (g1Var = this.a.f30317b) == null) {
            return;
        }
        g1Var.g();
    }

    @Override // com.win.opensdk.PBListener
    public void onClicked() {
        g1 g1Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (g1Var = this.a.f30317b) == null) {
            return;
        }
        g1Var.onClicked();
    }

    @Override // com.win.opensdk.PBListener
    public void onFail(PBError pBError) {
        g1 g1Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, pBError) == null) || (g1Var = this.a.f30317b) == null) {
            return;
        }
        g1Var.onFail(pBError);
    }

    @Override // com.win.opensdk.PBListener
    public void onLoaded() {
        g1 g1Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (g1Var = this.a.f30317b) == null) {
            return;
        }
        g1Var.onLoaded();
    }
}

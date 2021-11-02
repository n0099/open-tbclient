package b.q.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.PBError;
/* loaded from: classes6.dex */
public class a3 implements i3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e3 f33236a;

    public a3(e3 e3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {e3Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33236a = e3Var;
    }

    @Override // b.q.a.i3
    public void a(boolean z) {
        i3 i3Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (i3Var = this.f33236a.f33298b) == null) {
            return;
        }
        i3Var.a(z);
    }

    @Override // com.win.opensdk.PBListener
    public void onClicked() {
        i3 i3Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (i3Var = this.f33236a.f33298b) == null) {
            return;
        }
        i3Var.onClicked();
    }

    @Override // b.q.a.i3
    public void onDisplayed() {
        i3 i3Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (i3Var = this.f33236a.f33298b) == null) {
            return;
        }
        i3Var.onDisplayed();
    }

    @Override // com.win.opensdk.PBListener
    public void onFail(PBError pBError) {
        i3 i3Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, pBError) == null) || (i3Var = this.f33236a.f33298b) == null) {
            return;
        }
        i3Var.onFail(pBError);
    }

    @Override // com.win.opensdk.PBListener
    public void onLoaded() {
        i3 i3Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (i3Var = this.f33236a.f33298b) == null) {
            return;
        }
        i3Var.onLoaded();
    }
}

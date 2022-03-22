package c.a.p0.s4.m;

import android.content.Context;
import c.a.o0.w.m;
import c.a.o0.w.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.write.editor.EditorInfoContainer;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class b extends m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context, String str) {
        super(context, (String) null, 15);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = false;
        this.r = context;
        this.l = 3;
        this.k = new EditorInfoContainer(context, str);
        this.n = new int[]{9, 20, 19, 12, 13, 10, 11, 46, 49, 54, 57};
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            n nVar = this.k;
            if (nVar instanceof EditorInfoContainer) {
                ((EditorInfoContainer) nVar).hide();
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            n nVar = this.k;
            if (nVar instanceof EditorInfoContainer) {
                ((EditorInfoContainer) nVar).j();
            }
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            n nVar = this.k;
            if (nVar instanceof EditorInfoContainer) {
                ((EditorInfoContainer) nVar).k();
            }
        }
    }

    public void i(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, str, i) == null) {
            n nVar = this.k;
            if (nVar instanceof EditorInfoContainer) {
                ((EditorInfoContainer) nVar).o(str, i);
            }
        }
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            n nVar = this.k;
            if (nVar instanceof EditorInfoContainer) {
                ((EditorInfoContainer) nVar).p(i);
            }
        }
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            n nVar = this.k;
            if (nVar instanceof EditorInfoContainer) {
                ((EditorInfoContainer) nVar).q(z);
            }
        }
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            n nVar = this.k;
            if (nVar instanceof EditorInfoContainer) {
                ((EditorInfoContainer) nVar).setFrom(str);
            }
        }
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            n nVar = this.k;
            if (nVar instanceof EditorInfoContainer) {
                ((EditorInfoContainer) nVar).s(z);
            }
        }
    }
}

package c.a.u0.u2.u.f;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class w0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.u0.s4.m a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.u0.s4.m f23881b;

    /* renamed from: c  reason: collision with root package name */
    public EditText f23882c;

    /* renamed from: d  reason: collision with root package name */
    public EditText f23883d;

    /* renamed from: e  reason: collision with root package name */
    public PostWriteCallBackData f23884e;

    public w0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        c.a.u0.s4.m mVar = new c.a.u0.s4.m();
        this.a = mVar;
        mVar.j(c.a.u0.a4.d.CAM_X0101);
        this.a.h(c.a.u0.a4.d.cp_cont_h_alpha85);
        c.a.u0.s4.m mVar2 = new c.a.u0.s4.m();
        this.f23881b = mVar2;
        mVar2.j(c.a.u0.a4.d.CAM_X0101);
        this.f23881b.h(c.a.u0.a4.d.cp_cont_h_alpha85);
    }

    public void a(boolean z) {
        EditText editText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (editText = this.f23882c) == null || editText.getText() == null) {
            return;
        }
        int selectionEnd = this.f23882c.getSelectionEnd();
        SpannableStringBuilder f2 = this.a.f(this.f23882c.getText());
        if (f2 != null) {
            this.a.l(true);
            this.f23882c.setText(f2);
            if (z && this.a.b() >= 0) {
                this.f23882c.requestFocus();
                this.f23882c.setSelection(this.a.b());
            } else {
                this.f23882c.setSelection(selectionEnd);
            }
            c.a.u0.s4.m mVar = this.a;
            mVar.k(mVar.b() >= 0);
        }
    }

    public void b(boolean z) {
        EditText editText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (editText = this.f23883d) == null || editText.getText() == null) {
            return;
        }
        int selectionEnd = this.f23883d.getSelectionEnd();
        SpannableStringBuilder f2 = this.f23881b.f(this.f23883d.getText());
        if (f2 != null) {
            this.f23881b.l(true);
            this.f23883d.setText(f2);
            if (z && this.f23881b.b() >= 0) {
                this.f23883d.requestFocus();
                this.f23883d.setSelection(this.f23881b.b());
            } else {
                this.f23883d.setSelection(selectionEnd);
            }
            c.a.u0.s4.m mVar = this.f23881b;
            mVar.k(mVar.b() >= 0);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.n(null);
            this.a.i(null);
            this.a.k(false);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f23881b.n(null);
            this.f23881b.i(null);
            this.f23881b.k(false);
        }
    }

    public c.a.u0.s4.m e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a : (c.a.u0.s4.m) invokeV.objValue;
    }

    public EditText f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f23883d : (EditText) invokeV.objValue;
    }

    public c.a.u0.s4.m g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f23881b : (c.a.u0.s4.m) invokeV.objValue;
    }

    public PostWriteCallBackData h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f23884e : (PostWriteCallBackData) invokeV.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.a.g();
            this.f23881b.g();
            if (this.a.d()) {
                a(false);
            }
            if (this.f23881b.d()) {
                b(false);
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f23882c = null;
            this.f23883d = null;
        }
    }

    public void k(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, postWriteCallBackData) == null) || postWriteCallBackData == null) {
            return;
        }
        this.a.i(postWriteCallBackData.getSensitiveWords());
        this.a.n(postWriteCallBackData.getErrorString());
        if (ListUtils.isEmpty(this.a.a())) {
            return;
        }
        a(true);
        this.f23884e = postWriteCallBackData;
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, postWriteCallBackData) == null) || postWriteCallBackData == null) {
            return;
        }
        this.f23881b.i(postWriteCallBackData.getSensitiveWords());
        this.f23881b.n(postWriteCallBackData.getErrorString());
        if (ListUtils.isEmpty(this.f23881b.a())) {
            return;
        }
        b(true);
    }

    public void m(EditText editText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, editText) == null) {
            this.f23882c = editText;
        }
    }

    public void n(EditText editText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, editText) == null) {
            this.f23883d = editText;
        }
    }
}

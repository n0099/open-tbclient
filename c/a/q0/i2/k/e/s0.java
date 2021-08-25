package c.a.q0.i2.k.e;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class s0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.q0.b4.c f19606a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.q0.b4.c f19607b;

    /* renamed from: c  reason: collision with root package name */
    public EditText f19608c;

    /* renamed from: d  reason: collision with root package name */
    public EditText f19609d;

    /* renamed from: e  reason: collision with root package name */
    public PostWriteCallBackData f19610e;

    public s0() {
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
        c.a.q0.b4.c cVar = new c.a.q0.b4.c();
        this.f19606a = cVar;
        cVar.j(R.color.CAM_X0101);
        this.f19606a.h(R.color.cp_cont_h_alpha85);
        c.a.q0.b4.c cVar2 = new c.a.q0.b4.c();
        this.f19607b = cVar2;
        cVar2.j(R.color.CAM_X0101);
        this.f19607b.h(R.color.cp_cont_h_alpha85);
    }

    public void a(boolean z) {
        EditText editText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (editText = this.f19608c) == null || editText.getText() == null) {
            return;
        }
        int selectionEnd = this.f19608c.getSelectionEnd();
        SpannableStringBuilder f2 = this.f19606a.f(this.f19608c.getText());
        if (f2 != null) {
            this.f19606a.l(true);
            this.f19608c.setText(f2);
            if (z && this.f19606a.b() >= 0) {
                this.f19608c.requestFocus();
                this.f19608c.setSelection(this.f19606a.b());
            } else {
                this.f19608c.setSelection(selectionEnd);
            }
            c.a.q0.b4.c cVar = this.f19606a;
            cVar.k(cVar.b() >= 0);
        }
    }

    public void b(boolean z) {
        EditText editText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (editText = this.f19609d) == null || editText.getText() == null) {
            return;
        }
        int selectionEnd = this.f19609d.getSelectionEnd();
        SpannableStringBuilder f2 = this.f19607b.f(this.f19609d.getText());
        if (f2 != null) {
            this.f19607b.l(true);
            this.f19609d.setText(f2);
            if (z && this.f19607b.b() >= 0) {
                this.f19609d.requestFocus();
                this.f19609d.setSelection(this.f19607b.b());
            } else {
                this.f19609d.setSelection(selectionEnd);
            }
            c.a.q0.b4.c cVar = this.f19607b;
            cVar.k(cVar.b() >= 0);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f19606a.n(null);
            this.f19606a.i(null);
            this.f19606a.k(false);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f19607b.n(null);
            this.f19607b.i(null);
            this.f19607b.k(false);
        }
    }

    public c.a.q0.b4.c e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f19606a : (c.a.q0.b4.c) invokeV.objValue;
    }

    public EditText f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f19609d : (EditText) invokeV.objValue;
    }

    public c.a.q0.b4.c g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f19607b : (c.a.q0.b4.c) invokeV.objValue;
    }

    public PostWriteCallBackData h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f19610e : (PostWriteCallBackData) invokeV.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f19606a.g();
            this.f19607b.g();
            if (this.f19606a.d()) {
                a(false);
            }
            if (this.f19607b.d()) {
                b(false);
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f19608c = null;
            this.f19609d = null;
        }
    }

    public void k(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, postWriteCallBackData) == null) || postWriteCallBackData == null) {
            return;
        }
        this.f19606a.i(postWriteCallBackData.getSensitiveWords());
        this.f19606a.n(postWriteCallBackData.getErrorString());
        if (ListUtils.isEmpty(this.f19606a.a())) {
            return;
        }
        a(true);
        this.f19610e = postWriteCallBackData;
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, postWriteCallBackData) == null) || postWriteCallBackData == null) {
            return;
        }
        this.f19607b.i(postWriteCallBackData.getSensitiveWords());
        this.f19607b.n(postWriteCallBackData.getErrorString());
        if (ListUtils.isEmpty(this.f19607b.a())) {
            return;
        }
        b(true);
    }

    public void m(EditText editText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, editText) == null) {
            this.f19608c = editText;
        }
    }

    public void n(EditText editText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, editText) == null) {
            this.f19609d = editText;
        }
    }
}

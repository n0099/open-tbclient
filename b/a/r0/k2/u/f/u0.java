package b.a.r0.k2.u.f;

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
/* loaded from: classes5.dex */
public class u0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b.a.r0.d4.c f19495a;

    /* renamed from: b  reason: collision with root package name */
    public b.a.r0.d4.c f19496b;

    /* renamed from: c  reason: collision with root package name */
    public EditText f19497c;

    /* renamed from: d  reason: collision with root package name */
    public EditText f19498d;

    /* renamed from: e  reason: collision with root package name */
    public PostWriteCallBackData f19499e;

    public u0() {
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
        b.a.r0.d4.c cVar = new b.a.r0.d4.c();
        this.f19495a = cVar;
        cVar.j(R.color.CAM_X0101);
        this.f19495a.h(R.color.cp_cont_h_alpha85);
        b.a.r0.d4.c cVar2 = new b.a.r0.d4.c();
        this.f19496b = cVar2;
        cVar2.j(R.color.CAM_X0101);
        this.f19496b.h(R.color.cp_cont_h_alpha85);
    }

    public void a(boolean z) {
        EditText editText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (editText = this.f19497c) == null || editText.getText() == null) {
            return;
        }
        int selectionEnd = this.f19497c.getSelectionEnd();
        SpannableStringBuilder f2 = this.f19495a.f(this.f19497c.getText());
        if (f2 != null) {
            this.f19495a.l(true);
            this.f19497c.setText(f2);
            if (z && this.f19495a.b() >= 0) {
                this.f19497c.requestFocus();
                this.f19497c.setSelection(this.f19495a.b());
            } else {
                this.f19497c.setSelection(selectionEnd);
            }
            b.a.r0.d4.c cVar = this.f19495a;
            cVar.k(cVar.b() >= 0);
        }
    }

    public void b(boolean z) {
        EditText editText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (editText = this.f19498d) == null || editText.getText() == null) {
            return;
        }
        int selectionEnd = this.f19498d.getSelectionEnd();
        SpannableStringBuilder f2 = this.f19496b.f(this.f19498d.getText());
        if (f2 != null) {
            this.f19496b.l(true);
            this.f19498d.setText(f2);
            if (z && this.f19496b.b() >= 0) {
                this.f19498d.requestFocus();
                this.f19498d.setSelection(this.f19496b.b());
            } else {
                this.f19498d.setSelection(selectionEnd);
            }
            b.a.r0.d4.c cVar = this.f19496b;
            cVar.k(cVar.b() >= 0);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f19495a.n(null);
            this.f19495a.i(null);
            this.f19495a.k(false);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f19496b.n(null);
            this.f19496b.i(null);
            this.f19496b.k(false);
        }
    }

    public b.a.r0.d4.c e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f19495a : (b.a.r0.d4.c) invokeV.objValue;
    }

    public EditText f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f19498d : (EditText) invokeV.objValue;
    }

    public b.a.r0.d4.c g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f19496b : (b.a.r0.d4.c) invokeV.objValue;
    }

    public PostWriteCallBackData h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f19499e : (PostWriteCallBackData) invokeV.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f19495a.g();
            this.f19496b.g();
            if (this.f19495a.d()) {
                a(false);
            }
            if (this.f19496b.d()) {
                b(false);
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f19497c = null;
            this.f19498d = null;
        }
    }

    public void k(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, postWriteCallBackData) == null) || postWriteCallBackData == null) {
            return;
        }
        this.f19495a.i(postWriteCallBackData.getSensitiveWords());
        this.f19495a.n(postWriteCallBackData.getErrorString());
        if (ListUtils.isEmpty(this.f19495a.a())) {
            return;
        }
        a(true);
        this.f19499e = postWriteCallBackData;
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, postWriteCallBackData) == null) || postWriteCallBackData == null) {
            return;
        }
        this.f19496b.i(postWriteCallBackData.getSensitiveWords());
        this.f19496b.n(postWriteCallBackData.getErrorString());
        if (ListUtils.isEmpty(this.f19496b.a())) {
            return;
        }
        b(true);
    }

    public void m(EditText editText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, editText) == null) {
            this.f19497c = editText;
        }
    }

    public void n(EditText editText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, editText) == null) {
            this.f19498d = editText;
        }
    }
}

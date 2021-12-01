package c.a.r0.q2.u.f;

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
/* loaded from: classes6.dex */
public class v0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.r0.l4.c a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.r0.l4.c f22220b;

    /* renamed from: c  reason: collision with root package name */
    public EditText f22221c;

    /* renamed from: d  reason: collision with root package name */
    public EditText f22222d;

    /* renamed from: e  reason: collision with root package name */
    public PostWriteCallBackData f22223e;

    public v0() {
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
        c.a.r0.l4.c cVar = new c.a.r0.l4.c();
        this.a = cVar;
        cVar.j(R.color.CAM_X0101);
        this.a.h(R.color.cp_cont_h_alpha85);
        c.a.r0.l4.c cVar2 = new c.a.r0.l4.c();
        this.f22220b = cVar2;
        cVar2.j(R.color.CAM_X0101);
        this.f22220b.h(R.color.cp_cont_h_alpha85);
    }

    public void a(boolean z) {
        EditText editText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (editText = this.f22221c) == null || editText.getText() == null) {
            return;
        }
        int selectionEnd = this.f22221c.getSelectionEnd();
        SpannableStringBuilder f2 = this.a.f(this.f22221c.getText());
        if (f2 != null) {
            this.a.l(true);
            this.f22221c.setText(f2);
            if (z && this.a.b() >= 0) {
                this.f22221c.requestFocus();
                this.f22221c.setSelection(this.a.b());
            } else {
                this.f22221c.setSelection(selectionEnd);
            }
            c.a.r0.l4.c cVar = this.a;
            cVar.k(cVar.b() >= 0);
        }
    }

    public void b(boolean z) {
        EditText editText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (editText = this.f22222d) == null || editText.getText() == null) {
            return;
        }
        int selectionEnd = this.f22222d.getSelectionEnd();
        SpannableStringBuilder f2 = this.f22220b.f(this.f22222d.getText());
        if (f2 != null) {
            this.f22220b.l(true);
            this.f22222d.setText(f2);
            if (z && this.f22220b.b() >= 0) {
                this.f22222d.requestFocus();
                this.f22222d.setSelection(this.f22220b.b());
            } else {
                this.f22222d.setSelection(selectionEnd);
            }
            c.a.r0.l4.c cVar = this.f22220b;
            cVar.k(cVar.b() >= 0);
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
            this.f22220b.n(null);
            this.f22220b.i(null);
            this.f22220b.k(false);
        }
    }

    public c.a.r0.l4.c e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a : (c.a.r0.l4.c) invokeV.objValue;
    }

    public EditText f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f22222d : (EditText) invokeV.objValue;
    }

    public c.a.r0.l4.c g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f22220b : (c.a.r0.l4.c) invokeV.objValue;
    }

    public PostWriteCallBackData h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f22223e : (PostWriteCallBackData) invokeV.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.a.g();
            this.f22220b.g();
            if (this.a.d()) {
                a(false);
            }
            if (this.f22220b.d()) {
                b(false);
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f22221c = null;
            this.f22222d = null;
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
        this.f22223e = postWriteCallBackData;
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, postWriteCallBackData) == null) || postWriteCallBackData == null) {
            return;
        }
        this.f22220b.i(postWriteCallBackData.getSensitiveWords());
        this.f22220b.n(postWriteCallBackData.getErrorString());
        if (ListUtils.isEmpty(this.f22220b.a())) {
            return;
        }
        b(true);
    }

    public void m(EditText editText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, editText) == null) {
            this.f22221c = editText;
        }
    }

    public void n(EditText editText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, editText) == null) {
            this.f22222d = editText;
        }
    }
}

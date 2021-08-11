package c.a.p0.i2.k.e;

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
public class u0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.p0.b4.c f19424a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.p0.b4.c f19425b;

    /* renamed from: c  reason: collision with root package name */
    public EditText f19426c;

    /* renamed from: d  reason: collision with root package name */
    public EditText f19427d;

    /* renamed from: e  reason: collision with root package name */
    public PostWriteCallBackData f19428e;

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
        c.a.p0.b4.c cVar = new c.a.p0.b4.c();
        this.f19424a = cVar;
        cVar.j(R.color.CAM_X0101);
        this.f19424a.h(R.color.cp_cont_h_alpha85);
        c.a.p0.b4.c cVar2 = new c.a.p0.b4.c();
        this.f19425b = cVar2;
        cVar2.j(R.color.CAM_X0101);
        this.f19425b.h(R.color.cp_cont_h_alpha85);
    }

    public void a(boolean z) {
        EditText editText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (editText = this.f19426c) == null || editText.getText() == null) {
            return;
        }
        int selectionEnd = this.f19426c.getSelectionEnd();
        SpannableStringBuilder f2 = this.f19424a.f(this.f19426c.getText());
        if (f2 != null) {
            this.f19424a.l(true);
            this.f19426c.setText(f2);
            if (z && this.f19424a.b() >= 0) {
                this.f19426c.requestFocus();
                this.f19426c.setSelection(this.f19424a.b());
            } else {
                this.f19426c.setSelection(selectionEnd);
            }
            c.a.p0.b4.c cVar = this.f19424a;
            cVar.k(cVar.b() >= 0);
        }
    }

    public void b(boolean z) {
        EditText editText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (editText = this.f19427d) == null || editText.getText() == null) {
            return;
        }
        int selectionEnd = this.f19427d.getSelectionEnd();
        SpannableStringBuilder f2 = this.f19425b.f(this.f19427d.getText());
        if (f2 != null) {
            this.f19425b.l(true);
            this.f19427d.setText(f2);
            if (z && this.f19425b.b() >= 0) {
                this.f19427d.requestFocus();
                this.f19427d.setSelection(this.f19425b.b());
            } else {
                this.f19427d.setSelection(selectionEnd);
            }
            c.a.p0.b4.c cVar = this.f19425b;
            cVar.k(cVar.b() >= 0);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f19424a.n(null);
            this.f19424a.i(null);
            this.f19424a.k(false);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f19425b.n(null);
            this.f19425b.i(null);
            this.f19425b.k(false);
        }
    }

    public c.a.p0.b4.c e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f19424a : (c.a.p0.b4.c) invokeV.objValue;
    }

    public EditText f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f19427d : (EditText) invokeV.objValue;
    }

    public c.a.p0.b4.c g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f19425b : (c.a.p0.b4.c) invokeV.objValue;
    }

    public PostWriteCallBackData h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f19428e : (PostWriteCallBackData) invokeV.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f19424a.g();
            this.f19425b.g();
            if (this.f19424a.d()) {
                a(false);
            }
            if (this.f19425b.d()) {
                b(false);
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f19426c = null;
            this.f19427d = null;
        }
    }

    public void k(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, postWriteCallBackData) == null) || postWriteCallBackData == null) {
            return;
        }
        this.f19424a.i(postWriteCallBackData.getSensitiveWords());
        this.f19424a.n(postWriteCallBackData.getErrorString());
        if (ListUtils.isEmpty(this.f19424a.a())) {
            return;
        }
        a(true);
        this.f19428e = postWriteCallBackData;
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, postWriteCallBackData) == null) || postWriteCallBackData == null) {
            return;
        }
        this.f19425b.i(postWriteCallBackData.getSensitiveWords());
        this.f19425b.n(postWriteCallBackData.getErrorString());
        if (ListUtils.isEmpty(this.f19425b.a())) {
            return;
        }
        b(true);
    }

    public void m(EditText editText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, editText) == null) {
            this.f19426c = editText;
        }
    }

    public void n(EditText editText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, editText) == null) {
            this.f19427d = editText;
        }
    }
}

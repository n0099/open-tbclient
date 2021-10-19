package c.a.r0.k2.k.e;

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
    public c.a.r0.d4.c f20507a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.r0.d4.c f20508b;

    /* renamed from: c  reason: collision with root package name */
    public EditText f20509c;

    /* renamed from: d  reason: collision with root package name */
    public EditText f20510d;

    /* renamed from: e  reason: collision with root package name */
    public PostWriteCallBackData f20511e;

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
        c.a.r0.d4.c cVar = new c.a.r0.d4.c();
        this.f20507a = cVar;
        cVar.j(R.color.CAM_X0101);
        this.f20507a.h(R.color.cp_cont_h_alpha85);
        c.a.r0.d4.c cVar2 = new c.a.r0.d4.c();
        this.f20508b = cVar2;
        cVar2.j(R.color.CAM_X0101);
        this.f20508b.h(R.color.cp_cont_h_alpha85);
    }

    public void a(boolean z) {
        EditText editText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (editText = this.f20509c) == null || editText.getText() == null) {
            return;
        }
        int selectionEnd = this.f20509c.getSelectionEnd();
        SpannableStringBuilder f2 = this.f20507a.f(this.f20509c.getText());
        if (f2 != null) {
            this.f20507a.l(true);
            this.f20509c.setText(f2);
            if (z && this.f20507a.b() >= 0) {
                this.f20509c.requestFocus();
                this.f20509c.setSelection(this.f20507a.b());
            } else {
                this.f20509c.setSelection(selectionEnd);
            }
            c.a.r0.d4.c cVar = this.f20507a;
            cVar.k(cVar.b() >= 0);
        }
    }

    public void b(boolean z) {
        EditText editText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (editText = this.f20510d) == null || editText.getText() == null) {
            return;
        }
        int selectionEnd = this.f20510d.getSelectionEnd();
        SpannableStringBuilder f2 = this.f20508b.f(this.f20510d.getText());
        if (f2 != null) {
            this.f20508b.l(true);
            this.f20510d.setText(f2);
            if (z && this.f20508b.b() >= 0) {
                this.f20510d.requestFocus();
                this.f20510d.setSelection(this.f20508b.b());
            } else {
                this.f20510d.setSelection(selectionEnd);
            }
            c.a.r0.d4.c cVar = this.f20508b;
            cVar.k(cVar.b() >= 0);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f20507a.n(null);
            this.f20507a.i(null);
            this.f20507a.k(false);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f20508b.n(null);
            this.f20508b.i(null);
            this.f20508b.k(false);
        }
    }

    public c.a.r0.d4.c e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f20507a : (c.a.r0.d4.c) invokeV.objValue;
    }

    public EditText f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f20510d : (EditText) invokeV.objValue;
    }

    public c.a.r0.d4.c g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f20508b : (c.a.r0.d4.c) invokeV.objValue;
    }

    public PostWriteCallBackData h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f20511e : (PostWriteCallBackData) invokeV.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f20507a.g();
            this.f20508b.g();
            if (this.f20507a.d()) {
                a(false);
            }
            if (this.f20508b.d()) {
                b(false);
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f20509c = null;
            this.f20510d = null;
        }
    }

    public void k(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, postWriteCallBackData) == null) || postWriteCallBackData == null) {
            return;
        }
        this.f20507a.i(postWriteCallBackData.getSensitiveWords());
        this.f20507a.n(postWriteCallBackData.getErrorString());
        if (ListUtils.isEmpty(this.f20507a.a())) {
            return;
        }
        a(true);
        this.f20511e = postWriteCallBackData;
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, postWriteCallBackData) == null) || postWriteCallBackData == null) {
            return;
        }
        this.f20508b.i(postWriteCallBackData.getSensitiveWords());
        this.f20508b.n(postWriteCallBackData.getErrorString());
        if (ListUtils.isEmpty(this.f20508b.a())) {
            return;
        }
        b(true);
    }

    public void m(EditText editText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, editText) == null) {
            this.f20509c = editText;
        }
    }

    public void n(EditText editText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, editText) == null) {
            this.f20510d = editText;
        }
    }
}

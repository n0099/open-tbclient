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
public class v0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b.a.r0.e4.c f21067a;

    /* renamed from: b  reason: collision with root package name */
    public b.a.r0.e4.c f21068b;

    /* renamed from: c  reason: collision with root package name */
    public EditText f21069c;

    /* renamed from: d  reason: collision with root package name */
    public EditText f21070d;

    /* renamed from: e  reason: collision with root package name */
    public PostWriteCallBackData f21071e;

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
        b.a.r0.e4.c cVar = new b.a.r0.e4.c();
        this.f21067a = cVar;
        cVar.j(R.color.CAM_X0101);
        this.f21067a.h(R.color.cp_cont_h_alpha85);
        b.a.r0.e4.c cVar2 = new b.a.r0.e4.c();
        this.f21068b = cVar2;
        cVar2.j(R.color.CAM_X0101);
        this.f21068b.h(R.color.cp_cont_h_alpha85);
    }

    public void a(boolean z) {
        EditText editText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (editText = this.f21069c) == null || editText.getText() == null) {
            return;
        }
        int selectionEnd = this.f21069c.getSelectionEnd();
        SpannableStringBuilder f2 = this.f21067a.f(this.f21069c.getText());
        if (f2 != null) {
            this.f21067a.l(true);
            this.f21069c.setText(f2);
            if (z && this.f21067a.b() >= 0) {
                this.f21069c.requestFocus();
                this.f21069c.setSelection(this.f21067a.b());
            } else {
                this.f21069c.setSelection(selectionEnd);
            }
            b.a.r0.e4.c cVar = this.f21067a;
            cVar.k(cVar.b() >= 0);
        }
    }

    public void b(boolean z) {
        EditText editText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (editText = this.f21070d) == null || editText.getText() == null) {
            return;
        }
        int selectionEnd = this.f21070d.getSelectionEnd();
        SpannableStringBuilder f2 = this.f21068b.f(this.f21070d.getText());
        if (f2 != null) {
            this.f21068b.l(true);
            this.f21070d.setText(f2);
            if (z && this.f21068b.b() >= 0) {
                this.f21070d.requestFocus();
                this.f21070d.setSelection(this.f21068b.b());
            } else {
                this.f21070d.setSelection(selectionEnd);
            }
            b.a.r0.e4.c cVar = this.f21068b;
            cVar.k(cVar.b() >= 0);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f21067a.n(null);
            this.f21067a.i(null);
            this.f21067a.k(false);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f21068b.n(null);
            this.f21068b.i(null);
            this.f21068b.k(false);
        }
    }

    public b.a.r0.e4.c e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f21067a : (b.a.r0.e4.c) invokeV.objValue;
    }

    public EditText f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f21070d : (EditText) invokeV.objValue;
    }

    public b.a.r0.e4.c g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f21068b : (b.a.r0.e4.c) invokeV.objValue;
    }

    public PostWriteCallBackData h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f21071e : (PostWriteCallBackData) invokeV.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f21067a.g();
            this.f21068b.g();
            if (this.f21067a.d()) {
                a(false);
            }
            if (this.f21068b.d()) {
                b(false);
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f21069c = null;
            this.f21070d = null;
        }
    }

    public void k(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, postWriteCallBackData) == null) || postWriteCallBackData == null) {
            return;
        }
        this.f21067a.i(postWriteCallBackData.getSensitiveWords());
        this.f21067a.n(postWriteCallBackData.getErrorString());
        if (ListUtils.isEmpty(this.f21067a.a())) {
            return;
        }
        a(true);
        this.f21071e = postWriteCallBackData;
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, postWriteCallBackData) == null) || postWriteCallBackData == null) {
            return;
        }
        this.f21068b.i(postWriteCallBackData.getSensitiveWords());
        this.f21068b.n(postWriteCallBackData.getErrorString());
        if (ListUtils.isEmpty(this.f21068b.a())) {
            return;
        }
        b(true);
    }

    public void m(EditText editText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, editText) == null) {
            this.f21069c = editText;
        }
    }

    public void n(EditText editText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, editText) == null) {
            this.f21070d = editText;
        }
    }
}

package c.a.p0.w2.m.f;

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
public class c1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.p0.s4.c a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.p0.s4.c f20030b;

    /* renamed from: c  reason: collision with root package name */
    public EditText f20031c;

    /* renamed from: d  reason: collision with root package name */
    public EditText f20032d;

    /* renamed from: e  reason: collision with root package name */
    public PostWriteCallBackData f20033e;

    public c1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        c.a.p0.s4.c cVar = new c.a.p0.s4.c();
        this.a = cVar;
        cVar.j(R.color.CAM_X0101);
        this.a.h(R.color.cp_cont_h_alpha85);
        c.a.p0.s4.c cVar2 = new c.a.p0.s4.c();
        this.f20030b = cVar2;
        cVar2.j(R.color.CAM_X0101);
        this.f20030b.h(R.color.cp_cont_h_alpha85);
    }

    public void a(boolean z) {
        EditText editText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (editText = this.f20031c) == null || editText.getText() == null) {
            return;
        }
        int selectionEnd = this.f20031c.getSelectionEnd();
        SpannableStringBuilder f2 = this.a.f(this.f20031c.getText());
        if (f2 != null) {
            this.a.l(true);
            this.f20031c.setText(f2);
            if (z && this.a.b() >= 0) {
                this.f20031c.requestFocus();
                this.f20031c.setSelection(this.a.b());
            } else {
                this.f20031c.setSelection(selectionEnd);
            }
            c.a.p0.s4.c cVar = this.a;
            cVar.k(cVar.b() >= 0);
        }
    }

    public void b(boolean z) {
        EditText editText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (editText = this.f20032d) == null || editText.getText() == null) {
            return;
        }
        int selectionEnd = this.f20032d.getSelectionEnd();
        SpannableStringBuilder f2 = this.f20030b.f(this.f20032d.getText());
        if (f2 != null) {
            this.f20030b.l(true);
            this.f20032d.setText(f2);
            if (z && this.f20030b.b() >= 0) {
                this.f20032d.requestFocus();
                this.f20032d.setSelection(this.f20030b.b());
            } else {
                this.f20032d.setSelection(selectionEnd);
            }
            c.a.p0.s4.c cVar = this.f20030b;
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
            this.f20030b.n(null);
            this.f20030b.i(null);
            this.f20030b.k(false);
        }
    }

    public c.a.p0.s4.c e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a : (c.a.p0.s4.c) invokeV.objValue;
    }

    public EditText f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f20032d : (EditText) invokeV.objValue;
    }

    public c.a.p0.s4.c g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f20030b : (c.a.p0.s4.c) invokeV.objValue;
    }

    public PostWriteCallBackData h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f20033e : (PostWriteCallBackData) invokeV.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.a.g();
            this.f20030b.g();
            if (this.a.d()) {
                a(false);
            }
            if (this.f20030b.d()) {
                b(false);
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f20031c = null;
            this.f20032d = null;
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
        this.f20033e = postWriteCallBackData;
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, postWriteCallBackData) == null) || postWriteCallBackData == null) {
            return;
        }
        this.f20030b.i(postWriteCallBackData.getSensitiveWords());
        this.f20030b.n(postWriteCallBackData.getErrorString());
        if (ListUtils.isEmpty(this.f20030b.a())) {
            return;
        }
        b(true);
    }

    public void m(EditText editText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, editText) == null) {
            this.f20031c = editText;
        }
    }

    public void n(EditText editText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, editText) == null) {
            this.f20032d = editText;
        }
    }
}

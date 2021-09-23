package c.a.r0.j2.k.e;

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
    public c.a.r0.c4.c f20330a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.r0.c4.c f20331b;

    /* renamed from: c  reason: collision with root package name */
    public EditText f20332c;

    /* renamed from: d  reason: collision with root package name */
    public EditText f20333d;

    /* renamed from: e  reason: collision with root package name */
    public PostWriteCallBackData f20334e;

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
        c.a.r0.c4.c cVar = new c.a.r0.c4.c();
        this.f20330a = cVar;
        cVar.j(R.color.CAM_X0101);
        this.f20330a.h(R.color.cp_cont_h_alpha85);
        c.a.r0.c4.c cVar2 = new c.a.r0.c4.c();
        this.f20331b = cVar2;
        cVar2.j(R.color.CAM_X0101);
        this.f20331b.h(R.color.cp_cont_h_alpha85);
    }

    public void a(boolean z) {
        EditText editText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (editText = this.f20332c) == null || editText.getText() == null) {
            return;
        }
        int selectionEnd = this.f20332c.getSelectionEnd();
        SpannableStringBuilder f2 = this.f20330a.f(this.f20332c.getText());
        if (f2 != null) {
            this.f20330a.l(true);
            this.f20332c.setText(f2);
            if (z && this.f20330a.b() >= 0) {
                this.f20332c.requestFocus();
                this.f20332c.setSelection(this.f20330a.b());
            } else {
                this.f20332c.setSelection(selectionEnd);
            }
            c.a.r0.c4.c cVar = this.f20330a;
            cVar.k(cVar.b() >= 0);
        }
    }

    public void b(boolean z) {
        EditText editText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (editText = this.f20333d) == null || editText.getText() == null) {
            return;
        }
        int selectionEnd = this.f20333d.getSelectionEnd();
        SpannableStringBuilder f2 = this.f20331b.f(this.f20333d.getText());
        if (f2 != null) {
            this.f20331b.l(true);
            this.f20333d.setText(f2);
            if (z && this.f20331b.b() >= 0) {
                this.f20333d.requestFocus();
                this.f20333d.setSelection(this.f20331b.b());
            } else {
                this.f20333d.setSelection(selectionEnd);
            }
            c.a.r0.c4.c cVar = this.f20331b;
            cVar.k(cVar.b() >= 0);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f20330a.n(null);
            this.f20330a.i(null);
            this.f20330a.k(false);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f20331b.n(null);
            this.f20331b.i(null);
            this.f20331b.k(false);
        }
    }

    public c.a.r0.c4.c e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f20330a : (c.a.r0.c4.c) invokeV.objValue;
    }

    public EditText f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f20333d : (EditText) invokeV.objValue;
    }

    public c.a.r0.c4.c g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f20331b : (c.a.r0.c4.c) invokeV.objValue;
    }

    public PostWriteCallBackData h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f20334e : (PostWriteCallBackData) invokeV.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f20330a.g();
            this.f20331b.g();
            if (this.f20330a.d()) {
                a(false);
            }
            if (this.f20331b.d()) {
                b(false);
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f20332c = null;
            this.f20333d = null;
        }
    }

    public void k(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, postWriteCallBackData) == null) || postWriteCallBackData == null) {
            return;
        }
        this.f20330a.i(postWriteCallBackData.getSensitiveWords());
        this.f20330a.n(postWriteCallBackData.getErrorString());
        if (ListUtils.isEmpty(this.f20330a.a())) {
            return;
        }
        a(true);
        this.f20334e = postWriteCallBackData;
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, postWriteCallBackData) == null) || postWriteCallBackData == null) {
            return;
        }
        this.f20331b.i(postWriteCallBackData.getSensitiveWords());
        this.f20331b.n(postWriteCallBackData.getErrorString());
        if (ListUtils.isEmpty(this.f20331b.a())) {
            return;
        }
        b(true);
    }

    public void m(EditText editText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, editText) == null) {
            this.f20332c = editText;
        }
    }

    public void n(EditText editText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, editText) == null) {
            this.f20333d = editText;
        }
    }
}

package c.a.t0.p4.e0;

import android.text.Editable;
import android.text.Spannable;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.widget.EditText;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupEditText;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupForegroundColorSpan;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<String> a;

    /* renamed from: b  reason: collision with root package name */
    public String f21108b;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public boolean a(EditText editText) {
        InterceptResult invokeL;
        Editable text;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, editText)) == null) {
            if (editText == null || (text = editText.getText()) == null) {
                return false;
            }
            int d2 = d(text);
            if (d2 > 0) {
                editText.requestFocus();
                editText.setSelection(d2);
                return true;
            }
            editText.setSelection(editText.getSelectionEnd());
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean b(EditText editText, EditText editText2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, editText, editText2)) == null) {
            if (ListUtils.isEmpty(c())) {
                return false;
            }
            return a(editText) || a(editText2);
        }
        return invokeLL.booleanValue;
    }

    public ArrayList<String> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : (ArrayList) invokeV.objValue;
    }

    public int d(Spanned spanned) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, spanned)) == null) {
            if (spanned == null) {
                return 0;
            }
            BackgroundColorSpan[] backgroundColorSpanArr = (BackgroundColorSpan[]) spanned.getSpans(0, spanned.length(), BackgroundColorSpan.class);
            int length = spanned.length();
            return (backgroundColorSpanArr == null || backgroundColorSpanArr.length <= 0) ? length : spanned.getSpanEnd(backgroundColorSpanArr[0]);
        }
        return invokeL.intValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f21108b : (String) invokeV.objValue;
    }

    public boolean f(Spannable spannable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, spannable)) == null) ? Pattern.compile("@[\\u4e00-\\u9fa5\\w\\ud83c\\udc00-\\ud83c\\udfff\\ud83d\\udc00-\\ud83d\\udfff\\u2600-\\u27ff]+").matcher(spannable).find() : invokeL.booleanValue;
    }

    public void g(EditText editText, boolean z) {
        Editable text;
        Object[] spans;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048582, this, editText, z) == null) || editText == null || (text = editText.getText()) == null) {
            return;
        }
        for (Object obj : text.getSpans(0, text.length(), Object.class)) {
            if (((obj instanceof ForegroundColorSpan) && !(obj instanceof SpanGroupForegroundColorSpan)) || (obj instanceof BackgroundColorSpan)) {
                text.removeSpan(obj);
            }
        }
        c.a.s0.u0.a.j(text);
        k(text);
    }

    public void h(SpanGroupEditText spanGroupEditText) {
        Editable text;
        Object[] spans;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, spanGroupEditText) == null) || spanGroupEditText == null || (text = spanGroupEditText.getText()) == null) {
            return;
        }
        for (Object obj : text.getSpans(0, text.length(), Object.class)) {
            if ((obj instanceof ForegroundColorSpan) || (obj instanceof BackgroundColorSpan)) {
                text.removeSpan(obj);
            }
        }
        c.a.s0.u0.a.k(spanGroupEditText);
    }

    public void i(EditText editText, EditText editText2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, editText, editText2) == null) {
            j(editText, true);
            j(editText2, false);
            b(editText, editText2);
        }
    }

    public void j(EditText editText, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048585, this, editText, z) == null) || editText == null) {
            return;
        }
        g(editText, z);
    }

    public final void k(Spannable spannable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, spannable) == null) || spannable == null || ListUtils.isEmpty(this.a)) {
            return;
        }
        String obj = spannable.toString();
        if (TextUtils.isEmpty(obj)) {
            return;
        }
        Iterator<String> it = this.a.iterator();
        while (it.hasNext()) {
            l(spannable, obj, it.next());
        }
    }

    public final void l(Spannable spannable, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048587, this, spannable, str, str2) == null) || spannable == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        int indexOf = str.indexOf(str2);
        int length = str2.length();
        while (indexOf >= 0) {
            int i2 = indexOf + length;
            int color = SkinManager.getColor(c.a.t0.p4.d.CAM_X0101);
            int color2 = SkinManager.getColor(c.a.t0.p4.d.cp_cont_h_alpha85);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(color);
            BackgroundColorSpan backgroundColorSpan = new BackgroundColorSpan(color2);
            spannable.setSpan(foregroundColorSpan, indexOf, i2, 33);
            spannable.setSpan(backgroundColorSpan, indexOf, i2, 33);
            indexOf = str.indexOf(str2, i2);
        }
    }

    public void m(EditText editText, EditText editText2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, editText, editText2) == null) {
            i(editText, editText2);
        }
    }

    public void n(ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, arrayList) == null) {
            this.a = arrayList;
        }
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.f21108b = str;
        }
    }
}

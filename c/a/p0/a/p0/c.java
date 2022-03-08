package c.a.p0.a.p0;

import android.widget.EditText;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.p2.n0;
import c.a.p0.a.s.c.f.a;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tieba.write.write.WriteImageActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static a.g f6801b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(826395216, "Lc/a/p0/a/p0/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(826395216, "Lc/a/p0/a/p0/c;");
                return;
            }
        }
        a = c.a.p0.a.a.a;
    }

    public static void a(a.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, gVar) == null) {
            f6801b = gVar;
        }
    }

    public static void b(EditText editText, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, editText, i2) == null) {
            e(editText, "blur", i2);
        }
    }

    public static void c(c.a.p0.a.s.c.f.b bVar, EditText editText, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(65539, null, bVar, editText, i2) == null) || editText == null || f6801b == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("value", editText.getText());
            jSONObject.put("eventName", WriteImageActivity.CHANGE_FLAG);
            jSONObject.put("cursorOffset", editText.getSelectionStart());
            jSONObject.put("keyCode", i2);
        } catch (JSONException e2) {
            if (a) {
                e2.printStackTrace();
            }
        }
        bVar.k(editText.getText().toString());
        bVar.m(editText.getSelectionStart(), editText.getSelectionEnd());
        f6801b.a(String.valueOf(editText.getTag()), jSONObject);
    }

    public static void d(EditText editText, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, editText, i2) == null) {
            e(editText, "confirm", i2);
        }
    }

    public static void e(EditText editText, String str, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(65541, null, editText, str, i2) == null) || editText == null || f6801b == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("value", editText.getText());
            jSONObject.put("eventName", str);
            jSONObject.put("cursorOffset", editText.getText().length());
            jSONObject.put("keyboardHeight", "" + n0.P(i2));
        } catch (JSONException e2) {
            if (a) {
                e2.printStackTrace();
            }
        }
        f6801b.a(String.valueOf(editText.getTag()), jSONObject);
    }

    public static void f(EditText editText, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65542, null, editText, i2) == null) {
            e(editText, AddFriendActivityConfig.TYPE_FOCUS, i2);
        }
    }
}

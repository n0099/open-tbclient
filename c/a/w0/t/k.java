package c.a.w0.t;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class k {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static Toast f30931a = null;

    /* renamed from: b  reason: collision with root package name */
    public static int f30932b = -1;

    /* renamed from: c  reason: collision with root package name */
    public static int f30933c = -1;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-492225477, "Lc/a/w0/t/k;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-492225477, "Lc/a/w0/t/k;");
        }
    }

    public static void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65537, null, i2) == null) {
            b(i2, 0);
        }
    }

    public static void b(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65538, null, i2, i3) == null) {
            c(c.a.w0.b.d().b().getResources().getString(i2), i3);
        }
    }

    public static void c(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65539, null, str, i2) == null) {
            d(str, i2, null);
        }
    }

    public static void d(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i2, str2) == null) {
            e(str, i2, str2, -1);
        }
    }

    public static void e(String str, int i2, String str2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{str, Integer.valueOf(i2), str2, Integer.valueOf(i3)}) == null) {
            if (f30932b != -1 && f30933c != -1) {
                Toast toast = f30931a;
                if (toast != null) {
                    toast.cancel();
                }
                Toast toast2 = new Toast(c.a.w0.b.d().b());
                f30931a = toast2;
                if (i3 > -1) {
                    toast2.setGravity(i3, 0, 0);
                }
                f30931a.setDuration(i2);
                try {
                    View inflate = LayoutInflater.from(c.a.w0.b.d().b()).inflate(f30932b, (ViewGroup) null);
                    TextView textView = (TextView) inflate.findViewById(f30933c);
                    if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str) && str.contains(str2)) {
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(c.a.w0.b.d().b().getResources().getColor(c.a.w0.o.a.app_theme_color)), str.indexOf(str2), str.indexOf(str2) + str2.length(), 33);
                        textView.setText(spannableStringBuilder);
                    } else {
                        textView.setText(str);
                    }
                    f30931a.setView(inflate);
                    f30931a.show();
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            Toast toast3 = f30931a;
            if (toast3 == null) {
                Toast makeText = Toast.makeText(c.a.w0.b.d().b(), str, i2);
                f30931a = makeText;
                if (i3 > -1) {
                    makeText.setGravity(i3, 0, 0);
                }
            } else {
                toast3.cancel();
                Toast makeText2 = Toast.makeText(c.a.w0.b.d().b(), str, i2);
                f30931a = makeText2;
                if (i3 > -1) {
                    makeText2.setGravity(i3, 0, 0);
                }
                f30931a.setDuration(i2);
            }
            try {
                f30931a.show();
            } catch (Exception unused) {
            }
        }
    }
}

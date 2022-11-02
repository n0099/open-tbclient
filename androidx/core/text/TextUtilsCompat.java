package androidx.core.text;

import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Locale;
/* loaded from: classes.dex */
public final class TextUtilsCompat {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ARAB_SCRIPT_SUBTAG = "Arab";
    public static final String HEBR_SCRIPT_SUBTAG = "Hebr";
    public static final Locale ROOT;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2124716353, "Landroidx/core/text/TextUtilsCompat;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2124716353, "Landroidx/core/text/TextUtilsCompat;");
                return;
            }
        }
        ROOT = new Locale("", "");
    }

    public TextUtilsCompat() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static int getLayoutDirectionFromFirstChar(@NonNull Locale locale) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, locale)) == null) {
            byte directionality = Character.getDirectionality(locale.getDisplayName(locale).charAt(0));
            if (directionality != 1 && directionality != 2) {
                return 0;
            }
            return 1;
        }
        return invokeL.intValue;
    }

    public static int getLayoutDirectionFromLocale(@Nullable Locale locale) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, locale)) == null) {
            if (Build.VERSION.SDK_INT >= 17) {
                return TextUtils.getLayoutDirectionFromLocale(locale);
            }
            if (locale != null && !locale.equals(ROOT)) {
                String maximizeAndGetScript = ICUCompat.maximizeAndGetScript(locale);
                if (maximizeAndGetScript == null) {
                    return getLayoutDirectionFromFirstChar(locale);
                }
                if (maximizeAndGetScript.equalsIgnoreCase(ARAB_SCRIPT_SUBTAG) || maximizeAndGetScript.equalsIgnoreCase(HEBR_SCRIPT_SUBTAG)) {
                    return 1;
                }
                return 0;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    @NonNull
    public static String htmlEncode(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (Build.VERSION.SDK_INT >= 17) {
                return TextUtils.htmlEncode(str);
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                char charAt = str.charAt(i);
                if (charAt != '\"') {
                    if (charAt != '<') {
                        if (charAt != '>') {
                            if (charAt != '&') {
                                if (charAt != '\'') {
                                    sb.append(charAt);
                                } else {
                                    sb.append("&#39;");
                                }
                            } else {
                                sb.append("&amp;");
                            }
                        } else {
                            sb.append("&gt;");
                        }
                    } else {
                        sb.append("&lt;");
                    }
                } else {
                    sb.append("&quot;");
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }
}

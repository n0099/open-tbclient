package androidx.core.text;

import android.icu.util.ULocale;
import android.os.Build;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;
/* loaded from: classes.dex */
public final class ICUCompat {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "ICUCompat";
    public static Method sAddLikelySubtagsMethod;
    public static Method sGetScriptMethod;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(487554890, "Landroidx/core/text/ICUCompat;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(487554890, "Landroidx/core/text/ICUCompat;");
                return;
            }
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            if (i2 < 24) {
                try {
                    sAddLikelySubtagsMethod = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", Locale.class);
                    return;
                } catch (Exception e2) {
                    throw new IllegalStateException(e2);
                }
            }
            return;
        }
        try {
            Class<?> cls = Class.forName("libcore.icu.ICU");
            if (cls != null) {
                sGetScriptMethod = cls.getMethod("getScript", String.class);
                sAddLikelySubtagsMethod = cls.getMethod("addLikelySubtags", String.class);
            }
        } catch (Exception e3) {
            sGetScriptMethod = null;
            sAddLikelySubtagsMethod = null;
            Log.w(TAG, e3);
        }
    }

    public ICUCompat() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String addLikelySubtags(Locale locale) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, locale)) == null) {
            String locale2 = locale.toString();
            try {
                if (sAddLikelySubtagsMethod != null) {
                    return (String) sAddLikelySubtagsMethod.invoke(null, locale2);
                }
            } catch (IllegalAccessException e2) {
                Log.w(TAG, e2);
            } catch (InvocationTargetException e3) {
                Log.w(TAG, e3);
            }
            return locale2;
        }
        return (String) invokeL.objValue;
    }

    public static String getScript(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            try {
                if (sGetScriptMethod != null) {
                    return (String) sGetScriptMethod.invoke(null, str);
                }
            } catch (IllegalAccessException e2) {
                Log.w(TAG, e2);
            } catch (InvocationTargetException e3) {
                Log.w(TAG, e3);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Nullable
    public static String maximizeAndGetScript(Locale locale) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, locale)) == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 24) {
                return ULocale.addLikelySubtags(ULocale.forLocale(locale)).getScript();
            }
            if (i2 >= 21) {
                try {
                    return ((Locale) sAddLikelySubtagsMethod.invoke(null, locale)).getScript();
                } catch (IllegalAccessException e2) {
                    Log.w(TAG, e2);
                    return locale.getScript();
                } catch (InvocationTargetException e3) {
                    Log.w(TAG, e3);
                    return locale.getScript();
                }
            }
            String addLikelySubtags = addLikelySubtags(locale);
            if (addLikelySubtags != null) {
                return getScript(addLikelySubtags);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }
}

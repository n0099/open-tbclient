package c.r.a.a.c.b;

import android.content.ContentResolver;
import android.content.Context;
import android.os.IBinder;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;
/* loaded from: classes4.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static String f35332a = "";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(431860100, "Lc/r/a/a/c/b/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(431860100, "Lc/r/a/a/c/b/a;");
        }
    }

    public static synchronized String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            synchronized (a.class) {
                if (TextUtils.isEmpty(f35332a)) {
                    String str = new String(Base64.decode("YW5kcm9pZF9pZA==", 0));
                    String c2 = c(context, str);
                    f35332a = c2;
                    if (TextUtils.isEmpty(c2)) {
                        String b2 = b(context, str);
                        f35332a = b2;
                        if (TextUtils.isEmpty(b2)) {
                            String string = Settings.Secure.getString(context.getContentResolver(), str);
                            f35332a = string;
                            return string;
                        }
                    }
                    return f35332a;
                }
                return f35332a;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            try {
                Method declaredMethod = Class.forName("android.os.UserHandle").getDeclaredMethod("getUserId", Integer.TYPE);
                declaredMethod.setAccessible(true);
                int intValue = ((Integer) declaredMethod.invoke(null, Integer.valueOf(Process.myUid()))).intValue();
                Method declaredMethod2 = Class.forName("android.provider.Settings$Secure").getDeclaredMethod("getStringForUser", ContentResolver.class, String.class, Integer.TYPE);
                declaredMethod2.setAccessible(true);
                return (String) declaredMethod2.invoke(null, context.getContentResolver(), str, Integer.valueOf(intValue));
            } catch (Throwable th) {
                c.c(th);
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    public static String c(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, str)) == null) {
            ContentResolver contentResolver = context.getContentResolver();
            try {
                Method declaredMethod = Class.forName("android.os.UserHandle").getDeclaredMethod("getUserId", Integer.TYPE);
                declaredMethod.setAccessible(true);
                int intValue = ((Integer) declaredMethod.invoke(null, Integer.valueOf(Process.myUid()))).intValue();
                HashSet hashSet = new HashSet();
                HashSet hashSet2 = new HashSet();
                HashSet hashSet3 = new HashSet();
                try {
                    Class<?> cls = Class.forName("android.provider.Settings$Global");
                    Field declaredField = cls.getDeclaredField("MOVED_TO_SECURE");
                    declaredField.setAccessible(true);
                    hashSet = (HashSet) declaredField.get(cls);
                } catch (Exception unused) {
                }
                try {
                    Class<?> cls2 = Class.forName("android.provider.Settings$Secure");
                    Field declaredField2 = cls2.getDeclaredField("MOVED_TO_LOCK_SETTINGS");
                    declaredField2.setAccessible(true);
                    hashSet2 = (HashSet) declaredField2.get(cls2);
                } catch (Exception unused2) {
                }
                try {
                    Class<?> cls3 = Class.forName("android.provider.Settings$Secure");
                    Field declaredField3 = cls3.getDeclaredField("MOVED_TO_GLOBAL");
                    declaredField3.setAccessible(true);
                    hashSet3 = (HashSet) declaredField3.get(cls3);
                } catch (Exception unused3) {
                }
                if (!hashSet.contains(str)) {
                    if (hashSet3.contains(str)) {
                        Method declaredMethod2 = Class.forName("android.provider.Global").getDeclaredMethod("getStringForUser", ContentResolver.class, String.class, Integer.TYPE);
                        declaredMethod2.setAccessible(true);
                        return (String) declaredMethod2.invoke(null, contentResolver, str, Integer.valueOf(intValue));
                    } else if (hashSet2.contains(str)) {
                        Method declaredMethod3 = Class.forName("android.os.ServiceManager").getDeclaredMethod("getService", new Class[0]);
                        declaredMethod3.setAccessible(true);
                        Method declaredMethod4 = Class.forName("com.android.internal.widget.ILockSettings$Stub").getDeclaredMethod("asInterface", IBinder.class);
                        declaredMethod4.setAccessible(true);
                        Object invoke = declaredMethod4.invoke(null, (IBinder) declaredMethod3.invoke(null, "lock_settings"));
                        boolean z = Process.myUid() == 1000;
                        if (hashSet2.contains(str) && invoke != null && !z) {
                            return (String) invoke.getClass().getDeclaredMethod("getString", String.class, String.class, Integer.TYPE).invoke(str, "0", Integer.valueOf(intValue));
                        }
                    }
                }
                Field declaredField4 = Class.forName("android.provider.Settings$Secure").getDeclaredField("sNameValueCache");
                declaredField4.setAccessible(true);
                Object obj = declaredField4.get(null);
                return (String) obj.getClass().getDeclaredMethod("getStringForUser", ContentResolver.class, String.class, Integer.TYPE).invoke(obj, contentResolver, str, Integer.valueOf(intValue));
            } catch (Throwable th) {
                c.c(th);
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }
}

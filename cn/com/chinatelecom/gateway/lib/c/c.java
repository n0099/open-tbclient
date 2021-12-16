package cn.com.chinatelecom.gateway.lib.c;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.MessageDigest;
import java.util.UUID;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "cn.com.chinatelecom.gateway.lib.c.c";

    /* renamed from: b  reason: collision with root package name */
    public static String f31474b = "";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1293515390, "Lcn/com/chinatelecom/gateway/lib/c/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1293515390, "Lcn/com/chinatelecom/gateway/lib/c/c;");
        }
    }

    public c() {
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

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            String uuid = UUID.randomUUID().toString();
            try {
                uuid = UUID.nameUUIDFromBytes((uuid + System.currentTimeMillis() + Math.random()).getBytes("utf8")).toString();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return !TextUtils.isEmpty(uuid) ? uuid.replace("-", "") : uuid;
        }
        return (String) invokeV.objValue;
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (TextUtils.isEmpty(f31474b)) {
                String b2 = b(context);
                f31474b = b2;
                if (TextUtils.isEmpty(b2)) {
                    String c2 = c(context);
                    f31474b = c2;
                    a(context, c2);
                }
            }
            return f31474b;
        }
        return (String) invokeL.objValue;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
            try {
                byte[] bytes = str.getBytes();
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(bytes);
                byte[] digest = messageDigest.digest();
                char[] cArr2 = new char[digest.length * 2];
                int i2 = 0;
                for (byte b2 : digest) {
                    int i3 = i2 + 1;
                    cArr2[i2] = cArr[(b2 >>> 4) & 15];
                    i2 = i3 + 1;
                    cArr2[i3] = cArr[b2 & 15];
                }
                return new String(cArr2);
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65541, null, context, str) == null) || TextUtils.isEmpty(str) || context == null) {
            return;
        }
        b.a(context, "key_d_i_u", str);
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) ? b.b(context, "key_d_i_u", "") : (String) invokeL.objValue;
    }

    public static String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            try {
                String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
                String lowerCase = !TextUtils.isEmpty(string) ? string.toLowerCase() : UUID.randomUUID().toString();
                return TextUtils.isEmpty(lowerCase) ? "default" : a(lowerCase + "default");
            }
        }
        return (String) invokeL.objValue;
    }
}

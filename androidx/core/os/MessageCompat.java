package androidx.core.os;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Message;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class MessageCompat {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean sTryIsAsynchronous = true;
    public static boolean sTrySetAsynchronous = true;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-560521401, "Landroidx/core/os/MessageCompat;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-560521401, "Landroidx/core/os/MessageCompat;");
        }
    }

    public MessageCompat() {
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

    @SuppressLint({"NewApi"})
    public static boolean isAsynchronous(@NonNull Message message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, message)) == null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 22) {
                return message.isAsynchronous();
            }
            if (sTryIsAsynchronous && i >= 16) {
                try {
                    return message.isAsynchronous();
                } catch (NoSuchMethodError unused) {
                    sTryIsAsynchronous = false;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @SuppressLint({"NewApi"})
    public static void setAsynchronous(@NonNull Message message, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65539, null, message, z) == null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 22) {
                message.setAsynchronous(z);
            } else if (!sTrySetAsynchronous || i < 16) {
            } else {
                try {
                    message.setAsynchronous(z);
                } catch (NoSuchMethodError unused) {
                    sTrySetAsynchronous = false;
                }
            }
        }
    }
}

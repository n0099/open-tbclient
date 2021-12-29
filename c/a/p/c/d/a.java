package c.a.p.c.d;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.net.update.CommandPostData;
import com.baidu.searchbox.net.update.v2.ActionData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONException;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Context context, String str, String str2, CommandPostData commandPostData) throws JSONException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65536, null, context, str, str2, commandPostData) == null) || commandPostData == null || commandPostData.getVersion() == null) {
            return;
        }
        commandPostData.getVersion().put(str2, e(context, str, str2));
    }

    public static boolean b(Context context, String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65537, null, context, str, str2, str3, str4)) == null) {
            if (str3 == null || str4 == null || TextUtils.equals(e(context, str, str2), str3)) {
                return false;
            }
            b.c(d("key_version", str, str2), str3);
            if (str4.isEmpty()) {
                return true;
            }
            b.c(d("key_data", str, str2), str4);
            return true;
        }
        return invokeLLLLL.booleanValue;
    }

    public static boolean c(Context context, String str, String str2, ActionData<String> actionData) {
        InterceptResult invokeLLLL;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, context, str, str2, actionData)) == null) {
            if (actionData == null || (str3 = actionData.data) == null) {
                return false;
            }
            return b(context, str, str2, actionData.version, str3);
        }
        return invokeLLLL.booleanValue;
    }

    public static String d(@NonNull String str, @NonNull String str2, @NonNull String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, str, str2, str3)) == null) {
            return str + "_" + str2 + "_" + str3;
        }
        return (String) invokeLLL.objValue;
    }

    public static String e(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str, str2)) == null) ? b.b(d("key_version", str, str2), "0") : (String) invokeLLL.objValue;
    }
}

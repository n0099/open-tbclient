package c.a.o0.s;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static NetworkInfo a(Context context) {
        InterceptResult invokeL;
        ConnectivityManager connectivityManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            Context appContext = AppRuntime.getAppContext();
            if (appContext == null || (connectivityManager = (ConnectivityManager) appContext.getSystemService("connectivity")) == null) {
                return null;
            }
            return connectivityManager.getActiveNetworkInfo();
        }
        return (NetworkInfo) invokeL.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static String b(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65537, null, i2, str)) == null) {
            switch (i2) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                case 16:
                    return "2g";
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                    return "3g";
                case 13:
                case 18:
                case 19:
                    break;
                default:
                    if (TextUtils.isEmpty(str) || !str.equalsIgnoreCase("LTE_CA")) {
                        return "unknown";
                    }
                    break;
            }
            return "4g";
        }
        return (String) invokeIL.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            NetworkInfo a2 = a(AppRuntime.getAppContext());
            return (a2 == null || !a2.isConnected()) ? "no" : a2.getType() == 1 ? "wifi" : a2.getType() == 0 ? b(a2.getSubtype(), a2.getSubtypeName()) : "unknown";
        }
        return (String) invokeV.objValue;
    }
}

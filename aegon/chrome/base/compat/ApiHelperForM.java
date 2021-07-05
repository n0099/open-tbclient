package aegon.chrome.base.compat;

import aegon.chrome.base.annotations.DoNotInline;
import android.annotation.TargetApi;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
@DoNotInline
@TargetApi(23)
/* loaded from: classes.dex */
public final class ApiHelperForM {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Network getActiveNetwork(ConnectivityManager connectivityManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, connectivityManager)) == null) {
            try {
                return connectivityManager.getActiveNetwork();
            } catch (Exception unused) {
                return null;
            }
        }
        return (Network) invokeL.objValue;
    }

    public static long getLongVersionCode(PackageInfo packageInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, packageInfo)) == null) ? packageInfo.getLongVersionCode() : invokeL.longValue;
    }

    public static String getPrivateDnsServerName(LinkProperties linkProperties) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, linkProperties)) == null) ? linkProperties.getPrivateDnsServerName() : (String) invokeL.objValue;
    }

    public static boolean isPrivateDnsActive(LinkProperties linkProperties) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, linkProperties)) == null) ? linkProperties.isPrivateDnsActive() : invokeL.booleanValue;
    }
}

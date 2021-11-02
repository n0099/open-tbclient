package com.baidu.searchbox.bddownload;

import androidx.annotation.NonNull;
import com.baidu.searchbox.bddownload.core.connection.DownloadConnection;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.net.ProtocolException;
/* loaded from: classes7.dex */
public class RedirectUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int HTTP_PERMANENT_REDIRECT = 308;
    public static final int HTTP_TEMPORARY_REDIRECT = 307;
    public static final int MAX_REDIRECT_TIMES = 10;
    public transient /* synthetic */ FieldHolder $fh;

    public RedirectUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @NonNull
    public static String getRedirectedUrl(DownloadConnection.Connected connected, int i2) throws IOException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, connected, i2)) == null) {
            String responseHeaderField = connected.getResponseHeaderField("Location");
            if (responseHeaderField != null) {
                return responseHeaderField;
            }
            throw new ProtocolException("Response code is " + i2 + " but can't find Location field");
        }
        return (String) invokeLI.objValue;
    }

    public static boolean isRedirect(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) ? i2 == 301 || i2 == 302 || i2 == 303 || i2 == 300 || i2 == 307 || i2 == 308 : invokeI.booleanValue;
    }
}

package com.baidu.searchbox.bddownload;

import androidx.annotation.NonNull;
import com.baidu.searchbox.bddownload.core.connection.DownloadConnection;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.http.Headers;
import java.io.IOException;
import java.net.ProtocolException;
/* loaded from: classes2.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @NonNull
    public static String getRedirectedUrl(DownloadConnection.Connected connected, int i) throws IOException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, connected, i)) == null) {
            String responseHeaderField = connected.getResponseHeaderField(Headers.LOCATION);
            if (responseHeaderField != null) {
                return responseHeaderField;
            }
            throw new ProtocolException("Response code is " + i + " but can't find Location field");
        }
        return (String) invokeLI.objValue;
    }

    public static boolean isRedirect(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) ? i == 301 || i == 302 || i == 303 || i == 300 || i == 307 || i == 308 : invokeI.booleanValue;
    }
}

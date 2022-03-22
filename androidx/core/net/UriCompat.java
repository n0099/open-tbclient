package androidx.core.net;

import android.net.Uri;
import androidx.annotation.NonNull;
import com.baidu.searchbox.account.contants.LoginConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.component.input.InputType;
/* loaded from: classes.dex */
public final class UriCompat {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public UriCompat() {
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
    public static String toSafeString(@NonNull Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, uri)) == null) {
            String scheme = uri.getScheme();
            String schemeSpecificPart = uri.getSchemeSpecificPart();
            if (scheme != null) {
                if (!scheme.equalsIgnoreCase(InputType.TEL) && !scheme.equalsIgnoreCase("sip") && !scheme.equalsIgnoreCase(LoginConstants.SMS_LOGIN) && !scheme.equalsIgnoreCase("smsto") && !scheme.equalsIgnoreCase("mailto") && !scheme.equalsIgnoreCase("nfc")) {
                    if (scheme.equalsIgnoreCase("http") || scheme.equalsIgnoreCase("https") || scheme.equalsIgnoreCase("ftp") || scheme.equalsIgnoreCase("rtsp")) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("//");
                        sb.append(uri.getHost() != null ? uri.getHost() : "");
                        sb.append(uri.getPort() != -1 ? ":" + uri.getPort() : "");
                        sb.append("/...");
                        schemeSpecificPart = sb.toString();
                    }
                } else {
                    StringBuilder sb2 = new StringBuilder(64);
                    sb2.append(scheme);
                    sb2.append(':');
                    if (schemeSpecificPart != null) {
                        for (int i = 0; i < schemeSpecificPart.length(); i++) {
                            char charAt = schemeSpecificPart.charAt(i);
                            if (charAt != '-' && charAt != '@' && charAt != '.') {
                                sb2.append('x');
                            } else {
                                sb2.append(charAt);
                            }
                        }
                    }
                    return sb2.toString();
                }
            }
            StringBuilder sb3 = new StringBuilder(64);
            if (scheme != null) {
                sb3.append(scheme);
                sb3.append(':');
            }
            if (schemeSpecificPart != null) {
                sb3.append(schemeSpecificPart);
            }
            return sb3.toString();
        }
        return (String) invokeL.objValue;
    }
}

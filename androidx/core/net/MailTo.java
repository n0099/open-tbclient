package androidx.core.net;

import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Preconditions;
import androidx.core.view.InputDeviceCompat;
import com.alipay.sdk.encrypt.a;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes.dex */
public final class MailTo {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BCC = "bcc";
    public static final String BODY = "body";
    public static final String CC = "cc";
    public static final String MAILTO = "mailto";
    public static final String MAILTO_SCHEME = "mailto:";
    public static final String SUBJECT = "subject";
    public static final String TO = "to";
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, String> mHeaders;

    public MailTo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mHeaders = new HashMap<>();
    }

    @Nullable
    public String getBcc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mHeaders.get(BCC);
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public String getBody() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mHeaders.get("body");
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public String getCc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mHeaders.get(CC);
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public Map<String, String> getHeaders() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mHeaders;
        }
        return (Map) invokeV.objValue;
    }

    @Nullable
    public String getSubject() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mHeaders.get(SUBJECT);
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public String getTo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mHeaders.get(TO);
        }
        return (String) invokeV.objValue;
    }

    public static boolean isMailTo(@Nullable Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, uri)) == null) {
            if (uri != null && MAILTO.equals(uri.getScheme())) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @NonNull
    public static MailTo parse(@NonNull Uri uri) throws ParseException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, uri)) == null) {
            return parse(uri.toString());
        }
        return (MailTo) invokeL.objValue;
    }

    public static boolean isMailTo(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (str != null && str.startsWith("mailto:")) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @NonNull
    public static MailTo parse(@NonNull String str) throws ParseException {
        InterceptResult invokeL;
        String decode;
        String substring;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            Preconditions.checkNotNull(str);
            if (isMailTo(str)) {
                int indexOf = str.indexOf(35);
                if (indexOf != -1) {
                    str = str.substring(0, indexOf);
                }
                int indexOf2 = str.indexOf(63);
                if (indexOf2 == -1) {
                    decode = Uri.decode(str.substring(7));
                    substring = null;
                } else {
                    decode = Uri.decode(str.substring(7, indexOf2));
                    substring = str.substring(indexOf2 + 1);
                }
                MailTo mailTo = new MailTo();
                if (substring != null) {
                    for (String str3 : substring.split("&")) {
                        String[] split = str3.split("=", 2);
                        if (split.length != 0) {
                            String lowerCase = Uri.decode(split[0]).toLowerCase(Locale.ROOT);
                            if (split.length > 1) {
                                str2 = Uri.decode(split[1]);
                            } else {
                                str2 = null;
                            }
                            mailTo.mHeaders.put(lowerCase, str2);
                        }
                    }
                }
                String to = mailTo.getTo();
                if (to != null) {
                    decode = decode + StringUtil.ARRAY_ELEMENT_SEPARATOR + to;
                }
                mailTo.mHeaders.put(TO, decode);
                return mailTo;
            }
            throw new ParseException("Not a mailto scheme");
        }
        return (MailTo) invokeL.objValue;
    }

    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            StringBuilder sb = new StringBuilder("mailto:");
            sb.append('?');
            for (Map.Entry<String, String> entry : this.mHeaders.entrySet()) {
                sb.append(Uri.encode(entry.getKey()));
                sb.append(a.h);
                sb.append(Uri.encode(entry.getValue()));
                sb.append('&');
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}

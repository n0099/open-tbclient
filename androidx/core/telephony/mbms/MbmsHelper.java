package androidx.core.telephony.mbms;

import android.content.Context;
import android.os.Build;
import android.os.LocaleList;
import android.telephony.mbms.ServiceInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Locale;
/* loaded from: classes.dex */
public final class MbmsHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public MbmsHelper() {
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

    public static CharSequence getBestNameForService(Context context, ServiceInfo serviceInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, serviceInfo)) == null) {
            if (Build.VERSION.SDK_INT < 28) {
                return null;
            }
            LocaleList locales = context.getResources().getConfiguration().getLocales();
            int size = serviceInfo.getNamedContentLocales().size();
            if (size == 0) {
                return null;
            }
            String[] strArr = new String[size];
            int i = 0;
            for (Locale locale : serviceInfo.getNamedContentLocales()) {
                strArr[i] = locale.toLanguageTag();
                i++;
            }
            Locale firstMatch = locales.getFirstMatch(strArr);
            if (firstMatch == null) {
                return null;
            }
            return serviceInfo.getNameForLocale(firstMatch);
        }
        return (CharSequence) invokeLL.objValue;
    }
}

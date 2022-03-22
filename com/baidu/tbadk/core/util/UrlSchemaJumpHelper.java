package com.baidu.tbadk.core.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.r.j0.b;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes5.dex */
public class UrlSchemaJumpHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_APP_JUMP_BLACK_LIST = "ad_scheme_blacklist";
    public static final List<String> SCHEMA_BLACK_LIST;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2142095601, "Lcom/baidu/tbadk/core/util/UrlSchemaJumpHelper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2142095601, "Lcom/baidu/tbadk/core/util/UrlSchemaJumpHelper;");
                return;
            }
        }
        SCHEMA_BLACK_LIST = new ArrayList();
    }

    public UrlSchemaJumpHelper() {
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

    public static void ensureBlackList() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, null) == null) && ListUtils.isEmpty(SCHEMA_BLACK_LIST)) {
            String q = b.k().q(KEY_APP_JUMP_BLACK_LIST, null);
            if (TextUtils.isEmpty(q)) {
                return;
            }
            try {
                setBlackList(new JSONArray(q));
            } catch (JSONException e2) {
                BdLog.e(e2);
            }
        }
    }

    public static boolean isHitBlackList(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (str == null) {
                return false;
            }
            ensureBlackList();
            for (String str2 : SCHEMA_BLACK_LIST) {
                if (str.startsWith(str2)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static int launchApplication(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str)) == null) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            try {
                intent.setData(Uri.parse(str));
                try {
                    if (context.getPackageManager().resolveActivity(intent, 65536) == null) {
                        return 1004;
                    }
                    context.startActivity(intent);
                    return 1000;
                } catch (Exception unused) {
                    return 1006;
                }
            } catch (Exception unused2) {
                return 1003;
            }
        }
        return invokeLL.intValue;
    }

    public static void setBlackList(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, jSONArray) == null) {
            if (jSONArray != null && jSONArray.length() != 0) {
                ArrayList arrayList = new ArrayList(jSONArray.length());
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    String optString = jSONArray.optString(i);
                    if (!StringUtils.isNull(optString)) {
                        arrayList.add(optString);
                    }
                }
                synchronized (SCHEMA_BLACK_LIST) {
                    SCHEMA_BLACK_LIST.clear();
                    SCHEMA_BLACK_LIST.addAll(arrayList);
                }
                b.k().y(KEY_APP_JUMP_BLACK_LIST, jSONArray.toString());
                return;
            }
            b.k().D(KEY_APP_JUMP_BLACK_LIST);
            SCHEMA_BLACK_LIST.clear();
        }
    }

    public static boolean tryDeeplinkFromWebview(String str, @NonNull Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, str, context)) == null) ? (TextUtils.isEmpty(str) || isHitBlackList(str) || launchApplication(context, str) != 1000) ? false : true : invokeLL.booleanValue;
    }
}

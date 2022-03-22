package com.baidu.tbadk.core.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class WebViewUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String WEBVIEW_CACHE_DATABASE_FILE = "webviewCache.db";
    public static final String WEBVIEW_DATABASE_FILE = "webview.db";
    public transient /* synthetic */ FieldHolder $fh;

    public WebViewUtil() {
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

    public static boolean isDatabaseCorrupted(Context context, String str) {
        InterceptResult invokeLL;
        SQLiteDatabase openOrCreateDatabase;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) {
            if (context == null || StringUtils.isNull(str)) {
                return false;
            }
            try {
                try {
                    SQLiteDatabase openOrCreateDatabase2 = context.openOrCreateDatabase(str, 0, null);
                    if (openOrCreateDatabase2 != null) {
                        openOrCreateDatabase2.close();
                        return false;
                    }
                    return false;
                } catch (Throwable unused) {
                    return true;
                }
            } catch (Throwable unused2) {
                if (!context.deleteDatabase(str) || (openOrCreateDatabase = context.openOrCreateDatabase(str, 0, null)) == null) {
                    return false;
                }
                openOrCreateDatabase.close();
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static boolean isWebViewCorrupted(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (context == null) {
                return false;
            }
            boolean isDatabaseCorrupted = isDatabaseCorrupted(context, WEBVIEW_DATABASE_FILE);
            if (isDatabaseCorrupted(context, WEBVIEW_CACHE_DATABASE_FILE)) {
                return true;
            }
            return isDatabaseCorrupted;
        }
        return invokeL.booleanValue;
    }
}

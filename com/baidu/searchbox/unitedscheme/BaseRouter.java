package com.baidu.searchbox.unitedscheme;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
/* loaded from: classes2.dex */
public class BaseRouter {
    public static boolean invoke(Context context, String str) {
        if (UnitedSchemeUtility.isUnitedScheme(str)) {
            return invokeSchemeForInner(context, Uri.parse(str));
        }
        return false;
    }

    public static boolean invokeNextScheme(Context context, Intent intent) {
        return SchemeRouter.invokeNextScheme(context, intent);
    }

    public static boolean invokeScheme(Context context, Uri uri, String str, CallbackHandler callbackHandler) {
        if (context == null) {
            context = AppRuntime.getAppContext();
        }
        return SchemeRouter.invokeScheme(context, uri, str, callbackHandler);
    }

    public static boolean invokeSchemeForInner(Context context, Uri uri) {
        return SchemeRouter.invokeSchemeForInner(context, uri);
    }

    public static boolean isAvailable(Context context, String str) {
        if (UnitedSchemeUtility.isUnitedScheme(str)) {
            return isSchemeAvailable(context, Uri.parse(str), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
        }
        return false;
    }

    public static boolean isSchemeAvailable(Context context, Uri uri, String str) {
        if (context == null) {
            context = AppRuntime.getAppContext();
        }
        return SchemeRouter.isSchemeAvailable(context, uri, str);
    }

    public static boolean invokeScheme(Context context, Uri uri, String str) {
        return invokeScheme(context, uri, str, null);
    }
}

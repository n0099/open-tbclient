package com.baidu.searchbox.unitedscheme;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
/* loaded from: classes5.dex */
public class SchemeRouter {
    public static boolean isSchemeAvailable(Context context, Uri uri, String str) {
        if (context == null) {
            context = SchemeConfig.getAppContext();
        }
        UnitedSchemeMainDispatcher unitedSchemeMainDispatcher = new UnitedSchemeMainDispatcher();
        UnitedSchemeEntity unitedSchemeEntity = new UnitedSchemeEntity(uri, str);
        unitedSchemeEntity.setOnlyVerify(true);
        return unitedSchemeMainDispatcher.dispatch(context, unitedSchemeEntity);
    }

    public static boolean invokeSchemeForInner(Context context, Uri uri) {
        return invokeScheme(context, uri, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
    }

    public static boolean invokeScheme(Context context, Uri uri, String str, CallbackHandler callbackHandler) {
        if (context == null) {
            context = SchemeConfig.getAppContext();
        }
        UnitedSchemeMainDispatcher unitedSchemeMainDispatcher = new UnitedSchemeMainDispatcher();
        UnitedSchemeEntity unitedSchemeEntity = new UnitedSchemeEntity(uri, str);
        unitedSchemeEntity.setOnlyVerify(false);
        return unitedSchemeMainDispatcher.dispatch(context, unitedSchemeEntity, callbackHandler);
    }

    public static boolean invokeScheme(Context context, Uri uri, String str) {
        return invokeScheme(context, uri, str, null);
    }

    public static boolean invokeNextScheme(Context context, Intent intent) {
        if (intent == null) {
            return false;
        }
        if (context == null) {
            context = SchemeConfig.getAppContext();
        }
        String stringExtra = intent.getStringExtra(UnitedSchemeConstants.INTENT_KEY_FOR_NEXT);
        if (TextUtils.isEmpty(stringExtra)) {
            return false;
        }
        return invokeScheme(context, Uri.parse(stringExtra), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
    }

    public static boolean invoke(Context context, String str) {
        if (UnitedSchemeUtility.isUnitedScheme(str)) {
            return invokeSchemeForInner(context, Uri.parse(str));
        }
        return false;
    }
}

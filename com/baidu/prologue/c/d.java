package com.baidu.prologue.c;

import android.content.Context;
import android.net.Uri;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
/* loaded from: classes19.dex */
public class d {
    static {
        h acW = h.acW();
        i iVar = new i();
        acW.a("splash_ad", iVar);
        acW.a(iVar);
    }

    public static boolean invokeSchemeForInner(Context context, Uri uri) {
        return invokeScheme(context, uri, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
    }

    public static boolean invokeScheme(Context context, Uri uri, String str) {
        return a(context, uri, str, null);
    }

    public static boolean a(Context context, Uri uri, String str, a aVar) {
        if (context == null) {
            context = c.getAppContext();
        }
        h acW = h.acW();
        g gVar = new g(uri, str);
        gVar.setOnlyVerify(false);
        return acW.a(context, gVar, aVar);
    }

    public static boolean invoke(Context context, String str) {
        if (j.isUnitedScheme(str)) {
            return invokeSchemeForInner(context, Uri.parse(str));
        }
        return false;
    }
}

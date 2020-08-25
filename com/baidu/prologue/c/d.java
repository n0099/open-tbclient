package com.baidu.prologue.c;

import android.content.Context;
import android.net.Uri;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
/* loaded from: classes9.dex */
public class d {
    static {
        h VY = h.VY();
        i iVar = new i();
        VY.a("splash_ad", iVar);
        VY.a(iVar);
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
        h VY = h.VY();
        g gVar = new g(uri, str);
        gVar.setOnlyVerify(false);
        return VY.a(context, gVar, aVar);
    }

    public static boolean invoke(Context context, String str) {
        if (j.isUnitedScheme(str)) {
            return invokeSchemeForInner(context, Uri.parse(str));
        }
        return false;
    }
}

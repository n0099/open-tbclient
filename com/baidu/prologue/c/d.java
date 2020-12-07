package com.baidu.prologue.c;

import android.content.Context;
import android.net.Uri;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
/* loaded from: classes14.dex */
public class d {
    static {
        h afv = h.afv();
        i iVar = new i();
        afv.a("splash_ad", iVar);
        afv.a(iVar);
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
        h afv = h.afv();
        g gVar = new g(uri, str);
        gVar.setOnlyVerify(false);
        return afv.a(context, gVar, aVar);
    }

    public static boolean invoke(Context context, String str) {
        if (j.isUnitedScheme(str)) {
            return invokeSchemeForInner(context, Uri.parse(str));
        }
        return false;
    }
}

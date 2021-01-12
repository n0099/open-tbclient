package com.baidu.prologue.c;

import android.content.Context;
import android.net.Uri;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
/* loaded from: classes5.dex */
public class d {
    static {
        h ady = h.ady();
        i iVar = new i();
        ady.a("splash_ad", iVar);
        ady.a(iVar);
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
        h ady = h.ady();
        g gVar = new g(uri, str);
        gVar.setOnlyVerify(false);
        return ady.a(context, gVar, aVar);
    }

    public static boolean invoke(Context context, String str) {
        if (j.isUnitedScheme(str)) {
            return invokeSchemeForInner(context, Uri.parse(str));
        }
        return false;
    }
}

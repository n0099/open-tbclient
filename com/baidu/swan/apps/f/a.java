package com.baidu.swan.apps.f;

import android.text.TextUtils;
import com.baidu.swan.apps.v.b.b;
/* loaded from: classes2.dex */
public class a {
    @Deprecated
    public static boolean dm(String str) {
        return (TextUtils.isEmpty(str) || str.contains("_")) ? false : true;
    }

    public static boolean a(b bVar) {
        return bVar != null && bVar.mType == 0;
    }

    public static boolean b(b bVar) {
        return bVar != null && bVar.mType == 1;
    }

    public static boolean c(b bVar) {
        return bVar != null && bVar.mType == 2;
    }

    public static String dn(String str) {
        if (!TextUtils.isEmpty(str)) {
            int indexOf = str.indexOf("_dev");
            if (indexOf > 0) {
                return str.substring(0, indexOf);
            }
            int indexOf2 = str.indexOf("_trial");
            if (indexOf2 > 0) {
                return str.substring(0, indexOf2);
            }
            return str;
        }
        return str;
    }

    /* renamed from: do  reason: not valid java name */
    public static String m13do(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf("_dev");
        if (lastIndexOf >= 0 && lastIndexOf < str.length()) {
            return str.substring(lastIndexOf);
        }
        int lastIndexOf2 = str.lastIndexOf("_trial");
        if (lastIndexOf2 >= 0 && lastIndexOf2 < str.length()) {
            return str.substring(lastIndexOf2);
        }
        return "";
    }
}

package com.baidu.searchbox.schemeauthenticate;

import android.net.Uri;
import android.text.TextUtils;
/* loaded from: classes4.dex */
public class AuthenticateUtils {
    public static final String getAuthKey(String str, String str2) {
        try {
            Uri parse = Uri.parse(str);
            return parse.getScheme() + parse.getAuthority() + str2;
        } catch (Exception unused) {
            return null;
        }
    }

    public static final String getSameOriginUri(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Uri parse = Uri.parse(str);
            return parse.getScheme() + parse.getAuthority();
        } catch (Exception unused) {
            return null;
        }
    }

    public static final String getSchemeAuthority(String str) {
        try {
            Uri parse = Uri.parse(str);
            return parse.getAuthority() + parse.getPath();
        } catch (Exception unused) {
            return null;
        }
    }
}

package com.baidu.loginshare;

import android.content.Context;
import com.baidu.share.Crypto;
/* loaded from: classes.dex */
public class f {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(Context context, String str) {
        try {
            return Crypto.a(context, str);
        } catch (Throwable th) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(Context context, String str) {
        try {
            return Crypto.b(context, str);
        } catch (Throwable th) {
            return null;
        }
    }
}

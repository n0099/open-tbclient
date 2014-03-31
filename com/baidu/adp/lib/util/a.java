package com.baidu.adp.lib.util;

import android.text.ClipboardManager;
/* loaded from: classes.dex */
public final class a {
    public static void a(String str) {
        if (str == null) {
            str = "";
        }
        try {
            ((ClipboardManager) com.baidu.adp.a.b.a().b().getSystemService("clipboard")).setText(str);
        } catch (Throwable th) {
            f.b("copyToClipboard failed: " + th.getMessage());
        }
    }
}

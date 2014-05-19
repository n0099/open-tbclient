package com.baidu.adp.lib.util;

import android.text.ClipboardManager;
/* loaded from: classes.dex */
public class a {
    public static void a(String str) {
        if (str == null) {
            str = "";
        }
        try {
            ((ClipboardManager) com.baidu.adp.base.a.getInst().getApp().getSystemService("clipboard")).setText(str);
        } catch (Throwable th) {
            BdLog.e("copyToClipboard failed: " + th.getMessage());
        }
    }
}

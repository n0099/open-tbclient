package com.baidu.adp.lib.util;

import android.text.ClipboardManager;
import com.baidu.adp.base.BdBaseApplication;
/* loaded from: classes.dex */
public class a {
    public static void aE(String str) {
        if (str == null) {
            str = "";
        }
        try {
            ((ClipboardManager) BdBaseApplication.getInst().getApp().getSystemService("clipboard")).setText(str);
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }
}

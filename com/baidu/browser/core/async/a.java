package com.baidu.browser.core.async;

import android.os.Build;
import android.os.HandlerThread;
import android.os.Looper;
/* loaded from: classes11.dex */
public class a extends HandlerThread {
    public a(String str, int i) {
        super(str, i);
    }

    @Override // android.os.HandlerThread
    public boolean quit() {
        return quitSafely();
    }

    @Override // android.os.HandlerThread
    public boolean quitSafely() {
        b.a(this);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ts() {
        try {
            Looper looper = getLooper();
            if (Build.VERSION.SDK_INT >= 18) {
                looper.quitSafely();
            } else {
                looper.quit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

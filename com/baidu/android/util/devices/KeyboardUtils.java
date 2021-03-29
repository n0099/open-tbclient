package com.baidu.android.util.devices;

import android.content.Context;
import android.os.IBinder;
import android.view.inputmethod.InputMethodManager;
/* loaded from: classes.dex */
public class KeyboardUtils {
    public static final boolean DEBUG = false;
    public static final String TAG = "KeyboardUtils";

    public static synchronized void forceHiddenSoftInput(Context context, IBinder iBinder) {
        synchronized (KeyboardUtils.class) {
            InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
            if (inputMethodManager != null) {
                try {
                    inputMethodManager.hideSoftInputFromWindow(iBinder, 0);
                } catch (Exception unused) {
                }
            }
        }
    }

    public static synchronized void forceToggleSoftInput(Context context, boolean z) {
        synchronized (KeyboardUtils.class) {
            InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.toggleSoftInput(z ? 2 : 0, 2);
            }
        }
    }
}

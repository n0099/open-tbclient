package com.baidu.android.util.devices;

import android.content.Context;
import android.os.IBinder;
import android.view.inputmethod.InputMethodManager;
/* loaded from: classes9.dex */
public class KeyboardUtils {
    private static final boolean DEBUG = false;
    private static final String TAG = "KeyboardUtils";

    public static synchronized void forceHiddenSoftInput(Context context, IBinder iBinder) {
        synchronized (KeyboardUtils.class) {
            InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
            if (inputMethodManager != null) {
                try {
                    inputMethodManager.hideSoftInputFromWindow(iBinder, 0);
                } catch (Exception e) {
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

package com.baidu.swan.apps.ap;

import android.content.Context;
import android.os.IBinder;
import android.view.inputmethod.InputMethodManager;
/* loaded from: classes10.dex */
public class w {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void forceHiddenSoftInput(Context context, IBinder iBinder) {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
        if (inputMethodManager != null) {
            try {
                inputMethodManager.hideSoftInputFromWindow(iBinder, 0);
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void forceToggleSoftInput(Context context, boolean z) {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.toggleSoftInput(z ? 2 : 0, 2);
        }
    }
}

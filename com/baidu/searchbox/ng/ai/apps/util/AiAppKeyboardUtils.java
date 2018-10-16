package com.baidu.searchbox.ng.ai.apps.util;

import android.content.Context;
import android.os.IBinder;
import android.view.inputmethod.InputMethodManager;
/* loaded from: classes2.dex */
public class AiAppKeyboardUtils {
    private static final boolean DEBUG = false;
    private static final String TAG = "KeyboardUtils";

    public static void forceHiddenSoftInput(Context context, IBinder iBinder) {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
        if (inputMethodManager != null) {
            try {
                inputMethodManager.hideSoftInputFromWindow(iBinder, 0);
            } catch (Exception e) {
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

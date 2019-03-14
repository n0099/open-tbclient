package com.baidu.swan.apps.an;

import android.content.Context;
import android.os.IBinder;
import android.view.inputmethod.InputMethodManager;
/* loaded from: classes2.dex */
public class o {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void a(Context context, IBinder iBinder) {
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
}

package com.baidu.tbadk.core.util;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import d.a.j0.m.g;
import java.lang.reflect.Field;
/* loaded from: classes3.dex */
public class InputMethodManagerLeaksFixer {
    public static void fixFocusedViewLeak(Application application) {
        final InputMethodManager inputMethodManager;
        if (application == null || (inputMethodManager = (InputMethodManager) application.getSystemService("input_method")) == null) {
            return;
        }
        String[] strArr = {"mCurRootView", "mServedView", "mNextServedView"};
        final Field[] fieldArr = new Field[3];
        for (int i2 = 0; i2 < 3; i2++) {
            try {
                fieldArr[i2] = inputMethodManager.getClass().getDeclaredField(strArr[i2]);
                if (!fieldArr[i2].isAccessible()) {
                    fieldArr[i2].setAccessible(true);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        application.registerActivityLifecycleCallbacks(new g() { // from class: com.baidu.tbadk.core.util.InputMethodManagerLeaksFixer.1
            @Override // d.a.j0.m.g, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                InputMethodManagerLeaksFixer.fixInputMethodMemoryLeak(activity, fieldArr, inputMethodManager);
            }
        });
    }

    public static void fixInputMethodMemoryLeak(Context context, Field[] fieldArr, InputMethodManager inputMethodManager) {
        if (context == null || fieldArr == null || fieldArr.length <= 0 || inputMethodManager == null) {
            return;
        }
        for (Field field : fieldArr) {
            try {
                Object obj = field.get(inputMethodManager);
                if (!(obj instanceof View)) {
                    continue;
                } else if (((View) obj).getContext() != context) {
                    return;
                } else {
                    field.set(inputMethodManager, null);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}

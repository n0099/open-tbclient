package com.baidu.tbadk.core.util;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class x {
    /* JADX INFO: Access modifiers changed from: private */
    public static void a(Context context, Field[] fieldArr, InputMethodManager inputMethodManager) {
        if (context != null && fieldArr != null && fieldArr.length > 0 && inputMethodManager != null) {
            for (Field field : fieldArr) {
                try {
                    Object obj = field.get(inputMethodManager);
                    if (!(obj instanceof View)) {
                        continue;
                    } else if (((View) obj).getContext() == context) {
                        field.set(inputMethodManager, null);
                    } else {
                        return;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void f(Application application) {
        final InputMethodManager inputMethodManager;
        if (application != null && (inputMethodManager = (InputMethodManager) application.getSystemService("input_method")) != null) {
            String[] strArr = {"mCurRootView", "mServedView", "mNextServedView"};
            final Field[] fieldArr = new Field[strArr.length];
            for (int i = 0; i < strArr.length; i++) {
                try {
                    fieldArr[i] = inputMethodManager.getClass().getDeclaredField(strArr[i]);
                    if (!fieldArr[i].isAccessible()) {
                        fieldArr[i].setAccessible(true);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            application.registerActivityLifecycleCallbacks(new com.baidu.tbadk.h.g() { // from class: com.baidu.tbadk.core.util.x.1
                @Override // com.baidu.tbadk.h.g, android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity) {
                    x.a(activity, fieldArr, inputMethodManager);
                }
            });
        }
    }
}

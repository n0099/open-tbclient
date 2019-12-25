package com.baidu.e.a.a;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
/* loaded from: classes11.dex */
public class g {
    public static void b(Context context, View view) {
        try {
            view.requestFocus();
            ((InputMethodManager) context.getApplicationContext().getSystemService("input_method")).toggleSoftInput(0, 2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void ax(Context context) {
        try {
            if (context instanceof Activity) {
                a(context, (Activity) context);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void a(Context context, Activity activity) {
        try {
            ((InputMethodManager) context.getApplicationContext().getSystemService("input_method")).hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void c(Context context, View view) {
        if (view != null && context != null) {
            try {
                ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

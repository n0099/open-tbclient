package com.baidu.sapi2.utils;

import android.content.Context;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
/* loaded from: classes2.dex */
public class AccessibleUtils {
    public static void accessible(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain();
            obtain.setEventType(16384);
            obtain.setClassName(context.getClass().getName());
            obtain.setPackageName(context.getPackageName());
            obtain.getText().add(str);
            accessibilityManager.sendAccessibilityEvent(obtain);
        }
    }
}

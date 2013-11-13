package com.baidu.cloudsdk.social.core;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.cloudsdk.common.util.Validator;
/* loaded from: classes.dex */
public class WidgetPreferenceManager {

    /* renamed from: a  reason: collision with root package name */
    private static WidgetPreferenceManager f850a;
    private SharedPreferences b;

    private WidgetPreferenceManager(Context context) {
        Validator.notNull(context, "context");
        this.b = context.getSharedPreferences("com.baidu.cloudsdk.social.WIDGET", 0);
    }

    public static WidgetPreferenceManager getInstance(Context context) {
        if (f850a == null) {
            f850a = new WidgetPreferenceManager(context);
        }
        return f850a;
    }

    public boolean isWidgetActivated(String str) {
        return this.b.getBoolean(str, false);
    }

    public void setWidgetActivated(String str) {
        this.b.edit().putBoolean(str, true).commit();
    }
}

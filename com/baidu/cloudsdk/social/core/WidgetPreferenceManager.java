package com.baidu.cloudsdk.social.core;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.cloudsdk.common.util.Validator;
/* loaded from: classes.dex */
public class WidgetPreferenceManager {
    private SharedPreferences a;

    public WidgetPreferenceManager(Context context) {
        Validator.notNull(context, "context");
        this.a = context.getSharedPreferences("com.baidu.cloudsdk.social.WIDGET", 0);
    }

    public boolean isWidgetActivated(String str) {
        return this.a.getBoolean(str, false);
    }

    public void setWidgetActivated(String str) {
        this.a.edit().putBoolean(str, true).commit();
    }
}

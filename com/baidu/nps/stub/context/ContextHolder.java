package com.baidu.nps.stub.context;

import android.app.Application;
import android.text.TextUtils;
import com.baidu.nps.stub.component.NPSApplication;
/* loaded from: classes2.dex */
public abstract class ContextHolder {
    public final Application getContextInternal() {
        Application applicationContext = com.baidu.nps.utils.ContextHolder.getApplicationContext();
        return TextUtils.isEmpty(getPackageName()) ? applicationContext : new NPSApplication(applicationContext, getPackageName());
    }

    public abstract String getPackageName();
}

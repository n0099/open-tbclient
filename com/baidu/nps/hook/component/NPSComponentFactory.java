package com.baidu.nps.hook.component;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AppComponentFactory;
import android.app.Application;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.os.Process;
import android.util.Log;
import com.baidu.nps.main.manager.NPSManager;
import d.b.x.h.b;
@TargetApi(28)
/* loaded from: classes2.dex */
public class NPSComponentFactory extends AppComponentFactory {
    @Override // android.app.AppComponentFactory
    public Activity instantiateActivity(ClassLoader classLoader, String str, Intent intent) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        if (b.a()) {
            Log.e("NPS", "instantiateActivity,classLoader=" + classLoader + " className=" + str);
            StringBuilder sb = new StringBuilder();
            sb.append("NPSComponentFactory.instantiateActivity|process=");
            sb.append(Process.myPid());
            Log.e("NPS", sb.toString());
        }
        try {
            return super.instantiateActivity(classLoader, str, intent);
        } catch (ClassNotFoundException unused) {
            return NPSManager.getInstance().instantiateActivity(str);
        }
    }

    @Override // android.app.AppComponentFactory
    public Application instantiateApplication(ClassLoader classLoader, String str) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        if (b.a()) {
            Log.e("NPS", "instantiateApplication,classLoader=" + classLoader + " className=" + str);
        }
        return super.instantiateApplication(classLoader, str);
    }

    @Override // android.app.AppComponentFactory
    public BroadcastReceiver instantiateReceiver(ClassLoader classLoader, String str, Intent intent) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        if (b.a()) {
            Log.e("NPS", "instantiateReceiver,classLoader=" + classLoader + " className=" + str);
        }
        try {
            return super.instantiateReceiver(classLoader, str, intent);
        } catch (ClassNotFoundException unused) {
            return NPSManager.getInstance().instantiateReceiver(str);
        }
    }

    @Override // android.app.AppComponentFactory
    public Service instantiateService(ClassLoader classLoader, String str, Intent intent) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        if (b.a()) {
            Log.e("NPS", "instantiateService,classLoader=" + classLoader + " className=" + str);
        }
        try {
            return super.instantiateService(classLoader, str, intent);
        } catch (ClassNotFoundException unused) {
            return NPSManager.getInstance().instantiateService(str);
        }
    }
}

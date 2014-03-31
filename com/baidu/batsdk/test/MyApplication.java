package com.baidu.batsdk.test;

import android.app.Application;
import com.baidu.batsdk.BatSDK;
/* loaded from: classes.dex */
public class MyApplication extends Application {
    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        BatSDK.setLogLevel(1);
        BatSDK.setUploadInterval(20000);
        BatSDK.setSyncInterval(20000L);
        BatSDK.init(this);
    }
}

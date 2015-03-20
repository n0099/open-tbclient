package com.baidu.location;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import dalvik.system.DexClassLoader;
import java.io.File;
/* loaded from: classes.dex */
public class f extends Service implements a0, n {
    private static final String iO = "app.jar";
    LLSInterface iN = null;
    LLSInterface iP = null;
    LLSInterface iQ = null;
    public static String replaceFileName = "repll.jar";
    public static Context mC = null;

    public static float getFrameVersion() {
        return 5.01f;
    }

    public static String getJarFileName() {
        return iO;
    }

    public static Context getServiceContext() {
        return mC;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.iQ.onBind(intent);
    }

    @Override // android.app.Service
    public void onCreate() {
        mC = getApplicationContext();
        System.currentTimeMillis();
        this.iP = new ad();
        try {
            File file = new File(c.m276long() + File.separator + replaceFileName);
            if (file.exists()) {
                File file2 = new File(c.m276long() + File.separator + iO);
                if (file2.exists()) {
                    file2.delete();
                }
                file.renameTo(file2);
            }
            this.iN = (LLSInterface) new DexClassLoader(c.m276long() + File.separator + iO, c.m276long(), null, getClassLoader()).loadClass("com.baidu.serverLoc.LocationService").newInstance();
        } catch (Exception e) {
            this.iN = null;
        }
        if (this.iN == null || this.iN.getVersion() <= this.iP.getVersion()) {
            this.iQ = this.iP;
            this.iN = null;
        } else {
            this.iQ = this.iN;
            this.iP = null;
        }
        this.iQ.onCreate(this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.iQ.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        return this.iQ.onStartCommand(intent, i, i2);
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        return this.iQ.onUnBind(intent);
    }
}

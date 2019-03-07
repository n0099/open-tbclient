package com.baidu.location;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.baidu.location.f.a;
import com.baidu.location.g.g;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.RandomAccessFile;
/* loaded from: classes3.dex */
public class f extends Service {
    LLSInterface a = null;
    LLSInterface b = null;
    LLSInterface c = null;
    public static String replaceFileName = "repll.jar";
    public static Context mC = null;
    public static boolean isServing = false;
    public static boolean isStartedServing = false;

    private boolean a(File file) {
        int readInt;
        boolean z = false;
        try {
            File file2 = new File(g.h() + "/grtcfrsa.dat");
            if (file2.exists()) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
                randomAccessFile.seek(200L);
                if (randomAccessFile.readBoolean() && randomAccessFile.readBoolean() && (readInt = randomAccessFile.readInt()) != 0) {
                    byte[] bArr = new byte[readInt];
                    randomAccessFile.read(bArr, 0, readInt);
                    String str = new String(bArr);
                    String a = g.a(file, "SHA-256");
                    if (str != null && a != null && g.b(a, str, "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCiP7BS5IjEOzrKGR9/Ww9oSDhdX1ir26VOsYjT1T6tk2XumRpkHRwZbrucDcNnvSB4QsqiEJnvTSRi7YMbh2H9sLMkcvHlMV5jAErNvnuskWfcvf7T2mq7EUZI/Hf4oVZhHV0hQJRFVdTcjWI6q2uaaKM3VMh+roDesiE7CR2biQIDAQAB")) {
                        z = true;
                    }
                }
                randomAccessFile.close();
            }
        } catch (Exception e) {
        }
        return z;
    }

    public static float getFrameVersion() {
        return 7.8f;
    }

    public static String getJarFileName() {
        return "app.jar";
    }

    public static Context getServiceContext() {
        return mC;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.c.onBind(intent);
    }

    @Override // android.app.Service
    @SuppressLint({"NewApi"})
    public void onCreate() {
        mC = getApplicationContext();
        System.currentTimeMillis();
        this.b = new a();
        try {
            File file = new File(g.h() + File.separator + replaceFileName);
            File file2 = new File(g.h() + File.separator + "app.jar");
            if (file.exists()) {
                if (file2.exists()) {
                    file2.delete();
                }
                file.renameTo(file2);
            }
            if (file2.exists() && a(new File(g.h() + File.separator + "app.jar"))) {
                this.a = (LLSInterface) new DexClassLoader(g.h() + File.separator + "app.jar", g.h(), null, getClassLoader()).loadClass("com.baidu.serverLoc.LocationService").newInstance();
            }
        } catch (Exception e) {
            this.a = null;
        }
        if (this.a == null || this.a.getVersion() < this.b.getVersion()) {
            this.c = this.b;
            this.a = null;
        } else {
            this.c = this.a;
            this.b = null;
        }
        isServing = true;
        this.c.onCreate(this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        isServing = false;
        this.c.onDestroy();
        if (isStartedServing) {
            stopForeground(true);
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        return this.c.onStartCommand(intent, i, i2);
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        this.c.onTaskRemoved(intent);
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        return this.c.onUnBind(intent);
    }
}

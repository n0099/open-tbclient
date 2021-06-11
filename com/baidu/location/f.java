package com.baidu.location;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Process;
import android.util.Log;
import com.baidu.android.util.io.ActionJsonData;
import com.baidu.location.e.k;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.RandomAccessFile;
/* loaded from: classes2.dex */
public class f extends Service {
    public static boolean isServing = false;
    public static boolean isStartedServing = false;
    public static Context mC = null;
    public static String replaceFileName = "repll.jar";

    /* renamed from: a  reason: collision with root package name */
    public LLSInterface f6771a = null;

    /* renamed from: b  reason: collision with root package name */
    public LLSInterface f6772b = null;

    /* renamed from: c  reason: collision with root package name */
    public LLSInterface f6773c = null;

    private boolean a(File file) {
        int readInt;
        boolean z = false;
        try {
            File file2 = new File(k.j() + "/grtcfrsa.dat");
            if (file2.exists()) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
                randomAccessFile.seek(200L);
                if (randomAccessFile.readBoolean() && randomAccessFile.readBoolean() && (readInt = randomAccessFile.readInt()) != 0) {
                    byte[] bArr = new byte[readInt];
                    randomAccessFile.read(bArr, 0, readInt);
                    String str = new String(bArr);
                    String a2 = k.a(file, "SHA-256");
                    if (a2 != null && k.b(a2, str, "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCiP7BS5IjEOzrKGR9/Ww9oSDhdX1ir26VOsYjT1T6tk2XumRpkHRwZbrucDcNnvSB4QsqiEJnvTSRi7YMbh2H9sLMkcvHlMV5jAErNvnuskWfcvf7T2mq7EUZI/Hf4oVZhHV0hQJRFVdTcjWI6q2uaaKM3VMh+roDesiE7CR2biQIDAQAB")) {
                        z = true;
                    }
                }
                randomAccessFile.close();
            }
        } catch (Exception unused) {
        }
        return z;
    }

    public static float getFrameVersion() {
        return 7.93f;
    }

    public static String getJarFileName() {
        return "app.jar";
    }

    public static Context getServiceContext() {
        return mC;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        LLSInterface lLSInterface = this.f6773c;
        if (lLSInterface != null) {
            return lLSInterface.onBind(intent);
        }
        return null;
    }

    @Override // android.app.Service
    @SuppressLint({"NewApi"})
    public void onCreate() {
        if (isServing) {
            Log.d("baidu_location_service", "baidu location service can not start again ...20190306..." + Process.myPid());
            return;
        }
        mC = getApplicationContext();
        System.currentTimeMillis();
        this.f6772b = new com.baidu.location.d.a();
        try {
            File file = new File(k.j() + File.separator + replaceFileName);
            File file2 = new File(k.j() + File.separator + "app.jar");
            if (file.exists()) {
                if (file2.exists()) {
                    file2.delete();
                }
                file.renameTo(file2);
            }
            if (file2.exists()) {
                if (a(new File(k.j() + File.separator + "app.jar"))) {
                    this.f6771a = (LLSInterface) new DexClassLoader(k.j() + File.separator + "app.jar", k.j(), null, getClassLoader()).loadClass("com.baidu.serverLoc.LocationService").newInstance();
                }
            }
        } catch (Exception unused) {
            this.f6771a = null;
        }
        LLSInterface lLSInterface = this.f6771a;
        if (lLSInterface == null || lLSInterface.getVersion() < this.f6772b.getVersion()) {
            this.f6773c = this.f6772b;
            this.f6771a = null;
        } else {
            this.f6773c = this.f6771a;
            this.f6772b = null;
        }
        isServing = true;
        this.f6773c.onCreate(this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        isServing = false;
        LLSInterface lLSInterface = this.f6773c;
        if (lLSInterface != null) {
            lLSInterface.onDestroy();
        }
        if (isStartedServing) {
            stopForeground(true);
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        if (intent != null) {
            try {
                int intExtra = intent.getIntExtra("command", 0);
                if (intExtra == 1) {
                    startForeground(intent.getIntExtra("id", 0), (Notification) intent.getParcelableExtra(ActionJsonData.TAG_NOTIFICATION));
                    isStartedServing = true;
                } else if (intExtra == 2) {
                    stopForeground(intent.getBooleanExtra("removenotify", true));
                    isStartedServing = false;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return this.f6773c.onStartCommand(intent, i2, i3);
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        LLSInterface lLSInterface = this.f6773c;
        if (lLSInterface != null) {
            lLSInterface.onTaskRemoved(intent);
        }
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        return false;
    }
}

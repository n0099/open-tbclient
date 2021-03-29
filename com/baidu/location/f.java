package com.baidu.location;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.baidu.android.util.io.ActionJsonData;
import com.baidu.location.d.j;
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
    public LLSInterface f6723a = null;

    /* renamed from: b  reason: collision with root package name */
    public LLSInterface f6724b = null;

    /* renamed from: c  reason: collision with root package name */
    public LLSInterface f6725c = null;

    private boolean a(File file) {
        int readInt;
        boolean z = false;
        try {
            File file2 = new File(j.h() + "/grtcfrsa.dat");
            if (file2.exists()) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
                randomAccessFile.seek(200L);
                if (randomAccessFile.readBoolean() && randomAccessFile.readBoolean() && (readInt = randomAccessFile.readInt()) != 0) {
                    byte[] bArr = new byte[readInt];
                    randomAccessFile.read(bArr, 0, readInt);
                    String str = new String(bArr);
                    String a2 = j.a(file, "SHA-256");
                    if (a2 != null && j.b(a2, str, "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCiP7BS5IjEOzrKGR9/Ww9oSDhdX1ir26VOsYjT1T6tk2XumRpkHRwZbrucDcNnvSB4QsqiEJnvTSRi7YMbh2H9sLMkcvHlMV5jAErNvnuskWfcvf7T2mq7EUZI/Hf4oVZhHV0hQJRFVdTcjWI6q2uaaKM3VMh+roDesiE7CR2biQIDAQAB")) {
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
        return 7.63f;
    }

    public static String getJarFileName() {
        return "app.jar";
    }

    public static Context getServiceContext() {
        return mC;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f6725c.onBind(intent);
    }

    @Override // android.app.Service
    @SuppressLint({"NewApi"})
    public void onCreate() {
        mC = getApplicationContext();
        System.currentTimeMillis();
        this.f6724b = new com.baidu.location.c.a();
        try {
            File file = new File(j.h() + File.separator + replaceFileName);
            File file2 = new File(j.h() + File.separator + "app.jar");
            if (file.exists()) {
                if (file2.exists()) {
                    file2.delete();
                }
                file.renameTo(file2);
            }
            if (file2.exists()) {
                if (a(new File(j.h() + File.separator + "app.jar"))) {
                    this.f6723a = (LLSInterface) new DexClassLoader(j.h() + File.separator + "app.jar", j.h(), null, getClassLoader()).loadClass("com.baidu.serverLoc.LocationService").newInstance();
                }
            }
        } catch (Exception unused) {
            this.f6723a = null;
        }
        LLSInterface lLSInterface = this.f6723a;
        if (lLSInterface == null || lLSInterface.getVersion() < this.f6724b.getVersion()) {
            this.f6725c = this.f6724b;
            this.f6723a = null;
        } else {
            this.f6725c = this.f6723a;
            this.f6724b = null;
        }
        isServing = true;
        this.f6725c.onCreate(this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        isServing = false;
        this.f6725c.onDestroy();
        if (isStartedServing) {
            stopForeground(true);
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
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
        return this.f6725c.onStartCommand(intent, i, i2);
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        this.f6725c.onTaskRemoved(intent);
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        return this.f6725c.onUnBind(intent);
    }
}

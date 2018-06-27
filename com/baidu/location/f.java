package com.baidu.location;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.baidu.location.h.h;
import com.baidu.location.h.i;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.RandomAccessFile;
/* loaded from: classes2.dex */
public class f extends Service {
    private static final String jarFileName = "app.jar";
    public static String replaceFileName = "repll.jar";
    public static Context mC = null;
    public static boolean isServing = false;
    LLSInterface libJar = null;
    LLSInterface libNat = null;
    LLSInterface lib = null;

    public static float getFrameVersion() {
        return 6.23f;
    }

    public static String getJarFileName() {
        return jarFileName;
    }

    public static Context getServiceContext() {
        return mC;
    }

    private boolean readConf(File file) {
        int readInt;
        boolean z = false;
        try {
            File file2 = new File(h.a + "/grtcf.dat");
            if (file2.exists()) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
                randomAccessFile.seek(200L);
                if (randomAccessFile.readBoolean() && randomAccessFile.readBoolean() && (readInt = randomAccessFile.readInt()) != 0) {
                    byte[] bArr = new byte[readInt];
                    randomAccessFile.read(bArr, 0, readInt);
                    String str = new String(bArr);
                    String a = i.a(file);
                    if (str != null && a != null && a.equals(str)) {
                        z = true;
                    }
                }
                randomAccessFile.close();
            }
        } catch (Exception e) {
        }
        return z;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.lib.onBind(intent);
    }

    @Override // android.app.Service
    public void onCreate() {
        mC = getApplicationContext();
        System.currentTimeMillis();
        this.libNat = new com.baidu.location.g.a();
        try {
            File file = new File(i.g() + File.separator + replaceFileName);
            File file2 = new File(i.g() + File.separator + jarFileName);
            if (file.exists()) {
                if (file2.exists()) {
                    file2.delete();
                }
                file.renameTo(file2);
            }
            if (file2.exists()) {
                this.libJar = (LLSInterface) new DexClassLoader(i.g() + File.separator + jarFileName, i.g(), null, getClassLoader()).loadClass("com.baidu.serverLoc.LocationService").newInstance();
            }
        } catch (Exception e) {
            this.libJar = null;
        }
        if (this.libJar == null || this.libJar.getVersion() < this.libNat.getVersion() || !readConf(new File(i.g() + File.separator + jarFileName))) {
            this.lib = this.libNat;
            this.libJar = null;
        } else {
            this.lib = this.libJar;
            this.libNat = null;
        }
        isServing = true;
        this.lib.onCreate(this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        isServing = false;
        this.lib.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        return this.lib.onStartCommand(intent, i, i2);
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        return this.lib.onUnBind(intent);
    }
}

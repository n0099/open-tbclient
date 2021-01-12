package com.baidu.minivideo.arface.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Environment;
import com.baidu.tieba.ala.live.walletconfig.CashierData;
import java.io.File;
import java.util.Objects;
/* loaded from: classes5.dex */
public class e {
    private static e cgs;
    private File cgt;
    private File cgu;
    private File cgv;
    private File cgw;
    private File cgx;
    private File cgy;
    private File mSourceDir;

    public static e aas() {
        if (cgs == null) {
            createInst();
        }
        return cgs;
    }

    private static synchronized void createInst() {
        synchronized (e.class) {
            if (cgs == null) {
                cgs = new e();
            }
        }
    }

    public void init(Context context) {
        this.cgt = bD(context);
        this.cgu = bC(context);
        if (this.cgu == null) {
            this.cgu = this.cgt;
        }
        if (this.cgu != null) {
            this.cgw = new File(this.cgu, CashierData.SDK);
            this.mSourceDir = new File(this.cgw, "arsource");
            if (!this.mSourceDir.exists()) {
                this.mSourceDir.mkdirs();
            }
        }
        if (this.cgt != null) {
            this.cgv = new File(this.cgt, CashierData.SDK);
            this.cgx = new File(this.cgt, "sdklibs/armeabi-v7a");
            if (!this.cgx.exists()) {
                this.cgx.mkdirs();
            }
            this.cgy = new File(this.cgt, "sdklibs/armeabi-v7a-2");
            if (!this.cgy.exists()) {
                this.cgy.mkdirs();
            }
        }
    }

    public File aat() {
        return this.mSourceDir;
    }

    public File aau() {
        return this.cgw;
    }

    @SuppressLint({"NewApi"})
    public File bC(Context context) {
        if (!Environment.getExternalStorageState().equals("mounted")) {
            return null;
        }
        return ((Context) Objects.requireNonNull(context)).getExternalFilesDir("duar");
    }

    public static File bD(Context context) {
        File file = new File(context.getFilesDir(), "duar");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File aav() {
        return aas().cgx;
    }

    public static File aaw() {
        return aas().cgy;
    }
}

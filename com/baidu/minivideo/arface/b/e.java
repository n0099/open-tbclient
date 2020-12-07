package com.baidu.minivideo.arface.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Environment;
import com.baidu.tieba.ala.live.walletconfig.CashierData;
import java.io.File;
import java.util.Objects;
/* loaded from: classes8.dex */
public class e {
    private static e cev;
    private File ceA;
    private File ceB;
    private File cew;
    private File cex;
    private File cey;
    private File cez;
    private File mSourceDir;

    public static e acv() {
        if (cev == null) {
            createInst();
        }
        return cev;
    }

    private static synchronized void createInst() {
        synchronized (e.class) {
            if (cev == null) {
                cev = new e();
            }
        }
    }

    public void init(Context context) {
        this.cew = br(context);
        this.cex = bq(context);
        if (this.cex == null) {
            this.cex = this.cew;
        }
        if (this.cex != null) {
            this.cez = new File(this.cex, CashierData.SDK);
            this.mSourceDir = new File(this.cez, "arsource");
            if (!this.mSourceDir.exists()) {
                this.mSourceDir.mkdirs();
            }
        }
        if (this.cew != null) {
            this.cey = new File(this.cew, CashierData.SDK);
            this.ceA = new File(this.cew, "sdklibs/armeabi-v7a");
            if (!this.ceA.exists()) {
                this.ceA.mkdirs();
            }
            this.ceB = new File(this.cew, "sdklibs/armeabi-v7a-2");
            if (!this.ceB.exists()) {
                this.ceB.mkdirs();
            }
        }
    }

    public File acw() {
        return this.mSourceDir;
    }

    public File acx() {
        return this.cez;
    }

    @SuppressLint({"NewApi"})
    public File bq(Context context) {
        if (!Environment.getExternalStorageState().equals("mounted")) {
            return null;
        }
        return ((Context) Objects.requireNonNull(context)).getExternalFilesDir("duar");
    }

    public static File br(Context context) {
        File file = new File(context.getFilesDir(), "duar");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File acy() {
        return acv().ceA;
    }

    public static File acz() {
        return acv().ceB;
    }
}

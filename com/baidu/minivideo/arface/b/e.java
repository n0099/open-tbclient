package com.baidu.minivideo.arface.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Environment;
import com.baidu.tieba.ala.live.walletconfig.CashierData;
import java.io.File;
import java.util.Objects;
/* loaded from: classes3.dex */
public class e {
    private static e ckC;
    private File ckD;
    private File ckE;
    private File ckF;
    private File ckG;
    private File ckH;
    private File ckI;
    private File mSourceDir;

    public static e acg() {
        if (ckC == null) {
            createInst();
        }
        return ckC;
    }

    private static synchronized void createInst() {
        synchronized (e.class) {
            if (ckC == null) {
                ckC = new e();
            }
        }
    }

    public void init(Context context) {
        this.ckD = bG(context);
        this.ckE = bF(context);
        if (this.ckE == null) {
            this.ckE = this.ckD;
        }
        if (this.ckE != null) {
            this.ckG = new File(this.ckE, CashierData.SDK);
            this.mSourceDir = new File(this.ckG, "arsource");
            if (!this.mSourceDir.exists()) {
                this.mSourceDir.mkdirs();
            }
        }
        if (this.ckD != null) {
            this.ckF = new File(this.ckD, CashierData.SDK);
            this.ckH = new File(this.ckD, "sdklibs/armeabi-v7a");
            if (!this.ckH.exists()) {
                this.ckH.mkdirs();
            }
            this.ckI = new File(this.ckD, "sdklibs/armeabi-v7a-2");
            if (!this.ckI.exists()) {
                this.ckI.mkdirs();
            }
        }
    }

    public File ach() {
        return this.mSourceDir;
    }

    public File aci() {
        return this.ckG;
    }

    @SuppressLint({"NewApi"})
    public File bF(Context context) {
        if (!Environment.getExternalStorageState().equals("mounted")) {
            return null;
        }
        return ((Context) Objects.requireNonNull(context)).getExternalFilesDir("duar");
    }

    public static File bG(Context context) {
        File file = new File(context.getFilesDir(), "duar");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File acj() {
        return acg().ckH;
    }

    public static File ack() {
        return acg().ckI;
    }
}

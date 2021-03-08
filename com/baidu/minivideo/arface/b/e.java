package com.baidu.minivideo.arface.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Environment;
import com.baidu.tieba.ala.live.walletconfig.CashierData;
import java.io.File;
import java.util.Objects;
/* loaded from: classes5.dex */
public class e {
    private static e cmc;
    private File cme;
    private File cmf;
    private File cmg;
    private File cmh;
    private File cmi;
    private File cmj;
    private File mSourceDir;

    public static e acj() {
        if (cmc == null) {
            createInst();
        }
        return cmc;
    }

    private static synchronized void createInst() {
        synchronized (e.class) {
            if (cmc == null) {
                cmc = new e();
            }
        }
    }

    public void init(Context context) {
        this.cme = bF(context);
        this.cmf = bE(context);
        if (this.cmf == null) {
            this.cmf = this.cme;
        }
        if (this.cmf != null) {
            this.cmh = new File(this.cmf, CashierData.SDK);
            this.mSourceDir = new File(this.cmh, "arsource");
            if (!this.mSourceDir.exists()) {
                this.mSourceDir.mkdirs();
            }
        }
        if (this.cme != null) {
            this.cmg = new File(this.cme, CashierData.SDK);
            this.cmi = new File(this.cme, "sdklibs/armeabi-v7a");
            if (!this.cmi.exists()) {
                this.cmi.mkdirs();
            }
            this.cmj = new File(this.cme, "sdklibs/armeabi-v7a-2");
            if (!this.cmj.exists()) {
                this.cmj.mkdirs();
            }
        }
    }

    public File ack() {
        return this.mSourceDir;
    }

    public File acl() {
        return this.cmh;
    }

    @SuppressLint({"NewApi"})
    public File bE(Context context) {
        if (!Environment.getExternalStorageState().equals("mounted")) {
            return null;
        }
        return ((Context) Objects.requireNonNull(context)).getExternalFilesDir("duar");
    }

    public static File bF(Context context) {
        File file = new File(context.getFilesDir(), "duar");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File acm() {
        return acj().cmi;
    }

    public static File acn() {
        return acj().cmj;
    }
}

package com.baidu.minivideo.arface.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Environment;
import com.baidu.tieba.ala.live.walletconfig.CashierData;
import java.io.File;
import java.util.Objects;
/* loaded from: classes6.dex */
public class e {
    private static e clf;
    private File clg;
    private File clh;
    private File cli;
    private File clj;
    private File clk;
    private File cll;
    private File mSourceDir;

    public static e aek() {
        if (clf == null) {
            createInst();
        }
        return clf;
    }

    private static synchronized void createInst() {
        synchronized (e.class) {
            if (clf == null) {
                clf = new e();
            }
        }
    }

    public void init(Context context) {
        this.clg = bE(context);
        this.clh = bD(context);
        if (this.clh == null) {
            this.clh = this.clg;
        }
        if (this.clh != null) {
            this.clj = new File(this.clh, CashierData.SDK);
            this.mSourceDir = new File(this.clj, "arsource");
            if (!this.mSourceDir.exists()) {
                this.mSourceDir.mkdirs();
            }
        }
        if (this.clg != null) {
            this.cli = new File(this.clg, CashierData.SDK);
            this.clk = new File(this.clg, "sdklibs/armeabi-v7a");
            if (!this.clk.exists()) {
                this.clk.mkdirs();
            }
            this.cll = new File(this.clg, "sdklibs/armeabi-v7a-2");
            if (!this.cll.exists()) {
                this.cll.mkdirs();
            }
        }
    }

    public File ael() {
        return this.mSourceDir;
    }

    public File aem() {
        return this.clj;
    }

    @SuppressLint({"NewApi"})
    public File bD(Context context) {
        if (!Environment.getExternalStorageState().equals("mounted")) {
            return null;
        }
        return ((Context) Objects.requireNonNull(context)).getExternalFilesDir("duar");
    }

    public static File bE(Context context) {
        File file = new File(context.getFilesDir(), "duar");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File aen() {
        return aek().clk;
    }

    public static File aeo() {
        return aek().cll;
    }
}

package com.baidu.minivideo.arface.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.minivideo.arface.utils.g;
import java.io.File;
import java.util.Objects;
/* loaded from: classes6.dex */
public class b extends d {
    private static b cmm = null;
    private String cmj = "arsource";
    private File cmk;
    private Boolean cml;
    private Context mContext;

    public static final b aeH() {
        if (cmm == null) {
            createInst();
        }
        return cmm;
    }

    private static synchronized void createInst() {
        synchronized (b.class) {
            if (cmm == null) {
                cmm = new b();
            }
        }
    }

    @SuppressLint({"NewApi"})
    public void b(Context context, String str, File file) {
        this.mContext = ((Context) Objects.requireNonNull(context)).getApplicationContext();
        this.cmj = (String) Objects.requireNonNull(str);
        this.cmk = (File) Objects.requireNonNull(file);
        if (isDebug()) {
            log("init " + str + " to " + file.getAbsolutePath());
        }
    }

    @SuppressLint({"NewApi"})
    public void a(Context context, String str, File file, g.a aVar) {
        this.mContext = ((Context) Objects.requireNonNull(context)).getApplicationContext();
        this.cmj = (String) Objects.requireNonNull(str);
        this.cmk = (File) Objects.requireNonNull(file);
        if (isDebug()) {
            log("start " + str + " to " + file.getAbsolutePath());
        }
        super.a(aVar);
    }

    private String aeI() {
        return this.cmj;
    }

    private File aeJ() {
        if (this.cmk == null && com.baidu.minivideo.arface.b.adN() != null && !TextUtils.isEmpty(com.baidu.minivideo.arface.c.adV())) {
            this.cmk = new File(com.baidu.minivideo.arface.c.adV());
        }
        return this.cmk;
    }

    public boolean isValid() {
        if (this.cml != null) {
            return this.cml.booleanValue();
        }
        String aeI = aeI();
        File aeJ = aeJ();
        if (isDebug()) {
            log(String.format("from %s to %s ", aeI, aeJ));
        }
        String t = (aeJ != null && aeJ.exists() && aeJ.isDirectory()) ? f.t(new File(aeJ, "version")) : null;
        String Q = TextUtils.isEmpty(t) ? null : f.Q(this.mContext, aeI + "/version");
        if (isDebug()) {
            log("assets=" + Q + ", sdcard=" + t);
        }
        boolean z = TextUtils.isEmpty(t) || !TextUtils.equals(t, Q);
        this.cml = Boolean.valueOf(!z);
        return !z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bG(Context context) {
        boolean z = true;
        if (!isValid()) {
            z = c(context, aeI(), aeJ());
        }
        if (z) {
            this.cml = null;
            setState(2);
        }
        if (isDebug()) {
            log("arVersion=" + com.baidu.minivideo.arface.b.getVersion() + ", arVersionName=" + com.baidu.minivideo.arface.b.getVersionName());
        }
    }

    private boolean c(Context context, String str, File file) {
        if (file.isDirectory()) {
            f.deleteDir(file);
        } else {
            f.r(file);
        }
        File file2 = new File(file + ".loading");
        boolean assetToSD = new c(context).assetToSD(str, file2);
        if (isDebug()) {
            log(assetToSD + " assetsToSD " + file2.getAbsolutePath());
        }
        if (assetToSD) {
            assetToSD = file2.renameTo(file);
        }
        if (isDebug()) {
            log(assetToSD + " renameTo " + file);
        }
        if (!assetToSD) {
            log("del temp ...");
            f.deleteDir(file2);
            if (file.exists()) {
                log("del " + file);
                f.deleteDir(file);
            }
        }
        return assetToSD;
    }

    @Override // com.baidu.minivideo.arface.utils.d
    public void run() {
        ThreadPool.aeL().execute(new Runnable() { // from class: com.baidu.minivideo.arface.utils.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.bG(b.this.mContext);
            }
        });
    }

    private void log(String str) {
        Log.d("DuAr_AssetsLoader", str);
    }

    private boolean isDebug() {
        return com.baidu.minivideo.arface.b.isDebug();
    }
}

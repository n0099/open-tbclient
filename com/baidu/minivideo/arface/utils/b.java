package com.baidu.minivideo.arface.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.minivideo.arface.utils.g;
import java.io.File;
import java.util.Objects;
/* loaded from: classes5.dex */
public class b extends d {
    private static b cno = null;
    private String cnl = "arsource";
    private File cnm;
    private Boolean cnn;
    private Context mContext;

    public static final b acF() {
        if (cno == null) {
            createInst();
        }
        return cno;
    }

    private static synchronized void createInst() {
        synchronized (b.class) {
            if (cno == null) {
                cno = new b();
            }
        }
    }

    @SuppressLint({"NewApi"})
    public void b(Context context, String str, File file) {
        this.mContext = ((Context) Objects.requireNonNull(context)).getApplicationContext();
        this.cnl = (String) Objects.requireNonNull(str);
        this.cnm = (File) Objects.requireNonNull(file);
        if (isDebug()) {
            log("init " + str + " to " + file.getAbsolutePath());
        }
    }

    @SuppressLint({"NewApi"})
    public void a(Context context, String str, File file, g.a aVar) {
        this.mContext = ((Context) Objects.requireNonNull(context)).getApplicationContext();
        this.cnl = (String) Objects.requireNonNull(str);
        this.cnm = (File) Objects.requireNonNull(file);
        if (isDebug()) {
            log("start " + str + " to " + file.getAbsolutePath());
        }
        super.a(aVar);
    }

    private String acG() {
        return this.cnl;
    }

    private File acH() {
        if (this.cnm == null && com.baidu.minivideo.arface.b.abL() != null && !TextUtils.isEmpty(com.baidu.minivideo.arface.c.abT())) {
            this.cnm = new File(com.baidu.minivideo.arface.c.abT());
        }
        return this.cnm;
    }

    public boolean isValid() {
        if (this.cnn != null) {
            return this.cnn.booleanValue();
        }
        String acG = acG();
        File acH = acH();
        if (isDebug()) {
            log(String.format("from %s to %s ", acG, acH));
        }
        String s = (acH != null && acH.exists() && acH.isDirectory()) ? f.s(new File(acH, "version")) : null;
        String Q = TextUtils.isEmpty(s) ? null : f.Q(this.mContext, acG + "/version");
        if (isDebug()) {
            log("assets=" + Q + ", sdcard=" + s);
        }
        boolean z = TextUtils.isEmpty(s) || !TextUtils.equals(s, Q);
        this.cnn = Boolean.valueOf(!z);
        return !z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bH(Context context) {
        boolean z = true;
        if (!isValid()) {
            z = c(context, acG(), acH());
        }
        if (z) {
            this.cnn = null;
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
            f.q(file);
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
        ThreadPool.acJ().execute(new Runnable() { // from class: com.baidu.minivideo.arface.utils.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.bH(b.this.mContext);
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

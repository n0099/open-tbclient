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
    private static b chy = null;
    private String chv = "arsource";
    private File chw;
    private Boolean chx;
    private Context mContext;

    public static final b aaO() {
        if (chy == null) {
            createInst();
        }
        return chy;
    }

    private static synchronized void createInst() {
        synchronized (b.class) {
            if (chy == null) {
                chy = new b();
            }
        }
    }

    @SuppressLint({"NewApi"})
    public void b(Context context, String str, File file) {
        this.mContext = ((Context) Objects.requireNonNull(context)).getApplicationContext();
        this.chv = (String) Objects.requireNonNull(str);
        this.chw = (File) Objects.requireNonNull(file);
        if (isDebug()) {
            log("init " + str + " to " + file.getAbsolutePath());
        }
    }

    @SuppressLint({"NewApi"})
    public void a(Context context, String str, File file, g.a aVar) {
        this.mContext = ((Context) Objects.requireNonNull(context)).getApplicationContext();
        this.chv = (String) Objects.requireNonNull(str);
        this.chw = (File) Objects.requireNonNull(file);
        if (isDebug()) {
            log("start " + str + " to " + file.getAbsolutePath());
        }
        super.a(aVar);
    }

    private String aaP() {
        return this.chv;
    }

    private File aaQ() {
        if (this.chw == null && com.baidu.minivideo.arface.b.ZU() != null && !TextUtils.isEmpty(com.baidu.minivideo.arface.c.aac())) {
            this.chw = new File(com.baidu.minivideo.arface.c.aac());
        }
        return this.chw;
    }

    public boolean isValid() {
        if (this.chx != null) {
            return this.chx.booleanValue();
        }
        String aaP = aaP();
        File aaQ = aaQ();
        if (isDebug()) {
            log(String.format("from %s to %s ", aaP, aaQ));
        }
        String s = (aaQ != null && aaQ.exists() && aaQ.isDirectory()) ? f.s(new File(aaQ, "version")) : null;
        String Q = TextUtils.isEmpty(s) ? null : f.Q(this.mContext, aaP + "/version");
        if (isDebug()) {
            log("assets=" + Q + ", sdcard=" + s);
        }
        boolean z = TextUtils.isEmpty(s) || !TextUtils.equals(s, Q);
        this.chx = Boolean.valueOf(!z);
        return !z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bF(Context context) {
        boolean z = true;
        if (!isValid()) {
            z = c(context, aaP(), aaQ());
        }
        if (z) {
            this.chx = null;
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
        ThreadPool.aaS().execute(new Runnable() { // from class: com.baidu.minivideo.arface.utils.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.bF(b.this.mContext);
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

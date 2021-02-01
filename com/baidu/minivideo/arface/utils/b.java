package com.baidu.minivideo.arface.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.minivideo.arface.utils.g;
import java.io.File;
import java.util.Objects;
/* loaded from: classes3.dex */
public class b extends d {
    private static b clN = null;
    private String clK = "arsource";
    private File clL;
    private Boolean clM;
    private Context mContext;

    public static final b acC() {
        if (clN == null) {
            createInst();
        }
        return clN;
    }

    private static synchronized void createInst() {
        synchronized (b.class) {
            if (clN == null) {
                clN = new b();
            }
        }
    }

    @SuppressLint({"NewApi"})
    public void b(Context context, String str, File file) {
        this.mContext = ((Context) Objects.requireNonNull(context)).getApplicationContext();
        this.clK = (String) Objects.requireNonNull(str);
        this.clL = (File) Objects.requireNonNull(file);
        if (isDebug()) {
            log("init " + str + " to " + file.getAbsolutePath());
        }
    }

    @SuppressLint({"NewApi"})
    public void a(Context context, String str, File file, g.a aVar) {
        this.mContext = ((Context) Objects.requireNonNull(context)).getApplicationContext();
        this.clK = (String) Objects.requireNonNull(str);
        this.clL = (File) Objects.requireNonNull(file);
        if (isDebug()) {
            log("start " + str + " to " + file.getAbsolutePath());
        }
        super.a(aVar);
    }

    private String acD() {
        return this.clK;
    }

    private File acE() {
        if (this.clL == null && com.baidu.minivideo.arface.b.abI() != null && !TextUtils.isEmpty(com.baidu.minivideo.arface.c.abQ())) {
            this.clL = new File(com.baidu.minivideo.arface.c.abQ());
        }
        return this.clL;
    }

    public boolean isValid() {
        if (this.clM != null) {
            return this.clM.booleanValue();
        }
        String acD = acD();
        File acE = acE();
        if (isDebug()) {
            log(String.format("from %s to %s ", acD, acE));
        }
        String s = (acE != null && acE.exists() && acE.isDirectory()) ? f.s(new File(acE, "version")) : null;
        String Q = TextUtils.isEmpty(s) ? null : f.Q(this.mContext, acD + "/version");
        if (isDebug()) {
            log("assets=" + Q + ", sdcard=" + s);
        }
        boolean z = TextUtils.isEmpty(s) || !TextUtils.equals(s, Q);
        this.clM = Boolean.valueOf(!z);
        return !z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bI(Context context) {
        boolean z = true;
        if (!isValid()) {
            z = c(context, acD(), acE());
        }
        if (z) {
            this.clM = null;
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
        ThreadPool.acG().execute(new Runnable() { // from class: com.baidu.minivideo.arface.utils.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.bI(b.this.mContext);
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

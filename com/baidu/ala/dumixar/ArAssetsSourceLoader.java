package com.baidu.ala.dumixar;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.minivideo.arface.b;
import com.baidu.minivideo.arface.utils.ThreadPool;
import com.baidu.minivideo.arface.utils.c;
import com.baidu.minivideo.arface.utils.e;
import com.baidu.minivideo.arface.utils.f;
import java.io.File;
import java.util.Objects;
/* loaded from: classes15.dex */
public class ArAssetsSourceLoader extends c {
    private static final String TAG = "ArAssetsSource";
    private static ArAssetsSourceLoader sInst = null;
    private String mAssetsPath = "arsource";
    private Context mContext;
    private Boolean mIsSourceValidCache;
    private File mSDcardFile;

    public static final ArAssetsSourceLoader getInst() {
        if (sInst == null) {
            createInst();
        }
        return sInst;
    }

    private static synchronized void createInst() {
        synchronized (ArAssetsSourceLoader.class) {
            if (sInst == null) {
                sInst = new ArAssetsSourceLoader();
            }
        }
    }

    public void start(Context context, String str, File file, f.a aVar) {
        this.mContext = ((Context) Objects.requireNonNull(context)).getApplicationContext();
        this.mAssetsPath = (String) Objects.requireNonNull(str);
        this.mSDcardFile = (File) Objects.requireNonNull(file);
        if (isDebug()) {
            log("start " + str + " to " + file.getAbsolutePath());
        }
        super.start(aVar);
    }

    private String getAssetsPath() {
        return this.mAssetsPath;
    }

    private File getSDcardPath() {
        return this.mSDcardFile;
    }

    public boolean isValid() {
        if (this.mIsSourceValidCache != null) {
            return this.mIsSourceValidCache.booleanValue();
        }
        String assetsPath = getAssetsPath();
        File sDcardPath = getSDcardPath();
        if (isDebug()) {
            log(String.format("from %s to %s ", assetsPath, sDcardPath));
        }
        String q = (sDcardPath != null && sDcardPath.exists() && sDcardPath.isDirectory()) ? e.q(new File(sDcardPath, "version")) : null;
        String I = TextUtils.isEmpty(q) ? null : e.I(this.mContext, assetsPath + "/version");
        if (isDebug()) {
            log("assets=" + I + ", sdcard=" + q);
        }
        boolean z = TextUtils.isEmpty(q) || !TextUtils.equals(q, I);
        this.mIsSourceValidCache = Boolean.valueOf(!z);
        return !z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadArAssetsSource(Context context) {
        boolean z = true;
        if (!isValid()) {
            z = doAssetToSD(context, getAssetsPath(), getSDcardPath());
        }
        if (z) {
            setState(2);
        }
        if (isDebug()) {
            log("arVersion=" + b.getVersion() + ", arVersionName=" + b.getVersionName());
        }
    }

    private boolean doAssetToSD(Context context, String str, File file) {
        if (file.isDirectory()) {
            e.deleteDir(file);
        } else {
            e.o(file);
        }
        File file2 = new File(file + ".loading");
        boolean assetToSD = new Assets2Sdcard(context).assetToSD(str, file2);
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
            e.deleteDir(file2);
            if (file.exists()) {
                log("del " + file);
                e.deleteDir(file);
            }
        }
        return assetToSD;
    }

    @Override // com.baidu.minivideo.arface.utils.c
    public void run() {
        ThreadPool.ZG().execute(new Runnable() { // from class: com.baidu.ala.dumixar.ArAssetsSourceLoader.1
            @Override // java.lang.Runnable
            public void run() {
                ArAssetsSourceLoader.this.loadArAssetsSource(ArAssetsSourceLoader.this.mContext);
            }
        });
    }

    private void log(String str) {
        Log.d(TAG, str);
    }

    private boolean isDebug() {
        return b.isDebug();
    }
}

package com.baidu.minivideo.arface.b;

import android.content.Context;
import android.util.Log;
import com.baidu.haokan.soloader.sopathadder.SysSoLoaderUtils;
import com.baidu.minivideo.arface.b.j;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class b {
    private static String ckO = "def";
    private i ckP;
    private String ckQ;
    private List<j> ckR;
    private List<j> ckS;
    d ckT;
    d ckU;
    private j ckV;
    private j.b ckW;
    private Boolean ckX;
    private j.b ckY;
    private Context mContext;
    private boolean mIsLoading;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class a {
        private static final b cla = new b();
    }

    public static final b jH(String str) {
        ckO = str;
        return a.cla;
    }

    private b() {
        this.ckR = new ArrayList();
        this.ckS = null;
        this.ckY = new j.b<j>() { // from class: com.baidu.minivideo.arface.b.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.minivideo.arface.b.j.b
            /* renamed from: a */
            public void e(j jVar, String str) {
                b.this.ckS.remove(jVar);
                b.this.ckR.add(jVar);
                if (jVar == b.this.ckV) {
                    b.this.ckP.d(b.ckO, b.this.ckV.getLocalFile());
                }
                if (b.this.isLoaded()) {
                    b.this.onCompleted();
                }
                super.e(jVar, str);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.minivideo.arface.b.j.b
            public void a(j jVar, Exception exc) {
                super.a((AnonymousClass1) jVar, exc);
                b.this.onFailed();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.minivideo.arface.b.j.b
            public void a(j jVar, long j, long j2, int i) {
                super.a((AnonymousClass1) jVar, j, j2, i);
                int progress = b.this.getProgress();
                if (b.this.ckW != null) {
                    b.this.ckW.a(b.this, 0L, 100L, progress);
                }
            }
        };
        this.ckP = new i(e.aek().aem());
        this.ckP.jL(ckO);
        aec();
    }

    public boolean isLoaded() {
        return this.ckR.size() > 0 && (this.ckS == null || this.ckS.size() == 0);
    }

    public boolean bB(Context context) {
        if (this.ckX != null && this.ckX.booleanValue()) {
            return this.ckX.booleanValue();
        }
        this.ckX = false;
        long currentTimeMillis = System.currentTimeMillis();
        boolean bC = bC(context);
        if (isDebug()) {
            d("loadSo " + bC);
        }
        if (!bC) {
            return this.ckX.booleanValue();
        }
        boolean adC = com.baidu.minivideo.arface.a.adC();
        if (isDebug()) {
            d("ARControllerProxy.loadSoFile " + adC);
        }
        if (!adC) {
            return this.ckX.booleanValue();
        }
        File file = this.ckU.cld;
        if (isDebug()) {
            d("setResConfig " + file);
        }
        if (file != null) {
            com.baidu.minivideo.arface.b.a(new com.baidu.minivideo.arface.c(file.getAbsolutePath()));
        }
        if (isDebug()) {
            d("initRecource costMS: " + (System.currentTimeMillis() - currentTimeMillis));
        }
        this.ckX = true;
        return this.ckX.booleanValue();
    }

    public File aea() {
        return this.ckU.cld;
    }

    public File aeb() {
        return this.ckT.cld;
    }

    public boolean bC(Context context) {
        if (SysSoLoaderUtils.containsNativeDir(context, this.ckT.cld)) {
            return true;
        }
        SysSoLoaderUtils.addNativeDir(context, this.ckT.cld);
        return SysSoLoaderUtils.containsNativeDir(context, this.ckT.cld);
    }

    public void a(Context context, j.b<b> bVar) {
        this.mContext = context;
        this.ckW = bVar;
        synchronized (this) {
            if (this.mIsLoading) {
                if (isDebug()) {
                    d("start return, isLoading true");
                }
                return;
            }
            this.mIsLoading = true;
            aec();
            onStart();
        }
    }

    private void aec() {
        this.ckR.clear();
        if (this.ckS != null) {
            this.ckS.clear();
        }
        this.ckT = d.aee();
        this.ckU = d.aef();
        this.ckV = new c(this.ckU);
        a(this.ckV);
        a(new c(this.ckT));
    }

    private void a(j jVar) {
        boolean isLoaded = jVar.isLoaded();
        if (isDebug()) {
            d("isLoaded " + isLoaded + ", " + jVar.getUrl() + " to " + jVar.getLocalFile());
        }
        if (jVar.isLoaded()) {
            this.ckR.add(jVar);
            return;
        }
        if (this.ckS == null) {
            this.ckS = new ArrayList();
        }
        this.ckS.add(jVar);
    }

    private boolean isDebug() {
        return com.baidu.minivideo.arface.b.isDebug();
    }

    private void onStart() {
        this.ckQ = this.ckP.jJ(ckO);
        if (this.ckS != null && this.ckS.size() > 0) {
            for (j jVar : this.ckS) {
                jVar.a(this.ckY);
            }
            return;
        }
        onCompleted();
    }

    protected void onCompleted() {
        boolean bB = bB(this.mContext);
        this.ckP.jK(this.ckQ);
        this.ckP.aeu();
        if (isDebug()) {
            d("all onCompleted " + bB);
        }
        synchronized (this) {
            this.mIsLoading = false;
        }
        if (this.ckW != null && bB) {
            String str = null;
            if (this.ckU != null && this.ckU.cld != null) {
                str = this.ckU.cld.getAbsolutePath();
            }
            this.ckW.e(this, str);
        }
    }

    protected void onFailed() {
        if (isDebug()) {
            d("all onFailed .");
        }
        synchronized (this) {
            this.mIsLoading = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getProgress() {
        float f;
        float f2 = 0.0f;
        if (this.ckS == null || this.ckS.size() == 0) {
            f = 100.0f;
        } else {
            float size = 100.0f / (this.ckR.size() + this.ckS.size());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.ckS.size()) {
                    break;
                }
                f2 += (this.ckS.get(i2).getProgress() / 100.0f) * size;
                i = i2 + 1;
            }
            f = (this.ckR.size() * size) + f2;
        }
        return (int) f;
    }

    private static void d(String str) {
        Log.d("DuAr_InitModel", str);
    }
}

package com.baidu.minivideo.arface.b;

import android.content.Context;
import android.util.Log;
import com.baidu.haokan.soloader.sopathadder.SysSoLoaderUtils;
import com.baidu.minivideo.arface.b.j;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    private static String ckl = "def";
    private i ckm;
    private String ckn;
    private List<j> cko;
    private List<j> ckp;
    d ckq;
    d ckr;
    private j cks;
    private j.b ckt;
    private Boolean cku;
    private j.b ckv;
    private Context mContext;
    private boolean mIsLoading;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class a {
        private static final b ckx = new b();
    }

    public static final b jc(String str) {
        ckl = str;
        return a.ckx;
    }

    private b() {
        this.cko = new ArrayList();
        this.ckp = null;
        this.ckv = new j.b<j>() { // from class: com.baidu.minivideo.arface.b.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.minivideo.arface.b.j.b
            /* renamed from: a */
            public void e(j jVar, String str) {
                b.this.ckp.remove(jVar);
                b.this.cko.add(jVar);
                if (jVar == b.this.cks) {
                    b.this.ckm.d(b.ckl, b.this.cks.getLocalFile());
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
                if (b.this.ckt != null) {
                    b.this.ckt.a(b.this, 0L, 100L, progress);
                }
            }
        };
        this.ckm = new i(e.acg().aci());
        this.ckm.jg(ckl);
        abY();
    }

    public boolean isLoaded() {
        return this.cko.size() > 0 && (this.ckp == null || this.ckp.size() == 0);
    }

    public boolean bD(Context context) {
        if (this.cku != null && this.cku.booleanValue()) {
            return this.cku.booleanValue();
        }
        this.cku = false;
        long currentTimeMillis = System.currentTimeMillis();
        boolean bE = bE(context);
        if (isDebug()) {
            d("loadSo " + bE);
        }
        if (!bE) {
            return this.cku.booleanValue();
        }
        boolean abz = com.baidu.minivideo.arface.a.abz();
        if (isDebug()) {
            d("ARControllerProxy.loadSoFile " + abz);
        }
        if (!abz) {
            return this.cku.booleanValue();
        }
        File file = this.ckr.ckA;
        if (isDebug()) {
            d("setResConfig " + file);
        }
        if (file != null) {
            com.baidu.minivideo.arface.b.a(new com.baidu.minivideo.arface.c(file.getAbsolutePath()));
        }
        if (isDebug()) {
            d("initRecource costMS: " + (System.currentTimeMillis() - currentTimeMillis));
        }
        this.cku = true;
        return this.cku.booleanValue();
    }

    public File abW() {
        return this.ckr.ckA;
    }

    public File abX() {
        return this.ckq.ckA;
    }

    public boolean bE(Context context) {
        if (SysSoLoaderUtils.containsNativeDir(context, this.ckq.ckA)) {
            return true;
        }
        SysSoLoaderUtils.addNativeDir(context, this.ckq.ckA);
        return SysSoLoaderUtils.containsNativeDir(context, this.ckq.ckA);
    }

    public void a(Context context, j.b<b> bVar) {
        this.mContext = context;
        this.ckt = bVar;
        synchronized (this) {
            if (this.mIsLoading) {
                if (isDebug()) {
                    d("start return, isLoading true");
                }
                return;
            }
            this.mIsLoading = true;
            abY();
            onStart();
        }
    }

    private void abY() {
        this.cko.clear();
        if (this.ckp != null) {
            this.ckp.clear();
        }
        this.ckq = d.aca();
        this.ckr = d.acb();
        this.cks = new c(this.ckr);
        a(this.cks);
        a(new c(this.ckq));
    }

    private void a(j jVar) {
        boolean isLoaded = jVar.isLoaded();
        if (isDebug()) {
            d("isLoaded " + isLoaded + ", " + jVar.getUrl() + " to " + jVar.getLocalFile());
        }
        if (jVar.isLoaded()) {
            this.cko.add(jVar);
            return;
        }
        if (this.ckp == null) {
            this.ckp = new ArrayList();
        }
        this.ckp.add(jVar);
    }

    private boolean isDebug() {
        return com.baidu.minivideo.arface.b.isDebug();
    }

    private void onStart() {
        this.ckn = this.ckm.je(ckl);
        if (this.ckp != null && this.ckp.size() > 0) {
            for (j jVar : this.ckp) {
                jVar.a(this.ckv);
            }
            return;
        }
        onCompleted();
    }

    protected void onCompleted() {
        boolean bD = bD(this.mContext);
        this.ckm.jf(this.ckn);
        this.ckm.acq();
        if (isDebug()) {
            d("all onCompleted " + bD);
        }
        synchronized (this) {
            this.mIsLoading = false;
        }
        if (this.ckt != null && bD) {
            String str = null;
            if (this.ckr != null && this.ckr.ckA != null) {
                str = this.ckr.ckA.getAbsolutePath();
            }
            this.ckt.e(this, str);
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
        if (this.ckp == null || this.ckp.size() == 0) {
            f = 100.0f;
        } else {
            float size = 100.0f / (this.cko.size() + this.ckp.size());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.ckp.size()) {
                    break;
                }
                f2 += (this.ckp.get(i2).getProgress() / 100.0f) * size;
                i = i2 + 1;
            }
            f = (this.cko.size() * size) + f2;
        }
        return (int) f;
    }

    private static void d(String str) {
        Log.d("DuAr_InitModel", str);
    }
}

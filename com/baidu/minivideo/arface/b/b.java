package com.baidu.minivideo.arface.b;

import android.content.Context;
import android.util.Log;
import com.baidu.haokan.soloader.sopathadder.SysSoLoaderUtils;
import com.baidu.minivideo.arface.b.j;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class b {
    private static String cgb = "def";
    private i cgc;
    private String cgd;
    private List<j> cge;
    private List<j> cgf;
    d cgg;
    d cgh;
    private j cgi;
    private j.b cgj;
    private Boolean cgk;
    private j.b cgl;
    private Context mContext;
    private boolean mIsLoading;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class a {
        private static final b cgn = new b();
    }

    public static final b iw(String str) {
        cgb = str;
        return a.cgn;
    }

    private b() {
        this.cge = new ArrayList();
        this.cgf = null;
        this.cgl = new j.b<j>() { // from class: com.baidu.minivideo.arface.b.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.minivideo.arface.b.j.b
            /* renamed from: a */
            public void e(j jVar, String str) {
                b.this.cgf.remove(jVar);
                b.this.cge.add(jVar);
                if (jVar == b.this.cgi) {
                    b.this.cgc.d(b.cgb, b.this.cgi.getLocalFile());
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
                if (b.this.cgj != null) {
                    b.this.cgj.a(b.this, 0L, 100L, progress);
                }
            }
        };
        this.cgc = new i(e.aas().aau());
        this.cgc.iA(cgb);
        aak();
    }

    public boolean isLoaded() {
        return this.cge.size() > 0 && (this.cgf == null || this.cgf.size() == 0);
    }

    public boolean bA(Context context) {
        if (this.cgk != null && this.cgk.booleanValue()) {
            return this.cgk.booleanValue();
        }
        this.cgk = false;
        long currentTimeMillis = System.currentTimeMillis();
        boolean bB = bB(context);
        if (isDebug()) {
            d("loadSo " + bB);
        }
        if (!bB) {
            return this.cgk.booleanValue();
        }
        boolean ZK = com.baidu.minivideo.arface.a.ZK();
        if (isDebug()) {
            d("ARControllerProxy.loadSoFile " + ZK);
        }
        if (!ZK) {
            return this.cgk.booleanValue();
        }
        File file = this.cgh.cgq;
        if (isDebug()) {
            d("setResConfig " + file);
        }
        if (file != null) {
            com.baidu.minivideo.arface.b.a(new com.baidu.minivideo.arface.c(file.getAbsolutePath()));
        }
        if (isDebug()) {
            d("initRecource costMS: " + (System.currentTimeMillis() - currentTimeMillis));
        }
        this.cgk = true;
        return this.cgk.booleanValue();
    }

    public File aai() {
        return this.cgh.cgq;
    }

    public File aaj() {
        return this.cgg.cgq;
    }

    public boolean bB(Context context) {
        if (SysSoLoaderUtils.containsNativeDir(context, this.cgg.cgq)) {
            return true;
        }
        SysSoLoaderUtils.addNativeDir(context, this.cgg.cgq);
        return SysSoLoaderUtils.containsNativeDir(context, this.cgg.cgq);
    }

    public void a(Context context, j.b<b> bVar) {
        this.mContext = context;
        this.cgj = bVar;
        synchronized (this) {
            if (this.mIsLoading) {
                if (isDebug()) {
                    d("start return, isLoading true");
                }
                return;
            }
            this.mIsLoading = true;
            aak();
            onStart();
        }
    }

    private void aak() {
        this.cge.clear();
        if (this.cgf != null) {
            this.cgf.clear();
        }
        this.cgg = d.aam();
        this.cgh = d.aan();
        this.cgi = new c(this.cgh);
        a(this.cgi);
        a(new c(this.cgg));
    }

    private void a(j jVar) {
        boolean isLoaded = jVar.isLoaded();
        if (isDebug()) {
            d("isLoaded " + isLoaded + ", " + jVar.getUrl() + " to " + jVar.getLocalFile());
        }
        if (jVar.isLoaded()) {
            this.cge.add(jVar);
            return;
        }
        if (this.cgf == null) {
            this.cgf = new ArrayList();
        }
        this.cgf.add(jVar);
    }

    private boolean isDebug() {
        return com.baidu.minivideo.arface.b.isDebug();
    }

    private void onStart() {
        this.cgd = this.cgc.iy(cgb);
        if (this.cgf != null && this.cgf.size() > 0) {
            for (j jVar : this.cgf) {
                jVar.a(this.cgl);
            }
            return;
        }
        onCompleted();
    }

    protected void onCompleted() {
        boolean bA = bA(this.mContext);
        this.cgc.iz(this.cgd);
        this.cgc.aaC();
        if (isDebug()) {
            d("all onCompleted " + bA);
        }
        synchronized (this) {
            this.mIsLoading = false;
        }
        if (this.cgj != null && bA) {
            String str = null;
            if (this.cgh != null && this.cgh.cgq != null) {
                str = this.cgh.cgq.getAbsolutePath();
            }
            this.cgj.e(this, str);
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
        if (this.cgf == null || this.cgf.size() == 0) {
            f = 100.0f;
        } else {
            float size = 100.0f / (this.cge.size() + this.cgf.size());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.cgf.size()) {
                    break;
                }
                f2 += (this.cgf.get(i2).getProgress() / 100.0f) * size;
                i = i2 + 1;
            }
            f = (this.cge.size() * size) + f2;
        }
        return (int) f;
    }

    private static void d(String str) {
        Log.d("DuAr_InitModel", str);
    }
}

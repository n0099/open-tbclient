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
    private static String clL = "def";
    private i clM;
    private String clN;
    private List<j> clO;
    private List<j> clP;
    d clQ;
    d clR;
    private j clS;
    private j.b clT;
    private Boolean clU;
    private j.b clV;
    private Context mContext;
    private boolean mIsLoading;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class a {
        private static final b clX = new b();
    }

    public static final b ji(String str) {
        clL = str;
        return a.clX;
    }

    private b() {
        this.clO = new ArrayList();
        this.clP = null;
        this.clV = new j.b<j>() { // from class: com.baidu.minivideo.arface.b.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.minivideo.arface.b.j.b
            /* renamed from: a */
            public void f(j jVar, String str) {
                b.this.clP.remove(jVar);
                b.this.clO.add(jVar);
                if (jVar == b.this.clS) {
                    b.this.clM.d(b.clL, b.this.clS.getLocalFile());
                }
                if (b.this.isLoaded()) {
                    b.this.onCompleted();
                }
                super.f(jVar, str);
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
                if (b.this.clT != null) {
                    b.this.clT.a(b.this, 0L, 100L, progress);
                }
            }
        };
        this.clM = new i(e.acj().acl());
        this.clM.jm(clL);
        acb();
    }

    public boolean isLoaded() {
        return this.clO.size() > 0 && (this.clP == null || this.clP.size() == 0);
    }

    public boolean bC(Context context) {
        if (this.clU != null && this.clU.booleanValue()) {
            return this.clU.booleanValue();
        }
        this.clU = false;
        long currentTimeMillis = System.currentTimeMillis();
        boolean bD = bD(context);
        if (isDebug()) {
            d("loadSo " + bD);
        }
        if (!bD) {
            return this.clU.booleanValue();
        }
        boolean abC = com.baidu.minivideo.arface.a.abC();
        if (isDebug()) {
            d("ARControllerProxy.loadSoFile " + abC);
        }
        if (!abC) {
            return this.clU.booleanValue();
        }
        File file = this.clR.cma;
        if (isDebug()) {
            d("setResConfig " + file);
        }
        if (file != null) {
            com.baidu.minivideo.arface.b.a(new com.baidu.minivideo.arface.c(file.getAbsolutePath()));
        }
        if (isDebug()) {
            d("initRecource costMS: " + (System.currentTimeMillis() - currentTimeMillis));
        }
        this.clU = true;
        return this.clU.booleanValue();
    }

    public File abZ() {
        return this.clR.cma;
    }

    public File aca() {
        return this.clQ.cma;
    }

    public boolean bD(Context context) {
        if (SysSoLoaderUtils.containsNativeDir(context, this.clQ.cma)) {
            return true;
        }
        SysSoLoaderUtils.addNativeDir(context, this.clQ.cma);
        return SysSoLoaderUtils.containsNativeDir(context, this.clQ.cma);
    }

    public void a(Context context, j.b<b> bVar) {
        this.mContext = context;
        this.clT = bVar;
        synchronized (this) {
            if (this.mIsLoading) {
                if (isDebug()) {
                    d("start return, isLoading true");
                }
                return;
            }
            this.mIsLoading = true;
            acb();
            onStart();
        }
    }

    private void acb() {
        this.clO.clear();
        if (this.clP != null) {
            this.clP.clear();
        }
        this.clQ = d.acd();
        this.clR = d.ace();
        this.clS = new c(this.clR);
        a(this.clS);
        a(new c(this.clQ));
    }

    private void a(j jVar) {
        boolean isLoaded = jVar.isLoaded();
        if (isDebug()) {
            d("isLoaded " + isLoaded + ", " + jVar.getUrl() + " to " + jVar.getLocalFile());
        }
        if (jVar.isLoaded()) {
            this.clO.add(jVar);
            return;
        }
        if (this.clP == null) {
            this.clP = new ArrayList();
        }
        this.clP.add(jVar);
    }

    private boolean isDebug() {
        return com.baidu.minivideo.arface.b.isDebug();
    }

    private void onStart() {
        this.clN = this.clM.jk(clL);
        if (this.clP != null && this.clP.size() > 0) {
            for (j jVar : this.clP) {
                jVar.a(this.clV);
            }
            return;
        }
        onCompleted();
    }

    protected void onCompleted() {
        boolean bC = bC(this.mContext);
        this.clM.jl(this.clN);
        this.clM.act();
        if (isDebug()) {
            d("all onCompleted " + bC);
        }
        synchronized (this) {
            this.mIsLoading = false;
        }
        if (this.clT != null && bC) {
            String str = null;
            if (this.clR != null && this.clR.cma != null) {
                str = this.clR.cma.getAbsolutePath();
            }
            this.clT.f(this, str);
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
        if (this.clP == null || this.clP.size() == 0) {
            f = 100.0f;
        } else {
            float size = 100.0f / (this.clO.size() + this.clP.size());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.clP.size()) {
                    break;
                }
                f2 += (this.clP.get(i2).getProgress() / 100.0f) * size;
                i = i2 + 1;
            }
            f = (this.clO.size() * size) + f2;
        }
        return (int) f;
    }

    private static void d(String str) {
        Log.d("DuAr_InitModel", str);
    }
}

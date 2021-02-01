package com.baidu.swan.games.i;

import com.baidu.swan.apps.ao.p;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes9.dex */
public class h implements Runnable {
    private final i efH;
    private AtomicBoolean egE = new AtomicBoolean(false);
    private List<h> egF = Collections.synchronizedList(new ArrayList());
    private String[] mPaths;
    private final Runnable mRunnable;
    private String mTag;

    public h(i iVar, Runnable runnable, String str, String[] strArr) {
        this.efH = iVar;
        this.mRunnable = runnable;
        this.mTag = str;
        this.mPaths = strArr;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            aWo();
        } finally {
            this.efH.c(this);
        }
    }

    public void aWo() {
        this.mRunnable.run();
    }

    public void aWp() {
        p.a(this, this.mTag);
    }

    public String getTag() {
        return this.mTag;
    }

    public String[] aWq() {
        return this.mPaths;
    }

    public boolean aWr() {
        return this.egE.get();
    }

    public void aWs() {
        this.egE.set(true);
    }

    public void a(h hVar) {
        if (!this.egF.contains(hVar)) {
            this.egF.add(hVar);
        }
    }

    public void b(h hVar) {
        this.egF.remove(hVar);
    }

    public boolean aWt() {
        return this.egF.isEmpty();
    }
}

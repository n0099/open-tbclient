package com.baidu.swan.games.i;

import com.baidu.swan.apps.ap.p;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes25.dex */
public class h implements Runnable {
    private final i dZq;
    private AtomicBoolean eam = new AtomicBoolean(false);
    private List<h> ean = Collections.synchronizedList(new ArrayList());
    private String[] mPaths;
    private final Runnable mRunnable;
    private String mTag;

    public h(i iVar, Runnable runnable, String str, String[] strArr) {
        this.dZq = iVar;
        this.mRunnable = runnable;
        this.mTag = str;
        this.mPaths = strArr;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            aXB();
        } finally {
            this.dZq.c(this);
        }
    }

    public void aXB() {
        this.mRunnable.run();
    }

    public void aXC() {
        p.postOnIO(this, this.mTag);
    }

    public String getTag() {
        return this.mTag;
    }

    public String[] aXD() {
        return this.mPaths;
    }

    public boolean aXE() {
        return this.eam.get();
    }

    public void aXF() {
        this.eam.set(true);
    }

    public void a(h hVar) {
        if (!this.ean.contains(hVar)) {
            this.ean.add(hVar);
        }
    }

    public void b(h hVar) {
        this.ean.remove(hVar);
    }

    public boolean aXG() {
        return this.ean.isEmpty();
    }
}

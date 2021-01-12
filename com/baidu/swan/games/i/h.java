package com.baidu.swan.games.i;

import com.baidu.swan.apps.ao.p;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes8.dex */
public class h implements Runnable {
    private final i edA;
    private AtomicBoolean eew = new AtomicBoolean(false);
    private List<h> eex = Collections.synchronizedList(new ArrayList());
    private String[] mPaths;
    private final Runnable mRunnable;
    private String mTag;

    public h(i iVar, Runnable runnable, String str, String[] strArr) {
        this.edA = iVar;
        this.mRunnable = runnable;
        this.mTag = str;
        this.mPaths = strArr;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            aWc();
        } finally {
            this.edA.c(this);
        }
    }

    public void aWc() {
        this.mRunnable.run();
    }

    public void aWd() {
        p.a(this, this.mTag);
    }

    public String getTag() {
        return this.mTag;
    }

    public String[] aWe() {
        return this.mPaths;
    }

    public boolean aWf() {
        return this.eew.get();
    }

    public void aWg() {
        this.eew.set(true);
    }

    public void a(h hVar) {
        if (!this.eex.contains(hVar)) {
            this.eex.add(hVar);
        }
    }

    public void b(h hVar) {
        this.eex.remove(hVar);
    }

    public boolean aWh() {
        return this.eex.isEmpty();
    }
}

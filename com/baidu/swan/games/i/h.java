package com.baidu.swan.games.i;

import com.baidu.swan.apps.ao.p;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes8.dex */
public class h implements Runnable {
    private final i ehj;
    private AtomicBoolean eif = new AtomicBoolean(false);
    private List<h> eig = Collections.synchronizedList(new ArrayList());
    private String[] mPaths;
    private final Runnable mRunnable;
    private String mTag;

    public h(i iVar, Runnable runnable, String str, String[] strArr) {
        this.ehj = iVar;
        this.mRunnable = runnable;
        this.mTag = str;
        this.mPaths = strArr;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            aWr();
        } finally {
            this.ehj.c(this);
        }
    }

    public void aWr() {
        this.mRunnable.run();
    }

    public void aWs() {
        p.a(this, this.mTag);
    }

    public String getTag() {
        return this.mTag;
    }

    public String[] aWt() {
        return this.mPaths;
    }

    public boolean aWu() {
        return this.eif.get();
    }

    public void aWv() {
        this.eif.set(true);
    }

    public void a(h hVar) {
        if (!this.eig.contains(hVar)) {
            this.eig.add(hVar);
        }
    }

    public void b(h hVar) {
        this.eig.remove(hVar);
    }

    public boolean aWw() {
        return this.eig.isEmpty();
    }
}

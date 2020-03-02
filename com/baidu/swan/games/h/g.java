package com.baidu.swan.games.h;

import com.baidu.swan.apps.as.m;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes11.dex */
public class g implements Runnable {
    private final h cmX;
    private AtomicBoolean cnM = new AtomicBoolean(false);
    private List<g> cnN = Collections.synchronizedList(new ArrayList());
    private String[] mPaths;
    private final Runnable mRunnable;
    private String mTag;

    public g(h hVar, Runnable runnable, String str, String[] strArr) {
        this.cmX = hVar;
        this.mRunnable = runnable;
        this.mTag = str;
        this.mPaths = strArr;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            anK();
        } finally {
            this.cmX.c(this);
        }
    }

    public void anK() {
        this.mRunnable.run();
    }

    public void anL() {
        m.postOnIO(this, this.mTag);
    }

    public String getTag() {
        return this.mTag;
    }

    public String[] anM() {
        return this.mPaths;
    }

    public boolean anN() {
        return this.cnM.get();
    }

    public void anO() {
        this.cnM.set(true);
    }

    public void a(g gVar) {
        if (!this.cnN.contains(gVar)) {
            this.cnN.add(gVar);
        }
    }

    public void b(g gVar) {
        this.cnN.remove(gVar);
    }

    public boolean anP() {
        return this.cnN.isEmpty();
    }
}

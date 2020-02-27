package com.baidu.swan.games.h;

import com.baidu.swan.apps.as.m;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes11.dex */
public class g implements Runnable {
    private final h cmW;
    private AtomicBoolean cnL = new AtomicBoolean(false);
    private List<g> cnM = Collections.synchronizedList(new ArrayList());
    private String[] mPaths;
    private final Runnable mRunnable;
    private String mTag;

    public g(h hVar, Runnable runnable, String str, String[] strArr) {
        this.cmW = hVar;
        this.mRunnable = runnable;
        this.mTag = str;
        this.mPaths = strArr;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            anI();
        } finally {
            this.cmW.c(this);
        }
    }

    public void anI() {
        this.mRunnable.run();
    }

    public void anJ() {
        m.postOnIO(this, this.mTag);
    }

    public String getTag() {
        return this.mTag;
    }

    public String[] anK() {
        return this.mPaths;
    }

    public boolean anL() {
        return this.cnL.get();
    }

    public void anM() {
        this.cnL.set(true);
    }

    public void a(g gVar) {
        if (!this.cnM.contains(gVar)) {
            this.cnM.add(gVar);
        }
    }

    public void b(g gVar) {
        this.cnM.remove(gVar);
    }

    public boolean anN() {
        return this.cnM.isEmpty();
    }
}

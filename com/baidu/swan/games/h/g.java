package com.baidu.swan.games.h;

import com.baidu.swan.apps.as.m;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes11.dex */
public class g implements Runnable {
    private AtomicBoolean cnY = new AtomicBoolean(false);
    private List<g> cnZ = Collections.synchronizedList(new ArrayList());
    private final h cnj;
    private String[] mPaths;
    private final Runnable mRunnable;
    private String mTag;

    public g(h hVar, Runnable runnable, String str, String[] strArr) {
        this.cnj = hVar;
        this.mRunnable = runnable;
        this.mTag = str;
        this.mPaths = strArr;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            anN();
        } finally {
            this.cnj.c(this);
        }
    }

    public void anN() {
        this.mRunnable.run();
    }

    public void anO() {
        m.postOnIO(this, this.mTag);
    }

    public String getTag() {
        return this.mTag;
    }

    public String[] anP() {
        return this.mPaths;
    }

    public boolean anQ() {
        return this.cnY.get();
    }

    public void anR() {
        this.cnY.set(true);
    }

    public void a(g gVar) {
        if (!this.cnZ.contains(gVar)) {
            this.cnZ.add(gVar);
        }
    }

    public void b(g gVar) {
        this.cnZ.remove(gVar);
    }

    public boolean anS() {
        return this.cnZ.isEmpty();
    }
}

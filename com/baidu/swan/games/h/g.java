package com.baidu.swan.games.h;

import com.baidu.swan.apps.as.m;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes11.dex */
public class g implements Runnable {
    private final h cMl;
    private AtomicBoolean cNa = new AtomicBoolean(false);
    private List<g> cNb = Collections.synchronizedList(new ArrayList());
    private String[] mPaths;
    private final Runnable mRunnable;
    private String mTag;

    public g(h hVar, Runnable runnable, String str, String[] strArr) {
        this.cMl = hVar;
        this.mRunnable = runnable;
        this.mTag = str;
        this.mPaths = strArr;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            awa();
        } finally {
            this.cMl.c(this);
        }
    }

    public void awa() {
        this.mRunnable.run();
    }

    public void awb() {
        m.postOnIO(this, this.mTag);
    }

    public String getTag() {
        return this.mTag;
    }

    public String[] awc() {
        return this.mPaths;
    }

    public boolean awd() {
        return this.cNa.get();
    }

    public void awe() {
        this.cNa.set(true);
    }

    public void a(g gVar) {
        if (!this.cNb.contains(gVar)) {
            this.cNb.add(gVar);
        }
    }

    public void b(g gVar) {
        this.cNb.remove(gVar);
    }

    public boolean awf() {
        return this.cNb.isEmpty();
    }
}

package com.baidu.swan.games.h;

import com.baidu.swan.apps.as.m;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes11.dex */
public class g implements Runnable {
    private AtomicBoolean cMU = new AtomicBoolean(false);
    private List<g> cMV = Collections.synchronizedList(new ArrayList());
    private final h cMf;
    private String[] mPaths;
    private final Runnable mRunnable;
    private String mTag;

    public g(h hVar, Runnable runnable, String str, String[] strArr) {
        this.cMf = hVar;
        this.mRunnable = runnable;
        this.mTag = str;
        this.mPaths = strArr;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            awa();
        } finally {
            this.cMf.c(this);
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
        return this.cMU.get();
    }

    public void awe() {
        this.cMU.set(true);
    }

    public void a(g gVar) {
        if (!this.cMV.contains(gVar)) {
            this.cMV.add(gVar);
        }
    }

    public void b(g gVar) {
        this.cMV.remove(gVar);
    }

    public boolean awf() {
        return this.cMV.isEmpty();
    }
}

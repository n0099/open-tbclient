package com.baidu.swan.games.h;

import com.baidu.swan.apps.as.m;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes11.dex */
public class g implements Runnable {
    private final h cmY;
    private AtomicBoolean cnN = new AtomicBoolean(false);
    private List<g> cnO = Collections.synchronizedList(new ArrayList());
    private String[] mPaths;
    private final Runnable mRunnable;
    private String mTag;

    public g(h hVar, Runnable runnable, String str, String[] strArr) {
        this.cmY = hVar;
        this.mRunnable = runnable;
        this.mTag = str;
        this.mPaths = strArr;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            anK();
        } finally {
            this.cmY.c(this);
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
        return this.cnN.get();
    }

    public void anO() {
        this.cnN.set(true);
    }

    public void a(g gVar) {
        if (!this.cnO.contains(gVar)) {
            this.cnO.add(gVar);
        }
    }

    public void b(g gVar) {
        this.cnO.remove(gVar);
    }

    public boolean anP() {
        return this.cnO.isEmpty();
    }
}

package com.baidu.swan.games.h;

import com.baidu.swan.apps.as.m;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes10.dex */
public class g implements Runnable {
    private final h ciS;
    private AtomicBoolean cjH = new AtomicBoolean(false);
    private List<g> cjI = Collections.synchronizedList(new ArrayList());
    private String[] mPaths;
    private final Runnable mRunnable;
    private String mTag;

    public g(h hVar, Runnable runnable, String str, String[] strArr) {
        this.ciS = hVar;
        this.mRunnable = runnable;
        this.mTag = str;
        this.mPaths = strArr;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            alv();
        } finally {
            this.ciS.c(this);
        }
    }

    public void alv() {
        this.mRunnable.run();
    }

    public void alw() {
        m.postOnIO(this, this.mTag);
    }

    public String getTag() {
        return this.mTag;
    }

    public String[] alx() {
        return this.mPaths;
    }

    public boolean aly() {
        return this.cjH.get();
    }

    public void alz() {
        this.cjH.set(true);
    }

    public void a(g gVar) {
        if (!this.cjI.contains(gVar)) {
            this.cjI.add(gVar);
        }
    }

    public void b(g gVar) {
        this.cjI.remove(gVar);
    }

    public boolean alA() {
        return this.cjI.isEmpty();
    }
}

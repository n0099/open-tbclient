package com.baidu.swan.games.h;

import com.baidu.swan.apps.as.m;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes9.dex */
public class g implements Runnable {
    private final h ciF;
    private AtomicBoolean cju = new AtomicBoolean(false);
    private List<g> cjv = Collections.synchronizedList(new ArrayList());
    private String[] mPaths;
    private final Runnable mRunnable;
    private String mTag;

    public g(h hVar, Runnable runnable, String str, String[] strArr) {
        this.ciF = hVar;
        this.mRunnable = runnable;
        this.mTag = str;
        this.mPaths = strArr;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            alc();
        } finally {
            this.ciF.c(this);
        }
    }

    public void alc() {
        this.mRunnable.run();
    }

    public void ald() {
        m.postOnIO(this, this.mTag);
    }

    public String getTag() {
        return this.mTag;
    }

    public String[] ale() {
        return this.mPaths;
    }

    public boolean alf() {
        return this.cju.get();
    }

    public void alg() {
        this.cju.set(true);
    }

    public void a(g gVar) {
        if (!this.cjv.contains(gVar)) {
            this.cjv.add(gVar);
        }
    }

    public void b(g gVar) {
        this.cjv.remove(gVar);
    }

    public boolean alh() {
        return this.cjv.isEmpty();
    }
}

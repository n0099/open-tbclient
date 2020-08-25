package com.baidu.swan.games.i;

import com.baidu.swan.apps.ap.p;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes8.dex */
public class h implements Runnable {
    private final i drD;
    private AtomicBoolean dsA = new AtomicBoolean(false);
    private List<h> dsB = Collections.synchronizedList(new ArrayList());
    private String[] mPaths;
    private final Runnable mRunnable;
    private String mTag;

    public h(i iVar, Runnable runnable, String str, String[] strArr) {
        this.drD = iVar;
        this.mRunnable = runnable;
        this.mTag = str;
        this.mPaths = strArr;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            aNq();
        } finally {
            this.drD.c(this);
        }
    }

    public void aNq() {
        this.mRunnable.run();
    }

    public void aNr() {
        p.postOnIO(this, this.mTag);
    }

    public String getTag() {
        return this.mTag;
    }

    public String[] aNs() {
        return this.mPaths;
    }

    public boolean aNt() {
        return this.dsA.get();
    }

    public void aNu() {
        this.dsA.set(true);
    }

    public void a(h hVar) {
        if (!this.dsB.contains(hVar)) {
            this.dsB.add(hVar);
        }
    }

    public void b(h hVar) {
        this.dsB.remove(hVar);
    }

    public boolean aNv() {
        return this.dsB.isEmpty();
    }
}

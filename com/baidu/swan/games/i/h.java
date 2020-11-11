package com.baidu.swan.games.i;

import com.baidu.swan.apps.ap.p;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes10.dex */
public class h implements Runnable {
    private AtomicBoolean dUW = new AtomicBoolean(false);
    private List<h> dUX = Collections.synchronizedList(new ArrayList());
    private final i dUa;
    private String[] mPaths;
    private final Runnable mRunnable;
    private String mTag;

    public h(i iVar, Runnable runnable, String str, String[] strArr) {
        this.dUa = iVar;
        this.mRunnable = runnable;
        this.mTag = str;
        this.mPaths = strArr;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            aVe();
        } finally {
            this.dUa.c(this);
        }
    }

    public void aVe() {
        this.mRunnable.run();
    }

    public void aVf() {
        p.postOnIO(this, this.mTag);
    }

    public String getTag() {
        return this.mTag;
    }

    public String[] aVg() {
        return this.mPaths;
    }

    public boolean aVh() {
        return this.dUW.get();
    }

    public void aVi() {
        this.dUW.set(true);
    }

    public void a(h hVar) {
        if (!this.dUX.contains(hVar)) {
            this.dUX.add(hVar);
        }
    }

    public void b(h hVar) {
        this.dUX.remove(hVar);
    }

    public boolean aVj() {
        return this.dUX.isEmpty();
    }
}

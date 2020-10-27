package com.baidu.swan.games.i;

import com.baidu.swan.apps.ap.p;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes10.dex */
public class h implements Runnable {
    private final i dOi;
    private AtomicBoolean dPe = new AtomicBoolean(false);
    private List<h> dPf = Collections.synchronizedList(new ArrayList());
    private String[] mPaths;
    private final Runnable mRunnable;
    private String mTag;

    public h(i iVar, Runnable runnable, String str, String[] strArr) {
        this.dOi = iVar;
        this.mRunnable = runnable;
        this.mTag = str;
        this.mPaths = strArr;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            aSE();
        } finally {
            this.dOi.c(this);
        }
    }

    public void aSE() {
        this.mRunnable.run();
    }

    public void aSF() {
        p.postOnIO(this, this.mTag);
    }

    public String getTag() {
        return this.mTag;
    }

    public String[] aSG() {
        return this.mPaths;
    }

    public boolean aSH() {
        return this.dPe.get();
    }

    public void aSI() {
        this.dPe.set(true);
    }

    public void a(h hVar) {
        if (!this.dPf.contains(hVar)) {
            this.dPf.add(hVar);
        }
    }

    public void b(h hVar) {
        this.dPf.remove(hVar);
    }

    public boolean aSJ() {
        return this.dPf.isEmpty();
    }
}

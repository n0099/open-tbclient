package com.baidu.swan.games.i;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes11.dex */
public class h implements Runnable {
    private final i cWY;
    private AtomicBoolean cXU = new AtomicBoolean(false);
    private List<h> cXV = Collections.synchronizedList(new ArrayList());
    private String[] mPaths;
    private final Runnable mRunnable;
    private String mTag;

    public h(i iVar, Runnable runnable, String str, String[] strArr) {
        this.cWY = iVar;
        this.mRunnable = runnable;
        this.mTag = str;
        this.mPaths = strArr;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            azR();
        } finally {
            this.cWY.c(this);
        }
    }

    public void azR() {
        this.mRunnable.run();
    }

    public void azS() {
        com.baidu.swan.apps.aq.n.postOnIO(this, this.mTag);
    }

    public String getTag() {
        return this.mTag;
    }

    public String[] azT() {
        return this.mPaths;
    }

    public boolean azU() {
        return this.cXU.get();
    }

    public void azV() {
        this.cXU.set(true);
    }

    public void a(h hVar) {
        if (!this.cXV.contains(hVar)) {
            this.cXV.add(hVar);
        }
    }

    public void b(h hVar) {
        this.cXV.remove(hVar);
    }

    public boolean azW() {
        return this.cXV.isEmpty();
    }
}

package com.baidu.swan.games.i;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes11.dex */
public class h implements Runnable {
    private final i dbK;
    private AtomicBoolean dcH = new AtomicBoolean(false);
    private List<h> dcI = Collections.synchronizedList(new ArrayList());
    private String[] mPaths;
    private final Runnable mRunnable;
    private String mTag;

    public h(i iVar, Runnable runnable, String str, String[] strArr) {
        this.dbK = iVar;
        this.mRunnable = runnable;
        this.mTag = str;
        this.mPaths = strArr;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            aAX();
        } finally {
            this.dbK.c(this);
        }
    }

    public void aAX() {
        this.mRunnable.run();
    }

    public void aAY() {
        com.baidu.swan.apps.aq.n.postOnIO(this, this.mTag);
    }

    public String getTag() {
        return this.mTag;
    }

    public String[] aAZ() {
        return this.mPaths;
    }

    public boolean aBa() {
        return this.dcH.get();
    }

    public void aBb() {
        this.dcH.set(true);
    }

    public void a(h hVar) {
        if (!this.dcI.contains(hVar)) {
            this.dcI.add(hVar);
        }
    }

    public void b(h hVar) {
        this.dcI.remove(hVar);
    }

    public boolean aBc() {
        return this.dcI.isEmpty();
    }
}

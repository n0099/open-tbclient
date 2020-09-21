package com.baidu.swan.games.i;

import com.baidu.swan.apps.ap.p;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class h implements Runnable {
    private final i dtK;
    private AtomicBoolean duG = new AtomicBoolean(false);
    private List<h> duH = Collections.synchronizedList(new ArrayList());
    private String[] mPaths;
    private final Runnable mRunnable;
    private String mTag;

    public h(i iVar, Runnable runnable, String str, String[] strArr) {
        this.dtK = iVar;
        this.mRunnable = runnable;
        this.mTag = str;
        this.mPaths = strArr;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            aOb();
        } finally {
            this.dtK.c(this);
        }
    }

    public void aOb() {
        this.mRunnable.run();
    }

    public void aOc() {
        p.postOnIO(this, this.mTag);
    }

    public String getTag() {
        return this.mTag;
    }

    public String[] aOd() {
        return this.mPaths;
    }

    public boolean aOe() {
        return this.duG.get();
    }

    public void aOf() {
        this.duG.set(true);
    }

    public void a(h hVar) {
        if (!this.duH.contains(hVar)) {
            this.duH.add(hVar);
        }
    }

    public void b(h hVar) {
        this.duH.remove(hVar);
    }

    public boolean aOg() {
        return this.duH.isEmpty();
    }
}

package com.baidu.swan.games.i;

import com.baidu.swan.apps.ao.p;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes9.dex */
public class h implements Runnable {
    private final i ein;
    private AtomicBoolean ejj = new AtomicBoolean(false);
    private List<h> ejk = Collections.synchronizedList(new ArrayList());
    private String[] mPaths;
    private final Runnable mRunnable;
    private String mTag;

    public h(i iVar, Runnable runnable, String str, String[] strArr) {
        this.ein = iVar;
        this.mRunnable = runnable;
        this.mTag = str;
        this.mPaths = strArr;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            aZW();
        } finally {
            this.ein.c(this);
        }
    }

    public void aZW() {
        this.mRunnable.run();
    }

    public void aZX() {
        p.a(this, this.mTag);
    }

    public String getTag() {
        return this.mTag;
    }

    public String[] aZY() {
        return this.mPaths;
    }

    public boolean aZZ() {
        return this.ejj.get();
    }

    public void baa() {
        this.ejj.set(true);
    }

    public void a(h hVar) {
        if (!this.ejk.contains(hVar)) {
            this.ejk.add(hVar);
        }
    }

    public void b(h hVar) {
        this.ejk.remove(hVar);
    }

    public boolean bab() {
        return this.ejk.isEmpty();
    }
}

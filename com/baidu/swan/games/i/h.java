package com.baidu.swan.games.i;

import com.baidu.swan.apps.ap.p;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public class h implements Runnable {
    private final i dSs;
    private AtomicBoolean dTo = new AtomicBoolean(false);
    private List<h> dTp = Collections.synchronizedList(new ArrayList());
    private String[] mPaths;
    private final Runnable mRunnable;
    private String mTag;

    public h(i iVar, Runnable runnable, String str, String[] strArr) {
        this.dSs = iVar;
        this.mRunnable = runnable;
        this.mTag = str;
        this.mPaths = strArr;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            aUw();
        } finally {
            this.dSs.c(this);
        }
    }

    public void aUw() {
        this.mRunnable.run();
    }

    public void aUx() {
        p.postOnIO(this, this.mTag);
    }

    public String getTag() {
        return this.mTag;
    }

    public String[] aUy() {
        return this.mPaths;
    }

    public boolean aUz() {
        return this.dTo.get();
    }

    public void aUA() {
        this.dTo.set(true);
    }

    public void a(h hVar) {
        if (!this.dTp.contains(hVar)) {
            this.dTp.add(hVar);
        }
    }

    public void b(h hVar) {
        this.dTp.remove(hVar);
    }

    public boolean aUB() {
        return this.dTp.isEmpty();
    }
}

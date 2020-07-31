package com.baidu.swan.games.i;

import com.baidu.swan.apps.aq.p;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public class h implements Runnable {
    private final i dht;
    private AtomicBoolean diq = new AtomicBoolean(false);
    private List<h> dit = Collections.synchronizedList(new ArrayList());
    private String[] mPaths;
    private final Runnable mRunnable;
    private String mTag;

    public h(i iVar, Runnable runnable, String str, String[] strArr) {
        this.dht = iVar;
        this.mRunnable = runnable;
        this.mTag = str;
        this.mPaths = strArr;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            aEC();
        } finally {
            this.dht.c(this);
        }
    }

    public void aEC() {
        this.mRunnable.run();
    }

    public void aED() {
        p.postOnIO(this, this.mTag);
    }

    public String getTag() {
        return this.mTag;
    }

    public String[] aEE() {
        return this.mPaths;
    }

    public boolean aEF() {
        return this.diq.get();
    }

    public void aEG() {
        this.diq.set(true);
    }

    public void a(h hVar) {
        if (!this.dit.contains(hVar)) {
            this.dit.add(hVar);
        }
    }

    public void b(h hVar) {
        this.dit.remove(hVar);
    }

    public boolean aEH() {
        return this.dit.isEmpty();
    }
}

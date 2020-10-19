package com.baidu.swan.games.i;

import com.baidu.swan.apps.ap.p;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes10.dex */
public class h implements Runnable {
    private final i dFL;
    private AtomicBoolean dGH = new AtomicBoolean(false);
    private List<h> dGI = Collections.synchronizedList(new ArrayList());
    private String[] mPaths;
    private final Runnable mRunnable;
    private String mTag;

    public h(i iVar, Runnable runnable, String str, String[] strArr) {
        this.dFL = iVar;
        this.mRunnable = runnable;
        this.mTag = str;
        this.mPaths = strArr;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            aQK();
        } finally {
            this.dFL.c(this);
        }
    }

    public void aQK() {
        this.mRunnable.run();
    }

    public void aQL() {
        p.postOnIO(this, this.mTag);
    }

    public String getTag() {
        return this.mTag;
    }

    public String[] aQM() {
        return this.mPaths;
    }

    public boolean aQN() {
        return this.dGH.get();
    }

    public void aQO() {
        this.dGH.set(true);
    }

    public void a(h hVar) {
        if (!this.dGI.contains(hVar)) {
            this.dGI.add(hVar);
        }
    }

    public void b(h hVar) {
        this.dGI.remove(hVar);
    }

    public boolean aQP() {
        return this.dGI.isEmpty();
    }
}

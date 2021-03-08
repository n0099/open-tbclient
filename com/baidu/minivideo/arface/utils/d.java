package com.baidu.minivideo.arface.utils;

import com.baidu.minivideo.arface.utils.g;
/* loaded from: classes5.dex */
public abstract class d implements g {
    private g.a cnq;
    private int mState = 0;

    protected abstract void run();

    public void a(g.a aVar) {
        if (this.mState == 0 || 3 == this.mState || 2 == this.mState) {
            setState(1);
            b(aVar);
            try {
                run();
                return;
            } catch (Throwable th) {
                th.printStackTrace();
                setState(3);
                return;
            }
        }
        b(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setState(int i) {
        if (this.mState != i) {
            this.mState = i;
            if (this.cnq != null) {
                this.cnq.a(this.mState, this);
            }
        }
    }

    protected int getState() {
        return this.mState;
    }

    public void b(g.a aVar) {
        this.cnq = aVar;
        if (this.cnq != null) {
            this.cnq.a(getState(), this);
        }
    }
}

package com.baidu.minivideo.arface.utils;

import com.baidu.minivideo.arface.utils.f;
/* loaded from: classes8.dex */
public abstract class c implements f {
    private f.a cfl;
    private int mState = 0;

    protected abstract void run();

    public void a(f.a aVar) {
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
            if (this.cfl != null) {
                this.cfl.a(this.mState, this);
            }
        }
    }

    protected int getState() {
        return this.mState;
    }

    public void b(f.a aVar) {
        this.cfl = aVar;
        if (this.cfl != null) {
            this.cfl.a(getState(), this);
        }
    }
}

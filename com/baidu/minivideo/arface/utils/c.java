package com.baidu.minivideo.arface.utils;

import com.baidu.minivideo.arface.utils.f;
/* loaded from: classes3.dex */
public abstract class c implements f {
    private f.a brn;
    private int mState = 0;

    public void a(f.a aVar) {
        if (this.mState == 0 || 3 == this.mState || 2 == this.mState) {
            setState(1);
            b(aVar);
            run();
            return;
        }
        b(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setState(int i) {
        if (this.mState != i) {
            this.mState = i;
            if (this.brn != null) {
                this.brn.a(this.mState, this);
            }
        }
    }

    protected int getState() {
        return this.mState;
    }

    public void b(f.a aVar) {
        this.brn = aVar;
        if (this.brn != null) {
            this.brn.a(getState(), this);
        }
    }
}

package com.baidu.minivideo.arface.utils;

import com.baidu.minivideo.arface.utils.f;
/* loaded from: classes14.dex */
public abstract class c implements f {
    private f.a mCallback;
    private int mState = 0;

    protected abstract void run();

    public void start(f.a aVar) {
        if (this.mState == 0 || 3 == this.mState || 2 == this.mState) {
            setState(1);
            setCallback(aVar);
            try {
                run();
                return;
            } catch (Throwable th) {
                th.printStackTrace();
                setState(3);
                return;
            }
        }
        setCallback(aVar);
    }

    public void cancel() {
        setState(0);
    }

    public boolean isRunning() {
        return 1 == this.mState;
    }

    public boolean isSuccess() {
        return 2 == this.mState;
    }

    public boolean isFailed() {
        return 3 == this.mState;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setState(int i) {
        if (this.mState != i) {
            this.mState = i;
            if (this.mCallback != null) {
                this.mCallback.a(this.mState, this);
            }
        }
    }

    protected int getState() {
        return this.mState;
    }

    public void setCallback(f.a aVar) {
        this.mCallback = aVar;
        if (this.mCallback != null) {
            this.mCallback.a(getState(), this);
        }
    }
}

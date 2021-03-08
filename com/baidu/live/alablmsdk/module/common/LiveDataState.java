package com.baidu.live.alablmsdk.module.common;
/* loaded from: classes10.dex */
public enum LiveDataState {
    NULL(-1),
    FALSE(0),
    TRUE(1);
    
    private int state;

    LiveDataState(int i) {
        this.state = i;
    }

    public int getState() {
        return this.state;
    }

    public boolean isTrue() {
        return this.state == 1;
    }

    public boolean isFalse() {
        return this.state == 0;
    }

    public boolean isNull() {
        return this.state == -1;
    }
}

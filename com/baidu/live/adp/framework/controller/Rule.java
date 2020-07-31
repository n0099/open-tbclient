package com.baidu.live.adp.framework.controller;

import com.baidu.live.adp.framework.Priority;
/* loaded from: classes4.dex */
public abstract class Rule<T> extends Priority {
    private int mCmd;

    public Rule(int i) {
        this.mCmd = 0;
        this.mCmd = i;
    }

    public int getCmd() {
        return this.mCmd;
    }

    public void setCmd(int i) {
        this.mCmd = i;
    }
}

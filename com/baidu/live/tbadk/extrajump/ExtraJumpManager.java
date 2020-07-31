package com.baidu.live.tbadk.extrajump;

import com.baidu.live.tbadk.extrajump.interfaces.IExtraJump;
import com.baidu.live.tbadk.extrajump.interfaces.IExtraJumpBuilder;
/* loaded from: classes4.dex */
public class ExtraJumpManager {
    private IExtraJump mExtraJump;
    private IExtraJumpBuilder mExtraJumpBuilder;

    public static ExtraJumpManager getInstance() {
        return InstanceHolder.sInst;
    }

    private ExtraJumpManager() {
    }

    public void init(IExtraJumpBuilder iExtraJumpBuilder) {
        this.mExtraJumpBuilder = iExtraJumpBuilder;
        build();
    }

    public IExtraJump buildJumpExtra() {
        if (this.mExtraJump != null) {
            return this.mExtraJump;
        }
        build();
        return this.mExtraJump;
    }

    private void build() {
        if (this.mExtraJumpBuilder != null) {
            this.mExtraJump = this.mExtraJumpBuilder.build();
        }
    }

    /* loaded from: classes4.dex */
    public static class InstanceHolder {
        private static final ExtraJumpManager sInst = new ExtraJumpManager();
    }
}

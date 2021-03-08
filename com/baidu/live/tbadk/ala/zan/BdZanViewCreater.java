package com.baidu.live.tbadk.ala.zan;
/* loaded from: classes10.dex */
public class BdZanViewCreater {
    private static BdZanViewCreater sBdZanViewCreater = new BdZanViewCreater();
    private IAlaBdZanBuilder mIAlaBdZanBuilder;

    private BdZanViewCreater() {
    }

    public static BdZanViewCreater getInst() {
        return sBdZanViewCreater;
    }

    public IAlaBdZanBuilder getBdZanBuilder() {
        return this.mIAlaBdZanBuilder;
    }

    public void setBdZanBuilder(IAlaBdZanBuilder iAlaBdZanBuilder) {
        this.mIAlaBdZanBuilder = iAlaBdZanBuilder;
    }

    public IAlaBdZan create() {
        if (this.mIAlaBdZanBuilder != null) {
            return this.mIAlaBdZanBuilder.build();
        }
        return null;
    }
}

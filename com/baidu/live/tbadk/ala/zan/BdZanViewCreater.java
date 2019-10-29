package com.baidu.live.tbadk.ala.zan;
/* loaded from: classes6.dex */
public class BdZanViewCreater {
    private static BdZanViewCreater sBdZanViewCreater;
    private IAlaBdZanBuilder mIAlaBdZanBuilder;

    private BdZanViewCreater() {
    }

    public static BdZanViewCreater getInst() {
        if (sBdZanViewCreater == null) {
            synchronized (BdZanViewCreater.class) {
                if (sBdZanViewCreater == null) {
                    sBdZanViewCreater = new BdZanViewCreater();
                }
            }
        }
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

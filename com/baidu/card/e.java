package com.baidu.card;

import android.content.Context;
/* loaded from: classes3.dex */
public class e extends ac {
    private boolean VM;

    public e(Context context) {
        super(context);
        this.VM = false;
    }

    public e(Context context, boolean z) {
        super(context);
        this.VM = false;
        this.VM = z;
    }

    @Override // com.baidu.card.ac
    protected com.baidu.tieba.play.operableVideoView.a qG() {
        return new com.baidu.tieba.play.operableVideoView.b(this.mContext, this.XC, this.VM);
    }
}

package com.baidu.card;

import android.content.Context;
/* loaded from: classes3.dex */
public class e extends ac {
    private boolean VL;

    public e(Context context) {
        super(context);
        this.VL = false;
    }

    public e(Context context, boolean z) {
        super(context);
        this.VL = false;
        this.VL = z;
    }

    @Override // com.baidu.card.ac
    protected com.baidu.tieba.play.operableVideoView.a qH() {
        return new com.baidu.tieba.play.operableVideoView.b(this.mContext, this.XB, this.VL);
    }
}

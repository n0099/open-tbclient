package com.baidu.card;

import android.content.Context;
/* loaded from: classes3.dex */
public class e extends ac {
    private boolean XC;

    public e(Context context) {
        super(context);
        this.XC = false;
    }

    public e(Context context, boolean z) {
        super(context);
        this.XC = false;
        this.XC = z;
    }

    @Override // com.baidu.card.ac
    protected com.baidu.tieba.play.operableVideoView.a ro() {
        return new com.baidu.tieba.play.operableVideoView.b(this.mContext, this.Zq, this.XC);
    }
}

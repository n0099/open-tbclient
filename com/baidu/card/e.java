package com.baidu.card;

import android.content.Context;
/* loaded from: classes3.dex */
public class e extends ac {
    private boolean XB;

    public e(Context context) {
        super(context);
        this.XB = false;
    }

    public e(Context context, boolean z) {
        super(context);
        this.XB = false;
        this.XB = z;
    }

    @Override // com.baidu.card.ac
    protected com.baidu.tieba.play.operableVideoView.a ro() {
        return new com.baidu.tieba.play.operableVideoView.b(this.mContext, this.Zp, this.XB);
    }
}

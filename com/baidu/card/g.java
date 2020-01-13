package com.baidu.card;

import android.content.Context;
/* loaded from: classes6.dex */
public class g extends al {
    private boolean JR;

    public g(Context context) {
        super(context);
        this.JR = false;
    }

    public g(Context context, boolean z) {
        super(context);
        this.JR = false;
        this.JR = z;
    }

    @Override // com.baidu.card.al
    protected com.baidu.tieba.play.operableVideoView.a mK() {
        return new com.baidu.tieba.play.operableVideoView.b(this.mContext, this.Mk, this.JR);
    }
}

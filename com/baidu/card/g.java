package com.baidu.card;

import android.content.Context;
/* loaded from: classes.dex */
public class g extends as {
    private boolean agu;

    public g(Context context) {
        super(context);
        this.agu = false;
    }

    public g(Context context, boolean z) {
        super(context);
        this.agu = false;
        this.agu = z;
    }

    @Override // com.baidu.card.as
    protected com.baidu.tieba.play.operableVideoView.a sU() {
        return new com.baidu.tieba.play.operableVideoView.b(this.mContext, this.agA, this.agu);
    }
}

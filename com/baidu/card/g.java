package com.baidu.card;

import android.content.Context;
/* loaded from: classes.dex */
public class g extends as {
    private boolean ahM;

    public g(Context context) {
        super(context);
        this.ahM = false;
    }

    public g(Context context, boolean z) {
        super(context);
        this.ahM = false;
        this.ahM = z;
    }

    @Override // com.baidu.card.as
    protected com.baidu.tieba.play.operableVideoView.a sU() {
        return new com.baidu.tieba.play.operableVideoView.b(this.mContext, this.ahS, this.ahM);
    }
}

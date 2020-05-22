package com.baidu.card;

import android.content.Context;
/* loaded from: classes8.dex */
public class g extends am {
    private boolean adG;

    public g(Context context) {
        super(context);
        this.adG = false;
    }

    public g(Context context, boolean z) {
        super(context);
        this.adG = false;
        this.adG = z;
    }

    @Override // com.baidu.card.am
    protected com.baidu.tieba.play.operableVideoView.a ry() {
        return new com.baidu.tieba.play.operableVideoView.b(this.mContext, this.afX, this.adG);
    }
}

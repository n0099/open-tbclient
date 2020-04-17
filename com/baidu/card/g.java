package com.baidu.card;

import android.content.Context;
/* loaded from: classes8.dex */
public class g extends al {
    private boolean adl;

    public g(Context context) {
        super(context);
        this.adl = false;
    }

    public g(Context context, boolean z) {
        super(context);
        this.adl = false;
        this.adl = z;
    }

    @Override // com.baidu.card.al
    protected com.baidu.tieba.play.operableVideoView.a rr() {
        return new com.baidu.tieba.play.operableVideoView.b(this.mContext, this.afy, this.adl);
    }
}

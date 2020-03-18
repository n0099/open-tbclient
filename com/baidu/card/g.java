package com.baidu.card;

import android.content.Context;
/* loaded from: classes8.dex */
public class g extends al {
    private boolean Kn;

    public g(Context context) {
        super(context);
        this.Kn = false;
    }

    public g(Context context, boolean z) {
        super(context);
        this.Kn = false;
        this.Kn = z;
    }

    @Override // com.baidu.card.al
    protected com.baidu.tieba.play.operableVideoView.a mZ() {
        return new com.baidu.tieba.play.operableVideoView.b(this.mContext, this.MN, this.Kn);
    }
}

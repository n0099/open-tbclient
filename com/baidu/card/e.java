package com.baidu.card;

import android.content.Context;
/* loaded from: classes3.dex */
public class e extends ac {
    private boolean Vs;

    public e(Context context) {
        super(context);
        this.Vs = false;
    }

    public e(Context context, boolean z) {
        super(context);
        this.Vs = false;
        this.Vs = z;
    }

    @Override // com.baidu.card.ac
    protected com.baidu.tieba.play.operableVideoView.a qj() {
        return new com.baidu.tieba.play.operableVideoView.b(this.mContext, this.Xh, this.Vs);
    }
}

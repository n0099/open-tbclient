package com.baidu.card;

import android.content.Context;
/* loaded from: classes.dex */
public class g extends as {
    private boolean agF;

    public g(Context context) {
        super(context);
        this.agF = false;
    }

    public g(Context context, boolean z) {
        super(context);
        this.agF = false;
        this.agF = z;
    }

    @Override // com.baidu.card.as
    protected com.baidu.tieba.play.operableVideoView.a sX() {
        return new com.baidu.tieba.play.operableVideoView.b(this.mContext, this.agL, this.agF);
    }
}

package com.baidu.card;

import android.content.Context;
/* loaded from: classes.dex */
public class g extends as {
    private boolean ahw;

    public g(Context context) {
        super(context);
        this.ahw = false;
    }

    public g(Context context, boolean z) {
        super(context);
        this.ahw = false;
        this.ahw = z;
    }

    @Override // com.baidu.card.as
    protected com.baidu.tieba.play.operableVideoView.a ti() {
        return new com.baidu.tieba.play.operableVideoView.b(this.mContext, this.ahC, this.ahw);
    }
}

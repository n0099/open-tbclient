package com.baidu.card;

import android.content.Context;
/* loaded from: classes15.dex */
public class g extends as {
    private boolean afi;

    public g(Context context) {
        super(context);
        this.afi = false;
    }

    public g(Context context, boolean z) {
        super(context);
        this.afi = false;
        this.afi = z;
    }

    @Override // com.baidu.card.as
    protected com.baidu.tieba.play.operableVideoView.a tC() {
        return new com.baidu.tieba.play.operableVideoView.b(this.mContext, this.ahJ, this.afi);
    }
}

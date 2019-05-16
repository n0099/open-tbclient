package com.baidu.card;

import android.content.Context;
/* loaded from: classes3.dex */
public class e extends ac {
    private boolean Vt;

    public e(Context context) {
        super(context);
        this.Vt = false;
    }

    public e(Context context, boolean z) {
        super(context);
        this.Vt = false;
        this.Vt = z;
    }

    @Override // com.baidu.card.ac
    protected com.baidu.tieba.play.operableVideoView.a qj() {
        return new com.baidu.tieba.play.operableVideoView.b(this.mContext, this.Xi, this.Vt);
    }
}

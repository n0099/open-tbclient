package com.baidu.card;

import android.content.Context;
/* loaded from: classes3.dex */
public class e extends ac {
    private boolean Fa;

    public e(Context context) {
        super(context);
        this.Fa = false;
    }

    public e(Context context, boolean z) {
        super(context);
        this.Fa = false;
        this.Fa = z;
    }

    @Override // com.baidu.card.ac
    protected com.baidu.tieba.play.operableVideoView.a lM() {
        return new com.baidu.tieba.play.operableVideoView.b(this.mContext, this.GV, this.Fa);
    }
}

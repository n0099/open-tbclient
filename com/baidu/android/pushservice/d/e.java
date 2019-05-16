package com.baidu.android.pushservice.d;

import android.content.Context;
import com.sina.weibo.sdk.statistic.LogBuilder;
/* loaded from: classes3.dex */
public abstract class e extends a {
    public e(l lVar, Context context) {
        super(lVar, context);
    }

    @Override // com.baidu.android.pushservice.d.a
    public boolean c() {
        this.c += LogBuilder.KEY_CHANNEL;
        return super.c();
    }
}

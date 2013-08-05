package com.baidu.android.pushservice.a;

import android.content.Context;
import com.baidu.android.common.logging.Log;
/* loaded from: classes.dex */
public abstract class e extends a {
    public e(l lVar, Context context) {
        super(lVar, context);
    }

    @Override // com.baidu.android.pushservice.a.a
    public boolean b() {
        Log.i("SendApiProcessor", "networkConnect");
        this.c += "channel";
        return super.b();
    }
}

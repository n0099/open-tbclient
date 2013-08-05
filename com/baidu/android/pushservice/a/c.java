package com.baidu.android.pushservice.a;

import android.content.Context;
import com.baidu.android.common.logging.Log;
/* loaded from: classes.dex */
public abstract class c extends a {
    public c(l lVar, Context context) {
        super(lVar, context);
    }

    @Override // com.baidu.android.pushservice.a.a
    public boolean b() {
        Log.i("BaseApiProcessor", "networkConnect");
        this.c += com.baidu.android.pushservice.y.a().c();
        return super.b();
    }
}

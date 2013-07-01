package com.baidu.android.defense.a;

import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
public final class d extends a {
    public d(Context context, c cVar) {
        super(context, cVar);
    }

    @Override // com.baidu.android.defense.a.a
    protected void a() {
        Intent intent = new Intent("action_appinstall");
        intent.putExtra("file_path", this.c);
        this.f231a.sendBroadcast(intent);
    }
}

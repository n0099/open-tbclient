package com.baidu.android.defense.a;

import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
public final class b extends c {
    public b(Context context, a aVar) {
        super(context, aVar);
    }

    @Override // com.baidu.android.defense.a.c
    protected void a() {
        Intent intent = new Intent("action_appinstall");
        intent.putExtra("file_path", this.c);
        this.a.sendBroadcast(intent);
    }
}

package com.baidu.android.defense.a;

import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
public final class a extends d {
    public a(Context context, b bVar) {
        super(context, bVar);
    }

    @Override // com.baidu.android.defense.a.d
    protected void a() {
        Intent intent = new Intent("action_appinstall");
        intent.putExtra("file_path", this.c);
        this.f520a.sendBroadcast(intent);
    }
}

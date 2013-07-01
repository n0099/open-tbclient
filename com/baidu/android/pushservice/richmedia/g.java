package com.baidu.android.pushservice.richmedia;

import android.content.DialogInterface;
import android.content.Intent;
import java.io.File;
import java.util.Map;
/* loaded from: classes.dex */
class g implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ long f340a;
    final /* synthetic */ e b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar, long j) {
        this.b = eVar;
        this.f340a = j;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        String str;
        str = MediaListActivity.r;
        String str2 = (String) ((Map) this.b.f338a.f332a.get((int) this.f340a)).get(str);
        com.baidu.android.pushservice.util.i a2 = com.baidu.android.pushservice.util.e.a(com.baidu.android.pushservice.util.e.a(this.b.f338a), str2);
        if (a2 != null) {
            new File(a2.e).delete();
        }
        com.baidu.android.pushservice.util.e.b(com.baidu.android.pushservice.util.e.a(this.b.f338a), str2);
        Intent intent = new Intent();
        intent.setClass(this.b.f338a, MediaListActivity.class);
        this.b.f338a.startActivity(intent);
    }
}

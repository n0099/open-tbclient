package com.baidu.android.pushservice.richmedia;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes.dex */
class d implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MediaListActivity f607a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(MediaListActivity mediaListActivity) {
        this.f607a = mediaListActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        String str;
        str = MediaListActivity.r;
        com.baidu.android.pushservice.util.i a2 = com.baidu.android.pushservice.util.e.a(com.baidu.android.pushservice.util.e.a(this.f607a), (String) ((HashMap) adapterView.getItemAtPosition(i)).get(str));
        if (a2 != null) {
            if (a2.i != b.f) {
                this.f607a.a(a2.b, a2.c, a2.d);
                return;
            }
            String str2 = a2.e;
            String str3 = a2.f;
            String str4 = str2 + "/" + str3.substring(0, str3.lastIndexOf(".")) + "/index.html";
            Intent intent = new Intent();
            intent.setClass(this.f607a, MediaViewActivity.class);
            intent.setData(Uri.fromFile(new File(str4)));
            intent.addFlags(268435456);
            this.f607a.startActivity(intent);
        }
    }
}

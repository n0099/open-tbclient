package com.baidu.android.pushservice.richmedia;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.android.pushservice.util.PushDatabase;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes.dex */
class d implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MediaListActivity f735a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(MediaListActivity mediaListActivity) {
        this.f735a = mediaListActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        String str;
        str = MediaListActivity.r;
        com.baidu.android.pushservice.util.j fileDownloadingInfo = PushDatabase.getFileDownloadingInfo(PushDatabase.getDb(this.f735a), (String) ((HashMap) adapterView.getItemAtPosition(i)).get(str));
        if (fileDownloadingInfo != null) {
            if (fileDownloadingInfo.i != b.f) {
                this.f735a.a(fileDownloadingInfo.b, fileDownloadingInfo.c, fileDownloadingInfo.d);
                return;
            }
            String str2 = fileDownloadingInfo.e;
            String str3 = fileDownloadingInfo.f;
            String str4 = str2 + "/" + str3.substring(0, str3.lastIndexOf(".")) + "/index.html";
            Intent intent = new Intent();
            intent.setClass(this.f735a, MediaViewActivity.class);
            intent.setData(Uri.fromFile(new File(str4)));
            intent.addFlags(268435456);
            this.f735a.startActivity(intent);
        }
    }
}

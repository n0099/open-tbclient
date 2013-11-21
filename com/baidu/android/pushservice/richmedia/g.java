package com.baidu.android.pushservice.richmedia;

import android.content.DialogInterface;
import android.content.Intent;
import com.baidu.android.pushservice.util.PushDatabase;
import java.io.File;
import java.util.Map;
/* loaded from: classes.dex */
class g implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ long f738a;
    final /* synthetic */ e b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar, long j) {
        this.b = eVar;
        this.f738a = j;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        String str;
        str = MediaListActivity.r;
        String str2 = (String) ((Map) this.b.f736a.f730a.get((int) this.f738a)).get(str);
        com.baidu.android.pushservice.util.j fileDownloadingInfo = PushDatabase.getFileDownloadingInfo(PushDatabase.getDb(this.b.f736a), str2);
        if (fileDownloadingInfo != null) {
            new File(fileDownloadingInfo.e).delete();
        }
        PushDatabase.deleteFileDownloadingInfo(PushDatabase.getDb(this.b.f736a), str2);
        Intent intent = new Intent();
        intent.setClass(this.b.f736a, MediaListActivity.class);
        this.b.f736a.startActivity(intent);
    }
}

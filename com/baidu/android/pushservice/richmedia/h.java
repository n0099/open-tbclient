package com.baidu.android.pushservice.richmedia;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.widget.RemoteViews;
import android.widget.Toast;
import com.baidu.android.pushservice.util.PushDatabase;
import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements s {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MediaListActivity f738a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(MediaListActivity mediaListActivity) {
        this.f738a = mediaListActivity;
    }

    @Override // com.baidu.android.pushservice.richmedia.s
    public void a(b bVar) {
    }

    @Override // com.baidu.android.pushservice.richmedia.s
    public void a(b bVar, m mVar) {
        RemoteViews remoteViews;
        RemoteViews remoteViews2;
        int i;
        RemoteViews remoteViews3;
        int i2;
        RemoteViews remoteViews4;
        int i3;
        RemoteViews remoteViews5;
        int i4;
        RemoteViews remoteViews6;
        String d = bVar.d.d();
        if (mVar.f743a == mVar.b) {
            return;
        }
        remoteViews = this.f738a.m;
        if (remoteViews != null) {
            int i5 = (int) ((mVar.f743a * 100.0d) / mVar.b);
            remoteViews2 = this.f738a.m;
            i = this.f738a.o;
            remoteViews2.setTextViewText(i, i5 + "%");
            remoteViews3 = this.f738a.m;
            i2 = this.f738a.p;
            remoteViews3.setTextViewText(i2, d);
            remoteViews4 = this.f738a.m;
            i3 = this.f738a.n;
            remoteViews4.setProgressBar(i3, 100, i5, false);
            remoteViews5 = this.f738a.m;
            i4 = this.f738a.q;
            remoteViews5.setImageViewResource(i4, 17301633);
            Notification notification = new Notification(17301633, null, System.currentTimeMillis());
            remoteViews6 = this.f738a.m;
            notification.contentView = remoteViews6;
            notification.contentIntent = PendingIntent.getActivity(this.f738a, 0, new Intent(), 0);
            notification.flags |= 32;
            notification.flags |= 2;
            this.f738a.b.notify(d, 0, notification);
        }
    }

    @Override // com.baidu.android.pushservice.richmedia.s
    public void a(b bVar, r rVar) {
        String d = bVar.d.d();
        this.f738a.b.cancel(d, 0);
        com.baidu.android.pushservice.util.j fileDownloadingInfo = PushDatabase.getFileDownloadingInfo(PushDatabase.getDb(this.f738a), d);
        if (fileDownloadingInfo == null || fileDownloadingInfo.i != b.f) {
            return;
        }
        String str = fileDownloadingInfo.e;
        String str2 = fileDownloadingInfo.f;
        String str3 = str + "/" + str2.substring(0, str2.lastIndexOf(".")) + "/index.html";
        Intent intent = new Intent();
        intent.setClass(this.f738a, MediaViewActivity.class);
        intent.setData(Uri.fromFile(new File(str3)));
        intent.addFlags(268435456);
        this.f738a.startActivity(intent);
    }

    @Override // com.baidu.android.pushservice.richmedia.s
    public void a(b bVar, Throwable th) {
        String d = bVar.d.d();
        this.f738a.b.cancel(d, 0);
        Toast makeText = Toast.makeText(this.f738a, "下载富媒体" + Uri.parse(d).getAuthority() + "失败", 1);
        makeText.setGravity(17, 0, 0);
        makeText.show();
    }

    @Override // com.baidu.android.pushservice.richmedia.s
    public void b(b bVar) {
        this.f738a.b.cancel(bVar.d.d(), 0);
    }
}

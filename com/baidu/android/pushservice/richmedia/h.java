package com.baidu.android.pushservice.richmedia;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.widget.RemoteViews;
import android.widget.Toast;
import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements s {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MediaListActivity f609a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(MediaListActivity mediaListActivity) {
        this.f609a = mediaListActivity;
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
        if (mVar.f614a == mVar.b) {
            return;
        }
        remoteViews = this.f609a.m;
        if (remoteViews != null) {
            int i5 = (int) ((mVar.f614a * 100.0d) / mVar.b);
            remoteViews2 = this.f609a.m;
            i = this.f609a.o;
            remoteViews2.setTextViewText(i, i5 + "%");
            remoteViews3 = this.f609a.m;
            i2 = this.f609a.p;
            remoteViews3.setTextViewText(i2, d);
            remoteViews4 = this.f609a.m;
            i3 = this.f609a.n;
            remoteViews4.setProgressBar(i3, 100, i5, false);
            remoteViews5 = this.f609a.m;
            i4 = this.f609a.q;
            remoteViews5.setImageViewResource(i4, 17301633);
            Notification notification = new Notification(17301633, null, System.currentTimeMillis());
            remoteViews6 = this.f609a.m;
            notification.contentView = remoteViews6;
            notification.contentIntent = PendingIntent.getActivity(this.f609a, 0, new Intent(), 0);
            notification.flags |= 32;
            notification.flags |= 2;
            this.f609a.b.notify(d, 0, notification);
        }
    }

    @Override // com.baidu.android.pushservice.richmedia.s
    public void a(b bVar, r rVar) {
        String d = bVar.d.d();
        this.f609a.b.cancel(d, 0);
        com.baidu.android.pushservice.util.i a2 = com.baidu.android.pushservice.util.e.a(com.baidu.android.pushservice.util.e.a(this.f609a), d);
        if (a2 == null || a2.i != b.f) {
            return;
        }
        String str = a2.e;
        String str2 = a2.f;
        String str3 = str + "/" + str2.substring(0, str2.lastIndexOf(".")) + "/index.html";
        Intent intent = new Intent();
        intent.setClass(this.f609a, MediaViewActivity.class);
        intent.setData(Uri.fromFile(new File(str3)));
        intent.addFlags(268435456);
        this.f609a.startActivity(intent);
    }

    @Override // com.baidu.android.pushservice.richmedia.s
    public void a(b bVar, Throwable th) {
        String d = bVar.d.d();
        this.f609a.b.cancel(d, 0);
        Toast makeText = Toast.makeText(this.f609a, "下载富媒体" + Uri.parse(d).getAuthority() + "失败", 1);
        makeText.setGravity(17, 0, 0);
        makeText.show();
    }

    @Override // com.baidu.android.pushservice.richmedia.s
    public void b(b bVar) {
        this.f609a.b.cancel(bVar.d.d(), 0);
    }
}

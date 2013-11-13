package com.baidu.android.pushservice;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.widget.RemoteViews;
import android.widget.Toast;
import com.baidu.android.pushservice.message.PublicMsg;
import com.baidu.android.pushservice.richmedia.MediaViewActivity;
import com.baidu.android.pushservice.util.PushDatabase;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements com.baidu.android.pushservice.richmedia.s {

    /* renamed from: a  reason: collision with root package name */
    public Context f725a;
    public RemoteViews b = null;
    public int c = 0;
    public int d = 0;
    public int e = 0;
    public int f = 0;
    NotificationManager g;
    PublicMsg h;
    final /* synthetic */ PushServiceReceiver i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(PushServiceReceiver pushServiceReceiver, Context context, PublicMsg publicMsg) {
        this.i = pushServiceReceiver;
        this.f725a = null;
        this.f725a = context;
        this.g = (NotificationManager) context.getSystemService("notification");
        this.h = publicMsg;
    }

    @Override // com.baidu.android.pushservice.richmedia.s
    public void a(com.baidu.android.pushservice.richmedia.b bVar) {
        Resources resources = this.f725a.getResources();
        String packageName = this.f725a.getPackageName();
        if (resources == null) {
            return;
        }
        int identifier = resources.getIdentifier("bpush_download_progress", "layout", packageName);
        this.b = new RemoteViews(this.f725a.getPackageName(), identifier);
        if (identifier != 0) {
            this.c = resources.getIdentifier("bpush_download_progress", LocaleUtil.INDONESIAN, packageName);
            this.d = resources.getIdentifier("bpush_progress_percent", LocaleUtil.INDONESIAN, packageName);
            this.e = resources.getIdentifier("bpush_progress_text", LocaleUtil.INDONESIAN, packageName);
            this.f = resources.getIdentifier("bpush_download_icon", LocaleUtil.INDONESIAN, packageName);
            this.b.setImageViewResource(this.f, this.f725a.getApplicationInfo().icon);
        }
    }

    @Override // com.baidu.android.pushservice.richmedia.s
    public void a(com.baidu.android.pushservice.richmedia.b bVar, com.baidu.android.pushservice.richmedia.m mVar) {
        String d = bVar.d.d();
        if (mVar.f743a == mVar.b || this.b == null) {
            return;
        }
        int i = (int) ((mVar.f743a * 100.0d) / mVar.b);
        this.b.setTextViewText(this.d, i + "%");
        this.b.setTextViewText(this.e, "正在下载富媒体:" + d);
        this.b.setProgressBar(this.c, 100, i, false);
        Notification notification = new Notification(17301633, null, System.currentTimeMillis());
        notification.contentView = this.b;
        notification.contentIntent = PendingIntent.getActivity(this.f725a, 0, new Intent(), 0);
        notification.flags |= 32;
        notification.flags |= 2;
        this.g.notify(d, 0, notification);
    }

    @Override // com.baidu.android.pushservice.richmedia.s
    public void a(com.baidu.android.pushservice.richmedia.b bVar, com.baidu.android.pushservice.richmedia.r rVar) {
        String d = bVar.d.d();
        this.g.cancel(d, 0);
        com.baidu.android.pushservice.util.j fileDownloadingInfo = PushDatabase.getFileDownloadingInfo(PushDatabase.getDb(this.f725a), d);
        if (fileDownloadingInfo == null || fileDownloadingInfo.i != com.baidu.android.pushservice.richmedia.b.f) {
            return;
        }
        String str = fileDownloadingInfo.e;
        String str2 = fileDownloadingInfo.f;
        String str3 = str + "/" + str2.substring(0, str2.lastIndexOf(".")) + "/index.html";
        com.baidu.android.pushservice.b.j jVar = new com.baidu.android.pushservice.b.j();
        jVar.c("010401");
        jVar.a(this.h.f718a);
        jVar.c(7);
        jVar.e(this.h.b);
        jVar.a(System.currentTimeMillis());
        jVar.d(com.baidu.android.pushservice.b.m.d(this.f725a));
        jVar.a(0);
        com.baidu.android.pushservice.b.s.a(this.f725a, jVar);
        Intent intent = new Intent();
        intent.setClass(this.f725a, MediaViewActivity.class);
        intent.setData(Uri.fromFile(new File(str3)));
        intent.addFlags(268435456);
        this.f725a.startActivity(intent);
    }

    @Override // com.baidu.android.pushservice.richmedia.s
    public void a(com.baidu.android.pushservice.richmedia.b bVar, Throwable th) {
        String d = bVar.d.d();
        this.g.cancel(d, 0);
        Toast makeText = Toast.makeText(this.f725a, "下载富媒体" + Uri.parse(d).getAuthority() + "失败", 1);
        makeText.setGravity(17, 0, 0);
        makeText.show();
    }

    @Override // com.baidu.android.pushservice.richmedia.s
    public void b(com.baidu.android.pushservice.richmedia.b bVar) {
        this.g.cancel(bVar.d.d(), 0);
    }
}

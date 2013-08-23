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
import com.baidu.android.pushservice.richmedia.MediaViewActivity;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.io.File;
/* loaded from: classes.dex */
class o implements com.baidu.android.pushservice.richmedia.s {

    /* renamed from: a  reason: collision with root package name */
    public Context f619a;
    public RemoteViews b = null;
    public int c = 0;
    public int d = 0;
    public int e = 0;
    public int f = 0;
    NotificationManager g;
    final /* synthetic */ PushServiceReceiver h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(PushServiceReceiver pushServiceReceiver, Context context) {
        this.h = pushServiceReceiver;
        this.f619a = null;
        this.f619a = context;
        this.g = (NotificationManager) context.getSystemService("notification");
    }

    @Override // com.baidu.android.pushservice.richmedia.s
    public void a(com.baidu.android.pushservice.richmedia.b bVar) {
        Resources resources = this.f619a.getResources();
        String packageName = this.f619a.getPackageName();
        if (resources == null) {
            return;
        }
        int identifier = resources.getIdentifier("bpush_download_progress", "layout", packageName);
        this.b = new RemoteViews(this.f619a.getPackageName(), identifier);
        if (identifier != 0) {
            this.c = resources.getIdentifier("bpush_download_progress", LocaleUtil.INDONESIAN, packageName);
            this.d = resources.getIdentifier("bpush_progress_percent", LocaleUtil.INDONESIAN, packageName);
            this.e = resources.getIdentifier("bpush_progress_text", LocaleUtil.INDONESIAN, packageName);
            this.f = resources.getIdentifier("bpush_download_icon", LocaleUtil.INDONESIAN, packageName);
            this.b.setImageViewResource(this.f, this.f619a.getApplicationInfo().icon);
        }
    }

    @Override // com.baidu.android.pushservice.richmedia.s
    public void a(com.baidu.android.pushservice.richmedia.b bVar, com.baidu.android.pushservice.richmedia.m mVar) {
        String d = bVar.d.d();
        if (mVar.f637a == mVar.b || this.b == null) {
            return;
        }
        int i = (int) ((mVar.f637a * 100.0d) / mVar.b);
        this.b.setTextViewText(this.d, i + "%");
        this.b.setTextViewText(this.e, "正在下载富媒体:" + d);
        this.b.setProgressBar(this.c, 100, i, false);
        Notification notification = new Notification(17301633, null, System.currentTimeMillis());
        notification.contentView = this.b;
        notification.contentIntent = PendingIntent.getActivity(this.f619a, 0, new Intent(), 0);
        notification.flags |= 32;
        notification.flags |= 2;
        this.g.notify(d, 0, notification);
    }

    @Override // com.baidu.android.pushservice.richmedia.s
    public void a(com.baidu.android.pushservice.richmedia.b bVar, com.baidu.android.pushservice.richmedia.r rVar) {
        String d = bVar.d.d();
        this.g.cancel(d, 0);
        com.baidu.android.pushservice.util.i a2 = com.baidu.android.pushservice.util.e.a(com.baidu.android.pushservice.util.e.a(this.f619a), d);
        if (a2 == null || a2.i != com.baidu.android.pushservice.richmedia.b.f) {
            return;
        }
        String str = a2.e;
        String str2 = a2.f;
        String str3 = str + "/" + str2.substring(0, str2.lastIndexOf(".")) + "/index.html";
        Intent intent = new Intent();
        intent.setClass(this.f619a, MediaViewActivity.class);
        intent.setData(Uri.fromFile(new File(str3)));
        intent.addFlags(268435456);
        this.f619a.startActivity(intent);
    }

    @Override // com.baidu.android.pushservice.richmedia.s
    public void a(com.baidu.android.pushservice.richmedia.b bVar, Throwable th) {
        String d = bVar.d.d();
        this.g.cancel(d, 0);
        Toast makeText = Toast.makeText(this.f619a, "下载富媒体" + Uri.parse(d).getAuthority() + "失败", 1);
        makeText.setGravity(17, 0, 0);
        makeText.show();
    }

    @Override // com.baidu.android.pushservice.richmedia.s
    public void b(com.baidu.android.pushservice.richmedia.b bVar) {
        this.g.cancel(bVar.d.d(), 0);
    }
}

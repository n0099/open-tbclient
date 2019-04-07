package com.baidu.android.pushservice;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.widget.RemoteViews;
import android.widget.Toast;
import com.baidu.android.pushservice.d.a;
import com.baidu.android.pushservice.j.l;
import com.baidu.android.pushservice.j.m;
import com.baidu.android.pushservice.message.PublicMsg;
import com.baidu.android.pushservice.richmedia.MediaViewActivity;
import com.baidu.android.pushservice.richmedia.c;
import java.io.File;
import java.net.URISyntaxException;
import java.util.concurrent.locks.ReentrantLock;
@SuppressLint({"NewApi"})
/* loaded from: classes3.dex */
public class PushServiceReceiver extends BroadcastReceiver {
    private final ReentrantLock a = new ReentrantLock();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a implements com.baidu.android.pushservice.richmedia.f {
        public Context a;
        public RemoteViews b = null;
        public int c = 0;
        public int d = 0;
        public int e = 0;
        public int f = 0;
        NotificationManager g;

        a(Context context, PublicMsg publicMsg) {
            this.a = null;
            this.a = context;
            this.g = (NotificationManager) context.getSystemService(com.coloros.mcssdk.PushManager.MESSAGE_TYPE_NOTI);
        }

        @Override // com.baidu.android.pushservice.richmedia.f
        public void a(com.baidu.android.pushservice.richmedia.a aVar) {
            Resources resources = this.a.getResources();
            String packageName = this.a.getPackageName();
            if (resources == null) {
                return;
            }
            int identifier = resources.getIdentifier("bpush_download_progress", "layout", packageName);
            this.b = new RemoteViews(this.a.getPackageName(), identifier);
            if (identifier != 0) {
                this.c = resources.getIdentifier("bpush_download_progress", "id", packageName);
                this.d = resources.getIdentifier("bpush_progress_percent", "id", packageName);
                this.e = resources.getIdentifier("bpush_progress_text", "id", packageName);
                this.f = resources.getIdentifier("bpush_download_icon", "id", packageName);
                this.b.setImageViewResource(this.f, this.a.getApplicationInfo().icon);
            }
        }

        @Override // com.baidu.android.pushservice.richmedia.f
        @SuppressLint({"NewApi"})
        public void a(com.baidu.android.pushservice.richmedia.a aVar, com.baidu.android.pushservice.richmedia.b bVar) {
            String c = aVar.d.c();
            if (bVar.a == bVar.b || this.b == null) {
                return;
            }
            int i = (int) ((bVar.a * 100.0d) / bVar.b);
            this.b.setTextViewText(this.d, i + "%");
            this.b.setTextViewText(this.e, "正在下载富媒体:" + c);
            this.b.setProgressBar(this.c, 100, i, false);
            Notification build = Build.VERSION.SDK_INT >= 16 ? new Notification.Builder(this.a).setSmallIcon(17301633).setWhen(System.currentTimeMillis()).build() : new Notification(17301633, null, System.currentTimeMillis());
            build.contentView = this.b;
            build.contentIntent = PendingIntent.getActivity(this.a, 0, new Intent(), 0);
            build.flags |= 32;
            build.flags |= 2;
            this.g.notify(c, 0, build);
        }

        @Override // com.baidu.android.pushservice.richmedia.f
        public void a(com.baidu.android.pushservice.richmedia.a aVar, com.baidu.android.pushservice.richmedia.e eVar) {
            Uri fromFile;
            String c = aVar.d.c();
            this.g.cancel(c, 0);
            a.g a = com.baidu.android.pushservice.d.a.a(this.a, c);
            if (a == null || a.i != com.baidu.android.pushservice.richmedia.a.f) {
                return;
            }
            String str = a.e;
            String str2 = a.f;
            if (TextUtils.isEmpty(str2) || str2.length() <= 0) {
                return;
            }
            String str3 = str + "/" + str2.substring(0, str2.lastIndexOf(".")) + "/index.html";
            Intent intent = new Intent();
            intent.setClass(this.a, MediaViewActivity.class);
            int A = m.A(this.a, this.a.getPackageName());
            File file = new File(str3);
            if (A >= 24) {
                ContentValues contentValues = new ContentValues(1);
                contentValues.put("_data", file.getAbsolutePath());
                fromFile = this.a.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
            } else {
                fromFile = Uri.fromFile(file);
            }
            intent.setData(fromFile);
            intent.addFlags(268435456);
            try {
                this.a.startActivity(intent);
            } catch (ActivityNotFoundException e) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.android.pushservice.PushServiceReceiver.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(a.this.a, "富媒体推送没有声明必须的Activity，请检查！", 1).show();
                    }
                });
                com.baidu.android.pushservice.g.a.a("PushServiceReceiver", e, this.a);
            }
        }

        @Override // com.baidu.android.pushservice.richmedia.f
        public void a(com.baidu.android.pushservice.richmedia.a aVar, Throwable th) {
            if (this.a == null) {
                return;
            }
            final String c = aVar.d.c();
            this.g.cancel(c, 0);
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.android.pushservice.PushServiceReceiver.a.2
                @Override // java.lang.Runnable
                public void run() {
                    Toast makeText = Toast.makeText(a.this.a, "下载富媒体" + Uri.parse(c).getAuthority() + "失败", 1);
                    makeText.setGravity(17, 0, 0);
                    makeText.show();
                }
            });
        }

        @Override // com.baidu.android.pushservice.richmedia.f
        public void b(com.baidu.android.pushservice.richmedia.a aVar) {
            this.g.cancel(aVar.d.c(), 0);
        }
    }

    private static Intent a(String str) {
        try {
            Intent intent = new Intent();
            try {
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                intent.setFlags(268435456);
                return intent;
            } catch (Exception e) {
                return intent;
            }
        } catch (Exception e2) {
            return null;
        }
    }

    public static void a(Context context, PublicMsg publicMsg) {
        if (!Environment.getExternalStorageState().equals("mounted")) {
            Toast makeText = Toast.makeText(context, "请插入SD卡", 1);
            makeText.setGravity(17, 0, 0);
            makeText.show();
        } else if (publicMsg == null || publicMsg.mUrl == null) {
        } else {
            Uri parse = Uri.parse(publicMsg.mUrl);
            String path = parse.getPath();
            if (TextUtils.isEmpty(parse.getPath())) {
                return;
            }
            File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/baidu/pushservice/files/" + parse.getAuthority() + "/" + path.substring(0, path.lastIndexOf(47)));
            com.baidu.android.pushservice.richmedia.c a2 = com.baidu.android.pushservice.richmedia.d.a(c.a.REQ_TYPE_GET_ZIP, parse.toString());
            a2.a = publicMsg.mPkgName;
            a2.b = file.getAbsolutePath();
            a2.c = publicMsg.mTitle;
            a2.d = publicMsg.mDescription;
            new com.baidu.android.pushservice.richmedia.a(context, new a(context, publicMsg), a2).start();
        }
    }

    private static void a(Context context, PublicMsg publicMsg, byte[] bArr, byte[] bArr2) {
        Intent intent = new Intent();
        intent.setPackage(publicMsg.mPkgName);
        intent.putExtra("method", "com.baidu.android.pushservice.action.notification.ARRIVED");
        intent.putExtra("msgid", publicMsg.mMsgId);
        intent.putExtra("notification_title", publicMsg.mTitle);
        intent.putExtra("notification_content", publicMsg.mDescription);
        intent.putExtra("extra_extra_custom_content", publicMsg.mCustomContent);
        intent.putExtra("com.baidu.pushservice.app_id", publicMsg.mAppId);
        intent.putExtra("baidu_message_secur_info", bArr);
        intent.putExtra("baidu_message_body", bArr2);
        m.b(context, intent, PushConstants.ACTION_RECEIVE, publicMsg.mPkgName);
    }

    public static void a(Context context, String str, String str2, PublicMsg publicMsg) {
        Intent b;
        try {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(com.coloros.mcssdk.PushManager.MESSAGE_TYPE_NOTI);
            if (TextUtils.isEmpty(publicMsg.mPkgContent)) {
                b = !TextUtils.isEmpty(publicMsg.mUrl) ? a(publicMsg.mUrl) : b(context, publicMsg);
            } else {
                try {
                    b = Intent.parseUri(publicMsg.mPkgContent, 1);
                    b.setPackage(context.getPackageName());
                } catch (URISyntaxException e) {
                    b = b(context, publicMsg);
                }
            }
            if (b != null) {
                PendingIntent activity = PendingIntent.getActivity(context, 0, b, 0);
                Notification a2 = d.a(context, 0, 7, publicMsg.mTitle, publicMsg.mDescription, false);
                if (a2 != null) {
                    a2.contentIntent = activity;
                    notificationManager.notify(System.currentTimeMillis() + "", 0, a2);
                }
            }
        } catch (Exception e2) {
        }
    }

    private static Intent b(Context context, PublicMsg publicMsg) {
        try {
            Intent intent = new Intent();
            try {
                intent.setClassName(context.getPackageName(), publicMsg.getLauncherActivityName(context, context.getPackageName()));
                intent.setFlags(268435456);
                return intent;
            } catch (Exception e) {
                return intent;
            }
        } catch (Exception e2) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, String str, String str2, PublicMsg publicMsg, String str3) {
        Intent intent = new Intent("com.baidu.android.pushservice.action.media.CLICK");
        intent.setClassName(str, str2);
        intent.setData(Uri.parse("content://" + publicMsg.mMsgId));
        intent.putExtra("public_msg", publicMsg);
        intent.putExtra("app_id", str3);
        PendingIntent service = PendingIntent.getService(context, 0, intent, 0);
        Intent intent2 = new Intent();
        intent2.setClassName(str, str2);
        intent2.setAction("com.baidu.android.pushservice.action.media.DELETE");
        intent2.setData(Uri.parse("content://" + publicMsg.mMsgId));
        intent2.putExtra("public_msg", publicMsg);
        intent2.putExtra("app_id", str3);
        PendingIntent service2 = PendingIntent.getService(context, 0, intent2, 0);
        Notification a2 = d.a(context, 8888, publicMsg.mTitle, "富媒体消息：点击后下载与查看", m.q(context, publicMsg.mPkgName));
        a2.contentIntent = service;
        a2.deleteIntent = service2;
        ((NotificationManager) context.getSystemService(com.coloros.mcssdk.PushManager.MESSAGE_TYPE_NOTI)).notify(publicMsg.mMsgId, 0, a2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, String str, String str2, PublicMsg publicMsg, byte[] bArr, byte[] bArr2) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(com.coloros.mcssdk.PushManager.MESSAGE_TYPE_NOTI);
        Intent intent = new Intent();
        intent.setClassName(str, str2);
        intent.setAction("com.baidu.android.pushservice.action.privatenotification.CLICK");
        intent.setData(Uri.parse("content://" + publicMsg.mMsgId));
        intent.putExtra("public_msg", publicMsg);
        intent.putExtra("app_id", publicMsg.mAppId);
        intent.putExtra("msg_id", publicMsg.mMsgId);
        intent.putExtra("baidu_message_secur_info", bArr);
        intent.putExtra("baidu_message_body", bArr2);
        PendingIntent service = PendingIntent.getService(context, 0, intent, 0);
        Intent intent2 = new Intent();
        intent2.setClassName(str, str2);
        intent2.setAction("com.baidu.android.pushservice.action.privatenotification.DELETE");
        intent2.setData(Uri.parse("content://" + publicMsg.mMsgId));
        intent2.putExtra("public_msg", publicMsg);
        intent2.putExtra("app_id", publicMsg.mAppId);
        intent2.putExtra("msg_id", publicMsg.mMsgId);
        PendingIntent service2 = PendingIntent.getService(context, 0, intent2, 0);
        boolean q = m.q(context, publicMsg.mPkgName);
        Notification a2 = publicMsg.mNotificationBuilder == 0 ? d.a(context, publicMsg.mNotificationBuilder, publicMsg.mNotificationBasicStyle, publicMsg.mTitle, publicMsg.mDescription, q) : d.a(context, publicMsg.mNotificationBuilder, publicMsg.mTitle, publicMsg.mDescription, q);
        a2.contentIntent = service;
        a2.deleteIntent = service2;
        notificationManager.notify(publicMsg.mMsgId, 0, a2);
        a(context, publicMsg, bArr, bArr2);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, Intent intent) {
        String action = intent.getAction();
        try {
            intent.getByteArrayExtra("baidu_message_secur_info");
            if ("android.intent.action.BOOT_COMPLETED".equals(action) || "android.net.conn.CONNECTIVITY_CHANGE".equals(action) || "android.intent.action.USER_PRESENT".equals(action) || "android.intent.action.MEDIA_CHECKING".equals(action) || "android.intent.action.ACTION_POWER_CONNECTED".equals(action) || "android.intent.action.ACTION_POWER_DISCONNECTED".equals(action) || "android.bluetooth.adapter.action.STATE_CHANGED".equals(action)) {
                if (com.baidu.android.pushservice.c.e.h(context) || m.h(context.getApplicationContext()) <= 0) {
                    return;
                }
                l.d(context);
            } else if (!"com.baidu.android.pushservice.action.notification.SHOW".equals(action)) {
                if ("com.baidu.android.pushservice.action.media.CLICK".equals(action)) {
                    com.baidu.android.pushservice.g.a.a("PushServiceReceiver", "Rich media notification clicked", context.getApplicationContext());
                    try {
                        PublicMsg publicMsg = intent.hasExtra("public_msg") ? (PublicMsg) intent.getParcelableExtra("public_msg") : null;
                        if (m.b(context, publicMsg)) {
                            a(context, publicMsg);
                        }
                    } catch (ClassCastException e) {
                    }
                }
            } else if (com.baidu.android.pushservice.c.e.h(context)) {
            } else {
                if (!m.y(context)) {
                    f.g(context);
                    return;
                }
                final String stringExtra = intent.getStringExtra("pushService_package_name");
                final String stringExtra2 = intent.getStringExtra("service_name");
                final String stringExtra3 = intent.getStringExtra("notify_type");
                final String stringExtra4 = intent.getStringExtra("app_id");
                final byte[] byteArrayExtra = intent.getByteArrayExtra("baidu_message_body");
                final byte[] byteArrayExtra2 = intent.getByteArrayExtra("baidu_message_secur_info");
                int intExtra = intent.getIntExtra("baidu_message_type", -1);
                final String stringExtra5 = intent.getStringExtra("message_id");
                if (TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(stringExtra2) || byteArrayExtra == null || byteArrayExtra2 == null || intExtra == -1 || m.t(context, stringExtra5) || !com.baidu.android.pushservice.d.a.e(context, stringExtra5)) {
                    return;
                }
                com.baidu.android.pushservice.i.d.a().a(new com.baidu.android.pushservice.i.c("showPrivateNotification", (short) 99) { // from class: com.baidu.android.pushservice.PushServiceReceiver.1
                    @Override // com.baidu.android.pushservice.i.c
                    public void a() {
                        PublicMsg a2 = com.baidu.android.pushservice.message.a.e.a(context, stringExtra4, stringExtra5, byteArrayExtra2, byteArrayExtra);
                        if (a2 == null) {
                            return;
                        }
                        if (com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PRIVATE.equals(stringExtra3)) {
                            PushServiceReceiver.b(context, stringExtra, stringExtra2, a2, byteArrayExtra2, byteArrayExtra);
                        } else if ("rich_media".equals(stringExtra3)) {
                            PushServiceReceiver.b(context, stringExtra, stringExtra2, a2, stringExtra4);
                        }
                    }
                });
            }
        } catch (Exception e2) {
        }
    }
}

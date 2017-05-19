package com.baidu.android.pushservice;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
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
import com.baidu.android.pushservice.config.ModeConfig;
import com.baidu.android.pushservice.h.o;
import com.baidu.android.pushservice.h.t;
import com.baidu.android.pushservice.h.u;
import com.baidu.android.pushservice.message.PublicMsg;
import com.baidu.android.pushservice.richmedia.MediaViewActivity;
import com.baidu.android.pushservice.richmedia.c;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import java.io.File;
import java.net.URISyntaxException;
/* loaded from: classes2.dex */
public class PushServiceReceiverUtil {
    private static final short NOTIFICATIONBASICSTYLE = 7;
    private static final String TAG = "PushServiceReceiverUtil";

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
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
            this.g = (NotificationManager) context.getSystemService("notification");
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
            o.h a = o.a(this.a, c);
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
            int z = u.z(this.a, this.a.getPackageName());
            File file = new File(str3);
            if (z >= 24) {
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
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.android.pushservice.PushServiceReceiverUtil.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(a.this.a, "富媒体推送没有声明必须的Activity，请检查！", 1).show();
                    }
                });
                com.baidu.android.pushservice.e.b.a(PushServiceReceiverUtil.TAG, e, this.a);
            }
        }

        @Override // com.baidu.android.pushservice.richmedia.f
        public void a(com.baidu.android.pushservice.richmedia.a aVar, Throwable th) {
            if (this.a == null) {
                return;
            }
            final String c = aVar.d.c();
            this.g.cancel(c, 0);
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.android.pushservice.PushServiceReceiverUtil.a.2
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

    private static Intent getLauncherActivityIntent(Context context, PublicMsg publicMsg) {
        Intent intent;
        Exception e;
        try {
            intent = new Intent();
        } catch (Exception e2) {
            intent = null;
            e = e2;
        }
        try {
            intent.setClassName(context.getPackageName(), publicMsg.getLauncherActivityName(context, context.getPackageName()));
            intent.setFlags(268435456);
        } catch (Exception e3) {
            e = e3;
            com.baidu.android.pushservice.e.a.a(TAG, e);
            return intent;
        }
        return intent;
    }

    private static Intent getOpenUrlIntent(String str) {
        Intent intent;
        Exception e;
        try {
            intent = new Intent();
        } catch (Exception e2) {
            intent = null;
            e = e2;
        }
        try {
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            intent.setFlags(268435456);
        } catch (Exception e3) {
            e = e3;
            com.baidu.android.pushservice.e.a.a(TAG, e);
            return intent;
        }
        return intent;
    }

    public static void handleRichMediaClick(Context context, PublicMsg publicMsg) {
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
            com.baidu.android.pushservice.e.a.c(TAG, "<<< download url " + parse.toString());
            com.baidu.android.pushservice.richmedia.c a2 = com.baidu.android.pushservice.richmedia.d.a(c.a.REQ_TYPE_GET_ZIP, parse.toString());
            a2.a = publicMsg.mPkgName;
            a2.b = file.getAbsolutePath();
            a2.c = publicMsg.mTitle;
            a2.d = publicMsg.mDescription;
            new com.baidu.android.pushservice.richmedia.a(context, new a(context, publicMsg), a2).start();
        }
    }

    public static void onReceive(final Context context, Intent intent) {
        String action = intent.getAction();
        try {
            intent.getByteArrayExtra("baidu_message_secur_info");
            if ("android.intent.action.BOOT_COMPLETED".equals(action) || "android.net.conn.CONNECTIVITY_CHANGE".equals(action) || "android.intent.action.USER_PRESENT".equals(action) || "android.intent.action.MEDIA_CHECKING".equals(action) || "android.intent.action.ACTION_POWER_CONNECTED".equals(action) || "android.intent.action.ACTION_POWER_DISCONNECTED".equals(action) || "android.bluetooth.adapter.action.STATE_CHANGED".equals(action)) {
                com.baidu.android.pushservice.e.a.b(TAG, "start PushSerevice for by " + action);
                if (ModeConfig.isProxyMode(context) || u.h(context.getApplicationContext()) <= 0) {
                    return;
                }
                t.d(context);
            } else if (!"com.baidu.android.pushservice.action.notification.SHOW".equals(action)) {
                if ("com.baidu.android.pushservice.action.media.CLICK".equals(action)) {
                    com.baidu.android.pushservice.e.b.a(TAG, "Rich media notification clicked", context.getApplicationContext());
                    try {
                        PublicMsg publicMsg = intent.hasExtra("public_msg") ? (PublicMsg) intent.getParcelableExtra("public_msg") : null;
                        if (u.b(context, publicMsg)) {
                            handleRichMediaClick(context, publicMsg);
                        }
                    } catch (ClassCastException e) {
                        com.baidu.android.pushservice.e.a.d(TAG, "Rich media notification clicked, parse pMsg exception");
                    }
                }
            } else if (ModeConfig.isProxyMode(context)) {
            } else {
                final String stringExtra = intent.getStringExtra("pushService_package_name");
                final String stringExtra2 = intent.getStringExtra("service_name");
                final String stringExtra3 = intent.getStringExtra("notify_type");
                final String stringExtra4 = intent.getStringExtra("app_id");
                final byte[] byteArrayExtra = intent.getByteArrayExtra("baidu_message_body");
                final byte[] byteArrayExtra2 = intent.getByteArrayExtra("baidu_message_secur_info");
                int intExtra = intent.getIntExtra("baidu_message_type", -1);
                final String stringExtra5 = intent.getStringExtra("message_id");
                if (TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(stringExtra2) || byteArrayExtra == null || byteArrayExtra2 == null || intExtra == -1) {
                    com.baidu.android.pushservice.e.a.c(TAG, "Extra not valid, servicePkgName=" + stringExtra + " serviceName=" + stringExtra2 + " pMsg==null?  msgBody==null? " + (byteArrayExtra == null) + " checkInfo==null? " + (byteArrayExtra2 == null) + " msgType=" + intExtra);
                } else if (u.r(context, stringExtra5)) {
                    com.baidu.android.pushservice.e.a.e(TAG, " receive message duplicated !");
                } else {
                    com.baidu.android.pushservice.g.d.a().a(new com.baidu.android.pushservice.g.c("showPrivateNotification", (short) 99) { // from class: com.baidu.android.pushservice.PushServiceReceiverUtil.1
                        @Override // com.baidu.android.pushservice.g.c
                        public void a() {
                            PublicMsg a2 = com.baidu.android.pushservice.message.a.e.a(context, stringExtra4, stringExtra5, byteArrayExtra2, byteArrayExtra);
                            if (a2 == null) {
                                com.baidu.android.pushservice.e.a.e(PushServiceReceiverUtil.TAG, "notification check fail !");
                                return;
                            }
                            u.a(context, a2);
                            if ("private".equals(stringExtra3)) {
                                PushServiceReceiverUtil.showPrivateNotification(context, stringExtra, stringExtra2, a2, stringExtra5, stringExtra4);
                            } else if ("rich_media".equals(stringExtra3)) {
                                PushServiceReceiverUtil.showRichNotification(context, stringExtra, stringExtra2, a2, stringExtra4);
                            }
                        }
                    });
                }
            }
        } catch (Exception e2) {
            com.baidu.android.pushservice.e.a.c(TAG, "attack by null Serializable data and return");
        }
    }

    private static void sendNotificationArrivedReceiver(Context context, PublicMsg publicMsg) {
        Intent intent = new Intent();
        intent.setPackage(publicMsg.mPkgName);
        intent.putExtra(PushConstants.EXTRA_METHOD, "com.baidu.android.pushservice.action.notification.ARRIVED");
        intent.putExtra("notification_title", publicMsg.mTitle);
        intent.putExtra("notification_content", publicMsg.mDescription);
        intent.putExtra("extra_extra_custom_content", publicMsg.mCustomContent);
        intent.putExtra("com.baidu.pushservice.app_id", publicMsg.mAppId);
        u.a(context, publicMsg.mMsgId, publicMsg.mAppId, publicMsg.mTitle, publicMsg.mDescription, publicMsg.mCustomContent);
        u.b(context, intent, PushConstants.ACTION_RECEIVE, publicMsg.mPkgName);
    }

    public static void showHWNotification(Context context, String str, String str2, PublicMsg publicMsg) {
        Intent launcherActivityIntent;
        try {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            if (!TextUtils.isEmpty(publicMsg.mPkgContent)) {
                try {
                    launcherActivityIntent = Intent.parseUri(publicMsg.mPkgContent, 1);
                    launcherActivityIntent.setPackage(context.getPackageName());
                    com.baidu.android.pushservice.e.a.c(TAG, "Open Special Activity   " + publicMsg.mPkgContent);
                } catch (URISyntaxException e) {
                    com.baidu.android.pushservice.e.a.a(TAG, e);
                    launcherActivityIntent = getLauncherActivityIntent(context, publicMsg);
                }
            } else if (TextUtils.isEmpty(publicMsg.mUrl)) {
                launcherActivityIntent = getLauncherActivityIntent(context, publicMsg);
                com.baidu.android.pushservice.e.a.c(TAG, "Start Application MainActivity");
            } else {
                launcherActivityIntent = getOpenUrlIntent(publicMsg.mUrl);
                com.baidu.android.pushservice.e.a.c(TAG, "Start URL   " + publicMsg.mUrl);
            }
            if (launcherActivityIntent != null) {
                PendingIntent activity = PendingIntent.getActivity(context, 0, launcherActivityIntent, 0);
                Notification a2 = d.a(context, 0, 7, publicMsg.mTitle, publicMsg.mDescription, false);
                if (a2 != null) {
                    a2.contentIntent = activity;
                    notificationManager.notify(System.currentTimeMillis() + "", 0, a2);
                }
            }
        } catch (Exception e2) {
            com.baidu.android.pushservice.e.a.a(TAG, e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void showPrivateNotification(Context context, String str, String str2, PublicMsg publicMsg, String str3, String str4) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        Intent intent = new Intent();
        intent.setClassName(str, str2);
        intent.setAction("com.baidu.android.pushservice.action.privatenotification.CLICK");
        intent.setData(Uri.parse("content://" + str3));
        intent.putExtra("public_msg", publicMsg);
        intent.putExtra("app_id", str4);
        intent.putExtra(PbActivityConfig.KEY_MSG_ID, str3);
        PendingIntent service = PendingIntent.getService(context, 0, intent, 0);
        Intent intent2 = new Intent();
        intent2.setClassName(str, str2);
        intent2.setAction("com.baidu.android.pushservice.action.privatenotification.DELETE");
        intent2.setData(Uri.parse("content://" + str3));
        intent2.putExtra("public_msg", publicMsg);
        intent2.putExtra("app_id", str4);
        intent2.putExtra(PbActivityConfig.KEY_MSG_ID, str3);
        PendingIntent service2 = PendingIntent.getService(context, 0, intent2, 0);
        boolean p = u.p(context, publicMsg.mPkgName);
        Notification a2 = publicMsg.mNotificationBuilder == 0 ? d.a(context, publicMsg.mNotificationBuilder, publicMsg.mNotificationBasicStyle, publicMsg.mTitle, publicMsg.mDescription, p) : d.a(context, publicMsg.mNotificationBuilder, publicMsg.mTitle, publicMsg.mDescription, p);
        a2.contentIntent = service;
        a2.deleteIntent = service2;
        notificationManager.notify(str3, 0, a2);
        sendNotificationArrivedReceiver(context, publicMsg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void showRichNotification(Context context, String str, String str2, PublicMsg publicMsg, String str3) {
        Intent intent = new Intent("com.baidu.android.pushservice.action.media.CLICK");
        intent.setClassName(str, str2);
        intent.setData(Uri.parse("content://" + publicMsg.mMsgId));
        intent.putExtra("public_msg", publicMsg);
        intent.putExtra("app_id", str3);
        PendingIntent service = PendingIntent.getService(context, 0, intent, 0);
        com.baidu.android.pushservice.e.a.c(TAG, "Set click broadcast, pkgname: " + publicMsg.mPkgName + " action: com.baidu.android.pushservice.action.media.CLICK");
        u.a(context, publicMsg);
        Intent intent2 = new Intent();
        intent2.setClassName(str, str2);
        intent2.setAction("com.baidu.android.pushservice.action.media.DELETE");
        intent2.setData(Uri.parse("content://" + publicMsg.mMsgId));
        intent2.putExtra("public_msg", publicMsg);
        intent2.putExtra("app_id", str3);
        PendingIntent service2 = PendingIntent.getService(context, 0, intent2, 0);
        Notification a2 = d.a(context, 8888, publicMsg.mTitle, "富媒体消息：点击后下载与查看", u.p(context, publicMsg.mPkgName));
        a2.contentIntent = service;
        a2.deleteIntent = service2;
        ((NotificationManager) context.getSystemService("notification")).notify(publicMsg.mMsgId, 0, a2);
    }
}

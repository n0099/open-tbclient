package com.baidu.android.pushservice;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.a0.m;
import com.baidu.android.pushservice.message.PublicMsg;
import com.baidu.android.pushservice.pull.ClientEventInfo;
import com.baidu.android.pushservice.util.Utility;
import com.baidu.android.pushservice.x.k;
import com.baidu.searchbox.IntentConstants;
import com.baidu.searchbox.downloads.DownloadConstants;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import java.net.URISyntaxException;
import org.json.JSONException;
import org.json.JSONObject;
@SuppressLint({"NewApi"})
/* loaded from: classes.dex */
public class PushServiceReceiver extends BroadcastReceiver {
    public static Handler a;

    /* loaded from: classes.dex */
    public class a extends com.baidu.android.pushservice.z.c {
        public final /* synthetic */ Context c;
        public final /* synthetic */ Intent d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(PushServiceReceiver pushServiceReceiver, String str, short s, Context context, Intent intent) {
            super(str, s);
            this.c = context;
            this.d = intent;
        }

        @Override // com.baidu.android.pushservice.z.c
        public void a() {
            if (Utility.E(this.c) || !m.a(this.c, (Intent) null)) {
                try {
                    f.a(this.c).a(this.d);
                } catch (Exception unused) {
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends com.baidu.android.pushservice.z.c {
        public final /* synthetic */ Context c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ byte[] f;
        public final /* synthetic */ byte[] g;
        public final /* synthetic */ String h;
        public final /* synthetic */ String i;
        public final /* synthetic */ int j;
        public final /* synthetic */ String k;
        public final /* synthetic */ String l;
        public final /* synthetic */ int m;
        public final /* synthetic */ int n;
        public final /* synthetic */ String o;
        public final /* synthetic */ String p;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(PushServiceReceiver pushServiceReceiver, String str, short s, Context context, String str2, String str3, byte[] bArr, byte[] bArr2, String str4, String str5, int i, String str6, String str7, int i2, int i3, String str8, String str9) {
            super(str, s);
            this.c = context;
            this.d = str2;
            this.e = str3;
            this.f = bArr;
            this.g = bArr2;
            this.h = str4;
            this.i = str5;
            this.j = i;
            this.k = str6;
            this.l = str7;
            this.m = i2;
            this.n = i3;
            this.o = str8;
            this.p = str9;
        }

        @Override // com.baidu.android.pushservice.z.c
        public void a() {
            PublicMsg a = com.baidu.android.pushservice.w.m.e.a(this.c, this.d, this.e, this.f, this.g);
            if (a == null) {
                return;
            }
            com.baidu.android.pushservice.x.h hVar = new com.baidu.android.pushservice.x.h(this.h, this.i, this.f, this.g, this.j, this.k, this.l, this.m, this.n, this.o);
            if (com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PRIVATE.equals(this.p)) {
                PushServiceReceiver.b(this.c, a, hVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c extends com.baidu.android.pushservice.z.c {
        public final /* synthetic */ Context c;
        public final /* synthetic */ PublicMsg d;
        public final /* synthetic */ com.baidu.android.pushservice.x.h e;

        public c(Context context, PublicMsg publicMsg, com.baidu.android.pushservice.x.h hVar) {
            this.c = context;
            this.d = publicMsg;
            this.e = hVar;
        }

        @Override // com.baidu.android.pushservice.z.c
        public void a() {
            PublicMsg publicMsg;
            Context context;
            PublicMsg publicMsg2;
            com.baidu.android.pushservice.x.h hVar;
            boolean z;
            if (this.c == null || (publicMsg = this.d) == null || this.e == null) {
                return;
            }
            Bitmap a = TextUtils.isEmpty(publicMsg.mImgUrl) ? null : com.baidu.android.pushservice.q.a.a().a(this.d.mImgUrl);
            com.baidu.android.pushservice.ach.d.e eVar = new com.baidu.android.pushservice.ach.d.e();
            PublicMsg publicMsg3 = this.d;
            eVar.a = publicMsg3.mTitle;
            eVar.b = publicMsg3.mDescription;
            eVar.c = a;
            com.baidu.android.pushservice.x.h hVar2 = this.e;
            int i = hVar2.h;
            eVar.d = i;
            eVar.e = hVar2.j;
            if (com.baidu.android.pushservice.w.m.f.a(i) == 3) {
                if (PushServiceReceiver.a(this.c, this.d, eVar, this.e, "com.baidu.android.pushservice.push.importance_HIGH") || !com.baidu.android.pushservice.v.c.a().b(this.c, this.e.h) || !com.baidu.android.pushservice.v.c.a().a(this.c, this.e.h)) {
                    return;
                }
                context = this.c;
                publicMsg2 = this.d;
                hVar = this.e;
                z = true;
            } else if (!com.baidu.android.pushservice.v.c.a().b(this.c, this.e.h) || !com.baidu.android.pushservice.v.c.a().a(this.c, this.e.h)) {
                PushServiceReceiver.a(this.c, this.d, eVar, this.e, "com.baidu.android.pushservice.push.importance_HIGH");
                return;
            } else {
                context = this.c;
                publicMsg2 = this.d;
                hVar = this.e;
                z = false;
            }
            PushServiceReceiver.b(context, publicMsg2, eVar, hVar, z);
        }
    }

    /* loaded from: classes.dex */
    public static class d implements com.baidu.android.pushservice.ach.d.b {
        public final /* synthetic */ Context a;
        public final /* synthetic */ com.baidu.android.pushservice.x.h b;
        public final /* synthetic */ PublicMsg c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ com.baidu.android.pushservice.ach.d.e e;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d dVar = d.this;
                PushServiceReceiver.a(dVar.a, dVar.c, dVar.e, dVar.b, "com.baidu.android.pushservice.push.importance_HIGH");
            }
        }

        /* loaded from: classes.dex */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d dVar = d.this;
                PushServiceReceiver.a(dVar.a, dVar.c, dVar.e, dVar.b, "com.baidu.android.pushservice.push.importance_low");
            }
        }

        public d(Context context, com.baidu.android.pushservice.x.h hVar, PublicMsg publicMsg, boolean z, com.baidu.android.pushservice.ach.d.e eVar) {
            this.a = context;
            this.b = hVar;
            this.c = publicMsg;
            this.d = z;
            this.e = eVar;
        }

        @Override // com.baidu.android.pushservice.ach.d.b
        public void a() {
            com.baidu.android.pushservice.x.h hVar = this.b;
            Intent b2 = PushServiceReceiver.b(hVar.a, hVar.b, this.c, hVar.g);
            if (b2 == null) {
                return;
            }
            try {
                this.a.startService(b2);
            } catch (Exception unused) {
            }
        }

        @Override // com.baidu.android.pushservice.ach.d.b
        public void a(int i) {
            Handler handler;
            Runnable bVar;
            long j = this.b.i * 1000;
            if (j <= 0) {
                j = 5000;
            }
            if (PushServiceReceiver.a == null) {
                PushServiceReceiver.a = new Handler(this.a.getMainLooper());
            }
            if (!this.d) {
                if (com.baidu.android.pushservice.w.m.f.a(this.b.h) == 0) {
                    handler = PushServiceReceiver.a;
                    bVar = new a();
                } else if (com.baidu.android.pushservice.w.m.f.a(this.b.h) == 1) {
                    handler = PushServiceReceiver.a;
                    bVar = new b();
                }
                handler.postDelayed(bVar, j);
            }
            Context context = this.a;
            PublicMsg publicMsg = this.c;
            com.baidu.android.pushservice.x.h hVar = this.b;
            PushServiceReceiver.b(context, publicMsg, hVar.c, hVar.d, hVar.f, i, hVar.g);
        }

        @Override // com.baidu.android.pushservice.ach.d.b
        public void b() {
            if (this.d) {
                return;
            }
            PushServiceReceiver.a(this.a, this.c, this.e, this.b, "com.baidu.android.pushservice.push.importance_HIGH");
        }

        @Override // com.baidu.android.pushservice.ach.d.b
        public void b(int i) {
            com.baidu.android.pushservice.a0.h.a(this.a, this.b.e);
            com.baidu.android.pushservice.x.h hVar = this.b;
            Intent b2 = PushServiceReceiver.b(hVar.a, this.c, hVar.c, hVar.d, hVar.g);
            if (b2 == null) {
                return;
            }
            b2.putExtra("float_window_show_type", i);
            b2.addFlags(LaunchTaskConstants.OTHER_PROCESS);
            try {
                this.a.startActivity(b2);
            } catch (Exception unused) {
            }
        }
    }

    public static Intent a(Context context, PublicMsg publicMsg) {
        try {
            Intent intent = new Intent();
            try {
                intent.setClassName(context.getPackageName(), publicMsg.getLauncherActivityName(context, context.getPackageName()));
                intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
                return intent;
            } catch (Exception unused) {
                return intent;
            }
        } catch (Exception unused2) {
            return null;
        }
    }

    public static Intent a(Context context, String str) {
        try {
            Intent intent = new Intent();
            try {
                intent.setAction(IntentConstants.ACTION_BOX_BROWSER);
                intent.setData(Uri.parse(str));
                intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
                return intent;
            } catch (Exception unused) {
                return intent;
            }
        } catch (Exception unused2) {
            return null;
        }
    }

    public static void a(Context context, boolean z) {
        if (com.baidu.android.pushservice.y.c.b(context) > 0 && Utility.s(context) >= com.baidu.android.pushservice.y.c.c(context)) {
            f.a(context).a(z, z ? com.baidu.android.pushservice.y.c.b(context) : 60);
        } else if (z) {
            f.a(context).c();
        }
    }

    public static boolean a(Context context, PublicMsg publicMsg, com.baidu.android.pushservice.ach.d.e eVar, com.baidu.android.pushservice.x.h hVar, String str) {
        if (!com.baidu.android.pushservice.w.m.f.b(hVar.h) || com.baidu.android.pushservice.a0.h.b(context) == 0) {
            return false;
        }
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        boolean o = Utility.o(context, publicMsg.mPkgName);
        int i = publicMsg.mNotificationBuilder;
        Notification a2 = i == 0 ? NotificationBuilderManager.a(context, i, publicMsg.mNotificationBasicStyle, publicMsg.mTitle, publicMsg.mDescription, o, eVar.c, publicMsg.mGroup, str) : NotificationBuilderManager.a(context, i, publicMsg.mTitle, publicMsg.mDescription, o, publicMsg.mBuilderRes, publicMsg.mImgUrl, publicMsg.mSummary, publicMsg.mGroup);
        if (k.a && publicMsg.mNotificationBuilder >= 100) {
            hVar.g = com.baidu.android.pushservice.w.m.e.a(hVar.g, "c_downgrade", 1);
        }
        PendingIntent activity = PendingIntent.getActivity(context, 0, b(hVar.a, publicMsg, hVar.c, hVar.d, hVar.g), Utility.a(0));
        PendingIntent service = PendingIntent.getService(context, 0, b(hVar.a, hVar.b, publicMsg, hVar.g), Utility.a(0));
        a2.contentIntent = activity;
        a2.deleteIntent = service;
        notificationManager.notify(hVar.e, a2);
        NotificationBuilderManager.a(context, publicMsg, a2);
        String str2 = publicMsg.mMsgId + " notified!";
        b(context, publicMsg, hVar.c, hVar.d, hVar.f, 0, hVar.g);
        return true;
    }

    public static Intent b(String str, PublicMsg publicMsg, byte[] bArr, byte[] bArr2, String str2) {
        Intent intent = new Intent();
        intent.setClassName(str, PushNotifyDispatchActivity.class.getName());
        intent.setAction("com.baidu.android.pushservice.action.privatenotification.CLICK");
        intent.setData(Uri.parse(DownloadConstants.LOCAL_DATA_URI_PREFIX + publicMsg.mMsgId));
        intent.putExtra("public_msg", publicMsg);
        intent.putExtra("app_id", publicMsg.mAppId);
        intent.putExtra("msg_id", publicMsg.mMsgId);
        intent.putExtra("baidu_message_secur_info", bArr);
        intent.putExtra("baidu_message_body", bArr2);
        intent.putExtra("notification_log_ext", str2);
        return intent;
    }

    public static Intent b(String str, String str2, PublicMsg publicMsg, String str3) {
        Intent intent = new Intent();
        intent.setClassName(str, str2);
        intent.setAction("com.baidu.android.pushservice.action.privatenotification.DELETE");
        intent.setData(Uri.parse(DownloadConstants.LOCAL_DATA_URI_PREFIX + publicMsg.mMsgId));
        intent.putExtra("public_msg", publicMsg);
        intent.putExtra("app_id", publicMsg.mAppId);
        intent.putExtra("msg_id", publicMsg.mMsgId);
        intent.putExtra("notification_log_ext", str3);
        return intent;
    }

    public static void b(Context context, PublicMsg publicMsg) {
        Intent parseUri;
        try {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            if (TextUtils.isEmpty(publicMsg.mPkgContent)) {
                if (!TextUtils.isEmpty(publicMsg.mUrl)) {
                    parseUri = a(context, publicMsg.mUrl);
                }
                parseUri = a(context, publicMsg);
            } else {
                try {
                    parseUri = Intent.parseUri(publicMsg.mPkgContent, 1);
                    parseUri.setPackage(context.getPackageName());
                } catch (URISyntaxException unused) {
                }
            }
            if (parseUri != null) {
                PendingIntent activity = PendingIntent.getActivity(context, 0, parseUri, Utility.a(0));
                Notification a2 = NotificationBuilderManager.a(context, 0, 7, publicMsg.mTitle, publicMsg.mDescription, false, (Bitmap) null, publicMsg.mGroup, "");
                if (a2 != null) {
                    a2.contentIntent = activity;
                    long currentTimeMillis = System.currentTimeMillis();
                    notificationManager.notify(currentTimeMillis + "", 0, a2);
                }
            }
        } catch (Exception unused2) {
        }
    }

    public static void b(Context context, PublicMsg publicMsg, com.baidu.android.pushservice.ach.d.e eVar, com.baidu.android.pushservice.x.h hVar, boolean z) {
        com.baidu.android.pushservice.v.c.a().a(context, 1, eVar, hVar.i * 1000, new d(context, hVar, publicMsg, z, eVar));
    }

    public static void b(Context context, PublicMsg publicMsg, com.baidu.android.pushservice.x.h hVar) {
        com.baidu.android.pushservice.z.e.a().a(new c(context, publicMsg, hVar));
    }

    public static void b(Context context, PublicMsg publicMsg, byte[] bArr, byte[] bArr2, String str, int i, String str2) {
        Intent intent = new Intent();
        intent.setPackage(publicMsg.mPkgName);
        intent.putExtra("method", "com.baidu.android.pushservice.action.notification.ARRIVED");
        intent.putExtra("msgid", publicMsg.mMsgId);
        intent.putExtra("notification_title", publicMsg.mTitle);
        intent.putExtra("notification_content", publicMsg.mDescription);
        intent.putExtra("notification_log_ext", str2);
        intent.putExtra("extra_extra_custom_content", publicMsg.mCustomContent);
        intent.putExtra("com.baidu.pushservice.app_id", publicMsg.mAppId);
        intent.putExtra("baidu_message_secur_info", bArr);
        intent.putExtra("baidu_message_body", bArr2);
        intent.putExtra("widget_badge_info", str);
        if (i > 0) {
            intent.putExtra("float_window_show_type", i);
        }
        Utility.c(context, intent, "com.baidu.android.pushservice.action.RECEIVE", publicMsg.mPkgName);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (!"com.baidu.android.pushservice.action.receiver.pullmsg".equals(action) && !"com.baidu.android.pushservice.action.receiver.SHOW_ASYNC_NOTIFICATION".equals(action) && !"com.baidu.android.pushservice.action.receiver.SAVE_PUSH_PROCESS_SP".equals(action)) {
            com.baidu.android.pushservice.t.a.a(context.getApplicationContext()).a(0);
        }
        try {
            intent.getByteArrayExtra("baidu_message_secur_info");
            if ("com.baidu.android.pushservice.action.receiver.ALARM".equals(action)) {
                com.baidu.android.pushservice.z.e.a().a(new a(this, "PushServiceReceiver - keep alive", (short) 99, context, intent));
            } else if (!"com.baidu.android.pushservice.action.notification.SHOW".equals(action)) {
                if ("com.baidu.android.pushservice.action.receiver.CANCEL_ALARM".equals(action)) {
                    f.a(context).c();
                } else if ("com.baidu.android.pushservice.action.receiver.CHANGE_ALARM".equals(action)) {
                    a(context, intent.getBooleanExtra("com.baidu.android.pushservice.action.receiver.ALARM_IS_BACK", true));
                } else if ("com.baidu.android.pushservice.action.receiver.pullmsg".equals(action)) {
                    ClientEventInfo clientEventInfo = (ClientEventInfo) intent.getParcelableExtra("pull_msg_event_info");
                    com.baidu.android.pushservice.t.a.a(context.getApplicationContext()).a(clientEventInfo != null ? clientEventInfo.getSource() : 0);
                    com.baidu.android.pushservice.y.d.e(context, clientEventInfo);
                } else if ("com.baidu.android.pushservice.action.receiver.SHOW_ASYNC_NOTIFICATION".equals(action)) {
                    com.baidu.android.pushservice.x.a.a().b(context, intent.getLongExtra("com.baidu.android.pushservice.SHOW_ASYNC_NOTIFICATION_KEY", 0L), intent.getIntExtra("com.baidu.android.pushservice.SHOW_ASYNC_NOTIFICATION_NOTIFY_ID", 0));
                } else if ("com.baidu.android.pushservice.action.receiver.SAVE_PUSH_PROCESS_SP".equals(action)) {
                    com.baidu.android.pushservice.l.d.a(context, new JSONObject(intent.getStringExtra("com.baidu.android.pushservice.UPDATE_CONF_RESPONSE_DATA")));
                }
            } else if (!com.baidu.android.pushservice.l.d.r(context) || com.baidu.android.pushservice.l.d.q(context)) {
                String stringExtra = intent.getStringExtra("pushService_package_name");
                String stringExtra2 = intent.getStringExtra("service_name");
                String stringExtra3 = intent.getStringExtra("notify_type");
                String stringExtra4 = intent.getStringExtra("app_id");
                int intExtra = intent.getIntExtra(Constants.EXTRA_NOTIFY_ID, 0);
                String stringExtra5 = intent.getStringExtra("widget_badge_info");
                byte[] byteArrayExtra = intent.getByteArrayExtra("baidu_message_body");
                byte[] byteArrayExtra2 = intent.getByteArrayExtra("baidu_message_secur_info");
                int intExtra2 = intent.getIntExtra("baidu_message_type", -1);
                String stringExtra6 = intent.getStringExtra(ForbidActivityConfig.CHAT_MSG_ID);
                int intExtra3 = intent.getIntExtra("extra_push_show_switch", -1);
                int intExtra4 = intent.getIntExtra("extra_float_window_duration", 5);
                String stringExtra7 = intent.getStringExtra("notification_log_ext");
                String stringExtra8 = intent.getStringExtra("extra_push_show_params");
                if (TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(stringExtra2) || byteArrayExtra == null || byteArrayExtra2 == null || intExtra2 == -1 || Utility.l(context, stringExtra6) || !com.baidu.android.pushservice.m.b.b(context, stringExtra6)) {
                    return;
                }
                com.baidu.android.pushservice.z.e.a().a(new b(this, "showPrivateNotification", (short) 99, context, stringExtra4, stringExtra6, byteArrayExtra2, byteArrayExtra, stringExtra, stringExtra2, intExtra, stringExtra5, stringExtra7, intExtra3, intExtra4, stringExtra8, stringExtra3));
            }
        } catch (JSONException | Exception unused) {
        }
    }
}

package com.baidu.android.pushservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.message.PublicMsg;
import com.baidu.android.pushservice.util.Utility;
import com.baidu.android.pushservice.w.m.l;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.mipush.sdk.MiPushMessage;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class PushMessageReceiver extends BroadcastReceiver {
    public static final String TAG = "PushMessageReceiver";

    /* loaded from: classes.dex */
    public static final class PushCallBackExtra implements Parcelable {
        public static final Parcelable.Creator<PushCallBackExtra> CREATOR = new a();
        public long asyncMsgKey;
        public int connectSource;
        public boolean fromLocal;
        public boolean isLongConnection;
        public String logExt;
        public int windowType;

        /* loaded from: classes.dex */
        public static class a implements Parcelable.Creator<PushCallBackExtra> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public PushCallBackExtra createFromParcel(Parcel parcel) {
                return new PushCallBackExtra(parcel, null);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public PushCallBackExtra[] newArray(int i) {
                return new PushCallBackExtra[i];
            }
        }

        public PushCallBackExtra() {
            this.connectSource = 0;
            this.fromLocal = false;
            this.isLongConnection = false;
            this.logExt = "";
            this.asyncMsgKey = 0L;
            this.windowType = 0;
        }

        public PushCallBackExtra(Parcel parcel) {
            this.connectSource = 0;
            this.fromLocal = false;
            this.isLongConnection = false;
            this.logExt = "";
            this.asyncMsgKey = 0L;
            this.windowType = 0;
            this.connectSource = parcel.readInt();
            this.fromLocal = parcel.readInt() == 1;
            this.isLongConnection = parcel.readInt() == 1;
            this.logExt = parcel.readString();
            this.asyncMsgKey = parcel.readLong();
            this.windowType = parcel.readInt();
        }

        public /* synthetic */ PushCallBackExtra(Parcel parcel, a aVar) {
            this(parcel);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "PushCallBackExtra{connectSource=" + this.connectSource + ", fromLocal=" + this.fromLocal + ", isLongConnection=" + this.isLongConnection + ", logExt='" + this.logExt + "', asyncMsgKey=" + this.asyncMsgKey + ", windowType=" + this.windowType + '}';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.connectSource);
            parcel.writeInt(this.fromLocal ? 1 : 0);
            parcel.writeInt(this.isLongConnection ? 1 : 0);
            parcel.writeString(this.logExt);
            parcel.writeLong(this.asyncMsgKey);
            parcel.writeInt(this.windowType);
        }
    }

    /* loaded from: classes.dex */
    public class a extends e {
        public final /* synthetic */ int b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ long d;
        public final /* synthetic */ String e;
        public final /* synthetic */ Context f;
        public final /* synthetic */ Intent g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context, int i, boolean z, long j, String str, Context context2, Intent intent) {
            super(context);
            this.b = i;
            this.c = z;
            this.d = j;
            this.e = str;
            this.f = context2;
            this.g = intent;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.a.get() != null) {
                PushMessageReceiver.this.handleOnMessage(this.a.get(), message.getData().getString("message"), message.getData().getString("custom_content"), message.getData().getInt(Constants.EXTRA_NOTIFY_ID), this.b, this.c, this.d, this.e);
                PushMessageReceiver.sendCallback(this.f, this.g, 10, false);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends Thread {
        public final /* synthetic */ Context a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ byte[] e;
        public final /* synthetic */ byte[] f;
        public final /* synthetic */ int g;
        public final /* synthetic */ Intent h;
        public final /* synthetic */ int i;
        public final /* synthetic */ e j;

        public b(PushMessageReceiver pushMessageReceiver, Context context, int i, String str, String str2, byte[] bArr, byte[] bArr2, int i2, Intent intent, int i3, e eVar) {
            this.a = context;
            this.b = i;
            this.c = str;
            this.d = str2;
            this.e = bArr;
            this.f = bArr2;
            this.g = i2;
            this.h = intent;
            this.i = i3;
            this.j = eVar;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            String[] a = com.baidu.android.pushservice.w.m.h.a(this.a, this.b, this.c, this.d, this.e, this.f, this.g);
            if (a == null || a.length != 2) {
                PushMessageReceiver.sendCallback(this.a, this.h, 9, true);
                return;
            }
            Message message = new Message();
            Bundle bundle = new Bundle();
            bundle.putString("message", a[0]);
            bundle.putString("custom_content", a[1]);
            bundle.putInt(Constants.EXTRA_NOTIFY_ID, this.i);
            message.setData(bundle);
            this.j.sendMessage(message);
        }
    }

    /* loaded from: classes.dex */
    public class c extends com.baidu.android.pushservice.z.c {
        public final /* synthetic */ Context c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;

        public c(PushMessageReceiver pushMessageReceiver, Context context, String str, String str2) {
            this.c = context;
            this.d = str;
            this.e = str2;
        }

        @Override // com.baidu.android.pushservice.z.c
        public void a() {
            com.baidu.android.pushservice.m.d.h(this.c, Utility.c(this.c.getPackageName() + "," + this.d + "," + this.e + ",false," + ((int) com.baidu.android.pushservice.a.a())));
        }
    }

    /* loaded from: classes.dex */
    public class d extends com.baidu.android.pushservice.z.c {
        public final /* synthetic */ Context c;
        public final /* synthetic */ String d;

        public d(PushMessageReceiver pushMessageReceiver, Context context, String str) {
            this.c = context;
            this.d = str;
        }

        @Override // com.baidu.android.pushservice.z.c
        public void a() {
            com.baidu.android.pushservice.o.a.a(this.c).b(this.d);
        }
    }

    /* loaded from: classes.dex */
    public static class e extends Handler {
        public final WeakReference<Context> a;

        public e(Context context) {
            super(context.getMainLooper());
            this.a = new WeakReference<>(context);
        }
    }

    /* loaded from: classes.dex */
    public enum f {
        MSG_PASS(1),
        MSG_ARRIVED(2),
        MSG_CLICKED(3);
        
        public int a;

        f(int i) {
            this.a = i;
        }

        public final int a() {
            return this.a;
        }
    }

    private void handleHonorMessage(Context context, Intent intent, String str) {
        String stringExtra = intent.getStringExtra("honor_pass_msg_content");
        if (Utility.b(context)) {
            handleOnMessage(context, stringExtra, null, 0, 0, false, 0L, "");
        }
    }

    private void handleHonorMessageCallBack(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("hn_notification_sign");
        String stringExtra2 = intent.getStringExtra("hn_notification_msg_id");
        intent.getStringExtra("hn_notification_pkg_content");
        String stringExtra3 = intent.getStringExtra("extra_extra_custom_content");
        if (TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(stringExtra2) || Utility.a(context, stringExtra2)) {
            return;
        }
        if (com.baidu.android.pushservice.e.a(context, stringExtra, stringExtra2 + stringExtra3)) {
            try {
                handleNotificationClicked(context, null, null, stringExtra3, false, "", 0);
            } catch (Exception unused) {
            }
        }
    }

    private void handleHuaweiMessage(Context context, Intent intent, String str) {
        if (com.baidu.android.pushservice.l.d.m(context) || com.baidu.android.pushservice.l.d.l(context)) {
            try {
                if (intent.getBooleanExtra("IS_HMS_PASS_MSG_KEY", false)) {
                    handleHuaweiMessageCallBack(context, intent.getStringExtra("HMS_PASS_MSG_VALUE_KEY"), null);
                    return;
                }
                handleHuaweiMessageCallBack(context, new String(intent.getByteArrayExtra("msg_data"), "utf-8"), new String(intent.getByteArrayExtra(RemoteMessageConst.DEVICE_TOKEN), "utf-8"));
            } catch (Exception unused) {
            }
        }
    }

    private void handleHuaweiMessageCallBack(Context context, String str, String str2) {
        com.baidu.android.pushservice.w.i iVar = new com.baidu.android.pushservice.w.i();
        String a2 = iVar.a(context, str);
        if (a2 == null) {
            try {
                a2 = iVar.a(context, new JSONObject(str).getJSONObject(RemoteMessageConst.MessageBody.MSG_CONTENT).getString("data"));
            } catch (JSONException unused) {
            }
        }
        String str3 = a2;
        if (Utility.b(context) && !Utility.a(context, iVar.j)) {
            String str4 = iVar.m;
            if (com.baidu.android.pushservice.e.a(context, str4, iVar.j + str3)) {
                if (iVar.k == l.MSG_TYPE_APPSTAT_COMMAND.a()) {
                    Utility.Y(context);
                } else if (iVar.k == l.MSG_TYPE_PRIVATE_MESSAGE.a() || iVar.k == l.MSG_TYPE_SINGLE_PRIVATE.a()) {
                    handleOnMessage(context, str3, null, 0, 0, false, 0L, "");
                }
            }
        }
    }

    private void handleMeizuMessageCallBack(Context context, Intent intent) {
        com.baidu.android.pushservice.w.i iVar = new com.baidu.android.pushservice.w.i();
        int intExtra = intent.getIntExtra("mz_push_msg_type", 0);
        String b2 = iVar.b(context, intent.getStringExtra("mz_notification_self_define_content"));
        if (Utility.a(context, iVar.j)) {
            return;
        }
        String str = iVar.m;
        if (com.baidu.android.pushservice.e.a(context, str, (iVar.j + b2).replaceAll("\\\\", "")) && intExtra == f.MSG_CLICKED.a()) {
            handleNotificationClicked(context, intent.getStringExtra("mz_notification_title"), intent.getStringExtra("mz_notification_content"), b2, false, "", 0);
        }
    }

    private void handleNotificationArrived(Context context, String str, String str2, String str3, boolean z, String str4, int i) {
        PushCallBackExtra pushCallBackExtra = new PushCallBackExtra();
        pushCallBackExtra.isLongConnection = z;
        pushCallBackExtra.logExt = str4;
        pushCallBackExtra.windowType = i;
        onNotificationArrived(context, str, str2, str3);
        onNotificationArrived(context, str, str2, str3, pushCallBackExtra);
    }

    private void handleNotificationClicked(Context context, String str, String str2, String str3, boolean z, String str4, int i) {
        PushCallBackExtra pushCallBackExtra = new PushCallBackExtra();
        pushCallBackExtra.isLongConnection = z;
        pushCallBackExtra.logExt = str4;
        pushCallBackExtra.windowType = i;
        onNotificationClicked(context, str, str2, str3);
        onNotificationClicked(context, str, str2, str3, pushCallBackExtra);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnMessage(Context context, String str, String str2, int i, int i2, boolean z, long j, String str3) {
        PushCallBackExtra pushCallBackExtra = new PushCallBackExtra();
        pushCallBackExtra.connectSource = i2;
        pushCallBackExtra.fromLocal = z;
        pushCallBackExtra.logExt = str3;
        pushCallBackExtra.asyncMsgKey = j;
        onMessage(context, str, str2, i);
        onMessage(context, str, str2, i, pushCallBackExtra);
    }

    private void handleOppoMessageCallBack(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("op_notification_sign");
        String stringExtra2 = intent.getStringExtra("op_notification_msg_id");
        String stringExtra3 = intent.getStringExtra("op_notification_pkg_content");
        String stringExtra4 = intent.getStringExtra("extra_extra_custom_content");
        if (TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(stringExtra2) || Utility.a(context, stringExtra2)) {
            return;
        }
        if (com.baidu.android.pushservice.e.a(context, stringExtra, stringExtra2 + stringExtra4)) {
            if (TextUtils.isEmpty(stringExtra3)) {
                try {
                    handleNotificationClicked(context, null, null, new JSONObject("{\"extras\":" + stringExtra4 + "}").getString("extras"), false, "", 0);
                    return;
                } catch (Exception unused) {
                    return;
                }
            }
            try {
                Intent parseUri = Intent.parseUri(stringExtra3, 0);
                parseUri.setPackage(context.getPackageName());
                parseUri.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                if (!TextUtils.isEmpty(stringExtra4)) {
                    JSONObject jSONObject = new JSONObject(stringExtra4);
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        parseUri.putExtra(next, jSONObject.optString(next));
                    }
                }
                if (context.getPackageManager().queryIntentActivities(parseUri, 0).size() > 0) {
                    context.startActivity(parseUri);
                }
            } catch (Exception unused2) {
            }
        }
    }

    private void handleVivoMessageCallBack(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("vi_notification_title");
        String stringExtra2 = intent.getStringExtra("vi_notification_content");
        String stringExtra3 = intent.getStringExtra("vi_notification_sign");
        String stringExtra4 = intent.getStringExtra("vi_notification_msg_id");
        String stringExtra5 = intent.getStringExtra("vi_notification_pkg_content");
        String stringExtra6 = intent.getStringExtra("extra_extra_custom_content");
        if (TextUtils.isEmpty(stringExtra3) || TextUtils.isEmpty(stringExtra4) || Utility.a(context, stringExtra4)) {
            return;
        }
        if (com.baidu.android.pushservice.e.a(context, stringExtra3, stringExtra4 + stringExtra6)) {
            if (TextUtils.isEmpty(stringExtra5)) {
                try {
                    handleNotificationClicked(context, stringExtra, stringExtra2, stringExtra6, false, "", 0);
                    return;
                } catch (Exception unused) {
                    return;
                }
            }
            try {
                Intent parseUri = Intent.parseUri(stringExtra5, 0);
                parseUri.setPackage(context.getPackageName());
                parseUri.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                if (!TextUtils.isEmpty(stringExtra6)) {
                    JSONObject jSONObject = new JSONObject(stringExtra6);
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        parseUri.putExtra(next, jSONObject.optString(next));
                    }
                }
                if (context.getPackageManager().queryIntentActivities(parseUri, 0).size() > 0) {
                    context.startActivity(parseUri);
                }
            } catch (Exception unused2) {
            }
        }
    }

    private void handleXiaomiMessageCallBack(Context context, MiPushMessage miPushMessage, int i) {
        try {
            String content = miPushMessage.getContent();
            com.baidu.android.pushservice.w.i iVar = new com.baidu.android.pushservice.w.i();
            if (msgFromXMConsole(context, content)) {
                iVar.k = l.MSG_TYPE_SINGLE_PRIVATE.a();
            } else {
                content = iVar.c(context, content);
            }
            String str = content;
            if (i == f.MSG_CLICKED.a() || !Utility.a(context, iVar.j)) {
                if (iVar.k == l.MSG_TYPE_APPSTAT_COMMAND.a()) {
                    Utility.Y(context);
                } else if (iVar.k == l.MSG_TYPE_PRIVATE_MESSAGE.a() || iVar.k == l.MSG_TYPE_MULTI_PRIVATE.a() || iVar.k == l.MSG_TYPE_SINGLE_PRIVATE.a() || iVar.k == l.MSG_TYPE_MULTI_PRIVATE_NOTIFICATION.a() || iVar.k == l.MSG_TYPE_SINGLE_PUBLIC.a() || iVar.k == l.MSG_TYPE_MULTI_PUBLIC.a()) {
                    if (i == f.MSG_PASS.a()) {
                        handleOnMessage(context, str, null, 0, 0, false, 0L, "");
                    } else if (i == f.MSG_ARRIVED.a()) {
                        handleNotificationArrived(context, miPushMessage.getTitle(), miPushMessage.getDescription(), str, false, "", 0);
                    } else if (i == f.MSG_CLICKED.a()) {
                        handleNotificationClicked(context, miPushMessage.getTitle(), miPushMessage.getDescription(), str, false, "", 0);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static boolean msgFromXMConsole(Context context, String str) {
        try {
            new JSONObject(str);
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    public static void sendCallback(Context context, Intent intent, int i, boolean z) {
        int intExtra = intent.getIntExtra("baidu_message_type", -1);
        intent.getAction();
        if (intExtra == l.MSG_TYPE_APP_PRIORITY.a()) {
            if (z) {
                Utility.c(context, intent.getStringExtra(ForbidActivityConfig.CHAT_MSG_ID), i);
            }
        } else if (intent.getBooleanExtra("bdpush_deliver_NO_CALLBACK", false)) {
        } else {
            if (TextUtils.equals(context.getPackageName(), intent.getStringExtra("bd.cross.request.SOURCE_PACKAGE"))) {
                intent.putExtra("bd.cross.request.COMMAND_TYPE", "bd.cross.command.MESSAGE_ACK");
                intent.putExtra("bd.cross.request.RESULT_CODE", i);
                com.baidu.android.pushservice.a0.b.a(intent);
            }
        }
    }

    private void widgetInfoCallBack(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("widget_badge_info");
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(stringExtra);
            onWidgetBadgeUpdate(context, jSONObject.getInt("widget_badge_num"), jSONObject.getInt("widget_badge_type"));
        } catch (Exception unused) {
        }
    }

    public abstract void onBind(Context context, int i, String str, String str2, String str3, String str4);

    public abstract void onDelTags(Context context, int i, List<String> list, List<String> list2, String str);

    public abstract void onListTags(Context context, int i, List<String> list, String str);

    public abstract void onMessage(Context context, String str, String str2, int i);

    public void onMessage(Context context, String str, String str2, int i, PushCallBackExtra pushCallBackExtra) {
    }

    public abstract void onNotificationArrived(Context context, String str, String str2, String str3);

    public void onNotificationArrived(Context context, String str, String str2, String str3, PushCallBackExtra pushCallBackExtra) {
    }

    public abstract void onNotificationClicked(Context context, String str, String str2, String str3);

    public void onNotificationClicked(Context context, String str, String str2, String str3, PushCallBackExtra pushCallBackExtra) {
    }

    public void onNotificationMessageArrived(Context context, String str, String str2, String str3, PushCallBackExtra pushCallBackExtra) {
    }

    public void onNotificationMessageClicked(Context context, String str, String str2, String str3, PushCallBackExtra pushCallBackExtra) {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String stringExtra;
        com.baidu.android.pushservice.w.i a2;
        PublicMsg a3;
        boolean z;
        PushMessageReceiver pushMessageReceiver;
        Context context2;
        String str;
        String str2;
        String str3;
        String str4;
        int i;
        JSONArray jSONArray;
        ArrayList arrayList;
        ArrayList arrayList2;
        JSONArray jSONArray2;
        int i2;
        String str5;
        String str6;
        long j;
        if (context == null || intent == null) {
            return;
        }
        try {
            intent.getByteArrayExtra("baidu_message_secur_info");
            String action = intent.getAction();
            int i3 = 0;
            if (TextUtils.equals(action, "com.baidu.android.pushservice.action.MESSAGE")) {
                if ((com.baidu.android.pushservice.l.d.r(context) && !com.baidu.android.pushservice.l.d.q(context)) || intent.getExtras() == null) {
                    return;
                }
                byte[] byteArrayExtra = intent.getByteArrayExtra("baidu_message_secur_info");
                byte[] byteArrayExtra2 = intent.getByteArrayExtra("baidu_message_body");
                String stringExtra2 = intent.getStringExtra(ForbidActivityConfig.CHAT_MSG_ID);
                int intExtra = intent.getIntExtra("baidu_message_type", -1);
                String stringExtra3 = intent.getStringExtra("app_id");
                int intExtra2 = intent.getIntExtra(Constants.EXTRA_NOTIFY_ID, 0);
                int intExtra3 = intent.getIntExtra("connect_source", 0);
                int intExtra4 = intent.getIntExtra("foreground_show_num", 0);
                boolean booleanExtra = intent.getBooleanExtra("from_local_msg", false);
                String stringExtra4 = intent.getStringExtra("notification_log_ext");
                if (byteArrayExtra == null || byteArrayExtra2 == null || TextUtils.isEmpty(stringExtra2) || TextUtils.isEmpty(stringExtra3) || intExtra == -1) {
                    sendCallback(context, intent, 2, true);
                    return;
                } else if (intExtra == l.MSG_TYPE_APP_PRIORITY.a() || (!Utility.l(context, stringExtra2) && com.baidu.android.pushservice.m.b.b(context, stringExtra2))) {
                    new b(this, context, intExtra, stringExtra3, stringExtra2, byteArrayExtra, byteArrayExtra2, intExtra4, intent, intExtra2, new a(context, intExtra3, booleanExtra, com.baidu.android.pushservice.x.a.a().a(new String(byteArrayExtra2), intExtra3, booleanExtra, stringExtra4), stringExtra4, context, intent)).start();
                } else {
                    sendCallback(context, intent, 4, true);
                }
            } else if (!TextUtils.equals(action, "com.baidu.android.pushservice.action.RECEIVE")) {
                if (TextUtils.equals(action, "com.baidu.android.pushservice.action.notification.CLICK")) {
                    String stringExtra5 = intent.getStringExtra("msgid");
                    String stringExtra6 = intent.getStringExtra("notification_title");
                    String stringExtra7 = intent.getStringExtra("notification_content");
                    String stringExtra8 = intent.getStringExtra("extra_extra_custom_content");
                    String stringExtra9 = intent.getStringExtra("notification_log_ext");
                    String stringExtra10 = intent.getStringExtra("com.baidu.pushservice.app_id");
                    int intExtra5 = intent.getIntExtra("proxy_mode", 0);
                    byte[] byteArrayExtra3 = intent.getByteArrayExtra("baidu_message_secur_info");
                    byte[] byteArrayExtra4 = intent.getByteArrayExtra("baidu_message_body");
                    int intExtra6 = intent.getIntExtra("float_window_show_type", 0);
                    if (intExtra5 == 5) {
                        if (!com.baidu.android.pushservice.e.a(context.getApplicationContext(), intent.getStringExtra("proxy_sign_info"), intent.getStringExtra("proxy_check_info"))) {
                            return;
                        }
                        z = false;
                        i = 0;
                        str4 = "";
                        pushMessageReceiver = this;
                        context2 = context;
                        str = stringExtra6;
                        str2 = stringExtra7;
                        str3 = stringExtra8;
                    } else if (!Utility.a(context, stringExtra5, stringExtra10, stringExtra6, stringExtra7, stringExtra8) && !Utility.a(context, byteArrayExtra3, stringExtra5, byteArrayExtra4)) {
                        return;
                    } else {
                        z = true;
                        pushMessageReceiver = this;
                        context2 = context;
                        str = stringExtra6;
                        str2 = stringExtra7;
                        str3 = stringExtra8;
                        str4 = stringExtra9;
                        i = intExtra6;
                    }
                    pushMessageReceiver.handleNotificationClicked(context2, str, str2, str3, z, str4, i);
                    return;
                }
                try {
                    if (TextUtils.equals(action, "com.huawei.android.push.intent.REGISTRATION")) {
                        if (PushSettings.i(context)) {
                            String str7 = new String(intent.getByteArrayExtra(RemoteMessageConst.DEVICE_TOKEN), "UTF-8");
                            if (TextUtils.isEmpty(str7)) {
                                return;
                            }
                            if (com.baidu.android.pushservice.l.d.m(context)) {
                                com.baidu.android.pushservice.e.a(context, str7, 5);
                            }
                            if (com.baidu.android.pushservice.l.d.l(context)) {
                                com.baidu.android.pushservice.z.e.a().a(new d(this, context, str7));
                                return;
                            }
                            return;
                        }
                        return;
                    } else if (TextUtils.equals(action, "com.huawei.intent.action.PUSH")) {
                        if ((com.baidu.android.pushservice.l.d.m(context) || com.baidu.android.pushservice.l.d.t(context)) && PushSettings.i(context)) {
                            String str8 = new String(intent.getByteArrayExtra("selfshow_info"), "UTF-8");
                            if (!TextUtils.isEmpty(str8) && (a3 = (a2 = com.baidu.android.pushservice.w.m.j.a(context, str8)).a(context)) != null && Utility.b(context) && !Utility.a(context, a2.j)) {
                                PushServiceReceiver.b(context, a3);
                                return;
                            }
                            return;
                        }
                        return;
                    } else if (TextUtils.equals(action, "com.huawei.android.push.intent.RECEIVE")) {
                        handleHuaweiMessage(context, intent, action);
                        return;
                    } else if (TextUtils.equals(action, "com.honor.android.push.intent.RECEIVE")) {
                        handleHonorMessage(context, intent, action);
                        return;
                    } else {
                        if (TextUtils.equals(action, "com.xiaomi.mipush.REGISTER")) {
                            if (!com.baidu.android.pushservice.l.d.B(context) || !intent.hasExtra(PushPatchMessageReceiver.REGISTER_ERRORCODE)) {
                                return;
                            }
                            if (intent.getLongExtra(PushPatchMessageReceiver.REGISTER_ERRORCODE, 0L) != 0) {
                                com.baidu.android.pushservice.e.d(context);
                                return;
                            } else if (!intent.hasExtra(PushPatchMessageReceiver.REGID)) {
                                return;
                            } else {
                                stringExtra = intent.getStringExtra(PushPatchMessageReceiver.REGID);
                                if (TextUtils.isEmpty(stringExtra)) {
                                    return;
                                }
                            }
                        } else if (TextUtils.equals(action, "com.xiaomi.mipush.PUSH_MSG")) {
                            if (Utility.T(context) && intent.hasExtra(PushPatchMessageReceiver.PUSH_MSG)) {
                                MiPushMessage miPushMessage = (MiPushMessage) intent.getSerializableExtra(PushPatchMessageReceiver.PUSH_MSG);
                                if (intent.hasExtra(PushPatchMessageReceiver.PUSH_MSG_TYPE)) {
                                    handleXiaomiMessageCallBack(context, miPushMessage, intent.getIntExtra(PushPatchMessageReceiver.PUSH_MSG_TYPE, 0));
                                    return;
                                }
                                return;
                            }
                            return;
                        } else if (!TextUtils.equals(action, "com.meizu.mzpush.REGISTER")) {
                            if (TextUtils.equals(action, "com.meizu.mzpush.PUSH_MSG")) {
                                if (Utility.J(context) && intent.hasExtra("mz_push_msg_type")) {
                                    handleMeizuMessageCallBack(context, intent);
                                    return;
                                }
                                return;
                            } else if (TextUtils.equals(action, "com.baidu.android.pushservice.action.OPPO_CLICK")) {
                                if (Utility.N(context) || Utility.M(context) || Utility.P(context)) {
                                    handleOppoMessageCallBack(context, intent);
                                    return;
                                }
                                return;
                            } else if (TextUtils.equals(action, "com.baidu.android.pushservice.action.VIVO_CLICK")) {
                                if (Utility.S(context)) {
                                    handleVivoMessageCallBack(context, intent);
                                    return;
                                }
                                return;
                            } else if (TextUtils.equals(action, "com.baidu.android.pushservice.action.HONOR_CLICK")) {
                                if (Utility.G(context)) {
                                    handleHonorMessageCallBack(context, intent);
                                    return;
                                }
                                return;
                            } else if (TextUtils.equals(action, "com.baidu.android.pushservice.action.pass_through_notify_CLICK")) {
                                onNotificationMessageClicked(context, intent.getStringExtra("notification_title"), intent.getStringExtra("notification_content"), intent.getStringExtra("extra_extra_custom_content"), (PushCallBackExtra) Utility.a(intent.getByteArrayExtra("extra_extra_push_call_back"), PushCallBackExtra.CREATOR));
                                return;
                            } else if (TextUtils.equals(action, "com.baidu.android.pushservice.action.pass_through_notify_ARRIVE")) {
                                onNotificationMessageArrived(context, intent.getStringExtra("notification_title"), intent.getStringExtra("notification_content"), intent.getStringExtra("extra_extra_custom_content"), (PushCallBackExtra) Utility.a(intent.getByteArrayExtra("extra_extra_push_call_back"), PushCallBackExtra.CREATOR));
                                return;
                            } else {
                                return;
                            }
                        } else if (!com.baidu.android.pushservice.l.d.n(context) || !intent.hasExtra("mz_register_errorcode")) {
                            return;
                        } else {
                            String stringExtra11 = intent.getStringExtra("mz_register_errorcode");
                            if (TextUtils.isEmpty(stringExtra11) || !stringExtra11.equals(BasicPushStatus.SUCCESS_CODE)) {
                                com.baidu.android.pushservice.e.c(context);
                                return;
                            } else if (!intent.hasExtra("mz_pushid")) {
                                return;
                            } else {
                                stringExtra = intent.getStringExtra("mz_pushid");
                                if (TextUtils.isEmpty(stringExtra)) {
                                    return;
                                }
                            }
                        }
                        com.baidu.android.pushservice.e.a(context, stringExtra);
                        return;
                    }
                } catch (Exception unused) {
                    return;
                }
            } else {
                String stringExtra12 = intent.getStringExtra("method");
                if (TextUtils.isEmpty(stringExtra12)) {
                    return;
                }
                int intExtra7 = intent.getIntExtra(GameCodeGetResponseMsg.PARAM_ERROR_MSG, 0);
                String str9 = intent.getByteArrayExtra("content") != null ? new String(intent.getByteArrayExtra("content")) : "";
                if (!stringExtra12.equals("com.baidu.android.pushservice.action.notification.ARRIVED")) {
                    if (stringExtra12.equals("method_bind")) {
                        if (intExtra7 == 0 && !TextUtils.isEmpty(str9)) {
                            try {
                                JSONObject jSONObject = new JSONObject(str9);
                                String string = jSONObject.getString(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID);
                                JSONObject jSONObject2 = jSONObject.getJSONObject("response_params");
                                String string2 = jSONObject2.getString("appid");
                                PushSettings.a(context, string2);
                                String string3 = jSONObject2.getString("channel_id");
                                String optString = jSONObject2.optString("new_channel_id");
                                String string4 = jSONObject2.getString("user_id");
                                if (intent.hasExtra("real_bind")) {
                                    j = System.currentTimeMillis();
                                    str5 = intent.getStringExtra("access_token");
                                    str6 = intent.getStringExtra("secret_key");
                                } else {
                                    str5 = null;
                                    str6 = null;
                                    j = 0;
                                }
                                com.baidu.android.pushservice.a0.i.a(context, string2, string3, optString, string, string4, j, str5, str6);
                                onBind(context, intExtra7, string2, string4, TextUtils.isEmpty(optString) ? string3 : optString, string);
                                i2 = intExtra7;
                                try {
                                    com.baidu.android.pushservice.z.e.a().a(new c(this, context, string2, string4));
                                    return;
                                } catch (Exception unused2) {
                                }
                            } catch (Exception unused3) {
                            }
                        }
                        i2 = intExtra7;
                        onBind(context, i2, null, null, null, null);
                        return;
                    } else if (stringExtra12.equals("method_unbind")) {
                        try {
                            onUnbind(context, intExtra7, new JSONObject(str9).getString(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID));
                        } catch (JSONException unused4) {
                            onUnbind(context, intExtra7, null);
                        }
                        Utility.c(context, false);
                        if (com.baidu.android.pushservice.l.d.B(context)) {
                            MiPushClient.unregisterPush(context);
                        }
                        if (com.baidu.android.pushservice.l.d.n(context)) {
                            String c2 = com.baidu.android.pushservice.a0.i.c(context, "BD_MEIZU_PROXY_APPID_KEY");
                            String c3 = com.baidu.android.pushservice.a0.i.c(context, "BD_MEIZU_PROXY_APPKEY_KEY");
                            if (TextUtils.isEmpty(c2) || TextUtils.isEmpty(c3)) {
                                return;
                            }
                            com.meizu.cloud.pushsdk.PushManager.unRegister(context, c2, c3);
                            return;
                        }
                        return;
                    } else if (stringExtra12.equals("method_set_tags")) {
                        try {
                            JSONObject jSONObject3 = new JSONObject(str9);
                            String string5 = jSONObject3.getString(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID);
                            if (TextUtils.isEmpty(jSONObject3.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG))) {
                                JSONObject optJSONObject = jSONObject3.optJSONObject("response_params");
                                if (optJSONObject == null || (jSONArray = optJSONObject.getJSONArray("details")) == null) {
                                    return;
                                }
                                arrayList = new ArrayList();
                                arrayList2 = new ArrayList();
                                while (i3 < jSONArray.length()) {
                                    JSONObject jSONObject4 = jSONArray.getJSONObject(i3);
                                    String string6 = jSONObject4.getString("tag");
                                    if (jSONObject4.getInt("result") == 0) {
                                        arrayList.add(string6);
                                    } else {
                                        arrayList2.add(string6);
                                    }
                                    i3++;
                                }
                            } else {
                                arrayList = new ArrayList();
                                arrayList2 = new ArrayList();
                            }
                            onSetTags(context, intExtra7, arrayList, arrayList2, string5);
                            return;
                        } catch (JSONException unused5) {
                            onSetTags(context, intExtra7, null, null, null);
                            return;
                        }
                    } else if (!stringExtra12.equals("method_del_tags")) {
                        if (stringExtra12.equals("method_listtags")) {
                            try {
                                onListTags(context, intExtra7, intent.getStringArrayListExtra("tags_list"), new JSONObject(str9).getString(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID));
                                return;
                            } catch (JSONException unused6) {
                                onListTags(context, intExtra7, null, null);
                                return;
                            }
                        }
                        return;
                    } else {
                        try {
                            JSONObject jSONObject5 = new JSONObject(str9);
                            String string7 = jSONObject5.getString(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID);
                            JSONObject jSONObject6 = jSONObject5.getJSONObject("response_params");
                            if (jSONObject6 == null || (jSONArray2 = jSONObject6.getJSONArray("details")) == null) {
                                return;
                            }
                            ArrayList arrayList3 = new ArrayList();
                            ArrayList arrayList4 = new ArrayList();
                            while (i3 < jSONArray2.length()) {
                                JSONObject jSONObject7 = jSONArray2.getJSONObject(i3);
                                String string8 = jSONObject7.getString("tag");
                                if (jSONObject7.getInt("result") == 0) {
                                    arrayList3.add(string8);
                                } else {
                                    arrayList4.add(string8);
                                }
                                i3++;
                            }
                            onDelTags(context, intExtra7, arrayList3, arrayList4, string7);
                            return;
                        } catch (JSONException unused7) {
                            onDelTags(context, intExtra7, null, null, null);
                            return;
                        }
                    }
                }
                String stringExtra13 = intent.getStringExtra("msgid");
                String stringExtra14 = intent.getStringExtra("notification_title");
                String stringExtra15 = intent.getStringExtra("notification_content");
                String stringExtra16 = intent.getStringExtra("extra_extra_custom_content");
                byte[] byteArrayExtra5 = intent.getByteArrayExtra("baidu_message_secur_info");
                byte[] byteArrayExtra6 = intent.getByteArrayExtra("baidu_message_body");
                String stringExtra17 = intent.getStringExtra("notification_log_ext");
                int intExtra8 = intent.getIntExtra("float_window_show_type", 0);
                if (Utility.a(context, byteArrayExtra5, stringExtra13, byteArrayExtra6)) {
                    handleNotificationArrived(context, stringExtra14, stringExtra15, stringExtra16, true, stringExtra17, intExtra8);
                }
            }
            widgetInfoCallBack(context, intent);
        } catch (Exception unused8) {
        }
    }

    public abstract void onSetTags(Context context, int i, List<String> list, List<String> list2, String str);

    public abstract void onUnbind(Context context, int i, String str);

    public void onWidgetBadgeUpdate(Context context, int i, int i2) {
    }
}

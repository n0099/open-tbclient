package com.baidu.android.pushservice.x;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.android.pushservice.NotificationBuilderManager;
import com.baidu.android.pushservice.PushMessageReceiver;
import com.baidu.android.pushservice.PushServiceReceiver;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static a c;
    public final HashMap<Long, String> a = new HashMap<>();
    public final HashMap<Long, PushMessageReceiver.PushCallBackExtra> b = new HashMap<>();

    /* renamed from: com.baidu.android.pushservice.x.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0041a extends com.baidu.android.pushservice.z.c {
        public final /* synthetic */ Context c;
        public final /* synthetic */ String d;
        public final /* synthetic */ int e;
        public final /* synthetic */ PushMessageReceiver.PushCallBackExtra f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0041a(a aVar, String str, short s, Context context, String str2, int i, PushMessageReceiver.PushCallBackExtra pushCallBackExtra) {
            super(str, s);
            this.c = context;
            this.d = str2;
            this.e = i;
            this.f = pushCallBackExtra;
        }

        @Override // com.baidu.android.pushservice.z.c
        public void a() {
            NotificationBuilderManager.a(this.c, this.d, this.e, this.f);
        }
    }

    public static a a() {
        if (c == null) {
            synchronized (a.class) {
                if (c == null) {
                    c = new a();
                }
            }
        }
        return c;
    }

    public static void a(Context context, long j, int i) {
        if (context == null || j <= 0) {
            return;
        }
        Intent intent = new Intent("com.baidu.android.pushservice.action.receiver.SHOW_ASYNC_NOTIFICATION");
        intent.setPackage(context.getPackageName());
        intent.setClass(context, PushServiceReceiver.class);
        intent.putExtra("com.baidu.android.pushservice.SHOW_ASYNC_NOTIFICATION_KEY", j);
        intent.putExtra("com.baidu.android.pushservice.SHOW_ASYNC_NOTIFICATION_NOTIFY_ID", i);
        context.sendBroadcast(intent);
    }

    public long a(String str, int i, boolean z, String str2) {
        int i2;
        try {
            i2 = new JSONObject(str).optInt("notification_builder_id");
        } catch (JSONException unused) {
            i2 = 0;
        }
        if (i2 >= 100) {
            long currentTimeMillis = System.currentTimeMillis();
            PushMessageReceiver.PushCallBackExtra pushCallBackExtra = new PushMessageReceiver.PushCallBackExtra();
            pushCallBackExtra.connectSource = i;
            pushCallBackExtra.fromLocal = z;
            pushCallBackExtra.logExt = str2;
            pushCallBackExtra.asyncMsgKey = currentTimeMillis;
            pushCallBackExtra.isLongConnection = true;
            this.b.put(Long.valueOf(currentTimeMillis), pushCallBackExtra);
            this.a.put(Long.valueOf(currentTimeMillis), str);
            return currentTimeMillis;
        }
        return 0L;
    }

    public void b(Context context, long j, int i) {
        String remove = this.a.remove(Long.valueOf(j));
        PushMessageReceiver.PushCallBackExtra remove2 = this.b.remove(Long.valueOf(j));
        if (TextUtils.isEmpty(remove)) {
            return;
        }
        com.baidu.android.pushservice.z.e.a().a(new C0041a(this, "showAsyncNotify", (short) 99, context, remove, i, remove2));
    }
}

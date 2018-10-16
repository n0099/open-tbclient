package cn.jpush.android.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jpush.android.api.JPushMessage;
import com.baidu.ar.audio.AudioParams;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.searchbox.ng.ai.apps.trace.ErrDef;
import com.xiaomi.mipush.sdk.PushMessageHelper;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes3.dex */
public final class g {
    private static ConcurrentLinkedQueue<Long> a = new ConcurrentLinkedQueue<>();
    private static final Object c = new Object();
    private static g d;
    private ConcurrentHashMap<Long, h> b = new ConcurrentHashMap<>();

    public static synchronized g a() {
        g gVar;
        synchronized (g.class) {
            if (d == null) {
                synchronized (c) {
                    if (d == null) {
                        d = new g();
                    }
                }
            }
            gVar = d;
        }
        return gVar;
    }

    public static JPushMessage a(Intent intent) {
        if (intent != null) {
            try {
                int intExtra = intent.getIntExtra("sequence", -1);
                int intExtra2 = intent.getIntExtra("code", -1);
                String stringExtra = intent.getStringExtra("mobile_number");
                JPushMessage jPushMessage = new JPushMessage();
                try {
                    jPushMessage.setSequence(intExtra);
                    jPushMessage.setErrorCode(intExtra2);
                    jPushMessage.setMobileNumber(stringExtra);
                    return jPushMessage;
                } catch (Throwable th) {
                    return jPushMessage;
                }
            } catch (Throwable th2) {
                return null;
            }
        }
        return null;
    }

    public static void a(Context context, int i, int i2, String str) {
        try {
            Intent intent = new Intent();
            intent.addCategory(cn.jpush.android.a.c);
            intent.setAction("cn.jpush.android.intent.RECEIVE_MESSAGE");
            intent.setPackage(context.getPackageName());
            intent.putExtra(PushMessageHelper.MESSAGE_TYPE, 3);
            intent.putExtra("sequence", i);
            intent.putExtra("code", i2);
            intent.putExtra("mobile_number", str);
            context.sendBroadcast(intent);
        } catch (Throwable th) {
            cn.jpush.android.d.f.c("MobileNumberHelper", "onResult error:" + th);
        }
    }

    public final void a(Context context, long j, int i) {
        h remove;
        if (this.b.size() == 0 || (remove = this.b.remove(Long.valueOf(j))) == null) {
            return;
        }
        if (i == 0) {
            cn.jiguang.api.i.f(context, "mobile_number", remove.b);
        } else if (i == 11) {
            i = cn.jpush.android.api.b.y;
        } else if (i == 10) {
            i = cn.jpush.android.api.b.x;
        }
        a(context, remove.a, i, remove.b);
    }

    public final void a(Context context, Bundle bundle) {
        char c2;
        int i = bundle.getInt("sequence", 0);
        String string = bundle.getString("mobile_number");
        String string2 = cn.jiguang.api.i.getString(context, "mobile_number", null);
        if (string2 != null && TextUtils.equals(string, string2)) {
            cn.jpush.android.d.f.a("MobileNumberHelper", "already set this mobile number");
            a(context, i, cn.jpush.android.api.b.a, string);
            return;
        }
        if (string2 != null) {
            cn.jiguang.api.i.f(context, "mobile_number", null);
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (a.size() < 3) {
            a.offer(Long.valueOf(currentTimeMillis));
            c2 = 0;
        } else {
            long longValue = currentTimeMillis - a.element().longValue();
            if (longValue < 0) {
                a.clear();
                c2 = 2;
            } else if (longValue > ErrDef.Feature.WEIGHT) {
                while (a.size() >= 3) {
                    a.poll();
                }
                a.offer(Long.valueOf(currentTimeMillis));
                c2 = 0;
            } else {
                c2 = 1;
            }
        }
        if (c2 != 0) {
            a(context, i, c2 == 1 ? cn.jpush.android.api.b.l : cn.jpush.android.api.b.n, string);
            return;
        }
        int c3 = cn.jpush.android.d.h.c(string);
        if (c3 != 0) {
            cn.jpush.android.d.f.a("MobileNumberHelper", "Invalid mobile number: " + string + ", will not set mobile number this time.");
            a(context, i, c3, string);
            return;
        }
        long by = cn.jiguang.api.e.by();
        long uid = cn.jiguang.api.e.getUid();
        int sid = cn.jiguang.api.e.getSid();
        cn.jiguang.api.a.b bVar = new cn.jiguang.api.a.b(AudioParams.DEFAULT_AUDIO_BUFFER_SIZE);
        bVar.l(0);
        bVar.k(1);
        bVar.k(26);
        bVar.h(by);
        bVar.g(sid);
        bVar.h(uid);
        bVar.k(7);
        bVar.k(1);
        bVar.f(string != null ? string.getBytes() : new byte[0]);
        bVar.l(bVar.current(), 0);
        byte[] byteArray = bVar.toByteArray();
        this.b.put(Long.valueOf(by), new h(this, i, string));
        cn.jiguang.api.e.b(context, cn.jpush.android.a.a, HttpConstants.HTTP_CONNECT_TIMEOUT, byteArray);
    }
}

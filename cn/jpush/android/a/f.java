package cn.jpush.android.a;

import android.content.Context;
import android.content.Intent;
import com.xiaomi.mipush.sdk.PushMessageHelper;
/* loaded from: classes3.dex */
public final class f {
    private static f b = null;
    private Context a;

    private f(Context context) {
        this.a = null;
        this.a = context;
    }

    public static synchronized f a(Context context) {
        f fVar;
        synchronized (f.class) {
            if (b == null) {
                b = new f(context);
            }
            fVar = b;
        }
        return fVar;
    }

    public final void a(long j, int i) {
        try {
            int a = o.a().a(j);
            Intent intent = new Intent();
            intent.addCategory(cn.jpush.android.a.c);
            intent.setPackage(this.a.getPackageName());
            if (a == 0) {
                intent.setAction("cn.jpush.android.intent.TAG_ALIAS_TIMEOUT");
            } else {
                intent.setAction("cn.jpush.android.intent.RECEIVE_MESSAGE");
                if (a == 1) {
                    intent.putExtra(PushMessageHelper.MESSAGE_TYPE, 1);
                } else {
                    intent.putExtra(PushMessageHelper.MESSAGE_TYPE, 2);
                }
            }
            intent.putExtra("tagalias_errorcode", i);
            intent.putExtra("tagalias_seqid", j);
            this.a.sendBroadcast(intent);
        } catch (Throwable th) {
            cn.jpush.android.d.f.c("JPushRequestHelper", "onTagaliasTimeout error:" + th.getMessage());
        }
    }

    public final void a(cn.jiguang.api.g gVar, int i) {
        if (gVar == null) {
            return;
        }
        cn.jpush.android.d.f.a("JPushRequestHelper", "Action - sendJPushRequest, timeout:20000, threadId:" + Thread.currentThread().getId());
        Long rid = gVar.getRid();
        int command = gVar.getCommand();
        long uid = cn.jiguang.api.e.getUid();
        int sid = cn.jiguang.api.e.getSid();
        switch (command) {
            case 10:
            case 28:
            case 29:
                long longValue = rid.longValue();
                String appKey = cn.jiguang.api.e.getAppKey();
                short command2 = (short) gVar.getCommand();
                String a = ((cn.jpush.a.c) gVar).a();
                cn.jiguang.api.a.b bVar = new cn.jiguang.api.a.b(20480);
                bVar.l(0);
                bVar.k((short) gVar.getVersion());
                bVar.k(command2);
                bVar.h(longValue);
                bVar.g(sid);
                bVar.h(uid);
                if (command2 == 10) {
                    bVar.f(appKey.getBytes());
                }
                bVar.f(a.getBytes());
                bVar.l(bVar.current(), 0);
                cn.jiguang.api.e.b(this.a, cn.jpush.android.a.a, 20000, bVar.toByteArray());
                return;
            default:
                return;
        }
    }
}

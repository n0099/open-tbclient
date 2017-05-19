package com.baidu.android.pushservice.message.a;

import android.content.Context;
import com.baidu.android.pushservice.h.u;
/* loaded from: classes2.dex */
public class k {
    private static final String a = k.class.getSimpleName();
    private Context b;

    public k(Context context) {
        this.b = context;
    }

    public c a(l lVar) {
        switch (lVar) {
            case MSG_TYPE_SINGLE_PRIVATE:
            case MSG_TYPE_MULTI_PRIVATE:
                return new g(this.b);
            case MSG_TYPE_PRIVATE_MESSAGE:
                return new h(this.b);
            case MSG_TYPE_SINGLE_PUBLIC:
            case MSG_TYPE_MULTI_PUBLIC:
                return new i(this.b);
            case MSG_TYPE_MULTI_PRIVATE_NOTIFICATION:
                return new e(this.b);
            case MSG_TYPE_RICH_MEDIA:
                return new m(this.b);
            case MSG_TYPE_BAIDU_SUPPER:
                return new b(this.b);
            case MSG_TYPE_INNERBIND:
                return new d(this.b);
            case MSG_TYPE_ALARM_MESSAGE:
            case MSG_TYPE_ALARM_NOTIFICATION:
            case MSG_TYPE_ALARM_AD_NOTIFICATION:
                com.baidu.android.pushservice.e.a.c(a, ">>> MSG_TYPE_ALARM msg_type : " + lVar);
                return new a(this.b);
            case MSG_TYPE_ULTRON_COMMAND:
                return new n(this.b);
            default:
                com.baidu.android.pushservice.e.a.e(a, ">>> Unknown msg_type : " + lVar);
                u.b(">>> Unknown msg_type : " + lVar, this.b);
                return null;
        }
    }
}

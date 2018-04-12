package com.baidu.android.pushservice.message.a;

import android.content.Context;
/* loaded from: classes3.dex */
public class k {
    private Context a;

    public k(Context context) {
        this.a = context;
    }

    public c a(l lVar) {
        switch (lVar) {
            case MSG_TYPE_SINGLE_PRIVATE:
            case MSG_TYPE_MULTI_PRIVATE:
                return new g(this.a);
            case MSG_TYPE_PRIVATE_MESSAGE:
                return new h(this.a);
            case MSG_TYPE_SINGLE_PUBLIC:
            case MSG_TYPE_MULTI_PUBLIC:
                return new i(this.a);
            case MSG_TYPE_MULTI_PRIVATE_NOTIFICATION:
                return new e(this.a);
            case MSG_TYPE_RICH_MEDIA:
                return new m(this.a);
            case MSG_TYPE_BAIDU_SUPPER:
                return new b(this.a);
            case MSG_TYPE_INNERBIND:
                return new d(this.a);
            case MSG_TYPE_ALARM_MESSAGE:
            case MSG_TYPE_ALARM_NOTIFICATION:
            case MSG_TYPE_ALARM_AD_NOTIFICATION:
                return new a(this.a);
            case MSG_TYPE_ULTRON_COMMAND:
                return new n(this.a);
            default:
                com.baidu.android.pushservice.j.m.b(">>> Unknown msg_type : " + lVar, this.a);
                return null;
        }
    }
}

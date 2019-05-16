package com.baidu.android.pushservice.message.a;

import android.content.Context;
import com.baidu.android.pushservice.i.l;
/* loaded from: classes3.dex */
public class j {
    private Context a;

    public j(Context context) {
        this.a = context;
    }

    public b a(k kVar) {
        switch (kVar) {
            case MSG_TYPE_SINGLE_PRIVATE:
            case MSG_TYPE_MULTI_PRIVATE:
                return new f(this.a);
            case MSG_TYPE_PRIVATE_MESSAGE:
                return new g(this.a);
            case MSG_TYPE_SINGLE_PUBLIC:
            case MSG_TYPE_MULTI_PUBLIC:
                return new h(this.a);
            case MSG_TYPE_MULTI_PRIVATE_NOTIFICATION:
                return new d(this.a);
            case MSG_TYPE_INNERBIND:
                return new c(this.a);
            case MSG_TYPE_CROSS_PUSH:
                return new a(this.a);
            default:
                l.b(">>> Unknown msg_type : " + kVar, this.a);
                return null;
        }
    }
}

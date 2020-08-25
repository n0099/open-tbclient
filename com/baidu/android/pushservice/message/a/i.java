package com.baidu.android.pushservice.message.a;

import android.content.Context;
import com.baidu.android.pushservice.i.m;
/* loaded from: classes5.dex */
public class i {
    private Context a;

    public i(Context context) {
        this.a = context;
    }

    public b a(j jVar) {
        switch (jVar) {
            case MSG_TYPE_SINGLE_PRIVATE:
            case MSG_TYPE_MULTI_PRIVATE:
                return new e(this.a);
            case MSG_TYPE_PRIVATE_MESSAGE:
                return new f(this.a);
            case MSG_TYPE_SINGLE_PUBLIC:
            case MSG_TYPE_MULTI_PUBLIC:
                return new g(this.a);
            case MSG_TYPE_MULTI_PRIVATE_NOTIFICATION:
                return new c(this.a);
            case MSG_TYPE_CROSS_PUSH:
                return new a(this.a);
            default:
                m.a(">>> Unknown msg_type : " + jVar, this.a);
                return null;
        }
    }
}

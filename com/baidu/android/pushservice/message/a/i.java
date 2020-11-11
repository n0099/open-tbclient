package com.baidu.android.pushservice.message.a;

import android.content.Context;
import com.baidu.android.pushservice.i.m;
/* loaded from: classes10.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private Context f1173a;

    public i(Context context) {
        this.f1173a = context;
    }

    public b a(j jVar) {
        switch (jVar) {
            case MSG_TYPE_SINGLE_PRIVATE:
            case MSG_TYPE_MULTI_PRIVATE:
                return new e(this.f1173a);
            case MSG_TYPE_PRIVATE_MESSAGE:
                return new f(this.f1173a);
            case MSG_TYPE_SINGLE_PUBLIC:
            case MSG_TYPE_MULTI_PUBLIC:
                return new g(this.f1173a);
            case MSG_TYPE_MULTI_PRIVATE_NOTIFICATION:
                return new c(this.f1173a);
            case MSG_TYPE_CROSS_PUSH:
                return new a(this.f1173a);
            default:
                m.a(">>> Unknown msg_type : " + jVar, this.f1173a);
                return null;
        }
    }
}

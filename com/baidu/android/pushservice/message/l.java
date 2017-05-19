package com.baidu.android.pushservice.message;

import android.content.Context;
/* loaded from: classes2.dex */
public class l extends c {
    private static final String b = l.class.getSimpleName();

    public l(Context context) {
        super(context);
    }

    @Override // com.baidu.android.pushservice.message.c
    public g a(e eVar) {
        eVar.e = true;
        g gVar = new g();
        gVar.a(0);
        com.baidu.android.pushservice.e.a.b(b, "handleMessage: server heart beat type - " + ((int) eVar.a));
        return gVar;
    }
}

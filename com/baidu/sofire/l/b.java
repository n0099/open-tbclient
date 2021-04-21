package com.baidu.sofire.l;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.sofire.h.c;
/* loaded from: classes2.dex */
public final class b implements com.baidu.sofire.h.b {

    /* renamed from: a  reason: collision with root package name */
    public Context f11509a;

    /* renamed from: b  reason: collision with root package name */
    public a f11510b;

    @Override // com.baidu.sofire.h.b
    public final void a(Context context, c cVar) {
        this.f11509a = context;
        a aVar = new a();
        this.f11510b = aVar;
        aVar.f11505c = null;
        aVar.f11506d = null;
        aVar.f11507e = null;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            aVar.f11504b = cls;
            aVar.f11503a = cls.newInstance();
        } catch (Exception e2) {
            Log.d("IdentifierManager", "reflect exception!", e2);
        }
        try {
            aVar.f11505c = aVar.f11504b.getMethod("getOAID", Context.class);
        } catch (Exception e3) {
            Log.d("IdentifierManager", "reflect exception!", e3);
        }
        try {
            aVar.f11506d = aVar.f11504b.getMethod("getVAID", Context.class);
        } catch (Exception e4) {
            Log.d("IdentifierManager", "reflect exception!", e4);
        }
        try {
            aVar.f11507e = aVar.f11504b.getMethod("getAAID", Context.class);
        } catch (Exception e5) {
            Log.d("IdentifierManager", "reflect exception!", e5);
        }
    }

    @Override // com.baidu.sofire.h.b
    public final String b() {
        a aVar = this.f11510b;
        Context context = this.f11509a;
        if (TextUtils.isEmpty(aVar.f11508f)) {
            aVar.f11508f = aVar.a(context, aVar.f11505c);
        }
        return aVar.f11508f;
    }
}

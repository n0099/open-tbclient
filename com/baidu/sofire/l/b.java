package com.baidu.sofire.l;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.sofire.h.c;
/* loaded from: classes2.dex */
public final class b implements com.baidu.sofire.h.b {

    /* renamed from: a  reason: collision with root package name */
    public Context f10401a;

    /* renamed from: b  reason: collision with root package name */
    public a f10402b;

    @Override // com.baidu.sofire.h.b
    public final void a(Context context, c cVar) {
        this.f10401a = context;
        a aVar = new a();
        this.f10402b = aVar;
        aVar.f10397c = null;
        aVar.f10398d = null;
        aVar.f10399e = null;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            aVar.f10396b = cls;
            aVar.f10395a = cls.newInstance();
        } catch (Exception e2) {
            Log.d("IdentifierManager", "reflect exception!", e2);
        }
        try {
            aVar.f10397c = aVar.f10396b.getMethod("getOAID", Context.class);
        } catch (Exception e3) {
            Log.d("IdentifierManager", "reflect exception!", e3);
        }
        try {
            aVar.f10398d = aVar.f10396b.getMethod("getVAID", Context.class);
        } catch (Exception e4) {
            Log.d("IdentifierManager", "reflect exception!", e4);
        }
        try {
            aVar.f10399e = aVar.f10396b.getMethod("getAAID", Context.class);
        } catch (Exception e5) {
            Log.d("IdentifierManager", "reflect exception!", e5);
        }
    }

    @Override // com.baidu.sofire.h.b
    public final String b() {
        a aVar = this.f10402b;
        Context context = this.f10401a;
        if (TextUtils.isEmpty(aVar.f10400f)) {
            aVar.f10400f = aVar.a(context, aVar.f10397c);
        }
        return aVar.f10400f;
    }
}

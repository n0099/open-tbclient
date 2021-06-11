package com.baidu.sofire.l;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.sofire.h.c;
/* loaded from: classes2.dex */
public final class b implements com.baidu.sofire.h.b {

    /* renamed from: a  reason: collision with root package name */
    public Context f10364a;

    /* renamed from: b  reason: collision with root package name */
    public a f10365b;

    @Override // com.baidu.sofire.h.b
    public final void a(Context context, c cVar) {
        this.f10364a = context;
        a aVar = new a();
        this.f10365b = aVar;
        aVar.f10360c = null;
        aVar.f10361d = null;
        aVar.f10362e = null;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            aVar.f10359b = cls;
            aVar.f10358a = cls.newInstance();
        } catch (Exception e2) {
            Log.d("IdentifierManager", "reflect exception!", e2);
        }
        try {
            aVar.f10360c = aVar.f10359b.getMethod("getOAID", Context.class);
        } catch (Exception e3) {
            Log.d("IdentifierManager", "reflect exception!", e3);
        }
        try {
            aVar.f10361d = aVar.f10359b.getMethod("getVAID", Context.class);
        } catch (Exception e4) {
            Log.d("IdentifierManager", "reflect exception!", e4);
        }
        try {
            aVar.f10362e = aVar.f10359b.getMethod("getAAID", Context.class);
        } catch (Exception e5) {
            Log.d("IdentifierManager", "reflect exception!", e5);
        }
    }

    @Override // com.baidu.sofire.h.b
    public final String b() {
        a aVar = this.f10365b;
        Context context = this.f10364a;
        if (TextUtils.isEmpty(aVar.f10363f)) {
            aVar.f10363f = aVar.a(context, aVar.f10360c);
        }
        return aVar.f10363f;
    }
}

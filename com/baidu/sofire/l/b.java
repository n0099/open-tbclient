package com.baidu.sofire.l;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.sofire.h.c;
/* loaded from: classes2.dex */
public final class b implements com.baidu.sofire.h.b {

    /* renamed from: a  reason: collision with root package name */
    public Context f11840a;

    /* renamed from: b  reason: collision with root package name */
    public a f11841b;

    @Override // com.baidu.sofire.h.b
    public final void a(Context context, c cVar) {
        this.f11840a = context;
        a aVar = new a();
        this.f11841b = aVar;
        aVar.f11836c = null;
        aVar.f11837d = null;
        aVar.f11838e = null;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            aVar.f11835b = cls;
            aVar.f11834a = cls.newInstance();
        } catch (Exception e2) {
            Log.d("IdentifierManager", "reflect exception!", e2);
        }
        try {
            aVar.f11836c = aVar.f11835b.getMethod("getOAID", Context.class);
        } catch (Exception e3) {
            Log.d("IdentifierManager", "reflect exception!", e3);
        }
        try {
            aVar.f11837d = aVar.f11835b.getMethod("getVAID", Context.class);
        } catch (Exception e4) {
            Log.d("IdentifierManager", "reflect exception!", e4);
        }
        try {
            aVar.f11838e = aVar.f11835b.getMethod("getAAID", Context.class);
        } catch (Exception e5) {
            Log.d("IdentifierManager", "reflect exception!", e5);
        }
    }

    @Override // com.baidu.sofire.h.b
    public final String b() {
        a aVar = this.f11841b;
        Context context = this.f11840a;
        if (TextUtils.isEmpty(aVar.f11839f)) {
            aVar.f11839f = aVar.a(context, aVar.f11836c);
        }
        return aVar.f11839f;
    }
}

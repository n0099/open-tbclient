package com.baidu.sofire.l;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.sofire.h.c;
/* loaded from: classes2.dex */
public final class b implements com.baidu.sofire.h.b {

    /* renamed from: a  reason: collision with root package name */
    public Context f11501a;

    /* renamed from: b  reason: collision with root package name */
    public a f11502b;

    @Override // com.baidu.sofire.h.b
    public final void a(Context context, c cVar) {
        this.f11501a = context;
        a aVar = new a();
        this.f11502b = aVar;
        aVar.f11497c = null;
        aVar.f11498d = null;
        aVar.f11499e = null;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            aVar.f11496b = cls;
            aVar.f11495a = cls.newInstance();
        } catch (Exception e2) {
            Log.d("IdentifierManager", "reflect exception!", e2);
        }
        try {
            aVar.f11497c = aVar.f11496b.getMethod("getOAID", Context.class);
        } catch (Exception e3) {
            Log.d("IdentifierManager", "reflect exception!", e3);
        }
        try {
            aVar.f11498d = aVar.f11496b.getMethod("getVAID", Context.class);
        } catch (Exception e4) {
            Log.d("IdentifierManager", "reflect exception!", e4);
        }
        try {
            aVar.f11499e = aVar.f11496b.getMethod("getAAID", Context.class);
        } catch (Exception e5) {
            Log.d("IdentifierManager", "reflect exception!", e5);
        }
    }

    @Override // com.baidu.sofire.h.b
    public final String b() {
        a aVar = this.f11502b;
        Context context = this.f11501a;
        if (TextUtils.isEmpty(aVar.f11500f)) {
            aVar.f11500f = aVar.a(context, aVar.f11497c);
        }
        return aVar.f11500f;
    }
}

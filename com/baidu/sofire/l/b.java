package com.baidu.sofire.l;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.sofire.h.c;
/* loaded from: classes2.dex */
public final class b implements com.baidu.sofire.h.b {

    /* renamed from: a  reason: collision with root package name */
    public Context f11334a;

    /* renamed from: b  reason: collision with root package name */
    public a f11335b;

    @Override // com.baidu.sofire.h.b
    public final void a(Context context, c cVar) {
        this.f11334a = context;
        a aVar = new a();
        this.f11335b = aVar;
        aVar.f11330c = null;
        aVar.f11331d = null;
        aVar.f11332e = null;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            aVar.f11329b = cls;
            aVar.f11328a = cls.newInstance();
        } catch (Exception e2) {
            Log.d("IdentifierManager", "reflect exception!", e2);
        }
        try {
            aVar.f11330c = aVar.f11329b.getMethod("getOAID", Context.class);
        } catch (Exception e3) {
            Log.d("IdentifierManager", "reflect exception!", e3);
        }
        try {
            aVar.f11331d = aVar.f11329b.getMethod("getVAID", Context.class);
        } catch (Exception e4) {
            Log.d("IdentifierManager", "reflect exception!", e4);
        }
        try {
            aVar.f11332e = aVar.f11329b.getMethod("getAAID", Context.class);
        } catch (Exception e5) {
            Log.d("IdentifierManager", "reflect exception!", e5);
        }
    }

    @Override // com.baidu.sofire.h.b
    public final String b() {
        a aVar = this.f11335b;
        Context context = this.f11334a;
        if (TextUtils.isEmpty(aVar.f11333f)) {
            aVar.f11333f = aVar.a(context, aVar.f11330c);
        }
        return aVar.f11333f;
    }
}

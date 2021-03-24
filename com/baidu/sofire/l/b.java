package com.baidu.sofire.l;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.sofire.h.c;
/* loaded from: classes3.dex */
public final class b implements com.baidu.sofire.h.b {

    /* renamed from: a  reason: collision with root package name */
    public Context f11839a;

    /* renamed from: b  reason: collision with root package name */
    public a f11840b;

    @Override // com.baidu.sofire.h.b
    public final void a(Context context, c cVar) {
        this.f11839a = context;
        a aVar = new a();
        this.f11840b = aVar;
        aVar.f11835c = null;
        aVar.f11836d = null;
        aVar.f11837e = null;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            aVar.f11834b = cls;
            aVar.f11833a = cls.newInstance();
        } catch (Exception e2) {
            Log.d("IdentifierManager", "reflect exception!", e2);
        }
        try {
            aVar.f11835c = aVar.f11834b.getMethod("getOAID", Context.class);
        } catch (Exception e3) {
            Log.d("IdentifierManager", "reflect exception!", e3);
        }
        try {
            aVar.f11836d = aVar.f11834b.getMethod("getVAID", Context.class);
        } catch (Exception e4) {
            Log.d("IdentifierManager", "reflect exception!", e4);
        }
        try {
            aVar.f11837e = aVar.f11834b.getMethod("getAAID", Context.class);
        } catch (Exception e5) {
            Log.d("IdentifierManager", "reflect exception!", e5);
        }
    }

    @Override // com.baidu.sofire.h.b
    public final String b() {
        a aVar = this.f11840b;
        Context context = this.f11839a;
        if (TextUtils.isEmpty(aVar.f11838f)) {
            aVar.f11838f = aVar.a(context, aVar.f11835c);
        }
        return aVar.f11838f;
    }
}

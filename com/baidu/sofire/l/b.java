package com.baidu.sofire.l;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.sofire.h.c;
/* loaded from: classes2.dex */
public final class b implements com.baidu.sofire.h.b {

    /* renamed from: a  reason: collision with root package name */
    public Context f10302a;

    /* renamed from: b  reason: collision with root package name */
    public a f10303b;

    @Override // com.baidu.sofire.h.b
    public final void a(Context context, c cVar) {
        this.f10302a = context;
        a aVar = new a();
        this.f10303b = aVar;
        aVar.f10298c = null;
        aVar.f10299d = null;
        aVar.f10300e = null;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            aVar.f10297b = cls;
            aVar.f10296a = cls.newInstance();
        } catch (Exception e2) {
            Log.d("IdentifierManager", "reflect exception!", e2);
        }
        try {
            aVar.f10298c = aVar.f10297b.getMethod("getOAID", Context.class);
        } catch (Exception e3) {
            Log.d("IdentifierManager", "reflect exception!", e3);
        }
        try {
            aVar.f10299d = aVar.f10297b.getMethod("getVAID", Context.class);
        } catch (Exception e4) {
            Log.d("IdentifierManager", "reflect exception!", e4);
        }
        try {
            aVar.f10300e = aVar.f10297b.getMethod("getAAID", Context.class);
        } catch (Exception e5) {
            Log.d("IdentifierManager", "reflect exception!", e5);
        }
    }

    @Override // com.baidu.sofire.h.b
    public final String b() {
        a aVar = this.f10303b;
        Context context = this.f10302a;
        if (TextUtils.isEmpty(aVar.f10301f)) {
            aVar.f10301f = aVar.a(context, aVar.f10298c);
        }
        return aVar.f10301f;
    }
}

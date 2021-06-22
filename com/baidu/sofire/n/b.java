package com.baidu.sofire.n;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.sofire.j.c;
/* loaded from: classes2.dex */
public final class b implements com.baidu.sofire.j.b {

    /* renamed from: a  reason: collision with root package name */
    public Context f10386a;

    /* renamed from: b  reason: collision with root package name */
    public a f10387b;

    @Override // com.baidu.sofire.j.b
    public final void a(Context context, c cVar) {
        this.f10386a = context;
        a aVar = new a();
        this.f10387b = aVar;
        aVar.f10382c = null;
        aVar.f10383d = null;
        aVar.f10384e = null;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            aVar.f10381b = cls;
            aVar.f10380a = cls.newInstance();
        } catch (Exception e2) {
            Log.d("IdentifierManager", "reflect exception!", e2);
        }
        try {
            aVar.f10382c = aVar.f10381b.getMethod("getOAID", Context.class);
        } catch (Exception e3) {
            Log.d("IdentifierManager", "reflect exception!", e3);
        }
        try {
            aVar.f10383d = aVar.f10381b.getMethod("getVAID", Context.class);
        } catch (Exception e4) {
            Log.d("IdentifierManager", "reflect exception!", e4);
        }
        try {
            aVar.f10384e = aVar.f10381b.getMethod("getAAID", Context.class);
        } catch (Exception e5) {
            Log.d("IdentifierManager", "reflect exception!", e5);
        }
    }

    @Override // com.baidu.sofire.j.b
    public final String b() {
        a aVar = this.f10387b;
        Context context = this.f10386a;
        if (TextUtils.isEmpty(aVar.f10385f)) {
            aVar.f10385f = aVar.a(context, aVar.f10382c);
        }
        return aVar.f10385f;
    }
}

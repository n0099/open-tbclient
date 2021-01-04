package com.baidu.sofire.n;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.sofire.j.c;
/* loaded from: classes15.dex */
public final class b implements com.baidu.sofire.j.b {

    /* renamed from: a  reason: collision with root package name */
    private Context f5596a;

    /* renamed from: b  reason: collision with root package name */
    private a f5597b;

    @Override // com.baidu.sofire.j.b
    public final void a(Context context, c cVar) {
        this.f5596a = context;
        this.f5597b = new a();
        a aVar = this.f5597b;
        aVar.c = null;
        aVar.d = null;
        aVar.e = null;
        try {
            aVar.f5595b = Class.forName("com.android.id.impl.IdProviderImpl");
            aVar.f5594a = aVar.f5595b.newInstance();
        } catch (Exception e) {
            Log.d("IdentifierManager", "reflect exception!", e);
        }
        try {
            aVar.c = aVar.f5595b.getMethod("getOAID", Context.class);
        } catch (Exception e2) {
            Log.d("IdentifierManager", "reflect exception!", e2);
        }
        try {
            aVar.d = aVar.f5595b.getMethod("getVAID", Context.class);
        } catch (Exception e3) {
            Log.d("IdentifierManager", "reflect exception!", e3);
        }
        try {
            aVar.e = aVar.f5595b.getMethod("getAAID", Context.class);
        } catch (Exception e4) {
            Log.d("IdentifierManager", "reflect exception!", e4);
        }
    }

    @Override // com.baidu.sofire.j.b
    public final String b() {
        a aVar = this.f5597b;
        Context context = this.f5596a;
        if (TextUtils.isEmpty(aVar.f)) {
            aVar.f = aVar.a(context, aVar.c);
        }
        return aVar.f;
    }
}

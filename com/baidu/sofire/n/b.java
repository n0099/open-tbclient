package com.baidu.sofire.n;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.sofire.j.c;
/* loaded from: classes9.dex */
public final class b implements com.baidu.sofire.j.b {

    /* renamed from: a  reason: collision with root package name */
    private Context f3668a;
    private a b;

    @Override // com.baidu.sofire.j.b
    public final void a(Context context, c cVar) {
        this.f3668a = context;
        this.b = new a();
        a aVar = this.b;
        aVar.c = null;
        aVar.d = null;
        aVar.e = null;
        try {
            aVar.b = Class.forName("com.android.id.impl.IdProviderImpl");
            aVar.f3667a = aVar.b.newInstance();
        } catch (Exception e) {
            Log.d("IdentifierManager", "reflect exception!", e);
        }
        try {
            aVar.c = aVar.b.getMethod("getOAID", Context.class);
        } catch (Exception e2) {
            Log.d("IdentifierManager", "reflect exception!", e2);
        }
        try {
            aVar.d = aVar.b.getMethod("getVAID", Context.class);
        } catch (Exception e3) {
            Log.d("IdentifierManager", "reflect exception!", e3);
        }
        try {
            aVar.e = aVar.b.getMethod("getAAID", Context.class);
        } catch (Exception e4) {
            Log.d("IdentifierManager", "reflect exception!", e4);
        }
    }

    @Override // com.baidu.sofire.j.b
    public final String b() {
        a aVar = this.b;
        Context context = this.f3668a;
        if (TextUtils.isEmpty(aVar.f)) {
            aVar.f = aVar.a(context, aVar.c);
        }
        return aVar.f;
    }
}

package com.baidu.sofire.n;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.sofire.j.c;
/* loaded from: classes14.dex */
public final class b implements com.baidu.sofire.j.b {

    /* renamed from: a  reason: collision with root package name */
    private Context f5314a;

    /* renamed from: b  reason: collision with root package name */
    private a f5315b;

    @Override // com.baidu.sofire.j.b
    public final void a(Context context, c cVar) {
        this.f5314a = context;
        this.f5315b = new a();
        a aVar = this.f5315b;
        aVar.c = null;
        aVar.d = null;
        aVar.e = null;
        try {
            aVar.f5313b = Class.forName("com.android.id.impl.IdProviderImpl");
            aVar.f5312a = aVar.f5313b.newInstance();
        } catch (Exception e) {
            Log.d("IdentifierManager", "reflect exception!", e);
        }
        try {
            aVar.c = aVar.f5313b.getMethod("getOAID", Context.class);
        } catch (Exception e2) {
            Log.d("IdentifierManager", "reflect exception!", e2);
        }
        try {
            aVar.d = aVar.f5313b.getMethod("getVAID", Context.class);
        } catch (Exception e3) {
            Log.d("IdentifierManager", "reflect exception!", e3);
        }
        try {
            aVar.e = aVar.f5313b.getMethod("getAAID", Context.class);
        } catch (Exception e4) {
            Log.d("IdentifierManager", "reflect exception!", e4);
        }
    }

    @Override // com.baidu.sofire.j.b
    public final String b() {
        a aVar = this.f5315b;
        Context context = this.f5314a;
        if (TextUtils.isEmpty(aVar.f)) {
            aVar.f = aVar.a(context, aVar.c);
        }
        return aVar.f;
    }
}

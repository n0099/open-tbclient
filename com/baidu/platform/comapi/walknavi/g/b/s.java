package com.baidu.platform.comapi.walknavi.g.b;

import android.content.Context;
import android.widget.Toast;
import com.baidu.platform.comapi.walknavi.g.b.c;
/* loaded from: classes2.dex */
public class s implements c.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f10030a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ c.d f10031b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ c f10032c;

    public s(c cVar, String str, c.d dVar) {
        this.f10032c = cVar;
        this.f10030a = str;
        this.f10031b = dVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.g.b.c.b
    public void a(String str) {
        boolean z;
        Context context;
        z = this.f10032c.R;
        if (z) {
            this.f10032c.R = false;
            context = this.f10032c.l;
            Toast.makeText(context, "模型更新成功，下次进入时即可生效", 0).show();
        } else if (com.baidu.platform.comapi.wnplatform.a.a().c()) {
            this.f10032c.b(this.f10030a, str);
            c.d dVar = this.f10031b;
            if (dVar != null) {
                dVar.a();
            }
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.g.b.c.b
    public void a(int i2) {
        this.f10031b.b();
    }
}

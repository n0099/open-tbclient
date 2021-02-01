package com.baidu.platform.comapi.walknavi.g.b;

import android.content.Context;
import android.widget.Toast;
import com.baidu.platform.comapi.walknavi.g.b.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class s implements c.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f4320a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ c.d f4321b;
    final /* synthetic */ c c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(c cVar, String str, c.d dVar) {
        this.c = cVar;
        this.f4320a = str;
        this.f4321b = dVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.g.b.c.b
    public void a(String str) {
        boolean z;
        Context context;
        z = this.c.R;
        if (z) {
            this.c.R = false;
            context = this.c.l;
            Toast.makeText(context, "模型更新成功，下次进入时即可生效", 0).show();
        } else if (com.baidu.platform.comapi.wnplatform.a.a().c()) {
            this.c.b(this.f4320a, str);
            if (this.f4321b != null) {
                this.f4321b.a();
            }
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.g.b.c.b
    public void a(int i) {
        this.f4321b.b();
    }
}

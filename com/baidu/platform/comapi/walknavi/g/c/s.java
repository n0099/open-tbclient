package com.baidu.platform.comapi.walknavi.g.c;

import android.content.Context;
import android.widget.Toast;
import com.baidu.platform.comapi.walknavi.g.c.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class s implements c.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f4539a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ c.d f4540b;
    final /* synthetic */ c c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(c cVar, String str, c.d dVar) {
        this.c = cVar;
        this.f4539a = str;
        this.f4540b = dVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.g.c.c.b
    public void a(String str) {
        boolean z;
        Context context;
        z = this.c.S;
        if (z) {
            this.c.S = false;
            context = this.c.l;
            Toast.makeText(context, "模型更新成功，下次进入时即可生效", 0).show();
        } else if (com.baidu.platform.comapi.wnplatform.a.a().c()) {
            this.c.b(this.f4539a, str);
            if (this.f4540b != null) {
                this.f4540b.a();
            }
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.g.c.c.b
    public void a(int i) {
        this.f4540b.b();
    }
}

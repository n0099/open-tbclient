package com.baidu.tbadk.core.voice.a;

import android.content.Context;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.u;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends com.baidu.adp.lib.e.a<d> {
    final /* synthetic */ a a;
    private final /* synthetic */ c b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, c cVar) {
        this.a = aVar;
        this.b = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.e.a
    public void a(d dVar, String str, com.baidu.adp.lib.e.e eVar) {
        Context context;
        LinkedList linkedList;
        super.a((b) dVar, str, eVar);
        if (dVar != null) {
            this.b.a(dVar.b, dVar.a, dVar.c, dVar.d);
        } else {
            c cVar = this.b;
            context = this.a.b;
            cVar.a(null, null, 1, context.getString(u.voice_cache_error_internal));
        }
        linkedList = this.a.a;
        linkedList.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.e.a
    public void c(String str, com.baidu.adp.lib.e.e eVar) {
        LinkedList linkedList;
        al alVar;
        super.c(str, eVar);
        if (eVar != null && (alVar = (al) eVar.a("network")) != null) {
            alVar.g();
        }
        linkedList = this.a.a;
        linkedList.remove(str);
    }
}

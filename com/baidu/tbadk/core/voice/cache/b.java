package com.baidu.tbadk.core.voice.cache;

import android.content.Context;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.l;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b extends com.baidu.adp.lib.e.a<d> {
    final /* synthetic */ a a;
    private final /* synthetic */ c b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, c cVar) {
        this.a = aVar;
        this.b = cVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.String, com.baidu.adp.lib.e.e] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.e.a
    public final /* synthetic */ void a(d dVar, String str, com.baidu.adp.lib.e.e eVar) {
        Context context;
        LinkedList linkedList;
        d dVar2 = dVar;
        super.a(dVar2, str, eVar);
        if (dVar2 != null) {
            this.b.a(dVar2.b, dVar2.a, dVar2.c, dVar2.d);
        } else {
            c cVar = this.b;
            context = this.a.b;
            cVar.a(null, null, 1, context.getString(l.voice_cache_error_internal));
        }
        linkedList = this.a.a;
        linkedList.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.e.a
    public final void b(String str, com.baidu.adp.lib.e.e eVar) {
        LinkedList linkedList;
        ak akVar;
        super.b(str, eVar);
        if (eVar != null && (akVar = (ak) eVar.a("network")) != null) {
            akVar.g();
        }
        linkedList = this.a.a;
        linkedList.remove(str);
    }
}

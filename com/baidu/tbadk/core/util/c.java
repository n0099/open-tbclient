package com.baidu.tbadk.core.util;

import java.util.Iterator;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c extends com.baidu.adp.lib.e.a<com.baidu.adp.widget.ImageView.b> {
    final /* synthetic */ b a;
    private final /* synthetic */ e b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, e eVar) {
        this.a = bVar;
        this.b = eVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.String, com.baidu.adp.lib.e.e] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.e.a
    public final /* synthetic */ void a(com.baidu.adp.widget.ImageView.b bVar, String str, com.baidu.adp.lib.e.e eVar) {
        LinkedList linkedList;
        LinkedList linkedList2;
        LinkedList linkedList3;
        com.baidu.adp.widget.ImageView.b bVar2 = bVar;
        super.a(bVar2, str, eVar);
        linkedList = this.a.k;
        linkedList.remove(this.b);
        if (!this.b.o && !this.b.a() && this.b.b != null) {
            Iterator<com.baidu.tbadk.imageManager.d> it = this.b.b.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.imageManager.d next = it.next();
                if (next != null && this.b != null) {
                    if (bVar2 != null && this.b.i == null) {
                        TiebaStatic.a("", -1008, "resource of onLoaded() is not null but task.img is null", bVar2.j());
                    }
                    next.a(this.b.i == null ? bVar2 : this.b.i, this.b.b(), this.b.f);
                }
            }
            this.b.a(true);
        }
        linkedList2 = this.a.l;
        if (linkedList2.size() > 0) {
            linkedList3 = this.a.l;
            d dVar = (d) linkedList3.remove(0);
            this.a.a(dVar.a, dVar.c, dVar.b, dVar.d, false, dVar.e, dVar.f, dVar.g, true);
        }
        if (this.b.f) {
            return;
        }
        new ay(this.b).execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.e.a
    public final void a(String str, com.baidu.adp.lib.e.e eVar) {
        super.a(str, eVar);
        e eVar2 = this.b;
        eVar2.n = true;
        if (eVar2.a != null) {
            eVar2.a.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.e.a
    public final void b(String str, com.baidu.adp.lib.e.e eVar) {
        LinkedList linkedList;
        LinkedList linkedList2;
        LinkedList linkedList3;
        super.b(str, eVar);
        linkedList = this.a.k;
        linkedList.remove(this.b);
        linkedList2 = this.a.l;
        if (linkedList2.size() > 0) {
            linkedList3 = this.a.l;
            d dVar = (d) linkedList3.remove(0);
            if (dVar != null) {
                this.a.a(dVar.a, dVar.c, dVar.b, dVar.d, false, dVar.e, dVar.f, dVar.g, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.e.a
    public final void a(Object... objArr) {
        super.a(objArr);
        if ((this.b.o || this.b.i != null) && !this.b.a()) {
            this.b.o = false;
            if (this.b.b != null) {
                Iterator<com.baidu.tbadk.imageManager.d> it = this.b.b.iterator();
                while (it.hasNext()) {
                    com.baidu.tbadk.imageManager.d next = it.next();
                    if (next != null) {
                        next.a(this.b.i, this.b.b(), this.b.f);
                    }
                }
                this.b.a(true);
            }
        }
    }
}

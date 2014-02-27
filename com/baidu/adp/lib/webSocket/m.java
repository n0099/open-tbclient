package com.baidu.adp.lib.webSocket;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class m implements k {
    final /* synthetic */ l a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.a = lVar;
    }

    @Override // com.baidu.adp.lib.webSocket.k
    public final void a(String str) {
        ArrayList arrayList;
        arrayList = this.a.g;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((k) it.next()).a(str);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.k
    public final void b(byte[] bArr) {
        ArrayList arrayList;
        arrayList = this.a.g;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((k) it.next()).b(bArr);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.k
    public final void a(byte[] bArr) {
        ArrayList arrayList;
        arrayList = this.a.g;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((k) it.next()).a(bArr);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.k
    public final void a(Map<String, String> map) {
        ArrayList arrayList;
        arrayList = this.a.g;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((k) it.next()).a(map);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.k
    public final void a(int i, String str) {
        ArrayList arrayList;
        this.a.f = null;
        arrayList = this.a.g;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((k) it.next()).a(i, str);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.k
    public final void a(d dVar) {
        ArrayList arrayList;
        arrayList = this.a.g;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((k) it.next()).a(dVar);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.k
    public final void a() {
        ArrayList arrayList;
        arrayList = this.a.g;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((k) it.next()).a();
        }
    }

    @Override // com.baidu.adp.lib.webSocket.k
    public final void b(d dVar) {
        if (dVar != null) {
            dVar.b();
        }
    }

    @Override // com.baidu.adp.lib.webSocket.k
    public final void a(int i, d dVar) {
        if (dVar != null) {
            dVar.a(2);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.k
    public final void c(d dVar) {
        if (dVar != null) {
            dVar.c();
        }
    }
}

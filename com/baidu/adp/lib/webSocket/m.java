package com.baidu.adp.lib.webSocket;

import java.util.ArrayList;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements k {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ l f537a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.f537a = lVar;
    }

    @Override // com.baidu.adp.lib.webSocket.k
    public void a(String str) {
        ArrayList arrayList;
        arrayList = this.f537a.g;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((k) it.next()).a(str);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.k
    public void a(byte[] bArr) {
        ArrayList arrayList;
        arrayList = this.f537a.g;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((k) it.next()).a(bArr);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.k
    public void b(byte[] bArr) {
        ArrayList arrayList;
        arrayList = this.f537a.g;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((k) it.next()).b(bArr);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.k
    public void a() {
        ArrayList arrayList;
        arrayList = this.f537a.g;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((k) it.next()).a();
        }
    }

    @Override // com.baidu.adp.lib.webSocket.k
    public void a(int i, String str) {
        ArrayList arrayList;
        this.f537a.f = null;
        arrayList = this.f537a.g;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((k) it.next()).a(i, str);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.k
    public void a(am amVar) {
        ArrayList arrayList;
        arrayList = this.f537a.g;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((k) it.next()).a(amVar);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.k
    public void b() {
        ArrayList arrayList;
        arrayList = this.f537a.g;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((k) it.next()).b();
        }
    }

    @Override // com.baidu.adp.lib.webSocket.k
    public void b(am amVar) {
        if (amVar != null && amVar.d() != null) {
            amVar.d().a(amVar);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.k
    public void c(am amVar) {
        if (amVar != null && amVar.d() != null) {
            amVar.d().b(amVar);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.k
    public void d(am amVar) {
        if (amVar != null && amVar.d() != null) {
            amVar.d().c(amVar);
        }
    }
}

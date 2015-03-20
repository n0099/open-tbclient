package com.baidu.adp.lib.webSocket;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements k {
    final /* synthetic */ l Ag;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.Ag = lVar;
    }

    @Override // com.baidu.adp.lib.webSocket.k
    public void G(String str) {
        ArrayList arrayList;
        arrayList = this.Ag.Ae;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((k) it.next()).G(str);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.k
    public void s(byte[] bArr) {
        ArrayList arrayList;
        arrayList = this.Ag.Ae;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((k) it.next()).s(bArr);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.k
    public void j(byte[] bArr) {
        ArrayList arrayList;
        arrayList = this.Ag.Ae;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((k) it.next()).j(bArr);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.k
    public void d(Map<String, String> map) {
        ArrayList arrayList;
        arrayList = this.Ag.Ae;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((k) it.next()).d(map);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.k
    public void l(int i, String str) {
        ArrayList arrayList;
        this.Ag.Ac = null;
        arrayList = this.Ag.Ae;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((k) it.next()).l(i, str);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.k
    public void a(c cVar) {
        ArrayList arrayList;
        arrayList = this.Ag.Ae;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((k) it.next()).a(cVar);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.k
    public void jq() {
        ArrayList arrayList;
        arrayList = this.Ag.Ae;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((k) it.next()).jq();
        }
    }

    @Override // com.baidu.adp.lib.webSocket.k
    public void b(c cVar) {
        if (cVar != null) {
            cVar.ed();
        }
    }

    @Override // com.baidu.adp.lib.webSocket.k
    public void a(int i, c cVar) {
        if (cVar != null) {
            cVar.v(i);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.k
    public void c(c cVar) {
        if (cVar != null) {
            cVar.ee();
        }
    }
}

package com.baidu.adp.lib.webSocket;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements k {
    final /* synthetic */ l zU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.zU = lVar;
    }

    @Override // com.baidu.adp.lib.webSocket.k
    public void J(String str) {
        ArrayList arrayList;
        arrayList = this.zU.zS;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((k) it.next()).J(str);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.k
    public void s(byte[] bArr) {
        ArrayList arrayList;
        arrayList = this.zU.zS;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((k) it.next()).s(bArr);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.k
    public void j(byte[] bArr) {
        ArrayList arrayList;
        arrayList = this.zU.zS;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((k) it.next()).j(bArr);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.k
    public void d(Map<String, String> map) {
        ArrayList arrayList;
        arrayList = this.zU.zS;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((k) it.next()).d(map);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.k
    public void l(int i, String str) {
        ArrayList arrayList;
        this.zU.zR = null;
        arrayList = this.zU.zS;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((k) it.next()).l(i, str);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.k
    public void a(c cVar) {
        ArrayList arrayList;
        arrayList = this.zU.zS;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((k) it.next()).a(cVar);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.k
    public void jH() {
        ArrayList arrayList;
        arrayList = this.zU.zS;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((k) it.next()).jH();
        }
    }

    @Override // com.baidu.adp.lib.webSocket.k
    public void b(c cVar) {
        if (cVar != null) {
            cVar.eg();
        }
    }

    @Override // com.baidu.adp.lib.webSocket.k
    public void a(int i, c cVar) {
        if (cVar != null) {
            cVar.w(i);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.k
    public void c(c cVar) {
        if (cVar != null) {
            cVar.eh();
        }
    }
}

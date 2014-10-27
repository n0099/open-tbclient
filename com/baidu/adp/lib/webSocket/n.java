package com.baidu.adp.lib.webSocket;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements l {
    final /* synthetic */ m pt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.pt = mVar;
    }

    @Override // com.baidu.adp.lib.webSocket.l
    public void j(String str) {
        ArrayList arrayList;
        arrayList = this.pt.pr;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((l) it.next()).j(str);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.l
    public void s(byte[] bArr) {
        ArrayList arrayList;
        arrayList = this.pt.pr;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((l) it.next()).s(bArr);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.l
    public void h(byte[] bArr) {
        ArrayList arrayList;
        arrayList = this.pt.pr;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((l) it.next()).h(bArr);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.l
    public void c(Map<String, String> map) {
        ArrayList arrayList;
        arrayList = this.pt.pr;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((l) it.next()).c(map);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.l
    public void b(int i, String str) {
        ArrayList arrayList;
        this.pt.pq = null;
        arrayList = this.pt.pr;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((l) it.next()).b(i, str);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.l
    public void a(d dVar) {
        ArrayList arrayList;
        arrayList = this.pt.pr;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((l) it.next()).a(dVar);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.l
    public void fS() {
        ArrayList arrayList;
        arrayList = this.pt.pr;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((l) it.next()).fS();
        }
    }

    @Override // com.baidu.adp.lib.webSocket.l
    public void b(d dVar) {
        if (dVar != null) {
            dVar.ag();
        }
    }

    @Override // com.baidu.adp.lib.webSocket.l
    public void a(int i, d dVar) {
        if (dVar != null) {
            dVar.i(i);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.l
    public void c(d dVar) {
        if (dVar != null) {
            dVar.ah();
        }
    }
}

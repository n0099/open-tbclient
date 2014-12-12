package com.baidu.adp.lib.webSocket;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements l {
    final /* synthetic */ m pr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.pr = mVar;
    }

    @Override // com.baidu.adp.lib.webSocket.l
    public void y(String str) {
        ArrayList arrayList;
        arrayList = this.pr.pp;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((l) it.next()).y(str);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.l
    public void r(byte[] bArr) {
        ArrayList arrayList;
        arrayList = this.pr.pp;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((l) it.next()).r(bArr);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.l
    public void i(byte[] bArr) {
        ArrayList arrayList;
        arrayList = this.pr.pp;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((l) it.next()).i(bArr);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.l
    public void d(Map<String, String> map) {
        ArrayList arrayList;
        arrayList = this.pr.pp;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((l) it.next()).d(map);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.l
    public void l(int i, String str) {
        ArrayList arrayList;
        this.pr.po = null;
        arrayList = this.pr.pp;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((l) it.next()).l(i, str);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.l
    public void a(d dVar) {
        ArrayList arrayList;
        arrayList = this.pr.pp;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((l) it.next()).a(dVar);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.l
    public void fU() {
        ArrayList arrayList;
        arrayList = this.pr.pp;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((l) it.next()).fU();
        }
    }

    @Override // com.baidu.adp.lib.webSocket.l
    public void b(d dVar) {
        if (dVar != null) {
            dVar.aG();
        }
    }

    @Override // com.baidu.adp.lib.webSocket.l
    public void a(int i, d dVar) {
        if (dVar != null) {
            dVar.u(i);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.l
    public void c(d dVar) {
        if (dVar != null) {
            dVar.aH();
        }
    }
}

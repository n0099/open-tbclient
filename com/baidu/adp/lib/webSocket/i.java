package com.baidu.adp.lib.webSocket;

import com.baidu.adp.lib.webSocket.g;
import com.baidu.adp.lib.webSocket.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements g.a {
    final /* synthetic */ h qA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.qA = hVar;
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void y(String str) {
        ArrayList arrayList;
        arrayList = this.qA.qy;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((g.a) it.next()).y(str);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void o(byte[] bArr) {
        ArrayList arrayList;
        arrayList = this.qA.qy;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((g.a) it.next()).o(bArr);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void b(m.a aVar) {
        ArrayList arrayList;
        arrayList = this.qA.qy;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((g.a) it.next()).b(aVar);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void e(Map<String, String> map) {
        ArrayList arrayList;
        arrayList = this.qA.qy;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((g.a) it.next()).e(map);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void e(int i, String str) {
        ArrayList arrayList;
        this.qA.qx = null;
        arrayList = this.qA.qy;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((g.a) it.next()).e(i, str);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void a(c cVar) {
        ArrayList arrayList;
        arrayList = this.qA.qy;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((g.a) it.next()).a(cVar);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void gf() {
        ArrayList arrayList;
        arrayList = this.qA.qy;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((g.a) it.next()).gf();
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void b(c cVar) {
        if (cVar != null) {
            cVar.aA();
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void a(int i, c cVar) {
        if (cVar != null) {
            cVar.x(i);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void c(c cVar) {
        if (cVar != null) {
            cVar.aB();
        }
    }
}

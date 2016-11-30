package com.baidu.adp.lib.webSocket;

import com.baidu.adp.lib.webSocket.g;
import com.baidu.adp.lib.webSocket.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements g.a {
    final /* synthetic */ h tw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.tw = hVar;
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void B(String str) {
        ArrayList arrayList;
        arrayList = this.tw.tu;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((g.a) it.next()).B(str);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void r(byte[] bArr) {
        ArrayList arrayList;
        arrayList = this.tw.tu;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((g.a) it.next()).r(bArr);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void b(m.a aVar) {
        ArrayList arrayList;
        arrayList = this.tw.tu;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((g.a) it.next()).b(aVar);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void e(Map<String, String> map) {
        ArrayList arrayList;
        arrayList = this.tw.tu;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((g.a) it.next()).e(map);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void d(int i, String str) {
        ArrayList arrayList;
        this.tw.tt = null;
        arrayList = this.tw.tu;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((g.a) it.next()).d(i, str);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void a(c cVar) {
        ArrayList arrayList;
        arrayList = this.tw.tu;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((g.a) it.next()).a(cVar);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void gZ() {
        ArrayList arrayList;
        arrayList = this.tw.tu;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((g.a) it.next()).gZ();
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void b(c cVar) {
        if (cVar != null) {
            cVar.bv();
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void a(int i, c cVar) {
        if (cVar != null) {
            cVar.N(i);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void c(c cVar) {
        if (cVar != null) {
            cVar.bw();
        }
    }
}

package com.baidu.adp.lib.webSocket;

import com.baidu.adp.lib.webSocket.g;
import com.baidu.adp.lib.webSocket.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements g.a {
    final /* synthetic */ h Ao;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.Ao = hVar;
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void H(String str) {
        ArrayList arrayList;
        arrayList = this.Ao.Am;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((g.a) it.next()).H(str);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void p(byte[] bArr) {
        ArrayList arrayList;
        arrayList = this.Ao.Am;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((g.a) it.next()).p(bArr);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void b(m.a aVar) {
        ArrayList arrayList;
        arrayList = this.Ao.Am;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((g.a) it.next()).b(aVar);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void d(Map<String, String> map) {
        ArrayList arrayList;
        arrayList = this.Ao.Am;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((g.a) it.next()).d(map);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void e(int i, String str) {
        ArrayList arrayList;
        this.Ao.Al = null;
        arrayList = this.Ao.Am;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((g.a) it.next()).e(i, str);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void a(c cVar) {
        ArrayList arrayList;
        arrayList = this.Ao.Am;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((g.a) it.next()).a(cVar);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void jQ() {
        ArrayList arrayList;
        arrayList = this.Ao.Am;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((g.a) it.next()).jQ();
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void b(c cVar) {
        if (cVar != null) {
            cVar.ek();
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void a(int i, c cVar) {
        if (cVar != null) {
            cVar.I(i);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void c(c cVar) {
        if (cVar != null) {
            cVar.el();
        }
    }
}

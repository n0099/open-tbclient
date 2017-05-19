package com.baidu.adp.lib.webSocket;

import com.baidu.adp.lib.webSocket.g;
import com.baidu.adp.lib.webSocket.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements g.a {
    final /* synthetic */ h Ag;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.Ag = hVar;
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void x(String str) {
        ArrayList arrayList;
        arrayList = this.Ag.Ae;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((g.a) it.next()).x(str);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void r(byte[] bArr) {
        ArrayList arrayList;
        arrayList = this.Ag.Ae;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((g.a) it.next()).r(bArr);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void b(m.a aVar) {
        ArrayList arrayList;
        arrayList = this.Ag.Ae;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((g.a) it.next()).b(aVar);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void e(Map<String, String> map) {
        ArrayList arrayList;
        arrayList = this.Ag.Ae;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((g.a) it.next()).e(map);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void e(int i, String str) {
        ArrayList arrayList;
        this.Ag.Ac = null;
        arrayList = this.Ag.Ae;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((g.a) it.next()).e(i, str);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void a(c cVar) {
        ArrayList arrayList;
        arrayList = this.Ag.Ae;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((g.a) it.next()).a(cVar);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void hW() {
        ArrayList arrayList;
        arrayList = this.Ag.Ae;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((g.a) it.next()).hW();
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void b(c cVar) {
        if (cVar != null) {
            cVar.cD();
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void a(int i, c cVar) {
        if (cVar != null) {
            cVar.M(i);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void c(c cVar) {
        if (cVar != null) {
            cVar.cE();
        }
    }
}

package com.baidu.adp.lib.webSocket;

import com.baidu.adp.lib.webSocket.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements g.a {
    final /* synthetic */ h zV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.zV = hVar;
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void H(String str) {
        ArrayList arrayList;
        arrayList = this.zV.zT;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((g.a) it.next()).H(str);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void F(byte[] bArr) {
        ArrayList arrayList;
        arrayList = this.zV.zT;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((g.a) it.next()).F(bArr);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void w(byte[] bArr) {
        ArrayList arrayList;
        arrayList = this.zV.zT;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((g.a) it.next()).w(bArr);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void d(Map<String, String> map) {
        ArrayList arrayList;
        arrayList = this.zV.zT;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((g.a) it.next()).d(map);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void l(int i, String str) {
        ArrayList arrayList;
        this.zV.zS = null;
        arrayList = this.zV.zT;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((g.a) it.next()).l(i, str);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void a(c cVar) {
        ArrayList arrayList;
        arrayList = this.zV.zT;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((g.a) it.next()).a(cVar);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void jK() {
        ArrayList arrayList;
        arrayList = this.zV.zT;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((g.a) it.next()).jK();
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
            cVar.J(i);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void c(c cVar) {
        if (cVar != null) {
            cVar.el();
        }
    }
}

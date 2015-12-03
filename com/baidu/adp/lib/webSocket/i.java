package com.baidu.adp.lib.webSocket;

import com.baidu.adp.lib.webSocket.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements g.a {
    final /* synthetic */ h zL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.zL = hVar;
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void I(String str) {
        ArrayList arrayList;
        arrayList = this.zL.zJ;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((g.a) it.next()).I(str);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void F(byte[] bArr) {
        ArrayList arrayList;
        arrayList = this.zL.zJ;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((g.a) it.next()).F(bArr);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void w(byte[] bArr) {
        ArrayList arrayList;
        arrayList = this.zL.zJ;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((g.a) it.next()).w(bArr);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void c(Map<String, String> map) {
        ArrayList arrayList;
        arrayList = this.zL.zJ;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((g.a) it.next()).c(map);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void l(int i, String str) {
        ArrayList arrayList;
        this.zL.zI = null;
        arrayList = this.zL.zJ;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((g.a) it.next()).l(i, str);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void a(c cVar) {
        ArrayList arrayList;
        arrayList = this.zL.zJ;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((g.a) it.next()).a(cVar);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void jA() {
        ArrayList arrayList;
        arrayList = this.zL.zJ;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((g.a) it.next()).jA();
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void b(c cVar) {
        if (cVar != null) {
            cVar.eg();
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void a(int i, c cVar) {
        if (cVar != null) {
            cVar.z(i);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void c(c cVar) {
        if (cVar != null) {
            cVar.eh();
        }
    }
}

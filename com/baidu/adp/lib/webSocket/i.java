package com.baidu.adp.lib.webSocket;

import com.baidu.adp.lib.webSocket.g;
import com.baidu.adp.lib.webSocket.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements g.a {
    final /* synthetic */ h tl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.tl = hVar;
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void B(String str) {
        ArrayList arrayList;
        arrayList = this.tl.tj;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((g.a) it.next()).B(str);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void r(byte[] bArr) {
        ArrayList arrayList;
        arrayList = this.tl.tj;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((g.a) it.next()).r(bArr);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void b(m.a aVar) {
        ArrayList arrayList;
        arrayList = this.tl.tj;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((g.a) it.next()).b(aVar);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void e(Map<String, String> map) {
        ArrayList arrayList;
        arrayList = this.tl.tj;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((g.a) it.next()).e(map);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void d(int i, String str) {
        ArrayList arrayList;
        this.tl.ti = null;
        arrayList = this.tl.tj;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((g.a) it.next()).d(i, str);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void a(c cVar) {
        ArrayList arrayList;
        arrayList = this.tl.tj;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((g.a) it.next()).a(cVar);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void gX() {
        ArrayList arrayList;
        arrayList = this.tl.tj;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((g.a) it.next()).gX();
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
            cVar.O(i);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void c(c cVar) {
        if (cVar != null) {
            cVar.bw();
        }
    }
}

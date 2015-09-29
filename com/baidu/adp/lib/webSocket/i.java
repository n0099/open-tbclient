package com.baidu.adp.lib.webSocket;

import com.baidu.adp.lib.webSocket.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements g.a {
    final /* synthetic */ h zF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.zF = hVar;
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void I(String str) {
        ArrayList arrayList;
        arrayList = this.zF.zD;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((g.a) it.next()).I(str);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void F(byte[] bArr) {
        ArrayList arrayList;
        arrayList = this.zF.zD;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((g.a) it.next()).F(bArr);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void w(byte[] bArr) {
        ArrayList arrayList;
        arrayList = this.zF.zD;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((g.a) it.next()).w(bArr);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void d(Map<String, String> map) {
        ArrayList arrayList;
        arrayList = this.zF.zD;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((g.a) it.next()).d(map);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void l(int i, String str) {
        ArrayList arrayList;
        this.zF.zC = null;
        arrayList = this.zF.zD;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((g.a) it.next()).l(i, str);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void a(c cVar) {
        ArrayList arrayList;
        arrayList = this.zF.zD;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((g.a) it.next()).a(cVar);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void jy() {
        ArrayList arrayList;
        arrayList = this.zF.zD;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((g.a) it.next()).jy();
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
            cVar.y(i);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void c(c cVar) {
        if (cVar != null) {
            cVar.eh();
        }
    }
}

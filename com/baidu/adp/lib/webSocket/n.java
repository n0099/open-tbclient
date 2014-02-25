package com.baidu.adp.lib.webSocket;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements l {
    final /* synthetic */ m a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.a = mVar;
    }

    @Override // com.baidu.adp.lib.webSocket.l
    public void a(String str) {
        ArrayList arrayList;
        arrayList = this.a.g;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((l) it.next()).a(str);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.l
    public void b(byte[] bArr) {
        ArrayList arrayList;
        arrayList = this.a.g;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((l) it.next()).b(bArr);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.l
    public void a(byte[] bArr) {
        ArrayList arrayList;
        arrayList = this.a.g;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((l) it.next()).a(bArr);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.l
    public void a(Map<String, String> map) {
        ArrayList arrayList;
        arrayList = this.a.g;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((l) it.next()).a(map);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.l
    public void a(int i, String str) {
        ArrayList arrayList;
        this.a.f = null;
        arrayList = this.a.g;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((l) it.next()).a(i, str);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.l
    public void a(d dVar) {
        ArrayList arrayList;
        arrayList = this.a.g;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((l) it.next()).a(dVar);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.l
    public void a() {
        ArrayList arrayList;
        arrayList = this.a.g;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((l) it.next()).a();
        }
    }

    @Override // com.baidu.adp.lib.webSocket.l
    public void b(d dVar) {
        if (dVar != null) {
            dVar.c();
        }
    }

    @Override // com.baidu.adp.lib.webSocket.l
    public void a(int i, d dVar) {
        if (dVar != null) {
            dVar.a(i);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.l
    public void c(d dVar) {
        if (dVar != null) {
            dVar.d();
        }
    }
}

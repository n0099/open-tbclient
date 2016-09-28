package com.baidu.adp.lib.webSocket;

import com.baidu.adp.lib.webSocket.g;
import com.baidu.adp.lib.webSocket.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements g.a {

    /* renamed from: tv  reason: collision with root package name */
    final /* synthetic */ h f1tv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.f1tv = hVar;
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void B(String str) {
        ArrayList arrayList;
        arrayList = this.f1tv.tt;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((g.a) it.next()).B(str);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void r(byte[] bArr) {
        ArrayList arrayList;
        arrayList = this.f1tv.tt;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((g.a) it.next()).r(bArr);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void b(m.a aVar) {
        ArrayList arrayList;
        arrayList = this.f1tv.tt;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((g.a) it.next()).b(aVar);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void e(Map<String, String> map) {
        ArrayList arrayList;
        arrayList = this.f1tv.tt;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((g.a) it.next()).e(map);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void e(int i, String str) {
        ArrayList arrayList;
        this.f1tv.ts = null;
        arrayList = this.f1tv.tt;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((g.a) it.next()).e(i, str);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void a(c cVar) {
        ArrayList arrayList;
        arrayList = this.f1tv.tt;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((g.a) it.next()).a(cVar);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void gZ() {
        ArrayList arrayList;
        arrayList = this.f1tv.tt;
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

package com.baidu.ar.npc;

import com.baidu.ar.npc.BaiduArView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BaiduArView.b f1565a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ BaiduArView f1566b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(BaiduArView baiduArView, BaiduArView.b bVar) {
        this.f1566b = baiduArView;
        this.f1565a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        BaiduArView.g gVar;
        gVar = this.f1566b.v;
        gVar.a(this.f1565a);
    }
}

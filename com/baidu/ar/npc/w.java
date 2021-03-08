package com.baidu.ar.npc;

import com.baidu.ar.npc.BaiduArView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BaiduArView.b f1304a;
    final /* synthetic */ BaiduArView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(BaiduArView baiduArView, BaiduArView.b bVar) {
        this.b = baiduArView;
        this.f1304a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        BaiduArView.g gVar;
        gVar = this.b.v;
        gVar.a(this.f1304a);
    }
}

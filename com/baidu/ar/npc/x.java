package com.baidu.ar.npc;

import com.baidu.ar.npc.BaiduArView;
/* loaded from: classes26.dex */
class x implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BaiduArView f1238a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(BaiduArView baiduArView) {
        this.f1238a = baiduArView;
    }

    @Override // java.lang.Runnable
    public void run() {
        BaiduArView.g gVar;
        gVar = this.f1238a.v;
        gVar.a((BaiduArView.b) null);
    }
}

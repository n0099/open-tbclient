package com.baidu.ar.npc;

import com.baidu.ar.npc.BaiduArView;
/* loaded from: classes7.dex */
class x implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BaiduArView f1235a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(BaiduArView baiduArView) {
        this.f1235a = baiduArView;
    }

    @Override // java.lang.Runnable
    public void run() {
        BaiduArView.g gVar;
        gVar = this.f1235a.v;
        gVar.a((BaiduArView.b) null);
    }
}

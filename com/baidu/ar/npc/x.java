package com.baidu.ar.npc;

import com.baidu.ar.npc.BaiduArView;
/* loaded from: classes10.dex */
class x implements Runnable {
    final /* synthetic */ BaiduArView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(BaiduArView baiduArView) {
        this.a = baiduArView;
    }

    @Override // java.lang.Runnable
    public void run() {
        BaiduArView.g gVar;
        gVar = this.a.v;
        gVar.a((BaiduArView.b) null);
    }
}

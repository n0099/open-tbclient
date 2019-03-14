package com.baidu.ar.npc;

import com.baidu.ar.npc.BaiduArView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class w implements Runnable {
    final /* synthetic */ BaiduArView.b a;
    final /* synthetic */ BaiduArView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(BaiduArView baiduArView, BaiduArView.b bVar) {
        this.b = baiduArView;
        this.a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        BaiduArView.g gVar;
        gVar = this.b.v;
        gVar.a(this.a);
    }
}

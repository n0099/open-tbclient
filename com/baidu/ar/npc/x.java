package com.baidu.ar.npc;

import com.baidu.ar.npc.BaiduArView;
/* loaded from: classes.dex */
public class x implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BaiduArView f4260a;

    public x(BaiduArView baiduArView) {
        this.f4260a = baiduArView;
    }

    @Override // java.lang.Runnable
    public void run() {
        BaiduArView.g gVar;
        gVar = this.f4260a.v;
        gVar.a((BaiduArView.b) null);
    }
}

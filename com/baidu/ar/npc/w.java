package com.baidu.ar.npc;

import com.baidu.ar.npc.BaiduArView;
/* loaded from: classes2.dex */
public class w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BaiduArView.b f4222a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BaiduArView f4223b;

    public w(BaiduArView baiduArView, BaiduArView.b bVar) {
        this.f4223b = baiduArView;
        this.f4222a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        BaiduArView.g gVar;
        gVar = this.f4223b.v;
        gVar.a(this.f4222a);
    }
}

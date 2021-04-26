package com.baidu.ar.npc;

import com.baidu.ar.npc.BaiduArView;
/* loaded from: classes.dex */
public class w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BaiduArView.b f4328a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BaiduArView f4329b;

    public w(BaiduArView baiduArView, BaiduArView.b bVar) {
        this.f4329b = baiduArView;
        this.f4328a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        BaiduArView.g gVar;
        gVar = this.f4329b.v;
        gVar.a(this.f4328a);
    }
}

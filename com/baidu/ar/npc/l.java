package com.baidu.ar.npc;

import android.graphics.Bitmap;
import android.os.Handler;
import com.baidu.ar.npc.ArBridge;
import com.baidu.ar.npc.BaiduArView;
/* loaded from: classes2.dex */
public class l implements BaiduArView.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ArBridge.c f4186a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ArBridge f4187b;

    public l(ArBridge arBridge, ArBridge.c cVar) {
        this.f4187b = arBridge;
        this.f4186a = cVar;
    }

    @Override // com.baidu.ar.npc.BaiduArView.a
    public void a(Bitmap bitmap) {
        Handler handler;
        handler = this.f4187b.f4080d;
        handler.post(new m(this, bitmap));
    }
}

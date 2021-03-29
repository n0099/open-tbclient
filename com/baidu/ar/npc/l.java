package com.baidu.ar.npc;

import android.graphics.Bitmap;
import android.os.Handler;
import com.baidu.ar.npc.ArBridge;
import com.baidu.ar.npc.BaiduArView;
/* loaded from: classes.dex */
public class l implements BaiduArView.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ArBridge.c f4187a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ArBridge f4188b;

    public l(ArBridge arBridge, ArBridge.c cVar) {
        this.f4188b = arBridge;
        this.f4187a = cVar;
    }

    @Override // com.baidu.ar.npc.BaiduArView.a
    public void a(Bitmap bitmap) {
        Handler handler;
        handler = this.f4188b.f4081d;
        handler.post(new m(this, bitmap));
    }
}

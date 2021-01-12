package com.baidu.ar.npc;

import android.graphics.Bitmap;
import android.os.Handler;
import com.baidu.ar.npc.ArBridge;
import com.baidu.ar.npc.BaiduArView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class l implements BaiduArView.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ArBridge.c f1544a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ArBridge f1545b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(ArBridge arBridge, ArBridge.c cVar) {
        this.f1545b = arBridge;
        this.f1544a = cVar;
    }

    @Override // com.baidu.ar.npc.BaiduArView.a
    public void a(Bitmap bitmap) {
        Handler handler;
        handler = this.f1545b.d;
        handler.post(new m(this, bitmap));
    }
}

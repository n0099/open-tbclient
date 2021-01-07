package com.baidu.platform.comapi.walknavi.g.c;

import android.graphics.BitmapFactory;
import android.widget.ImageView;
import com.baidu.mapapi.walknavi.adapter.IWNPCLoadAndInitListener;
import com.baidu.mapapi.walknavi.model.BaseNpcModel;
import com.baidu.platform.comapi.walknavi.g.c.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class ac implements c.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BaseNpcModel f4512a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ c f4513b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(c cVar, BaseNpcModel baseNpcModel) {
        this.f4513b = cVar;
        this.f4512a = baseNpcModel;
    }

    @Override // com.baidu.platform.comapi.walknavi.g.c.c.d
    public void a() {
        IWNPCLoadAndInitListener iWNPCLoadAndInitListener;
        ImageView imageView;
        IWNPCLoadAndInitListener iWNPCLoadAndInitListener2;
        iWNPCLoadAndInitListener = this.f4513b.Y;
        if (iWNPCLoadAndInitListener != null) {
            iWNPCLoadAndInitListener2 = this.f4513b.Y;
            iWNPCLoadAndInitListener2.onSuccess();
        }
        imageView = this.f4513b.O;
        imageView.setImageBitmap(this.f4512a.getIcon());
    }

    @Override // com.baidu.platform.comapi.walknavi.g.c.c.d
    public void b() {
        IWNPCLoadAndInitListener iWNPCLoadAndInitListener;
        ImageView imageView;
        IWNPCLoadAndInitListener iWNPCLoadAndInitListener2;
        iWNPCLoadAndInitListener = this.f4513b.Y;
        if (iWNPCLoadAndInitListener != null) {
            com.baidu.platform.comapi.walknavi.d.e.c().a("");
            this.f4513b.b(true);
            com.baidu.platform.comapi.walknavi.b.a().G().a(0, 0);
            this.f4513b.s();
            iWNPCLoadAndInitListener2 = this.f4513b.Y;
            iWNPCLoadAndInitListener2.onFail();
        }
        imageView = this.f4513b.O;
        imageView.setImageBitmap(BitmapFactory.decodeResource(com.baidu.platform.comapi.wnplatform.p.a.a.b(), 2130837868));
    }
}

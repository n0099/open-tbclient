package com.baidu.platform.comapi.walknavi.g.b;

import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.ImageView;
import com.baidu.mapapi.walknavi.adapter.IWNPCLoadAndInitListener;
import com.baidu.mapapi.walknavi.model.BaseNpcModel;
import com.baidu.platform.comapi.walknavi.g.b.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class ac implements c.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BaseNpcModel f4290a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ c f4291b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(c cVar, BaseNpcModel baseNpcModel) {
        this.f4291b = cVar;
        this.f4290a = baseNpcModel;
    }

    @Override // com.baidu.platform.comapi.walknavi.g.b.c.d
    public void a() {
        IWNPCLoadAndInitListener iWNPCLoadAndInitListener;
        View view;
        IWNPCLoadAndInitListener iWNPCLoadAndInitListener2;
        iWNPCLoadAndInitListener = this.f4291b.W;
        if (iWNPCLoadAndInitListener != null) {
            iWNPCLoadAndInitListener2 = this.f4291b.W;
            iWNPCLoadAndInitListener2.onSuccess();
        }
        view = this.f4291b.N;
        ((ImageView) view).setImageBitmap(this.f4290a.getIcon());
    }

    @Override // com.baidu.platform.comapi.walknavi.g.b.c.d
    public void b() {
        IWNPCLoadAndInitListener iWNPCLoadAndInitListener;
        View view;
        IWNPCLoadAndInitListener iWNPCLoadAndInitListener2;
        iWNPCLoadAndInitListener = this.f4291b.W;
        if (iWNPCLoadAndInitListener != null) {
            com.baidu.platform.comapi.walknavi.d.e.c().a("");
            this.f4291b.b(true);
            com.baidu.platform.comapi.walknavi.b.a().D().a(0, 0);
            this.f4291b.o();
            iWNPCLoadAndInitListener2 = this.f4291b.W;
            iWNPCLoadAndInitListener2.onFail();
        }
        view = this.f4291b.N;
        ((ImageView) view).setImageBitmap(BitmapFactory.decodeResource(com.baidu.platform.comapi.wnplatform.o.a.a.b(), 2130837800));
    }
}

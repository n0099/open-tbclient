package com.baidu.platform.comapi.walknavi.g.b;

import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.ImageView;
import com.baidu.mapapi.walknavi.adapter.IWNPCLoadAndInitListener;
import com.baidu.mapapi.walknavi.model.BaseNpcModel;
import com.baidu.platform.comapi.walknavi.g.b.c;
/* loaded from: classes2.dex */
public class ac implements c.d {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BaseNpcModel f10077a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ c f10078b;

    public ac(c cVar, BaseNpcModel baseNpcModel) {
        this.f10078b = cVar;
        this.f10077a = baseNpcModel;
    }

    @Override // com.baidu.platform.comapi.walknavi.g.b.c.d
    public void a() {
        IWNPCLoadAndInitListener iWNPCLoadAndInitListener;
        View view;
        IWNPCLoadAndInitListener iWNPCLoadAndInitListener2;
        iWNPCLoadAndInitListener = this.f10078b.W;
        if (iWNPCLoadAndInitListener != null) {
            iWNPCLoadAndInitListener2 = this.f10078b.W;
            iWNPCLoadAndInitListener2.onSuccess();
        }
        view = this.f10078b.N;
        ((ImageView) view).setImageBitmap(this.f10077a.getIcon());
    }

    @Override // com.baidu.platform.comapi.walknavi.g.b.c.d
    public void b() {
        IWNPCLoadAndInitListener iWNPCLoadAndInitListener;
        View view;
        IWNPCLoadAndInitListener iWNPCLoadAndInitListener2;
        iWNPCLoadAndInitListener = this.f10078b.W;
        if (iWNPCLoadAndInitListener != null) {
            com.baidu.platform.comapi.walknavi.d.e.c().a("");
            this.f10078b.b(true);
            com.baidu.platform.comapi.walknavi.b.a().D().a(0, 0);
            this.f10078b.o();
            iWNPCLoadAndInitListener2 = this.f10078b.W;
            iWNPCLoadAndInitListener2.onFail();
        }
        view = this.f10078b.N;
        ((ImageView) view).setImageBitmap(BitmapFactory.decodeResource(com.baidu.platform.comapi.wnplatform.o.a.a.b(), 2130837800));
    }
}

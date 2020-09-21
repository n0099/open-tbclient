package com.baidu.platform.comapi.walknavi.g.c;

import android.graphics.BitmapFactory;
import android.widget.ImageView;
import com.baidu.mapapi.walknavi.adapter.IWNPCLoadAndInitListener;
import com.baidu.mapapi.walknavi.model.BaseNpcModel;
import com.baidu.platform.comapi.walknavi.g.c.c;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class ac implements c.d {
    final /* synthetic */ BaseNpcModel a;
    final /* synthetic */ c b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(c cVar, BaseNpcModel baseNpcModel) {
        this.b = cVar;
        this.a = baseNpcModel;
    }

    @Override // com.baidu.platform.comapi.walknavi.g.c.c.d
    public void a() {
        IWNPCLoadAndInitListener iWNPCLoadAndInitListener;
        ImageView imageView;
        IWNPCLoadAndInitListener iWNPCLoadAndInitListener2;
        iWNPCLoadAndInitListener = this.b.Y;
        if (iWNPCLoadAndInitListener != null) {
            iWNPCLoadAndInitListener2 = this.b.Y;
            iWNPCLoadAndInitListener2.onSuccess();
        }
        imageView = this.b.O;
        imageView.setImageBitmap(this.a.getIcon());
    }

    @Override // com.baidu.platform.comapi.walknavi.g.c.c.d
    public void b() {
        IWNPCLoadAndInitListener iWNPCLoadAndInitListener;
        ImageView imageView;
        IWNPCLoadAndInitListener iWNPCLoadAndInitListener2;
        iWNPCLoadAndInitListener = this.b.Y;
        if (iWNPCLoadAndInitListener != null) {
            com.baidu.platform.comapi.walknavi.d.e.c().a("");
            this.b.b(true);
            com.baidu.platform.comapi.walknavi.b.a().G().a(0, 0);
            this.b.s();
            iWNPCLoadAndInitListener2 = this.b.Y;
            iWNPCLoadAndInitListener2.onFail();
        }
        imageView = this.b.O;
        imageView.setImageBitmap(BitmapFactory.decodeResource(com.baidu.platform.comapi.wnplatform.p.a.a.b(), R.drawable.aiapps_subscribe_msg_unselected));
    }
}

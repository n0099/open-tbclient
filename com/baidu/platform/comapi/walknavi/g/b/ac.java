package com.baidu.platform.comapi.walknavi.g.b;

import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.ImageView;
import com.baidu.mapapi.walknavi.adapter.IWNPCLoadAndInitListener;
import com.baidu.mapapi.walknavi.model.BaseNpcModel;
import com.baidu.platform.comapi.walknavi.g.b.c;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class ac implements c.d {
    final /* synthetic */ BaseNpcModel a;
    final /* synthetic */ c b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(c cVar, BaseNpcModel baseNpcModel) {
        this.b = cVar;
        this.a = baseNpcModel;
    }

    @Override // com.baidu.platform.comapi.walknavi.g.b.c.d
    public void a() {
        IWNPCLoadAndInitListener iWNPCLoadAndInitListener;
        View view;
        IWNPCLoadAndInitListener iWNPCLoadAndInitListener2;
        iWNPCLoadAndInitListener = this.b.W;
        if (iWNPCLoadAndInitListener != null) {
            iWNPCLoadAndInitListener2 = this.b.W;
            iWNPCLoadAndInitListener2.onSuccess();
        }
        view = this.b.N;
        ((ImageView) view).setImageBitmap(this.a.getIcon());
    }

    @Override // com.baidu.platform.comapi.walknavi.g.b.c.d
    public void b() {
        IWNPCLoadAndInitListener iWNPCLoadAndInitListener;
        View view;
        IWNPCLoadAndInitListener iWNPCLoadAndInitListener2;
        iWNPCLoadAndInitListener = this.b.W;
        if (iWNPCLoadAndInitListener != null) {
            com.baidu.platform.comapi.walknavi.d.e.c().a("");
            this.b.b(true);
            com.baidu.platform.comapi.walknavi.b.a().D().a(0, 0);
            this.b.o();
            iWNPCLoadAndInitListener2 = this.b.W;
            iWNPCLoadAndInitListener2.onFail();
        }
        view = this.b.N;
        ((ImageView) view).setImageBitmap(BitmapFactory.decodeResource(com.baidu.platform.comapi.wnplatform.o.a.a.b(), R.drawable.aiapps_game_keyboard_sendbutton_disabled));
    }
}

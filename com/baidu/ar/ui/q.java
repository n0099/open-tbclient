package com.baidu.ar.ui;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.ar.bean.ARResource;
import com.baidu.ar.util.Res;
/* loaded from: classes3.dex */
public class q extends c {
    private View x;

    public q(ViewGroup viewGroup, com.baidu.ar.b bVar, ARResource aRResource) {
        super(viewGroup, bVar, aRResource);
        y();
    }

    private void y() {
        this.x = Res.inflate("bdar_layout_gui_track");
        this.a.addView(this.x);
        this.o.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.ar.ui.c
    public void i() {
        super.i();
    }

    @Override // com.baidu.ar.ui.c
    public void n() {
        super.n();
        this.a.removeView(this.x);
    }
}

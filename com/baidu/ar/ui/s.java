package com.baidu.ar.ui;

import android.view.ViewGroup;
import com.baidu.ar.bean.ARResource;
import com.baidu.ar.track.TrackStateMachine;
import com.baidu.ar.util.Res;
import com.baidu.ar.util.ViewUtils;
/* loaded from: classes3.dex */
public class s extends c {
    private ViewGroup x;

    public s(ViewGroup viewGroup, com.baidu.ar.b bVar, ARResource aRResource) {
        super(viewGroup, bVar, aRResource);
        y();
        this.w.a(true);
    }

    private void y() {
        this.x = (ViewGroup) Res.inflate("bdar_layout_gui_track");
        this.p.a(this.x);
        this.a.addView(this.x);
        this.o.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.ar.ui.c
    public void i() {
        super.i();
        q();
        if (TrackStateMachine.getInstance().getTrackState() == TrackStateMachine.STATE.TRACKED) {
            ViewUtils.setViewVisibility(this.p.a(), 8);
        } else {
            a(this.g);
        }
        r();
        o();
        ViewUtils.setViewVisibility(this.p.c(), 8);
    }

    @Override // com.baidu.ar.ui.c
    public void n() {
        super.n();
        if (this.x != null) {
            this.a.removeView(this.x);
        }
    }
}

package com.baidu.ar.ui;

import com.baidu.ar.rotate.OrientationManager;
import com.baidu.ar.ui.rotateview.RotateImageView;
import com.baidu.ar.ui.rotateview.RotateViewUtils;
import com.baidu.ar.util.SystemInfoUtil;
import com.baidu.ar.util.ViewUtils;
/* loaded from: classes3.dex */
public class h {
    private RotateImageView a;
    private boolean b = true;
    private boolean c = false;
    private boolean d;

    public h(c cVar) {
        this.d = true;
        this.a = cVar.u().h().getHostUI().getIconFlash();
        this.d = cVar.u().h().getHostUI().isBackCamera();
    }

    private void b() {
        if (this.d && this.b && !this.c && SystemInfoUtil.checkFlashFeature(this.a.getContext().getApplicationContext())) {
            ViewUtils.setViewVisibility(this.a, 0);
            RotateViewUtils.requestOrientation(this.a, OrientationManager.getGlobalOrientation());
        }
    }

    private void c() {
        ViewUtils.setViewVisibility(this.a, 4);
    }

    public RotateImageView a() {
        return this.a;
    }

    public void a(boolean z) {
        this.b = z;
        if (this.b) {
            b();
        } else {
            c();
        }
    }

    public void b(boolean z) {
        this.c = z;
        if (this.c) {
            c();
        } else {
            b();
        }
    }

    public void c(boolean z) {
        this.d = z;
        if (this.d) {
            b();
        } else {
            c();
        }
    }
}

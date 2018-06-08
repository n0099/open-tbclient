package com.baidu.ar.ui;

import com.baidu.ar.ui.rotateview.RotateImageView;
import com.baidu.ar.util.ViewUtils;
/* loaded from: classes3.dex */
public class b {
    private RotateImageView a;
    private boolean b = true;
    private boolean c = false;

    public b(c cVar) {
        this.a = cVar.u().h().getHostUI().getIconBack();
    }

    private void b() {
        if (!this.b || this.c) {
            return;
        }
        ViewUtils.setViewVisibility(this.a, 0);
    }

    public RotateImageView a() {
        return this.a;
    }

    public void a(boolean z) {
        this.b = z;
        if (this.b) {
            b();
        } else {
            ViewUtils.setViewVisibility(this.a, 4);
        }
    }

    public void b(boolean z) {
        this.c = z;
        if (this.c) {
            ViewUtils.setViewVisibility(this.a, 4);
        } else {
            b();
        }
    }
}

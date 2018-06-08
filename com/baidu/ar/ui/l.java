package com.baidu.ar.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.ar.rotate.Orientation;
import com.baidu.ar.ui.rotateview.RotateImageView;
import com.baidu.ar.ui.rotateview.RotateViewGroup;
import com.baidu.ar.ui.rotateview.RotateViewUtils;
import com.baidu.ar.util.Res;
/* loaded from: classes3.dex */
public class l {
    protected RotateViewGroup a;
    protected TextView b;
    protected RotateViewGroup c;
    protected TextView d;
    protected ScanView e;
    protected FrameLayout.LayoutParams f;
    protected int g;
    private View h;
    private RotateImageView i;

    private void h() {
        if (this.a != null) {
            this.f = (FrameLayout.LayoutParams) this.a.getLayoutParams();
            this.f.gravity = 16;
            this.f.leftMargin = Res.getDimensionPixelSize("bdar_icon_margin_edge");
            this.f.bottomMargin = 0;
        }
    }

    private void i() {
        if (this.a != null) {
            this.f = (FrameLayout.LayoutParams) this.a.getLayoutParams();
            this.f.gravity = 21;
            this.f.rightMargin = Res.getDimensionPixelSize("bdar_icon_margin_edge");
            this.f.bottomMargin = 0;
        }
    }

    private void j() {
        if (this.a != null) {
            this.f = (FrameLayout.LayoutParams) this.a.getLayoutParams();
            this.f.gravity = 81;
            this.f.bottomMargin = this.g;
            this.f.leftMargin = 0;
            this.f.rightMargin = 0;
        }
    }

    public RotateViewGroup a() {
        return this.a;
    }

    public void a(View view) {
        this.h = view;
        this.e = (ScanView) view.findViewById(Res.id("bdar_gui_scan_view"));
        this.a = (RotateViewGroup) view.findViewById(Res.id("bdar_gui_tips_group"));
        this.b = (TextView) view.findViewById(Res.id("bdar_gui_tips_text"));
        this.c = (RotateViewGroup) view.findViewById(Res.id("bdar_gui_exception_tips_group"));
        this.d = (TextView) view.findViewById(Res.id("bdar_gui_excteption_tips_text"));
        this.i = (RotateImageView) view.findViewById(Res.id("bdar_gui_image_trigger_picture"));
        this.g = Res.getDimensionPixelSize("bdar_hint_margin_bottom");
    }

    public void a(Orientation orientation) {
        RotateViewUtils.requestOrientation(this.a, orientation);
        RotateViewUtils.requestOrientation(this.c, orientation);
        RotateViewUtils.requestOrientation(this.i, orientation);
        if (orientation == Orientation.LANDSCAPE) {
            i();
        } else if (orientation == Orientation.LANDSCAPE_REVERSE) {
            h();
        } else if (orientation == Orientation.PORTRAIT) {
            j();
        }
    }

    public TextView b() {
        return this.b;
    }

    public RotateViewGroup c() {
        return this.c;
    }

    public TextView d() {
        return this.d;
    }

    public ScanView e() {
        return this.e;
    }

    public RotateImageView f() {
        return this.i;
    }

    public void g() {
        if (this.h != null) {
            ((ViewGroup) this.h).removeAllViews();
        }
    }
}

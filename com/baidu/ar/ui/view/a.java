package com.baidu.ar.ui.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.ar.bean.CaptureState;
import com.baidu.ar.rotate.Orientation;
import com.baidu.ar.rotate.OrientationManager;
import com.baidu.ar.ui.RoundProgressBar;
import com.baidu.ar.ui.ToastCustom;
import com.baidu.ar.ui.rotateview.RotateViewGroup;
import com.baidu.ar.ui.rotateview.RotateViewUtils;
import com.baidu.ar.ui.view.CategoryView;
import com.baidu.ar.ui.view.adapter.a;
import com.baidu.ar.util.Res;
import com.baidu.ar.util.Utils;
import com.baidu.ar.util.ViewUtils;
/* loaded from: classes3.dex */
public class a {
    private Context a;
    private RelativeLayout b;
    private RotateViewGroup c;
    private RoundProgressBar d;
    private ImageView e;
    private ImageView f;
    private CategoryView g;
    private String h;
    private InterfaceC0053a j;
    private boolean i = false;
    private View.OnClickListener k = new View.OnClickListener() { // from class: com.baidu.ar.ui.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.i();
        }
    };
    private CategoryView.a l = new CategoryView.a() { // from class: com.baidu.ar.ui.view.a.2
        @Override // com.baidu.ar.ui.view.CategoryView.a
        public void a() {
            a.this.i = true;
            ViewUtils.setViewEnabled(a.this.f, false);
        }

        @Override // com.baidu.ar.ui.view.CategoryView.a
        public void a(int i) {
            a.this.i = false;
            ViewUtils.setViewEnabled(a.this.f, true);
        }
    };

    /* renamed from: com.baidu.ar.ui.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0053a {
        void f();

        void g();

        void h();
    }

    public a(Context context, RelativeLayout relativeLayout) {
        this.a = context;
        this.b = relativeLayout;
        if (this.b == null) {
            return;
        }
        this.c = (RotateViewGroup) this.b.findViewById(Res.id("bdar_capture_progress_group"));
        this.c.requestOrientation(OrientationManager.getGlobalOrientation());
        this.d = (RoundProgressBar) this.b.findViewById(Res.id("bdar_capture_progress"));
        this.d.setTextColor(0);
        this.d.setCricleProgressColor(Res.getColor("bdar_capture_progress"));
        this.d.setCricleColor(0);
        this.d.setRoundWidth(Utils.dipToPx(this.a, 1.0f));
        this.e = (ImageView) this.b.findViewById(Res.id("bdar_record_flashing"));
        this.f = (ImageView) this.b.findViewById(Res.id("bdar_capture_button"));
        this.f.setOnClickListener(this.k);
        ViewUtils.setViewEnabled(this.f, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, boolean z) {
        AlphaAnimation alphaAnimation;
        if (view == null) {
            return;
        }
        if (z) {
            alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        } else if (view.getVisibility() != 0) {
            return;
        } else {
            alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        }
        alphaAnimation.setDuration(500L);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setFillBefore(true);
        view.startAnimation(alphaAnimation);
        if (z) {
            view.setVisibility(0);
        } else {
            view.setVisibility(4);
        }
    }

    private void a(Object obj) {
        if (this.f != null) {
            this.f.setTag(obj);
        }
    }

    private void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.equals("拍摄")) {
            this.f.setTag(CaptureState.PICTURE);
        } else if (str.equals("录制")) {
            this.f.setTag(CaptureState.VIDEO_UNSTART);
        }
        this.h = str;
        if (this.g != null) {
            this.g.setCurrentItem(this.h);
        }
    }

    private void c(int i) {
        if (this.d != null) {
            this.d.setProgress(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        CaptureState captureState;
        if (this.i || (captureState = (CaptureState) this.f.getTag()) == null) {
            return;
        }
        if (captureState == CaptureState.PICTURE) {
            if (this.j != null) {
                this.j.f();
            }
        } else if (captureState == CaptureState.VIDEO_UNSTART) {
            if (this.j != null) {
                this.j.g();
            }
        } else if (captureState != CaptureState.VIDEO_CAPTURING || this.j == null) {
        } else {
            this.j.h();
        }
    }

    private void j() {
        if (this.g == null || this.g.getVisibility() != 0) {
            return;
        }
        this.g.setCurrentItem(this.h);
        if (this.f != null) {
            if (this.h.equals("拍摄")) {
                this.e.setVisibility(8);
                this.f.setTag(CaptureState.PICTURE);
            } else if (this.h.equals("录制")) {
                this.e.setVisibility(0);
                this.f.setTag(CaptureState.VIDEO_UNSTART);
            }
        }
    }

    private void k() {
        ImageView imageView = this.e;
        if (imageView == null) {
            return;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.2f);
        alphaAnimation.setDuration(500L);
        alphaAnimation.setFillAfter(false);
        alphaAnimation.setFillBefore(true);
        alphaAnimation.setRepeatMode(2);
        alphaAnimation.setRepeatCount(-1);
        imageView.startAnimation(alphaAnimation);
    }

    private void l() {
        ImageView imageView = this.e;
        if (imageView == null) {
            return;
        }
        imageView.clearAnimation();
    }

    private int m() {
        return this.d.getProgress();
    }

    public void a() {
        ViewUtils.setViewEnabled(this.f, false);
        ViewUtils.setViewVisibility(this.g, 4);
    }

    public void a(int i) {
        ViewUtils.setViewVisibility(this.g, i);
    }

    public void a(Orientation orientation) {
        RotateViewUtils.requestOrientation(this.c, orientation);
    }

    public void a(InterfaceC0053a interfaceC0053a) {
        this.j = interfaceC0053a;
    }

    public void a(boolean z) {
        if (!z) {
            this.c.setVisibility(8);
            this.e.setVisibility(8);
            a("拍摄");
            return;
        }
        this.g = (CategoryView) this.b.findViewById(Res.id("bdar_capture_category"));
        ViewUtils.setViewVisibility(this.g, 0);
        this.g.setCategoryListener(new a.InterfaceC0054a() { // from class: com.baidu.ar.ui.view.a.3
            @Override // com.baidu.ar.ui.view.adapter.a.InterfaceC0054a
            public void a(com.baidu.ar.ui.view.adapter.a aVar, String str) {
                a.this.h = str;
                if (str.equals("拍摄")) {
                    a.this.a((View) a.this.e, false);
                    a.this.f.setTag(CaptureState.PICTURE);
                } else if (str.equals("录制")) {
                    a.this.f.setTag(CaptureState.VIDEO_UNSTART);
                    a.this.a((View) a.this.e, true);
                }
            }
        });
        this.g.setItemChangeListener(this.l);
        a("录制");
    }

    public void b() {
        c(0);
        ViewUtils.setViewVisibility(this.c, 0);
        a(CaptureState.VIDEO_CAPTURING);
        k();
        ViewUtils.setViewEnabled(this.f, true);
    }

    public void b(boolean z) {
        ViewUtils.setViewEnabled(this.f, z);
    }

    public boolean b(int i) {
        if (i > 0 && i < 100) {
            this.d.setProgress(i);
            return false;
        }
        if (i >= 100) {
            this.d.setProgress(100);
        }
        return true;
    }

    public void c() {
        a(CaptureState.VIDEO_UNSTART);
        ViewUtils.setViewVisibility(this.g, 0);
    }

    public void d() {
        l();
        ViewUtils.setViewVisibility(this.c, 8);
        a(CaptureState.VIDEO_UNSTART);
        ViewUtils.setViewEnabled(this.f, false);
    }

    public void e() {
        ViewUtils.setViewVisibility(this.b, 0);
        j();
    }

    public void f() {
        if (this.e != null) {
            this.e.clearAnimation();
            this.e.invalidate();
        }
        ViewUtils.setViewVisibility(this.b, 8);
    }

    public void g() {
        this.i = false;
    }

    public boolean h() {
        if (m() <= 10) {
            String string = Res.getString("bdar_video_recording_too_short");
            ToastCustom toastCustom = new ToastCustom(this.a);
            toastCustom.makeText(string, 0);
            toastCustom.setGravity(2);
            toastCustom.show();
            return false;
        }
        return true;
    }
}

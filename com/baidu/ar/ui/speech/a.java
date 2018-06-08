package com.baidu.ar.ui.speech;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.ar.rotate.Orientation;
import com.baidu.ar.ui.rotateview.RotateImageView;
import com.baidu.ar.ui.rotateview.RotateViewGroup;
import com.baidu.ar.ui.rotateview.RotateViewUtils;
import com.baidu.ar.util.Res;
import com.baidu.ar.util.UiThreadUtil;
import com.baidu.ar.util.Utils;
/* loaded from: classes3.dex */
public class a {
    public RotateViewGroup a;
    public FrameLayout.LayoutParams b;
    public SpeechWaveView c;
    public SpeechCircleView d;
    public RotateViewGroup e;
    public FrameLayout.LayoutParams f;
    public TextView g;
    private LinearLayout h;
    private boolean i = false;
    private Context j;
    private RotateImageView k;
    private RotateViewGroup l;
    private TextView m;

    public a(Context context, LinearLayout linearLayout) {
        this.j = context;
        this.h = linearLayout;
    }

    public void a() {
        this.i = true;
        a(Orientation.PORTRAIT);
        RotateViewUtils.requestOrientation(this.e, Orientation.PORTRAIT, false);
        RotateViewUtils.requestOrientation(this.a, Orientation.PORTRAIT, false);
        RotateViewUtils.requestOrientation(this.k, Orientation.PORTRAIT, false);
        if (this.e != null) {
            this.f = (FrameLayout.LayoutParams) this.e.getLayoutParams();
            this.f.gravity = 81;
            this.f.bottomMargin = Res.getDimensionPixelSize("bdar_voice_tips_margin_bottom");
            int dimensionPixelSize = Res.getDimensionPixelSize("bdar_voice_tips_margin_left_right");
            this.f.leftMargin = dimensionPixelSize;
            this.f.rightMargin = dimensionPixelSize;
        }
        if (this.a != null) {
            this.b = (FrameLayout.LayoutParams) this.a.getLayoutParams();
            this.b.gravity = 81;
            this.b.bottomMargin = Res.getDimensionPixelSize("bdar_voice_wave_margin_bottom");
            this.b.leftMargin = 0;
            this.b.rightMargin = 0;
            this.b.topMargin = 0;
            DisplayMetrics displayMetrics = this.j.getResources().getDisplayMetrics();
            int i = displayMetrics.heightPixels;
            int i2 = displayMetrics.widthPixels;
            this.c.a(i2, Res.getDimensionPixelSize("bdar_voice_wave_height"));
            this.d.a(i2, Res.getDimensionPixelSize("bdar_voice_wave_height"));
        }
    }

    public void a(float f) {
        if (this.c != null) {
            this.c.a(f);
        }
    }

    public void a(View.OnClickListener onClickListener) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        LayoutInflater.from(this.j);
        View inflate = Res.inflate("bdar_layout_speech");
        if (inflate != null) {
            inflate.setLayoutParams(layoutParams);
            this.h.addView(inflate);
            this.a = (RotateViewGroup) inflate.findViewById(Res.id("bdar_id_voice_wave_layout"));
            this.e = (RotateViewGroup) inflate.findViewById(Res.id("bdar_id_voice_tips_layout"));
            this.g = (TextView) inflate.findViewById(Res.id("bdar_id_speech_tips"));
            this.c = (SpeechWaveView) inflate.findViewById(Res.id("bdar_id_voice_wave"));
            this.d = (SpeechCircleView) inflate.findViewById(Res.id("bdar_id_voice_circle"));
            this.k = (RotateImageView) inflate.findViewById(Res.id("bdar_gui_record_audio"));
            this.k.setOnClickListener(onClickListener);
            this.l = (RotateViewGroup) inflate.findViewById(Res.id("bdar_gui_record_audio_rotate_group"));
            this.m = (TextView) inflate.findViewById(Res.id("bdar_record_audio_tip"));
        }
    }

    public void a(Orientation orientation) {
        if (this.l.getVisibility() != 0) {
            return;
        }
        if (orientation == Orientation.PORTRAIT) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.l.getLayoutParams();
            layoutParams.removeRule(1);
            layoutParams.removeRule(12);
            layoutParams.addRule(2, Res.id("bdar_gui_record_audio"));
            layoutParams.addRule(11);
            layoutParams.bottomMargin = Res.getDimensionPixelSize("bdar_voice_button_tip_margin_bottom");
            layoutParams.rightMargin = Res.getDimensionPixelSize("bdar_voice_button_tip_margin_right");
            this.l.setLayoutParams(layoutParams);
            this.l.requestLayout();
            this.l.setAngle(0);
            this.m.setBackground(Res.getDrawable("bdar_drawable_bg_pop_right_bottom"));
        } else if (orientation == Orientation.LANDSCAPE) {
            this.l.setAngle(-90);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.l.getLayoutParams();
            layoutParams2.removeRule(2);
            layoutParams2.removeRule(11);
            layoutParams2.addRule(0, Res.id("bdar_gui_record_audio"));
            layoutParams2.addRule(12);
            layoutParams2.rightMargin = Res.getDimensionPixelSize("bdar_voice_button_tip_margin_bottom");
            layoutParams2.bottomMargin = Res.getDimensionPixelSize("bdar_voice_button_tip_margin_bottom_landscape");
            this.l.setLayoutParams(layoutParams2);
            this.l.requestLayout();
            this.m.setBackground(Res.getDrawable("bdar_drawable_bg_pop_left_bottom"));
        } else if (orientation == Orientation.LANDSCAPE_REVERSE) {
            this.l.setAngle(90);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.l.getLayoutParams();
            layoutParams3.removeRule(2);
            layoutParams3.removeRule(11);
            layoutParams3.addRule(0, Res.id("bdar_gui_record_audio"));
            layoutParams3.addRule(12);
            layoutParams3.rightMargin = Res.getDimensionPixelSize("bdar_voice_button_tip_margin_bottom");
            layoutParams3.bottomMargin = Res.getDimensionPixelSize("bdar_voice_button_tip_margin_bottom_landscape");
            this.l.setLayoutParams(layoutParams3);
            this.l.requestLayout();
            this.m.setBackground(Res.getDrawable("bdar_drawable_bg_pop_right_top"));
        }
    }

    public void a(String str) {
        if (this.g != null) {
            this.g.setText(str);
        }
    }

    public void a(final boolean z) {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.ui.speech.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.a != null) {
                    a.this.a.setVisibility(z ? 0 : 8);
                }
            }
        });
    }

    public void b() {
        this.i = true;
        a(Orientation.LANDSCAPE);
        RotateViewUtils.requestOrientation(this.e, Orientation.LANDSCAPE, false);
        RotateViewUtils.requestOrientation(this.a, Orientation.LANDSCAPE, false);
        RotateViewUtils.requestOrientation(this.k, Orientation.LANDSCAPE, false);
        if (this.e != null) {
            this.f = (FrameLayout.LayoutParams) this.e.getLayoutParams();
            this.f.gravity = 21;
            this.f.rightMargin = Res.getDimensionPixelSize("bdar_voice_tip_margin_bottom_landscape");
            int dimensionPixelSize = Res.getDimensionPixelSize("bdar_voice_tips_margin_left_right");
            this.f.topMargin = dimensionPixelSize;
            this.f.bottomMargin = dimensionPixelSize;
        }
        if (this.a != null) {
            this.b = (FrameLayout.LayoutParams) this.a.getLayoutParams();
            int dimensionPixelSize2 = Res.getDimensionPixelSize("bdar_voice_wave_margin_bottom_landscape");
            Res.getDimensionPixelSize("bdar_voice_wave_margin_bottom");
            this.b.gravity = 21;
            this.b.bottomMargin = 0;
            this.b.leftMargin = 0;
            this.b.rightMargin = dimensionPixelSize2;
            this.b.topMargin = 0;
            this.c.a(Utils.getHeight(this.j), Res.getDimensionPixelSize("bdar_voice_wave_height"));
            this.d.a(Utils.getHeight(this.j), Res.getDimensionPixelSize("bdar_voice_wave_height"));
        }
    }

    public void b(final String str) {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.ui.speech.a.7
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.m != null) {
                    a.this.m.setText(str);
                }
            }
        });
    }

    public void b(final boolean z) {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.ui.speech.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.e != null) {
                    a.this.e.setVisibility(z ? 0 : 8);
                }
            }
        });
    }

    public void c() {
        this.i = true;
        a(Orientation.LANDSCAPE_REVERSE);
        RotateViewUtils.requestOrientation(this.e, Orientation.LANDSCAPE_REVERSE, false);
        RotateViewUtils.requestOrientation(this.a, Orientation.LANDSCAPE_REVERSE, false);
        RotateViewUtils.requestOrientation(this.k, Orientation.LANDSCAPE_REVERSE, false);
        if (this.e != null) {
            this.f = (FrameLayout.LayoutParams) this.e.getLayoutParams();
            this.f.gravity = 19;
            this.f.leftMargin = Res.getDimensionPixelSize("bdar_voice_tip_margin_bottom_landscape");
            int dimensionPixelSize = Res.getDimensionPixelSize("bdar_voice_tips_margin_left_right");
            this.f.topMargin = dimensionPixelSize;
            this.f.bottomMargin = dimensionPixelSize;
        }
        if (this.a != null) {
            this.b = (FrameLayout.LayoutParams) this.a.getLayoutParams();
            int dimensionPixelSize2 = Res.getDimensionPixelSize("bdar_voice_wave_margin_bottom_landscape");
            Res.getDimensionPixelSize("bdar_voice_wave_margin_bottom");
            this.b.gravity = 19;
            this.b.bottomMargin = 0;
            this.b.leftMargin = dimensionPixelSize2;
            this.b.rightMargin = 0;
            this.b.topMargin = 0;
            this.c.a(Utils.getHeight(this.j), Res.getDimensionPixelSize("bdar_voice_wave_height"));
            this.d.a(Utils.getHeight(this.j), Res.getDimensionPixelSize("bdar_voice_wave_height"));
        }
    }

    public void c(final boolean z) {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.ui.speech.a.3
            @Override // java.lang.Runnable
            public void run() {
                if (!z) {
                    a.this.d(false);
                    return;
                }
                if (a.this.c != null) {
                    a.this.c.setVisibility(8);
                }
                if (a.this.d != null) {
                    a.this.d.a(Res.getDimensionPixelSize("bdar_voice_upscreen_loading_radius"), -1);
                    a.this.d.a();
                    a.this.d(false);
                }
            }
        });
    }

    public void d() {
        if (this.d != null) {
            this.d.b();
            this.d = null;
        }
        if (this.c != null) {
            this.c.c();
            this.c = null;
        }
    }

    public void d(boolean z) {
        if (this.d != null) {
            this.d.setVisibility(z ? 0 : 8);
        }
    }

    public void e() {
        if (!this.i) {
            a();
        }
        d(false);
        if (this.c != null) {
            this.c.setCallBack(null);
            this.c.a();
            this.c.setVisibility(0);
        }
    }

    public void e(final boolean z) {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.ui.speech.a.4
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.c != null) {
                    a.this.c.setVisibility(z ? 0 : 8);
                }
            }
        });
    }

    public RotateImageView f() {
        return this.k;
    }

    public void f(final boolean z) {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.ui.speech.a.5
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.k != null) {
                    a.this.k.setVisibility(z ? 0 : 4);
                }
            }
        });
    }

    public void g(final boolean z) {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.ui.speech.a.6
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.l != null) {
                    a.this.l.setVisibility(z ? 0 : 4);
                }
            }
        });
    }
}

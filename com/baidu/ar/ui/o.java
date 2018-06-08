package com.baidu.ar.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.ar.ARController;
import com.baidu.ar.bean.ARConfig;
import com.baidu.ar.rotate.Orientation;
import com.baidu.ar.rotate.OrientationManager;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.ar.statistic.StatisticHelper;
import com.baidu.ar.ui.rotateview.RotateImageView;
import com.baidu.ar.ui.rotateview.RotateViewGroup;
import com.baidu.ar.ui.rotateview.RotateViewUtils;
import com.baidu.ar.util.Res;
import com.baidu.ar.util.UiThreadUtil;
import com.baidu.ar.util.Utils;
import com.baidu.ar.util.ViewUtils;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes3.dex */
public class o {
    private RotateImageView a;
    private RotateViewGroup b;
    private TextView c;
    private Timer d;
    private TimerTask e;
    private View f;
    private c g;
    private Context h;
    private boolean i = true;
    private boolean j = false;
    private boolean k = false;

    public o(c cVar) {
        this.g = cVar;
        this.h = cVar.u().h().getActivity().getApplicationContext();
        g();
    }

    private void c() {
        if (this.a != null && this.k && l() && this.i && !this.j) {
            this.a.setVisibility(0);
            h();
        }
    }

    private void d() {
        if (this.b != null) {
            if (this.c != null) {
                this.c.setBackground(Res.getDrawable("bdar_drawable_bg_pop_left_bottom"));
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.b.getLayoutParams();
            layoutParams.removeRule(1);
            layoutParams.removeRule(12);
            layoutParams.addRule(2, Res.findViewById(this.f, "bdar_rescan").getId());
            layoutParams.bottomMargin = Utils.dipToPx(this.h, 5.0f);
            layoutParams.leftMargin = Utils.dipToPx(this.h, 16.0f);
            this.b.setLayoutParams(layoutParams);
            this.b.requestLayout();
        }
    }

    private void e() {
        if (this.b != null) {
            if (this.c != null) {
                this.c.setBackground(Res.getDrawable("bdar_drawable_bg_pop_left_top"));
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.b.getLayoutParams();
            layoutParams.removeRule(2);
            layoutParams.addRule(1, Res.findViewById(this.f, "bdar_rescan").getId());
            layoutParams.addRule(12);
            layoutParams.leftMargin = Utils.dipToPx(this.h, 5.0f);
            layoutParams.bottomMargin = Utils.dipToPx(this.h, 46.0f);
            this.b.requestLayout();
        }
    }

    private void f() {
        if (this.b != null) {
            if (this.c != null) {
                this.c.setBackground(Res.getDrawable("bdar_drawable_bg_pop_right_bottom"));
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.b.getLayoutParams();
            layoutParams.removeRule(2);
            layoutParams.addRule(1, Res.findViewById(this.f, "bdar_rescan").getId());
            layoutParams.addRule(12);
            layoutParams.leftMargin = Utils.dipToPx(this.h, 5.0f);
            layoutParams.bottomMargin = Utils.dipToPx(this.h, 46.0f);
            this.b.setLayoutParams(layoutParams);
            this.b.requestLayout();
        }
    }

    private void g() {
        this.f = Res.inflate("bdar_layout_rescan");
        this.a = (RotateImageView) Res.findViewById(this.f, "bdar_rescan");
        this.b = (RotateViewGroup) Res.findViewById(this.f, "bdar_rescan_guide_frame");
        this.c = (TextView) Res.findViewById(this.f, "bdar_rescan_guide");
        this.a.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.ar.ui.o.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ARConfig.getARLaunchMode() == 2) {
                    StatisticHelper.getInstance().statisticInfo(StatisticConstants.RESCAN, StatisticConstants.HOST_PLATFORM_OPEN_SDK);
                    o.this.k().h().closeCamera();
                    return;
                }
                StatisticHelper.getInstance().statisticInfo(StatisticConstants.RESCAN, StatisticConstants.HOST_PLATFORM_BOX);
                o.this.j().switchCase(null, ARConfig.getARInitialType());
                o.this.j().getRequestController().release();
                o.this.k().h().getHostUI().hideLoadingView();
            }
        });
        this.a.setVisibility(4);
        this.g.a.addView(this.f);
    }

    private void h() {
        SharedPreferences sharedPreferences = this.h.getSharedPreferences("bdar_rescan_guide", 0);
        if (sharedPreferences.getBoolean("show_rescan_guide", false)) {
            return;
        }
        sharedPreferences.edit().putBoolean("show_rescan_guide", true).apply();
        if (this.b != null) {
            this.b.setVisibility(0);
            a(OrientationManager.getGlobalOrientation());
        }
        i();
        this.d = new Timer();
        if (this.e == null) {
            this.e = new TimerTask() { // from class: com.baidu.ar.ui.o.2
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.ui.o.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (o.this.b != null) {
                                o.this.b.setVisibility(8);
                            }
                            o.this.i();
                        }
                    });
                }
            };
        }
        this.d.schedule(this.e, 2500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (this.d != null) {
            this.d.cancel();
            this.d.purge();
            this.d = null;
        }
        if (this.e != null) {
            this.e.cancel();
            this.e = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ARController j() {
        return this.g.u().i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.ar.b k() {
        return this.g.u();
    }

    private boolean l() {
        return ARConfig.getARInitialType() == 7 || ARConfig.getARInitialType() == 6 || ARConfig.getARLaunchMode() == 2;
    }

    public void a() {
        this.g.a.removeView(this.f);
        i();
    }

    public void a(Orientation orientation) {
        RotateViewUtils.requestOrientation(this.a, orientation, true);
        RotateViewUtils.requestOrientation(this.b, orientation);
        if (orientation == Orientation.PORTRAIT) {
            d();
        } else if (orientation == Orientation.LANDSCAPE_REVERSE) {
            f();
        } else if (orientation == Orientation.LANDSCAPE) {
            e();
        }
    }

    public void a(boolean z) {
        this.k = z;
        if (this.k) {
            c();
        } else {
            ViewUtils.setViewVisibility(this.a, 4);
        }
    }

    public RotateImageView b() {
        return this.a;
    }

    public void b(boolean z) {
        this.j = z;
        if (this.j) {
            ViewUtils.setViewVisibility(this.a, 4);
        } else {
            c();
        }
    }

    public void c(boolean z) {
        this.i = z;
        if (this.i) {
            c();
        } else {
            ViewUtils.setViewVisibility(this.a, 4);
        }
    }
}

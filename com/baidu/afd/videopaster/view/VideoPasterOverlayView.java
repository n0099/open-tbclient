package com.baidu.afd.videopaster.view;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import d.b.b.e.p.l;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class VideoPasterOverlayView extends FrameLayout {
    public static final int w = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds22);

    /* renamed from: e  reason: collision with root package name */
    public TextView f2493e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f2494f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f2495g;

    /* renamed from: h  reason: collision with root package name */
    public View f2496h;
    public View i;
    public ImageView j;
    public boolean k;
    public boolean l;
    public b m;
    public Context n;
    public int o;
    public boolean p;
    public int q;
    public int r;
    public String s;
    public boolean t;
    public d.b.c.m.e.a u;
    public View.OnClickListener v;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.video_paster_overlay_time_and_close) {
                if (VideoPasterOverlayView.this.m != null) {
                    VideoPasterOverlayView.this.m.c();
                }
            } else if (view.getId() == R.id.video_paster_overlay_title) {
                if (VideoPasterOverlayView.this.m != null) {
                    VideoPasterOverlayView.this.m.b();
                }
            } else if (view.getId() == R.id.video_paster_overlay_detail) {
                if (VideoPasterOverlayView.this.m != null) {
                    VideoPasterOverlayView.this.m.d();
                    VideoPasterOverlayView.this.t = true;
                }
            } else if (view.getId() == R.id.video_paster_mask_wrapper) {
                if (VideoPasterOverlayView.this.m != null) {
                    VideoPasterOverlayView.this.m.e();
                    VideoPasterOverlayView.this.t = true;
                }
            } else if (view.getId() != R.id.video_paster_mask_back || VideoPasterOverlayView.this.m == null) {
            } else {
                VideoPasterOverlayView.this.m.a();
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a();

        void b();

        void c();

        void d();

        void e();
    }

    public VideoPasterOverlayView(@NonNull Context context) {
        super(context);
        this.o = 0;
        this.p = false;
        this.q = 0;
        this.r = 0;
        this.t = false;
        this.v = new a();
        this.n = context;
        this.o = e(context);
        View inflate = LayoutInflater.from(context).inflate(R.layout.video_paster_overlay_layout, (ViewGroup) null);
        this.i = inflate;
        this.f2496h = inflate.findViewById(R.id.video_paster_mask_wrapper);
        this.f2493e = (TextView) this.i.findViewById(R.id.video_paster_overlay_title);
        this.f2494f = (TextView) this.i.findViewById(R.id.video_paster_overlay_time_and_close);
        this.f2495g = (TextView) this.i.findViewById(R.id.video_paster_overlay_detail);
        this.j = (ImageView) this.i.findViewById(R.id.video_paster_mask_back);
        this.f2495g.setOnClickListener(this.v);
        this.f2494f.setOnClickListener(this.v);
        this.f2496h.setOnClickListener(this.v);
        this.j.setOnClickListener(this.v);
        this.f2493e.setOnClickListener(this.v);
    }

    private String getNavBarOverride() {
        try {
            Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class);
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke(null, "qemu.hw.mainkeys");
        } catch (Throwable unused) {
            return null;
        }
    }

    public final void c() {
        this.j.setVisibility(0);
        this.f2494f.setPadding(w, 0, 0, 0);
        this.f2495g.setPadding(0, 0, w, 0);
        this.i.setPadding(0, 0, 0, 0);
        p();
    }

    public final void d() {
        this.j.setVisibility(8);
        this.f2494f.setPadding(0, 0, 0, 0);
        this.f2495g.setPadding(0, 0, 0, 0);
        boolean f2 = f(this.n);
        if (this.k && this.l && f2) {
            this.i.setPadding(0, 0, 0, this.o);
        } else {
            this.i.setPadding(0, 0, 0, 0);
        }
        p();
    }

    public final int e(Context context) {
        Resources resources;
        int identifier;
        if (!f(context) || (identifier = (resources = context.getResources()).getIdentifier("navigation_bar_height", "dimen", "android")) <= 0) {
            return 0;
        }
        return resources.getDimensionPixelSize(identifier);
    }

    public final boolean f(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
        if (identifier != 0) {
            boolean z = resources.getBoolean(identifier);
            String navBarOverride = getNavBarOverride();
            if ("1".equals(navBarOverride)) {
                return false;
            }
            if ("0".equals(navBarOverride)) {
                return true;
            }
            return z;
        }
        return !ViewConfiguration.get(context).hasPermanentMenuKey();
    }

    public void g() {
        this.k = true;
        n(this.u, true, this.l);
        if (this.p) {
            o(this.q, this.r, this.s);
        }
    }

    @Override // android.view.View
    public View getRootView() {
        return this.i;
    }

    public void h() {
        this.k = false;
        n(this.u, false, this.l);
        if (this.t && !this.l) {
            this.t = false;
        } else if (this.p) {
            o(this.q, this.r, this.s);
        }
    }

    public void i() {
        this.p = false;
        this.s = "";
        this.q = 0;
        this.r = 0;
        this.t = false;
    }

    public final void j(int i, int i2, String str) {
        Context context = this.n;
        if (context == null || i == 0 || i2 == 0) {
            return;
        }
        int k = l.k(context);
        int i3 = 0;
        if (TextUtils.equals(str, "NEWINDEX")) {
            k -= l.g(this.n, R.dimen.tbds88);
            i3 = (int) (k * 0.5625d);
        } else if (TextUtils.equals(str, "VIDEO_LIST")) {
            i3 = (int) (k * (this.l ? 0.875f : 0.5625f));
        } else {
            k = 0;
        }
        if (i3 == 0) {
            return;
        }
        if (i / i2 > k / i3) {
            i3 = (i2 * k) / i;
        }
        if (i3 <= 0) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.i.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = i3;
        this.i.setLayoutParams(layoutParams);
    }

    public void k(int i) {
    }

    public void l() {
    }

    public void m() {
    }

    public void n(d.b.c.m.e.a aVar, boolean z, boolean z2) {
        if (aVar == null) {
            return;
        }
        this.u = aVar;
        this.k = z;
        this.l = z2;
        this.f2493e.setText(aVar.f42521h);
        this.f2495g.setText(aVar.b());
        if (z && !z2) {
            c();
        } else {
            d();
        }
    }

    public void o(int i, int i2, String str) {
        this.p = true;
        this.q = i;
        this.r = i2;
        this.s = str;
        if (this.k) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.i.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -1;
            this.i.setLayoutParams(layoutParams);
            return;
        }
        j(i, i2, str);
    }

    public final void p() {
        Context context = this.n;
        if (context == null || this.f2496h == null || !f(context)) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f2496h.getLayoutParams();
        if (this.k) {
            if (this.l) {
                layoutParams.setMargins(0, 0, 0, this.o);
            } else {
                int i = this.o;
                layoutParams.setMargins(i, 0, i, 0);
            }
        } else {
            layoutParams.setMargins(0, 0, 0, 0);
        }
        this.f2496h.setLayoutParams(layoutParams);
    }

    public void setCountDownNum(int i) {
        String str;
        if (this.f2494f != null && i > 0) {
            if (i < 10) {
                str = "0" + i;
            } else {
                str = "" + i;
            }
            this.f2494f.setText(str + TbadkCoreApplication.getInst().getResources().getString(R.string.video_paster_close_ad));
        }
    }

    public void setOverlayViewCallback(b bVar) {
        this.m = bVar;
    }
}

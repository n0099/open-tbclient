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
import d.a.c.e.p.l;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class VideoPasterOverlayView extends FrameLayout {
    public static final int w = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds22);

    /* renamed from: e  reason: collision with root package name */
    public TextView f2524e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f2525f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f2526g;

    /* renamed from: h  reason: collision with root package name */
    public View f2527h;

    /* renamed from: i  reason: collision with root package name */
    public View f2528i;
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
    public d.a.d.m.e.a u;
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
                    VideoPasterOverlayView.this.m.a();
                }
            } else if (view.getId() == R.id.video_paster_overlay_detail) {
                if (VideoPasterOverlayView.this.m != null) {
                    VideoPasterOverlayView.this.m.d();
                    VideoPasterOverlayView.this.t = true;
                }
            } else if (view.getId() == R.id.video_paster_mask_wrapper) {
                if (VideoPasterOverlayView.this.m != null) {
                    VideoPasterOverlayView.this.m.onClickAd();
                    VideoPasterOverlayView.this.t = true;
                }
            } else if (view.getId() != R.id.video_paster_mask_back || VideoPasterOverlayView.this.m == null) {
            } else {
                VideoPasterOverlayView.this.m.b();
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a();

        void b();

        void c();

        void d();

        void onClickAd();
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
        this.f2528i = inflate;
        this.f2527h = inflate.findViewById(R.id.video_paster_mask_wrapper);
        this.f2524e = (TextView) this.f2528i.findViewById(R.id.video_paster_overlay_title);
        this.f2525f = (TextView) this.f2528i.findViewById(R.id.video_paster_overlay_time_and_close);
        this.f2526g = (TextView) this.f2528i.findViewById(R.id.video_paster_overlay_detail);
        this.j = (ImageView) this.f2528i.findViewById(R.id.video_paster_mask_back);
        this.f2526g.setOnClickListener(this.v);
        this.f2525f.setOnClickListener(this.v);
        this.f2527h.setOnClickListener(this.v);
        this.j.setOnClickListener(this.v);
        this.f2524e.setOnClickListener(this.v);
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
        this.f2525f.setPadding(w, 0, 0, 0);
        this.f2526g.setPadding(0, 0, w, 0);
        this.f2528i.setPadding(0, 0, 0, 0);
        p();
    }

    public final void d() {
        this.j.setVisibility(8);
        this.f2525f.setPadding(0, 0, 0, 0);
        this.f2526g.setPadding(0, 0, 0, 0);
        boolean f2 = f(this.n);
        if (this.k && this.l && f2) {
            this.f2528i.setPadding(0, 0, 0, this.o);
        } else {
            this.f2528i.setPadding(0, 0, 0, 0);
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
        return this.f2528i;
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

    public final void j(int i2, int i3, String str) {
        Context context = this.n;
        if (context == null || i2 == 0 || i3 == 0) {
            return;
        }
        int k = l.k(context);
        int i4 = 0;
        if (TextUtils.equals(str, "NEWINDEX")) {
            k -= l.g(this.n, R.dimen.tbds88);
            i4 = (int) (k * 0.5625d);
        } else if (TextUtils.equals(str, "VIDEO_LIST")) {
            i4 = (int) (k * (this.l ? 0.875f : 0.5625f));
        } else {
            k = 0;
        }
        if (i4 == 0) {
            return;
        }
        if (i2 / i3 > k / i4) {
            i4 = (i3 * k) / i2;
        }
        if (i4 <= 0) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f2528i.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = i4;
        this.f2528i.setLayoutParams(layoutParams);
    }

    public void k(int i2) {
    }

    public void l() {
    }

    public void m() {
    }

    public void n(d.a.d.m.e.a aVar, boolean z, boolean z2) {
        if (aVar == null) {
            return;
        }
        this.u = aVar;
        this.k = z;
        this.l = z2;
        this.f2524e.setText(aVar.f39751h);
        this.f2526g.setText(aVar.b());
        if (z && !z2) {
            c();
        } else {
            d();
        }
    }

    public void o(int i2, int i3, String str) {
        this.p = true;
        this.q = i2;
        this.r = i3;
        this.s = str;
        if (this.k) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f2528i.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -1;
            this.f2528i.setLayoutParams(layoutParams);
            return;
        }
        j(i2, i3, str);
    }

    public final void p() {
        Context context = this.n;
        if (context == null || this.f2527h == null || !f(context)) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f2527h.getLayoutParams();
        if (this.k) {
            if (this.l) {
                layoutParams.setMargins(0, 0, 0, this.o);
            } else {
                int i2 = this.o;
                layoutParams.setMargins(i2, 0, i2, 0);
            }
        } else {
            layoutParams.setMargins(0, 0, 0, 0);
        }
        this.f2527h.setLayoutParams(layoutParams);
    }

    public void setCountDownNum(int i2) {
        String str;
        if (this.f2525f != null && i2 > 0) {
            if (i2 < 10) {
                str = "0" + i2;
            } else {
                str = "" + i2;
            }
            this.f2525f.setText(str + TbadkCoreApplication.getInst().getResources().getString(R.string.video_paster_close_ad));
        }
    }

    public void setOverlayViewCallback(b bVar) {
        this.m = bVar;
    }
}

package com.baidu.platform.comapi.bikenavi.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.AsyncTask;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.baidu.platform.comapi.wnplatform.o.f;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class a extends com.baidu.platform.comapi.walknavi.g.b.b implements View.OnClickListener {
    public static int F = 135;
    public static int G = 90;
    public TextView A;
    public TextView B;
    public TextView C;
    public TextView D;
    public int E;

    /* renamed from: a  reason: collision with root package name */
    public Activity f9418a;

    /* renamed from: e  reason: collision with root package name */
    public int f9422e;

    /* renamed from: g  reason: collision with root package name */
    public com.baidu.platform.comapi.bikenavi.c.b f9424g;

    /* renamed from: h  reason: collision with root package name */
    public ImageButton f9425h;
    public ImageButton i;
    public LinearLayout j;
    public TextView k;
    public RelativeLayout l;
    public RelativeLayout m;
    public CustomScrollView n;
    public TextView o;
    public View p;
    public TextView q;
    public View r;
    public View s;
    public ImageView t;
    public ImageView u;
    public TextView v;
    public TextView w;
    public TextView x;
    public TextView y;
    public TextView z;

    /* renamed from: b  reason: collision with root package name */
    public final int f9419b = 1;

    /* renamed from: c  reason: collision with root package name */
    public final int f9420c = 2;

    /* renamed from: d  reason: collision with root package name */
    public final int f9421d = 3;

    /* renamed from: f  reason: collision with root package name */
    public boolean f9423f = false;
    public int H = 0;

    /* renamed from: com.baidu.platform.comapi.bikenavi.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class AsyncTaskC0118a extends AsyncTask<Integer, Integer, String> {

        /* renamed from: b  reason: collision with root package name */
        public ScrollView f9427b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f9428c;

        /* renamed from: d  reason: collision with root package name */
        public int f9429d = 15;

        public AsyncTaskC0118a(ScrollView scrollView, boolean z) {
            this.f9427b = scrollView;
            this.f9428c = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public String doInBackground(Integer... numArr) {
            try {
                int i = 153;
                if (this.f9428c) {
                    int i2 = 0;
                    while (i2 < 153) {
                        i2 += this.f9429d;
                        publishProgress(Integer.valueOf(i2));
                        Thread.sleep(10L);
                    }
                    return null;
                }
                while (i > 0) {
                    i -= this.f9429d;
                    if (i < 0) {
                        i = 0;
                    }
                    publishProgress(Integer.valueOf(i));
                    Thread.sleep(10L);
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onProgressUpdate(Integer... numArr) {
            try {
                int intValue = numArr[0].intValue();
                String hexString = Integer.toHexString(intValue);
                if (hexString.length() == 1) {
                    hexString = "0" + hexString;
                }
                String str = "#" + hexString + "000000";
                com.baidu.platform.comapi.wnplatform.d.a.a("yang12", "onProgressUpdate:" + str + "alpha:" + intValue);
                this.f9427b.setBackgroundColor(Color.parseColor(str));
                a.this.H = intValue;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public a(Context context, com.baidu.platform.comapi.bikenavi.c.b bVar, View view) {
        this.f9418a = (Activity) context;
        this.f9424g = bVar;
        a(view);
    }

    private void g() {
        this.n.setVisibility(8);
        this.p.setVisibility(0);
    }

    private void h() {
        this.n.setBackgroundColor(Color.parseColor("#00000000"));
        this.H = 0;
        d(false);
        this.n.setVisibility(0);
        this.p.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.dimen.M_W_X009) {
            if (!this.f9423f) {
                com.baidu.platform.comapi.wnplatform.k.a.a().a("status", "overview");
            }
            com.baidu.platform.comapi.wnplatform.k.a.a().a("BikeNaviPG.turnDire");
            int i = this.f9422e;
            if (i == 1) {
                com.baidu.platform.comapi.walknavi.b.a().F().run("[3D车头向上]按钮点击");
            } else if (i == 2) {
                com.baidu.platform.comapi.walknavi.b.a().F().run("[2D正北]按钮点击");
            } else if (i != 3) {
            } else {
                com.baidu.platform.comapi.walknavi.b.a().F().run("[回车位]按钮点击");
            }
        } else if (id == R.dimen.M_W_X019) {
            this.f9423f = !this.f9423f;
            com.baidu.platform.comapi.wnplatform.k.a.a().a("BikeNaviPG.overview");
            com.baidu.platform.comapi.walknavi.b.a().F().run("[查看全览]按钮点击");
            this.j.setVisibility(8);
            this.k.setVisibility(0);
            this.f9424g.k();
            h();
            this.f9424g.a(this.f9418a, com.baidu.platform.comapi.walknavi.b.a().G().a(), 10, 0, 0, F + 10);
            if (com.baidu.platform.comapi.walknavi.b.a().G().a() != null) {
                com.baidu.platform.comapi.walknavi.b.a().G().a().requestLayout();
            }
        } else if (id != R.dimen.M_W_X021) {
            if (id == R.dimen.M_W_X016) {
                this.f9424g.a(false, R.drawable.res_0x7f080001_avd_hide_password__1);
            }
        } else {
            this.f9423f = !this.f9423f;
            com.baidu.platform.comapi.wnplatform.k.a.a().a("BikeNaviPG.continue");
            com.baidu.platform.comapi.walknavi.b.a().F().run("[3D车头向上]按钮点击");
            this.j.setVisibility(0);
            this.k.setVisibility(8);
            com.baidu.platform.comapi.walknavi.segmentbrowse.c.a(com.baidu.platform.comapi.walknavi.segmentbrowse.b.REFRESH_GUIDANCE);
            com.baidu.platform.comapi.walknavi.b.a().D().j();
            g();
            this.f9424g.a(this.f9418a, com.baidu.platform.comapi.walknavi.b.a().G().a(), 70, 0, 0, 60);
            if (com.baidu.platform.comapi.walknavi.b.a().G().a() != null) {
                com.baidu.platform.comapi.walknavi.b.a().G().a().requestLayout();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z) {
        this.n.updateStatus(com.baidu.platform.comapi.wnplatform.n.b.BOTTOM, z);
        this.t.setVisibility(0);
        this.u.setVisibility(8);
        com.baidu.platform.comapi.wnplatform.k.a.a().a("BikeNaviPG.smallDrawer");
    }

    private void a(View view) {
        this.l = (RelativeLayout) view.findViewById(R.dimen.M_H_X010);
        this.f9425h = (ImageButton) view.findViewById(R.dimen.M_W_X009);
        this.j = (LinearLayout) view.findViewById(R.dimen.M_W_X019);
        this.k = (TextView) view.findViewById(R.dimen.M_W_X021);
        this.i = (ImageButton) view.findViewById(R.dimen.M_W_X016);
        this.o = (TextView) view.findViewById(R.dimen.M_W_X010);
        this.p = view.findViewById(R.dimen.M_W_X008);
        this.q = (TextView) view.findViewById(R.dimen.M_W_X020);
        b(view);
        this.f9425h.setOnClickListener(this);
        this.j.setOnClickListener(this);
        this.k.setOnClickListener(this);
        this.i.setOnClickListener(this);
    }

    private void b(View view) {
        this.n = (CustomScrollView) view.findViewById(R.dimen.M_W_X014);
        view.post(new b(this));
        View a2 = com.baidu.platform.comapi.wnplatform.o.a.a.a(this.f9418a, R.array.Mask_X003, null);
        this.s = a2;
        this.n.addContentView(a2);
        this.n.updateStatus(com.baidu.platform.comapi.wnplatform.n.b.BOTTOM, false);
        this.t = (ImageView) this.s.findViewById(R.dimen.M_H_X013);
        this.u = (ImageView) this.s.findViewById(R.dimen.M_H_X014);
        this.v = (TextView) this.s.findViewById(R.dimen.M_T_X001);
        this.w = (TextView) this.s.findViewById(R.dimen.M_T_X002);
        this.x = (TextView) this.s.findViewById(R.dimen.M_T_X003);
        this.y = (TextView) this.s.findViewById(R.dimen.M_H_X015);
        this.z = (TextView) this.s.findViewById(R.dimen.M_H_X016);
        this.A = (TextView) this.s.findViewById(R.dimen.M_W_X001);
        this.B = (TextView) this.s.findViewById(R.dimen.M_W_X002);
        this.C = (TextView) this.s.findViewById(R.dimen.M_W_X003);
        this.D = (TextView) this.s.findViewById(R.dimen.M_H_X017);
        View findViewById = this.s.findViewById(R.dimen.M_H_X011);
        this.r = findViewById;
        findViewById.setOnClickListener(new c(this));
        this.n.setOnScrollChangeListener(new d(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        this.n.updateStatus(com.baidu.platform.comapi.wnplatform.n.b.TOP, z);
        this.t.setVisibility(8);
        this.u.setVisibility(0);
        com.baidu.platform.comapi.wnplatform.k.a.a().a("BikeNaviPG.bigDrawer");
    }

    public void a(double d2, double d3, double d4) {
        TextView textView = this.o;
        textView.setText(((int) d2) + "");
        TextView textView2 = this.v;
        textView2.setText(d2 + "");
        TextView textView3 = this.x;
        textView3.setText(d4 + "");
        TextView textView4 = this.w;
        textView4.setText(d3 + "");
    }

    public void a(double d2, long j) {
        StringBuffer stringBuffer = new StringBuffer();
        com.baidu.platform.comapi.wnplatform.o.f.a((int) d2, f.a.ZH, stringBuffer);
        StringBuilder sb = new StringBuilder();
        sb.append("已骑行" + stringBuffer.toString() + " ");
        sb.append(com.baidu.platform.comapi.wnplatform.o.f.a((int) j, 2));
        this.D.setText(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        if (z) {
            new AsyncTaskC0118a(this.n, true).execute(new Integer[0]);
        } else if (this.H != 0) {
            new AsyncTaskC0118a(this.n, false).execute(new Integer[0]);
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.g.b.b
    public void b() {
        super.b();
        Animation c2 = com.baidu.platform.comapi.wnplatform.o.a.a.c(this.f9418a, R.attr.SapiSdkDividerWidth);
        if (this.l.isShown()) {
            this.l.setAnimation(c2);
        }
        this.l.setVisibility(8);
        RelativeLayout relativeLayout = this.m;
        if (relativeLayout != null) {
            if (relativeLayout.isShown()) {
                this.m.setAnimation(c2);
            }
            this.m.setVisibility(8);
        }
    }

    public void a(float f2, float f3, float f4) {
        TextView textView = this.A;
        textView.setText(f2 + "");
        TextView textView2 = this.B;
        textView2.setText(f3 + "");
        TextView textView3 = this.C;
        textView3.setText(f4 + "");
    }

    public void a(String str, String str2) {
        this.y.setText(str);
        this.z.setText(str2);
        StringBuilder sb = new StringBuilder();
        sb.append("全程剩余: ");
        sb.append(str + " ");
        sb.append(str2);
        this.q.setText(sb.toString());
    }

    public void a(int i) {
        if (i == 2130837750) {
            this.f9425h.setImageDrawable(com.baidu.platform.comapi.wnplatform.o.a.a.a(this.f9418a, 2130837750));
            this.f9422e = 1;
        } else if (i == 2130837753) {
            this.f9425h.setImageDrawable(com.baidu.platform.comapi.wnplatform.o.a.a.a(this.f9418a, 2130837753));
            this.f9422e = 2;
        } else if (i == 2130837751) {
            this.f9425h.setImageDrawable(com.baidu.platform.comapi.wnplatform.o.a.a.a(this.f9418a, 2130837751));
            this.f9422e = 3;
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.g.b.b
    public void a() {
        super.a();
        Animation c2 = com.baidu.platform.comapi.wnplatform.o.a.a.c(this.f9418a, R.attr.SapiSdkDividerPadding);
        if (!this.l.isShown()) {
            this.l.setAnimation(c2);
        }
        this.l.setVisibility(0);
        RelativeLayout relativeLayout = this.m;
        if (relativeLayout != null) {
            if (!relativeLayout.isShown()) {
                this.m.setAnimation(c2);
            }
            this.m.setVisibility(0);
        }
    }

    public void a(boolean z) {
        this.f9423f = z;
        if (z) {
            this.j.setVisibility(0);
            this.k.setVisibility(8);
            return;
        }
        this.j.setVisibility(8);
        this.k.setVisibility(0);
    }
}

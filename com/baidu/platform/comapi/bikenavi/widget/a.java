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
import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.platform.comapi.wnplatform.o.f;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class a extends com.baidu.platform.comapi.walknavi.g.b.b implements View.OnClickListener {
    private static int F = 135;
    private static int G = 90;
    private TextView A;
    private TextView B;
    private TextView C;
    private TextView D;
    private int E;
    private Activity a;
    private int e;
    private com.baidu.platform.comapi.bikenavi.c.b g;
    private ImageButton h;
    private ImageButton i;
    private LinearLayout j;
    private TextView k;
    private RelativeLayout l;
    private RelativeLayout m;
    private CustomScrollView n;
    private TextView o;
    private View p;
    private TextView q;
    private View r;
    private View s;
    private ImageView t;
    private ImageView u;
    private TextView v;
    private TextView w;
    private TextView x;
    private TextView y;
    private TextView z;
    private final int b = 1;
    private final int c = 2;
    private final int d = 3;
    private boolean f = false;
    private int H = 0;

    public a(Context context, com.baidu.platform.comapi.bikenavi.c.b bVar, View view) {
        this.a = (Activity) context;
        this.g = bVar;
        a(view);
    }

    private void a(View view) {
        this.l = (RelativeLayout) view.findViewById(R.raw.imageviewer_drag);
        this.h = (ImageButton) view.findViewById(R.raw.lottie_pull_refresh);
        this.j = (LinearLayout) view.findViewById(R.raw.lottie_tab_live_1);
        this.k = (TextView) view.findViewById(R.raw.lottie_tab_msg_1);
        this.i = (ImageButton) view.findViewById(R.raw.lottie_tab_home);
        this.o = (TextView) view.findViewById(R.raw.lottie_pull_refresh_1);
        this.p = view.findViewById(R.raw.lottie_photo);
        this.q = (TextView) view.findViewById(R.raw.lottie_tab_msg);
        b(view);
        this.h.setOnClickListener(this);
        this.j.setOnClickListener(this);
        this.k.setOnClickListener(this);
        this.i.setOnClickListener(this);
    }

    public void a(double d, double d2, double d3) {
        this.o.setText(((int) d) + "");
        this.v.setText(d + "");
        this.x.setText(d3 + "");
        this.w.setText(d2 + "");
    }

    public void a(double d, long j) {
        StringBuffer stringBuffer = new StringBuffer();
        com.baidu.platform.comapi.wnplatform.o.f.a((int) d, f.a.ZH, stringBuffer);
        StringBuilder sb = new StringBuilder();
        sb.append("已骑行" + stringBuffer.toString() + " ");
        sb.append(com.baidu.platform.comapi.wnplatform.o.f.a((int) j, 2));
        this.D.setText(sb.toString());
    }

    public void a(float f, float f2, float f3) {
        this.A.setText(f + "");
        this.B.setText(f2 + "");
        this.C.setText(f3 + "");
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

    private void b(View view) {
        this.n = (CustomScrollView) view.findViewById(R.raw.lottie_tab_forum);
        view.post(new b(this));
        this.s = com.baidu.platform.comapi.wnplatform.o.a.a.a(this.a, R.layout.abc_action_menu_item_layout, null);
        this.n.addContentView(this.s);
        this.n.updateStatus(com.baidu.platform.comapi.wnplatform.n.b.BOTTOM, false);
        this.t = (ImageView) this.s.findViewById(R.raw.lottie_agree_1);
        this.u = (ImageView) this.s.findViewById(R.raw.lottie_agree_2);
        this.v = (TextView) this.s.findViewById(R.raw.lottie_candle_1);
        this.w = (TextView) this.s.findViewById(R.raw.lottie_common_pull_refresh);
        this.x = (TextView) this.s.findViewById(R.raw.lottie_common_pull_refresh_1);
        this.y = (TextView) this.s.findViewById(R.raw.lottie_bless);
        this.z = (TextView) this.s.findViewById(R.raw.lottie_bless_1);
        this.A = (TextView) this.s.findViewById(R.raw.lottie_common_pull_refresh_2);
        this.B = (TextView) this.s.findViewById(R.raw.lottie_disagree);
        this.C = (TextView) this.s.findViewById(R.raw.lottie_disagree_1);
        this.D = (TextView) this.s.findViewById(R.raw.lottie_candle);
        this.r = this.s.findViewById(R.raw.lotti_video_loading);
        this.r.setOnClickListener(new c(this));
        this.n.setOnScrollChangeListener(new d(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        if (z) {
            new AsyncTaskC0224a(this.n, true).execute(new Integer[0]);
        } else if (this.H != 0) {
            new AsyncTaskC0224a(this.n, false).execute(new Integer[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        this.n.updateStatus(com.baidu.platform.comapi.wnplatform.n.b.TOP, z);
        this.t.setVisibility(8);
        this.u.setVisibility(0);
        com.baidu.platform.comapi.wnplatform.k.a.a().a("BikeNaviPG.bigDrawer");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z) {
        this.n.updateStatus(com.baidu.platform.comapi.wnplatform.n.b.BOTTOM, z);
        this.t.setVisibility(0);
        this.u.setVisibility(8);
        com.baidu.platform.comapi.wnplatform.k.a.a().a("BikeNaviPG.smallDrawer");
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

    public void a(int i) {
        if (i == R.drawable.aiapps_checkbox_checked) {
            this.h.setImageDrawable(com.baidu.platform.comapi.wnplatform.o.a.a.a(this.a, (int) R.drawable.aiapps_checkbox_checked));
            this.e = 1;
        } else if (i == R.drawable.aiapps_checkbox_normal_disable) {
            this.h.setImageDrawable(com.baidu.platform.comapi.wnplatform.o.a.a.a(this.a, (int) R.drawable.aiapps_checkbox_normal_disable));
            this.e = 2;
        } else if (i == R.drawable.aiapps_checkbox_checked_disable) {
            this.h.setImageDrawable(com.baidu.platform.comapi.wnplatform.o.a.a.a(this.a, (int) R.drawable.aiapps_checkbox_checked_disable));
            this.e = 3;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.platform.comapi.walknavi.g.b.b
    public void a() {
        super.a();
        Animation c = com.baidu.platform.comapi.wnplatform.o.a.a.c(this.a, R.anim.abc_popup_enter);
        if (!this.l.isShown()) {
            this.l.setAnimation(c);
        }
        this.l.setVisibility(0);
        if (this.m != null) {
            if (!this.m.isShown()) {
                this.m.setAnimation(c);
            }
            this.m.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.platform.comapi.walknavi.g.b.b
    public void b() {
        super.b();
        Animation c = com.baidu.platform.comapi.wnplatform.o.a.a.c(this.a, R.anim.abc_popup_exit);
        if (this.l.isShown()) {
            this.l.setAnimation(c);
        }
        this.l.setVisibility(8);
        if (this.m != null) {
            if (this.m.isShown()) {
                this.m.setAnimation(c);
            }
            this.m.setVisibility(8);
        }
    }

    public void a(boolean z) {
        this.f = z;
        if (this.f) {
            this.j.setVisibility(0);
            this.k.setVisibility(8);
            return;
        }
        this.j.setVisibility(8);
        this.k.setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.raw.lottie_pull_refresh) {
            if (!this.f) {
                com.baidu.platform.comapi.wnplatform.k.a.a().a("status", "overview");
            }
            com.baidu.platform.comapi.wnplatform.k.a.a().a("BikeNaviPG.turnDire");
            switch (this.e) {
                case 1:
                    com.baidu.platform.comapi.walknavi.b.a().F().run("[3D车头向上]按钮点击");
                    return;
                case 2:
                    com.baidu.platform.comapi.walknavi.b.a().F().run("[2D正北]按钮点击");
                    return;
                case 3:
                    com.baidu.platform.comapi.walknavi.b.a().F().run("[回车位]按钮点击");
                    return;
                default:
                    return;
            }
        } else if (id == R.raw.lottie_tab_live_1) {
            this.f = this.f ? false : true;
            com.baidu.platform.comapi.wnplatform.k.a.a().a("BikeNaviPG.overview");
            com.baidu.platform.comapi.walknavi.b.a().F().run("[查看全览]按钮点击");
            this.j.setVisibility(8);
            this.k.setVisibility(0);
            this.g.k();
            h();
            this.g.a(this.a, com.baidu.platform.comapi.walknavi.b.a().G().a(), 10, 0, 0, F + 10);
            if (com.baidu.platform.comapi.walknavi.b.a().G().a() != null) {
                com.baidu.platform.comapi.walknavi.b.a().G().a().requestLayout();
            }
        } else if (id == R.raw.lottie_tab_msg_1) {
            this.f = this.f ? false : true;
            com.baidu.platform.comapi.wnplatform.k.a.a().a("BikeNaviPG.continue");
            com.baidu.platform.comapi.walknavi.b.a().F().run("[3D车头向上]按钮点击");
            this.j.setVisibility(0);
            this.k.setVisibility(8);
            com.baidu.platform.comapi.walknavi.segmentbrowse.c.a(com.baidu.platform.comapi.walknavi.segmentbrowse.b.REFRESH_GUIDANCE);
            com.baidu.platform.comapi.walknavi.b.a().D().j();
            g();
            this.g.a(this.a, com.baidu.platform.comapi.walknavi.b.a().G().a(), 70, 0, 0, 60);
            if (com.baidu.platform.comapi.walknavi.b.a().G().a() != null) {
                com.baidu.platform.comapi.walknavi.b.a().G().a().requestLayout();
            }
        } else if (id == R.raw.lottie_tab_home) {
            this.g.a(false, R.string.abc_action_bar_up_description);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.platform.comapi.bikenavi.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class AsyncTaskC0224a extends AsyncTask<Integer, Integer, String> {
        private ScrollView b;
        private boolean c;
        private int d = 15;

        public AsyncTaskC0224a(ScrollView scrollView, boolean z) {
            this.b = scrollView;
            this.c = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public String doInBackground(Integer... numArr) {
            int i = Opcodes.IFEQ;
            int i2 = 0;
            try {
                if (this.c) {
                    while (i2 < 153) {
                        i2 += this.d;
                        publishProgress(Integer.valueOf(i2));
                        Thread.sleep(10L);
                    }
                    return null;
                }
                while (i > 0) {
                    i -= this.d;
                    if (i < 0) {
                        i = 0;
                    }
                    publishProgress(Integer.valueOf(i));
                    Thread.sleep(10L);
                }
                return null;
            } catch (Exception e) {
                return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
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
                this.b.setBackgroundColor(Color.parseColor(str));
                a.this.H = intValue;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

package com.baidu.platform.comapi.bikenavi.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.mapapi.bikenavi.controllers.BNavigatorWrapper;
import com.baidu.mapapi.bikenavi.model.a;
import com.baidu.platform.comapi.wnplatform.p.g;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class a extends com.baidu.platform.comapi.walknavi.g.c.b implements View.OnClickListener {
    private static int F = 135;
    private static int G = 90;
    private TextView A;
    private TextView B;
    private TextView C;
    private TextView D;
    private int E;

    /* renamed from: a  reason: collision with root package name */
    private Activity f2844a;
    private int e;
    private com.baidu.platform.comapi.bikenavi.c.b g;
    private ImageButton h;
    private ImageView i;
    private RelativeLayout j;
    private RelativeLayout k;
    private CustomScrollView l;
    private TextView m;
    private TextView n;
    private LinearLayout o;
    private TextView p;
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
    private boolean I = true;
    private a.b J = null;
    private boolean K = false;
    private a.C0251a L = null;
    private boolean M = false;

    public a(Context context, com.baidu.platform.comapi.bikenavi.c.b bVar, View view) {
        this.f2844a = (Activity) context;
        this.g = bVar;
        a(view);
    }

    private void a(View view) {
        this.h = (ImageButton) view.findViewById(2131165227);
        d(view);
        b(view);
        e(view);
        this.h.setOnClickListener(this);
        this.p.setOnClickListener(new View$OnClickListenerC0279a());
        this.i.setOnClickListener(new com.baidu.platform.comapi.bikenavi.widget.b(this));
        i();
    }

    private void b(View view) {
        if (view != null) {
            this.j = (RelativeLayout) view.findViewById(2131165205);
            BNavigatorWrapper.getWNavigator();
            com.baidu.mapapi.bikenavi.model.b p = com.baidu.platform.comapi.walknavi.b.a().p();
            if (p == null || !p.f()) {
                c(view);
            } else if (!a(p)) {
                c(view);
            }
        }
    }

    private boolean a(com.baidu.mapapi.bikenavi.model.b bVar) {
        if (bVar == null) {
            Log.e("CustomWNaviView", "Load BottomSetting layout failed,BikeNaviDisplayOption is null.");
            return false;
        }
        int e = bVar.e();
        if (e == 0) {
            Log.e("CustomWNaviView", "BottomSetting layout resource is empty.");
            return false;
        } else if (this.j == null) {
            Log.e("CustomWNaviView", "BottomSetting layout add failed.");
            return false;
        } else {
            View inflate = LayoutInflater.from(this.f2844a).inflate(e, (ViewGroup) this.j, false);
            if (inflate == null) {
                Log.e("CustomWNaviView", "Load BottomSetting layout failed,please checking layout.");
                return false;
            } else if (!com.baidu.platform.comapi.walknavi.g.d.d.a().a(this.f2844a, 6, e, this)) {
                Log.e("CustomWNaviView", "Parser BottomSetting layout failed,please checking layout.");
                return false;
            } else if (this.L == null) {
                Log.e("CustomWNaviView", "Parser BottomSetting layout failed,missing other keywords like TAG attribute or ID attribute.");
                return false;
            } else if (TextUtils.isEmpty(this.L.a()) || TextUtils.isEmpty(this.L.b()) || TextUtils.isEmpty(this.L.c())) {
                Log.e("CustomWNaviView", "BottomSetting layout missing other keywords like TAG attribute or ID attribute.");
                return false;
            } else {
                try {
                    this.i = (ImageView) inflate.findViewById(Integer.parseInt(this.L.a().replace(UgcConstant.AT_RULE_TAG, "")));
                    this.p = (TextView) inflate.findViewById(Integer.parseInt(this.L.b().replace(UgcConstant.AT_RULE_TAG, "")));
                    this.q = (TextView) inflate.findViewById(Integer.parseInt(this.L.c().replace(UgcConstant.AT_RULE_TAG, "")));
                    if (this.i == null || this.p == null || this.q == null) {
                        Log.e("CustomWNaviView", "BottomSetting layout control initialize failed,Missing other keywords like TAG attribute or ID attribute.");
                        return false;
                    }
                    this.j.removeAllViews();
                    this.j.addView(inflate);
                    this.M = true;
                    this.j.setBackgroundColor(0);
                    return true;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    Log.e("CustomWNaviView", "BottomSetting layout control type error.");
                    return false;
                }
            }
        }
    }

    private void c(View view) {
        if (view != null) {
            this.i = (ImageView) view.findViewById(2131165234);
            this.p = (TextView) view.findViewById(2131165238);
            this.q = (TextView) view.findViewById(2131165239);
        }
    }

    private void d(View view) {
        if (view != null) {
            this.o = (LinearLayout) view.findViewById(2131165226);
            BNavigatorWrapper.getWNavigator();
            com.baidu.mapapi.bikenavi.model.b p = com.baidu.platform.comapi.walknavi.b.a().p();
            if (p == null || !p.d()) {
                this.m = (TextView) view.findViewById(2131165228);
                this.n = (TextView) view.findViewById(2131165229);
            } else if (!b(p)) {
                this.m = (TextView) view.findViewById(2131165228);
                this.n = (TextView) view.findViewById(2131165229);
            }
        }
    }

    private boolean b(com.baidu.mapapi.bikenavi.model.b bVar) {
        if (bVar == null) {
            Log.e("CustomWNaviView", "Load BikeSpeed layout failed,BikeNaviDisplayOption is null.");
            return false;
        }
        int c = bVar.c();
        if (c == 0) {
            Log.e("CustomWNaviView", "BikeSpeed layout resource is empty.");
            return false;
        } else if (this.o == null) {
            Log.e("CustomWNaviView", "BikeSpeed layout add failed.");
            return false;
        } else {
            View inflate = LayoutInflater.from(this.f2844a).inflate(c, (ViewGroup) this.o, false);
            if (inflate == null) {
                Log.e("CustomWNaviView", "Load BikeSpeed layout failed,please checking layout.");
                return false;
            } else if (!com.baidu.platform.comapi.walknavi.g.d.d.a().a(this.f2844a, 5, c, this)) {
                Log.e("CustomWNaviView", "Parser BikeSpeed layout failed,please checking layout.");
                return false;
            } else if (this.J == null) {
                Log.e("CustomWNaviView", "Parser BikeSpeed layout failed,missing other keywords like TAG attribute or ID attribute.");
                return false;
            } else if (TextUtils.isEmpty(this.J.a()) || TextUtils.isEmpty(this.J.b())) {
                Log.e("CustomWNaviView", "BikeSpeed layout missing other keywords like TAG attribute or ID attribute.");
                return false;
            } else {
                try {
                    this.m = (TextView) inflate.findViewById(Integer.parseInt(this.J.a().replace(UgcConstant.AT_RULE_TAG, "")));
                    this.n = (TextView) inflate.findViewById(Integer.parseInt(this.J.b().replace(UgcConstant.AT_RULE_TAG, "")));
                    if (this.m == null || this.n == null) {
                        Log.e("CustomWNaviView", "BikeSpeed layout control initialize failed,Missing other keywords like TAG attribute or ID attribute.");
                        return false;
                    }
                    this.o.removeAllViews();
                    this.o.addView(inflate);
                    this.K = true;
                    this.o.setBackgroundColor(0);
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.e("CustomWNaviView", "BikeSpeed layout control type error.");
                    return false;
                }
            }
        }
    }

    public void a(double d, double d2, double d3) {
        this.m.setText(((int) d) + "");
        this.v.setText(d + "");
        this.x.setText(d3 + "");
        this.w.setText(d2 + "");
    }

    public void a(double d, long j) {
        StringBuffer stringBuffer = new StringBuffer();
        com.baidu.platform.comapi.wnplatform.p.g.a((int) d, g.b.ZH, stringBuffer);
        StringBuilder sb = new StringBuilder();
        sb.append("已骑行" + stringBuffer.toString() + " ");
        sb.append(com.baidu.platform.comapi.wnplatform.p.g.a((int) j, 2));
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

    private void e(View view) {
        this.l = (CustomScrollView) view.findViewById(2131165233);
        view.post(new c(this));
        this.s = com.baidu.platform.comapi.wnplatform.p.a.a.a(this.f2844a, 2130903044, null);
        this.l.addContentView(this.s);
        this.l.updateStatus(com.baidu.platform.comapi.wnplatform.o.b.BOTTOM, false);
        this.t = (ImageView) this.s.findViewById(2131165208);
        this.u = (ImageView) this.s.findViewById(2131165209);
        this.v = (TextView) this.s.findViewById(2131165213);
        this.w = (TextView) this.s.findViewById(2131165214);
        this.x = (TextView) this.s.findViewById(2131165215);
        this.y = (TextView) this.s.findViewById(2131165210);
        this.z = (TextView) this.s.findViewById(2131165211);
        this.A = (TextView) this.s.findViewById(2131165216);
        this.B = (TextView) this.s.findViewById(2131165217);
        this.C = (TextView) this.s.findViewById(2131165218);
        this.D = (TextView) this.s.findViewById(2131165212);
        this.r = this.s.findViewById(2131165206);
        this.r.setOnClickListener(new d(this));
        this.l.setOnScrollChangeListener(new e(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        if (z) {
            new b(this.l, true).execute(new Integer[0]);
        } else if (this.H != 0) {
            new b(this.l, false).execute(new Integer[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        this.l.updateStatus(com.baidu.platform.comapi.wnplatform.o.b.TOP, z);
        this.t.setVisibility(8);
        this.u.setVisibility(0);
        com.baidu.platform.comapi.wnplatform.l.a.a().a("BikeNaviPG.bigDrawer");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z) {
        this.l.updateStatus(com.baidu.platform.comapi.wnplatform.o.b.BOTTOM, z);
        this.t.setVisibility(0);
        this.u.setVisibility(8);
        com.baidu.platform.comapi.wnplatform.l.a.a().a("BikeNaviPG.smallDrawer");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        this.l.setVisibility(8);
        this.o.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        this.l.setBackgroundColor(Color.parseColor("#00000000"));
        this.H = 0;
        d(false);
        this.l.setVisibility(0);
        this.o.setVisibility(8);
    }

    public void a(int i) {
        if (i == R.drawable.aiapps_keyboard_number_item_selector) {
            this.h.setImageDrawable(com.baidu.platform.comapi.wnplatform.p.a.a.a(this.f2844a, (int) R.drawable.aiapps_keyboard_number_item_selector));
            this.e = 1;
        } else if (i == R.drawable.aiapps_loading_dark_image_view) {
            this.h.setImageDrawable(com.baidu.platform.comapi.wnplatform.p.a.a.a(this.f2844a, (int) R.drawable.aiapps_loading_dark_image_view));
            this.e = 2;
        } else if (i == R.drawable.aiapps_loading) {
            this.h.setImageDrawable(com.baidu.platform.comapi.wnplatform.p.a.a.a(this.f2844a, (int) R.drawable.aiapps_loading));
            this.e = 3;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.platform.comapi.walknavi.g.c.b
    public void a() {
        super.a();
        Animation c = com.baidu.platform.comapi.wnplatform.p.a.a.c(this.f2844a, R.layout.abc_action_menu_layout);
        if (!this.j.isShown()) {
            this.j.setAnimation(c);
        }
        this.j.setVisibility(0);
        if (this.k != null) {
            if (!this.k.isShown()) {
                this.k.setAnimation(c);
            }
            this.k.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.platform.comapi.walknavi.g.c.b
    public void b() {
        super.b();
        Animation c = com.baidu.platform.comapi.wnplatform.p.a.a.c(this.f2844a, R.layout.abc_action_mode_bar);
        if (this.j.isShown()) {
            this.j.setAnimation(c);
        }
        this.j.setVisibility(8);
        if (this.k != null) {
            if (this.k.isShown()) {
                this.k.setAnimation(c);
            }
            this.k.setVisibility(8);
        }
    }

    public void a(boolean z) {
        this.f = z;
        if (this.f) {
            if (this.p != null) {
                this.p.setText("查看全览");
            }
            this.q.setVisibility(0);
            return;
        }
        if (this.p != null) {
            this.p.setText("继续导航");
        }
        this.q.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == 2131165227) {
            if (!this.f) {
                com.baidu.platform.comapi.wnplatform.l.a.a().a("status", "overview");
            }
            com.baidu.platform.comapi.wnplatform.l.a.a().a("BikeNaviPG.turnDire");
            switch (this.e) {
                case 1:
                    com.baidu.platform.comapi.walknavi.b.a().I().run("[3D车头向上]按钮点击");
                    return;
                case 2:
                    com.baidu.platform.comapi.walknavi.b.a().I().run("[2D正北]按钮点击");
                    return;
                case 3:
                    com.baidu.platform.comapi.walknavi.b.a().I().run("[回车位]按钮点击");
                    return;
                default:
                    return;
            }
        }
    }

    public void a(a.b bVar) {
        this.J = bVar;
    }

    public void a(a.C0251a c0251a) {
        this.L = c0251a;
    }

    private void i() {
        BNavigatorWrapper.getWNavigator();
        com.baidu.mapapi.bikenavi.model.b p = com.baidu.platform.comapi.walknavi.b.a().p();
        if (p != null && p.g() != null) {
            if (this.m != null) {
                this.m.setTypeface(p.g());
            }
            if (this.n != null) {
                this.n.setTypeface(p.g());
            }
            if (this.p != null) {
                this.p.setTypeface(p.g());
            }
            if (this.q != null) {
                this.q.setTypeface(p.g());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.platform.comapi.bikenavi.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class View$OnClickListenerC0279a implements View.OnClickListener {
        View$OnClickListenerC0279a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.p) {
                if (a.this.f) {
                    if (a.this.p != null) {
                        a.this.p.setText("继续导航");
                    }
                    a.this.f = a.this.f ? false : true;
                    com.baidu.platform.comapi.wnplatform.l.a.a().a("BikeNaviPG.overview");
                    com.baidu.platform.comapi.walknavi.b.a().I().run("[查看全览]按钮点击");
                    a.this.q.setVisibility(8);
                    a.this.g.k();
                    a.this.h();
                    a.this.g.a(a.this.f2844a, com.baidu.platform.comapi.walknavi.b.a().J().a(), 10, 0, 0, a.F + 10);
                } else {
                    if (a.this.p != null) {
                        a.this.p.setText("查看全览");
                    }
                    a.this.f = a.this.f ? false : true;
                    com.baidu.platform.comapi.wnplatform.l.a.a().a("BikeNaviPG.continue");
                    com.baidu.platform.comapi.walknavi.b.a().I().run("[3D车头向上]按钮点击");
                    a.this.q.setVisibility(0);
                    com.baidu.platform.comapi.walknavi.segmentbrowse.c.a(com.baidu.platform.comapi.walknavi.segmentbrowse.b.REFRESH_GUIDANCE);
                    com.baidu.platform.comapi.walknavi.b.a().G().j();
                    a.this.g();
                    a.this.g.a(a.this.f2844a, com.baidu.platform.comapi.walknavi.b.a().J().a(), 70, 0, 0, 60);
                }
                if (com.baidu.platform.comapi.walknavi.b.a().J().a() != null) {
                    com.baidu.platform.comapi.walknavi.b.a().J().a().requestLayout();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public class b extends AsyncTask<Integer, Integer, String> {
        private ScrollView b;
        private boolean c;
        private int d = 15;

        public b(ScrollView scrollView, boolean z) {
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

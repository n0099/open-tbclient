package com.baidu.poly.widget;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.android.lbspay.view.PayChannelController;
import com.baidu.poly.widget.a;
import com.baidu.poly.widget.coupon.CouponEntranceView;
import com.baidu.poly.widget.coupon.l;
import com.baidu.poly.widget.hostmarket.HostMarketView;
import d.a.a0.a;
import d.a.a0.k.j.a;
import d.a.a0.p.a.a;
import d.a.a0.p.c;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class m extends FrameLayout implements View.OnClickListener {
    public com.baidu.poly.widget.coupon.l A;
    public com.baidu.poly.a.l.c B;
    public Long C;
    public Long D;
    public d.a.a0.k.i.c E;
    public d.a.a0.p.c F;
    public String G;
    public d.a.a0.p.a.a H;
    public boolean I;
    public boolean J;
    public Runnable K;
    public boolean L;
    public boolean M;
    public String N;

    /* renamed from: e  reason: collision with root package name */
    public View f10409e;

    /* renamed from: f  reason: collision with root package name */
    public PolyFrameLayout f10410f;

    /* renamed from: g  reason: collision with root package name */
    public TipView f10411g;

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup f10412h;

    /* renamed from: i  reason: collision with root package name */
    public Bundle f10413i;
    public ProgressButton j;
    public a.b k;
    public o l;
    public o[] m;
    public boolean n;
    public boolean o;
    public int p;
    public l q;
    public Animation r;
    public Animation s;
    public HostMarketView t;
    public TextView u;
    public TextView v;
    public View w;
    public CouponEntranceView x;
    public View y;
    public View z;

    /* loaded from: classes2.dex */
    public class a implements d.a.a0.k.j.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.a0.k.j.a f10414a;

        public a(d.a.a0.k.j.a aVar) {
            this.f10414a = aVar;
        }

        @Override // d.a.a0.k.j.a
        public void a(a.C0498a c0498a) {
            if (c0498a.f39217a == 0) {
                m.this.C = Long.valueOf(c0498a.f39219c);
                m.this.K();
                if (m.this.l != null && m.this.l.P() == 1) {
                    m.this.l.l(c0498a.f39220d);
                }
            }
            this.f10414a.a(c0498a);
            m.this.x.d();
        }
    }

    /* loaded from: classes2.dex */
    public class b extends d.a.a0.k.a.a<JSONObject> {
        public b() {
        }

        @Override // d.a.a0.k.a.a
        public void b(Throwable th, String str) {
            if (m.this.m != null) {
                return;
            }
            m mVar = m.this;
            mVar.b0(mVar.getResources().getString(d.a.a0.h.common_error_tips));
            m.this.g0(3, "request channel list fail");
            m.this.H();
            d.a.a0.k.h.b bVar = new d.a.a0.k.h.b("1");
            bVar.c(new com.baidu.poly.a.i.a("gatewaylist error --> " + str, th).U());
            d.a.a0.k.h.d.b(bVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.a0.k.a.a
        /* renamed from: c */
        public void a(JSONObject jSONObject) {
            m.this.C = Long.valueOf(jSONObject.optLong("payMoney"));
            JSONArray optJSONArray = jSONObject.optJSONArray("payChannels");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                o[] oVarArr = new o[optJSONArray.length()];
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    o oVar = new o(optJSONArray.optJSONObject(i2));
                    if (oVar.P() == 1) {
                        m.this.N = oVar.R();
                    }
                    oVarArr[i2] = oVar;
                }
                m.this.m = oVarArr;
                JSONArray optJSONArray2 = jSONObject.optJSONArray("coupons");
                m.this.H = new d.a.a0.p.a.a(optJSONArray2);
                m.this.x.b(m.this.H);
                if (m.this.A != null) {
                    m.this.A.g(m.this.H.f39236b);
                }
                JSONArray optJSONArray3 = jSONObject.optJSONArray("marketChannels");
                if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                    m.this.l = new o(optJSONArray3.optJSONObject(0));
                }
                d.a.a0.k.h.a.g("7");
                if (m.this.m.length != 1 || m.this.x.getVisibility() != 8 || m.this.l != null || m.this.m[0] == null) {
                    m.this.K();
                    if (m.this.l != null || m.this.x.getVisibility() != 8) {
                        m.this.w.setVisibility(0);
                    } else {
                        m.this.w.setVisibility(8);
                    }
                    m.this.y();
                    m mVar = m.this;
                    o[] oVarArr2 = mVar.m;
                    mVar.p(oVarArr2);
                    mVar.v(oVarArr2);
                    m.this.f10411g.d();
                    m.this.M();
                    m.this.M = true;
                    m.this.W();
                    return;
                }
                m.this.M = true;
                m.this.W();
                TipView tipView = m.this.f10411g;
                String Q = m.this.m[0].Q();
                tipView.b(Q, "即将进入" + m.this.m[0].getDisplayName() + "…");
                m mVar2 = m.this;
                mVar2.u(mVar2.m[0]);
                return;
            }
            d.a.a0.k.h.a.d("7", null, null);
            b(new com.baidu.poly.a.i.b("channelList is null"), "request channelList payChannels is null");
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            m.this.T();
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Animation.AnimationListener {
        public d() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            m.this.L = true;
            m.this.W();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes2.dex */
    public class e implements HostMarketView.a {
        public e() {
        }

        @Override // com.baidu.poly.widget.hostmarket.HostMarketView.a
        public void a(boolean z, o oVar, d.a.a0.k.j.a aVar) {
            m.this.f10410f.a(true);
            m mVar = m.this;
            mVar.postDelayed(mVar.K, 500L);
            if (oVar == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            if (z) {
                arrayList.add(oVar.O());
            }
            if (m.this.x.getSelectedItem() != null) {
                arrayList.add(m.this.x.getSelectedItem().f39244h);
            }
            m.this.n(arrayList, aVar);
        }

        @Override // com.baidu.poly.widget.hostmarket.HostMarketView.a
        public void b(a.C0498a c0498a) {
            m.this.f10410f.a(false);
            m mVar = m.this;
            mVar.removeCallbacks(mVar.K);
            m.this.I();
        }
    }

    /* loaded from: classes2.dex */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.getParent() instanceof ViewGroup) {
                m mVar = m.this;
                mVar.startAnimation(mVar.s);
                ((ViewGroup) m.this.getParent()).removeView(m.this);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            m.this.q();
        }
    }

    /* loaded from: classes2.dex */
    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (m.this.F == null || !m.this.F.u()) {
                return;
            }
            m.this.F.q();
        }
    }

    /* loaded from: classes2.dex */
    public class i implements c.b {
        public i() {
        }

        @Override // d.a.a0.p.c.b
        public void onDismiss() {
            m.this.q();
        }
    }

    /* loaded from: classes2.dex */
    public class j implements a.InterfaceC0133a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ o[] f10424a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ o f10425b;

        public j(o[] oVarArr, o oVar) {
            this.f10424a = oVarArr;
            this.f10425b = oVar;
        }

        @Override // com.baidu.poly.widget.a.InterfaceC0133a
        public void a() {
            o[] oVarArr = this.f10424a;
            int length = oVarArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                o oVar = oVarArr[i2];
                oVar.i(oVar == this.f10425b ? 1 : 0);
            }
            m.this.v(this.f10424a);
        }
    }

    /* loaded from: classes2.dex */
    public class k implements l.h {
        public k() {
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void a(a.C0501a c0501a, d.a.a0.k.j.a aVar) {
            if (c0501a == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(c0501a.f39244h);
            if (m.this.l != null && m.this.l.P() == 1) {
                arrayList.add(m.this.l.O());
            }
            m.this.n(arrayList, aVar);
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void b() {
            m.this.P();
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void d() {
            if (m.this.A == null) {
                return;
            }
            m.this.A.k(m.this.f10410f);
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void onDetach() {
            m.this.A = null;
        }
    }

    /* loaded from: classes2.dex */
    public interface l {
        void onClose();
    }

    public m(PolyActivity polyActivity) {
        super(polyActivity);
        this.I = true;
        this.J = false;
        this.K = new c();
        this.L = false;
        this.M = false;
        B();
    }

    public final void B() {
        this.r = AnimationUtils.loadAnimation(getContext(), d.a.a0.b.slide_in_bottom);
        this.s = AnimationUtils.loadAnimation(getContext(), d.a.a0.b.slide_out_bottom);
        LayoutInflater.from(getContext()).inflate(d.a.a0.g.view_channel_list, this);
        this.f10409e = findViewById(d.a.a0.f.bg_view);
        this.f10410f = (PolyFrameLayout) findViewById(d.a.a0.f.popup_view);
        this.y = findViewById(d.a.a0.f.pay_money_layout);
        this.z = findViewById(d.a.a0.f.channel_list_scroll_view);
        this.f10411g = (TipView) findViewById(d.a.a0.f.tip_view);
        this.f10412h = (ViewGroup) findViewById(d.a.a0.f.channel_list_view);
        this.j = (ProgressButton) findViewById(d.a.a0.f.pay_button);
        this.w = findViewById(d.a.a0.f.line);
        findViewById(d.a.a0.f.close_button).setOnClickListener(this);
        this.j.setOnClickListener(this);
        this.t = (HostMarketView) findViewById(d.a.a0.f.hostmarket);
        CouponEntranceView couponEntranceView = (CouponEntranceView) findViewById(d.a.a0.f.coupon);
        this.x = couponEntranceView;
        couponEntranceView.setOnClickListener(this);
        this.u = (TextView) findViewById(d.a.a0.f.money);
        this.v = (TextView) findViewById(d.a.a0.f.cut);
    }

    public final void G() {
        List<a.C0501a> list;
        d.a.a0.p.a.a aVar = this.H;
        if (aVar == null || (list = aVar.f39236b) == null || list.size() <= 0) {
            return;
        }
        com.baidu.poly.widget.coupon.l lVar = new com.baidu.poly.widget.coupon.l(getContext());
        this.A = lVar;
        lVar.c(this.f10410f.getMeasuredHeight());
        this.A.setListener(new k());
        this.A.g(this.H.f39236b);
        this.A.d(this.f10410f);
    }

    public void H() {
        if (this.n) {
            this.n = false;
            this.f10409e.animate().alpha(0.0f).setDuration(240L).start();
            postDelayed(new f(), 240L);
            postDelayed(new g(), 480L);
        }
    }

    public void I() {
        d.a.a0.k.k.a.c(this.B);
        this.B = null;
    }

    public final void K() {
        Long l2;
        Long l3 = this.D;
        if (l3 == null || (l2 = this.C) == null) {
            return;
        }
        if (l3.equals(l2)) {
            this.u.setText(e(this.C.longValue()));
            this.v.setVisibility(8);
        } else {
            this.v.setVisibility(0);
            this.u.setText(e(this.C.longValue()));
            TextView textView = this.v;
            textView.setText(" ¥" + e(this.D.longValue()));
        }
        if (this.y.getVisibility() != 0) {
            this.y.setVisibility(0);
        }
    }

    public final void M() {
        if (this.p <= 0) {
            this.j.setVisibility(4);
            return;
        }
        this.j.setVisibility(0);
        this.j.setEnable(true);
    }

    public m O() {
        if (!this.n) {
            this.n = true;
            if (getContext() instanceof Activity) {
                this.f10411g.a("收银台加载中...");
                d.a.a0.n.d.e("ChannelListView->attach()");
                R();
            } else {
                throw new IllegalStateException("can not attach to context " + getContext());
            }
        }
        return this;
    }

    public final void P() {
        d.a.a0.k.b.b.j().c(this.f10413i, new b());
    }

    public final void R() {
        this.f10409e.setVisibility(0);
        this.f10410f.setVisibility(0);
        this.f10409e.setAlpha(0.0f);
        this.f10409e.animate().alpha(0.65f).setDuration(240L).start();
        this.f10410f.startAnimation(this.r);
        this.r.setAnimationListener(new d());
        M();
    }

    public final void T() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.B = d.a.a0.k.k.a.a(this.f10410f, layoutParams, "加载中", -1L);
    }

    public final void W() {
        if (this.L && this.M) {
            d.a.a0.k.h.a.b();
        }
    }

    public final void b0(String str) {
        if (TextUtils.isEmpty(str)) {
            str = getResources().getString(d.a.a0.h.common_error_tips);
        }
        if (this.F == null) {
            View inflate = View.inflate(this.f10412h.getContext(), d.a.a0.g.default_pop_window, null);
            ((TextView) inflate.findViewById(d.a.a0.f.pop_title)).setText("支付失败");
            ((TextView) inflate.findViewById(d.a.a0.f.pop_tips)).setText(str.trim());
            d.a.a0.p.c cVar = new d.a.a0.p.c(inflate, -1, -1, true);
            this.F = cVar;
            cVar.y(false);
            this.F.C(false);
            this.F.x(new ColorDrawable(0));
            ((TextView) inflate.findViewById(d.a.a0.f.pop_button)).setOnClickListener(new h());
            this.F.h(new i());
        }
        PolyActivity polyActivity = (PolyActivity) getContext();
        if (polyActivity.isFinishing()) {
            return;
        }
        this.F.E(polyActivity.getWindow().getDecorView(), 0, 0, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.o || super.dispatchTouchEvent(motionEvent);
    }

    public final String e(long j2) {
        return new DecimalFormat("0.00").format((j2 * 1.0d) / 100.0d);
    }

    public final void e0(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("default", this.N);
            jSONObject.put("selected", str);
        } catch (JSONException unused) {
        }
        d.a.a0.k.h.b bVar = new d.a.a0.k.h.b("5");
        bVar.b(jSONObject);
        d.a.a0.k.h.d.b(bVar);
    }

    public boolean f0() {
        com.baidu.poly.widget.coupon.l lVar = this.A;
        if (lVar != null) {
            lVar.t();
            return true;
        } else if (this.o) {
            return true;
        } else {
            if (this.n) {
                g0(2, d.a.a0.n.b.a(2, null, "key_back_cancel"));
                H();
                return true;
            }
            return false;
        }
    }

    public void g(int i2, String str) {
        d.a.a0.n.d.e("ChannelListView->payEnd()");
        g0(i2, str);
        setIsPreparePaying(false);
    }

    public void g0(int i2, String str) {
        d.a.a0.n.d.e("ChannelListView->onResult() statusCode = " + i2 + " result = " + str);
        this.I = true;
        a.b bVar = this.k;
        if (bVar != null) {
            bVar.a(i2, str);
            this.k = null;
        }
        d.a.a0.k.h.d.e(i2, str);
        if (((PolyActivity) getContext()).isFinishing()) {
            d.a.a0.k.h.d.j();
        }
        q();
    }

    public void h(Bundle bundle) {
        if (bundle != null) {
            try {
                String string = bundle.getString("totalAmount");
                if (TextUtils.isEmpty(string)) {
                    this.D = -1L;
                } else {
                    this.D = Long.valueOf(Long.parseLong(string));
                }
            } catch (Exception unused) {
                d.a.a0.n.d.e("totalAmount is not long");
            }
        }
        this.f10413i = bundle;
        P();
    }

    public void i(Bundle bundle, String str) {
        this.G = str;
        if (this.E != null) {
            this.o = true;
            this.I = false;
            d.a.a0.k.h.a.e(Long.valueOf(System.currentTimeMillis()));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            this.B = d.a.a0.k.k.a.a(this, layoutParams, getResources().getString(d.a.a0.h.poly_fast_pay_loading), -1L);
            this.E.c(bundle, str, this);
        }
    }

    public void m(String str, String str2) {
        d.a.a0.n.d.e("ChannelListView->errorEnd()");
        I();
        if (!TextUtils.isEmpty(str2)) {
            b0(str2);
        } else {
            b0(getResources().getString(d.a.a0.h.common_error_tips));
        }
        g0(3, str);
        setIsPreparePaying(false);
    }

    public final void n(List<String> list, d.a.a0.k.j.a aVar) {
        if (aVar == null) {
            return;
        }
        String string = this.f10413i.getString("bduss");
        String string2 = this.f10413i.getString("appKey");
        d.a.a0.k.j.b.a(string, string2, this.D + "", list, new a(aVar));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d.a.a0.f.close_button) {
            g0(2, "主动取消支付");
            H();
            d.a.a0.k.h.d.b(new d.a.a0.k.h.b("6"));
        } else if (view.getId() == d.a.a0.f.pay_button) {
            if (this.p == 0) {
                return;
            }
            this.j.b();
            this.o = true;
            int i2 = 0;
            this.I = false;
            o oVar = null;
            o[] oVarArr = this.m;
            int length = oVarArr.length;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                o oVar2 = oVarArr[i2];
                if (oVar2.P() == 1) {
                    oVar = oVar2;
                    break;
                }
                i2++;
            }
            if (oVar != null) {
                u(oVar);
                e0(oVar.R());
            }
        } else if (view.getId() == d.a.a0.f.coupon) {
            G();
        }
    }

    public final o[] p(o[] oVarArr) {
        int i2 = 0;
        for (o oVar : oVarArr) {
            if (oVar.P() == 1 && (i2 = i2 + 1) > 1) {
                oVar.i(0);
            }
            if (oVar.N() == 1) {
                this.p++;
            }
        }
        if (i2 == 0) {
            for (o oVar2 : oVarArr) {
                if (oVar2.N() == 1) {
                    oVar2.i(1);
                    return oVarArr;
                }
            }
        }
        return oVarArr;
    }

    public final void q() {
        d.a.a0.p.c cVar = this.F;
        boolean z = ((cVar != null && cVar.u()) || this.o || this.n) ? false : true;
        if ((!TextUtils.isEmpty(this.G) && (TextUtils.equals(this.G, PayChannelController.ALIPAY_PAYCHANNEL) || TextUtils.equals(this.G, "BAIDU-ALIPAY-WISE-HUABEI-PAY"))) || this.J) {
            d.a.a0.n.d.e("ChannelListView->confirmViewClose() ali pay channel");
            z &= this.I;
        }
        d.a.a0.n.d.e("ChannelListView->confirmViewClose() canFinishActivity = " + z);
        if (!z || this.q == null) {
            return;
        }
        d.a.a0.n.d.e("ChannelListView->confirmViewClose() finish activity");
        this.q.onClose();
        this.q = null;
    }

    public void setCloseListener(l lVar) {
        this.q = lVar;
    }

    public void setIsPreparePaying(boolean z) {
        this.o = z;
        q();
        H();
    }

    public void setResultListener(a.b bVar) {
        this.k = bVar;
    }

    public void setWalletList(d.a.a0.k.i.c cVar) {
        this.E = cVar;
    }

    public void setWechatH5Pay(boolean z) {
        this.J = z;
    }

    public final void u(o oVar) {
        if (oVar == null) {
            return;
        }
        d.a.a0.k.h.a.e(Long.valueOf(System.currentTimeMillis()));
        JSONArray jSONArray = new JSONArray();
        try {
            if (this.l != null && this.l.P() == 1 && !TextUtils.isEmpty(this.l.O())) {
                jSONArray.put(new JSONObject(this.l.O()));
            }
            if (this.x.getSelectedItem() != null && !TextUtils.isEmpty(this.x.getSelectedItem().f39244h)) {
                jSONArray.put(new JSONObject(this.x.getSelectedItem().f39244h));
            }
        } catch (Exception unused) {
        }
        if (jSONArray.length() > 0) {
            this.f10413i.putString("hostMarketingDetail", jSONArray.toString());
        }
        if (this.E != null) {
            this.G = oVar.R();
            this.E.c(this.f10413i, oVar.R(), this);
        }
    }

    public final void v(o[] oVarArr) {
        this.z.setMinimumHeight(0);
        if (oVarArr != null) {
            this.f10412h.removeAllViews();
            for (o oVar : oVarArr) {
                com.baidu.poly.widget.a aVar = new com.baidu.poly.widget.a(getContext());
                aVar.a(oVar, new j(oVarArr, oVar));
                this.f10412h.addView(aVar);
            }
        }
    }

    public final void y() {
        this.t.d(this.l);
        this.t.setListener(new e());
    }
}

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
import d.a.c0.a;
import d.a.c0.k.j.a;
import d.a.c0.p.a.a;
import d.a.c0.p.c;
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
    public d.a.c0.k.i.c E;
    public d.a.c0.p.c F;
    public String G;
    public d.a.c0.p.a.a H;
    public boolean I;
    public boolean J;
    public Runnable K;
    public boolean L;
    public boolean M;
    public String N;
    public boolean O;

    /* renamed from: e  reason: collision with root package name */
    public View f9346e;

    /* renamed from: f  reason: collision with root package name */
    public PolyFrameLayout f9347f;

    /* renamed from: g  reason: collision with root package name */
    public TipView f9348g;

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup f9349h;

    /* renamed from: i  reason: collision with root package name */
    public Bundle f9350i;
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
    public class a implements d.a.c0.k.j.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.c0.k.j.a f9351a;

        public a(d.a.c0.k.j.a aVar) {
            this.f9351a = aVar;
        }

        @Override // d.a.c0.k.j.a
        public void a(a.C0511a c0511a) {
            if (c0511a.f39482a == 0) {
                m.this.C = Long.valueOf(c0511a.f39484c);
                m.this.M();
                if (m.this.l != null && m.this.l.P() == 1) {
                    m.this.l.l(c0511a.f39485d);
                }
            }
            this.f9351a.a(c0511a);
            m.this.x.d();
        }
    }

    /* loaded from: classes2.dex */
    public class b extends d.a.c0.k.a.a<JSONObject> {
        public b() {
        }

        @Override // d.a.c0.k.a.a
        public void b(Throwable th, String str) {
            if (m.this.m != null) {
                return;
            }
            m mVar = m.this;
            mVar.d0(mVar.getResources().getString(d.a.c0.h.common_error_tips));
            m.this.h0(3, "request channel list fail");
            m.this.H();
            d.a.c0.k.h.b bVar = new d.a.c0.k.h.b("1");
            bVar.c(new com.baidu.poly.a.i.a("gatewaylist error --> " + str, th).U());
            d.a.c0.k.h.d.b(bVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c0.k.a.a
        /* renamed from: c */
        public void a(JSONObject jSONObject) {
            d.a.c0.n.d.e("requestChannelList onSuccess");
            Long valueOf = Long.valueOf(jSONObject.optLong("payMoney"));
            String optString = jSONObject.optString("showTotalAmount", "1");
            m.this.O = optString.equals("1");
            m.this.C = valueOf;
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
                m.this.H = new d.a.c0.p.a.a(optJSONArray2);
                m.this.x.b(m.this.H);
                if (m.this.A != null) {
                    m.this.A.g(m.this.H.f39501b);
                }
                d.a.c0.n.d.e("渲染coupon结束");
                JSONArray optJSONArray3 = jSONObject.optJSONArray("marketChannels");
                if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                    m.this.l = new o(optJSONArray3.optJSONObject(0));
                }
                d.a.c0.n.d.e("渲染hostMark结束");
                d.a.c0.k.h.a.g("7");
                if (m.this.m.length != 1 || m.this.x.getVisibility() != 8 || m.this.l != null || m.this.m[0] == null) {
                    m.this.M();
                    if (m.this.l != null || m.this.x.getVisibility() != 8) {
                        m.this.w.setVisibility(0);
                    } else {
                        m.this.w.setVisibility(8);
                    }
                    m.this.B();
                    d.a.c0.n.d.e("渲染宿主营销结束");
                    m mVar = m.this;
                    o[] oVarArr2 = mVar.m;
                    mVar.p(oVarArr2);
                    mVar.u(oVarArr2);
                    d.a.c0.n.d.e("渲染支付渠道结束");
                    m.this.f9348g.d();
                    d.a.c0.n.d.e("隐藏loading状态");
                    m.this.P();
                    m.this.M = true;
                    m.this.Y();
                    return;
                }
                m.this.M = true;
                m.this.Y();
                TipView tipView = m.this.f9348g;
                String Q = m.this.m[0].Q();
                tipView.b(Q, "即将进入" + m.this.m[0].getDisplayName() + "…");
                m mVar2 = m.this;
                mVar2.t(mVar2.m[0]);
                d.a.c0.n.d.e("单渠道支付");
                return;
            }
            d.a.c0.k.h.a.d("7", null, null);
            b(new com.baidu.poly.a.i.b("channelList is null"), "request channelList payChannels is null");
            d.a.c0.n.d.e("requestChannelList channelList is null");
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            m.this.W();
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Animation.AnimationListener {
        public d() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            m.this.L = true;
            m.this.Y();
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
        public void a(boolean z, o oVar, d.a.c0.k.j.a aVar) {
            m.this.f9347f.a(true);
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
                arrayList.add(m.this.x.getSelectedItem().f39509h);
            }
            m.this.n(arrayList, aVar);
        }

        @Override // com.baidu.poly.widget.hostmarket.HostMarketView.a
        public void b(a.C0511a c0511a) {
            m.this.f9347f.a(false);
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
            m.this.x();
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

        @Override // d.a.c0.p.c.b
        public void onDismiss() {
            m.this.x();
        }
    }

    /* loaded from: classes2.dex */
    public class j implements a.InterfaceC0119a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ o[] f9361a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ o f9362b;

        public j(o[] oVarArr, o oVar) {
            this.f9361a = oVarArr;
            this.f9362b = oVar;
        }

        @Override // com.baidu.poly.widget.a.InterfaceC0119a
        public void a() {
            o[] oVarArr = this.f9361a;
            int length = oVarArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                o oVar = oVarArr[i2];
                oVar.i(oVar == this.f9362b ? 1 : 0);
            }
            m.this.u(this.f9361a);
        }
    }

    /* loaded from: classes2.dex */
    public class k implements l.h {
        public k() {
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void a(a.C0514a c0514a, d.a.c0.k.j.a aVar) {
            if (c0514a == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(c0514a.f39509h);
            if (m.this.l != null && m.this.l.P() == 1) {
                arrayList.add(m.this.l.O());
            }
            m.this.n(arrayList, aVar);
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void b() {
            m.this.R();
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void d() {
            if (m.this.A == null) {
                return;
            }
            m.this.A.k(m.this.f9347f);
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
        this.O = true;
        G();
    }

    public final void B() {
        this.t.d(this.l);
        this.t.setListener(new e());
    }

    public final void G() {
        this.r = AnimationUtils.loadAnimation(getContext(), d.a.c0.b.slide_in_bottom);
        this.s = AnimationUtils.loadAnimation(getContext(), d.a.c0.b.slide_out_bottom);
        LayoutInflater.from(getContext()).inflate(d.a.c0.g.view_channel_list, this);
        this.f9346e = findViewById(d.a.c0.f.bg_view);
        this.f9347f = (PolyFrameLayout) findViewById(d.a.c0.f.popup_view);
        this.y = findViewById(d.a.c0.f.pay_money_layout);
        this.z = findViewById(d.a.c0.f.channel_list_scroll_view);
        this.f9348g = (TipView) findViewById(d.a.c0.f.tip_view);
        this.f9349h = (ViewGroup) findViewById(d.a.c0.f.channel_list_view);
        this.j = (ProgressButton) findViewById(d.a.c0.f.pay_button);
        this.w = findViewById(d.a.c0.f.line);
        findViewById(d.a.c0.f.close_button).setOnClickListener(this);
        this.j.setOnClickListener(this);
        this.t = (HostMarketView) findViewById(d.a.c0.f.hostmarket);
        CouponEntranceView couponEntranceView = (CouponEntranceView) findViewById(d.a.c0.f.coupon);
        this.x = couponEntranceView;
        couponEntranceView.setOnClickListener(this);
        this.u = (TextView) findViewById(d.a.c0.f.money);
        this.v = (TextView) findViewById(d.a.c0.f.cut);
    }

    public void H() {
        if (this.n) {
            this.n = false;
            this.f9346e.animate().alpha(0.0f).setDuration(240L).start();
            postDelayed(new f(), 240L);
            postDelayed(new g(), 480L);
        }
    }

    public void I() {
        d.a.c0.k.k.a.c(this.B);
        this.B = null;
    }

    public final void K() {
        List<a.C0514a> list;
        d.a.c0.p.a.a aVar = this.H;
        if (aVar == null || (list = aVar.f39501b) == null || list.size() <= 0) {
            return;
        }
        com.baidu.poly.widget.coupon.l lVar = new com.baidu.poly.widget.coupon.l(getContext());
        this.A = lVar;
        lVar.c(this.f9347f.getMeasuredHeight());
        this.A.setListener(new k());
        this.A.g(this.H.f39501b);
        this.A.d(this.f9347f);
    }

    public final void M() {
        Long l2;
        Long l3 = this.D;
        if (l3 == null || (l2 = this.C) == null) {
            return;
        }
        if (l3.equals(l2)) {
            this.u.setText(e(this.C.longValue()));
            this.v.setVisibility(8);
        } else {
            if (this.O) {
                this.v.setVisibility(0);
            }
            this.u.setText(e(this.C.longValue()));
            TextView textView = this.v;
            textView.setText(" ¥" + e(this.D.longValue()));
        }
        if (this.y.getVisibility() != 0) {
            this.y.setVisibility(0);
        }
    }

    public m O() {
        if (!this.n) {
            this.n = true;
            if (getContext() instanceof Activity) {
                this.f9348g.a("收银台加载中...");
                d.a.c0.n.d.e("ChannelListView->attach()");
                T();
            } else {
                throw new IllegalStateException("can not attach to context " + getContext());
            }
        }
        return this;
    }

    public final void P() {
        if (this.p <= 0) {
            this.j.setVisibility(4);
            return;
        }
        this.j.setVisibility(0);
        this.j.setEnable(true);
    }

    public final void R() {
        d.a.c0.n.d.e("requestChannelList start");
        d.a.c0.k.b.b.j().c(this.f9350i, new b());
    }

    public final void T() {
        this.f9346e.setVisibility(0);
        this.f9347f.setVisibility(0);
        this.f9346e.setAlpha(0.0f);
        this.f9346e.animate().alpha(0.65f).setDuration(240L).start();
        this.f9347f.startAnimation(this.r);
        this.r.setAnimationListener(new d());
        P();
    }

    public final void W() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.B = d.a.c0.k.k.a.a(this.f9347f, layoutParams, "加载中", -1L);
    }

    public final void Y() {
        if (this.L && this.M) {
            d.a.c0.k.h.a.b();
        }
    }

    public final void d0(String str) {
        if (TextUtils.isEmpty(str)) {
            str = getResources().getString(d.a.c0.h.common_error_tips);
        }
        if (this.F == null) {
            View inflate = View.inflate(this.f9349h.getContext(), d.a.c0.g.default_pop_window, null);
            ((TextView) inflate.findViewById(d.a.c0.f.pop_title)).setText("支付失败");
            ((TextView) inflate.findViewById(d.a.c0.f.pop_tips)).setText(str.trim());
            d.a.c0.p.c cVar = new d.a.c0.p.c(inflate, -1, -1, true);
            this.F = cVar;
            cVar.y(false);
            this.F.C(false);
            this.F.x(new ColorDrawable(0));
            ((TextView) inflate.findViewById(d.a.c0.f.pop_button)).setOnClickListener(new h());
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

    public final void f0(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("default", this.N);
            jSONObject.put("selected", str);
        } catch (JSONException unused) {
        }
        d.a.c0.k.h.b bVar = new d.a.c0.k.h.b("5");
        bVar.b(jSONObject);
        d.a.c0.k.h.d.b(bVar);
    }

    public void g(int i2, String str) {
        d.a.c0.n.d.e("ChannelListView->payEnd()");
        h0(i2, str);
        setIsPreparePaying(false);
    }

    public boolean g0() {
        com.baidu.poly.widget.coupon.l lVar = this.A;
        if (lVar != null) {
            lVar.t();
            return true;
        } else if (this.o) {
            return true;
        } else {
            if (this.n) {
                h0(2, d.a.c0.n.b.a(2, null, "key_back_cancel"));
                H();
                return true;
            }
            return false;
        }
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
                d.a.c0.n.d.e("totalAmount is not long");
            }
        }
        this.f9350i = bundle;
        R();
    }

    public void h0(int i2, String str) {
        d.a.c0.n.d.e("ChannelListView->onResult() statusCode = " + i2 + " result = " + str);
        this.I = true;
        a.b bVar = this.k;
        if (bVar != null) {
            bVar.a(i2, str);
            this.k = null;
        }
        d.a.c0.k.h.d.e(i2, str);
        if (((PolyActivity) getContext()).isFinishing()) {
            d.a.c0.k.h.d.j();
        }
        x();
    }

    public void i(Bundle bundle, String str) {
        this.G = str;
        if (this.E != null) {
            this.o = true;
            this.I = false;
            d.a.c0.k.h.a.e(Long.valueOf(System.currentTimeMillis()));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            this.B = d.a.c0.k.k.a.a(this, layoutParams, getResources().getString(d.a.c0.h.poly_fast_pay_loading), -1L);
            this.E.c(bundle, str, this);
        }
    }

    public void m(String str, String str2) {
        d.a.c0.n.d.e("ChannelListView->errorEnd()");
        I();
        if (!TextUtils.isEmpty(str2)) {
            d0(str2);
        } else {
            d0(getResources().getString(d.a.c0.h.common_error_tips));
        }
        h0(3, str);
        setIsPreparePaying(false);
    }

    public final void n(List<String> list, d.a.c0.k.j.a aVar) {
        if (aVar == null) {
            return;
        }
        String string = this.f9350i.getString("bduss");
        String string2 = this.f9350i.getString("appKey");
        d.a.c0.k.j.b.a(string, string2, this.D + "", list, new a(aVar));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d.a.c0.f.close_button) {
            h0(2, "主动取消支付");
            H();
            d.a.c0.k.h.d.b(new d.a.c0.k.h.b("6"));
        } else if (view.getId() == d.a.c0.f.pay_button) {
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
                t(oVar);
                f0(oVar.R());
            }
        } else if (view.getId() == d.a.c0.f.coupon) {
            K();
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

    public void setCloseListener(l lVar) {
        this.q = lVar;
    }

    public void setIsPreparePaying(boolean z) {
        this.o = z;
        x();
        H();
    }

    public void setResultListener(a.b bVar) {
        this.k = bVar;
    }

    public void setWalletList(d.a.c0.k.i.c cVar) {
        this.E = cVar;
    }

    public void setWechatH5Pay(boolean z) {
        this.J = z;
    }

    public final void t(o oVar) {
        if (oVar == null) {
            return;
        }
        d.a.c0.k.h.a.e(Long.valueOf(System.currentTimeMillis()));
        JSONArray jSONArray = new JSONArray();
        try {
            if (this.l != null && this.l.P() == 1 && !TextUtils.isEmpty(this.l.O())) {
                jSONArray.put(new JSONObject(this.l.O()));
            }
            if (this.x.getSelectedItem() != null && !TextUtils.isEmpty(this.x.getSelectedItem().f39509h)) {
                jSONArray.put(new JSONObject(this.x.getSelectedItem().f39509h));
            }
        } catch (Exception unused) {
        }
        if (jSONArray.length() > 0) {
            this.f9350i.putString("hostMarketingDetail", jSONArray.toString());
        }
        if (this.E != null) {
            this.G = oVar.R();
            this.E.c(this.f9350i, oVar.R(), this);
        }
    }

    public final void u(o[] oVarArr) {
        this.z.setMinimumHeight(0);
        if (oVarArr != null) {
            this.f9349h.removeAllViews();
            for (o oVar : oVarArr) {
                com.baidu.poly.widget.a aVar = new com.baidu.poly.widget.a(getContext());
                aVar.a(oVar, new j(oVarArr, oVar));
                this.f9349h.addView(aVar);
            }
        }
    }

    public final void x() {
        d.a.c0.p.c cVar = this.F;
        boolean z = ((cVar != null && cVar.u()) || this.o || this.n) ? false : true;
        if ((!TextUtils.isEmpty(this.G) && (TextUtils.equals(this.G, PayChannelController.ALIPAY_PAYCHANNEL) || TextUtils.equals(this.G, "BAIDU-ALIPAY-WISE-HUABEI-PAY"))) || this.J) {
            d.a.c0.n.d.e("ChannelListView->confirmViewClose() ali pay channel");
            z &= this.I;
        }
        d.a.c0.n.d.e("ChannelListView->confirmViewClose() canFinishActivity = " + z);
        if (!z || this.q == null) {
            return;
        }
        d.a.c0.n.d.e("ChannelListView->confirmViewClose() finish activity");
        this.q.onClose();
        this.q = null;
    }
}

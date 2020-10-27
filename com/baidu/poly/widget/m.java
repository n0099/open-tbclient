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
import com.baidu.poly.a;
import com.baidu.poly.a.k.a;
import com.baidu.poly.b;
import com.baidu.poly.widget.a;
import com.baidu.poly.widget.c;
import com.baidu.poly.widget.coupon.CouponEntranceView;
import com.baidu.poly.widget.coupon.a;
import com.baidu.poly.widget.coupon.l;
import com.baidu.poly.widget.hostmarket.HostMarketView;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class m extends FrameLayout implements View.OnClickListener {
    private boolean G;
    private boolean H;
    private int I;
    private TextView S;
    private TextView U;
    private a.b bXZ;
    private Bundle bYc;
    private com.baidu.poly.a.l.c bZN;
    private Runnable bZP;
    private com.baidu.poly.widget.coupon.a bZs;
    private View caa;
    private PolyFrameLayout cab;
    private TipView cac;
    private ViewGroup cad;
    private ProgressButton cae;
    private o caf;
    private o[] cag;
    private l cah;
    private Animation cai;
    private Animation caj;
    private HostMarketView cak;
    private View cal;
    private CouponEntranceView cam;
    private View can;
    private View cao;
    private com.baidu.poly.widget.coupon.l cap;
    private Long caq;
    private Long car;
    private com.baidu.poly.a.j.c cas;
    private com.baidu.poly.widget.c cat;
    private String cau;
    private boolean cav;
    private boolean caw;
    private String cax;
    private boolean la;
    private boolean ma;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a implements com.baidu.poly.a.k.a {
        final /* synthetic */ com.baidu.poly.a.k.a bXF;

        a(com.baidu.poly.a.k.a aVar) {
            this.bXF = aVar;
        }

        @Override // com.baidu.poly.a.k.a
        public void a(a.C0297a c0297a) {
            if (c0297a.statusCode == 0) {
                m.this.caq = Long.valueOf(c0297a.bXD);
                m.this.Za();
                if (m.this.caf != null && m.this.caf.P() == 1) {
                    m.this.caf.l(c0297a.bXE);
                }
            }
            this.bXF.a(c0297a);
            m.this.cam.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class b extends com.baidu.poly.a.a.a<JSONObject> {
        b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.poly.a.a.a
        public void a(JSONObject jSONObject) {
            m.this.caq = Long.valueOf(jSONObject.optLong("payMoney"));
            JSONArray optJSONArray = jSONObject.optJSONArray("payChannels");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                o[] oVarArr = new o[optJSONArray.length()];
                for (int i = 0; i < optJSONArray.length(); i++) {
                    o oVar = new o(optJSONArray.optJSONObject(i));
                    if (oVar.P() == 1) {
                        m.this.cax = oVar.R();
                    }
                    oVarArr[i] = oVar;
                }
                m.this.cag = oVarArr;
                m.this.bZs = new com.baidu.poly.widget.coupon.a(jSONObject.optJSONArray("coupons"));
                m.this.cam.a(m.this.bZs);
                if (m.this.cap != null) {
                    m.this.cap.a(m.this.bZs.bZv);
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("marketChannels");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    m.this.caf = new o(optJSONArray2.optJSONObject(0));
                }
                com.baidu.poly.a.h.a.j("7");
                if (m.this.cag.length != 1 || m.this.cam.getVisibility() != 8 || m.this.caf != null || m.this.cag[0] == null) {
                    m.this.Za();
                    if (m.this.caf != null || m.this.cam.getVisibility() != 8) {
                        m.this.cal.setVisibility(0);
                    } else {
                        m.this.cal.setVisibility(8);
                    }
                    m.this.ba();
                    m mVar = m.this;
                    mVar.b(mVar.a(mVar.cag));
                    m.this.cac.j();
                    m.this.YY();
                    m.this.caw = true;
                    m.this.Zd();
                    return;
                }
                m.this.caw = true;
                m.this.Zd();
                m.this.cac.b(m.this.cag[0].Q(), "即将进入" + m.this.cag[0].getDisplayName() + "…");
                m mVar2 = m.this;
                mVar2.b(mVar2.cag[0]);
                return;
            }
            com.baidu.poly.a.h.a.a("7", null, null);
            a(new com.baidu.poly.a.i.b("channelList is null"), "request channelList payChannels is null");
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            if (m.this.cag == null) {
                m mVar = m.this;
                mVar.n(mVar.getResources().getString(b.g.common_error_tips));
                m.this.onResult(3, "request channel list fail");
                m.this.detach();
                com.baidu.poly.a.h.d.a(new com.baidu.poly.a.h.b("1").jn(new com.baidu.poly.a.i.a("gatewaylist error --> " + str, th).U()));
            }
        }
    }

    /* loaded from: classes6.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            m.this.YZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class d implements Animation.AnimationListener {
        d() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            m.this.cav = true;
            m.this.Zd();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class e implements HostMarketView.a {
        e() {
        }

        @Override // com.baidu.poly.widget.hostmarket.HostMarketView.a
        public void a(boolean z, o oVar, com.baidu.poly.a.k.a aVar) {
            m.this.cab.a(true);
            m mVar = m.this;
            mVar.postDelayed(mVar.bZP, 500L);
            if (oVar != null) {
                ArrayList arrayList = new ArrayList();
                if (z) {
                    arrayList.add(oVar.O());
                }
                if (m.this.cam.getSelectedItem() != null) {
                    arrayList.add(m.this.cam.getSelectedItem().bZz);
                }
                m.this.a(arrayList, aVar);
            }
        }

        @Override // com.baidu.poly.widget.hostmarket.HostMarketView.a
        public void b(a.C0297a c0297a) {
            m.this.cab.a(false);
            m mVar = m.this;
            mVar.removeCallbacks(mVar.bZP);
            m.this.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.getParent() instanceof ViewGroup) {
                m mVar = m.this;
                mVar.startAnimation(mVar.caj);
                ((ViewGroup) m.this.getParent()).removeView(m.this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            m.this.aa();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (m.this.cat == null || !m.this.cat.isShowing()) {
                return;
            }
            m.this.cat.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class i implements c.b {
        i() {
        }

        @Override // com.baidu.poly.widget.c.b
        public void onDismiss() {
            m.this.aa();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class j implements a.InterfaceC0302a {
        final /* synthetic */ o[] bZY;
        final /* synthetic */ o bZZ;

        j(o[] oVarArr, o oVar) {
            this.bZY = oVarArr;
            this.bZZ = oVar;
        }

        @Override // com.baidu.poly.widget.a.InterfaceC0302a
        public void a() {
            o[] oVarArr = this.bZY;
            int length = oVarArr.length;
            for (int i = 0; i < length; i++) {
                o oVar = oVarArr[i];
                oVar.i(oVar == this.bZZ ? 1 : 0);
            }
            m.this.b(this.bZY);
        }
    }

    /* loaded from: classes6.dex */
    public interface l {
        void onClose();
    }

    public m(PolyActivity polyActivity) {
        super(polyActivity);
        this.la = true;
        this.ma = false;
        this.bZP = new c();
        this.cav = false;
        this.caw = false;
        YX();
    }

    private void YX() {
        this.cai = AnimationUtils.loadAnimation(getContext(), b.a.slide_in_bottom);
        this.caj = AnimationUtils.loadAnimation(getContext(), b.a.slide_out_bottom);
        LayoutInflater.from(getContext()).inflate(b.f.view_channel_list, this);
        this.caa = findViewById(b.e.bg_view);
        this.cab = (PolyFrameLayout) findViewById(b.e.popup_view);
        this.can = findViewById(b.e.pay_money_layout);
        this.cao = findViewById(b.e.channel_list_scroll_view);
        this.cac = (TipView) findViewById(b.e.tip_view);
        this.cad = (ViewGroup) findViewById(b.e.channel_list_view);
        this.cae = (ProgressButton) findViewById(b.e.pay_button);
        this.cal = findViewById(b.e.line);
        findViewById(b.e.close_button).setOnClickListener(this);
        this.cae.setOnClickListener(this);
        this.cak = (HostMarketView) findViewById(b.e.hostmarket);
        this.cam = (CouponEntranceView) findViewById(b.e.coupon);
        this.cam.setOnClickListener(this);
        this.S = (TextView) findViewById(b.e.money);
        this.U = (TextView) findViewById(b.e.cut);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void YY() {
        if (this.I <= 0) {
            this.cae.setVisibility(4);
            return;
        }
        this.cae.setVisibility(0);
        this.cae.setEnable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void YZ() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.bZN = com.baidu.poly.a.l.a.a(this.cab, layoutParams, "加载中", -1L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Za() {
        Long l2;
        Long l3 = this.car;
        if (l3 != null && (l2 = this.caq) != null) {
            if (l3.equals(l2)) {
                this.S.setText(a(this.caq.longValue()));
                this.U.setVisibility(8);
            } else {
                this.U.setVisibility(0);
                this.S.setText(a(this.caq.longValue()));
                this.U.setText(" ¥" + a(this.car.longValue()));
            }
            if (this.can.getVisibility() != 0) {
                this.can.setVisibility(0);
            }
        }
    }

    private void Zb() {
        List<a.C0304a> list;
        com.baidu.poly.widget.coupon.a aVar = this.bZs;
        if (aVar != null && (list = aVar.bZv) != null && list.size() > 0) {
            this.cap = new com.baidu.poly.widget.coupon.l(getContext());
            this.cap.a(this.cab.getMeasuredHeight());
            this.cap.setListener(new k());
            this.cap.a(this.bZs.bZv);
            this.cap.a(this.cab);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zc() {
        com.baidu.poly.a.b.b.Yt().a(this.bYc, new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zd() {
        if (this.cav && this.caw) {
            com.baidu.poly.a.h.a.F();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa() {
        com.baidu.poly.widget.c cVar = this.cat;
        boolean z = ((cVar != null && cVar.isShowing()) || this.H || this.G) ? false : true;
        if ((!TextUtils.isEmpty(this.cau) && (TextUtils.equals(this.cau, "BAIDU-ALIPAY-WISE") || TextUtils.equals(this.cau, "BAIDU-ALIPAY-WISE-HUABEI-PAY"))) || this.ma) {
            com.baidu.poly.util.d.info("ChannelListView->confirmViewClose() ali pay channel");
            z &= this.la;
        }
        com.baidu.poly.util.d.info("ChannelListView->confirmViewClose() canFinishActivity = " + z);
        if (!z || this.cah == null) {
            return;
        }
        com.baidu.poly.util.d.info("ChannelListView->confirmViewClose() finish activity");
        this.cah.onClose();
        this.cah = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ba() {
        this.cak.a(this.caf);
        this.cak.setListener(new e());
    }

    private void ha() {
        this.caa.setVisibility(0);
        this.cab.setVisibility(0);
        this.caa.setAlpha(0.0f);
        this.caa.animate().alpha(0.65f).setDuration(240L).start();
        this.cab.startAnimation(this.cai);
        this.cai.setAnimationListener(new d());
        YY();
    }

    public void detach() {
        if (this.G) {
            this.G = false;
            this.caa.animate().alpha(0.0f).setDuration(240L).start();
            postDelayed(new f(), 240L);
            postDelayed(new g(), 480L);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.H || super.dispatchTouchEvent(motionEvent);
    }

    public boolean onBackPressed() {
        com.baidu.poly.widget.coupon.l lVar = this.cap;
        if (lVar != null) {
            lVar.onBackPressed();
            return true;
        } else if (this.H) {
            return true;
        } else {
            if (this.G) {
                onResult(2, com.baidu.poly.util.b.a(2, null, "key_back_cancel"));
                detach();
                return true;
            }
            return false;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        o oVar;
        if (view.getId() == b.e.close_button) {
            onResult(2, "主动取消支付");
            detach();
            com.baidu.poly.a.h.d.a(new com.baidu.poly.a.h.b("6"));
        } else if (view.getId() == b.e.pay_button) {
            if (this.I != 0) {
                this.cae.startLoading();
                this.H = true;
                this.la = false;
                o[] oVarArr = this.cag;
                int length = oVarArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        oVar = null;
                        break;
                    }
                    oVar = oVarArr[i2];
                    if (oVar.P() == 1) {
                        break;
                    }
                    i2++;
                }
                if (oVar != null) {
                    b(oVar);
                    o(oVar.R());
                }
            }
        } else if (view.getId() == b.e.coupon) {
            Zb();
        }
    }

    public void onResult(int i2, String str) {
        com.baidu.poly.util.d.info("ChannelListView->onResult() statusCode = " + i2 + " result = " + str);
        this.la = true;
        a.b bVar = this.bXZ;
        if (bVar != null) {
            bVar.onResult(i2, str);
            this.bXZ = null;
        }
        com.baidu.poly.a.h.d.b(i2, str);
        if (((PolyActivity) getContext()).isFinishing()) {
            com.baidu.poly.a.h.d.flush();
        }
        aa();
    }

    public void setCloseListener(l lVar) {
        this.cah = lVar;
    }

    public void setIsPreparePaying(boolean z) {
        this.H = z;
        aa();
        detach();
    }

    public void setResultListener(a.b bVar) {
        this.bXZ = bVar;
    }

    public void setWalletList(com.baidu.poly.a.j.c cVar) {
        this.cas = cVar;
    }

    public void setWechatH5Pay(boolean z) {
        this.ma = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(String str) {
        if (TextUtils.isEmpty(str)) {
            str = getResources().getString(b.g.common_error_tips);
        }
        if (this.cat == null) {
            View inflate = View.inflate(this.cad.getContext(), b.f.default_pop_window, null);
            ((TextView) inflate.findViewById(b.e.pop_title)).setText("支付失败");
            ((TextView) inflate.findViewById(b.e.pop_tips)).setText(str.trim());
            this.cat = new com.baidu.poly.widget.c(inflate, -1, -1, true);
            this.cat.setClippingEnabled(false);
            this.cat.setOutsideTouchable(false);
            this.cat.setBackgroundDrawable(new ColorDrawable(0));
            ((TextView) inflate.findViewById(b.e.pop_button)).setOnClickListener(new h());
            this.cat.a(new i());
        }
        PolyActivity polyActivity = (PolyActivity) getContext();
        if (polyActivity.isFinishing()) {
            return;
        }
        this.cat.showAtLocation(polyActivity.getWindow().getDecorView(), 0, 0, 0);
    }

    private void o(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("default", this.cax);
            jSONObject.put("selected", str);
        } catch (JSONException e2) {
        }
        com.baidu.poly.a.h.d.a(new com.baidu.poly.a.h.b("5").an(jSONObject));
    }

    public m Ze() {
        if (!this.G) {
            this.G = true;
            if (!(getContext() instanceof Activity)) {
                throw new IllegalStateException("can not attach to context " + getContext());
            }
            this.cac.a("收银台加载中...");
            com.baidu.poly.util.d.info("ChannelListView->attach()");
            ha();
        }
        return this;
    }

    public void e() {
        com.baidu.poly.a.l.a.a(this.bZN);
        this.bZN = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class k implements l.h {
        k() {
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void b() {
            m.this.Zc();
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void d() {
            if (m.this.cap != null) {
                m.this.cap.b(m.this.cab);
            }
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void onDetach() {
            m.this.cap = null;
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void a(a.C0304a c0304a, com.baidu.poly.a.k.a aVar) {
            if (c0304a != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(c0304a.bZz);
                if (m.this.caf != null && m.this.caf.P() == 1) {
                    arrayList.add(m.this.caf.O());
                }
                m.this.a(arrayList, aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(o[] oVarArr) {
        this.cao.setMinimumHeight(0);
        if (oVarArr != null) {
            this.cad.removeAllViews();
            for (o oVar : oVarArr) {
                com.baidu.poly.widget.a aVar = new com.baidu.poly.widget.a(getContext());
                aVar.a(oVar, new j(oVarArr, oVar));
                this.cad.addView(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public o[] a(o[] oVarArr) {
        int i2 = 0;
        for (o oVar : oVarArr) {
            if (oVar.P() == 1 && (i2 = i2 + 1) > 1) {
                oVar.i(0);
            }
            if (oVar.N() == 1) {
                this.I++;
            }
        }
        if (i2 == 0) {
            int length = oVarArr.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                o oVar2 = oVarArr[i3];
                if (oVar2.N() == 1) {
                    oVar2.i(1);
                    break;
                }
                i3++;
            }
        }
        return oVarArr;
    }

    public void a(Bundle bundle) {
        if (bundle != null) {
            try {
                String string = bundle.getString("totalAmount");
                if (TextUtils.isEmpty(string)) {
                    this.car = -1L;
                } else {
                    this.car = Long.valueOf(Long.parseLong(string));
                }
            } catch (Exception e2) {
                com.baidu.poly.util.d.info("totalAmount is not long");
            }
        }
        this.bYc = bundle;
        Zc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(o oVar) {
        if (oVar != null) {
            com.baidu.poly.a.h.a.d(Long.valueOf(System.currentTimeMillis()));
            JSONArray jSONArray = new JSONArray();
            try {
                if (this.caf != null && this.caf.P() == 1 && !TextUtils.isEmpty(this.caf.O())) {
                    jSONArray.put(new JSONObject(this.caf.O()));
                }
                if (this.cam.getSelectedItem() != null && !TextUtils.isEmpty(this.cam.getSelectedItem().bZz)) {
                    jSONArray.put(new JSONObject(this.cam.getSelectedItem().bZz));
                }
            } catch (Exception e2) {
            }
            if (jSONArray.length() > 0) {
                this.bYc.putString("hostMarketingDetail", jSONArray.toString());
            }
            if (this.cas != null) {
                this.cau = oVar.R();
                this.cas.b(this.bYc, oVar.R(), this);
            }
        }
    }

    public void c(Bundle bundle, String str) {
        this.cau = str;
        if (this.cas != null) {
            this.H = true;
            this.la = false;
            com.baidu.poly.a.h.a.d(Long.valueOf(System.currentTimeMillis()));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            this.bZN = com.baidu.poly.a.l.a.a(this, layoutParams, getResources().getString(b.g.poly_fast_pay_loading), -1L);
            this.cas.b(bundle, str, this);
        }
    }

    public void a(String str, String str2) {
        com.baidu.poly.util.d.info("ChannelListView->errorEnd()");
        e();
        if (!TextUtils.isEmpty(str2)) {
            n(str2);
        } else {
            n(getResources().getString(b.g.common_error_tips));
        }
        onResult(3, str);
        setIsPreparePaying(false);
    }

    public void a(int i2, String str) {
        com.baidu.poly.util.d.info("ChannelListView->payEnd()");
        onResult(i2, str);
        setIsPreparePaying(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<String> list, com.baidu.poly.a.k.a aVar) {
        if (aVar == null) {
            return;
        }
        com.baidu.poly.a.k.b.a(this.bYc.getString("bduss"), this.bYc.getString("appKey"), this.car + "", list, new a(aVar));
    }

    private String a(long j2) {
        return new DecimalFormat("0.00").format((j2 * 1.0d) / 100.0d);
    }
}

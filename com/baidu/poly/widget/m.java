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
/* loaded from: classes9.dex */
public class m extends FrameLayout implements View.OnClickListener {
    private boolean F;
    private boolean G;
    private int H;
    private TextView R;
    private View aa;
    private a.b bBk;
    private Bundle bBn;
    private com.baidu.poly.widget.coupon.a bCG;
    private View bDA;
    private CouponEntranceView bDB;
    private View bDC;
    private com.baidu.poly.widget.coupon.l bDD;
    private Long bDE;
    private Long bDF;
    private com.baidu.poly.a.j.c bDG;
    private com.baidu.poly.widget.c bDH;
    private o bDI;
    private boolean bDJ;
    private boolean bDK;
    private com.baidu.poly.a.l.c bDc;
    private Runnable bDe;
    private PolyFrameLayout bDp;
    private TipView bDq;
    private ViewGroup bDr;
    private ProgressButton bDs;
    private o bDt;
    private o[] bDu;
    private l bDv;
    private Animation bDw;
    private Animation bDx;
    private HostMarketView bDy;
    private TextView bDz;
    private boolean ka;
    private boolean la;
    private String pa;
    private View s;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class a implements com.baidu.poly.a.k.a {
        final /* synthetic */ com.baidu.poly.a.k.a bAQ;

        a(com.baidu.poly.a.k.a aVar) {
            this.bAQ = aVar;
        }

        @Override // com.baidu.poly.a.k.a
        public void a(a.C0249a c0249a) {
            if (c0249a.statusCode == 0) {
                m.this.bDE = Long.valueOf(c0249a.bAO);
                m.this.ea();
                if (m.this.bDt != null && m.this.bDt.O() == 1) {
                    m.this.bDt.l(c0249a.bAP);
                }
            }
            this.bAQ.a(c0249a);
            m.this.bDB.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class b extends com.baidu.poly.a.a.a<JSONObject> {
        b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.poly.a.a.a
        public void a(JSONObject jSONObject) {
            m.this.bDE = Long.valueOf(jSONObject.optLong("payMoney"));
            JSONArray optJSONArray = jSONObject.optJSONArray("payChannels");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                o[] oVarArr = new o[optJSONArray.length()];
                for (int i = 0; i < optJSONArray.length(); i++) {
                    o oVar = new o(optJSONArray.optJSONObject(i));
                    if (oVar.O() == 1) {
                        m.this.pa = oVar.Q();
                    }
                    oVarArr[i] = oVar;
                }
                m.this.bDu = oVarArr;
                m.this.bCG = new com.baidu.poly.widget.coupon.a(jSONObject.optJSONArray("coupons"));
                m.this.bDB.a(m.this.bCG);
                if (m.this.bDD != null) {
                    m.this.bDD.a(m.this.bCG.bCJ);
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("marketChannels");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    m.this.bDt = new o(optJSONArray2.optJSONObject(0));
                }
                com.baidu.poly.a.h.a.j("7");
                if (m.this.bDu.length != 1 || m.this.bDB.getVisibility() != 8 || m.this.bDt != null) {
                    m.this.ea();
                    if (m.this.bDt != null || m.this.bDB.getVisibility() != 8) {
                        m.this.bDA.setVisibility(0);
                    } else {
                        m.this.bDA.setVisibility(8);
                    }
                    m.this.aa();
                    m mVar = m.this;
                    mVar.b(mVar.a(mVar.bDu));
                    m.this.bDq.h();
                    m.this.OE();
                    m.this.bDK = true;
                    m.this.OH();
                    return;
                }
                m.this.bDK = true;
                m.this.OH();
                m.this.bDq.b(m.this.bDu[0].P(), "即将进入" + m.this.bDu[0].getDisplayName() + "…");
                m mVar2 = m.this;
                mVar2.b(mVar2.bDu[0]);
                return;
            }
            com.baidu.poly.a.h.a.a("7", null, null);
            a(new com.baidu.poly.a.i.b("channelList is null"), "request channelList payChannels is null");
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            if (m.this.bDu == null) {
                m mVar = m.this;
                mVar.n(mVar.getResources().getString(b.g.common_error_tips));
                m.this.onResult(3, "request channel list fail");
                m.this.detach();
                com.baidu.poly.a.h.d.a(new com.baidu.poly.a.h.b("1").gE(new com.baidu.poly.a.i.a("gatewaylist error --> " + str, th).T()));
            }
        }
    }

    /* loaded from: classes9.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            m.this.OF();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class d implements Animation.AnimationListener {
        d() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            m.this.bDJ = true;
            m.this.OH();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class e implements HostMarketView.a {
        e() {
        }

        @Override // com.baidu.poly.widget.hostmarket.HostMarketView.a
        public void a(boolean z, o oVar, com.baidu.poly.a.k.a aVar) {
            m.this.bDp.a(true);
            m mVar = m.this;
            mVar.postDelayed(mVar.bDe, 500L);
            if (oVar != null) {
                ArrayList arrayList = new ArrayList();
                if (z) {
                    arrayList.add(oVar.N());
                }
                if (m.this.bDB.getSelectedItem() != null) {
                    arrayList.add(m.this.bDB.getSelectedItem().bCO);
                }
                m.this.a(arrayList, aVar);
            }
        }

        @Override // com.baidu.poly.widget.hostmarket.HostMarketView.a
        public void b(a.C0249a c0249a) {
            m.this.bDp.a(false);
            m mVar = m.this;
            mVar.removeCallbacks(mVar.bDe);
            m.this.ba();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.getParent() instanceof ViewGroup) {
                m mVar = m.this;
                mVar.startAnimation(mVar.bDx);
                ((ViewGroup) m.this.getParent()).removeView(m.this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            m.this.Z();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (m.this.bDH == null || !m.this.bDH.isShowing()) {
                return;
            }
            m.this.bDH.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class i implements c.b {
        i() {
        }

        @Override // com.baidu.poly.widget.c.b
        public void onDismiss() {
            m.this.Z();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class j implements a.InterfaceC0254a {
        final /* synthetic */ o[] bDn;
        final /* synthetic */ o bDo;

        j(o[] oVarArr, o oVar) {
            this.bDn = oVarArr;
            this.bDo = oVar;
        }

        @Override // com.baidu.poly.widget.a.InterfaceC0254a
        public void a() {
            o[] oVarArr = this.bDn;
            int length = oVarArr.length;
            for (int i = 0; i < length; i++) {
                o oVar = oVarArr[i];
                oVar.i(oVar == this.bDo ? 1 : 0);
            }
            m.this.b(this.bDn);
        }
    }

    /* loaded from: classes9.dex */
    public interface l {
        void onClose();
    }

    public m(PolyActivity polyActivity) {
        super(polyActivity);
        this.bDI = null;
        this.ka = true;
        this.la = false;
        this.bDe = new c();
        this.bDJ = false;
        this.bDK = false;
        ca();
    }

    private void OD() {
        this.s.setVisibility(0);
        this.bDp.setVisibility(0);
        this.s.setAlpha(0.0f);
        this.s.animate().alpha(0.65f).setDuration(240L).start();
        this.bDp.startAnimation(this.bDw);
        this.bDw.setAnimationListener(new d());
        OE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OE() {
        if (this.H <= 0) {
            this.bDs.setVisibility(4);
            return;
        }
        this.bDs.setVisibility(0);
        this.bDs.setEnable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OF() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.bDc = com.baidu.poly.a.l.a.a(this.bDp, layoutParams, "加载中", -1L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OG() {
        com.baidu.poly.a.b.b.Oa().a(this.bBn, new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OH() {
        if (this.bDJ && this.bDK) {
            com.baidu.poly.a.h.a.E();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z() {
        com.baidu.poly.widget.c cVar = this.bDH;
        boolean z = ((cVar != null && cVar.isShowing()) || this.G || this.F) ? false : true;
        o oVar = this.bDI;
        if ((oVar != null && (TextUtils.equals(oVar.Q(), "BAIDU-ALIPAY-WISE") || TextUtils.equals(this.bDI.Q(), "BAIDU-ALIPAY-WISE-HUABEI-PAY"))) || this.la) {
            com.baidu.poly.util.d.info("ChannelListView->confirmViewClose() ali pay channel");
            z &= this.ka;
        }
        com.baidu.poly.util.d.info("ChannelListView->confirmViewClose() canFinishActivity = " + z);
        if (!z || this.bDv == null) {
            return;
        }
        com.baidu.poly.util.d.info("ChannelListView->confirmViewClose() finish activity");
        this.bDv.onClose();
        this.bDv = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa() {
        this.bDy.a(this.bDt);
        this.bDy.setListener(new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ba() {
        com.baidu.poly.a.l.a.a(this.bDc);
        this.bDc = null;
    }

    private void ca() {
        this.bDw = AnimationUtils.loadAnimation(getContext(), b.a.slide_in_bottom);
        this.bDx = AnimationUtils.loadAnimation(getContext(), b.a.slide_out_bottom);
        LayoutInflater.from(getContext()).inflate(b.f.view_channel_list, this);
        this.s = findViewById(b.e.bg_view);
        this.bDp = (PolyFrameLayout) findViewById(b.e.popup_view);
        this.aa = findViewById(b.e.pay_money_layout);
        this.bDC = findViewById(b.e.channel_list_scroll_view);
        this.bDq = (TipView) findViewById(b.e.tip_view);
        this.bDr = (ViewGroup) findViewById(b.e.channel_list_view);
        this.bDs = (ProgressButton) findViewById(b.e.pay_button);
        this.bDA = findViewById(b.e.line);
        findViewById(b.e.close_button).setOnClickListener(this);
        this.bDs.setOnClickListener(this);
        this.bDy = (HostMarketView) findViewById(b.e.hostmarket);
        this.bDB = (CouponEntranceView) findViewById(b.e.coupon);
        this.bDB.setOnClickListener(this);
        this.R = (TextView) findViewById(b.e.money);
        this.bDz = (TextView) findViewById(b.e.cut);
    }

    private void da() {
        List<a.C0256a> list;
        com.baidu.poly.widget.coupon.a aVar = this.bCG;
        if (aVar != null && (list = aVar.bCJ) != null && list.size() > 0) {
            this.bDD = new com.baidu.poly.widget.coupon.l(getContext());
            this.bDD.a(this.bDp.getMeasuredHeight());
            this.bDD.setListener(new k());
            this.bDD.a(this.bCG.bCJ);
            this.bDD.a(this.bDp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ea() {
        Long l2;
        Long l3 = this.bDF;
        if (l3 != null && (l2 = this.bDE) != null) {
            if (l3.equals(l2)) {
                this.R.setText(a(this.bDE.longValue()));
                this.bDz.setVisibility(8);
            } else {
                this.bDz.setVisibility(0);
                this.R.setText(a(this.bDE.longValue()));
                this.bDz.setText(" ¥" + a(this.bDF.longValue()));
            }
            if (this.aa.getVisibility() != 0) {
                this.aa.setVisibility(0);
            }
        }
    }

    public void detach() {
        if (this.F) {
            this.F = false;
            this.s.animate().alpha(0.0f).setDuration(240L).start();
            postDelayed(new f(), 240L);
            postDelayed(new g(), 480L);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.G || super.dispatchTouchEvent(motionEvent);
    }

    public boolean onBackPressed() {
        com.baidu.poly.widget.coupon.l lVar = this.bDD;
        if (lVar != null) {
            lVar.onBackPressed();
            return true;
        } else if (this.G) {
            return true;
        } else {
            if (this.F) {
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
            if (this.H != 0) {
                this.bDs.startLoading();
                this.G = true;
                this.ka = false;
                o[] oVarArr = this.bDu;
                int length = oVarArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        oVar = null;
                        break;
                    }
                    oVar = oVarArr[i2];
                    if (oVar.O() == 1) {
                        break;
                    }
                    i2++;
                }
                b(oVar);
            }
        } else if (view.getId() == b.e.coupon) {
            da();
        }
    }

    public void onResult(int i2, String str) {
        com.baidu.poly.util.d.info("ChannelListView->onResult() statusCode = " + i2 + " result = " + str);
        this.ka = true;
        a.b bVar = this.bBk;
        if (bVar != null) {
            bVar.onResult(i2, str);
            this.bBk = null;
        }
        com.baidu.poly.a.h.d.b(i2, str);
        if (((PolyActivity) getContext()).isFinishing()) {
            com.baidu.poly.a.h.d.flush();
        }
        Z();
    }

    public void setIsPreparePaying(boolean z) {
        this.G = z;
        Z();
        detach();
    }

    public void setWechatH5Pay(boolean z) {
        this.la = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(String str) {
        if (TextUtils.isEmpty(str)) {
            str = getResources().getString(b.g.common_error_tips);
        }
        if (this.bDH == null) {
            View inflate = View.inflate(this.bDr.getContext(), b.f.default_pop_window, null);
            ((TextView) inflate.findViewById(b.e.pop_title)).setText("支付失败");
            ((TextView) inflate.findViewById(b.e.pop_tips)).setText(str.trim());
            this.bDH = new com.baidu.poly.widget.c(inflate, -1, -1, true);
            this.bDH.setClippingEnabled(false);
            this.bDH.setOutsideTouchable(false);
            this.bDH.setBackgroundDrawable(new ColorDrawable(0));
            ((TextView) inflate.findViewById(b.e.pop_button)).setOnClickListener(new h());
            this.bDH.a(new i());
        }
        PolyActivity polyActivity = (PolyActivity) getContext();
        if (polyActivity.isFinishing()) {
            return;
        }
        this.bDH.showAtLocation(polyActivity.getWindow().getDecorView(), 0, 0, 0);
    }

    private void o(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("default", this.pa);
            jSONObject.put("selected", str);
        } catch (JSONException e2) {
        }
        com.baidu.poly.a.h.d.a(new com.baidu.poly.a.h.b("5").ac(jSONObject));
    }

    public m OI() {
        if (!this.F) {
            this.F = true;
            if (!(getContext() instanceof Activity)) {
                throw new IllegalStateException("can not attach to context " + getContext());
            }
            this.bDq.a("收银台加载中...");
            com.baidu.poly.util.d.info("ChannelListView->attach()");
            OD();
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class k implements l.h {
        k() {
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void b() {
            m.this.OG();
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void d() {
            if (m.this.bDD != null) {
                m.this.bDD.b(m.this.bDp);
            }
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void onDetach() {
            m.this.bDD = null;
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void a(a.C0256a c0256a, com.baidu.poly.a.k.a aVar) {
            if (c0256a != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(c0256a.bCO);
                if (m.this.bDt != null && m.this.bDt.O() == 1) {
                    arrayList.add(m.this.bDt.N());
                }
                m.this.a(arrayList, aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(o[] oVarArr) {
        this.bDC.setMinimumHeight(0);
        if (oVarArr != null) {
            this.bDr.removeAllViews();
            for (o oVar : oVarArr) {
                com.baidu.poly.widget.a aVar = new com.baidu.poly.widget.a(getContext());
                aVar.a(oVar, new j(oVarArr, oVar));
                this.bDr.addView(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public o[] a(o[] oVarArr) {
        int i2 = 0;
        for (o oVar : oVarArr) {
            if (oVar.O() == 1 && (i2 = i2 + 1) > 1) {
                oVar.i(0);
            }
            if (oVar.M() == 1) {
                this.H++;
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
                if (oVar2.M() == 1) {
                    oVar2.i(1);
                    break;
                }
                i3++;
            }
        }
        return oVarArr;
    }

    public m n(Bundle bundle) {
        if (bundle != null) {
            try {
                this.bDF = Long.valueOf(Long.parseLong(bundle.getString("totalAmount")));
            } catch (NumberFormatException e2) {
            }
        }
        this.bBn = bundle;
        OG();
        return this;
    }

    public m a(a.b bVar) {
        this.bBk = bVar;
        return this;
    }

    public m a(l lVar) {
        this.bDv = lVar;
        return this;
    }

    public m a(com.baidu.poly.a.j.c cVar) {
        this.bDG = cVar;
        return this;
    }

    public void a(String str, String str2) {
        com.baidu.poly.util.d.info("ChannelListView->errorEnd()");
        if (!TextUtils.isEmpty(str2)) {
            n(str2);
        } else {
            n(getResources().getString(b.g.common_error_tips));
        }
        onResult(3, str);
        setIsPreparePaying(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(o oVar) {
        if (oVar != null) {
            o(oVar != null ? oVar.Q() : null);
            com.baidu.poly.a.h.a.c(Long.valueOf(System.currentTimeMillis()));
            JSONArray jSONArray = new JSONArray();
            try {
                if (this.bDt != null && this.bDt.O() == 1 && !TextUtils.isEmpty(this.bDt.N())) {
                    jSONArray.put(new JSONObject(this.bDt.N()));
                }
                if (this.bDB.getSelectedItem() != null && !TextUtils.isEmpty(this.bDB.getSelectedItem().bCO)) {
                    jSONArray.put(new JSONObject(this.bDB.getSelectedItem().bCO));
                }
            } catch (Exception e2) {
            }
            if (jSONArray.length() > 0) {
                this.bBn.putString("hostMarketingDetail", jSONArray.toString());
            }
            com.baidu.poly.a.j.c cVar = this.bDG;
            if (cVar != null) {
                this.bDI = oVar;
                cVar.b(this.bBn, oVar.Q(), this);
            }
        }
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
        com.baidu.poly.a.k.b.a(this.bBn.getString("bduss"), this.bBn.getString("appKey"), this.bDF + "", list, new a(aVar));
    }

    private String a(long j2) {
        return new DecimalFormat("0.00").format((j2 * 1.0d) / 100.0d);
    }
}

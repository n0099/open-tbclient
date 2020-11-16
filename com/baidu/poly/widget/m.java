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
    private a.b cbY;
    private Bundle ccb;
    private com.baidu.poly.a.l.c cdO;
    private Runnable cdQ;
    private com.baidu.poly.widget.coupon.a cdt;
    private View ceb;
    private PolyFrameLayout cec;
    private TipView ced;
    private ViewGroup cee;
    private ProgressButton cef;
    private o ceg;
    private o[] ceh;
    private l cei;
    private Animation cej;
    private Animation cek;
    private HostMarketView cel;
    private View cem;
    private CouponEntranceView cen;
    private View ceo;
    private View cep;
    private com.baidu.poly.widget.coupon.l ceq;
    private Long cer;
    private Long ces;
    private com.baidu.poly.a.j.c cet;
    private com.baidu.poly.widget.c ceu;
    private String cev;
    private boolean cew;
    private boolean cex;
    private String cey;
    private boolean la;
    private boolean ma;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a implements com.baidu.poly.a.k.a {
        final /* synthetic */ com.baidu.poly.a.k.a cbE;

        a(com.baidu.poly.a.k.a aVar) {
            this.cbE = aVar;
        }

        @Override // com.baidu.poly.a.k.a
        public void a(a.C0307a c0307a) {
            if (c0307a.statusCode == 0) {
                m.this.cer = Long.valueOf(c0307a.cbC);
                m.this.aaQ();
                if (m.this.ceg != null && m.this.ceg.P() == 1) {
                    m.this.ceg.l(c0307a.cbD);
                }
            }
            this.cbE.a(c0307a);
            m.this.cen.h();
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
            m.this.cer = Long.valueOf(jSONObject.optLong("payMoney"));
            JSONArray optJSONArray = jSONObject.optJSONArray("payChannels");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                o[] oVarArr = new o[optJSONArray.length()];
                for (int i = 0; i < optJSONArray.length(); i++) {
                    o oVar = new o(optJSONArray.optJSONObject(i));
                    if (oVar.P() == 1) {
                        m.this.cey = oVar.R();
                    }
                    oVarArr[i] = oVar;
                }
                m.this.ceh = oVarArr;
                m.this.cdt = new com.baidu.poly.widget.coupon.a(jSONObject.optJSONArray("coupons"));
                m.this.cen.a(m.this.cdt);
                if (m.this.ceq != null) {
                    m.this.ceq.a(m.this.cdt.cdw);
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("marketChannels");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    m.this.ceg = new o(optJSONArray2.optJSONObject(0));
                }
                com.baidu.poly.a.h.a.j("7");
                if (m.this.ceh.length != 1 || m.this.cen.getVisibility() != 8 || m.this.ceg != null || m.this.ceh[0] == null) {
                    m.this.aaQ();
                    if (m.this.ceg != null || m.this.cen.getVisibility() != 8) {
                        m.this.cem.setVisibility(0);
                    } else {
                        m.this.cem.setVisibility(8);
                    }
                    m.this.ba();
                    m mVar = m.this;
                    mVar.b(mVar.a(mVar.ceh));
                    m.this.ced.j();
                    m.this.aaO();
                    m.this.cex = true;
                    m.this.aaT();
                    return;
                }
                m.this.cex = true;
                m.this.aaT();
                m.this.ced.b(m.this.ceh[0].Q(), "即将进入" + m.this.ceh[0].getDisplayName() + "…");
                m mVar2 = m.this;
                mVar2.b(mVar2.ceh[0]);
                return;
            }
            com.baidu.poly.a.h.a.a("7", null, null);
            a(new com.baidu.poly.a.i.b("channelList is null"), "request channelList payChannels is null");
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            if (m.this.ceh == null) {
                m mVar = m.this;
                mVar.n(mVar.getResources().getString(b.g.common_error_tips));
                m.this.onResult(3, "request channel list fail");
                m.this.detach();
                com.baidu.poly.a.h.d.a(new com.baidu.poly.a.h.b("1").ju(new com.baidu.poly.a.i.a("gatewaylist error --> " + str, th).U()));
            }
        }
    }

    /* loaded from: classes6.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            m.this.aaP();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class d implements Animation.AnimationListener {
        d() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            m.this.cew = true;
            m.this.aaT();
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
            m.this.cec.a(true);
            m mVar = m.this;
            mVar.postDelayed(mVar.cdQ, 500L);
            if (oVar != null) {
                ArrayList arrayList = new ArrayList();
                if (z) {
                    arrayList.add(oVar.O());
                }
                if (m.this.cen.getSelectedItem() != null) {
                    arrayList.add(m.this.cen.getSelectedItem().cdA);
                }
                m.this.a(arrayList, aVar);
            }
        }

        @Override // com.baidu.poly.widget.hostmarket.HostMarketView.a
        public void b(a.C0307a c0307a) {
            m.this.cec.a(false);
            m mVar = m.this;
            mVar.removeCallbacks(mVar.cdQ);
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
                mVar.startAnimation(mVar.cek);
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
            if (m.this.ceu == null || !m.this.ceu.isShowing()) {
                return;
            }
            m.this.ceu.dismiss();
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
    public class j implements a.InterfaceC0312a {
        final /* synthetic */ o[] cdZ;
        final /* synthetic */ o cea;

        j(o[] oVarArr, o oVar) {
            this.cdZ = oVarArr;
            this.cea = oVar;
        }

        @Override // com.baidu.poly.widget.a.InterfaceC0312a
        public void a() {
            o[] oVarArr = this.cdZ;
            int length = oVarArr.length;
            for (int i = 0; i < length; i++) {
                o oVar = oVarArr[i];
                oVar.i(oVar == this.cea ? 1 : 0);
            }
            m.this.b(this.cdZ);
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
        this.cdQ = new c();
        this.cew = false;
        this.cex = false;
        aaN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa() {
        com.baidu.poly.widget.c cVar = this.ceu;
        boolean z = ((cVar != null && cVar.isShowing()) || this.H || this.G) ? false : true;
        if ((!TextUtils.isEmpty(this.cev) && (TextUtils.equals(this.cev, "BAIDU-ALIPAY-WISE") || TextUtils.equals(this.cev, "BAIDU-ALIPAY-WISE-HUABEI-PAY"))) || this.ma) {
            com.baidu.poly.util.d.info("ChannelListView->confirmViewClose() ali pay channel");
            z &= this.la;
        }
        com.baidu.poly.util.d.info("ChannelListView->confirmViewClose() canFinishActivity = " + z);
        if (!z || this.cei == null) {
            return;
        }
        com.baidu.poly.util.d.info("ChannelListView->confirmViewClose() finish activity");
        this.cei.onClose();
        this.cei = null;
    }

    private void aaN() {
        this.cej = AnimationUtils.loadAnimation(getContext(), b.a.slide_in_bottom);
        this.cek = AnimationUtils.loadAnimation(getContext(), b.a.slide_out_bottom);
        LayoutInflater.from(getContext()).inflate(b.f.view_channel_list, this);
        this.ceb = findViewById(b.e.bg_view);
        this.cec = (PolyFrameLayout) findViewById(b.e.popup_view);
        this.ceo = findViewById(b.e.pay_money_layout);
        this.cep = findViewById(b.e.channel_list_scroll_view);
        this.ced = (TipView) findViewById(b.e.tip_view);
        this.cee = (ViewGroup) findViewById(b.e.channel_list_view);
        this.cef = (ProgressButton) findViewById(b.e.pay_button);
        this.cem = findViewById(b.e.line);
        findViewById(b.e.close_button).setOnClickListener(this);
        this.cef.setOnClickListener(this);
        this.cel = (HostMarketView) findViewById(b.e.hostmarket);
        this.cen = (CouponEntranceView) findViewById(b.e.coupon);
        this.cen.setOnClickListener(this);
        this.S = (TextView) findViewById(b.e.money);
        this.U = (TextView) findViewById(b.e.cut);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaO() {
        if (this.I <= 0) {
            this.cef.setVisibility(4);
            return;
        }
        this.cef.setVisibility(0);
        this.cef.setEnable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaP() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.cdO = com.baidu.poly.a.l.a.a(this.cec, layoutParams, "加载中", -1L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaQ() {
        Long l2;
        Long l3 = this.ces;
        if (l3 != null && (l2 = this.cer) != null) {
            if (l3.equals(l2)) {
                this.S.setText(a(this.cer.longValue()));
                this.U.setVisibility(8);
            } else {
                this.U.setVisibility(0);
                this.S.setText(a(this.cer.longValue()));
                this.U.setText(" ¥" + a(this.ces.longValue()));
            }
            if (this.ceo.getVisibility() != 0) {
                this.ceo.setVisibility(0);
            }
        }
    }

    private void aaR() {
        List<a.C0314a> list;
        com.baidu.poly.widget.coupon.a aVar = this.cdt;
        if (aVar != null && (list = aVar.cdw) != null && list.size() > 0) {
            this.ceq = new com.baidu.poly.widget.coupon.l(getContext());
            this.ceq.a(this.cec.getMeasuredHeight());
            this.ceq.setListener(new k());
            this.ceq.a(this.cdt.cdw);
            this.ceq.a(this.cec);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaS() {
        com.baidu.poly.a.b.b.aaj().a(this.ccb, new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaT() {
        if (this.cew && this.cex) {
            com.baidu.poly.a.h.a.F();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ba() {
        this.cel.a(this.ceg);
        this.cel.setListener(new e());
    }

    private void ha() {
        this.ceb.setVisibility(0);
        this.cec.setVisibility(0);
        this.ceb.setAlpha(0.0f);
        this.ceb.animate().alpha(0.65f).setDuration(240L).start();
        this.cec.startAnimation(this.cej);
        this.cej.setAnimationListener(new d());
        aaO();
    }

    public void detach() {
        if (this.G) {
            this.G = false;
            this.ceb.animate().alpha(0.0f).setDuration(240L).start();
            postDelayed(new f(), 240L);
            postDelayed(new g(), 480L);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.H || super.dispatchTouchEvent(motionEvent);
    }

    public boolean onBackPressed() {
        com.baidu.poly.widget.coupon.l lVar = this.ceq;
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
                this.cef.startLoading();
                this.H = true;
                this.la = false;
                o[] oVarArr = this.ceh;
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
            aaR();
        }
    }

    public void onResult(int i2, String str) {
        com.baidu.poly.util.d.info("ChannelListView->onResult() statusCode = " + i2 + " result = " + str);
        this.la = true;
        a.b bVar = this.cbY;
        if (bVar != null) {
            bVar.onResult(i2, str);
            this.cbY = null;
        }
        com.baidu.poly.a.h.d.b(i2, str);
        if (((PolyActivity) getContext()).isFinishing()) {
            com.baidu.poly.a.h.d.flush();
        }
        aa();
    }

    public void setCloseListener(l lVar) {
        this.cei = lVar;
    }

    public void setIsPreparePaying(boolean z) {
        this.H = z;
        aa();
        detach();
    }

    public void setResultListener(a.b bVar) {
        this.cbY = bVar;
    }

    public void setWalletList(com.baidu.poly.a.j.c cVar) {
        this.cet = cVar;
    }

    public void setWechatH5Pay(boolean z) {
        this.ma = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(String str) {
        if (TextUtils.isEmpty(str)) {
            str = getResources().getString(b.g.common_error_tips);
        }
        if (this.ceu == null) {
            View inflate = View.inflate(this.cee.getContext(), b.f.default_pop_window, null);
            ((TextView) inflate.findViewById(b.e.pop_title)).setText("支付失败");
            ((TextView) inflate.findViewById(b.e.pop_tips)).setText(str.trim());
            this.ceu = new com.baidu.poly.widget.c(inflate, -1, -1, true);
            this.ceu.setClippingEnabled(false);
            this.ceu.setOutsideTouchable(false);
            this.ceu.setBackgroundDrawable(new ColorDrawable(0));
            ((TextView) inflate.findViewById(b.e.pop_button)).setOnClickListener(new h());
            this.ceu.a(new i());
        }
        PolyActivity polyActivity = (PolyActivity) getContext();
        if (polyActivity.isFinishing()) {
            return;
        }
        this.ceu.showAtLocation(polyActivity.getWindow().getDecorView(), 0, 0, 0);
    }

    private void o(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("default", this.cey);
            jSONObject.put("selected", str);
        } catch (JSONException e2) {
        }
        com.baidu.poly.a.h.d.a(new com.baidu.poly.a.h.b("5").an(jSONObject));
    }

    public m aaU() {
        if (!this.G) {
            this.G = true;
            if (!(getContext() instanceof Activity)) {
                throw new IllegalStateException("can not attach to context " + getContext());
            }
            this.ced.a("收银台加载中...");
            com.baidu.poly.util.d.info("ChannelListView->attach()");
            ha();
        }
        return this;
    }

    public void e() {
        com.baidu.poly.a.l.a.a(this.cdO);
        this.cdO = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class k implements l.h {
        k() {
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void b() {
            m.this.aaS();
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void d() {
            if (m.this.ceq != null) {
                m.this.ceq.b(m.this.cec);
            }
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void onDetach() {
            m.this.ceq = null;
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void a(a.C0314a c0314a, com.baidu.poly.a.k.a aVar) {
            if (c0314a != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(c0314a.cdA);
                if (m.this.ceg != null && m.this.ceg.P() == 1) {
                    arrayList.add(m.this.ceg.O());
                }
                m.this.a(arrayList, aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(o[] oVarArr) {
        this.cep.setMinimumHeight(0);
        if (oVarArr != null) {
            this.cee.removeAllViews();
            for (o oVar : oVarArr) {
                com.baidu.poly.widget.a aVar = new com.baidu.poly.widget.a(getContext());
                aVar.a(oVar, new j(oVarArr, oVar));
                this.cee.addView(aVar);
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
                    this.ces = -1L;
                } else {
                    this.ces = Long.valueOf(Long.parseLong(string));
                }
            } catch (Exception e2) {
                com.baidu.poly.util.d.info("totalAmount is not long");
            }
        }
        this.ccb = bundle;
        aaS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(o oVar) {
        if (oVar != null) {
            com.baidu.poly.a.h.a.d(Long.valueOf(System.currentTimeMillis()));
            JSONArray jSONArray = new JSONArray();
            try {
                if (this.ceg != null && this.ceg.P() == 1 && !TextUtils.isEmpty(this.ceg.O())) {
                    jSONArray.put(new JSONObject(this.ceg.O()));
                }
                if (this.cen.getSelectedItem() != null && !TextUtils.isEmpty(this.cen.getSelectedItem().cdA)) {
                    jSONArray.put(new JSONObject(this.cen.getSelectedItem().cdA));
                }
            } catch (Exception e2) {
            }
            if (jSONArray.length() > 0) {
                this.ccb.putString("hostMarketingDetail", jSONArray.toString());
            }
            if (this.cet != null) {
                this.cev = oVar.R();
                this.cet.b(this.ccb, oVar.R(), this);
            }
        }
    }

    public void c(Bundle bundle, String str) {
        this.cev = str;
        if (this.cet != null) {
            this.H = true;
            this.la = false;
            com.baidu.poly.a.h.a.d(Long.valueOf(System.currentTimeMillis()));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            this.cdO = com.baidu.poly.a.l.a.a(this, layoutParams, getResources().getString(b.g.poly_fast_pay_loading), -1L);
            this.cet.b(bundle, str, this);
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
        com.baidu.poly.a.k.b.a(this.ccb.getString("bduss"), this.ccb.getString("appKey"), this.ces + "", list, new a(aVar));
    }

    private String a(long j2) {
        return new DecimalFormat("0.00").format((j2 * 1.0d) / 100.0d);
    }
}

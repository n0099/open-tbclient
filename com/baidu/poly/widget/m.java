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
    private TextView U;
    private a.b bGO;
    private Bundle bGR;
    private com.baidu.poly.a.l.c bIC;
    private Runnable bIE;
    private View bIP;
    private PolyFrameLayout bIQ;
    private TipView bIR;
    private ViewGroup bIS;
    private ProgressButton bIT;
    private o bIU;
    private o[] bIV;
    private l bIW;
    private Animation bIX;
    private Animation bIY;
    private HostMarketView bIZ;
    private com.baidu.poly.widget.coupon.a bIh;
    private TextView bJa;
    private View bJb;
    private CouponEntranceView bJc;
    private View bJd;
    private View bJe;
    private com.baidu.poly.widget.coupon.l bJf;
    private Long bJg;
    private Long bJh;
    private com.baidu.poly.a.j.c bJi;
    private com.baidu.poly.widget.c bJj;
    private String bJk;
    private boolean bJl;
    private boolean bJm;
    private String bJn;
    private boolean la;
    private boolean ma;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a implements com.baidu.poly.a.k.a {
        final /* synthetic */ com.baidu.poly.a.k.a bGu;

        a(com.baidu.poly.a.k.a aVar) {
            this.bGu = aVar;
        }

        @Override // com.baidu.poly.a.k.a
        public void a(a.C0270a c0270a) {
            if (c0270a.statusCode == 0) {
                m.this.bJg = Long.valueOf(c0270a.bGs);
                m.this.UA();
                if (m.this.bIU != null && m.this.bIU.P() == 1) {
                    m.this.bIU.l(c0270a.bGt);
                }
            }
            this.bGu.a(c0270a);
            m.this.bJc.h();
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
            m.this.bJg = Long.valueOf(jSONObject.optLong("payMoney"));
            JSONArray optJSONArray = jSONObject.optJSONArray("payChannels");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                o[] oVarArr = new o[optJSONArray.length()];
                for (int i = 0; i < optJSONArray.length(); i++) {
                    o oVar = new o(optJSONArray.optJSONObject(i));
                    if (oVar.P() == 1) {
                        m.this.bJn = oVar.R();
                    }
                    oVarArr[i] = oVar;
                }
                m.this.bIV = oVarArr;
                m.this.bIh = new com.baidu.poly.widget.coupon.a(jSONObject.optJSONArray("coupons"));
                m.this.bJc.a(m.this.bIh);
                if (m.this.bJf != null) {
                    m.this.bJf.a(m.this.bIh.bIk);
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("marketChannels");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    m.this.bIU = new o(optJSONArray2.optJSONObject(0));
                }
                com.baidu.poly.a.h.a.j("7");
                if (m.this.bIV.length != 1 || m.this.bJc.getVisibility() != 8 || m.this.bIU != null || m.this.bIV[0] == null) {
                    m.this.UA();
                    if (m.this.bIU != null || m.this.bJc.getVisibility() != 8) {
                        m.this.bJb.setVisibility(0);
                    } else {
                        m.this.bJb.setVisibility(8);
                    }
                    m.this.ba();
                    m mVar = m.this;
                    mVar.b(mVar.a(mVar.bIV));
                    m.this.bIR.j();
                    m.this.Uy();
                    m.this.bJm = true;
                    m.this.UD();
                    return;
                }
                m.this.bJm = true;
                m.this.UD();
                m.this.bIR.b(m.this.bIV[0].Q(), "即将进入" + m.this.bIV[0].getDisplayName() + "…");
                m mVar2 = m.this;
                mVar2.b(mVar2.bIV[0]);
                return;
            }
            com.baidu.poly.a.h.a.a("7", null, null);
            a(new com.baidu.poly.a.i.b("channelList is null"), "request channelList payChannels is null");
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            if (m.this.bIV == null) {
                m mVar = m.this;
                mVar.n(mVar.getResources().getString(b.g.common_error_tips));
                m.this.onResult(3, "request channel list fail");
                m.this.detach();
                com.baidu.poly.a.h.d.a(new com.baidu.poly.a.h.b("1").hY(new com.baidu.poly.a.i.a("gatewaylist error --> " + str, th).U()));
            }
        }
    }

    /* loaded from: classes6.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            m.this.Uz();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class d implements Animation.AnimationListener {
        d() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            m.this.bJl = true;
            m.this.UD();
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
            m.this.bIQ.a(true);
            m mVar = m.this;
            mVar.postDelayed(mVar.bIE, 500L);
            if (oVar != null) {
                ArrayList arrayList = new ArrayList();
                if (z) {
                    arrayList.add(oVar.O());
                }
                if (m.this.bJc.getSelectedItem() != null) {
                    arrayList.add(m.this.bJc.getSelectedItem().bIo);
                }
                m.this.a(arrayList, aVar);
            }
        }

        @Override // com.baidu.poly.widget.hostmarket.HostMarketView.a
        public void b(a.C0270a c0270a) {
            m.this.bIQ.a(false);
            m mVar = m.this;
            mVar.removeCallbacks(mVar.bIE);
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
                mVar.startAnimation(mVar.bIY);
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
            if (m.this.bJj == null || !m.this.bJj.isShowing()) {
                return;
            }
            m.this.bJj.dismiss();
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
    public class j implements a.InterfaceC0275a {
        final /* synthetic */ o[] bIN;
        final /* synthetic */ o bIO;

        j(o[] oVarArr, o oVar) {
            this.bIN = oVarArr;
            this.bIO = oVar;
        }

        @Override // com.baidu.poly.widget.a.InterfaceC0275a
        public void a() {
            o[] oVarArr = this.bIN;
            int length = oVarArr.length;
            for (int i = 0; i < length; i++) {
                o oVar = oVarArr[i];
                oVar.i(oVar == this.bIO ? 1 : 0);
            }
            m.this.b(this.bIN);
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
        this.bIE = new c();
        this.bJl = false;
        this.bJm = false;
        Ux();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UA() {
        Long l2;
        Long l3 = this.bJh;
        if (l3 != null && (l2 = this.bJg) != null) {
            if (l3.equals(l2)) {
                this.bJa.setText(a(this.bJg.longValue()));
                this.U.setVisibility(8);
            } else {
                this.U.setVisibility(0);
                this.bJa.setText(a(this.bJg.longValue()));
                this.U.setText(" ¥" + a(this.bJh.longValue()));
            }
            if (this.bJd.getVisibility() != 0) {
                this.bJd.setVisibility(0);
            }
        }
    }

    private void UB() {
        List<a.C0277a> list;
        com.baidu.poly.widget.coupon.a aVar = this.bIh;
        if (aVar != null && (list = aVar.bIk) != null && list.size() > 0) {
            this.bJf = new com.baidu.poly.widget.coupon.l(getContext());
            this.bJf.a(this.bIQ.getMeasuredHeight());
            this.bJf.setListener(new k());
            this.bJf.a(this.bIh.bIk);
            this.bJf.a(this.bIQ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UC() {
        com.baidu.poly.a.b.b.TT().a(this.bGR, new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UD() {
        if (this.bJl && this.bJm) {
            com.baidu.poly.a.h.a.F();
        }
    }

    private void Ux() {
        this.bIX = AnimationUtils.loadAnimation(getContext(), b.a.slide_in_bottom);
        this.bIY = AnimationUtils.loadAnimation(getContext(), b.a.slide_out_bottom);
        LayoutInflater.from(getContext()).inflate(b.f.view_channel_list, this);
        this.bIP = findViewById(b.e.bg_view);
        this.bIQ = (PolyFrameLayout) findViewById(b.e.popup_view);
        this.bJd = findViewById(b.e.pay_money_layout);
        this.bJe = findViewById(b.e.channel_list_scroll_view);
        this.bIR = (TipView) findViewById(b.e.tip_view);
        this.bIS = (ViewGroup) findViewById(b.e.channel_list_view);
        this.bIT = (ProgressButton) findViewById(b.e.pay_button);
        this.bJb = findViewById(b.e.line);
        findViewById(b.e.close_button).setOnClickListener(this);
        this.bIT.setOnClickListener(this);
        this.bIZ = (HostMarketView) findViewById(b.e.hostmarket);
        this.bJc = (CouponEntranceView) findViewById(b.e.coupon);
        this.bJc.setOnClickListener(this);
        this.bJa = (TextView) findViewById(b.e.money);
        this.U = (TextView) findViewById(b.e.cut);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uy() {
        if (this.I <= 0) {
            this.bIT.setVisibility(4);
            return;
        }
        this.bIT.setVisibility(0);
        this.bIT.setEnable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uz() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.bIC = com.baidu.poly.a.l.a.a(this.bIQ, layoutParams, "加载中", -1L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa() {
        com.baidu.poly.widget.c cVar = this.bJj;
        boolean z = ((cVar != null && cVar.isShowing()) || this.H || this.G) ? false : true;
        if ((!TextUtils.isEmpty(this.bJk) && (TextUtils.equals(this.bJk, "BAIDU-ALIPAY-WISE") || TextUtils.equals(this.bJk, "BAIDU-ALIPAY-WISE-HUABEI-PAY"))) || this.ma) {
            com.baidu.poly.util.d.info("ChannelListView->confirmViewClose() ali pay channel");
            z &= this.la;
        }
        com.baidu.poly.util.d.info("ChannelListView->confirmViewClose() canFinishActivity = " + z);
        if (!z || this.bIW == null) {
            return;
        }
        com.baidu.poly.util.d.info("ChannelListView->confirmViewClose() finish activity");
        this.bIW.onClose();
        this.bIW = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ba() {
        this.bIZ.a(this.bIU);
        this.bIZ.setListener(new e());
    }

    private void ha() {
        this.bIP.setVisibility(0);
        this.bIQ.setVisibility(0);
        this.bIP.setAlpha(0.0f);
        this.bIP.animate().alpha(0.65f).setDuration(240L).start();
        this.bIQ.startAnimation(this.bIX);
        this.bIX.setAnimationListener(new d());
        Uy();
    }

    public void detach() {
        if (this.G) {
            this.G = false;
            this.bIP.animate().alpha(0.0f).setDuration(240L).start();
            postDelayed(new f(), 240L);
            postDelayed(new g(), 480L);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.H || super.dispatchTouchEvent(motionEvent);
    }

    public boolean onBackPressed() {
        com.baidu.poly.widget.coupon.l lVar = this.bJf;
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
                this.bIT.startLoading();
                this.H = true;
                this.la = false;
                o[] oVarArr = this.bIV;
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
            UB();
        }
    }

    public void onResult(int i2, String str) {
        com.baidu.poly.util.d.info("ChannelListView->onResult() statusCode = " + i2 + " result = " + str);
        this.la = true;
        a.b bVar = this.bGO;
        if (bVar != null) {
            bVar.onResult(i2, str);
            this.bGO = null;
        }
        com.baidu.poly.a.h.d.b(i2, str);
        if (((PolyActivity) getContext()).isFinishing()) {
            com.baidu.poly.a.h.d.flush();
        }
        aa();
    }

    public void setCloseListener(l lVar) {
        this.bIW = lVar;
    }

    public void setIsPreparePaying(boolean z) {
        this.H = z;
        aa();
        detach();
    }

    public void setResultListener(a.b bVar) {
        this.bGO = bVar;
    }

    public void setWalletList(com.baidu.poly.a.j.c cVar) {
        this.bJi = cVar;
    }

    public void setWechatH5Pay(boolean z) {
        this.ma = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(String str) {
        if (TextUtils.isEmpty(str)) {
            str = getResources().getString(b.g.common_error_tips);
        }
        if (this.bJj == null) {
            View inflate = View.inflate(this.bIS.getContext(), b.f.default_pop_window, null);
            ((TextView) inflate.findViewById(b.e.pop_title)).setText("支付失败");
            ((TextView) inflate.findViewById(b.e.pop_tips)).setText(str.trim());
            this.bJj = new com.baidu.poly.widget.c(inflate, -1, -1, true);
            this.bJj.setClippingEnabled(false);
            this.bJj.setOutsideTouchable(false);
            this.bJj.setBackgroundDrawable(new ColorDrawable(0));
            ((TextView) inflate.findViewById(b.e.pop_button)).setOnClickListener(new h());
            this.bJj.a(new i());
        }
        PolyActivity polyActivity = (PolyActivity) getContext();
        if (polyActivity.isFinishing()) {
            return;
        }
        this.bJj.showAtLocation(polyActivity.getWindow().getDecorView(), 0, 0, 0);
    }

    private void o(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("default", this.bJn);
            jSONObject.put("selected", str);
        } catch (JSONException e2) {
        }
        com.baidu.poly.a.h.d.a(new com.baidu.poly.a.h.b("5").ae(jSONObject));
    }

    public m UE() {
        if (!this.G) {
            this.G = true;
            if (!(getContext() instanceof Activity)) {
                throw new IllegalStateException("can not attach to context " + getContext());
            }
            this.bIR.a("收银台加载中...");
            com.baidu.poly.util.d.info("ChannelListView->attach()");
            ha();
        }
        return this;
    }

    public void e() {
        com.baidu.poly.a.l.a.a(this.bIC);
        this.bIC = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class k implements l.h {
        k() {
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void b() {
            m.this.UC();
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void d() {
            if (m.this.bJf != null) {
                m.this.bJf.b(m.this.bIQ);
            }
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void onDetach() {
            m.this.bJf = null;
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void a(a.C0277a c0277a, com.baidu.poly.a.k.a aVar) {
            if (c0277a != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(c0277a.bIo);
                if (m.this.bIU != null && m.this.bIU.P() == 1) {
                    arrayList.add(m.this.bIU.O());
                }
                m.this.a(arrayList, aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(o[] oVarArr) {
        this.bJe.setMinimumHeight(0);
        if (oVarArr != null) {
            this.bIS.removeAllViews();
            for (o oVar : oVarArr) {
                com.baidu.poly.widget.a aVar = new com.baidu.poly.widget.a(getContext());
                aVar.a(oVar, new j(oVarArr, oVar));
                this.bIS.addView(aVar);
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
                    this.bJh = -1L;
                } else {
                    this.bJh = Long.valueOf(Long.parseLong(string));
                }
            } catch (Exception e2) {
                com.baidu.poly.util.d.info("totalAmount is not long");
            }
        }
        this.bGR = bundle;
        UC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(o oVar) {
        if (oVar != null) {
            com.baidu.poly.a.h.a.c(Long.valueOf(System.currentTimeMillis()));
            JSONArray jSONArray = new JSONArray();
            try {
                if (this.bIU != null && this.bIU.P() == 1 && !TextUtils.isEmpty(this.bIU.O())) {
                    jSONArray.put(new JSONObject(this.bIU.O()));
                }
                if (this.bJc.getSelectedItem() != null && !TextUtils.isEmpty(this.bJc.getSelectedItem().bIo)) {
                    jSONArray.put(new JSONObject(this.bJc.getSelectedItem().bIo));
                }
            } catch (Exception e2) {
            }
            if (jSONArray.length() > 0) {
                this.bGR.putString("hostMarketingDetail", jSONArray.toString());
            }
            if (this.bJi != null) {
                this.bJk = oVar.R();
                this.bJi.b(this.bGR, oVar.R(), this);
            }
        }
    }

    public void c(Bundle bundle, String str) {
        this.bJk = str;
        if (this.bJi != null) {
            this.H = true;
            this.la = false;
            com.baidu.poly.a.h.a.c(Long.valueOf(System.currentTimeMillis()));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            this.bIC = com.baidu.poly.a.l.a.a(this, layoutParams, getResources().getString(b.g.poly_fast_pay_loading), -1L);
            this.bJi.b(bundle, str, this);
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
        com.baidu.poly.a.k.b.a(this.bGR.getString("bduss"), this.bGR.getString("appKey"), this.bJh + "", list, new a(aVar));
    }

    private String a(long j2) {
        return new DecimalFormat("0.00").format((j2 * 1.0d) / 100.0d);
    }
}

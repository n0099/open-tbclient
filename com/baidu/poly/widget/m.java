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
    private a.b bPC;
    private Bundle bPF;
    private com.baidu.poly.widget.coupon.a bQV;
    private View bRD;
    private PolyFrameLayout bRE;
    private TipView bRF;
    private ViewGroup bRG;
    private ProgressButton bRH;
    private o bRI;
    private o[] bRJ;
    private l bRK;
    private Animation bRL;
    private Animation bRM;
    private HostMarketView bRN;
    private View bRO;
    private CouponEntranceView bRP;
    private View bRQ;
    private View bRR;
    private com.baidu.poly.widget.coupon.l bRS;
    private Long bRT;
    private Long bRU;
    private com.baidu.poly.a.j.c bRV;
    private com.baidu.poly.widget.c bRW;
    private String bRX;
    private boolean bRY;
    private boolean bRZ;
    private com.baidu.poly.a.l.c bRq;
    private Runnable bRs;
    private String bSa;
    private boolean la;
    private boolean ma;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a implements com.baidu.poly.a.k.a {
        final /* synthetic */ com.baidu.poly.a.k.a bPi;

        a(com.baidu.poly.a.k.a aVar) {
            this.bPi = aVar;
        }

        @Override // com.baidu.poly.a.k.a
        public void a(a.C0283a c0283a) {
            if (c0283a.statusCode == 0) {
                m.this.bRT = Long.valueOf(c0283a.bPg);
                m.this.Xg();
                if (m.this.bRI != null && m.this.bRI.P() == 1) {
                    m.this.bRI.l(c0283a.bPh);
                }
            }
            this.bPi.a(c0283a);
            m.this.bRP.h();
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
            m.this.bRT = Long.valueOf(jSONObject.optLong("payMoney"));
            JSONArray optJSONArray = jSONObject.optJSONArray("payChannels");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                o[] oVarArr = new o[optJSONArray.length()];
                for (int i = 0; i < optJSONArray.length(); i++) {
                    o oVar = new o(optJSONArray.optJSONObject(i));
                    if (oVar.P() == 1) {
                        m.this.bSa = oVar.R();
                    }
                    oVarArr[i] = oVar;
                }
                m.this.bRJ = oVarArr;
                m.this.bQV = new com.baidu.poly.widget.coupon.a(jSONObject.optJSONArray("coupons"));
                m.this.bRP.a(m.this.bQV);
                if (m.this.bRS != null) {
                    m.this.bRS.a(m.this.bQV.bQY);
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("marketChannels");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    m.this.bRI = new o(optJSONArray2.optJSONObject(0));
                }
                com.baidu.poly.a.h.a.j("7");
                if (m.this.bRJ.length != 1 || m.this.bRP.getVisibility() != 8 || m.this.bRI != null || m.this.bRJ[0] == null) {
                    m.this.Xg();
                    if (m.this.bRI != null || m.this.bRP.getVisibility() != 8) {
                        m.this.bRO.setVisibility(0);
                    } else {
                        m.this.bRO.setVisibility(8);
                    }
                    m.this.ba();
                    m mVar = m.this;
                    mVar.b(mVar.a(mVar.bRJ));
                    m.this.bRF.j();
                    m.this.Xe();
                    m.this.bRZ = true;
                    m.this.Xj();
                    return;
                }
                m.this.bRZ = true;
                m.this.Xj();
                m.this.bRF.b(m.this.bRJ[0].Q(), "即将进入" + m.this.bRJ[0].getDisplayName() + "…");
                m mVar2 = m.this;
                mVar2.b(mVar2.bRJ[0]);
                return;
            }
            com.baidu.poly.a.h.a.a("7", null, null);
            a(new com.baidu.poly.a.i.b("channelList is null"), "request channelList payChannels is null");
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            if (m.this.bRJ == null) {
                m mVar = m.this;
                mVar.n(mVar.getResources().getString(b.g.common_error_tips));
                m.this.onResult(3, "request channel list fail");
                m.this.detach();
                com.baidu.poly.a.h.d.a(new com.baidu.poly.a.h.b("1").iU(new com.baidu.poly.a.i.a("gatewaylist error --> " + str, th).U()));
            }
        }
    }

    /* loaded from: classes6.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            m.this.Xf();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class d implements Animation.AnimationListener {
        d() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            m.this.bRY = true;
            m.this.Xj();
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
            m.this.bRE.a(true);
            m mVar = m.this;
            mVar.postDelayed(mVar.bRs, 500L);
            if (oVar != null) {
                ArrayList arrayList = new ArrayList();
                if (z) {
                    arrayList.add(oVar.O());
                }
                if (m.this.bRP.getSelectedItem() != null) {
                    arrayList.add(m.this.bRP.getSelectedItem().bRc);
                }
                m.this.a(arrayList, aVar);
            }
        }

        @Override // com.baidu.poly.widget.hostmarket.HostMarketView.a
        public void b(a.C0283a c0283a) {
            m.this.bRE.a(false);
            m mVar = m.this;
            mVar.removeCallbacks(mVar.bRs);
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
                mVar.startAnimation(mVar.bRM);
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
            if (m.this.bRW == null || !m.this.bRW.isShowing()) {
                return;
            }
            m.this.bRW.dismiss();
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
    public class j implements a.InterfaceC0288a {
        final /* synthetic */ o[] bRB;
        final /* synthetic */ o bRC;

        j(o[] oVarArr, o oVar) {
            this.bRB = oVarArr;
            this.bRC = oVar;
        }

        @Override // com.baidu.poly.widget.a.InterfaceC0288a
        public void a() {
            o[] oVarArr = this.bRB;
            int length = oVarArr.length;
            for (int i = 0; i < length; i++) {
                o oVar = oVarArr[i];
                oVar.i(oVar == this.bRC ? 1 : 0);
            }
            m.this.b(this.bRB);
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
        this.bRs = new c();
        this.bRY = false;
        this.bRZ = false;
        Xd();
    }

    private void Xd() {
        this.bRL = AnimationUtils.loadAnimation(getContext(), b.a.slide_in_bottom);
        this.bRM = AnimationUtils.loadAnimation(getContext(), b.a.slide_out_bottom);
        LayoutInflater.from(getContext()).inflate(b.f.view_channel_list, this);
        this.bRD = findViewById(b.e.bg_view);
        this.bRE = (PolyFrameLayout) findViewById(b.e.popup_view);
        this.bRQ = findViewById(b.e.pay_money_layout);
        this.bRR = findViewById(b.e.channel_list_scroll_view);
        this.bRF = (TipView) findViewById(b.e.tip_view);
        this.bRG = (ViewGroup) findViewById(b.e.channel_list_view);
        this.bRH = (ProgressButton) findViewById(b.e.pay_button);
        this.bRO = findViewById(b.e.line);
        findViewById(b.e.close_button).setOnClickListener(this);
        this.bRH.setOnClickListener(this);
        this.bRN = (HostMarketView) findViewById(b.e.hostmarket);
        this.bRP = (CouponEntranceView) findViewById(b.e.coupon);
        this.bRP.setOnClickListener(this);
        this.S = (TextView) findViewById(b.e.money);
        this.U = (TextView) findViewById(b.e.cut);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xe() {
        if (this.I <= 0) {
            this.bRH.setVisibility(4);
            return;
        }
        this.bRH.setVisibility(0);
        this.bRH.setEnable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xf() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.bRq = com.baidu.poly.a.l.a.a(this.bRE, layoutParams, "加载中", -1L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xg() {
        Long l2;
        Long l3 = this.bRU;
        if (l3 != null && (l2 = this.bRT) != null) {
            if (l3.equals(l2)) {
                this.S.setText(a(this.bRT.longValue()));
                this.U.setVisibility(8);
            } else {
                this.U.setVisibility(0);
                this.S.setText(a(this.bRT.longValue()));
                this.U.setText(" ¥" + a(this.bRU.longValue()));
            }
            if (this.bRQ.getVisibility() != 0) {
                this.bRQ.setVisibility(0);
            }
        }
    }

    private void Xh() {
        List<a.C0290a> list;
        com.baidu.poly.widget.coupon.a aVar = this.bQV;
        if (aVar != null && (list = aVar.bQY) != null && list.size() > 0) {
            this.bRS = new com.baidu.poly.widget.coupon.l(getContext());
            this.bRS.a(this.bRE.getMeasuredHeight());
            this.bRS.setListener(new k());
            this.bRS.a(this.bQV.bQY);
            this.bRS.a(this.bRE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xi() {
        com.baidu.poly.a.b.b.Wz().a(this.bPF, new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xj() {
        if (this.bRY && this.bRZ) {
            com.baidu.poly.a.h.a.F();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa() {
        com.baidu.poly.widget.c cVar = this.bRW;
        boolean z = ((cVar != null && cVar.isShowing()) || this.H || this.G) ? false : true;
        if ((!TextUtils.isEmpty(this.bRX) && (TextUtils.equals(this.bRX, "BAIDU-ALIPAY-WISE") || TextUtils.equals(this.bRX, "BAIDU-ALIPAY-WISE-HUABEI-PAY"))) || this.ma) {
            com.baidu.poly.util.d.info("ChannelListView->confirmViewClose() ali pay channel");
            z &= this.la;
        }
        com.baidu.poly.util.d.info("ChannelListView->confirmViewClose() canFinishActivity = " + z);
        if (!z || this.bRK == null) {
            return;
        }
        com.baidu.poly.util.d.info("ChannelListView->confirmViewClose() finish activity");
        this.bRK.onClose();
        this.bRK = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ba() {
        this.bRN.a(this.bRI);
        this.bRN.setListener(new e());
    }

    private void ha() {
        this.bRD.setVisibility(0);
        this.bRE.setVisibility(0);
        this.bRD.setAlpha(0.0f);
        this.bRD.animate().alpha(0.65f).setDuration(240L).start();
        this.bRE.startAnimation(this.bRL);
        this.bRL.setAnimationListener(new d());
        Xe();
    }

    public void detach() {
        if (this.G) {
            this.G = false;
            this.bRD.animate().alpha(0.0f).setDuration(240L).start();
            postDelayed(new f(), 240L);
            postDelayed(new g(), 480L);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.H || super.dispatchTouchEvent(motionEvent);
    }

    public boolean onBackPressed() {
        com.baidu.poly.widget.coupon.l lVar = this.bRS;
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
                this.bRH.startLoading();
                this.H = true;
                this.la = false;
                o[] oVarArr = this.bRJ;
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
            Xh();
        }
    }

    public void onResult(int i2, String str) {
        com.baidu.poly.util.d.info("ChannelListView->onResult() statusCode = " + i2 + " result = " + str);
        this.la = true;
        a.b bVar = this.bPC;
        if (bVar != null) {
            bVar.onResult(i2, str);
            this.bPC = null;
        }
        com.baidu.poly.a.h.d.b(i2, str);
        if (((PolyActivity) getContext()).isFinishing()) {
            com.baidu.poly.a.h.d.flush();
        }
        aa();
    }

    public void setCloseListener(l lVar) {
        this.bRK = lVar;
    }

    public void setIsPreparePaying(boolean z) {
        this.H = z;
        aa();
        detach();
    }

    public void setResultListener(a.b bVar) {
        this.bPC = bVar;
    }

    public void setWalletList(com.baidu.poly.a.j.c cVar) {
        this.bRV = cVar;
    }

    public void setWechatH5Pay(boolean z) {
        this.ma = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(String str) {
        if (TextUtils.isEmpty(str)) {
            str = getResources().getString(b.g.common_error_tips);
        }
        if (this.bRW == null) {
            View inflate = View.inflate(this.bRG.getContext(), b.f.default_pop_window, null);
            ((TextView) inflate.findViewById(b.e.pop_title)).setText("支付失败");
            ((TextView) inflate.findViewById(b.e.pop_tips)).setText(str.trim());
            this.bRW = new com.baidu.poly.widget.c(inflate, -1, -1, true);
            this.bRW.setClippingEnabled(false);
            this.bRW.setOutsideTouchable(false);
            this.bRW.setBackgroundDrawable(new ColorDrawable(0));
            ((TextView) inflate.findViewById(b.e.pop_button)).setOnClickListener(new h());
            this.bRW.a(new i());
        }
        PolyActivity polyActivity = (PolyActivity) getContext();
        if (polyActivity.isFinishing()) {
            return;
        }
        this.bRW.showAtLocation(polyActivity.getWindow().getDecorView(), 0, 0, 0);
    }

    private void o(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("default", this.bSa);
            jSONObject.put("selected", str);
        } catch (JSONException e2) {
        }
        com.baidu.poly.a.h.d.a(new com.baidu.poly.a.h.b("5").ak(jSONObject));
    }

    public m Xk() {
        if (!this.G) {
            this.G = true;
            if (!(getContext() instanceof Activity)) {
                throw new IllegalStateException("can not attach to context " + getContext());
            }
            this.bRF.a("收银台加载中...");
            com.baidu.poly.util.d.info("ChannelListView->attach()");
            ha();
        }
        return this;
    }

    public void e() {
        com.baidu.poly.a.l.a.a(this.bRq);
        this.bRq = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class k implements l.h {
        k() {
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void b() {
            m.this.Xi();
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void d() {
            if (m.this.bRS != null) {
                m.this.bRS.b(m.this.bRE);
            }
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void onDetach() {
            m.this.bRS = null;
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void a(a.C0290a c0290a, com.baidu.poly.a.k.a aVar) {
            if (c0290a != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(c0290a.bRc);
                if (m.this.bRI != null && m.this.bRI.P() == 1) {
                    arrayList.add(m.this.bRI.O());
                }
                m.this.a(arrayList, aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(o[] oVarArr) {
        this.bRR.setMinimumHeight(0);
        if (oVarArr != null) {
            this.bRG.removeAllViews();
            for (o oVar : oVarArr) {
                com.baidu.poly.widget.a aVar = new com.baidu.poly.widget.a(getContext());
                aVar.a(oVar, new j(oVarArr, oVar));
                this.bRG.addView(aVar);
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
                    this.bRU = -1L;
                } else {
                    this.bRU = Long.valueOf(Long.parseLong(string));
                }
            } catch (Exception e2) {
                com.baidu.poly.util.d.info("totalAmount is not long");
            }
        }
        this.bPF = bundle;
        Xi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(o oVar) {
        if (oVar != null) {
            com.baidu.poly.a.h.a.c(Long.valueOf(System.currentTimeMillis()));
            JSONArray jSONArray = new JSONArray();
            try {
                if (this.bRI != null && this.bRI.P() == 1 && !TextUtils.isEmpty(this.bRI.O())) {
                    jSONArray.put(new JSONObject(this.bRI.O()));
                }
                if (this.bRP.getSelectedItem() != null && !TextUtils.isEmpty(this.bRP.getSelectedItem().bRc)) {
                    jSONArray.put(new JSONObject(this.bRP.getSelectedItem().bRc));
                }
            } catch (Exception e2) {
            }
            if (jSONArray.length() > 0) {
                this.bPF.putString("hostMarketingDetail", jSONArray.toString());
            }
            if (this.bRV != null) {
                this.bRX = oVar.R();
                this.bRV.b(this.bPF, oVar.R(), this);
            }
        }
    }

    public void c(Bundle bundle, String str) {
        this.bRX = str;
        if (this.bRV != null) {
            this.H = true;
            this.la = false;
            com.baidu.poly.a.h.a.c(Long.valueOf(System.currentTimeMillis()));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            this.bRq = com.baidu.poly.a.l.a.a(this, layoutParams, getResources().getString(b.g.poly_fast_pay_loading), -1L);
            this.bRV.b(bundle, str, this);
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
        com.baidu.poly.a.k.b.a(this.bPF.getString("bduss"), this.bPF.getString("appKey"), this.bRU + "", list, new a(aVar));
    }

    private String a(long j2) {
        return new DecimalFormat("0.00").format((j2 * 1.0d) / 100.0d);
    }
}

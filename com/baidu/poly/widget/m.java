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
/* loaded from: classes19.dex */
public class m extends FrameLayout implements View.OnClickListener {
    private boolean G;
    private boolean H;
    private int I;
    private TextView S;
    private TextView U;
    private a.b ciC;
    private Bundle ciF;
    private com.baidu.poly.widget.coupon.a cjX;
    private View ckG;
    private PolyFrameLayout ckH;
    private TipView ckI;
    private ViewGroup ckJ;
    private ProgressButton ckK;
    private o ckL;
    private o[] ckM;
    private l ckN;
    private Animation ckO;
    private Animation ckP;
    private HostMarketView ckQ;
    private View ckR;
    private CouponEntranceView ckS;
    private View ckT;
    private View ckU;
    private com.baidu.poly.widget.coupon.l ckV;
    private Long ckW;
    private Long ckX;
    private com.baidu.poly.a.j.c ckY;
    private com.baidu.poly.widget.c ckZ;
    private com.baidu.poly.a.l.c ckt;
    private Runnable ckv;
    private String cla;
    private boolean clb;
    private boolean clc;
    private boolean la;
    private boolean ma;
    private String qa;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class a implements com.baidu.poly.a.k.a {
        final /* synthetic */ com.baidu.poly.a.k.a cii;

        a(com.baidu.poly.a.k.a aVar) {
            this.cii = aVar;
        }

        @Override // com.baidu.poly.a.k.a
        public void a(a.C0318a c0318a) {
            if (c0318a.statusCode == 0) {
                m.this.ckW = Long.valueOf(c0318a.cig);
                m.this.adZ();
                if (m.this.ckL != null && m.this.ckL.P() == 1) {
                    m.this.ckL.l(c0318a.cih);
                }
            }
            this.cii.a(c0318a);
            m.this.ckS.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class b extends com.baidu.poly.a.a.a<JSONObject> {
        b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.poly.a.a.a
        public void a(JSONObject jSONObject) {
            m.this.ckW = Long.valueOf(jSONObject.optLong("payMoney"));
            JSONArray optJSONArray = jSONObject.optJSONArray("payChannels");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                o[] oVarArr = new o[optJSONArray.length()];
                for (int i = 0; i < optJSONArray.length(); i++) {
                    o oVar = new o(optJSONArray.optJSONObject(i));
                    if (oVar.P() == 1) {
                        m.this.qa = oVar.R();
                    }
                    oVarArr[i] = oVar;
                }
                m.this.ckM = oVarArr;
                m.this.cjX = new com.baidu.poly.widget.coupon.a(jSONObject.optJSONArray("coupons"));
                m.this.ckS.a(m.this.cjX);
                if (m.this.ckV != null) {
                    m.this.ckV.a(m.this.cjX.cka);
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("marketChannels");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    m.this.ckL = new o(optJSONArray2.optJSONObject(0));
                }
                com.baidu.poly.a.h.a.j("7");
                if (m.this.ckM.length != 1 || m.this.ckS.getVisibility() != 8 || m.this.ckL != null || m.this.ckM[0] == null) {
                    m.this.adZ();
                    if (m.this.ckL != null || m.this.ckS.getVisibility() != 8) {
                        m.this.ckR.setVisibility(0);
                    } else {
                        m.this.ckR.setVisibility(8);
                    }
                    m.this.adY();
                    m mVar = m.this;
                    mVar.b(mVar.a(mVar.ckM));
                    m.this.ckI.j();
                    m.this.adW();
                    m.this.clc = true;
                    m.this.aeb();
                    return;
                }
                m.this.clc = true;
                m.this.aeb();
                m.this.ckI.b(m.this.ckM[0].Q(), "即将进入" + m.this.ckM[0].getDisplayName() + "…");
                m mVar2 = m.this;
                mVar2.b(mVar2.ckM[0]);
                return;
            }
            com.baidu.poly.a.h.a.a("7", null, null);
            a(new com.baidu.poly.a.i.b("channelList is null"), "request channelList payChannels is null");
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            if (m.this.ckM == null) {
                m mVar = m.this;
                mVar.n(mVar.getResources().getString(b.g.common_error_tips));
                m.this.onResult(3, "request channel list fail");
                m.this.detach();
                com.baidu.poly.a.h.d.a(new com.baidu.poly.a.h.b("1").kb(new com.baidu.poly.a.i.a("gatewaylist error --> " + str, th).U()));
            }
        }
    }

    /* loaded from: classes19.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            m.this.adX();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class d implements Animation.AnimationListener {
        d() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            m.this.clb = true;
            m.this.aeb();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class e implements HostMarketView.a {
        e() {
        }

        @Override // com.baidu.poly.widget.hostmarket.HostMarketView.a
        public void a(boolean z, o oVar, com.baidu.poly.a.k.a aVar) {
            m.this.ckH.a(true);
            m mVar = m.this;
            mVar.postDelayed(mVar.ckv, 500L);
            if (oVar != null) {
                ArrayList arrayList = new ArrayList();
                if (z) {
                    arrayList.add(oVar.O());
                }
                if (m.this.ckS.getSelectedItem() != null) {
                    arrayList.add(m.this.ckS.getSelectedItem().ckf);
                }
                m.this.a(arrayList, aVar);
            }
        }

        @Override // com.baidu.poly.widget.hostmarket.HostMarketView.a
        public void b(a.C0318a c0318a) {
            m.this.ckH.a(false);
            m mVar = m.this;
            mVar.removeCallbacks(mVar.ckv);
            m.this.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.getParent() instanceof ViewGroup) {
                m mVar = m.this;
                mVar.startAnimation(mVar.ckP);
                ((ViewGroup) m.this.getParent()).removeView(m.this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            m.this.aa();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (m.this.ckZ == null || !m.this.ckZ.isShowing()) {
                return;
            }
            m.this.ckZ.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class i implements c.b {
        i() {
        }

        @Override // com.baidu.poly.widget.c.b
        public void onDismiss() {
            m.this.aa();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class j implements a.InterfaceC0323a {
        final /* synthetic */ o[] ckE;
        final /* synthetic */ o ckF;

        j(o[] oVarArr, o oVar) {
            this.ckE = oVarArr;
            this.ckF = oVar;
        }

        @Override // com.baidu.poly.widget.a.InterfaceC0323a
        public void a() {
            o[] oVarArr = this.ckE;
            int length = oVarArr.length;
            for (int i = 0; i < length; i++) {
                o oVar = oVarArr[i];
                oVar.i(oVar == this.ckF ? 1 : 0);
            }
            m.this.b(this.ckE);
        }
    }

    /* loaded from: classes19.dex */
    public interface l {
        void onClose();
    }

    public m(PolyActivity polyActivity) {
        super(polyActivity);
        this.la = true;
        this.ma = false;
        this.ckv = new c();
        this.clb = false;
        this.clc = false;
        adV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa() {
        com.baidu.poly.widget.c cVar = this.ckZ;
        boolean z = ((cVar != null && cVar.isShowing()) || this.H || this.G) ? false : true;
        if ((!TextUtils.isEmpty(this.cla) && (TextUtils.equals(this.cla, "BAIDU-ALIPAY-WISE") || TextUtils.equals(this.cla, "BAIDU-ALIPAY-WISE-HUABEI-PAY"))) || this.ma) {
            com.baidu.poly.util.d.info("ChannelListView->confirmViewClose() ali pay channel");
            z &= this.la;
        }
        com.baidu.poly.util.d.info("ChannelListView->confirmViewClose() canFinishActivity = " + z);
        if (!z || this.ckN == null) {
            return;
        }
        com.baidu.poly.util.d.info("ChannelListView->confirmViewClose() finish activity");
        this.ckN.onClose();
        this.ckN = null;
    }

    private void adV() {
        this.ckO = AnimationUtils.loadAnimation(getContext(), b.a.slide_in_bottom);
        this.ckP = AnimationUtils.loadAnimation(getContext(), b.a.slide_out_bottom);
        LayoutInflater.from(getContext()).inflate(b.f.view_channel_list, this);
        this.ckG = findViewById(b.e.bg_view);
        this.ckH = (PolyFrameLayout) findViewById(b.e.popup_view);
        this.ckT = findViewById(b.e.pay_money_layout);
        this.ckU = findViewById(b.e.channel_list_scroll_view);
        this.ckI = (TipView) findViewById(b.e.tip_view);
        this.ckJ = (ViewGroup) findViewById(b.e.channel_list_view);
        this.ckK = (ProgressButton) findViewById(b.e.pay_button);
        this.ckR = findViewById(b.e.line);
        findViewById(b.e.close_button).setOnClickListener(this);
        this.ckK.setOnClickListener(this);
        this.ckQ = (HostMarketView) findViewById(b.e.hostmarket);
        this.ckS = (CouponEntranceView) findViewById(b.e.coupon);
        this.ckS.setOnClickListener(this);
        this.S = (TextView) findViewById(b.e.money);
        this.U = (TextView) findViewById(b.e.cut);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adW() {
        if (this.I <= 0) {
            this.ckK.setVisibility(4);
            return;
        }
        this.ckK.setVisibility(0);
        this.ckK.setEnable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adX() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.ckt = com.baidu.poly.a.l.a.a(this.ckH, layoutParams, "加载中", -1L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adY() {
        this.ckQ.a(this.ckL);
        this.ckQ.setListener(new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adZ() {
        Long l2;
        Long l3 = this.ckX;
        if (l3 != null && (l2 = this.ckW) != null) {
            if (l3.equals(l2)) {
                this.S.setText(a(this.ckW.longValue()));
                this.U.setVisibility(8);
            } else {
                this.U.setVisibility(0);
                this.S.setText(a(this.ckW.longValue()));
                this.U.setText(" ¥" + a(this.ckX.longValue()));
            }
            if (this.ckT.getVisibility() != 0) {
                this.ckT.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aea() {
        com.baidu.poly.a.b.b.adr().a(this.ciF, new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeb() {
        if (this.clb && this.clc) {
            com.baidu.poly.a.h.a.F();
        }
    }

    private void da() {
        List<a.C0325a> list;
        com.baidu.poly.widget.coupon.a aVar = this.cjX;
        if (aVar != null && (list = aVar.cka) != null && list.size() > 0) {
            this.ckV = new com.baidu.poly.widget.coupon.l(getContext());
            this.ckV.a(this.ckH.getMeasuredHeight());
            this.ckV.setListener(new k());
            this.ckV.a(this.cjX.cka);
            this.ckV.a(this.ckH);
        }
    }

    private void ha() {
        this.ckG.setVisibility(0);
        this.ckH.setVisibility(0);
        this.ckG.setAlpha(0.0f);
        this.ckG.animate().alpha(0.65f).setDuration(240L).start();
        this.ckH.startAnimation(this.ckO);
        this.ckO.setAnimationListener(new d());
        adW();
    }

    public void detach() {
        if (this.G) {
            this.G = false;
            this.ckG.animate().alpha(0.0f).setDuration(240L).start();
            postDelayed(new f(), 240L);
            postDelayed(new g(), 480L);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.H || super.dispatchTouchEvent(motionEvent);
    }

    public boolean onBackPressed() {
        com.baidu.poly.widget.coupon.l lVar = this.ckV;
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
                this.ckK.startLoading();
                this.H = true;
                this.la = false;
                o[] oVarArr = this.ckM;
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
            da();
        }
    }

    public void onResult(int i2, String str) {
        com.baidu.poly.util.d.info("ChannelListView->onResult() statusCode = " + i2 + " result = " + str);
        this.la = true;
        a.b bVar = this.ciC;
        if (bVar != null) {
            bVar.onResult(i2, str);
            this.ciC = null;
        }
        com.baidu.poly.a.h.d.b(i2, str);
        if (((PolyActivity) getContext()).isFinishing()) {
            com.baidu.poly.a.h.d.flush();
        }
        aa();
    }

    public void setCloseListener(l lVar) {
        this.ckN = lVar;
    }

    public void setIsPreparePaying(boolean z) {
        this.H = z;
        aa();
        detach();
    }

    public void setResultListener(a.b bVar) {
        this.ciC = bVar;
    }

    public void setWalletList(com.baidu.poly.a.j.c cVar) {
        this.ckY = cVar;
    }

    public void setWechatH5Pay(boolean z) {
        this.ma = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(String str) {
        if (TextUtils.isEmpty(str)) {
            str = getResources().getString(b.g.common_error_tips);
        }
        if (this.ckZ == null) {
            View inflate = View.inflate(this.ckJ.getContext(), b.f.default_pop_window, null);
            ((TextView) inflate.findViewById(b.e.pop_title)).setText("支付失败");
            ((TextView) inflate.findViewById(b.e.pop_tips)).setText(str.trim());
            this.ckZ = new com.baidu.poly.widget.c(inflate, -1, -1, true);
            this.ckZ.setClippingEnabled(false);
            this.ckZ.setOutsideTouchable(false);
            this.ckZ.setBackgroundDrawable(new ColorDrawable(0));
            ((TextView) inflate.findViewById(b.e.pop_button)).setOnClickListener(new h());
            this.ckZ.a(new i());
        }
        PolyActivity polyActivity = (PolyActivity) getContext();
        if (polyActivity.isFinishing()) {
            return;
        }
        this.ckZ.showAtLocation(polyActivity.getWindow().getDecorView(), 0, 0, 0);
    }

    private void o(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("default", this.qa);
            jSONObject.put("selected", str);
        } catch (JSONException e2) {
        }
        com.baidu.poly.a.h.d.a(new com.baidu.poly.a.h.b("5").ap(jSONObject));
    }

    public m aec() {
        if (!this.G) {
            this.G = true;
            if (!(getContext() instanceof Activity)) {
                throw new IllegalStateException("can not attach to context " + getContext());
            }
            this.ckI.a("收银台加载中...");
            com.baidu.poly.util.d.info("ChannelListView->attach()");
            ha();
        }
        return this;
    }

    public void e() {
        com.baidu.poly.a.l.a.a(this.ckt);
        this.ckt = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class k implements l.h {
        k() {
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void b() {
            m.this.aea();
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void d() {
            if (m.this.ckV != null) {
                m.this.ckV.b(m.this.ckH);
            }
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void onDetach() {
            m.this.ckV = null;
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void a(a.C0325a c0325a, com.baidu.poly.a.k.a aVar) {
            if (c0325a != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(c0325a.ckf);
                if (m.this.ckL != null && m.this.ckL.P() == 1) {
                    arrayList.add(m.this.ckL.O());
                }
                m.this.a(arrayList, aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(o[] oVarArr) {
        this.ckU.setMinimumHeight(0);
        if (oVarArr != null) {
            this.ckJ.removeAllViews();
            for (o oVar : oVarArr) {
                com.baidu.poly.widget.a aVar = new com.baidu.poly.widget.a(getContext());
                aVar.a(oVar, new j(oVarArr, oVar));
                this.ckJ.addView(aVar);
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
                    this.ckX = -1L;
                } else {
                    this.ckX = Long.valueOf(Long.parseLong(string));
                }
            } catch (Exception e2) {
                com.baidu.poly.util.d.info("totalAmount is not long");
            }
        }
        this.ciF = bundle;
        aea();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(o oVar) {
        if (oVar != null) {
            com.baidu.poly.a.h.a.d(Long.valueOf(System.currentTimeMillis()));
            JSONArray jSONArray = new JSONArray();
            try {
                if (this.ckL != null && this.ckL.P() == 1 && !TextUtils.isEmpty(this.ckL.O())) {
                    jSONArray.put(new JSONObject(this.ckL.O()));
                }
                if (this.ckS.getSelectedItem() != null && !TextUtils.isEmpty(this.ckS.getSelectedItem().ckf)) {
                    jSONArray.put(new JSONObject(this.ckS.getSelectedItem().ckf));
                }
            } catch (Exception e2) {
            }
            if (jSONArray.length() > 0) {
                this.ciF.putString("hostMarketingDetail", jSONArray.toString());
            }
            if (this.ckY != null) {
                this.cla = oVar.R();
                this.ckY.b(this.ciF, oVar.R(), this);
            }
        }
    }

    public void c(Bundle bundle, String str) {
        this.cla = str;
        if (this.ckY != null) {
            this.H = true;
            this.la = false;
            com.baidu.poly.a.h.a.d(Long.valueOf(System.currentTimeMillis()));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            this.ckt = com.baidu.poly.a.l.a.a(this, layoutParams, getResources().getString(b.g.poly_fast_pay_loading), -1L);
            this.ckY.b(bundle, str, this);
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
        com.baidu.poly.a.k.b.a(this.ciF.getString("bduss"), this.ciF.getString("appKey"), this.ckX + "", list, new a(aVar));
    }

    private String a(long j2) {
        return new DecimalFormat("0.00").format((j2 * 1.0d) / 100.0d);
    }
}

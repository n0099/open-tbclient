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
/* loaded from: classes4.dex */
public class m extends FrameLayout implements View.OnClickListener {
    private boolean G;
    private boolean H;
    private int I;
    private TextView S;
    private TextView U;
    private a.b cpF;
    private Bundle cpI;
    private View crJ;
    private PolyFrameLayout crK;
    private TipView crL;
    private ViewGroup crM;
    private ProgressButton crN;
    private o crO;
    private o[] crP;
    private l crQ;
    private Animation crR;
    private Animation crS;
    private HostMarketView crT;
    private View crU;
    private CouponEntranceView crV;
    private View crW;
    private View crX;
    private com.baidu.poly.widget.coupon.l crY;
    private Long crZ;
    private com.baidu.poly.widget.coupon.a cra;
    private com.baidu.poly.a.l.c crw;
    private Runnable cry;
    private Long csa;
    private com.baidu.poly.a.j.c csb;
    private com.baidu.poly.widget.c csc;
    private String csd;
    private boolean cse;
    private boolean csf;
    private boolean la;
    private boolean ma;
    private String qa;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements com.baidu.poly.a.k.a {
        final /* synthetic */ com.baidu.poly.a.k.a cpk;

        a(com.baidu.poly.a.k.a aVar) {
            this.cpk = aVar;
        }

        @Override // com.baidu.poly.a.k.a
        public void a(a.C0318a c0318a) {
            if (c0318a.statusCode == 0) {
                m.this.crZ = Long.valueOf(c0318a.cpi);
                m.this.afV();
                if (m.this.crO != null && m.this.crO.P() == 1) {
                    m.this.crO.l(c0318a.cpj);
                }
            }
            this.cpk.a(c0318a);
            m.this.crV.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b extends com.baidu.poly.a.a.a<JSONObject> {
        b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.poly.a.a.a
        public void a(JSONObject jSONObject) {
            m.this.crZ = Long.valueOf(jSONObject.optLong("payMoney"));
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
                m.this.crP = oVarArr;
                m.this.cra = new com.baidu.poly.widget.coupon.a(jSONObject.optJSONArray("coupons"));
                m.this.crV.a(m.this.cra);
                if (m.this.crY != null) {
                    m.this.crY.a(m.this.cra.cre);
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("marketChannels");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    m.this.crO = new o(optJSONArray2.optJSONObject(0));
                }
                com.baidu.poly.a.h.a.j("7");
                if (m.this.crP.length != 1 || m.this.crV.getVisibility() != 8 || m.this.crO != null || m.this.crP[0] == null) {
                    m.this.afV();
                    if (m.this.crO != null || m.this.crV.getVisibility() != 8) {
                        m.this.crU.setVisibility(0);
                    } else {
                        m.this.crU.setVisibility(8);
                    }
                    m.this.afU();
                    m mVar = m.this;
                    mVar.b(mVar.a(mVar.crP));
                    m.this.crL.j();
                    m.this.afS();
                    m.this.csf = true;
                    m.this.afX();
                    return;
                }
                m.this.csf = true;
                m.this.afX();
                m.this.crL.b(m.this.crP[0].Q(), "即将进入" + m.this.crP[0].getDisplayName() + "…");
                m mVar2 = m.this;
                mVar2.b(mVar2.crP[0]);
                return;
            }
            com.baidu.poly.a.h.a.a("7", null, null);
            a(new com.baidu.poly.a.i.b("channelList is null"), "request channelList payChannels is null");
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            if (m.this.crP == null) {
                m mVar = m.this;
                mVar.n(mVar.getResources().getString(b.g.common_error_tips));
                m.this.onResult(3, "request channel list fail");
                m.this.detach();
                com.baidu.poly.a.h.d.a(new com.baidu.poly.a.h.b("1").jX(new com.baidu.poly.a.i.a("gatewaylist error --> " + str, th).U()));
            }
        }
    }

    /* loaded from: classes4.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            m.this.afT();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class d implements Animation.AnimationListener {
        d() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            m.this.cse = true;
            m.this.afX();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class e implements HostMarketView.a {
        e() {
        }

        @Override // com.baidu.poly.widget.hostmarket.HostMarketView.a
        public void a(boolean z, o oVar, com.baidu.poly.a.k.a aVar) {
            m.this.crK.a(true);
            m mVar = m.this;
            mVar.postDelayed(mVar.cry, 500L);
            if (oVar != null) {
                ArrayList arrayList = new ArrayList();
                if (z) {
                    arrayList.add(oVar.O());
                }
                if (m.this.crV.getSelectedItem() != null) {
                    arrayList.add(m.this.crV.getSelectedItem().crj);
                }
                m.this.a(arrayList, aVar);
            }
        }

        @Override // com.baidu.poly.widget.hostmarket.HostMarketView.a
        public void b(a.C0318a c0318a) {
            m.this.crK.a(false);
            m mVar = m.this;
            mVar.removeCallbacks(mVar.cry);
            m.this.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.getParent() instanceof ViewGroup) {
                m mVar = m.this;
                mVar.startAnimation(mVar.crS);
                ((ViewGroup) m.this.getParent()).removeView(m.this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            m.this.aa();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (m.this.csc == null || !m.this.csc.isShowing()) {
                return;
            }
            m.this.csc.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class i implements c.b {
        i() {
        }

        @Override // com.baidu.poly.widget.c.b
        public void onDismiss() {
            m.this.aa();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class j implements a.InterfaceC0323a {
        final /* synthetic */ o[] crH;
        final /* synthetic */ o crI;

        j(o[] oVarArr, o oVar) {
            this.crH = oVarArr;
            this.crI = oVar;
        }

        @Override // com.baidu.poly.widget.a.InterfaceC0323a
        public void a() {
            o[] oVarArr = this.crH;
            int length = oVarArr.length;
            for (int i = 0; i < length; i++) {
                o oVar = oVarArr[i];
                oVar.i(oVar == this.crI ? 1 : 0);
            }
            m.this.b(this.crH);
        }
    }

    /* loaded from: classes4.dex */
    public interface l {
        void onClose();
    }

    public m(PolyActivity polyActivity) {
        super(polyActivity);
        this.la = true;
        this.ma = false;
        this.cry = new c();
        this.cse = false;
        this.csf = false;
        afR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa() {
        com.baidu.poly.widget.c cVar = this.csc;
        boolean z = ((cVar != null && cVar.isShowing()) || this.H || this.G) ? false : true;
        if ((!TextUtils.isEmpty(this.csd) && (TextUtils.equals(this.csd, "BAIDU-ALIPAY-WISE") || TextUtils.equals(this.csd, "BAIDU-ALIPAY-WISE-HUABEI-PAY"))) || this.ma) {
            com.baidu.poly.util.d.info("ChannelListView->confirmViewClose() ali pay channel");
            z &= this.la;
        }
        com.baidu.poly.util.d.info("ChannelListView->confirmViewClose() canFinishActivity = " + z);
        if (!z || this.crQ == null) {
            return;
        }
        com.baidu.poly.util.d.info("ChannelListView->confirmViewClose() finish activity");
        this.crQ.onClose();
        this.crQ = null;
    }

    private void afR() {
        this.crR = AnimationUtils.loadAnimation(getContext(), b.a.slide_in_bottom);
        this.crS = AnimationUtils.loadAnimation(getContext(), b.a.slide_out_bottom);
        LayoutInflater.from(getContext()).inflate(b.f.view_channel_list, this);
        this.crJ = findViewById(b.e.bg_view);
        this.crK = (PolyFrameLayout) findViewById(b.e.popup_view);
        this.crW = findViewById(b.e.pay_money_layout);
        this.crX = findViewById(b.e.channel_list_scroll_view);
        this.crL = (TipView) findViewById(b.e.tip_view);
        this.crM = (ViewGroup) findViewById(b.e.channel_list_view);
        this.crN = (ProgressButton) findViewById(b.e.pay_button);
        this.crU = findViewById(b.e.line);
        findViewById(b.e.close_button).setOnClickListener(this);
        this.crN.setOnClickListener(this);
        this.crT = (HostMarketView) findViewById(b.e.hostmarket);
        this.crV = (CouponEntranceView) findViewById(b.e.coupon);
        this.crV.setOnClickListener(this);
        this.S = (TextView) findViewById(b.e.money);
        this.U = (TextView) findViewById(b.e.cut);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afS() {
        if (this.I <= 0) {
            this.crN.setVisibility(4);
            return;
        }
        this.crN.setVisibility(0);
        this.crN.setEnable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afT() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.crw = com.baidu.poly.a.l.a.a(this.crK, layoutParams, "加载中", -1L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afU() {
        this.crT.a(this.crO);
        this.crT.setListener(new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afV() {
        Long l2;
        Long l3 = this.csa;
        if (l3 != null && (l2 = this.crZ) != null) {
            if (l3.equals(l2)) {
                this.S.setText(a(this.crZ.longValue()));
                this.U.setVisibility(8);
            } else {
                this.U.setVisibility(0);
                this.S.setText(a(this.crZ.longValue()));
                this.U.setText(" ¥" + a(this.csa.longValue()));
            }
            if (this.crW.getVisibility() != 0) {
                this.crW.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afW() {
        com.baidu.poly.a.b.b.afo().a(this.cpI, new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afX() {
        if (this.cse && this.csf) {
            com.baidu.poly.a.h.a.F();
        }
    }

    private void da() {
        List<a.C0325a> list;
        com.baidu.poly.widget.coupon.a aVar = this.cra;
        if (aVar != null && (list = aVar.cre) != null && list.size() > 0) {
            this.crY = new com.baidu.poly.widget.coupon.l(getContext());
            this.crY.a(this.crK.getMeasuredHeight());
            this.crY.setListener(new k());
            this.crY.a(this.cra.cre);
            this.crY.a(this.crK);
        }
    }

    private void ha() {
        this.crJ.setVisibility(0);
        this.crK.setVisibility(0);
        this.crJ.setAlpha(0.0f);
        this.crJ.animate().alpha(0.65f).setDuration(240L).start();
        this.crK.startAnimation(this.crR);
        this.crR.setAnimationListener(new d());
        afS();
    }

    public void detach() {
        if (this.G) {
            this.G = false;
            this.crJ.animate().alpha(0.0f).setDuration(240L).start();
            postDelayed(new f(), 240L);
            postDelayed(new g(), 480L);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.H || super.dispatchTouchEvent(motionEvent);
    }

    public boolean onBackPressed() {
        com.baidu.poly.widget.coupon.l lVar = this.crY;
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
                this.crN.startLoading();
                this.H = true;
                this.la = false;
                o[] oVarArr = this.crP;
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
        a.b bVar = this.cpF;
        if (bVar != null) {
            bVar.onResult(i2, str);
            this.cpF = null;
        }
        com.baidu.poly.a.h.d.b(i2, str);
        if (((PolyActivity) getContext()).isFinishing()) {
            com.baidu.poly.a.h.d.flush();
        }
        aa();
    }

    public void setCloseListener(l lVar) {
        this.crQ = lVar;
    }

    public void setIsPreparePaying(boolean z) {
        this.H = z;
        aa();
        detach();
    }

    public void setResultListener(a.b bVar) {
        this.cpF = bVar;
    }

    public void setWalletList(com.baidu.poly.a.j.c cVar) {
        this.csb = cVar;
    }

    public void setWechatH5Pay(boolean z) {
        this.ma = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(String str) {
        if (TextUtils.isEmpty(str)) {
            str = getResources().getString(b.g.common_error_tips);
        }
        if (this.csc == null) {
            View inflate = View.inflate(this.crM.getContext(), b.f.default_pop_window, null);
            ((TextView) inflate.findViewById(b.e.pop_title)).setText("支付失败");
            ((TextView) inflate.findViewById(b.e.pop_tips)).setText(str.trim());
            this.csc = new com.baidu.poly.widget.c(inflate, -1, -1, true);
            this.csc.ei(false);
            this.csc.eh(false);
            this.csc.setBackgroundDrawable(new ColorDrawable(0));
            ((TextView) inflate.findViewById(b.e.pop_button)).setOnClickListener(new h());
            this.csc.a(new i());
        }
        PolyActivity polyActivity = (PolyActivity) getContext();
        if (polyActivity.isFinishing()) {
            return;
        }
        this.csc.showAtLocation(polyActivity.getWindow().getDecorView(), 0, 0, 0);
    }

    private void o(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("default", this.qa);
            jSONObject.put("selected", str);
        } catch (JSONException e2) {
        }
        com.baidu.poly.a.h.d.a(new com.baidu.poly.a.h.b("5").ax(jSONObject));
    }

    public m afY() {
        if (!this.G) {
            this.G = true;
            if (!(getContext() instanceof Activity)) {
                throw new IllegalStateException("can not attach to context " + getContext());
            }
            this.crL.a("收银台加载中...");
            com.baidu.poly.util.d.info("ChannelListView->attach()");
            ha();
        }
        return this;
    }

    public void e() {
        com.baidu.poly.a.l.a.a(this.crw);
        this.crw = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class k implements l.h {
        k() {
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void b() {
            m.this.afW();
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void d() {
            if (m.this.crY != null) {
                m.this.crY.b(m.this.crK);
            }
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void onDetach() {
            m.this.crY = null;
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void a(a.C0325a c0325a, com.baidu.poly.a.k.a aVar) {
            if (c0325a != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(c0325a.crj);
                if (m.this.crO != null && m.this.crO.P() == 1) {
                    arrayList.add(m.this.crO.O());
                }
                m.this.a(arrayList, aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(o[] oVarArr) {
        this.crX.setMinimumHeight(0);
        if (oVarArr != null) {
            this.crM.removeAllViews();
            for (o oVar : oVarArr) {
                com.baidu.poly.widget.a aVar = new com.baidu.poly.widget.a(getContext());
                aVar.a(oVar, new j(oVarArr, oVar));
                this.crM.addView(aVar);
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
                    this.csa = -1L;
                } else {
                    this.csa = Long.valueOf(Long.parseLong(string));
                }
            } catch (Exception e2) {
                com.baidu.poly.util.d.info("totalAmount is not long");
            }
        }
        this.cpI = bundle;
        afW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(o oVar) {
        if (oVar != null) {
            com.baidu.poly.a.h.a.d(Long.valueOf(System.currentTimeMillis()));
            JSONArray jSONArray = new JSONArray();
            try {
                if (this.crO != null && this.crO.P() == 1 && !TextUtils.isEmpty(this.crO.O())) {
                    jSONArray.put(new JSONObject(this.crO.O()));
                }
                if (this.crV.getSelectedItem() != null && !TextUtils.isEmpty(this.crV.getSelectedItem().crj)) {
                    jSONArray.put(new JSONObject(this.crV.getSelectedItem().crj));
                }
            } catch (Exception e2) {
            }
            if (jSONArray.length() > 0) {
                this.cpI.putString("hostMarketingDetail", jSONArray.toString());
            }
            if (this.csb != null) {
                this.csd = oVar.R();
                this.csb.b(this.cpI, oVar.R(), this);
            }
        }
    }

    public void c(Bundle bundle, String str) {
        this.csd = str;
        if (this.csb != null) {
            this.H = true;
            this.la = false;
            com.baidu.poly.a.h.a.d(Long.valueOf(System.currentTimeMillis()));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            this.crw = com.baidu.poly.a.l.a.a(this, layoutParams, getResources().getString(b.g.poly_fast_pay_loading), -1L);
            this.csb.b(bundle, str, this);
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
        com.baidu.poly.a.k.b.a(this.cpI.getString("bduss"), this.cpI.getString("appKey"), this.csa + "", list, new a(aVar));
    }

    private String a(long j2) {
        return new DecimalFormat("0.00").format((j2 * 1.0d) / 100.0d);
    }
}

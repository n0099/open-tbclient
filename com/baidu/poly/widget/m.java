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
import com.baidu.searchbox.config.DefaultSharedPrefsWrapper;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class m extends FrameLayout implements View.OnClickListener {
    private boolean G;
    private boolean H;
    private int I;
    private TextView S;
    private TextView U;
    private a.b cqI;
    private Bundle cqL;
    private Runnable csB;
    private View csM;
    private PolyFrameLayout csN;
    private TipView csO;
    private ViewGroup csP;
    private ProgressButton csQ;
    private o csR;
    private o[] csS;
    private l csT;
    private Animation csU;
    private Animation csV;
    private HostMarketView csW;
    private View csX;
    private CouponEntranceView csY;
    private View csZ;
    private com.baidu.poly.widget.coupon.a cse;
    private com.baidu.poly.a.l.c csz;
    private View cta;
    private com.baidu.poly.widget.coupon.l ctb;
    private Long ctc;
    private Long ctd;
    private com.baidu.poly.a.j.c cte;
    private com.baidu.poly.widget.c ctf;
    private String ctg;
    private boolean cth;
    private boolean cti;
    private boolean la;
    private boolean ma;
    private String qa;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public class a implements com.baidu.poly.a.k.a {
        final /* synthetic */ com.baidu.poly.a.k.a cqo;

        a(com.baidu.poly.a.k.a aVar) {
            this.cqo = aVar;
        }

        @Override // com.baidu.poly.a.k.a
        public void a(a.C0311a c0311a) {
            if (c0311a.statusCode == 0) {
                m.this.ctc = Long.valueOf(c0311a.cqm);
                m.this.adS();
                if (m.this.csR != null && m.this.csR.P() == 1) {
                    m.this.csR.l(c0311a.cqn);
                }
            }
            this.cqo.a(c0311a);
            m.this.csY.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public class b extends com.baidu.poly.a.a.a<JSONObject> {
        b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.poly.a.a.a
        public void a(JSONObject jSONObject) {
            m.this.ctc = Long.valueOf(jSONObject.optLong("payMoney"));
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
                m.this.csS = oVarArr;
                m.this.cse = new com.baidu.poly.widget.coupon.a(jSONObject.optJSONArray("coupons"));
                m.this.csY.a(m.this.cse);
                if (m.this.ctb != null) {
                    m.this.ctb.a(m.this.cse.csh);
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("marketChannels");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    m.this.csR = new o(optJSONArray2.optJSONObject(0));
                }
                com.baidu.poly.a.h.a.j("7");
                if (m.this.csS.length != 1 || m.this.csY.getVisibility() != 8 || m.this.csR != null || m.this.csS[0] == null) {
                    m.this.adS();
                    if (m.this.csR != null || m.this.csY.getVisibility() != 8) {
                        m.this.csX.setVisibility(0);
                    } else {
                        m.this.csX.setVisibility(8);
                    }
                    m.this.adR();
                    m mVar = m.this;
                    mVar.b(mVar.a(mVar.csS));
                    m.this.csO.j();
                    m.this.adP();
                    m.this.cti = true;
                    m.this.adU();
                    return;
                }
                m.this.cti = true;
                m.this.adU();
                m.this.csO.b(m.this.csS[0].Q(), "即将进入" + m.this.csS[0].getDisplayName() + "…");
                m mVar2 = m.this;
                mVar2.b(mVar2.csS[0]);
                return;
            }
            com.baidu.poly.a.h.a.a("7", null, null);
            a(new com.baidu.poly.a.i.b("channelList is null"), "request channelList payChannels is null");
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            if (m.this.csS == null) {
                m mVar = m.this;
                mVar.n(mVar.getResources().getString(b.g.common_error_tips));
                m.this.onResult(3, "request channel list fail");
                m.this.detach();
                com.baidu.poly.a.h.d.a(new com.baidu.poly.a.h.b("1").jx(new com.baidu.poly.a.i.a("gatewaylist error --> " + str, th).U()));
            }
        }
    }

    /* loaded from: classes14.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            m.this.adQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public class d implements Animation.AnimationListener {
        d() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            m.this.cth = true;
            m.this.adU();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public class e implements HostMarketView.a {
        e() {
        }

        @Override // com.baidu.poly.widget.hostmarket.HostMarketView.a
        public void a(boolean z, o oVar, com.baidu.poly.a.k.a aVar) {
            m.this.csN.a(true);
            m mVar = m.this;
            mVar.postDelayed(mVar.csB, 500L);
            if (oVar != null) {
                ArrayList arrayList = new ArrayList();
                if (z) {
                    arrayList.add(oVar.O());
                }
                if (m.this.csY.getSelectedItem() != null) {
                    arrayList.add(m.this.csY.getSelectedItem().csm);
                }
                m.this.a(arrayList, aVar);
            }
        }

        @Override // com.baidu.poly.widget.hostmarket.HostMarketView.a
        public void b(a.C0311a c0311a) {
            m.this.csN.a(false);
            m mVar = m.this;
            mVar.removeCallbacks(mVar.csB);
            m.this.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.getParent() instanceof ViewGroup) {
                m mVar = m.this;
                mVar.startAnimation(mVar.csV);
                ((ViewGroup) m.this.getParent()).removeView(m.this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            m.this.aa();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (m.this.ctf == null || !m.this.ctf.isShowing()) {
                return;
            }
            m.this.ctf.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public class i implements c.b {
        i() {
        }

        @Override // com.baidu.poly.widget.c.b
        public void onDismiss() {
            m.this.aa();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public class j implements a.InterfaceC0316a {
        final /* synthetic */ o[] csK;
        final /* synthetic */ o csL;

        j(o[] oVarArr, o oVar) {
            this.csK = oVarArr;
            this.csL = oVar;
        }

        @Override // com.baidu.poly.widget.a.InterfaceC0316a
        public void a() {
            o[] oVarArr = this.csK;
            int length = oVarArr.length;
            for (int i = 0; i < length; i++) {
                o oVar = oVarArr[i];
                oVar.i(oVar == this.csL ? 1 : 0);
            }
            m.this.b(this.csK);
        }
    }

    /* loaded from: classes14.dex */
    public interface l {
        void onClose();
    }

    public m(PolyActivity polyActivity) {
        super(polyActivity);
        this.la = true;
        this.ma = false;
        this.csB = new c();
        this.cth = false;
        this.cti = false;
        adO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa() {
        com.baidu.poly.widget.c cVar = this.ctf;
        boolean z = ((cVar != null && cVar.isShowing()) || this.H || this.G) ? false : true;
        if ((!TextUtils.isEmpty(this.ctg) && (TextUtils.equals(this.ctg, "BAIDU-ALIPAY-WISE") || TextUtils.equals(this.ctg, "BAIDU-ALIPAY-WISE-HUABEI-PAY"))) || this.ma) {
            com.baidu.poly.util.d.info("ChannelListView->confirmViewClose() ali pay channel");
            z &= this.la;
        }
        com.baidu.poly.util.d.info("ChannelListView->confirmViewClose() canFinishActivity = " + z);
        if (!z || this.csT == null) {
            return;
        }
        com.baidu.poly.util.d.info("ChannelListView->confirmViewClose() finish activity");
        this.csT.onClose();
        this.csT = null;
    }

    private void adO() {
        this.csU = AnimationUtils.loadAnimation(getContext(), b.a.slide_in_bottom);
        this.csV = AnimationUtils.loadAnimation(getContext(), b.a.slide_out_bottom);
        LayoutInflater.from(getContext()).inflate(b.f.view_channel_list, this);
        this.csM = findViewById(b.e.bg_view);
        this.csN = (PolyFrameLayout) findViewById(b.e.popup_view);
        this.csZ = findViewById(b.e.pay_money_layout);
        this.cta = findViewById(b.e.channel_list_scroll_view);
        this.csO = (TipView) findViewById(b.e.tip_view);
        this.csP = (ViewGroup) findViewById(b.e.channel_list_view);
        this.csQ = (ProgressButton) findViewById(b.e.pay_button);
        this.csX = findViewById(b.e.line);
        findViewById(b.e.close_button).setOnClickListener(this);
        this.csQ.setOnClickListener(this);
        this.csW = (HostMarketView) findViewById(b.e.hostmarket);
        this.csY = (CouponEntranceView) findViewById(b.e.coupon);
        this.csY.setOnClickListener(this);
        this.S = (TextView) findViewById(b.e.money);
        this.U = (TextView) findViewById(b.e.cut);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adP() {
        if (this.I <= 0) {
            this.csQ.setVisibility(4);
            return;
        }
        this.csQ.setVisibility(0);
        this.csQ.setEnable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adQ() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.csz = com.baidu.poly.a.l.a.a(this.csN, layoutParams, "加载中", -1L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adR() {
        this.csW.a(this.csR);
        this.csW.setListener(new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adS() {
        Long l2;
        Long l3 = this.ctd;
        if (l3 != null && (l2 = this.ctc) != null) {
            if (l3.equals(l2)) {
                this.S.setText(a(this.ctc.longValue()));
                this.U.setVisibility(8);
            } else {
                this.U.setVisibility(0);
                this.S.setText(a(this.ctc.longValue()));
                this.U.setText(" ¥" + a(this.ctd.longValue()));
            }
            if (this.csZ.getVisibility() != 0) {
                this.csZ.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adT() {
        com.baidu.poly.a.b.b.adm().a(this.cqL, new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adU() {
        if (this.cth && this.cti) {
            com.baidu.poly.a.h.a.F();
        }
    }

    private void da() {
        List<a.C0318a> list;
        com.baidu.poly.widget.coupon.a aVar = this.cse;
        if (aVar != null && (list = aVar.csh) != null && list.size() > 0) {
            this.ctb = new com.baidu.poly.widget.coupon.l(getContext());
            this.ctb.a(this.csN.getMeasuredHeight());
            this.ctb.setListener(new k());
            this.ctb.a(this.cse.csh);
            this.ctb.a(this.csN);
        }
    }

    private void ha() {
        this.csM.setVisibility(0);
        this.csN.setVisibility(0);
        this.csM.setAlpha(0.0f);
        this.csM.animate().alpha(0.65f).setDuration(240L).start();
        this.csN.startAnimation(this.csU);
        this.csU.setAnimationListener(new d());
        adP();
    }

    public void detach() {
        if (this.G) {
            this.G = false;
            this.csM.animate().alpha(0.0f).setDuration(240L).start();
            postDelayed(new f(), 240L);
            postDelayed(new g(), 480L);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.H || super.dispatchTouchEvent(motionEvent);
    }

    public boolean onBackPressed() {
        com.baidu.poly.widget.coupon.l lVar = this.ctb;
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
                this.csQ.startLoading();
                this.H = true;
                this.la = false;
                o[] oVarArr = this.csS;
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
        a.b bVar = this.cqI;
        if (bVar != null) {
            bVar.onResult(i2, str);
            this.cqI = null;
        }
        com.baidu.poly.a.h.d.b(i2, str);
        if (((PolyActivity) getContext()).isFinishing()) {
            com.baidu.poly.a.h.d.flush();
        }
        aa();
    }

    public void setCloseListener(l lVar) {
        this.csT = lVar;
    }

    public void setIsPreparePaying(boolean z) {
        this.H = z;
        aa();
        detach();
    }

    public void setResultListener(a.b bVar) {
        this.cqI = bVar;
    }

    public void setWalletList(com.baidu.poly.a.j.c cVar) {
        this.cte = cVar;
    }

    public void setWechatH5Pay(boolean z) {
        this.ma = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(String str) {
        if (TextUtils.isEmpty(str)) {
            str = getResources().getString(b.g.common_error_tips);
        }
        if (this.ctf == null) {
            View inflate = View.inflate(this.csP.getContext(), b.f.default_pop_window, null);
            ((TextView) inflate.findViewById(b.e.pop_title)).setText("支付失败");
            ((TextView) inflate.findViewById(b.e.pop_tips)).setText(str.trim());
            this.ctf = new com.baidu.poly.widget.c(inflate, -1, -1, true);
            this.ctf.eo(false);
            this.ctf.en(false);
            this.ctf.setBackgroundDrawable(new ColorDrawable(0));
            ((TextView) inflate.findViewById(b.e.pop_button)).setOnClickListener(new h());
            this.ctf.a(new i());
        }
        PolyActivity polyActivity = (PolyActivity) getContext();
        if (polyActivity.isFinishing()) {
            return;
        }
        this.ctf.showAtLocation(polyActivity.getWindow().getDecorView(), 0, 0, 0);
    }

    private void o(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(DefaultSharedPrefsWrapper.SP_FILE_DEFAULT, this.qa);
            jSONObject.put("selected", str);
        } catch (JSONException e2) {
        }
        com.baidu.poly.a.h.d.a(new com.baidu.poly.a.h.b("5").aB(jSONObject));
    }

    public m adV() {
        if (!this.G) {
            this.G = true;
            if (!(getContext() instanceof Activity)) {
                throw new IllegalStateException("can not attach to context " + getContext());
            }
            this.csO.a("收银台加载中...");
            com.baidu.poly.util.d.info("ChannelListView->attach()");
            ha();
        }
        return this;
    }

    public void e() {
        com.baidu.poly.a.l.a.a(this.csz);
        this.csz = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public class k implements l.h {
        k() {
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void b() {
            m.this.adT();
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void d() {
            if (m.this.ctb != null) {
                m.this.ctb.b(m.this.csN);
            }
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void onDetach() {
            m.this.ctb = null;
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void a(a.C0318a c0318a, com.baidu.poly.a.k.a aVar) {
            if (c0318a != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(c0318a.csm);
                if (m.this.csR != null && m.this.csR.P() == 1) {
                    arrayList.add(m.this.csR.O());
                }
                m.this.a(arrayList, aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(o[] oVarArr) {
        this.cta.setMinimumHeight(0);
        if (oVarArr != null) {
            this.csP.removeAllViews();
            for (o oVar : oVarArr) {
                com.baidu.poly.widget.a aVar = new com.baidu.poly.widget.a(getContext());
                aVar.a(oVar, new j(oVarArr, oVar));
                this.csP.addView(aVar);
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
                    this.ctd = -1L;
                } else {
                    this.ctd = Long.valueOf(Long.parseLong(string));
                }
            } catch (Exception e2) {
                com.baidu.poly.util.d.info("totalAmount is not long");
            }
        }
        this.cqL = bundle;
        adT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(o oVar) {
        if (oVar != null) {
            com.baidu.poly.a.h.a.d(Long.valueOf(System.currentTimeMillis()));
            JSONArray jSONArray = new JSONArray();
            try {
                if (this.csR != null && this.csR.P() == 1 && !TextUtils.isEmpty(this.csR.O())) {
                    jSONArray.put(new JSONObject(this.csR.O()));
                }
                if (this.csY.getSelectedItem() != null && !TextUtils.isEmpty(this.csY.getSelectedItem().csm)) {
                    jSONArray.put(new JSONObject(this.csY.getSelectedItem().csm));
                }
            } catch (Exception e2) {
            }
            if (jSONArray.length() > 0) {
                this.cqL.putString("hostMarketingDetail", jSONArray.toString());
            }
            if (this.cte != null) {
                this.ctg = oVar.R();
                this.cte.b(this.cqL, oVar.R(), this);
            }
        }
    }

    public void c(Bundle bundle, String str) {
        this.ctg = str;
        if (this.cte != null) {
            this.H = true;
            this.la = false;
            com.baidu.poly.a.h.a.d(Long.valueOf(System.currentTimeMillis()));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            this.csz = com.baidu.poly.a.l.a.a(this, layoutParams, getResources().getString(b.g.poly_fast_pay_loading), -1L);
            this.cte.b(bundle, str, this);
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
        com.baidu.poly.a.k.b.a(this.cqL.getString("bduss"), this.cqL.getString("appKey"), this.ctd + "", list, new a(aVar));
    }

    private String a(long j2) {
        return new DecimalFormat("0.00").format((j2 * 1.0d) / 100.0d);
    }
}

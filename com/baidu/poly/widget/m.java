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
/* loaded from: classes4.dex */
public class m extends FrameLayout implements View.OnClickListener {
    private boolean G;
    private boolean H;
    private int I;
    private TextView S;
    private TextView U;
    private a.b cpg;
    private Bundle cpj;
    private com.baidu.poly.widget.coupon.a cqD;
    private com.baidu.poly.a.l.c cqY;
    private View crA;
    private com.baidu.poly.widget.coupon.l crB;
    private Long crC;
    private Long crD;
    private com.baidu.poly.a.j.c crE;
    private com.baidu.poly.widget.c crF;
    private String crG;
    private boolean crH;
    private boolean crI;
    private Runnable cra;
    private View crm;
    private PolyFrameLayout crn;
    private TipView cro;
    private ViewGroup crp;
    private ProgressButton crq;
    private o crr;
    private o[] crs;
    private l crt;
    private Animation cru;
    private Animation crv;
    private HostMarketView crw;
    private View crx;
    private CouponEntranceView cry;
    private View crz;
    private boolean la;
    private boolean ma;
    private String qa;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements com.baidu.poly.a.k.a {
        final /* synthetic */ com.baidu.poly.a.k.a coM;

        a(com.baidu.poly.a.k.a aVar) {
            this.coM = aVar;
        }

        @Override // com.baidu.poly.a.k.a
        public void a(a.C0305a c0305a) {
            if (c0305a.statusCode == 0) {
                m.this.crC = Long.valueOf(c0305a.coK);
                m.this.adP();
                if (m.this.crr != null && m.this.crr.P() == 1) {
                    m.this.crr.l(c0305a.coL);
                }
            }
            this.coM.a(c0305a);
            m.this.cry.h();
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
            m.this.crC = Long.valueOf(jSONObject.optLong("payMoney"));
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
                m.this.crs = oVarArr;
                m.this.cqD = new com.baidu.poly.widget.coupon.a(jSONObject.optJSONArray("coupons"));
                m.this.cry.a(m.this.cqD);
                if (m.this.crB != null) {
                    m.this.crB.a(m.this.cqD.cqG);
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("marketChannels");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    m.this.crr = new o(optJSONArray2.optJSONObject(0));
                }
                com.baidu.poly.a.h.a.j("7");
                if (m.this.crs.length != 1 || m.this.cry.getVisibility() != 8 || m.this.crr != null || m.this.crs[0] == null) {
                    m.this.adP();
                    if (m.this.crr != null || m.this.cry.getVisibility() != 8) {
                        m.this.crx.setVisibility(0);
                    } else {
                        m.this.crx.setVisibility(8);
                    }
                    m.this.adO();
                    m mVar = m.this;
                    mVar.b(mVar.a(mVar.crs));
                    m.this.cro.j();
                    m.this.adM();
                    m.this.crI = true;
                    m.this.adR();
                    return;
                }
                m.this.crI = true;
                m.this.adR();
                m.this.cro.b(m.this.crs[0].Q(), "即将进入" + m.this.crs[0].getDisplayName() + "…");
                m mVar2 = m.this;
                mVar2.b(mVar2.crs[0]);
                return;
            }
            com.baidu.poly.a.h.a.a("7", null, null);
            a(new com.baidu.poly.a.i.b("channelList is null"), "request channelList payChannels is null");
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            if (m.this.crs == null) {
                m mVar = m.this;
                mVar.n(mVar.getResources().getString(b.g.common_error_tips));
                m.this.onResult(3, "request channel list fail");
                m.this.detach();
                com.baidu.poly.a.h.d.a(new com.baidu.poly.a.h.b("1").jr(new com.baidu.poly.a.i.a("gatewaylist error --> " + str, th).U()));
            }
        }
    }

    /* loaded from: classes4.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            m.this.adN();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class d implements Animation.AnimationListener {
        d() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            m.this.crH = true;
            m.this.adR();
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
            m.this.crn.a(true);
            m mVar = m.this;
            mVar.postDelayed(mVar.cra, 500L);
            if (oVar != null) {
                ArrayList arrayList = new ArrayList();
                if (z) {
                    arrayList.add(oVar.O());
                }
                if (m.this.cry.getSelectedItem() != null) {
                    arrayList.add(m.this.cry.getSelectedItem().cqL);
                }
                m.this.a(arrayList, aVar);
            }
        }

        @Override // com.baidu.poly.widget.hostmarket.HostMarketView.a
        public void b(a.C0305a c0305a) {
            m.this.crn.a(false);
            m mVar = m.this;
            mVar.removeCallbacks(mVar.cra);
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
                mVar.startAnimation(mVar.crv);
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
            if (m.this.crF == null || !m.this.crF.isShowing()) {
                return;
            }
            m.this.crF.dismiss();
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
    public class j implements a.InterfaceC0310a {
        final /* synthetic */ o[] crk;
        final /* synthetic */ o crl;

        j(o[] oVarArr, o oVar) {
            this.crk = oVarArr;
            this.crl = oVar;
        }

        @Override // com.baidu.poly.widget.a.InterfaceC0310a
        public void a() {
            o[] oVarArr = this.crk;
            int length = oVarArr.length;
            for (int i = 0; i < length; i++) {
                o oVar = oVarArr[i];
                oVar.i(oVar == this.crl ? 1 : 0);
            }
            m.this.b(this.crk);
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
        this.cra = new c();
        this.crH = false;
        this.crI = false;
        adL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa() {
        com.baidu.poly.widget.c cVar = this.crF;
        boolean z = ((cVar != null && cVar.isShowing()) || this.H || this.G) ? false : true;
        if ((!TextUtils.isEmpty(this.crG) && (TextUtils.equals(this.crG, "BAIDU-ALIPAY-WISE") || TextUtils.equals(this.crG, "BAIDU-ALIPAY-WISE-HUABEI-PAY"))) || this.ma) {
            com.baidu.poly.util.d.info("ChannelListView->confirmViewClose() ali pay channel");
            z &= this.la;
        }
        com.baidu.poly.util.d.info("ChannelListView->confirmViewClose() canFinishActivity = " + z);
        if (!z || this.crt == null) {
            return;
        }
        com.baidu.poly.util.d.info("ChannelListView->confirmViewClose() finish activity");
        this.crt.onClose();
        this.crt = null;
    }

    private void adL() {
        this.cru = AnimationUtils.loadAnimation(getContext(), b.a.slide_in_bottom);
        this.crv = AnimationUtils.loadAnimation(getContext(), b.a.slide_out_bottom);
        LayoutInflater.from(getContext()).inflate(b.f.view_channel_list, this);
        this.crm = findViewById(b.e.bg_view);
        this.crn = (PolyFrameLayout) findViewById(b.e.popup_view);
        this.crz = findViewById(b.e.pay_money_layout);
        this.crA = findViewById(b.e.channel_list_scroll_view);
        this.cro = (TipView) findViewById(b.e.tip_view);
        this.crp = (ViewGroup) findViewById(b.e.channel_list_view);
        this.crq = (ProgressButton) findViewById(b.e.pay_button);
        this.crx = findViewById(b.e.line);
        findViewById(b.e.close_button).setOnClickListener(this);
        this.crq.setOnClickListener(this);
        this.crw = (HostMarketView) findViewById(b.e.hostmarket);
        this.cry = (CouponEntranceView) findViewById(b.e.coupon);
        this.cry.setOnClickListener(this);
        this.S = (TextView) findViewById(b.e.money);
        this.U = (TextView) findViewById(b.e.cut);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adM() {
        if (this.I <= 0) {
            this.crq.setVisibility(4);
            return;
        }
        this.crq.setVisibility(0);
        this.crq.setEnable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adN() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.cqY = com.baidu.poly.a.l.a.a(this.crn, layoutParams, "加载中", -1L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adO() {
        this.crw.a(this.crr);
        this.crw.setListener(new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adP() {
        Long l2;
        Long l3 = this.crD;
        if (l3 != null && (l2 = this.crC) != null) {
            if (l3.equals(l2)) {
                this.S.setText(a(this.crC.longValue()));
                this.U.setVisibility(8);
            } else {
                this.U.setVisibility(0);
                this.S.setText(a(this.crC.longValue()));
                this.U.setText(" ¥" + a(this.crD.longValue()));
            }
            if (this.crz.getVisibility() != 0) {
                this.crz.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adQ() {
        com.baidu.poly.a.b.b.adj().a(this.cpj, new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adR() {
        if (this.crH && this.crI) {
            com.baidu.poly.a.h.a.F();
        }
    }

    private void da() {
        List<a.C0312a> list;
        com.baidu.poly.widget.coupon.a aVar = this.cqD;
        if (aVar != null && (list = aVar.cqG) != null && list.size() > 0) {
            this.crB = new com.baidu.poly.widget.coupon.l(getContext());
            this.crB.a(this.crn.getMeasuredHeight());
            this.crB.setListener(new k());
            this.crB.a(this.cqD.cqG);
            this.crB.a(this.crn);
        }
    }

    private void ha() {
        this.crm.setVisibility(0);
        this.crn.setVisibility(0);
        this.crm.setAlpha(0.0f);
        this.crm.animate().alpha(0.65f).setDuration(240L).start();
        this.crn.startAnimation(this.cru);
        this.cru.setAnimationListener(new d());
        adM();
    }

    public void detach() {
        if (this.G) {
            this.G = false;
            this.crm.animate().alpha(0.0f).setDuration(240L).start();
            postDelayed(new f(), 240L);
            postDelayed(new g(), 480L);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.H || super.dispatchTouchEvent(motionEvent);
    }

    public boolean onBackPressed() {
        com.baidu.poly.widget.coupon.l lVar = this.crB;
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
                this.crq.startLoading();
                this.H = true;
                this.la = false;
                o[] oVarArr = this.crs;
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
        a.b bVar = this.cpg;
        if (bVar != null) {
            bVar.onResult(i2, str);
            this.cpg = null;
        }
        com.baidu.poly.a.h.d.b(i2, str);
        if (((PolyActivity) getContext()).isFinishing()) {
            com.baidu.poly.a.h.d.flush();
        }
        aa();
    }

    public void setCloseListener(l lVar) {
        this.crt = lVar;
    }

    public void setIsPreparePaying(boolean z) {
        this.H = z;
        aa();
        detach();
    }

    public void setResultListener(a.b bVar) {
        this.cpg = bVar;
    }

    public void setWalletList(com.baidu.poly.a.j.c cVar) {
        this.crE = cVar;
    }

    public void setWechatH5Pay(boolean z) {
        this.ma = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(String str) {
        if (TextUtils.isEmpty(str)) {
            str = getResources().getString(b.g.common_error_tips);
        }
        if (this.crF == null) {
            View inflate = View.inflate(this.crp.getContext(), b.f.default_pop_window, null);
            ((TextView) inflate.findViewById(b.e.pop_title)).setText("支付失败");
            ((TextView) inflate.findViewById(b.e.pop_tips)).setText(str.trim());
            this.crF = new com.baidu.poly.widget.c(inflate, -1, -1, true);
            this.crF.eo(false);
            this.crF.en(false);
            this.crF.setBackgroundDrawable(new ColorDrawable(0));
            ((TextView) inflate.findViewById(b.e.pop_button)).setOnClickListener(new h());
            this.crF.a(new i());
        }
        PolyActivity polyActivity = (PolyActivity) getContext();
        if (polyActivity.isFinishing()) {
            return;
        }
        this.crF.showAtLocation(polyActivity.getWindow().getDecorView(), 0, 0, 0);
    }

    private void o(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(DefaultSharedPrefsWrapper.SP_FILE_DEFAULT, this.qa);
            jSONObject.put("selected", str);
        } catch (JSONException e2) {
        }
        com.baidu.poly.a.h.d.a(new com.baidu.poly.a.h.b("5").az(jSONObject));
    }

    public m adS() {
        if (!this.G) {
            this.G = true;
            if (!(getContext() instanceof Activity)) {
                throw new IllegalStateException("can not attach to context " + getContext());
            }
            this.cro.a("收银台加载中...");
            com.baidu.poly.util.d.info("ChannelListView->attach()");
            ha();
        }
        return this;
    }

    public void e() {
        com.baidu.poly.a.l.a.a(this.cqY);
        this.cqY = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class k implements l.h {
        k() {
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void b() {
            m.this.adQ();
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void d() {
            if (m.this.crB != null) {
                m.this.crB.b(m.this.crn);
            }
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void onDetach() {
            m.this.crB = null;
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void a(a.C0312a c0312a, com.baidu.poly.a.k.a aVar) {
            if (c0312a != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(c0312a.cqL);
                if (m.this.crr != null && m.this.crr.P() == 1) {
                    arrayList.add(m.this.crr.O());
                }
                m.this.a(arrayList, aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(o[] oVarArr) {
        this.crA.setMinimumHeight(0);
        if (oVarArr != null) {
            this.crp.removeAllViews();
            for (o oVar : oVarArr) {
                com.baidu.poly.widget.a aVar = new com.baidu.poly.widget.a(getContext());
                aVar.a(oVar, new j(oVarArr, oVar));
                this.crp.addView(aVar);
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
                    this.crD = -1L;
                } else {
                    this.crD = Long.valueOf(Long.parseLong(string));
                }
            } catch (Exception e2) {
                com.baidu.poly.util.d.info("totalAmount is not long");
            }
        }
        this.cpj = bundle;
        adQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(o oVar) {
        if (oVar != null) {
            com.baidu.poly.a.h.a.d(Long.valueOf(System.currentTimeMillis()));
            JSONArray jSONArray = new JSONArray();
            try {
                if (this.crr != null && this.crr.P() == 1 && !TextUtils.isEmpty(this.crr.O())) {
                    jSONArray.put(new JSONObject(this.crr.O()));
                }
                if (this.cry.getSelectedItem() != null && !TextUtils.isEmpty(this.cry.getSelectedItem().cqL)) {
                    jSONArray.put(new JSONObject(this.cry.getSelectedItem().cqL));
                }
            } catch (Exception e2) {
            }
            if (jSONArray.length() > 0) {
                this.cpj.putString("hostMarketingDetail", jSONArray.toString());
            }
            if (this.crE != null) {
                this.crG = oVar.R();
                this.crE.b(this.cpj, oVar.R(), this);
            }
        }
    }

    public void c(Bundle bundle, String str) {
        this.crG = str;
        if (this.crE != null) {
            this.H = true;
            this.la = false;
            com.baidu.poly.a.h.a.d(Long.valueOf(System.currentTimeMillis()));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            this.cqY = com.baidu.poly.a.l.a.a(this, layoutParams, getResources().getString(b.g.poly_fast_pay_loading), -1L);
            this.crE.b(bundle, str, this);
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
        com.baidu.poly.a.k.b.a(this.cpj.getString("bduss"), this.cpj.getString("appKey"), this.crD + "", list, new a(aVar));
    }

    private String a(long j2) {
        return new DecimalFormat("0.00").format((j2 * 1.0d) / 100.0d);
    }
}

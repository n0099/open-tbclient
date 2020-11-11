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
    private a.b cdL;
    private Bundle cdO;
    private Runnable cfB;
    private View cfM;
    private PolyFrameLayout cfN;
    private TipView cfO;
    private ViewGroup cfP;
    private ProgressButton cfQ;
    private o cfR;
    private o[] cfS;
    private l cfT;
    private Animation cfU;
    private Animation cfV;
    private HostMarketView cfW;
    private View cfX;
    private CouponEntranceView cfY;
    private View cfZ;
    private com.baidu.poly.widget.coupon.a cfe;
    private com.baidu.poly.a.l.c cfz;
    private View cga;
    private com.baidu.poly.widget.coupon.l cgb;
    private Long cgc;
    private Long cgd;
    private com.baidu.poly.a.j.c cge;
    private com.baidu.poly.widget.c cgf;
    private String cgg;
    private boolean cgh;
    private boolean cgi;
    private String cgj;
    private boolean la;
    private boolean ma;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a implements com.baidu.poly.a.k.a {
        final /* synthetic */ com.baidu.poly.a.k.a cdr;

        a(com.baidu.poly.a.k.a aVar) {
            this.cdr = aVar;
        }

        @Override // com.baidu.poly.a.k.a
        public void a(a.C0309a c0309a) {
            if (c0309a.statusCode == 0) {
                m.this.cgc = Long.valueOf(c0309a.cdp);
                m.this.abz();
                if (m.this.cfR != null && m.this.cfR.P() == 1) {
                    m.this.cfR.l(c0309a.cdq);
                }
            }
            this.cdr.a(c0309a);
            m.this.cfY.h();
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
            m.this.cgc = Long.valueOf(jSONObject.optLong("payMoney"));
            JSONArray optJSONArray = jSONObject.optJSONArray("payChannels");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                o[] oVarArr = new o[optJSONArray.length()];
                for (int i = 0; i < optJSONArray.length(); i++) {
                    o oVar = new o(optJSONArray.optJSONObject(i));
                    if (oVar.P() == 1) {
                        m.this.cgj = oVar.R();
                    }
                    oVarArr[i] = oVar;
                }
                m.this.cfS = oVarArr;
                m.this.cfe = new com.baidu.poly.widget.coupon.a(jSONObject.optJSONArray("coupons"));
                m.this.cfY.a(m.this.cfe);
                if (m.this.cgb != null) {
                    m.this.cgb.a(m.this.cfe.cfh);
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("marketChannels");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    m.this.cfR = new o(optJSONArray2.optJSONObject(0));
                }
                com.baidu.poly.a.h.a.j("7");
                if (m.this.cfS.length != 1 || m.this.cfY.getVisibility() != 8 || m.this.cfR != null || m.this.cfS[0] == null) {
                    m.this.abz();
                    if (m.this.cfR != null || m.this.cfY.getVisibility() != 8) {
                        m.this.cfX.setVisibility(0);
                    } else {
                        m.this.cfX.setVisibility(8);
                    }
                    m.this.ba();
                    m mVar = m.this;
                    mVar.b(mVar.a(mVar.cfS));
                    m.this.cfO.j();
                    m.this.abx();
                    m.this.cgi = true;
                    m.this.abC();
                    return;
                }
                m.this.cgi = true;
                m.this.abC();
                m.this.cfO.b(m.this.cfS[0].Q(), "即将进入" + m.this.cfS[0].getDisplayName() + "…");
                m mVar2 = m.this;
                mVar2.b(mVar2.cfS[0]);
                return;
            }
            com.baidu.poly.a.h.a.a("7", null, null);
            a(new com.baidu.poly.a.i.b("channelList is null"), "request channelList payChannels is null");
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            if (m.this.cfS == null) {
                m mVar = m.this;
                mVar.n(mVar.getResources().getString(b.g.common_error_tips));
                m.this.onResult(3, "request channel list fail");
                m.this.detach();
                com.baidu.poly.a.h.d.a(new com.baidu.poly.a.h.b("1").jA(new com.baidu.poly.a.i.a("gatewaylist error --> " + str, th).U()));
            }
        }
    }

    /* loaded from: classes6.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            m.this.aby();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class d implements Animation.AnimationListener {
        d() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            m.this.cgh = true;
            m.this.abC();
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
            m.this.cfN.a(true);
            m mVar = m.this;
            mVar.postDelayed(mVar.cfB, 500L);
            if (oVar != null) {
                ArrayList arrayList = new ArrayList();
                if (z) {
                    arrayList.add(oVar.O());
                }
                if (m.this.cfY.getSelectedItem() != null) {
                    arrayList.add(m.this.cfY.getSelectedItem().cfl);
                }
                m.this.a(arrayList, aVar);
            }
        }

        @Override // com.baidu.poly.widget.hostmarket.HostMarketView.a
        public void b(a.C0309a c0309a) {
            m.this.cfN.a(false);
            m mVar = m.this;
            mVar.removeCallbacks(mVar.cfB);
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
                mVar.startAnimation(mVar.cfV);
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
            if (m.this.cgf == null || !m.this.cgf.isShowing()) {
                return;
            }
            m.this.cgf.dismiss();
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
    public class j implements a.InterfaceC0314a {
        final /* synthetic */ o[] cfK;
        final /* synthetic */ o cfL;

        j(o[] oVarArr, o oVar) {
            this.cfK = oVarArr;
            this.cfL = oVar;
        }

        @Override // com.baidu.poly.widget.a.InterfaceC0314a
        public void a() {
            o[] oVarArr = this.cfK;
            int length = oVarArr.length;
            for (int i = 0; i < length; i++) {
                o oVar = oVarArr[i];
                oVar.i(oVar == this.cfL ? 1 : 0);
            }
            m.this.b(this.cfK);
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
        this.cfB = new c();
        this.cgh = false;
        this.cgi = false;
        abw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa() {
        com.baidu.poly.widget.c cVar = this.cgf;
        boolean z = ((cVar != null && cVar.isShowing()) || this.H || this.G) ? false : true;
        if ((!TextUtils.isEmpty(this.cgg) && (TextUtils.equals(this.cgg, "BAIDU-ALIPAY-WISE") || TextUtils.equals(this.cgg, "BAIDU-ALIPAY-WISE-HUABEI-PAY"))) || this.ma) {
            com.baidu.poly.util.d.info("ChannelListView->confirmViewClose() ali pay channel");
            z &= this.la;
        }
        com.baidu.poly.util.d.info("ChannelListView->confirmViewClose() canFinishActivity = " + z);
        if (!z || this.cfT == null) {
            return;
        }
        com.baidu.poly.util.d.info("ChannelListView->confirmViewClose() finish activity");
        this.cfT.onClose();
        this.cfT = null;
    }

    private void abA() {
        List<a.C0316a> list;
        com.baidu.poly.widget.coupon.a aVar = this.cfe;
        if (aVar != null && (list = aVar.cfh) != null && list.size() > 0) {
            this.cgb = new com.baidu.poly.widget.coupon.l(getContext());
            this.cgb.a(this.cfN.getMeasuredHeight());
            this.cgb.setListener(new k());
            this.cgb.a(this.cfe.cfh);
            this.cgb.a(this.cfN);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abB() {
        com.baidu.poly.a.b.b.aaS().a(this.cdO, new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abC() {
        if (this.cgh && this.cgi) {
            com.baidu.poly.a.h.a.F();
        }
    }

    private void abw() {
        this.cfU = AnimationUtils.loadAnimation(getContext(), b.a.slide_in_bottom);
        this.cfV = AnimationUtils.loadAnimation(getContext(), b.a.slide_out_bottom);
        LayoutInflater.from(getContext()).inflate(b.f.view_channel_list, this);
        this.cfM = findViewById(b.e.bg_view);
        this.cfN = (PolyFrameLayout) findViewById(b.e.popup_view);
        this.cfZ = findViewById(b.e.pay_money_layout);
        this.cga = findViewById(b.e.channel_list_scroll_view);
        this.cfO = (TipView) findViewById(b.e.tip_view);
        this.cfP = (ViewGroup) findViewById(b.e.channel_list_view);
        this.cfQ = (ProgressButton) findViewById(b.e.pay_button);
        this.cfX = findViewById(b.e.line);
        findViewById(b.e.close_button).setOnClickListener(this);
        this.cfQ.setOnClickListener(this);
        this.cfW = (HostMarketView) findViewById(b.e.hostmarket);
        this.cfY = (CouponEntranceView) findViewById(b.e.coupon);
        this.cfY.setOnClickListener(this);
        this.S = (TextView) findViewById(b.e.money);
        this.U = (TextView) findViewById(b.e.cut);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abx() {
        if (this.I <= 0) {
            this.cfQ.setVisibility(4);
            return;
        }
        this.cfQ.setVisibility(0);
        this.cfQ.setEnable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aby() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.cfz = com.baidu.poly.a.l.a.a(this.cfN, layoutParams, "加载中", -1L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abz() {
        Long l2;
        Long l3 = this.cgd;
        if (l3 != null && (l2 = this.cgc) != null) {
            if (l3.equals(l2)) {
                this.S.setText(a(this.cgc.longValue()));
                this.U.setVisibility(8);
            } else {
                this.U.setVisibility(0);
                this.S.setText(a(this.cgc.longValue()));
                this.U.setText(" ¥" + a(this.cgd.longValue()));
            }
            if (this.cfZ.getVisibility() != 0) {
                this.cfZ.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ba() {
        this.cfW.a(this.cfR);
        this.cfW.setListener(new e());
    }

    private void ha() {
        this.cfM.setVisibility(0);
        this.cfN.setVisibility(0);
        this.cfM.setAlpha(0.0f);
        this.cfM.animate().alpha(0.65f).setDuration(240L).start();
        this.cfN.startAnimation(this.cfU);
        this.cfU.setAnimationListener(new d());
        abx();
    }

    public void detach() {
        if (this.G) {
            this.G = false;
            this.cfM.animate().alpha(0.0f).setDuration(240L).start();
            postDelayed(new f(), 240L);
            postDelayed(new g(), 480L);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.H || super.dispatchTouchEvent(motionEvent);
    }

    public boolean onBackPressed() {
        com.baidu.poly.widget.coupon.l lVar = this.cgb;
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
                this.cfQ.startLoading();
                this.H = true;
                this.la = false;
                o[] oVarArr = this.cfS;
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
            abA();
        }
    }

    public void onResult(int i2, String str) {
        com.baidu.poly.util.d.info("ChannelListView->onResult() statusCode = " + i2 + " result = " + str);
        this.la = true;
        a.b bVar = this.cdL;
        if (bVar != null) {
            bVar.onResult(i2, str);
            this.cdL = null;
        }
        com.baidu.poly.a.h.d.b(i2, str);
        if (((PolyActivity) getContext()).isFinishing()) {
            com.baidu.poly.a.h.d.flush();
        }
        aa();
    }

    public void setCloseListener(l lVar) {
        this.cfT = lVar;
    }

    public void setIsPreparePaying(boolean z) {
        this.H = z;
        aa();
        detach();
    }

    public void setResultListener(a.b bVar) {
        this.cdL = bVar;
    }

    public void setWalletList(com.baidu.poly.a.j.c cVar) {
        this.cge = cVar;
    }

    public void setWechatH5Pay(boolean z) {
        this.ma = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(String str) {
        if (TextUtils.isEmpty(str)) {
            str = getResources().getString(b.g.common_error_tips);
        }
        if (this.cgf == null) {
            View inflate = View.inflate(this.cfP.getContext(), b.f.default_pop_window, null);
            ((TextView) inflate.findViewById(b.e.pop_title)).setText("支付失败");
            ((TextView) inflate.findViewById(b.e.pop_tips)).setText(str.trim());
            this.cgf = new com.baidu.poly.widget.c(inflate, -1, -1, true);
            this.cgf.setClippingEnabled(false);
            this.cgf.setOutsideTouchable(false);
            this.cgf.setBackgroundDrawable(new ColorDrawable(0));
            ((TextView) inflate.findViewById(b.e.pop_button)).setOnClickListener(new h());
            this.cgf.a(new i());
        }
        PolyActivity polyActivity = (PolyActivity) getContext();
        if (polyActivity.isFinishing()) {
            return;
        }
        this.cgf.showAtLocation(polyActivity.getWindow().getDecorView(), 0, 0, 0);
    }

    private void o(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("default", this.cgj);
            jSONObject.put("selected", str);
        } catch (JSONException e2) {
        }
        com.baidu.poly.a.h.d.a(new com.baidu.poly.a.h.b("5").at(jSONObject));
    }

    public m abD() {
        if (!this.G) {
            this.G = true;
            if (!(getContext() instanceof Activity)) {
                throw new IllegalStateException("can not attach to context " + getContext());
            }
            this.cfO.a("收银台加载中...");
            com.baidu.poly.util.d.info("ChannelListView->attach()");
            ha();
        }
        return this;
    }

    public void e() {
        com.baidu.poly.a.l.a.a(this.cfz);
        this.cfz = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class k implements l.h {
        k() {
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void b() {
            m.this.abB();
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void d() {
            if (m.this.cgb != null) {
                m.this.cgb.b(m.this.cfN);
            }
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void onDetach() {
            m.this.cgb = null;
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void a(a.C0316a c0316a, com.baidu.poly.a.k.a aVar) {
            if (c0316a != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(c0316a.cfl);
                if (m.this.cfR != null && m.this.cfR.P() == 1) {
                    arrayList.add(m.this.cfR.O());
                }
                m.this.a(arrayList, aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(o[] oVarArr) {
        this.cga.setMinimumHeight(0);
        if (oVarArr != null) {
            this.cfP.removeAllViews();
            for (o oVar : oVarArr) {
                com.baidu.poly.widget.a aVar = new com.baidu.poly.widget.a(getContext());
                aVar.a(oVar, new j(oVarArr, oVar));
                this.cfP.addView(aVar);
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
                    this.cgd = -1L;
                } else {
                    this.cgd = Long.valueOf(Long.parseLong(string));
                }
            } catch (Exception e2) {
                com.baidu.poly.util.d.info("totalAmount is not long");
            }
        }
        this.cdO = bundle;
        abB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(o oVar) {
        if (oVar != null) {
            com.baidu.poly.a.h.a.d(Long.valueOf(System.currentTimeMillis()));
            JSONArray jSONArray = new JSONArray();
            try {
                if (this.cfR != null && this.cfR.P() == 1 && !TextUtils.isEmpty(this.cfR.O())) {
                    jSONArray.put(new JSONObject(this.cfR.O()));
                }
                if (this.cfY.getSelectedItem() != null && !TextUtils.isEmpty(this.cfY.getSelectedItem().cfl)) {
                    jSONArray.put(new JSONObject(this.cfY.getSelectedItem().cfl));
                }
            } catch (Exception e2) {
            }
            if (jSONArray.length() > 0) {
                this.cdO.putString("hostMarketingDetail", jSONArray.toString());
            }
            if (this.cge != null) {
                this.cgg = oVar.R();
                this.cge.b(this.cdO, oVar.R(), this);
            }
        }
    }

    public void c(Bundle bundle, String str) {
        this.cgg = str;
        if (this.cge != null) {
            this.H = true;
            this.la = false;
            com.baidu.poly.a.h.a.d(Long.valueOf(System.currentTimeMillis()));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            this.cfz = com.baidu.poly.a.l.a.a(this, layoutParams, getResources().getString(b.g.poly_fast_pay_loading), -1L);
            this.cge.b(bundle, str, this);
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
        com.baidu.poly.a.k.b.a(this.cdO.getString("bduss"), this.cdO.getString("appKey"), this.cgd + "", list, new a(aVar));
    }

    private String a(long j2) {
        return new DecimalFormat("0.00").format((j2 * 1.0d) / 100.0d);
    }
}

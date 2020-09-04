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
    private a.b bGS;
    private Bundle bGV;
    private com.baidu.poly.a.l.c bIG;
    private Runnable bII;
    private View bIT;
    private PolyFrameLayout bIU;
    private TipView bIV;
    private ViewGroup bIW;
    private ProgressButton bIX;
    private o bIY;
    private o[] bIZ;
    private com.baidu.poly.widget.coupon.a bIl;
    private l bJa;
    private Animation bJb;
    private Animation bJc;
    private HostMarketView bJd;
    private TextView bJe;
    private View bJf;
    private CouponEntranceView bJg;
    private View bJh;
    private View bJi;
    private com.baidu.poly.widget.coupon.l bJj;
    private Long bJk;
    private Long bJl;
    private com.baidu.poly.a.j.c bJm;
    private com.baidu.poly.widget.c bJn;
    private String bJo;
    private boolean bJp;
    private boolean bJq;
    private String bJr;
    private boolean la;
    private boolean ma;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a implements com.baidu.poly.a.k.a {
        final /* synthetic */ com.baidu.poly.a.k.a bGy;

        a(com.baidu.poly.a.k.a aVar) {
            this.bGy = aVar;
        }

        @Override // com.baidu.poly.a.k.a
        public void a(a.C0270a c0270a) {
            if (c0270a.statusCode == 0) {
                m.this.bJk = Long.valueOf(c0270a.bGw);
                m.this.UA();
                if (m.this.bIY != null && m.this.bIY.P() == 1) {
                    m.this.bIY.l(c0270a.bGx);
                }
            }
            this.bGy.a(c0270a);
            m.this.bJg.h();
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
            m.this.bJk = Long.valueOf(jSONObject.optLong("payMoney"));
            JSONArray optJSONArray = jSONObject.optJSONArray("payChannels");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                o[] oVarArr = new o[optJSONArray.length()];
                for (int i = 0; i < optJSONArray.length(); i++) {
                    o oVar = new o(optJSONArray.optJSONObject(i));
                    if (oVar.P() == 1) {
                        m.this.bJr = oVar.R();
                    }
                    oVarArr[i] = oVar;
                }
                m.this.bIZ = oVarArr;
                m.this.bIl = new com.baidu.poly.widget.coupon.a(jSONObject.optJSONArray("coupons"));
                m.this.bJg.a(m.this.bIl);
                if (m.this.bJj != null) {
                    m.this.bJj.a(m.this.bIl.bIo);
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("marketChannels");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    m.this.bIY = new o(optJSONArray2.optJSONObject(0));
                }
                com.baidu.poly.a.h.a.j("7");
                if (m.this.bIZ.length != 1 || m.this.bJg.getVisibility() != 8 || m.this.bIY != null || m.this.bIZ[0] == null) {
                    m.this.UA();
                    if (m.this.bIY != null || m.this.bJg.getVisibility() != 8) {
                        m.this.bJf.setVisibility(0);
                    } else {
                        m.this.bJf.setVisibility(8);
                    }
                    m.this.ba();
                    m mVar = m.this;
                    mVar.b(mVar.a(mVar.bIZ));
                    m.this.bIV.j();
                    m.this.Uy();
                    m.this.bJq = true;
                    m.this.UD();
                    return;
                }
                m.this.bJq = true;
                m.this.UD();
                m.this.bIV.b(m.this.bIZ[0].Q(), "即将进入" + m.this.bIZ[0].getDisplayName() + "…");
                m mVar2 = m.this;
                mVar2.b(mVar2.bIZ[0]);
                return;
            }
            com.baidu.poly.a.h.a.a("7", null, null);
            a(new com.baidu.poly.a.i.b("channelList is null"), "request channelList payChannels is null");
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            if (m.this.bIZ == null) {
                m mVar = m.this;
                mVar.n(mVar.getResources().getString(b.g.common_error_tips));
                m.this.onResult(3, "request channel list fail");
                m.this.detach();
                com.baidu.poly.a.h.d.a(new com.baidu.poly.a.h.b("1").hZ(new com.baidu.poly.a.i.a("gatewaylist error --> " + str, th).U()));
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
            m.this.bJp = true;
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
            m.this.bIU.a(true);
            m mVar = m.this;
            mVar.postDelayed(mVar.bII, 500L);
            if (oVar != null) {
                ArrayList arrayList = new ArrayList();
                if (z) {
                    arrayList.add(oVar.O());
                }
                if (m.this.bJg.getSelectedItem() != null) {
                    arrayList.add(m.this.bJg.getSelectedItem().bIs);
                }
                m.this.a(arrayList, aVar);
            }
        }

        @Override // com.baidu.poly.widget.hostmarket.HostMarketView.a
        public void b(a.C0270a c0270a) {
            m.this.bIU.a(false);
            m mVar = m.this;
            mVar.removeCallbacks(mVar.bII);
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
                mVar.startAnimation(mVar.bJc);
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
            if (m.this.bJn == null || !m.this.bJn.isShowing()) {
                return;
            }
            m.this.bJn.dismiss();
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
        final /* synthetic */ o[] bIR;
        final /* synthetic */ o bIS;

        j(o[] oVarArr, o oVar) {
            this.bIR = oVarArr;
            this.bIS = oVar;
        }

        @Override // com.baidu.poly.widget.a.InterfaceC0275a
        public void a() {
            o[] oVarArr = this.bIR;
            int length = oVarArr.length;
            for (int i = 0; i < length; i++) {
                o oVar = oVarArr[i];
                oVar.i(oVar == this.bIS ? 1 : 0);
            }
            m.this.b(this.bIR);
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
        this.bII = new c();
        this.bJp = false;
        this.bJq = false;
        Ux();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UA() {
        Long l2;
        Long l3 = this.bJl;
        if (l3 != null && (l2 = this.bJk) != null) {
            if (l3.equals(l2)) {
                this.bJe.setText(a(this.bJk.longValue()));
                this.U.setVisibility(8);
            } else {
                this.U.setVisibility(0);
                this.bJe.setText(a(this.bJk.longValue()));
                this.U.setText(" ¥" + a(this.bJl.longValue()));
            }
            if (this.bJh.getVisibility() != 0) {
                this.bJh.setVisibility(0);
            }
        }
    }

    private void UB() {
        List<a.C0277a> list;
        com.baidu.poly.widget.coupon.a aVar = this.bIl;
        if (aVar != null && (list = aVar.bIo) != null && list.size() > 0) {
            this.bJj = new com.baidu.poly.widget.coupon.l(getContext());
            this.bJj.a(this.bIU.getMeasuredHeight());
            this.bJj.setListener(new k());
            this.bJj.a(this.bIl.bIo);
            this.bJj.a(this.bIU);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UC() {
        com.baidu.poly.a.b.b.TT().a(this.bGV, new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UD() {
        if (this.bJp && this.bJq) {
            com.baidu.poly.a.h.a.F();
        }
    }

    private void Ux() {
        this.bJb = AnimationUtils.loadAnimation(getContext(), b.a.slide_in_bottom);
        this.bJc = AnimationUtils.loadAnimation(getContext(), b.a.slide_out_bottom);
        LayoutInflater.from(getContext()).inflate(b.f.view_channel_list, this);
        this.bIT = findViewById(b.e.bg_view);
        this.bIU = (PolyFrameLayout) findViewById(b.e.popup_view);
        this.bJh = findViewById(b.e.pay_money_layout);
        this.bJi = findViewById(b.e.channel_list_scroll_view);
        this.bIV = (TipView) findViewById(b.e.tip_view);
        this.bIW = (ViewGroup) findViewById(b.e.channel_list_view);
        this.bIX = (ProgressButton) findViewById(b.e.pay_button);
        this.bJf = findViewById(b.e.line);
        findViewById(b.e.close_button).setOnClickListener(this);
        this.bIX.setOnClickListener(this);
        this.bJd = (HostMarketView) findViewById(b.e.hostmarket);
        this.bJg = (CouponEntranceView) findViewById(b.e.coupon);
        this.bJg.setOnClickListener(this);
        this.bJe = (TextView) findViewById(b.e.money);
        this.U = (TextView) findViewById(b.e.cut);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uy() {
        if (this.I <= 0) {
            this.bIX.setVisibility(4);
            return;
        }
        this.bIX.setVisibility(0);
        this.bIX.setEnable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uz() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.bIG = com.baidu.poly.a.l.a.a(this.bIU, layoutParams, "加载中", -1L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa() {
        com.baidu.poly.widget.c cVar = this.bJn;
        boolean z = ((cVar != null && cVar.isShowing()) || this.H || this.G) ? false : true;
        if ((!TextUtils.isEmpty(this.bJo) && (TextUtils.equals(this.bJo, "BAIDU-ALIPAY-WISE") || TextUtils.equals(this.bJo, "BAIDU-ALIPAY-WISE-HUABEI-PAY"))) || this.ma) {
            com.baidu.poly.util.d.info("ChannelListView->confirmViewClose() ali pay channel");
            z &= this.la;
        }
        com.baidu.poly.util.d.info("ChannelListView->confirmViewClose() canFinishActivity = " + z);
        if (!z || this.bJa == null) {
            return;
        }
        com.baidu.poly.util.d.info("ChannelListView->confirmViewClose() finish activity");
        this.bJa.onClose();
        this.bJa = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ba() {
        this.bJd.a(this.bIY);
        this.bJd.setListener(new e());
    }

    private void ha() {
        this.bIT.setVisibility(0);
        this.bIU.setVisibility(0);
        this.bIT.setAlpha(0.0f);
        this.bIT.animate().alpha(0.65f).setDuration(240L).start();
        this.bIU.startAnimation(this.bJb);
        this.bJb.setAnimationListener(new d());
        Uy();
    }

    public void detach() {
        if (this.G) {
            this.G = false;
            this.bIT.animate().alpha(0.0f).setDuration(240L).start();
            postDelayed(new f(), 240L);
            postDelayed(new g(), 480L);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.H || super.dispatchTouchEvent(motionEvent);
    }

    public boolean onBackPressed() {
        com.baidu.poly.widget.coupon.l lVar = this.bJj;
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
                this.bIX.startLoading();
                this.H = true;
                this.la = false;
                o[] oVarArr = this.bIZ;
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
        a.b bVar = this.bGS;
        if (bVar != null) {
            bVar.onResult(i2, str);
            this.bGS = null;
        }
        com.baidu.poly.a.h.d.b(i2, str);
        if (((PolyActivity) getContext()).isFinishing()) {
            com.baidu.poly.a.h.d.flush();
        }
        aa();
    }

    public void setCloseListener(l lVar) {
        this.bJa = lVar;
    }

    public void setIsPreparePaying(boolean z) {
        this.H = z;
        aa();
        detach();
    }

    public void setResultListener(a.b bVar) {
        this.bGS = bVar;
    }

    public void setWalletList(com.baidu.poly.a.j.c cVar) {
        this.bJm = cVar;
    }

    public void setWechatH5Pay(boolean z) {
        this.ma = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(String str) {
        if (TextUtils.isEmpty(str)) {
            str = getResources().getString(b.g.common_error_tips);
        }
        if (this.bJn == null) {
            View inflate = View.inflate(this.bIW.getContext(), b.f.default_pop_window, null);
            ((TextView) inflate.findViewById(b.e.pop_title)).setText("支付失败");
            ((TextView) inflate.findViewById(b.e.pop_tips)).setText(str.trim());
            this.bJn = new com.baidu.poly.widget.c(inflate, -1, -1, true);
            this.bJn.setClippingEnabled(false);
            this.bJn.setOutsideTouchable(false);
            this.bJn.setBackgroundDrawable(new ColorDrawable(0));
            ((TextView) inflate.findViewById(b.e.pop_button)).setOnClickListener(new h());
            this.bJn.a(new i());
        }
        PolyActivity polyActivity = (PolyActivity) getContext();
        if (polyActivity.isFinishing()) {
            return;
        }
        this.bJn.showAtLocation(polyActivity.getWindow().getDecorView(), 0, 0, 0);
    }

    private void o(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("default", this.bJr);
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
            this.bIV.a("收银台加载中...");
            com.baidu.poly.util.d.info("ChannelListView->attach()");
            ha();
        }
        return this;
    }

    public void e() {
        com.baidu.poly.a.l.a.a(this.bIG);
        this.bIG = null;
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
            if (m.this.bJj != null) {
                m.this.bJj.b(m.this.bIU);
            }
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void onDetach() {
            m.this.bJj = null;
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void a(a.C0277a c0277a, com.baidu.poly.a.k.a aVar) {
            if (c0277a != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(c0277a.bIs);
                if (m.this.bIY != null && m.this.bIY.P() == 1) {
                    arrayList.add(m.this.bIY.O());
                }
                m.this.a(arrayList, aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(o[] oVarArr) {
        this.bJi.setMinimumHeight(0);
        if (oVarArr != null) {
            this.bIW.removeAllViews();
            for (o oVar : oVarArr) {
                com.baidu.poly.widget.a aVar = new com.baidu.poly.widget.a(getContext());
                aVar.a(oVar, new j(oVarArr, oVar));
                this.bIW.addView(aVar);
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
                    this.bJl = -1L;
                } else {
                    this.bJl = Long.valueOf(Long.parseLong(string));
                }
            } catch (Exception e2) {
                com.baidu.poly.util.d.info("totalAmount is not long");
            }
        }
        this.bGV = bundle;
        UC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(o oVar) {
        if (oVar != null) {
            com.baidu.poly.a.h.a.c(Long.valueOf(System.currentTimeMillis()));
            JSONArray jSONArray = new JSONArray();
            try {
                if (this.bIY != null && this.bIY.P() == 1 && !TextUtils.isEmpty(this.bIY.O())) {
                    jSONArray.put(new JSONObject(this.bIY.O()));
                }
                if (this.bJg.getSelectedItem() != null && !TextUtils.isEmpty(this.bJg.getSelectedItem().bIs)) {
                    jSONArray.put(new JSONObject(this.bJg.getSelectedItem().bIs));
                }
            } catch (Exception e2) {
            }
            if (jSONArray.length() > 0) {
                this.bGV.putString("hostMarketingDetail", jSONArray.toString());
            }
            if (this.bJm != null) {
                this.bJo = oVar.R();
                this.bJm.b(this.bGV, oVar.R(), this);
            }
        }
    }

    public void c(Bundle bundle, String str) {
        this.bJo = str;
        if (this.bJm != null) {
            this.H = true;
            this.la = false;
            com.baidu.poly.a.h.a.c(Long.valueOf(System.currentTimeMillis()));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            this.bIG = com.baidu.poly.a.l.a.a(this, layoutParams, getResources().getString(b.g.poly_fast_pay_loading), -1L);
            this.bJm.b(bundle, str, this);
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
        com.baidu.poly.a.k.b.a(this.bGV.getString("bduss"), this.bGV.getString("appKey"), this.bJl + "", list, new a(aVar));
    }

    private String a(long j2) {
        return new DecimalFormat("0.00").format((j2 * 1.0d) / 100.0d);
    }
}

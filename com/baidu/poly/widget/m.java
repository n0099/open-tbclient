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
    private boolean G;
    private boolean H;
    private int I;
    private TextView S;
    private TextView U;
    private a.b bIT;
    private Bundle bIW;
    private com.baidu.poly.a.l.c bKH;
    private Runnable bKJ;
    private View bKU;
    private PolyFrameLayout bKV;
    private TipView bKW;
    private ViewGroup bKX;
    private ProgressButton bKY;
    private o bKZ;
    private com.baidu.poly.widget.coupon.a bKm;
    private o[] bLa;
    private l bLb;
    private Animation bLc;
    private Animation bLd;
    private HostMarketView bLe;
    private View bLf;
    private CouponEntranceView bLg;
    private View bLh;
    private View bLi;
    private com.baidu.poly.widget.coupon.l bLj;
    private Long bLk;
    private Long bLl;
    private com.baidu.poly.a.j.c bLm;
    private com.baidu.poly.widget.c bLn;
    private String bLo;
    private boolean bLp;
    private boolean bLq;
    private String bLr;
    private boolean la;
    private boolean ma;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class a implements com.baidu.poly.a.k.a {
        final /* synthetic */ com.baidu.poly.a.k.a bIz;

        a(com.baidu.poly.a.k.a aVar) {
            this.bIz = aVar;
        }

        @Override // com.baidu.poly.a.k.a
        public void a(a.C0268a c0268a) {
            if (c0268a.statusCode == 0) {
                m.this.bLk = Long.valueOf(c0268a.bIx);
                m.this.Vj();
                if (m.this.bKZ != null && m.this.bKZ.P() == 1) {
                    m.this.bKZ.l(c0268a.bIy);
                }
            }
            this.bIz.a(c0268a);
            m.this.bLg.h();
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
            m.this.bLk = Long.valueOf(jSONObject.optLong("payMoney"));
            JSONArray optJSONArray = jSONObject.optJSONArray("payChannels");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                o[] oVarArr = new o[optJSONArray.length()];
                for (int i = 0; i < optJSONArray.length(); i++) {
                    o oVar = new o(optJSONArray.optJSONObject(i));
                    if (oVar.P() == 1) {
                        m.this.bLr = oVar.R();
                    }
                    oVarArr[i] = oVar;
                }
                m.this.bLa = oVarArr;
                m.this.bKm = new com.baidu.poly.widget.coupon.a(jSONObject.optJSONArray("coupons"));
                m.this.bLg.a(m.this.bKm);
                if (m.this.bLj != null) {
                    m.this.bLj.a(m.this.bKm.bKp);
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("marketChannels");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    m.this.bKZ = new o(optJSONArray2.optJSONObject(0));
                }
                com.baidu.poly.a.h.a.j("7");
                if (m.this.bLa.length != 1 || m.this.bLg.getVisibility() != 8 || m.this.bKZ != null || m.this.bLa[0] == null) {
                    m.this.Vj();
                    if (m.this.bKZ != null || m.this.bLg.getVisibility() != 8) {
                        m.this.bLf.setVisibility(0);
                    } else {
                        m.this.bLf.setVisibility(8);
                    }
                    m.this.ba();
                    m mVar = m.this;
                    mVar.b(mVar.a(mVar.bLa));
                    m.this.bKW.j();
                    m.this.Vh();
                    m.this.bLq = true;
                    m.this.Vm();
                    return;
                }
                m.this.bLq = true;
                m.this.Vm();
                m.this.bKW.b(m.this.bLa[0].Q(), "即将进入" + m.this.bLa[0].getDisplayName() + "…");
                m mVar2 = m.this;
                mVar2.b(mVar2.bLa[0]);
                return;
            }
            com.baidu.poly.a.h.a.a("7", null, null);
            a(new com.baidu.poly.a.i.b("channelList is null"), "request channelList payChannels is null");
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            if (m.this.bLa == null) {
                m mVar = m.this;
                mVar.n(mVar.getResources().getString(b.g.common_error_tips));
                m.this.onResult(3, "request channel list fail");
                m.this.detach();
                com.baidu.poly.a.h.d.a(new com.baidu.poly.a.h.b("1").is(new com.baidu.poly.a.i.a("gatewaylist error --> " + str, th).U()));
            }
        }
    }

    /* loaded from: classes9.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            m.this.Vi();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class d implements Animation.AnimationListener {
        d() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            m.this.bLp = true;
            m.this.Vm();
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
            m.this.bKV.a(true);
            m mVar = m.this;
            mVar.postDelayed(mVar.bKJ, 500L);
            if (oVar != null) {
                ArrayList arrayList = new ArrayList();
                if (z) {
                    arrayList.add(oVar.O());
                }
                if (m.this.bLg.getSelectedItem() != null) {
                    arrayList.add(m.this.bLg.getSelectedItem().bKt);
                }
                m.this.a(arrayList, aVar);
            }
        }

        @Override // com.baidu.poly.widget.hostmarket.HostMarketView.a
        public void b(a.C0268a c0268a) {
            m.this.bKV.a(false);
            m mVar = m.this;
            mVar.removeCallbacks(mVar.bKJ);
            m.this.e();
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
                mVar.startAnimation(mVar.bLd);
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
            m.this.aa();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (m.this.bLn == null || !m.this.bLn.isShowing()) {
                return;
            }
            m.this.bLn.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class i implements c.b {
        i() {
        }

        @Override // com.baidu.poly.widget.c.b
        public void onDismiss() {
            m.this.aa();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class j implements a.InterfaceC0273a {
        final /* synthetic */ o[] bKS;
        final /* synthetic */ o bKT;

        j(o[] oVarArr, o oVar) {
            this.bKS = oVarArr;
            this.bKT = oVar;
        }

        @Override // com.baidu.poly.widget.a.InterfaceC0273a
        public void a() {
            o[] oVarArr = this.bKS;
            int length = oVarArr.length;
            for (int i = 0; i < length; i++) {
                o oVar = oVarArr[i];
                oVar.i(oVar == this.bKT ? 1 : 0);
            }
            m.this.b(this.bKS);
        }
    }

    /* loaded from: classes9.dex */
    public interface l {
        void onClose();
    }

    public m(PolyActivity polyActivity) {
        super(polyActivity);
        this.la = true;
        this.ma = false;
        this.bKJ = new c();
        this.bLp = false;
        this.bLq = false;
        Vg();
    }

    private void Vg() {
        this.bLc = AnimationUtils.loadAnimation(getContext(), b.a.slide_in_bottom);
        this.bLd = AnimationUtils.loadAnimation(getContext(), b.a.slide_out_bottom);
        LayoutInflater.from(getContext()).inflate(b.f.view_channel_list, this);
        this.bKU = findViewById(b.e.bg_view);
        this.bKV = (PolyFrameLayout) findViewById(b.e.popup_view);
        this.bLh = findViewById(b.e.pay_money_layout);
        this.bLi = findViewById(b.e.channel_list_scroll_view);
        this.bKW = (TipView) findViewById(b.e.tip_view);
        this.bKX = (ViewGroup) findViewById(b.e.channel_list_view);
        this.bKY = (ProgressButton) findViewById(b.e.pay_button);
        this.bLf = findViewById(b.e.line);
        findViewById(b.e.close_button).setOnClickListener(this);
        this.bKY.setOnClickListener(this);
        this.bLe = (HostMarketView) findViewById(b.e.hostmarket);
        this.bLg = (CouponEntranceView) findViewById(b.e.coupon);
        this.bLg.setOnClickListener(this);
        this.S = (TextView) findViewById(b.e.money);
        this.U = (TextView) findViewById(b.e.cut);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vh() {
        if (this.I <= 0) {
            this.bKY.setVisibility(4);
            return;
        }
        this.bKY.setVisibility(0);
        this.bKY.setEnable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vi() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.bKH = com.baidu.poly.a.l.a.a(this.bKV, layoutParams, "加载中", -1L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vj() {
        Long l2;
        Long l3 = this.bLl;
        if (l3 != null && (l2 = this.bLk) != null) {
            if (l3.equals(l2)) {
                this.S.setText(a(this.bLk.longValue()));
                this.U.setVisibility(8);
            } else {
                this.U.setVisibility(0);
                this.S.setText(a(this.bLk.longValue()));
                this.U.setText(" ¥" + a(this.bLl.longValue()));
            }
            if (this.bLh.getVisibility() != 0) {
                this.bLh.setVisibility(0);
            }
        }
    }

    private void Vk() {
        List<a.C0275a> list;
        com.baidu.poly.widget.coupon.a aVar = this.bKm;
        if (aVar != null && (list = aVar.bKp) != null && list.size() > 0) {
            this.bLj = new com.baidu.poly.widget.coupon.l(getContext());
            this.bLj.a(this.bKV.getMeasuredHeight());
            this.bLj.setListener(new k());
            this.bLj.a(this.bKm.bKp);
            this.bLj.a(this.bKV);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vl() {
        com.baidu.poly.a.b.b.UC().a(this.bIW, new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vm() {
        if (this.bLp && this.bLq) {
            com.baidu.poly.a.h.a.F();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa() {
        com.baidu.poly.widget.c cVar = this.bLn;
        boolean z = ((cVar != null && cVar.isShowing()) || this.H || this.G) ? false : true;
        if ((!TextUtils.isEmpty(this.bLo) && (TextUtils.equals(this.bLo, "BAIDU-ALIPAY-WISE") || TextUtils.equals(this.bLo, "BAIDU-ALIPAY-WISE-HUABEI-PAY"))) || this.ma) {
            com.baidu.poly.util.d.info("ChannelListView->confirmViewClose() ali pay channel");
            z &= this.la;
        }
        com.baidu.poly.util.d.info("ChannelListView->confirmViewClose() canFinishActivity = " + z);
        if (!z || this.bLb == null) {
            return;
        }
        com.baidu.poly.util.d.info("ChannelListView->confirmViewClose() finish activity");
        this.bLb.onClose();
        this.bLb = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ba() {
        this.bLe.a(this.bKZ);
        this.bLe.setListener(new e());
    }

    private void ha() {
        this.bKU.setVisibility(0);
        this.bKV.setVisibility(0);
        this.bKU.setAlpha(0.0f);
        this.bKU.animate().alpha(0.65f).setDuration(240L).start();
        this.bKV.startAnimation(this.bLc);
        this.bLc.setAnimationListener(new d());
        Vh();
    }

    public void detach() {
        if (this.G) {
            this.G = false;
            this.bKU.animate().alpha(0.0f).setDuration(240L).start();
            postDelayed(new f(), 240L);
            postDelayed(new g(), 480L);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.H || super.dispatchTouchEvent(motionEvent);
    }

    public boolean onBackPressed() {
        com.baidu.poly.widget.coupon.l lVar = this.bLj;
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
                this.bKY.startLoading();
                this.H = true;
                this.la = false;
                o[] oVarArr = this.bLa;
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
            Vk();
        }
    }

    public void onResult(int i2, String str) {
        com.baidu.poly.util.d.info("ChannelListView->onResult() statusCode = " + i2 + " result = " + str);
        this.la = true;
        a.b bVar = this.bIT;
        if (bVar != null) {
            bVar.onResult(i2, str);
            this.bIT = null;
        }
        com.baidu.poly.a.h.d.b(i2, str);
        if (((PolyActivity) getContext()).isFinishing()) {
            com.baidu.poly.a.h.d.flush();
        }
        aa();
    }

    public void setCloseListener(l lVar) {
        this.bLb = lVar;
    }

    public void setIsPreparePaying(boolean z) {
        this.H = z;
        aa();
        detach();
    }

    public void setResultListener(a.b bVar) {
        this.bIT = bVar;
    }

    public void setWalletList(com.baidu.poly.a.j.c cVar) {
        this.bLm = cVar;
    }

    public void setWechatH5Pay(boolean z) {
        this.ma = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(String str) {
        if (TextUtils.isEmpty(str)) {
            str = getResources().getString(b.g.common_error_tips);
        }
        if (this.bLn == null) {
            View inflate = View.inflate(this.bKX.getContext(), b.f.default_pop_window, null);
            ((TextView) inflate.findViewById(b.e.pop_title)).setText("支付失败");
            ((TextView) inflate.findViewById(b.e.pop_tips)).setText(str.trim());
            this.bLn = new com.baidu.poly.widget.c(inflate, -1, -1, true);
            this.bLn.setClippingEnabled(false);
            this.bLn.setOutsideTouchable(false);
            this.bLn.setBackgroundDrawable(new ColorDrawable(0));
            ((TextView) inflate.findViewById(b.e.pop_button)).setOnClickListener(new h());
            this.bLn.a(new i());
        }
        PolyActivity polyActivity = (PolyActivity) getContext();
        if (polyActivity.isFinishing()) {
            return;
        }
        this.bLn.showAtLocation(polyActivity.getWindow().getDecorView(), 0, 0, 0);
    }

    private void o(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("default", this.bLr);
            jSONObject.put("selected", str);
        } catch (JSONException e2) {
        }
        com.baidu.poly.a.h.d.a(new com.baidu.poly.a.h.b("5").ah(jSONObject));
    }

    public m Vn() {
        if (!this.G) {
            this.G = true;
            if (!(getContext() instanceof Activity)) {
                throw new IllegalStateException("can not attach to context " + getContext());
            }
            this.bKW.a("收银台加载中...");
            com.baidu.poly.util.d.info("ChannelListView->attach()");
            ha();
        }
        return this;
    }

    public void e() {
        com.baidu.poly.a.l.a.a(this.bKH);
        this.bKH = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class k implements l.h {
        k() {
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void b() {
            m.this.Vl();
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void d() {
            if (m.this.bLj != null) {
                m.this.bLj.b(m.this.bKV);
            }
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void onDetach() {
            m.this.bLj = null;
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void a(a.C0275a c0275a, com.baidu.poly.a.k.a aVar) {
            if (c0275a != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(c0275a.bKt);
                if (m.this.bKZ != null && m.this.bKZ.P() == 1) {
                    arrayList.add(m.this.bKZ.O());
                }
                m.this.a(arrayList, aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(o[] oVarArr) {
        this.bLi.setMinimumHeight(0);
        if (oVarArr != null) {
            this.bKX.removeAllViews();
            for (o oVar : oVarArr) {
                com.baidu.poly.widget.a aVar = new com.baidu.poly.widget.a(getContext());
                aVar.a(oVar, new j(oVarArr, oVar));
                this.bKX.addView(aVar);
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
                    this.bLl = -1L;
                } else {
                    this.bLl = Long.valueOf(Long.parseLong(string));
                }
            } catch (Exception e2) {
                com.baidu.poly.util.d.info("totalAmount is not long");
            }
        }
        this.bIW = bundle;
        Vl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(o oVar) {
        if (oVar != null) {
            com.baidu.poly.a.h.a.c(Long.valueOf(System.currentTimeMillis()));
            JSONArray jSONArray = new JSONArray();
            try {
                if (this.bKZ != null && this.bKZ.P() == 1 && !TextUtils.isEmpty(this.bKZ.O())) {
                    jSONArray.put(new JSONObject(this.bKZ.O()));
                }
                if (this.bLg.getSelectedItem() != null && !TextUtils.isEmpty(this.bLg.getSelectedItem().bKt)) {
                    jSONArray.put(new JSONObject(this.bLg.getSelectedItem().bKt));
                }
            } catch (Exception e2) {
            }
            if (jSONArray.length() > 0) {
                this.bIW.putString("hostMarketingDetail", jSONArray.toString());
            }
            if (this.bLm != null) {
                this.bLo = oVar.R();
                this.bLm.b(this.bIW, oVar.R(), this);
            }
        }
    }

    public void c(Bundle bundle, String str) {
        this.bLo = str;
        if (this.bLm != null) {
            this.H = true;
            this.la = false;
            com.baidu.poly.a.h.a.c(Long.valueOf(System.currentTimeMillis()));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            this.bKH = com.baidu.poly.a.l.a.a(this, layoutParams, getResources().getString(b.g.poly_fast_pay_loading), -1L);
            this.bLm.b(bundle, str, this);
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
        com.baidu.poly.a.k.b.a(this.bIW.getString("bduss"), this.bIW.getString("appKey"), this.bLl + "", list, new a(aVar));
    }

    private String a(long j2) {
        return new DecimalFormat("0.00").format((j2 * 1.0d) / 100.0d);
    }
}

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
import com.baidu.poly.a.j.a;
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
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class m extends FrameLayout implements View.OnClickListener {
    private boolean D;
    private boolean F;
    private int G;
    private TextView R;
    private View S;
    private View aa;
    private a.b bAT;
    private Bundle bAW;
    private com.baidu.poly.a.k.c bCK;
    private Runnable bCM;
    private PolyFrameLayout bCX;
    private TipView bCY;
    private ViewGroup bCZ;
    private com.baidu.poly.widget.coupon.a bCo;
    private ProgressButton bDa;
    private o bDb;
    private o[] bDc;
    private l bDd;
    private Animation bDe;
    private Animation bDf;
    private HostMarketView bDg;
    private TextView bDh;
    private CouponEntranceView bDi;
    private View bDj;
    private com.baidu.poly.widget.coupon.l bDk;
    private Long bDl;
    private Long bDm;
    private com.baidu.poly.a.i.c bDn;
    private com.baidu.poly.widget.c bDo;
    private o bDp;
    private boolean bDq;
    private boolean bDr;
    private boolean ja;
    private boolean ka;
    private View r;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class a implements com.baidu.poly.a.j.a {
        final /* synthetic */ com.baidu.poly.a.j.a bAA;

        a(com.baidu.poly.a.j.a aVar) {
            this.bAA = aVar;
        }

        @Override // com.baidu.poly.a.j.a
        public void a(a.C0246a c0246a) {
            if (c0246a.statusCode == 0) {
                m.this.bDl = Long.valueOf(c0246a.bAy);
                m.this.W();
                if (m.this.bDb != null && m.this.bDb.G() == 1) {
                    m.this.bDb.k(c0246a.bAz);
                }
            }
            this.bAA.a(c0246a);
            m.this.bDi.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class b extends com.baidu.poly.a.a.a<JSONObject> {
        b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.poly.a.a.a
        public void a(JSONObject jSONObject) {
            m.this.bDl = Long.valueOf(jSONObject.optLong("payMoney"));
            JSONArray optJSONArray = jSONObject.optJSONArray("payChannels");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                o[] oVarArr = new o[optJSONArray.length()];
                for (int i = 0; i < optJSONArray.length(); i++) {
                    oVarArr[i] = new o(optJSONArray.optJSONObject(i));
                }
                m.this.bDc = oVarArr;
                m.this.bCo = new com.baidu.poly.widget.coupon.a(jSONObject.optJSONArray("coupons"));
                m.this.bDi.a(m.this.bCo);
                if (m.this.bDk != null) {
                    m.this.bDk.a(m.this.bCo.bCr);
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("marketChannels");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    m.this.bDb = new o(optJSONArray2.optJSONObject(0));
                }
                com.baidu.poly.a.g.a.i("7");
                if (m.this.bDc.length != 1 || m.this.bDi.getVisibility() != 8 || m.this.bDb != null) {
                    m.this.W();
                    if (m.this.bDb != null || m.this.bDi.getVisibility() != 8) {
                        m.this.S.setVisibility(0);
                    } else {
                        m.this.S.setVisibility(8);
                    }
                    m.this.S();
                    m mVar = m.this;
                    mVar.b(mVar.a(mVar.bDc));
                    m.this.bCY.h();
                    m.this.X();
                    m.this.bDr = true;
                    m.this.ba();
                    return;
                }
                m.this.bDr = true;
                m.this.ba();
                m.this.bCY.b(m.this.bDc[0].H(), "即将进入" + m.this.bDc[0].getDisplayName() + "…");
                m mVar2 = m.this;
                mVar2.b(mVar2.bDc[0]);
                return;
            }
            com.baidu.poly.a.g.a.a("7", null, null);
            a(new com.baidu.poly.a.h.b("channelList is null"), "request channelList payChannels is null");
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            if (m.this.bDc == null) {
                m mVar = m.this;
                mVar.n(mVar.getResources().getString(b.g.common_error_tips));
                m.this.onResult(3, "request channel list fail");
                m.this.detach();
                com.baidu.poly.a.g.d.a(new com.baidu.poly.a.g.b("1").gF(new com.baidu.poly.a.h.a("gatewaylist error --> " + str, th).L()));
            }
        }
    }

    /* loaded from: classes11.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            m.this.aa();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class d implements Animation.AnimationListener {
        d() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            m.this.bDq = true;
            m.this.ba();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class e implements HostMarketView.a {
        e() {
        }

        @Override // com.baidu.poly.widget.hostmarket.HostMarketView.a
        public void a(boolean z, o oVar, com.baidu.poly.a.j.a aVar) {
            m.this.bCX.a(true);
            m mVar = m.this;
            mVar.postDelayed(mVar.bCM, 500L);
            if (oVar != null) {
                ArrayList arrayList = new ArrayList();
                if (z) {
                    arrayList.add(oVar.F());
                }
                if (m.this.bDi.getSelectedItem() != null) {
                    arrayList.add(m.this.bDi.getSelectedItem().bCx);
                }
                m.this.a(arrayList, aVar);
            }
        }

        @Override // com.baidu.poly.widget.hostmarket.HostMarketView.a
        public void b(a.C0246a c0246a) {
            m.this.bCX.a(false);
            m mVar = m.this;
            mVar.removeCallbacks(mVar.bCM);
            m.this.T();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.getParent() instanceof ViewGroup) {
                m mVar = m.this;
                mVar.startAnimation(mVar.bDf);
                ((ViewGroup) m.this.getParent()).removeView(m.this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            m.this.R();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (m.this.bDo == null || !m.this.bDo.isShowing()) {
                return;
            }
            m.this.bDo.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class i implements c.b {
        i() {
        }

        @Override // com.baidu.poly.widget.c.b
        public void onDismiss() {
            m.this.R();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class j implements a.InterfaceC0251a {
        final /* synthetic */ o[] bCV;
        final /* synthetic */ o bCW;

        j(o[] oVarArr, o oVar) {
            this.bCV = oVarArr;
            this.bCW = oVar;
        }

        @Override // com.baidu.poly.widget.a.InterfaceC0251a
        public void a() {
            o[] oVarArr = this.bCV;
            int length = oVarArr.length;
            for (int i = 0; i < length; i++) {
                o oVar = oVarArr[i];
                oVar.h(oVar == this.bCW ? 1 : 0);
            }
            m.this.b(this.bCV);
        }
    }

    /* loaded from: classes11.dex */
    public interface l {
        void onClose();
    }

    public m(PolyActivity polyActivity) {
        super(polyActivity);
        this.bDp = null;
        this.ja = true;
        this.ka = false;
        this.bCM = new c();
        this.bDq = false;
        this.bDr = false;
        U();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R() {
        com.baidu.poly.widget.c cVar = this.bDo;
        boolean z = ((cVar != null && cVar.isShowing()) || this.F || this.D) ? false : true;
        o oVar = this.bDp;
        if ((oVar != null && (TextUtils.equals(oVar.I(), "BAIDU-ALIPAY-WISE") || TextUtils.equals(this.bDp.I(), "BAIDU-ALIPAY-WISE-HUABEI-PAY"))) || this.ka) {
            com.baidu.poly.util.d.info("ChannelListView->confirmViewClose() ali pay channel");
            z &= this.ja;
        }
        com.baidu.poly.util.d.info("ChannelListView->confirmViewClose() canFinishActivity = " + z);
        if (!z || this.bDd == null) {
            return;
        }
        com.baidu.poly.util.d.info("ChannelListView->confirmViewClose() finish activity");
        this.bDd.onClose();
        this.bDd = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        this.bDg.a(this.bDb);
        this.bDg.setListener(new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        com.baidu.poly.a.k.a.a(this.bCK);
        this.bCK = null;
    }

    private void U() {
        this.bDe = AnimationUtils.loadAnimation(getContext(), b.a.slide_in_bottom);
        this.bDf = AnimationUtils.loadAnimation(getContext(), b.a.slide_out_bottom);
        LayoutInflater.from(getContext()).inflate(b.f.view_channel_list, this);
        this.r = findViewById(b.e.bg_view);
        this.bCX = (PolyFrameLayout) findViewById(b.e.popup_view);
        this.bDj = findViewById(b.e.pay_money_layout);
        this.aa = findViewById(b.e.channel_list_scroll_view);
        this.bCY = (TipView) findViewById(b.e.tip_view);
        this.bCZ = (ViewGroup) findViewById(b.e.channel_list_view);
        this.bDa = (ProgressButton) findViewById(b.e.pay_button);
        this.S = findViewById(b.e.line);
        findViewById(b.e.close_button).setOnClickListener(this);
        this.bDa.setOnClickListener(this);
        this.bDg = (HostMarketView) findViewById(b.e.hostmarket);
        this.bDi = (CouponEntranceView) findViewById(b.e.coupon);
        this.bDi.setOnClickListener(this);
        this.bDh = (TextView) findViewById(b.e.money);
        this.R = (TextView) findViewById(b.e.cut);
    }

    private void V() {
        List<a.C0253a> list;
        com.baidu.poly.widget.coupon.a aVar = this.bCo;
        if (aVar != null && (list = aVar.bCr) != null && list.size() > 0) {
            this.bDk = new com.baidu.poly.widget.coupon.l(getContext());
            this.bDk.a(this.bCX.getMeasuredHeight());
            this.bDk.setListener(new k());
            this.bDk.a(this.bCo.bCr);
            this.bDk.a(this.bCX);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W() {
        Long l2;
        Long l3 = this.bDm;
        if (l3 != null && (l2 = this.bDl) != null) {
            if (l3.equals(l2)) {
                this.bDh.setText(a(this.bDl.longValue()));
                this.R.setVisibility(8);
            } else {
                this.R.setVisibility(0);
                this.bDh.setText(a(this.bDl.longValue()));
                this.R.setText(" ¥" + a(this.bDm.longValue()));
            }
            if (this.bDj.getVisibility() != 0) {
                this.bDj.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X() {
        if (this.G <= 0) {
            this.bDa.setVisibility(4);
            return;
        }
        this.bDa.setVisibility(0);
        this.bDa.setEnable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y() {
        com.baidu.poly.a.b.a.NU().a(this.bAW, new b());
    }

    private void Z() {
        this.r.setVisibility(0);
        this.bCX.setVisibility(0);
        this.r.setAlpha(0.0f);
        this.r.animate().alpha(0.65f).setDuration(240L).start();
        this.bCX.startAnimation(this.bDe);
        this.bDe.setAnimationListener(new d());
        X();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.bCK = com.baidu.poly.a.k.a.a(this.bCX, layoutParams, "加载中", -1L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ba() {
        if (this.bDq && this.bDr) {
            com.baidu.poly.a.g.a.w();
        }
    }

    public void detach() {
        if (this.D) {
            this.D = false;
            this.r.animate().alpha(0.0f).setDuration(240L).start();
            postDelayed(new f(), 240L);
            postDelayed(new g(), 480L);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.F || super.dispatchTouchEvent(motionEvent);
    }

    public boolean onBackPressed() {
        com.baidu.poly.widget.coupon.l lVar = this.bDk;
        if (lVar != null) {
            lVar.onBackPressed();
            return true;
        } else if (this.F) {
            return true;
        } else {
            if (this.D) {
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
            com.baidu.poly.a.g.d.a(new com.baidu.poly.a.g.b("6"));
        } else if (view.getId() == b.e.pay_button) {
            if (this.G != 0) {
                this.bDa.startLoading();
                this.F = true;
                this.ja = false;
                o[] oVarArr = this.bDc;
                int length = oVarArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        oVar = null;
                        break;
                    }
                    oVar = oVarArr[i2];
                    if (oVar.G() == 1) {
                        break;
                    }
                    i2++;
                }
                b(oVar);
                com.baidu.poly.a.g.d.a(new com.baidu.poly.a.g.b("5").gF(oVar != null ? gH(oVar.I()) : null));
            }
        } else if (view.getId() == b.e.coupon) {
            V();
        }
    }

    public void onResult(int i2, String str) {
        com.baidu.poly.util.d.info("ChannelListView->onResult() statusCode = " + i2 + " result = " + str);
        this.ja = true;
        a.b bVar = this.bAT;
        if (bVar != null) {
            bVar.onResult(i2, str);
            this.bAT = null;
        }
        com.baidu.poly.a.g.d.b(i2, str);
        if (((PolyActivity) getContext()).isFinishing()) {
            com.baidu.poly.a.g.d.flush();
        }
        R();
    }

    public void setIsPreparePaying(boolean z) {
        this.F = z;
        R();
        detach();
    }

    public void setWechatH5Pay(boolean z) {
        this.ka = z;
    }

    private String gH(String str) {
        if (TextUtils.isEmpty(str)) {
            return "unknown";
        }
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1537577171:
                if (str.equals("BAIDU-QUICKPAY")) {
                    c2 = 4;
                    break;
                }
                break;
            case -1021180251:
                if (str.equals("BAIDU-ALIPAY-WISE-HUABEI-PAY")) {
                    c2 = 2;
                    break;
                }
                break;
            case 299450696:
                if (str.equals("BAIDU-BAIFUBAO-WISE")) {
                    c2 = 3;
                    break;
                }
                break;
            case 1455583605:
                if (str.equals("BAIDU-ALIPAY-WISE")) {
                    c2 = 1;
                    break;
                }
                break;
            case 2009937959:
                if (str.equals("BAIDU-SUPER-WECHAT-WISE")) {
                    c2 = 0;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return "1";
            case 1:
                return "2";
            case 2:
                return "3";
            case 3:
                return "4";
            case 4:
                return "10";
            default:
                return "unknown";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(String str) {
        if (TextUtils.isEmpty(str)) {
            str = getResources().getString(b.g.common_error_tips);
        }
        if (this.bDo == null) {
            View inflate = View.inflate(this.bCZ.getContext(), b.f.default_pop_window, null);
            ((TextView) inflate.findViewById(b.e.pop_title)).setText("收银员正在找零，请您稍等哦～");
            ((TextView) inflate.findViewById(b.e.pop_tips)).setText(str.trim());
            this.bDo = new com.baidu.poly.widget.c(inflate, -1, -1, true);
            this.bDo.setClippingEnabled(false);
            this.bDo.setOutsideTouchable(false);
            this.bDo.setBackgroundDrawable(new ColorDrawable(0));
            ((TextView) inflate.findViewById(b.e.pop_button)).setOnClickListener(new h());
            this.bDo.a(new i());
        }
        PolyActivity polyActivity = (PolyActivity) getContext();
        if (polyActivity.isFinishing()) {
            return;
        }
        this.bDo.showAtLocation(polyActivity.getWindow().getDecorView(), 0, 0, 0);
    }

    public m Ot() {
        if (!this.D) {
            this.D = true;
            if (!(getContext() instanceof Activity)) {
                throw new IllegalStateException("can not attach to context " + getContext());
            }
            this.bCY.a("收银台加载中...");
            com.baidu.poly.util.d.info("ChannelListView->attach()");
            Z();
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class k implements l.h {
        k() {
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void b() {
            m.this.Y();
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void d() {
            if (m.this.bDk != null) {
                m.this.bDk.b(m.this.bCX);
            }
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void onDetach() {
            m.this.bDk = null;
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void a(a.C0253a c0253a, com.baidu.poly.a.j.a aVar) {
            if (c0253a != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(c0253a.bCx);
                if (m.this.bDb != null && m.this.bDb.G() == 1) {
                    arrayList.add(m.this.bDb.F());
                }
                m.this.a(arrayList, aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(o[] oVarArr) {
        this.aa.setMinimumHeight(0);
        if (oVarArr != null) {
            this.bCZ.removeAllViews();
            for (o oVar : oVarArr) {
                com.baidu.poly.widget.a aVar = new com.baidu.poly.widget.a(getContext());
                aVar.a(oVar, new j(oVarArr, oVar));
                this.bCZ.addView(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public o[] a(o[] oVarArr) {
        int i2 = 0;
        for (o oVar : oVarArr) {
            if (oVar.G() == 1 && (i2 = i2 + 1) > 1) {
                oVar.h(0);
            }
            if (oVar.E() == 1) {
                this.G++;
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
                if (oVar2.E() == 1) {
                    oVar2.h(1);
                    break;
                }
                i3++;
            }
        }
        return oVarArr;
    }

    public m n(Bundle bundle) {
        if (bundle != null) {
            try {
                this.bDm = Long.valueOf(Long.parseLong(bundle.getString("totalAmount")));
            } catch (NumberFormatException e2) {
            }
        }
        this.bAW = bundle;
        Y();
        return this;
    }

    public m a(a.b bVar) {
        this.bAT = bVar;
        return this;
    }

    public m a(l lVar) {
        this.bDd = lVar;
        return this;
    }

    public m a(com.baidu.poly.a.i.c cVar) {
        this.bDn = cVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(o oVar) {
        if (oVar != null) {
            com.baidu.poly.a.g.a.c(Long.valueOf(System.currentTimeMillis()));
            JSONArray jSONArray = new JSONArray();
            try {
                if (this.bDb != null && this.bDb.G() == 1 && !TextUtils.isEmpty(this.bDb.F())) {
                    jSONArray.put(new JSONObject(this.bDb.F()));
                }
                if (this.bDi.getSelectedItem() != null && !TextUtils.isEmpty(this.bDi.getSelectedItem().bCx)) {
                    jSONArray.put(new JSONObject(this.bDi.getSelectedItem().bCx));
                }
            } catch (Exception e2) {
            }
            if (jSONArray.length() > 0) {
                this.bAW.putString("hostMarketingDetail", jSONArray.toString());
            }
            com.baidu.poly.a.i.c cVar = this.bDn;
            if (cVar != null) {
                this.bDp = oVar;
                cVar.b(this.bAW, oVar.I(), this);
            }
        }
    }

    public void a(String str, String str2) {
        com.baidu.poly.util.d.info("ChannelListView->errorEnd()");
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
    public void a(List<String> list, com.baidu.poly.a.j.a aVar) {
        if (aVar == null) {
            return;
        }
        com.baidu.poly.a.j.b.a(this.bAW.getString("bduss"), this.bAW.getString("appKey"), this.bDm + "", list, new a(aVar));
    }

    private String a(long j2) {
        return new DecimalFormat("0.00").format((j2 * 1.0d) / 100.0d);
    }
}

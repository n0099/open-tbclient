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
/* loaded from: classes10.dex */
public class l extends FrameLayout implements View.OnClickListener {
    private boolean D;
    private boolean F;
    private int G;
    private a.b aNH;
    private Bundle aNK;
    private com.baidu.poly.a.k.c aPA;
    private Runnable aPC;
    private PolyFrameLayout aPN;
    private TipView aPO;
    private ViewGroup aPP;
    private ProgressButton aPQ;
    private n aPR;
    private n[] aPS;
    private k aPT;
    private Animation aPU;
    private Animation aPV;
    private HostMarketView aPW;
    private TextView aPX;
    private TextView aPY;
    private View aPZ;
    private com.baidu.poly.widget.coupon.a aPd;
    private CouponEntranceView aQa;
    private View aQb;
    private com.baidu.poly.widget.coupon.l aQc;
    private Long aQd;
    private Long aQe;
    private com.baidu.poly.a.i.c aQf;
    private com.baidu.poly.widget.c aQg;
    private n aQh;
    private boolean aQi;
    private View aa;
    private boolean ka;
    private View s;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class a extends com.baidu.poly.a.a.a<JSONObject> {
        a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.poly.a.a.a
        public void a(JSONObject jSONObject) {
            l.this.aQd = Long.valueOf(jSONObject.optLong("payMoney"));
            JSONArray optJSONArray = jSONObject.optJSONArray("payChannels");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                n[] nVarArr = new n[optJSONArray.length()];
                for (int i = 0; i < optJSONArray.length(); i++) {
                    nVarArr[i] = new n(optJSONArray.optJSONObject(i));
                }
                l.this.aPS = nVarArr;
                l.this.aPd = new com.baidu.poly.widget.coupon.a(jSONObject.optJSONArray("coupons"));
                l.this.aQa.a(l.this.aPd);
                if (l.this.aQc != null) {
                    l.this.aQc.a(l.this.aPd.aPg);
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("marketChannels");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    l.this.aPR = new n(optJSONArray2.optJSONObject(0));
                }
                if (l.this.aPS.length != 1 || l.this.aQa.getVisibility() != 8 || l.this.aPR != null) {
                    l.this.L();
                    if (l.this.aPR != null || l.this.aQa.getVisibility() != 8) {
                        l.this.aPZ.setVisibility(0);
                    } else {
                        l.this.aPZ.setVisibility(8);
                    }
                    l.this.H();
                    l lVar = l.this;
                    lVar.b(lVar.a(lVar.aPS));
                    l.this.aPO.f();
                    l.this.M();
                    return;
                }
                l.this.aPO.a(l.this.aPS[0].x(), "即将进入" + l.this.aPS[0].t() + "…");
                l lVar2 = l.this;
                lVar2.b(lVar2.aPS[0]);
                return;
            }
            a(new com.baidu.poly.a.h.b("channelList is null"), "request channelList payChannels is null");
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            if (l.this.aPS == null) {
                l.this.m("网络不给力，请稍后重试");
                l.this.onResult(3, "request channel list fail");
                l.this.detach();
                com.baidu.poly.a.g.c.a(new com.baidu.poly.a.g.a("1").eA(new com.baidu.poly.a.h.a("gatewaylist error --> " + str, th).B()));
            }
        }
    }

    /* loaded from: classes10.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l.this.P();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class c implements HostMarketView.a {
        c() {
        }

        @Override // com.baidu.poly.widget.hostmarket.HostMarketView.a
        public void a(boolean z, n nVar, com.baidu.poly.a.j.a aVar) {
            l.this.aPN.a(true);
            l lVar = l.this;
            lVar.postDelayed(lVar.aPC, 500L);
            if (nVar != null) {
                ArrayList arrayList = new ArrayList();
                if (z) {
                    arrayList.add(nVar.v());
                }
                if (l.this.aQa.getSelectedItem() != null) {
                    arrayList.add(l.this.aQa.getSelectedItem().aPm);
                }
                l.this.a(arrayList, aVar);
            }
        }

        @Override // com.baidu.poly.widget.hostmarket.HostMarketView.a
        public void b(a.C0152a c0152a) {
            l.this.aPN.a(false);
            l lVar = l.this;
            lVar.removeCallbacks(lVar.aPC);
            l.this.I();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (l.this.getParent() instanceof ViewGroup) {
                l lVar = l.this;
                lVar.startAnimation(lVar.aPV);
                ((ViewGroup) l.this.getParent()).removeView(l.this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l.this.G();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.this.aQg == null || !l.this.aQg.isShowing()) {
                return;
            }
            l.this.aQg.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class g implements c.b {
        g() {
        }

        @Override // com.baidu.poly.widget.c.b
        public void onDismiss() {
            l.this.G();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class h implements a.InterfaceC0157a {
        final /* synthetic */ n[] aPL;
        final /* synthetic */ n aPM;

        h(n[] nVarArr, n nVar) {
            this.aPL = nVarArr;
            this.aPM = nVar;
        }

        @Override // com.baidu.poly.widget.a.InterfaceC0157a
        public void a() {
            n[] nVarArr = this.aPL;
            int length = nVarArr.length;
            for (int i = 0; i < length; i++) {
                n nVar = nVarArr[i];
                nVar.h(nVar == this.aPM ? 1 : 0);
            }
            l.this.b(this.aPL);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class j implements com.baidu.poly.a.j.a {
        final /* synthetic */ com.baidu.poly.a.j.a aNn;

        j(com.baidu.poly.a.j.a aVar) {
            this.aNn = aVar;
        }

        @Override // com.baidu.poly.a.j.a
        public void a(a.C0152a c0152a) {
            if (c0152a.statusCode == 0) {
                l.this.aQd = Long.valueOf(c0152a.aNl);
                l.this.L();
                if (l.this.aPR != null && l.this.aPR.w() == 1) {
                    l.this.aPR.j(c0152a.aNm);
                }
            }
            this.aNn.a(c0152a);
            l.this.aQa.e();
        }
    }

    /* loaded from: classes10.dex */
    public interface k {
        void onClose();
    }

    public l(PolyActivity polyActivity) {
        super(polyActivity);
        this.aQh = null;
        this.aQi = true;
        this.ka = false;
        this.aPC = new b();
        J();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        com.baidu.poly.widget.c cVar = this.aQg;
        boolean z = ((cVar != null && cVar.isShowing()) || this.F || this.D) ? false : true;
        n nVar = this.aQh;
        if ((nVar != null && TextUtils.equals(nVar.y(), "BAIDU-ALIPAY-WISE")) || this.ka) {
            com.baidu.poly.util.c.info("ChannelListView->confirmViewClose() ali pay channel");
            z &= this.aQi;
        }
        com.baidu.poly.util.c.info("ChannelListView->confirmViewClose() canFinishActivity = " + z);
        if (!z || this.aPT == null) {
            return;
        }
        com.baidu.poly.util.c.info("ChannelListView->confirmViewClose() finish activity");
        this.aPT.onClose();
        this.aPT = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        this.aPW.a(this.aPR);
        this.aPW.setListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        com.baidu.poly.a.k.a.a(this.aPA);
        this.aPA = null;
    }

    private void J() {
        this.aPU = AnimationUtils.loadAnimation(getContext(), b.a.slide_in_bottom);
        this.aPV = AnimationUtils.loadAnimation(getContext(), b.a.slide_out_bottom);
        LayoutInflater.from(getContext()).inflate(b.f.view_channel_list, this);
        this.s = findViewById(b.e.bg_view);
        this.aPN = (PolyFrameLayout) findViewById(b.e.popup_view);
        this.aQb = findViewById(b.e.pay_money_layout);
        this.aa = findViewById(b.e.channel_list_scroll_view);
        this.aPO = (TipView) findViewById(b.e.tip_view);
        this.aPP = (ViewGroup) findViewById(b.e.channel_list_view);
        this.aPQ = (ProgressButton) findViewById(b.e.pay_button);
        this.aPZ = findViewById(b.e.line);
        findViewById(b.e.close_button).setOnClickListener(this);
        this.aPQ.setOnClickListener(this);
        this.aPW = (HostMarketView) findViewById(b.e.hostmarket);
        this.aQa = (CouponEntranceView) findViewById(b.e.coupon);
        this.aQa.setOnClickListener(this);
        this.aPX = (TextView) findViewById(b.e.money);
        this.aPY = (TextView) findViewById(b.e.cut);
    }

    private void K() {
        List<a.C0159a> list;
        com.baidu.poly.widget.coupon.a aVar = this.aPd;
        if (aVar != null && (list = aVar.aPg) != null && list.size() > 0) {
            this.aQc = new com.baidu.poly.widget.coupon.l(getContext());
            this.aQc.a(this.aPN.getMeasuredHeight());
            this.aQc.setListener(new i());
            this.aQc.a(this.aPd.aPg);
            this.aQc.a(this.aPN);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        Long l;
        Long l2 = this.aQe;
        if (l2 != null && (l = this.aQd) != null) {
            if (l2.equals(l)) {
                this.aPX.setText(a(this.aQd.longValue()));
                this.aPY.setVisibility(8);
            } else {
                this.aPY.setVisibility(0);
                this.aPX.setText(a(this.aQd.longValue()));
                this.aPY.setText(" ¥" + a(this.aQe.longValue()));
            }
            if (this.aQb.getVisibility() != 0) {
                this.aQb.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        if (this.G <= 0) {
            this.aPQ.setVisibility(4);
            return;
        }
        this.aPQ.setVisibility(0);
        this.aPQ.setEnable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        com.baidu.poly.a.b.a.Cc().a(this.aNK, new a());
    }

    private void O() {
        this.s.setVisibility(0);
        this.aPN.setVisibility(0);
        this.s.setAlpha(0.0f);
        this.s.animate().alpha(0.65f).setDuration(240L).start();
        this.aPN.startAnimation(this.aPU);
        M();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.aPA = com.baidu.poly.a.k.a.a(this.aPN, layoutParams, "加载中", -1L);
    }

    public void detach() {
        if (this.D) {
            this.D = false;
            this.s.animate().alpha(0.0f).setDuration(240L).start();
            postDelayed(new d(), 240L);
            postDelayed(new e(), 480L);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.F || super.dispatchTouchEvent(motionEvent);
    }

    public boolean onBackPressed() {
        com.baidu.poly.widget.coupon.l lVar = this.aQc;
        if (lVar != null) {
            lVar.onBackPressed();
            return true;
        } else if (this.F) {
            return true;
        } else {
            if (this.D) {
                onResult(2, com.baidu.poly.util.a.a(2, null, "key_back_cancel"));
                detach();
                return true;
            }
            return false;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        n nVar;
        if (view.getId() == b.e.close_button) {
            onResult(2, "主动取消支付");
            detach();
            com.baidu.poly.a.g.c.a(new com.baidu.poly.a.g.a("6"));
        } else if (view.getId() == b.e.pay_button) {
            if (this.G != 0) {
                this.aPQ.startLoading();
                this.F = true;
                this.aQi = false;
                n[] nVarArr = this.aPS;
                int length = nVarArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        nVar = null;
                        break;
                    }
                    nVar = nVarArr[i2];
                    if (nVar.w() == 1) {
                        break;
                    }
                    i2++;
                }
                b(nVar);
                com.baidu.poly.a.g.c.a(new com.baidu.poly.a.g.a("5").eA(nVar != null ? eD(nVar.y()) : null));
            }
        } else if (view.getId() == b.e.coupon) {
            K();
        }
    }

    public void onResult(int i2, String str) {
        com.baidu.poly.util.c.info("ChannelListView->onResult() statusCode = " + i2 + " result = " + str);
        this.aQi = true;
        a.b bVar = this.aNH;
        if (bVar != null) {
            bVar.onResult(i2, str);
            this.aNH = null;
        }
        com.baidu.poly.a.g.c.b(i2, str);
        if (((PolyActivity) getContext()).isFinishing()) {
            com.baidu.poly.a.g.c.flush();
        }
        G();
    }

    public void setIsPreparePaying(boolean z) {
        this.F = z;
        G();
        detach();
    }

    public void setWechatH5Pay(boolean z) {
        this.ka = z;
    }

    private String eD(String str) {
        if (TextUtils.isEmpty(str)) {
            return "unknown";
        }
        char c2 = 65535;
        int hashCode = str.hashCode();
        if (hashCode != -1537577171) {
            if (hashCode != 299450696) {
                if (hashCode != 1455583605) {
                    if (hashCode == 2009937959 && str.equals("BAIDU-SUPER-WECHAT-WISE")) {
                        c2 = 0;
                    }
                } else if (str.equals("BAIDU-ALIPAY-WISE")) {
                    c2 = 1;
                }
            } else if (str.equals("BAIDU-BAIFUBAO-WISE")) {
                c2 = 2;
            }
        } else if (str.equals("BAIDU-QUICKPAY")) {
            c2 = 3;
        }
        switch (c2) {
            case 0:
                return "1";
            case 1:
                return "2";
            case 2:
                return "4";
            case 3:
                return "10";
            default:
                return "unknown";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (this.aQg == null) {
                View inflate = View.inflate(this.aPP.getContext(), b.f.default_pop_window, null);
                ((TextView) inflate.findViewById(b.e.pop_title)).setText("收银员正在找零，请您稍等哦～");
                ((TextView) inflate.findViewById(b.e.pop_tips)).setText(str.trim());
                this.aQg = new com.baidu.poly.widget.c(inflate, -1, -1, true);
                this.aQg.setClippingEnabled(false);
                this.aQg.setOutsideTouchable(false);
                this.aQg.setBackgroundDrawable(new ColorDrawable(0));
                ((TextView) inflate.findViewById(b.e.pop_button)).setOnClickListener(new f());
                this.aQg.a(new g());
            }
            PolyActivity polyActivity = (PolyActivity) getContext();
            if (!polyActivity.isFinishing()) {
                this.aQg.showAtLocation(polyActivity.getWindow().getDecorView(), 0, 0, 0);
            }
        }
    }

    public l Cn() {
        if (!this.D) {
            this.D = true;
            if (!(getContext() instanceof Activity)) {
                throw new IllegalStateException("can not attach to context " + getContext());
            }
            this.aPO.b("收银台加载中...");
            com.baidu.poly.util.c.info("ChannelListView->attach()");
            O();
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class i implements l.h {
        i() {
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void b() {
            l.this.N();
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void c() {
            if (l.this.aQc != null) {
                l.this.aQc.b(l.this.aPN);
            }
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void onDetach() {
            l.this.aQc = null;
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void a(a.C0159a c0159a, com.baidu.poly.a.j.a aVar) {
            if (c0159a != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(c0159a.aPm);
                if (l.this.aPR != null && l.this.aPR.w() == 1) {
                    arrayList.add(l.this.aPR.v());
                }
                l.this.a(arrayList, aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(n[] nVarArr) {
        this.aa.setMinimumHeight(0);
        if (nVarArr != null) {
            this.aPP.removeAllViews();
            for (n nVar : nVarArr) {
                com.baidu.poly.widget.a aVar = new com.baidu.poly.widget.a(getContext());
                aVar.a(nVar, new h(nVarArr, nVar));
                this.aPP.addView(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public n[] a(n[] nVarArr) {
        int i2 = 0;
        for (n nVar : nVarArr) {
            if (nVar.w() == 1 && (i2 = i2 + 1) > 1) {
                nVar.h(0);
            }
            if (nVar.u() == 1) {
                this.G++;
            }
        }
        if (i2 == 0) {
            int length = nVarArr.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                n nVar2 = nVarArr[i3];
                if (nVar2.u() == 1) {
                    nVar2.h(1);
                    break;
                }
                i3++;
            }
        }
        return nVarArr;
    }

    public l l(Bundle bundle) {
        if (bundle != null) {
            try {
                this.aQe = Long.valueOf(Long.parseLong(bundle.getString("totalAmount")));
            } catch (NumberFormatException e2) {
            }
        }
        this.aNK = bundle;
        N();
        return this;
    }

    public l a(a.b bVar) {
        this.aNH = bVar;
        return this;
    }

    public l a(k kVar) {
        this.aPT = kVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(n nVar) {
        if (nVar != null) {
            JSONArray jSONArray = new JSONArray();
            try {
                if (this.aPR != null && this.aPR.w() == 1 && !TextUtils.isEmpty(this.aPR.v())) {
                    jSONArray.put(new JSONObject(this.aPR.v()));
                }
                if (this.aQa.getSelectedItem() != null && !TextUtils.isEmpty(this.aQa.getSelectedItem().aPm)) {
                    jSONArray.put(new JSONObject(this.aQa.getSelectedItem().aPm));
                }
            } catch (Exception e2) {
            }
            if (jSONArray.length() > 0) {
                this.aNK.putString("hostMarketingDetail", jSONArray.toString());
            }
            com.baidu.poly.a.i.c cVar = this.aQf;
            if (cVar != null) {
                this.aQh = nVar;
                cVar.b(this.aNK, nVar.y(), this);
            }
        }
    }

    public l a(com.baidu.poly.a.i.c cVar) {
        this.aQf = cVar;
        return this;
    }

    public void a(String str) {
        com.baidu.poly.util.c.info("ChannelListView->errorEnd()");
        if (com.baidu.poly.util.c.aNC) {
            m(str);
        } else {
            m("网络不给力，请稍后重试");
        }
        onResult(3, str);
        setIsPreparePaying(false);
    }

    public void a(int i2, String str) {
        com.baidu.poly.util.c.info("ChannelListView->payEnd()");
        onResult(i2, str);
        setIsPreparePaying(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<String> list, com.baidu.poly.a.j.a aVar) {
        if (aVar == null) {
            return;
        }
        com.baidu.poly.a.j.b.a(this.aNK.getString("bduss"), this.aNK.getString("appKey"), this.aQe + "", list, new j(aVar));
    }

    private String a(long j2) {
        return new DecimalFormat("0.00").format((j2 * 1.0d) / 100.0d);
    }
}

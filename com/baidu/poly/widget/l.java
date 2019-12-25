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
/* loaded from: classes9.dex */
public class l extends FrameLayout implements View.OnClickListener {
    private boolean D;
    private boolean F;
    private int G;
    private a.b aMP;
    private Bundle aMS;
    private com.baidu.poly.a.k.c aOI;
    private Runnable aOK;
    private PolyFrameLayout aOV;
    private TipView aOW;
    private ViewGroup aOX;
    private ProgressButton aOY;
    private n aOZ;
    private com.baidu.poly.widget.coupon.a aOl;
    private n[] aPa;
    private k aPb;
    private Animation aPc;
    private Animation aPd;
    private HostMarketView aPe;
    private TextView aPf;
    private TextView aPg;
    private View aPh;
    private CouponEntranceView aPi;
    private View aPj;
    private com.baidu.poly.widget.coupon.l aPk;
    private Long aPl;
    private Long aPm;
    private com.baidu.poly.a.i.c aPn;
    private com.baidu.poly.widget.c aPo;
    private n aPp;
    private boolean aPq;
    private View aa;
    private boolean ka;
    private View s;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class a extends com.baidu.poly.a.a.a<JSONObject> {
        a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.poly.a.a.a
        public void a(JSONObject jSONObject) {
            l.this.aPl = Long.valueOf(jSONObject.optLong("payMoney"));
            JSONArray optJSONArray = jSONObject.optJSONArray("payChannels");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                n[] nVarArr = new n[optJSONArray.length()];
                for (int i = 0; i < optJSONArray.length(); i++) {
                    nVarArr[i] = new n(optJSONArray.optJSONObject(i));
                }
                l.this.aPa = nVarArr;
                l.this.aOl = new com.baidu.poly.widget.coupon.a(jSONObject.optJSONArray("coupons"));
                l.this.aPi.a(l.this.aOl);
                if (l.this.aPk != null) {
                    l.this.aPk.a(l.this.aOl.aOo);
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("marketChannels");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    l.this.aOZ = new n(optJSONArray2.optJSONObject(0));
                }
                if (l.this.aPa.length != 1 || l.this.aPi.getVisibility() != 8 || l.this.aOZ != null) {
                    l.this.L();
                    if (l.this.aOZ != null || l.this.aPi.getVisibility() != 8) {
                        l.this.aPh.setVisibility(0);
                    } else {
                        l.this.aPh.setVisibility(8);
                    }
                    l.this.H();
                    l lVar = l.this;
                    lVar.b(lVar.a(lVar.aPa));
                    l.this.aOW.f();
                    l.this.M();
                    return;
                }
                l.this.aOW.a(l.this.aPa[0].x(), "即将进入" + l.this.aPa[0].t() + "…");
                l lVar2 = l.this;
                lVar2.b(lVar2.aPa[0]);
                return;
            }
            a(new com.baidu.poly.a.h.b("channelList is null"), "request channelList payChannels is null");
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            if (l.this.aPa == null) {
                l.this.m("网络不给力，请稍后重试");
                l.this.onResult(3, "request channel list fail");
                l.this.detach();
                com.baidu.poly.a.g.c.a(new com.baidu.poly.a.g.a("1").ex(new com.baidu.poly.a.h.a("gatewaylist error --> " + str, th).B()));
            }
        }
    }

    /* loaded from: classes9.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l.this.P();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class c implements HostMarketView.a {
        c() {
        }

        @Override // com.baidu.poly.widget.hostmarket.HostMarketView.a
        public void a(boolean z, n nVar, com.baidu.poly.a.j.a aVar) {
            l.this.aOV.a(true);
            l lVar = l.this;
            lVar.postDelayed(lVar.aOK, 500L);
            if (nVar != null) {
                ArrayList arrayList = new ArrayList();
                if (z) {
                    arrayList.add(nVar.v());
                }
                if (l.this.aPi.getSelectedItem() != null) {
                    arrayList.add(l.this.aPi.getSelectedItem().aOu);
                }
                l.this.a(arrayList, aVar);
            }
        }

        @Override // com.baidu.poly.widget.hostmarket.HostMarketView.a
        public void b(a.C0150a c0150a) {
            l.this.aOV.a(false);
            l lVar = l.this;
            lVar.removeCallbacks(lVar.aOK);
            l.this.I();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (l.this.getParent() instanceof ViewGroup) {
                l lVar = l.this;
                lVar.startAnimation(lVar.aPd);
                ((ViewGroup) l.this.getParent()).removeView(l.this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l.this.G();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.this.aPo == null || !l.this.aPo.isShowing()) {
                return;
            }
            l.this.aPo.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class g implements c.b {
        g() {
        }

        @Override // com.baidu.poly.widget.c.b
        public void onDismiss() {
            l.this.G();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class h implements a.InterfaceC0155a {
        final /* synthetic */ n[] aOT;
        final /* synthetic */ n aOU;

        h(n[] nVarArr, n nVar) {
            this.aOT = nVarArr;
            this.aOU = nVar;
        }

        @Override // com.baidu.poly.widget.a.InterfaceC0155a
        public void a() {
            n[] nVarArr = this.aOT;
            int length = nVarArr.length;
            for (int i = 0; i < length; i++) {
                n nVar = nVarArr[i];
                nVar.h(nVar == this.aOU ? 1 : 0);
            }
            l.this.b(this.aOT);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class j implements com.baidu.poly.a.j.a {
        final /* synthetic */ com.baidu.poly.a.j.a aMv;

        j(com.baidu.poly.a.j.a aVar) {
            this.aMv = aVar;
        }

        @Override // com.baidu.poly.a.j.a
        public void a(a.C0150a c0150a) {
            if (c0150a.statusCode == 0) {
                l.this.aPl = Long.valueOf(c0150a.aMt);
                l.this.L();
                if (l.this.aOZ != null && l.this.aOZ.w() == 1) {
                    l.this.aOZ.j(c0150a.aMu);
                }
            }
            this.aMv.a(c0150a);
            l.this.aPi.e();
        }
    }

    /* loaded from: classes9.dex */
    public interface k {
        void onClose();
    }

    public l(PolyActivity polyActivity) {
        super(polyActivity);
        this.aPp = null;
        this.aPq = true;
        this.ka = false;
        this.aOK = new b();
        J();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        com.baidu.poly.widget.c cVar = this.aPo;
        boolean z = ((cVar != null && cVar.isShowing()) || this.F || this.D) ? false : true;
        n nVar = this.aPp;
        if ((nVar != null && TextUtils.equals(nVar.y(), "BAIDU-ALIPAY-WISE")) || this.ka) {
            com.baidu.poly.util.c.info("ChannelListView->confirmViewClose() ali pay channel");
            z &= this.aPq;
        }
        com.baidu.poly.util.c.info("ChannelListView->confirmViewClose() canFinishActivity = " + z);
        if (!z || this.aPb == null) {
            return;
        }
        com.baidu.poly.util.c.info("ChannelListView->confirmViewClose() finish activity");
        this.aPb.onClose();
        this.aPb = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        this.aPe.a(this.aOZ);
        this.aPe.setListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        com.baidu.poly.a.k.a.a(this.aOI);
        this.aOI = null;
    }

    private void J() {
        this.aPc = AnimationUtils.loadAnimation(getContext(), b.a.slide_in_bottom);
        this.aPd = AnimationUtils.loadAnimation(getContext(), b.a.slide_out_bottom);
        LayoutInflater.from(getContext()).inflate(b.f.view_channel_list, this);
        this.s = findViewById(b.e.bg_view);
        this.aOV = (PolyFrameLayout) findViewById(b.e.popup_view);
        this.aPj = findViewById(b.e.pay_money_layout);
        this.aa = findViewById(b.e.channel_list_scroll_view);
        this.aOW = (TipView) findViewById(b.e.tip_view);
        this.aOX = (ViewGroup) findViewById(b.e.channel_list_view);
        this.aOY = (ProgressButton) findViewById(b.e.pay_button);
        this.aPh = findViewById(b.e.line);
        findViewById(b.e.close_button).setOnClickListener(this);
        this.aOY.setOnClickListener(this);
        this.aPe = (HostMarketView) findViewById(b.e.hostmarket);
        this.aPi = (CouponEntranceView) findViewById(b.e.coupon);
        this.aPi.setOnClickListener(this);
        this.aPf = (TextView) findViewById(b.e.money);
        this.aPg = (TextView) findViewById(b.e.cut);
    }

    private void K() {
        List<a.C0157a> list;
        com.baidu.poly.widget.coupon.a aVar = this.aOl;
        if (aVar != null && (list = aVar.aOo) != null && list.size() > 0) {
            this.aPk = new com.baidu.poly.widget.coupon.l(getContext());
            this.aPk.a(this.aOV.getMeasuredHeight());
            this.aPk.setListener(new i());
            this.aPk.a(this.aOl.aOo);
            this.aPk.a(this.aOV);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        Long l;
        Long l2 = this.aPm;
        if (l2 != null && (l = this.aPl) != null) {
            if (l2.equals(l)) {
                this.aPf.setText(a(this.aPl.longValue()));
                this.aPg.setVisibility(8);
            } else {
                this.aPg.setVisibility(0);
                this.aPf.setText(a(this.aPl.longValue()));
                this.aPg.setText(" ¥" + a(this.aPm.longValue()));
            }
            if (this.aPj.getVisibility() != 0) {
                this.aPj.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        if (this.G <= 0) {
            this.aOY.setVisibility(4);
            return;
        }
        this.aOY.setVisibility(0);
        this.aOY.setEnable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        com.baidu.poly.a.b.a.BG().a(this.aMS, new a());
    }

    private void O() {
        this.s.setVisibility(0);
        this.aOV.setVisibility(0);
        this.s.setAlpha(0.0f);
        this.s.animate().alpha(0.65f).setDuration(240L).start();
        this.aOV.startAnimation(this.aPc);
        M();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.aOI = com.baidu.poly.a.k.a.a(this.aOV, layoutParams, "加载中", -1L);
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
        com.baidu.poly.widget.coupon.l lVar = this.aPk;
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
                this.aOY.startLoading();
                this.F = true;
                this.aPq = false;
                n[] nVarArr = this.aPa;
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
                com.baidu.poly.a.g.c.a(new com.baidu.poly.a.g.a("5").ex(nVar != null ? eA(nVar.y()) : null));
            }
        } else if (view.getId() == b.e.coupon) {
            K();
        }
    }

    public void onResult(int i2, String str) {
        com.baidu.poly.util.c.info("ChannelListView->onResult() statusCode = " + i2 + " result = " + str);
        this.aPq = true;
        a.b bVar = this.aMP;
        if (bVar != null) {
            bVar.onResult(i2, str);
            this.aMP = null;
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

    private String eA(String str) {
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
            if (this.aPo == null) {
                View inflate = View.inflate(this.aOX.getContext(), b.f.default_pop_window, null);
                ((TextView) inflate.findViewById(b.e.pop_title)).setText("收银员正在找零，请您稍等哦～");
                ((TextView) inflate.findViewById(b.e.pop_tips)).setText(str.trim());
                this.aPo = new com.baidu.poly.widget.c(inflate, -1, -1, true);
                this.aPo.setClippingEnabled(false);
                this.aPo.setOutsideTouchable(false);
                this.aPo.setBackgroundDrawable(new ColorDrawable(0));
                ((TextView) inflate.findViewById(b.e.pop_button)).setOnClickListener(new f());
                this.aPo.a(new g());
            }
            PolyActivity polyActivity = (PolyActivity) getContext();
            if (!polyActivity.isFinishing()) {
                this.aPo.showAtLocation(polyActivity.getWindow().getDecorView(), 0, 0, 0);
            }
        }
    }

    public l BR() {
        if (!this.D) {
            this.D = true;
            if (!(getContext() instanceof Activity)) {
                throw new IllegalStateException("can not attach to context " + getContext());
            }
            this.aOW.b("收银台加载中...");
            com.baidu.poly.util.c.info("ChannelListView->attach()");
            O();
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class i implements l.h {
        i() {
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void b() {
            l.this.N();
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void c() {
            if (l.this.aPk != null) {
                l.this.aPk.b(l.this.aOV);
            }
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void onDetach() {
            l.this.aPk = null;
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void a(a.C0157a c0157a, com.baidu.poly.a.j.a aVar) {
            if (c0157a != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(c0157a.aOu);
                if (l.this.aOZ != null && l.this.aOZ.w() == 1) {
                    arrayList.add(l.this.aOZ.v());
                }
                l.this.a(arrayList, aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(n[] nVarArr) {
        this.aa.setMinimumHeight(0);
        if (nVarArr != null) {
            this.aOX.removeAllViews();
            for (n nVar : nVarArr) {
                com.baidu.poly.widget.a aVar = new com.baidu.poly.widget.a(getContext());
                aVar.a(nVar, new h(nVarArr, nVar));
                this.aOX.addView(aVar);
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
                this.aPm = Long.valueOf(Long.parseLong(bundle.getString("totalAmount")));
            } catch (NumberFormatException e2) {
            }
        }
        this.aMS = bundle;
        N();
        return this;
    }

    public l a(a.b bVar) {
        this.aMP = bVar;
        return this;
    }

    public l a(k kVar) {
        this.aPb = kVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(n nVar) {
        if (nVar != null) {
            JSONArray jSONArray = new JSONArray();
            try {
                if (this.aOZ != null && this.aOZ.w() == 1 && !TextUtils.isEmpty(this.aOZ.v())) {
                    jSONArray.put(new JSONObject(this.aOZ.v()));
                }
                if (this.aPi.getSelectedItem() != null && !TextUtils.isEmpty(this.aPi.getSelectedItem().aOu)) {
                    jSONArray.put(new JSONObject(this.aPi.getSelectedItem().aOu));
                }
            } catch (Exception e2) {
            }
            if (jSONArray.length() > 0) {
                this.aMS.putString("hostMarketingDetail", jSONArray.toString());
            }
            com.baidu.poly.a.i.c cVar = this.aPn;
            if (cVar != null) {
                this.aPp = nVar;
                cVar.b(this.aMS, nVar.y(), this);
            }
        }
    }

    public l a(com.baidu.poly.a.i.c cVar) {
        this.aPn = cVar;
        return this;
    }

    public void a(String str) {
        com.baidu.poly.util.c.info("ChannelListView->errorEnd()");
        if (com.baidu.poly.util.c.aMK) {
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
        com.baidu.poly.a.j.b.a(this.aMS.getString("bduss"), this.aMS.getString("appKey"), this.aPm + "", list, new j(aVar));
    }

    private String a(long j2) {
        return new DecimalFormat("0.00").format((j2 * 1.0d) / 100.0d);
    }
}

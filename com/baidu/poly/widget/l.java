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
public class l extends FrameLayout implements View.OnClickListener {
    private boolean D;
    private boolean F;
    private int G;
    private View aa;
    private Bundle boA;
    private a.b box;
    private com.baidu.poly.widget.coupon.a bpQ;
    private PolyFrameLayout bqA;
    private TipView bqB;
    private ViewGroup bqC;
    private ProgressButton bqD;
    private n bqE;
    private n[] bqF;
    private k bqG;
    private Animation bqH;
    private Animation bqI;
    private HostMarketView bqJ;
    private TextView bqK;
    private TextView bqL;
    private View bqM;
    private CouponEntranceView bqN;
    private View bqO;
    private com.baidu.poly.widget.coupon.l bqP;
    private Long bqQ;
    private Long bqR;
    private com.baidu.poly.a.i.c bqS;
    private com.baidu.poly.widget.c bqT;
    private n bqU;
    private boolean bqV;
    private com.baidu.poly.a.k.c bqn;
    private Runnable bqp;
    private boolean ka;
    private View s;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class a extends com.baidu.poly.a.a.a<JSONObject> {
        a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.poly.a.a.a
        public void a(JSONObject jSONObject) {
            l.this.bqQ = Long.valueOf(jSONObject.optLong("payMoney"));
            JSONArray optJSONArray = jSONObject.optJSONArray("payChannels");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                n[] nVarArr = new n[optJSONArray.length()];
                for (int i = 0; i < optJSONArray.length(); i++) {
                    nVarArr[i] = new n(optJSONArray.optJSONObject(i));
                }
                l.this.bqF = nVarArr;
                l.this.bpQ = new com.baidu.poly.widget.coupon.a(jSONObject.optJSONArray("coupons"));
                l.this.bqN.a(l.this.bpQ);
                if (l.this.bqP != null) {
                    l.this.bqP.a(l.this.bpQ.bpT);
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("marketChannels");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    l.this.bqE = new n(optJSONArray2.optJSONObject(0));
                }
                if (l.this.bqF.length != 1 || l.this.bqN.getVisibility() != 8 || l.this.bqE != null) {
                    l.this.L();
                    if (l.this.bqE != null || l.this.bqN.getVisibility() != 8) {
                        l.this.bqM.setVisibility(0);
                    } else {
                        l.this.bqM.setVisibility(8);
                    }
                    l.this.H();
                    l lVar = l.this;
                    lVar.b(lVar.a(lVar.bqF));
                    l.this.bqB.f();
                    l.this.M();
                    return;
                }
                l.this.bqB.a(l.this.bqF[0].x(), "即将进入" + l.this.bqF[0].t() + "…");
                l lVar2 = l.this;
                lVar2.b(lVar2.bqF[0]);
                return;
            }
            a(new com.baidu.poly.a.h.b("channelList is null"), "request channelList payChannels is null");
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            if (l.this.bqF == null) {
                l.this.m("网络不给力，请稍后重试");
                l.this.onResult(3, "request channel list fail");
                l.this.detach();
                com.baidu.poly.a.g.c.a(new com.baidu.poly.a.g.a("1").fK(new com.baidu.poly.a.h.a("gatewaylist error --> " + str, th).B()));
            }
        }
    }

    /* loaded from: classes11.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l.this.P();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class c implements HostMarketView.a {
        c() {
        }

        @Override // com.baidu.poly.widget.hostmarket.HostMarketView.a
        public void a(boolean z, n nVar, com.baidu.poly.a.j.a aVar) {
            l.this.bqA.a(true);
            l lVar = l.this;
            lVar.postDelayed(lVar.bqp, 500L);
            if (nVar != null) {
                ArrayList arrayList = new ArrayList();
                if (z) {
                    arrayList.add(nVar.v());
                }
                if (l.this.bqN.getSelectedItem() != null) {
                    arrayList.add(l.this.bqN.getSelectedItem().bpZ);
                }
                l.this.a(arrayList, aVar);
            }
        }

        @Override // com.baidu.poly.widget.hostmarket.HostMarketView.a
        public void b(a.C0185a c0185a) {
            l.this.bqA.a(false);
            l lVar = l.this;
            lVar.removeCallbacks(lVar.bqp);
            l.this.I();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (l.this.getParent() instanceof ViewGroup) {
                l lVar = l.this;
                lVar.startAnimation(lVar.bqI);
                ((ViewGroup) l.this.getParent()).removeView(l.this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l.this.G();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.this.bqT == null || !l.this.bqT.isShowing()) {
                return;
            }
            l.this.bqT.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class g implements c.b {
        g() {
        }

        @Override // com.baidu.poly.widget.c.b
        public void onDismiss() {
            l.this.G();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class h implements a.InterfaceC0190a {
        final /* synthetic */ n[] bqy;
        final /* synthetic */ n bqz;

        h(n[] nVarArr, n nVar) {
            this.bqy = nVarArr;
            this.bqz = nVar;
        }

        @Override // com.baidu.poly.widget.a.InterfaceC0190a
        public void a() {
            n[] nVarArr = this.bqy;
            int length = nVarArr.length;
            for (int i = 0; i < length; i++) {
                n nVar = nVarArr[i];
                nVar.h(nVar == this.bqz ? 1 : 0);
            }
            l.this.b(this.bqy);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class j implements com.baidu.poly.a.j.a {
        final /* synthetic */ com.baidu.poly.a.j.a boe;

        j(com.baidu.poly.a.j.a aVar) {
            this.boe = aVar;
        }

        @Override // com.baidu.poly.a.j.a
        public void a(a.C0185a c0185a) {
            if (c0185a.statusCode == 0) {
                l.this.bqQ = Long.valueOf(c0185a.boc);
                l.this.L();
                if (l.this.bqE != null && l.this.bqE.w() == 1) {
                    l.this.bqE.j(c0185a.bod);
                }
            }
            this.boe.a(c0185a);
            l.this.bqN.e();
        }
    }

    /* loaded from: classes11.dex */
    public interface k {
        void onClose();
    }

    public l(PolyActivity polyActivity) {
        super(polyActivity);
        this.bqU = null;
        this.bqV = true;
        this.ka = false;
        this.bqp = new b();
        J();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        com.baidu.poly.widget.c cVar = this.bqT;
        boolean z = ((cVar != null && cVar.isShowing()) || this.F || this.D) ? false : true;
        n nVar = this.bqU;
        if ((nVar != null && TextUtils.equals(nVar.y(), "BAIDU-ALIPAY-WISE")) || this.ka) {
            com.baidu.poly.util.c.info("ChannelListView->confirmViewClose() ali pay channel");
            z &= this.bqV;
        }
        com.baidu.poly.util.c.info("ChannelListView->confirmViewClose() canFinishActivity = " + z);
        if (!z || this.bqG == null) {
            return;
        }
        com.baidu.poly.util.c.info("ChannelListView->confirmViewClose() finish activity");
        this.bqG.onClose();
        this.bqG = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        this.bqJ.a(this.bqE);
        this.bqJ.setListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        com.baidu.poly.a.k.a.a(this.bqn);
        this.bqn = null;
    }

    private void J() {
        this.bqH = AnimationUtils.loadAnimation(getContext(), b.a.slide_in_bottom);
        this.bqI = AnimationUtils.loadAnimation(getContext(), b.a.slide_out_bottom);
        LayoutInflater.from(getContext()).inflate(b.f.view_channel_list, this);
        this.s = findViewById(b.e.bg_view);
        this.bqA = (PolyFrameLayout) findViewById(b.e.popup_view);
        this.bqO = findViewById(b.e.pay_money_layout);
        this.aa = findViewById(b.e.channel_list_scroll_view);
        this.bqB = (TipView) findViewById(b.e.tip_view);
        this.bqC = (ViewGroup) findViewById(b.e.channel_list_view);
        this.bqD = (ProgressButton) findViewById(b.e.pay_button);
        this.bqM = findViewById(b.e.line);
        findViewById(b.e.close_button).setOnClickListener(this);
        this.bqD.setOnClickListener(this);
        this.bqJ = (HostMarketView) findViewById(b.e.hostmarket);
        this.bqN = (CouponEntranceView) findViewById(b.e.coupon);
        this.bqN.setOnClickListener(this);
        this.bqK = (TextView) findViewById(b.e.money);
        this.bqL = (TextView) findViewById(b.e.cut);
    }

    private void K() {
        List<a.C0192a> list;
        com.baidu.poly.widget.coupon.a aVar = this.bpQ;
        if (aVar != null && (list = aVar.bpT) != null && list.size() > 0) {
            this.bqP = new com.baidu.poly.widget.coupon.l(getContext());
            this.bqP.a(this.bqA.getMeasuredHeight());
            this.bqP.setListener(new i());
            this.bqP.a(this.bpQ.bpT);
            this.bqP.a(this.bqA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        Long l;
        Long l2 = this.bqR;
        if (l2 != null && (l = this.bqQ) != null) {
            if (l2.equals(l)) {
                this.bqK.setText(a(this.bqQ.longValue()));
                this.bqL.setVisibility(8);
            } else {
                this.bqL.setVisibility(0);
                this.bqK.setText(a(this.bqQ.longValue()));
                this.bqL.setText(" ¥" + a(this.bqR.longValue()));
            }
            if (this.bqO.getVisibility() != 0) {
                this.bqO.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        if (this.G <= 0) {
            this.bqD.setVisibility(4);
            return;
        }
        this.bqD.setVisibility(0);
        this.bqD.setEnable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        com.baidu.poly.a.b.a.KR().a(this.boA, new a());
    }

    private void O() {
        this.s.setVisibility(0);
        this.bqA.setVisibility(0);
        this.s.setAlpha(0.0f);
        this.s.animate().alpha(0.65f).setDuration(240L).start();
        this.bqA.startAnimation(this.bqH);
        M();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.bqn = com.baidu.poly.a.k.a.a(this.bqA, layoutParams, "加载中", -1L);
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
        com.baidu.poly.widget.coupon.l lVar = this.bqP;
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
                this.bqD.startLoading();
                this.F = true;
                this.bqV = false;
                n[] nVarArr = this.bqF;
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
                com.baidu.poly.a.g.c.a(new com.baidu.poly.a.g.a("5").fK(nVar != null ? fN(nVar.y()) : null));
            }
        } else if (view.getId() == b.e.coupon) {
            K();
        }
    }

    public void onResult(int i2, String str) {
        com.baidu.poly.util.c.info("ChannelListView->onResult() statusCode = " + i2 + " result = " + str);
        this.bqV = true;
        a.b bVar = this.box;
        if (bVar != null) {
            bVar.onResult(i2, str);
            this.box = null;
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

    private String fN(String str) {
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
            if (this.bqT == null) {
                View inflate = View.inflate(this.bqC.getContext(), b.f.default_pop_window, null);
                ((TextView) inflate.findViewById(b.e.pop_title)).setText("收银员正在找零，请您稍等哦～");
                ((TextView) inflate.findViewById(b.e.pop_tips)).setText(str.trim());
                this.bqT = new com.baidu.poly.widget.c(inflate, -1, -1, true);
                this.bqT.setClippingEnabled(false);
                this.bqT.setOutsideTouchable(false);
                this.bqT.setBackgroundDrawable(new ColorDrawable(0));
                ((TextView) inflate.findViewById(b.e.pop_button)).setOnClickListener(new f());
                this.bqT.a(new g());
            }
            PolyActivity polyActivity = (PolyActivity) getContext();
            if (!polyActivity.isFinishing()) {
                this.bqT.showAtLocation(polyActivity.getWindow().getDecorView(), 0, 0, 0);
            }
        }
    }

    public l Lc() {
        if (!this.D) {
            this.D = true;
            if (!(getContext() instanceof Activity)) {
                throw new IllegalStateException("can not attach to context " + getContext());
            }
            this.bqB.b("收银台加载中...");
            com.baidu.poly.util.c.info("ChannelListView->attach()");
            O();
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class i implements l.h {
        i() {
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void b() {
            l.this.N();
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void c() {
            if (l.this.bqP != null) {
                l.this.bqP.b(l.this.bqA);
            }
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void onDetach() {
            l.this.bqP = null;
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void a(a.C0192a c0192a, com.baidu.poly.a.j.a aVar) {
            if (c0192a != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(c0192a.bpZ);
                if (l.this.bqE != null && l.this.bqE.w() == 1) {
                    arrayList.add(l.this.bqE.v());
                }
                l.this.a(arrayList, aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(n[] nVarArr) {
        this.aa.setMinimumHeight(0);
        if (nVarArr != null) {
            this.bqC.removeAllViews();
            for (n nVar : nVarArr) {
                com.baidu.poly.widget.a aVar = new com.baidu.poly.widget.a(getContext());
                aVar.a(nVar, new h(nVarArr, nVar));
                this.bqC.addView(aVar);
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
                this.bqR = Long.valueOf(Long.parseLong(bundle.getString("totalAmount")));
            } catch (NumberFormatException e2) {
            }
        }
        this.boA = bundle;
        N();
        return this;
    }

    public l a(a.b bVar) {
        this.box = bVar;
        return this;
    }

    public l a(k kVar) {
        this.bqG = kVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(n nVar) {
        if (nVar != null) {
            JSONArray jSONArray = new JSONArray();
            try {
                if (this.bqE != null && this.bqE.w() == 1 && !TextUtils.isEmpty(this.bqE.v())) {
                    jSONArray.put(new JSONObject(this.bqE.v()));
                }
                if (this.bqN.getSelectedItem() != null && !TextUtils.isEmpty(this.bqN.getSelectedItem().bpZ)) {
                    jSONArray.put(new JSONObject(this.bqN.getSelectedItem().bpZ));
                }
            } catch (Exception e2) {
            }
            if (jSONArray.length() > 0) {
                this.boA.putString("hostMarketingDetail", jSONArray.toString());
            }
            com.baidu.poly.a.i.c cVar = this.bqS;
            if (cVar != null) {
                this.bqU = nVar;
                cVar.b(this.boA, nVar.y(), this);
            }
        }
    }

    public l a(com.baidu.poly.a.i.c cVar) {
        this.bqS = cVar;
        return this;
    }

    public void a(String str) {
        com.baidu.poly.util.c.info("ChannelListView->errorEnd()");
        if (com.baidu.poly.util.c.bos) {
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
        com.baidu.poly.a.j.b.a(this.boA.getString("bduss"), this.boA.getString("appKey"), this.bqR + "", list, new j(aVar));
    }

    private String a(long j2) {
        return new DecimalFormat("0.00").format((j2 * 1.0d) / 100.0d);
    }
}

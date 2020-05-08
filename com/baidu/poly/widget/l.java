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
    private View S;
    private View aa;
    private a.b boC;
    private Bundle boF;
    private com.baidu.poly.widget.coupon.a bpV;
    private PolyFrameLayout bqF;
    private TipView bqG;
    private ViewGroup bqH;
    private ProgressButton bqI;
    private n bqJ;
    private n[] bqK;
    private k bqL;
    private Animation bqM;
    private Animation bqN;
    private HostMarketView bqO;
    private TextView bqP;
    private TextView bqQ;
    private CouponEntranceView bqR;
    private View bqS;
    private com.baidu.poly.widget.coupon.l bqT;
    private Long bqU;
    private Long bqV;
    private com.baidu.poly.a.i.c bqW;
    private com.baidu.poly.widget.c bqX;
    private n bqY;
    private boolean bqZ;
    private com.baidu.poly.a.k.c bqs;
    private Runnable bqu;
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
            l.this.bqU = Long.valueOf(jSONObject.optLong("payMoney"));
            JSONArray optJSONArray = jSONObject.optJSONArray("payChannels");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                n[] nVarArr = new n[optJSONArray.length()];
                for (int i = 0; i < optJSONArray.length(); i++) {
                    nVarArr[i] = new n(optJSONArray.optJSONObject(i));
                }
                l.this.bqK = nVarArr;
                l.this.bpV = new com.baidu.poly.widget.coupon.a(jSONObject.optJSONArray("coupons"));
                l.this.bqR.a(l.this.bpV);
                if (l.this.bqT != null) {
                    l.this.bqT.a(l.this.bpV.bpY);
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("marketChannels");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    l.this.bqJ = new n(optJSONArray2.optJSONObject(0));
                }
                if (l.this.bqK.length != 1 || l.this.bqR.getVisibility() != 8 || l.this.bqJ != null) {
                    l.this.L();
                    if (l.this.bqJ != null || l.this.bqR.getVisibility() != 8) {
                        l.this.S.setVisibility(0);
                    } else {
                        l.this.S.setVisibility(8);
                    }
                    l.this.H();
                    l lVar = l.this;
                    lVar.b(lVar.a(lVar.bqK));
                    l.this.bqG.f();
                    l.this.M();
                    return;
                }
                l.this.bqG.a(l.this.bqK[0].x(), "即将进入" + l.this.bqK[0].t() + "…");
                l lVar2 = l.this;
                lVar2.b(lVar2.bqK[0]);
                return;
            }
            a(new com.baidu.poly.a.h.b("channelList is null"), "request channelList payChannels is null");
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            if (l.this.bqK == null) {
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
            l.this.bqF.a(true);
            l lVar = l.this;
            lVar.postDelayed(lVar.bqu, 500L);
            if (nVar != null) {
                ArrayList arrayList = new ArrayList();
                if (z) {
                    arrayList.add(nVar.v());
                }
                if (l.this.bqR.getSelectedItem() != null) {
                    arrayList.add(l.this.bqR.getSelectedItem().bqe);
                }
                l.this.a(arrayList, aVar);
            }
        }

        @Override // com.baidu.poly.widget.hostmarket.HostMarketView.a
        public void b(a.C0207a c0207a) {
            l.this.bqF.a(false);
            l lVar = l.this;
            lVar.removeCallbacks(lVar.bqu);
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
                lVar.startAnimation(lVar.bqN);
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
            if (l.this.bqX == null || !l.this.bqX.isShowing()) {
                return;
            }
            l.this.bqX.dismiss();
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
    public class h implements a.InterfaceC0212a {
        final /* synthetic */ n[] bqD;
        final /* synthetic */ n bqE;

        h(n[] nVarArr, n nVar) {
            this.bqD = nVarArr;
            this.bqE = nVar;
        }

        @Override // com.baidu.poly.widget.a.InterfaceC0212a
        public void a() {
            n[] nVarArr = this.bqD;
            int length = nVarArr.length;
            for (int i = 0; i < length; i++) {
                n nVar = nVarArr[i];
                nVar.h(nVar == this.bqE ? 1 : 0);
            }
            l.this.b(this.bqD);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class j implements com.baidu.poly.a.j.a {
        final /* synthetic */ com.baidu.poly.a.j.a boj;

        j(com.baidu.poly.a.j.a aVar) {
            this.boj = aVar;
        }

        @Override // com.baidu.poly.a.j.a
        public void a(a.C0207a c0207a) {
            if (c0207a.statusCode == 0) {
                l.this.bqU = Long.valueOf(c0207a.boh);
                l.this.L();
                if (l.this.bqJ != null && l.this.bqJ.w() == 1) {
                    l.this.bqJ.j(c0207a.boi);
                }
            }
            this.boj.a(c0207a);
            l.this.bqR.e();
        }
    }

    /* loaded from: classes11.dex */
    public interface k {
        void onClose();
    }

    public l(PolyActivity polyActivity) {
        super(polyActivity);
        this.bqY = null;
        this.bqZ = true;
        this.ka = false;
        this.bqu = new b();
        J();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        com.baidu.poly.widget.c cVar = this.bqX;
        boolean z = ((cVar != null && cVar.isShowing()) || this.F || this.D) ? false : true;
        n nVar = this.bqY;
        if ((nVar != null && TextUtils.equals(nVar.y(), "BAIDU-ALIPAY-WISE")) || this.ka) {
            com.baidu.poly.util.c.info("ChannelListView->confirmViewClose() ali pay channel");
            z &= this.bqZ;
        }
        com.baidu.poly.util.c.info("ChannelListView->confirmViewClose() canFinishActivity = " + z);
        if (!z || this.bqL == null) {
            return;
        }
        com.baidu.poly.util.c.info("ChannelListView->confirmViewClose() finish activity");
        this.bqL.onClose();
        this.bqL = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        this.bqO.a(this.bqJ);
        this.bqO.setListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        com.baidu.poly.a.k.a.a(this.bqs);
        this.bqs = null;
    }

    private void J() {
        this.bqM = AnimationUtils.loadAnimation(getContext(), b.a.slide_in_bottom);
        this.bqN = AnimationUtils.loadAnimation(getContext(), b.a.slide_out_bottom);
        LayoutInflater.from(getContext()).inflate(b.f.view_channel_list, this);
        this.s = findViewById(b.e.bg_view);
        this.bqF = (PolyFrameLayout) findViewById(b.e.popup_view);
        this.bqS = findViewById(b.e.pay_money_layout);
        this.aa = findViewById(b.e.channel_list_scroll_view);
        this.bqG = (TipView) findViewById(b.e.tip_view);
        this.bqH = (ViewGroup) findViewById(b.e.channel_list_view);
        this.bqI = (ProgressButton) findViewById(b.e.pay_button);
        this.S = findViewById(b.e.line);
        findViewById(b.e.close_button).setOnClickListener(this);
        this.bqI.setOnClickListener(this);
        this.bqO = (HostMarketView) findViewById(b.e.hostmarket);
        this.bqR = (CouponEntranceView) findViewById(b.e.coupon);
        this.bqR.setOnClickListener(this);
        this.bqP = (TextView) findViewById(b.e.money);
        this.bqQ = (TextView) findViewById(b.e.cut);
    }

    private void K() {
        List<a.C0214a> list;
        com.baidu.poly.widget.coupon.a aVar = this.bpV;
        if (aVar != null && (list = aVar.bpY) != null && list.size() > 0) {
            this.bqT = new com.baidu.poly.widget.coupon.l(getContext());
            this.bqT.a(this.bqF.getMeasuredHeight());
            this.bqT.setListener(new i());
            this.bqT.a(this.bpV.bpY);
            this.bqT.a(this.bqF);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        Long l;
        Long l2 = this.bqV;
        if (l2 != null && (l = this.bqU) != null) {
            if (l2.equals(l)) {
                this.bqP.setText(a(this.bqU.longValue()));
                this.bqQ.setVisibility(8);
            } else {
                this.bqQ.setVisibility(0);
                this.bqP.setText(a(this.bqU.longValue()));
                this.bqQ.setText(" ¥" + a(this.bqV.longValue()));
            }
            if (this.bqS.getVisibility() != 0) {
                this.bqS.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        if (this.G <= 0) {
            this.bqI.setVisibility(4);
            return;
        }
        this.bqI.setVisibility(0);
        this.bqI.setEnable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        com.baidu.poly.a.b.a.KQ().a(this.boF, new a());
    }

    private void O() {
        this.s.setVisibility(0);
        this.bqF.setVisibility(0);
        this.s.setAlpha(0.0f);
        this.s.animate().alpha(0.65f).setDuration(240L).start();
        this.bqF.startAnimation(this.bqM);
        M();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.bqs = com.baidu.poly.a.k.a.a(this.bqF, layoutParams, "加载中", -1L);
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
        com.baidu.poly.widget.coupon.l lVar = this.bqT;
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
                this.bqI.startLoading();
                this.F = true;
                this.bqZ = false;
                n[] nVarArr = this.bqK;
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
        this.bqZ = true;
        a.b bVar = this.boC;
        if (bVar != null) {
            bVar.onResult(i2, str);
            this.boC = null;
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
            if (this.bqX == null) {
                View inflate = View.inflate(this.bqH.getContext(), b.f.default_pop_window, null);
                ((TextView) inflate.findViewById(b.e.pop_title)).setText("收银员正在找零，请您稍等哦～");
                ((TextView) inflate.findViewById(b.e.pop_tips)).setText(str.trim());
                this.bqX = new com.baidu.poly.widget.c(inflate, -1, -1, true);
                this.bqX.setClippingEnabled(false);
                this.bqX.setOutsideTouchable(false);
                this.bqX.setBackgroundDrawable(new ColorDrawable(0));
                ((TextView) inflate.findViewById(b.e.pop_button)).setOnClickListener(new f());
                this.bqX.a(new g());
            }
            PolyActivity polyActivity = (PolyActivity) getContext();
            if (!polyActivity.isFinishing()) {
                this.bqX.showAtLocation(polyActivity.getWindow().getDecorView(), 0, 0, 0);
            }
        }
    }

    public l Lb() {
        if (!this.D) {
            this.D = true;
            if (!(getContext() instanceof Activity)) {
                throw new IllegalStateException("can not attach to context " + getContext());
            }
            this.bqG.b("收银台加载中...");
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
            if (l.this.bqT != null) {
                l.this.bqT.b(l.this.bqF);
            }
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void onDetach() {
            l.this.bqT = null;
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void a(a.C0214a c0214a, com.baidu.poly.a.j.a aVar) {
            if (c0214a != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(c0214a.bqe);
                if (l.this.bqJ != null && l.this.bqJ.w() == 1) {
                    arrayList.add(l.this.bqJ.v());
                }
                l.this.a(arrayList, aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(n[] nVarArr) {
        this.aa.setMinimumHeight(0);
        if (nVarArr != null) {
            this.bqH.removeAllViews();
            for (n nVar : nVarArr) {
                com.baidu.poly.widget.a aVar = new com.baidu.poly.widget.a(getContext());
                aVar.a(nVar, new h(nVarArr, nVar));
                this.bqH.addView(aVar);
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
                this.bqV = Long.valueOf(Long.parseLong(bundle.getString("totalAmount")));
            } catch (NumberFormatException e2) {
            }
        }
        this.boF = bundle;
        N();
        return this;
    }

    public l a(a.b bVar) {
        this.boC = bVar;
        return this;
    }

    public l a(k kVar) {
        this.bqL = kVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(n nVar) {
        if (nVar != null) {
            JSONArray jSONArray = new JSONArray();
            try {
                if (this.bqJ != null && this.bqJ.w() == 1 && !TextUtils.isEmpty(this.bqJ.v())) {
                    jSONArray.put(new JSONObject(this.bqJ.v()));
                }
                if (this.bqR.getSelectedItem() != null && !TextUtils.isEmpty(this.bqR.getSelectedItem().bqe)) {
                    jSONArray.put(new JSONObject(this.bqR.getSelectedItem().bqe));
                }
            } catch (Exception e2) {
            }
            if (jSONArray.length() > 0) {
                this.boF.putString("hostMarketingDetail", jSONArray.toString());
            }
            com.baidu.poly.a.i.c cVar = this.bqW;
            if (cVar != null) {
                this.bqY = nVar;
                cVar.b(this.boF, nVar.y(), this);
            }
        }
    }

    public l a(com.baidu.poly.a.i.c cVar) {
        this.bqW = cVar;
        return this;
    }

    public void a(String str) {
        com.baidu.poly.util.c.info("ChannelListView->errorEnd()");
        if (com.baidu.poly.util.c.box) {
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
        com.baidu.poly.a.j.b.a(this.boF.getString("bduss"), this.boF.getString("appKey"), this.bqV + "", list, new j(aVar));
    }

    private String a(long j2) {
        return new DecimalFormat("0.00").format((j2 * 1.0d) / 100.0d);
    }
}

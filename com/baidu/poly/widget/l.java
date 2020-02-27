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
    private a.b aSg;
    private Bundle aSj;
    private com.baidu.poly.widget.coupon.a aTC;
    private com.baidu.poly.a.k.c aTZ;
    private View aUA;
    private com.baidu.poly.widget.coupon.l aUB;
    private Long aUC;
    private Long aUD;
    private com.baidu.poly.a.i.c aUE;
    private com.baidu.poly.widget.c aUF;
    private n aUG;
    private boolean aUH;
    private Runnable aUb;
    private PolyFrameLayout aUm;
    private TipView aUn;
    private ViewGroup aUo;
    private ProgressButton aUp;
    private n aUq;
    private n[] aUr;
    private k aUs;
    private Animation aUt;
    private Animation aUu;
    private HostMarketView aUv;
    private TextView aUw;
    private TextView aUx;
    private View aUy;
    private CouponEntranceView aUz;
    private View aa;
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
            l.this.aUC = Long.valueOf(jSONObject.optLong("payMoney"));
            JSONArray optJSONArray = jSONObject.optJSONArray("payChannels");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                n[] nVarArr = new n[optJSONArray.length()];
                for (int i = 0; i < optJSONArray.length(); i++) {
                    nVarArr[i] = new n(optJSONArray.optJSONObject(i));
                }
                l.this.aUr = nVarArr;
                l.this.aTC = new com.baidu.poly.widget.coupon.a(jSONObject.optJSONArray("coupons"));
                l.this.aUz.a(l.this.aTC);
                if (l.this.aUB != null) {
                    l.this.aUB.a(l.this.aTC.aTF);
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("marketChannels");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    l.this.aUq = new n(optJSONArray2.optJSONObject(0));
                }
                if (l.this.aUr.length != 1 || l.this.aUz.getVisibility() != 8 || l.this.aUq != null) {
                    l.this.L();
                    if (l.this.aUq != null || l.this.aUz.getVisibility() != 8) {
                        l.this.aUy.setVisibility(0);
                    } else {
                        l.this.aUy.setVisibility(8);
                    }
                    l.this.H();
                    l lVar = l.this;
                    lVar.b(lVar.a(lVar.aUr));
                    l.this.aUn.f();
                    l.this.M();
                    return;
                }
                l.this.aUn.a(l.this.aUr[0].x(), "即将进入" + l.this.aUr[0].t() + "…");
                l lVar2 = l.this;
                lVar2.b(lVar2.aUr[0]);
                return;
            }
            a(new com.baidu.poly.a.h.b("channelList is null"), "request channelList payChannels is null");
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            if (l.this.aUr == null) {
                l.this.m("网络不给力，请稍后重试");
                l.this.onResult(3, "request channel list fail");
                l.this.detach();
                com.baidu.poly.a.g.c.a(new com.baidu.poly.a.g.a("1").eQ(new com.baidu.poly.a.h.a("gatewaylist error --> " + str, th).B()));
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
            l.this.aUm.a(true);
            l lVar = l.this;
            lVar.postDelayed(lVar.aUb, 500L);
            if (nVar != null) {
                ArrayList arrayList = new ArrayList();
                if (z) {
                    arrayList.add(nVar.v());
                }
                if (l.this.aUz.getSelectedItem() != null) {
                    arrayList.add(l.this.aUz.getSelectedItem().aTL);
                }
                l.this.a(arrayList, aVar);
            }
        }

        @Override // com.baidu.poly.widget.hostmarket.HostMarketView.a
        public void b(a.C0161a c0161a) {
            l.this.aUm.a(false);
            l lVar = l.this;
            lVar.removeCallbacks(lVar.aUb);
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
                lVar.startAnimation(lVar.aUu);
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
            if (l.this.aUF == null || !l.this.aUF.isShowing()) {
                return;
            }
            l.this.aUF.dismiss();
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
    public class h implements a.InterfaceC0166a {
        final /* synthetic */ n[] aUk;
        final /* synthetic */ n aUl;

        h(n[] nVarArr, n nVar) {
            this.aUk = nVarArr;
            this.aUl = nVar;
        }

        @Override // com.baidu.poly.widget.a.InterfaceC0166a
        public void a() {
            n[] nVarArr = this.aUk;
            int length = nVarArr.length;
            for (int i = 0; i < length; i++) {
                n nVar = nVarArr[i];
                nVar.h(nVar == this.aUl ? 1 : 0);
            }
            l.this.b(this.aUk);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class j implements com.baidu.poly.a.j.a {
        final /* synthetic */ com.baidu.poly.a.j.a aRM;

        j(com.baidu.poly.a.j.a aVar) {
            this.aRM = aVar;
        }

        @Override // com.baidu.poly.a.j.a
        public void a(a.C0161a c0161a) {
            if (c0161a.statusCode == 0) {
                l.this.aUC = Long.valueOf(c0161a.aRK);
                l.this.L();
                if (l.this.aUq != null && l.this.aUq.w() == 1) {
                    l.this.aUq.j(c0161a.aRL);
                }
            }
            this.aRM.a(c0161a);
            l.this.aUz.e();
        }
    }

    /* loaded from: classes11.dex */
    public interface k {
        void onClose();
    }

    public l(PolyActivity polyActivity) {
        super(polyActivity);
        this.aUG = null;
        this.aUH = true;
        this.ka = false;
        this.aUb = new b();
        J();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        com.baidu.poly.widget.c cVar = this.aUF;
        boolean z = ((cVar != null && cVar.isShowing()) || this.F || this.D) ? false : true;
        n nVar = this.aUG;
        if ((nVar != null && TextUtils.equals(nVar.y(), "BAIDU-ALIPAY-WISE")) || this.ka) {
            com.baidu.poly.util.c.info("ChannelListView->confirmViewClose() ali pay channel");
            z &= this.aUH;
        }
        com.baidu.poly.util.c.info("ChannelListView->confirmViewClose() canFinishActivity = " + z);
        if (!z || this.aUs == null) {
            return;
        }
        com.baidu.poly.util.c.info("ChannelListView->confirmViewClose() finish activity");
        this.aUs.onClose();
        this.aUs = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        this.aUv.a(this.aUq);
        this.aUv.setListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        com.baidu.poly.a.k.a.a(this.aTZ);
        this.aTZ = null;
    }

    private void J() {
        this.aUt = AnimationUtils.loadAnimation(getContext(), b.a.slide_in_bottom);
        this.aUu = AnimationUtils.loadAnimation(getContext(), b.a.slide_out_bottom);
        LayoutInflater.from(getContext()).inflate(b.f.view_channel_list, this);
        this.s = findViewById(b.e.bg_view);
        this.aUm = (PolyFrameLayout) findViewById(b.e.popup_view);
        this.aUA = findViewById(b.e.pay_money_layout);
        this.aa = findViewById(b.e.channel_list_scroll_view);
        this.aUn = (TipView) findViewById(b.e.tip_view);
        this.aUo = (ViewGroup) findViewById(b.e.channel_list_view);
        this.aUp = (ProgressButton) findViewById(b.e.pay_button);
        this.aUy = findViewById(b.e.line);
        findViewById(b.e.close_button).setOnClickListener(this);
        this.aUp.setOnClickListener(this);
        this.aUv = (HostMarketView) findViewById(b.e.hostmarket);
        this.aUz = (CouponEntranceView) findViewById(b.e.coupon);
        this.aUz.setOnClickListener(this);
        this.aUw = (TextView) findViewById(b.e.money);
        this.aUx = (TextView) findViewById(b.e.cut);
    }

    private void K() {
        List<a.C0168a> list;
        com.baidu.poly.widget.coupon.a aVar = this.aTC;
        if (aVar != null && (list = aVar.aTF) != null && list.size() > 0) {
            this.aUB = new com.baidu.poly.widget.coupon.l(getContext());
            this.aUB.a(this.aUm.getMeasuredHeight());
            this.aUB.setListener(new i());
            this.aUB.a(this.aTC.aTF);
            this.aUB.a(this.aUm);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        Long l;
        Long l2 = this.aUD;
        if (l2 != null && (l = this.aUC) != null) {
            if (l2.equals(l)) {
                this.aUw.setText(a(this.aUC.longValue()));
                this.aUx.setVisibility(8);
            } else {
                this.aUx.setVisibility(0);
                this.aUw.setText(a(this.aUC.longValue()));
                this.aUx.setText(" ¥" + a(this.aUD.longValue()));
            }
            if (this.aUA.getVisibility() != 0) {
                this.aUA.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        if (this.G <= 0) {
            this.aUp.setVisibility(4);
            return;
        }
        this.aUp.setVisibility(0);
        this.aUp.setEnable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        com.baidu.poly.a.b.a.Ey().a(this.aSj, new a());
    }

    private void O() {
        this.s.setVisibility(0);
        this.aUm.setVisibility(0);
        this.s.setAlpha(0.0f);
        this.s.animate().alpha(0.65f).setDuration(240L).start();
        this.aUm.startAnimation(this.aUt);
        M();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.aTZ = com.baidu.poly.a.k.a.a(this.aUm, layoutParams, "加载中", -1L);
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
        com.baidu.poly.widget.coupon.l lVar = this.aUB;
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
                this.aUp.startLoading();
                this.F = true;
                this.aUH = false;
                n[] nVarArr = this.aUr;
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
                com.baidu.poly.a.g.c.a(new com.baidu.poly.a.g.a("5").eQ(nVar != null ? eT(nVar.y()) : null));
            }
        } else if (view.getId() == b.e.coupon) {
            K();
        }
    }

    public void onResult(int i2, String str) {
        com.baidu.poly.util.c.info("ChannelListView->onResult() statusCode = " + i2 + " result = " + str);
        this.aUH = true;
        a.b bVar = this.aSg;
        if (bVar != null) {
            bVar.onResult(i2, str);
            this.aSg = null;
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

    private String eT(String str) {
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
            if (this.aUF == null) {
                View inflate = View.inflate(this.aUo.getContext(), b.f.default_pop_window, null);
                ((TextView) inflate.findViewById(b.e.pop_title)).setText("收银员正在找零，请您稍等哦～");
                ((TextView) inflate.findViewById(b.e.pop_tips)).setText(str.trim());
                this.aUF = new com.baidu.poly.widget.c(inflate, -1, -1, true);
                this.aUF.setClippingEnabled(false);
                this.aUF.setOutsideTouchable(false);
                this.aUF.setBackgroundDrawable(new ColorDrawable(0));
                ((TextView) inflate.findViewById(b.e.pop_button)).setOnClickListener(new f());
                this.aUF.a(new g());
            }
            PolyActivity polyActivity = (PolyActivity) getContext();
            if (!polyActivity.isFinishing()) {
                this.aUF.showAtLocation(polyActivity.getWindow().getDecorView(), 0, 0, 0);
            }
        }
    }

    public l EJ() {
        if (!this.D) {
            this.D = true;
            if (!(getContext() instanceof Activity)) {
                throw new IllegalStateException("can not attach to context " + getContext());
            }
            this.aUn.b("收银台加载中...");
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
            if (l.this.aUB != null) {
                l.this.aUB.b(l.this.aUm);
            }
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void onDetach() {
            l.this.aUB = null;
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void a(a.C0168a c0168a, com.baidu.poly.a.j.a aVar) {
            if (c0168a != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(c0168a.aTL);
                if (l.this.aUq != null && l.this.aUq.w() == 1) {
                    arrayList.add(l.this.aUq.v());
                }
                l.this.a(arrayList, aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(n[] nVarArr) {
        this.aa.setMinimumHeight(0);
        if (nVarArr != null) {
            this.aUo.removeAllViews();
            for (n nVar : nVarArr) {
                com.baidu.poly.widget.a aVar = new com.baidu.poly.widget.a(getContext());
                aVar.a(nVar, new h(nVarArr, nVar));
                this.aUo.addView(aVar);
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
                this.aUD = Long.valueOf(Long.parseLong(bundle.getString("totalAmount")));
            } catch (NumberFormatException e2) {
            }
        }
        this.aSj = bundle;
        N();
        return this;
    }

    public l a(a.b bVar) {
        this.aSg = bVar;
        return this;
    }

    public l a(k kVar) {
        this.aUs = kVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(n nVar) {
        if (nVar != null) {
            JSONArray jSONArray = new JSONArray();
            try {
                if (this.aUq != null && this.aUq.w() == 1 && !TextUtils.isEmpty(this.aUq.v())) {
                    jSONArray.put(new JSONObject(this.aUq.v()));
                }
                if (this.aUz.getSelectedItem() != null && !TextUtils.isEmpty(this.aUz.getSelectedItem().aTL)) {
                    jSONArray.put(new JSONObject(this.aUz.getSelectedItem().aTL));
                }
            } catch (Exception e2) {
            }
            if (jSONArray.length() > 0) {
                this.aSj.putString("hostMarketingDetail", jSONArray.toString());
            }
            com.baidu.poly.a.i.c cVar = this.aUE;
            if (cVar != null) {
                this.aUG = nVar;
                cVar.b(this.aSj, nVar.y(), this);
            }
        }
    }

    public l a(com.baidu.poly.a.i.c cVar) {
        this.aUE = cVar;
        return this;
    }

    public void a(String str) {
        com.baidu.poly.util.c.info("ChannelListView->errorEnd()");
        if (com.baidu.poly.util.c.aSb) {
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
        com.baidu.poly.a.j.b.a(this.aSj.getString("bduss"), this.aSj.getString("appKey"), this.aUD + "", list, new j(aVar));
    }

    private String a(long j2) {
        return new DecimalFormat("0.00").format((j2 * 1.0d) / 100.0d);
    }
}

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
    private a.b bwc;
    private Bundle bwf;
    private com.baidu.poly.a.k.c bxU;
    private Runnable bxW;
    private com.baidu.poly.widget.coupon.a bxy;
    private boolean byA;
    private boolean byB;
    private boolean byC;
    private PolyFrameLayout byh;
    private TipView byi;
    private ViewGroup byj;
    private ProgressButton byk;
    private o byl;
    private o[] bym;
    private l byn;
    private Animation byo;
    private Animation byp;
    private HostMarketView byq;
    private TextView byr;
    private CouponEntranceView bys;
    private View byt;
    private com.baidu.poly.widget.coupon.l byu;
    private Long byv;
    private Long byw;
    private com.baidu.poly.a.i.c byx;
    private com.baidu.poly.widget.c byy;
    private o byz;
    private boolean ka;
    private View r;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class a implements com.baidu.poly.a.j.a {
        final /* synthetic */ com.baidu.poly.a.j.a bvJ;

        a(com.baidu.poly.a.j.a aVar) {
            this.bvJ = aVar;
        }

        @Override // com.baidu.poly.a.j.a
        public void a(a.C0240a c0240a) {
            if (c0240a.statusCode == 0) {
                m.this.byv = Long.valueOf(c0240a.bvH);
                m.this.W();
                if (m.this.byl != null && m.this.byl.G() == 1) {
                    m.this.byl.k(c0240a.bvI);
                }
            }
            this.bvJ.a(c0240a);
            m.this.bys.g();
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
            m.this.byv = Long.valueOf(jSONObject.optLong("payMoney"));
            JSONArray optJSONArray = jSONObject.optJSONArray("payChannels");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                o[] oVarArr = new o[optJSONArray.length()];
                for (int i = 0; i < optJSONArray.length(); i++) {
                    oVarArr[i] = new o(optJSONArray.optJSONObject(i));
                }
                m.this.bym = oVarArr;
                m.this.bxy = new com.baidu.poly.widget.coupon.a(jSONObject.optJSONArray("coupons"));
                m.this.bys.a(m.this.bxy);
                if (m.this.byu != null) {
                    m.this.byu.a(m.this.bxy.bxB);
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("marketChannels");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    m.this.byl = new o(optJSONArray2.optJSONObject(0));
                }
                com.baidu.poly.a.g.a.i("7");
                if (m.this.bym.length != 1 || m.this.bys.getVisibility() != 8 || m.this.byl != null) {
                    m.this.W();
                    if (m.this.byl != null || m.this.bys.getVisibility() != 8) {
                        m.this.S.setVisibility(0);
                    } else {
                        m.this.S.setVisibility(8);
                    }
                    m.this.S();
                    m mVar = m.this;
                    mVar.b(mVar.a(mVar.bym));
                    m.this.byi.h();
                    m.this.X();
                    m.this.byC = true;
                    m.this.Nm();
                    return;
                }
                m.this.byC = true;
                m.this.Nm();
                m.this.byi.b(m.this.bym[0].H(), "即将进入" + m.this.bym[0].getDisplayName() + "…");
                m mVar2 = m.this;
                mVar2.b(mVar2.bym[0]);
                return;
            }
            com.baidu.poly.a.g.a.a("7", null, null);
            a(new com.baidu.poly.a.h.b("channelList is null"), "request channelList payChannels is null");
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            if (m.this.bym == null) {
                m mVar = m.this;
                mVar.n(mVar.getResources().getString(b.g.common_error_tips));
                m.this.onResult(3, "request channel list fail");
                m.this.detach();
                com.baidu.poly.a.g.d.a(new com.baidu.poly.a.g.b("1").gx(new com.baidu.poly.a.h.a("gatewaylist error --> " + str, th).L()));
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
            m.this.byB = true;
            m.this.Nm();
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
            m.this.byh.a(true);
            m mVar = m.this;
            mVar.postDelayed(mVar.bxW, 500L);
            if (oVar != null) {
                ArrayList arrayList = new ArrayList();
                if (z) {
                    arrayList.add(oVar.F());
                }
                if (m.this.bys.getSelectedItem() != null) {
                    arrayList.add(m.this.bys.getSelectedItem().bxH);
                }
                m.this.a(arrayList, aVar);
            }
        }

        @Override // com.baidu.poly.widget.hostmarket.HostMarketView.a
        public void b(a.C0240a c0240a) {
            m.this.byh.a(false);
            m mVar = m.this;
            mVar.removeCallbacks(mVar.bxW);
            m.this.Nl();
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
                mVar.startAnimation(mVar.byp);
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
            if (m.this.byy == null || !m.this.byy.isShowing()) {
                return;
            }
            m.this.byy.dismiss();
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
    public class j implements a.InterfaceC0245a {
        final /* synthetic */ o[] byf;
        final /* synthetic */ o byg;

        j(o[] oVarArr, o oVar) {
            this.byf = oVarArr;
            this.byg = oVar;
        }

        @Override // com.baidu.poly.widget.a.InterfaceC0245a
        public void a() {
            o[] oVarArr = this.byf;
            int length = oVarArr.length;
            for (int i = 0; i < length; i++) {
                o oVar = oVarArr[i];
                oVar.h(oVar == this.byg ? 1 : 0);
            }
            m.this.b(this.byf);
        }
    }

    /* loaded from: classes11.dex */
    public interface l {
        void onClose();
    }

    public m(PolyActivity polyActivity) {
        super(polyActivity);
        this.byz = null;
        this.byA = true;
        this.ka = false;
        this.bxW = new c();
        this.byB = false;
        this.byC = false;
        U();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nl() {
        com.baidu.poly.a.k.a.a(this.bxU);
        this.bxU = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nm() {
        if (this.byB && this.byC) {
            com.baidu.poly.a.g.a.w();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R() {
        com.baidu.poly.widget.c cVar = this.byy;
        boolean z = ((cVar != null && cVar.isShowing()) || this.F || this.D) ? false : true;
        o oVar = this.byz;
        if ((oVar != null && (TextUtils.equals(oVar.I(), "BAIDU-ALIPAY-WISE") || TextUtils.equals(this.byz.I(), "BAIDU-ALIPAY-WISE-HUABEI-PAY"))) || this.ka) {
            com.baidu.poly.util.d.info("ChannelListView->confirmViewClose() ali pay channel");
            z &= this.byA;
        }
        com.baidu.poly.util.d.info("ChannelListView->confirmViewClose() canFinishActivity = " + z);
        if (!z || this.byn == null) {
            return;
        }
        com.baidu.poly.util.d.info("ChannelListView->confirmViewClose() finish activity");
        this.byn.onClose();
        this.byn = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        this.byq.a(this.byl);
        this.byq.setListener(new e());
    }

    private void U() {
        this.byo = AnimationUtils.loadAnimation(getContext(), b.a.slide_in_bottom);
        this.byp = AnimationUtils.loadAnimation(getContext(), b.a.slide_out_bottom);
        LayoutInflater.from(getContext()).inflate(b.f.view_channel_list, this);
        this.r = findViewById(b.e.bg_view);
        this.byh = (PolyFrameLayout) findViewById(b.e.popup_view);
        this.byt = findViewById(b.e.pay_money_layout);
        this.aa = findViewById(b.e.channel_list_scroll_view);
        this.byi = (TipView) findViewById(b.e.tip_view);
        this.byj = (ViewGroup) findViewById(b.e.channel_list_view);
        this.byk = (ProgressButton) findViewById(b.e.pay_button);
        this.S = findViewById(b.e.line);
        findViewById(b.e.close_button).setOnClickListener(this);
        this.byk.setOnClickListener(this);
        this.byq = (HostMarketView) findViewById(b.e.hostmarket);
        this.bys = (CouponEntranceView) findViewById(b.e.coupon);
        this.bys.setOnClickListener(this);
        this.byr = (TextView) findViewById(b.e.money);
        this.R = (TextView) findViewById(b.e.cut);
    }

    private void V() {
        List<a.C0247a> list;
        com.baidu.poly.widget.coupon.a aVar = this.bxy;
        if (aVar != null && (list = aVar.bxB) != null && list.size() > 0) {
            this.byu = new com.baidu.poly.widget.coupon.l(getContext());
            this.byu.a(this.byh.getMeasuredHeight());
            this.byu.setListener(new k());
            this.byu.a(this.bxy.bxB);
            this.byu.a(this.byh);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W() {
        Long l2;
        Long l3 = this.byw;
        if (l3 != null && (l2 = this.byv) != null) {
            if (l3.equals(l2)) {
                this.byr.setText(a(this.byv.longValue()));
                this.R.setVisibility(8);
            } else {
                this.R.setVisibility(0);
                this.byr.setText(a(this.byv.longValue()));
                this.R.setText(" ¥" + a(this.byw.longValue()));
            }
            if (this.byt.getVisibility() != 0) {
                this.byt.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X() {
        if (this.G <= 0) {
            this.byk.setVisibility(4);
            return;
        }
        this.byk.setVisibility(0);
        this.byk.setEnable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y() {
        com.baidu.poly.a.b.a.ML().a(this.bwf, new b());
    }

    private void Z() {
        this.r.setVisibility(0);
        this.byh.setVisibility(0);
        this.r.setAlpha(0.0f);
        this.r.animate().alpha(0.65f).setDuration(240L).start();
        this.byh.startAnimation(this.byo);
        this.byo.setAnimationListener(new d());
        X();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.bxU = com.baidu.poly.a.k.a.a(this.byh, layoutParams, "加载中", -1L);
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
        com.baidu.poly.widget.coupon.l lVar = this.byu;
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
                this.byk.startLoading();
                this.F = true;
                this.byA = false;
                o[] oVarArr = this.bym;
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
                com.baidu.poly.a.g.d.a(new com.baidu.poly.a.g.b("5").gx(oVar != null ? gz(oVar.I()) : null));
            }
        } else if (view.getId() == b.e.coupon) {
            V();
        }
    }

    public void onResult(int i2, String str) {
        com.baidu.poly.util.d.info("ChannelListView->onResult() statusCode = " + i2 + " result = " + str);
        this.byA = true;
        a.b bVar = this.bwc;
        if (bVar != null) {
            bVar.onResult(i2, str);
            this.bwc = null;
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

    private String gz(String str) {
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
        if (this.byy == null) {
            View inflate = View.inflate(this.byj.getContext(), b.f.default_pop_window, null);
            ((TextView) inflate.findViewById(b.e.pop_title)).setText("收银员正在找零，请您稍等哦～");
            ((TextView) inflate.findViewById(b.e.pop_tips)).setText(str.trim());
            this.byy = new com.baidu.poly.widget.c(inflate, -1, -1, true);
            this.byy.setClippingEnabled(false);
            this.byy.setOutsideTouchable(false);
            this.byy.setBackgroundDrawable(new ColorDrawable(0));
            ((TextView) inflate.findViewById(b.e.pop_button)).setOnClickListener(new h());
            this.byy.a(new i());
        }
        PolyActivity polyActivity = (PolyActivity) getContext();
        if (polyActivity.isFinishing()) {
            return;
        }
        this.byy.showAtLocation(polyActivity.getWindow().getDecorView(), 0, 0, 0);
    }

    public m Nn() {
        if (!this.D) {
            this.D = true;
            if (!(getContext() instanceof Activity)) {
                throw new IllegalStateException("can not attach to context " + getContext());
            }
            this.byi.a("收银台加载中...");
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
            if (m.this.byu != null) {
                m.this.byu.b(m.this.byh);
            }
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void onDetach() {
            m.this.byu = null;
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void a(a.C0247a c0247a, com.baidu.poly.a.j.a aVar) {
            if (c0247a != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(c0247a.bxH);
                if (m.this.byl != null && m.this.byl.G() == 1) {
                    arrayList.add(m.this.byl.F());
                }
                m.this.a(arrayList, aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(o[] oVarArr) {
        this.aa.setMinimumHeight(0);
        if (oVarArr != null) {
            this.byj.removeAllViews();
            for (o oVar : oVarArr) {
                com.baidu.poly.widget.a aVar = new com.baidu.poly.widget.a(getContext());
                aVar.a(oVar, new j(oVarArr, oVar));
                this.byj.addView(aVar);
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
                this.byw = Long.valueOf(Long.parseLong(bundle.getString("totalAmount")));
            } catch (NumberFormatException e2) {
            }
        }
        this.bwf = bundle;
        Y();
        return this;
    }

    public m a(a.b bVar) {
        this.bwc = bVar;
        return this;
    }

    public m a(l lVar) {
        this.byn = lVar;
        return this;
    }

    public m a(com.baidu.poly.a.i.c cVar) {
        this.byx = cVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(o oVar) {
        if (oVar != null) {
            com.baidu.poly.a.g.a.c(Long.valueOf(System.currentTimeMillis()));
            JSONArray jSONArray = new JSONArray();
            try {
                if (this.byl != null && this.byl.G() == 1 && !TextUtils.isEmpty(this.byl.F())) {
                    jSONArray.put(new JSONObject(this.byl.F()));
                }
                if (this.bys.getSelectedItem() != null && !TextUtils.isEmpty(this.bys.getSelectedItem().bxH)) {
                    jSONArray.put(new JSONObject(this.bys.getSelectedItem().bxH));
                }
            } catch (Exception e2) {
            }
            if (jSONArray.length() > 0) {
                this.bwf.putString("hostMarketingDetail", jSONArray.toString());
            }
            com.baidu.poly.a.i.c cVar = this.byx;
            if (cVar != null) {
                this.byz = oVar;
                cVar.b(this.bwf, oVar.I(), this);
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
        com.baidu.poly.a.j.b.a(this.bwf.getString("bduss"), this.bwf.getString("appKey"), this.byw + "", list, new a(aVar));
    }

    private String a(long j2) {
        return new DecimalFormat("0.00").format((j2 * 1.0d) / 100.0d);
    }
}

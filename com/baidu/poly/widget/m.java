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
import com.baidu.searchbox.config.DefaultSharedPrefsWrapper;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class m extends FrameLayout implements View.OnClickListener {
    private boolean G;
    private boolean H;
    private int I;
    private TextView S;
    private TextView U;
    private a.b ckP;
    private Bundle ckS;
    private com.baidu.poly.a.l.c cmG;
    private Runnable cmI;
    private View cmT;
    private PolyFrameLayout cmU;
    private TipView cmV;
    private ViewGroup cmW;
    private ProgressButton cmX;
    private o cmY;
    private o[] cmZ;
    private com.baidu.poly.widget.coupon.a cml;
    private l cna;
    private Animation cnb;
    private Animation cnc;
    private HostMarketView cnd;
    private View cne;
    private CouponEntranceView cnf;
    private View cng;
    private View cnh;
    private com.baidu.poly.widget.coupon.l cni;
    private Long cnj;
    private Long cnk;
    private com.baidu.poly.a.j.c cnl;
    private com.baidu.poly.widget.c cnm;
    private String cnn;
    private boolean cno;
    private boolean cnp;
    private boolean la;
    private boolean ma;
    private String qa;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements com.baidu.poly.a.k.a {
        final /* synthetic */ com.baidu.poly.a.k.a ckv;

        a(com.baidu.poly.a.k.a aVar) {
            this.ckv = aVar;
        }

        @Override // com.baidu.poly.a.k.a
        public void a(a.C0301a c0301a) {
            if (c0301a.statusCode == 0) {
                m.this.cnj = Long.valueOf(c0301a.ckt);
                m.this.acb();
                if (m.this.cmY != null && m.this.cmY.P() == 1) {
                    m.this.cmY.l(c0301a.cku);
                }
            }
            this.ckv.a(c0301a);
            m.this.cnf.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b extends com.baidu.poly.a.a.a<JSONObject> {
        b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.poly.a.a.a
        public void a(JSONObject jSONObject) {
            m.this.cnj = Long.valueOf(jSONObject.optLong("payMoney"));
            JSONArray optJSONArray = jSONObject.optJSONArray("payChannels");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                o[] oVarArr = new o[optJSONArray.length()];
                for (int i = 0; i < optJSONArray.length(); i++) {
                    o oVar = new o(optJSONArray.optJSONObject(i));
                    if (oVar.P() == 1) {
                        m.this.qa = oVar.R();
                    }
                    oVarArr[i] = oVar;
                }
                m.this.cmZ = oVarArr;
                m.this.cml = new com.baidu.poly.widget.coupon.a(jSONObject.optJSONArray("coupons"));
                m.this.cnf.a(m.this.cml);
                if (m.this.cni != null) {
                    m.this.cni.a(m.this.cml.cmo);
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("marketChannels");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    m.this.cmY = new o(optJSONArray2.optJSONObject(0));
                }
                com.baidu.poly.a.h.a.j("7");
                if (m.this.cmZ.length != 1 || m.this.cnf.getVisibility() != 8 || m.this.cmY != null || m.this.cmZ[0] == null) {
                    m.this.acb();
                    if (m.this.cmY != null || m.this.cnf.getVisibility() != 8) {
                        m.this.cne.setVisibility(0);
                    } else {
                        m.this.cne.setVisibility(8);
                    }
                    m.this.aca();
                    m mVar = m.this;
                    mVar.b(mVar.a(mVar.cmZ));
                    m.this.cmV.j();
                    m.this.abY();
                    m.this.cnp = true;
                    m.this.acd();
                    return;
                }
                m.this.cnp = true;
                m.this.acd();
                m.this.cmV.b(m.this.cmZ[0].Q(), "即将进入" + m.this.cmZ[0].getDisplayName() + "…");
                m mVar2 = m.this;
                mVar2.b(mVar2.cmZ[0]);
                return;
            }
            com.baidu.poly.a.h.a.a("7", null, null);
            a(new com.baidu.poly.a.i.b("channelList is null"), "request channelList payChannels is null");
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            if (m.this.cmZ == null) {
                m mVar = m.this;
                mVar.n(mVar.getResources().getString(b.g.common_error_tips));
                m.this.onResult(3, "request channel list fail");
                m.this.detach();
                com.baidu.poly.a.h.d.a(new com.baidu.poly.a.h.b("1").iM(new com.baidu.poly.a.i.a("gatewaylist error --> " + str, th).U()));
            }
        }
    }

    /* loaded from: classes3.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            m.this.abZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class d implements Animation.AnimationListener {
        d() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            m.this.cno = true;
            m.this.acd();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class e implements HostMarketView.a {
        e() {
        }

        @Override // com.baidu.poly.widget.hostmarket.HostMarketView.a
        public void a(boolean z, o oVar, com.baidu.poly.a.k.a aVar) {
            m.this.cmU.a(true);
            m mVar = m.this;
            mVar.postDelayed(mVar.cmI, 500L);
            if (oVar != null) {
                ArrayList arrayList = new ArrayList();
                if (z) {
                    arrayList.add(oVar.O());
                }
                if (m.this.cnf.getSelectedItem() != null) {
                    arrayList.add(m.this.cnf.getSelectedItem().cmt);
                }
                m.this.a(arrayList, aVar);
            }
        }

        @Override // com.baidu.poly.widget.hostmarket.HostMarketView.a
        public void b(a.C0301a c0301a) {
            m.this.cmU.a(false);
            m mVar = m.this;
            mVar.removeCallbacks(mVar.cmI);
            m.this.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.getParent() instanceof ViewGroup) {
                m mVar = m.this;
                mVar.startAnimation(mVar.cnc);
                ((ViewGroup) m.this.getParent()).removeView(m.this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            m.this.aa();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (m.this.cnm == null || !m.this.cnm.isShowing()) {
                return;
            }
            m.this.cnm.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class i implements c.b {
        i() {
        }

        @Override // com.baidu.poly.widget.c.b
        public void onDismiss() {
            m.this.aa();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class j implements a.InterfaceC0306a {
        final /* synthetic */ o[] cmR;
        final /* synthetic */ o cmS;

        j(o[] oVarArr, o oVar) {
            this.cmR = oVarArr;
            this.cmS = oVar;
        }

        @Override // com.baidu.poly.widget.a.InterfaceC0306a
        public void a() {
            o[] oVarArr = this.cmR;
            int length = oVarArr.length;
            for (int i = 0; i < length; i++) {
                o oVar = oVarArr[i];
                oVar.i(oVar == this.cmS ? 1 : 0);
            }
            m.this.b(this.cmR);
        }
    }

    /* loaded from: classes3.dex */
    public interface l {
        void onClose();
    }

    public m(PolyActivity polyActivity) {
        super(polyActivity);
        this.la = true;
        this.ma = false;
        this.cmI = new c();
        this.cno = false;
        this.cnp = false;
        abX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa() {
        com.baidu.poly.widget.c cVar = this.cnm;
        boolean z = ((cVar != null && cVar.isShowing()) || this.H || this.G) ? false : true;
        if ((!TextUtils.isEmpty(this.cnn) && (TextUtils.equals(this.cnn, "BAIDU-ALIPAY-WISE") || TextUtils.equals(this.cnn, "BAIDU-ALIPAY-WISE-HUABEI-PAY"))) || this.ma) {
            com.baidu.poly.util.d.info("ChannelListView->confirmViewClose() ali pay channel");
            z &= this.la;
        }
        com.baidu.poly.util.d.info("ChannelListView->confirmViewClose() canFinishActivity = " + z);
        if (!z || this.cna == null) {
            return;
        }
        com.baidu.poly.util.d.info("ChannelListView->confirmViewClose() finish activity");
        this.cna.onClose();
        this.cna = null;
    }

    private void abX() {
        this.cnb = AnimationUtils.loadAnimation(getContext(), b.a.slide_in_bottom);
        this.cnc = AnimationUtils.loadAnimation(getContext(), b.a.slide_out_bottom);
        LayoutInflater.from(getContext()).inflate(b.f.view_channel_list, this);
        this.cmT = findViewById(b.e.bg_view);
        this.cmU = (PolyFrameLayout) findViewById(b.e.popup_view);
        this.cng = findViewById(b.e.pay_money_layout);
        this.cnh = findViewById(b.e.channel_list_scroll_view);
        this.cmV = (TipView) findViewById(b.e.tip_view);
        this.cmW = (ViewGroup) findViewById(b.e.channel_list_view);
        this.cmX = (ProgressButton) findViewById(b.e.pay_button);
        this.cne = findViewById(b.e.line);
        findViewById(b.e.close_button).setOnClickListener(this);
        this.cmX.setOnClickListener(this);
        this.cnd = (HostMarketView) findViewById(b.e.hostmarket);
        this.cnf = (CouponEntranceView) findViewById(b.e.coupon);
        this.cnf.setOnClickListener(this);
        this.S = (TextView) findViewById(b.e.money);
        this.U = (TextView) findViewById(b.e.cut);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abY() {
        if (this.I <= 0) {
            this.cmX.setVisibility(4);
            return;
        }
        this.cmX.setVisibility(0);
        this.cmX.setEnable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abZ() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.cmG = com.baidu.poly.a.l.a.a(this.cmU, layoutParams, "加载中", -1L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aca() {
        this.cnd.a(this.cmY);
        this.cnd.setListener(new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acb() {
        Long l2;
        Long l3 = this.cnk;
        if (l3 != null && (l2 = this.cnj) != null) {
            if (l3.equals(l2)) {
                this.S.setText(a(this.cnj.longValue()));
                this.U.setVisibility(8);
            } else {
                this.U.setVisibility(0);
                this.S.setText(a(this.cnj.longValue()));
                this.U.setText(" ¥" + a(this.cnk.longValue()));
            }
            if (this.cng.getVisibility() != 0) {
                this.cng.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acc() {
        com.baidu.poly.a.b.b.abv().a(this.ckS, new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acd() {
        if (this.cno && this.cnp) {
            com.baidu.poly.a.h.a.F();
        }
    }

    private void da() {
        List<a.C0308a> list;
        com.baidu.poly.widget.coupon.a aVar = this.cml;
        if (aVar != null && (list = aVar.cmo) != null && list.size() > 0) {
            this.cni = new com.baidu.poly.widget.coupon.l(getContext());
            this.cni.a(this.cmU.getMeasuredHeight());
            this.cni.setListener(new k());
            this.cni.a(this.cml.cmo);
            this.cni.a(this.cmU);
        }
    }

    private void ha() {
        this.cmT.setVisibility(0);
        this.cmU.setVisibility(0);
        this.cmT.setAlpha(0.0f);
        this.cmT.animate().alpha(0.65f).setDuration(240L).start();
        this.cmU.startAnimation(this.cnb);
        this.cnb.setAnimationListener(new d());
        abY();
    }

    public void detach() {
        if (this.G) {
            this.G = false;
            this.cmT.animate().alpha(0.0f).setDuration(240L).start();
            postDelayed(new f(), 240L);
            postDelayed(new g(), 480L);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.H || super.dispatchTouchEvent(motionEvent);
    }

    public boolean onBackPressed() {
        com.baidu.poly.widget.coupon.l lVar = this.cni;
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
                this.cmX.startLoading();
                this.H = true;
                this.la = false;
                o[] oVarArr = this.cmZ;
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
            da();
        }
    }

    public void onResult(int i2, String str) {
        com.baidu.poly.util.d.info("ChannelListView->onResult() statusCode = " + i2 + " result = " + str);
        this.la = true;
        a.b bVar = this.ckP;
        if (bVar != null) {
            bVar.onResult(i2, str);
            this.ckP = null;
        }
        com.baidu.poly.a.h.d.b(i2, str);
        if (((PolyActivity) getContext()).isFinishing()) {
            com.baidu.poly.a.h.d.flush();
        }
        aa();
    }

    public void setCloseListener(l lVar) {
        this.cna = lVar;
    }

    public void setIsPreparePaying(boolean z) {
        this.H = z;
        aa();
        detach();
    }

    public void setResultListener(a.b bVar) {
        this.ckP = bVar;
    }

    public void setWalletList(com.baidu.poly.a.j.c cVar) {
        this.cnl = cVar;
    }

    public void setWechatH5Pay(boolean z) {
        this.ma = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(String str) {
        if (TextUtils.isEmpty(str)) {
            str = getResources().getString(b.g.common_error_tips);
        }
        if (this.cnm == null) {
            View inflate = View.inflate(this.cmW.getContext(), b.f.default_pop_window, null);
            ((TextView) inflate.findViewById(b.e.pop_title)).setText("支付失败");
            ((TextView) inflate.findViewById(b.e.pop_tips)).setText(str.trim());
            this.cnm = new com.baidu.poly.widget.c(inflate, -1, -1, true);
            this.cnm.ee(false);
            this.cnm.ed(false);
            this.cnm.setBackgroundDrawable(new ColorDrawable(0));
            ((TextView) inflate.findViewById(b.e.pop_button)).setOnClickListener(new h());
            this.cnm.a(new i());
        }
        PolyActivity polyActivity = (PolyActivity) getContext();
        if (polyActivity.isFinishing()) {
            return;
        }
        this.cnm.showAtLocation(polyActivity.getWindow().getDecorView(), 0, 0, 0);
    }

    private void o(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(DefaultSharedPrefsWrapper.SP_FILE_DEFAULT, this.qa);
            jSONObject.put("selected", str);
        } catch (JSONException e2) {
        }
        com.baidu.poly.a.h.d.a(new com.baidu.poly.a.h.b("5").ax(jSONObject));
    }

    public m ace() {
        if (!this.G) {
            this.G = true;
            if (!(getContext() instanceof Activity)) {
                throw new IllegalStateException("can not attach to context " + getContext());
            }
            this.cmV.a("收银台加载中...");
            com.baidu.poly.util.d.info("ChannelListView->attach()");
            ha();
        }
        return this;
    }

    public void e() {
        com.baidu.poly.a.l.a.a(this.cmG);
        this.cmG = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class k implements l.h {
        k() {
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void b() {
            m.this.acc();
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void d() {
            if (m.this.cni != null) {
                m.this.cni.b(m.this.cmU);
            }
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void onDetach() {
            m.this.cni = null;
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void a(a.C0308a c0308a, com.baidu.poly.a.k.a aVar) {
            if (c0308a != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(c0308a.cmt);
                if (m.this.cmY != null && m.this.cmY.P() == 1) {
                    arrayList.add(m.this.cmY.O());
                }
                m.this.a(arrayList, aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(o[] oVarArr) {
        this.cnh.setMinimumHeight(0);
        if (oVarArr != null) {
            this.cmW.removeAllViews();
            for (o oVar : oVarArr) {
                com.baidu.poly.widget.a aVar = new com.baidu.poly.widget.a(getContext());
                aVar.a(oVar, new j(oVarArr, oVar));
                this.cmW.addView(aVar);
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
                    this.cnk = -1L;
                } else {
                    this.cnk = Long.valueOf(Long.parseLong(string));
                }
            } catch (Exception e2) {
                com.baidu.poly.util.d.info("totalAmount is not long");
            }
        }
        this.ckS = bundle;
        acc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(o oVar) {
        if (oVar != null) {
            com.baidu.poly.a.h.a.d(Long.valueOf(System.currentTimeMillis()));
            JSONArray jSONArray = new JSONArray();
            try {
                if (this.cmY != null && this.cmY.P() == 1 && !TextUtils.isEmpty(this.cmY.O())) {
                    jSONArray.put(new JSONObject(this.cmY.O()));
                }
                if (this.cnf.getSelectedItem() != null && !TextUtils.isEmpty(this.cnf.getSelectedItem().cmt)) {
                    jSONArray.put(new JSONObject(this.cnf.getSelectedItem().cmt));
                }
            } catch (Exception e2) {
            }
            if (jSONArray.length() > 0) {
                this.ckS.putString("hostMarketingDetail", jSONArray.toString());
            }
            if (this.cnl != null) {
                this.cnn = oVar.R();
                this.cnl.b(this.ckS, oVar.R(), this);
            }
        }
    }

    public void c(Bundle bundle, String str) {
        this.cnn = str;
        if (this.cnl != null) {
            this.H = true;
            this.la = false;
            com.baidu.poly.a.h.a.d(Long.valueOf(System.currentTimeMillis()));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            this.cmG = com.baidu.poly.a.l.a.a(this, layoutParams, getResources().getString(b.g.poly_fast_pay_loading), -1L);
            this.cnl.b(bundle, str, this);
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
        com.baidu.poly.a.k.b.a(this.ckS.getString("bduss"), this.ckS.getString("appKey"), this.cnk + "", list, new a(aVar));
    }

    private String a(long j2) {
        return new DecimalFormat("0.00").format((j2 * 1.0d) / 100.0d);
    }
}

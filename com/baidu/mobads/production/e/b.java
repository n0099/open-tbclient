package com.baidu.mobads.production.e;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.mobads.AdSize;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXAdContainer;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdResponseInfo;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.production.p;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends com.baidu.mobads.production.a implements a {
    public final IXAdLogger A;
    public d B;
    public AdSize C;
    public boolean D;
    public boolean E;
    public Activity F;
    public RelativeLayout G;
    public Boolean H;
    public final String z;

    public b(Context context, RelativeLayout relativeLayout, Boolean bool, String str) {
        super(context);
        this.z = "html5_intersitial";
        this.D = false;
        this.E = false;
        this.A = XAdSDKFoundationFacade.getInstance().getAdLogger();
        setId(str);
        setActivity(context);
        setAdSlotBase(relativeLayout);
        this.o = IXAdConstants4PDK.SlotType.SLOT_TYPE_INTERSTITIAL;
        this.H = bool;
        this.C = AdSize.InterstitialGame;
        XAdSDKFoundationFacade.getInstance().getAdConstants();
        d dVar = new d(getApplicationContext(), getActivity(), this.o, Boolean.TRUE);
        this.B = dVar;
        dVar.d(str);
        this.B.f(AdSize.InterstitialGame.getValue());
        com.baidu.mobads.vo.b bVar = (com.baidu.mobads.vo.b) this.B.d();
        JSONObject attribute = bVar.getAttribute();
        attribute = attribute == null ? new JSONObject() : attribute;
        try {
            attribute.put("ABILITY", "PAUSE,");
        } catch (JSONException unused) {
        }
        bVar.a(attribute);
        d(str);
    }

    @Override // com.baidu.mobads.production.e.a
    public void a(int i, int i2) {
    }

    @Override // com.baidu.mobads.production.e.a
    public void a(Activity activity, RelativeLayout relativeLayout) {
    }

    @Override // com.baidu.mobads.production.a
    public void b(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
    }

    @Override // com.baidu.mobads.production.a
    public void b(IXAdResponseInfo iXAdResponseInfo) {
    }

    @Override // com.baidu.mobads.production.a
    public void c() {
    }

    @Override // com.baidu.mobads.production.a
    public void d() {
        this.m = 8000;
    }

    @Override // com.baidu.mobads.production.a
    public void e(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        s();
        this.E = false;
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public void request() {
        super.a(this.B);
    }

    public void s() {
        Activity activity = this.F;
        if (activity == null) {
            return;
        }
        activity.runOnUiThread(new c(this));
    }

    @Override // com.baidu.mobads.production.a, com.baidu.mobads.interfaces.IXAdProd
    public void start() {
        super.start();
    }

    @Override // com.baidu.mobads.production.e.a
    public boolean v() {
        return this.D;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ViewGroup b(Context context) {
        return (ViewGroup) ((Activity) context).getWindow().getDecorView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.mobads.interfaces.IXAdProd
    /* renamed from: b */
    public com.baidu.mobads.vo.d getAdRequestInfo() {
        return this.B;
    }

    @Override // com.baidu.mobads.production.a
    public void a(com.baidu.mobads.openad.b.b bVar, p pVar, int i) {
        pVar.a(bVar, "{'ad':[{'id':99999999,'url':'" + this.B.b() + "', type='" + IXAdInstanceInfo.CreativeType.HTML.getValue() + "'}],'n':1}");
    }

    @Override // com.baidu.mobads.production.e.a
    public void a(Activity activity) {
        if (this.D && !this.E) {
            this.E = true;
            this.D = false;
            this.F = activity;
            start();
            Rect rect = new Rect();
            activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            this.f8437e.setBackgroundColor(0);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.topMargin = rect.top;
            ViewGroup b2 = b(activity);
            RelativeLayout relativeLayout = new RelativeLayout(activity);
            this.G = relativeLayout;
            relativeLayout.addView(this.f8437e, layoutParams);
            b2.addView(this.G, new RelativeLayout.LayoutParams(-1, -1));
            this.f8437e.setFocusableInTouchMode(true);
            this.f8437e.setFocusable(true);
            this.f8437e.requestFocus();
        } else if (this.E) {
            this.A.w("interstitial ad is showing now");
        } else if (this.D) {
        } else {
            this.A.w("interstitial ad is not ready");
        }
    }

    @Override // com.baidu.mobads.production.a
    public void a(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        Object obj;
        this.D = true;
        if (hashMap == null || (obj = hashMap.get("type")) == null) {
            return;
        }
        ((String) obj).equals("video");
    }

    @Override // com.baidu.mobads.production.e.a
    public void a() {
        load();
    }
}

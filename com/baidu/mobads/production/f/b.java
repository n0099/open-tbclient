package com.baidu.mobads.production.f;

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
import com.baidu.mobads.production.v;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class b extends com.baidu.mobads.production.b implements a {
    private boolean A;
    private boolean B;
    private Activity C;
    private RelativeLayout D;
    private Boolean E;
    public final String w;
    protected final IXAdLogger x;
    private d y;
    private AdSize z;

    @Override // com.baidu.mobads.production.b
    public void g() {
    }

    public b(Context context, RelativeLayout relativeLayout, Boolean bool, String str) {
        super(context);
        this.w = "html5_intersitial";
        this.A = false;
        this.B = false;
        this.x = XAdSDKFoundationFacade.getInstance().getAdLogger();
        setId(str);
        setActivity(context);
        setAdSlotBase(relativeLayout);
        this.o = IXAdConstants4PDK.SlotType.SLOT_TYPE_INTERSTITIAL;
        this.E = bool;
        this.z = AdSize.InterstitialGame;
        XAdSDKFoundationFacade.getInstance().getAdConstants();
        this.y = new d(getApplicationContext(), getActivity(), this.o, true);
        this.y.d(str);
        this.y.f(AdSize.InterstitialGame.getValue());
        com.baidu.mobads.vo.b bVar = (com.baidu.mobads.vo.b) this.y.d();
        JSONObject attribute = bVar.getAttribute();
        JSONObject jSONObject = attribute == null ? new JSONObject() : attribute;
        try {
            jSONObject.put("ABILITY", "PAUSE,");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        bVar.a(jSONObject);
        e(str);
    }

    @Override // com.baidu.mobads.production.b
    protected void h() {
        this.m = 8000;
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public void request() {
        super.a(this.y);
    }

    @Override // com.baidu.mobads.production.b
    protected void a(com.baidu.mobads.openad.d.c cVar, v vVar, int i) {
        vVar.a(cVar, "{'ad':[{'id':99999999,'url':'" + this.y.b() + "', type='" + IXAdInstanceInfo.CreativeType.HTML.getValue() + "'}],'n':1}");
    }

    @Override // com.baidu.mobads.production.b, com.baidu.mobads.interfaces.IXAdProd
    public void start() {
        super.start();
    }

    @Override // com.baidu.mobads.production.f.a
    public void a(Activity activity) {
        if (this.A && !this.B) {
            this.B = true;
            this.A = false;
            this.C = activity;
            start();
            Rect rect = new Rect();
            activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            this.e.setBackgroundColor(0);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.topMargin = rect.top;
            ViewGroup b2 = b((Context) activity);
            this.D = new RelativeLayout(activity);
            this.D.addView(this.e, layoutParams);
            b2.addView(this.D, new RelativeLayout.LayoutParams(-1, -1));
            this.e.setFocusableInTouchMode(true);
            this.e.setFocusable(true);
            this.e.requestFocus();
        } else if (this.B) {
            this.x.w("interstitial ad is showing now");
        } else if (!this.A) {
            this.x.w("interstitial ad is not ready");
        }
    }

    @Override // com.baidu.mobads.production.f.a
    public void a(Activity activity, RelativeLayout relativeLayout) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ViewGroup b(Context context) {
        return (ViewGroup) ((Activity) context).getWindow().getDecorView();
    }

    @Override // com.baidu.mobads.production.b
    protected void c(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        Object obj;
        this.A = true;
        if (hashMap == null || (obj = hashMap.get("type")) == null || ((String) obj).equals("video")) {
        }
    }

    @Override // com.baidu.mobads.production.b
    protected void d(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.mobads.interfaces.IXAdProd
    /* renamed from: r */
    public com.baidu.mobads.vo.d getAdRequestInfo() {
        return this.y;
    }

    public void s() {
        if (this.C != null) {
            this.C.runOnUiThread(new c(this));
        }
    }

    @Override // com.baidu.mobads.production.f.a
    public boolean v() {
        return this.A;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.production.b
    public void e(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        s();
        this.B = false;
    }

    @Override // com.baidu.mobads.production.f.a
    public void q() {
        load();
    }

    @Override // com.baidu.mobads.production.f.a
    public void a(int i, int i2) {
    }

    @Override // com.baidu.mobads.production.b
    public void c(IXAdResponseInfo iXAdResponseInfo) {
    }
}

package com.baidu.mobads.production.f;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXAdContainer;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdResponseInfo;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.production.p;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.utils.e;
import com.baidu.mobads.utils.l;
import com.baidu.mobads.utils.r;
import com.baidu.mobads.vo.d;
import com.baidu.sapi2.SapiWebView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends com.baidu.mobads.production.a {
    public static int F;
    public boolean A;
    public b B;
    public Context C;
    public boolean D;
    public int E;
    public final IXAdLogger z;

    public a(Context context, RelativeLayout relativeLayout, String str, boolean z, int i, int i2, int i3, int i4) {
        super(context);
        String supportedActionType4RequestingNone;
        this.D = false;
        this.z = XAdSDKFoundationFacade.getInstance().getAdLogger();
        setId(str);
        setActivity(context);
        setAdSlotBase(relativeLayout);
        this.o = IXAdConstants4PDK.SlotType.SLOT_TYPE_SPLASH;
        this.C = context;
        this.m = i4;
        this.E = i3;
        b bVar = new b(getApplicationContext(), this.o);
        this.B = bVar;
        bVar.a(z);
        l adConstants = XAdSDKFoundationFacade.getInstance().getAdConstants();
        if (z) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(adConstants.getSupportedActionType4RequestingNone());
            arrayList.add(adConstants.getSupportedActionType4RequestingLandingPage());
            arrayList.add(adConstants.a());
            XAdSDKFoundationFacade.getInstance().getPackageUtils();
            if (r.b(context)) {
                arrayList.add(adConstants.getSupportedActionType4RequestingDownload());
            }
            supportedActionType4RequestingNone = XAdSDKFoundationFacade.getInstance().getCommonUtils().a((List<String>) arrayList);
        } else {
            supportedActionType4RequestingNone = adConstants.getSupportedActionType4RequestingNone();
        }
        this.B.b(supportedActionType4RequestingNone);
        this.B.d(i);
        this.B.e(i2);
        this.B.d(str);
        d(str);
    }

    private void a(Handler handler) {
    }

    @Override // com.baidu.mobads.production.a
    public void a(com.baidu.mobads.openad.b.b bVar, p pVar, int i) {
        com.baidu.mobads.vo.b bVar2 = (com.baidu.mobads.vo.b) this.k.d();
        JSONObject attribute = bVar2.getAttribute();
        if (attribute == null) {
            attribute = new JSONObject();
        }
        try {
            attribute.put("bitmapDisplayMode", F);
            attribute.put("countDownNew", true);
        } catch (JSONException unused) {
        }
        bVar2.a(attribute);
        pVar.a(bVar, i);
    }

    @Override // com.baidu.mobads.production.a
    public void a(boolean z, IXAdInstanceInfo iXAdInstanceInfo) {
    }

    @Override // com.baidu.mobads.production.a
    public void b(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        if (hashMap != null) {
            IXAdInstanceInfo iXAdInstanceInfo = (IXAdInstanceInfo) hashMap.get("AdInstance");
            IXAdInstanceInfo.CreativeType creativeType = iXAdInstanceInfo.getCreativeType();
            if (creativeType == IXAdInstanceInfo.CreativeType.VIDEO || creativeType == IXAdInstanceInfo.CreativeType.RM) {
                com.baidu.mobads.b.a.a().a(this.C, "383", iXAdInstanceInfo, this.B.d(), "processAdStart");
            }
        }
    }

    @Override // com.baidu.mobads.production.a
    public void b(IXAdResponseInfo iXAdResponseInfo) {
    }

    @Override // com.baidu.mobads.production.a
    public void c() {
        com.baidu.mobads.constants.a.q = System.currentTimeMillis();
        IXAdContainer iXAdContainer = this.f8441h;
        if (iXAdContainer == null || this.A) {
            return;
        }
        iXAdContainer.load();
    }

    @Override // com.baidu.mobads.production.a
    public void d() {
    }

    @Override // com.baidu.mobads.production.a
    public void e() {
    }

    @Override // com.baidu.mobads.production.a
    public void e(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        super.e(iXAdContainer, hashMap);
        if (hashMap != null) {
            try {
                String str = (String) hashMap.get("video_close_reason");
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                com.baidu.mobads.b.a.a().a(this.C, "383", (IXAdInstanceInfo) null, this.B.d(), "closead", str);
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.baidu.mobads.production.a
    public void f() {
        this.D = true;
        try {
            IXAdResponseInfo adResponseInfo = getAdResponseInfo();
            com.baidu.mobads.b.a.a().a(this.C, "382", adResponseInfo != null ? adResponseInfo.getPrimaryAdInstanceInfo() : null, this.B.d(), (HashMap<String, String>) null);
        } catch (Exception e2) {
            this.z.e(e2);
        }
    }

    @Override // com.baidu.mobads.production.a
    public boolean h() {
        return true;
    }

    @Override // com.baidu.mobads.production.a
    public HashMap r() {
        HashMap hashMap = new HashMap();
        HashMap r = super.r();
        return r != null ? r : hashMap;
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public void request() {
        com.baidu.mobads.constants.a.m = System.currentTimeMillis();
        m();
        a(this.B);
        try {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                e.a(getActivity(), getActivity().getBaseContext()).loadDataWithBaseURL(null, "", SapiWebView.K, "UTF-8", null);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.baidu.mobads.production.a
    public void a(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        com.baidu.mobads.constants.a.r = System.currentTimeMillis();
        try {
            HashMap<String, String> hashMap2 = new HashMap<>();
            hashMap2.put("m_new_rsplash", String.valueOf(com.baidu.mobads.constants.a.l));
            hashMap2.put("m_start_request", String.valueOf(com.baidu.mobads.constants.a.m));
            hashMap2.put("m_end_request", String.valueOf(com.baidu.mobads.constants.a.n));
            hashMap2.put("m_start_dex", String.valueOf(com.baidu.mobads.constants.a.o));
            hashMap2.put("m_end_dex", String.valueOf(com.baidu.mobads.constants.a.p));
            hashMap2.put("m_start_load", String.valueOf(com.baidu.mobads.constants.a.q));
            hashMap2.put("m_end_load", String.valueOf(com.baidu.mobads.constants.a.r));
            hashMap2.put("isRequestAndLoadAdTimeout", String.valueOf(this.D));
            IXAdResponseInfo adResponseInfo = getAdResponseInfo();
            IXAdInstanceInfo primaryAdInstanceInfo = adResponseInfo != null ? adResponseInfo.getPrimaryAdInstanceInfo() : null;
            JSONObject attribute = this.B.d().getAttribute();
            if (attribute == null) {
                attribute = new JSONObject();
            }
            try {
                attribute.put("splashTipStyle", this.E);
            } catch (JSONException unused) {
            }
            ((com.baidu.mobads.vo.b) this.B.d()).a(attribute);
            com.baidu.mobads.b.a.a().a(this.C, "386", primaryAdInstanceInfo, this.B.d(), hashMap2);
        } catch (Exception unused2) {
        }
        if (this.D) {
            return;
        }
        start();
        Handler handler = new Handler(this.C.getMainLooper());
        try {
            if (hashMap == null) {
                a(handler);
            } else {
                IXAdInstanceInfo iXAdInstanceInfo = (IXAdInstanceInfo) hashMap.get("AdInstance");
                IXAdInstanceInfo.CreativeType creativeType = iXAdInstanceInfo.getCreativeType();
                if (creativeType != IXAdInstanceInfo.CreativeType.VIDEO && creativeType != IXAdInstanceInfo.CreativeType.RM) {
                    a(handler);
                } else {
                    com.baidu.mobads.b.a.a().a(this.C, "383", iXAdInstanceInfo, this.B.d(), "processAdLoaded");
                }
            }
        } catch (Exception unused3) {
        }
    }

    @Override // com.baidu.mobads.production.a
    public boolean f(IXAdInstanceInfo iXAdInstanceInfo) {
        return b(iXAdInstanceInfo);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.mobads.interfaces.IXAdProd
    /* renamed from: a */
    public d getAdRequestInfo() {
        return this.B;
    }

    @Override // com.baidu.mobads.production.a
    public String a(IXAdInstanceInfo iXAdInstanceInfo) {
        if (b(iXAdInstanceInfo)) {
            return iXAdInstanceInfo.getMainPictureUrl();
        }
        return super.a(iXAdInstanceInfo);
    }
}

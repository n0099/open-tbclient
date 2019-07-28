package com.baidu.mobads.production.a;

import android.content.Context;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.baidu.mapapi.UIMsg;
import com.baidu.mobads.AdSize;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXAdContainer;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdResponseInfo;
import com.baidu.mobads.interfaces.IXNonLinearAdSlot;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.production.v;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.vo.d;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a extends com.baidu.mobads.production.b implements IXNonLinearAdSlot {
    private c w;

    public a(Context context, RelativeLayout relativeLayout, String str, boolean z) {
        super(context);
        setId(str);
        setActivity(context);
        setAdSlotBase(relativeLayout);
        this.o = IXAdConstants4PDK.SlotType.SLOT_TYPE_BANNER;
        XAdSDKFoundationFacade.getInstance().getAdConstants();
        this.w = new c(getApplicationContext(), getActivity(), this.o);
        this.w.f(AdSize.Banner.getValue());
        this.w.d(str);
        com.baidu.mobads.vo.b bVar = (com.baidu.mobads.vo.b) this.w.d();
        bVar.a(z);
        JSONObject attribute = bVar.getAttribute();
        JSONObject jSONObject = attribute == null ? new JSONObject() : attribute;
        try {
            jSONObject.put("ABILITY", "BANNER_CLOSE,PAUSE,UNLIMITED_BANNER_SIZE,");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        bVar.a(jSONObject);
        e(str);
    }

    @Override // com.baidu.mobads.production.b
    public void g() {
        load();
    }

    @Override // com.baidu.mobads.production.b
    protected void h() {
        this.m = 10000;
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public void request() {
        a(this.w);
        try {
            new WebView(getActivity());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.mobads.production.b
    protected void b(d dVar) {
        this.k = dVar;
        k();
        a((com.baidu.mobads.openad.d.c) null, (v) null, UIMsg.m_AppUI.MSG_APP_GPS);
    }

    @Override // com.baidu.mobads.production.b
    protected void a(com.baidu.mobads.openad.d.c cVar, v vVar, int i) {
        try {
            setAdResponseInfo(new com.baidu.mobads.vo.c("{'ad':[{'id':99999999,'url':'" + this.w.b() + "', type='" + IXAdInstanceInfo.CreativeType.HTML.getValue() + "'}],'n':1}"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        b("XAdMouldeLoader ad-server requesting success");
    }

    @Override // com.baidu.mobads.production.b
    protected void c(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        start();
    }

    @Override // com.baidu.mobads.production.b
    protected void d(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.mobads.interfaces.IXAdProd
    /* renamed from: q */
    public d getAdRequestInfo() {
        return this.w;
    }

    @Override // com.baidu.mobads.production.b
    protected void c() {
        new Thread(new b(this)).start();
    }

    @Override // com.baidu.mobads.production.b
    protected void e(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        super.p();
        dispatchEvent(new com.baidu.mobads.f.a(IXAdEvent.AD_USER_CLOSE));
    }

    @Override // com.baidu.mobads.production.b
    public void c(IXAdResponseInfo iXAdResponseInfo) {
    }
}

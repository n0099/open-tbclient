package com.baidu.mobads.production.a;

import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.mobads.AdSize;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXAdContainer;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdResponseInfo;
import com.baidu.mobads.interfaces.IXNonLinearAdSlot;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.production.p;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.utils.e;
import com.baidu.mobads.vo.c;
import com.baidu.mobads.vo.d;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a extends com.baidu.mobads.production.a implements IXNonLinearAdSlot {
    private b z;

    public a(Context context, RelativeLayout relativeLayout, String str, boolean z) {
        super(context);
        setId(str);
        setActivity(context);
        setAdSlotBase(relativeLayout);
        this.o = IXAdConstants4PDK.SlotType.SLOT_TYPE_BANNER;
        XAdSDKFoundationFacade.getInstance().getAdConstants();
        this.z = new b(getApplicationContext(), getActivity(), this.o);
        this.z.f(AdSize.Banner.getValue());
        this.z.d(str);
        com.baidu.mobads.vo.b bVar = (com.baidu.mobads.vo.b) this.z.d();
        bVar.a(z);
        JSONObject attribute = bVar.getAttribute();
        attribute = attribute == null ? new JSONObject() : attribute;
        try {
            attribute.put("ABILITY", "BANNER_CLOSE,PAUSE,UNLIMITED_BANNER_SIZE,");
        } catch (JSONException e) {
        }
        bVar.a(attribute);
        d(str);
    }

    @Override // com.baidu.mobads.production.a
    public void c() {
        load();
    }

    @Override // com.baidu.mobads.production.a
    protected void d() {
        this.m = 10000;
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public void request() {
        a(this.z);
        try {
            e.a(getActivity(), getActivity().getBaseContext());
        } catch (Error e) {
            new HashMap().put("error_message", "init webview,error");
            dispatchEvent(new com.baidu.mobads.e.a(IXAdEvent.AD_ERROR));
        } catch (Exception e2) {
            new HashMap().put("error_message", "init webview,exception");
            dispatchEvent(new com.baidu.mobads.e.a(IXAdEvent.AD_ERROR));
        }
    }

    @Override // com.baidu.mobads.production.a
    protected void b(d dVar) {
        this.k = dVar;
        k();
        a((com.baidu.mobads.openad.b.b) null, (p) null, 5000);
    }

    @Override // com.baidu.mobads.production.a
    protected void a(com.baidu.mobads.openad.b.b bVar, p pVar, int i) {
        try {
            setAdResponseInfo(new c("{'ad':[{'id':99999999,'url':'" + this.z.b() + "', type='" + IXAdInstanceInfo.CreativeType.HTML.getValue() + "'}],'n':1}"));
        } catch (Exception e) {
        }
        a("XAdMouldeLoader ad-server requesting success");
    }

    @Override // com.baidu.mobads.production.a
    protected void a(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        start();
    }

    @Override // com.baidu.mobads.production.a
    protected void b(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.mobads.interfaces.IXAdProd
    /* renamed from: a */
    public d getAdRequestInfo() {
        return this.z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.production.a
    public void e(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        super.p();
        dispatchEvent(new com.baidu.mobads.e.a(IXAdEvent.AD_USER_CLOSE));
    }

    @Override // com.baidu.mobads.production.a
    public void b(IXAdResponseInfo iXAdResponseInfo) {
    }
}

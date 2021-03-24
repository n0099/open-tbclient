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
/* loaded from: classes2.dex */
public class a extends com.baidu.mobads.production.a implements IXNonLinearAdSlot {
    public b z;

    public a(Context context, RelativeLayout relativeLayout, String str, boolean z) {
        super(context);
        setId(str);
        setActivity(context);
        setAdSlotBase(relativeLayout);
        this.o = IXAdConstants4PDK.SlotType.SLOT_TYPE_BANNER;
        XAdSDKFoundationFacade.getInstance().getAdConstants();
        b bVar = new b(getApplicationContext(), getActivity(), this.o);
        this.z = bVar;
        bVar.f(AdSize.Banner.getValue());
        this.z.d(str);
        com.baidu.mobads.vo.b bVar2 = (com.baidu.mobads.vo.b) this.z.d();
        bVar2.a(z);
        JSONObject attribute = bVar2.getAttribute();
        attribute = attribute == null ? new JSONObject() : attribute;
        try {
            attribute.put("ABILITY", "BANNER_CLOSE,PAUSE,UNLIMITED_BANNER_SIZE,");
        } catch (JSONException unused) {
        }
        bVar2.a(attribute);
        d(str);
    }

    @Override // com.baidu.mobads.production.a
    public void a(com.baidu.mobads.openad.b.b bVar, p pVar, int i) {
        try {
            setAdResponseInfo(new c("{'ad':[{'id':99999999,'url':'" + this.z.b() + "', type='" + IXAdInstanceInfo.CreativeType.HTML.getValue() + "'}],'n':1}"));
        } catch (Exception unused) {
        }
        a("XAdMouldeLoader ad-server requesting success");
    }

    @Override // com.baidu.mobads.production.a
    public void b(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
    }

    @Override // com.baidu.mobads.production.a
    public void b(IXAdResponseInfo iXAdResponseInfo) {
    }

    @Override // com.baidu.mobads.production.a
    public void b(d dVar) {
        this.k = dVar;
        k();
        a((com.baidu.mobads.openad.b.b) null, (p) null, 5000);
    }

    @Override // com.baidu.mobads.production.a
    public void c() {
        load();
    }

    @Override // com.baidu.mobads.production.a
    public void d() {
        this.m = 10000;
    }

    @Override // com.baidu.mobads.production.a
    public void e(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        super.p();
        dispatchEvent(new com.baidu.mobads.e.a(IXAdEvent.AD_USER_CLOSE));
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public void request() {
        a(this.z);
        try {
            e.a(getActivity(), getActivity().getBaseContext());
        } catch (Error unused) {
            new HashMap().put("error_message", "init webview,error");
            dispatchEvent(new com.baidu.mobads.e.a(IXAdEvent.AD_ERROR));
        } catch (Exception unused2) {
            new HashMap().put("error_message", "init webview,exception");
            dispatchEvent(new com.baidu.mobads.e.a(IXAdEvent.AD_ERROR));
        }
    }

    @Override // com.baidu.mobads.production.a
    public void a(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        start();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.mobads.interfaces.IXAdProd
    /* renamed from: a */
    public d getAdRequestInfo() {
        return this.z;
    }
}

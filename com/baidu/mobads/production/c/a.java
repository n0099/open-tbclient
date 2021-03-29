package com.baidu.mobads.production.c;

import android.webkit.WebView;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXAdContainer;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdResponseInfo;
import com.baidu.mobads.interfaces.IXHybridAdRenderer;
import com.baidu.mobads.interfaces.IXNonLinearAdSlot;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.production.p;
import com.baidu.mobads.vo.c;
import com.baidu.mobads.vo.d;
import java.util.HashMap;
import org.json.JSONException;
/* loaded from: classes2.dex */
public class a extends com.baidu.mobads.production.a implements IXNonLinearAdSlot {
    public IXHybridAdRenderer A;
    public WebView B;
    public b z;

    public a(WebView webView) {
        super(webView.getContext());
        this.B = webView;
        setActivity(webView.getContext());
        this.o = IXAdConstants4PDK.SlotType.SLOT_TYPE_JSSDK;
        this.z = new b(getApplicationContext(), getActivity(), this.o);
    }

    @Override // com.baidu.mobads.production.a
    public void a(com.baidu.mobads.openad.b.b bVar, p pVar, int i) {
        try {
            setAdResponseInfo(new c("{'ad':[{'id':99999999,'url':'" + this.z.b() + "', type='" + IXAdInstanceInfo.CreativeType.HYBRID.getValue() + "'}],'n':1}"));
        } catch (JSONException unused) {
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
    }

    @Override // com.baidu.mobads.production.a
    public void a(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        try {
            IXHybridAdRenderer iXHybridAdRenderer = (IXHybridAdRenderer) this.f8441h;
            this.A = iXHybridAdRenderer;
            iXHybridAdRenderer.setCustomerWebView(this.B);
        } catch (Exception unused) {
            this.A = null;
        }
        start();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.mobads.interfaces.IXAdProd
    /* renamed from: a */
    public d getAdRequestInfo() {
        return this.z;
    }

    public boolean a(WebView webView, String str) {
        IXHybridAdRenderer iXHybridAdRenderer = this.A;
        if (iXHybridAdRenderer == null) {
            return false;
        }
        return iXHybridAdRenderer.shouldOverrideUrlLoading(webView, str);
    }
}

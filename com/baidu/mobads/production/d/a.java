package com.baidu.mobads.production.d;

import android.webkit.WebView;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXAdContainer;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdResponseInfo;
import com.baidu.mobads.interfaces.IXHybridAdRenderer;
import com.baidu.mobads.interfaces.IXNonLinearAdSlot;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.production.v;
import com.baidu.mobads.vo.d;
import java.util.HashMap;
import org.json.JSONException;
/* loaded from: classes20.dex */
public class a extends com.baidu.mobads.production.b implements IXNonLinearAdSlot {
    private c w;
    private IXHybridAdRenderer x;
    private WebView y;

    public a(WebView webView) {
        super(webView.getContext());
        this.y = webView;
        setActivity(webView.getContext());
        this.o = IXAdConstants4PDK.SlotType.SLOT_TYPE_JSSDK;
        this.w = new c(getApplicationContext(), getActivity(), this.o);
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
    }

    @Override // com.baidu.mobads.production.b
    protected void b(d dVar) {
        this.k = dVar;
        k();
        a((com.baidu.mobads.openad.d.c) null, (v) null, 5000);
    }

    @Override // com.baidu.mobads.production.b
    protected void a(com.baidu.mobads.openad.d.c cVar, v vVar, int i) {
        try {
            setAdResponseInfo(new com.baidu.mobads.vo.c("{'ad':[{'id':99999999,'url':'" + this.w.b() + "', type='" + IXAdInstanceInfo.CreativeType.HYBRID.getValue() + "'}],'n':1}"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        b("XAdMouldeLoader ad-server requesting success");
    }

    @Override // com.baidu.mobads.production.b
    protected void c(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        try {
            this.x = (IXHybridAdRenderer) this.h;
            this.x.setCustomerWebView(this.y);
        } catch (Exception e) {
            this.x = null;
        }
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

    public boolean a(WebView webView, String str) {
        if (this.x == null) {
            return false;
        }
        return this.x.shouldOverrideUrlLoading(webView, str);
    }

    @Override // com.baidu.mobads.production.b
    public void c(IXAdResponseInfo iXAdResponseInfo) {
    }
}

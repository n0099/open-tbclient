package com.baidu.mobads.production.b;

import android.content.Context;
import android.view.View;
import com.baidu.mobad.feeds.RequestParameters;
import com.baidu.mobads.AdSize;
import com.baidu.mobads.BaiduNativeH5AdView;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXAdContainer;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.interfaces.IXAdResponseInfo;
import com.baidu.mobads.interfaces.error.XAdErrorCode;
import com.baidu.mobads.interfaces.feeds.IXAdDummyContainer;
import com.baidu.mobads.interfaces.feeds.IXAdFeedsRequestParameters;
import com.baidu.mobads.production.p;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.utils.l;
import com.baidu.mobads.utils.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes2.dex */
public class c extends com.baidu.mobads.production.a {
    public BaiduNativeH5AdView A;
    public d z;

    public c(Context context, BaiduNativeH5AdView baiduNativeH5AdView) {
        super(context);
        this.z = null;
        this.A = baiduNativeH5AdView;
        setId(baiduNativeH5AdView.getAdPlacement().getApId());
        setActivity(context);
        setAdSlotBase(this.A);
        this.o = IXAdConstants4PDK.SlotType.SLOT_TYPE_FEEDS;
        d dVar = new d(getApplicationContext(), getActivity(), this.o);
        this.z = dVar;
        dVar.d(this.A.getAdPlacement().getApId());
        l adConstants = XAdSDKFoundationFacade.getInstance().getAdConstants();
        ArrayList arrayList = new ArrayList();
        arrayList.add(adConstants.getSupportedActionType4RequestingLandingPage());
        arrayList.add(adConstants.a());
        XAdSDKFoundationFacade.getInstance().getPackageUtils();
        if (r.b(this.f8438f)) {
            arrayList.add(adConstants.getSupportedActionType4RequestingDownload());
        }
        this.z.b(XAdSDKFoundationFacade.getInstance().getCommonUtils().a((List<String>) arrayList));
        this.z.h(0);
        this.z.f(AdSize.FeedH5TemplateNative.getValue());
        this.z.g(1);
    }

    public void a() {
    }

    public void a(int i) {
        this.z.a(i);
    }

    @Override // com.baidu.mobads.production.a
    public void b(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
    }

    @Override // com.baidu.mobads.production.a
    public void b(IXAdResponseInfo iXAdResponseInfo) {
        if (iXAdResponseInfo.getAdInstanceList().size() > 0) {
            if (iXAdResponseInfo.getPrimaryAdInstanceInfo().getHtmlSnippet() != null && iXAdResponseInfo.getPrimaryAdInstanceInfo().getHtmlSnippet().length() > 0) {
                this.A.getAdPlacement().setAdResponse(iXAdResponseInfo);
                dispatchEvent(new com.baidu.mobads.e.a("AdLoadData"));
                return;
            }
            a(XAdErrorCode.REQUEST_PARAM_ERROR, "代码位错误，请检查代码位是否是信息流模板");
        }
    }

    public void c(int i) {
        this.z.b(i);
    }

    @Override // com.baidu.mobads.production.a
    public void d() {
    }

    public void d(int i) {
        this.z.c(i);
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public IXAdRequestInfo getAdRequestInfo() {
        return this.z;
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public void request() {
        m();
        a(this.z);
    }

    @Override // com.baidu.mobads.production.a
    public void a(RequestParameters requestParameters) {
        int width = requestParameters.getWidth();
        int height = requestParameters.getHeight();
        if (width <= 0 || height <= 0) {
            return;
        }
        this.z.d(width);
        this.z.e(height);
    }

    @Override // com.baidu.mobads.production.a
    public void c() {
        IXAdContainer iXAdContainer = this.f8440h;
        if (iXAdContainer != null) {
            iXAdContainer.load();
        } else {
            this.v.e("container is null");
        }
    }

    @Override // com.baidu.mobads.production.a
    public void a(com.baidu.mobads.openad.b.b bVar, p pVar, int i) {
        if (getAdResponseInfo() != null) {
            a("XAdMouldeLoader ad-server requesting success");
        } else {
            pVar.a(bVar, i);
        }
    }

    @Override // com.baidu.mobads.production.a
    public void a(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        iXAdContainer.start();
    }

    public void a(View view, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        try {
            ((IXAdDummyContainer) this.f8440h).onImpression(view, iXAdInstanceInfo, iXAdFeedsRequestParameters, new HashMap());
        } catch (Exception unused) {
        }
    }
}

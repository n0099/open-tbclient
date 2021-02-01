package com.baidu.mobads.production.b;

import android.content.Context;
import android.view.View;
import com.baidu.mobad.feeds.RequestParameters;
import com.baidu.mobads.AdSize;
import com.baidu.mobads.g.q;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXAdContainer;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdResponseInfo;
import com.baidu.mobads.interfaces.feeds.IXAdDummyContainer;
import com.baidu.mobads.interfaces.feeds.IXAdFeedsRequestParameters;
import com.baidu.mobads.production.p;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.utils.l;
import com.baidu.mobads.utils.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class e extends com.baidu.mobads.production.a {
    private ArrayList<IXAdInstanceInfo> A;
    private boolean B;
    private int C;
    private f z;

    public e(Context context) {
        super(context);
        this.B = true;
        this.C = 8000;
    }

    public e(Context context, String str) {
        this(context, str, true);
    }

    public e(Context context, String str, boolean z) {
        this(context, str, z, 8000);
    }

    public e(Context context, String str, int i) {
        this(context, str, true, i);
    }

    public e(Context context, String str, boolean z, int i) {
        this(context, str, IXAdConstants4PDK.SlotType.SLOT_TYPE_FEEDS, z, i);
    }

    public e(Context context, String str, IXAdConstants4PDK.SlotType slotType, boolean z, int i) {
        super(context);
        this.B = true;
        this.C = 8000;
        this.B = z;
        this.C = i;
        setId(str);
        setActivity(context);
        setAdSlotBase(null);
        this.o = slotType;
        this.z = new f(getApplicationContext(), getActivity(), this.o);
        l adConstants = XAdSDKFoundationFacade.getInstance().getAdConstants();
        ArrayList arrayList = new ArrayList();
        arrayList.add(adConstants.getSupportedActionType4RequestingNone());
        arrayList.add(adConstants.getSupportedActionType4RequestingLandingPage());
        arrayList.add(adConstants.a());
        XAdSDKFoundationFacade.getInstance().getPackageUtils();
        if (r.b(context)) {
            arrayList.add(adConstants.getSupportedActionType4RequestingDownload());
        }
        this.z.b(XAdSDKFoundationFacade.getInstance().getCommonUtils().a((List<String>) arrayList));
        this.z.d(600);
        this.z.e(500);
        this.z.h(0);
        this.z.d(str);
        this.z.f(AdSize.FeedNative.getValue());
        this.z.g(1);
        this.z.i(XAdSDKFoundationFacade.getInstance().getAdConstants().getAdCreativeTypeImage());
    }

    @Override // com.baidu.mobads.production.a
    public void a(RequestParameters requestParameters) {
        int width = requestParameters.getWidth();
        int height = requestParameters.getHeight();
        if (width > 0 && height > 0) {
            this.z.d(width);
            this.z.e(height);
        }
        this.z.a(requestParameters.getExtras());
        super.a(requestParameters);
    }

    @Override // com.baidu.mobads.production.a
    protected void d() {
        this.m = this.C;
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public void request() {
        super.a(this.z);
    }

    @Override // com.baidu.mobads.production.a
    protected void a(com.baidu.mobads.openad.b.b bVar, p pVar, int i) {
        pVar.a(bVar, i);
    }

    @Override // com.baidu.mobads.production.a
    protected void a(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        iXAdContainer.start();
    }

    @Override // com.baidu.mobads.production.a
    protected void b(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        this.A = iXAdContainer.getAdContainerContext().getAdResponseInfo().getAdInstanceList();
    }

    public ArrayList<IXAdInstanceInfo> a() {
        return this.A;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.mobads.interfaces.IXAdProd
    /* renamed from: b */
    public com.baidu.mobads.vo.d getAdRequestInfo() {
        return this.z;
    }

    public void a(View view, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        try {
            ((IXAdDummyContainer) this.h).onImpression(view, iXAdInstanceInfo, iXAdFeedsRequestParameters, a(-1, iXAdInstanceInfo.getThirdImpressionTrackingUrls()));
        } catch (Exception e) {
        }
    }

    public boolean a(Context context, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(iXAdInstanceInfo.getHtmlSnippet());
            stringBuffer.append("_&_");
            stringBuffer.append(iXAdInstanceInfo.getQueryKey());
            stringBuffer.append("_&_");
            stringBuffer.append(iXAdInstanceInfo.getAdId());
            stringBuffer.append("_&_");
            stringBuffer.append(iXAdInstanceInfo.getMainPictureUrl());
            stringBuffer.append("_&_");
            stringBuffer.append(iXAdInstanceInfo.getTitle());
            stringBuffer.append("_&_");
            q.f3357a = stringBuffer.toString();
        } catch (Exception e) {
        }
        try {
            return ((IXAdDummyContainer) this.h).isAdAvailable(context, iXAdInstanceInfo, iXAdFeedsRequestParameters);
        } catch (Exception e2) {
            return false;
        }
    }

    public void b(View view, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        a(view, iXAdInstanceInfo, -1, iXAdFeedsRequestParameters);
    }

    public void a(View view, IXAdInstanceInfo iXAdInstanceInfo, int i, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        try {
            getAdRequestInfo().d().setClickView(view);
            ((IXAdDummyContainer) this.h).onClick(view, iXAdInstanceInfo, i, iXAdFeedsRequestParameters, a(i, iXAdInstanceInfo.getThirdClickTrackingUrls()));
        } catch (Exception e) {
        }
    }

    public void b(Context context, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        try {
            ((IXAdDummyContainer) this.h).onStart(context, iXAdInstanceInfo, iXAdFeedsRequestParameters, a(0, iXAdInstanceInfo.getStartTrackers()));
        } catch (Exception e) {
        }
    }

    public void a(Context context, int i, int i2, IXAdInstanceInfo iXAdInstanceInfo) {
    }

    public void c(Context context, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        try {
            ((IXAdDummyContainer) this.h).onComplete(context, iXAdInstanceInfo, iXAdFeedsRequestParameters, null);
        } catch (Exception e) {
        }
    }

    public void a(Context context, int i, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        try {
            ((IXAdDummyContainer) this.h).onClose(context, iXAdInstanceInfo, iXAdFeedsRequestParameters, a(i, iXAdInstanceInfo.getCloseTrackers()));
        } catch (Exception e) {
        }
    }

    public void d(Context context, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        try {
            ((IXAdDummyContainer) this.h).onCstartcard(context, iXAdInstanceInfo, iXAdFeedsRequestParameters, a(0, iXAdInstanceInfo.getCstartcardTrackers()));
        } catch (Exception e) {
        }
    }

    public void b(Context context, int i, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        try {
            ((IXAdDummyContainer) this.h).onFullScreen(context, i, iXAdInstanceInfo, iXAdFeedsRequestParameters, a(i, iXAdInstanceInfo.getFullScreenTrackers()));
        } catch (Exception e) {
        }
    }

    private Map<String, Object> a(int i, List<String> list) {
        HashMap hashMap = new HashMap();
        hashMap.put(XAdSDKFoundationFacade.getInstance().getAdConstants().feedsTrackerParameterKeyProgress(), Integer.valueOf(i));
        hashMap.put(XAdSDKFoundationFacade.getInstance().getAdConstants().feedsTrackerParameterKeyList(), list);
        return hashMap;
    }

    @Override // com.baidu.mobads.production.a
    public void c() {
        this.h.load();
    }

    @Override // com.baidu.mobads.production.a
    public void b(IXAdResponseInfo iXAdResponseInfo) {
    }

    @Override // com.baidu.mobads.production.a
    public boolean q() {
        return this.B;
    }
}

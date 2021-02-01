package com.baidu.mobads.production.rewardvideo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.text.TextUtils;
import com.baidu.mobads.AdSize;
import com.baidu.mobads.MobRewardVideoImpl;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXAdContainer;
import com.baidu.mobads.interfaces.IXAdResponseInfo;
import com.baidu.mobads.interfaces.IXRewardVideoAdContainer;
import com.baidu.mobads.production.p;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.utils.l;
import com.baidu.mobads.utils.r;
import com.baidu.mobads.vo.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes5.dex */
public class a extends com.baidu.mobads.production.a {
    private IXRewardVideoAdContainer A;
    private boolean B;
    private boolean C;
    private b z;

    public a(Context context, String str, boolean z) {
        this(context, str, z, IXAdConstants4PDK.SlotType.SLOT_TYPE_REWARD_VIDEO);
    }

    public a(Context context, String str, boolean z, IXAdConstants4PDK.SlotType slotType) {
        super(context);
        this.B = false;
        setId(str);
        setActivity(context);
        setAdSlotBase(null);
        this.C = z;
        this.o = slotType;
        this.z = new b(getApplicationContext(), getActivity(), this.o);
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
        Rect screenRect = XAdSDKFoundationFacade.getInstance().getCommonUtils().getScreenRect(context);
        this.z.d(screenRect.width());
        this.z.e(screenRect.height());
        if (context.getResources().getConfiguration().orientation == 2) {
            this.z.d(screenRect.height());
            this.z.e(screenRect.width());
        }
        this.z.h(0);
        this.z.d(str);
        this.z.g(1);
        this.z.f(AdSize.RewardVideo.getValue());
        this.z.i(adConstants.getAdCreativeTypeVideo() + adConstants.getAdCreativeTypeImage());
    }

    public boolean a() {
        this.A = (IXRewardVideoAdContainer) this.h;
        if (this.A != null) {
            return this.A.isExpired();
        }
        return false;
    }

    public boolean b() {
        this.A = (IXRewardVideoAdContainer) this.h;
        if (this.A != null) {
            return this.A.isVideoDownloaded();
        }
        return false;
    }

    public boolean s() {
        try {
            this.A = (IXRewardVideoAdContainer) this.h;
            if (this.A != null) {
                return !this.A.getAdContainerContext().getAdInstanceInfo().getAdHasDisplayed();
            }
        } catch (Exception e) {
            this.v.d("XAbstractAdProdTemplate", "notPlayedBefore-exception=" + e.getMessage());
        }
        return false;
    }

    public boolean t() {
        this.A = (IXRewardVideoAdContainer) this.h;
        return (this.A == null || this.A.getAdContainerContext() == null || this.A.getAdContainerContext().getAdInstanceInfo() == null || TextUtils.isEmpty(this.A.getAdContainerContext().getAdInstanceInfo().getVideoUrl())) ? false : true;
    }

    public void u() {
        w();
    }

    @Override // com.baidu.mobads.production.a
    protected void d() {
        this.m = 8000;
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
        if (this.B) {
            this.B = false;
            w();
        }
    }

    @Override // com.baidu.mobads.production.a
    protected void b(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.mobads.interfaces.IXAdProd
    /* renamed from: v */
    public d getAdRequestInfo() {
        return this.z;
    }

    @Override // com.baidu.mobads.production.a
    public void c() {
        this.h.load();
    }

    @Override // com.baidu.mobads.production.a
    public void b(IXAdResponseInfo iXAdResponseInfo) {
    }

    public void c(boolean z) {
        this.B = z;
    }

    @Override // com.baidu.mobads.production.a
    public void o() {
        super.o();
        MobRewardVideoImpl.mAdContainer = null;
        MobRewardVideoImpl.mContext = null;
    }

    private void w() {
        MobRewardVideoImpl.mAdContainer = (IXRewardVideoAdContainer) this.h;
        MobRewardVideoImpl.mContext = this.h.getAdContainerContext();
        Intent intent = new Intent(this.f, MobRewardVideoImpl.getActivityClass());
        if (this.f != null && !(this.f instanceof Activity)) {
            intent.addFlags(268435456);
        }
        intent.putExtra("orientation", x());
        intent.putExtra("useSurfaceView", this.C);
        this.f.startActivity(intent);
    }

    private String x() {
        if (this.f == null) {
            return "portrait";
        }
        int i = this.f.getResources().getConfiguration().orientation;
        if (i == 2) {
            return "landscape";
        }
        if (i != 1) {
            return "portrait";
        }
        return "portrait";
    }
}

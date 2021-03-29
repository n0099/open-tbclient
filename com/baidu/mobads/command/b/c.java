package com.baidu.mobads.command.b;

import android.content.Intent;
import com.baidu.mobads.AppActivity;
import com.baidu.mobads.AppActivityImp;
import com.baidu.mobads.command.XAdCommandExtraInfo;
import com.baidu.mobads.command.XAdLandingPageExtraInfo;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdResource;
import com.baidu.mobads.interfaces.IXNonLinearAdSlot;
import com.baidu.mobads.interfaces.utils.IXAdActivityUtils;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.utils.h;
import com.baidu.mobads.utils.q;
import com.baidu.mobads.vo.XAdInstanceInfo;
import com.baidubce.auth.NTLMEngineImpl;
/* loaded from: classes2.dex */
public class c extends com.baidu.mobads.command.b {

    /* renamed from: f  reason: collision with root package name */
    public String f8199f;

    /* renamed from: g  reason: collision with root package name */
    public String f8200g;

    /* renamed from: h  reason: collision with root package name */
    public String f8201h;

    public c(IXNonLinearAdSlot iXNonLinearAdSlot, IXAdInstanceInfo iXAdInstanceInfo, IXAdResource iXAdResource, String str) {
        super(iXNonLinearAdSlot, iXAdInstanceInfo, iXAdResource);
        this.f8201h = null;
        this.f8199f = "";
        this.f8200g = "";
        this.f8201h = str;
    }

    public void a() {
        try {
            h commonUtils = XAdSDKFoundationFacade.getInstance().getCommonUtils();
            IXAdActivityUtils activityUtils = XAdSDKFoundationFacade.getInstance().getActivityUtils();
            XAdLandingPageExtraInfo xAdLandingPageExtraInfo = new XAdLandingPageExtraInfo(this.f8191b.getProdInfo().getProdType(), this.f8192c);
            xAdLandingPageExtraInfo.mIntTesting4LM = 999;
            xAdLandingPageExtraInfo.mStringTesting4LM = "this is the test string";
            xAdLandingPageExtraInfo.url = this.f8201h;
            xAdLandingPageExtraInfo.e75 = 1;
            xAdLandingPageExtraInfo.from = 0;
            xAdLandingPageExtraInfo.adid = this.f8192c.getAdId();
            xAdLandingPageExtraInfo.qk = this.f8192c.getQueryKey();
            xAdLandingPageExtraInfo.packageNameOfPubliser = this.f8190a.getPackageName();
            xAdLandingPageExtraInfo.appsid = commonUtils.getAppId(this.f8190a);
            xAdLandingPageExtraInfo.appsec = commonUtils.getAppSec(this.f8190a);
            xAdLandingPageExtraInfo.title = this.f8192c.getTitle();
            xAdLandingPageExtraInfo.lpShoubaiStyle = this.f8199f;
            xAdLandingPageExtraInfo.lpMurl = this.f8200g;
            Intent intent = new Intent(this.f8190a, AppActivity.getActivityClass());
            if (this.f8191b.getActivity() != null) {
                xAdLandingPageExtraInfo.isFullScreen = activityUtils.isFullScreen(this.f8191b.getActivity()).booleanValue();
            }
            xAdLandingPageExtraInfo.orientation = this.f8190a.getResources().getConfiguration().orientation;
            if (AppActivity.isAnti()) {
                intent.putExtra(AppActivityImp.EXTRA_LANDINGPAGE_EXTRA_INFO, AppActivityImp.classToString(XAdLandingPageExtraInfo.class, xAdLandingPageExtraInfo));
                intent.putExtra(AppActivityImp.EXTRA_COMMAND_EXTRA_INFO, AppActivityImp.classToString(XAdCommandExtraInfo.class, xAdLandingPageExtraInfo));
                intent.putExtra(AppActivityImp.EXTRA_AD_INSTANCE_INFO, AppActivityImp.classToString(XAdInstanceInfo.class, xAdLandingPageExtraInfo.getAdInstanceInfo()));
            } else {
                intent.putExtra(AppActivityImp.EXTRA_DATA, xAdLandingPageExtraInfo);
            }
            intent.putExtra(AppActivityImp.EXTRA_LP_THEME, AppActivityImp.classToString(AppActivity.ActionBarColorTheme.class, AppActivity.getActionBarColorTheme()));
            intent.putExtra("showWhenLocked", AppActivity.getLpShowWhenLocked());
            intent.addFlags(268435456);
            intent.addFlags(NTLMEngineImpl.FLAG_REQUEST_128BIT_KEY_EXCH);
            this.f8190a.startActivity(intent);
        } catch (Exception e2) {
            q.a().e(e2);
        }
    }
}

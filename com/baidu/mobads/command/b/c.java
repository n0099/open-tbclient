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
/* loaded from: classes5.dex */
public class c extends com.baidu.mobads.command.b {
    public String f;
    public String g;
    private String h;

    public c(IXNonLinearAdSlot iXNonLinearAdSlot, IXAdInstanceInfo iXAdInstanceInfo, IXAdResource iXAdResource, String str) {
        super(iXNonLinearAdSlot, iXAdInstanceInfo, iXAdResource);
        this.h = null;
        this.f = "";
        this.g = "";
        this.h = str;
    }

    public void a() {
        try {
            h commonUtils = XAdSDKFoundationFacade.getInstance().getCommonUtils();
            IXAdActivityUtils activityUtils = XAdSDKFoundationFacade.getInstance().getActivityUtils();
            XAdLandingPageExtraInfo xAdLandingPageExtraInfo = new XAdLandingPageExtraInfo(this.f3307b.getProdInfo().getProdType(), this.c);
            xAdLandingPageExtraInfo.mIntTesting4LM = 999;
            xAdLandingPageExtraInfo.mStringTesting4LM = "this is the test string";
            xAdLandingPageExtraInfo.url = this.h;
            xAdLandingPageExtraInfo.e75 = 1;
            xAdLandingPageExtraInfo.from = 0;
            xAdLandingPageExtraInfo.adid = this.c.getAdId();
            xAdLandingPageExtraInfo.qk = this.c.getQueryKey();
            xAdLandingPageExtraInfo.packageNameOfPubliser = this.f3306a.getPackageName();
            xAdLandingPageExtraInfo.appsid = commonUtils.getAppId(this.f3306a);
            xAdLandingPageExtraInfo.appsec = commonUtils.getAppSec(this.f3306a);
            xAdLandingPageExtraInfo.title = this.c.getTitle();
            xAdLandingPageExtraInfo.lpShoubaiStyle = this.f;
            xAdLandingPageExtraInfo.lpMurl = this.g;
            Intent intent = new Intent(this.f3306a, AppActivity.getActivityClass());
            if (this.f3307b.getActivity() != null) {
                xAdLandingPageExtraInfo.isFullScreen = activityUtils.isFullScreen(this.f3307b.getActivity()).booleanValue();
            }
            xAdLandingPageExtraInfo.orientation = this.f3306a.getResources().getConfiguration().orientation;
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
            intent.addFlags(536870912);
            this.f3306a.startActivity(intent);
        } catch (Exception e) {
            q.a().e(e);
        }
    }
}

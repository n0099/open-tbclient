package com.baidu.mobads.command.c;

import android.content.Intent;
import com.baidu.mobads.AppActivity;
import com.baidu.mobads.command.XAdCommandExtraInfo;
import com.baidu.mobads.command.XAdLandingPageExtraInfo;
import com.baidu.mobads.command.b;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdResource;
import com.baidu.mobads.interfaces.IXNonLinearAdSlot;
import com.baidu.mobads.interfaces.utils.IXAdActivityUtils;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.utils.e;
import com.baidu.mobads.utils.m;
import com.baidu.mobads.vo.XAdInstanceInfo;
/* loaded from: classes5.dex */
public class a extends b {
    public String f;
    private String g;

    public a(IXNonLinearAdSlot iXNonLinearAdSlot, IXAdInstanceInfo iXAdInstanceInfo, IXAdResource iXAdResource, String str) {
        super(iXNonLinearAdSlot, iXAdInstanceInfo, iXAdResource);
        this.g = null;
        this.f = "";
        this.g = str;
    }

    public void a() {
        try {
            e commonUtils = XAdSDKFoundationFacade.getInstance().getCommonUtils();
            IXAdActivityUtils activityUtils = XAdSDKFoundationFacade.getInstance().getActivityUtils();
            XAdLandingPageExtraInfo xAdLandingPageExtraInfo = new XAdLandingPageExtraInfo(this.b.getProdInfo().getProdType(), this.c);
            xAdLandingPageExtraInfo.mIntTesting4LM = 999;
            xAdLandingPageExtraInfo.mStringTesting4LM = "this is the test string";
            xAdLandingPageExtraInfo.url = this.g;
            xAdLandingPageExtraInfo.e75 = 1;
            xAdLandingPageExtraInfo.from = 0;
            xAdLandingPageExtraInfo.adid = this.c.getAdId();
            xAdLandingPageExtraInfo.qk = this.c.getQueryKey();
            xAdLandingPageExtraInfo.packageNameOfPubliser = this.a.getPackageName();
            xAdLandingPageExtraInfo.appsid = commonUtils.getAppId(this.a);
            xAdLandingPageExtraInfo.appsec = commonUtils.getAppSec(this.a);
            xAdLandingPageExtraInfo.title = this.c.getTitle();
            xAdLandingPageExtraInfo.lpShoubaiStyle = this.f;
            Intent intent = new Intent(this.a, AppActivity.zq());
            if (this.b.getActivity() != null) {
                xAdLandingPageExtraInfo.isFullScreen = activityUtils.isFullScreen(this.b.getActivity()).booleanValue();
            }
            xAdLandingPageExtraInfo.orientation = this.a.getResources().getConfiguration().orientation;
            if (AppActivity.zp()) {
                intent.putExtra("EXTRA_DATA_STRING", com.baidu.mobads.b.a(XAdLandingPageExtraInfo.class, xAdLandingPageExtraInfo));
                intent.putExtra("EXTRA_DATA_STRING_COM", com.baidu.mobads.b.a(XAdCommandExtraInfo.class, xAdLandingPageExtraInfo));
                intent.putExtra("EXTRA_DATA_STRING_AD", com.baidu.mobads.b.a(XAdInstanceInfo.class, xAdLandingPageExtraInfo.getAdInstanceInfo()));
            } else {
                intent.putExtra("EXTRA_DATA", xAdLandingPageExtraInfo);
            }
            intent.addFlags(268435456);
            if (!com.baidu.mobads.b.zr()) {
                this.a.startActivity(intent);
            }
        } catch (Exception e) {
            m.a().e(e);
        }
    }
}

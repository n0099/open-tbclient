package com.baidu.mobads.container.template.splash;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.mobads.container.XBaseAdContainer;
import com.baidu.mobads.container.XMyWebView;
import com.baidu.mobads.container.adrequest.IXAdInstanceInfo;
import com.baidu.mobads.container.adrequest.XAdContainerContext;
import com.baidu.mobads.container.landingpage.AppPriActivity;
import com.baidu.mobads.container.template.XTemplateAdContainer;
import com.baidu.mobads.container.widget.DisplayInfoView;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class XSplashTemplateAdContainer extends XTemplateAdContainer {
    public boolean mIsDisplayDownLoadInfo;
    public boolean mPopDialogIfDl;

    public XSplashTemplateAdContainer(XAdContainerContext xAdContainerContext) {
        super(xAdContainerContext);
        this.mIsDisplayDownLoadInfo = true;
    }

    private void addDownloadDesc(String str, String str2, String str3, String str4, boolean z, boolean z2) {
        RelativeLayout relativeLayout = new RelativeLayout(this.mAdContainerCxt.getActivity());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        if (z2) {
            layoutParams.addRule(12);
            layoutParams.setMargins(0, 0, 0, (int) ((this.mActivity.getResources().getDisplayMetrics().density * 15.0f) + 0.5f));
        } else {
            layoutParams.addRule(2, XBaseAdContainer.Baidu_Ad_IMG_ID);
        }
        relativeLayout.setLayoutParams(layoutParams);
        DisplayInfoView build = new DisplayInfoView.Builder(this.mAdContainerCxt.getActivity()).addContent(str2, str, str3, str4).addTextColor(-10066330).addHideNavigation(true).addListener(new DisplayInfoView.OnDisplayListener() { // from class: com.baidu.mobads.container.template.splash.XSplashTemplateAdContainer.1
            @Override // com.baidu.mobads.container.widget.DisplayInfoView.OnDisplayListener
            public void onDismiss(boolean z3) {
                XSplashTemplateAdContainer.this.handleResume(null);
            }

            @Override // com.baidu.mobads.container.widget.DisplayInfoView.OnDisplayListener
            public void onShow(boolean z3) {
                XSplashTemplateAdContainer.this.handlePause(null);
            }
        }).build();
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        build.setGravity(17);
        relativeLayout.addView(build, layoutParams2);
        this.mAdContainerCxt.getAdProdBase().addView(relativeLayout);
    }

    @Override // com.baidu.mobads.container.template.XTemplateAdContainer, com.baidu.mobads.container.XBaseAdContainer
    public void doStartOnUIThread() {
        if (this.mAdState != 2) {
            displayVersion4DebugMode();
            doAddProgressView();
            this.mWebView.setOverScrollMode(2);
            XMyWebView xMyWebView = this.mWebView;
            xMyWebView.scrollTo(0, xMyWebView.getHeight());
            JSONObject adReqParam = this.mAdContainerCxt.getAdReqParam();
            this.mIsDisplayDownLoadInfo = adReqParam.optBoolean("Display_Down_Info", true);
            this.mPopDialogIfDl = adReqParam.optBoolean("popDialogIfDl", true);
            JSONObject originJsonObject = this.mAdContainerCxt.getAdInstanceInfo().getOriginJsonObject();
            String optString = originJsonObject.optString("publisher");
            String optString2 = originJsonObject.optString("app_version");
            String optString3 = originJsonObject.optString(AppPriActivity.PRIVACY_LINK);
            String optString4 = originJsonObject.optString("permission_link");
            if (this.mIsDisplayDownLoadInfo && !TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3) && !TextUtils.isEmpty(optString4) && !this.mPopDialogIfDl) {
                addDownloadDesc(optString, optString2, optString3, optString4, true, true);
            }
        }
        super.doStartOnUIThread();
    }

    @Override // com.baidu.mobads.container.XBaseAdContainer
    public void handlePause(IXAdInstanceInfo iXAdInstanceInfo) {
        super.handlePause(iXAdInstanceInfo);
        XMyWebView xMyWebView = this.mWebView;
        if (xMyWebView != null) {
            xMyWebView.onPause();
        }
    }

    @Override // com.baidu.mobads.container.XBaseAdContainer
    public void handleResume(IXAdInstanceInfo iXAdInstanceInfo) {
        super.handleResume(iXAdInstanceInfo);
        XMyWebView xMyWebView = this.mWebView;
        if (xMyWebView != null) {
            xMyWebView.onResume();
        }
    }

    @Override // com.baidu.mobads.container.XBaseAdContainer
    public void onAdClick(IXAdInstanceInfo iXAdInstanceInfo, View view) {
        sendRsplashExpClickLog(2);
    }

    @Override // com.baidu.mobads.container.template.XTemplateAdContainer, com.baidu.mobads.container.XBaseAdContainer
    public void resetAdContainerName() {
        this.mAdContainerName = "XSplashMouldAdContainer";
    }
}

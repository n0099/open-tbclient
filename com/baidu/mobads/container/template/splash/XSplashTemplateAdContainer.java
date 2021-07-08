package com.baidu.mobads.container.template.splash;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.XBaseAdContainer;
import com.baidu.mobads.container.XMyWebView;
import com.baidu.mobads.container.adrequest.IXAdInstanceInfo;
import com.baidu.mobads.container.adrequest.XAdContainerContext;
import com.baidu.mobads.container.landingpage.AppPriActivity;
import com.baidu.mobads.container.template.XTemplateAdContainer;
import com.baidu.mobads.container.widget.DisplayInfoView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class XSplashTemplateAdContainer extends XTemplateAdContainer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mIsDisplayDownLoadInfo;
    public boolean mPopDialogIfDl;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public XSplashTemplateAdContainer(XAdContainerContext xAdContainerContext) {
        super(xAdContainerContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xAdContainerContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((XAdContainerContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mIsDisplayDownLoadInfo = true;
    }

    private void addDownloadDesc(String str, String str2, String str3, String str4, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, this, new Object[]{str, str2, str3, str4, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            RelativeLayout relativeLayout = new RelativeLayout(this.mAdContainerCxt.getActivity());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            if (z2) {
                layoutParams.addRule(12);
                layoutParams.setMargins(0, 0, 0, (int) ((this.mActivity.getResources().getDisplayMetrics().density * 15.0f) + 0.5f));
            } else {
                layoutParams.addRule(2, XBaseAdContainer.Baidu_Ad_IMG_ID);
            }
            relativeLayout.setLayoutParams(layoutParams);
            DisplayInfoView build = new DisplayInfoView.Builder(this.mAdContainerCxt.getActivity()).addContent(str2, str, str3, str4).addTextColor(-10066330).addHideNavigation(true).addListener(new DisplayInfoView.OnDisplayListener(this) { // from class: com.baidu.mobads.container.template.splash.XSplashTemplateAdContainer.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ XSplashTemplateAdContainer this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.baidu.mobads.container.widget.DisplayInfoView.OnDisplayListener
                public void onDismiss(boolean z3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z3) == null) {
                        this.this$0.handleResume(null);
                    }
                }

                @Override // com.baidu.mobads.container.widget.DisplayInfoView.OnDisplayListener
                public void onShow(boolean z3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z3) == null) {
                        this.this$0.handlePause(null);
                    }
                }
            }).build();
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            build.setGravity(17);
            relativeLayout.addView(build, layoutParams2);
            this.mAdContainerCxt.getAdProdBase().addView(relativeLayout);
        }
    }

    @Override // com.baidu.mobads.container.template.XTemplateAdContainer, com.baidu.mobads.container.XBaseAdContainer
    public void doStartOnUIThread() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
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
    }

    @Override // com.baidu.mobads.container.XBaseAdContainer
    public void handlePause(IXAdInstanceInfo iXAdInstanceInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iXAdInstanceInfo) == null) {
            super.handlePause(iXAdInstanceInfo);
            XMyWebView xMyWebView = this.mWebView;
            if (xMyWebView != null) {
                xMyWebView.onPause();
            }
        }
    }

    @Override // com.baidu.mobads.container.XBaseAdContainer
    public void handleResume(IXAdInstanceInfo iXAdInstanceInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iXAdInstanceInfo) == null) {
            super.handleResume(iXAdInstanceInfo);
            XMyWebView xMyWebView = this.mWebView;
            if (xMyWebView != null) {
                xMyWebView.onResume();
            }
        }
    }

    @Override // com.baidu.mobads.container.XBaseAdContainer
    public void onAdClick(IXAdInstanceInfo iXAdInstanceInfo, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, iXAdInstanceInfo, view) == null) {
            sendRsplashExpClickLog(2);
        }
    }

    @Override // com.baidu.mobads.container.template.XTemplateAdContainer, com.baidu.mobads.container.XBaseAdContainer
    public void resetAdContainerName() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.mAdContainerName = "XSplashMouldAdContainer";
        }
    }
}

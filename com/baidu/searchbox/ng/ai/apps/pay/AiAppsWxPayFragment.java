package com.baidu.searchbox.ng.ai.apps.pay;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.searchbox.ng.ai.apps.AiAppsActivity;
import com.baidu.searchbox.ng.ai.apps.R;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.core.container.NgWebView;
import com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsBaseFragment;
import com.baidu.searchbox.ng.ai.apps.model.AiAppsPageParam;
import com.baidu.searchbox.ng.ai.apps.skin.AiAppNightModeHelper;
import com.facebook.common.internal.h;
import java.util.Set;
import org.apache.http.HttpHost;
/* loaded from: classes2.dex */
public class AiAppsWxPayFragment extends AiAppsBaseFragment implements WxPayWebViewListener {
    private static final boolean DEBUG = false;
    private static final Set<String> LEGAL_SCHEMES = h.K(HttpHost.DEFAULT_SCHEME_NAME, "https", "tel", "sms");
    private static final String PARAM_URL_KEY = "params_url";
    public static final String TAG = "AiAppsWxPayFragment";
    private static final String WX_PAY_SCHEMES = "weixin://wap/pay";
    private RelativeLayout loadingView;
    private String mCurrentPage;
    private NgWebView mNgWebView;
    private FrameLayout mWebViewContainer;
    private AiAppsWxPayWebViewWidget wxPayWidget;

    @Override // com.baidu.searchbox.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        restoreArguments();
    }

    @Override // com.baidu.searchbox.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.aiapps_wx_pay_fragment, viewGroup, false);
        this.loadingView = (RelativeLayout) inflate.findViewById(R.id.ai_apps_wx_pay_loading_view);
        initWebViewWidget(inflate);
        initActionBar(inflate);
        return enableSliding(immersionEnabled() ? initImmersion(inflate) : inflate, this);
    }

    private void initWebViewWidget(View view) {
        if (this.wxPayWidget == null) {
            this.wxPayWidget = new AiAppsWxPayWebViewWidget(getContext());
        }
        this.wxPayWidget.setWxPayWebViewListener(this);
        this.mNgWebView = this.wxPayWidget.getWebView();
        this.wxPayWidget.loadUrl(this.mCurrentPage);
        this.mWebViewContainer = (FrameLayout) view.findViewById(R.id.ai_apps_wx_pay_content);
        this.wxPayWidget.addToParent((ViewGroup) this.mWebViewContainer, false);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.pay.WxPayWebViewListener
    public boolean shouldOverrideUrlLoading(BdSailorWebView bdSailorWebView, String str) {
        Uri parse;
        if (str == null || (parse = Uri.parse(str)) == null) {
            return false;
        }
        if (LEGAL_SCHEMES.contains(parse.getScheme())) {
            AiAppsLog.d(TAG, "legal schemes " + parse.getScheme());
            return false;
        } else if (str.startsWith(WX_PAY_SCHEMES)) {
            AiAppsLog.d(TAG, " weixin  url:   " + str);
            AiAppsWxPayLaunchMsg.getInstance().closeWebView();
            return false;
        } else {
            AiAppsLog.e(TAG, "error schemes: " + parse.getScheme());
            return true;
        }
    }

    private void restoreArguments() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mCurrentPage = arguments.getString(PARAM_URL_KEY);
        }
    }

    public static AiAppsWxPayFragment newInstance(AiAppsPageParam aiAppsPageParam) {
        AiAppsWxPayFragment aiAppsWxPayFragment = new AiAppsWxPayFragment();
        if (aiAppsPageParam != null) {
            Bundle bundle = new Bundle();
            bundle.putString(PARAM_URL_KEY, aiAppsPageParam.mBaseUrl);
            aiAppsWxPayFragment.setArguments(bundle);
        }
        return aiAppsWxPayFragment;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsBaseFragment
    public void initActionBar(View view) {
        super.initActionBar(view);
        setActionBarBackgroundColor(-1);
        setNavigationBarFrontColor(-16777216);
        this.mAiAppsActionBar.setTitle(getResources().getString(R.string.aiapps_wx_pay_title));
        this.mAiAppsActionBar.setRightImgZone2Visibility(8);
        this.mAiAppsActionBar.setRightMenuVisibility(false);
        setBackViewVisible(false);
    }

    @Override // com.baidu.searchbox.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof AiAppsActivity) {
            this.mActivity = (AiAppsActivity) activity;
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsBaseFragment, com.baidu.searchbox.support.v4.app.Fragment
    public void onDetach() {
        this.mActivity = null;
        super.onDetach();
    }

    @Override // com.baidu.searchbox.support.v4.app.Fragment
    public void onDestroy() {
        if (this.wxPayWidget != null) {
            this.wxPayWidget.destroy();
        }
        this.wxPayWidget = null;
        super.onDestroy();
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsBaseFragment
    protected void onActionBarSettingPressed() {
        initToolMenu();
        this.mToolMenu.show(AiAppNightModeHelper.getNightModeSwitcherState());
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsBaseFragment, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable() {
        return true;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsBaseFragment
    public boolean isTabFragment() {
        return false;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsBaseFragment
    public boolean handleBackPressed() {
        if (this.mNgWebView == null || !this.mNgWebView.canGoBack()) {
            return false;
        }
        this.mNgWebView.goBack();
        return true;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsBaseFragment
    protected void initToolMenu() {
    }

    @Override // com.baidu.searchbox.support.v4.app.Fragment
    public Animation onCreateAnimation(int i, boolean z, int i2) {
        return AnimationUtils.loadAnimation(getActivity(), z ? R.anim.aiapps_slide_in_from_right : R.anim.aiapps_slide_out_to_right);
    }
}

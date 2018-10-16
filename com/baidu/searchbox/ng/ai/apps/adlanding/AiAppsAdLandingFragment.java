package com.baidu.searchbox.ng.ai.apps.adlanding;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.searchbox.ng.ai.apps.R;
import com.baidu.searchbox.ng.ai.apps.core.container.NgWebView;
import com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsBaseFragment;
import com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsFragmentManager;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController;
import com.baidu.searchbox.ng.ai.apps.model.AiAppsPageParam;
import com.baidu.searchbox.ng.ai.apps.skin.AiAppNightModeHelper;
import com.facebook.common.internal.h;
import java.util.Set;
import org.apache.http.HttpHost;
/* loaded from: classes2.dex */
public class AiAppsAdLandingFragment extends AiAppsBaseFragment implements AdLandingWebViewListener {
    private static final boolean DEBUG = false;
    private static final Set<String> LEGAL_SCHEMES = h.J(HttpHost.DEFAULT_SCHEME_NAME, "https", "tel", "sms");
    private static final String PARAM_URL_KEY = "params_url";
    public static final String TAG = "AiAppsAdLandingFragment";
    private Activity mActivity;
    private AiAppsAdLandingWebViewWidget mAdLandingWVWidget;
    private String mCurrentPage;
    private Object mDownloadProcessManager;
    private NgWebView mNgWebView;
    private FrameLayout mWebViewContainer;

    @Override // com.baidu.searchbox.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        restoreArguments();
    }

    @Override // com.baidu.searchbox.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.aiapps_ad_landing_fragment, viewGroup, false);
        initWebViewWidget(inflate);
        initActionBar(inflate);
        if (immersionEnabled()) {
            inflate = initImmersion(inflate);
        }
        return enableSliding(inflate, this);
    }

    private void initWebViewWidget(View view) {
        if (this.mAdLandingWVWidget == null) {
            this.mAdLandingWVWidget = new AiAppsAdLandingWebViewWidget(getContext());
        }
        this.mAdLandingWVWidget.setAdLandingWebViewListener(this);
        this.mNgWebView = this.mAdLandingWVWidget.getWebView();
        this.mAdLandingWVWidget.loadUrl(this.mCurrentPage);
        this.mWebViewContainer = (FrameLayout) view.findViewById(R.id.ai_apps_ad_content);
        this.mAdLandingWVWidget.addToParent((ViewGroup) this.mWebViewContainer, false);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.adlanding.AdLandingWebViewListener
    public void onPageStarted() {
    }

    @Override // com.baidu.searchbox.ng.ai.apps.adlanding.AdLandingWebViewListener
    public void goBack() {
        changeLeftCloseVisibility(this.mNgWebView.canGoBack());
    }

    @Override // com.baidu.searchbox.ng.ai.apps.adlanding.AdLandingWebViewListener
    public void onReceivedTitle(final String str) {
        changeLeftCloseVisibility(this.mNgWebView.canGoBack());
        this.mAiAppsActionBar.post(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.adlanding.AiAppsAdLandingFragment.1
            @Override // java.lang.Runnable
            public void run() {
                AiAppsAdLandingFragment.this.mAiAppsActionBar.setTitle(TextUtils.isEmpty(str) ? "" : str);
            }
        });
    }

    @Override // com.baidu.searchbox.ng.ai.apps.adlanding.AdLandingWebViewListener
    public boolean shouldOverrideUrlLoading(BdSailorWebView bdSailorWebView, String str) {
        Uri parse;
        return (str == null || (parse = Uri.parse(str)) == null || LEGAL_SCHEMES.contains(parse.getScheme())) ? false : true;
    }

    private void changeLeftCloseVisibility(boolean z) {
        this.mAiAppsActionBar.setLeftSecondViewVisibility(z ? 0 : 8);
        this.mAiAppsActionBar.setLeftSecondViewText("");
    }

    public static AiAppsAdLandingFragment newInstance(AiAppsPageParam aiAppsPageParam) {
        AiAppsAdLandingFragment aiAppsAdLandingFragment = new AiAppsAdLandingFragment();
        if (aiAppsPageParam != null) {
            Bundle bundle = new Bundle();
            bundle.putString(PARAM_URL_KEY, aiAppsPageParam.mBaseUrl);
            aiAppsAdLandingFragment.setArguments(bundle);
        }
        return aiAppsAdLandingFragment;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsBaseFragment
    public void initActionBar(View view) {
        super.initActionBar(view);
        setActionBarBackgroundColor(-1);
        setNavigationBarFrontColor(-16777216);
        this.mAiAppsActionBar.setTitle("");
        this.mAiAppsActionBar.setRightImgZone2Visibility(8);
        this.mAiAppsActionBar.setRightMenuVisibility(false);
        this.mAiAppsActionBar.setLeftSecondViewImageSrc(R.drawable.aiapps_action_bar_close_black_selector);
        setBackViewVisible(true);
        this.mAiAppsActionBar.setLeftZoneOnClickListener(new View.OnClickListener() { // from class: com.baidu.searchbox.ng.ai.apps.adlanding.AiAppsAdLandingFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (AiAppsAdLandingFragment.this.mNgWebView.canGoBack()) {
                    AiAppsAdLandingFragment.this.mNgWebView.goBack();
                } else {
                    AiAppsAdLandingFragment.this.onActionBarBackPressed();
                }
            }
        });
        this.mAiAppsActionBar.setLeftSecondViewClickListener(new View.OnClickListener() { // from class: com.baidu.searchbox.ng.ai.apps.adlanding.AiAppsAdLandingFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                AiAppsAdLandingFragment.this.closeAdLandingFrame(1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean closeAdLandingFrame(int i) {
        AiAppsFragmentManager aiAppsFragmentManager = AiAppsController.getInstance().getAiAppsFragmentManager();
        if (aiAppsFragmentManager != null) {
            aiAppsFragmentManager.createTransaction("adLanding").setCustomAnimations(AiAppsFragmentManager.ANIM_HOLD, AiAppsFragmentManager.ANIM_EXIT).popFragment(i).commit();
            return true;
        }
        return false;
    }

    private void restoreArguments() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mCurrentPage = arguments.getString(PARAM_URL_KEY);
        }
    }

    @Override // com.baidu.searchbox.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mActivity = activity;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsBaseFragment, com.baidu.searchbox.support.v4.app.Fragment
    public void onDetach() {
        this.mActivity = null;
        super.onDetach();
    }

    @Override // com.baidu.searchbox.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.mDownloadProcessManager == null) {
            this.mDownloadProcessManager = AiAppsRuntime.getAppDownloadRuntime().registerDownloadTips(getActivity(), true, false);
        }
    }

    @Override // com.baidu.searchbox.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.mDownloadProcessManager != null) {
            AiAppsRuntime.getAppDownloadRuntime().unRegisterDownloadTips(this.mDownloadProcessManager);
            this.mDownloadProcessManager = null;
        }
    }

    @Override // com.baidu.searchbox.support.v4.app.Fragment
    public void onDestroy() {
        if (this.mAdLandingWVWidget != null) {
            this.mAdLandingWVWidget.destroy();
        }
        this.mAdLandingWVWidget = null;
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

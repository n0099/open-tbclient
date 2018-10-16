package com.baidu.searchbox.ng.ai.apps.core.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.searchbox.ng.ai.apps.AiAppsErrorActivity;
import com.baidu.searchbox.ng.ai.apps.R;
import com.baidu.searchbox.ng.ai.apps.launch.model.AiAppsLaunchInfo;
import com.baidu.searchbox.ng.ai.apps.util.AiAppIntentUtils;
/* loaded from: classes2.dex */
public class AiAppsErrorFragment extends AiAppsBaseFragment {
    private static final boolean DEBUG = false;
    private static final String TAG = "AiAppsErrorFragment";
    private TextView mErrorDetail;
    private TextView mErrorMsg;
    private TextView mResumeDate;
    private LinearLayout mRootLayout;

    @Override // com.baidu.searchbox.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.aiapps_error_fragment, viewGroup, false);
        initView(inflate);
        initActionBar(inflate);
        if (immersionEnabled()) {
            return initImmersion(inflate);
        }
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsBaseFragment
    public void initActionBar(View view) {
        super.initActionBar(view);
        setActionBarBackgroundColor(-1);
        setNavigationBarFrontColor(-16777216);
        setBackViewVisible(true);
        setRightMenuVisibility(false);
        String safeGetStringExtra = AiAppIntentUtils.safeGetStringExtra(this.mActivity.getIntent(), AiAppsLaunchInfo.EXTRA_APP_TITLE_KEY);
        if (!TextUtils.isEmpty(safeGetStringExtra)) {
            setActionbarTitle(safeGetStringExtra);
        }
        this.mAiAppsActionBar.setLeftZoneOnClickListener(new View.OnClickListener() { // from class: com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsErrorFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                AiAppsErrorFragment.this.onActionBarBackPressed();
            }
        });
    }

    public void initView(View view) {
        AiAppsLaunchInfo launchInfo;
        if (getActivity() != null && (launchInfo = ((AiAppsErrorActivity) getActivity()).getLaunchInfo()) != null) {
            String str = launchInfo.mResumeDate;
            this.mRootLayout = (LinearLayout) view.findViewById(R.id.error_layout);
            this.mRootLayout.setBackgroundColor(getResources().getColor(R.color.aiapps_error_fragment_background));
            this.mErrorMsg = (TextView) view.findViewById(R.id.ai_apps_error_msg);
            this.mErrorMsg.setText(launchInfo.mErrorMsg);
            this.mErrorMsg.setTextColor(getResources().getColor(R.color.aiapps_error_msg_color));
            if (!TextUtils.isEmpty(str)) {
                this.mResumeDate = (TextView) view.findViewById(R.id.ai_apps_error_text_one);
                this.mResumeDate.setText(launchInfo.mResumeDate);
                this.mResumeDate.setTextColor(getResources().getColor(R.color.aiapps_error_detail_color));
                this.mErrorDetail = (TextView) view.findViewById(R.id.ai_apps_error_text_two);
            } else {
                this.mErrorDetail = (TextView) view.findViewById(R.id.ai_apps_error_text_one);
            }
            this.mErrorDetail.setText(launchInfo.mErrorDetail);
            this.mErrorDetail.setTextColor(getResources().getColor(R.color.aiapps_error_detail_color));
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsBaseFragment
    protected void onActionBarSettingPressed() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsBaseFragment
    public boolean isTabFragment() {
        return false;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsBaseFragment
    public boolean handleBackPressed() {
        return false;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsBaseFragment
    protected void initToolMenu() {
    }
}

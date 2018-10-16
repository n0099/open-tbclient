package com.baidu.searchbox.ng.ai.apps.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.searchbox.ng.ai.apps.AiAppsActivity;
import com.baidu.searchbox.ng.ai.apps.R;
import com.baidu.searchbox.ng.ai.apps.animator.AiAppsLoadingAnimator;
import com.baidu.searchbox.ng.ai.apps.performance.AiAppsPerformanceUBC;
import com.baidu.searchbox.ng.ai.apps.performance.UbcFlowEvent;
import com.baidu.searchbox.ng.ai.apps.res.ui.BdBaseImageView;
import com.baidu.searchbox.ng.ai.apps.res.widget.ImmersionHelper;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUIUtils;
/* loaded from: classes2.dex */
public class AiAppsLoadingView {
    public static final float ALPHA_DARK_LOADING_TRANSPARENT = 0.0f;
    private AiAppsActivity aiAppsActivity;
    public AiAppsRoundedImageView mAiAppsIcon;
    public BdBaseImageView mAiAppsLabelBg;
    public TextView mAiAppsLabelTv;
    private AiAppsLoadingAnimator mAiAppsLoadingAnimator;
    public RelativeLayout mAiAppsRelativeLayout;
    public TextView mAiAppsTitle;
    public ImageView mDarkLoadingPoint;
    public ImageView mLightLoadingPoint;
    private ImageView mRightExitImageView;
    private View mRightMenu;
    private ImageView mRightMenuImageView;
    public View mStartLoadingContainer;

    public AiAppsLoadingView(AiAppsActivity aiAppsActivity) {
        this.aiAppsActivity = aiAppsActivity;
    }

    public void showAiAppStartView() {
        if (this.mAiAppsLoadingAnimator == null) {
            this.mAiAppsLoadingAnimator = new AiAppsLoadingAnimator();
        }
        this.mStartLoadingContainer = LayoutInflater.from(this.aiAppsActivity).inflate(R.layout.aiapps_loading_fragment, (ViewGroup) null);
        this.aiAppsActivity.getFloatLayer().show(this.mStartLoadingContainer);
        this.mStartLoadingContainer.setPadding(0, ImmersionHelper.SUPPORT_IMMERSION ? AiAppsUIUtils.getStatusBarHeight() : 0, 0, 0);
        this.mAiAppsTitle = (TextView) this.mStartLoadingContainer.findViewById(R.id.aiapps_title);
        this.mAiAppsIcon = (AiAppsRoundedImageView) this.mStartLoadingContainer.findViewById(R.id.aiapps_icon);
        this.mAiAppsLabelBg = (BdBaseImageView) this.mStartLoadingContainer.findViewById(R.id.aiapps_label_bg);
        this.mAiAppsLabelTv = (TextView) this.mStartLoadingContainer.findViewById(R.id.aiapps_label_tv);
        this.mAiAppsRelativeLayout = (RelativeLayout) this.mStartLoadingContainer.findViewById(R.id.aiapps_icon_rl);
        this.mAiAppsTitle.setText(this.aiAppsActivity.getLaunchInfo().mAppTitle);
        this.mAiAppsIcon.setImageBitmap(this.aiAppsActivity.getLaunchInfo().mAppIcon);
        initIconLabelView(this.aiAppsActivity.getLaunchInfo().mType);
        this.mLightLoadingPoint = (ImageView) this.mStartLoadingContainer.findViewById(R.id.light_print);
        this.mDarkLoadingPoint = (ImageView) this.mStartLoadingContainer.findViewById(R.id.dark_print);
        this.mRightMenuImageView = (ImageView) this.mStartLoadingContainer.findViewById(R.id.titlebar_right_menu_img);
        this.mRightExitImageView = (ImageView) this.mStartLoadingContainer.findViewById(R.id.titlebar_right_menu_exit);
        this.mRightMenu = this.mStartLoadingContainer.findViewById(R.id.titlebar_right_menu);
        this.mRightMenuImageView.setImageResource(R.drawable.aiapps_action_bar_menu_black_selector);
        this.mRightExitImageView.setImageResource(R.drawable.aiapps_action_bar_exit_black_selector);
        this.mRightMenu.setBackgroundResource(R.drawable.aiapps_action_bar_right_menu_bg);
        this.mDarkLoadingPoint.setAlpha(0.0f);
        this.mAiAppsLoadingAnimator.startLoadingAnimator(this.aiAppsActivity);
        setExitClickListener();
    }

    private void setExitClickListener() {
        this.mRightExitImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.searchbox.ng.ai.apps.view.AiAppsLoadingView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AiAppsLoadingView.this.aiAppsActivity != null && !AiAppsLoadingView.this.aiAppsActivity.isFinishing()) {
                    AiAppsLoadingView.this.aiAppsActivity.moveTaskToBack(true);
                }
            }
        });
    }

    private void initIconLabelView(int i) {
        AiAppsUIUtils.isShowIconLabel(this.mAiAppsLabelBg, this.mAiAppsLabelTv, String.valueOf(i));
    }

    public void startLoadFinishAnimator() {
        AiAppsPerformanceUBC.requireSession().record(new UbcFlowEvent(AiAppsPerformanceUBC.ACTION_FIRST_ANIM_END));
        this.mAiAppsLoadingAnimator.startLoadFinishAnimator(this.aiAppsActivity);
    }

    public void stopAnimations() {
        this.mAiAppsLoadingAnimator.stopAnimations();
    }
}

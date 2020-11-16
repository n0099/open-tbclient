package com.baidu.live.tieba.yuyinala;

import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.ActivityPendingTransitionFactory;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.util.ViewCommonUtil;
import com.baidu.live.tieba.yuyinala.b.a;
import com.baidu.live.utils.i;
import com.baidu.live.utils.q;
/* loaded from: classes4.dex */
public class AlaFeedBackEditActivity extends BaseActivity implements View.OnTouchListener {
    private int availableHeight;
    private a bDY;
    private String bDZ;
    private int bEb;
    private int mLastScreenHeight;
    private int mLastScreenWidth;
    private String mLiveId;
    private String mRoomId;
    private View mRootView;
    private int mScreenWidth;
    private boolean aTr = false;
    private boolean aXq = false;
    private boolean aXr = false;
    private boolean mIsKeyboardOpen = false;
    private boolean bEa = true;
    private final CustomMessageListener aTH = new CustomMessageListener(2913054) { // from class: com.baidu.live.tieba.yuyinala.AlaFeedBackEditActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaFeedBackEditActivity.this.closeActivity();
        }
    };
    private final CustomMessageListener bEc = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.live.tieba.yuyinala.AlaFeedBackEditActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaFeedBackEditActivity.this.closeActivity();
        }
    };
    private ViewTreeObserver.OnGlobalLayoutListener aXm = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.live.tieba.yuyinala.AlaFeedBackEditActivity.5
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int[] screenDimensions = BdUtilHelper.getScreenDimensions(AlaFeedBackEditActivity.this.getPageContext().getPageActivity());
            if (screenDimensions[0] > screenDimensions[1] && screenDimensions[0] != AlaFeedBackEditActivity.this.mScreenWidth) {
                AlaFeedBackEditActivity.this.mScreenWidth = screenDimensions[0];
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    AlaFeedBackEditActivity.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.tieba.yuyinala.AlaFeedBackEditActivity.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (AlaFeedBackEditActivity.this.mRootView != null) {
                                i.ae(AlaFeedBackEditActivity.this.mRootView);
                                q.e(AlaFeedBackEditActivity.this.getActivity(), false);
                            }
                        }
                    }, 300L);
                }
            }
            Rect rect = new Rect();
            AlaFeedBackEditActivity.this.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            int statusBarHeight = BdUtilHelper.getStatusBarHeight(AlaFeedBackEditActivity.this.getPageContext().getPageActivity());
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(AlaFeedBackEditActivity.this.getPageContext().getPageActivity());
            boolean z = AlaFeedBackEditActivity.this.availableHeight != rect.bottom;
            AlaFeedBackEditActivity.this.availableHeight = rect.bottom;
            if (AlaFeedBackEditActivity.this.mLastScreenHeight != screenFullSize[1]) {
                AlaFeedBackEditActivity.this.mLastScreenHeight = screenFullSize[1];
            } else if (AlaFeedBackEditActivity.this.mLastScreenWidth != screenFullSize[0]) {
                AlaFeedBackEditActivity.this.mLastScreenWidth = screenFullSize[0];
            }
            if (screenFullSize[1] - rect.bottom > screenFullSize[1] / 4 && ((!AlaFeedBackEditActivity.this.mIsKeyboardOpen || z) && AlaFeedBackEditActivity.this.bEa)) {
                AlaFeedBackEditActivity.this.mIsKeyboardOpen = true;
                AlaFeedBackEditActivity.this.bEb = screenFullSize[1] - rect.bottom;
                AlaFeedBackEditActivity.this.onKeyboardVisibilityChanged(true);
            } else if (screenFullSize[1] - rect.height() <= statusBarHeight && AlaFeedBackEditActivity.this.mIsKeyboardOpen) {
                AlaFeedBackEditActivity.this.mIsKeyboardOpen = false;
                AlaFeedBackEditActivity.this.onKeyboardVisibilityChanged(false);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(true);
        super.onCreate(bundle);
        this.mLiveId = getIntent().getStringExtra("live_id");
        this.mRoomId = getIntent().getStringExtra("room_id");
        this.bDZ = getIntent().getStringExtra("user_key");
        registerListener(this.bEc);
        registerListener(this.aTH);
        if (TextUtils.isEmpty(this.bDZ)) {
            this.bDY = new a(getPageContext(), this.mLiveId, this.mRoomId);
        } else {
            this.bDY = new a(getPageContext(), this.mLiveId, this.mRoomId, this.bDZ);
        }
        this.mRootView = this.bDY.getView();
        if (this.mRootView == null) {
            super.finish();
            return;
        }
        TH();
        setContentView(this.mRootView);
        if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            i.ae(this.mRootView);
            q.e(getActivity(), false);
        }
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        this.aXq = false;
        this.mRootView.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (!this.aTr) {
            this.mRootView.setVisibility(0);
            Hn();
            this.aTr = true;
        }
    }

    private void Hn() {
        Animation loadAnimation;
        this.aXq = true;
        if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0195a.sdk_in_from_right);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0195a.sdk_in_from_bottom);
        }
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.live.tieba.yuyinala.AlaFeedBackEditActivity.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                AlaFeedBackEditActivity.this.aXq = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mRootView.startAnimation(loadAnimation);
    }

    private void Ho() {
        Animation loadAnimation;
        if (!this.aXr && !this.aXq) {
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0195a.sdk_out_to_right);
            } else {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0195a.sdk_out_to_bottom);
            }
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.live.tieba.yuyinala.AlaFeedBackEditActivity.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    AlaFeedBackEditActivity.super.finish();
                    ActivityPendingTransitionFactory.enterExitAnimation(AlaFeedBackEditActivity.this.getPageContext(), 0);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.aXr = true;
            this.mRootView.startAnimation(loadAnimation);
        }
    }

    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (!this.aXr) {
            this.bDY.onDestroy();
        }
        Ho();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.mRootView != null) {
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                i.ae(this.mRootView);
                q.e(getActivity(), false);
            } else {
                i.af(this.mRootView);
                q.e(getActivity(), true);
            }
            TH();
            TI();
        }
    }

    private void TH() {
        this.mRootView.setBackgroundResource(a.e.yuyin_ala_choose_feedback_act_bg);
    }

    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        TI();
    }

    private void TI() {
        Window window = getWindow();
        if (window != null) {
            int[] screenDimensions = BdUtilHelper.getScreenDimensions(getPageContext().getPageActivity());
            View decorView = window.getDecorView();
            decorView.setOnTouchListener(this);
            if (!UtilHelper.canUseStyleImmersiveSticky()) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                if (screenDimensions[1] > screenDimensions[0]) {
                    attributes.height = screenDimensions[1] - BdUtilHelper.getStatusBarHeight(getPageContext().getPageActivity());
                    attributes.gravity = 80;
                } else {
                    attributes.height = screenDimensions[1];
                    attributes.gravity = 48;
                }
                getWindowManager().updateViewLayout(decorView, attributes);
            }
            this.mScreenWidth = screenDimensions[0];
            window.setBackgroundDrawableResource(17170445);
            window.getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.aXm);
            if (this.mRootView.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mRootView.getLayoutParams();
                if (screenDimensions[1] > screenDimensions[0]) {
                    layoutParams.width = screenDimensions[0];
                    layoutParams.height = BdUtilHelper.dip2px(this, 244.0f);
                    layoutParams.gravity = 80;
                } else {
                    layoutParams.width = screenDimensions[1];
                    layoutParams.height = screenDimensions[1];
                    layoutParams.gravity = 53;
                }
                this.mRootView.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.bEa = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.bEa = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (this.mRootView != null && (this.mRootView.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mRootView.getLayoutParams();
            if (z) {
                layoutParams.bottomMargin = this.bEb;
            } else {
                layoutParams.bottomMargin = 0;
            }
            this.mRootView.setLayoutParams(layoutParams);
        }
        if (this.bDY != null) {
            this.bDY.onKeyboardVisibilityChanged(z);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.mIsKeyboardOpen) {
                BdUtilHelper.hideSoftKeyPad(this, this.mRootView);
                onKeyboardVisibilityChanged(false);
                return true;
            } else if (view != this.mRootView) {
                setResult(0);
                finish();
                return true;
            } else {
                return true;
            }
        }
        return false;
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.mIsKeyboardOpen) {
            onKeyboardVisibilityChanged(false);
        } else {
            super.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
        getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.aXm);
        this.aXm = null;
    }
}

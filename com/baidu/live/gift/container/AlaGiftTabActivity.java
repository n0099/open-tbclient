package com.baidu.live.gift.container;

import android.app.Instrumentation;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.AlaLiveGiftUIInfo;
import com.baidu.live.gift.container.AlaGiftTabView;
import com.baidu.live.gift.g;
import com.baidu.live.gift.l;
import com.baidu.live.gift.panel.GiftPanelFragmentPagerAdapter;
import com.baidu.live.gift.panel.b;
import com.baidu.live.gift.widget.panel.GiftPanelDrawContainerView;
import com.baidu.live.gift.widget.panel.GiftPanelTabView;
import com.baidu.live.noble.data.NobleUserInfo;
import com.baidu.live.noble.widget.NobleGiftEntryView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.ActivityPendingTransitionFactory;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.fragment.SupportXFragment;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.utils.h;
import com.baidu.live.utils.q;
import com.baidu.live.view.ScrollEnableViewPager;
import com.baidu.live.view.input.AlaLiveInputEditView;
import com.baidu.live.view.input.b;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.util.Locale;
/* loaded from: classes7.dex */
public class AlaGiftTabActivity extends BaseFragmentActivity implements View.OnTouchListener, AlaGiftTabView.a, b.a {
    private View aQM;
    private GiftPanelTabView aQN;
    private NobleGiftEntryView aQO;
    private ScrollEnableViewPager aQP;
    private FrameLayout aQQ;
    private AlaLiveInputEditView aQR;
    private GiftPanelDrawContainerView aQS;
    private TextView aQT;
    private ViewTreeObserver.OnGlobalLayoutListener aQU;
    private int aQV;
    private int aQW;
    private com.baidu.live.gift.panel.b aRb;
    private Runnable aRc;
    private Runnable aRd;
    private SupportXFragment[] aRe;
    private ViewGroup mContentLayout;
    private boolean mIsKeyboardOpen;
    private View mRootView;
    private boolean aQX = false;
    private boolean aND = false;
    private boolean aQY = false;
    private boolean aQZ = false;
    private boolean aRa = true;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(true);
        super.onCreate(bundle);
        if (!isFinishing()) {
            String str = Build.DISPLAY;
            if (str != null && str.contains("Flyme")) {
                getWindow().setBackgroundDrawable(new ColorDrawable(getResources().getColor(a.d.sdk_transparent)));
            }
            FF();
            initView();
            this.aRb.a(this, this);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        if (window != null) {
            View decorView = window.getDecorView();
            window.getDecorView().setOnTouchListener(this);
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (!UtilHelper.canUseStyleImmersiveSticky()) {
                int[] screenDimensions = BdUtilHelper.getScreenDimensions(getPageContext().getPageActivity());
                attributes.width = screenDimensions[0];
                attributes.height = screenDimensions[1];
                attributes.gravity = 83;
                getWindowManager().updateViewLayout(decorView, attributes);
            }
            window.setBackgroundDrawableResource(17170445);
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        finish();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    protected void addGlobalLayoutListener() {
        this.aQU = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                AlaGiftTabActivity.this.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(AlaGiftTabActivity.this.getPageContext().getPageActivity());
                int[] screenDimensions = BdUtilHelper.getScreenDimensions(AlaGiftTabActivity.this.getPageContext().getPageActivity());
                boolean z = AlaGiftTabActivity.this.aQV != rect.bottom;
                AlaGiftTabActivity.this.aQV = rect.bottom;
                if (screenDimensions[1] - rect.bottom > screenDimensions[1] / 4 && (!AlaGiftTabActivity.this.mIsKeyboardOpen || z)) {
                    AlaGiftTabActivity.this.mIsKeyboardOpen = true;
                    AlaGiftTabActivity.this.onKeyboardVisibilityChanged(true);
                } else if (screenDimensions[1] - rect.height() <= statusBarHeight && AlaGiftTabActivity.this.mIsKeyboardOpen) {
                    AlaGiftTabActivity.this.mIsKeyboardOpen = false;
                    AlaGiftTabActivity.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.aQU);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.aQR != null && this.aQR.getVisibility() == 0) {
                AsyncTask.execute(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.5
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            new Instrumentation().sendKeyDownUpSync(4);
                        } catch (Exception e) {
                            AlaGiftTabActivity.this.aQR.post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.5.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    AlaGiftTabActivity.this.c(false, 0);
                                }
                            });
                            e.printStackTrace();
                        }
                    }
                });
                return true;
            } else if (view == this.mContentLayout) {
                return true;
            } else {
                finish();
            }
        }
        return false;
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        SupportXFragment[] supportXFragmentArr;
        if (z) {
            Rect rect = new Rect();
            this.mRootView.getWindowVisibleDisplayFrame(rect);
            int dimensionPixelSize = rect.bottom - getResources().getDimensionPixelSize(a.e.sdk_ds120);
            int statusBarHeight = !UtilHelper.canUseStyleImmersiveSticky() ? dimensionPixelSize - UtilHelper.getStatusBarHeight() : dimensionPixelSize;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aQR.getLayoutParams();
            layoutParams.topMargin = statusBarHeight;
            this.aQR.setLayoutParams(layoutParams);
            if (!this.aRa) {
                this.aQR.setVisibility(0);
                return;
            }
            return;
        }
        if (this.aRe != null) {
            for (SupportXFragment supportXFragment : this.aRe) {
                if ((supportXFragment instanceof com.baidu.live.gift.panel.c) && ((com.baidu.live.gift.panel.c) supportXFragment).aVW != null) {
                    ((com.baidu.live.gift.panel.c) supportXFragment).aVW.Gc();
                }
            }
        }
        FQ();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.aQR != null && this.aQR.getVisibility() == 0) {
            c(false, 0);
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.baidu.live.gift.panel.b.a
    public void a(AlaLiveGiftUIInfo alaLiveGiftUIInfo) {
        if (alaLiveGiftUIInfo != null) {
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2 || TextUtils.isEmpty(alaLiveGiftUIInfo.getVerticalBgUrl())) {
                b(alaLiveGiftUIInfo);
                c(alaLiveGiftUIInfo);
                if (this.mContentLayout != null && alaLiveGiftUIInfo.getBgColor() != 0) {
                    Drawable background = this.mContentLayout.getBackground();
                    if (background instanceof GradientDrawable) {
                        ((GradientDrawable) background).setColor(alaLiveGiftUIInfo.getBgColor());
                        this.mContentLayout.setBackgroundDrawable(background);
                        return;
                    }
                    return;
                }
                return;
            }
            d(alaLiveGiftUIInfo);
        }
    }

    @Override // com.baidu.live.gift.panel.b.a
    public void a(int i, SupportXFragment... supportXFragmentArr) {
        SupportXFragment[] supportXFragmentArr2;
        this.aRe = supportXFragmentArr;
        if (this.aQQ != null) {
            this.aQQ.removeAllViews();
            if (this.aRe != null) {
                for (SupportXFragment supportXFragment : this.aRe) {
                    supportXFragment.onCreateView(null, null, null);
                    supportXFragment.onActivityCreated(null);
                    this.aQQ.addView(supportXFragment.getView(), new ViewGroup.LayoutParams(-1, -1));
                }
            }
        }
        dX(i);
    }

    @Override // com.baidu.live.gift.container.AlaGiftTabView.a
    public void c(boolean z, int i) {
        if (this.aQR != null && this.aQR.getEditView() != null) {
            if (z) {
                this.aQR.setMaxText(String.valueOf(i));
                this.aQR.setHintText(String.format(Locale.getDefault(), getString(a.i.ala_send_gift_count_hint), Integer.valueOf(i)));
                this.aQR.KA();
                this.aQR.getEditView().setFocusable(true);
                this.aQR.getEditView().setFocusableInTouchMode(true);
                this.aQR.getEditView().postDelayed(FO(), 100L);
                return;
            }
            FQ();
            this.aQR.getEditView().post(FP());
        }
    }

    @Override // com.baidu.live.gift.container.AlaGiftTabView.a
    public void e(boolean z, String str) {
        if (this.aQS != null) {
            if (z) {
                if (Build.VERSION.SDK_INT != 26) {
                    setRequestedOrientation(1);
                    this.aQX = true;
                }
                this.aQS.setVisibility(0);
            } else {
                if (Build.VERSION.SDK_INT != 26 && this.aQX) {
                    setRequestedOrientation(3);
                    this.aQX = false;
                }
                this.aQS.setVisibility(8);
            }
            this.aQS.f(z, str);
        }
    }

    @Override // com.baidu.live.gift.container.AlaGiftTabView.a
    public void a(g gVar) {
        if (this.aQS != null) {
            this.aQS.setGiftItem(gVar);
        }
    }

    @Override // com.baidu.live.gift.panel.b.a
    public l FC() {
        if (this.aQS != null) {
            return this.aQS.getGraffitiData();
        }
        return null;
    }

    @Override // com.baidu.live.gift.panel.b.a
    public void a(NobleUserInfo.a aVar) {
        if (this.aQO != null) {
            this.aQO.setData(aVar);
        }
    }

    @Override // com.baidu.live.gift.container.AlaGiftTabView.a
    public void ao(String str, String str2) {
        if (this.aQT != null) {
            if (!TextUtils.isEmpty(str)) {
                this.aQT.setText(str);
                this.aQT.setTag(str2);
                this.aQT.setVisibility(0);
                return;
            }
            this.aQT.setText("");
            this.aQT.setVisibility(8);
        }
    }

    @Override // com.baidu.live.gift.panel.b.a
    public void onClose() {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        SupportXFragment[] supportXFragmentArr;
        super.onDestroy();
        getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.aQU);
        if (this.aRb != null) {
            this.aRb.release();
        }
        if (this.aRe != null) {
            for (SupportXFragment supportXFragment : this.aRe) {
                supportXFragment.onDestroyView();
                supportXFragment.onDestroy();
            }
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (!this.aND) {
            this.mRootView.setVisibility(0);
            FD();
            this.aND = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.aRa = false;
        if (this.aRe != null) {
            for (SupportXFragment supportXFragment : this.aRe) {
                supportXFragment.onResume();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.aRa = true;
        if (this.aRe != null) {
            for (SupportXFragment supportXFragment : this.aRe) {
                supportXFragment.onPause();
            }
        }
    }

    private void FD() {
        Animation loadAnimation;
        this.aQY = true;
        if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0185a.sdk_in_from_right);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0185a.sdk_in_from_bottom);
        }
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                AlaGiftTabActivity.this.aQY = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        if (this.mRootView != null) {
            this.mRootView.startAnimation(loadAnimation);
        }
    }

    private void FE() {
        Animation loadAnimation;
        if (!this.aQZ && !this.aQY) {
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0185a.sdk_out_to_right);
            } else {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0185a.sdk_out_to_bottom);
            }
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.7
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    AlaGiftTabActivity.super.finish();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913175));
                    ActivityPendingTransitionFactory.enterExitAnimation(AlaGiftTabActivity.this.getPageContext(), 0);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.aQZ = true;
            if (this.mRootView != null) {
                this.mRootView.startAnimation(loadAnimation);
            }
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        FE();
    }

    private void FF() {
        this.aRb = new com.baidu.live.gift.panel.b(getPageContext());
        this.aRb.init(getIntent());
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this).inflate(a.h.live_gift_activity_panel, (ViewGroup) null);
        setContentView(this.mRootView);
        boolean z = UtilHelper.getRealScreenOrientation(getActivity()) == 2;
        if (z) {
            h.Y(this.mRootView);
            q.e(getActivity(), false);
        }
        addGlobalLayoutListener();
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        this.aQY = false;
        this.mRootView.setVisibility(4);
        FG();
        bo(z);
        bp(z);
        bq(z);
        br(z);
        bs(z);
        FH();
        FI();
        bt(z);
    }

    private void FG() {
        this.mContentLayout = (ViewGroup) findViewById(a.g.layout_content);
        this.aQM = findViewById(a.g.layout_tab);
        this.aQN = (GiftPanelTabView) findViewById(a.g.tab);
        this.aQO = (NobleGiftEntryView) findViewById(a.g.noble_entry);
        this.aQP = (ScrollEnableViewPager) findViewById(a.g.vp);
        this.aQQ = (FrameLayout) findViewById(a.g.layout_supportx);
        this.aQR = (AlaLiveInputEditView) findViewById(a.g.edit_num);
        this.aQS = (GiftPanelDrawContainerView) findViewById(a.g.container_draw);
        this.aQT = (TextView) findViewById(a.g.gift_toast);
    }

    private void bo(boolean z) {
        this.mContentLayout.setClickable(true);
        if (Build.VERSION.SDK_INT >= 26) {
            this.mContentLayout.setDefaultFocusHighlightEnabled(false);
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(getResources().getColor(a.d.live_gift_panel_primary));
        float dimensionPixelOffset = getResources().getDimensionPixelOffset(a.e.sdk_ds26);
        if (z) {
            gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelOffset, dimensionPixelOffset});
        } else {
            gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f});
        }
        this.mContentLayout.setBackgroundDrawable(gradientDrawable);
        if (z) {
            ViewGroup.LayoutParams layoutParams = this.mContentLayout.getLayoutParams();
            layoutParams.width = ScreenHelper.getRealScreenHeight(this);
            this.mContentLayout.setLayoutParams(layoutParams);
        }
    }

    private void bp(boolean z) {
        if (!z) {
            ViewGroup.LayoutParams layoutParams = this.aQM.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                ((FrameLayout.LayoutParams) layoutParams).gravity |= 80;
                ((FrameLayout.LayoutParams) layoutParams).bottomMargin = FJ();
                this.aQM.setLayoutParams(layoutParams);
            }
        }
        this.aQN.setCallback(new GiftPanelTabView.a() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.8
            @Override // com.baidu.live.gift.widget.panel.GiftPanelTabView.a
            public void dY(int i) {
                AlaGiftTabActivity.this.dX(i);
            }
        });
    }

    private void bq(boolean z) {
        if (this.aRb == null || !this.aRb.Hi()) {
            this.aQO.setVisibility(8);
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.aQO.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            if (z) {
                ((FrameLayout.LayoutParams) layoutParams).topMargin = FL();
            } else {
                ((FrameLayout.LayoutParams) layoutParams).gravity = 80;
                ((FrameLayout.LayoutParams) layoutParams).bottomMargin = FK() + FM();
            }
            this.aQO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AlaGiftTabActivity.this.aRb != null) {
                        AlaGiftTabActivity.this.aRb.Hj();
                    }
                }
            });
        }
    }

    private void br(boolean z) {
        this.aQP.setScrollEnabled(false);
        ViewGroup.LayoutParams layoutParams = this.aQP.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.height = -1;
            } else {
                layoutParams.height = FL() + FJ();
            }
            this.aQP.setLayoutParams(layoutParams);
        }
    }

    private void bs(boolean z) {
        ViewGroup.LayoutParams layoutParams = this.aQQ.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.height = -1;
            } else {
                layoutParams.height = getResources().getDimensionPixelOffset(a.e.sdk_ds116) + FJ();
            }
            this.aQQ.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.live.gift.container.AlaGiftTabActivity$10  reason: invalid class name */
    /* loaded from: classes7.dex */
    public class AnonymousClass10 implements b.a {
        AnonymousClass10() {
        }

        @Override // com.baidu.live.view.input.b.a
        public void gw(String str) {
            AsyncTask.execute(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.10.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        new Instrumentation().sendKeyDownUpSync(4);
                    } catch (Exception e) {
                        AlaGiftTabActivity.this.aQR.post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.10.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AlaGiftTabActivity.this.c(false, 0);
                            }
                        });
                        e.printStackTrace();
                    }
                }
            });
            if (JavaTypesHelper.toInt(str, 0) <= 0) {
                str = "1";
            }
            com.baidu.live.gift.panel.c FN = AlaGiftTabActivity.this.FN();
            if (FN != null && FN.aVW != null) {
                FN.aVW.gz(str);
            }
        }
    }

    private void FH() {
        this.aQR.setEditViewConfirmCallBack(new AnonymousClass10());
    }

    private void FI() {
        this.aQS.setCallback(new GiftPanelDrawContainerView.a() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.11
            @Override // com.baidu.live.gift.widget.panel.GiftPanelDrawContainerView.a
            public void dZ(int i) {
                com.baidu.live.gift.panel.c FN = AlaGiftTabActivity.this.FN();
                if (FN != null && FN.aVW != null) {
                    FN.aVW.eh(i);
                }
            }

            @Override // com.baidu.live.gift.widget.panel.GiftPanelDrawContainerView.a
            public void FR() {
                AlaGiftTabActivity.this.finish();
            }
        });
    }

    private void bt(boolean z) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(BdUtilHelper.dip2px(this, 5.0f));
        gradientDrawable.setColor(-1560281088);
        this.aQT.setBackgroundDrawable(gradientDrawable);
        if (z) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aQT.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            layoutParams.addRule(5, this.mContentLayout.getId());
            layoutParams.addRule(2, 0);
            layoutParams.rightMargin = 0;
            layoutParams.addRule(12);
            layoutParams.bottomMargin = BdUtilHelper.getDimens(this, a.e.sdk_ds90);
            this.aQT.setLayoutParams(layoutParams);
            this.aQT.setBackgroundColor(-1560281088);
            this.aQT.setGravity(17);
            int dimens = BdUtilHelper.getDimens(this, a.e.sdk_ds12);
            this.aQT.setPadding(dimens, dimens, dimens, dimens);
        }
        this.aQT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaGiftTabActivity.this.aRb != null) {
                    Object tag = AlaGiftTabActivity.this.aQT.getTag();
                    if ((tag instanceof String) && !TextUtils.isEmpty((String) tag)) {
                        AlaGiftTabActivity.this.aRb.gK((String) tag);
                    }
                }
            }
        });
    }

    private int FJ() {
        if (this.aQW <= 0) {
            this.aQW = FK();
            if (this.aRb != null && this.aRb.Hi()) {
                this.aQW += FM() + getResources().getDimensionPixelOffset(a.e.sdk_ds72);
            }
        }
        return this.aQW;
    }

    private int FK() {
        return (getResources().getDimensionPixelOffset(a.e.sdk_ds192) * 2) + getResources().getDimensionPixelOffset(a.e.sdk_ds4) + getResources().getDimensionPixelOffset(a.e.sdk_ds12) + getResources().getDimensionPixelOffset(a.e.sdk_ds116);
    }

    private int FL() {
        return getResources().getDimensionPixelOffset(a.e.sdk_ds116);
    }

    private int FM() {
        return getResources().getDimensionPixelOffset(a.e.sdk_ds24);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.live.gift.panel.c FN() {
        if (this.aRe == null || this.aQN == null || this.aRe.length <= this.aQN.getSelect() || !(this.aRe[this.aQN.getSelect()] instanceof com.baidu.live.gift.panel.c)) {
            return null;
        }
        return (com.baidu.live.gift.panel.c) this.aRe[this.aQN.getSelect()];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dX(int i) {
        if (this.aQN != null) {
            this.aQN.setSelect(i);
        }
        if (this.aRe != null) {
            int i2 = 0;
            while (i2 < this.aRe.length) {
                this.aRe[i2].setUserVisibleHint(i2 == i);
                if ((this.aRe[i2] instanceof com.baidu.live.gift.panel.c) && ((com.baidu.live.gift.panel.c) this.aRe[i2]).aVW != null) {
                    ((com.baidu.live.gift.panel.c) this.aRe[i2]).aVW.bw(i2 == i);
                }
                if (this.aRe[i2].getView() != null) {
                    this.aRe[i2].getView().setVisibility(i2 == i ? 0 : 8);
                }
                i2++;
            }
        }
    }

    private Runnable FO() {
        if (this.aRc == null) {
            this.aRc = new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.2
                @Override // java.lang.Runnable
                public void run() {
                    if (AlaGiftTabActivity.this.aQR != null && AlaGiftTabActivity.this.aQR.getEditView() != null) {
                        AlaGiftTabActivity.this.aQR.getEditView().requestFocus();
                        BdUtilHelper.showSoftKeyPad(AlaGiftTabActivity.this, AlaGiftTabActivity.this.aQR.getEditView());
                    }
                }
            };
        }
        return this.aRc;
    }

    private Runnable FP() {
        if (this.aRd == null) {
            this.aRd = new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.3
                @Override // java.lang.Runnable
                public void run() {
                    if (AlaGiftTabActivity.this.aQR != null && AlaGiftTabActivity.this.aQR.getEditView() != null) {
                        BdUtilHelper.hideSoftKeyPad(AlaGiftTabActivity.this, AlaGiftTabActivity.this.aQR.getEditView());
                    }
                }
            };
        }
        return this.aRd;
    }

    private void FQ() {
        if (this.aQR != null) {
            this.aQR.setVisibility(8);
        }
    }

    private void b(AlaLiveGiftUIInfo alaLiveGiftUIInfo) {
        if (alaLiveGiftUIInfo != null && this.aQN != null) {
            this.aQN.setColors(alaLiveGiftUIInfo.getTabBgSelectedColor(), alaLiveGiftUIInfo.getTabBgUnSelectedColor(), alaLiveGiftUIInfo.getTabTextSelectedColor(), alaLiveGiftUIInfo.getTabTextUnSelectedColor());
        }
    }

    private void c(AlaLiveGiftUIInfo alaLiveGiftUIInfo) {
        SupportXFragment[] supportXFragmentArr;
        if (alaLiveGiftUIInfo != null && alaLiveGiftUIInfo.getCategoryTextSelectedColor() != 0 && (this.aQP.getAdapter() instanceof GiftPanelFragmentPagerAdapter) && ((GiftPanelFragmentPagerAdapter) this.aQP.getAdapter()).Hr() != null && this.aRe != null) {
            for (SupportXFragment supportXFragment : this.aRe) {
                if (supportXFragment instanceof com.baidu.live.gift.panel.c) {
                    ((com.baidu.live.gift.panel.c) supportXFragment).ea(alaLiveGiftUIInfo.getCategoryTextSelectedColor());
                }
            }
        }
    }

    private void d(final AlaLiveGiftUIInfo alaLiveGiftUIInfo) {
        if (alaLiveGiftUIInfo != null && !TextUtils.isEmpty(alaLiveGiftUIInfo.getVerticalBgUrl()) && this.mContentLayout != null) {
            LinearLayout linearLayout = new LinearLayout(this.mContentLayout.getContext());
            linearLayout.setBackgroundColor(0);
            linearLayout.setOrientation(1);
            SimpleDraweeView simpleDraweeView = new SimpleDraweeView(linearLayout.getContext());
            simpleDraweeView.setScaleType(ImageView.ScaleType.FIT_XY);
            linearLayout.addView(simpleDraweeView, new LinearLayout.LayoutParams(-1, -1));
            View view = new View(linearLayout.getContext());
            view.setBackgroundColor(0);
            linearLayout.addView(view, new LinearLayout.LayoutParams(-1, FJ()));
            this.mContentLayout.addView(linearLayout, 0);
            simpleDraweeView.setController(com.facebook.drawee.a.a.c.dPn().c(simpleDraweeView.getController()).be(ImageRequestBuilder.ab(Uri.parse(alaLiveGiftUIInfo.getVerticalBgUrl())).a(com.facebook.imagepipeline.common.e.dSr()).a(com.facebook.imagepipeline.common.b.dSg().c(Bitmap.Config.RGB_565).dSo()).dWr()).xU(true).c(new com.facebook.drawee.controller.c<com.facebook.imagepipeline.g.f>() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.4
                @Override // com.facebook.drawee.controller.c
                public void g(String str, Object obj) {
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.facebook.drawee.controller.c
                public void a(String str, com.facebook.imagepipeline.g.f fVar, Animatable animatable) {
                    if (fVar != null) {
                        AlaGiftTabActivity.this.a(alaLiveGiftUIInfo, fVar.getWidth(), fVar.getHeight());
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.facebook.drawee.controller.c
                /* renamed from: a */
                public void h(String str, com.facebook.imagepipeline.g.f fVar) {
                }

                @Override // com.facebook.drawee.controller.c
                public void g(String str, Throwable th) {
                }

                @Override // com.facebook.drawee.controller.c
                public void h(String str, Throwable th) {
                }

                @Override // com.facebook.drawee.controller.c
                public void gv(String str) {
                }
            }).dQe());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaLiveGiftUIInfo alaLiveGiftUIInfo, int i, int i2) {
        if (this.mContentLayout != null && i != 0 && i2 != 0) {
            View childAt = this.mContentLayout.getChildAt(0);
            if (childAt instanceof LinearLayout) {
                LinearLayout linearLayout = (LinearLayout) childAt;
                if (linearLayout.getChildCount() > 1) {
                    View childAt2 = linearLayout.getChildAt(0);
                    if (childAt2 instanceof SimpleDraweeView) {
                        int realScreenWidth = (ScreenHelper.getRealScreenWidth(getApplicationContext()) * i2) / i;
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt2.getLayoutParams();
                        layoutParams.width = -1;
                        layoutParams.height = realScreenWidth;
                        childAt2.setLayoutParams(layoutParams);
                        if (alaLiveGiftUIInfo != null) {
                            b(alaLiveGiftUIInfo);
                            c(alaLiveGiftUIInfo);
                            if (alaLiveGiftUIInfo.getBgColor() != 0) {
                                this.mContentLayout.setBackgroundColor(0);
                                linearLayout.getChildAt(1).setBackgroundColor(alaLiveGiftUIInfo.getBgColor());
                            }
                        }
                    }
                }
            }
        }
    }
}

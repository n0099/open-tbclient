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
import com.baidu.live.gift.k;
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
import com.baidu.live.tieba.view.fresco.SimpleDraweeView;
import com.baidu.live.utils.i;
import com.baidu.live.utils.q;
import com.baidu.live.view.ScrollEnableViewPager;
import com.baidu.live.view.input.AlaLiveInputEditView;
import com.baidu.live.view.input.b;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.util.Locale;
/* loaded from: classes4.dex */
public class AlaGiftTabActivity extends BaseFragmentActivity implements View.OnTouchListener, AlaGiftTabView.a, b.a {
    private View aYP;
    private GiftPanelTabView aYQ;
    private NobleGiftEntryView aYR;
    private ScrollEnableViewPager aYS;
    private FrameLayout aYT;
    private AlaLiveInputEditView aYU;
    private GiftPanelDrawContainerView aYV;
    private TextView aYW;
    private ViewTreeObserver.OnGlobalLayoutListener aYX;
    private int aYY;
    private int aYZ;
    private com.baidu.live.gift.panel.b aZe;
    private Runnable aZf;
    private Runnable aZg;
    private SupportXFragment[] aZh;
    private ViewGroup mContentLayout;
    private boolean mIsKeyboardOpen;
    private View mRootView;
    private boolean aZa = false;
    private boolean aVc = false;
    private boolean aZb = false;
    private boolean aZc = false;
    private boolean aZd = true;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(true);
        super.onCreate(bundle);
        if (!isFinishing()) {
            String str = Build.DISPLAY;
            if (str != null && str.contains("Flyme")) {
                getWindow().setBackgroundDrawable(new ColorDrawable(getResources().getColor(a.c.sdk_transparent)));
            }
            HY();
            initView();
            this.aZe.a(this, this);
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
        this.aYX = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                AlaGiftTabActivity.this.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(AlaGiftTabActivity.this.getPageContext().getPageActivity());
                int[] screenDimensions = BdUtilHelper.getScreenDimensions(AlaGiftTabActivity.this.getPageContext().getPageActivity());
                boolean z = AlaGiftTabActivity.this.aYY != rect.bottom;
                AlaGiftTabActivity.this.aYY = rect.bottom;
                if (screenDimensions[1] - rect.bottom > screenDimensions[1] / 4 && (!AlaGiftTabActivity.this.mIsKeyboardOpen || z)) {
                    AlaGiftTabActivity.this.mIsKeyboardOpen = true;
                    AlaGiftTabActivity.this.onKeyboardVisibilityChanged(true);
                } else if (screenDimensions[1] - rect.height() <= statusBarHeight && AlaGiftTabActivity.this.mIsKeyboardOpen) {
                    AlaGiftTabActivity.this.mIsKeyboardOpen = false;
                    AlaGiftTabActivity.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.aYX);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.aYU != null && this.aYU.getVisibility() == 0) {
                AsyncTask.execute(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.5
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            new Instrumentation().sendKeyDownUpSync(4);
                        } catch (Exception e) {
                            AlaGiftTabActivity.this.aYU.post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.5.1
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
            int dimensionPixelSize = rect.bottom - getResources().getDimensionPixelSize(a.d.sdk_ds120);
            int statusBarHeight = !UtilHelper.canUseStyleImmersiveSticky() ? dimensionPixelSize - UtilHelper.getStatusBarHeight() : dimensionPixelSize;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aYU.getLayoutParams();
            layoutParams.topMargin = statusBarHeight;
            this.aYU.setLayoutParams(layoutParams);
            if (!this.aZd) {
                this.aYU.setVisibility(0);
                return;
            }
            return;
        }
        if (this.aZh != null) {
            for (SupportXFragment supportXFragment : this.aZh) {
                if ((supportXFragment instanceof com.baidu.live.gift.panel.c) && ((com.baidu.live.gift.panel.c) supportXFragment).bev != null) {
                    ((com.baidu.live.gift.panel.c) supportXFragment).bev.Iu();
                }
            }
        }
        Ii();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.aYU != null && this.aYU.getVisibility() == 0) {
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
        this.aZh = supportXFragmentArr;
        if (this.aYT != null) {
            this.aYT.removeAllViews();
            if (this.aZh != null) {
                for (SupportXFragment supportXFragment : this.aZh) {
                    supportXFragment.onCreateView(null, null, null);
                    supportXFragment.onActivityCreated(null);
                    this.aYT.addView(supportXFragment.getView(), new ViewGroup.LayoutParams(-1, -1));
                }
            }
        }
        eh(i);
    }

    @Override // com.baidu.live.gift.container.AlaGiftTabView.a
    public void c(boolean z, int i) {
        if (this.aYU != null && this.aYU.getEditView() != null) {
            if (z) {
                this.aYU.setMaxText(String.valueOf(i));
                this.aYU.setHintText(String.format(Locale.getDefault(), getString(a.h.ala_send_gift_count_hint), Integer.valueOf(i)));
                this.aYU.Ng();
                this.aYU.getEditView().setFocusable(true);
                this.aYU.getEditView().setFocusableInTouchMode(true);
                this.aYU.getEditView().postDelayed(Ig(), 100L);
                return;
            }
            Ii();
            this.aYU.getEditView().post(Ih());
        }
    }

    @Override // com.baidu.live.gift.container.AlaGiftTabView.a
    public void f(boolean z, String str) {
        if (this.aYV != null) {
            if (z) {
                if (Build.VERSION.SDK_INT != 26) {
                    setRequestedOrientation(1);
                    this.aZa = true;
                }
                this.aYV.setVisibility(0);
            } else {
                if (Build.VERSION.SDK_INT != 26 && this.aZa) {
                    setRequestedOrientation(3);
                    this.aZa = false;
                }
                this.aYV.setVisibility(8);
            }
            this.aYV.h(z, str);
        }
    }

    @Override // com.baidu.live.gift.container.AlaGiftTabView.a
    public void a(g gVar) {
        if (this.aYV != null) {
            this.aYV.setGiftItem(gVar);
        }
    }

    @Override // com.baidu.live.gift.panel.b.a
    public k HV() {
        if (this.aYV != null) {
            return this.aYV.getGraffitiData();
        }
        return null;
    }

    @Override // com.baidu.live.gift.panel.b.a
    public void a(NobleUserInfo.a aVar) {
        if (this.aYR != null) {
            this.aYR.setData(aVar);
        }
    }

    @Override // com.baidu.live.gift.container.AlaGiftTabView.a
    public void at(String str, String str2) {
        if (this.aYW != null) {
            if (!TextUtils.isEmpty(str)) {
                this.aYW.setText(str);
                this.aYW.setTag(str2);
                this.aYW.setVisibility(0);
                return;
            }
            this.aYW.setText("");
            this.aYW.setVisibility(8);
        }
    }

    @Override // com.baidu.live.gift.container.AlaGiftTabView.a
    public void q(int i, String str) {
        if (this.aZe != null) {
            this.aZe.q(i, str);
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
        getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.aYX);
        if (this.aZe != null) {
            this.aZe.release();
        }
        if (this.aZh != null) {
            for (SupportXFragment supportXFragment : this.aZh) {
                supportXFragment.onDestroyView();
                supportXFragment.onDestroy();
            }
        }
        if (this.aYQ != null) {
            this.aYQ.onDestroy();
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (!this.aVc) {
            this.mRootView.setVisibility(0);
            HW();
            this.aVc = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.aZd = false;
        if (this.aZh != null) {
            for (SupportXFragment supportXFragment : this.aZh) {
                supportXFragment.onResume();
            }
        }
        if (this.aZe != null) {
            this.aZe.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.aZd = true;
        if (this.aZh != null) {
            for (SupportXFragment supportXFragment : this.aZh) {
                supportXFragment.onPause();
            }
        }
        if (this.aZe != null) {
            this.aZe.onPause();
        }
    }

    private void HW() {
        Animation loadAnimation;
        this.aZb = true;
        if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0197a.sdk_in_from_right);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0197a.sdk_in_from_bottom);
        }
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                AlaGiftTabActivity.this.aZb = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        if (this.mRootView != null) {
            this.mRootView.startAnimation(loadAnimation);
        }
    }

    private void HX() {
        Animation loadAnimation;
        if (!this.aZc && !this.aZb) {
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0197a.sdk_out_to_right);
            } else {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0197a.sdk_out_to_bottom);
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
            this.aZc = true;
            if (this.mRootView != null) {
                this.mRootView.startAnimation(loadAnimation);
            }
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        HX();
    }

    private void HY() {
        this.aZe = new com.baidu.live.gift.panel.b(getPageContext());
        this.aZe.init(getIntent());
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this).inflate(a.g.live_gift_activity_panel, (ViewGroup) null);
        setContentView(this.mRootView);
        boolean z = UtilHelper.getRealScreenOrientation(getActivity()) == 2;
        if (z) {
            i.ae(this.mRootView);
            q.e(getActivity(), false);
        }
        addGlobalLayoutListener();
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        this.aZb = false;
        this.mRootView.setVisibility(4);
        HZ();
        bw(z);
        bx(z);
        by(z);
        bz(z);
        bA(z);
        Ia();
        Ib();
        bB(z);
    }

    private void HZ() {
        this.mContentLayout = (ViewGroup) findViewById(a.f.layout_content);
        this.aYP = findViewById(a.f.layout_tab);
        this.aYQ = (GiftPanelTabView) findViewById(a.f.tab);
        this.aYR = (NobleGiftEntryView) findViewById(a.f.noble_entry);
        this.aYS = (ScrollEnableViewPager) findViewById(a.f.vp);
        this.aYT = (FrameLayout) findViewById(a.f.layout_supportx);
        this.aYU = (AlaLiveInputEditView) findViewById(a.f.edit_num);
        this.aYV = (GiftPanelDrawContainerView) findViewById(a.f.container_draw);
        this.aYW = (TextView) findViewById(a.f.gift_toast);
    }

    private void bw(boolean z) {
        this.mContentLayout.setClickable(true);
        if (Build.VERSION.SDK_INT >= 26) {
            this.mContentLayout.setDefaultFocusHighlightEnabled(false);
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(getResources().getColor(a.c.live_gift_panel_primary));
        float dimensionPixelOffset = getResources().getDimensionPixelOffset(a.d.sdk_ds26);
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

    private void bx(boolean z) {
        if (!z) {
            ViewGroup.LayoutParams layoutParams = this.aYP.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                ((FrameLayout.LayoutParams) layoutParams).gravity |= 80;
                ((FrameLayout.LayoutParams) layoutParams).bottomMargin = Ic();
                this.aYP.setLayoutParams(layoutParams);
            }
        }
        this.aYQ.setCallback(new GiftPanelTabView.a() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.8
            @Override // com.baidu.live.gift.widget.panel.GiftPanelTabView.a
            public void ei(int i) {
                AlaGiftTabActivity.this.eh(i);
            }
        });
    }

    private void by(boolean z) {
        if (this.aZe == null || !this.aZe.JA()) {
            this.aYR.setVisibility(8);
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.aYR.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            if (z) {
                ((FrameLayout.LayoutParams) layoutParams).topMargin = Id();
            } else {
                ((FrameLayout.LayoutParams) layoutParams).gravity = 80;
                ((FrameLayout.LayoutParams) layoutParams).bottomMargin = getDataPagerHeight() + Ie();
            }
            this.aYR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AlaGiftTabActivity.this.aZe != null) {
                        AlaGiftTabActivity.this.aZe.JB();
                    }
                }
            });
        }
    }

    private void bz(boolean z) {
        this.aYS.setScrollEnabled(false);
        ViewGroup.LayoutParams layoutParams = this.aYS.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.height = -1;
            } else {
                layoutParams.height = Id() + Ic();
            }
            this.aYS.setLayoutParams(layoutParams);
        }
    }

    private void bA(boolean z) {
        ViewGroup.LayoutParams layoutParams = this.aYT.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.height = -1;
            } else {
                layoutParams.height = getResources().getDimensionPixelOffset(a.d.sdk_ds116) + Ic();
            }
            this.aYT.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.live.gift.container.AlaGiftTabActivity$10  reason: invalid class name */
    /* loaded from: classes4.dex */
    public class AnonymousClass10 implements b.a {
        AnonymousClass10() {
        }

        @Override // com.baidu.live.view.input.b.a
        public void hn(String str) {
            AsyncTask.execute(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.10.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        new Instrumentation().sendKeyDownUpSync(4);
                    } catch (Exception e) {
                        AlaGiftTabActivity.this.aYU.post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.10.1.1
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
            com.baidu.live.gift.panel.c If = AlaGiftTabActivity.this.If();
            if (If != null && If.bev != null) {
                If.bev.hq(str);
            }
        }
    }

    private void Ia() {
        this.aYU.setEditViewConfirmCallBack(new AnonymousClass10());
    }

    private void Ib() {
        this.aYV.setCallback(new GiftPanelDrawContainerView.a() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.11
            @Override // com.baidu.live.gift.widget.panel.GiftPanelDrawContainerView.a
            public void ej(int i) {
                com.baidu.live.gift.panel.c If = AlaGiftTabActivity.this.If();
                if (If != null && If.bev != null) {
                    If.bev.er(i);
                }
            }

            @Override // com.baidu.live.gift.widget.panel.GiftPanelDrawContainerView.a
            public void Ij() {
                AlaGiftTabActivity.this.finish();
            }
        });
    }

    private void bB(boolean z) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(BdUtilHelper.dip2px(this, 5.0f));
        gradientDrawable.setColor(-1560281088);
        this.aYW.setBackgroundDrawable(gradientDrawable);
        if (z) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aYW.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            layoutParams.addRule(5, this.mContentLayout.getId());
            layoutParams.addRule(2, 0);
            layoutParams.rightMargin = 0;
            layoutParams.addRule(12);
            layoutParams.bottomMargin = BdUtilHelper.getDimens(this, a.d.sdk_ds90);
            this.aYW.setLayoutParams(layoutParams);
            this.aYW.setBackgroundColor(-1560281088);
            this.aYW.setGravity(17);
            int dimens = BdUtilHelper.getDimens(this, a.d.sdk_ds12);
            this.aYW.setPadding(dimens, dimens, dimens, dimens);
        }
        this.aYW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaGiftTabActivity.this.aZe != null) {
                    Object tag = AlaGiftTabActivity.this.aYW.getTag();
                    if ((tag instanceof String) && !TextUtils.isEmpty((String) tag)) {
                        AlaGiftTabActivity.this.aZe.hA((String) tag);
                    }
                }
            }
        });
    }

    private int Ic() {
        if (this.aYZ <= 0) {
            this.aYZ = getDataPagerHeight();
            if (this.aZe != null && this.aZe.JA()) {
                this.aYZ += Ie() + getResources().getDimensionPixelOffset(a.d.sdk_ds72);
            }
        }
        return this.aYZ;
    }

    private int getDataPagerHeight() {
        return (getResources().getDimensionPixelOffset(a.d.sdk_ds192) * 2) + getResources().getDimensionPixelOffset(a.d.sdk_ds4) + getResources().getDimensionPixelOffset(a.d.sdk_ds12) + getResources().getDimensionPixelOffset(a.d.sdk_ds116);
    }

    private int Id() {
        return getResources().getDimensionPixelOffset(a.d.sdk_ds116);
    }

    private int Ie() {
        return getResources().getDimensionPixelOffset(a.d.sdk_ds24);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.live.gift.panel.c If() {
        if (this.aZh == null || this.aYQ == null || this.aZh.length <= this.aYQ.getSelect() || !(this.aZh[this.aYQ.getSelect()] instanceof com.baidu.live.gift.panel.c)) {
            return null;
        }
        return (com.baidu.live.gift.panel.c) this.aZh[this.aYQ.getSelect()];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eh(int i) {
        if (this.aYQ != null) {
            this.aYQ.setSelect(i);
            AlaGiftTabView.page = i;
        }
        if (this.aZh != null) {
            int i2 = 0;
            while (i2 < this.aZh.length) {
                this.aZh[i2].setUserVisibleHint(i2 == i);
                if ((this.aZh[i2] instanceof com.baidu.live.gift.panel.c) && ((com.baidu.live.gift.panel.c) this.aZh[i2]).bev != null) {
                    ((com.baidu.live.gift.panel.c) this.aZh[i2]).bev.bE(i2 == i);
                }
                if (this.aZh[i2].getView() != null) {
                    this.aZh[i2].getView().setVisibility(i2 == i ? 0 : 8);
                }
                i2++;
            }
        }
    }

    private Runnable Ig() {
        if (this.aZf == null) {
            this.aZf = new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.2
                @Override // java.lang.Runnable
                public void run() {
                    if (AlaGiftTabActivity.this.aYU != null && AlaGiftTabActivity.this.aYU.getEditView() != null) {
                        AlaGiftTabActivity.this.aYU.getEditView().requestFocus();
                        BdUtilHelper.showSoftKeyPad(AlaGiftTabActivity.this, AlaGiftTabActivity.this.aYU.getEditView());
                    }
                }
            };
        }
        return this.aZf;
    }

    private Runnable Ih() {
        if (this.aZg == null) {
            this.aZg = new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.3
                @Override // java.lang.Runnable
                public void run() {
                    if (AlaGiftTabActivity.this.aYU != null && AlaGiftTabActivity.this.aYU.getEditView() != null) {
                        BdUtilHelper.hideSoftKeyPad(AlaGiftTabActivity.this, AlaGiftTabActivity.this.aYU.getEditView());
                    }
                }
            };
        }
        return this.aZg;
    }

    private void Ii() {
        if (this.aYU != null) {
            this.aYU.setVisibility(8);
        }
    }

    private void b(AlaLiveGiftUIInfo alaLiveGiftUIInfo) {
        if (alaLiveGiftUIInfo != null && this.aYQ != null) {
            this.aYQ.setColors(alaLiveGiftUIInfo.getTabBgSelectedColor(), alaLiveGiftUIInfo.getTabBgUnSelectedColor(), alaLiveGiftUIInfo.getTabTextSelectedColor(), alaLiveGiftUIInfo.getTabTextUnSelectedColor());
        }
    }

    private void c(AlaLiveGiftUIInfo alaLiveGiftUIInfo) {
        SupportXFragment[] supportXFragmentArr;
        if (alaLiveGiftUIInfo != null && alaLiveGiftUIInfo.getCategoryTextSelectedColor() != 0 && (this.aYS.getAdapter() instanceof GiftPanelFragmentPagerAdapter) && ((GiftPanelFragmentPagerAdapter) this.aYS.getAdapter()).JJ() != null && this.aZh != null) {
            for (SupportXFragment supportXFragment : this.aZh) {
                if (supportXFragment instanceof com.baidu.live.gift.panel.c) {
                    ((com.baidu.live.gift.panel.c) supportXFragment).ek(alaLiveGiftUIInfo.getCategoryTextSelectedColor());
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
            linearLayout.addView(view, new LinearLayout.LayoutParams(-1, Ic()));
            this.mContentLayout.addView(linearLayout, 0);
            simpleDraweeView.setController(com.facebook.drawee.a.a.c.ekS().c(simpleDraweeView.getController()).bn(ImageRequestBuilder.ad(Uri.parse(alaLiveGiftUIInfo.getVerticalBgUrl())).a(com.facebook.imagepipeline.common.e.enX()).a(com.facebook.imagepipeline.common.b.enM().c(Bitmap.Config.RGB_565).enU()).erY()).Af(true).c(new com.facebook.drawee.controller.c<com.facebook.imagepipeline.g.f>() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.4
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
                public void hm(String str) {
                }
            }).elJ());
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

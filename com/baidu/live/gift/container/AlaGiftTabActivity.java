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
import com.baidu.live.gift.widget.panel.GiftPanelCountBadgeView;
import com.baidu.live.gift.widget.panel.GiftPanelDrawContainerView;
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
import com.baidu.live.utils.r;
import com.baidu.live.view.RoundRectFrameLayout;
import com.baidu.live.view.ScrollEnableViewPager;
import com.baidu.live.view.input.AlaLiveInputEditView;
import com.baidu.live.view.input.c;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.util.Locale;
/* loaded from: classes10.dex */
public class AlaGiftTabActivity extends BaseFragmentActivity implements View.OnTouchListener, AlaGiftTabView.a, b.a {
    private int aXD;
    private com.baidu.live.gift.panel.b aXE;
    private Runnable aXF;
    private Runnable aXG;
    private SupportXFragment[] aXH;
    private RoundRectFrameLayout aXm;
    private View aXn;
    private TextView aXo;
    private GiftPanelCountBadgeView aXp;
    private NobleGiftEntryView aXq;
    private ScrollEnableViewPager aXr;
    private FrameLayout aXs;
    private AlaLiveInputEditView aXt;
    private GiftPanelDrawContainerView aXu;
    private TextView aXv;
    private ViewTreeObserver.OnGlobalLayoutListener aXw;
    private int aXx;
    private int aXy;
    private boolean mIsKeyboardOpen;
    private View mRootView;
    private boolean aXz = false;
    private boolean aTo = false;
    private boolean aXA = false;
    private boolean aXB = false;
    private boolean aXC = true;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(true);
        super.onCreate(bundle);
        if (!isFinishing()) {
            String str = Build.DISPLAY;
            if (str != null && str.contains("Flyme")) {
                getWindow().setBackgroundDrawable(new ColorDrawable(getResources().getColor(a.c.sdk_transparent)));
            }
            EN();
            initView();
            this.aXE.a(this, this);
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

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        finish();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    protected void addGlobalLayoutListener() {
        this.aXw = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                AlaGiftTabActivity.this.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(AlaGiftTabActivity.this.getPageContext().getPageActivity());
                int[] screenDimensions = BdUtilHelper.getScreenDimensions(AlaGiftTabActivity.this.getPageContext().getPageActivity());
                boolean z = AlaGiftTabActivity.this.aXx != rect.bottom;
                AlaGiftTabActivity.this.aXx = rect.bottom;
                if (screenDimensions[1] - rect.bottom > screenDimensions[1] / 4 && (!AlaGiftTabActivity.this.mIsKeyboardOpen || z)) {
                    AlaGiftTabActivity.this.mIsKeyboardOpen = true;
                    AlaGiftTabActivity.this.onKeyboardVisibilityChanged(true);
                } else if (screenDimensions[1] - rect.height() <= statusBarHeight && AlaGiftTabActivity.this.mIsKeyboardOpen) {
                    AlaGiftTabActivity.this.mIsKeyboardOpen = false;
                    AlaGiftTabActivity.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.aXw);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.aXt != null && this.aXt.getVisibility() == 0) {
                AsyncTask.execute(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.5
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            new Instrumentation().sendKeyDownUpSync(4);
                        } catch (Exception e) {
                            AlaGiftTabActivity.this.aXt.post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.5.1
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
            } else if (view == this.aXm) {
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
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aXt.getLayoutParams();
            layoutParams.topMargin = statusBarHeight;
            this.aXt.setLayoutParams(layoutParams);
            if (!this.aXC) {
                this.aXt.setVisibility(0);
                return;
            }
            return;
        }
        if (this.aXH != null) {
            for (SupportXFragment supportXFragment : this.aXH) {
                if ((supportXFragment instanceof com.baidu.live.gift.panel.c) && ((com.baidu.live.gift.panel.c) supportXFragment).bdy != null) {
                    ((com.baidu.live.gift.panel.c) supportXFragment).bdy.Fj();
                }
            }
        }
        EX();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.aXt != null && this.aXt.getVisibility() == 0) {
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
                if (this.aXm != null && alaLiveGiftUIInfo.getBgColor() != 0) {
                    Drawable background = this.aXm.getBackground();
                    if (background instanceof GradientDrawable) {
                        ((GradientDrawable) background).setColor(alaLiveGiftUIInfo.getBgColor());
                        this.aXm.setBackgroundDrawable(background);
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
        this.aXH = supportXFragmentArr;
        if (this.aXs != null) {
            this.aXs.removeAllViews();
            if (this.aXH != null) {
                for (SupportXFragment supportXFragment : this.aXH) {
                    supportXFragment.onCreateView(null, null, null);
                    supportXFragment.onActivityCreated(null);
                    this.aXs.addView(supportXFragment.getView(), new ViewGroup.LayoutParams(-1, -1));
                }
            }
        }
        cQ(i);
    }

    @Override // com.baidu.live.gift.container.AlaGiftTabView.a
    public void EJ() {
        cQ(0);
    }

    @Override // com.baidu.live.gift.container.AlaGiftTabView.a
    public void cP(int i) {
        if (this.aXp != null) {
            if (EU() instanceof com.baidu.live.gift.panel.e) {
                com.baidu.live.d.xf().putInt("gift_package_list_flag", 0);
                i = 0;
            }
            if (i > 0) {
                this.aXp.setCount(i);
                this.aXp.setVisibility(0);
                return;
            }
            this.aXp.setVisibility(4);
        }
    }

    @Override // com.baidu.live.gift.container.AlaGiftTabView.a
    public void c(boolean z, int i) {
        if (this.aXt != null && this.aXt.getEditView() != null) {
            if (z) {
                this.aXt.setMaxText(String.valueOf(i));
                this.aXt.setHintText(String.format(Locale.getDefault(), getString(a.h.ala_send_gift_count_hint), Integer.valueOf(i)));
                this.aXt.KC();
                this.aXt.getEditView().setFocusable(true);
                this.aXt.getEditView().setFocusableInTouchMode(true);
                this.aXt.getEditView().postDelayed(EV(), 100L);
                return;
            }
            EX();
            this.aXt.getEditView().post(EW());
        }
    }

    @Override // com.baidu.live.gift.container.AlaGiftTabView.a
    public void f(boolean z, String str) {
        if (this.aXu != null) {
            if (z) {
                if (Build.VERSION.SDK_INT != 26) {
                    setRequestedOrientation(1);
                    this.aXz = true;
                }
                this.aXu.setVisibility(0);
            } else {
                if (Build.VERSION.SDK_INT != 26 && this.aXz) {
                    setRequestedOrientation(3);
                    this.aXz = false;
                }
                this.aXu.setVisibility(8);
            }
            this.aXu.h(z, str);
        }
    }

    @Override // com.baidu.live.gift.container.AlaGiftTabView.a
    public void a(g gVar) {
        if (this.aXu != null) {
            this.aXu.setGiftItem(gVar);
        }
    }

    @Override // com.baidu.live.gift.panel.b.a
    public k EK() {
        if (this.aXu != null) {
            return this.aXu.getGraffitiData();
        }
        return null;
    }

    @Override // com.baidu.live.gift.panel.b.a
    public void a(NobleUserInfo.a aVar) {
        if (this.aXq != null) {
            this.aXq.setData(aVar);
        }
    }

    @Override // com.baidu.live.gift.container.AlaGiftTabView.a
    public void g(String str, String str2, boolean z) {
        int dimensionPixelOffset;
        if (this.aXv != null) {
            if (TextUtils.isEmpty(str)) {
                this.aXv.setText("");
                this.aXv.setVisibility(8);
                return;
            }
            Drawable background = this.aXv.getBackground();
            if (background instanceof GradientDrawable) {
                if (z) {
                    if (Build.VERSION.SDK_INT >= 16) {
                        ((GradientDrawable) background).setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
                        ((GradientDrawable) background).setColors(new int[]{-7995264, -10157941});
                    } else {
                        ((GradientDrawable) background).setColor(-7995264);
                    }
                } else if (Build.VERSION.SDK_INT >= 16) {
                    ((GradientDrawable) background).setColors(new int[]{-1560281088, -1560281088});
                } else {
                    ((GradientDrawable) background).setColor(-1560281088);
                }
                this.aXv.setBackgroundDrawable(background);
            }
            this.aXv.setText(str);
            this.aXv.setTag(str2);
            this.aXv.setVisibility(0);
            ViewGroup.LayoutParams layoutParams = this.aXv.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                if (UtilHelper.getRealScreenOrientation(this) == 2) {
                    if (z) {
                        dimensionPixelOffset = getResources().getDimensionPixelOffset(a.d.sdk_ds176);
                    } else {
                        dimensionPixelOffset = getResources().getDimensionPixelOffset(a.d.sdk_ds90);
                    }
                } else {
                    dimensionPixelOffset = getResources().getDimensionPixelOffset(a.d.sdk_ds10);
                }
                if (((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin != dimensionPixelOffset) {
                    ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = dimensionPixelOffset;
                    this.aXv.setLayoutParams(layoutParams);
                }
            }
        }
    }

    @Override // com.baidu.live.gift.container.AlaGiftTabView.a
    public void r(int i, String str) {
        if (this.aXE != null) {
            this.aXE.r(i, str);
        }
    }

    @Override // com.baidu.live.gift.panel.b.a
    public void onClose() {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        SupportXFragment[] supportXFragmentArr;
        super.onDestroy();
        getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.aXw);
        if (this.aXE != null) {
            this.aXE.release();
        }
        if (this.aXH != null) {
            for (SupportXFragment supportXFragment : this.aXH) {
                supportXFragment.onDestroyView();
                supportXFragment.onDestroy();
            }
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (!this.aTo) {
            this.mRootView.setVisibility(0);
            EL();
            this.aTo = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.aXC = false;
        if (this.aXH != null) {
            for (SupportXFragment supportXFragment : this.aXH) {
                supportXFragment.onResume();
            }
        }
        if (this.aXE != null) {
            this.aXE.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.aXC = true;
        if (this.aXH != null) {
            for (SupportXFragment supportXFragment : this.aXH) {
                supportXFragment.onPause();
            }
        }
        if (this.aXE != null) {
            this.aXE.onPause();
        }
    }

    private void EL() {
        Animation loadAnimation;
        this.aXA = true;
        if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0194a.sdk_in_from_right);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0194a.sdk_in_from_bottom);
        }
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                AlaGiftTabActivity.this.aXA = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        if (this.mRootView != null) {
            this.mRootView.startAnimation(loadAnimation);
        }
    }

    private void EM() {
        Animation loadAnimation;
        if (!this.aXB && !this.aXA) {
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0194a.sdk_out_to_right);
            } else {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0194a.sdk_out_to_bottom);
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
            this.aXB = true;
            if (this.mRootView != null) {
                this.mRootView.startAnimation(loadAnimation);
            }
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        EM();
    }

    private void EN() {
        this.aXE = new com.baidu.live.gift.panel.b(getPageContext());
        this.aXE.init(getIntent());
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this).inflate(a.g.live_gift_activity_panel, (ViewGroup) null);
        setContentView(this.mRootView);
        boolean z = UtilHelper.getRealScreenOrientation(getActivity()) == 2;
        if (z) {
            i.ae(this.mRootView);
            r.e(getActivity(), false);
        }
        addGlobalLayoutListener();
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        this.aXA = false;
        this.mRootView.setVisibility(4);
        EO();
        bB(z);
        bC(z);
        bD(z);
        bE(z);
        bF(z);
        EP();
        EQ();
        bG(z);
    }

    private void EO() {
        this.aXm = (RoundRectFrameLayout) findViewById(a.f.layout_content);
        this.aXn = findViewById(a.f.layout_tab);
        this.aXo = (TextView) findViewById(a.f.tv_tab_text);
        this.aXp = (GiftPanelCountBadgeView) findViewById(a.f.layout_tab_badge_count);
        this.aXq = (NobleGiftEntryView) findViewById(a.f.noble_entry);
        this.aXr = (ScrollEnableViewPager) findViewById(a.f.vp);
        this.aXs = (FrameLayout) findViewById(a.f.layout_supportx);
        this.aXt = (AlaLiveInputEditView) findViewById(a.f.edit_num);
        this.aXu = (GiftPanelDrawContainerView) findViewById(a.f.container_draw);
        this.aXv = (TextView) findViewById(a.f.gift_toast);
    }

    private void bB(boolean z) {
        this.aXm.setClickable(true);
        if (Build.VERSION.SDK_INT >= 26) {
            this.aXm.setDefaultFocusHighlightEnabled(false);
        }
        this.aXm.setBackgroundColor(getResources().getColor(a.c.live_gift_panel_primary));
        float dimensionPixelOffset = getResources().getDimensionPixelOffset(a.d.sdk_ds26);
        if (z) {
            this.aXm.setCornerRadius(dimensionPixelOffset, 0.0f, 0.0f, dimensionPixelOffset);
        } else {
            this.aXm.setCornerRadius(dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f);
        }
        if (z) {
            ViewGroup.LayoutParams layoutParams = this.aXm.getLayoutParams();
            layoutParams.width = ScreenHelper.getRealScreenHeight(this);
            this.aXm.setLayoutParams(layoutParams);
        }
    }

    private void bC(boolean z) {
        if (!z) {
            ViewGroup.LayoutParams layoutParams = this.aXn.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                ((FrameLayout.LayoutParams) layoutParams).gravity |= 80;
                ((FrameLayout.LayoutParams) layoutParams).bottomMargin = ER();
                this.aXn.setLayoutParams(layoutParams);
            }
        }
        this.aXn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaGiftTabActivity.this.cQ(1);
            }
        });
        this.aXp.setPlusThreshold(99, false);
    }

    private void bD(boolean z) {
        if (this.aXE == null || !this.aXE.Gx()) {
            this.aXq.setVisibility(8);
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.aXq.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            if (z) {
                ((FrameLayout.LayoutParams) layoutParams).topMargin = ES();
            } else {
                ((FrameLayout.LayoutParams) layoutParams).gravity = 80;
                ((FrameLayout.LayoutParams) layoutParams).bottomMargin = getDataPagerHeight() + ET();
            }
            this.aXq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AlaGiftTabActivity.this.aXE != null) {
                        AlaGiftTabActivity.this.aXE.Gy();
                    }
                }
            });
        }
    }

    private void bE(boolean z) {
        this.aXr.setScrollEnabled(false);
        ViewGroup.LayoutParams layoutParams = this.aXr.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.height = -1;
            } else {
                layoutParams.height = ES() + ER();
            }
            this.aXr.setLayoutParams(layoutParams);
        }
    }

    private void bF(boolean z) {
        ViewGroup.LayoutParams layoutParams = this.aXs.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.height = -1;
            } else {
                layoutParams.height = getResources().getDimensionPixelOffset(a.d.sdk_ds116) + ER();
            }
            this.aXs.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.live.gift.container.AlaGiftTabActivity$10  reason: invalid class name */
    /* loaded from: classes10.dex */
    public class AnonymousClass10 implements c.a {
        AnonymousClass10() {
        }

        @Override // com.baidu.live.view.input.c.a
        public void gb(String str) {
            String str2;
            AsyncTask.execute(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.10.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        new Instrumentation().sendKeyDownUpSync(4);
                    } catch (Exception e) {
                        AlaGiftTabActivity.this.aXt.post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.10.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AlaGiftTabActivity.this.c(false, 0);
                            }
                        });
                        e.printStackTrace();
                    }
                }
            });
            int i = JavaTypesHelper.toInt(str, 0);
            if (i <= 0) {
                str2 = "1";
            } else {
                str2 = i + "";
            }
            com.baidu.live.gift.panel.c EU = AlaGiftTabActivity.this.EU();
            if ((!(EU instanceof com.baidu.live.gift.panel.e) || !((com.baidu.live.gift.panel.e) EU).gt(str2)) && EU != null && EU.bdy != null) {
                EU.bdy.ge(str2);
            }
        }
    }

    private void EP() {
        this.aXt.setEditViewConfirmCallBack(new AnonymousClass10());
    }

    private void EQ() {
        this.aXu.setCallback(new GiftPanelDrawContainerView.a() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.11
            @Override // com.baidu.live.gift.widget.panel.GiftPanelDrawContainerView.a
            public void cR(int i) {
                com.baidu.live.gift.panel.c EU = AlaGiftTabActivity.this.EU();
                if (EU != null && EU.bdy != null) {
                    EU.bdy.da(i);
                }
            }

            @Override // com.baidu.live.gift.widget.panel.GiftPanelDrawContainerView.a
            public void EY() {
                AlaGiftTabActivity.this.finish();
            }
        });
    }

    private void bG(boolean z) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(BdUtilHelper.dip2px(this, 5.0f));
        this.aXv.setBackgroundDrawable(gradientDrawable);
        if (z) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aXv.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            layoutParams.addRule(5, this.aXm.getId());
            layoutParams.addRule(2, 0);
            layoutParams.rightMargin = 0;
            layoutParams.addRule(12);
            this.aXv.setLayoutParams(layoutParams);
            this.aXv.setGravity(17);
            int dimens = BdUtilHelper.getDimens(this, a.d.sdk_ds12);
            this.aXv.setPadding(dimens, dimens, dimens, dimens);
        }
        this.aXv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaGiftTabActivity.this.aXE != null) {
                    Object tag = AlaGiftTabActivity.this.aXv.getTag();
                    if ((tag instanceof String) && !TextUtils.isEmpty((String) tag)) {
                        AlaGiftTabActivity.this.aXE.gr((String) tag);
                    }
                }
            }
        });
    }

    private int ER() {
        if (this.aXy <= 0) {
            this.aXy = getDataPagerHeight();
            if (this.aXE != null && this.aXE.Gx()) {
                this.aXy += ET() + getResources().getDimensionPixelOffset(a.d.sdk_ds72);
            }
        }
        return this.aXy;
    }

    private int getDataPagerHeight() {
        return (getResources().getDimensionPixelOffset(a.d.sdk_ds192) * 2) + getResources().getDimensionPixelOffset(a.d.sdk_ds4) + getResources().getDimensionPixelOffset(a.d.sdk_ds12) + getResources().getDimensionPixelOffset(a.d.sdk_ds116);
    }

    private int ES() {
        return getResources().getDimensionPixelOffset(a.d.sdk_ds116);
    }

    private int ET() {
        return getResources().getDimensionPixelOffset(a.d.sdk_ds24);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.live.gift.panel.c EU() {
        if (this.aXH == null || this.aXH.length <= this.aXD || !(this.aXH[this.aXD] instanceof com.baidu.live.gift.panel.c)) {
            return null;
        }
        return (com.baidu.live.gift.panel.c) this.aXH[this.aXD];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQ(int i) {
        this.aXD = i;
        if (this.aXn != null) {
            this.aXn.setVisibility(i == 1 ? 4 : 0);
            AlaGiftTabView.page = i;
        }
        if (this.aXH != null) {
            int i2 = 0;
            while (i2 < this.aXH.length) {
                this.aXH[i2].setUserVisibleHint(i2 == i);
                if ((this.aXH[i2] instanceof com.baidu.live.gift.panel.c) && ((com.baidu.live.gift.panel.c) this.aXH[i2]).bdy != null) {
                    ((com.baidu.live.gift.panel.c) this.aXH[i2]).bdy.bJ(i2 == i);
                }
                if (this.aXH[i2].getView() != null) {
                    this.aXH[i2].getView().setVisibility(i2 == i ? 0 : 8);
                }
                i2++;
            }
            cP(0);
        }
    }

    private Runnable EV() {
        if (this.aXF == null) {
            this.aXF = new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.2
                @Override // java.lang.Runnable
                public void run() {
                    if (AlaGiftTabActivity.this.aXt != null && AlaGiftTabActivity.this.aXt.getEditView() != null) {
                        AlaGiftTabActivity.this.aXt.getEditView().requestFocus();
                        BdUtilHelper.showSoftKeyPad(AlaGiftTabActivity.this, AlaGiftTabActivity.this.aXt.getEditView());
                    }
                }
            };
        }
        return this.aXF;
    }

    private Runnable EW() {
        if (this.aXG == null) {
            this.aXG = new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.3
                @Override // java.lang.Runnable
                public void run() {
                    if (AlaGiftTabActivity.this.aXt != null && AlaGiftTabActivity.this.aXt.getEditView() != null) {
                        BdUtilHelper.hideSoftKeyPad(AlaGiftTabActivity.this, AlaGiftTabActivity.this.aXt.getEditView());
                    }
                }
            };
        }
        return this.aXG;
    }

    private void EX() {
        if (this.aXt != null) {
            this.aXt.setVisibility(8);
        }
    }

    private void b(AlaLiveGiftUIInfo alaLiveGiftUIInfo) {
        if (alaLiveGiftUIInfo != null && this.aXo != null) {
            this.aXo.setTextColor(alaLiveGiftUIInfo.getTabTextUnSelectedColor());
        }
    }

    private void c(AlaLiveGiftUIInfo alaLiveGiftUIInfo) {
        SupportXFragment[] supportXFragmentArr;
        if (alaLiveGiftUIInfo != null && alaLiveGiftUIInfo.getCategoryTextSelectedColor() != 0 && (this.aXr.getAdapter() instanceof GiftPanelFragmentPagerAdapter) && ((GiftPanelFragmentPagerAdapter) this.aXr.getAdapter()).GG() != null && this.aXH != null) {
            for (SupportXFragment supportXFragment : this.aXH) {
                if (supportXFragment instanceof com.baidu.live.gift.panel.c) {
                    ((com.baidu.live.gift.panel.c) supportXFragment).cS(alaLiveGiftUIInfo.getCategoryTextSelectedColor());
                }
            }
        }
    }

    private void d(final AlaLiveGiftUIInfo alaLiveGiftUIInfo) {
        if (alaLiveGiftUIInfo != null && !TextUtils.isEmpty(alaLiveGiftUIInfo.getVerticalBgUrl()) && this.aXm != null) {
            LinearLayout linearLayout = new LinearLayout(this.aXm.getContext());
            linearLayout.setBackgroundColor(0);
            linearLayout.setOrientation(1);
            SimpleDraweeView simpleDraweeView = new SimpleDraweeView(linearLayout.getContext());
            simpleDraweeView.setScaleType(ImageView.ScaleType.FIT_XY);
            linearLayout.addView(simpleDraweeView, new LinearLayout.LayoutParams(-1, -1));
            View view = new View(linearLayout.getContext());
            view.setBackgroundColor(0);
            linearLayout.addView(view, new LinearLayout.LayoutParams(-1, ER()));
            this.aXm.addView(linearLayout, 0);
            simpleDraweeView.setController(com.facebook.drawee.a.a.c.eqV().c(simpleDraweeView.getController()).bo(ImageRequestBuilder.ag(Uri.parse(alaLiveGiftUIInfo.getVerticalBgUrl())).a(com.facebook.imagepipeline.common.e.etV()).a(com.facebook.imagepipeline.common.b.etL().e(Bitmap.Config.RGB_565).etT()).exQ()).AT(true).c(new com.facebook.drawee.controller.c<com.facebook.imagepipeline.f.f>() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.4
                @Override // com.facebook.drawee.controller.c
                public void f(String str, Object obj) {
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.facebook.drawee.controller.c
                public void a(String str, com.facebook.imagepipeline.f.f fVar, Animatable animatable) {
                    if (fVar != null) {
                        AlaGiftTabActivity.this.a(alaLiveGiftUIInfo, fVar.getWidth(), fVar.getHeight());
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.facebook.drawee.controller.c
                /* renamed from: a */
                public void g(String str, com.facebook.imagepipeline.f.f fVar) {
                }

                @Override // com.facebook.drawee.controller.c
                public void g(String str, Throwable th) {
                }

                @Override // com.facebook.drawee.controller.c
                public void h(String str, Throwable th) {
                }

                @Override // com.facebook.drawee.controller.c
                public void ga(String str) {
                }
            }).erN());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaLiveGiftUIInfo alaLiveGiftUIInfo, int i, int i2) {
        if (this.aXm != null && i != 0 && i2 != 0) {
            View childAt = this.aXm.getChildAt(0);
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
                                this.aXm.setBackgroundColor(0);
                                linearLayout.getChildAt(1).setBackgroundColor(alaLiveGiftUIInfo.getBgColor());
                            }
                        }
                    }
                }
            }
        }
    }
}

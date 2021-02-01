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
/* loaded from: classes11.dex */
public class AlaGiftTabActivity extends BaseFragmentActivity implements View.OnTouchListener, AlaGiftTabView.a, b.a {
    private AlaLiveInputEditView baA;
    private GiftPanelDrawContainerView baB;
    private TextView baC;
    private ViewTreeObserver.OnGlobalLayoutListener baD;
    private int baE;
    private int baF;
    private int baK;
    private com.baidu.live.gift.panel.b baL;
    private Runnable baM;
    private Runnable baN;
    private SupportXFragment[] baO;
    private RoundRectFrameLayout bat;
    private View bau;
    private TextView bav;
    private GiftPanelCountBadgeView baw;
    private NobleGiftEntryView bax;
    private ScrollEnableViewPager bay;
    private FrameLayout baz;
    private boolean mIsKeyboardOpen;
    private View mRootView;
    private boolean baG = false;
    private boolean aWt = false;
    private boolean baH = false;
    private boolean baI = false;
    private boolean baJ = true;

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
            Gd();
            initView();
            this.baL.a(this, this);
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
        this.baD = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                AlaGiftTabActivity.this.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(AlaGiftTabActivity.this.getPageContext().getPageActivity());
                int[] screenDimensions = BdUtilHelper.getScreenDimensions(AlaGiftTabActivity.this.getPageContext().getPageActivity());
                boolean z = AlaGiftTabActivity.this.baE != rect.bottom;
                AlaGiftTabActivity.this.baE = rect.bottom;
                if (screenDimensions[1] - rect.bottom > screenDimensions[1] / 4 && (!AlaGiftTabActivity.this.mIsKeyboardOpen || z)) {
                    AlaGiftTabActivity.this.mIsKeyboardOpen = true;
                    AlaGiftTabActivity.this.onKeyboardVisibilityChanged(true);
                } else if (screenDimensions[1] - rect.height() <= statusBarHeight && AlaGiftTabActivity.this.mIsKeyboardOpen) {
                    AlaGiftTabActivity.this.mIsKeyboardOpen = false;
                    AlaGiftTabActivity.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.baD);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.baA != null && this.baA.getVisibility() == 0) {
                AsyncTask.execute(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.5
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            new Instrumentation().sendKeyDownUpSync(4);
                        } catch (Exception e) {
                            AlaGiftTabActivity.this.baA.post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.5.1
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
            } else if (view == this.bat) {
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
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.baA.getLayoutParams();
            layoutParams.topMargin = statusBarHeight;
            this.baA.setLayoutParams(layoutParams);
            if (!this.baJ) {
                this.baA.setVisibility(0);
                return;
            }
            return;
        }
        if (this.baO != null) {
            for (SupportXFragment supportXFragment : this.baO) {
                if ((supportXFragment instanceof com.baidu.live.gift.panel.c) && ((com.baidu.live.gift.panel.c) supportXFragment).bgI != null) {
                    ((com.baidu.live.gift.panel.c) supportXFragment).bgI.Gz();
                }
            }
        }
        Gn();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.baA != null && this.baA.getVisibility() == 0) {
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
                if (this.bat != null && alaLiveGiftUIInfo.getBgColor() != 0) {
                    Drawable background = this.bat.getBackground();
                    if (background instanceof GradientDrawable) {
                        ((GradientDrawable) background).setColor(alaLiveGiftUIInfo.getBgColor());
                        this.bat.setBackgroundDrawable(background);
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
        this.baO = supportXFragmentArr;
        if (this.baz != null) {
            this.baz.removeAllViews();
            if (this.baO != null) {
                for (SupportXFragment supportXFragment : this.baO) {
                    supportXFragment.onCreateView(null, null, null);
                    supportXFragment.onActivityCreated(null);
                    this.baz.addView(supportXFragment.getView(), new ViewGroup.LayoutParams(-1, -1));
                }
            }
        }
        cV(i);
    }

    @Override // com.baidu.live.gift.container.AlaGiftTabView.a
    public void FZ() {
        cV(0);
    }

    @Override // com.baidu.live.gift.container.AlaGiftTabView.a
    public void cU(int i) {
        if (this.baw != null) {
            if (Gk() instanceof com.baidu.live.gift.panel.e) {
                com.baidu.live.d.xc().putInt("gift_package_list_flag", 0);
                i = 0;
            }
            if (i > 0) {
                this.baw.setCount(i);
                this.baw.setVisibility(0);
                return;
            }
            this.baw.setVisibility(4);
        }
    }

    @Override // com.baidu.live.gift.container.AlaGiftTabView.a
    public void c(boolean z, int i) {
        if (this.baA != null && this.baA.getEditView() != null) {
            if (z) {
                this.baA.setMaxText(String.valueOf(i));
                this.baA.setHintText(String.format(Locale.getDefault(), getString(a.h.ala_send_gift_count_hint), Integer.valueOf(i)));
                this.baA.Ma();
                this.baA.getEditView().setFocusable(true);
                this.baA.getEditView().setFocusableInTouchMode(true);
                this.baA.getEditView().postDelayed(Gl(), 100L);
                return;
            }
            Gn();
            this.baA.getEditView().post(Gm());
        }
    }

    @Override // com.baidu.live.gift.container.AlaGiftTabView.a
    public void j(boolean z, String str) {
        if (this.baB != null) {
            if (z) {
                if (Build.VERSION.SDK_INT != 26) {
                    setRequestedOrientation(1);
                    this.baG = true;
                }
                this.baB.setVisibility(0);
            } else {
                if (Build.VERSION.SDK_INT != 26 && this.baG) {
                    setRequestedOrientation(3);
                    this.baG = false;
                }
                this.baB.setVisibility(8);
            }
            this.baB.l(z, str);
        }
    }

    @Override // com.baidu.live.gift.container.AlaGiftTabView.a
    public void a(g gVar) {
        if (this.baB != null) {
            this.baB.setGiftItem(gVar);
        }
    }

    @Override // com.baidu.live.gift.panel.b.a
    public k Ga() {
        if (this.baB != null) {
            return this.baB.getGraffitiData();
        }
        return null;
    }

    @Override // com.baidu.live.gift.panel.b.a
    public void a(NobleUserInfo.a aVar) {
        if (this.bax != null) {
            this.bax.setData(aVar);
        }
    }

    @Override // com.baidu.live.gift.container.AlaGiftTabView.a
    public void g(String str, String str2, boolean z) {
        int dimensionPixelOffset;
        if (this.baC != null) {
            if (TextUtils.isEmpty(str)) {
                this.baC.setText("");
                this.baC.setVisibility(8);
                return;
            }
            Drawable background = this.baC.getBackground();
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
                this.baC.setBackgroundDrawable(background);
            }
            this.baC.setText(str);
            this.baC.setTag(str2);
            this.baC.setVisibility(0);
            ViewGroup.LayoutParams layoutParams = this.baC.getLayoutParams();
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
                    this.baC.setLayoutParams(layoutParams);
                }
            }
        }
    }

    @Override // com.baidu.live.gift.container.AlaGiftTabView.a
    public void u(int i, String str) {
        if (this.baL != null) {
            this.baL.u(i, str);
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
        getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.baD);
        if (this.baL != null) {
            this.baL.release();
        }
        if (this.baO != null) {
            for (SupportXFragment supportXFragment : this.baO) {
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
        if (!this.aWt) {
            this.mRootView.setVisibility(0);
            Gb();
            this.aWt = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.baJ = false;
        if (this.baO != null) {
            for (SupportXFragment supportXFragment : this.baO) {
                supportXFragment.onResume();
            }
        }
        if (this.baL != null) {
            this.baL.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.baJ = true;
        if (this.baO != null) {
            for (SupportXFragment supportXFragment : this.baO) {
                supportXFragment.onPause();
            }
        }
        if (this.baL != null) {
            this.baL.onPause();
        }
    }

    private void Gb() {
        Animation loadAnimation;
        this.baH = true;
        if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0195a.sdk_in_from_right);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0195a.sdk_in_from_bottom);
        }
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                AlaGiftTabActivity.this.baH = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        if (this.mRootView != null) {
            this.mRootView.startAnimation(loadAnimation);
        }
    }

    private void Gc() {
        Animation loadAnimation;
        if (!this.baI && !this.baH) {
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0195a.sdk_out_to_right);
            } else {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0195a.sdk_out_to_bottom);
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
            this.baI = true;
            if (this.mRootView != null) {
                this.mRootView.startAnimation(loadAnimation);
            }
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        Gc();
    }

    private void Gd() {
        this.baL = new com.baidu.live.gift.panel.b(getPageContext());
        this.baL.init(getIntent());
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
        this.baH = false;
        this.mRootView.setVisibility(4);
        Ge();
        bG(z);
        bH(z);
        bI(z);
        bJ(z);
        bK(z);
        Gf();
        Gg();
        bL(z);
    }

    private void Ge() {
        this.bat = (RoundRectFrameLayout) findViewById(a.f.layout_content);
        this.bau = findViewById(a.f.layout_tab);
        this.bav = (TextView) findViewById(a.f.tv_tab_text);
        this.baw = (GiftPanelCountBadgeView) findViewById(a.f.layout_tab_badge_count);
        this.bax = (NobleGiftEntryView) findViewById(a.f.noble_entry);
        this.bay = (ScrollEnableViewPager) findViewById(a.f.vp);
        this.baz = (FrameLayout) findViewById(a.f.layout_supportx);
        this.baA = (AlaLiveInputEditView) findViewById(a.f.edit_num);
        this.baB = (GiftPanelDrawContainerView) findViewById(a.f.container_draw);
        this.baC = (TextView) findViewById(a.f.gift_toast);
    }

    private void bG(boolean z) {
        this.bat.setClickable(true);
        if (Build.VERSION.SDK_INT >= 26) {
            this.bat.setDefaultFocusHighlightEnabled(false);
        }
        this.bat.setBackgroundColor(getResources().getColor(a.c.live_gift_panel_primary));
        float dimensionPixelOffset = getResources().getDimensionPixelOffset(a.d.sdk_ds26);
        if (z) {
            this.bat.setCornerRadius(dimensionPixelOffset, 0.0f, 0.0f, dimensionPixelOffset);
        } else {
            this.bat.setCornerRadius(dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f);
        }
        if (z) {
            ViewGroup.LayoutParams layoutParams = this.bat.getLayoutParams();
            layoutParams.width = ScreenHelper.getRealScreenHeight(this);
            this.bat.setLayoutParams(layoutParams);
        }
    }

    private void bH(boolean z) {
        if (!z) {
            ViewGroup.LayoutParams layoutParams = this.bau.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                ((FrameLayout.LayoutParams) layoutParams).gravity |= 80;
                ((FrameLayout.LayoutParams) layoutParams).bottomMargin = Gh();
                this.bau.setLayoutParams(layoutParams);
            }
        }
        this.bau.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaGiftTabActivity.this.cV(1);
            }
        });
        this.baw.setPlusThreshold(99, false);
    }

    private void bI(boolean z) {
        if (this.baL == null || !this.baL.HN()) {
            this.bax.setVisibility(8);
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.bax.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            if (z) {
                ((FrameLayout.LayoutParams) layoutParams).topMargin = Gi();
            } else {
                ((FrameLayout.LayoutParams) layoutParams).gravity = 80;
                ((FrameLayout.LayoutParams) layoutParams).bottomMargin = getDataPagerHeight() + Gj();
            }
            this.bax.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AlaGiftTabActivity.this.baL != null) {
                        AlaGiftTabActivity.this.baL.HO();
                    }
                }
            });
        }
    }

    private void bJ(boolean z) {
        this.bay.setScrollEnabled(false);
        ViewGroup.LayoutParams layoutParams = this.bay.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.height = -1;
            } else {
                layoutParams.height = Gi() + Gh();
            }
            this.bay.setLayoutParams(layoutParams);
        }
    }

    private void bK(boolean z) {
        ViewGroup.LayoutParams layoutParams = this.baz.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.height = -1;
            } else {
                layoutParams.height = getResources().getDimensionPixelOffset(a.d.sdk_ds116) + Gh();
            }
            this.baz.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.live.gift.container.AlaGiftTabActivity$10  reason: invalid class name */
    /* loaded from: classes11.dex */
    public class AnonymousClass10 implements c.a {
        AnonymousClass10() {
        }

        @Override // com.baidu.live.view.input.c.a
        public void gz(String str) {
            String str2;
            AsyncTask.execute(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.10.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        new Instrumentation().sendKeyDownUpSync(4);
                    } catch (Exception e) {
                        AlaGiftTabActivity.this.baA.post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.10.1.1
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
            com.baidu.live.gift.panel.c Gk = AlaGiftTabActivity.this.Gk();
            if ((!(Gk instanceof com.baidu.live.gift.panel.e) || !((com.baidu.live.gift.panel.e) Gk).gQ(str2)) && Gk != null && Gk.bgI != null) {
                Gk.bgI.gC(str2);
            }
        }
    }

    private void Gf() {
        this.baA.setEditViewConfirmCallBack(new AnonymousClass10());
    }

    private void Gg() {
        this.baB.setCallback(new GiftPanelDrawContainerView.a() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.11
            @Override // com.baidu.live.gift.widget.panel.GiftPanelDrawContainerView.a
            public void cW(int i) {
                com.baidu.live.gift.panel.c Gk = AlaGiftTabActivity.this.Gk();
                if (Gk != null && Gk.bgI != null) {
                    Gk.bgI.df(i);
                }
            }

            @Override // com.baidu.live.gift.widget.panel.GiftPanelDrawContainerView.a
            public void Go() {
                AlaGiftTabActivity.this.finish();
            }
        });
    }

    private void bL(boolean z) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(BdUtilHelper.dip2px(this, 5.0f));
        this.baC.setBackgroundDrawable(gradientDrawable);
        if (z) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.baC.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            layoutParams.addRule(5, this.bat.getId());
            layoutParams.addRule(2, 0);
            layoutParams.rightMargin = 0;
            layoutParams.addRule(12);
            this.baC.setLayoutParams(layoutParams);
            this.baC.setGravity(17);
            int dimens = BdUtilHelper.getDimens(this, a.d.sdk_ds12);
            this.baC.setPadding(dimens, dimens, dimens, dimens);
        }
        this.baC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaGiftTabActivity.this.baL != null) {
                    Object tag = AlaGiftTabActivity.this.baC.getTag();
                    if ((tag instanceof String) && !TextUtils.isEmpty((String) tag)) {
                        AlaGiftTabActivity.this.baL.gP((String) tag);
                    }
                }
            }
        });
    }

    private int Gh() {
        if (this.baF <= 0) {
            this.baF = getDataPagerHeight();
            if (this.baL != null && this.baL.HN()) {
                this.baF += Gj() + getResources().getDimensionPixelOffset(a.d.sdk_ds72);
            }
        }
        return this.baF;
    }

    private int getDataPagerHeight() {
        return (getResources().getDimensionPixelOffset(a.d.sdk_ds192) * 2) + getResources().getDimensionPixelOffset(a.d.sdk_ds4) + getResources().getDimensionPixelOffset(a.d.sdk_ds12) + getResources().getDimensionPixelOffset(a.d.sdk_ds116);
    }

    private int Gi() {
        return getResources().getDimensionPixelOffset(a.d.sdk_ds116);
    }

    private int Gj() {
        return getResources().getDimensionPixelOffset(a.d.sdk_ds24);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.live.gift.panel.c Gk() {
        if (this.baO == null || this.baO.length <= this.baK || !(this.baO[this.baK] instanceof com.baidu.live.gift.panel.c)) {
            return null;
        }
        return (com.baidu.live.gift.panel.c) this.baO[this.baK];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cV(int i) {
        this.baK = i;
        if (this.bau != null) {
            this.bau.setVisibility(i == 1 ? 4 : 0);
            AlaGiftTabView.page = i;
        }
        if (this.baO != null) {
            int i2 = 0;
            while (i2 < this.baO.length) {
                this.baO[i2].setUserVisibleHint(i2 == i);
                if ((this.baO[i2] instanceof com.baidu.live.gift.panel.c) && ((com.baidu.live.gift.panel.c) this.baO[i2]).bgI != null) {
                    ((com.baidu.live.gift.panel.c) this.baO[i2]).bgI.bO(i2 == i);
                }
                if (this.baO[i2].getView() != null) {
                    this.baO[i2].getView().setVisibility(i2 == i ? 0 : 8);
                }
                i2++;
            }
            cU(0);
        }
    }

    private Runnable Gl() {
        if (this.baM == null) {
            this.baM = new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.2
                @Override // java.lang.Runnable
                public void run() {
                    if (AlaGiftTabActivity.this.baA != null && AlaGiftTabActivity.this.baA.getEditView() != null) {
                        AlaGiftTabActivity.this.baA.getEditView().requestFocus();
                        BdUtilHelper.showSoftKeyPad(AlaGiftTabActivity.this, AlaGiftTabActivity.this.baA.getEditView());
                    }
                }
            };
        }
        return this.baM;
    }

    private Runnable Gm() {
        if (this.baN == null) {
            this.baN = new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.3
                @Override // java.lang.Runnable
                public void run() {
                    if (AlaGiftTabActivity.this.baA != null && AlaGiftTabActivity.this.baA.getEditView() != null) {
                        BdUtilHelper.hideSoftKeyPad(AlaGiftTabActivity.this, AlaGiftTabActivity.this.baA.getEditView());
                    }
                }
            };
        }
        return this.baN;
    }

    private void Gn() {
        if (this.baA != null) {
            this.baA.setVisibility(8);
        }
    }

    private void b(AlaLiveGiftUIInfo alaLiveGiftUIInfo) {
        if (alaLiveGiftUIInfo != null && this.bav != null) {
            this.bav.setTextColor(alaLiveGiftUIInfo.getTabTextUnSelectedColor());
        }
    }

    private void c(AlaLiveGiftUIInfo alaLiveGiftUIInfo) {
        SupportXFragment[] supportXFragmentArr;
        if (alaLiveGiftUIInfo != null && alaLiveGiftUIInfo.getCategoryTextSelectedColor() != 0 && (this.bay.getAdapter() instanceof GiftPanelFragmentPagerAdapter) && ((GiftPanelFragmentPagerAdapter) this.bay.getAdapter()).HW() != null && this.baO != null) {
            for (SupportXFragment supportXFragment : this.baO) {
                if (supportXFragment instanceof com.baidu.live.gift.panel.c) {
                    ((com.baidu.live.gift.panel.c) supportXFragment).cX(alaLiveGiftUIInfo.getCategoryTextSelectedColor());
                }
            }
        }
    }

    private void d(final AlaLiveGiftUIInfo alaLiveGiftUIInfo) {
        if (alaLiveGiftUIInfo != null && !TextUtils.isEmpty(alaLiveGiftUIInfo.getVerticalBgUrl()) && this.bat != null) {
            LinearLayout linearLayout = new LinearLayout(this.bat.getContext());
            linearLayout.setBackgroundColor(0);
            linearLayout.setOrientation(1);
            SimpleDraweeView simpleDraweeView = new SimpleDraweeView(linearLayout.getContext());
            simpleDraweeView.setScaleType(ImageView.ScaleType.FIT_XY);
            linearLayout.addView(simpleDraweeView, new LinearLayout.LayoutParams(-1, -1));
            View view = new View(linearLayout.getContext());
            view.setBackgroundColor(0);
            linearLayout.addView(view, new LinearLayout.LayoutParams(-1, Gh()));
            this.bat.addView(linearLayout, 0);
            simpleDraweeView.setController(com.facebook.drawee.a.a.c.eto().c(simpleDraweeView.getController()).bo(ImageRequestBuilder.ag(Uri.parse(alaLiveGiftUIInfo.getVerticalBgUrl())).a(com.facebook.imagepipeline.common.e.ewn()).a(com.facebook.imagepipeline.common.b.ewd().e(Bitmap.Config.RGB_565).ewl()).eAi()).Bm(true).c(new com.facebook.drawee.controller.c<com.facebook.imagepipeline.f.f>() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.4
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
                public void gy(String str) {
                }
            }).euf());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaLiveGiftUIInfo alaLiveGiftUIInfo, int i, int i2) {
        if (this.bat != null && i != 0 && i2 != 0) {
            View childAt = this.bat.getChildAt(0);
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
                                this.bat.setBackgroundColor(0);
                                linearLayout.getChildAt(1).setBackgroundColor(alaLiveGiftUIInfo.getBgColor());
                            }
                        }
                    }
                }
            }
        }
    }
}

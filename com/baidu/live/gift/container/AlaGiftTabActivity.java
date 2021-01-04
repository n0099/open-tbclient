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
    private RoundRectFrameLayout bca;
    private View bcb;
    private TextView bcc;
    private GiftPanelCountBadgeView bcd;
    private NobleGiftEntryView bce;
    private ScrollEnableViewPager bcf;
    private FrameLayout bcg;
    private AlaLiveInputEditView bch;
    private GiftPanelDrawContainerView bci;
    private TextView bcj;
    private ViewTreeObserver.OnGlobalLayoutListener bck;
    private int bcl;
    private int bcm;
    private int bcr;
    private com.baidu.live.gift.panel.b bcs;
    private Runnable bct;
    private Runnable bcu;
    private SupportXFragment[] bcv;
    private boolean mIsKeyboardOpen;
    private View mRootView;
    private boolean bcn = false;
    private boolean aYb = false;
    private boolean bco = false;
    private boolean bcp = false;
    private boolean bcq = true;

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
            II();
            initView();
            this.bcs.a(this, this);
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
        this.bck = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                AlaGiftTabActivity.this.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(AlaGiftTabActivity.this.getPageContext().getPageActivity());
                int[] screenDimensions = BdUtilHelper.getScreenDimensions(AlaGiftTabActivity.this.getPageContext().getPageActivity());
                boolean z = AlaGiftTabActivity.this.bcl != rect.bottom;
                AlaGiftTabActivity.this.bcl = rect.bottom;
                if (screenDimensions[1] - rect.bottom > screenDimensions[1] / 4 && (!AlaGiftTabActivity.this.mIsKeyboardOpen || z)) {
                    AlaGiftTabActivity.this.mIsKeyboardOpen = true;
                    AlaGiftTabActivity.this.onKeyboardVisibilityChanged(true);
                } else if (screenDimensions[1] - rect.height() <= statusBarHeight && AlaGiftTabActivity.this.mIsKeyboardOpen) {
                    AlaGiftTabActivity.this.mIsKeyboardOpen = false;
                    AlaGiftTabActivity.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.bck);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.bch != null && this.bch.getVisibility() == 0) {
                AsyncTask.execute(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.5
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            new Instrumentation().sendKeyDownUpSync(4);
                        } catch (Exception e) {
                            AlaGiftTabActivity.this.bch.post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.5.1
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
            } else if (view == this.bca) {
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
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bch.getLayoutParams();
            layoutParams.topMargin = statusBarHeight;
            this.bch.setLayoutParams(layoutParams);
            if (!this.bcq) {
                this.bch.setVisibility(0);
                return;
            }
            return;
        }
        if (this.bcv != null) {
            for (SupportXFragment supportXFragment : this.bcv) {
                if ((supportXFragment instanceof com.baidu.live.gift.panel.c) && ((com.baidu.live.gift.panel.c) supportXFragment).bir != null) {
                    ((com.baidu.live.gift.panel.c) supportXFragment).bir.Je();
                }
            }
        }
        IS();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.bch != null && this.bch.getVisibility() == 0) {
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
                if (this.bca != null && alaLiveGiftUIInfo.getBgColor() != 0) {
                    Drawable background = this.bca.getBackground();
                    if (background instanceof GradientDrawable) {
                        ((GradientDrawable) background).setColor(alaLiveGiftUIInfo.getBgColor());
                        this.bca.setBackgroundDrawable(background);
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
        this.bcv = supportXFragmentArr;
        if (this.bcg != null) {
            this.bcg.removeAllViews();
            if (this.bcv != null) {
                for (SupportXFragment supportXFragment : this.bcv) {
                    supportXFragment.onCreateView(null, null, null);
                    supportXFragment.onActivityCreated(null);
                    this.bcg.addView(supportXFragment.getView(), new ViewGroup.LayoutParams(-1, -1));
                }
            }
        }
        ew(i);
    }

    @Override // com.baidu.live.gift.container.AlaGiftTabView.a
    public void IE() {
        ew(0);
    }

    @Override // com.baidu.live.gift.container.AlaGiftTabView.a
    public void ev(int i) {
        if (this.bcd != null) {
            if (IP() instanceof com.baidu.live.gift.panel.e) {
                com.baidu.live.d.Ba().putInt("gift_package_list_flag", 0);
                i = 0;
            }
            if (i > 0) {
                this.bcd.setCount(i);
                this.bcd.setVisibility(0);
                return;
            }
            this.bcd.setVisibility(4);
        }
    }

    @Override // com.baidu.live.gift.container.AlaGiftTabView.a
    public void c(boolean z, int i) {
        if (this.bch != null && this.bch.getEditView() != null) {
            if (z) {
                this.bch.setMaxText(String.valueOf(i));
                this.bch.setHintText(String.format(Locale.getDefault(), getString(a.h.ala_send_gift_count_hint), Integer.valueOf(i)));
                this.bch.Ox();
                this.bch.getEditView().setFocusable(true);
                this.bch.getEditView().setFocusableInTouchMode(true);
                this.bch.getEditView().postDelayed(IQ(), 100L);
                return;
            }
            IS();
            this.bch.getEditView().post(IR());
        }
    }

    @Override // com.baidu.live.gift.container.AlaGiftTabView.a
    public void f(boolean z, String str) {
        if (this.bci != null) {
            if (z) {
                if (Build.VERSION.SDK_INT != 26) {
                    setRequestedOrientation(1);
                    this.bcn = true;
                }
                this.bci.setVisibility(0);
            } else {
                if (Build.VERSION.SDK_INT != 26 && this.bcn) {
                    setRequestedOrientation(3);
                    this.bcn = false;
                }
                this.bci.setVisibility(8);
            }
            this.bci.h(z, str);
        }
    }

    @Override // com.baidu.live.gift.container.AlaGiftTabView.a
    public void a(g gVar) {
        if (this.bci != null) {
            this.bci.setGiftItem(gVar);
        }
    }

    @Override // com.baidu.live.gift.panel.b.a
    public k IF() {
        if (this.bci != null) {
            return this.bci.getGraffitiData();
        }
        return null;
    }

    @Override // com.baidu.live.gift.panel.b.a
    public void a(NobleUserInfo.a aVar) {
        if (this.bce != null) {
            this.bce.setData(aVar);
        }
    }

    @Override // com.baidu.live.gift.container.AlaGiftTabView.a
    public void g(String str, String str2, boolean z) {
        int dimensionPixelOffset;
        if (this.bcj != null) {
            if (TextUtils.isEmpty(str)) {
                this.bcj.setText("");
                this.bcj.setVisibility(8);
                return;
            }
            Drawable background = this.bcj.getBackground();
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
                this.bcj.setBackgroundDrawable(background);
            }
            this.bcj.setText(str);
            this.bcj.setTag(str2);
            this.bcj.setVisibility(0);
            ViewGroup.LayoutParams layoutParams = this.bcj.getLayoutParams();
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
                    this.bcj.setLayoutParams(layoutParams);
                }
            }
        }
    }

    @Override // com.baidu.live.gift.container.AlaGiftTabView.a
    public void q(int i, String str) {
        if (this.bcs != null) {
            this.bcs.q(i, str);
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
        getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.bck);
        if (this.bcs != null) {
            this.bcs.release();
        }
        if (this.bcv != null) {
            for (SupportXFragment supportXFragment : this.bcv) {
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
        if (!this.aYb) {
            this.mRootView.setVisibility(0);
            IG();
            this.aYb = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.bcq = false;
        if (this.bcv != null) {
            for (SupportXFragment supportXFragment : this.bcv) {
                supportXFragment.onResume();
            }
        }
        if (this.bcs != null) {
            this.bcs.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.bcq = true;
        if (this.bcv != null) {
            for (SupportXFragment supportXFragment : this.bcv) {
                supportXFragment.onPause();
            }
        }
        if (this.bcs != null) {
            this.bcs.onPause();
        }
    }

    private void IG() {
        Animation loadAnimation;
        this.bco = true;
        if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0203a.sdk_in_from_right);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0203a.sdk_in_from_bottom);
        }
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                AlaGiftTabActivity.this.bco = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        if (this.mRootView != null) {
            this.mRootView.startAnimation(loadAnimation);
        }
    }

    private void IH() {
        Animation loadAnimation;
        if (!this.bcp && !this.bco) {
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0203a.sdk_out_to_right);
            } else {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0203a.sdk_out_to_bottom);
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
            this.bcp = true;
            if (this.mRootView != null) {
                this.mRootView.startAnimation(loadAnimation);
            }
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        IH();
    }

    private void II() {
        this.bcs = new com.baidu.live.gift.panel.b(getPageContext());
        this.bcs.init(getIntent());
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
        this.bco = false;
        this.mRootView.setVisibility(4);
        IJ();
        bF(z);
        bG(z);
        bH(z);
        bI(z);
        bJ(z);
        IK();
        IL();
        bK(z);
    }

    private void IJ() {
        this.bca = (RoundRectFrameLayout) findViewById(a.f.layout_content);
        this.bcb = findViewById(a.f.layout_tab);
        this.bcc = (TextView) findViewById(a.f.tv_tab_text);
        this.bcd = (GiftPanelCountBadgeView) findViewById(a.f.layout_tab_badge_count);
        this.bce = (NobleGiftEntryView) findViewById(a.f.noble_entry);
        this.bcf = (ScrollEnableViewPager) findViewById(a.f.vp);
        this.bcg = (FrameLayout) findViewById(a.f.layout_supportx);
        this.bch = (AlaLiveInputEditView) findViewById(a.f.edit_num);
        this.bci = (GiftPanelDrawContainerView) findViewById(a.f.container_draw);
        this.bcj = (TextView) findViewById(a.f.gift_toast);
    }

    private void bF(boolean z) {
        this.bca.setClickable(true);
        if (Build.VERSION.SDK_INT >= 26) {
            this.bca.setDefaultFocusHighlightEnabled(false);
        }
        this.bca.setBackgroundColor(getResources().getColor(a.c.live_gift_panel_primary));
        float dimensionPixelOffset = getResources().getDimensionPixelOffset(a.d.sdk_ds26);
        if (z) {
            this.bca.setCornerRadius(dimensionPixelOffset, 0.0f, 0.0f, dimensionPixelOffset);
        } else {
            this.bca.setCornerRadius(dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f);
        }
        if (z) {
            ViewGroup.LayoutParams layoutParams = this.bca.getLayoutParams();
            layoutParams.width = ScreenHelper.getRealScreenHeight(this);
            this.bca.setLayoutParams(layoutParams);
        }
    }

    private void bG(boolean z) {
        if (!z) {
            ViewGroup.LayoutParams layoutParams = this.bcb.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                ((FrameLayout.LayoutParams) layoutParams).gravity |= 80;
                ((FrameLayout.LayoutParams) layoutParams).bottomMargin = IM();
                this.bcb.setLayoutParams(layoutParams);
            }
        }
        this.bcb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaGiftTabActivity.this.ew(1);
            }
        });
        this.bcd.setPlusThreshold(99, false);
    }

    private void bH(boolean z) {
        if (this.bcs == null || !this.bcs.Ks()) {
            this.bce.setVisibility(8);
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.bce.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            if (z) {
                ((FrameLayout.LayoutParams) layoutParams).topMargin = IN();
            } else {
                ((FrameLayout.LayoutParams) layoutParams).gravity = 80;
                ((FrameLayout.LayoutParams) layoutParams).bottomMargin = getDataPagerHeight() + IO();
            }
            this.bce.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AlaGiftTabActivity.this.bcs != null) {
                        AlaGiftTabActivity.this.bcs.Kt();
                    }
                }
            });
        }
    }

    private void bI(boolean z) {
        this.bcf.setScrollEnabled(false);
        ViewGroup.LayoutParams layoutParams = this.bcf.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.height = -1;
            } else {
                layoutParams.height = IN() + IM();
            }
            this.bcf.setLayoutParams(layoutParams);
        }
    }

    private void bJ(boolean z) {
        ViewGroup.LayoutParams layoutParams = this.bcg.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.height = -1;
            } else {
                layoutParams.height = getResources().getDimensionPixelOffset(a.d.sdk_ds116) + IM();
            }
            this.bcg.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.live.gift.container.AlaGiftTabActivity$10  reason: invalid class name */
    /* loaded from: classes11.dex */
    public class AnonymousClass10 implements c.a {
        AnonymousClass10() {
        }

        @Override // com.baidu.live.view.input.c.a
        public void hn(String str) {
            String str2;
            AsyncTask.execute(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.10.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        new Instrumentation().sendKeyDownUpSync(4);
                    } catch (Exception e) {
                        AlaGiftTabActivity.this.bch.post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.10.1.1
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
            com.baidu.live.gift.panel.c IP = AlaGiftTabActivity.this.IP();
            if ((!(IP instanceof com.baidu.live.gift.panel.e) || !((com.baidu.live.gift.panel.e) IP).hE(str2)) && IP != null && IP.bir != null) {
                IP.bir.hq(str2);
            }
        }
    }

    private void IK() {
        this.bch.setEditViewConfirmCallBack(new AnonymousClass10());
    }

    private void IL() {
        this.bci.setCallback(new GiftPanelDrawContainerView.a() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.11
            @Override // com.baidu.live.gift.widget.panel.GiftPanelDrawContainerView.a
            public void ex(int i) {
                com.baidu.live.gift.panel.c IP = AlaGiftTabActivity.this.IP();
                if (IP != null && IP.bir != null) {
                    IP.bir.eG(i);
                }
            }

            @Override // com.baidu.live.gift.widget.panel.GiftPanelDrawContainerView.a
            public void IT() {
                AlaGiftTabActivity.this.finish();
            }
        });
    }

    private void bK(boolean z) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(BdUtilHelper.dip2px(this, 5.0f));
        this.bcj.setBackgroundDrawable(gradientDrawable);
        if (z) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bcj.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            layoutParams.addRule(5, this.bca.getId());
            layoutParams.addRule(2, 0);
            layoutParams.rightMargin = 0;
            layoutParams.addRule(12);
            this.bcj.setLayoutParams(layoutParams);
            this.bcj.setGravity(17);
            int dimens = BdUtilHelper.getDimens(this, a.d.sdk_ds12);
            this.bcj.setPadding(dimens, dimens, dimens, dimens);
        }
        this.bcj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaGiftTabActivity.this.bcs != null) {
                    Object tag = AlaGiftTabActivity.this.bcj.getTag();
                    if ((tag instanceof String) && !TextUtils.isEmpty((String) tag)) {
                        AlaGiftTabActivity.this.bcs.hD((String) tag);
                    }
                }
            }
        });
    }

    private int IM() {
        if (this.bcm <= 0) {
            this.bcm = getDataPagerHeight();
            if (this.bcs != null && this.bcs.Ks()) {
                this.bcm += IO() + getResources().getDimensionPixelOffset(a.d.sdk_ds72);
            }
        }
        return this.bcm;
    }

    private int getDataPagerHeight() {
        return (getResources().getDimensionPixelOffset(a.d.sdk_ds192) * 2) + getResources().getDimensionPixelOffset(a.d.sdk_ds4) + getResources().getDimensionPixelOffset(a.d.sdk_ds12) + getResources().getDimensionPixelOffset(a.d.sdk_ds116);
    }

    private int IN() {
        return getResources().getDimensionPixelOffset(a.d.sdk_ds116);
    }

    private int IO() {
        return getResources().getDimensionPixelOffset(a.d.sdk_ds24);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.live.gift.panel.c IP() {
        if (this.bcv == null || this.bcv.length <= this.bcr || !(this.bcv[this.bcr] instanceof com.baidu.live.gift.panel.c)) {
            return null;
        }
        return (com.baidu.live.gift.panel.c) this.bcv[this.bcr];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ew(int i) {
        this.bcr = i;
        if (this.bcb != null) {
            this.bcb.setVisibility(i == 1 ? 4 : 0);
            AlaGiftTabView.page = i;
        }
        if (this.bcv != null) {
            int i2 = 0;
            while (i2 < this.bcv.length) {
                this.bcv[i2].setUserVisibleHint(i2 == i);
                if ((this.bcv[i2] instanceof com.baidu.live.gift.panel.c) && ((com.baidu.live.gift.panel.c) this.bcv[i2]).bir != null) {
                    ((com.baidu.live.gift.panel.c) this.bcv[i2]).bir.bN(i2 == i);
                }
                if (this.bcv[i2].getView() != null) {
                    this.bcv[i2].getView().setVisibility(i2 == i ? 0 : 8);
                }
                i2++;
            }
            ev(0);
        }
    }

    private Runnable IQ() {
        if (this.bct == null) {
            this.bct = new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.2
                @Override // java.lang.Runnable
                public void run() {
                    if (AlaGiftTabActivity.this.bch != null && AlaGiftTabActivity.this.bch.getEditView() != null) {
                        AlaGiftTabActivity.this.bch.getEditView().requestFocus();
                        BdUtilHelper.showSoftKeyPad(AlaGiftTabActivity.this, AlaGiftTabActivity.this.bch.getEditView());
                    }
                }
            };
        }
        return this.bct;
    }

    private Runnable IR() {
        if (this.bcu == null) {
            this.bcu = new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.3
                @Override // java.lang.Runnable
                public void run() {
                    if (AlaGiftTabActivity.this.bch != null && AlaGiftTabActivity.this.bch.getEditView() != null) {
                        BdUtilHelper.hideSoftKeyPad(AlaGiftTabActivity.this, AlaGiftTabActivity.this.bch.getEditView());
                    }
                }
            };
        }
        return this.bcu;
    }

    private void IS() {
        if (this.bch != null) {
            this.bch.setVisibility(8);
        }
    }

    private void b(AlaLiveGiftUIInfo alaLiveGiftUIInfo) {
        if (alaLiveGiftUIInfo != null && this.bcc != null) {
            this.bcc.setTextColor(alaLiveGiftUIInfo.getTabTextUnSelectedColor());
        }
    }

    private void c(AlaLiveGiftUIInfo alaLiveGiftUIInfo) {
        SupportXFragment[] supportXFragmentArr;
        if (alaLiveGiftUIInfo != null && alaLiveGiftUIInfo.getCategoryTextSelectedColor() != 0 && (this.bcf.getAdapter() instanceof GiftPanelFragmentPagerAdapter) && ((GiftPanelFragmentPagerAdapter) this.bcf.getAdapter()).KB() != null && this.bcv != null) {
            for (SupportXFragment supportXFragment : this.bcv) {
                if (supportXFragment instanceof com.baidu.live.gift.panel.c) {
                    ((com.baidu.live.gift.panel.c) supportXFragment).ey(alaLiveGiftUIInfo.getCategoryTextSelectedColor());
                }
            }
        }
    }

    private void d(final AlaLiveGiftUIInfo alaLiveGiftUIInfo) {
        if (alaLiveGiftUIInfo != null && !TextUtils.isEmpty(alaLiveGiftUIInfo.getVerticalBgUrl()) && this.bca != null) {
            LinearLayout linearLayout = new LinearLayout(this.bca.getContext());
            linearLayout.setBackgroundColor(0);
            linearLayout.setOrientation(1);
            SimpleDraweeView simpleDraweeView = new SimpleDraweeView(linearLayout.getContext());
            simpleDraweeView.setScaleType(ImageView.ScaleType.FIT_XY);
            linearLayout.addView(simpleDraweeView, new LinearLayout.LayoutParams(-1, -1));
            View view = new View(linearLayout.getContext());
            view.setBackgroundColor(0);
            linearLayout.addView(view, new LinearLayout.LayoutParams(-1, IM()));
            this.bca.addView(linearLayout, 0);
            simpleDraweeView.setController(com.facebook.drawee.a.a.c.euI().c(simpleDraweeView.getController()).bo(ImageRequestBuilder.aj(Uri.parse(alaLiveGiftUIInfo.getVerticalBgUrl())).a(com.facebook.imagepipeline.common.e.exl()).a(com.facebook.imagepipeline.common.b.exb().e(Bitmap.Config.RGB_565).exj()).eBe()).AX(true).c(new com.facebook.drawee.controller.c<com.facebook.imagepipeline.f.f>() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.4
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
                public void hm(String str) {
                }
            }).evz());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaLiveGiftUIInfo alaLiveGiftUIInfo, int i, int i2) {
        if (this.bca != null && i != 0 && i2 != 0) {
            View childAt = this.bca.getChildAt(0);
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
                                this.bca.setBackgroundColor(0);
                                linearLayout.getChildAt(1).setBackgroundColor(alaLiveGiftUIInfo.getBgColor());
                            }
                        }
                    }
                }
            }
        }
    }
}

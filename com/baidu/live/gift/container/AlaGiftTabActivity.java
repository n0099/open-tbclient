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
import com.baidu.live.utils.i;
import com.baidu.live.utils.q;
import com.baidu.live.view.ScrollEnableViewPager;
import com.baidu.live.view.input.AlaLiveInputEditView;
import com.baidu.live.view.input.b;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.util.Locale;
/* loaded from: classes4.dex */
public class AlaGiftTabActivity extends BaseFragmentActivity implements View.OnTouchListener, AlaGiftTabView.a, b.a {
    private View aSR;
    private GiftPanelTabView aSS;
    private NobleGiftEntryView aST;
    private ScrollEnableViewPager aSU;
    private FrameLayout aSV;
    private AlaLiveInputEditView aSW;
    private GiftPanelDrawContainerView aSX;
    private TextView aSY;
    private ViewTreeObserver.OnGlobalLayoutListener aSZ;
    private int aTa;
    private int aTb;
    private com.baidu.live.gift.panel.b aTg;
    private Runnable aTh;
    private Runnable aTi;
    private SupportXFragment[] aTj;
    private ViewGroup mContentLayout;
    private boolean mIsKeyboardOpen;
    private View mRootView;
    private boolean aTc = false;
    private boolean aPD = false;
    private boolean aTd = false;
    private boolean aTe = false;
    private boolean aTf = true;

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
            Gf();
            initView();
            this.aTg.a(this, this);
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
        this.aSZ = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                AlaGiftTabActivity.this.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(AlaGiftTabActivity.this.getPageContext().getPageActivity());
                int[] screenDimensions = BdUtilHelper.getScreenDimensions(AlaGiftTabActivity.this.getPageContext().getPageActivity());
                boolean z = AlaGiftTabActivity.this.aTa != rect.bottom;
                AlaGiftTabActivity.this.aTa = rect.bottom;
                if (screenDimensions[1] - rect.bottom > screenDimensions[1] / 4 && (!AlaGiftTabActivity.this.mIsKeyboardOpen || z)) {
                    AlaGiftTabActivity.this.mIsKeyboardOpen = true;
                    AlaGiftTabActivity.this.onKeyboardVisibilityChanged(true);
                } else if (screenDimensions[1] - rect.height() <= statusBarHeight && AlaGiftTabActivity.this.mIsKeyboardOpen) {
                    AlaGiftTabActivity.this.mIsKeyboardOpen = false;
                    AlaGiftTabActivity.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.aSZ);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.aSW != null && this.aSW.getVisibility() == 0) {
                AsyncTask.execute(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.5
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            new Instrumentation().sendKeyDownUpSync(4);
                        } catch (Exception e) {
                            AlaGiftTabActivity.this.aSW.post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.5.1
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
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aSW.getLayoutParams();
            layoutParams.topMargin = statusBarHeight;
            this.aSW.setLayoutParams(layoutParams);
            if (!this.aTf) {
                this.aSW.setVisibility(0);
                return;
            }
            return;
        }
        if (this.aTj != null) {
            for (SupportXFragment supportXFragment : this.aTj) {
                if ((supportXFragment instanceof com.baidu.live.gift.panel.c) && ((com.baidu.live.gift.panel.c) supportXFragment).aYs != null) {
                    ((com.baidu.live.gift.panel.c) supportXFragment).aYs.GC();
                }
            }
        }
        Gq();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.aSW != null && this.aSW.getVisibility() == 0) {
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
        this.aTj = supportXFragmentArr;
        if (this.aSV != null) {
            this.aSV.removeAllViews();
            if (this.aTj != null) {
                for (SupportXFragment supportXFragment : this.aTj) {
                    supportXFragment.onCreateView(null, null, null);
                    supportXFragment.onActivityCreated(null);
                    this.aSV.addView(supportXFragment.getView(), new ViewGroup.LayoutParams(-1, -1));
                }
            }
        }
        eb(i);
    }

    @Override // com.baidu.live.gift.container.AlaGiftTabView.a
    public void c(boolean z, int i) {
        if (this.aSW != null && this.aSW.getEditView() != null) {
            if (z) {
                this.aSW.setMaxText(String.valueOf(i));
                this.aSW.setHintText(String.format(Locale.getDefault(), getString(a.i.ala_send_gift_count_hint), Integer.valueOf(i)));
                this.aSW.Lh();
                this.aSW.getEditView().setFocusable(true);
                this.aSW.getEditView().setFocusableInTouchMode(true);
                this.aSW.getEditView().postDelayed(Go(), 100L);
                return;
            }
            Gq();
            this.aSW.getEditView().post(Gp());
        }
    }

    @Override // com.baidu.live.gift.container.AlaGiftTabView.a
    public void e(boolean z, String str) {
        if (this.aSX != null) {
            if (z) {
                if (Build.VERSION.SDK_INT != 26) {
                    setRequestedOrientation(1);
                    this.aTc = true;
                }
                this.aSX.setVisibility(0);
            } else {
                if (Build.VERSION.SDK_INT != 26 && this.aTc) {
                    setRequestedOrientation(3);
                    this.aTc = false;
                }
                this.aSX.setVisibility(8);
            }
            this.aSX.f(z, str);
        }
    }

    @Override // com.baidu.live.gift.container.AlaGiftTabView.a
    public void a(g gVar) {
        if (this.aSX != null) {
            this.aSX.setGiftItem(gVar);
        }
    }

    @Override // com.baidu.live.gift.panel.b.a
    public l Gc() {
        if (this.aSX != null) {
            return this.aSX.getGraffitiData();
        }
        return null;
    }

    @Override // com.baidu.live.gift.panel.b.a
    public void a(NobleUserInfo.a aVar) {
        if (this.aST != null) {
            this.aST.setData(aVar);
        }
    }

    @Override // com.baidu.live.gift.container.AlaGiftTabView.a
    public void ao(String str, String str2) {
        if (this.aSY != null) {
            if (!TextUtils.isEmpty(str)) {
                this.aSY.setText(str);
                this.aSY.setTag(str2);
                this.aSY.setVisibility(0);
                return;
            }
            this.aSY.setText("");
            this.aSY.setVisibility(8);
        }
    }

    @Override // com.baidu.live.gift.container.AlaGiftTabView.a
    public void o(int i, String str) {
        if (this.aTg != null) {
            this.aTg.o(i, str);
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
        getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.aSZ);
        if (this.aTg != null) {
            this.aTg.release();
        }
        if (this.aTj != null) {
            for (SupportXFragment supportXFragment : this.aTj) {
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
        if (!this.aPD) {
            this.mRootView.setVisibility(0);
            Gd();
            this.aPD = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.aTf = false;
        if (this.aTj != null) {
            for (SupportXFragment supportXFragment : this.aTj) {
                supportXFragment.onResume();
            }
        }
        if (this.aTg != null) {
            this.aTg.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.aTf = true;
        if (this.aTj != null) {
            for (SupportXFragment supportXFragment : this.aTj) {
                supportXFragment.onPause();
            }
        }
        if (this.aTg != null) {
            this.aTg.onPause();
        }
    }

    private void Gd() {
        Animation loadAnimation;
        this.aTd = true;
        if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0186a.sdk_in_from_right);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0186a.sdk_in_from_bottom);
        }
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                AlaGiftTabActivity.this.aTd = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        if (this.mRootView != null) {
            this.mRootView.startAnimation(loadAnimation);
        }
    }

    private void Ge() {
        Animation loadAnimation;
        if (!this.aTe && !this.aTd) {
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0186a.sdk_out_to_right);
            } else {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0186a.sdk_out_to_bottom);
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
            this.aTe = true;
            if (this.mRootView != null) {
                this.mRootView.startAnimation(loadAnimation);
            }
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        Ge();
    }

    private void Gf() {
        this.aTg = new com.baidu.live.gift.panel.b(getPageContext());
        this.aTg.init(getIntent());
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this).inflate(a.h.live_gift_activity_panel, (ViewGroup) null);
        setContentView(this.mRootView);
        boolean z = UtilHelper.getRealScreenOrientation(getActivity()) == 2;
        if (z) {
            i.aa(this.mRootView);
            q.e(getActivity(), false);
        }
        addGlobalLayoutListener();
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        this.aTd = false;
        this.mRootView.setVisibility(4);
        Gg();
        bp(z);
        bq(z);
        br(z);
        bs(z);
        bt(z);
        Gh();
        Gi();
        bu(z);
    }

    private void Gg() {
        this.mContentLayout = (ViewGroup) findViewById(a.g.layout_content);
        this.aSR = findViewById(a.g.layout_tab);
        this.aSS = (GiftPanelTabView) findViewById(a.g.tab);
        this.aST = (NobleGiftEntryView) findViewById(a.g.noble_entry);
        this.aSU = (ScrollEnableViewPager) findViewById(a.g.vp);
        this.aSV = (FrameLayout) findViewById(a.g.layout_supportx);
        this.aSW = (AlaLiveInputEditView) findViewById(a.g.edit_num);
        this.aSX = (GiftPanelDrawContainerView) findViewById(a.g.container_draw);
        this.aSY = (TextView) findViewById(a.g.gift_toast);
    }

    private void bp(boolean z) {
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

    private void bq(boolean z) {
        if (!z) {
            ViewGroup.LayoutParams layoutParams = this.aSR.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                ((FrameLayout.LayoutParams) layoutParams).gravity |= 80;
                ((FrameLayout.LayoutParams) layoutParams).bottomMargin = Gj();
                this.aSR.setLayoutParams(layoutParams);
            }
        }
        this.aSS.setCallback(new GiftPanelTabView.a() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.8
            @Override // com.baidu.live.gift.widget.panel.GiftPanelTabView.a
            public void ec(int i) {
                AlaGiftTabActivity.this.eb(i);
            }
        });
    }

    private void br(boolean z) {
        if (this.aTg == null || !this.aTg.HJ()) {
            this.aST.setVisibility(8);
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.aST.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            if (z) {
                ((FrameLayout.LayoutParams) layoutParams).topMargin = Gl();
            } else {
                ((FrameLayout.LayoutParams) layoutParams).gravity = 80;
                ((FrameLayout.LayoutParams) layoutParams).bottomMargin = Gk() + Gm();
            }
            this.aST.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AlaGiftTabActivity.this.aTg != null) {
                        AlaGiftTabActivity.this.aTg.HK();
                    }
                }
            });
        }
    }

    private void bs(boolean z) {
        this.aSU.setScrollEnabled(false);
        ViewGroup.LayoutParams layoutParams = this.aSU.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.height = -1;
            } else {
                layoutParams.height = Gl() + Gj();
            }
            this.aSU.setLayoutParams(layoutParams);
        }
    }

    private void bt(boolean z) {
        ViewGroup.LayoutParams layoutParams = this.aSV.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.height = -1;
            } else {
                layoutParams.height = getResources().getDimensionPixelOffset(a.e.sdk_ds116) + Gj();
            }
            this.aSV.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.live.gift.container.AlaGiftTabActivity$10  reason: invalid class name */
    /* loaded from: classes4.dex */
    public class AnonymousClass10 implements b.a {
        AnonymousClass10() {
        }

        @Override // com.baidu.live.view.input.b.a
        public void gH(String str) {
            AsyncTask.execute(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.10.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        new Instrumentation().sendKeyDownUpSync(4);
                    } catch (Exception e) {
                        AlaGiftTabActivity.this.aSW.post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.10.1.1
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
            com.baidu.live.gift.panel.c Gn = AlaGiftTabActivity.this.Gn();
            if (Gn != null && Gn.aYs != null) {
                Gn.aYs.gK(str);
            }
        }
    }

    private void Gh() {
        this.aSW.setEditViewConfirmCallBack(new AnonymousClass10());
    }

    private void Gi() {
        this.aSX.setCallback(new GiftPanelDrawContainerView.a() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.11
            @Override // com.baidu.live.gift.widget.panel.GiftPanelDrawContainerView.a
            public void ed(int i) {
                com.baidu.live.gift.panel.c Gn = AlaGiftTabActivity.this.Gn();
                if (Gn != null && Gn.aYs != null) {
                    Gn.aYs.el(i);
                }
            }

            @Override // com.baidu.live.gift.widget.panel.GiftPanelDrawContainerView.a
            public void Gr() {
                AlaGiftTabActivity.this.finish();
            }
        });
    }

    private void bu(boolean z) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(BdUtilHelper.dip2px(this, 5.0f));
        gradientDrawable.setColor(-1560281088);
        this.aSY.setBackgroundDrawable(gradientDrawable);
        if (z) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aSY.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            layoutParams.addRule(5, this.mContentLayout.getId());
            layoutParams.addRule(2, 0);
            layoutParams.rightMargin = 0;
            layoutParams.addRule(12);
            layoutParams.bottomMargin = BdUtilHelper.getDimens(this, a.e.sdk_ds90);
            this.aSY.setLayoutParams(layoutParams);
            this.aSY.setBackgroundColor(-1560281088);
            this.aSY.setGravity(17);
            int dimens = BdUtilHelper.getDimens(this, a.e.sdk_ds12);
            this.aSY.setPadding(dimens, dimens, dimens, dimens);
        }
        this.aSY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaGiftTabActivity.this.aTg != null) {
                    Object tag = AlaGiftTabActivity.this.aSY.getTag();
                    if ((tag instanceof String) && !TextUtils.isEmpty((String) tag)) {
                        AlaGiftTabActivity.this.aTg.gX((String) tag);
                    }
                }
            }
        });
    }

    private int Gj() {
        if (this.aTb <= 0) {
            this.aTb = Gk();
            if (this.aTg != null && this.aTg.HJ()) {
                this.aTb += Gm() + getResources().getDimensionPixelOffset(a.e.sdk_ds72);
            }
        }
        return this.aTb;
    }

    private int Gk() {
        return (getResources().getDimensionPixelOffset(a.e.sdk_ds192) * 2) + getResources().getDimensionPixelOffset(a.e.sdk_ds4) + getResources().getDimensionPixelOffset(a.e.sdk_ds12) + getResources().getDimensionPixelOffset(a.e.sdk_ds116);
    }

    private int Gl() {
        return getResources().getDimensionPixelOffset(a.e.sdk_ds116);
    }

    private int Gm() {
        return getResources().getDimensionPixelOffset(a.e.sdk_ds24);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.live.gift.panel.c Gn() {
        if (this.aTj == null || this.aSS == null || this.aTj.length <= this.aSS.getSelect() || !(this.aTj[this.aSS.getSelect()] instanceof com.baidu.live.gift.panel.c)) {
            return null;
        }
        return (com.baidu.live.gift.panel.c) this.aTj[this.aSS.getSelect()];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eb(int i) {
        if (this.aSS != null) {
            this.aSS.setSelect(i);
            AlaGiftTabView.page = i;
        }
        if (this.aTj != null) {
            int i2 = 0;
            while (i2 < this.aTj.length) {
                this.aTj[i2].setUserVisibleHint(i2 == i);
                if ((this.aTj[i2] instanceof com.baidu.live.gift.panel.c) && ((com.baidu.live.gift.panel.c) this.aTj[i2]).aYs != null) {
                    ((com.baidu.live.gift.panel.c) this.aTj[i2]).aYs.bx(i2 == i);
                }
                if (this.aTj[i2].getView() != null) {
                    this.aTj[i2].getView().setVisibility(i2 == i ? 0 : 8);
                }
                i2++;
            }
        }
    }

    private Runnable Go() {
        if (this.aTh == null) {
            this.aTh = new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.2
                @Override // java.lang.Runnable
                public void run() {
                    if (AlaGiftTabActivity.this.aSW != null && AlaGiftTabActivity.this.aSW.getEditView() != null) {
                        AlaGiftTabActivity.this.aSW.getEditView().requestFocus();
                        BdUtilHelper.showSoftKeyPad(AlaGiftTabActivity.this, AlaGiftTabActivity.this.aSW.getEditView());
                    }
                }
            };
        }
        return this.aTh;
    }

    private Runnable Gp() {
        if (this.aTi == null) {
            this.aTi = new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.3
                @Override // java.lang.Runnable
                public void run() {
                    if (AlaGiftTabActivity.this.aSW != null && AlaGiftTabActivity.this.aSW.getEditView() != null) {
                        BdUtilHelper.hideSoftKeyPad(AlaGiftTabActivity.this, AlaGiftTabActivity.this.aSW.getEditView());
                    }
                }
            };
        }
        return this.aTi;
    }

    private void Gq() {
        if (this.aSW != null) {
            this.aSW.setVisibility(8);
        }
    }

    private void b(AlaLiveGiftUIInfo alaLiveGiftUIInfo) {
        if (alaLiveGiftUIInfo != null && this.aSS != null) {
            this.aSS.setColors(alaLiveGiftUIInfo.getTabBgSelectedColor(), alaLiveGiftUIInfo.getTabBgUnSelectedColor(), alaLiveGiftUIInfo.getTabTextSelectedColor(), alaLiveGiftUIInfo.getTabTextUnSelectedColor());
        }
    }

    private void c(AlaLiveGiftUIInfo alaLiveGiftUIInfo) {
        SupportXFragment[] supportXFragmentArr;
        if (alaLiveGiftUIInfo != null && alaLiveGiftUIInfo.getCategoryTextSelectedColor() != 0 && (this.aSU.getAdapter() instanceof GiftPanelFragmentPagerAdapter) && ((GiftPanelFragmentPagerAdapter) this.aSU.getAdapter()).HS() != null && this.aTj != null) {
            for (SupportXFragment supportXFragment : this.aTj) {
                if (supportXFragment instanceof com.baidu.live.gift.panel.c) {
                    ((com.baidu.live.gift.panel.c) supportXFragment).ee(alaLiveGiftUIInfo.getCategoryTextSelectedColor());
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
            linearLayout.addView(view, new LinearLayout.LayoutParams(-1, Gj()));
            this.mContentLayout.addView(linearLayout, 0);
            simpleDraweeView.setController(com.facebook.drawee.a.a.c.dTu().c(simpleDraweeView.getController()).bg(ImageRequestBuilder.ad(Uri.parse(alaLiveGiftUIInfo.getVerticalBgUrl())).a(com.facebook.imagepipeline.common.e.dWy()).a(com.facebook.imagepipeline.common.b.dWn().c(Bitmap.Config.RGB_565).dWv()).eay()).yf(true).c(new com.facebook.drawee.controller.c<com.facebook.imagepipeline.g.f>() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.4
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
                public void gG(String str) {
                }
            }).dUl());
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

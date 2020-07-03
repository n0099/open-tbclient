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
/* loaded from: classes3.dex */
public class AlaGiftTabActivity extends BaseFragmentActivity implements View.OnTouchListener, AlaGiftTabView.a, b.a {
    private View aKd;
    private GiftPanelTabView aKe;
    private NobleGiftEntryView aKf;
    private ScrollEnableViewPager aKg;
    private FrameLayout aKh;
    private AlaLiveInputEditView aKi;
    private GiftPanelDrawContainerView aKj;
    private TextView aKk;
    private ViewTreeObserver.OnGlobalLayoutListener aKl;
    private int aKm;
    private int aKn;
    private com.baidu.live.gift.panel.b aKs;
    private Runnable aKt;
    private Runnable aKu;
    private SupportXFragment[] aKv;
    private ViewGroup mContentLayout;
    private boolean mIsKeyboardOpen;
    private View mRootView;
    private boolean aKo = false;
    private boolean aGX = false;
    private boolean aKp = false;
    private boolean aKq = false;
    private boolean aKr = true;

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
            zA();
            initView();
            this.aKs.a(this, this);
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
        this.aKl = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                AlaGiftTabActivity.this.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(AlaGiftTabActivity.this.getPageContext().getPageActivity());
                int[] screenDimensions = BdUtilHelper.getScreenDimensions(AlaGiftTabActivity.this.getPageContext().getPageActivity());
                boolean z = AlaGiftTabActivity.this.aKm != rect.bottom;
                AlaGiftTabActivity.this.aKm = rect.bottom;
                if (screenDimensions[1] - rect.bottom > screenDimensions[1] / 4 && (!AlaGiftTabActivity.this.mIsKeyboardOpen || z)) {
                    AlaGiftTabActivity.this.mIsKeyboardOpen = true;
                    AlaGiftTabActivity.this.onKeyboardVisibilityChanged(true);
                } else if (screenDimensions[1] - rect.height() <= statusBarHeight && AlaGiftTabActivity.this.mIsKeyboardOpen) {
                    AlaGiftTabActivity.this.mIsKeyboardOpen = false;
                    AlaGiftTabActivity.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.aKl);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.aKi != null && this.aKi.getVisibility() == 0) {
                AsyncTask.execute(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.5
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            new Instrumentation().sendKeyDownUpSync(4);
                        } catch (Exception e) {
                            AlaGiftTabActivity.this.aKi.post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.5.1
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
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aKi.getLayoutParams();
            layoutParams.topMargin = statusBarHeight;
            this.aKi.setLayoutParams(layoutParams);
            if (!this.aKr) {
                this.aKi.setVisibility(0);
                return;
            }
            return;
        }
        if (this.aKv != null) {
            for (SupportXFragment supportXFragment : this.aKv) {
                if ((supportXFragment instanceof com.baidu.live.gift.panel.c) && ((com.baidu.live.gift.panel.c) supportXFragment).aPp != null) {
                    ((com.baidu.live.gift.panel.c) supportXFragment).aPp.zX();
                }
            }
        }
        zL();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.aKi != null && this.aKi.getVisibility() == 0) {
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
        this.aKv = supportXFragmentArr;
        if (this.aKh != null) {
            this.aKh.removeAllViews();
            if (this.aKv != null) {
                for (SupportXFragment supportXFragment : this.aKv) {
                    supportXFragment.onCreateView(null, null, null);
                    supportXFragment.onActivityCreated(null);
                    this.aKh.addView(supportXFragment.getView(), new ViewGroup.LayoutParams(-1, -1));
                }
            }
        }
        cc(i);
    }

    @Override // com.baidu.live.gift.container.AlaGiftTabView.a
    public void c(boolean z, int i) {
        if (this.aKi != null && this.aKi.getEditView() != null) {
            if (z) {
                this.aKi.setMaxText(String.valueOf(i));
                this.aKi.setHintText(String.format(Locale.getDefault(), getString(a.i.ala_send_gift_count_hint), Integer.valueOf(i)));
                this.aKi.EO();
                this.aKi.getEditView().setFocusable(true);
                this.aKi.getEditView().setFocusableInTouchMode(true);
                this.aKi.getEditView().postDelayed(zJ(), 100L);
                return;
            }
            zL();
            this.aKi.getEditView().post(zK());
        }
    }

    @Override // com.baidu.live.gift.container.AlaGiftTabView.a
    public void e(boolean z, String str) {
        if (this.aKj != null) {
            if (z) {
                if (Build.VERSION.SDK_INT != 26) {
                    setRequestedOrientation(1);
                    this.aKo = true;
                }
                this.aKj.setVisibility(0);
            } else {
                if (Build.VERSION.SDK_INT != 26 && this.aKo) {
                    setRequestedOrientation(3);
                    this.aKo = false;
                }
                this.aKj.setVisibility(8);
            }
            this.aKj.f(z, str);
        }
    }

    @Override // com.baidu.live.gift.container.AlaGiftTabView.a
    public void a(g gVar) {
        if (this.aKj != null) {
            this.aKj.setGiftItem(gVar);
        }
    }

    @Override // com.baidu.live.gift.panel.b.a
    public l zx() {
        if (this.aKj != null) {
            return this.aKj.getGraffitiData();
        }
        return null;
    }

    @Override // com.baidu.live.gift.panel.b.a
    public void a(NobleUserInfo.a aVar) {
        if (this.aKf != null) {
            this.aKf.setData(aVar);
        }
    }

    @Override // com.baidu.live.gift.container.AlaGiftTabView.a
    public void al(String str, String str2) {
        if (this.aKk != null) {
            if (!TextUtils.isEmpty(str)) {
                this.aKk.setText(str);
                this.aKk.setTag(str2);
                this.aKk.setVisibility(0);
                return;
            }
            this.aKk.setText("");
            this.aKk.setVisibility(8);
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
        getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.aKl);
        if (this.aKs != null) {
            this.aKs.release();
        }
        if (this.aKv != null) {
            for (SupportXFragment supportXFragment : this.aKv) {
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
        if (!this.aGX) {
            this.mRootView.setVisibility(0);
            zy();
            this.aGX = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.aKr = false;
        if (this.aKv != null) {
            for (SupportXFragment supportXFragment : this.aKv) {
                supportXFragment.onResume();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.aKr = true;
        if (this.aKv != null) {
            for (SupportXFragment supportXFragment : this.aKv) {
                supportXFragment.onPause();
            }
        }
    }

    private void zy() {
        Animation loadAnimation;
        this.aKp = true;
        if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0176a.sdk_in_from_right);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0176a.sdk_in_from_bottom);
        }
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                AlaGiftTabActivity.this.aKp = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        if (this.mRootView != null) {
            this.mRootView.startAnimation(loadAnimation);
        }
    }

    private void zz() {
        Animation loadAnimation;
        if (!this.aKq && !this.aKp) {
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0176a.sdk_out_to_right);
            } else {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0176a.sdk_out_to_bottom);
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
            this.aKq = true;
            if (this.mRootView != null) {
                this.mRootView.startAnimation(loadAnimation);
            }
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        zz();
    }

    private void zA() {
        this.aKs = new com.baidu.live.gift.panel.b(getPageContext());
        this.aKs.init(getIntent());
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this).inflate(a.h.live_gift_activity_panel, (ViewGroup) null);
        setContentView(this.mRootView);
        boolean z = UtilHelper.getRealScreenOrientation(getActivity()) == 2;
        if (z) {
            h.U(this.mRootView);
            q.e(getActivity(), false);
        }
        addGlobalLayoutListener();
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        this.aKp = false;
        this.mRootView.setVisibility(4);
        zB();
        bg(z);
        bh(z);
        bi(z);
        bj(z);
        bk(z);
        zC();
        zD();
        bl(z);
    }

    private void zB() {
        this.mContentLayout = (ViewGroup) findViewById(a.g.layout_content);
        this.aKd = findViewById(a.g.layout_tab);
        this.aKe = (GiftPanelTabView) findViewById(a.g.tab);
        this.aKf = (NobleGiftEntryView) findViewById(a.g.noble_entry);
        this.aKg = (ScrollEnableViewPager) findViewById(a.g.vp);
        this.aKh = (FrameLayout) findViewById(a.g.layout_supportx);
        this.aKi = (AlaLiveInputEditView) findViewById(a.g.edit_num);
        this.aKj = (GiftPanelDrawContainerView) findViewById(a.g.container_draw);
        this.aKk = (TextView) findViewById(a.g.gift_toast);
    }

    private void bg(boolean z) {
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

    private void bh(boolean z) {
        if (!z) {
            ViewGroup.LayoutParams layoutParams = this.aKd.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                ((FrameLayout.LayoutParams) layoutParams).gravity |= 80;
                ((FrameLayout.LayoutParams) layoutParams).bottomMargin = zE();
                this.aKd.setLayoutParams(layoutParams);
            }
        }
        this.aKe.setCallback(new GiftPanelTabView.a() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.8
            @Override // com.baidu.live.gift.widget.panel.GiftPanelTabView.a
            public void cd(int i) {
                AlaGiftTabActivity.this.cc(i);
            }
        });
    }

    private void bi(boolean z) {
        if (this.aKs == null || !this.aKs.Bd()) {
            this.aKf.setVisibility(8);
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.aKf.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            if (z) {
                ((FrameLayout.LayoutParams) layoutParams).topMargin = zG();
            } else {
                ((FrameLayout.LayoutParams) layoutParams).gravity = 80;
                ((FrameLayout.LayoutParams) layoutParams).bottomMargin = zF() + zH();
            }
            this.aKf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AlaGiftTabActivity.this.aKs != null) {
                        AlaGiftTabActivity.this.aKs.Be();
                    }
                }
            });
        }
    }

    private void bj(boolean z) {
        this.aKg.setScrollEnabled(false);
        ViewGroup.LayoutParams layoutParams = this.aKg.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.height = -1;
            } else {
                layoutParams.height = zG() + zE();
            }
            this.aKg.setLayoutParams(layoutParams);
        }
    }

    private void bk(boolean z) {
        ViewGroup.LayoutParams layoutParams = this.aKh.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.height = -1;
            } else {
                layoutParams.height = getResources().getDimensionPixelOffset(a.e.sdk_ds116) + zE();
            }
            this.aKh.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.live.gift.container.AlaGiftTabActivity$10  reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass10 implements b.a {
        AnonymousClass10() {
        }

        @Override // com.baidu.live.view.input.b.a
        public void fc(String str) {
            AsyncTask.execute(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.10.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        new Instrumentation().sendKeyDownUpSync(4);
                    } catch (Exception e) {
                        AlaGiftTabActivity.this.aKi.post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.10.1.1
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
            com.baidu.live.gift.panel.c zI = AlaGiftTabActivity.this.zI();
            if (zI != null && zI.aPp != null) {
                zI.aPp.ff(str);
            }
        }
    }

    private void zC() {
        this.aKi.setEditViewConfirmCallBack(new AnonymousClass10());
    }

    private void zD() {
        this.aKj.setCallback(new GiftPanelDrawContainerView.a() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.11
            @Override // com.baidu.live.gift.widget.panel.GiftPanelDrawContainerView.a
            public void ce(int i) {
                com.baidu.live.gift.panel.c zI = AlaGiftTabActivity.this.zI();
                if (zI != null && zI.aPp != null) {
                    zI.aPp.cm(i);
                }
            }

            @Override // com.baidu.live.gift.widget.panel.GiftPanelDrawContainerView.a
            public void zM() {
                AlaGiftTabActivity.this.finish();
            }
        });
    }

    private void bl(boolean z) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(BdUtilHelper.dip2px(this, 5.0f));
        gradientDrawable.setColor(-1560281088);
        this.aKk.setBackgroundDrawable(gradientDrawable);
        if (z) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aKk.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            layoutParams.addRule(5, this.mContentLayout.getId());
            layoutParams.addRule(2, 0);
            layoutParams.rightMargin = 0;
            layoutParams.addRule(12);
            layoutParams.bottomMargin = BdUtilHelper.getDimens(this, a.e.sdk_ds90);
            this.aKk.setLayoutParams(layoutParams);
            this.aKk.setBackgroundColor(-1560281088);
            this.aKk.setGravity(17);
            int dimens = BdUtilHelper.getDimens(this, a.e.sdk_ds12);
            this.aKk.setPadding(dimens, dimens, dimens, dimens);
        }
        this.aKk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaGiftTabActivity.this.aKs != null) {
                    Object tag = AlaGiftTabActivity.this.aKk.getTag();
                    if ((tag instanceof String) && !TextUtils.isEmpty((String) tag)) {
                        AlaGiftTabActivity.this.aKs.fq((String) tag);
                    }
                }
            }
        });
    }

    private int zE() {
        if (this.aKn <= 0) {
            this.aKn = zF();
            if (this.aKs != null && this.aKs.Bd()) {
                this.aKn += zH() + getResources().getDimensionPixelOffset(a.e.sdk_ds72);
            }
        }
        return this.aKn;
    }

    private int zF() {
        return (getResources().getDimensionPixelOffset(a.e.sdk_ds192) * 2) + getResources().getDimensionPixelOffset(a.e.sdk_ds4) + getResources().getDimensionPixelOffset(a.e.sdk_ds12) + getResources().getDimensionPixelOffset(a.e.sdk_ds116);
    }

    private int zG() {
        return getResources().getDimensionPixelOffset(a.e.sdk_ds116);
    }

    private int zH() {
        return getResources().getDimensionPixelOffset(a.e.sdk_ds24);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.live.gift.panel.c zI() {
        if (this.aKv == null || this.aKe == null || this.aKv.length <= this.aKe.getSelect() || !(this.aKv[this.aKe.getSelect()] instanceof com.baidu.live.gift.panel.c)) {
            return null;
        }
        return (com.baidu.live.gift.panel.c) this.aKv[this.aKe.getSelect()];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cc(int i) {
        if (this.aKe != null) {
            this.aKe.setSelect(i);
        }
        if (this.aKv != null) {
            int i2 = 0;
            while (i2 < this.aKv.length) {
                this.aKv[i2].setUserVisibleHint(i2 == i);
                if ((this.aKv[i2] instanceof com.baidu.live.gift.panel.c) && ((com.baidu.live.gift.panel.c) this.aKv[i2]).aPp != null) {
                    ((com.baidu.live.gift.panel.c) this.aKv[i2]).aPp.bo(i2 == i);
                }
                if (this.aKv[i2].getView() != null) {
                    this.aKv[i2].getView().setVisibility(i2 == i ? 0 : 8);
                }
                i2++;
            }
        }
    }

    private Runnable zJ() {
        if (this.aKt == null) {
            this.aKt = new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.2
                @Override // java.lang.Runnable
                public void run() {
                    if (AlaGiftTabActivity.this.aKi != null && AlaGiftTabActivity.this.aKi.getEditView() != null) {
                        AlaGiftTabActivity.this.aKi.getEditView().requestFocus();
                        BdUtilHelper.showSoftKeyPad(AlaGiftTabActivity.this, AlaGiftTabActivity.this.aKi.getEditView());
                    }
                }
            };
        }
        return this.aKt;
    }

    private Runnable zK() {
        if (this.aKu == null) {
            this.aKu = new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.3
                @Override // java.lang.Runnable
                public void run() {
                    if (AlaGiftTabActivity.this.aKi != null && AlaGiftTabActivity.this.aKi.getEditView() != null) {
                        BdUtilHelper.hideSoftKeyPad(AlaGiftTabActivity.this, AlaGiftTabActivity.this.aKi.getEditView());
                    }
                }
            };
        }
        return this.aKu;
    }

    private void zL() {
        if (this.aKi != null) {
            this.aKi.setVisibility(8);
        }
    }

    private void b(AlaLiveGiftUIInfo alaLiveGiftUIInfo) {
        if (alaLiveGiftUIInfo != null && this.aKe != null) {
            this.aKe.setColors(alaLiveGiftUIInfo.getTabBgSelectedColor(), alaLiveGiftUIInfo.getTabBgUnSelectedColor(), alaLiveGiftUIInfo.getTabTextSelectedColor(), alaLiveGiftUIInfo.getTabTextUnSelectedColor());
        }
    }

    private void c(AlaLiveGiftUIInfo alaLiveGiftUIInfo) {
        SupportXFragment[] supportXFragmentArr;
        if (alaLiveGiftUIInfo != null && alaLiveGiftUIInfo.getCategoryTextSelectedColor() != 0 && (this.aKg.getAdapter() instanceof GiftPanelFragmentPagerAdapter) && ((GiftPanelFragmentPagerAdapter) this.aKg.getAdapter()).Bm() != null && this.aKv != null) {
            for (SupportXFragment supportXFragment : this.aKv) {
                if (supportXFragment instanceof com.baidu.live.gift.panel.c) {
                    ((com.baidu.live.gift.panel.c) supportXFragment).cf(alaLiveGiftUIInfo.getCategoryTextSelectedColor());
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
            linearLayout.addView(view, new LinearLayout.LayoutParams(-1, zE()));
            this.mContentLayout.addView(linearLayout, 0);
            simpleDraweeView.setController(com.facebook.drawee.a.a.c.dzW().c(simpleDraweeView.getController()).bc(ImageRequestBuilder.ac(Uri.parse(alaLiveGiftUIInfo.getVerticalBgUrl())).a(com.facebook.imagepipeline.common.e.dDb()).a(com.facebook.imagepipeline.common.b.dCQ().c(Bitmap.Config.RGB_565).dCY()).dHb()).wy(true).c(new com.facebook.drawee.controller.c<com.facebook.imagepipeline.g.f>() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.4
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
                public void fb(String str) {
                }
            }).dAN());
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

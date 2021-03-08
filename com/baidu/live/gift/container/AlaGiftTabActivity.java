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
    private RoundRectFrameLayout bbT;
    private View bbU;
    private TextView bbV;
    private GiftPanelCountBadgeView bbW;
    private NobleGiftEntryView bbX;
    private ScrollEnableViewPager bbY;
    private FrameLayout bbZ;
    private AlaLiveInputEditView bca;
    private GiftPanelDrawContainerView bcb;
    private TextView bcc;
    private ViewTreeObserver.OnGlobalLayoutListener bcd;
    private int bce;
    private int bcf;
    private int bck;
    private com.baidu.live.gift.panel.b bcl;
    private Runnable bcm;
    private Runnable bcn;
    private SupportXFragment[] bco;
    private boolean mIsKeyboardOpen;
    private View mRootView;
    private boolean bcg = false;
    private boolean aXT = false;
    private boolean bch = false;
    private boolean bci = false;
    private boolean bcj = true;

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
            Gg();
            initView();
            this.bcl.a(this, this);
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
        this.bcd = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                AlaGiftTabActivity.this.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(AlaGiftTabActivity.this.getPageContext().getPageActivity());
                int[] screenDimensions = BdUtilHelper.getScreenDimensions(AlaGiftTabActivity.this.getPageContext().getPageActivity());
                boolean z = AlaGiftTabActivity.this.bce != rect.bottom;
                AlaGiftTabActivity.this.bce = rect.bottom;
                if (screenDimensions[1] - rect.bottom > screenDimensions[1] / 4 && (!AlaGiftTabActivity.this.mIsKeyboardOpen || z)) {
                    AlaGiftTabActivity.this.mIsKeyboardOpen = true;
                    AlaGiftTabActivity.this.onKeyboardVisibilityChanged(true);
                } else if (screenDimensions[1] - rect.height() <= statusBarHeight && AlaGiftTabActivity.this.mIsKeyboardOpen) {
                    AlaGiftTabActivity.this.mIsKeyboardOpen = false;
                    AlaGiftTabActivity.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.bcd);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.bca != null && this.bca.getVisibility() == 0) {
                AsyncTask.execute(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.5
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            new Instrumentation().sendKeyDownUpSync(4);
                        } catch (Exception e) {
                            AlaGiftTabActivity.this.bca.post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.5.1
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
            } else if (view == this.bbT) {
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
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bca.getLayoutParams();
            layoutParams.topMargin = statusBarHeight;
            this.bca.setLayoutParams(layoutParams);
            if (!this.bcj) {
                this.bca.setVisibility(0);
                return;
            }
            return;
        }
        if (this.bco != null) {
            for (SupportXFragment supportXFragment : this.bco) {
                if ((supportXFragment instanceof com.baidu.live.gift.panel.c) && ((com.baidu.live.gift.panel.c) supportXFragment).bik != null) {
                    ((com.baidu.live.gift.panel.c) supportXFragment).bik.GC();
                }
            }
        }
        Gq();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.bca != null && this.bca.getVisibility() == 0) {
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
                if (this.bbT != null && alaLiveGiftUIInfo.getBgColor() != 0) {
                    Drawable background = this.bbT.getBackground();
                    if (background instanceof GradientDrawable) {
                        ((GradientDrawable) background).setColor(alaLiveGiftUIInfo.getBgColor());
                        this.bbT.setBackgroundDrawable(background);
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
        this.bco = supportXFragmentArr;
        if (this.bbZ != null) {
            this.bbZ.removeAllViews();
            if (this.bco != null) {
                for (SupportXFragment supportXFragment : this.bco) {
                    supportXFragment.onCreateView(null, null, null);
                    supportXFragment.onActivityCreated(null);
                    this.bbZ.addView(supportXFragment.getView(), new ViewGroup.LayoutParams(-1, -1));
                }
            }
        }
        cW(i);
    }

    @Override // com.baidu.live.gift.container.AlaGiftTabView.a
    public void Gc() {
        cW(0);
    }

    @Override // com.baidu.live.gift.container.AlaGiftTabView.a
    public void cV(int i) {
        if (this.bbW != null) {
            if (Gn() instanceof com.baidu.live.gift.panel.e) {
                com.baidu.live.d.xf().putInt("gift_package_list_flag", 0);
                i = 0;
            }
            if (i > 0) {
                this.bbW.setCount(i);
                this.bbW.setVisibility(0);
                return;
            }
            this.bbW.setVisibility(4);
        }
    }

    @Override // com.baidu.live.gift.container.AlaGiftTabView.a
    public void c(boolean z, int i) {
        if (this.bca != null && this.bca.getEditView() != null) {
            if (z) {
                this.bca.setMaxText(String.valueOf(i));
                this.bca.setHintText(String.format(Locale.getDefault(), getString(a.h.ala_send_gift_count_hint), Integer.valueOf(i)));
                this.bca.Md();
                this.bca.getEditView().setFocusable(true);
                this.bca.getEditView().setFocusableInTouchMode(true);
                this.bca.getEditView().postDelayed(Go(), 100L);
                return;
            }
            Gq();
            this.bca.getEditView().post(Gp());
        }
    }

    @Override // com.baidu.live.gift.container.AlaGiftTabView.a
    public void j(boolean z, String str) {
        if (this.bcb != null) {
            if (z) {
                if (Build.VERSION.SDK_INT != 26) {
                    setRequestedOrientation(1);
                    this.bcg = true;
                }
                this.bcb.setVisibility(0);
            } else {
                if (Build.VERSION.SDK_INT != 26 && this.bcg) {
                    setRequestedOrientation(3);
                    this.bcg = false;
                }
                this.bcb.setVisibility(8);
            }
            this.bcb.l(z, str);
        }
    }

    @Override // com.baidu.live.gift.container.AlaGiftTabView.a
    public void a(g gVar) {
        if (this.bcb != null) {
            this.bcb.setGiftItem(gVar);
        }
    }

    @Override // com.baidu.live.gift.panel.b.a
    public k Gd() {
        if (this.bcb != null) {
            return this.bcb.getGraffitiData();
        }
        return null;
    }

    @Override // com.baidu.live.gift.panel.b.a
    public void a(NobleUserInfo.a aVar) {
        if (this.bbX != null) {
            this.bbX.setData(aVar);
        }
    }

    @Override // com.baidu.live.gift.container.AlaGiftTabView.a
    public void g(String str, String str2, boolean z) {
        int dimensionPixelOffset;
        if (this.bcc != null) {
            if (TextUtils.isEmpty(str)) {
                this.bcc.setText("");
                this.bcc.setVisibility(8);
                return;
            }
            Drawable background = this.bcc.getBackground();
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
                this.bcc.setBackgroundDrawable(background);
            }
            this.bcc.setText(str);
            this.bcc.setTag(str2);
            this.bcc.setVisibility(0);
            ViewGroup.LayoutParams layoutParams = this.bcc.getLayoutParams();
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
                    this.bcc.setLayoutParams(layoutParams);
                }
            }
        }
    }

    @Override // com.baidu.live.gift.container.AlaGiftTabView.a
    public void u(int i, String str) {
        if (this.bcl != null) {
            this.bcl.u(i, str);
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
        getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.bcd);
        if (this.bcl != null) {
            this.bcl.release();
        }
        if (this.bco != null) {
            for (SupportXFragment supportXFragment : this.bco) {
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
        if (!this.aXT) {
            this.mRootView.setVisibility(0);
            Ge();
            this.aXT = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.bcj = false;
        if (this.bco != null) {
            for (SupportXFragment supportXFragment : this.bco) {
                supportXFragment.onResume();
            }
        }
        if (this.bcl != null) {
            this.bcl.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.bcj = true;
        if (this.bco != null) {
            for (SupportXFragment supportXFragment : this.bco) {
                supportXFragment.onPause();
            }
        }
        if (this.bcl != null) {
            this.bcl.onPause();
        }
    }

    private void Ge() {
        Animation loadAnimation;
        this.bch = true;
        if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0201a.sdk_in_from_right);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0201a.sdk_in_from_bottom);
        }
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                AlaGiftTabActivity.this.bch = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        if (this.mRootView != null) {
            this.mRootView.startAnimation(loadAnimation);
        }
    }

    private void Gf() {
        Animation loadAnimation;
        if (!this.bci && !this.bch) {
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0201a.sdk_out_to_right);
            } else {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0201a.sdk_out_to_bottom);
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
            this.bci = true;
            if (this.mRootView != null) {
                this.mRootView.startAnimation(loadAnimation);
            }
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        Gf();
    }

    private void Gg() {
        this.bcl = new com.baidu.live.gift.panel.b(getPageContext());
        this.bcl.init(getIntent());
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
        this.bch = false;
        this.mRootView.setVisibility(4);
        Gh();
        bG(z);
        bH(z);
        bI(z);
        bJ(z);
        bK(z);
        Gi();
        Gj();
        bL(z);
    }

    private void Gh() {
        this.bbT = (RoundRectFrameLayout) findViewById(a.f.layout_content);
        this.bbU = findViewById(a.f.layout_tab);
        this.bbV = (TextView) findViewById(a.f.tv_tab_text);
        this.bbW = (GiftPanelCountBadgeView) findViewById(a.f.layout_tab_badge_count);
        this.bbX = (NobleGiftEntryView) findViewById(a.f.noble_entry);
        this.bbY = (ScrollEnableViewPager) findViewById(a.f.vp);
        this.bbZ = (FrameLayout) findViewById(a.f.layout_supportx);
        this.bca = (AlaLiveInputEditView) findViewById(a.f.edit_num);
        this.bcb = (GiftPanelDrawContainerView) findViewById(a.f.container_draw);
        this.bcc = (TextView) findViewById(a.f.gift_toast);
    }

    private void bG(boolean z) {
        this.bbT.setClickable(true);
        if (Build.VERSION.SDK_INT >= 26) {
            this.bbT.setDefaultFocusHighlightEnabled(false);
        }
        this.bbT.setBackgroundColor(getResources().getColor(a.c.live_gift_panel_primary));
        float dimensionPixelOffset = getResources().getDimensionPixelOffset(a.d.sdk_ds26);
        if (z) {
            this.bbT.setCornerRadius(dimensionPixelOffset, 0.0f, 0.0f, dimensionPixelOffset);
        } else {
            this.bbT.setCornerRadius(dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f);
        }
        if (z) {
            ViewGroup.LayoutParams layoutParams = this.bbT.getLayoutParams();
            layoutParams.width = ScreenHelper.getRealScreenHeight(this);
            this.bbT.setLayoutParams(layoutParams);
        }
    }

    private void bH(boolean z) {
        if (!z) {
            ViewGroup.LayoutParams layoutParams = this.bbU.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                ((FrameLayout.LayoutParams) layoutParams).gravity |= 80;
                ((FrameLayout.LayoutParams) layoutParams).bottomMargin = Gk();
                this.bbU.setLayoutParams(layoutParams);
            }
        }
        this.bbU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaGiftTabActivity.this.cW(1);
            }
        });
        this.bbW.setPlusThreshold(99, false);
    }

    private void bI(boolean z) {
        if (this.bcl == null || !this.bcl.HQ()) {
            this.bbX.setVisibility(8);
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.bbX.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            if (z) {
                ((FrameLayout.LayoutParams) layoutParams).topMargin = Gl();
            } else {
                ((FrameLayout.LayoutParams) layoutParams).gravity = 80;
                ((FrameLayout.LayoutParams) layoutParams).bottomMargin = getDataPagerHeight() + Gm();
            }
            this.bbX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AlaGiftTabActivity.this.bcl != null) {
                        AlaGiftTabActivity.this.bcl.HR();
                    }
                }
            });
        }
    }

    private void bJ(boolean z) {
        this.bbY.setScrollEnabled(false);
        ViewGroup.LayoutParams layoutParams = this.bbY.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.height = -1;
            } else {
                layoutParams.height = Gl() + Gk();
            }
            this.bbY.setLayoutParams(layoutParams);
        }
    }

    private void bK(boolean z) {
        ViewGroup.LayoutParams layoutParams = this.bbZ.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.height = -1;
            } else {
                layoutParams.height = getResources().getDimensionPixelOffset(a.d.sdk_ds116) + Gk();
            }
            this.bbZ.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.live.gift.container.AlaGiftTabActivity$10  reason: invalid class name */
    /* loaded from: classes10.dex */
    public class AnonymousClass10 implements c.a {
        AnonymousClass10() {
        }

        @Override // com.baidu.live.view.input.c.a
        public void gF(String str) {
            String str2;
            AsyncTask.execute(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.10.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        new Instrumentation().sendKeyDownUpSync(4);
                    } catch (Exception e) {
                        AlaGiftTabActivity.this.bca.post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.10.1.1
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
            com.baidu.live.gift.panel.c Gn = AlaGiftTabActivity.this.Gn();
            if ((!(Gn instanceof com.baidu.live.gift.panel.e) || !((com.baidu.live.gift.panel.e) Gn).gW(str2)) && Gn != null && Gn.bik != null) {
                Gn.bik.gI(str2);
            }
        }
    }

    private void Gi() {
        this.bca.setEditViewConfirmCallBack(new AnonymousClass10());
    }

    private void Gj() {
        this.bcb.setCallback(new GiftPanelDrawContainerView.a() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.11
            @Override // com.baidu.live.gift.widget.panel.GiftPanelDrawContainerView.a
            public void cX(int i) {
                com.baidu.live.gift.panel.c Gn = AlaGiftTabActivity.this.Gn();
                if (Gn != null && Gn.bik != null) {
                    Gn.bik.dg(i);
                }
            }

            @Override // com.baidu.live.gift.widget.panel.GiftPanelDrawContainerView.a
            public void Gr() {
                AlaGiftTabActivity.this.finish();
            }
        });
    }

    private void bL(boolean z) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(BdUtilHelper.dip2px(this, 5.0f));
        this.bcc.setBackgroundDrawable(gradientDrawable);
        if (z) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bcc.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            layoutParams.addRule(5, this.bbT.getId());
            layoutParams.addRule(2, 0);
            layoutParams.rightMargin = 0;
            layoutParams.addRule(12);
            this.bcc.setLayoutParams(layoutParams);
            this.bcc.setGravity(17);
            int dimens = BdUtilHelper.getDimens(this, a.d.sdk_ds12);
            this.bcc.setPadding(dimens, dimens, dimens, dimens);
        }
        this.bcc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaGiftTabActivity.this.bcl != null) {
                    Object tag = AlaGiftTabActivity.this.bcc.getTag();
                    if ((tag instanceof String) && !TextUtils.isEmpty((String) tag)) {
                        AlaGiftTabActivity.this.bcl.gV((String) tag);
                    }
                }
            }
        });
    }

    private int Gk() {
        if (this.bcf <= 0) {
            this.bcf = getDataPagerHeight();
            if (this.bcl != null && this.bcl.HQ()) {
                this.bcf += Gm() + getResources().getDimensionPixelOffset(a.d.sdk_ds72);
            }
        }
        return this.bcf;
    }

    private int getDataPagerHeight() {
        return (getResources().getDimensionPixelOffset(a.d.sdk_ds192) * 2) + getResources().getDimensionPixelOffset(a.d.sdk_ds4) + getResources().getDimensionPixelOffset(a.d.sdk_ds12) + getResources().getDimensionPixelOffset(a.d.sdk_ds116);
    }

    private int Gl() {
        return getResources().getDimensionPixelOffset(a.d.sdk_ds116);
    }

    private int Gm() {
        return getResources().getDimensionPixelOffset(a.d.sdk_ds24);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.live.gift.panel.c Gn() {
        if (this.bco == null || this.bco.length <= this.bck || !(this.bco[this.bck] instanceof com.baidu.live.gift.panel.c)) {
            return null;
        }
        return (com.baidu.live.gift.panel.c) this.bco[this.bck];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cW(int i) {
        this.bck = i;
        if (this.bbU != null) {
            this.bbU.setVisibility(i == 1 ? 4 : 0);
            AlaGiftTabView.page = i;
        }
        if (this.bco != null) {
            int i2 = 0;
            while (i2 < this.bco.length) {
                this.bco[i2].setUserVisibleHint(i2 == i);
                if ((this.bco[i2] instanceof com.baidu.live.gift.panel.c) && ((com.baidu.live.gift.panel.c) this.bco[i2]).bik != null) {
                    ((com.baidu.live.gift.panel.c) this.bco[i2]).bik.bO(i2 == i);
                }
                if (this.bco[i2].getView() != null) {
                    this.bco[i2].getView().setVisibility(i2 == i ? 0 : 8);
                }
                i2++;
            }
            cV(0);
        }
    }

    private Runnable Go() {
        if (this.bcm == null) {
            this.bcm = new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.2
                @Override // java.lang.Runnable
                public void run() {
                    if (AlaGiftTabActivity.this.bca != null && AlaGiftTabActivity.this.bca.getEditView() != null) {
                        AlaGiftTabActivity.this.bca.getEditView().requestFocus();
                        BdUtilHelper.showSoftKeyPad(AlaGiftTabActivity.this, AlaGiftTabActivity.this.bca.getEditView());
                    }
                }
            };
        }
        return this.bcm;
    }

    private Runnable Gp() {
        if (this.bcn == null) {
            this.bcn = new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.3
                @Override // java.lang.Runnable
                public void run() {
                    if (AlaGiftTabActivity.this.bca != null && AlaGiftTabActivity.this.bca.getEditView() != null) {
                        BdUtilHelper.hideSoftKeyPad(AlaGiftTabActivity.this, AlaGiftTabActivity.this.bca.getEditView());
                    }
                }
            };
        }
        return this.bcn;
    }

    private void Gq() {
        if (this.bca != null) {
            this.bca.setVisibility(8);
        }
    }

    private void b(AlaLiveGiftUIInfo alaLiveGiftUIInfo) {
        if (alaLiveGiftUIInfo != null && this.bbV != null) {
            this.bbV.setTextColor(alaLiveGiftUIInfo.getTabTextUnSelectedColor());
        }
    }

    private void c(AlaLiveGiftUIInfo alaLiveGiftUIInfo) {
        SupportXFragment[] supportXFragmentArr;
        if (alaLiveGiftUIInfo != null && alaLiveGiftUIInfo.getCategoryTextSelectedColor() != 0 && (this.bbY.getAdapter() instanceof GiftPanelFragmentPagerAdapter) && ((GiftPanelFragmentPagerAdapter) this.bbY.getAdapter()).HZ() != null && this.bco != null) {
            for (SupportXFragment supportXFragment : this.bco) {
                if (supportXFragment instanceof com.baidu.live.gift.panel.c) {
                    ((com.baidu.live.gift.panel.c) supportXFragment).cY(alaLiveGiftUIInfo.getCategoryTextSelectedColor());
                }
            }
        }
    }

    private void d(final AlaLiveGiftUIInfo alaLiveGiftUIInfo) {
        if (alaLiveGiftUIInfo != null && !TextUtils.isEmpty(alaLiveGiftUIInfo.getVerticalBgUrl()) && this.bbT != null) {
            LinearLayout linearLayout = new LinearLayout(this.bbT.getContext());
            linearLayout.setBackgroundColor(0);
            linearLayout.setOrientation(1);
            SimpleDraweeView simpleDraweeView = new SimpleDraweeView(linearLayout.getContext());
            simpleDraweeView.setScaleType(ImageView.ScaleType.FIT_XY);
            linearLayout.addView(simpleDraweeView, new LinearLayout.LayoutParams(-1, -1));
            View view = new View(linearLayout.getContext());
            view.setBackgroundColor(0);
            linearLayout.addView(view, new LinearLayout.LayoutParams(-1, Gk()));
            this.bbT.addView(linearLayout, 0);
            simpleDraweeView.setController(com.facebook.drawee.a.a.c.etF().c(simpleDraweeView.getController()).bq(ImageRequestBuilder.ag(Uri.parse(alaLiveGiftUIInfo.getVerticalBgUrl())).a(com.facebook.imagepipeline.common.e.ewE()).a(com.facebook.imagepipeline.common.b.ewu().e(Bitmap.Config.RGB_565).ewC()).eAz()).Bk(true).c(new com.facebook.drawee.controller.c<com.facebook.imagepipeline.f.f>() { // from class: com.baidu.live.gift.container.AlaGiftTabActivity.4
                @Override // com.facebook.drawee.controller.c
                public void g(String str, Object obj) {
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
                public void h(String str, com.facebook.imagepipeline.f.f fVar) {
                }

                @Override // com.facebook.drawee.controller.c
                public void g(String str, Throwable th) {
                }

                @Override // com.facebook.drawee.controller.c
                public void h(String str, Throwable th) {
                }

                @Override // com.facebook.drawee.controller.c
                public void gE(String str) {
                }
            }).euw());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaLiveGiftUIInfo alaLiveGiftUIInfo, int i, int i2) {
        if (this.bbT != null && i != 0 && i2 != 0) {
            View childAt = this.bbT.getChildAt(0);
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
                                this.bbT.setBackgroundColor(0);
                                linearLayout.getChildAt(1).setBackgroundColor(alaLiveGiftUIInfo.getBgColor());
                            }
                        }
                    }
                }
            }
        }
    }
}

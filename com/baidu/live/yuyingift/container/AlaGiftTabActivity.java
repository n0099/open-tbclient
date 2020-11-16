package com.baidu.live.yuyingift.container;

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
import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.data.PersonUserData;
import com.baidu.live.data.bn;
import com.baidu.live.gift.g;
import com.baidu.live.gift.k;
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
import com.baidu.live.yuyingift.container.AlaGiftTabView;
import com.baidu.live.yuyingift.panel.GiftPanelFragmentPagerAdapter;
import com.baidu.live.yuyingift.panel.a;
import com.baidu.live.yuyingift.widget.panel.GiftPanelDrawContainerView;
import com.baidu.live.yuyingift.widget.panel.GiftPanelSelectMicrophoneSendView;
import com.baidu.live.yuyingift.widget.panel.GiftPanelTabView;
import com.facebook.imagepipeline.g.f;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.util.List;
import java.util.Locale;
/* loaded from: classes4.dex */
public class AlaGiftTabActivity extends BaseFragmentActivity implements View.OnTouchListener, AlaGiftTabView.a, a.InterfaceC0237a {
    private View aXe;
    private NobleGiftEntryView aXg;
    private ScrollEnableViewPager aXh;
    private FrameLayout aXi;
    private AlaLiveInputEditView aXj;
    private TextView aXl;
    private ViewTreeObserver.OnGlobalLayoutListener aXm;
    private int aXn;
    private int aXo;
    private Runnable aXu;
    private Runnable aXv;
    private SupportXFragment[] aXw;
    private GiftPanelSelectMicrophoneSendView bOr;
    private GiftPanelTabView bOs;
    private GiftPanelDrawContainerView bOt;
    private com.baidu.live.yuyingift.panel.a bOu;
    private ViewGroup mContentLayout;
    private boolean mIsKeyboardOpen;
    private View mRootView;
    private boolean aXp = false;
    private boolean aTr = false;
    private boolean aXq = false;
    private boolean aXr = false;
    private boolean aXs = true;

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
            Hp();
            initView();
            this.bOu.a(this, this);
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
        this.aXm = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabActivity.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                AlaGiftTabActivity.this.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(AlaGiftTabActivity.this.getPageContext().getPageActivity());
                int[] screenDimensions = BdUtilHelper.getScreenDimensions(AlaGiftTabActivity.this.getPageContext().getPageActivity());
                boolean z = AlaGiftTabActivity.this.aXn != rect.bottom;
                AlaGiftTabActivity.this.aXn = rect.bottom;
                if (screenDimensions[1] - rect.bottom > screenDimensions[1] / 4 && (!AlaGiftTabActivity.this.mIsKeyboardOpen || z)) {
                    AlaGiftTabActivity.this.mIsKeyboardOpen = true;
                    AlaGiftTabActivity.this.onKeyboardVisibilityChanged(true);
                } else if (screenDimensions[1] - rect.height() <= statusBarHeight && AlaGiftTabActivity.this.mIsKeyboardOpen) {
                    AlaGiftTabActivity.this.mIsKeyboardOpen = false;
                    AlaGiftTabActivity.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.aXm);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.aXj != null && this.aXj.getVisibility() == 0) {
                AsyncTask.execute(new Runnable() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabActivity.8
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            new Instrumentation().sendKeyDownUpSync(4);
                        } catch (Exception e) {
                            AlaGiftTabActivity.this.aXj.post(new Runnable() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabActivity.8.1
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
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aXj.getLayoutParams();
            layoutParams.topMargin = statusBarHeight;
            this.aXj.setLayoutParams(layoutParams);
            if (!this.aXs) {
                this.aXj.setVisibility(0);
                return;
            }
            return;
        }
        if (this.aXw != null) {
            for (SupportXFragment supportXFragment : this.aXw) {
                if ((supportXFragment instanceof com.baidu.live.yuyingift.panel.b) && ((com.baidu.live.yuyingift.panel.b) supportXFragment).bPR != null) {
                    ((com.baidu.live.yuyingift.panel.b) supportXFragment).bPR.HL();
                }
            }
        }
        Hz();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.aXj != null && this.aXj.getVisibility() == 0) {
            c(false, 0);
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.baidu.live.yuyingift.panel.a.InterfaceC0237a
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

    @Override // com.baidu.live.yuyingift.panel.a.InterfaceC0237a
    public GiftPanelSelectMicrophoneSendView.i WQ() {
        if (this.bOr != null) {
            return this.bOr.getSelectMicrophoneList();
        }
        return null;
    }

    @Override // com.baidu.live.yuyingift.panel.a.InterfaceC0237a
    public void a(List<AlaWheatInfoData> list, List<AlaWheatInfoData> list2, String[] strArr) {
        if (this.bOr != null) {
            this.bOr.b(list, list2, strArr);
        }
    }

    @Override // com.baidu.live.yuyingift.panel.a.InterfaceC0237a
    public void a(final PersonUserData personUserData, AlaWheatInfoData alaWheatInfoData) {
        if (this.bOr != null) {
            this.bOr.setAttentionAndInfo(personUserData);
            this.bOr.setCallback(new GiftPanelSelectMicrophoneSendView.c() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabActivity.9
                @Override // com.baidu.live.yuyingift.widget.panel.GiftPanelSelectMicrophoneSendView.c
                public void a(AlaWheatInfoData alaWheatInfoData2) {
                    AlaGiftTabActivity.this.bOu.a(alaWheatInfoData2, true);
                }

                @Override // com.baidu.live.yuyingift.widget.panel.GiftPanelSelectMicrophoneSendView.c
                public void b(AlaWheatInfoData alaWheatInfoData2) {
                    AlaGiftTabActivity.this.bOu.a(personUserData, alaWheatInfoData2, AlaGiftTabActivity.this.getIntent());
                    AlaGiftTabActivity.this.finish();
                }
            });
        }
    }

    @Override // com.baidu.live.yuyingift.panel.a.InterfaceC0237a
    public void WR() {
        if (this.bOr != null) {
            this.bOr.WR();
        }
    }

    @Override // com.baidu.live.yuyingift.panel.a.InterfaceC0237a
    public void a(int i, SupportXFragment... supportXFragmentArr) {
        SupportXFragment[] supportXFragmentArr2;
        this.aXw = supportXFragmentArr;
        if (this.aXi != null) {
            this.aXi.removeAllViews();
            if (this.aXw != null) {
                for (SupportXFragment supportXFragment : this.aXw) {
                    supportXFragment.onCreateView(null, null, null);
                    supportXFragment.onActivityCreated(null);
                    this.aXi.addView(supportXFragment.getView(), new ViewGroup.LayoutParams(-1, -1));
                }
            }
        }
        ed(i);
    }

    @Override // com.baidu.live.yuyingift.container.AlaGiftTabView.a
    public void c(boolean z, int i) {
        if (this.aXj != null && this.aXj.getEditView() != null) {
            if (z) {
                this.aXj.setMaxText(String.valueOf(i));
                this.aXj.setHintText(String.format(Locale.getDefault(), getString(a.h.ala_send_gift_count_hint), Integer.valueOf(i)));
                this.aXj.Mx();
                this.aXj.getEditView().setFocusable(true);
                this.aXj.getEditView().setFocusableInTouchMode(true);
                this.aXj.getEditView().postDelayed(Hx(), 100L);
                return;
            }
            Hz();
            this.aXj.getEditView().post(Hy());
        }
    }

    @Override // com.baidu.live.yuyingift.container.AlaGiftTabView.a
    public void f(boolean z, String str) {
        if (this.bOt != null) {
            if (z) {
                if (Build.VERSION.SDK_INT != 26) {
                    setRequestedOrientation(1);
                    this.aXp = true;
                }
                this.bOt.setVisibility(0);
            } else {
                if (Build.VERSION.SDK_INT != 26 && this.aXp) {
                    setRequestedOrientation(3);
                    this.aXp = false;
                }
                this.bOt.setVisibility(8);
            }
            this.bOt.h(z, str);
        }
    }

    @Override // com.baidu.live.yuyingift.container.AlaGiftTabView.a
    public void a(g gVar) {
        if (this.bOt != null) {
            this.bOt.setGiftItem(gVar);
        }
    }

    @Override // com.baidu.live.yuyingift.panel.a.InterfaceC0237a
    public k Hm() {
        if (this.bOt != null) {
            return this.bOt.getGraffitiData();
        }
        return null;
    }

    @Override // com.baidu.live.yuyingift.panel.a.InterfaceC0237a
    public void a(NobleUserInfo.a aVar) {
        if (this.aXg != null) {
            bn bnVar = com.baidu.live.aa.a.Ph().bsh;
            if (bnVar != null && bnVar.aNP.aQn) {
                this.aXg.setVisibility(0);
                this.aXg.setData(aVar);
                return;
            }
            this.aXg.setVisibility(8);
        }
    }

    @Override // com.baidu.live.yuyingift.container.AlaGiftTabView.a
    public void as(String str, String str2) {
        if (this.aXl != null) {
            if (!TextUtils.isEmpty(str)) {
                this.aXl.setText(str);
                this.aXl.setTag(str2);
                this.aXl.setVisibility(0);
                return;
            }
            this.aXl.setText("");
            this.aXl.setVisibility(8);
        }
    }

    @Override // com.baidu.live.yuyingift.panel.a.InterfaceC0237a
    public void onClose() {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        SupportXFragment[] supportXFragmentArr;
        super.onDestroy();
        getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.aXm);
        if (this.bOu != null) {
            this.bOu.release();
        }
        if (this.aXw != null) {
            for (SupportXFragment supportXFragment : this.aXw) {
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
        if (!this.aTr) {
            this.mRootView.setVisibility(0);
            Hn();
            this.aTr = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.aXs = false;
        if (this.aXw != null) {
            for (SupportXFragment supportXFragment : this.aXw) {
                supportXFragment.onResume();
            }
        }
        UtilHelper.changeStatusBarIconAndTextColor(true, getPageContext().getPageActivity());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.aXs = true;
        if (this.aXw != null) {
            for (SupportXFragment supportXFragment : this.aXw) {
                supportXFragment.onPause();
            }
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
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabActivity.10
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                AlaGiftTabActivity.this.aXq = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        if (this.mRootView != null) {
            this.mRootView.startAnimation(loadAnimation);
        }
    }

    private void Ho() {
        Animation loadAnimation;
        if (!this.aXr && !this.aXq) {
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0195a.sdk_out_to_right);
            } else {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0195a.sdk_out_to_bottom);
            }
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabActivity.11
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
            this.aXr = true;
            if (this.mRootView != null) {
                this.mRootView.startAnimation(loadAnimation);
            }
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        Ho();
    }

    private void Hp() {
        this.bOu = new com.baidu.live.yuyingift.panel.a(getPageContext());
        this.bOu.init(getIntent());
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this).inflate(a.g.yuyin_live_gift_activity_panel, (ViewGroup) null);
        setContentView(this.mRootView);
        boolean z = UtilHelper.getRealScreenOrientation(getActivity()) == 2;
        if (z) {
            i.ae(this.mRootView);
            q.e(getActivity(), false);
        }
        addGlobalLayoutListener();
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        this.aXq = false;
        this.mRootView.setVisibility(4);
        Hq();
        by(z);
        bz(z);
        WS();
        bA(z);
        bB(z);
        bC(z);
        Hr();
        Hs();
        bD(z);
    }

    private void WS() {
        this.bOu.Xb();
        this.bOr.setOnSelectWheatChangeListener(new GiftPanelSelectMicrophoneSendView.f() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabActivity.12
            @Override // com.baidu.live.yuyingift.widget.panel.GiftPanelSelectMicrophoneSendView.f
            public void onChange() {
                AlaGiftTabActivity.this.bOt.Xf();
            }
        });
        this.bOr.setOnSetDataListener(new GiftPanelSelectMicrophoneSendView.g() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabActivity.13
            @Override // com.baidu.live.yuyingift.widget.panel.GiftPanelSelectMicrophoneSendView.g
            public void c(AlaWheatInfoData alaWheatInfoData) {
                AlaGiftTabActivity.this.bOu.d(alaWheatInfoData);
            }
        });
    }

    private void Hq() {
        this.mContentLayout = (ViewGroup) findViewById(a.f.layout_content);
        this.aXe = findViewById(a.f.layout_tab);
        this.bOs = (GiftPanelTabView) findViewById(a.f.tab);
        this.bOr = (GiftPanelSelectMicrophoneSendView) findViewById(a.f.yuyin_ala_gift_microphone_view);
        this.aXg = (NobleGiftEntryView) findViewById(a.f.noble_entry);
        this.aXh = (ScrollEnableViewPager) findViewById(a.f.vp);
        this.aXi = (FrameLayout) findViewById(a.f.layout_supportx);
        this.aXj = (AlaLiveInputEditView) findViewById(a.f.edit_num);
        this.bOt = (GiftPanelDrawContainerView) findViewById(a.f.container_draw);
        this.aXl = (TextView) findViewById(a.f.gift_toast);
    }

    private void by(boolean z) {
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

    private void bz(boolean z) {
        if (!z) {
            ViewGroup.LayoutParams layoutParams = this.aXe.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                ((FrameLayout.LayoutParams) layoutParams).gravity |= 80;
                ((FrameLayout.LayoutParams) layoutParams).bottomMargin = Ht();
                this.aXe.setLayoutParams(layoutParams);
            }
        }
        this.bOs.setCallback(new GiftPanelTabView.a() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabActivity.14
            @Override // com.baidu.live.yuyingift.widget.panel.GiftPanelTabView.a
            public void ee(int i) {
                AlaGiftTabActivity.this.ed(i);
            }
        });
    }

    private void bA(boolean z) {
        if (this.bOu == null || !this.bOu.IR()) {
            this.aXg.setVisibility(8);
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.aXg.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            if (z) {
                ((FrameLayout.LayoutParams) layoutParams).topMargin = Hu();
            } else {
                ((FrameLayout.LayoutParams) layoutParams).gravity = 80;
                ((FrameLayout.LayoutParams) layoutParams).bottomMargin = getDataPagerHeight() + Hv();
            }
            this.aXg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabActivity.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AlaGiftTabActivity.this.bOu != null) {
                        AlaGiftTabActivity.this.bOu.IS();
                    }
                }
            });
        }
    }

    private void bB(boolean z) {
        this.aXh.setScrollEnabled(false);
        ViewGroup.LayoutParams layoutParams = this.aXh.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.height = -1;
            } else {
                layoutParams.height = Hu() + Ht();
            }
            this.aXh.setLayoutParams(layoutParams);
        }
    }

    private void bC(boolean z) {
        ViewGroup.LayoutParams layoutParams = this.aXi.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.height = -1;
            } else {
                layoutParams.height = getResources().getDimensionPixelOffset(a.d.yuyin_ala_dimen_gift_tabbar_height) + Ht();
            }
            this.aXi.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.live.yuyingift.container.AlaGiftTabActivity$2  reason: invalid class name */
    /* loaded from: classes4.dex */
    public class AnonymousClass2 implements b.a {
        AnonymousClass2() {
        }

        @Override // com.baidu.live.view.input.b.a
        public void hh(String str) {
            AsyncTask.execute(new Runnable() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabActivity.2.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        new Instrumentation().sendKeyDownUpSync(4);
                    } catch (Exception e) {
                        AlaGiftTabActivity.this.aXj.post(new Runnable() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabActivity.2.1.1
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
            com.baidu.live.yuyingift.panel.b WT = AlaGiftTabActivity.this.WT();
            if (WT != null && WT.bPR != null) {
                WT.bPR.hk(str);
            }
        }
    }

    private void Hr() {
        this.aXj.setEditViewConfirmCallBack(new AnonymousClass2());
    }

    private void Hs() {
        this.bOt.setCallback(new GiftPanelDrawContainerView.a() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabActivity.3
            @Override // com.baidu.live.yuyingift.widget.panel.GiftPanelDrawContainerView.a
            public void ef(int i) {
                com.baidu.live.yuyingift.panel.b WT = AlaGiftTabActivity.this.WT();
                if (WT != null && WT.bPR != null) {
                    WT.bPR.en(i);
                }
            }

            @Override // com.baidu.live.yuyingift.widget.panel.GiftPanelDrawContainerView.a
            public void HA() {
                AlaGiftTabActivity.this.finish();
            }
        });
    }

    private void bD(boolean z) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(BdUtilHelper.dip2px(this, 5.0f));
        gradientDrawable.setColor(-1560281088);
        this.aXl.setBackgroundDrawable(gradientDrawable);
        if (z) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aXl.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            layoutParams.addRule(5, this.mContentLayout.getId());
            layoutParams.addRule(2, 0);
            layoutParams.rightMargin = 0;
            layoutParams.addRule(12);
            layoutParams.bottomMargin = BdUtilHelper.getDimens(this, a.d.sdk_ds90);
            this.aXl.setLayoutParams(layoutParams);
            this.aXl.setBackgroundColor(-1560281088);
            this.aXl.setGravity(17);
            int dimens = BdUtilHelper.getDimens(this, a.d.sdk_ds12);
            this.aXl.setPadding(dimens, dimens, dimens, dimens);
        }
        this.aXl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaGiftTabActivity.this.bOu != null) {
                    Object tag = AlaGiftTabActivity.this.aXl.getTag();
                    if ((tag instanceof String) && !TextUtils.isEmpty((String) tag)) {
                        AlaGiftTabActivity.this.bOu.hu((String) tag);
                    }
                }
            }
        });
    }

    private int Ht() {
        if (this.aXo <= 0) {
            this.aXo = getDataPagerHeight();
            if (this.bOu != null && this.bOu.IR()) {
                this.aXo += Hv() + getResources().getDimensionPixelOffset(a.d.yuyin_ala_dimen_gift_noble_height);
            }
        }
        return this.aXo;
    }

    private int getDataPagerHeight() {
        return (getResources().getDimensionPixelOffset(a.d.sdk_ds192) * 2) + getResources().getDimensionPixelOffset(a.d.sdk_ds4) + getResources().getDimensionPixelOffset(a.d.sdk_ds12) + getResources().getDimensionPixelOffset(a.d.sdk_ds116);
    }

    private int Hu() {
        return getResources().getDimensionPixelOffset(a.d.yuyin_ala_dimen_gift_tabbar_height);
    }

    private int Hv() {
        return getResources().getDimensionPixelOffset(a.d.yuyin_ala_dimen_gift_noblr_maginbottom);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.live.yuyingift.panel.b WT() {
        if (this.aXw == null || this.bOs == null || this.aXw.length <= this.bOs.getSelect() || !(this.aXw[this.bOs.getSelect()] instanceof com.baidu.live.yuyingift.panel.b)) {
            return null;
        }
        return (com.baidu.live.yuyingift.panel.b) this.aXw[this.bOs.getSelect()];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ed(int i) {
        if (this.bOs != null) {
            this.bOs.setSelect(i);
        }
        if (this.aXw != null) {
            int i2 = 0;
            while (i2 < this.aXw.length) {
                this.aXw[i2].setUserVisibleHint(i2 == i);
                if ((this.aXw[i2] instanceof com.baidu.live.yuyingift.panel.b) && ((com.baidu.live.yuyingift.panel.b) this.aXw[i2]).bPR != null) {
                    ((com.baidu.live.yuyingift.panel.b) this.aXw[i2]).bPR.bG(i2 == i);
                }
                if (this.aXw[i2].getView() != null) {
                    this.aXw[i2].getView().setVisibility(i2 == i ? 0 : 8);
                }
                i2++;
            }
        }
    }

    private Runnable Hx() {
        if (this.aXu == null) {
            this.aXu = new Runnable() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabActivity.5
                @Override // java.lang.Runnable
                public void run() {
                    if (AlaGiftTabActivity.this.aXj != null && AlaGiftTabActivity.this.aXj.getEditView() != null) {
                        AlaGiftTabActivity.this.aXj.getEditView().requestFocus();
                        BdUtilHelper.showSoftKeyPad(AlaGiftTabActivity.this, AlaGiftTabActivity.this.aXj.getEditView());
                    }
                }
            };
        }
        return this.aXu;
    }

    private Runnable Hy() {
        if (this.aXv == null) {
            this.aXv = new Runnable() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabActivity.6
                @Override // java.lang.Runnable
                public void run() {
                    if (AlaGiftTabActivity.this.aXj != null && AlaGiftTabActivity.this.aXj.getEditView() != null) {
                        BdUtilHelper.hideSoftKeyPad(AlaGiftTabActivity.this, AlaGiftTabActivity.this.aXj.getEditView());
                    }
                }
            };
        }
        return this.aXv;
    }

    private void Hz() {
        if (this.aXj != null) {
            this.aXj.setVisibility(8);
        }
    }

    private void b(AlaLiveGiftUIInfo alaLiveGiftUIInfo) {
        if (alaLiveGiftUIInfo != null && this.bOs != null) {
            this.bOs.setColors(alaLiveGiftUIInfo.getTabBgSelectedColor(), alaLiveGiftUIInfo.getTabBgUnSelectedColor(), alaLiveGiftUIInfo.getTabTextSelectedColor(), alaLiveGiftUIInfo.getTabTextUnSelectedColor());
        }
    }

    private void c(AlaLiveGiftUIInfo alaLiveGiftUIInfo) {
        SupportXFragment[] supportXFragmentArr;
        if (alaLiveGiftUIInfo != null && alaLiveGiftUIInfo.getCategoryTextSelectedColor() != 0 && (this.aXh.getAdapter() instanceof GiftPanelFragmentPagerAdapter) && ((GiftPanelFragmentPagerAdapter) this.aXh.getAdapter()).Ja() != null && this.aXw != null) {
            for (SupportXFragment supportXFragment : this.aXw) {
                if (supportXFragment instanceof com.baidu.live.yuyingift.panel.b) {
                    ((com.baidu.live.yuyingift.panel.b) supportXFragment).eg(alaLiveGiftUIInfo.getCategoryTextSelectedColor());
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
            linearLayout.addView(view, new LinearLayout.LayoutParams(-1, Ht()));
            this.mContentLayout.addView(linearLayout, 0);
            simpleDraweeView.setController(com.facebook.drawee.a.a.c.ekQ().c(simpleDraweeView.getController()).bo(ImageRequestBuilder.ae(Uri.parse(alaLiveGiftUIInfo.getVerticalBgUrl())).a(com.facebook.imagepipeline.common.e.enV()).a(com.facebook.imagepipeline.common.b.enK().c(Bitmap.Config.RGB_565).enS()).erW()).Am(true).c(new com.facebook.drawee.controller.c<f>() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabActivity.7
                @Override // com.facebook.drawee.controller.c
                public void g(String str, Object obj) {
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.facebook.drawee.controller.c
                public void a(String str, f fVar, Animatable animatable) {
                    if (fVar != null) {
                        AlaGiftTabActivity.this.a(alaLiveGiftUIInfo, fVar.getWidth(), fVar.getHeight());
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.facebook.drawee.controller.c
                /* renamed from: a */
                public void h(String str, f fVar) {
                }

                @Override // com.facebook.drawee.controller.c
                public void g(String str, Throwable th) {
                }

                @Override // com.facebook.drawee.controller.c
                public void h(String str, Throwable th) {
                }

                @Override // com.facebook.drawee.controller.c
                public void hg(String str) {
                }
            }).elH());
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

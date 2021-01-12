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
import com.baidu.live.data.bq;
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
import com.baidu.live.utils.r;
import com.baidu.live.view.ScrollEnableViewPager;
import com.baidu.live.view.input.AlaLiveInputEditView;
import com.baidu.live.view.input.c;
import com.baidu.live.yuyingift.container.AlaGiftTabView;
import com.baidu.live.yuyingift.panel.GiftPanelFragmentPagerAdapter;
import com.baidu.live.yuyingift.panel.a;
import com.baidu.live.yuyingift.widget.panel.GiftPanelDrawContainerView;
import com.baidu.live.yuyingift.widget.panel.GiftPanelTabView;
import com.baidu.live.yuyingift.widget.wheatlist.GiftPanelSelectMicrophoneSendView;
import com.facebook.imagepipeline.f.f;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.util.List;
import java.util.Locale;
/* loaded from: classes10.dex */
public class AlaGiftTabActivity extends BaseFragmentActivity implements View.OnTouchListener, AlaGiftTabView.a, a.InterfaceC0237a {
    private Runnable aXF;
    private Runnable aXG;
    private SupportXFragment[] aXH;
    private View aXn;
    private NobleGiftEntryView aXq;
    private ScrollEnableViewPager aXr;
    private FrameLayout aXs;
    private AlaLiveInputEditView aXt;
    private TextView aXv;
    private ViewTreeObserver.OnGlobalLayoutListener aXw;
    private int aXx;
    private int aXy;
    private GiftPanelSelectMicrophoneSendView bUB;
    private GiftPanelTabView bUC;
    private GiftPanelDrawContainerView bUD;
    private com.baidu.live.yuyingift.panel.a bUE;
    private ViewGroup mContentLayout;
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
            this.bUE.a(this, this);
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
        this.aXw = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabActivity.1
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
                AsyncTask.execute(new Runnable() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabActivity.8
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            new Instrumentation().sendKeyDownUpSync(4);
                        } catch (Exception e) {
                            AlaGiftTabActivity.this.aXt.post(new Runnable() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabActivity.8.1
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
                if ((supportXFragment instanceof com.baidu.live.yuyingift.panel.b) && ((com.baidu.live.yuyingift.panel.b) supportXFragment).bWl != null) {
                    ((com.baidu.live.yuyingift.panel.b) supportXFragment).bWl.Fj();
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
    public GiftPanelSelectMicrophoneSendView.d WM() {
        if (this.bUB != null) {
            return this.bUB.getSelectMicrophoneList();
        }
        return null;
    }

    @Override // com.baidu.live.yuyingift.panel.a.InterfaceC0237a
    public void a(List<AlaWheatInfoData> list, List<AlaWheatInfoData> list2, String[] strArr) {
        if (this.bUB != null) {
            this.bUB.b(list, list2, strArr);
        }
    }

    @Override // com.baidu.live.yuyingift.panel.a.InterfaceC0237a
    public void a(final PersonUserData personUserData, AlaWheatInfoData alaWheatInfoData) {
        if (this.bUB != null) {
            this.bUB.setAttentionAndInfo(personUserData);
            this.bUB.setCallback(new GiftPanelSelectMicrophoneSendView.a() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabActivity.9
                @Override // com.baidu.live.yuyingift.widget.wheatlist.GiftPanelSelectMicrophoneSendView.a
                public void a(AlaWheatInfoData alaWheatInfoData2) {
                    AlaGiftTabActivity.this.bUE.a(alaWheatInfoData2, true);
                }

                @Override // com.baidu.live.yuyingift.widget.wheatlist.GiftPanelSelectMicrophoneSendView.a
                public void b(AlaWheatInfoData alaWheatInfoData2) {
                    AlaGiftTabActivity.this.bUE.a(personUserData, alaWheatInfoData2, AlaGiftTabActivity.this.getIntent());
                    AlaGiftTabActivity.this.finish();
                }
            });
        }
    }

    @Override // com.baidu.live.yuyingift.panel.a.InterfaceC0237a
    public void WN() {
        if (this.bUB != null) {
            this.bUB.WN();
        }
    }

    @Override // com.baidu.live.yuyingift.panel.a.InterfaceC0237a
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

    @Override // com.baidu.live.yuyingift.container.AlaGiftTabView.a
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

    @Override // com.baidu.live.yuyingift.container.AlaGiftTabView.a
    public void f(boolean z, String str) {
        if (this.bUD != null) {
            if (z) {
                if (Build.VERSION.SDK_INT != 26) {
                    setRequestedOrientation(1);
                    this.aXz = true;
                }
                this.bUD.setVisibility(0);
            } else {
                if (Build.VERSION.SDK_INT != 26 && this.aXz) {
                    setRequestedOrientation(3);
                    this.aXz = false;
                }
                this.bUD.setVisibility(8);
            }
            this.bUD.h(z, str);
        }
    }

    @Override // com.baidu.live.yuyingift.container.AlaGiftTabView.a
    public void a(g gVar) {
        if (this.bUD != null) {
            this.bUD.setGiftItem(gVar);
        }
    }

    @Override // com.baidu.live.yuyingift.panel.a.InterfaceC0237a
    public k EK() {
        if (this.bUD != null) {
            return this.bUD.getGraffitiData();
        }
        return null;
    }

    @Override // com.baidu.live.yuyingift.panel.a.InterfaceC0237a
    public void a(NobleUserInfo.a aVar) {
        if (this.aXq != null) {
            bq bqVar = com.baidu.live.af.a.OJ().bxp;
            if (bqVar != null && bqVar.aMR.aPA) {
                this.aXq.setVisibility(0);
                this.aXq.setData(aVar);
                return;
            }
            this.aXq.setVisibility(8);
        }
    }

    @Override // com.baidu.live.yuyingift.container.AlaGiftTabView.a
    public void aU(String str, String str2) {
        if (this.aXv != null) {
            if (!TextUtils.isEmpty(str)) {
                this.aXv.setText(str);
                this.aXv.setTag(str2);
                this.aXv.setVisibility(0);
                return;
            }
            this.aXv.setText("");
            this.aXv.setVisibility(8);
        }
    }

    @Override // com.baidu.live.yuyingift.container.AlaGiftTabView.a
    public void WO() {
        if (this.bUB != null) {
            this.bUB.Xy();
        }
    }

    @Override // com.baidu.live.yuyingift.container.AlaGiftTabView.a
    public void WP() {
        com.baidu.live.yuyingift.b.a.Xc();
    }

    @Override // com.baidu.live.yuyingift.container.AlaGiftTabView.a
    public void WQ() {
        com.baidu.live.yuyingift.b.a.Xd();
    }

    @Override // com.baidu.live.yuyingift.container.AlaGiftTabView.a
    public void WR() {
        com.baidu.live.yuyingift.b.a.Xe();
    }

    @Override // com.baidu.live.yuyingift.container.AlaGiftTabView.a
    public void WS() {
        com.baidu.live.yuyingift.b.a.Xf();
    }

    @Override // com.baidu.live.yuyingift.container.AlaGiftTabView.a
    public void WT() {
        com.baidu.live.yuyingift.b.a.Xg();
    }

    @Override // com.baidu.live.yuyingift.container.AlaGiftTabView.a
    public void WU() {
        if (this.bUB != null) {
            this.bUB.Xz();
        }
    }

    @Override // com.baidu.live.yuyingift.container.AlaGiftTabView.a
    public void aV(String str, String str2) {
        if (this.bUB != null) {
            this.bUB.aW(str, str2);
        }
    }

    @Override // com.baidu.live.yuyingift.panel.a.InterfaceC0237a
    public void onClose() {
        finish();
    }

    @Override // com.baidu.live.yuyingift.panel.a.InterfaceC0237a
    public void WV() {
        if (this.bUB != null) {
            this.bUB.XA();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        SupportXFragment[] supportXFragmentArr;
        super.onDestroy();
        getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.aXw);
        if (this.bUE != null) {
            this.bUE.release();
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
        UtilHelper.changeStatusBarIconAndTextColor(true, getPageContext().getPageActivity());
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
    }

    private void EL() {
        this.aXA = true;
        Animation loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0194a.sdk_in_from_bottom);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabActivity.10
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
        if (!this.aXB && !this.aXA) {
            Animation loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0194a.sdk_out_to_bottom);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabActivity.11
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    AlaGiftTabActivity.super.finish();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913175));
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
        this.bUE = new com.baidu.live.yuyingift.panel.a(getPageContext());
        this.bUE.init(getIntent());
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this).inflate(a.g.yuyin_live_gift_activity_panel, (ViewGroup) null);
        setContentView(this.mRootView);
        boolean z = UtilHelper.getRealScreenOrientation(getActivity()) == 2;
        if (z) {
            i.ae(this.mRootView);
            r.e(getActivity(), false);
        }
        addGlobalLayoutListener();
        this.aXA = false;
        this.mRootView.setVisibility(4);
        EO();
        bB(z);
        bC(z);
        WW();
        bD(z);
        bE(z);
        bF(z);
        EP();
        EQ();
        bG(z);
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    private void WW() {
        this.bUE.Xl();
        this.bUB.setOnSelectWheatChangeListener(new GiftPanelSelectMicrophoneSendView.b() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabActivity.12
            @Override // com.baidu.live.yuyingift.widget.wheatlist.GiftPanelSelectMicrophoneSendView.b
            public void onChange() {
                AlaGiftTabActivity.this.bUD.Xq();
                AlaGiftTabActivity.this.WX();
            }
        });
        this.bUB.setOnSetDataListener(new GiftPanelSelectMicrophoneSendView.c() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabActivity.13
            @Override // com.baidu.live.yuyingift.widget.wheatlist.GiftPanelSelectMicrophoneSendView.c
            public void c(AlaWheatInfoData alaWheatInfoData) {
                AlaGiftTabActivity.this.bUE.d(alaWheatInfoData);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WX() {
        for (SupportXFragment supportXFragment : this.aXH) {
            ((com.baidu.live.yuyingift.panel.b) supportXFragment).WX();
        }
    }

    private void EO() {
        this.mContentLayout = (ViewGroup) findViewById(a.f.layout_content);
        this.aXn = findViewById(a.f.layout_tab);
        this.bUC = (GiftPanelTabView) findViewById(a.f.tab);
        this.bUB = (GiftPanelSelectMicrophoneSendView) findViewById(a.f.yuyin_ala_gift_microphone_view);
        this.aXq = (NobleGiftEntryView) findViewById(a.f.noble_entry);
        this.aXr = (ScrollEnableViewPager) findViewById(a.f.vp);
        this.aXs = (FrameLayout) findViewById(a.f.layout_supportx);
        this.aXt = (AlaLiveInputEditView) findViewById(a.f.edit_num);
        this.bUD = (GiftPanelDrawContainerView) findViewById(a.f.container_draw);
        this.aXv = (TextView) findViewById(a.f.gift_toast);
    }

    private void bB(boolean z) {
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

    private void bC(boolean z) {
        if (!z) {
            ViewGroup.LayoutParams layoutParams = this.aXn.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                ((FrameLayout.LayoutParams) layoutParams).gravity |= 80;
                ((FrameLayout.LayoutParams) layoutParams).bottomMargin = ER();
                this.aXn.setLayoutParams(layoutParams);
            }
        }
        this.bUC.setCallback(new GiftPanelTabView.a() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabActivity.14
            @Override // com.baidu.live.yuyingift.widget.panel.GiftPanelTabView.a
            public void dv(int i) {
                AlaGiftTabActivity.this.cQ(i);
            }
        });
    }

    private void bD(boolean z) {
        if (this.bUE == null || !this.bUE.Gx()) {
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
            this.aXq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabActivity.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AlaGiftTabActivity.this.bUE != null) {
                        AlaGiftTabActivity.this.bUE.Gy();
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
                layoutParams.height = getResources().getDimensionPixelOffset(a.d.yuyin_ala_dimen_gift_tabbar_height) + ER();
            }
            this.aXs.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.live.yuyingift.container.AlaGiftTabActivity$2  reason: invalid class name */
    /* loaded from: classes10.dex */
    public class AnonymousClass2 implements c.a {
        AnonymousClass2() {
        }

        @Override // com.baidu.live.view.input.c.a
        public void gb(String str) {
            AsyncTask.execute(new Runnable() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabActivity.2.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        new Instrumentation().sendKeyDownUpSync(4);
                    } catch (Exception e) {
                        AlaGiftTabActivity.this.aXt.post(new Runnable() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabActivity.2.1.1
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
            com.baidu.live.yuyingift.panel.b WY = AlaGiftTabActivity.this.WY();
            if (WY != null && WY.bWl != null) {
                WY.bWl.ge(str);
            }
        }
    }

    private void EP() {
        this.aXt.setEditViewConfirmCallBack(new AnonymousClass2());
    }

    private void EQ() {
        this.bUD.setGiftPanelCallback(this);
        this.bUD.setCallback(new GiftPanelDrawContainerView.a() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabActivity.3
            @Override // com.baidu.live.yuyingift.widget.panel.GiftPanelDrawContainerView.a
            public void cR(int i) {
                com.baidu.live.yuyingift.panel.b WY = AlaGiftTabActivity.this.WY();
                if (WY != null && WY.bWl != null) {
                    WY.bWl.da(i);
                }
            }

            @Override // com.baidu.live.yuyingift.widget.panel.GiftPanelDrawContainerView.a
            public void EY() {
                AlaGiftTabActivity.this.finish();
            }
        });
    }

    private void bG(boolean z) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(BdUtilHelper.dip2px(this, 5.0f));
        gradientDrawable.setColor(-1560281088);
        this.aXv.setBackgroundDrawable(gradientDrawable);
        if (z) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aXv.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            layoutParams.addRule(5, this.mContentLayout.getId());
            layoutParams.addRule(2, 0);
            layoutParams.rightMargin = 0;
            layoutParams.addRule(12);
            layoutParams.bottomMargin = BdUtilHelper.getDimens(this, a.d.sdk_ds90);
            this.aXv.setLayoutParams(layoutParams);
            this.aXv.setBackgroundColor(-1560281088);
            this.aXv.setGravity(17);
            int dimens = BdUtilHelper.getDimens(this, a.d.sdk_ds12);
            this.aXv.setPadding(dimens, dimens, dimens, dimens);
        }
        this.aXv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaGiftTabActivity.this.bUE != null) {
                    Object tag = AlaGiftTabActivity.this.aXv.getTag();
                    if ((tag instanceof String) && !TextUtils.isEmpty((String) tag)) {
                        AlaGiftTabActivity.this.bUE.gr((String) tag);
                    }
                }
            }
        });
    }

    private int ER() {
        if (this.aXy <= 0) {
            this.aXy = getDataPagerHeight();
            if (this.bUE != null && this.bUE.Gx()) {
                this.aXy += ET() + getResources().getDimensionPixelOffset(a.d.yuyin_ala_dimen_gift_noble_height);
            }
        }
        return this.aXy;
    }

    private int getDataPagerHeight() {
        return (getResources().getDimensionPixelOffset(a.d.sdk_ds192) * 2) + getResources().getDimensionPixelOffset(a.d.sdk_ds4) + getResources().getDimensionPixelOffset(a.d.sdk_ds12) + getResources().getDimensionPixelOffset(a.d.sdk_ds116);
    }

    private int ES() {
        return getResources().getDimensionPixelOffset(a.d.yuyin_ala_dimen_gift_tabbar_height);
    }

    private int ET() {
        return getResources().getDimensionPixelOffset(a.d.yuyin_ala_dimen_gift_noblr_maginbottom);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.live.yuyingift.panel.b WY() {
        if (this.aXH == null || this.bUC == null || this.aXH.length <= this.bUC.getSelect() || !(this.aXH[this.bUC.getSelect()] instanceof com.baidu.live.yuyingift.panel.b)) {
            return null;
        }
        return (com.baidu.live.yuyingift.panel.b) this.aXH[this.bUC.getSelect()];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQ(int i) {
        if (this.bUC != null) {
            this.bUC.setSelect(i);
        }
        if (this.aXH != null) {
            int i2 = 0;
            while (i2 < this.aXH.length) {
                this.aXH[i2].setUserVisibleHint(i2 == i);
                if ((this.aXH[i2] instanceof com.baidu.live.yuyingift.panel.b) && ((com.baidu.live.yuyingift.panel.b) this.aXH[i2]).bWl != null) {
                    ((com.baidu.live.yuyingift.panel.b) this.aXH[i2]).bWl.bJ(i2 == i);
                }
                if (this.aXH[i2].getView() != null) {
                    this.aXH[i2].getView().setVisibility(i2 == i ? 0 : 8);
                }
                i2++;
            }
        }
    }

    private Runnable EV() {
        if (this.aXF == null) {
            this.aXF = new Runnable() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabActivity.5
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
            this.aXG = new Runnable() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabActivity.6
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
        if (alaLiveGiftUIInfo != null && this.bUC != null) {
            this.bUC.setColors(alaLiveGiftUIInfo.getTabBgSelectedColor(), alaLiveGiftUIInfo.getTabBgUnSelectedColor(), alaLiveGiftUIInfo.getTabTextSelectedColor(), alaLiveGiftUIInfo.getTabTextUnSelectedColor());
        }
    }

    private void c(AlaLiveGiftUIInfo alaLiveGiftUIInfo) {
        SupportXFragment[] supportXFragmentArr;
        if (alaLiveGiftUIInfo != null && alaLiveGiftUIInfo.getCategoryTextSelectedColor() != 0 && (this.aXr.getAdapter() instanceof GiftPanelFragmentPagerAdapter) && ((GiftPanelFragmentPagerAdapter) this.aXr.getAdapter()).GG() != null && this.aXH != null) {
            for (SupportXFragment supportXFragment : this.aXH) {
                if (supportXFragment instanceof com.baidu.live.yuyingift.panel.b) {
                    ((com.baidu.live.yuyingift.panel.b) supportXFragment).cS(alaLiveGiftUIInfo.getCategoryTextSelectedColor());
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
            linearLayout.addView(view, new LinearLayout.LayoutParams(-1, ER()));
            this.mContentLayout.addView(linearLayout, 0);
            simpleDraweeView.setController(com.facebook.drawee.a.a.c.eqV().c(simpleDraweeView.getController()).bo(ImageRequestBuilder.ag(Uri.parse(alaLiveGiftUIInfo.getVerticalBgUrl())).a(com.facebook.imagepipeline.common.e.etV()).a(com.facebook.imagepipeline.common.b.etL().e(Bitmap.Config.RGB_565).etT()).exQ()).AT(true).c(new com.facebook.drawee.controller.c<f>() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabActivity.7
                @Override // com.facebook.drawee.controller.c
                public void f(String str, Object obj) {
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
                public void g(String str, f fVar) {
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

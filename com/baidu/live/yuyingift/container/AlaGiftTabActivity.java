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
import com.baidu.live.data.bv;
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
public class AlaGiftTabActivity extends BaseFragmentActivity implements View.OnTouchListener, AlaGiftTabView.a, a.InterfaceC0244a {
    private View bbU;
    private NobleGiftEntryView bbX;
    private ScrollEnableViewPager bbY;
    private FrameLayout bbZ;
    private AlaLiveInputEditView bca;
    private TextView bcc;
    private ViewTreeObserver.OnGlobalLayoutListener bcd;
    private int bce;
    private int bcf;
    private Runnable bcm;
    private Runnable bcn;
    private SupportXFragment[] bco;
    private GiftPanelSelectMicrophoneSendView cad;
    private GiftPanelTabView cae;
    private GiftPanelDrawContainerView caf;
    private com.baidu.live.yuyingift.panel.a cag;
    private ViewGroup mContentLayout;
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
            this.cag.a(this, this);
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
        this.bcd = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabActivity.1
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
                AsyncTask.execute(new Runnable() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabActivity.8
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            new Instrumentation().sendKeyDownUpSync(4);
                        } catch (Exception e) {
                            AlaGiftTabActivity.this.bca.post(new Runnable() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabActivity.8.1
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
                if ((supportXFragment instanceof com.baidu.live.yuyingift.panel.b) && ((com.baidu.live.yuyingift.panel.b) supportXFragment).cbO != null) {
                    ((com.baidu.live.yuyingift.panel.b) supportXFragment).cbO.GC();
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

    @Override // com.baidu.live.yuyingift.panel.a.InterfaceC0244a
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

    @Override // com.baidu.live.yuyingift.panel.a.InterfaceC0244a
    public GiftPanelSelectMicrophoneSendView.d YF() {
        if (this.cad != null) {
            return this.cad.getSelectMicrophoneList();
        }
        return null;
    }

    @Override // com.baidu.live.yuyingift.panel.a.InterfaceC0244a
    public void a(List<AlaWheatInfoData> list, List<AlaWheatInfoData> list2, String[] strArr) {
        if (this.cad != null) {
            this.cad.b(list, list2, strArr);
        }
    }

    @Override // com.baidu.live.yuyingift.panel.a.InterfaceC0244a
    public void a(final PersonUserData personUserData, AlaWheatInfoData alaWheatInfoData) {
        if (this.cad != null) {
            this.cad.setAttentionAndInfo(personUserData);
            this.cad.setCallback(new GiftPanelSelectMicrophoneSendView.a() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabActivity.9
                @Override // com.baidu.live.yuyingift.widget.wheatlist.GiftPanelSelectMicrophoneSendView.a
                public void a(AlaWheatInfoData alaWheatInfoData2) {
                    AlaGiftTabActivity.this.cag.a(alaWheatInfoData2, true);
                }

                @Override // com.baidu.live.yuyingift.widget.wheatlist.GiftPanelSelectMicrophoneSendView.a
                public void b(AlaWheatInfoData alaWheatInfoData2) {
                    AlaGiftTabActivity.this.cag.a(personUserData, alaWheatInfoData2, AlaGiftTabActivity.this.getIntent());
                    AlaGiftTabActivity.this.finish();
                }
            });
        }
    }

    @Override // com.baidu.live.yuyingift.panel.a.InterfaceC0244a
    public void YG() {
        if (this.cad != null) {
            this.cad.YG();
        }
    }

    @Override // com.baidu.live.yuyingift.panel.a.InterfaceC0244a
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

    @Override // com.baidu.live.yuyingift.container.AlaGiftTabView.a
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

    @Override // com.baidu.live.yuyingift.container.AlaGiftTabView.a
    public void j(boolean z, String str) {
        if (this.caf != null) {
            if (z) {
                if (Build.VERSION.SDK_INT != 26) {
                    setRequestedOrientation(1);
                    this.bcg = true;
                }
                this.caf.setVisibility(0);
            } else {
                if (Build.VERSION.SDK_INT != 26 && this.bcg) {
                    setRequestedOrientation(3);
                    this.bcg = false;
                }
                this.caf.setVisibility(8);
            }
            this.caf.l(z, str);
        }
    }

    @Override // com.baidu.live.yuyingift.container.AlaGiftTabView.a
    public void a(g gVar) {
        if (this.caf != null) {
            this.caf.setGiftItem(gVar);
        }
    }

    @Override // com.baidu.live.yuyingift.panel.a.InterfaceC0244a
    public k Gd() {
        if (this.caf != null) {
            return this.caf.getGraffitiData();
        }
        return null;
    }

    @Override // com.baidu.live.yuyingift.panel.a.InterfaceC0244a
    public void a(NobleUserInfo.a aVar) {
        if (this.bbX != null) {
            bv bvVar = com.baidu.live.ae.a.Qm().bCs;
            if (bvVar != null && bvVar.aRp.aUc) {
                this.bbX.setVisibility(0);
                this.bbX.setData(aVar);
                return;
            }
            this.bbX.setVisibility(8);
        }
    }

    @Override // com.baidu.live.yuyingift.container.AlaGiftTabView.a
    public void aT(String str, String str2) {
        if (this.bcc != null) {
            if (!TextUtils.isEmpty(str)) {
                this.bcc.setText(str);
                this.bcc.setTag(str2);
                this.bcc.setVisibility(0);
                return;
            }
            this.bcc.setText("");
            this.bcc.setVisibility(8);
        }
    }

    @Override // com.baidu.live.yuyingift.container.AlaGiftTabView.a
    public void YH() {
        if (this.cad != null) {
            this.cad.Zr();
        }
    }

    @Override // com.baidu.live.yuyingift.container.AlaGiftTabView.a
    public void YI() {
        com.baidu.live.yuyingift.b.a.YV();
    }

    @Override // com.baidu.live.yuyingift.container.AlaGiftTabView.a
    public void YJ() {
        com.baidu.live.yuyingift.b.a.YW();
    }

    @Override // com.baidu.live.yuyingift.container.AlaGiftTabView.a
    public void YK() {
        com.baidu.live.yuyingift.b.a.YX();
    }

    @Override // com.baidu.live.yuyingift.container.AlaGiftTabView.a
    public void YL() {
        com.baidu.live.yuyingift.b.a.YY();
    }

    @Override // com.baidu.live.yuyingift.container.AlaGiftTabView.a
    public void YM() {
        com.baidu.live.yuyingift.b.a.YZ();
    }

    @Override // com.baidu.live.yuyingift.container.AlaGiftTabView.a
    public void YN() {
        if (this.cad != null) {
            this.cad.Zs();
        }
    }

    @Override // com.baidu.live.yuyingift.container.AlaGiftTabView.a
    public void aU(String str, String str2) {
        if (this.cad != null) {
            this.cad.aV(str, str2);
        }
    }

    @Override // com.baidu.live.yuyingift.panel.a.InterfaceC0244a
    public void onClose() {
        finish();
    }

    @Override // com.baidu.live.yuyingift.panel.a.InterfaceC0244a
    public void YO() {
        if (this.cad != null) {
            this.cad.Zt();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        SupportXFragment[] supportXFragmentArr;
        super.onDestroy();
        getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.bcd);
        if (this.cag != null) {
            this.cag.release();
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
        UtilHelper.changeStatusBarIconAndTextColor(true, getPageContext().getPageActivity());
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
    }

    private void Ge() {
        this.bch = true;
        Animation loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0201a.sdk_in_from_bottom);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabActivity.10
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
        if (!this.bci && !this.bch) {
            Animation loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0201a.sdk_out_to_bottom);
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
        this.cag = new com.baidu.live.yuyingift.panel.a(getPageContext());
        this.cag.init(getIntent());
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
        this.bch = false;
        this.mRootView.setVisibility(4);
        Gh();
        bG(z);
        bH(z);
        YP();
        bI(z);
        bJ(z);
        bK(z);
        Gi();
        Gj();
        bL(z);
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    private void YP() {
        this.cag.Ze();
        this.cad.setOnSelectWheatChangeListener(new GiftPanelSelectMicrophoneSendView.b() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabActivity.12
            @Override // com.baidu.live.yuyingift.widget.wheatlist.GiftPanelSelectMicrophoneSendView.b
            public void onChange() {
                AlaGiftTabActivity.this.caf.Zj();
                AlaGiftTabActivity.this.YQ();
            }
        });
        this.cad.setOnSetDataListener(new GiftPanelSelectMicrophoneSendView.c() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabActivity.13
            @Override // com.baidu.live.yuyingift.widget.wheatlist.GiftPanelSelectMicrophoneSendView.c
            public void c(AlaWheatInfoData alaWheatInfoData) {
                AlaGiftTabActivity.this.cag.d(alaWheatInfoData);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void YQ() {
        for (SupportXFragment supportXFragment : this.bco) {
            ((com.baidu.live.yuyingift.panel.b) supportXFragment).YQ();
        }
    }

    private void Gh() {
        this.mContentLayout = (ViewGroup) findViewById(a.f.layout_content);
        this.bbU = findViewById(a.f.layout_tab);
        this.cae = (GiftPanelTabView) findViewById(a.f.tab);
        this.cad = (GiftPanelSelectMicrophoneSendView) findViewById(a.f.yuyin_ala_gift_microphone_view);
        this.bbX = (NobleGiftEntryView) findViewById(a.f.noble_entry);
        this.bbY = (ScrollEnableViewPager) findViewById(a.f.vp);
        this.bbZ = (FrameLayout) findViewById(a.f.layout_supportx);
        this.bca = (AlaLiveInputEditView) findViewById(a.f.edit_num);
        this.caf = (GiftPanelDrawContainerView) findViewById(a.f.container_draw);
        this.bcc = (TextView) findViewById(a.f.gift_toast);
    }

    private void bG(boolean z) {
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

    private void bH(boolean z) {
        if (!z) {
            ViewGroup.LayoutParams layoutParams = this.bbU.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                ((FrameLayout.LayoutParams) layoutParams).gravity |= 80;
                ((FrameLayout.LayoutParams) layoutParams).bottomMargin = Gk();
                this.bbU.setLayoutParams(layoutParams);
            }
        }
        this.cae.setCallback(new GiftPanelTabView.a() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabActivity.14
            @Override // com.baidu.live.yuyingift.widget.panel.GiftPanelTabView.a
            public void dC(int i) {
                AlaGiftTabActivity.this.cW(i);
            }
        });
    }

    private void bI(boolean z) {
        if (this.cag == null || !this.cag.HQ()) {
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
            this.bbX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabActivity.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AlaGiftTabActivity.this.cag != null) {
                        AlaGiftTabActivity.this.cag.HR();
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
                layoutParams.height = getResources().getDimensionPixelOffset(a.d.yuyin_ala_dimen_gift_tabbar_height) + Gk();
            }
            this.bbZ.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.live.yuyingift.container.AlaGiftTabActivity$2  reason: invalid class name */
    /* loaded from: classes10.dex */
    public class AnonymousClass2 implements c.a {
        AnonymousClass2() {
        }

        @Override // com.baidu.live.view.input.c.a
        public void gF(String str) {
            AsyncTask.execute(new Runnable() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabActivity.2.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        new Instrumentation().sendKeyDownUpSync(4);
                    } catch (Exception e) {
                        AlaGiftTabActivity.this.bca.post(new Runnable() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabActivity.2.1.1
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
            com.baidu.live.yuyingift.panel.b YR = AlaGiftTabActivity.this.YR();
            if (YR != null && YR.cbO != null) {
                YR.cbO.gI(str);
            }
        }
    }

    private void Gi() {
        this.bca.setEditViewConfirmCallBack(new AnonymousClass2());
    }

    private void Gj() {
        this.caf.setGiftPanelCallback(this);
        this.caf.setCallback(new GiftPanelDrawContainerView.a() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabActivity.3
            @Override // com.baidu.live.yuyingift.widget.panel.GiftPanelDrawContainerView.a
            public void cX(int i) {
                com.baidu.live.yuyingift.panel.b YR = AlaGiftTabActivity.this.YR();
                if (YR != null && YR.cbO != null) {
                    YR.cbO.dg(i);
                }
            }

            @Override // com.baidu.live.yuyingift.widget.panel.GiftPanelDrawContainerView.a
            public void Gr() {
                AlaGiftTabActivity.this.finish();
            }
        });
    }

    private void bL(boolean z) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(BdUtilHelper.dip2px(this, 5.0f));
        gradientDrawable.setColor(-1560281088);
        this.bcc.setBackgroundDrawable(gradientDrawable);
        if (z) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bcc.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            layoutParams.addRule(5, this.mContentLayout.getId());
            layoutParams.addRule(2, 0);
            layoutParams.rightMargin = 0;
            layoutParams.addRule(12);
            layoutParams.bottomMargin = BdUtilHelper.getDimens(this, a.d.sdk_ds90);
            this.bcc.setLayoutParams(layoutParams);
            this.bcc.setBackgroundColor(-1560281088);
            this.bcc.setGravity(17);
            int dimens = BdUtilHelper.getDimens(this, a.d.sdk_ds12);
            this.bcc.setPadding(dimens, dimens, dimens, dimens);
        }
        this.bcc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaGiftTabActivity.this.cag != null) {
                    Object tag = AlaGiftTabActivity.this.bcc.getTag();
                    if ((tag instanceof String) && !TextUtils.isEmpty((String) tag)) {
                        AlaGiftTabActivity.this.cag.gV((String) tag);
                    }
                }
            }
        });
    }

    private int Gk() {
        if (this.bcf <= 0) {
            this.bcf = getDataPagerHeight();
            if (this.cag != null && this.cag.HQ()) {
                this.bcf += Gm() + getResources().getDimensionPixelOffset(a.d.yuyin_ala_dimen_gift_noble_height);
            }
        }
        return this.bcf;
    }

    private int getDataPagerHeight() {
        return (getResources().getDimensionPixelOffset(a.d.sdk_ds192) * 2) + getResources().getDimensionPixelOffset(a.d.sdk_ds4) + getResources().getDimensionPixelOffset(a.d.sdk_ds12) + getResources().getDimensionPixelOffset(a.d.sdk_ds116);
    }

    private int Gl() {
        return getResources().getDimensionPixelOffset(a.d.yuyin_ala_dimen_gift_tabbar_height);
    }

    private int Gm() {
        return getResources().getDimensionPixelOffset(a.d.yuyin_ala_dimen_gift_noblr_maginbottom);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.live.yuyingift.panel.b YR() {
        if (this.bco == null || this.cae == null || this.bco.length <= this.cae.getSelect() || !(this.bco[this.cae.getSelect()] instanceof com.baidu.live.yuyingift.panel.b)) {
            return null;
        }
        return (com.baidu.live.yuyingift.panel.b) this.bco[this.cae.getSelect()];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cW(int i) {
        if (this.cae != null) {
            this.cae.setSelect(i);
        }
        if (this.bco != null) {
            int i2 = 0;
            while (i2 < this.bco.length) {
                this.bco[i2].setUserVisibleHint(i2 == i);
                if ((this.bco[i2] instanceof com.baidu.live.yuyingift.panel.b) && ((com.baidu.live.yuyingift.panel.b) this.bco[i2]).cbO != null) {
                    ((com.baidu.live.yuyingift.panel.b) this.bco[i2]).cbO.bO(i2 == i);
                }
                if (this.bco[i2].getView() != null) {
                    this.bco[i2].getView().setVisibility(i2 == i ? 0 : 8);
                }
                i2++;
            }
        }
    }

    private Runnable Go() {
        if (this.bcm == null) {
            this.bcm = new Runnable() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabActivity.5
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
            this.bcn = new Runnable() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabActivity.6
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
        if (alaLiveGiftUIInfo != null && this.cae != null) {
            this.cae.setColors(alaLiveGiftUIInfo.getTabBgSelectedColor(), alaLiveGiftUIInfo.getTabBgUnSelectedColor(), alaLiveGiftUIInfo.getTabTextSelectedColor(), alaLiveGiftUIInfo.getTabTextUnSelectedColor());
        }
    }

    private void c(AlaLiveGiftUIInfo alaLiveGiftUIInfo) {
        SupportXFragment[] supportXFragmentArr;
        if (alaLiveGiftUIInfo != null && alaLiveGiftUIInfo.getCategoryTextSelectedColor() != 0 && (this.bbY.getAdapter() instanceof GiftPanelFragmentPagerAdapter) && ((GiftPanelFragmentPagerAdapter) this.bbY.getAdapter()).HZ() != null && this.bco != null) {
            for (SupportXFragment supportXFragment : this.bco) {
                if (supportXFragment instanceof com.baidu.live.yuyingift.panel.b) {
                    ((com.baidu.live.yuyingift.panel.b) supportXFragment).cY(alaLiveGiftUIInfo.getCategoryTextSelectedColor());
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
            linearLayout.addView(view, new LinearLayout.LayoutParams(-1, Gk()));
            this.mContentLayout.addView(linearLayout, 0);
            simpleDraweeView.setController(com.facebook.drawee.a.a.c.etF().c(simpleDraweeView.getController()).bq(ImageRequestBuilder.ag(Uri.parse(alaLiveGiftUIInfo.getVerticalBgUrl())).a(com.facebook.imagepipeline.common.e.ewE()).a(com.facebook.imagepipeline.common.b.ewu().e(Bitmap.Config.RGB_565).ewC()).eAz()).Bk(true).c(new com.facebook.drawee.controller.c<f>() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabActivity.7
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
                public void gE(String str) {
                }
            }).euw());
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

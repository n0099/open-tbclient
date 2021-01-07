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
/* loaded from: classes11.dex */
public class AlaGiftTabActivity extends BaseFragmentActivity implements View.OnTouchListener, AlaGiftTabView.a, a.InterfaceC0246a {
    private GiftPanelSelectMicrophoneSendView bZn;
    private GiftPanelTabView bZo;
    private GiftPanelDrawContainerView bZp;
    private com.baidu.live.yuyingift.panel.a bZq;
    private View bcb;
    private NobleGiftEntryView bce;
    private ScrollEnableViewPager bcf;
    private FrameLayout bcg;
    private AlaLiveInputEditView bch;
    private TextView bcj;
    private ViewTreeObserver.OnGlobalLayoutListener bck;
    private int bcl;
    private int bcm;
    private Runnable bct;
    private Runnable bcu;
    private SupportXFragment[] bcv;
    private ViewGroup mContentLayout;
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
            this.bZq.a(this, this);
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
        this.bck = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabActivity.1
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
                AsyncTask.execute(new Runnable() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabActivity.8
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            new Instrumentation().sendKeyDownUpSync(4);
                        } catch (Exception e) {
                            AlaGiftTabActivity.this.bch.post(new Runnable() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabActivity.8.1
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
                if ((supportXFragment instanceof com.baidu.live.yuyingift.panel.b) && ((com.baidu.live.yuyingift.panel.b) supportXFragment).caX != null) {
                    ((com.baidu.live.yuyingift.panel.b) supportXFragment).caX.Je();
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

    @Override // com.baidu.live.yuyingift.panel.a.InterfaceC0246a
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

    @Override // com.baidu.live.yuyingift.panel.a.InterfaceC0246a
    public GiftPanelSelectMicrophoneSendView.d aaF() {
        if (this.bZn != null) {
            return this.bZn.getSelectMicrophoneList();
        }
        return null;
    }

    @Override // com.baidu.live.yuyingift.panel.a.InterfaceC0246a
    public void a(List<AlaWheatInfoData> list, List<AlaWheatInfoData> list2, String[] strArr) {
        if (this.bZn != null) {
            this.bZn.b(list, list2, strArr);
        }
    }

    @Override // com.baidu.live.yuyingift.panel.a.InterfaceC0246a
    public void a(final PersonUserData personUserData, AlaWheatInfoData alaWheatInfoData) {
        if (this.bZn != null) {
            this.bZn.setAttentionAndInfo(personUserData);
            this.bZn.setCallback(new GiftPanelSelectMicrophoneSendView.a() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabActivity.9
                @Override // com.baidu.live.yuyingift.widget.wheatlist.GiftPanelSelectMicrophoneSendView.a
                public void a(AlaWheatInfoData alaWheatInfoData2) {
                    AlaGiftTabActivity.this.bZq.a(alaWheatInfoData2, true);
                }

                @Override // com.baidu.live.yuyingift.widget.wheatlist.GiftPanelSelectMicrophoneSendView.a
                public void b(AlaWheatInfoData alaWheatInfoData2) {
                    AlaGiftTabActivity.this.bZq.a(personUserData, alaWheatInfoData2, AlaGiftTabActivity.this.getIntent());
                    AlaGiftTabActivity.this.finish();
                }
            });
        }
    }

    @Override // com.baidu.live.yuyingift.panel.a.InterfaceC0246a
    public void aaG() {
        if (this.bZn != null) {
            this.bZn.aaG();
        }
    }

    @Override // com.baidu.live.yuyingift.panel.a.InterfaceC0246a
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

    @Override // com.baidu.live.yuyingift.container.AlaGiftTabView.a
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

    @Override // com.baidu.live.yuyingift.container.AlaGiftTabView.a
    public void f(boolean z, String str) {
        if (this.bZp != null) {
            if (z) {
                if (Build.VERSION.SDK_INT != 26) {
                    setRequestedOrientation(1);
                    this.bcn = true;
                }
                this.bZp.setVisibility(0);
            } else {
                if (Build.VERSION.SDK_INT != 26 && this.bcn) {
                    setRequestedOrientation(3);
                    this.bcn = false;
                }
                this.bZp.setVisibility(8);
            }
            this.bZp.h(z, str);
        }
    }

    @Override // com.baidu.live.yuyingift.container.AlaGiftTabView.a
    public void a(g gVar) {
        if (this.bZp != null) {
            this.bZp.setGiftItem(gVar);
        }
    }

    @Override // com.baidu.live.yuyingift.panel.a.InterfaceC0246a
    public k IF() {
        if (this.bZp != null) {
            return this.bZp.getGraffitiData();
        }
        return null;
    }

    @Override // com.baidu.live.yuyingift.panel.a.InterfaceC0246a
    public void a(NobleUserInfo.a aVar) {
        if (this.bce != null) {
            bq bqVar = com.baidu.live.af.a.SE().bCb;
            if (bqVar != null && bqVar.aRE.aUn) {
                this.bce.setVisibility(0);
                this.bce.setData(aVar);
                return;
            }
            this.bce.setVisibility(8);
        }
    }

    @Override // com.baidu.live.yuyingift.container.AlaGiftTabView.a
    public void aV(String str, String str2) {
        if (this.bcj != null) {
            if (!TextUtils.isEmpty(str)) {
                this.bcj.setText(str);
                this.bcj.setTag(str2);
                this.bcj.setVisibility(0);
                return;
            }
            this.bcj.setText("");
            this.bcj.setVisibility(8);
        }
    }

    @Override // com.baidu.live.yuyingift.container.AlaGiftTabView.a
    public void aaH() {
        if (this.bZn != null) {
            this.bZn.abr();
        }
    }

    @Override // com.baidu.live.yuyingift.container.AlaGiftTabView.a
    public void aaI() {
        com.baidu.live.yuyingift.b.a.aaV();
    }

    @Override // com.baidu.live.yuyingift.container.AlaGiftTabView.a
    public void aaJ() {
        com.baidu.live.yuyingift.b.a.aaW();
    }

    @Override // com.baidu.live.yuyingift.container.AlaGiftTabView.a
    public void aaK() {
        com.baidu.live.yuyingift.b.a.aaX();
    }

    @Override // com.baidu.live.yuyingift.container.AlaGiftTabView.a
    public void aaL() {
        com.baidu.live.yuyingift.b.a.aaY();
    }

    @Override // com.baidu.live.yuyingift.container.AlaGiftTabView.a
    public void aaM() {
        com.baidu.live.yuyingift.b.a.aaZ();
    }

    @Override // com.baidu.live.yuyingift.container.AlaGiftTabView.a
    public void aaN() {
        if (this.bZn != null) {
            this.bZn.abs();
        }
    }

    @Override // com.baidu.live.yuyingift.container.AlaGiftTabView.a
    public void aW(String str, String str2) {
        if (this.bZn != null) {
            this.bZn.aX(str, str2);
        }
    }

    @Override // com.baidu.live.yuyingift.panel.a.InterfaceC0246a
    public void onClose() {
        finish();
    }

    @Override // com.baidu.live.yuyingift.panel.a.InterfaceC0246a
    public void aaO() {
        if (this.bZn != null) {
            this.bZn.abt();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        SupportXFragment[] supportXFragmentArr;
        super.onDestroy();
        getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.bck);
        if (this.bZq != null) {
            this.bZq.release();
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
        UtilHelper.changeStatusBarIconAndTextColor(true, getPageContext().getPageActivity());
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
    }

    private void IG() {
        this.bco = true;
        Animation loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0203a.sdk_in_from_bottom);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabActivity.10
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
        if (!this.bcp && !this.bco) {
            Animation loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0203a.sdk_out_to_bottom);
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
        this.bZq = new com.baidu.live.yuyingift.panel.a(getPageContext());
        this.bZq.init(getIntent());
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
        this.bco = false;
        this.mRootView.setVisibility(4);
        IJ();
        bF(z);
        bG(z);
        aaP();
        bH(z);
        bI(z);
        bJ(z);
        IK();
        IL();
        bK(z);
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    private void aaP() {
        this.bZq.abe();
        this.bZn.setOnSelectWheatChangeListener(new GiftPanelSelectMicrophoneSendView.b() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabActivity.12
            @Override // com.baidu.live.yuyingift.widget.wheatlist.GiftPanelSelectMicrophoneSendView.b
            public void onChange() {
                AlaGiftTabActivity.this.bZp.abj();
                AlaGiftTabActivity.this.aaQ();
            }
        });
        this.bZn.setOnSetDataListener(new GiftPanelSelectMicrophoneSendView.c() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabActivity.13
            @Override // com.baidu.live.yuyingift.widget.wheatlist.GiftPanelSelectMicrophoneSendView.c
            public void c(AlaWheatInfoData alaWheatInfoData) {
                AlaGiftTabActivity.this.bZq.d(alaWheatInfoData);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaQ() {
        for (SupportXFragment supportXFragment : this.bcv) {
            ((com.baidu.live.yuyingift.panel.b) supportXFragment).aaQ();
        }
    }

    private void IJ() {
        this.mContentLayout = (ViewGroup) findViewById(a.f.layout_content);
        this.bcb = findViewById(a.f.layout_tab);
        this.bZo = (GiftPanelTabView) findViewById(a.f.tab);
        this.bZn = (GiftPanelSelectMicrophoneSendView) findViewById(a.f.yuyin_ala_gift_microphone_view);
        this.bce = (NobleGiftEntryView) findViewById(a.f.noble_entry);
        this.bcf = (ScrollEnableViewPager) findViewById(a.f.vp);
        this.bcg = (FrameLayout) findViewById(a.f.layout_supportx);
        this.bch = (AlaLiveInputEditView) findViewById(a.f.edit_num);
        this.bZp = (GiftPanelDrawContainerView) findViewById(a.f.container_draw);
        this.bcj = (TextView) findViewById(a.f.gift_toast);
    }

    private void bF(boolean z) {
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

    private void bG(boolean z) {
        if (!z) {
            ViewGroup.LayoutParams layoutParams = this.bcb.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                ((FrameLayout.LayoutParams) layoutParams).gravity |= 80;
                ((FrameLayout.LayoutParams) layoutParams).bottomMargin = IM();
                this.bcb.setLayoutParams(layoutParams);
            }
        }
        this.bZo.setCallback(new GiftPanelTabView.a() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabActivity.14
            @Override // com.baidu.live.yuyingift.widget.panel.GiftPanelTabView.a
            public void fb(int i) {
                AlaGiftTabActivity.this.ew(i);
            }
        });
    }

    private void bH(boolean z) {
        if (this.bZq == null || !this.bZq.Ks()) {
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
            this.bce.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabActivity.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AlaGiftTabActivity.this.bZq != null) {
                        AlaGiftTabActivity.this.bZq.Kt();
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
                layoutParams.height = getResources().getDimensionPixelOffset(a.d.yuyin_ala_dimen_gift_tabbar_height) + IM();
            }
            this.bcg.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.live.yuyingift.container.AlaGiftTabActivity$2  reason: invalid class name */
    /* loaded from: classes11.dex */
    public class AnonymousClass2 implements c.a {
        AnonymousClass2() {
        }

        @Override // com.baidu.live.view.input.c.a
        public void hn(String str) {
            AsyncTask.execute(new Runnable() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabActivity.2.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        new Instrumentation().sendKeyDownUpSync(4);
                    } catch (Exception e) {
                        AlaGiftTabActivity.this.bch.post(new Runnable() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabActivity.2.1.1
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
            com.baidu.live.yuyingift.panel.b aaR = AlaGiftTabActivity.this.aaR();
            if (aaR != null && aaR.caX != null) {
                aaR.caX.hq(str);
            }
        }
    }

    private void IK() {
        this.bch.setEditViewConfirmCallBack(new AnonymousClass2());
    }

    private void IL() {
        this.bZp.setGiftPanelCallback(this);
        this.bZp.setCallback(new GiftPanelDrawContainerView.a() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabActivity.3
            @Override // com.baidu.live.yuyingift.widget.panel.GiftPanelDrawContainerView.a
            public void ex(int i) {
                com.baidu.live.yuyingift.panel.b aaR = AlaGiftTabActivity.this.aaR();
                if (aaR != null && aaR.caX != null) {
                    aaR.caX.eG(i);
                }
            }

            @Override // com.baidu.live.yuyingift.widget.panel.GiftPanelDrawContainerView.a
            public void IT() {
                AlaGiftTabActivity.this.finish();
            }
        });
    }

    private void bK(boolean z) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(BdUtilHelper.dip2px(this, 5.0f));
        gradientDrawable.setColor(-1560281088);
        this.bcj.setBackgroundDrawable(gradientDrawable);
        if (z) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bcj.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            layoutParams.addRule(5, this.mContentLayout.getId());
            layoutParams.addRule(2, 0);
            layoutParams.rightMargin = 0;
            layoutParams.addRule(12);
            layoutParams.bottomMargin = BdUtilHelper.getDimens(this, a.d.sdk_ds90);
            this.bcj.setLayoutParams(layoutParams);
            this.bcj.setBackgroundColor(-1560281088);
            this.bcj.setGravity(17);
            int dimens = BdUtilHelper.getDimens(this, a.d.sdk_ds12);
            this.bcj.setPadding(dimens, dimens, dimens, dimens);
        }
        this.bcj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaGiftTabActivity.this.bZq != null) {
                    Object tag = AlaGiftTabActivity.this.bcj.getTag();
                    if ((tag instanceof String) && !TextUtils.isEmpty((String) tag)) {
                        AlaGiftTabActivity.this.bZq.hD((String) tag);
                    }
                }
            }
        });
    }

    private int IM() {
        if (this.bcm <= 0) {
            this.bcm = getDataPagerHeight();
            if (this.bZq != null && this.bZq.Ks()) {
                this.bcm += IO() + getResources().getDimensionPixelOffset(a.d.yuyin_ala_dimen_gift_noble_height);
            }
        }
        return this.bcm;
    }

    private int getDataPagerHeight() {
        return (getResources().getDimensionPixelOffset(a.d.sdk_ds192) * 2) + getResources().getDimensionPixelOffset(a.d.sdk_ds4) + getResources().getDimensionPixelOffset(a.d.sdk_ds12) + getResources().getDimensionPixelOffset(a.d.sdk_ds116);
    }

    private int IN() {
        return getResources().getDimensionPixelOffset(a.d.yuyin_ala_dimen_gift_tabbar_height);
    }

    private int IO() {
        return getResources().getDimensionPixelOffset(a.d.yuyin_ala_dimen_gift_noblr_maginbottom);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.live.yuyingift.panel.b aaR() {
        if (this.bcv == null || this.bZo == null || this.bcv.length <= this.bZo.getSelect() || !(this.bcv[this.bZo.getSelect()] instanceof com.baidu.live.yuyingift.panel.b)) {
            return null;
        }
        return (com.baidu.live.yuyingift.panel.b) this.bcv[this.bZo.getSelect()];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ew(int i) {
        if (this.bZo != null) {
            this.bZo.setSelect(i);
        }
        if (this.bcv != null) {
            int i2 = 0;
            while (i2 < this.bcv.length) {
                this.bcv[i2].setUserVisibleHint(i2 == i);
                if ((this.bcv[i2] instanceof com.baidu.live.yuyingift.panel.b) && ((com.baidu.live.yuyingift.panel.b) this.bcv[i2]).caX != null) {
                    ((com.baidu.live.yuyingift.panel.b) this.bcv[i2]).caX.bN(i2 == i);
                }
                if (this.bcv[i2].getView() != null) {
                    this.bcv[i2].getView().setVisibility(i2 == i ? 0 : 8);
                }
                i2++;
            }
        }
    }

    private Runnable IQ() {
        if (this.bct == null) {
            this.bct = new Runnable() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabActivity.5
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
            this.bcu = new Runnable() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabActivity.6
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
        if (alaLiveGiftUIInfo != null && this.bZo != null) {
            this.bZo.setColors(alaLiveGiftUIInfo.getTabBgSelectedColor(), alaLiveGiftUIInfo.getTabBgUnSelectedColor(), alaLiveGiftUIInfo.getTabTextSelectedColor(), alaLiveGiftUIInfo.getTabTextUnSelectedColor());
        }
    }

    private void c(AlaLiveGiftUIInfo alaLiveGiftUIInfo) {
        SupportXFragment[] supportXFragmentArr;
        if (alaLiveGiftUIInfo != null && alaLiveGiftUIInfo.getCategoryTextSelectedColor() != 0 && (this.bcf.getAdapter() instanceof GiftPanelFragmentPagerAdapter) && ((GiftPanelFragmentPagerAdapter) this.bcf.getAdapter()).KB() != null && this.bcv != null) {
            for (SupportXFragment supportXFragment : this.bcv) {
                if (supportXFragment instanceof com.baidu.live.yuyingift.panel.b) {
                    ((com.baidu.live.yuyingift.panel.b) supportXFragment).ey(alaLiveGiftUIInfo.getCategoryTextSelectedColor());
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
            linearLayout.addView(view, new LinearLayout.LayoutParams(-1, IM()));
            this.mContentLayout.addView(linearLayout, 0);
            simpleDraweeView.setController(com.facebook.drawee.a.a.c.euP().c(simpleDraweeView.getController()).bo(ImageRequestBuilder.aj(Uri.parse(alaLiveGiftUIInfo.getVerticalBgUrl())).a(com.facebook.imagepipeline.common.e.exN()).a(com.facebook.imagepipeline.common.b.exD().e(Bitmap.Config.RGB_565).exL()).eBI()).AX(true).c(new com.facebook.drawee.controller.c<f>() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabActivity.7
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
                public void hm(String str) {
                }
            }).evG());
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

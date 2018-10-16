package com.baidu.searchbox.ng.aiapps.menu;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.baidu.searchbox.ng.aiapps.menu.view.PopupWindow;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class AiAppMenuView extends PopupWindow implements View.OnClickListener, DismissCallback {
    public static final String COMMON_MENU_MASK_COLOR = "#80000000";
    private static final boolean DEBUG = false;
    private static final String TAG = "AiAppMenuView";
    private IAiAppMenuDecorate mAiAppMenuDecorate;
    private View mAttachView;
    private Context mContext;
    private BaseMenuView mCurMenuView;
    private boolean mFirstShow;
    private boolean mImmersionEnabled;
    private MainMenuView mMainMenu;
    private View mMask;
    private AiAppMenu mMenu;
    private int mMenuStyle;
    private FrameLayout mRootView;
    private String mStatisticSource;
    private Set<BaseMenuView> mSubMenus;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AiAppMenuView(Context context, View view, int i, @Nullable IAiAppMenuDecorate iAiAppMenuDecorate) {
        super(context);
        this.mFirstShow = true;
        this.mImmersionEnabled = true;
        this.mContext = context;
        this.mAttachView = view;
        this.mMenuStyle = i;
        this.mAiAppMenuDecorate = iAiAppMenuDecorate;
        setClippingEnabled(false);
        setFocusable(true);
        setOutsideTouchable(true);
        setBackgroundDrawable(new ColorDrawable(0));
        setAnimationStyle(R.style.aiapp_menu);
        setWidth(-1);
        setHeight(-1);
        initViews();
    }

    @Override // com.baidu.searchbox.ng.aiapps.menu.view.PopupWindow
    public void dismiss() {
        dismissView(true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.cancel || id == R.id.mask) {
            dismissView(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setStatisticSource(String str) {
        this.mStatisticSource = str;
        this.mMainMenu.setStatisticSource(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMenuSource(String str) {
        this.mMainMenu.setMenuSource(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void showView() {
        if (!isShowing()) {
            if (this.mAiAppMenuDecorate != null) {
                this.mAiAppMenuDecorate.decorateMainMenuView(this.mMainMenu);
            }
            this.mMainMenu.reset();
            this.mCurMenuView = this.mMainMenu;
            final View contentView = this.mMainMenu.getContentView();
            show(this.mAttachView, 81, 0, 0);
            if (contentView.getHeight() == 0) {
                contentView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.searchbox.ng.aiapps.menu.AiAppMenuView.1
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        AiAppMenuView.this.mMainMenu.adjustBgHeight(contentView.getHeight());
                        AiAppMenuView.this.showAnimation();
                        contentView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                });
            } else {
                showAnimation();
            }
            this.mMainMenu.onShow();
        }
    }

    public void show(View view, int i, int i2, int i3) {
        if (this.mImmersionEnabled) {
            setFocusable(false);
        }
        showAtLocation(view, i, i2, i3);
        if (this.mImmersionEnabled) {
            getContentView().setSystemUiVisibility(5120);
            setFocusable(true);
            update();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void showSubMenu(final BaseMenuView baseMenuView) {
        if (!this.mSubMenus.contains(baseMenuView)) {
            addSubMenu(baseMenuView);
        }
        this.mCurMenuView = baseMenuView;
        baseMenuView.setVisibility(0);
        baseMenuView.getBgView();
        final View contentView = baseMenuView.getContentView();
        int height = contentView.getHeight();
        if (height == 0) {
            contentView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.searchbox.ng.aiapps.menu.AiAppMenuView.2
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    baseMenuView.adjustBgHeight(contentView.getHeight());
                    AiAppMenuView.this.showSubMenuAnimation(baseMenuView);
                    contentView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
            });
            return;
        }
        baseMenuView.adjustBgHeight(height);
        showSubMenuAnimation(baseMenuView);
    }

    @Override // com.baidu.searchbox.ng.aiapps.menu.DismissCallback
    public void dismissView(boolean z) {
        if (!z) {
            super.dismiss();
        } else if (isShowing()) {
            ObjectAnimator maskHideAnimator = MenuAnimationUtils.getMaskHideAnimator(this.mMask);
            ObjectAnimator menuHideAnimator = MenuAnimationUtils.getMenuHideAnimator(this.mCurMenuView);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.searchbox.ng.aiapps.menu.AiAppMenuView.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Context context = AiAppMenuView.this.mContext;
                    if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
                        AiAppMenuView.super.dismiss();
                        if (AiAppMenuView.this.mCurMenuView != AiAppMenuView.this.mMainMenu) {
                            AiAppMenuView.this.mCurMenuView.setVisibility(8);
                        }
                    }
                }
            });
            animatorSet.playTogether(maskHideAnimator, menuHideAnimator);
            animatorSet.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateMenu(List<AiAppMenuItem> list) {
        this.mMainMenu.updateMenuItems(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void notifyDataChanged() {
        this.mMainMenu.notifyDataChanged();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMenu(AiAppMenu aiAppMenu) {
        this.mMenu = aiAppMenu;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMode(AiAppMenuMode aiAppMenuMode) {
        this.mMainMenu.setMode(aiAppMenuMode);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addSubMenu(BaseMenuView baseMenuView) {
        if (this.mSubMenus == null) {
            this.mSubMenus = new HashSet();
        }
        this.mSubMenus.add(baseMenuView);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        this.mRootView.addView(baseMenuView, layoutParams);
        baseMenuView.setVisibility(4);
    }

    private void initViews() {
        this.mRootView = (FrameLayout) LayoutInflater.from(this.mContext).inflate(R.layout.aiapp_menu_layout, (ViewGroup) null);
        this.mMask = this.mRootView.findViewById(R.id.mask);
        this.mMainMenu = (MainMenuView) this.mRootView.findViewById(R.id.aiapp_menu_body);
        this.mMask.setOnClickListener(this);
        this.mMainMenu.setClickListener(this);
        this.mMainMenu.setMenuStyle(this.mMenuStyle);
        this.mMainMenu.setDismissCallback(this);
        this.mRootView.measure(0, 0);
        setContentView(this.mRootView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showAnimation() {
        ObjectAnimator mainMenuCoverViewShowAnimator;
        View bgView = this.mMainMenu.getBgView();
        View contentView = this.mMainMenu.getContentView();
        int height = contentView.getHeight();
        this.mMainMenu.setTranslationY(0.0f);
        bgView.setTranslationY(height);
        contentView.setTranslationY(height);
        this.mMask.setAlpha(0.0f);
        contentView.setAlpha(0.0f);
        ObjectAnimator maskShowAnimator = MenuAnimationUtils.getMaskShowAnimator(this.mMask, this.mMainMenu);
        ObjectAnimator mainMenuBGShowAnimator = MenuAnimationUtils.getMainMenuBGShowAnimator(this.mMainMenu);
        ObjectAnimator mainMenuShowAnimator = MenuAnimationUtils.getMainMenuShowAnimator(this.mMainMenu);
        ObjectAnimator mainMenuAlphaAnimator = MenuAnimationUtils.getMainMenuAlphaAnimator(this.mMainMenu);
        ArrayList arrayList = new ArrayList();
        arrayList.add(maskShowAnimator);
        arrayList.add(mainMenuBGShowAnimator);
        arrayList.add(mainMenuShowAnimator);
        arrayList.add(mainMenuAlphaAnimator);
        View coverView = this.mMainMenu.getCoverView();
        if (coverView != null && (mainMenuCoverViewShowAnimator = MenuAnimationUtils.getMainMenuCoverViewShowAnimator(this.mMainMenu)) != null) {
            coverView.setTranslationY(height);
            arrayList.add(mainMenuCoverViewShowAnimator);
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showSubMenuAnimation(BaseMenuView baseMenuView) {
        int height = baseMenuView.getHeight();
        baseMenuView.setTranslationY(0.0f);
        View bgView = baseMenuView.getBgView();
        View contentView = baseMenuView.getContentView();
        if (bgView.getHeight() == 0) {
            bgView.getLayoutParams().height = height;
            bgView.requestLayout();
        }
        bgView.setTranslationY(height);
        contentView.setTranslationY(height);
        contentView.setAlpha(0.0f);
        ObjectAnimator menuHideAnimator = MenuAnimationUtils.getMenuHideAnimator(this.mMainMenu);
        ObjectAnimator subMenuBGShowAnimator = MenuAnimationUtils.getSubMenuBGShowAnimator(baseMenuView);
        ObjectAnimator subMenuShowAnimator = MenuAnimationUtils.getSubMenuShowAnimator(baseMenuView);
        ObjectAnimator subMenuAlphaAnimator = MenuAnimationUtils.getSubMenuAlphaAnimator(baseMenuView);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(menuHideAnimator, subMenuBGShowAnimator, subMenuAlphaAnimator, subMenuShowAnimator);
        animatorSet.start();
    }

    public void setImmersionEnabled(boolean z) {
        this.mImmersionEnabled = z;
    }
}

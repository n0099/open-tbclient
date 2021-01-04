package com.baidu.searchbox.floating.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.baidu.searchbox.floating.IFloating;
import com.baidu.searchbox.floating.animator.FloatViewAnimator;
import com.baidu.searchbox.floating.config.Config;
import com.baidu.searchbox.floating.config.ScaleMode;
import com.baidu.searchbox.floating.listener.FloatViewListener;
import com.baidu.searchbox.floating.service.FloatViewService;
import com.baidu.searchbox.floating.utils.FloatPrefs;
import com.baidu.searchbox.floating.utils.FloatingViewClickUtilKt;
import com.baidu.searchbox.floating.utils.TouchHelper;
import com.baidu.searchbox.floating.utils.UtilsKt;
import com.baidu.searchbox.floating.widget.FloatContainer;
import com.baidu.searchbox.videoplayer.floating.R;
import java.lang.ref.WeakReference;
import kotlin.Pair;
import kotlin.c;
import kotlin.d;
import kotlin.e;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.s;
import kotlin.reflect.j;
@e
/* loaded from: classes15.dex */
public final class ViewManager {
    static final /* synthetic */ j[] $$delegatedProperties = {s.a(new PropertyReference1Impl(s.G(ViewManager.class), "mContainer", "getMContainer()Lcom/baidu/searchbox/floating/widget/FloatContainer;")), s.a(new PropertyReference1Impl(s.G(ViewManager.class), "mTouchHelper", "getMTouchHelper()Lcom/baidu/searchbox/floating/utils/TouchHelper;"))};
    private Config config;
    private final Context context;
    private final c mContainer$delegate;
    private WindowManager.LayoutParams mParam;
    private final c mTouchHelper$delegate;
    private WindowManager mWindowManager;

    /* JADX INFO: Access modifiers changed from: private */
    public final FloatContainer getMContainer() {
        c cVar = this.mContainer$delegate;
        j jVar = $$delegatedProperties[0];
        return (FloatContainer) cVar.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TouchHelper getMTouchHelper() {
        c cVar = this.mTouchHelper$delegate;
        j jVar = $$delegatedProperties[1];
        return (TouchHelper) cVar.getValue();
    }

    public ViewManager(Context context, Config config) {
        p.o(context, "context");
        p.o(config, "config");
        this.context = context;
        this.config = config;
        this.mContainer$delegate = d.b(new ViewManager$mContainer$2(this));
        this.mTouchHelper$delegate = d.b(new ViewManager$mTouchHelper$2(this));
    }

    public static final /* synthetic */ WindowManager.LayoutParams access$getMParam$p(ViewManager viewManager) {
        WindowManager.LayoutParams layoutParams = viewManager.mParam;
        if (layoutParams == null) {
            p.acl("mParam");
        }
        return layoutParams;
    }

    public static final /* synthetic */ WindowManager access$getMWindowManager$p(ViewManager viewManager) {
        WindowManager windowManager = viewManager.mWindowManager;
        if (windowManager == null) {
            p.acl("mWindowManager");
        }
        return windowManager;
    }

    public final Config getConfig() {
        return this.config;
    }

    public final Context getContext() {
        return this.context;
    }

    public final void setConfig(Config config) {
        p.o(config, "<set-?>");
        this.config = config;
    }

    public final void createView() {
        restoreScaleMode();
        init();
        bindContentView();
    }

    private final void init() {
        int i;
        this.mWindowManager = UtilsKt.getWindowManager(this.context);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        if (Build.VERSION.SDK_INT >= 26) {
            i = 2038;
        } else {
            i = 2002;
        }
        layoutParams.type = i;
        layoutParams.format = 1;
        layoutParams.gravity = 8388659;
        layoutParams.flags = 40;
        layoutParams.width = -2;
        layoutParams.height = -2;
        Pair<Integer, Integer> size = getSize();
        if (this.config.getReverse()) {
            layoutParams.width = size.getSecond().intValue();
            layoutParams.height = size.getFirst().intValue();
        } else {
            layoutParams.width = size.getFirst().intValue();
            layoutParams.height = size.getSecond().intValue();
        }
        this.mParam = layoutParams;
        Pair<Integer, Integer> location = getLocation();
        WindowManager.LayoutParams layoutParams2 = this.mParam;
        if (layoutParams2 == null) {
            p.acl("mParam");
        }
        layoutParams2.x = location.getFirst().intValue();
        WindowManager.LayoutParams layoutParams3 = this.mParam;
        if (layoutParams3 == null) {
            p.acl("mParam");
        }
        layoutParams3.y = location.getSecond().intValue();
    }

    private final void bindContentView() {
        View floatingView = this.config.getFloatingView();
        if (floatingView != null) {
            floatingView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        FloatContainer mContainer = getMContainer();
        View floatingView2 = this.config.getFloatingView();
        if (floatingView2 == null) {
            p.eMi();
        }
        mContainer.addView(floatingView2);
        getMContainer().setTouchListener(new FloatContainer.TouchListener() { // from class: com.baidu.searchbox.floating.widget.ViewManager$bindContentView$1
            @Override // com.baidu.searchbox.floating.widget.FloatContainer.TouchListener
            public void onTouch(MotionEvent motionEvent) {
                TouchHelper mTouchHelper;
                FloatContainer mContainer2;
                p.o(motionEvent, "event");
                mTouchHelper = ViewManager.this.getMTouchHelper();
                mContainer2 = ViewManager.this.getMContainer();
                mTouchHelper.onTouch(mContainer2, motionEvent, ViewManager.access$getMWindowManager$p(ViewManager.this), ViewManager.access$getMParam$p(ViewManager.this));
            }
        });
        getMContainer().setLayoutListener(new FloatContainer.LayoutListener() { // from class: com.baidu.searchbox.floating.widget.ViewManager$bindContentView$2
            @Override // com.baidu.searchbox.floating.widget.FloatContainer.LayoutListener
            public void onLayout() {
                ViewManager.this.enterAnim();
            }
        });
        WindowManager windowManager = this.mWindowManager;
        if (windowManager == null) {
            p.acl("mWindowManager");
        }
        FloatContainer mContainer2 = getMContainer();
        WindowManager.LayoutParams layoutParams = this.mParam;
        if (layoutParams == null) {
            p.acl("mParam");
        }
        windowManager.addView(mContainer2, layoutParams);
        Point position = getPosition();
        for (FloatViewListener floatViewListener : this.config.getFloatViewListeners()) {
            floatViewListener.onViewCreate(true, this.config.getFloatingView(), this.config.getScaleMode().getSecond(), position);
        }
        final View findViewById = getMContainer().findViewById(R.id.floating_click_view_id);
        if (findViewById == null) {
            return;
        }
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.searchbox.floating.widget.ViewManager$bindContentView$$inlined$click$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Point position2;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - FloatingViewClickUtilKt.getLastClickTime(findViewById) > r2) {
                    FloatingViewClickUtilKt.setLastClickTime(findViewById, currentTimeMillis);
                    View view2 = findViewById;
                    position2 = this.getPosition();
                    for (FloatViewListener floatViewListener2 : this.getConfig().getFloatViewListeners()) {
                        floatViewListener2.onClick(view2, this.getConfig().getScaleMode().getSecond(), position2);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void enterAnim() {
        FloatViewAnimator animator;
        if (this.config.isAnimating() || (animator = this.config.getAnimator()) == null) {
            return;
        }
        WeakReference<View> weakReference = new WeakReference<>(getMContainer());
        WindowManager.LayoutParams layoutParams = this.mParam;
        if (layoutParams == null) {
            p.acl("mParam");
        }
        WindowManager windowManager = this.mWindowManager;
        if (windowManager == null) {
            p.acl("mWindowManager");
        }
        Animator enterAnim = animator.enterAnim(weakReference, layoutParams, windowManager);
        if (enterAnim != null) {
            WindowManager.LayoutParams layoutParams2 = this.mParam;
            if (layoutParams2 == null) {
                p.acl("mParam");
            }
            layoutParams2.flags = 552;
            enterAnim.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.searchbox.floating.widget.ViewManager$enterAnim$$inlined$apply$lambda$1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator2) {
                    ViewManager.this.getConfig().setAnimating(true);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator2, boolean z) {
                    ViewManager.access$getMParam$p(ViewManager.this).flags = 40;
                    ViewManager.this.getConfig().setAnimating(false);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator2) {
                    ViewManager.this.getConfig().setAnimating(false);
                }
            });
            enterAnim.start();
        }
    }

    public final void exitAnim() {
        if (!this.config.isAnimating()) {
            if (this.config.getAnimator() != null) {
                FloatViewAnimator animator = this.config.getAnimator();
                if (animator != null) {
                    WeakReference<View> weakReference = new WeakReference<>(getMContainer());
                    WindowManager.LayoutParams layoutParams = this.mParam;
                    if (layoutParams == null) {
                        p.acl("mParam");
                    }
                    WindowManager windowManager = this.mWindowManager;
                    if (windowManager == null) {
                        p.acl("mWindowManager");
                    }
                    Animator exitAnim = animator.exitAnim(weakReference, layoutParams, windowManager);
                    if (exitAnim != null) {
                        WindowManager.LayoutParams layoutParams2 = this.mParam;
                        if (layoutParams2 == null) {
                            p.acl("mParam");
                        }
                        layoutParams2.flags = 552;
                        exitAnim.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.searchbox.floating.widget.ViewManager$exitAnim$$inlined$apply$lambda$1
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationStart(Animator animator2) {
                                ViewManager.this.getConfig().setAnimating(true);
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator2, boolean z) {
                                ViewManager.this.destroy();
                            }

                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationCancel(Animator animator2) {
                                ViewManager.this.getConfig().setAnimating(false);
                            }
                        });
                        exitAnim.start();
                        return;
                    }
                    return;
                }
                return;
            }
            destroy();
        }
    }

    public final void updateLayoutParams() {
        Pair<Integer, Integer> size = getSize();
        WindowManager.LayoutParams layoutParams = this.mParam;
        if (layoutParams == null) {
            p.acl("mParam");
        }
        int i = layoutParams.width;
        WindowManager.LayoutParams layoutParams2 = this.mParam;
        if (layoutParams2 == null) {
            p.acl("mParam");
        }
        if (this.config.getReverse()) {
            layoutParams2.width = size.getSecond().intValue();
            layoutParams2.height = size.getFirst().intValue();
        } else {
            layoutParams2.width = size.getFirst().intValue();
            layoutParams2.height = size.getSecond().intValue();
        }
        if (getMContainer().getParent() != null) {
            WindowManager windowManager = this.mWindowManager;
            if (windowManager == null) {
                p.acl("mWindowManager");
            }
            FloatContainer mContainer = getMContainer();
            WindowManager.LayoutParams layoutParams3 = this.mParam;
            if (layoutParams3 == null) {
                p.acl("mParam");
            }
            windowManager.updateViewLayout(mContainer, layoutParams3);
        }
        WindowManager.LayoutParams layoutParams4 = this.mParam;
        if (layoutParams4 == null) {
            p.acl("mParam");
        }
        int i2 = layoutParams4.width;
        Point position = getPosition();
        if (i >= i2) {
            if (i <= i2) {
                return;
            }
            for (FloatViewListener floatViewListener : this.config.getFloatViewListeners()) {
                floatViewListener.onScale(false, this.config.getScaleMode().getSecond(), position);
            }
            return;
        }
        for (FloatViewListener floatViewListener2 : this.config.getFloatViewListeners()) {
            floatViewListener2.onScale(true, this.config.getScaleMode().getSecond(), position);
        }
    }

    private final Pair<Integer, Integer> getSize() {
        Pair<Integer, Integer> scale = this.config.getScaleMode().getSecond().scale(UtilsKt.dpToPxByScale(this.context, this.config.getSize().getFirst().intValue()), UtilsKt.dpToPxByScale(this.context, this.config.getSize().getSecond().intValue()));
        int dpToPxByScale = UtilsKt.dpToPxByScale(this.context, this.config.getShadow());
        return new Pair<>(Integer.valueOf(scale.getFirst().intValue() + (dpToPxByScale * 2)), Integer.valueOf(scale.getSecond().intValue() + (dpToPxByScale * 2)));
    }

    public final void setVisible(int i) {
        if (this.config.getFloatingView() != null && getMContainer().getVisibility() != i) {
            getMContainer().setVisibility(i);
            Point position = getPosition();
            if (i == 0) {
                for (FloatViewListener floatViewListener : this.config.getFloatViewListeners()) {
                    floatViewListener.onViewShow(getContentView(), this.config.getScaleMode().getSecond(), position);
                }
                return;
            }
            for (FloatViewListener floatViewListener2 : this.config.getFloatViewListeners()) {
                floatViewListener2.onViewHide(getContentView(), this.config.getScaleMode().getSecond(), position);
            }
        }
    }

    public final void destroy() {
        release();
        FloatViewService.Companion.stopService$lib_player_floating_release(this.context);
    }

    public final void release() {
        if (getMContainer().getParent() != null) {
            Point position = getPosition();
            this.config.setAnimating(false);
            if (this.config.getFloatingView() != null) {
                for (FloatViewListener floatViewListener : this.config.getFloatViewListeners()) {
                    floatViewListener.onViewDismiss(getContentView(), this.config.getScaleMode().getSecond(), position);
                }
                this.config.getFloatViewListeners().clear();
            }
            IFloating floatingContext = this.config.getFloatingContext();
            if (floatingContext != null) {
                floatingContext.onDestroy();
            }
            FloatPrefs.Companion companion = FloatPrefs.Companion;
            WindowManager.LayoutParams layoutParams = this.mParam;
            if (layoutParams == null) {
                p.acl("mParam");
            }
            Integer valueOf = Integer.valueOf(layoutParams.x);
            WindowManager.LayoutParams layoutParams2 = this.mParam;
            if (layoutParams2 == null) {
                p.acl("mParam");
            }
            companion.setLocation(new Pair<>(valueOf, Integer.valueOf(layoutParams2.y)));
            FloatPrefs.Companion.setScaleMode(this.config.getScaleMode());
            getMContainer().removeAllViews();
            WindowManager windowManager = this.mWindowManager;
            if (windowManager == null) {
                p.acl("mWindowManager");
            }
            windowManager.removeView(getMContainer());
        }
    }

    private final View getContentView() {
        View floatingView = this.config.getFloatingView();
        if (floatingView == null) {
            p.eMi();
        }
        return floatingView;
    }

    private final Pair<Integer, Integer> getLocation() {
        int dpToPxByScale;
        int dpToPxByScale2;
        Pair<Integer, Integer> location = FloatPrefs.Companion.getLocation();
        if (location.getFirst().intValue() <= 0 || location.getSecond().intValue() <= 0) {
            if (this.config.getLocation().getFirst().intValue() != -1 && this.config.getLocation().getSecond().intValue() != -1) {
                dpToPxByScale = UtilsKt.dpToPxByScale(this.context, this.config.getLocation().getFirst().intValue());
                int screenHeight = UtilsKt.getScreenHeight(this.context) - UtilsKt.getStatusBarHeight(this.context);
                WindowManager.LayoutParams layoutParams = this.mParam;
                if (layoutParams == null) {
                    p.acl("mParam");
                }
                dpToPxByScale2 = (screenHeight - layoutParams.height) - UtilsKt.dpToPxByScale(this.context, this.config.getLocation().getSecond().intValue());
            } else {
                dpToPxByScale = UtilsKt.dpToPxByScale(this.context, this.config.getBlockOffset().left);
                int screenHeight2 = UtilsKt.getScreenHeight(this.context);
                WindowManager.LayoutParams layoutParams2 = this.mParam;
                if (layoutParams2 == null) {
                    p.acl("mParam");
                }
                dpToPxByScale2 = (screenHeight2 - layoutParams2.height) - UtilsKt.dpToPxByScale(this.context, this.config.getBlockOffset().bottom);
            }
            return new Pair<>(Integer.valueOf(dpToPxByScale), Integer.valueOf(dpToPxByScale2));
        }
        return location;
    }

    private final void restoreScaleMode() {
        if (!p.l(FloatPrefs.Companion.getScaleMode().getSecond(), ScaleMode.S)) {
            this.config.setScaleMode(FloatPrefs.Companion.getScaleMode());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Point getPosition() {
        WindowManager.LayoutParams layoutParams = this.mParam;
        if (layoutParams == null) {
            p.acl("mParam");
        }
        int i = layoutParams.x;
        WindowManager.LayoutParams layoutParams2 = this.mParam;
        if (layoutParams2 == null) {
            p.acl("mParam");
        }
        return new Point(i, layoutParams2.y);
    }
}

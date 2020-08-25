package com.baidu.swan.apps.menu.fontsize;

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
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.ui.SliderBar;
import com.baidu.swan.menu.PopupWindow;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class c extends PopupWindow implements View.OnClickListener {
    private View cDq;
    private com.baidu.swan.menu.a cDr;
    private View cDs;
    private FontSizeSettingMenuView cDt;
    private a cDu;
    private Context mContext;
    private ViewGroup mRootView;

    /* loaded from: classes8.dex */
    public interface a {
        void it(int i);
    }

    public c(Context context, View view, @Nullable com.baidu.swan.menu.a aVar) {
        super(context);
        this.mContext = context;
        this.cDq = view;
        this.cDr = aVar;
        setClippingEnabled(false);
        setFocusable(true);
        setOutsideTouchable(true);
        setBackgroundDrawable(new ColorDrawable(0));
        setWidth(-1);
        setHeight(-1);
        initViews();
    }

    private void initViews() {
        this.mRootView = (FrameLayout) LayoutInflater.from(this.mContext).inflate(a.g.swan_app_font_setting_layout, (ViewGroup) null);
        this.cDs = this.mRootView.findViewById(a.f.mask);
        this.cDt = (FontSizeSettingMenuView) this.mRootView.findViewById(a.f.font_size_setting);
        this.cDs.setOnClickListener(this);
        this.cDt.setClickListener(this);
        this.cDt.setOnSliderBarChangeListener(new SliderBar.b() { // from class: com.baidu.swan.apps.menu.fontsize.c.1
            @Override // com.baidu.swan.apps.res.ui.SliderBar.b
            public void a(SliderBar sliderBar, int i) {
                if (c.this.cDu != null) {
                    c.this.cDu.it(i);
                }
            }
        });
        this.mRootView.measure(0, 0);
        setContentView(this.mRootView);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == a.f.cancel || id == a.f.mask) {
            eQ(true);
        }
    }

    public void showView() {
        if (!isShowing()) {
            auh();
            Activity activity = (Activity) this.mContext;
            if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
                this.cDt.setMode();
                showAtLocation(this.cDq, 81, 0, 0);
                getContentView().setSystemUiVisibility(5120);
                setFocusable(true);
                update();
                final View contentView = this.cDt.getContentView();
                if (contentView.getHeight() == 0) {
                    contentView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.menu.fontsize.c.2
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            c.this.cDt.lx(contentView.getHeight());
                            c.this.aui();
                            contentView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        }
                    });
                } else {
                    aui();
                }
            }
        }
    }

    public void auh() {
        if (this.cDr != null) {
            this.cDr.a(this.cDt);
        }
    }

    public void a(a aVar) {
        this.cDu = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aui() {
        this.cDs.setAlpha(0.0f);
        this.cDt.setTranslationY(this.cDt.getHeight());
        ObjectAnimator a2 = com.baidu.swan.menu.c.a(this.cDs, this.cDt);
        ObjectAnimator b = com.baidu.swan.menu.c.b(this.cDt);
        ArrayList arrayList = new ArrayList();
        arrayList.add(a2);
        arrayList.add(b);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        animatorSet.start();
    }

    public void eQ(boolean z) {
        if (!z) {
            super.dismiss();
        } else if (isShowing()) {
            ObjectAnimator aQ = com.baidu.swan.menu.c.aQ(this.cDs);
            ObjectAnimator c = com.baidu.swan.menu.c.c(this.cDt);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.apps.menu.fontsize.c.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Context context = c.this.mContext;
                    if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
                        c.this.dismiss();
                    }
                }
            });
            animatorSet.playTogether(aQ, c);
            animatorSet.start();
        }
    }
}

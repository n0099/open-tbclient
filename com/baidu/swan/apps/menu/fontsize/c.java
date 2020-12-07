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
/* loaded from: classes25.dex */
public class c extends PopupWindow implements View.OnClickListener {
    private View dli;
    private com.baidu.swan.menu.a dlj;
    private View dlk;
    private FontSizeSettingMenuView dll;
    private a dlm;
    private Context mContext;
    private ViewGroup mRootView;

    /* loaded from: classes25.dex */
    public interface a {
        void jP(int i);
    }

    public c(Context context, View view, @Nullable com.baidu.swan.menu.a aVar) {
        super(context);
        this.mContext = context;
        this.dli = view;
        this.dlj = aVar;
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
        this.dlk = this.mRootView.findViewById(a.f.mask);
        this.dll = (FontSizeSettingMenuView) this.mRootView.findViewById(a.f.font_size_setting);
        this.dlk.setOnClickListener(this);
        this.dll.setClickListener(this);
        this.dll.setOnSliderBarChangeListener(new SliderBar.b() { // from class: com.baidu.swan.apps.menu.fontsize.c.1
            @Override // com.baidu.swan.apps.res.ui.SliderBar.b
            public void a(SliderBar sliderBar, int i) {
                if (c.this.dlm != null) {
                    c.this.dlm.jP(i);
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
            fZ(true);
        }
    }

    public void showView() {
        if (!isShowing()) {
            aEw();
            Activity activity = (Activity) this.mContext;
            if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
                this.dll.setMode();
                showAtLocation(this.dli, 81, 0, 0);
                getContentView().setSystemUiVisibility(5120);
                setFocusable(true);
                update();
                final View contentView = this.dll.getContentView();
                if (contentView.getHeight() == 0) {
                    contentView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.menu.fontsize.c.2
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            c.this.dll.mU(contentView.getHeight());
                            c.this.aEx();
                            contentView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        }
                    });
                } else {
                    aEx();
                }
            }
        }
    }

    public void aEw() {
        if (this.dlj != null) {
            this.dlj.a(this.dll);
        }
    }

    public void a(a aVar) {
        this.dlm = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEx() {
        this.dlk.setAlpha(0.0f);
        this.dll.setTranslationY(this.dll.getHeight());
        ObjectAnimator a2 = com.baidu.swan.menu.c.a(this.dlk, this.dll);
        ObjectAnimator b = com.baidu.swan.menu.c.b(this.dll);
        ArrayList arrayList = new ArrayList();
        arrayList.add(a2);
        arrayList.add(b);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        animatorSet.start();
    }

    public void fZ(boolean z) {
        if (!z) {
            super.dismiss();
        } else if (isShowing()) {
            ObjectAnimator ba = com.baidu.swan.menu.c.ba(this.dlk);
            ObjectAnimator c = com.baidu.swan.menu.c.c(this.dll);
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
            animatorSet.playTogether(ba, c);
            animatorSet.start();
        }
    }
}

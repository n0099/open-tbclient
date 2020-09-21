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
/* loaded from: classes3.dex */
public class c extends PopupWindow implements View.OnClickListener {
    private View cFu;
    private com.baidu.swan.menu.a cFv;
    private View cFw;
    private FontSizeSettingMenuView cFx;
    private a cFy;
    private Context mContext;
    private ViewGroup mRootView;

    /* loaded from: classes3.dex */
    public interface a {
        void iD(int i);
    }

    public c(Context context, View view, @Nullable com.baidu.swan.menu.a aVar) {
        super(context);
        this.mContext = context;
        this.cFu = view;
        this.cFv = aVar;
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
        this.cFw = this.mRootView.findViewById(a.f.mask);
        this.cFx = (FontSizeSettingMenuView) this.mRootView.findViewById(a.f.font_size_setting);
        this.cFw.setOnClickListener(this);
        this.cFx.setClickListener(this);
        this.cFx.setOnSliderBarChangeListener(new SliderBar.b() { // from class: com.baidu.swan.apps.menu.fontsize.c.1
            @Override // com.baidu.swan.apps.res.ui.SliderBar.b
            public void a(SliderBar sliderBar, int i) {
                if (c.this.cFy != null) {
                    c.this.cFy.iD(i);
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
            eP(true);
        }
    }

    public void showView() {
        if (!isShowing()) {
            auQ();
            Activity activity = (Activity) this.mContext;
            if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
                this.cFx.setMode();
                showAtLocation(this.cFu, 81, 0, 0);
                getContentView().setSystemUiVisibility(5120);
                setFocusable(true);
                update();
                final View contentView = this.cFx.getContentView();
                if (contentView.getHeight() == 0) {
                    contentView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.menu.fontsize.c.2
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            c.this.cFx.lI(contentView.getHeight());
                            c.this.auR();
                            contentView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        }
                    });
                } else {
                    auR();
                }
            }
        }
    }

    public void auQ() {
        if (this.cFv != null) {
            this.cFv.a(this.cFx);
        }
    }

    public void a(a aVar) {
        this.cFy = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auR() {
        this.cFw.setAlpha(0.0f);
        this.cFx.setTranslationY(this.cFx.getHeight());
        ObjectAnimator a2 = com.baidu.swan.menu.c.a(this.cFw, this.cFx);
        ObjectAnimator b = com.baidu.swan.menu.c.b(this.cFx);
        ArrayList arrayList = new ArrayList();
        arrayList.add(a2);
        arrayList.add(b);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        animatorSet.start();
    }

    public void eP(boolean z) {
        if (!z) {
            super.dismiss();
        } else if (isShowing()) {
            ObjectAnimator aS = com.baidu.swan.menu.c.aS(this.cFw);
            ObjectAnimator c = com.baidu.swan.menu.c.c(this.cFx);
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
            animatorSet.playTogether(aS, c);
            animatorSet.start();
        }
    }
}

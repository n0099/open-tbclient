package com.baidu.swan.apps.menu.fontsize;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.ui.SliderBar;
import com.baidu.swan.menu.PopupWindow;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class c extends PopupWindow implements View.OnClickListener {
    private View dqh;
    private com.baidu.swan.menu.a dqi;
    private View dqj;
    private FontSizeSettingMenuView dqk;
    private a dql;
    private Context mContext;
    private ViewGroup mRootView;

    /* loaded from: classes9.dex */
    public interface a {
        void jK(int i);
    }

    public c(Context context, View view, @Nullable com.baidu.swan.menu.a aVar) {
        super(context);
        this.mContext = context;
        this.dqh = view;
        this.dqi = aVar;
        ei(false);
        setFocusable(true);
        eh(true);
        setBackgroundDrawable(new ColorDrawable(0));
        setWidth(-1);
        setHeight(-1);
        initViews();
    }

    private void initViews() {
        this.mRootView = (FrameLayout) LayoutInflater.from(this.mContext).inflate(a.g.swan_app_font_setting_layout, (ViewGroup) null);
        this.dqj = this.mRootView.findViewById(a.f.mask);
        this.dqk = (FontSizeSettingMenuView) this.mRootView.findViewById(a.f.font_size_setting);
        this.dqj.setOnClickListener(this);
        this.dqk.setClickListener(this);
        this.dqk.setOnSliderBarChangeListener(new SliderBar.b() { // from class: com.baidu.swan.apps.menu.fontsize.c.1
            @Override // com.baidu.swan.apps.res.ui.SliderBar.b
            public void a(SliderBar sliderBar, int i) {
                if (c.this.dql != null) {
                    c.this.dql.jK(i);
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
            gi(true);
        }
    }

    public void showView() {
        if (!isShowing()) {
            aFP();
            Activity activity = (Activity) this.mContext;
            if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
                this.dqk.setMode();
                showAtLocation(this.dqh, 81, 0, 0);
                getContentView().setSystemUiVisibility(Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION);
                setFocusable(true);
                update();
                final View contentView = this.dqk.getContentView();
                if (contentView.getHeight() == 0) {
                    contentView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.menu.fontsize.c.2
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            c.this.dqk.nc(contentView.getHeight());
                            c.this.aFQ();
                            contentView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        }
                    });
                } else {
                    aFQ();
                }
            }
        }
    }

    public void aFP() {
        if (this.dqi != null) {
            this.dqi.a(this.dqk);
        }
    }

    public void a(a aVar) {
        this.dql = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFQ() {
        this.dqj.setAlpha(0.0f);
        this.dqk.setTranslationY(this.dqk.getHeight());
        ObjectAnimator a2 = com.baidu.swan.menu.c.a(this.dqj, this.dqk);
        ObjectAnimator b2 = com.baidu.swan.menu.c.b(this.dqk);
        ArrayList arrayList = new ArrayList();
        arrayList.add(a2);
        arrayList.add(b2);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        animatorSet.start();
    }

    public void gi(boolean z) {
        if (!z) {
            super.dismiss();
        } else if (isShowing()) {
            ObjectAnimator bj = com.baidu.swan.menu.c.bj(this.dqj);
            ObjectAnimator c = com.baidu.swan.menu.c.c(this.dqk);
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
            animatorSet.playTogether(bj, c);
            animatorSet.start();
        }
    }
}

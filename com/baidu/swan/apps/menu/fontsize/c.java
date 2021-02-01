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
    private View dnC;
    private com.baidu.swan.menu.a dnD;
    private View dnE;
    private FontSizeSettingMenuView dnF;
    private a dnG;
    private Context mContext;
    private ViewGroup mRootView;

    /* loaded from: classes9.dex */
    public interface a {
        void ih(int i);
    }

    public c(Context context, View view, @Nullable com.baidu.swan.menu.a aVar) {
        super(context);
        this.mContext = context;
        this.dnC = view;
        this.dnD = aVar;
        eo(false);
        setFocusable(true);
        en(true);
        setBackgroundDrawable(new ColorDrawable(0));
        setWidth(-1);
        setHeight(-1);
        initViews();
    }

    private void initViews() {
        this.mRootView = (FrameLayout) LayoutInflater.from(this.mContext).inflate(a.g.swan_app_font_setting_layout, (ViewGroup) null);
        this.dnE = this.mRootView.findViewById(a.f.mask);
        this.dnF = (FontSizeSettingMenuView) this.mRootView.findViewById(a.f.font_size_setting);
        this.dnE.setOnClickListener(this);
        this.dnF.setClickListener(this);
        this.dnF.setOnSliderBarChangeListener(new SliderBar.b() { // from class: com.baidu.swan.apps.menu.fontsize.c.1
            @Override // com.baidu.swan.apps.res.ui.SliderBar.b
            public void a(SliderBar sliderBar, int i) {
                if (c.this.dnG != null) {
                    c.this.dnG.ih(i);
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
            gg(true);
        }
    }

    public void showView() {
        if (!isShowing()) {
            aCt();
            Activity activity = (Activity) this.mContext;
            if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
                this.dnF.setMode();
                showAtLocation(this.dnC, 81, 0, 0);
                getContentView().setSystemUiVisibility(Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION);
                setFocusable(true);
                update();
                final View contentView = this.dnF.getContentView();
                if (contentView.getHeight() == 0) {
                    contentView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.menu.fontsize.c.2
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            c.this.dnF.lz(contentView.getHeight());
                            c.this.aCu();
                            contentView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        }
                    });
                } else {
                    aCu();
                }
            }
        }
    }

    public void aCt() {
        if (this.dnD != null) {
            this.dnD.a(this.dnF);
        }
    }

    public void a(a aVar) {
        this.dnG = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCu() {
        this.dnE.setAlpha(0.0f);
        this.dnF.setTranslationY(this.dnF.getHeight());
        ObjectAnimator a2 = com.baidu.swan.menu.c.a(this.dnE, this.dnF);
        ObjectAnimator b2 = com.baidu.swan.menu.c.b(this.dnF);
        ArrayList arrayList = new ArrayList();
        arrayList.add(a2);
        arrayList.add(b2);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        animatorSet.start();
    }

    public void gg(boolean z) {
        if (!z) {
            super.dismiss();
        } else if (isShowing()) {
            ObjectAnimator bf = com.baidu.swan.menu.c.bf(this.dnE);
            ObjectAnimator c = com.baidu.swan.menu.c.c(this.dnF);
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
            animatorSet.playTogether(bf, c);
            animatorSet.start();
        }
    }
}

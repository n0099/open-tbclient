package com.baidu.swan.menu;

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
import com.baidu.swan.menu.g;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class j extends PopupWindow implements View.OnClickListener {
    private FrameLayout cSf;
    private View cYD;
    private BaseMenuView cYE;
    private View cYF;
    private MainMenuView cYG;
    private boolean cYH;
    private a cYI;
    private int cYJ;
    private Context mContext;
    private boolean mImmersionEnabled;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Context context, View view, @Nullable a aVar) {
        super(context);
        this.cYH = true;
        this.mImmersionEnabled = true;
        this.cYJ = 0;
        this.mContext = context;
        this.cYF = view;
        this.cYI = aVar;
        setClippingEnabled(false);
        setFocusable(true);
        setOutsideTouchable(true);
        setBackgroundDrawable(new ColorDrawable(0));
        setWidth(-1);
        setHeight(-1);
        initViews();
    }

    private void initViews() {
        this.cSf = (FrameLayout) LayoutInflater.from(this.mContext).inflate(g.e.aiapp_menu_layout, (ViewGroup) null);
        this.cYD = this.cSf.findViewById(g.d.mask);
        this.cYG = (MainMenuView) this.cSf.findViewById(g.d.aiapp_menu_body);
        this.cYD.setOnClickListener(this);
        this.cYG.setClickListener(this);
        this.cSf.measure(0, 0);
        setContentView(this.cSf);
    }

    private void showView() {
        if (!isShowing()) {
            aBh();
            this.cYG.reset();
            this.cYE = this.cYG;
            if (this.mImmersionEnabled) {
                setFocusable(false);
            }
            showAtLocation(this.cYF, 81, 0, 0);
            if (this.mImmersionEnabled) {
                getContentView().setSystemUiVisibility(this.cYJ | 1024 | 4096);
                setFocusable(true);
                update();
            }
            final View contentView = this.cYG.getContentView();
            if (contentView.getHeight() == 0) {
                contentView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.menu.j.1
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        j.this.cYG.it(contentView.getHeight());
                        j.this.aBi();
                        contentView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                });
            } else {
                aBi();
            }
        }
    }

    public void aBh() {
        if (this.cYI != null) {
            this.cYI.a(this.cYG);
        }
    }

    public void b(List<List<i>> list, View view, boolean z, int i) {
        this.cYG.a(list, view, z, i);
        showView();
    }

    @Override // com.baidu.swan.menu.PopupWindow
    public void dismiss() {
        fU(true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == g.d.cancel || id == g.d.mask) {
            fU(true);
        }
    }

    public void fU(boolean z) {
        if (!z) {
            super.dismiss();
        } else if (isShowing()) {
            ObjectAnimator aK = c.aK(this.cYD);
            ObjectAnimator b = c.b(this.cYE);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.menu.j.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Context context = j.this.mContext;
                    if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
                        j.super.dismiss();
                        if (j.this.cYE != j.this.cYG) {
                            j.this.cYE.setVisibility(8);
                        }
                    }
                }
            });
            animatorSet.playTogether(aK, b);
            animatorSet.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aBa() {
        this.cYG.aBa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBi() {
        this.cYD.setAlpha(0.0f);
        this.cYG.setTranslationY(this.cYG.getHeight());
        ObjectAnimator a = c.a(this.cYD, this.cYG);
        ObjectAnimator a2 = c.a(this.cYG);
        ArrayList arrayList = new ArrayList();
        arrayList.add(a);
        arrayList.add(a2);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        animatorSet.start();
    }

    public void ix(int i) {
        this.cYJ = i;
    }
}

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
/* loaded from: classes14.dex */
public class j extends PopupWindow implements View.OnClickListener {
    private FrameLayout aii;
    private View dfR;
    private View dfT;
    private BaseMenuView egH;
    private MainMenuView egI;
    private boolean egJ;
    private a egK;
    private int egL;
    private Context mContext;
    private boolean mImmersionEnabled;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Context context, View view, @Nullable a aVar) {
        super(context);
        this.egJ = true;
        this.mImmersionEnabled = true;
        this.egL = 0;
        this.mContext = context;
        this.dfR = view;
        this.egK = aVar;
        setClippingEnabled(false);
        setFocusable(true);
        setOutsideTouchable(true);
        setBackgroundDrawable(new ColorDrawable(0));
        setWidth(-1);
        setHeight(-1);
        initViews();
    }

    private void initViews() {
        this.aii = (FrameLayout) LayoutInflater.from(this.mContext).inflate(g.e.aiapp_menu_layout, (ViewGroup) null);
        this.dfT = this.aii.findViewById(g.d.mask);
        this.egI = (MainMenuView) this.aii.findViewById(g.d.aiapp_menu_body);
        this.dfT.setOnClickListener(this);
        this.egI.setClickListener(this);
        this.aii.measure(0, 0);
        setContentView(this.aii);
    }

    private void showView() {
        if (!isShowing()) {
            aBV();
            this.egI.reset();
            this.egH = this.egI;
            if (this.mImmersionEnabled) {
                setFocusable(false);
            }
            Activity activity = (Activity) this.mContext;
            if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
                showAtLocation(this.dfR, 81, 0, 0);
                if (this.mImmersionEnabled) {
                    getContentView().setSystemUiVisibility(this.egL | 1024 | 4096);
                    setFocusable(true);
                    update();
                }
                final View contentView = this.egI.getContentView();
                if (contentView.getHeight() == 0) {
                    contentView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.menu.j.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            j.this.egI.mA(contentView.getHeight());
                            j.this.aBW();
                            contentView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        }
                    });
                } else {
                    aBW();
                }
            }
        }
    }

    public void aBV() {
        if (this.egK != null) {
            this.egK.a(this.egI);
        }
    }

    public void b(List<List<i>> list, View view, boolean z, int i) {
        this.egI.a(list, view, z, i);
        showView();
    }

    @Override // com.baidu.swan.menu.PopupWindow
    public void dismiss() {
        fH(true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == g.d.cancel || id == g.d.mask) {
            fH(true);
        }
    }

    public void fH(boolean z) {
        if (!z) {
            super.dismiss();
        } else if (isShowing()) {
            ObjectAnimator aY = c.aY(this.dfT);
            ObjectAnimator c = c.c(this.egH);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.menu.j.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Context context = j.this.mContext;
                    if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
                        j.super.dismiss();
                        if (j.this.egH != j.this.egI) {
                            j.this.egH.setVisibility(8);
                        }
                    }
                }
            });
            animatorSet.playTogether(aY, c);
            animatorSet.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bar() {
        this.egI.bar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBW() {
        this.dfT.setAlpha(0.0f);
        this.egI.setTranslationY(this.egI.getHeight());
        ObjectAnimator a2 = c.a(this.dfT, this.egI);
        ObjectAnimator b = c.b(this.egI);
        ArrayList arrayList = new ArrayList();
        arrayList.add(a2);
        arrayList.add(b);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        animatorSet.start();
    }

    public void mE(int i) {
        this.egL = i;
    }
}

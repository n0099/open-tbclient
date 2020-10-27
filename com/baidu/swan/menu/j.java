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
    private View cZU;
    private View cZW;
    private BaseMenuView eaP;
    private MainMenuView eaQ;
    private boolean eaR;
    private a eaS;
    private int eaT;
    private Context mContext;
    private boolean mImmersionEnabled;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Context context, View view, @Nullable a aVar) {
        super(context);
        this.eaR = true;
        this.mImmersionEnabled = true;
        this.eaT = 0;
        this.mContext = context;
        this.cZU = view;
        this.eaS = aVar;
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
        this.cZW = this.aii.findViewById(g.d.mask);
        this.eaQ = (MainMenuView) this.aii.findViewById(g.d.aiapp_menu_body);
        this.cZW.setOnClickListener(this);
        this.eaQ.setClickListener(this);
        this.aii.measure(0, 0);
        setContentView(this.aii);
    }

    private void showView() {
        if (!isShowing()) {
            azv();
            this.eaQ.reset();
            this.eaP = this.eaQ;
            if (this.mImmersionEnabled) {
                setFocusable(false);
            }
            Activity activity = (Activity) this.mContext;
            if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
                showAtLocation(this.cZU, 81, 0, 0);
                if (this.mImmersionEnabled) {
                    getContentView().setSystemUiVisibility(this.eaT | 1024 | 4096);
                    setFocusable(true);
                    update();
                }
                final View contentView = this.eaQ.getContentView();
                if (contentView.getHeight() == 0) {
                    contentView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.menu.j.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            j.this.eaQ.mq(contentView.getHeight());
                            j.this.azw();
                            contentView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        }
                    });
                } else {
                    azw();
                }
            }
        }
    }

    public void azv() {
        if (this.eaS != null) {
            this.eaS.a(this.eaQ);
        }
    }

    public void b(List<List<i>> list, View view, boolean z, int i) {
        this.eaQ.a(list, view, z, i);
        showView();
    }

    @Override // com.baidu.swan.menu.PopupWindow
    public void dismiss() {
        fy(true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == g.d.cancel || id == g.d.mask) {
            fy(true);
        }
    }

    public void fy(boolean z) {
        if (!z) {
            super.dismiss();
        } else if (isShowing()) {
            ObjectAnimator aU = c.aU(this.cZW);
            ObjectAnimator c = c.c(this.eaP);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.menu.j.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Context context = j.this.mContext;
                    if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
                        j.super.dismiss();
                        if (j.this.eaP != j.this.eaQ) {
                            j.this.eaP.setVisibility(8);
                        }
                    }
                }
            });
            animatorSet.playTogether(aU, c);
            animatorSet.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aXR() {
        this.eaQ.aXR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azw() {
        this.cZW.setAlpha(0.0f);
        this.eaQ.setTranslationY(this.eaQ.getHeight());
        ObjectAnimator a2 = c.a(this.cZW, this.eaQ);
        ObjectAnimator b = c.b(this.eaQ);
        ArrayList arrayList = new ArrayList();
        arrayList.add(a2);
        arrayList.add(b);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        animatorSet.start();
    }

    public void mu(int i) {
        this.eaT = i;
    }
}

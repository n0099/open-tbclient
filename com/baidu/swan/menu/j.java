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
/* loaded from: classes10.dex */
public class j extends PopupWindow implements View.OnClickListener {
    private FrameLayout coW;
    private int cvA;
    private View cvu;
    private BaseMenuView cvv;
    private View cvw;
    private MainMenuView cvx;
    private boolean cvy;
    private a cvz;
    private Context mContext;
    private boolean mImmersionEnabled;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Context context, View view, @Nullable a aVar) {
        super(context);
        this.cvy = true;
        this.mImmersionEnabled = true;
        this.cvA = 0;
        this.mContext = context;
        this.cvw = view;
        this.cvz = aVar;
        setClippingEnabled(false);
        setFocusable(true);
        setOutsideTouchable(true);
        setBackgroundDrawable(new ColorDrawable(0));
        setWidth(-1);
        setHeight(-1);
        initViews();
    }

    private void initViews() {
        this.coW = (FrameLayout) LayoutInflater.from(this.mContext).inflate(g.e.aiapp_menu_layout, (ViewGroup) null);
        this.cvu = this.coW.findViewById(g.d.mask);
        this.cvx = (MainMenuView) this.coW.findViewById(g.d.aiapp_menu_body);
        this.cvu.setOnClickListener(this);
        this.cvx.setClickListener(this);
        this.coW.measure(0, 0);
        setContentView(this.coW);
    }

    private void showView() {
        if (!isShowing()) {
            aqE();
            this.cvx.reset();
            this.cvv = this.cvx;
            if (this.mImmersionEnabled) {
                setFocusable(false);
            }
            showAtLocation(this.cvw, 81, 0, 0);
            if (this.mImmersionEnabled) {
                getContentView().setSystemUiVisibility(this.cvA | 1024 | 4096);
                setFocusable(true);
                update();
            }
            final View contentView = this.cvx.getContentView();
            if (contentView.getHeight() == 0) {
                contentView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.menu.j.1
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        j.this.cvx.hV(contentView.getHeight());
                        j.this.aqF();
                        contentView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                });
            } else {
                aqF();
            }
        }
    }

    public void aqE() {
        if (this.cvz != null) {
            this.cvz.a(this.cvx);
        }
    }

    public void b(List<List<i>> list, View view, boolean z, int i) {
        this.cvx.a(list, view, z, i);
        showView();
    }

    @Override // com.baidu.swan.menu.PopupWindow
    public void dismiss() {
        eP(true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == g.d.cancel || id == g.d.mask) {
            eP(true);
        }
    }

    public void eP(boolean z) {
        if (!z) {
            super.dismiss();
        } else if (isShowing()) {
            ObjectAnimator aJ = c.aJ(this.cvu);
            ObjectAnimator b = c.b(this.cvv);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.menu.j.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Context context = j.this.mContext;
                    if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
                        j.super.dismiss();
                        if (j.this.cvv != j.this.cvx) {
                            j.this.cvv.setVisibility(8);
                        }
                    }
                }
            });
            animatorSet.playTogether(aJ, b);
            animatorSet.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aqx() {
        this.cvx.aqx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqF() {
        this.cvu.setAlpha(0.0f);
        this.cvx.setTranslationY(this.cvx.getHeight());
        ObjectAnimator a = c.a(this.cvu, this.cvx);
        ObjectAnimator a2 = c.a(this.cvx);
        ArrayList arrayList = new ArrayList();
        arrayList.add(a);
        arrayList.add(a2);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        animatorSet.start();
    }

    public void hZ(int i) {
        this.cvA = i;
    }
}

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
    private FrameLayout ctk;
    private View czF;
    private BaseMenuView czG;
    private View czH;
    private MainMenuView czI;
    private boolean czJ;
    private a czK;
    private int czL;
    private Context mContext;
    private boolean mImmersionEnabled;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Context context, View view, @Nullable a aVar) {
        super(context);
        this.czJ = true;
        this.mImmersionEnabled = true;
        this.czL = 0;
        this.mContext = context;
        this.czH = view;
        this.czK = aVar;
        setClippingEnabled(false);
        setFocusable(true);
        setOutsideTouchable(true);
        setBackgroundDrawable(new ColorDrawable(0));
        setWidth(-1);
        setHeight(-1);
        initViews();
    }

    private void initViews() {
        this.ctk = (FrameLayout) LayoutInflater.from(this.mContext).inflate(g.e.aiapp_menu_layout, (ViewGroup) null);
        this.czF = this.ctk.findViewById(g.d.mask);
        this.czI = (MainMenuView) this.ctk.findViewById(g.d.aiapp_menu_body);
        this.czF.setOnClickListener(this);
        this.czI.setClickListener(this);
        this.ctk.measure(0, 0);
        setContentView(this.ctk);
    }

    private void showView() {
        if (!isShowing()) {
            asX();
            this.czI.reset();
            this.czG = this.czI;
            if (this.mImmersionEnabled) {
                setFocusable(false);
            }
            showAtLocation(this.czH, 81, 0, 0);
            if (this.mImmersionEnabled) {
                getContentView().setSystemUiVisibility(this.czL | 1024 | 4096);
                setFocusable(true);
                update();
            }
            final View contentView = this.czI.getContentView();
            if (contentView.getHeight() == 0) {
                contentView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.menu.j.1
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        j.this.czI.im(contentView.getHeight());
                        j.this.asY();
                        contentView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                });
            } else {
                asY();
            }
        }
    }

    public void asX() {
        if (this.czK != null) {
            this.czK.a(this.czI);
        }
    }

    public void b(List<List<i>> list, View view, boolean z, int i) {
        this.czI.a(list, view, z, i);
        showView();
    }

    @Override // com.baidu.swan.menu.PopupWindow
    public void dismiss() {
        eX(true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == g.d.cancel || id == g.d.mask) {
            eX(true);
        }
    }

    public void eX(boolean z) {
        if (!z) {
            super.dismiss();
        } else if (isShowing()) {
            ObjectAnimator aJ = c.aJ(this.czF);
            ObjectAnimator b = c.b(this.czG);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.menu.j.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Context context = j.this.mContext;
                    if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
                        j.super.dismiss();
                        if (j.this.czG != j.this.czI) {
                            j.this.czG.setVisibility(8);
                        }
                    }
                }
            });
            animatorSet.playTogether(aJ, b);
            animatorSet.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void asQ() {
        this.czI.asQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asY() {
        this.czF.setAlpha(0.0f);
        this.czI.setTranslationY(this.czI.getHeight());
        ObjectAnimator a = c.a(this.czF, this.czI);
        ObjectAnimator a2 = c.a(this.czI);
        ArrayList arrayList = new ArrayList();
        arrayList.add(a);
        arrayList.add(a2);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        animatorSet.start();
    }

    public void iq(int i) {
        this.czL = i;
    }
}

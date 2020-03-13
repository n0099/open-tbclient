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
    private FrameLayout csZ;
    private int czA;
    private View czu;
    private BaseMenuView czv;
    private View czw;
    private MainMenuView czx;
    private boolean czy;
    private a czz;
    private Context mContext;
    private boolean mImmersionEnabled;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Context context, View view, @Nullable a aVar) {
        super(context);
        this.czy = true;
        this.mImmersionEnabled = true;
        this.czA = 0;
        this.mContext = context;
        this.czw = view;
        this.czz = aVar;
        setClippingEnabled(false);
        setFocusable(true);
        setOutsideTouchable(true);
        setBackgroundDrawable(new ColorDrawable(0));
        setWidth(-1);
        setHeight(-1);
        initViews();
    }

    private void initViews() {
        this.csZ = (FrameLayout) LayoutInflater.from(this.mContext).inflate(g.e.aiapp_menu_layout, (ViewGroup) null);
        this.czu = this.csZ.findViewById(g.d.mask);
        this.czx = (MainMenuView) this.csZ.findViewById(g.d.aiapp_menu_body);
        this.czu.setOnClickListener(this);
        this.czx.setClickListener(this);
        this.csZ.measure(0, 0);
        setContentView(this.csZ);
    }

    private void showView() {
        if (!isShowing()) {
            asU();
            this.czx.reset();
            this.czv = this.czx;
            if (this.mImmersionEnabled) {
                setFocusable(false);
            }
            showAtLocation(this.czw, 81, 0, 0);
            if (this.mImmersionEnabled) {
                getContentView().setSystemUiVisibility(this.czA | 1024 | 4096);
                setFocusable(true);
                update();
            }
            final View contentView = this.czx.getContentView();
            if (contentView.getHeight() == 0) {
                contentView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.menu.j.1
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        j.this.czx.im(contentView.getHeight());
                        j.this.asV();
                        contentView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                });
            } else {
                asV();
            }
        }
    }

    public void asU() {
        if (this.czz != null) {
            this.czz.a(this.czx);
        }
    }

    public void b(List<List<i>> list, View view, boolean z, int i) {
        this.czx.a(list, view, z, i);
        showView();
    }

    @Override // com.baidu.swan.menu.PopupWindow
    public void dismiss() {
        eW(true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == g.d.cancel || id == g.d.mask) {
            eW(true);
        }
    }

    public void eW(boolean z) {
        if (!z) {
            super.dismiss();
        } else if (isShowing()) {
            ObjectAnimator aJ = c.aJ(this.czu);
            ObjectAnimator b = c.b(this.czv);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.menu.j.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Context context = j.this.mContext;
                    if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
                        j.super.dismiss();
                        if (j.this.czv != j.this.czx) {
                            j.this.czv.setVisibility(8);
                        }
                    }
                }
            });
            animatorSet.playTogether(aJ, b);
            animatorSet.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void asN() {
        this.czx.asN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asV() {
        this.czu.setAlpha(0.0f);
        this.czx.setTranslationY(this.czx.getHeight());
        ObjectAnimator a = c.a(this.czu, this.czx);
        ObjectAnimator a2 = c.a(this.czx);
        ArrayList arrayList = new ArrayList();
        arrayList.add(a);
        arrayList.add(a2);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        animatorSet.start();
    }

    public void iq(int i) {
        this.czA = i;
    }
}

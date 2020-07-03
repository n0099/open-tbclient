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
    private FrameLayout agu;
    private MainMenuView doA;
    private boolean doB;
    private a doC;
    private int doD;
    private View dox;
    private BaseMenuView doy;
    private View doz;
    private Context mContext;
    private boolean mImmersionEnabled;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Context context, View view, @Nullable a aVar) {
        super(context);
        this.doB = true;
        this.mImmersionEnabled = true;
        this.doD = 0;
        this.mContext = context;
        this.doz = view;
        this.doC = aVar;
        setClippingEnabled(false);
        setFocusable(true);
        setOutsideTouchable(true);
        setBackgroundDrawable(new ColorDrawable(0));
        setWidth(-1);
        setHeight(-1);
        initViews();
    }

    private void initViews() {
        this.agu = (FrameLayout) LayoutInflater.from(this.mContext).inflate(g.e.aiapp_menu_layout, (ViewGroup) null);
        this.dox = this.agu.findViewById(g.d.mask);
        this.doA = (MainMenuView) this.agu.findViewById(g.d.aiapp_menu_body);
        this.dox.setOnClickListener(this);
        this.doA.setClickListener(this);
        this.agu.measure(0, 0);
        setContentView(this.agu);
    }

    private void showView() {
        if (!isShowing()) {
            aGf();
            this.doA.reset();
            this.doy = this.doA;
            if (this.mImmersionEnabled) {
                setFocusable(false);
            }
            showAtLocation(this.doz, 81, 0, 0);
            if (this.mImmersionEnabled) {
                getContentView().setSystemUiVisibility(this.doD | 1024 | 4096);
                setFocusable(true);
                update();
            }
            final View contentView = this.doA.getContentView();
            if (contentView.getHeight() == 0) {
                contentView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.menu.j.1
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        j.this.doA.iX(contentView.getHeight());
                        j.this.aGg();
                        contentView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                });
            } else {
                aGg();
            }
        }
    }

    public void aGf() {
        if (this.doC != null) {
            this.doC.a(this.doA);
        }
    }

    public void b(List<List<i>> list, View view, boolean z, int i) {
        this.doA.a(list, view, z, i);
        showView();
    }

    @Override // com.baidu.swan.menu.PopupWindow
    public void dismiss() {
        gk(true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == g.d.cancel || id == g.d.mask) {
            gk(true);
        }
    }

    public void gk(boolean z) {
        if (!z) {
            super.dismiss();
        } else if (isShowing()) {
            ObjectAnimator aJ = c.aJ(this.dox);
            ObjectAnimator b = c.b(this.doy);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.menu.j.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Context context = j.this.mContext;
                    if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
                        j.super.dismiss();
                        if (j.this.doy != j.this.doA) {
                            j.this.doy.setVisibility(8);
                        }
                    }
                }
            });
            animatorSet.playTogether(aJ, b);
            animatorSet.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aFY() {
        this.doA.aFY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGg() {
        this.dox.setAlpha(0.0f);
        this.doA.setTranslationY(this.doA.getHeight());
        ObjectAnimator a = c.a(this.dox, this.doA);
        ObjectAnimator a2 = c.a(this.doA);
        ArrayList arrayList = new ArrayList();
        arrayList.add(a);
        arrayList.add(a2);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        animatorSet.start();
    }

    public void jb(int i) {
        this.doD = i;
    }
}

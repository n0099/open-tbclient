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
import com.baidu.swan.menu.f;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class o extends PopupWindow implements View.OnClickListener, a {
    private boolean aKD;
    private FrameLayout bEW;
    private int bJS;
    private String bKI;
    private View bKV;
    private BaseMenuView bKW;
    private g bKX;
    private View bKY;
    private MainMenuView bKZ;
    private boolean bLa;
    private b bLb;
    private int bLc;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(Context context, View view, int i, @Nullable b bVar) {
        super(context);
        this.bLa = true;
        this.aKD = true;
        this.bLc = 0;
        this.mContext = context;
        this.bKY = view;
        this.bJS = i;
        this.bLb = bVar;
        dx(false);
        setFocusable(true);
        dw(true);
        setBackgroundDrawable(new ColorDrawable(0));
        setAnimationStyle(f.g.aiapp_menu);
        setWidth(-1);
        setHeight(-1);
        initViews();
    }

    @Override // com.baidu.swan.menu.PopupWindow
    public void dismiss() {
        dB(true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == f.d.cancel || id == f.d.mask) {
            dB(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setStatisticSource(String str) {
        this.bKI = str;
        this.bKZ.setStatisticSource(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMenuSource(String str) {
        this.bKZ.setMenuSource(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void showView() {
        if (!isShowing()) {
            if (this.bLb != null) {
                this.bLb.a(this.bKZ);
            }
            this.bKZ.reset();
            this.bKW = this.bKZ;
            final View contentView = this.bKZ.getContentView();
            b(this.bKY, 81, 0, 0);
            if (contentView.getHeight() == 0) {
                contentView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.menu.o.1
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        o.this.bKZ.gr(contentView.getHeight());
                        o.this.aaH();
                        contentView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                });
            } else {
                aaH();
            }
            this.bKZ.aax();
        }
    }

    public void b(View view, int i, int i2, int i3) {
        if (this.aKD) {
            setFocusable(false);
        }
        a(view, i, i2, i3);
        if (this.aKD) {
            getContentView().setSystemUiVisibility(this.bLc | 1024 | 4096);
            setFocusable(true);
            update();
        }
    }

    public void dB(boolean z) {
        if (!z) {
            super.dismiss();
        } else if (isShowing()) {
            ObjectAnimator aH = d.aH(this.bKV);
            ObjectAnimator d = d.d(this.bKW);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.menu.o.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Context context = o.this.mContext;
                    if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
                        o.super.dismiss();
                        if (o.this.bKW != o.this.bKZ) {
                            o.this.bKW.setVisibility(8);
                        }
                    }
                }
            });
            animatorSet.playTogether(aH, d);
            animatorSet.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void af(List<j> list) {
        this.bKZ.aa(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(g gVar) {
        this.bKX = gVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMode(SwanAppMenuMode swanAppMenuMode) {
        this.bKZ.setMode(swanAppMenuMode);
    }

    private void initViews() {
        this.bEW = (FrameLayout) LayoutInflater.from(this.mContext).inflate(f.e.aiapp_menu_layout, (ViewGroup) null);
        this.bKV = this.bEW.findViewById(f.d.mask);
        this.bKZ = (MainMenuView) this.bEW.findViewById(f.d.aiapp_menu_body);
        this.bKV.setOnClickListener(this);
        this.bKZ.setClickListener(this);
        this.bKZ.setMenuStyle(this.bJS);
        this.bKZ.setDismissCallback(this);
        this.bEW.measure(0, 0);
        setContentView(this.bEW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaH() {
        ObjectAnimator b;
        View bgView = this.bKZ.getBgView();
        View contentView = this.bKZ.getContentView();
        int height = contentView.getHeight();
        this.bKZ.setTranslationY(0.0f);
        bgView.setTranslationY(height);
        contentView.setTranslationY(height);
        this.bKV.setAlpha(0.0f);
        contentView.setAlpha(0.0f);
        ObjectAnimator a = d.a(this.bKV, this.bKZ);
        ObjectAnimator a2 = d.a(this.bKZ);
        ObjectAnimator b2 = d.b((BaseMenuView) this.bKZ);
        ObjectAnimator c = d.c(this.bKZ);
        ArrayList arrayList = new ArrayList();
        arrayList.add(a);
        arrayList.add(a2);
        arrayList.add(b2);
        arrayList.add(c);
        View coverView = this.bKZ.getCoverView();
        if (coverView != null && (b = d.b(this.bKZ)) != null) {
            coverView.setTranslationY(height);
            arrayList.add(b);
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        animatorSet.start();
    }

    public void gu(int i) {
        this.bLc = i;
    }
}

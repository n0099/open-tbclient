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
/* loaded from: classes2.dex */
public class p extends PopupWindow implements View.OnClickListener, b {
    private static final boolean DEBUG = a.DEBUG;
    private boolean aqa;
    private FrameLayout bfF;
    private int bjO;
    private String bkF;
    private View bkS;
    private BaseMenuView bkT;
    private h bkU;
    private View bkV;
    private MainMenuView bkW;
    private boolean bkX;
    private c bkY;
    private int bkZ;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(Context context, View view, int i, @Nullable c cVar) {
        super(context);
        this.bkX = true;
        this.aqa = true;
        this.bkZ = 0;
        this.mContext = context;
        this.bkV = view;
        this.bjO = i;
        this.bkY = cVar;
        setClippingEnabled(false);
        setFocusable(true);
        setOutsideTouchable(true);
        setBackgroundDrawable(new ColorDrawable(0));
        setAnimationStyle(g.C0177g.aiapp_menu);
        setWidth(-1);
        setHeight(-1);
        initViews();
    }

    @Override // com.baidu.swan.menu.PopupWindow
    public void dismiss() {
        cO(true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == g.d.cancel || id == g.d.mask) {
            cO(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setStatisticSource(String str) {
        this.bkF = str;
        this.bkW.setStatisticSource(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMenuSource(String str) {
        this.bkW.setMenuSource(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void showView() {
        if (!isShowing()) {
            if (this.bkY != null) {
                this.bkY.a(this.bkW);
            }
            this.bkW.reset();
            this.bkT = this.bkW;
            final View contentView = this.bkW.getContentView();
            a(this.bkV, 81, 0, 0);
            if (contentView.getHeight() == 0) {
                contentView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.menu.p.1
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        p.this.bkW.eT(contentView.getHeight());
                        p.this.Rl();
                        contentView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                });
            } else {
                Rl();
            }
            this.bkW.Rc();
        }
    }

    public void a(View view, int i, int i2, int i3) {
        if (this.aqa) {
            setFocusable(false);
        }
        showAtLocation(view, i, i2, i3);
        if (this.aqa) {
            getContentView().setSystemUiVisibility(this.bkZ | 1024 | 4096);
            setFocusable(true);
            update();
        }
    }

    public void cO(boolean z) {
        if (!z) {
            super.dismiss();
        } else if (isShowing()) {
            ObjectAnimator at = e.at(this.bkS);
            ObjectAnimator d = e.d(this.bkT);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.menu.p.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Context context = p.this.mContext;
                    if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
                        p.super.dismiss();
                        if (p.this.bkT != p.this.bkW) {
                            p.this.bkT.setVisibility(8);
                        }
                    }
                }
            });
            animatorSet.playTogether(at, d);
            animatorSet.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void F(List<k> list) {
        this.bkW.A(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(h hVar) {
        this.bkU = hVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMode(SwanAppMenuMode swanAppMenuMode) {
        this.bkW.setMode(swanAppMenuMode);
    }

    private void initViews() {
        this.bfF = (FrameLayout) LayoutInflater.from(this.mContext).inflate(g.e.aiapp_menu_layout, (ViewGroup) null);
        this.bkS = this.bfF.findViewById(g.d.mask);
        this.bkW = (MainMenuView) this.bfF.findViewById(g.d.aiapp_menu_body);
        this.bkS.setOnClickListener(this);
        this.bkW.setClickListener(this);
        this.bkW.setMenuStyle(this.bjO);
        this.bkW.setDismissCallback(this);
        this.bfF.measure(0, 0);
        setContentView(this.bfF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rl() {
        ObjectAnimator b;
        View bgView = this.bkW.getBgView();
        View contentView = this.bkW.getContentView();
        int height = contentView.getHeight();
        this.bkW.setTranslationY(0.0f);
        bgView.setTranslationY(height);
        contentView.setTranslationY(height);
        this.bkS.setAlpha(0.0f);
        contentView.setAlpha(0.0f);
        ObjectAnimator a = e.a(this.bkS, this.bkW);
        ObjectAnimator a2 = e.a(this.bkW);
        ObjectAnimator b2 = e.b((BaseMenuView) this.bkW);
        ObjectAnimator c = e.c(this.bkW);
        ArrayList arrayList = new ArrayList();
        arrayList.add(a);
        arrayList.add(a2);
        arrayList.add(b2);
        arrayList.add(c);
        View coverView = this.bkW.getCoverView();
        if (coverView != null && (b = e.b(this.bkW)) != null) {
            coverView.setTranslationY(height);
            arrayList.add(b);
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        animatorSet.start();
    }

    public void eW(int i) {
        this.bkZ = i;
    }
}

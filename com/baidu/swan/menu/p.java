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
    private boolean aqf;
    private FrameLayout bfJ;
    private int bjS;
    private String bkJ;
    private View bkW;
    private BaseMenuView bkX;
    private h bkY;
    private View bkZ;
    private MainMenuView bla;
    private boolean blb;
    private c blc;
    private int bld;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(Context context, View view, int i, @Nullable c cVar) {
        super(context);
        this.blb = true;
        this.aqf = true;
        this.bld = 0;
        this.mContext = context;
        this.bkZ = view;
        this.bjS = i;
        this.blc = cVar;
        setClippingEnabled(false);
        setFocusable(true);
        setOutsideTouchable(true);
        setBackgroundDrawable(new ColorDrawable(0));
        setAnimationStyle(g.C0211g.aiapp_menu);
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
        this.bkJ = str;
        this.bla.setStatisticSource(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMenuSource(String str) {
        this.bla.setMenuSource(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void showView() {
        if (!isShowing()) {
            if (this.blc != null) {
                this.blc.a(this.bla);
            }
            this.bla.reset();
            this.bkX = this.bla;
            final View contentView = this.bla.getContentView();
            a(this.bkZ, 81, 0, 0);
            if (contentView.getHeight() == 0) {
                contentView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.menu.p.1
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        p.this.bla.eS(contentView.getHeight());
                        p.this.Rj();
                        contentView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                });
            } else {
                Rj();
            }
            this.bla.Ra();
        }
    }

    public void a(View view, int i, int i2, int i3) {
        if (this.aqf) {
            setFocusable(false);
        }
        showAtLocation(view, i, i2, i3);
        if (this.aqf) {
            getContentView().setSystemUiVisibility(this.bld | 1024 | 4096);
            setFocusable(true);
            update();
        }
    }

    public void cO(boolean z) {
        if (!z) {
            super.dismiss();
        } else if (isShowing()) {
            ObjectAnimator at = e.at(this.bkW);
            ObjectAnimator d = e.d(this.bkX);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.menu.p.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Context context = p.this.mContext;
                    if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
                        p.super.dismiss();
                        if (p.this.bkX != p.this.bla) {
                            p.this.bkX.setVisibility(8);
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
        this.bla.A(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(h hVar) {
        this.bkY = hVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMode(SwanAppMenuMode swanAppMenuMode) {
        this.bla.setMode(swanAppMenuMode);
    }

    private void initViews() {
        this.bfJ = (FrameLayout) LayoutInflater.from(this.mContext).inflate(g.e.aiapp_menu_layout, (ViewGroup) null);
        this.bkW = this.bfJ.findViewById(g.d.mask);
        this.bla = (MainMenuView) this.bfJ.findViewById(g.d.aiapp_menu_body);
        this.bkW.setOnClickListener(this);
        this.bla.setClickListener(this);
        this.bla.setMenuStyle(this.bjS);
        this.bla.setDismissCallback(this);
        this.bfJ.measure(0, 0);
        setContentView(this.bfJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rj() {
        ObjectAnimator b;
        View bgView = this.bla.getBgView();
        View contentView = this.bla.getContentView();
        int height = contentView.getHeight();
        this.bla.setTranslationY(0.0f);
        bgView.setTranslationY(height);
        contentView.setTranslationY(height);
        this.bkW.setAlpha(0.0f);
        contentView.setAlpha(0.0f);
        ObjectAnimator a = e.a(this.bkW, this.bla);
        ObjectAnimator a2 = e.a(this.bla);
        ObjectAnimator b2 = e.b((BaseMenuView) this.bla);
        ObjectAnimator c = e.c(this.bla);
        ArrayList arrayList = new ArrayList();
        arrayList.add(a);
        arrayList.add(a2);
        arrayList.add(b2);
        arrayList.add(c);
        View coverView = this.bla.getCoverView();
        if (coverView != null && (b = e.b(this.bla)) != null) {
            coverView.setTranslationY(height);
            arrayList.add(b);
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        animatorSet.start();
    }

    public void eV(int i) {
        this.bld = i;
    }
}

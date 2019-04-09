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
    private boolean aqg;
    private FrameLayout bfK;
    private int bjT;
    private String bkK;
    private View bkX;
    private BaseMenuView bkY;
    private h bkZ;
    private View bla;
    private MainMenuView blb;
    private boolean blc;
    private c bld;
    private int ble;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(Context context, View view, int i, @Nullable c cVar) {
        super(context);
        this.blc = true;
        this.aqg = true;
        this.ble = 0;
        this.mContext = context;
        this.bla = view;
        this.bjT = i;
        this.bld = cVar;
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
        this.bkK = str;
        this.blb.setStatisticSource(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMenuSource(String str) {
        this.blb.setMenuSource(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void showView() {
        if (!isShowing()) {
            if (this.bld != null) {
                this.bld.a(this.blb);
            }
            this.blb.reset();
            this.bkY = this.blb;
            final View contentView = this.blb.getContentView();
            a(this.bla, 81, 0, 0);
            if (contentView.getHeight() == 0) {
                contentView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.menu.p.1
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        p.this.blb.eS(contentView.getHeight());
                        p.this.Rj();
                        contentView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                });
            } else {
                Rj();
            }
            this.blb.Ra();
        }
    }

    public void a(View view, int i, int i2, int i3) {
        if (this.aqg) {
            setFocusable(false);
        }
        showAtLocation(view, i, i2, i3);
        if (this.aqg) {
            getContentView().setSystemUiVisibility(this.ble | 1024 | 4096);
            setFocusable(true);
            update();
        }
    }

    public void cO(boolean z) {
        if (!z) {
            super.dismiss();
        } else if (isShowing()) {
            ObjectAnimator at = e.at(this.bkX);
            ObjectAnimator d = e.d(this.bkY);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.menu.p.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Context context = p.this.mContext;
                    if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
                        p.super.dismiss();
                        if (p.this.bkY != p.this.blb) {
                            p.this.bkY.setVisibility(8);
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
        this.blb.A(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(h hVar) {
        this.bkZ = hVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMode(SwanAppMenuMode swanAppMenuMode) {
        this.blb.setMode(swanAppMenuMode);
    }

    private void initViews() {
        this.bfK = (FrameLayout) LayoutInflater.from(this.mContext).inflate(g.e.aiapp_menu_layout, (ViewGroup) null);
        this.bkX = this.bfK.findViewById(g.d.mask);
        this.blb = (MainMenuView) this.bfK.findViewById(g.d.aiapp_menu_body);
        this.bkX.setOnClickListener(this);
        this.blb.setClickListener(this);
        this.blb.setMenuStyle(this.bjT);
        this.blb.setDismissCallback(this);
        this.bfK.measure(0, 0);
        setContentView(this.bfK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rj() {
        ObjectAnimator b;
        View bgView = this.blb.getBgView();
        View contentView = this.blb.getContentView();
        int height = contentView.getHeight();
        this.blb.setTranslationY(0.0f);
        bgView.setTranslationY(height);
        contentView.setTranslationY(height);
        this.bkX.setAlpha(0.0f);
        contentView.setAlpha(0.0f);
        ObjectAnimator a = e.a(this.bkX, this.blb);
        ObjectAnimator a2 = e.a(this.blb);
        ObjectAnimator b2 = e.b((BaseMenuView) this.blb);
        ObjectAnimator c = e.c(this.blb);
        ArrayList arrayList = new ArrayList();
        arrayList.add(a);
        arrayList.add(a2);
        arrayList.add(b2);
        arrayList.add(c);
        View coverView = this.blb.getCoverView();
        if (coverView != null && (b = e.b(this.blb)) != null) {
            coverView.setTranslationY(height);
            arrayList.add(b);
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        animatorSet.start();
    }

    public void eV(int i) {
        this.ble = i;
    }
}

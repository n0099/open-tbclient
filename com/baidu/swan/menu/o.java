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
    private boolean aKl;
    private FrameLayout bEf;
    private String bJR;
    private int bJb;
    private View bKe;
    private BaseMenuView bKf;
    private g bKg;
    private View bKh;
    private MainMenuView bKi;
    private boolean bKj;
    private b bKk;
    private int bKl;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(Context context, View view, int i, @Nullable b bVar) {
        super(context);
        this.bKj = true;
        this.aKl = true;
        this.bKl = 0;
        this.mContext = context;
        this.bKh = view;
        this.bJb = i;
        this.bKk = bVar;
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
        this.bJR = str;
        this.bKi.setStatisticSource(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMenuSource(String str) {
        this.bKi.setMenuSource(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void showView() {
        if (!isShowing()) {
            if (this.bKk != null) {
                this.bKk.a(this.bKi);
            }
            this.bKi.reset();
            this.bKf = this.bKi;
            final View contentView = this.bKi.getContentView();
            b(this.bKh, 81, 0, 0);
            if (contentView.getHeight() == 0) {
                contentView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.menu.o.1
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        o.this.bKi.gq(contentView.getHeight());
                        o.this.aaF();
                        contentView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                });
            } else {
                aaF();
            }
            this.bKi.aav();
        }
    }

    public void b(View view, int i, int i2, int i3) {
        if (this.aKl) {
            setFocusable(false);
        }
        a(view, i, i2, i3);
        if (this.aKl) {
            getContentView().setSystemUiVisibility(this.bKl | 1024 | 4096);
            setFocusable(true);
            update();
        }
    }

    public void dB(boolean z) {
        if (!z) {
            super.dismiss();
        } else if (isShowing()) {
            ObjectAnimator aH = d.aH(this.bKe);
            ObjectAnimator d = d.d(this.bKf);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.menu.o.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Context context = o.this.mContext;
                    if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
                        o.super.dismiss();
                        if (o.this.bKf != o.this.bKi) {
                            o.this.bKf.setVisibility(8);
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
        this.bKi.aa(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(g gVar) {
        this.bKg = gVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMode(SwanAppMenuMode swanAppMenuMode) {
        this.bKi.setMode(swanAppMenuMode);
    }

    private void initViews() {
        this.bEf = (FrameLayout) LayoutInflater.from(this.mContext).inflate(f.e.aiapp_menu_layout, (ViewGroup) null);
        this.bKe = this.bEf.findViewById(f.d.mask);
        this.bKi = (MainMenuView) this.bEf.findViewById(f.d.aiapp_menu_body);
        this.bKe.setOnClickListener(this);
        this.bKi.setClickListener(this);
        this.bKi.setMenuStyle(this.bJb);
        this.bKi.setDismissCallback(this);
        this.bEf.measure(0, 0);
        setContentView(this.bEf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaF() {
        ObjectAnimator b;
        View bgView = this.bKi.getBgView();
        View contentView = this.bKi.getContentView();
        int height = contentView.getHeight();
        this.bKi.setTranslationY(0.0f);
        bgView.setTranslationY(height);
        contentView.setTranslationY(height);
        this.bKe.setAlpha(0.0f);
        contentView.setAlpha(0.0f);
        ObjectAnimator a = d.a(this.bKe, this.bKi);
        ObjectAnimator a2 = d.a(this.bKi);
        ObjectAnimator b2 = d.b((BaseMenuView) this.bKi);
        ObjectAnimator c = d.c(this.bKi);
        ArrayList arrayList = new ArrayList();
        arrayList.add(a);
        arrayList.add(a2);
        arrayList.add(b2);
        arrayList.add(c);
        View coverView = this.bKi.getCoverView();
        if (coverView != null && (b = d.b(this.bKi)) != null) {
            coverView.setTranslationY(height);
            arrayList.add(b);
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        animatorSet.start();
    }

    public void gt(int i) {
        this.bKl = i;
    }
}

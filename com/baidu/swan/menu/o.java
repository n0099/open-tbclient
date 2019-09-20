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
    private boolean arn;
    private FrameLayout bmj;
    private String brX;
    private int brh;
    private View bsk;
    private BaseMenuView bsl;
    private g bsm;
    private View bsn;
    private MainMenuView bso;
    private boolean bsp;
    private b bsq;
    private int bsr;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(Context context, View view, int i, @Nullable b bVar) {
        super(context);
        this.bsp = true;
        this.arn = true;
        this.bsr = 0;
        this.mContext = context;
        this.bsn = view;
        this.brh = i;
        this.bsq = bVar;
        dg(false);
        setFocusable(true);
        df(true);
        setBackgroundDrawable(new ColorDrawable(0));
        setAnimationStyle(f.g.aiapp_menu);
        setWidth(-1);
        setHeight(-1);
        initViews();
    }

    @Override // com.baidu.swan.menu.PopupWindow
    public void dismiss() {
        dk(true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == f.d.cancel || id == f.d.mask) {
            dk(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setStatisticSource(String str) {
        this.brX = str;
        this.bso.setStatisticSource(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMenuSource(String str) {
        this.bso.setMenuSource(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void showView() {
        if (!isShowing()) {
            if (this.bsq != null) {
                this.bsq.a(this.bso);
            }
            this.bso.reset();
            this.bsl = this.bso;
            final View contentView = this.bso.getContentView();
            b(this.bsn, 81, 0, 0);
            if (contentView.getHeight() == 0) {
                contentView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.menu.o.1
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        o.this.bso.fw(contentView.getHeight());
                        o.this.VS();
                        contentView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                });
            } else {
                VS();
            }
            this.bso.VI();
        }
    }

    public void b(View view, int i, int i2, int i3) {
        if (this.arn) {
            setFocusable(false);
        }
        a(view, i, i2, i3);
        if (this.arn) {
            getContentView().setSystemUiVisibility(this.bsr | 1024 | 4096);
            setFocusable(true);
            update();
        }
    }

    public void dk(boolean z) {
        if (!z) {
            super.dismiss();
        } else if (isShowing()) {
            ObjectAnimator aB = d.aB(this.bsk);
            ObjectAnimator d = d.d(this.bsl);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.menu.o.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Context context = o.this.mContext;
                    if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
                        o.super.dismiss();
                        if (o.this.bsl != o.this.bso) {
                            o.this.bsl.setVisibility(8);
                        }
                    }
                }
            });
            animatorSet.playTogether(aB, d);
            animatorSet.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G(List<j> list) {
        this.bso.B(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(g gVar) {
        this.bsm = gVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMode(SwanAppMenuMode swanAppMenuMode) {
        this.bso.setMode(swanAppMenuMode);
    }

    private void initViews() {
        this.bmj = (FrameLayout) LayoutInflater.from(this.mContext).inflate(f.e.aiapp_menu_layout, (ViewGroup) null);
        this.bsk = this.bmj.findViewById(f.d.mask);
        this.bso = (MainMenuView) this.bmj.findViewById(f.d.aiapp_menu_body);
        this.bsk.setOnClickListener(this);
        this.bso.setClickListener(this);
        this.bso.setMenuStyle(this.brh);
        this.bso.setDismissCallback(this);
        this.bmj.measure(0, 0);
        setContentView(this.bmj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VS() {
        ObjectAnimator b;
        View bgView = this.bso.getBgView();
        View contentView = this.bso.getContentView();
        int height = contentView.getHeight();
        this.bso.setTranslationY(0.0f);
        bgView.setTranslationY(height);
        contentView.setTranslationY(height);
        this.bsk.setAlpha(0.0f);
        contentView.setAlpha(0.0f);
        ObjectAnimator a = d.a(this.bsk, this.bso);
        ObjectAnimator a2 = d.a(this.bso);
        ObjectAnimator b2 = d.b((BaseMenuView) this.bso);
        ObjectAnimator c = d.c(this.bso);
        ArrayList arrayList = new ArrayList();
        arrayList.add(a);
        arrayList.add(a2);
        arrayList.add(b2);
        arrayList.add(c);
        View coverView = this.bso.getCoverView();
        if (coverView != null && (b = d.b(this.bso)) != null) {
            coverView.setTranslationY(height);
            arrayList.add(b);
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        animatorSet.start();
    }

    public void fz(int i) {
        this.bsr = i;
    }
}

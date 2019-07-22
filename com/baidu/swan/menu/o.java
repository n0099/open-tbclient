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
    private boolean aqP;
    private FrameLayout blL;
    private int bqJ;
    private View brM;
    private BaseMenuView brN;
    private g brO;
    private View brP;
    private MainMenuView brQ;
    private boolean brR;
    private b brS;
    private int brT;
    private String brz;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(Context context, View view, int i, @Nullable b bVar) {
        super(context);
        this.brR = true;
        this.aqP = true;
        this.brT = 0;
        this.mContext = context;
        this.brP = view;
        this.bqJ = i;
        this.brS = bVar;
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
        this.brz = str;
        this.brQ.setStatisticSource(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMenuSource(String str) {
        this.brQ.setMenuSource(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void showView() {
        if (!isShowing()) {
            if (this.brS != null) {
                this.brS.a(this.brQ);
            }
            this.brQ.reset();
            this.brN = this.brQ;
            final View contentView = this.brQ.getContentView();
            b(this.brP, 81, 0, 0);
            if (contentView.getHeight() == 0) {
                contentView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.menu.o.1
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        o.this.brQ.fv(contentView.getHeight());
                        o.this.VO();
                        contentView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                });
            } else {
                VO();
            }
            this.brQ.VE();
        }
    }

    public void b(View view, int i, int i2, int i3) {
        if (this.aqP) {
            setFocusable(false);
        }
        a(view, i, i2, i3);
        if (this.aqP) {
            getContentView().setSystemUiVisibility(this.brT | 1024 | 4096);
            setFocusable(true);
            update();
        }
    }

    public void dk(boolean z) {
        if (!z) {
            super.dismiss();
        } else if (isShowing()) {
            ObjectAnimator aB = d.aB(this.brM);
            ObjectAnimator d = d.d(this.brN);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.menu.o.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Context context = o.this.mContext;
                    if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
                        o.super.dismiss();
                        if (o.this.brN != o.this.brQ) {
                            o.this.brN.setVisibility(8);
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
        this.brQ.B(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(g gVar) {
        this.brO = gVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMode(SwanAppMenuMode swanAppMenuMode) {
        this.brQ.setMode(swanAppMenuMode);
    }

    private void initViews() {
        this.blL = (FrameLayout) LayoutInflater.from(this.mContext).inflate(f.e.aiapp_menu_layout, (ViewGroup) null);
        this.brM = this.blL.findViewById(f.d.mask);
        this.brQ = (MainMenuView) this.blL.findViewById(f.d.aiapp_menu_body);
        this.brM.setOnClickListener(this);
        this.brQ.setClickListener(this);
        this.brQ.setMenuStyle(this.bqJ);
        this.brQ.setDismissCallback(this);
        this.blL.measure(0, 0);
        setContentView(this.blL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VO() {
        ObjectAnimator b;
        View bgView = this.brQ.getBgView();
        View contentView = this.brQ.getContentView();
        int height = contentView.getHeight();
        this.brQ.setTranslationY(0.0f);
        bgView.setTranslationY(height);
        contentView.setTranslationY(height);
        this.brM.setAlpha(0.0f);
        contentView.setAlpha(0.0f);
        ObjectAnimator a = d.a(this.brM, this.brQ);
        ObjectAnimator a2 = d.a(this.brQ);
        ObjectAnimator b2 = d.b((BaseMenuView) this.brQ);
        ObjectAnimator c = d.c(this.brQ);
        ArrayList arrayList = new ArrayList();
        arrayList.add(a);
        arrayList.add(a2);
        arrayList.add(b2);
        arrayList.add(c);
        View coverView = this.brQ.getCoverView();
        if (coverView != null && (b = d.b(this.brQ)) != null) {
            coverView.setTranslationY(height);
            arrayList.add(b);
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        animatorSet.start();
    }

    public void fy(int i) {
        this.brT = i;
    }
}

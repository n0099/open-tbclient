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
/* loaded from: classes23.dex */
public class j extends PopupWindow implements View.OnClickListener {
    private FrameLayout ahP;
    private View cFu;
    private View cFw;
    private BaseMenuView dGs;
    private MainMenuView dGt;
    private boolean dGu;
    private a dGv;
    private int dGw;
    private Context mContext;
    private boolean mImmersionEnabled;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Context context, View view, @Nullable a aVar) {
        super(context);
        this.dGu = true;
        this.mImmersionEnabled = true;
        this.dGw = 0;
        this.mContext = context;
        this.cFu = view;
        this.dGv = aVar;
        setClippingEnabled(false);
        setFocusable(true);
        setOutsideTouchable(true);
        setBackgroundDrawable(new ColorDrawable(0));
        setWidth(-1);
        setHeight(-1);
        initViews();
    }

    private void initViews() {
        this.ahP = (FrameLayout) LayoutInflater.from(this.mContext).inflate(g.e.aiapp_menu_layout, (ViewGroup) null);
        this.cFw = this.ahP.findViewById(g.d.mask);
        this.dGt = (MainMenuView) this.ahP.findViewById(g.d.aiapp_menu_body);
        this.cFw.setOnClickListener(this);
        this.dGt.setClickListener(this);
        this.ahP.measure(0, 0);
        setContentView(this.ahP);
    }

    private void showView() {
        if (!isShowing()) {
            auQ();
            this.dGt.reset();
            this.dGs = this.dGt;
            if (this.mImmersionEnabled) {
                setFocusable(false);
            }
            Activity activity = (Activity) this.mContext;
            if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
                showAtLocation(this.cFu, 81, 0, 0);
                if (this.mImmersionEnabled) {
                    getContentView().setSystemUiVisibility(this.dGw | 1024 | 4096);
                    setFocusable(true);
                    update();
                }
                final View contentView = this.dGt.getContentView();
                if (contentView.getHeight() == 0) {
                    contentView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.menu.j.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            j.this.dGt.lI(contentView.getHeight());
                            j.this.auR();
                            contentView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        }
                    });
                } else {
                    auR();
                }
            }
        }
    }

    public void auQ() {
        if (this.dGv != null) {
            this.dGv.a(this.dGt);
        }
    }

    public void b(List<List<i>> list, View view, boolean z, int i) {
        this.dGt.a(list, view, z, i);
        showView();
    }

    @Override // com.baidu.swan.menu.PopupWindow
    public void dismiss() {
        eP(true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == g.d.cancel || id == g.d.mask) {
            eP(true);
        }
    }

    public void eP(boolean z) {
        if (!z) {
            super.dismiss();
        } else if (isShowing()) {
            ObjectAnimator aS = c.aS(this.cFw);
            ObjectAnimator c = c.c(this.dGs);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.menu.j.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Context context = j.this.mContext;
                    if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
                        j.super.dismiss();
                        if (j.this.dGs != j.this.dGt) {
                            j.this.dGs.setVisibility(8);
                        }
                    }
                }
            });
            animatorSet.playTogether(aS, c);
            animatorSet.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aTp() {
        this.dGt.aTp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auR() {
        this.cFw.setAlpha(0.0f);
        this.dGt.setTranslationY(this.dGt.getHeight());
        ObjectAnimator a = c.a(this.cFw, this.dGt);
        ObjectAnimator b = c.b(this.dGt);
        ArrayList arrayList = new ArrayList();
        arrayList.add(a);
        arrayList.add(b);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        animatorSet.start();
    }

    public void lM(int i) {
        this.dGw = i;
    }
}

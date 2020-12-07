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
/* loaded from: classes14.dex */
public class j extends PopupWindow implements View.OnClickListener {
    private FrameLayout ajk;
    private View dli;
    private View dlk;
    private BaseMenuView ema;
    private MainMenuView emb;
    private boolean emc;
    private a emd;
    private int eme;
    private Context mContext;
    private boolean mImmersionEnabled;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Context context, View view, @Nullable a aVar) {
        super(context);
        this.emc = true;
        this.mImmersionEnabled = true;
        this.eme = 0;
        this.mContext = context;
        this.dli = view;
        this.emd = aVar;
        setClippingEnabled(false);
        setFocusable(true);
        setOutsideTouchable(true);
        setBackgroundDrawable(new ColorDrawable(0));
        setWidth(-1);
        setHeight(-1);
        initViews();
    }

    private void initViews() {
        this.ajk = (FrameLayout) LayoutInflater.from(this.mContext).inflate(g.e.aiapp_menu_layout, (ViewGroup) null);
        this.dlk = this.ajk.findViewById(g.d.mask);
        this.emb = (MainMenuView) this.ajk.findViewById(g.d.aiapp_menu_body);
        this.dlk.setOnClickListener(this);
        this.emb.setClickListener(this);
        this.ajk.measure(0, 0);
        setContentView(this.ajk);
    }

    private void showView() {
        if (!isShowing()) {
            aEw();
            this.emb.reset();
            this.ema = this.emb;
            if (this.mImmersionEnabled) {
                setFocusable(false);
            }
            Activity activity = (Activity) this.mContext;
            if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
                showAtLocation(this.dli, 81, 0, 0);
                if (this.mImmersionEnabled) {
                    getContentView().setSystemUiVisibility(this.eme | 1024 | 4096);
                    setFocusable(true);
                    update();
                }
                final View contentView = this.emb.getContentView();
                if (contentView.getHeight() == 0) {
                    contentView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.menu.j.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            j.this.emb.mU(contentView.getHeight());
                            j.this.aEx();
                            contentView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        }
                    });
                } else {
                    aEx();
                }
            }
        }
    }

    public void aEw() {
        if (this.emd != null) {
            this.emd.a(this.emb);
        }
    }

    public void b(List<List<i>> list, View view, boolean z, int i) {
        this.emb.a(list, view, z, i);
        showView();
    }

    @Override // com.baidu.swan.menu.PopupWindow
    public void dismiss() {
        fZ(true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == g.d.cancel || id == g.d.mask) {
            fZ(true);
        }
    }

    public void fZ(boolean z) {
        if (!z) {
            super.dismiss();
        } else if (isShowing()) {
            ObjectAnimator ba = c.ba(this.dlk);
            ObjectAnimator c = c.c(this.ema);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.menu.j.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Context context = j.this.mContext;
                    if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
                        j.super.dismiss();
                        if (j.this.ema != j.this.emb) {
                            j.this.ema.setVisibility(8);
                        }
                    }
                }
            });
            animatorSet.playTogether(ba, c);
            animatorSet.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bcP() {
        this.emb.bcP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEx() {
        this.dlk.setAlpha(0.0f);
        this.emb.setTranslationY(this.emb.getHeight());
        ObjectAnimator a2 = c.a(this.dlk, this.emb);
        ObjectAnimator b = c.b(this.emb);
        ArrayList arrayList = new ArrayList();
        arrayList.add(a2);
        arrayList.add(b);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        animatorSet.start();
    }

    public void mY(int i) {
        this.eme = i;
    }
}

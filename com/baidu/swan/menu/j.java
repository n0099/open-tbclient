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
    private FrameLayout ahv;
    private View cDu;
    private View cDw;
    private BaseMenuView dEr;
    private MainMenuView dEs;
    private boolean dEt;
    private a dEu;
    private int dEv;
    private Context mContext;
    private boolean mImmersionEnabled;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Context context, View view, @Nullable a aVar) {
        super(context);
        this.dEt = true;
        this.mImmersionEnabled = true;
        this.dEv = 0;
        this.mContext = context;
        this.cDu = view;
        this.dEu = aVar;
        setClippingEnabled(false);
        setFocusable(true);
        setOutsideTouchable(true);
        setBackgroundDrawable(new ColorDrawable(0));
        setWidth(-1);
        setHeight(-1);
        initViews();
    }

    private void initViews() {
        this.ahv = (FrameLayout) LayoutInflater.from(this.mContext).inflate(g.e.aiapp_menu_layout, (ViewGroup) null);
        this.cDw = this.ahv.findViewById(g.d.mask);
        this.dEs = (MainMenuView) this.ahv.findViewById(g.d.aiapp_menu_body);
        this.cDw.setOnClickListener(this);
        this.dEs.setClickListener(this);
        this.ahv.measure(0, 0);
        setContentView(this.ahv);
    }

    private void showView() {
        if (!isShowing()) {
            auh();
            this.dEs.reset();
            this.dEr = this.dEs;
            if (this.mImmersionEnabled) {
                setFocusable(false);
            }
            Activity activity = (Activity) this.mContext;
            if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
                showAtLocation(this.cDu, 81, 0, 0);
                if (this.mImmersionEnabled) {
                    getContentView().setSystemUiVisibility(this.dEv | 1024 | 4096);
                    setFocusable(true);
                    update();
                }
                final View contentView = this.dEs.getContentView();
                if (contentView.getHeight() == 0) {
                    contentView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.menu.j.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            j.this.dEs.lx(contentView.getHeight());
                            j.this.aui();
                            contentView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        }
                    });
                } else {
                    aui();
                }
            }
        }
    }

    public void auh() {
        if (this.dEu != null) {
            this.dEu.a(this.dEs);
        }
    }

    public void b(List<List<i>> list, View view, boolean z, int i) {
        this.dEs.a(list, view, z, i);
        showView();
    }

    @Override // com.baidu.swan.menu.PopupWindow
    public void dismiss() {
        eR(true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == g.d.cancel || id == g.d.mask) {
            eR(true);
        }
    }

    public void eR(boolean z) {
        if (!z) {
            super.dismiss();
        } else if (isShowing()) {
            ObjectAnimator aQ = c.aQ(this.cDw);
            ObjectAnimator c = c.c(this.dEr);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.menu.j.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Context context = j.this.mContext;
                    if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
                        j.super.dismiss();
                        if (j.this.dEr != j.this.dEs) {
                            j.this.dEr.setVisibility(8);
                        }
                    }
                }
            });
            animatorSet.playTogether(aQ, c);
            animatorSet.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aSD() {
        this.dEs.aSD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aui() {
        this.cDw.setAlpha(0.0f);
        this.dEs.setTranslationY(this.dEs.getHeight());
        ObjectAnimator a = c.a(this.cDw, this.dEs);
        ObjectAnimator b = c.b(this.dEs);
        ArrayList arrayList = new ArrayList();
        arrayList.add(a);
        arrayList.add(b);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        animatorSet.start();
    }

    public void lB(int i) {
        this.dEv = i;
    }
}

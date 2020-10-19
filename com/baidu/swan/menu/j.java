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
    private FrameLayout aih;
    private View cRA;
    private View cRy;
    private BaseMenuView dSt;
    private MainMenuView dSu;
    private boolean dSv;
    private a dSw;
    private int dSx;
    private Context mContext;
    private boolean mImmersionEnabled;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Context context, View view, @Nullable a aVar) {
        super(context);
        this.dSv = true;
        this.mImmersionEnabled = true;
        this.dSx = 0;
        this.mContext = context;
        this.cRy = view;
        this.dSw = aVar;
        setClippingEnabled(false);
        setFocusable(true);
        setOutsideTouchable(true);
        setBackgroundDrawable(new ColorDrawable(0));
        setWidth(-1);
        setHeight(-1);
        initViews();
    }

    private void initViews() {
        this.aih = (FrameLayout) LayoutInflater.from(this.mContext).inflate(g.e.aiapp_menu_layout, (ViewGroup) null);
        this.cRA = this.aih.findViewById(g.d.mask);
        this.dSu = (MainMenuView) this.aih.findViewById(g.d.aiapp_menu_body);
        this.cRA.setOnClickListener(this);
        this.dSu.setClickListener(this);
        this.aih.measure(0, 0);
        setContentView(this.aih);
    }

    private void showView() {
        if (!isShowing()) {
            axB();
            this.dSu.reset();
            this.dSt = this.dSu;
            if (this.mImmersionEnabled) {
                setFocusable(false);
            }
            Activity activity = (Activity) this.mContext;
            if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
                showAtLocation(this.cRy, 81, 0, 0);
                if (this.mImmersionEnabled) {
                    getContentView().setSystemUiVisibility(this.dSx | 1024 | 4096);
                    setFocusable(true);
                    update();
                }
                final View contentView = this.dSu.getContentView();
                if (contentView.getHeight() == 0) {
                    contentView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.menu.j.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            j.this.dSu.mf(contentView.getHeight());
                            j.this.axC();
                            contentView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        }
                    });
                } else {
                    axC();
                }
            }
        }
    }

    public void axB() {
        if (this.dSw != null) {
            this.dSw.a(this.dSu);
        }
    }

    public void b(List<List<i>> list, View view, boolean z, int i) {
        this.dSu.a(list, view, z, i);
        showView();
    }

    @Override // com.baidu.swan.menu.PopupWindow
    public void dismiss() {
        fl(true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == g.d.cancel || id == g.d.mask) {
            fl(true);
        }
    }

    public void fl(boolean z) {
        if (!z) {
            super.dismiss();
        } else if (isShowing()) {
            ObjectAnimator aT = c.aT(this.cRA);
            ObjectAnimator c = c.c(this.dSt);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.menu.j.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Context context = j.this.mContext;
                    if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
                        j.super.dismiss();
                        if (j.this.dSt != j.this.dSu) {
                            j.this.dSt.setVisibility(8);
                        }
                    }
                }
            });
            animatorSet.playTogether(aT, c);
            animatorSet.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aVY() {
        this.dSu.aVY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axC() {
        this.cRA.setAlpha(0.0f);
        this.dSu.setTranslationY(this.dSu.getHeight());
        ObjectAnimator a2 = c.a(this.cRA, this.dSu);
        ObjectAnimator b = c.b(this.dSu);
        ArrayList arrayList = new ArrayList();
        arrayList.add(a2);
        arrayList.add(b);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        animatorSet.start();
    }

    public void mj(int i) {
        this.dSx = i;
    }
}

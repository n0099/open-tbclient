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
    private FrameLayout aht;
    private View cDq;
    private View cDs;
    private BaseMenuView dEn;
    private MainMenuView dEo;
    private boolean dEp;
    private a dEq;
    private int dEr;
    private Context mContext;
    private boolean mImmersionEnabled;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Context context, View view, @Nullable a aVar) {
        super(context);
        this.dEp = true;
        this.mImmersionEnabled = true;
        this.dEr = 0;
        this.mContext = context;
        this.cDq = view;
        this.dEq = aVar;
        setClippingEnabled(false);
        setFocusable(true);
        setOutsideTouchable(true);
        setBackgroundDrawable(new ColorDrawable(0));
        setWidth(-1);
        setHeight(-1);
        initViews();
    }

    private void initViews() {
        this.aht = (FrameLayout) LayoutInflater.from(this.mContext).inflate(g.e.aiapp_menu_layout, (ViewGroup) null);
        this.cDs = this.aht.findViewById(g.d.mask);
        this.dEo = (MainMenuView) this.aht.findViewById(g.d.aiapp_menu_body);
        this.cDs.setOnClickListener(this);
        this.dEo.setClickListener(this);
        this.aht.measure(0, 0);
        setContentView(this.aht);
    }

    private void showView() {
        if (!isShowing()) {
            auh();
            this.dEo.reset();
            this.dEn = this.dEo;
            if (this.mImmersionEnabled) {
                setFocusable(false);
            }
            Activity activity = (Activity) this.mContext;
            if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
                showAtLocation(this.cDq, 81, 0, 0);
                if (this.mImmersionEnabled) {
                    getContentView().setSystemUiVisibility(this.dEr | 1024 | 4096);
                    setFocusable(true);
                    update();
                }
                final View contentView = this.dEo.getContentView();
                if (contentView.getHeight() == 0) {
                    contentView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.menu.j.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            j.this.dEo.lx(contentView.getHeight());
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
        if (this.dEq != null) {
            this.dEq.a(this.dEo);
        }
    }

    public void b(List<List<i>> list, View view, boolean z, int i) {
        this.dEo.a(list, view, z, i);
        showView();
    }

    @Override // com.baidu.swan.menu.PopupWindow
    public void dismiss() {
        eQ(true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == g.d.cancel || id == g.d.mask) {
            eQ(true);
        }
    }

    public void eQ(boolean z) {
        if (!z) {
            super.dismiss();
        } else if (isShowing()) {
            ObjectAnimator aQ = c.aQ(this.cDs);
            ObjectAnimator c = c.c(this.dEn);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.menu.j.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Context context = j.this.mContext;
                    if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
                        j.super.dismiss();
                        if (j.this.dEn != j.this.dEo) {
                            j.this.dEn.setVisibility(8);
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
        this.dEo.aSD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aui() {
        this.cDs.setAlpha(0.0f);
        this.dEo.setTranslationY(this.dEo.getHeight());
        ObjectAnimator a = c.a(this.cDs, this.dEo);
        ObjectAnimator b = c.b(this.dEo);
        ArrayList arrayList = new ArrayList();
        arrayList.add(a);
        arrayList.add(b);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        animatorSet.start();
    }

    public void lB(int i) {
        this.dEr = i;
    }
}

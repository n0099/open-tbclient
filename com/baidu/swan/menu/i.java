package com.baidu.swan.menu;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.baidu.swan.menu.f;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class i extends PopupWindow implements View.OnClickListener {
    private FrameLayout ajW;
    private boolean cUm;
    private View dqh;
    private View dqj;
    private BaseMenuView evH;
    private MainMenuView evI;
    private boolean evJ;
    private a evK;
    private int evL;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(Context context, View view, @Nullable a aVar) {
        super(context);
        this.evJ = true;
        this.cUm = true;
        this.evL = 0;
        this.mContext = context;
        this.dqh = view;
        this.evK = aVar;
        ei(false);
        setFocusable(true);
        eh(true);
        setBackgroundDrawable(new ColorDrawable(0));
        setWidth(-1);
        setHeight(-1);
        initViews();
    }

    private void initViews() {
        this.ajW = (FrameLayout) LayoutInflater.from(this.mContext).inflate(f.e.aiapp_menu_layout, (ViewGroup) null);
        this.dqj = this.ajW.findViewById(f.d.mask);
        this.evI = (MainMenuView) this.ajW.findViewById(f.d.aiapp_menu_body);
        this.dqj.setOnClickListener(this);
        this.evI.setClickListener(this);
        this.ajW.measure(0, 0);
        setContentView(this.ajW);
    }

    private void showView() {
        if (!isShowing()) {
            aFP();
            this.evI.reset();
            this.evH = this.evI;
            if (this.cUm) {
                setFocusable(false);
            }
            Activity activity = (Activity) this.mContext;
            if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
                showAtLocation(this.dqh, 81, 0, 0);
                if (this.cUm) {
                    getContentView().setSystemUiVisibility(this.evL | 1024 | 4096);
                    setFocusable(true);
                    update();
                }
                final View contentView = this.evI.getContentView();
                if (contentView.getHeight() == 0) {
                    contentView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.menu.i.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            i.this.evI.nc(contentView.getHeight());
                            i.this.aFQ();
                            contentView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        }
                    });
                } else {
                    aFQ();
                }
            }
        }
    }

    public void aFP() {
        if (this.evK != null) {
            this.evK.a(this.evI);
        }
    }

    public void b(List<List<h>> list, View view, boolean z, int i) {
        this.evI.a(list, view, z, i);
        showView();
    }

    @Override // com.baidu.swan.menu.PopupWindow
    public void dismiss() {
        gi(true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == f.d.cancel || id == f.d.mask) {
            gi(true);
        }
    }

    public void gi(boolean z) {
        if (!z) {
            super.dismiss();
        } else if (isShowing()) {
            ObjectAnimator bj = c.bj(this.dqj);
            ObjectAnimator c = c.c(this.evH);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.menu.i.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Context context = i.this.mContext;
                    if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
                        i.super.dismiss();
                        if (i.this.evH != i.this.evI) {
                            i.this.evH.setVisibility(8);
                        }
                    }
                }
            });
            animatorSet.playTogether(bj, c);
            animatorSet.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bfi() {
        this.evI.bfi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFQ() {
        this.dqj.setAlpha(0.0f);
        this.evI.setTranslationY(this.evI.getHeight());
        ObjectAnimator a2 = c.a(this.dqj, this.evI);
        ObjectAnimator b2 = c.b(this.evI);
        ArrayList arrayList = new ArrayList();
        arrayList.add(a2);
        arrayList.add(b2);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        animatorSet.start();
    }

    public void nh(int i) {
        this.evL = i;
    }
}

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
    private FrameLayout ajf;
    private boolean cPA;
    private View dlr;
    private View dlt;
    private BaseMenuView eqT;
    private MainMenuView eqU;
    private boolean eqV;
    private a eqW;
    private int eqX;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(Context context, View view, @Nullable a aVar) {
        super(context);
        this.eqV = true;
        this.cPA = true;
        this.eqX = 0;
        this.mContext = context;
        this.dlr = view;
        this.eqW = aVar;
        ee(false);
        setFocusable(true);
        ed(true);
        setBackgroundDrawable(new ColorDrawable(0));
        setWidth(-1);
        setHeight(-1);
        initViews();
    }

    private void initViews() {
        this.ajf = (FrameLayout) LayoutInflater.from(this.mContext).inflate(f.e.aiapp_menu_layout, (ViewGroup) null);
        this.dlt = this.ajf.findViewById(f.d.mask);
        this.eqU = (MainMenuView) this.ajf.findViewById(f.d.aiapp_menu_body);
        this.dlt.setOnClickListener(this);
        this.eqU.setClickListener(this);
        this.ajf.measure(0, 0);
        setContentView(this.ajf);
    }

    private void showView() {
        if (!isShowing()) {
            aBW();
            this.eqU.reset();
            this.eqT = this.eqU;
            if (this.cPA) {
                setFocusable(false);
            }
            Activity activity = (Activity) this.mContext;
            if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
                showAtLocation(this.dlr, 81, 0, 0);
                if (this.cPA) {
                    getContentView().setSystemUiVisibility(this.eqX | 1024 | 4096);
                    setFocusable(true);
                    update();
                }
                final View contentView = this.eqU.getContentView();
                if (contentView.getHeight() == 0) {
                    contentView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.menu.i.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            i.this.eqU.lw(contentView.getHeight());
                            i.this.aBX();
                            contentView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        }
                    });
                } else {
                    aBX();
                }
            }
        }
    }

    public void aBW() {
        if (this.eqW != null) {
            this.eqW.a(this.eqU);
        }
    }

    public void b(List<List<h>> list, View view, boolean z, int i) {
        this.eqU.a(list, view, z, i);
        showView();
    }

    @Override // com.baidu.swan.menu.PopupWindow
    public void dismiss() {
        ge(true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == f.d.cancel || id == f.d.mask) {
            ge(true);
        }
    }

    public void ge(boolean z) {
        if (!z) {
            super.dismiss();
        } else if (isShowing()) {
            ObjectAnimator bj = c.bj(this.dlt);
            ObjectAnimator c = c.c(this.eqT);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.menu.i.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Context context = i.this.mContext;
                    if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
                        i.super.dismiss();
                        if (i.this.eqT != i.this.eqU) {
                            i.this.eqT.setVisibility(8);
                        }
                    }
                }
            });
            animatorSet.playTogether(bj, c);
            animatorSet.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bbp() {
        this.eqU.bbp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBX() {
        this.dlt.setAlpha(0.0f);
        this.eqU.setTranslationY(this.eqU.getHeight());
        ObjectAnimator a2 = c.a(this.dlt, this.eqU);
        ObjectAnimator b2 = c.b(this.eqU);
        ArrayList arrayList = new ArrayList();
        arrayList.add(a2);
        arrayList.add(b2);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        animatorSet.start();
    }

    public void lB(int i) {
        this.eqX = i;
    }
}

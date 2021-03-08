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
/* loaded from: classes4.dex */
public class i extends PopupWindow implements View.OnClickListener {
    private FrameLayout akl;
    private boolean cTo;
    private View dpf;
    private View dph;
    private BaseMenuView euC;
    private MainMenuView euD;
    private boolean euE;
    private a euF;
    private int euG;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(Context context, View view, @Nullable a aVar) {
        super(context);
        this.euE = true;
        this.cTo = true;
        this.euG = 0;
        this.mContext = context;
        this.dpf = view;
        this.euF = aVar;
        eo(false);
        setFocusable(true);
        en(true);
        setBackgroundDrawable(new ColorDrawable(0));
        setWidth(-1);
        setHeight(-1);
        initViews();
    }

    private void initViews() {
        this.akl = (FrameLayout) LayoutInflater.from(this.mContext).inflate(f.e.aiapp_menu_layout, (ViewGroup) null);
        this.dph = this.akl.findViewById(f.d.mask);
        this.euD = (MainMenuView) this.akl.findViewById(f.d.aiapp_menu_body);
        this.dph.setOnClickListener(this);
        this.euD.setClickListener(this);
        this.akl.measure(0, 0);
        setContentView(this.akl);
    }

    private void showView() {
        if (!isShowing()) {
            aCw();
            this.euD.reset();
            this.euC = this.euD;
            if (this.cTo) {
                setFocusable(false);
            }
            Activity activity = (Activity) this.mContext;
            if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
                showAtLocation(this.dpf, 81, 0, 0);
                if (this.cTo) {
                    getContentView().setSystemUiVisibility(this.euG | 1024 | 4096);
                    setFocusable(true);
                    update();
                }
                final View contentView = this.euD.getContentView();
                if (contentView.getHeight() == 0) {
                    contentView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.menu.i.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            i.this.euD.lA(contentView.getHeight());
                            i.this.aCx();
                            contentView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        }
                    });
                } else {
                    aCx();
                }
            }
        }
    }

    public void aCw() {
        if (this.euF != null) {
            this.euF.a(this.euD);
        }
    }

    public void b(List<List<h>> list, View view, boolean z, int i) {
        this.euD.a(list, view, z, i);
        showView();
    }

    @Override // com.baidu.swan.menu.PopupWindow
    public void dismiss() {
        gg(true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == f.d.cancel || id == f.d.mask) {
            gg(true);
        }
    }

    public void gg(boolean z) {
        if (!z) {
            super.dismiss();
        } else if (isShowing()) {
            ObjectAnimator bf = c.bf(this.dph);
            ObjectAnimator c = c.c(this.euC);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.menu.i.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Context context = i.this.mContext;
                    if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
                        i.super.dismiss();
                        if (i.this.euC != i.this.euD) {
                            i.this.euC.setVisibility(8);
                        }
                    }
                }
            });
            animatorSet.playTogether(bf, c);
            animatorSet.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bbE() {
        this.euD.bbE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCx() {
        this.dph.setAlpha(0.0f);
        this.euD.setTranslationY(this.euD.getHeight());
        ObjectAnimator a2 = c.a(this.dph, this.euD);
        ObjectAnimator b = c.b(this.euD);
        ArrayList arrayList = new ArrayList();
        arrayList.add(a2);
        arrayList.add(b);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        animatorSet.start();
    }

    public void lF(int i) {
        this.euG = i;
    }
}

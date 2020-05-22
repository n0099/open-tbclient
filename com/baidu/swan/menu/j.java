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
/* loaded from: classes11.dex */
public class j extends PopupWindow implements View.OnClickListener {
    private FrameLayout ddl;
    private View djM;
    private BaseMenuView djN;
    private View djO;
    private MainMenuView djP;
    private boolean djQ;
    private a djR;
    private int djS;
    private Context mContext;
    private boolean mImmersionEnabled;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Context context, View view, @Nullable a aVar) {
        super(context);
        this.djQ = true;
        this.mImmersionEnabled = true;
        this.djS = 0;
        this.mContext = context;
        this.djO = view;
        this.djR = aVar;
        setClippingEnabled(false);
        setFocusable(true);
        setOutsideTouchable(true);
        setBackgroundDrawable(new ColorDrawable(0));
        setWidth(-1);
        setHeight(-1);
        initViews();
    }

    private void initViews() {
        this.ddl = (FrameLayout) LayoutInflater.from(this.mContext).inflate(g.e.aiapp_menu_layout, (ViewGroup) null);
        this.djM = this.ddl.findViewById(g.d.mask);
        this.djP = (MainMenuView) this.ddl.findViewById(g.d.aiapp_menu_body);
        this.djM.setOnClickListener(this);
        this.djP.setClickListener(this);
        this.ddl.measure(0, 0);
        setContentView(this.ddl);
    }

    private void showView() {
        if (!isShowing()) {
            aEZ();
            this.djP.reset();
            this.djN = this.djP;
            if (this.mImmersionEnabled) {
                setFocusable(false);
            }
            showAtLocation(this.djO, 81, 0, 0);
            if (this.mImmersionEnabled) {
                getContentView().setSystemUiVisibility(this.djS | 1024 | 4096);
                setFocusable(true);
                update();
            }
            final View contentView = this.djP.getContentView();
            if (contentView.getHeight() == 0) {
                contentView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.menu.j.1
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        j.this.djP.iK(contentView.getHeight());
                        j.this.aFa();
                        contentView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                });
            } else {
                aFa();
            }
        }
    }

    public void aEZ() {
        if (this.djR != null) {
            this.djR.a(this.djP);
        }
    }

    public void b(List<List<i>> list, View view, boolean z, int i) {
        this.djP.a(list, view, z, i);
        showView();
    }

    @Override // com.baidu.swan.menu.PopupWindow
    public void dismiss() {
        gf(true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == g.d.cancel || id == g.d.mask) {
            gf(true);
        }
    }

    public void gf(boolean z) {
        if (!z) {
            super.dismiss();
        } else if (isShowing()) {
            ObjectAnimator aJ = c.aJ(this.djM);
            ObjectAnimator b = c.b(this.djN);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.menu.j.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Context context = j.this.mContext;
                    if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
                        j.super.dismiss();
                        if (j.this.djN != j.this.djP) {
                            j.this.djN.setVisibility(8);
                        }
                    }
                }
            });
            animatorSet.playTogether(aJ, b);
            animatorSet.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aES() {
        this.djP.aES();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFa() {
        this.djM.setAlpha(0.0f);
        this.djP.setTranslationY(this.djP.getHeight());
        ObjectAnimator a = c.a(this.djM, this.djP);
        ObjectAnimator a2 = c.a(this.djP);
        ArrayList arrayList = new ArrayList();
        arrayList.add(a);
        arrayList.add(a2);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        animatorSet.start();
    }

    public void iO(int i) {
        this.djS = i;
    }
}

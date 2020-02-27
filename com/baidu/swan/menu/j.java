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
    private FrameLayout csX;
    private View czs;
    private BaseMenuView czt;
    private View czu;
    private MainMenuView czv;
    private boolean czw;
    private a czx;
    private int czy;
    private Context mContext;
    private boolean mImmersionEnabled;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Context context, View view, @Nullable a aVar) {
        super(context);
        this.czw = true;
        this.mImmersionEnabled = true;
        this.czy = 0;
        this.mContext = context;
        this.czu = view;
        this.czx = aVar;
        setClippingEnabled(false);
        setFocusable(true);
        setOutsideTouchable(true);
        setBackgroundDrawable(new ColorDrawable(0));
        setWidth(-1);
        setHeight(-1);
        initViews();
    }

    private void initViews() {
        this.csX = (FrameLayout) LayoutInflater.from(this.mContext).inflate(g.e.aiapp_menu_layout, (ViewGroup) null);
        this.czs = this.csX.findViewById(g.d.mask);
        this.czv = (MainMenuView) this.csX.findViewById(g.d.aiapp_menu_body);
        this.czs.setOnClickListener(this);
        this.czv.setClickListener(this);
        this.csX.measure(0, 0);
        setContentView(this.csX);
    }

    private void showView() {
        if (!isShowing()) {
            asS();
            this.czv.reset();
            this.czt = this.czv;
            if (this.mImmersionEnabled) {
                setFocusable(false);
            }
            showAtLocation(this.czu, 81, 0, 0);
            if (this.mImmersionEnabled) {
                getContentView().setSystemUiVisibility(this.czy | 1024 | 4096);
                setFocusable(true);
                update();
            }
            final View contentView = this.czv.getContentView();
            if (contentView.getHeight() == 0) {
                contentView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.menu.j.1
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        j.this.czv.im(contentView.getHeight());
                        j.this.asT();
                        contentView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                });
            } else {
                asT();
            }
        }
    }

    public void asS() {
        if (this.czx != null) {
            this.czx.a(this.czv);
        }
    }

    public void b(List<List<i>> list, View view, boolean z, int i) {
        this.czv.a(list, view, z, i);
        showView();
    }

    @Override // com.baidu.swan.menu.PopupWindow
    public void dismiss() {
        eW(true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == g.d.cancel || id == g.d.mask) {
            eW(true);
        }
    }

    public void eW(boolean z) {
        if (!z) {
            super.dismiss();
        } else if (isShowing()) {
            ObjectAnimator aJ = c.aJ(this.czs);
            ObjectAnimator b = c.b(this.czt);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.menu.j.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Context context = j.this.mContext;
                    if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
                        j.super.dismiss();
                        if (j.this.czt != j.this.czv) {
                            j.this.czt.setVisibility(8);
                        }
                    }
                }
            });
            animatorSet.playTogether(aJ, b);
            animatorSet.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void asL() {
        this.czv.asL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asT() {
        this.czs.setAlpha(0.0f);
        this.czv.setTranslationY(this.czv.getHeight());
        ObjectAnimator a = c.a(this.czs, this.czv);
        ObjectAnimator a2 = c.a(this.czv);
        ArrayList arrayList = new ArrayList();
        arrayList.add(a);
        arrayList.add(a2);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        animatorSet.start();
    }

    public void iq(int i) {
        this.czy = i;
    }
}

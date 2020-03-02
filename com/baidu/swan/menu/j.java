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
    private FrameLayout csY;
    private View czt;
    private BaseMenuView czu;
    private View czv;
    private MainMenuView czw;
    private boolean czx;
    private a czy;
    private int czz;
    private Context mContext;
    private boolean mImmersionEnabled;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Context context, View view, @Nullable a aVar) {
        super(context);
        this.czx = true;
        this.mImmersionEnabled = true;
        this.czz = 0;
        this.mContext = context;
        this.czv = view;
        this.czy = aVar;
        setClippingEnabled(false);
        setFocusable(true);
        setOutsideTouchable(true);
        setBackgroundDrawable(new ColorDrawable(0));
        setWidth(-1);
        setHeight(-1);
        initViews();
    }

    private void initViews() {
        this.csY = (FrameLayout) LayoutInflater.from(this.mContext).inflate(g.e.aiapp_menu_layout, (ViewGroup) null);
        this.czt = this.csY.findViewById(g.d.mask);
        this.czw = (MainMenuView) this.csY.findViewById(g.d.aiapp_menu_body);
        this.czt.setOnClickListener(this);
        this.czw.setClickListener(this);
        this.csY.measure(0, 0);
        setContentView(this.csY);
    }

    private void showView() {
        if (!isShowing()) {
            asU();
            this.czw.reset();
            this.czu = this.czw;
            if (this.mImmersionEnabled) {
                setFocusable(false);
            }
            showAtLocation(this.czv, 81, 0, 0);
            if (this.mImmersionEnabled) {
                getContentView().setSystemUiVisibility(this.czz | 1024 | 4096);
                setFocusable(true);
                update();
            }
            final View contentView = this.czw.getContentView();
            if (contentView.getHeight() == 0) {
                contentView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.menu.j.1
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        j.this.czw.im(contentView.getHeight());
                        j.this.asV();
                        contentView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                });
            } else {
                asV();
            }
        }
    }

    public void asU() {
        if (this.czy != null) {
            this.czy.a(this.czw);
        }
    }

    public void b(List<List<i>> list, View view, boolean z, int i) {
        this.czw.a(list, view, z, i);
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
            ObjectAnimator aJ = c.aJ(this.czt);
            ObjectAnimator b = c.b(this.czu);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.menu.j.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Context context = j.this.mContext;
                    if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
                        j.super.dismiss();
                        if (j.this.czu != j.this.czw) {
                            j.this.czu.setVisibility(8);
                        }
                    }
                }
            });
            animatorSet.playTogether(aJ, b);
            animatorSet.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void asN() {
        this.czw.asN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asV() {
        this.czt.setAlpha(0.0f);
        this.czw.setTranslationY(this.czw.getHeight());
        ObjectAnimator a = c.a(this.czt, this.czw);
        ObjectAnimator a2 = c.a(this.czw);
        ArrayList arrayList = new ArrayList();
        arrayList.add(a);
        arrayList.add(a2);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        animatorSet.start();
    }

    public void iq(int i) {
        this.czz = i;
    }
}

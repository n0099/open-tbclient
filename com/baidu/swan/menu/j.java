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
/* loaded from: classes9.dex */
public class j extends PopupWindow implements View.OnClickListener {
    private FrameLayout coJ;
    private View cvj;
    private BaseMenuView cvk;
    private View cvl;
    private MainMenuView cvm;
    private boolean cvn;
    private a cvo;
    private int cvp;
    private Context mContext;
    private boolean mImmersionEnabled;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Context context, View view, @Nullable a aVar) {
        super(context);
        this.cvn = true;
        this.mImmersionEnabled = true;
        this.cvp = 0;
        this.mContext = context;
        this.cvl = view;
        this.cvo = aVar;
        setClippingEnabled(false);
        setFocusable(true);
        setOutsideTouchable(true);
        setBackgroundDrawable(new ColorDrawable(0));
        setWidth(-1);
        setHeight(-1);
        initViews();
    }

    private void initViews() {
        this.coJ = (FrameLayout) LayoutInflater.from(this.mContext).inflate(g.e.aiapp_menu_layout, (ViewGroup) null);
        this.cvj = this.coJ.findViewById(g.d.mask);
        this.cvm = (MainMenuView) this.coJ.findViewById(g.d.aiapp_menu_body);
        this.cvj.setOnClickListener(this);
        this.cvm.setClickListener(this);
        this.coJ.measure(0, 0);
        setContentView(this.coJ);
    }

    private void showView() {
        if (!isShowing()) {
            aql();
            this.cvm.reset();
            this.cvk = this.cvm;
            if (this.mImmersionEnabled) {
                setFocusable(false);
            }
            showAtLocation(this.cvl, 81, 0, 0);
            if (this.mImmersionEnabled) {
                getContentView().setSystemUiVisibility(this.cvp | 1024 | 4096);
                setFocusable(true);
                update();
            }
            final View contentView = this.cvm.getContentView();
            if (contentView.getHeight() == 0) {
                contentView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.menu.j.1
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        j.this.cvm.hV(contentView.getHeight());
                        j.this.aqm();
                        contentView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                });
            } else {
                aqm();
            }
        }
    }

    public void aql() {
        if (this.cvo != null) {
            this.cvo.a(this.cvm);
        }
    }

    public void b(List<List<i>> list, View view, boolean z, int i) {
        this.cvm.a(list, view, z, i);
        showView();
    }

    @Override // com.baidu.swan.menu.PopupWindow
    public void dismiss() {
        eK(true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == g.d.cancel || id == g.d.mask) {
            eK(true);
        }
    }

    public void eK(boolean z) {
        if (!z) {
            super.dismiss();
        } else if (isShowing()) {
            ObjectAnimator aF = c.aF(this.cvj);
            ObjectAnimator b = c.b(this.cvk);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.menu.j.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Context context = j.this.mContext;
                    if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
                        j.super.dismiss();
                        if (j.this.cvk != j.this.cvm) {
                            j.this.cvk.setVisibility(8);
                        }
                    }
                }
            });
            animatorSet.playTogether(aF, b);
            animatorSet.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aqe() {
        this.cvm.aqe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqm() {
        this.cvj.setAlpha(0.0f);
        this.cvm.setTranslationY(this.cvm.getHeight());
        ObjectAnimator a = c.a(this.cvj, this.cvm);
        ObjectAnimator a2 = c.a(this.cvm);
        ArrayList arrayList = new ArrayList();
        arrayList.add(a);
        arrayList.add(a2);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        animatorSet.start();
    }

    public void hZ(int i) {
        this.cvp = i;
    }
}

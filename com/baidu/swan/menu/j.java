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
/* loaded from: classes5.dex */
public class j extends PopupWindow implements View.OnClickListener {
    private FrameLayout ail;
    private View dej;
    private View del;
    private BaseMenuView eeZ;
    private MainMenuView efa;
    private boolean efb;
    private a efc;
    private int efd;
    private Context mContext;
    private boolean mImmersionEnabled;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Context context, View view, @Nullable a aVar) {
        super(context);
        this.efb = true;
        this.mImmersionEnabled = true;
        this.efd = 0;
        this.mContext = context;
        this.dej = view;
        this.efc = aVar;
        setClippingEnabled(false);
        setFocusable(true);
        setOutsideTouchable(true);
        setBackgroundDrawable(new ColorDrawable(0));
        setWidth(-1);
        setHeight(-1);
        initViews();
    }

    private void initViews() {
        this.ail = (FrameLayout) LayoutInflater.from(this.mContext).inflate(g.e.aiapp_menu_layout, (ViewGroup) null);
        this.del = this.ail.findViewById(g.d.mask);
        this.efa = (MainMenuView) this.ail.findViewById(g.d.aiapp_menu_body);
        this.del.setOnClickListener(this);
        this.efa.setClickListener(this);
        this.ail.measure(0, 0);
        setContentView(this.ail);
    }

    private void showView() {
        if (!isShowing()) {
            aBn();
            this.efa.reset();
            this.eeZ = this.efa;
            if (this.mImmersionEnabled) {
                setFocusable(false);
            }
            Activity activity = (Activity) this.mContext;
            if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
                showAtLocation(this.dej, 81, 0, 0);
                if (this.mImmersionEnabled) {
                    getContentView().setSystemUiVisibility(this.efd | 1024 | 4096);
                    setFocusable(true);
                    update();
                }
                final View contentView = this.efa.getContentView();
                if (contentView.getHeight() == 0) {
                    contentView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.menu.j.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            j.this.efa.mw(contentView.getHeight());
                            j.this.aBo();
                            contentView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        }
                    });
                } else {
                    aBo();
                }
            }
        }
    }

    public void aBn() {
        if (this.efc != null) {
            this.efc.a(this.efa);
        }
    }

    public void b(List<List<i>> list, View view, boolean z, int i) {
        this.efa.a(list, view, z, i);
        showView();
    }

    @Override // com.baidu.swan.menu.PopupWindow
    public void dismiss() {
        fK(true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == g.d.cancel || id == g.d.mask) {
            fK(true);
        }
    }

    public void fK(boolean z) {
        if (!z) {
            super.dismiss();
        } else if (isShowing()) {
            ObjectAnimator aY = c.aY(this.del);
            ObjectAnimator c = c.c(this.eeZ);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.menu.j.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Context context = j.this.mContext;
                    if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
                        j.super.dismiss();
                        if (j.this.eeZ != j.this.efa) {
                            j.this.eeZ.setVisibility(8);
                        }
                    }
                }
            });
            animatorSet.playTogether(aY, c);
            animatorSet.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aZK() {
        this.efa.aZK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBo() {
        this.del.setAlpha(0.0f);
        this.efa.setTranslationY(this.efa.getHeight());
        ObjectAnimator a2 = c.a(this.del, this.efa);
        ObjectAnimator b = c.b(this.efa);
        ArrayList arrayList = new ArrayList();
        arrayList.add(a2);
        arrayList.add(b);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        animatorSet.start();
    }

    public void mA(int i) {
        this.efd = i;
    }
}

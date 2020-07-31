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
    private FrameLayout agl;
    private View duo;
    private BaseMenuView dup;
    private View duq;
    private MainMenuView dur;
    private boolean dus;
    private a dut;
    private int duu;
    private Context mContext;
    private boolean mImmersionEnabled;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Context context, View view, @Nullable a aVar) {
        super(context);
        this.dus = true;
        this.mImmersionEnabled = true;
        this.duu = 0;
        this.mContext = context;
        this.duq = view;
        this.dut = aVar;
        setClippingEnabled(false);
        setFocusable(true);
        setOutsideTouchable(true);
        setBackgroundDrawable(new ColorDrawable(0));
        setWidth(-1);
        setHeight(-1);
        initViews();
    }

    private void initViews() {
        this.agl = (FrameLayout) LayoutInflater.from(this.mContext).inflate(g.e.aiapp_menu_layout, (ViewGroup) null);
        this.duo = this.agl.findViewById(g.d.mask);
        this.dur = (MainMenuView) this.agl.findViewById(g.d.aiapp_menu_body);
        this.duo.setOnClickListener(this);
        this.dur.setClickListener(this);
        this.agl.measure(0, 0);
        setContentView(this.agl);
    }

    private void showView() {
        if (!isShowing()) {
            aJW();
            this.dur.reset();
            this.dup = this.dur;
            if (this.mImmersionEnabled) {
                setFocusable(false);
            }
            Activity activity = (Activity) this.mContext;
            if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
                showAtLocation(this.duq, 81, 0, 0);
                if (this.mImmersionEnabled) {
                    getContentView().setSystemUiVisibility(this.duu | 1024 | 4096);
                    setFocusable(true);
                    update();
                }
                final View contentView = this.dur.getContentView();
                if (contentView.getHeight() == 0) {
                    contentView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.menu.j.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            j.this.dur.jo(contentView.getHeight());
                            j.this.aJX();
                            contentView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        }
                    });
                } else {
                    aJX();
                }
            }
        }
    }

    public void aJW() {
        if (this.dut != null) {
            this.dut.a(this.dur);
        }
    }

    public void b(List<List<i>> list, View view, boolean z, int i) {
        this.dur.a(list, view, z, i);
        showView();
    }

    @Override // com.baidu.swan.menu.PopupWindow
    public void dismiss() {
        gF(true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == g.d.cancel || id == g.d.mask) {
            gF(true);
        }
    }

    public void gF(boolean z) {
        if (!z) {
            super.dismiss();
        } else if (isShowing()) {
            ObjectAnimator aO = c.aO(this.duo);
            ObjectAnimator b = c.b(this.dup);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.menu.j.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Context context = j.this.mContext;
                    if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
                        j.super.dismiss();
                        if (j.this.dup != j.this.dur) {
                            j.this.dup.setVisibility(8);
                        }
                    }
                }
            });
            animatorSet.playTogether(aO, b);
            animatorSet.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aJP() {
        this.dur.aJP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJX() {
        this.duo.setAlpha(0.0f);
        this.dur.setTranslationY(this.dur.getHeight());
        ObjectAnimator a = c.a(this.duo, this.dur);
        ObjectAnimator a2 = c.a(this.dur);
        ArrayList arrayList = new ArrayList();
        arrayList.add(a);
        arrayList.add(a2);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        animatorSet.start();
    }

    public void js(int i) {
        this.duu = i;
    }
}

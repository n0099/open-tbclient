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
/* loaded from: classes2.dex */
public class p extends PopupWindow implements View.OnClickListener, b {
    private static final boolean DEBUG = a.DEBUG;
    private boolean aqb;
    private FrameLayout bfG;
    private int bjP;
    private String bkG;
    private View bkT;
    private BaseMenuView bkU;
    private h bkV;
    private View bkW;
    private MainMenuView bkX;
    private boolean bkY;
    private c bkZ;
    private int bla;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(Context context, View view, int i, @Nullable c cVar) {
        super(context);
        this.bkY = true;
        this.aqb = true;
        this.bla = 0;
        this.mContext = context;
        this.bkW = view;
        this.bjP = i;
        this.bkZ = cVar;
        setClippingEnabled(false);
        setFocusable(true);
        setOutsideTouchable(true);
        setBackgroundDrawable(new ColorDrawable(0));
        setAnimationStyle(g.C0211g.aiapp_menu);
        setWidth(-1);
        setHeight(-1);
        initViews();
    }

    @Override // com.baidu.swan.menu.PopupWindow
    public void dismiss() {
        cO(true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == g.d.cancel || id == g.d.mask) {
            cO(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setStatisticSource(String str) {
        this.bkG = str;
        this.bkX.setStatisticSource(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMenuSource(String str) {
        this.bkX.setMenuSource(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void showView() {
        if (!isShowing()) {
            if (this.bkZ != null) {
                this.bkZ.a(this.bkX);
            }
            this.bkX.reset();
            this.bkU = this.bkX;
            final View contentView = this.bkX.getContentView();
            a(this.bkW, 81, 0, 0);
            if (contentView.getHeight() == 0) {
                contentView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.menu.p.1
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        p.this.bkX.eT(contentView.getHeight());
                        p.this.Rl();
                        contentView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                });
            } else {
                Rl();
            }
            this.bkX.Rc();
        }
    }

    public void a(View view, int i, int i2, int i3) {
        if (this.aqb) {
            setFocusable(false);
        }
        showAtLocation(view, i, i2, i3);
        if (this.aqb) {
            getContentView().setSystemUiVisibility(this.bla | 1024 | 4096);
            setFocusable(true);
            update();
        }
    }

    public void cO(boolean z) {
        if (!z) {
            super.dismiss();
        } else if (isShowing()) {
            ObjectAnimator at = e.at(this.bkT);
            ObjectAnimator d = e.d(this.bkU);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.menu.p.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Context context = p.this.mContext;
                    if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
                        p.super.dismiss();
                        if (p.this.bkU != p.this.bkX) {
                            p.this.bkU.setVisibility(8);
                        }
                    }
                }
            });
            animatorSet.playTogether(at, d);
            animatorSet.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void F(List<k> list) {
        this.bkX.A(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(h hVar) {
        this.bkV = hVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMode(SwanAppMenuMode swanAppMenuMode) {
        this.bkX.setMode(swanAppMenuMode);
    }

    private void initViews() {
        this.bfG = (FrameLayout) LayoutInflater.from(this.mContext).inflate(g.e.aiapp_menu_layout, (ViewGroup) null);
        this.bkT = this.bfG.findViewById(g.d.mask);
        this.bkX = (MainMenuView) this.bfG.findViewById(g.d.aiapp_menu_body);
        this.bkT.setOnClickListener(this);
        this.bkX.setClickListener(this);
        this.bkX.setMenuStyle(this.bjP);
        this.bkX.setDismissCallback(this);
        this.bfG.measure(0, 0);
        setContentView(this.bfG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rl() {
        ObjectAnimator b;
        View bgView = this.bkX.getBgView();
        View contentView = this.bkX.getContentView();
        int height = contentView.getHeight();
        this.bkX.setTranslationY(0.0f);
        bgView.setTranslationY(height);
        contentView.setTranslationY(height);
        this.bkT.setAlpha(0.0f);
        contentView.setAlpha(0.0f);
        ObjectAnimator a = e.a(this.bkT, this.bkX);
        ObjectAnimator a2 = e.a(this.bkX);
        ObjectAnimator b2 = e.b((BaseMenuView) this.bkX);
        ObjectAnimator c = e.c(this.bkX);
        ArrayList arrayList = new ArrayList();
        arrayList.add(a);
        arrayList.add(a2);
        arrayList.add(b2);
        arrayList.add(c);
        View coverView = this.bkX.getCoverView();
        if (coverView != null && (b = e.b(this.bkX)) != null) {
            coverView.setTranslationY(height);
            arrayList.add(b);
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        animatorSet.start();
    }

    public void eW(int i) {
        this.bla = i;
    }
}

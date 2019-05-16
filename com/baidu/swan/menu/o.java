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
import com.baidu.swan.menu.f;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class o extends PopupWindow implements View.OnClickListener, a {
    private boolean aqm;
    private FrameLayout bkY;
    private int bpW;
    private String bqM;
    private View bqZ;
    private BaseMenuView bra;
    private g brb;
    private View brc;
    private MainMenuView brd;
    private boolean bre;
    private b brf;
    private int brg;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(Context context, View view, int i, @Nullable b bVar) {
        super(context);
        this.bre = true;
        this.aqm = true;
        this.brg = 0;
        this.mContext = context;
        this.brc = view;
        this.bpW = i;
        this.brf = bVar;
        setClippingEnabled(false);
        setFocusable(true);
        setOutsideTouchable(true);
        setBackgroundDrawable(new ColorDrawable(0));
        setAnimationStyle(f.g.aiapp_menu);
        setWidth(-1);
        setHeight(-1);
        initViews();
    }

    @Override // com.baidu.swan.menu.PopupWindow
    public void dismiss() {
        df(true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == f.d.cancel || id == f.d.mask) {
            df(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setStatisticSource(String str) {
        this.bqM = str;
        this.brd.setStatisticSource(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMenuSource(String str) {
        this.brd.setMenuSource(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void showView() {
        if (!isShowing()) {
            if (this.brf != null) {
                this.brf.a(this.brd);
            }
            this.brd.reset();
            this.bra = this.brd;
            final View contentView = this.brd.getContentView();
            a(this.brc, 81, 0, 0);
            if (contentView.getHeight() == 0) {
                contentView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.menu.o.1
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        o.this.brd.fr(contentView.getHeight());
                        o.this.UV();
                        contentView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                });
            } else {
                UV();
            }
            this.brd.UM();
        }
    }

    public void a(View view, int i, int i2, int i3) {
        if (this.aqm) {
            setFocusable(false);
        }
        showAtLocation(view, i, i2, i3);
        if (this.aqm) {
            getContentView().setSystemUiVisibility(this.brg | 1024 | 4096);
            setFocusable(true);
            update();
        }
    }

    public void df(boolean z) {
        if (!z) {
            super.dismiss();
        } else if (isShowing()) {
            ObjectAnimator az = d.az(this.bqZ);
            ObjectAnimator d = d.d(this.bra);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.menu.o.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Context context = o.this.mContext;
                    if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
                        o.super.dismiss();
                        if (o.this.bra != o.this.brd) {
                            o.this.bra.setVisibility(8);
                        }
                    }
                }
            });
            animatorSet.playTogether(az, d);
            animatorSet.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G(List<j> list) {
        this.brd.B(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(g gVar) {
        this.brb = gVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMode(SwanAppMenuMode swanAppMenuMode) {
        this.brd.setMode(swanAppMenuMode);
    }

    private void initViews() {
        this.bkY = (FrameLayout) LayoutInflater.from(this.mContext).inflate(f.e.aiapp_menu_layout, (ViewGroup) null);
        this.bqZ = this.bkY.findViewById(f.d.mask);
        this.brd = (MainMenuView) this.bkY.findViewById(f.d.aiapp_menu_body);
        this.bqZ.setOnClickListener(this);
        this.brd.setClickListener(this);
        this.brd.setMenuStyle(this.bpW);
        this.brd.setDismissCallback(this);
        this.bkY.measure(0, 0);
        setContentView(this.bkY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UV() {
        ObjectAnimator b;
        View bgView = this.brd.getBgView();
        View contentView = this.brd.getContentView();
        int height = contentView.getHeight();
        this.brd.setTranslationY(0.0f);
        bgView.setTranslationY(height);
        contentView.setTranslationY(height);
        this.bqZ.setAlpha(0.0f);
        contentView.setAlpha(0.0f);
        ObjectAnimator a = d.a(this.bqZ, this.brd);
        ObjectAnimator a2 = d.a(this.brd);
        ObjectAnimator b2 = d.b((BaseMenuView) this.brd);
        ObjectAnimator c = d.c(this.brd);
        ArrayList arrayList = new ArrayList();
        arrayList.add(a);
        arrayList.add(a2);
        arrayList.add(b2);
        arrayList.add(c);
        View coverView = this.brd.getCoverView();
        if (coverView != null && (b = d.b(this.brd)) != null) {
            coverView.setTranslationY(height);
            arrayList.add(b);
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        animatorSet.start();
    }

    public void fu(int i) {
        this.brg = i;
    }
}

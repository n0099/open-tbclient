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
    private FrameLayout aiT;
    private boolean cRO;
    private View dnC;
    private View dnE;
    private BaseMenuView eta;
    private MainMenuView etb;
    private boolean etd;
    private a ete;
    private int etf;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(Context context, View view, @Nullable a aVar) {
        super(context);
        this.etd = true;
        this.cRO = true;
        this.etf = 0;
        this.mContext = context;
        this.dnC = view;
        this.ete = aVar;
        eo(false);
        setFocusable(true);
        en(true);
        setBackgroundDrawable(new ColorDrawable(0));
        setWidth(-1);
        setHeight(-1);
        initViews();
    }

    private void initViews() {
        this.aiT = (FrameLayout) LayoutInflater.from(this.mContext).inflate(f.e.aiapp_menu_layout, (ViewGroup) null);
        this.dnE = this.aiT.findViewById(f.d.mask);
        this.etb = (MainMenuView) this.aiT.findViewById(f.d.aiapp_menu_body);
        this.dnE.setOnClickListener(this);
        this.etb.setClickListener(this);
        this.aiT.measure(0, 0);
        setContentView(this.aiT);
    }

    private void showView() {
        if (!isShowing()) {
            aCt();
            this.etb.reset();
            this.eta = this.etb;
            if (this.cRO) {
                setFocusable(false);
            }
            Activity activity = (Activity) this.mContext;
            if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
                showAtLocation(this.dnC, 81, 0, 0);
                if (this.cRO) {
                    getContentView().setSystemUiVisibility(this.etf | 1024 | 4096);
                    setFocusable(true);
                    update();
                }
                final View contentView = this.etb.getContentView();
                if (contentView.getHeight() == 0) {
                    contentView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.menu.i.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            i.this.etb.lz(contentView.getHeight());
                            i.this.aCu();
                            contentView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        }
                    });
                } else {
                    aCu();
                }
            }
        }
    }

    public void aCt() {
        if (this.ete != null) {
            this.ete.a(this.etb);
        }
    }

    public void b(List<List<h>> list, View view, boolean z, int i) {
        this.etb.a(list, view, z, i);
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
            ObjectAnimator bf = c.bf(this.dnE);
            ObjectAnimator c = c.c(this.eta);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.menu.i.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Context context = i.this.mContext;
                    if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
                        i.super.dismiss();
                        if (i.this.eta != i.this.etb) {
                            i.this.eta.setVisibility(8);
                        }
                    }
                }
            });
            animatorSet.playTogether(bf, c);
            animatorSet.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bbC() {
        this.etb.bbC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCu() {
        this.dnE.setAlpha(0.0f);
        this.etb.setTranslationY(this.etb.getHeight());
        ObjectAnimator a2 = c.a(this.dnE, this.etb);
        ObjectAnimator b2 = c.b(this.etb);
        ArrayList arrayList = new ArrayList();
        arrayList.add(a2);
        arrayList.add(b2);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        animatorSet.start();
    }

    public void lE(int i) {
        this.etf = i;
    }
}

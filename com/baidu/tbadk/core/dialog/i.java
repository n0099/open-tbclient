package com.baidu.tbadk.core.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class i extends Dialog {
    private LinearLayout bOb;
    private float bOc;
    private boolean bOd;
    private Context context;
    private boolean isShowing;
    protected View mContentView;
    private com.baidu.adp.base.e mPageContext;

    public i(com.baidu.adp.base.e eVar, View view) {
        super(eVar.getPageActivity(), 16973835);
        this.bOc = 0.3f;
        this.bOd = false;
        this.isShowing = false;
        this.mPageContext = eVar;
        this.context = eVar.getPageActivity();
        this.mContentView = view;
    }

    public i(com.baidu.adp.base.e eVar) {
        super(eVar.getPageActivity(), 16973835);
        this.bOc = 0.3f;
        this.bOd = false;
        this.isShowing = false;
        this.context = eVar.getPageActivity();
        this.mPageContext = eVar;
    }

    public void an(float f) {
        this.bOc = f;
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        this.mContentView = view;
    }

    public void a(String str, String[] strArr, k.c cVar) {
        k kVar = new k(this.context);
        if (!StringUtils.isNull(str)) {
            kVar.setTitleText(str);
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < strArr.length; i++) {
            arrayList.add(new g(i, strArr[i], kVar));
        }
        kVar.W(arrayList);
        kVar.a(cVar);
        setCanceledOnTouchOutside(true);
        this.mContentView = kVar.ahb();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.popup_dialog);
        Display defaultDisplay = ((WindowManager) this.context.getSystemService("window")).getDefaultDisplay();
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = defaultDisplay.getWidth();
        getWindow().setAttributes(attributes);
        getWindow().setBackgroundDrawableResource(R.color.transparent);
        getWindow().setDimAmount(this.bOc);
        getWindow().setGravity(80);
        getWindow().setWindowAnimations(0);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        this.bOb = (LinearLayout) findViewById(R.id.root_view);
        this.bOb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i.this.cancel();
            }
        });
        if (this.mContentView != null) {
            this.bOb.removeAllViews();
            if (this.mContentView.getParent() != null) {
                if (this.mContentView.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.mContentView.getParent()).removeView(this.mContentView);
                    this.bOb.addView(this.mContentView);
                    return;
                }
                return;
            }
            this.bOb.addView(this.mContentView);
        }
    }

    public void showDialog() {
        this.bOd = false;
        if (isShowing()) {
            super.dismiss();
        }
        com.baidu.adp.lib.g.g.a(this, this.mPageContext);
        if (this.bOb != null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.context, R.anim.pop_enter_anim);
            loadAnimation.setFillAfter(true);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tbadk.core.dialog.i.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    i.this.setCancelable(false);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    i.this.setCancelable(true);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.bOb.startAnimation(loadAnimation);
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (this.bOb != null && !this.bOd && isShowing()) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.context, R.anim.pop_exit_anim);
            loadAnimation.setFillAfter(true);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tbadk.core.dialog.i.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    i.this.bOd = true;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    i.this.bOd = false;
                    if (i.this.mPageContext != null && i.this.mPageContext.getPageActivity() != null) {
                        Activity pageActivity = i.this.mPageContext.getPageActivity();
                        if (!pageActivity.isFinishing() && pageActivity.getWindow() != null) {
                            i.super.dismiss();
                        }
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.bOb.startAnimation(loadAnimation);
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        if (isShowing()) {
            cancel();
        } else {
            super.onBackPressed();
        }
    }

    public View getContentView() {
        return this.mContentView;
    }

    public LinearLayout getRootView() {
        return this.bOb;
    }
}

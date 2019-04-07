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
import com.baidu.tbadk.core.dialog.i;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class g extends Dialog {
    private boolean bFA;
    private LinearLayout bFy;
    private float bFz;
    private Context context;
    private boolean isShowing;
    protected View mContentView;
    private com.baidu.adp.base.e mPageContext;

    public g(com.baidu.adp.base.e eVar, View view) {
        super(eVar.getPageActivity(), 16973835);
        this.bFz = 0.3f;
        this.bFA = false;
        this.isShowing = false;
        this.mPageContext = eVar;
        this.context = eVar.getPageActivity();
        this.mContentView = view;
    }

    public g(com.baidu.adp.base.e eVar) {
        super(eVar.getPageActivity(), 16973835);
        this.bFz = 0.3f;
        this.bFA = false;
        this.isShowing = false;
        this.context = eVar.getPageActivity();
        this.mPageContext = eVar;
    }

    public void al(float f) {
        this.bFz = f;
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        this.mContentView = view;
    }

    public void a(String str, String[] strArr, i.c cVar) {
        i iVar = new i(this.context);
        if (!StringUtils.isNull(str)) {
            iVar.setTitleText(str);
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < strArr.length; i++) {
            arrayList.add(new f(i, strArr[i], iVar));
        }
        iVar.P(arrayList);
        iVar.a(cVar);
        setCanceledOnTouchOutside(true);
        this.mContentView = iVar.abh();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(d.h.popup_dialog);
        Display defaultDisplay = ((WindowManager) this.context.getSystemService("window")).getDefaultDisplay();
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = defaultDisplay.getWidth();
        getWindow().setAttributes(attributes);
        getWindow().setBackgroundDrawableResource(d.C0277d.transparent);
        getWindow().setDimAmount(this.bFz);
        getWindow().setGravity(80);
        getWindow().setWindowAnimations(0);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        this.bFy = (LinearLayout) findViewById(d.g.root_view);
        this.bFy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.cancel();
            }
        });
        if (this.mContentView != null) {
            this.bFy.removeAllViews();
            if (this.mContentView.getParent() != null) {
                if (this.mContentView.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.mContentView.getParent()).removeView(this.mContentView);
                    this.bFy.addView(this.mContentView);
                    return;
                }
                return;
            }
            this.bFy.addView(this.mContentView);
        }
    }

    public void showDialog() {
        this.bFA = false;
        if (isShowing()) {
            super.dismiss();
        }
        com.baidu.adp.lib.g.g.a(this, this.mPageContext);
        if (this.bFy != null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.context, d.a.pop_enter_anim);
            loadAnimation.setFillAfter(true);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tbadk.core.dialog.g.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    g.this.setCancelable(false);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    g.this.setCancelable(true);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.bFy.startAnimation(loadAnimation);
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (this.bFy != null && !this.bFA && isShowing()) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.context, d.a.pop_exit_anim);
            loadAnimation.setFillAfter(true);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tbadk.core.dialog.g.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    g.this.bFA = true;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    g.this.bFA = false;
                    if (g.this.mPageContext != null && g.this.mPageContext.getPageActivity() != null) {
                        Activity pageActivity = g.this.mPageContext.getPageActivity();
                        if (!pageActivity.isFinishing() && pageActivity.getWindow() != null) {
                            g.super.dismiss();
                        }
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.bFy.startAnimation(loadAnimation);
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
        return this.bFy;
    }
}

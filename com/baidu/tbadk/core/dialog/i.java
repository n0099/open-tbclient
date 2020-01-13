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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class i extends Dialog {
    private com.baidu.adp.base.e cRA;
    private float cRB;
    private k cRC;
    private CustomMessageListener cRD;
    private Context context;
    private boolean isDismissing;
    private boolean isShowing;
    protected View mContentView;
    private LinearLayout mRootView;

    public i(com.baidu.adp.base.e eVar, k kVar) {
        super(eVar.getPageActivity(), 16973835);
        this.cRB = 0.3f;
        this.isDismissing = false;
        this.isShowing = false;
        this.cRD = new CustomMessageListener(CmdConfigCustom.CMD_SKIN_TYPE_CHANGE) { // from class: com.baidu.tbadk.core.dialog.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer) && i.this.cRC != null) {
                    i.this.cRC.onChangeSkinType();
                }
            }
        };
        this.cRA = eVar;
        this.context = eVar.getPageActivity();
        this.cRC = kVar;
        this.mContentView = kVar.aCF();
    }

    public i(com.baidu.adp.base.e eVar) {
        super(eVar.getPageActivity(), 16973835);
        this.cRB = 0.3f;
        this.isDismissing = false;
        this.isShowing = false;
        this.cRD = new CustomMessageListener(CmdConfigCustom.CMD_SKIN_TYPE_CHANGE) { // from class: com.baidu.tbadk.core.dialog.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer) && i.this.cRC != null) {
                    i.this.cRC.onChangeSkinType();
                }
            }
        };
        this.context = eVar.getPageActivity();
        this.cRA = eVar;
    }

    public void af(float f) {
        this.cRB = f;
    }

    public void a(k kVar) {
        this.cRC = kVar;
        this.mContentView = kVar.aCF();
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        this.mContentView = view;
    }

    public void a(String str, String[] strArr, k.c cVar) {
        this.cRC = new k(this.context);
        if (!StringUtils.isNull(str)) {
            this.cRC.setTitleText(str);
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < strArr.length; i++) {
            arrayList.add(new g(i, strArr[i], this.cRC));
        }
        this.cRC.az(arrayList);
        this.cRC.a(cVar);
        setCanceledOnTouchOutside(true);
        this.mContentView = this.cRC.aCF();
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
        getWindow().setDimAmount(this.cRB);
        getWindow().setGravity(80);
        getWindow().setWindowAnimations(0);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        this.mRootView = (LinearLayout) findViewById(R.id.root_view);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.i.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i.this.cancel();
            }
        });
        if (this.mContentView != null) {
            this.mRootView.removeAllViews();
            if (this.mContentView.getParent() != null) {
                if (this.mContentView.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.mContentView.getParent()).removeView(this.mContentView);
                    this.mRootView.addView(this.mContentView);
                    return;
                }
                return;
            }
            this.mRootView.addView(this.mContentView);
        }
    }

    public void showDialog() {
        this.isDismissing = false;
        if (isShowing()) {
            super.dismiss();
        }
        com.baidu.adp.lib.f.g.a(this, this.cRA);
        if (this.mRootView != null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.context, R.anim.pop_enter_anim);
            loadAnimation.setFillAfter(true);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tbadk.core.dialog.i.3
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
            this.mRootView.startAnimation(loadAnimation);
        }
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        this.cRA.registerListener(this.cRD);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (this.mRootView != null && !this.isDismissing && isShowing()) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.context, R.anim.pop_exit_anim);
            loadAnimation.setFillAfter(true);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tbadk.core.dialog.i.4
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    i.this.isDismissing = true;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    i.this.isDismissing = false;
                    i.this.mRootView.post(new Runnable() { // from class: com.baidu.tbadk.core.dialog.i.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (i.this.cRA != null && i.this.cRA.getPageActivity() != null) {
                                Activity pageActivity = i.this.cRA.getPageActivity();
                                if (!pageActivity.isFinishing() && pageActivity.getWindow() != null) {
                                    i.super.dismiss();
                                }
                            }
                        }
                    });
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.mRootView.startAnimation(loadAnimation);
            MessageManager.getInstance().unRegisterListener(this.cRD);
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
        return this.mRootView;
    }
}

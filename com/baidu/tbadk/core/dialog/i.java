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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class i extends Dialog {
    private static int eNY = 1000;
    private Context context;
    private com.baidu.adp.base.e eNZ;
    private float eOa;
    private k eOb;
    private boolean eOc;
    private CustomMessageListener eOd;
    private boolean isDismissing;
    private boolean isShowing;
    protected View mContentView;
    private LinearLayout mRootView;

    public i(com.baidu.adp.base.e eVar, k kVar) {
        super(eVar.getPageActivity(), 16973835);
        this.eOa = 0.33f;
        this.isDismissing = false;
        this.isShowing = false;
        this.eOc = true;
        this.eOd = new CustomMessageListener(CmdConfigCustom.CMD_SKIN_TYPE_CHANGE) { // from class: com.baidu.tbadk.core.dialog.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer) && i.this.eOb != null) {
                    i.this.eOb.onChangeSkinType();
                }
            }
        };
        this.eNZ = eVar;
        this.context = eVar.getPageActivity();
        this.eOb = kVar;
        this.mContentView = kVar.brP();
    }

    public i(com.baidu.adp.base.e eVar) {
        super(eVar.getPageActivity(), 16973835);
        this.eOa = 0.33f;
        this.isDismissing = false;
        this.isShowing = false;
        this.eOc = true;
        this.eOd = new CustomMessageListener(CmdConfigCustom.CMD_SKIN_TYPE_CHANGE) { // from class: com.baidu.tbadk.core.dialog.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer) && i.this.eOb != null) {
                    i.this.eOb.onChangeSkinType();
                }
            }
        };
        this.context = eVar.getPageActivity();
        this.eNZ = eVar;
    }

    public void Z(float f) {
        this.eOa = f;
    }

    public void a(k kVar) {
        this.eOb = kVar;
        this.mContentView = kVar.brP();
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        this.mContentView = view;
    }

    public void a(String str, String[] strArr, k.c cVar) {
        this.eOb = new k(this.context);
        if (!StringUtils.isNull(str)) {
            this.eOb.setTitleText(str);
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < strArr.length; i++) {
            arrayList.add(new g(i, strArr[i], this.eOb));
        }
        this.eOb.bu(arrayList);
        this.eOb.a(cVar);
        setCanceledOnTouchOutside(true);
        this.mContentView = this.eOb.brP();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.popup_dialog);
        Display defaultDisplay = ((WindowManager) this.context.getSystemService("window")).getDefaultDisplay();
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = defaultDisplay.getWidth();
        attributes.height = defaultDisplay.getHeight();
        if (this.eOc) {
            attributes.y = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
            getWindow().addFlags(512);
        }
        getWindow().setAttributes(attributes);
        getWindow().setBackgroundDrawableResource(R.color.transparent);
        getWindow().setDimAmount(this.eOa);
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
            this.mRootView.removeView(this.mContentView);
            if (this.eOc && (this.mContentView instanceof ViewGroup) && ((ViewGroup) this.mContentView).getChildAt(((ViewGroup) this.mContentView).getChildCount() - 1).getId() != eNY) {
                View view = new View(getContext());
                view.setId(eNY);
                view.setLayoutParams(new ViewGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.bottom_enter_anim_place_holder_height)));
                ap.setBackgroundResource(view, R.color.CAM_X0204);
                ((ViewGroup) this.mContentView).addView(view);
            }
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

    public void RU() {
        this.isDismissing = false;
        if (isShowing()) {
            super.dismiss();
        }
        com.baidu.adp.lib.f.g.a(this, this.eNZ);
        if (this.mRootView != null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.context, R.anim.bomb_pop_enter_anim);
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
        this.eNZ.registerListener(this.eOd);
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
                            if (i.this.eNZ != null && i.this.eNZ.getPageActivity() != null) {
                                Activity pageActivity = i.this.eNZ.getPageActivity();
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
            MessageManager.getInstance().unRegisterListener(this.eOd);
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

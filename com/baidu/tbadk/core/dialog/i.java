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
import com.baidu.tbadk.core.message.WindowSwitchMessage;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class i extends Dialog {
    private static int eXV = 1000;
    private Context context;
    private com.baidu.adp.base.f eXW;
    private float eXX;
    private k eXY;
    private boolean eXZ;
    private CustomMessageListener eYa;
    private boolean isDismissing;
    private boolean isShowing;
    protected View mContentView;
    private LinearLayout mRootView;

    public i(com.baidu.adp.base.f fVar, k kVar) {
        super(fVar.getPageActivity(), 16973835);
        this.eXX = 0.33f;
        this.isDismissing = false;
        this.isShowing = false;
        this.eXZ = true;
        this.eYa = new CustomMessageListener(CmdConfigCustom.CMD_SKIN_TYPE_CHANGE) { // from class: com.baidu.tbadk.core.dialog.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer) && i.this.eXY != null) {
                    i.this.eXY.onChangeSkinType();
                }
            }
        };
        this.eXW = fVar;
        this.context = fVar.getPageActivity();
        this.eXY = kVar;
        this.mContentView = kVar.bur();
    }

    public i(com.baidu.adp.base.f fVar) {
        super(fVar.getPageActivity(), 16973835);
        this.eXX = 0.33f;
        this.isDismissing = false;
        this.isShowing = false;
        this.eXZ = true;
        this.eYa = new CustomMessageListener(CmdConfigCustom.CMD_SKIN_TYPE_CHANGE) { // from class: com.baidu.tbadk.core.dialog.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer) && i.this.eXY != null) {
                    i.this.eXY.onChangeSkinType();
                }
            }
        };
        this.context = fVar.getPageActivity();
        this.eXW = fVar;
    }

    public void ab(float f) {
        this.eXX = f;
    }

    public void a(k kVar) {
        this.eXY = kVar;
        this.mContentView = kVar.bur();
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        this.mContentView = view;
    }

    public void a(String str, String[] strArr, k.c cVar) {
        this.eXY = new k(this.context);
        if (!StringUtils.isNull(str)) {
            this.eXY.setTitleText(str);
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < strArr.length; i++) {
            arrayList.add(new g(i, strArr[i], this.eXY));
        }
        this.eXY.bB(arrayList);
        this.eXY.a(cVar);
        setCanceledOnTouchOutside(true);
        this.mContentView = this.eXY.bur();
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
        if (this.eXZ) {
            attributes.y = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
            getWindow().addFlags(512);
        }
        getWindow().setAttributes(attributes);
        getWindow().setBackgroundDrawableResource(R.color.transparent);
        getWindow().setDimAmount(this.eXX);
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
            if (this.eXZ && (this.mContentView instanceof ViewGroup) && ((ViewGroup) this.mContentView).getChildAt(((ViewGroup) this.mContentView).getChildCount() - 1).getId() != eXV) {
                View view = new View(getContext());
                view.setId(eXV);
                view.setLayoutParams(new ViewGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.bottom_enter_anim_place_holder_height)));
                ao.setBackgroundResource(view, R.color.CAM_X0204);
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

    public void SY() {
        this.isDismissing = false;
        if (isShowing()) {
            super.dismiss();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.valueOf(com.baidu.adp.lib.f.g.a(this, this.eXW))));
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
        this.eXW.registerListener(this.eYa);
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
                            if (i.this.eXW != null && i.this.eXW.getPageActivity() != null) {
                                Activity pageActivity = i.this.eXW.getPageActivity();
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
            MessageManager.getInstance().unRegisterListener(this.eYa);
            MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(false));
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

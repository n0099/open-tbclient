package com.baidu.tbadk.core.dialog;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    private static final int eXR = R.drawable.shape_new_complete_toast_bg;
    private TextView cWc;
    private TextView eXS;
    private TbImageView eXT;
    private Context mContext;
    private com.baidu.tbadk.BdToken.completeTask.a mData;
    private Runnable mHideRunnable;
    private WindowManager.LayoutParams mLayoutParams;
    private ViewGroup mRootView;
    private WindowManager mWindowManager;
    private int offsetX;
    private int offsetY;
    private float bem = 1.0f;
    private int duration = 3000;

    private h(Context context) {
        if (context != null) {
            this.mContext = context;
            this.mRootView = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.new_task_completed_toast_layout, (ViewGroup) null);
            this.cWc = (TextView) this.mRootView.findViewById(R.id.toast_message_content);
            this.eXS = (TextView) this.mRootView.findViewById(R.id.toast_btn);
            this.eXS.setOnClickListener(this);
            this.eXT = (TbImageView) this.mRootView.findViewById(R.id.toast_bg);
            this.eXT.setDefaultBgResource(eXR);
            this.eXT.setDrawCorner(true);
            this.eXT.setConrers(15);
            this.eXT.setRadius(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds20));
            this.offsetY = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds176);
            this.offsetX = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds29);
            ao.setBackgroundResource(this.mRootView, R.drawable.layerlist_new_complete_task_toast_shadow);
            this.mWindowManager = (WindowManager) this.mContext.getSystemService("window");
            buo();
            this.mHideRunnable = new Runnable() { // from class: com.baidu.tbadk.core.dialog.h.1
                @Override // java.lang.Runnable
                public void run() {
                    h.this.hide();
                }
            };
        }
    }

    public static h b(Context context, com.baidu.tbadk.BdToken.completeTask.a aVar) {
        return new h(context).b(aVar);
    }

    private h b(com.baidu.tbadk.BdToken.completeTask.a aVar) {
        if (this.mContext != null) {
            if (aVar == null) {
                return bul();
            }
            this.mData = aVar;
            if (at.isEmpty(aVar.message)) {
                this.cWc.setText(this.mContext.getResources().getString(R.string.task_already_finish));
            } else {
                this.cWc.setText(aVar.message);
            }
            if (at.isEmpty(aVar.btnText)) {
                this.eXS.setText(this.mContext.getResources().getString(R.string.back));
            } else {
                this.eXS.setText(aVar.btnText);
            }
            if (at.isEmpty(aVar.message_color)) {
                ao.setViewTextColor(this.cWc, R.color.CAM_X0302, 1);
            } else {
                this.cWc.setTextColor(com.baidu.tieba.lego.card.c.b.sF(aVar.message_color));
            }
            if (at.isEmpty(aVar.btn_text_color)) {
                ao.setViewTextColor(this.eXS, R.color.CAM_X0101, 1);
            } else {
                this.eXS.setTextColor(com.baidu.tieba.lego.card.c.b.sF(aVar.btn_text_color));
            }
            if (!at.isEmpty(aVar.btn_color)) {
                this.eXS.setBackgroundDrawable(Bt(aVar.btn_color));
            }
            if (!at.isEmpty(aVar.imgUrl)) {
                this.eXT.startLoad(aVar.imgUrl, 10, false);
            }
            if (aVar.duration > 3) {
                this.duration = aVar.duration * 1000;
            }
            this.bem = (float) aVar.opacity;
            bun();
            return this;
        }
        return this;
    }

    private h bul() {
        this.cWc.setText(this.mContext.getResources().getString(R.string.task_already_finish));
        this.eXS.setText(this.mContext.getResources().getString(R.string.back));
        ao.setViewTextColor(this.cWc, R.color.CAM_X0302, 1);
        ao.setViewTextColor(this.eXS, R.color.CAM_X0101, 1);
        bun();
        return this;
    }

    public h bum() {
        if (this.mContext != null) {
            this.mWindowManager.addView(this.mRootView, this.mLayoutParams);
            com.baidu.adp.lib.f.e.mB().removeCallbacks(this.mHideRunnable);
            com.baidu.adp.lib.f.e.mB().postDelayed(this.mHideRunnable, this.duration);
            if (this.mData != null) {
                TiebaStatic.log(new aq("c13317").an("obj_source", this.mData.activityId).an("obj_type", this.mData.missionId));
            }
        }
        return this;
    }

    public void hide() {
        if (this.mContext != null) {
            if (this.mRootView.getWindowToken() != null) {
                this.mWindowManager.removeView(this.mRootView);
            }
            com.baidu.adp.lib.f.e.mB().removeCallbacks(this.mHideRunnable);
        }
        this.mContext = null;
    }

    private void bun() {
        this.mLayoutParams.y = this.offsetY;
        this.mLayoutParams.alpha = this.bem;
    }

    private void buo() {
        this.mLayoutParams = new WindowManager.LayoutParams();
        this.mLayoutParams.width = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) - (this.offsetX * 2);
        this.mLayoutParams.height = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds196);
        this.mLayoutParams.type = 1000;
        this.mLayoutParams.format = -3;
        this.mLayoutParams.windowAnimations = R.style.new_complete_task_toast;
        this.mLayoutParams.flags = 262152;
        this.mLayoutParams.gravity = 81;
    }

    private StateListDrawable Bt(String str) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.shape_new_complete_toast_btn_bg_pressed);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10));
        gradientDrawable.setColor(com.baidu.tieba.lego.card.c.b.sF(str));
        stateListDrawable.addState(new int[]{16842919}, drawable);
        stateListDrawable.addState(new int[0], gradientDrawable);
        return stateListDrawable;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mData != null) {
            if (this.mData.eIg == com.baidu.tbadk.BdToken.completeTask.a.eIe) {
                if (!UtilHelper.dealOneScheme(TbadkCoreApplication.getInst().getCurrentActivity(), this.mData.schema) && !at.isEmpty(this.mData.url)) {
                    dealJump(this.mData.url);
                }
            } else if (this.mData.eIg == com.baidu.tbadk.BdToken.completeTask.a.eIf && !at.isEmpty(this.mData.url)) {
                dealJump(this.mData.url);
            }
            TiebaStatic.log(new aq("c13318").an("obj_source", this.mData.activityId).an("obj_type", this.mData.missionId));
        }
    }

    private void dealJump(String str) {
        TbPageContext<?> currentActivityPageContext;
        if (!at.isEmpty(str) && (currentActivityPageContext = getCurrentActivityPageContext(TbadkCoreApplication.getInst().getCurrentActivity())) != null) {
            be.bwu().b(currentActivityPageContext, new String[]{str});
        }
    }

    private TbPageContext getCurrentActivityPageContext(Activity activity) {
        if (activity instanceof BaseActivity) {
            return ((BaseActivity) activity).getPageContext();
        }
        if (activity instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) activity).getPageContext();
        }
        return null;
    }
}

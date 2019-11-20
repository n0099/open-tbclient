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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    private TextView aLN;
    private TextView ceP;
    private TbImageView ceQ;
    private Context mContext;
    private com.baidu.tbadk.BdToken.completeTask.a mData;
    private Runnable mHideRunnable;
    private WindowManager.LayoutParams mLayoutParams;
    private ViewGroup mRootView;
    private WindowManager mWindowManager;
    private int offsetX;
    private int offsetY;
    private float aED = 1.0f;
    private int duration = 3000;

    private h(Context context) {
        if (context != null) {
            this.mContext = context;
            this.mRootView = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.new_task_completed_toast_layout, (ViewGroup) null);
            this.aLN = (TextView) this.mRootView.findViewById(R.id.toast_message_content);
            this.ceP = (TextView) this.mRootView.findViewById(R.id.toast_btn);
            this.ceP.setOnClickListener(this);
            this.ceQ = (TbImageView) this.mRootView.findViewById(R.id.toast_bg);
            this.ceQ.setDefaultBgResource(R.drawable.shape_new_complete_toast_bg);
            this.ceQ.setDrawCorner(true);
            this.ceQ.setConrers(15);
            this.ceQ.setRadius(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds20));
            this.offsetY = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds176);
            this.offsetX = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds29);
            am.setBackgroundResource(this.mRootView, R.drawable.layerlist_new_complete_task_toast_shadow);
            this.mWindowManager = (WindowManager) this.mContext.getSystemService("window");
            akZ();
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
                return akW();
            }
            this.mData = aVar;
            if (aq.isEmpty(aVar.message)) {
                this.aLN.setText(this.mContext.getResources().getString(R.string.task_already_finish));
            } else {
                this.aLN.setText(aVar.message);
            }
            if (aq.isEmpty(aVar.btnText)) {
                this.ceP.setText(this.mContext.getResources().getString(R.string.back));
            } else {
                this.ceP.setText(aVar.btnText);
            }
            if (aq.isEmpty(aVar.message_color)) {
                am.setViewTextColor(this.aLN, R.color.cp_link_tip_a, 1);
            } else {
                this.aLN.setTextColor(com.baidu.tieba.lego.card.d.a.bR(aVar.message_color));
            }
            if (aq.isEmpty(aVar.btn_text_color)) {
                am.setViewTextColor(this.ceP, R.color.cp_cont_a, 1);
            } else {
                this.ceP.setTextColor(com.baidu.tieba.lego.card.d.a.bR(aVar.btn_text_color));
            }
            if (!aq.isEmpty(aVar.btn_color)) {
                this.ceP.setBackgroundDrawable(nr(aVar.btn_color));
            }
            if (!aq.isEmpty(aVar.imgUrl)) {
                this.ceQ.startLoad(aVar.imgUrl, 10, false);
            }
            if (aVar.duration > 3) {
                this.duration = aVar.duration * 1000;
            }
            this.aED = (float) aVar.opacity;
            akY();
            return this;
        }
        return this;
    }

    private h akW() {
        this.aLN.setText(this.mContext.getResources().getString(R.string.task_already_finish));
        this.ceP.setText(this.mContext.getResources().getString(R.string.back));
        am.setViewTextColor(this.aLN, R.color.cp_link_tip_a, 1);
        am.setViewTextColor(this.ceP, R.color.cp_cont_a, 1);
        akY();
        return this;
    }

    public h akX() {
        if (this.mContext != null) {
            this.mWindowManager.addView(this.mRootView, this.mLayoutParams);
            com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.mHideRunnable);
            com.baidu.adp.lib.g.e.fZ().postDelayed(this.mHideRunnable, this.duration);
            if (this.mData != null) {
                TiebaStatic.log(new an("c13317").O("obj_source", this.mData.activityId).O("obj_type", this.mData.missionId));
            }
        }
        return this;
    }

    public void hide() {
        if (this.mContext != null) {
            if (this.mRootView.getWindowToken() != null) {
                this.mWindowManager.removeView(this.mRootView);
            }
            com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.mHideRunnable);
        }
        this.mContext = null;
    }

    private void akY() {
        this.mLayoutParams.y = this.offsetY;
        this.mLayoutParams.alpha = this.aED;
    }

    private void akZ() {
        this.mLayoutParams = new WindowManager.LayoutParams();
        this.mLayoutParams.width = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) - (this.offsetX * 2);
        this.mLayoutParams.height = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds196);
        this.mLayoutParams.type = 1000;
        this.mLayoutParams.format = -3;
        this.mLayoutParams.windowAnimations = R.style.new_complete_task_toast;
        this.mLayoutParams.flags = 262152;
        this.mLayoutParams.gravity = 81;
    }

    private StateListDrawable nr(String str) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.shape_new_complete_toast_btn_bg_pressed);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10));
        gradientDrawable.setColor(com.baidu.tieba.lego.card.d.a.bR(str));
        stateListDrawable.addState(new int[]{16842919}, drawable);
        stateListDrawable.addState(new int[0], gradientDrawable);
        return stateListDrawable;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mData != null) {
            if (this.mData.bSB == com.baidu.tbadk.BdToken.completeTask.a.bSz) {
                if (!UtilHelper.dealOneScheme(TbadkCoreApplication.getInst().getCurrentActivity(), this.mData.schema) && !aq.isEmpty(this.mData.url)) {
                    lY(this.mData.url);
                }
            } else if (this.mData.bSB == com.baidu.tbadk.BdToken.completeTask.a.bSA && !aq.isEmpty(this.mData.url)) {
                lY(this.mData.url);
            }
            TiebaStatic.log(new an("c13318").O("obj_source", this.mData.activityId).O("obj_type", this.mData.missionId));
        }
    }

    private void lY(String str) {
        TbPageContext<?> X;
        if (!aq.isEmpty(str) && (X = X(TbadkCoreApplication.getInst().getCurrentActivity())) != null) {
            ba.amO().b(X, new String[]{str});
        }
    }

    private TbPageContext X(Activity activity) {
        if (activity instanceof BaseActivity) {
            return ((BaseActivity) activity).getPageContext();
        }
        if (activity instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) activity).getPageContext();
        }
        return null;
    }
}

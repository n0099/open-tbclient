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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    private static final int dWg = R.drawable.shape_new_complete_toast_bg;
    private TextView cdm;
    private TextView dWh;
    private TbImageView dWi;
    private Context mContext;
    private com.baidu.tbadk.BdToken.completeTask.a mData;
    private Runnable mHideRunnable;
    private WindowManager.LayoutParams mLayoutParams;
    private ViewGroup mRootView;
    private WindowManager mWindowManager;
    private int offsetX;
    private int offsetY;
    private float alpha = 1.0f;
    private int duration = 3000;

    private h(Context context) {
        if (context != null) {
            this.mContext = context;
            this.mRootView = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.new_task_completed_toast_layout, (ViewGroup) null);
            this.cdm = (TextView) this.mRootView.findViewById(R.id.toast_message_content);
            this.dWh = (TextView) this.mRootView.findViewById(R.id.toast_btn);
            this.dWh.setOnClickListener(this);
            this.dWi = (TbImageView) this.mRootView.findViewById(R.id.toast_bg);
            this.dWi.setDefaultBgResource(dWg);
            this.dWi.setDrawCorner(true);
            this.dWi.setConrers(15);
            this.dWi.setRadius(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds20));
            this.offsetY = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds176);
            this.offsetX = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds29);
            ao.setBackgroundResource(this.mRootView, R.drawable.layerlist_new_complete_task_toast_shadow);
            this.mWindowManager = (WindowManager) this.mContext.getSystemService("window");
            aYZ();
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
                return aYW();
            }
            this.mData = aVar;
            if (as.isEmpty(aVar.message)) {
                this.cdm.setText(this.mContext.getResources().getString(R.string.task_already_finish));
            } else {
                this.cdm.setText(aVar.message);
            }
            if (as.isEmpty(aVar.btnText)) {
                this.dWh.setText(this.mContext.getResources().getString(R.string.back));
            } else {
                this.dWh.setText(aVar.btnText);
            }
            if (as.isEmpty(aVar.message_color)) {
                ao.setViewTextColor(this.cdm, R.color.cp_link_tip_a, 1);
            } else {
                this.cdm.setTextColor(com.baidu.tieba.lego.card.d.a.dU(aVar.message_color));
            }
            if (as.isEmpty(aVar.btn_text_color)) {
                ao.setViewTextColor(this.dWh, R.color.cp_cont_a, 1);
            } else {
                this.dWh.setTextColor(com.baidu.tieba.lego.card.d.a.dU(aVar.btn_text_color));
            }
            if (!as.isEmpty(aVar.btn_color)) {
                this.dWh.setBackgroundDrawable(xp(aVar.btn_color));
            }
            if (!as.isEmpty(aVar.imgUrl)) {
                this.dWi.startLoad(aVar.imgUrl, 10, false);
            }
            if (aVar.duration > 3) {
                this.duration = aVar.duration * 1000;
            }
            this.alpha = (float) aVar.opacity;
            aYY();
            return this;
        }
        return this;
    }

    private h aYW() {
        this.cdm.setText(this.mContext.getResources().getString(R.string.task_already_finish));
        this.dWh.setText(this.mContext.getResources().getString(R.string.back));
        ao.setViewTextColor(this.cdm, R.color.cp_link_tip_a, 1);
        ao.setViewTextColor(this.dWh, R.color.cp_cont_a, 1);
        aYY();
        return this;
    }

    public h aYX() {
        if (this.mContext != null) {
            this.mWindowManager.addView(this.mRootView, this.mLayoutParams);
            com.baidu.adp.lib.f.e.lt().removeCallbacks(this.mHideRunnable);
            com.baidu.adp.lib.f.e.lt().postDelayed(this.mHideRunnable, this.duration);
            if (this.mData != null) {
                TiebaStatic.log(new ap("c13317").ah("obj_source", this.mData.activityId).ah("obj_type", this.mData.missionId));
            }
        }
        return this;
    }

    public void hide() {
        if (this.mContext != null) {
            if (this.mRootView.getWindowToken() != null) {
                this.mWindowManager.removeView(this.mRootView);
            }
            com.baidu.adp.lib.f.e.lt().removeCallbacks(this.mHideRunnable);
        }
        this.mContext = null;
    }

    private void aYY() {
        this.mLayoutParams.y = this.offsetY;
        this.mLayoutParams.alpha = this.alpha;
    }

    private void aYZ() {
        this.mLayoutParams = new WindowManager.LayoutParams();
        this.mLayoutParams.width = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) - (this.offsetX * 2);
        this.mLayoutParams.height = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds196);
        this.mLayoutParams.type = 1000;
        this.mLayoutParams.format = -3;
        this.mLayoutParams.windowAnimations = R.style.new_complete_task_toast;
        this.mLayoutParams.flags = 262152;
        this.mLayoutParams.gravity = 81;
    }

    private StateListDrawable xp(String str) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.shape_new_complete_toast_btn_bg_pressed);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10));
        gradientDrawable.setColor(com.baidu.tieba.lego.card.d.a.dU(str));
        stateListDrawable.addState(new int[]{16842919}, drawable);
        stateListDrawable.addState(new int[0], gradientDrawable);
        return stateListDrawable;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mData != null) {
            if (this.mData.dHG == com.baidu.tbadk.BdToken.completeTask.a.dHE) {
                if (!UtilHelper.dealOneScheme(TbadkCoreApplication.getInst().getCurrentActivity(), this.mData.schema) && !as.isEmpty(this.mData.url)) {
                    vK(this.mData.url);
                }
            } else if (this.mData.dHG == com.baidu.tbadk.BdToken.completeTask.a.dHF && !as.isEmpty(this.mData.url)) {
                vK(this.mData.url);
            }
            TiebaStatic.log(new ap("c13318").ah("obj_source", this.mData.activityId).ah("obj_type", this.mData.missionId));
        }
    }

    private void vK(String str) {
        TbPageContext<?> o;
        if (!as.isEmpty(str) && (o = o(TbadkCoreApplication.getInst().getCurrentActivity())) != null) {
            bd.baV().b(o, new String[]{str});
        }
    }

    private TbPageContext o(Activity activity) {
        if (activity instanceof BaseActivity) {
            return ((BaseActivity) activity).getPageContext();
        }
        if (activity instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) activity).getPageContext();
        }
        return null;
    }
}

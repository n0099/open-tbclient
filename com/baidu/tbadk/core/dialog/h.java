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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    private TextView cbI;
    private TextView dPO;
    private TbImageView dPP;
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
            this.cbI = (TextView) this.mRootView.findViewById(R.id.toast_message_content);
            this.dPO = (TextView) this.mRootView.findViewById(R.id.toast_btn);
            this.dPO.setOnClickListener(this);
            this.dPP = (TbImageView) this.mRootView.findViewById(R.id.toast_bg);
            this.dPP.setDefaultBgResource(R.drawable.shape_new_complete_toast_bg);
            this.dPP.setDrawCorner(true);
            this.dPP.setConrers(15);
            this.dPP.setRadius(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds20));
            this.offsetY = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds176);
            this.offsetX = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds29);
            an.setBackgroundResource(this.mRootView, R.drawable.layerlist_new_complete_task_toast_shadow);
            this.mWindowManager = (WindowManager) this.mContext.getSystemService("window");
            rR();
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
                return aUX();
            }
            this.mData = aVar;
            if (ar.isEmpty(aVar.message)) {
                this.cbI.setText(this.mContext.getResources().getString(R.string.task_already_finish));
            } else {
                this.cbI.setText(aVar.message);
            }
            if (ar.isEmpty(aVar.btnText)) {
                this.dPO.setText(this.mContext.getResources().getString(R.string.back));
            } else {
                this.dPO.setText(aVar.btnText);
            }
            if (ar.isEmpty(aVar.message_color)) {
                an.setViewTextColor(this.cbI, R.color.cp_link_tip_a, 1);
            } else {
                this.cbI.setTextColor(com.baidu.tieba.lego.card.d.a.dV(aVar.message_color));
            }
            if (ar.isEmpty(aVar.btn_text_color)) {
                an.setViewTextColor(this.dPO, R.color.cp_cont_a, 1);
            } else {
                this.dPO.setTextColor(com.baidu.tieba.lego.card.d.a.dV(aVar.btn_text_color));
            }
            if (!ar.isEmpty(aVar.btn_color)) {
                this.dPO.setBackgroundDrawable(wi(aVar.btn_color));
            }
            if (!ar.isEmpty(aVar.imgUrl)) {
                this.dPP.startLoad(aVar.imgUrl, 10, false);
            }
            if (aVar.duration > 3) {
                this.duration = aVar.duration * 1000;
            }
            this.alpha = (float) aVar.opacity;
            aUZ();
            return this;
        }
        return this;
    }

    private h aUX() {
        this.cbI.setText(this.mContext.getResources().getString(R.string.task_already_finish));
        this.dPO.setText(this.mContext.getResources().getString(R.string.back));
        an.setViewTextColor(this.cbI, R.color.cp_link_tip_a, 1);
        an.setViewTextColor(this.dPO, R.color.cp_cont_a, 1);
        aUZ();
        return this;
    }

    public h aUY() {
        if (this.mContext != null) {
            this.mWindowManager.addView(this.mRootView, this.mLayoutParams);
            com.baidu.adp.lib.f.e.lt().removeCallbacks(this.mHideRunnable);
            com.baidu.adp.lib.f.e.lt().postDelayed(this.mHideRunnable, this.duration);
            if (this.mData != null) {
                TiebaStatic.log(new ao("c13317").ag("obj_source", this.mData.activityId).ag("obj_type", this.mData.missionId));
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

    private void aUZ() {
        this.mLayoutParams.y = this.offsetY;
        this.mLayoutParams.alpha = this.alpha;
    }

    private void rR() {
        this.mLayoutParams = new WindowManager.LayoutParams();
        this.mLayoutParams.width = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) - (this.offsetX * 2);
        this.mLayoutParams.height = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds196);
        this.mLayoutParams.type = 1000;
        this.mLayoutParams.format = -3;
        this.mLayoutParams.windowAnimations = R.style.new_complete_task_toast;
        this.mLayoutParams.flags = 262152;
        this.mLayoutParams.gravity = 81;
    }

    private StateListDrawable wi(String str) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.shape_new_complete_toast_btn_bg_pressed);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10));
        gradientDrawable.setColor(com.baidu.tieba.lego.card.d.a.dV(str));
        stateListDrawable.addState(new int[]{16842919}, drawable);
        stateListDrawable.addState(new int[0], gradientDrawable);
        return stateListDrawable;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mData != null) {
            if (this.mData.dBK == com.baidu.tbadk.BdToken.completeTask.a.dBI) {
                if (!UtilHelper.dealOneScheme(TbadkCoreApplication.getInst().getCurrentActivity(), this.mData.schema) && !ar.isEmpty(this.mData.url)) {
                    uH(this.mData.url);
                }
            } else if (this.mData.dBK == com.baidu.tbadk.BdToken.completeTask.a.dBJ && !ar.isEmpty(this.mData.url)) {
                uH(this.mData.url);
            }
            TiebaStatic.log(new ao("c13318").ag("obj_source", this.mData.activityId).ag("obj_type", this.mData.missionId));
        }
    }

    private void uH(String str) {
        TbPageContext<?> n;
        if (!ar.isEmpty(str) && (n = n(TbadkCoreApplication.getInst().getCurrentActivity())) != null) {
            bc.aWU().b(n, new String[]{str});
        }
    }

    private TbPageContext n(Activity activity) {
        if (activity instanceof BaseActivity) {
            return ((BaseActivity) activity).getPageContext();
        }
        if (activity instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) activity).getPageContext();
        }
        return null;
    }
}

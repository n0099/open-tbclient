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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    private static final int eWV = R.drawable.shape_new_complete_toast_bg;
    private TextView cVd;
    private TextView eWW;
    private TbImageView eWX;
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
            this.cVd = (TextView) this.mRootView.findViewById(R.id.toast_message_content);
            this.eWW = (TextView) this.mRootView.findViewById(R.id.toast_btn);
            this.eWW.setOnClickListener(this);
            this.eWX = (TbImageView) this.mRootView.findViewById(R.id.toast_bg);
            this.eWX.setDefaultBgResource(eWV);
            this.eWX.setDrawCorner(true);
            this.eWX.setConrers(15);
            this.eWX.setRadius(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds20));
            this.offsetY = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds176);
            this.offsetX = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds29);
            ap.setBackgroundResource(this.mRootView, R.drawable.layerlist_new_complete_task_toast_shadow);
            this.mWindowManager = (WindowManager) this.mContext.getSystemService("window");
            bqP();
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
                return bqM();
            }
            this.mData = aVar;
            if (au.isEmpty(aVar.message)) {
                this.cVd.setText(this.mContext.getResources().getString(R.string.task_already_finish));
            } else {
                this.cVd.setText(aVar.message);
            }
            if (au.isEmpty(aVar.btnText)) {
                this.eWW.setText(this.mContext.getResources().getString(R.string.back));
            } else {
                this.eWW.setText(aVar.btnText);
            }
            if (au.isEmpty(aVar.message_color)) {
                ap.setViewTextColor(this.cVd, R.color.CAM_X0302, 1);
            } else {
                this.cVd.setTextColor(com.baidu.tieba.lego.card.c.b.rT(aVar.message_color));
            }
            if (au.isEmpty(aVar.btn_text_color)) {
                ap.setViewTextColor(this.eWW, R.color.CAM_X0101, 1);
            } else {
                this.eWW.setTextColor(com.baidu.tieba.lego.card.c.b.rT(aVar.btn_text_color));
            }
            if (!au.isEmpty(aVar.btn_color)) {
                this.eWW.setBackgroundDrawable(AF(aVar.btn_color));
            }
            if (!au.isEmpty(aVar.imgUrl)) {
                this.eWX.startLoad(aVar.imgUrl, 10, false);
            }
            if (aVar.duration > 3) {
                this.duration = aVar.duration * 1000;
            }
            this.alpha = (float) aVar.opacity;
            bqO();
            return this;
        }
        return this;
    }

    private h bqM() {
        this.cVd.setText(this.mContext.getResources().getString(R.string.task_already_finish));
        this.eWW.setText(this.mContext.getResources().getString(R.string.back));
        ap.setViewTextColor(this.cVd, R.color.CAM_X0302, 1);
        ap.setViewTextColor(this.eWW, R.color.CAM_X0101, 1);
        bqO();
        return this;
    }

    public h bqN() {
        if (this.mContext != null) {
            this.mWindowManager.addView(this.mRootView, this.mLayoutParams);
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.mHideRunnable);
            com.baidu.adp.lib.f.e.mA().postDelayed(this.mHideRunnable, this.duration);
            if (this.mData != null) {
                TiebaStatic.log(new ar("c13317").aq("obj_source", this.mData.activityId).aq("obj_type", this.mData.missionId));
            }
        }
        return this;
    }

    public void hide() {
        if (this.mContext != null) {
            if (this.mRootView.getWindowToken() != null) {
                this.mWindowManager.removeView(this.mRootView);
            }
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.mHideRunnable);
        }
        this.mContext = null;
    }

    private void bqO() {
        this.mLayoutParams.y = this.offsetY;
        this.mLayoutParams.alpha = this.alpha;
    }

    private void bqP() {
        this.mLayoutParams = new WindowManager.LayoutParams();
        this.mLayoutParams.width = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) - (this.offsetX * 2);
        this.mLayoutParams.height = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds196);
        this.mLayoutParams.type = 1000;
        this.mLayoutParams.format = -3;
        this.mLayoutParams.windowAnimations = R.style.new_complete_task_toast;
        this.mLayoutParams.flags = 262152;
        this.mLayoutParams.gravity = 81;
    }

    private StateListDrawable AF(String str) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.shape_new_complete_toast_btn_bg_pressed);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10));
        gradientDrawable.setColor(com.baidu.tieba.lego.card.c.b.rT(str));
        stateListDrawable.addState(new int[]{16842919}, drawable);
        stateListDrawable.addState(new int[0], gradientDrawable);
        return stateListDrawable;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mData != null) {
            if (this.mData.eHd == com.baidu.tbadk.BdToken.completeTask.a.eHb) {
                if (!UtilHelper.dealOneScheme(TbadkCoreApplication.getInst().getCurrentActivity(), this.mData.schema) && !au.isEmpty(this.mData.url)) {
                    dealJump(this.mData.url);
                }
            } else if (this.mData.eHd == com.baidu.tbadk.BdToken.completeTask.a.eHc && !au.isEmpty(this.mData.url)) {
                dealJump(this.mData.url);
            }
            TiebaStatic.log(new ar("c13318").aq("obj_source", this.mData.activityId).aq("obj_type", this.mData.missionId));
        }
    }

    private void dealJump(String str) {
        TbPageContext<?> currentActivityPageContext;
        if (!au.isEmpty(str) && (currentActivityPageContext = getCurrentActivityPageContext(TbadkCoreApplication.getInst().getCurrentActivity())) != null) {
            bf.bsY().b(currentActivityPageContext, new String[]{str});
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

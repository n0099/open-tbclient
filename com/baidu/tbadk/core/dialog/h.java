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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    private static final int ehZ = R.drawable.shape_new_complete_toast_bg;
    private TextView clp;
    private TextView eia;
    private TbImageView eib;
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
            this.clp = (TextView) this.mRootView.findViewById(R.id.toast_message_content);
            this.eia = (TextView) this.mRootView.findViewById(R.id.toast_btn);
            this.eia.setOnClickListener(this);
            this.eib = (TbImageView) this.mRootView.findViewById(R.id.toast_bg);
            this.eib.setDefaultBgResource(ehZ);
            this.eib.setDrawCorner(true);
            this.eib.setConrers(15);
            this.eib.setRadius(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds20));
            this.offsetY = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds176);
            this.offsetX = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds29);
            ap.setBackgroundResource(this.mRootView, R.drawable.layerlist_new_complete_task_toast_shadow);
            this.mWindowManager = (WindowManager) this.mContext.getSystemService("window");
            bio();
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
                return bil();
            }
            this.mData = aVar;
            if (at.isEmpty(aVar.message)) {
                this.clp.setText(this.mContext.getResources().getString(R.string.task_already_finish));
            } else {
                this.clp.setText(aVar.message);
            }
            if (at.isEmpty(aVar.btnText)) {
                this.eia.setText(this.mContext.getResources().getString(R.string.back));
            } else {
                this.eia.setText(aVar.btnText);
            }
            if (at.isEmpty(aVar.message_color)) {
                ap.setViewTextColor(this.clp, R.color.cp_link_tip_a, 1);
            } else {
                this.clp.setTextColor(com.baidu.tieba.lego.card.d.b.fq(aVar.message_color));
            }
            if (at.isEmpty(aVar.btn_text_color)) {
                ap.setViewTextColor(this.eia, R.color.cp_cont_a, 1);
            } else {
                this.eia.setTextColor(com.baidu.tieba.lego.card.d.b.fq(aVar.btn_text_color));
            }
            if (!at.isEmpty(aVar.btn_color)) {
                this.eia.setBackgroundDrawable(zZ(aVar.btn_color));
            }
            if (!at.isEmpty(aVar.imgUrl)) {
                this.eib.startLoad(aVar.imgUrl, 10, false);
            }
            if (aVar.duration > 3) {
                this.duration = aVar.duration * 1000;
            }
            this.alpha = (float) aVar.opacity;
            bin();
            return this;
        }
        return this;
    }

    private h bil() {
        this.clp.setText(this.mContext.getResources().getString(R.string.task_already_finish));
        this.eia.setText(this.mContext.getResources().getString(R.string.back));
        ap.setViewTextColor(this.clp, R.color.cp_link_tip_a, 1);
        ap.setViewTextColor(this.eia, R.color.cp_cont_a, 1);
        bin();
        return this;
    }

    public h bim() {
        if (this.mContext != null) {
            this.mWindowManager.addView(this.mRootView, this.mLayoutParams);
            com.baidu.adp.lib.f.e.mX().removeCallbacks(this.mHideRunnable);
            com.baidu.adp.lib.f.e.mX().postDelayed(this.mHideRunnable, this.duration);
            if (this.mData != null) {
                TiebaStatic.log(new aq("c13317").ai("obj_source", this.mData.activityId).ai("obj_type", this.mData.missionId));
            }
        }
        return this;
    }

    public void hide() {
        if (this.mContext != null) {
            if (this.mRootView.getWindowToken() != null) {
                this.mWindowManager.removeView(this.mRootView);
            }
            com.baidu.adp.lib.f.e.mX().removeCallbacks(this.mHideRunnable);
        }
        this.mContext = null;
    }

    private void bin() {
        this.mLayoutParams.y = this.offsetY;
        this.mLayoutParams.alpha = this.alpha;
    }

    private void bio() {
        this.mLayoutParams = new WindowManager.LayoutParams();
        this.mLayoutParams.width = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) - (this.offsetX * 2);
        this.mLayoutParams.height = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds196);
        this.mLayoutParams.type = 1000;
        this.mLayoutParams.format = -3;
        this.mLayoutParams.windowAnimations = R.style.new_complete_task_toast;
        this.mLayoutParams.flags = 262152;
        this.mLayoutParams.gravity = 81;
    }

    private StateListDrawable zZ(String str) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.shape_new_complete_toast_btn_bg_pressed);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10));
        gradientDrawable.setColor(com.baidu.tieba.lego.card.d.b.fq(str));
        stateListDrawable.addState(new int[]{16842919}, drawable);
        stateListDrawable.addState(new int[0], gradientDrawable);
        return stateListDrawable;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mData != null) {
            if (this.mData.dTb == com.baidu.tbadk.BdToken.completeTask.a.dSZ) {
                if (!UtilHelper.dealOneScheme(TbadkCoreApplication.getInst().getCurrentActivity(), this.mData.schema) && !at.isEmpty(this.mData.url)) {
                    yq(this.mData.url);
                }
            } else if (this.mData.dTb == com.baidu.tbadk.BdToken.completeTask.a.dTa && !at.isEmpty(this.mData.url)) {
                yq(this.mData.url);
            }
            TiebaStatic.log(new aq("c13318").ai("obj_source", this.mData.activityId).ai("obj_type", this.mData.missionId));
        }
    }

    private void yq(String str) {
        TbPageContext<?> o;
        if (!at.isEmpty(str) && (o = o(TbadkCoreApplication.getInst().getCurrentActivity())) != null) {
            be.bkp().b(o, new String[]{str});
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

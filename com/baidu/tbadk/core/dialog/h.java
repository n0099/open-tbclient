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
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
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
    private TextView bOC;
    private TbImageView bOD;
    private TextView mContentView;
    private Context mContext;
    private com.baidu.tbadk.BdToken.completeTask.a mData;
    private Runnable mHideRunnable;
    private WindowManager.LayoutParams mLayoutParams;
    private ViewGroup mRootView;
    private WindowManager mWindowManager;
    private int zQ;
    private int zR;
    private float alA = 1.0f;
    private int duration = 3000;

    private h(Context context) {
        if (context != null) {
            this.mContext = context;
            this.mRootView = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.new_task_completed_toast_layout, (ViewGroup) null);
            this.mContentView = (TextView) this.mRootView.findViewById(R.id.toast_message_content);
            this.bOC = (TextView) this.mRootView.findViewById(R.id.toast_btn);
            this.bOC.setOnClickListener(this);
            this.bOD = (TbImageView) this.mRootView.findViewById(R.id.toast_bg);
            this.bOD.setDefaultBgResource(R.drawable.shape_new_complete_toast_bg);
            this.bOD.setDrawCorner(true);
            this.bOD.setConrers(15);
            this.bOD.setRadius(com.baidu.adp.lib.util.l.g(context, R.dimen.tbds20));
            this.zR = com.baidu.adp.lib.util.l.g(context, R.dimen.tbds176);
            this.zQ = com.baidu.adp.lib.util.l.g(context, R.dimen.tbds29);
            am.k(this.mRootView, R.drawable.layerlist_new_complete_task_toast_shadow);
            this.mWindowManager = (WindowManager) this.mContext.getSystemService("window");
            ahe();
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
                return ahb();
            }
            this.mData = aVar;
            if (aq.isEmpty(aVar.message)) {
                this.mContentView.setText(this.mContext.getResources().getString(R.string.task_already_finish));
            } else {
                this.mContentView.setText(aVar.message);
            }
            if (aq.isEmpty(aVar.btnText)) {
                this.bOC.setText(this.mContext.getResources().getString(R.string.back));
            } else {
                this.bOC.setText(aVar.btnText);
            }
            if (aq.isEmpty(aVar.message_color)) {
                am.f(this.mContentView, R.color.cp_link_tip_a, 1);
            } else {
                this.mContentView.setTextColor(com.baidu.tieba.lego.card.d.a.cE(aVar.message_color));
            }
            if (aq.isEmpty(aVar.btn_text_color)) {
                am.f(this.bOC, R.color.cp_cont_a, 1);
            } else {
                this.bOC.setTextColor(com.baidu.tieba.lego.card.d.a.cE(aVar.btn_text_color));
            }
            if (!aq.isEmpty(aVar.btn_color)) {
                this.bOC.setBackgroundDrawable(mU(aVar.btn_color));
            }
            if (!aq.isEmpty(aVar.imgUrl)) {
                this.bOD.startLoad(aVar.imgUrl, 10, false);
            }
            if (aVar.duration > 3) {
                this.duration = aVar.duration * 1000;
            }
            this.alA = (float) aVar.opacity;
            ahd();
            return this;
        }
        return this;
    }

    private h ahb() {
        this.mContentView.setText(this.mContext.getResources().getString(R.string.task_already_finish));
        this.bOC.setText(this.mContext.getResources().getString(R.string.back));
        am.f(this.mContentView, R.color.cp_link_tip_a, 1);
        am.f(this.bOC, R.color.cp_cont_a, 1);
        ahd();
        return this;
    }

    public h ahc() {
        if (this.mContext != null) {
            this.mWindowManager.addView(this.mRootView, this.mLayoutParams);
            com.baidu.adp.lib.g.e.iK().removeCallbacks(this.mHideRunnable);
            com.baidu.adp.lib.g.e.iK().postDelayed(this.mHideRunnable, this.duration);
            if (this.mData != null) {
                TiebaStatic.log(new an("c13317").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mData.activityId).P("obj_type", this.mData.missionId));
            }
        }
        return this;
    }

    public void hide() {
        if (this.mContext != null) {
            if (this.mRootView.getWindowToken() != null) {
                this.mWindowManager.removeView(this.mRootView);
            }
            com.baidu.adp.lib.g.e.iK().removeCallbacks(this.mHideRunnable);
        }
        this.mContext = null;
    }

    private void ahd() {
        this.mLayoutParams.y = this.zR;
        this.mLayoutParams.alpha = this.alA;
    }

    private void ahe() {
        this.mLayoutParams = new WindowManager.LayoutParams();
        this.mLayoutParams.width = com.baidu.adp.lib.util.l.af(this.mContext) - (this.zQ * 2);
        this.mLayoutParams.height = com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds196);
        this.mLayoutParams.type = 1000;
        this.mLayoutParams.format = -3;
        this.mLayoutParams.windowAnimations = R.style.new_complete_task_toast;
        this.mLayoutParams.flags = 262152;
        this.mLayoutParams.gravity = 81;
    }

    private StateListDrawable mU(String str) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.shape_new_complete_toast_btn_bg_pressed);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds10));
        gradientDrawable.setColor(com.baidu.tieba.lego.card.d.a.cE(str));
        stateListDrawable.addState(new int[]{16842919}, drawable);
        stateListDrawable.addState(new int[0], gradientDrawable);
        return stateListDrawable;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mData != null) {
            if (this.mData.bAM == com.baidu.tbadk.BdToken.completeTask.a.bAK) {
                if (!UtilHelper.dealOneScheme(TbadkCoreApplication.getInst().getCurrentActivity(), this.mData.schema) && !aq.isEmpty(this.mData.url)) {
                    lv(this.mData.url);
                }
            } else if (this.mData.bAM == com.baidu.tbadk.BdToken.completeTask.a.bAL && !aq.isEmpty(this.mData.url)) {
                lv(this.mData.url);
            }
            TiebaStatic.log(new an("c13318").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mData.activityId).P("obj_type", this.mData.missionId));
        }
    }

    private void lv(String str) {
        TbPageContext<?> Y;
        if (!aq.isEmpty(str) && (Y = Y(TbadkCoreApplication.getInst().getCurrentActivity())) != null) {
            ba.ajK().c(Y, new String[]{str});
        }
    }

    private TbPageContext Y(Activity activity) {
        if (activity instanceof BaseActivity) {
            return ((BaseActivity) activity).getPageContext();
        }
        if (activity instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) activity).getPageContext();
        }
        return null;
    }
}

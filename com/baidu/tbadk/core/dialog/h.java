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
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    private TextView bOd;
    private TbImageView bOe;
    private TextView mContentView;
    private Context mContext;
    private com.baidu.tbadk.BdToken.completeTask.a mData;
    private Runnable mHideRunnable;
    private WindowManager.LayoutParams mLayoutParams;
    private ViewGroup mRootView;
    private WindowManager mWindowManager;
    private int zQ;
    private int zR;
    private float alb = 1.0f;
    private int duration = 3000;

    private h(Context context) {
        if (context != null) {
            this.mContext = context;
            this.mRootView = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.new_task_completed_toast_layout, (ViewGroup) null);
            this.mContentView = (TextView) this.mRootView.findViewById(R.id.toast_message_content);
            this.bOd = (TextView) this.mRootView.findViewById(R.id.toast_btn);
            this.bOd.setOnClickListener(this);
            this.bOe = (TbImageView) this.mRootView.findViewById(R.id.toast_bg);
            this.bOe.setDefaultBgResource(R.drawable.shape_new_complete_toast_bg);
            this.bOe.setDrawCorner(true);
            this.bOe.setConrers(15);
            this.bOe.setRadius(com.baidu.adp.lib.util.l.g(context, R.dimen.tbds20));
            this.zR = com.baidu.adp.lib.util.l.g(context, R.dimen.tbds176);
            this.zQ = com.baidu.adp.lib.util.l.g(context, R.dimen.tbds29);
            am.k(this.mRootView, R.drawable.layerlist_new_complete_task_toast_shadow);
            this.mWindowManager = (WindowManager) this.mContext.getSystemService("window");
            aha();
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
                return agX();
            }
            this.mData = aVar;
            if (aq.isEmpty(aVar.message)) {
                this.mContentView.setText(this.mContext.getResources().getString(R.string.task_already_finish));
            } else {
                this.mContentView.setText(aVar.message);
            }
            if (aq.isEmpty(aVar.btnText)) {
                this.bOd.setText(this.mContext.getResources().getString(R.string.back));
            } else {
                this.bOd.setText(aVar.btnText);
            }
            if (aq.isEmpty(aVar.message_color)) {
                am.f(this.mContentView, R.color.cp_link_tip_a, 1);
            } else {
                this.mContentView.setTextColor(com.baidu.tieba.lego.card.d.a.cE(aVar.message_color));
            }
            if (aq.isEmpty(aVar.btn_text_color)) {
                am.f(this.bOd, R.color.cp_btn_a, 1);
            } else {
                this.bOd.setTextColor(com.baidu.tieba.lego.card.d.a.cE(aVar.btn_text_color));
            }
            if (!aq.isEmpty(aVar.btn_color)) {
                this.bOd.setBackgroundDrawable(mS(aVar.btn_color));
            }
            if (!aq.isEmpty(aVar.imgUrl)) {
                this.bOe.startLoad(aVar.imgUrl, 10, false);
            }
            if (aVar.duration > 3) {
                this.duration = aVar.duration * 1000;
            }
            this.alb = (float) aVar.opacity;
            agZ();
            return this;
        }
        return this;
    }

    private h agX() {
        this.mContentView.setText(this.mContext.getResources().getString(R.string.task_already_finish));
        this.bOd.setText(this.mContext.getResources().getString(R.string.back));
        am.f(this.mContentView, R.color.cp_link_tip_a, 1);
        am.f(this.bOd, R.color.cp_btn_a, 1);
        agZ();
        return this;
    }

    public h agY() {
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

    private void agZ() {
        this.mLayoutParams.y = this.zR;
        this.mLayoutParams.alpha = this.alb;
    }

    private void aha() {
        this.mLayoutParams = new WindowManager.LayoutParams();
        this.mLayoutParams.width = com.baidu.adp.lib.util.l.af(this.mContext) - (this.zQ * 2);
        this.mLayoutParams.height = com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds196);
        this.mLayoutParams.type = 1000;
        this.mLayoutParams.format = -3;
        this.mLayoutParams.windowAnimations = R.style.new_complete_task_toast;
        this.mLayoutParams.flags = 262152;
        this.mLayoutParams.gravity = 81;
    }

    private StateListDrawable mS(String str) {
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
            if (this.mData.bAo == com.baidu.tbadk.BdToken.completeTask.a.bAm) {
                if (!UtilHelper.dealOneScheme(TbadkCoreApplication.getInst().getCurrentActivity(), this.mData.schema) && !aq.isEmpty(this.mData.url)) {
                    lt(this.mData.url);
                }
            } else if (this.mData.bAo == com.baidu.tbadk.BdToken.completeTask.a.bAn && !aq.isEmpty(this.mData.url)) {
                lt(this.mData.url);
            }
            TiebaStatic.log(new an("c13318").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mData.activityId).P("obj_type", this.mData.missionId));
        }
    }

    private void lt(String str) {
        TbPageContext<?> Y;
        if (!aq.isEmpty(str) && (Y = Y(TbadkCoreApplication.getInst().getCurrentActivity())) != null) {
            bb.ajE().c(Y, new String[]{str});
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

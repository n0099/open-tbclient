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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    private TextView bMX;
    private TbImageView bMY;
    private TextView mContentView;
    private Context mContext;
    private com.baidu.tbadk.BdToken.completeTask.a mData;
    private Runnable mHideRunnable;
    private WindowManager.LayoutParams mLayoutParams;
    private ViewGroup mRootView;
    private WindowManager mWindowManager;
    private int zK;
    private int zL;
    private float alpha = 1.0f;
    private int duration = 3000;

    private h(Context context) {
        if (context != null) {
            this.mContext = context;
            this.mRootView = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.new_task_completed_toast_layout, (ViewGroup) null);
            this.mContentView = (TextView) this.mRootView.findViewById(R.id.toast_message_content);
            this.bMX = (TextView) this.mRootView.findViewById(R.id.toast_btn);
            this.bMX.setOnClickListener(this);
            this.bMY = (TbImageView) this.mRootView.findViewById(R.id.toast_bg);
            this.bMY.setDefaultBgResource(R.drawable.shape_new_complete_toast_bg);
            this.bMY.setDrawCorner(true);
            this.bMY.setConrers(15);
            this.bMY.setRadius(com.baidu.adp.lib.util.l.g(context, R.dimen.tbds20));
            this.zL = com.baidu.adp.lib.util.l.g(context, R.dimen.tbds176);
            this.zK = com.baidu.adp.lib.util.l.g(context, R.dimen.tbds29);
            al.k(this.mRootView, R.drawable.layerlist_new_complete_task_toast_shadow);
            this.mWindowManager = (WindowManager) this.mContext.getSystemService("window");
            afW();
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
                return afT();
            }
            this.mData = aVar;
            if (ap.isEmpty(aVar.message)) {
                this.mContentView.setText(this.mContext.getResources().getString(R.string.task_already_finish));
            } else {
                this.mContentView.setText(aVar.message);
            }
            if (ap.isEmpty(aVar.btnText)) {
                this.bMX.setText(this.mContext.getResources().getString(R.string.back));
            } else {
                this.bMX.setText(aVar.btnText);
            }
            if (ap.isEmpty(aVar.message_color)) {
                al.f(this.mContentView, R.color.cp_link_tip_a, 1);
            } else {
                this.mContentView.setTextColor(com.baidu.tieba.lego.card.d.a.parseColor(aVar.message_color));
            }
            if (ap.isEmpty(aVar.btn_text_color)) {
                al.f(this.bMX, R.color.cp_btn_a, 1);
            } else {
                this.bMX.setTextColor(com.baidu.tieba.lego.card.d.a.parseColor(aVar.btn_text_color));
            }
            if (!ap.isEmpty(aVar.btn_color)) {
                this.bMX.setBackgroundDrawable(mH(aVar.btn_color));
            }
            if (!ap.isEmpty(aVar.imgUrl)) {
                this.bMY.startLoad(aVar.imgUrl, 10, false);
            }
            if (aVar.duration > 3) {
                this.duration = aVar.duration * 1000;
            }
            this.alpha = (float) aVar.opacity;
            afV();
            return this;
        }
        return this;
    }

    private h afT() {
        this.mContentView.setText(this.mContext.getResources().getString(R.string.task_already_finish));
        this.bMX.setText(this.mContext.getResources().getString(R.string.back));
        al.f(this.mContentView, R.color.cp_link_tip_a, 1);
        al.f(this.bMX, R.color.cp_btn_a, 1);
        afV();
        return this;
    }

    public h afU() {
        if (this.mContext != null) {
            this.mWindowManager.addView(this.mRootView, this.mLayoutParams);
            com.baidu.adp.lib.g.e.iB().removeCallbacks(this.mHideRunnable);
            com.baidu.adp.lib.g.e.iB().postDelayed(this.mHideRunnable, this.duration);
            if (this.mData != null) {
                TiebaStatic.log(new am("c13317").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mData.activityId).P("obj_type", this.mData.missionId));
            }
        }
        return this;
    }

    public void hide() {
        if (this.mContext != null) {
            if (this.mRootView.getWindowToken() != null) {
                this.mWindowManager.removeView(this.mRootView);
            }
            com.baidu.adp.lib.g.e.iB().removeCallbacks(this.mHideRunnable);
        }
        this.mContext = null;
    }

    private void afV() {
        this.mLayoutParams.y = this.zL;
        this.mLayoutParams.alpha = this.alpha;
    }

    private void afW() {
        this.mLayoutParams = new WindowManager.LayoutParams();
        this.mLayoutParams.width = com.baidu.adp.lib.util.l.af(this.mContext) - (this.zK * 2);
        this.mLayoutParams.height = com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds196);
        this.mLayoutParams.type = 1000;
        this.mLayoutParams.format = -3;
        this.mLayoutParams.windowAnimations = R.style.new_complete_task_toast;
        this.mLayoutParams.flags = 262152;
        this.mLayoutParams.gravity = 81;
    }

    private StateListDrawable mH(String str) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.shape_new_complete_toast_btn_bg_pressed);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds10));
        gradientDrawable.setColor(com.baidu.tieba.lego.card.d.a.parseColor(str));
        stateListDrawable.addState(new int[]{16842919}, drawable);
        stateListDrawable.addState(new int[0], gradientDrawable);
        return stateListDrawable;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mData != null) {
            if (this.mData.bzr == com.baidu.tbadk.BdToken.completeTask.a.bzp) {
                if (!UtilHelper.dealOneScheme(TbadkCoreApplication.getInst().getCurrentActivity(), this.mData.schema) && !ap.isEmpty(this.mData.url)) {
                    ll(this.mData.url);
                }
            } else if (this.mData.bzr == com.baidu.tbadk.BdToken.completeTask.a.bzq && !ap.isEmpty(this.mData.url)) {
                ll(this.mData.url);
            }
            TiebaStatic.log(new am("c13318").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mData.activityId).P("obj_type", this.mData.missionId));
        }
    }

    private void ll(String str) {
        TbPageContext<?> V;
        if (!ap.isEmpty(str) && (V = V(TbadkCoreApplication.getInst().getCurrentActivity())) != null) {
            ba.aiz().c(V, new String[]{str});
        }
    }

    private TbPageContext V(Activity activity) {
        if (activity instanceof BaseActivity) {
            return ((BaseActivity) activity).getPageContext();
        }
        if (activity instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) activity).getPageContext();
        }
        return null;
    }
}

package com.baidu.tbadk.BdToken;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
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
import com.baidu.tieba.d;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes.dex */
public class o {
    private NavigationBarCoverTip bso;
    private TextView bsp;
    private TextView bsq;
    private int bsr = 3000;
    private View mContentView;
    private com.baidu.tbadk.BdToken.completeTask.a mData;

    public void a(com.baidu.tbadk.BdToken.completeTask.a aVar) {
        this.mData = aVar;
    }

    public void show() {
        if (this.mData != null) {
            if (this.mData.showType == com.baidu.tbadk.BdToken.completeTask.a.bsu) {
                IK();
            } else {
                if (this.mData.showType == com.baidu.tbadk.BdToken.completeTask.a.bsv) {
                }
            }
        }
    }

    public void clearData() {
        if (this.bso != null) {
            this.bso.onDestroy();
        }
    }

    private void IK() {
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (currentActivity != null && this.mData != null) {
            this.bso = new NavigationBarCoverTip(currentActivity);
            this.bso.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
            ((FrameLayout) currentActivity.findViewById(16908290)).addView(this.bso);
            this.mContentView = LayoutInflater.from(currentActivity).inflate(d.h.task_completed_toast_layout, (ViewGroup) null);
            this.bsp = (TextView) this.mContentView.findViewById(d.g.task_completed_tip);
            this.bsq = (TextView) this.mContentView.findViewById(d.g.task_completed_button);
            al.j(this.bsp, d.C0277d.cp_cont_i);
            al.j(this.bsq, d.C0277d.cp_cont_i);
            al.k(this.bsq, d.f.share_now_bg);
            al.l(this.bso, d.C0277d.cp_link_tip_a_alpha95);
            if (this.bsp != null && !ap.isEmpty(this.mData.message)) {
                this.bsp.setText(this.mData.message);
            }
            if (this.bsq != null && !ap.isEmpty(this.mData.btnText)) {
                this.bsq.setText(this.mData.btnText);
                this.bsq.setVisibility(0);
                this.bsq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.BdToken.o.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        o.this.UB();
                        if (o.this.bso != null) {
                            o.this.bso.hideTip();
                        }
                        if (o.this.mData != null) {
                            TiebaStatic.log(new am("c13318").T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, o.this.mData.activityId).T("obj_type", o.this.mData.bsy));
                        }
                    }
                });
            }
            if (!ap.isEmpty(this.mData.token)) {
                com.baidu.adp.lib.util.a.bh(this.mData.token);
            }
            if (this.mData.duration == 0) {
                this.bsr = 3000;
            } else {
                this.bsr = this.mData.duration * 1000;
            }
            if (this.bso != null && currentActivity != null && this.mContentView != null) {
                TiebaStatic.log(new am("c13317").T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mData.activityId).T("obj_type", this.mData.bsy));
                this.bso.a(currentActivity, this.mContentView, this.bsr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UB() {
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        TbPageContext<?> T = T(currentActivity);
        if (currentActivity != null && T != null && this.mData != null) {
            if (this.mData.bsz == com.baidu.tbadk.BdToken.completeTask.a.bsw) {
                if (!UtilHelper.dealOneScheme(currentActivity, this.mData.schema) && !ap.isEmpty(this.mData.url)) {
                    ba.adD().c(T, new String[]{this.mData.url});
                }
            } else if (this.mData.bsz == com.baidu.tbadk.BdToken.completeTask.a.bsx && T != null && !ap.isEmpty(this.mData.url)) {
                ba.adD().c(T, new String[]{this.mData.url});
            }
        }
    }

    private TbPageContext T(Activity activity) {
        if (activity instanceof BaseActivity) {
            return ((BaseActivity) activity).getPageContext();
        }
        if (activity instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) activity).getPageContext();
        }
        return null;
    }
}

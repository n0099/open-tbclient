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
    private NavigationBarCoverTip bsn;
    private TextView bso;
    private TextView bsp;
    private int bsq = 3000;
    private View mContentView;
    private com.baidu.tbadk.BdToken.completeTask.a mData;

    public void a(com.baidu.tbadk.BdToken.completeTask.a aVar) {
        this.mData = aVar;
    }

    public void show() {
        if (this.mData != null) {
            if (this.mData.showType == com.baidu.tbadk.BdToken.completeTask.a.bst) {
                IK();
            } else {
                if (this.mData.showType == com.baidu.tbadk.BdToken.completeTask.a.bsu) {
                }
            }
        }
    }

    public void clearData() {
        if (this.bsn != null) {
            this.bsn.onDestroy();
        }
    }

    private void IK() {
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (currentActivity != null && this.mData != null) {
            this.bsn = new NavigationBarCoverTip(currentActivity);
            this.bsn.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
            ((FrameLayout) currentActivity.findViewById(16908290)).addView(this.bsn);
            this.mContentView = LayoutInflater.from(currentActivity).inflate(d.h.task_completed_toast_layout, (ViewGroup) null);
            this.bso = (TextView) this.mContentView.findViewById(d.g.task_completed_tip);
            this.bsp = (TextView) this.mContentView.findViewById(d.g.task_completed_button);
            al.j(this.bso, d.C0236d.cp_cont_i);
            al.j(this.bsp, d.C0236d.cp_cont_i);
            al.k(this.bsp, d.f.share_now_bg);
            al.l(this.bsn, d.C0236d.cp_link_tip_a_alpha95);
            if (this.bso != null && !ap.isEmpty(this.mData.message)) {
                this.bso.setText(this.mData.message);
            }
            if (this.bsp != null && !ap.isEmpty(this.mData.btnText)) {
                this.bsp.setText(this.mData.btnText);
                this.bsp.setVisibility(0);
                this.bsp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.BdToken.o.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        o.this.UB();
                        if (o.this.bsn != null) {
                            o.this.bsn.hideTip();
                        }
                        if (o.this.mData != null) {
                            TiebaStatic.log(new am("c13318").T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, o.this.mData.activityId).T("obj_type", o.this.mData.bsx));
                        }
                    }
                });
            }
            if (!ap.isEmpty(this.mData.token)) {
                com.baidu.adp.lib.util.a.bh(this.mData.token);
            }
            if (this.mData.duration == 0) {
                this.bsq = 3000;
            } else {
                this.bsq = this.mData.duration * 1000;
            }
            if (this.bsn != null && currentActivity != null && this.mContentView != null) {
                TiebaStatic.log(new am("c13317").T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mData.activityId).T("obj_type", this.mData.bsx));
                this.bsn.a(currentActivity, this.mContentView, this.bsq);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UB() {
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        TbPageContext<?> T = T(currentActivity);
        if (currentActivity != null && T != null && this.mData != null) {
            if (this.mData.bsy == com.baidu.tbadk.BdToken.completeTask.a.bsv) {
                if (!UtilHelper.dealOneScheme(currentActivity, this.mData.schema) && !ap.isEmpty(this.mData.url)) {
                    ba.adD().c(T, new String[]{this.mData.url});
                }
            } else if (this.mData.bsy == com.baidu.tbadk.BdToken.completeTask.a.bsw && T != null && !ap.isEmpty(this.mData.url)) {
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

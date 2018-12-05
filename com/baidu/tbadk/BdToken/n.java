package com.baidu.tbadk.BdToken;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.e;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes.dex */
public class n {
    private NavigationBarCoverTip alo;
    private TextView alp;
    private TextView alq;
    private int alr = 3000;
    private Activity mActivity;
    private View mContentView;
    private com.baidu.tbadk.BdToken.completeTask.a mData;
    private TbPageContext mPageContext;

    public void a(com.baidu.tbadk.BdToken.completeTask.a aVar) {
        this.mActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        this.mPageContext = TbadkCoreApplication.getInst().getCurrentActivityPageContext();
        this.mData = aVar;
    }

    public void show() {
        if (this.mData != null) {
            if (this.mData.showType == com.baidu.tbadk.BdToken.completeTask.a.alu) {
                showToast();
            } else {
                if (this.mData.showType == com.baidu.tbadk.BdToken.completeTask.a.alv) {
                }
            }
        }
    }

    public void clearData() {
        this.mActivity = null;
        this.mPageContext = null;
        this.mData = null;
        if (this.alo != null) {
            this.alo.onDestroy();
        }
    }

    private void showToast() {
        if (this.mActivity != null && this.mData != null) {
            this.alo = new NavigationBarCoverTip(this.mActivity);
            this.alo.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
            ((FrameLayout) this.mActivity.findViewById(16908290)).addView(this.alo);
            this.mContentView = LayoutInflater.from(this.mActivity).inflate(e.h.task_completed_toast_layout, (ViewGroup) null);
            this.alp = (TextView) this.mContentView.findViewById(e.g.task_completed_tip);
            this.alq = (TextView) this.mContentView.findViewById(e.g.task_completed_button);
            al.h(this.alp, e.d.cp_cont_i);
            al.h(this.alq, e.d.cp_cont_i);
            al.i(this.alq, e.f.share_now_bg);
            al.j(this.alo, e.d.cp_link_tip_a_alpha95);
            if (this.alp != null && !ao.isEmpty(this.mData.message)) {
                this.alp.setText(this.mData.message);
            }
            if (this.alq != null && !ao.isEmpty(this.mData.btnText)) {
                this.alq.setText(this.mData.btnText);
                this.alq.setVisibility(0);
                this.alq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.BdToken.n.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TiebaStatic.log(new am("c13318").x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, n.this.mData.activityId).x("obj_type", n.this.mData.aly));
                        n.this.vT();
                        n.this.alo.hideTip();
                    }
                });
            }
            if (!ao.isEmpty(this.mData.token)) {
                com.baidu.adp.lib.util.a.bg(this.mData.token);
            }
            if (this.mData.duration == 0) {
                this.alr = 3000;
            } else {
                this.alr = this.mData.duration * 1000;
            }
            if (this.alo != null && this.mActivity != null && this.mContentView != null) {
                TiebaStatic.log(new am("c13317").x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mData.activityId).x("obj_type", this.mData.aly));
                this.alo.a(this.mActivity, this.mContentView, this.alr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vT() {
        if (this.mData != null) {
            if (this.mData.alz == com.baidu.tbadk.BdToken.completeTask.a.alw) {
                if (!UtilHelper.dealOneScheme(this.mActivity, this.mData.schema) && !ao.isEmpty(this.mData.url)) {
                    ay.Ef().c(TbadkCoreApplication.getInst().getCurrentActivityPageContext(), new String[]{this.mData.url});
                }
            } else if (this.mData.alz == com.baidu.tbadk.BdToken.completeTask.a.alx && this.mPageContext != null && !ao.isEmpty(this.mData.url)) {
                ay.Ef().c(TbadkCoreApplication.getInst().getCurrentActivityPageContext(), new String[]{this.mData.url});
            }
        }
    }
}

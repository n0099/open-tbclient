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
    private NavigationBarCoverTip bsr;
    private TextView bss;
    private TextView bst;
    private int bsu = 3000;
    private View mContentView;
    private com.baidu.tbadk.BdToken.completeTask.a mData;

    public void a(com.baidu.tbadk.BdToken.completeTask.a aVar) {
        this.mData = aVar;
    }

    public void show() {
        if (this.mData != null) {
            if (this.mData.showType == com.baidu.tbadk.BdToken.completeTask.a.bsx) {
                II();
            } else {
                if (this.mData.showType == com.baidu.tbadk.BdToken.completeTask.a.bsy) {
                }
            }
        }
    }

    public void clearData() {
        if (this.bsr != null) {
            this.bsr.onDestroy();
        }
    }

    private void II() {
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (currentActivity != null && this.mData != null) {
            this.bsr = new NavigationBarCoverTip(currentActivity);
            this.bsr.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
            ((FrameLayout) currentActivity.findViewById(16908290)).addView(this.bsr);
            this.mContentView = LayoutInflater.from(currentActivity).inflate(d.h.task_completed_toast_layout, (ViewGroup) null);
            this.bss = (TextView) this.mContentView.findViewById(d.g.task_completed_tip);
            this.bst = (TextView) this.mContentView.findViewById(d.g.task_completed_button);
            al.j(this.bss, d.C0277d.cp_cont_i);
            al.j(this.bst, d.C0277d.cp_cont_i);
            al.k(this.bst, d.f.share_now_bg);
            al.l(this.bsr, d.C0277d.cp_link_tip_a_alpha95);
            if (this.bss != null && !ap.isEmpty(this.mData.message)) {
                this.bss.setText(this.mData.message);
            }
            if (this.bst != null && !ap.isEmpty(this.mData.btnText)) {
                this.bst.setText(this.mData.btnText);
                this.bst.setVisibility(0);
                this.bst.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.BdToken.o.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        o.this.Uy();
                        if (o.this.bsr != null) {
                            o.this.bsr.hideTip();
                        }
                        if (o.this.mData != null) {
                            TiebaStatic.log(new am("c13318").T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, o.this.mData.activityId).T("obj_type", o.this.mData.bsB));
                        }
                    }
                });
            }
            if (!ap.isEmpty(this.mData.token)) {
                com.baidu.adp.lib.util.a.bh(this.mData.token);
            }
            if (this.mData.duration == 0) {
                this.bsu = 3000;
            } else {
                this.bsu = this.mData.duration * 1000;
            }
            if (this.bsr != null && currentActivity != null && this.mContentView != null) {
                TiebaStatic.log(new am("c13317").T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mData.activityId).T("obj_type", this.mData.bsB));
                this.bsr.a(currentActivity, this.mContentView, this.bsu);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uy() {
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        TbPageContext<?> T = T(currentActivity);
        if (currentActivity != null && T != null && this.mData != null) {
            if (this.mData.bsC == com.baidu.tbadk.BdToken.completeTask.a.bsz) {
                if (!UtilHelper.dealOneScheme(currentActivity, this.mData.schema) && !ap.isEmpty(this.mData.url)) {
                    ba.adA().c(T, new String[]{this.mData.url});
                }
            } else if (this.mData.bsC == com.baidu.tbadk.BdToken.completeTask.a.bsA && T != null && !ap.isEmpty(this.mData.url)) {
                ba.adA().c(T, new String[]{this.mData.url});
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

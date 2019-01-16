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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.e;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes.dex */
public class o {
    private NavigationBarCoverTip alI;
    private TextView alJ;
    private TextView alK;
    private int alL = 3000;
    private View mContentView;
    private com.baidu.tbadk.BdToken.completeTask.a mData;

    public void a(com.baidu.tbadk.BdToken.completeTask.a aVar) {
        this.mData = aVar;
    }

    public void show() {
        if (this.mData != null) {
            if (this.mData.showType == com.baidu.tbadk.BdToken.completeTask.a.alO) {
                showToast();
            } else {
                if (this.mData.showType == com.baidu.tbadk.BdToken.completeTask.a.alP) {
                }
            }
        }
    }

    public void clearData() {
        this.mData = null;
        if (this.alI != null) {
            this.alI.onDestroy();
        }
    }

    private void showToast() {
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (currentActivity != null && this.mData != null) {
            this.alI = new NavigationBarCoverTip(currentActivity);
            this.alI.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
            ((FrameLayout) currentActivity.findViewById(16908290)).addView(this.alI);
            this.mContentView = LayoutInflater.from(currentActivity).inflate(e.h.task_completed_toast_layout, (ViewGroup) null);
            this.alJ = (TextView) this.mContentView.findViewById(e.g.task_completed_tip);
            this.alK = (TextView) this.mContentView.findViewById(e.g.task_completed_button);
            al.h(this.alJ, e.d.cp_cont_i);
            al.h(this.alK, e.d.cp_cont_i);
            al.i(this.alK, e.f.share_now_bg);
            al.j(this.alI, e.d.cp_link_tip_a_alpha95);
            if (this.alJ != null && !ao.isEmpty(this.mData.message)) {
                this.alJ.setText(this.mData.message);
            }
            if (this.alK != null && !ao.isEmpty(this.mData.btnText)) {
                this.alK.setText(this.mData.btnText);
                this.alK.setVisibility(0);
                this.alK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.BdToken.o.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TiebaStatic.log(new am("c13318").y(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, o.this.mData.activityId).y("obj_type", o.this.mData.alS));
                        o.this.wa();
                        if (o.this.alI != null) {
                            o.this.alI.hideTip();
                        }
                    }
                });
            }
            if (!ao.isEmpty(this.mData.token)) {
                com.baidu.adp.lib.util.a.bg(this.mData.token);
            }
            if (this.mData.duration == 0) {
                this.alL = 3000;
            } else {
                this.alL = this.mData.duration * 1000;
            }
            if (this.alI != null && currentActivity != null && this.mContentView != null) {
                TiebaStatic.log(new am("c13317").y(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mData.activityId).y("obj_type", this.mData.alS));
                this.alI.a(currentActivity, this.mContentView, this.alL);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wa() {
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        TbPageContext<?> w = w(currentActivity);
        if (currentActivity != null && w != null && this.mData != null) {
            if (this.mData.alT == com.baidu.tbadk.BdToken.completeTask.a.alQ) {
                if (!UtilHelper.dealOneScheme(currentActivity, this.mData.schema) && !ao.isEmpty(this.mData.url)) {
                    ay.Es().c(w, new String[]{this.mData.url});
                }
            } else if (this.mData.alT == com.baidu.tbadk.BdToken.completeTask.a.alR && w != null && !ao.isEmpty(this.mData.url)) {
                ay.Es().c(w, new String[]{this.mData.url});
            }
        }
    }

    private TbPageContext w(Activity activity) {
        if (activity instanceof BaseActivity) {
            return ((BaseActivity) activity).getPageContext();
        }
        if (activity instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) activity).getPageContext();
        }
        return null;
    }
}

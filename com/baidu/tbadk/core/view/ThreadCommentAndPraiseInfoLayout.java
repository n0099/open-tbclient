package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
import tbclient.ReportInfo;
/* loaded from: classes.dex */
public class ThreadCommentAndPraiseInfoLayout extends LinearLayout {
    private bj ain;
    private TbPageContext ajF;
    private TextView alA;
    private FrameLayout alB;
    private List<CharSequence> alC;
    private List<String> alD;
    private boolean alE;
    private boolean alF;
    private boolean alG;
    private boolean alH;
    private boolean alI;
    private boolean alJ;
    private String alK;
    private String alL;
    private View.OnClickListener alM;
    private View.OnClickListener alN;
    private View.OnClickListener alO;
    private CustomMessageListener alP;
    private TextView alt;
    private TextView alu;
    private View alv;
    private TextView alw;
    private TextView alx;
    private TextView aly;
    private TextView alz;
    private Context mContext;
    private int mFrom;

    public void setYuelaouLocate(String str) {
        this.alL = str;
    }

    public void setStType(String str) {
        this.alK = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.alE = false;
        this.alF = false;
        this.alG = true;
        this.alH = true;
        this.alI = true;
        this.alJ = false;
        this.mFrom = 1;
        this.alN = new ah(this);
        this.alO = new ai(this);
        this.alP = new aj(this, CmdConfigCustom.PB_ACTION_PRAISE);
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.alE = false;
        this.alF = false;
        this.alG = true;
        this.alH = true;
        this.alI = true;
        this.alJ = false;
        this.mFrom = 1;
        this.alN = new ah(this);
        this.alO = new ai(this);
        this.alP = new aj(this, CmdConfigCustom.PB_ACTION_PRAISE);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(w.j.thread_comment_and_praise_info_layout, (ViewGroup) this, true);
        this.alt = (TextView) inflate.findViewById(w.h.thread_info_bar_name);
        this.alu = (TextView) inflate.findViewById(w.h.thread_info_reply_time);
        this.alv = inflate.findViewById(w.h.frs_item_location_sep);
        this.alw = (TextView) inflate.findViewById(w.h.frs_item_location_address);
        this.alx = (TextView) inflate.findViewById(w.h.thread_info_praise_num);
        this.aly = (TextView) inflate.findViewById(w.h.thread_info_commont_num);
        this.alz = (TextView) inflate.findViewById(w.h.thread_info_view_num);
        this.alA = (TextView) inflate.findViewById(w.h.thread_info_more);
        this.alB = (FrameLayout) inflate.findViewById(w.h.thread_info_more_frame);
        this.mContext = context;
    }

    public void setShowPraiseNum(boolean z) {
        this.alG = z;
    }

    public void setBarNameClickEnabled(boolean z) {
        this.alI = z;
        if (this.alt != null) {
            this.alt.setClickable(this.alI);
        }
    }

    public boolean wT() {
        return this.alB != null && this.alB.getVisibility() == 0;
    }

    public boolean a(bj bjVar) {
        if (bjVar == null) {
            setVisibility(8);
            return false;
        }
        this.ain = bjVar;
        b(bjVar);
        c(bjVar);
        d(bjVar);
        g(bjVar);
        f(bjVar);
        e(bjVar);
        setVisibility(this.alE ? 0 : 8);
        return this.alE;
    }

    private void b(bj bjVar) {
        if (this.alt != null && bjVar != null) {
            if (!StringUtils.isNull(bjVar.rV())) {
                this.alt.setVisibility(0);
                String string = getContext().getString(w.l.chosen_pb_original_bar, UtilHelper.getFixedBarText(bjVar.rV(), 5, true));
                this.alt.setText(string);
                this.alt.setContentDescription(string);
                this.alt.setOnClickListener(this.alN);
                this.alt.setClickable(this.alI);
                this.alE = true;
                return;
            }
            this.alt.setVisibility(8);
        }
    }

    private void c(bj bjVar) {
        String r;
        if (this.alu != null && bjVar != null) {
            if (bjVar.rL() <= 0 || !this.alH) {
                this.alu.setVisibility(8);
                return;
            }
            this.alu.setVisibility(0);
            if (this.mFrom == 2) {
                r = com.baidu.tbadk.core.util.au.p(bjVar.rL());
            } else {
                r = com.baidu.tbadk.core.util.au.r(bjVar.rL() * 1000);
            }
            this.alu.setText(r);
            this.alE = true;
        }
    }

    private void d(bj bjVar) {
        if (this.alw != null && this.alv != null && bjVar != null) {
            if (this.alF && !bjVar.sv() && !StringUtils.isNull(bjVar.getAddress())) {
                this.alw.setVisibility(0);
                if (bjVar.rL() <= 0) {
                    this.alv.setVisibility(8);
                } else {
                    this.alv.setVisibility(0);
                }
                this.alw.setText(bjVar.getAddress());
                this.alE = true;
                return;
            }
            this.alw.setVisibility(8);
            this.alv.setVisibility(8);
        }
    }

    private void e(bj bjVar) {
        if (this.aly != null && bjVar != null) {
            if (bjVar.rJ() > 0) {
                this.aly.setVisibility(0);
                String t = com.baidu.tbadk.core.util.au.t(bjVar.rJ());
                this.aly.setText(String.format(this.mContext.getString(w.l.reply_num_tip), t));
                this.aly.setContentDescription(String.valueOf(this.mContext.getString(w.l.reply_num)) + t);
                this.alE = true;
                return;
            }
            this.aly.setVisibility(8);
        }
    }

    public void f(bj bjVar) {
        if (this.alx != null && bjVar != null) {
            this.alx.setVisibility(8);
        }
    }

    private void g(bj bjVar) {
        if (this.alz != null && bjVar != null) {
            if (this.alJ && bjVar.rK() > 0) {
                this.alz.setVisibility(0);
                String t = com.baidu.tbadk.core.util.au.t(bjVar.rK());
                this.alz.setText(String.format(this.mContext.getString(w.l.view_num_tip), t));
                this.alz.setContentDescription(String.valueOf(this.mContext.getString(w.l.view_num)) + t);
                this.alE = true;
                return;
            }
            this.alz.setVisibility(8);
        }
    }

    public void e(TbPageContext tbPageContext) {
        this.ajF = tbPageContext;
        if (this.alB != null) {
            if (this.ain == null || com.baidu.tbadk.core.util.x.q(this.ain.sS()) || !TbadkCoreApplication.isLogin() || this.ain.sT()) {
                this.alB.setVisibility(8);
                return;
            }
            if (this.alC == null) {
                this.alC = new ArrayList();
            } else {
                this.alC.clear();
            }
            if (this.alD == null) {
                this.alD = new ArrayList();
            } else {
                this.alD.clear();
            }
            boolean z = false;
            for (ReportInfo reportInfo : this.ain.sS()) {
                if (reportInfo != null && !StringUtils.isNull(reportInfo.info) && !StringUtils.isNull(reportInfo.url)) {
                    z = true;
                    this.alC.add(reportInfo.info);
                    this.alD.add(reportInfo.url);
                }
            }
            if (z) {
                this.alB.setOnClickListener(this.alO);
                this.alB.setVisibility(0);
                return;
            }
            this.alB.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wU() {
        if (this.ajF != null) {
            com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(this.ajF.getPageActivity());
            cVar.bZ(w.l.operation);
            cVar.a(this.alC, new ak(this));
            cVar.d(this.ajF);
            cVar.tv();
        }
    }

    public void tD() {
        com.baidu.tbadk.core.util.aq.i((View) this.alt, w.e.cp_cont_c);
        com.baidu.tbadk.core.util.aq.i((View) this.alu, w.e.cp_cont_c);
        com.baidu.tbadk.core.util.aq.k(this.alv, w.e.cp_cont_c);
        com.baidu.tbadk.core.util.aq.i((View) this.alw, w.e.cp_cont_c);
        com.baidu.tbadk.core.util.aq.i((View) this.alx, w.e.cp_cont_c);
        com.baidu.tbadk.core.util.aq.i((View) this.alz, w.e.cp_cont_c);
        com.baidu.tbadk.core.util.aq.i((View) this.aly, w.e.cp_cont_c);
        com.baidu.tbadk.core.util.aq.j(this.alA, w.g.btn_frs_more_selector);
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.alM = onClickListener;
    }

    public TextView getBarNameTv() {
        return this.alt;
    }

    public void h(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.alP != null) {
            this.alP.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.alP);
        }
    }

    public void setLocationEnabled(boolean z) {
        this.alF = z;
    }

    public void setViewNumEnabled(boolean z) {
        this.alJ = z;
    }

    public void setReplyTimeVisible(boolean z) {
        this.alH = z;
    }

    public View getCommentNumView() {
        return this.aly;
    }

    public void setCommentNumClickListener(View.OnClickListener onClickListener) {
        this.aly.setOnClickListener(onClickListener);
    }
}

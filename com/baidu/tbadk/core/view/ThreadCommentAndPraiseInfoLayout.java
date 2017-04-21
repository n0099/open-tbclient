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
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
import tbclient.ReportInfo;
/* loaded from: classes.dex */
public class ThreadCommentAndPraiseInfoLayout extends LinearLayout {
    private bi aiC;
    private TbPageContext ajU;
    private TextView alH;
    private TextView alI;
    private View alJ;
    private TextView alK;
    private TextView alL;
    private TextView alM;
    private TextView alN;
    private TextView alO;
    private FrameLayout alP;
    private List<CharSequence> alQ;
    private List<String> alR;
    private boolean alS;
    private boolean alT;
    private boolean alU;
    private boolean alV;
    private boolean alW;
    private boolean alX;
    private String alY;
    private String alZ;
    private View.OnClickListener ama;
    private View.OnClickListener amb;
    private View.OnClickListener amc;
    private CustomMessageListener amd;
    private Context mContext;
    private int mFrom;

    public void setYuelaouLocate(String str) {
        this.alZ = str;
    }

    public void setStType(String str) {
        this.alY = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.alS = false;
        this.alT = false;
        this.alU = true;
        this.alV = true;
        this.alW = true;
        this.alX = false;
        this.mFrom = 1;
        this.amb = new ah(this);
        this.amc = new ai(this);
        this.amd = new aj(this, CmdConfigCustom.PB_ACTION_PRAISE);
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.alS = false;
        this.alT = false;
        this.alU = true;
        this.alV = true;
        this.alW = true;
        this.alX = false;
        this.mFrom = 1;
        this.amb = new ah(this);
        this.amc = new ai(this);
        this.amd = new aj(this, CmdConfigCustom.PB_ACTION_PRAISE);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(w.j.thread_comment_and_praise_info_layout, (ViewGroup) this, true);
        this.alH = (TextView) inflate.findViewById(w.h.thread_info_bar_name);
        this.alI = (TextView) inflate.findViewById(w.h.thread_info_reply_time);
        this.alJ = inflate.findViewById(w.h.frs_item_location_sep);
        this.alK = (TextView) inflate.findViewById(w.h.frs_item_location_address);
        this.alL = (TextView) inflate.findViewById(w.h.thread_info_praise_num);
        this.alM = (TextView) inflate.findViewById(w.h.thread_info_commont_num);
        this.alN = (TextView) inflate.findViewById(w.h.thread_info_view_num);
        this.alO = (TextView) inflate.findViewById(w.h.thread_info_more);
        this.alP = (FrameLayout) inflate.findViewById(w.h.thread_info_more_frame);
        this.mContext = context;
    }

    public void setShowPraiseNum(boolean z) {
        this.alU = z;
    }

    public void setBarNameClickEnabled(boolean z) {
        this.alW = z;
        if (this.alH != null) {
            this.alH.setClickable(this.alW);
        }
    }

    public boolean xp() {
        return this.alP != null && this.alP.getVisibility() == 0;
    }

    public boolean a(bi biVar) {
        if (biVar == null) {
            setVisibility(8);
            return false;
        }
        this.aiC = biVar;
        b(biVar);
        c(biVar);
        d(biVar);
        g(biVar);
        f(biVar);
        e(biVar);
        setVisibility(this.alS ? 0 : 8);
        return this.alS;
    }

    private void b(bi biVar) {
        if (this.alH != null && biVar != null) {
            if (!StringUtils.isNull(biVar.st())) {
                this.alH.setVisibility(0);
                String string = getContext().getString(w.l.chosen_pb_original_bar, UtilHelper.getFixedBarText(biVar.st(), 5, true));
                this.alH.setText(string);
                this.alH.setContentDescription(string);
                this.alH.setOnClickListener(this.amb);
                this.alH.setClickable(this.alW);
                this.alS = true;
                return;
            }
            this.alH.setVisibility(8);
        }
    }

    private void c(bi biVar) {
        String r;
        if (this.alI != null && biVar != null) {
            if (biVar.sj() <= 0 || !this.alV) {
                this.alI.setVisibility(8);
                return;
            }
            this.alI.setVisibility(0);
            if (this.mFrom == 2) {
                r = com.baidu.tbadk.core.util.au.p(biVar.sj());
            } else {
                r = com.baidu.tbadk.core.util.au.r(biVar.sj() * 1000);
            }
            this.alI.setText(r);
            this.alS = true;
        }
    }

    private void d(bi biVar) {
        if (this.alK != null && this.alJ != null && biVar != null) {
            if (this.alT && !biVar.sT() && !StringUtils.isNull(biVar.getAddress())) {
                this.alK.setVisibility(0);
                if (biVar.sj() <= 0) {
                    this.alJ.setVisibility(8);
                } else {
                    this.alJ.setVisibility(0);
                }
                this.alK.setText(biVar.getAddress());
                this.alS = true;
                return;
            }
            this.alK.setVisibility(8);
            this.alJ.setVisibility(8);
        }
    }

    private void e(bi biVar) {
        if (this.alM != null && biVar != null) {
            if (biVar.sh() > 0) {
                this.alM.setVisibility(0);
                String t = com.baidu.tbadk.core.util.au.t(biVar.sh());
                this.alM.setText(String.format(this.mContext.getString(w.l.reply_num_tip), t));
                this.alM.setContentDescription(String.valueOf(this.mContext.getString(w.l.reply_num)) + t);
                this.alS = true;
                return;
            }
            this.alM.setVisibility(8);
        }
    }

    public void f(bi biVar) {
        if (this.alL != null && biVar != null) {
            this.alL.setVisibility(8);
        }
    }

    private void g(bi biVar) {
        if (this.alN != null && biVar != null) {
            if (this.alX && biVar.si() > 0) {
                this.alN.setVisibility(0);
                String t = com.baidu.tbadk.core.util.au.t(biVar.si());
                this.alN.setText(String.format(this.mContext.getString(w.l.view_num_tip), t));
                this.alN.setContentDescription(String.valueOf(this.mContext.getString(w.l.view_num)) + t);
                this.alS = true;
                return;
            }
            this.alN.setVisibility(8);
        }
    }

    public void e(TbPageContext tbPageContext) {
        this.ajU = tbPageContext;
        if (this.alP != null) {
            if (this.aiC == null || com.baidu.tbadk.core.util.x.q(this.aiC.tq()) || !TbadkCoreApplication.isLogin() || this.aiC.tr()) {
                this.alP.setVisibility(8);
                return;
            }
            if (this.alQ == null) {
                this.alQ = new ArrayList();
            } else {
                this.alQ.clear();
            }
            if (this.alR == null) {
                this.alR = new ArrayList();
            } else {
                this.alR.clear();
            }
            boolean z = false;
            for (ReportInfo reportInfo : this.aiC.tq()) {
                if (reportInfo != null && !StringUtils.isNull(reportInfo.info) && !StringUtils.isNull(reportInfo.url)) {
                    z = true;
                    this.alQ.add(reportInfo.info);
                    this.alR.add(reportInfo.url);
                }
            }
            if (z) {
                this.alP.setOnClickListener(this.amc);
                this.alP.setVisibility(0);
                return;
            }
            this.alP.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xq() {
        if (this.ajU != null) {
            com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(this.ajU.getPageActivity());
            cVar.cc(w.l.operation);
            cVar.a(this.alQ, new ak(this));
            cVar.d(this.ajU);
            cVar.tT();
        }
    }

    public void onChangeSkinType() {
        com.baidu.tbadk.core.util.aq.i(this.alH, w.e.cp_cont_c);
        com.baidu.tbadk.core.util.aq.i(this.alI, w.e.cp_cont_c);
        com.baidu.tbadk.core.util.aq.k(this.alJ, w.e.cp_cont_c);
        com.baidu.tbadk.core.util.aq.i(this.alK, w.e.cp_cont_c);
        com.baidu.tbadk.core.util.aq.i(this.alL, w.e.cp_cont_c);
        com.baidu.tbadk.core.util.aq.i(this.alN, w.e.cp_cont_c);
        com.baidu.tbadk.core.util.aq.i(this.alM, w.e.cp_cont_c);
        com.baidu.tbadk.core.util.aq.j(this.alO, w.g.btn_frs_more_selector);
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.ama = onClickListener;
    }

    public TextView getBarNameTv() {
        return this.alH;
    }

    public void h(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.amd != null) {
            this.amd.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.amd);
        }
    }

    public void setLocationEnabled(boolean z) {
        this.alT = z;
    }

    public void setViewNumEnabled(boolean z) {
        this.alX = z;
    }

    public void setReplyTimeVisible(boolean z) {
        this.alV = z;
    }

    public View getCommentNumView() {
        return this.alM;
    }

    public void setCommentNumClickListener(View.OnClickListener onClickListener) {
        this.alM.setOnClickListener(onClickListener);
    }
}

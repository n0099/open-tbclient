package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
import tbclient.ReportInfo;
/* loaded from: classes.dex */
public class ThreadCommentAndPraiseInfoLayout extends LinearLayout {
    private bk ahV;
    private TbPageContext ajr;
    private TextView alD;
    private TextView alE;
    private View alF;
    private TextView alG;
    private TextView alH;
    private TextView alI;
    private TextView alJ;
    private TextView alK;
    private FrameLayout alL;
    private List<CharSequence> alM;
    private List<String> alN;
    private boolean alO;
    private boolean alP;
    private boolean alQ;
    private boolean alR;
    private boolean alS;
    private boolean alT;
    private boolean alU;
    private boolean alV;
    private boolean alW;
    private String alX;
    private View.OnClickListener alY;
    private int alZ;
    private int ama;
    private View.OnClickListener amb;
    private View.OnClickListener amc;
    private CustomMessageListener amd;
    private Context mContext;
    private int mFrom;
    private String mStType;

    public void setYuelaouLocate(String str) {
        this.alX = str;
    }

    public void setStType(String str) {
        this.mStType = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.alO = false;
        this.alP = false;
        this.alQ = false;
        this.alR = true;
        this.alS = true;
        this.alT = false;
        this.alU = false;
        this.alV = false;
        this.alW = true;
        this.mFrom = 1;
        this.amb = new ak(this);
        this.amc = new al(this);
        this.amd = new am(this, CmdConfigCustom.PB_ACTION_PRAISE);
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.alO = false;
        this.alP = false;
        this.alQ = false;
        this.alR = true;
        this.alS = true;
        this.alT = false;
        this.alU = false;
        this.alV = false;
        this.alW = true;
        this.mFrom = 1;
        this.amb = new ak(this);
        this.amc = new al(this);
        this.amd = new am(this, CmdConfigCustom.PB_ACTION_PRAISE);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(w.j.thread_comment_and_praise_info_layout, (ViewGroup) this, true);
        this.alD = (TextView) inflate.findViewById(w.h.thread_info_bar_name);
        this.alE = (TextView) inflate.findViewById(w.h.thread_info_reply_time);
        this.alF = inflate.findViewById(w.h.frs_item_location_sep);
        this.alG = (TextView) inflate.findViewById(w.h.frs_item_location_address);
        this.alH = (TextView) inflate.findViewById(w.h.thread_info_praise_num);
        this.alI = (TextView) inflate.findViewById(w.h.thread_info_commont_num);
        this.alJ = (TextView) inflate.findViewById(w.h.thread_info_view_num);
        this.alK = (TextView) inflate.findViewById(w.h.thread_info_more);
        this.alL = (FrameLayout) inflate.findViewById(w.h.thread_info_more_frame);
        this.mContext = context;
    }

    public void setShowPraiseNum(boolean z) {
        this.alQ = z;
    }

    public void setBarNameClickEnabled(boolean z) {
        this.alS = z;
        if (this.alD != null) {
            this.alD.setClickable(this.alS);
        }
    }

    public boolean wA() {
        return this.alL != null && this.alL.getVisibility() == 0;
    }

    public boolean a(bk bkVar) {
        if (bkVar == null) {
            setVisibility(8);
            return false;
        }
        this.ahV = bkVar;
        b(bkVar);
        c(bkVar);
        d(bkVar);
        g(bkVar);
        f(bkVar);
        e(bkVar);
        setVisibility(this.alO ? 0 : 8);
        return this.alO;
    }

    private void b(bk bkVar) {
        if (this.alD != null && bkVar != null) {
            if (!StringUtils.isNull(bkVar.rD()) && this.alW) {
                this.alD.setVisibility(0);
                String d = com.baidu.tbadk.core.util.au.d(bkVar.rD(), 14, "...");
                String string = getContext().getString(w.l.chosen_pb_original_bar, d);
                if (com.baidu.tbadk.core.util.au.dy(d) > 14) {
                    this.alD.setText(d);
                } else {
                    this.alD.setText(string);
                }
                this.alD.setContentDescription(string);
                this.alD.setOnClickListener(this.amb);
                this.alD.setClickable(this.alS);
                this.alO = true;
                return;
            }
            this.alD.setVisibility(8);
        }
    }

    private void c(bk bkVar) {
        String r;
        if (this.alE != null && bkVar != null) {
            if (bkVar.rt() <= 0 || !this.alR) {
                this.alE.setVisibility(8);
                return;
            }
            this.alE.setVisibility(0);
            if (this.mFrom == 2) {
                r = com.baidu.tbadk.core.util.au.p(bkVar.rt());
            } else {
                r = com.baidu.tbadk.core.util.au.r(bkVar.rt() * 1000);
            }
            this.alE.setText(r);
            this.alO = true;
        }
    }

    private void d(bk bkVar) {
        if (this.alG != null && this.alF != null && bkVar != null) {
            if (this.alP && !bkVar.sd() && !StringUtils.isNull(bkVar.getAddress())) {
                this.alG.setVisibility(0);
                if (bkVar.rt() <= 0) {
                    this.alF.setVisibility(8);
                } else {
                    this.alF.setVisibility(0);
                }
                this.alG.setText(bkVar.getAddress());
                this.alO = true;
                return;
            }
            this.alG.setVisibility(8);
            this.alF.setVisibility(8);
        }
    }

    private void e(bk bkVar) {
        if (this.alI != null && bkVar != null) {
            if (bkVar.rr() > 0) {
                this.alI.setVisibility(0);
                String u = com.baidu.tbadk.core.util.au.u(bkVar.rr());
                if (this.alU) {
                    this.alI.setText(u);
                } else {
                    this.alI.setText(String.format(this.mContext.getString(w.l.reply_num_tip), u));
                }
                this.alI.setContentDescription(String.valueOf(this.mContext.getString(w.l.reply_num)) + u);
                this.alO = true;
            } else if (this.alU) {
                this.alI.setText("0");
            } else {
                this.alI.setVisibility(8);
            }
        }
    }

    public void f(bk bkVar) {
        if (this.alH != null && bkVar != null && this.alQ) {
            this.alH.setVisibility(0);
            String u = com.baidu.tbadk.core.util.au.u(bkVar.sH());
            this.alH.setText(u);
            this.alH.setContentDescription(String.valueOf(this.mContext.getString(w.l.zan_num)) + u);
            this.alO = true;
        }
    }

    private void g(bk bkVar) {
        if (this.alJ != null && bkVar != null) {
            if (this.alT && bkVar.rs() > 0) {
                this.alJ.setVisibility(0);
                String t = com.baidu.tbadk.core.util.au.t(bkVar.rs());
                this.alJ.setText(String.format(this.mContext.getString(w.l.view_num_tip), t));
                this.alJ.setContentDescription(String.valueOf(this.mContext.getString(w.l.view_num)) + t);
                this.alO = true;
                return;
            }
            this.alJ.setVisibility(8);
        }
    }

    public void e(TbPageContext tbPageContext) {
        this.ajr = tbPageContext;
        if (this.alL != null) {
            if (this.ahV == null || com.baidu.tbadk.core.util.x.r(this.ahV.sA()) || !TbadkCoreApplication.isLogin() || this.ahV.sB()) {
                this.alL.setVisibility(8);
                return;
            }
            if (this.alM == null) {
                this.alM = new ArrayList();
            } else {
                this.alM.clear();
            }
            if (this.alN == null) {
                this.alN = new ArrayList();
            } else {
                this.alN.clear();
            }
            boolean z = false;
            for (ReportInfo reportInfo : this.ahV.sA()) {
                if (reportInfo != null && !StringUtils.isNull(reportInfo.info) && !StringUtils.isNull(reportInfo.url)) {
                    z = true;
                    this.alM.add(reportInfo.info);
                    this.alN.add(reportInfo.url);
                }
            }
            if (z) {
                this.alL.setOnClickListener(this.amc);
                this.alL.setVisibility(0);
                return;
            }
            this.alL.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wB() {
        if (this.ajr != null) {
            com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(this.ajr.getPageActivity());
            cVar.ca(w.l.operation);
            cVar.a(this.alM, new an(this));
            cVar.d(this.ajr);
            cVar.tg();
        }
    }

    public void onChangeSkinType() {
        com.baidu.tbadk.core.util.aq.i(this.alD, w.e.cp_cont_d);
        com.baidu.tbadk.core.util.aq.i(this.alE, w.e.cp_cont_d);
        com.baidu.tbadk.core.util.aq.k(this.alF, w.e.cp_cont_d);
        com.baidu.tbadk.core.util.aq.i(this.alG, w.e.cp_cont_d);
        com.baidu.tbadk.core.util.aq.i(this.alH, w.e.cp_cont_d);
        com.baidu.tbadk.core.util.aq.i(this.alJ, w.e.cp_cont_d);
        com.baidu.tbadk.core.util.aq.i(this.alI, w.e.cp_cont_d);
        com.baidu.tbadk.core.util.aq.j(this.alK, w.g.btn_frs_more_selector);
        if (this.alH != null && this.alV && this.ama > 0) {
            this.alH.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.aq.getDrawable(this.alZ), (Drawable) null);
        }
        if (this.alI != null && this.alU && this.ama > 0) {
            this.alI.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.aq.getDrawable(this.ama), (Drawable) null);
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.alY = onClickListener;
    }

    public TextView getBarNameTv() {
        return this.alD;
    }

    public void h(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.amd != null) {
            this.amd.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.amd);
        }
    }

    public void setLocationEnabled(boolean z) {
        this.alP = z;
    }

    public void setViewNumEnabled(boolean z) {
        this.alT = z;
    }

    public void setReplyTimeVisible(boolean z) {
        this.alR = z;
    }

    public View getCommentNumView() {
        return this.alI;
    }

    public void setCommentNumClickListener(View.OnClickListener onClickListener) {
        this.alI.setOnClickListener(onClickListener);
    }

    public void setReplyIcon(int i) {
        if (i > 0) {
            this.ama = i;
        }
    }

    public void setPraiseIcon(int i) {
        if (i > 0) {
            this.alZ = i;
        }
    }

    public void setNeedAddReplyIcon(boolean z) {
        this.alU = z;
    }

    public void setNeedAddPraiseIcon(boolean z) {
        this.alV = z;
    }

    public void setIsBarViewVisible(boolean z) {
        this.alW = z;
    }
}

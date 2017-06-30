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
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
import tbclient.ReportInfo;
/* loaded from: classes.dex */
public class ThreadCommentAndPraiseInfoLayout extends LinearLayout {
    private bm aiu;
    private TbPageContext ajP;
    private boolean amA;
    private boolean amB;
    private boolean amC;
    private boolean amD;
    private String amE;
    private View.OnClickListener amF;
    private int amG;
    private int amH;
    private int amI;
    private View.OnClickListener amJ;
    private View.OnClickListener amK;
    private CustomMessageListener amL;
    private TextView amh;
    private TextView ami;
    private View amj;
    private TextView amk;
    private TextView aml;
    private TextView amm;
    private TextView amn;
    private TextView amo;
    private TextView amp;
    private FrameLayout amq;
    private List<CharSequence> amr;
    private List<String> ams;
    private boolean amt;
    private boolean amu;
    private boolean amv;
    private boolean amw;
    private boolean amx;
    private boolean amy;
    private boolean amz;
    private Context mContext;
    private int mFrom;
    private String mStType;

    public void setYuelaouLocate(String str) {
        this.amE = str;
    }

    public void setStType(String str) {
        this.mStType = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.amt = false;
        this.amu = false;
        this.amv = false;
        this.amw = true;
        this.amx = true;
        this.amy = false;
        this.amz = false;
        this.amA = false;
        this.amB = true;
        this.amC = true;
        this.amD = false;
        this.mFrom = 1;
        this.amJ = new ak(this);
        this.amK = new al(this);
        this.amL = new am(this, CmdConfigCustom.PB_ACTION_PRAISE);
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.amt = false;
        this.amu = false;
        this.amv = false;
        this.amw = true;
        this.amx = true;
        this.amy = false;
        this.amz = false;
        this.amA = false;
        this.amB = true;
        this.amC = true;
        this.amD = false;
        this.mFrom = 1;
        this.amJ = new ak(this);
        this.amK = new al(this);
        this.amL = new am(this, CmdConfigCustom.PB_ACTION_PRAISE);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(w.j.thread_comment_and_praise_info_layout, (ViewGroup) this, true);
        this.amh = (TextView) inflate.findViewById(w.h.thread_info_bar_name);
        this.ami = (TextView) inflate.findViewById(w.h.thread_info_reply_time);
        this.amj = inflate.findViewById(w.h.frs_item_location_sep);
        this.amk = (TextView) inflate.findViewById(w.h.frs_item_location_address);
        this.aml = (TextView) inflate.findViewById(w.h.thread_info_praise_num);
        this.amm = (TextView) inflate.findViewById(w.h.thread_info_commont_num);
        this.amn = (TextView) inflate.findViewById(w.h.thread_info_audience_num);
        this.amo = (TextView) inflate.findViewById(w.h.thread_info_view_num);
        this.amp = (TextView) inflate.findViewById(w.h.thread_info_more);
        this.amq = (FrameLayout) inflate.findViewById(w.h.thread_info_more_frame);
        this.mContext = context;
    }

    public void setShowPraiseNum(boolean z) {
        this.amv = z;
    }

    public void setBarNameClickEnabled(boolean z) {
        this.amx = z;
        if (this.amh != null) {
            this.amh.setClickable(this.amx);
        }
    }

    public boolean wO() {
        return this.amq != null && this.amq.getVisibility() == 0;
    }

    public boolean a(bm bmVar) {
        if (bmVar == null) {
            setVisibility(8);
            return false;
        }
        this.aiu = bmVar;
        b(bmVar);
        c(bmVar);
        d(bmVar);
        h(bmVar);
        g(bmVar);
        e(bmVar);
        f(bmVar);
        setVisibility(this.amt ? 0 : 8);
        return this.amt;
    }

    private void b(bm bmVar) {
        if (this.amh != null && bmVar != null) {
            if (!StringUtils.isNull(bmVar.rw()) && this.amB) {
                this.amh.setVisibility(0);
                String d = com.baidu.tbadk.core.util.aw.d(bmVar.rw(), 14, "...");
                String string = getContext().getString(w.l.chosen_pb_original_bar, d);
                if (com.baidu.tbadk.core.util.aw.dP(d) > 14) {
                    this.amh.setText(d);
                } else {
                    this.amh.setText(string);
                }
                this.amh.setContentDescription(string);
                this.amh.setOnClickListener(this.amJ);
                this.amh.setClickable(this.amx);
                this.amt = true;
                return;
            }
            this.amh.setVisibility(8);
        }
    }

    private void c(bm bmVar) {
        String r;
        if (this.ami != null && bmVar != null) {
            if (bmVar.rl() <= 0 || !this.amw) {
                this.ami.setVisibility(8);
                return;
            }
            this.ami.setVisibility(0);
            if (this.mFrom == 2) {
                r = com.baidu.tbadk.core.util.aw.p(bmVar.rl());
            } else {
                r = com.baidu.tbadk.core.util.aw.r(bmVar.rl() * 1000);
            }
            this.ami.setText(r);
            this.amt = true;
        }
    }

    private void d(bm bmVar) {
        if (this.amk != null && this.amj != null && bmVar != null) {
            if (this.amu && !bmVar.rW() && !StringUtils.isNull(bmVar.getAddress())) {
                this.amk.setVisibility(0);
                if (bmVar.rl() <= 0) {
                    this.amj.setVisibility(8);
                } else {
                    this.amj.setVisibility(0);
                }
                this.amk.setText(bmVar.getAddress());
                this.amt = true;
                return;
            }
            this.amk.setVisibility(8);
            this.amj.setVisibility(8);
        }
    }

    private void e(bm bmVar) {
        if (this.amm != null && bmVar != null) {
            if (this.amC) {
                if (bmVar.rj() > 0) {
                    this.amm.setVisibility(0);
                    String u = com.baidu.tbadk.core.util.aw.u(bmVar.rj());
                    if (this.amz) {
                        this.amm.setText(u);
                    } else {
                        this.amm.setText(String.format(this.mContext.getString(w.l.reply_num_tip), u));
                    }
                    this.amm.setContentDescription(String.valueOf(this.mContext.getString(w.l.reply_num)) + u);
                    this.amt = true;
                    return;
                } else if (this.amz) {
                    this.amm.setText("0");
                    return;
                } else {
                    this.amm.setVisibility(8);
                    return;
                }
            }
            this.amm.setVisibility(8);
        }
    }

    private void f(bm bmVar) {
        if ((this.amn != null || bmVar != null) && bmVar.rJ() != null) {
            if (!this.amD) {
                this.amn.setVisibility(8);
                return;
            }
            this.amn.setText(com.baidu.tbadk.core.util.aw.u(bmVar.rJ().audience_count));
            this.amn.setVisibility(0);
        }
    }

    public void g(bm bmVar) {
        if (this.aml != null && bmVar != null && this.amv) {
            this.aml.setVisibility(0);
            String u = com.baidu.tbadk.core.util.aw.u(bmVar.sD());
            this.aml.setText(u);
            this.aml.setContentDescription(String.valueOf(this.mContext.getString(w.l.zan_num)) + u);
            this.amt = true;
        }
    }

    private void h(bm bmVar) {
        if (this.amo != null && bmVar != null) {
            if (this.amy && bmVar.rk() > 0) {
                this.amo.setVisibility(0);
                String t = com.baidu.tbadk.core.util.aw.t(bmVar.rk());
                this.amo.setText(String.format(this.mContext.getString(w.l.view_num_tip), t));
                this.amo.setContentDescription(String.valueOf(this.mContext.getString(w.l.view_num)) + t);
                this.amt = true;
                return;
            }
            this.amo.setVisibility(8);
        }
    }

    public void e(TbPageContext tbPageContext) {
        this.ajP = tbPageContext;
        if (this.amq != null) {
            if (this.aiu == null || com.baidu.tbadk.core.util.z.t(this.aiu.st()) || !TbadkCoreApplication.isLogin() || this.aiu.su()) {
                this.amq.setVisibility(8);
                return;
            }
            if (this.amr == null) {
                this.amr = new ArrayList();
            } else {
                this.amr.clear();
            }
            if (this.ams == null) {
                this.ams = new ArrayList();
            } else {
                this.ams.clear();
            }
            boolean z = false;
            for (ReportInfo reportInfo : this.aiu.st()) {
                if (reportInfo != null && !StringUtils.isNull(reportInfo.info) && !StringUtils.isNull(reportInfo.url)) {
                    z = true;
                    this.amr.add(reportInfo.info);
                    this.ams.add(reportInfo.url);
                }
            }
            if (z) {
                this.amq.setOnClickListener(this.amK);
                this.amq.setVisibility(0);
                return;
            }
            this.amq.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wP() {
        if (this.ajP != null) {
            com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(this.ajP.getPageActivity());
            cVar.cb(w.l.operation);
            cVar.a(this.amr, new an(this));
            cVar.d(this.ajP);
            cVar.td();
        }
    }

    public void onChangeSkinType() {
        com.baidu.tbadk.core.util.as.i(this.amh, w.e.cp_cont_d);
        com.baidu.tbadk.core.util.as.i(this.ami, w.e.cp_cont_d);
        com.baidu.tbadk.core.util.as.k(this.amj, w.e.cp_cont_d);
        com.baidu.tbadk.core.util.as.i(this.amk, w.e.cp_cont_d);
        com.baidu.tbadk.core.util.as.i(this.aml, w.e.cp_cont_d);
        com.baidu.tbadk.core.util.as.i(this.amo, w.e.cp_cont_d);
        com.baidu.tbadk.core.util.as.i(this.amm, w.e.cp_cont_d);
        com.baidu.tbadk.core.util.as.i(this.amn, w.e.cp_cont_d);
        com.baidu.tbadk.core.util.as.j(this.amp, w.g.btn_frs_more_selector);
        if (this.aml != null && this.amA && this.amH > 0) {
            this.aml.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.as.getDrawable(this.amG), (Drawable) null);
        }
        if (this.amm != null && this.amz && this.amH > 0) {
            this.amm.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.as.getDrawable(this.amH), (Drawable) null);
        }
        if (this.amn != null && this.amD && this.amI > 0) {
            this.amn.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.as.getDrawable(this.amI), (Drawable) null);
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.amF = onClickListener;
    }

    public TextView getBarNameTv() {
        return this.amh;
    }

    public void h(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.amL != null) {
            this.amL.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.amL);
        }
    }

    public void setLocationEnabled(boolean z) {
        this.amu = z;
    }

    public void setViewNumEnabled(boolean z) {
        this.amy = z;
    }

    public void setCommentNumEnable(boolean z) {
        this.amC = z;
    }

    public void setLiveAudienceEnable(boolean z) {
        this.amD = z;
    }

    public void setReplyTimeVisible(boolean z) {
        this.amw = z;
    }

    public View getCommentNumView() {
        return this.amm;
    }

    public void setCommentNumClickListener(View.OnClickListener onClickListener) {
        this.amm.setOnClickListener(onClickListener);
    }

    public void setReplyIcon(int i) {
        if (i > 0) {
            this.amH = i;
        }
    }

    public void setPraiseIcon(int i) {
        if (i > 0) {
            this.amG = i;
        }
    }

    public void setLiveAudienceIcon(int i) {
        if (i > 0) {
            this.amI = i;
        }
    }

    public void setNeedAddReplyIcon(boolean z) {
        this.amz = z;
    }

    public void setNeedAddPraiseIcon(boolean z) {
        this.amA = z;
    }

    public void setIsBarViewVisible(boolean z) {
        this.amB = z;
    }
}

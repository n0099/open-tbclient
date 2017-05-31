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
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
import tbclient.ReportInfo;
/* loaded from: classes.dex */
public class ThreadCommentAndPraiseInfoLayout extends LinearLayout {
    private bl ahM;
    private TbPageContext ajh;
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
    private boolean alK;
    private boolean alL;
    private boolean alM;
    private String alN;
    private View.OnClickListener alO;
    private int alP;
    private int alQ;
    private View.OnClickListener alR;
    private View.OnClickListener alS;
    private CustomMessageListener alT;
    private TextView alt;
    private TextView alu;
    private View alv;
    private TextView alw;
    private TextView alx;
    private TextView aly;
    private TextView alz;
    private Context mContext;
    private int mFrom;
    private String mStType;

    public void setYuelaouLocate(String str) {
        this.alN = str;
    }

    public void setStType(String str) {
        this.mStType = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.alE = false;
        this.alF = false;
        this.alG = false;
        this.alH = true;
        this.alI = true;
        this.alJ = false;
        this.alK = false;
        this.alL = false;
        this.alM = true;
        this.mFrom = 1;
        this.alR = new ak(this);
        this.alS = new al(this);
        this.alT = new am(this, CmdConfigCustom.PB_ACTION_PRAISE);
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.alE = false;
        this.alF = false;
        this.alG = false;
        this.alH = true;
        this.alI = true;
        this.alJ = false;
        this.alK = false;
        this.alL = false;
        this.alM = true;
        this.mFrom = 1;
        this.alR = new ak(this);
        this.alS = new al(this);
        this.alT = new am(this, CmdConfigCustom.PB_ACTION_PRAISE);
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

    public boolean ww() {
        return this.alB != null && this.alB.getVisibility() == 0;
    }

    public boolean a(bl blVar) {
        if (blVar == null) {
            setVisibility(8);
            return false;
        }
        this.ahM = blVar;
        b(blVar);
        c(blVar);
        d(blVar);
        g(blVar);
        f(blVar);
        e(blVar);
        setVisibility(this.alE ? 0 : 8);
        return this.alE;
    }

    private void b(bl blVar) {
        if (this.alt != null && blVar != null) {
            if (!StringUtils.isNull(blVar.rz()) && this.alM) {
                this.alt.setVisibility(0);
                String d = com.baidu.tbadk.core.util.au.d(blVar.rz(), 14, "...");
                String string = getContext().getString(w.l.chosen_pb_original_bar, d);
                if (com.baidu.tbadk.core.util.au.dv(d) > 14) {
                    this.alt.setText(d);
                } else {
                    this.alt.setText(string);
                }
                this.alt.setContentDescription(string);
                this.alt.setOnClickListener(this.alR);
                this.alt.setClickable(this.alI);
                this.alE = true;
                return;
            }
            this.alt.setVisibility(8);
        }
    }

    private void c(bl blVar) {
        String r;
        if (this.alu != null && blVar != null) {
            if (blVar.rp() <= 0 || !this.alH) {
                this.alu.setVisibility(8);
                return;
            }
            this.alu.setVisibility(0);
            if (this.mFrom == 2) {
                r = com.baidu.tbadk.core.util.au.p(blVar.rp());
            } else {
                r = com.baidu.tbadk.core.util.au.r(blVar.rp() * 1000);
            }
            this.alu.setText(r);
            this.alE = true;
        }
    }

    private void d(bl blVar) {
        if (this.alw != null && this.alv != null && blVar != null) {
            if (this.alF && !blVar.rZ() && !StringUtils.isNull(blVar.getAddress())) {
                this.alw.setVisibility(0);
                if (blVar.rp() <= 0) {
                    this.alv.setVisibility(8);
                } else {
                    this.alv.setVisibility(0);
                }
                this.alw.setText(blVar.getAddress());
                this.alE = true;
                return;
            }
            this.alw.setVisibility(8);
            this.alv.setVisibility(8);
        }
    }

    private void e(bl blVar) {
        if (this.aly != null && blVar != null) {
            if (blVar.rn() > 0) {
                this.aly.setVisibility(0);
                String u = com.baidu.tbadk.core.util.au.u(blVar.rn());
                if (this.alK) {
                    this.aly.setText(u);
                } else {
                    this.aly.setText(String.format(this.mContext.getString(w.l.reply_num_tip), u));
                }
                this.aly.setContentDescription(String.valueOf(this.mContext.getString(w.l.reply_num)) + u);
                this.alE = true;
            } else if (this.alK) {
                this.aly.setText("0");
            } else {
                this.aly.setVisibility(8);
            }
        }
    }

    public void f(bl blVar) {
        if (this.alx != null && blVar != null && this.alG) {
            this.alx.setVisibility(0);
            String u = com.baidu.tbadk.core.util.au.u(blVar.sF());
            this.alx.setText(u);
            this.alx.setContentDescription(String.valueOf(this.mContext.getString(w.l.zan_num)) + u);
            this.alE = true;
        }
    }

    private void g(bl blVar) {
        if (this.alz != null && blVar != null) {
            if (this.alJ && blVar.ro() > 0) {
                this.alz.setVisibility(0);
                String t = com.baidu.tbadk.core.util.au.t(blVar.ro());
                this.alz.setText(String.format(this.mContext.getString(w.l.view_num_tip), t));
                this.alz.setContentDescription(String.valueOf(this.mContext.getString(w.l.view_num)) + t);
                this.alE = true;
                return;
            }
            this.alz.setVisibility(8);
        }
    }

    public void e(TbPageContext tbPageContext) {
        this.ajh = tbPageContext;
        if (this.alB != null) {
            if (this.ahM == null || com.baidu.tbadk.core.util.x.r(this.ahM.sv()) || !TbadkCoreApplication.isLogin() || this.ahM.sw()) {
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
            for (ReportInfo reportInfo : this.ahM.sv()) {
                if (reportInfo != null && !StringUtils.isNull(reportInfo.info) && !StringUtils.isNull(reportInfo.url)) {
                    z = true;
                    this.alC.add(reportInfo.info);
                    this.alD.add(reportInfo.url);
                }
            }
            if (z) {
                this.alB.setOnClickListener(this.alS);
                this.alB.setVisibility(0);
                return;
            }
            this.alB.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wx() {
        if (this.ajh != null) {
            com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(this.ajh.getPageActivity());
            cVar.cb(w.l.operation);
            cVar.a(this.alC, new an(this));
            cVar.d(this.ajh);
            cVar.tf();
        }
    }

    public void onChangeSkinType() {
        com.baidu.tbadk.core.util.aq.i(this.alt, w.e.cp_cont_d);
        com.baidu.tbadk.core.util.aq.i(this.alu, w.e.cp_cont_d);
        com.baidu.tbadk.core.util.aq.k(this.alv, w.e.cp_cont_d);
        com.baidu.tbadk.core.util.aq.i(this.alw, w.e.cp_cont_d);
        com.baidu.tbadk.core.util.aq.i(this.alx, w.e.cp_cont_d);
        com.baidu.tbadk.core.util.aq.i(this.alz, w.e.cp_cont_d);
        com.baidu.tbadk.core.util.aq.i(this.aly, w.e.cp_cont_d);
        com.baidu.tbadk.core.util.aq.j(this.alA, w.g.btn_frs_more_selector);
        if (this.alx != null && this.alL && this.alQ > 0) {
            this.alx.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.aq.getDrawable(this.alP), (Drawable) null);
        }
        if (this.aly != null && this.alK && this.alQ > 0) {
            this.aly.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.aq.getDrawable(this.alQ), (Drawable) null);
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.alO = onClickListener;
    }

    public TextView getBarNameTv() {
        return this.alt;
    }

    public void h(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.alT != null) {
            this.alT.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.alT);
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

    public void setReplyIcon(int i) {
        if (i > 0) {
            this.alQ = i;
        }
    }

    public void setPraiseIcon(int i) {
        if (i > 0) {
            this.alP = i;
        }
    }

    public void setNeedAddReplyIcon(boolean z) {
        this.alK = z;
    }

    public void setNeedAddPraiseIcon(boolean z) {
        this.alL = z;
    }

    public void setIsBarViewVisible(boolean z) {
        this.alM = z;
    }
}

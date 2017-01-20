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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
import tbclient.ReportInfo;
/* loaded from: classes.dex */
public class ThreadCommentAndPraiseInfoLayout extends LinearLayout {
    private TbPageContext FY;
    private bh acX;
    private TextView aga;
    private TextView agb;
    private View agc;
    private TextView agd;
    private TextView agf;
    private TextView agg;
    private TextView agh;
    private TextView agi;
    private FrameLayout agj;
    private List<CharSequence> agk;
    private List<String> agl;
    private boolean agm;
    private boolean agn;
    private boolean ago;
    private boolean agp;
    private boolean agq;
    private String agr;
    private String ags;
    private View.OnClickListener agt;
    private View.OnClickListener agu;
    private View.OnClickListener agv;
    private CustomMessageListener agw;
    private Context mContext;
    private int mFrom;

    public void setYuelaouLocate(String str) {
        this.ags = str;
    }

    public void setStType(String str) {
        this.agr = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.agm = false;
        this.agn = false;
        this.ago = true;
        this.agp = true;
        this.agq = false;
        this.mFrom = 1;
        this.agu = new ag(this);
        this.agv = new ah(this);
        this.agw = new ai(this, CmdConfigCustom.PB_ACTION_PRAISE);
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.agm = false;
        this.agn = false;
        this.ago = true;
        this.agp = true;
        this.agq = false;
        this.mFrom = 1;
        this.agu = new ag(this);
        this.agv = new ah(this);
        this.agw = new ai(this, CmdConfigCustom.PB_ACTION_PRAISE);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(r.j.thread_comment_and_praise_info_layout, (ViewGroup) this, true);
        this.aga = (TextView) inflate.findViewById(r.h.thread_info_bar_name);
        this.agb = (TextView) inflate.findViewById(r.h.thread_info_reply_time);
        this.agc = inflate.findViewById(r.h.frs_item_location_sep);
        this.agd = (TextView) inflate.findViewById(r.h.frs_item_location_address);
        this.agf = (TextView) inflate.findViewById(r.h.thread_info_praise_num);
        this.agg = (TextView) inflate.findViewById(r.h.thread_info_commont_num);
        this.agh = (TextView) inflate.findViewById(r.h.thread_info_view_num);
        this.agi = (TextView) inflate.findViewById(r.h.thread_info_more);
        this.agj = (FrameLayout) inflate.findViewById(r.h.thread_info_more_frame);
        this.mContext = context;
    }

    public void setShowPraiseNum(boolean z) {
        this.ago = z;
    }

    public void setBarNameClickEnabled(boolean z) {
        this.agp = z;
        if (this.aga != null) {
            this.aga.setClickable(this.agp);
        }
    }

    public boolean ww() {
        return this.agj != null && this.agj.getVisibility() == 0;
    }

    public boolean a(bh bhVar) {
        if (bhVar == null) {
            setVisibility(8);
            return false;
        }
        this.acX = bhVar;
        b(bhVar);
        c(bhVar);
        d(bhVar);
        if (this.acX.rN() != null && !StringUtils.isNull(this.acX.rN().video_url)) {
            this.agh.setVisibility(8);
        } else {
            g(bhVar);
        }
        f(bhVar);
        e(bhVar);
        setVisibility(this.agm ? 0 : 8);
        return this.agm;
    }

    private void b(bh bhVar) {
        if (this.aga != null && bhVar != null) {
            if (!StringUtils.isNull(bhVar.rB())) {
                this.aga.setVisibility(0);
                String string = getContext().getString(r.l.chosen_pb_original_bar, UtilHelper.getFixedBarText(bhVar.rB(), 5, true));
                this.aga.setText(string);
                this.aga.setContentDescription(string);
                this.aga.setOnClickListener(this.agu);
                this.aga.setClickable(this.agp);
                this.agm = true;
                return;
            }
            this.aga.setVisibility(8);
        }
    }

    private void c(bh bhVar) {
        String s;
        if (this.agb != null && bhVar != null) {
            if (bhVar.rr() <= 0) {
                this.agb.setVisibility(8);
                return;
            }
            this.agb.setVisibility(0);
            if (this.mFrom == 2) {
                s = com.baidu.tbadk.core.util.at.q(bhVar.rr());
            } else {
                s = com.baidu.tbadk.core.util.at.s(bhVar.rr() * 1000);
            }
            this.agb.setText(s);
            this.agm = true;
        }
    }

    private void d(bh bhVar) {
        if (this.agd != null && this.agc != null && bhVar != null) {
            if (this.agn && !bhVar.sa() && !StringUtils.isNull(bhVar.getAddress())) {
                this.agd.setVisibility(0);
                if (bhVar.rr() <= 0) {
                    this.agc.setVisibility(8);
                } else {
                    this.agc.setVisibility(0);
                }
                this.agd.setText(bhVar.getAddress());
                this.agm = true;
                return;
            }
            this.agd.setVisibility(8);
            this.agc.setVisibility(8);
        }
    }

    private void e(bh bhVar) {
        if (this.agg != null && bhVar != null) {
            if (bhVar.rp() > 0) {
                this.agg.setVisibility(0);
                String u = com.baidu.tbadk.core.util.at.u(bhVar.rp());
                this.agg.setText(String.format(this.mContext.getString(r.l.reply_num_tip), u));
                this.agg.setContentDescription(String.valueOf(this.mContext.getString(r.l.reply_num)) + u);
                this.agm = true;
                return;
            }
            this.agg.setVisibility(8);
        }
    }

    public void f(bh bhVar) {
        if (this.agf != null && bhVar != null) {
            this.agf.setVisibility(8);
        }
    }

    private void g(bh bhVar) {
        if (this.agh != null && bhVar != null) {
            if (this.agq && bhVar.rq() > 0) {
                this.agh.setVisibility(0);
                String u = com.baidu.tbadk.core.util.at.u(bhVar.rq());
                this.agh.setText(String.format(this.mContext.getString(r.l.view_num_tip), u));
                this.agh.setContentDescription(String.valueOf(this.mContext.getString(r.l.view_num)) + u);
                this.agm = true;
                return;
            }
            this.agh.setVisibility(8);
        }
    }

    public void e(TbPageContext tbPageContext) {
        this.FY = tbPageContext;
        if (this.agj != null) {
            if (this.acX == null || com.baidu.tbadk.core.util.w.s(this.acX.sx()) || !TbadkCoreApplication.isLogin()) {
                this.agj.setVisibility(8);
                return;
            }
            if (this.agk == null) {
                this.agk = new ArrayList();
            } else {
                this.agk.clear();
            }
            if (this.agl == null) {
                this.agl = new ArrayList();
            } else {
                this.agl.clear();
            }
            boolean z = false;
            for (ReportInfo reportInfo : this.acX.sx()) {
                if (reportInfo != null && !StringUtils.isNull(reportInfo.info) && !StringUtils.isNull(reportInfo.url)) {
                    z = true;
                    this.agk.add(reportInfo.info);
                    this.agl.add(reportInfo.url);
                }
            }
            if (z) {
                this.agj.setOnClickListener(this.agv);
                this.agj.setVisibility(0);
                return;
            }
            this.agj.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wx() {
        if (this.FY != null) {
            com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(this.FY.getPageActivity());
            cVar.cd(r.l.operation);
            cVar.a(this.agk, new aj(this));
            cVar.d(this.FY);
            cVar.sY();
        }
    }

    public void tg() {
        com.baidu.tbadk.core.util.ap.i((View) this.aga, r.e.cp_cont_c);
        com.baidu.tbadk.core.util.ap.i((View) this.agb, r.e.cp_cont_c);
        com.baidu.tbadk.core.util.ap.k(this.agc, r.e.cp_cont_c);
        com.baidu.tbadk.core.util.ap.i((View) this.agd, r.e.cp_cont_c);
        com.baidu.tbadk.core.util.ap.i((View) this.agf, r.e.cp_cont_c);
        com.baidu.tbadk.core.util.ap.i((View) this.agh, r.e.cp_cont_c);
        com.baidu.tbadk.core.util.ap.i((View) this.agg, r.e.cp_cont_c);
        com.baidu.tbadk.core.util.ap.j((View) this.agi, r.g.btn_frs_more_selector);
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.agt = onClickListener;
    }

    public TextView getBarNameTv() {
        return this.aga;
    }

    public void h(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.agw != null) {
            this.agw.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.agw);
        }
    }

    public void setLocationEnabled(boolean z) {
        this.agn = z;
    }

    public void setViewNumEnabled(boolean z) {
        this.agq = z;
    }

    public View getCommentNumView() {
        return this.agg;
    }

    public void setCommentNumClickListener(View.OnClickListener onClickListener) {
        this.agg.setOnClickListener(onClickListener);
    }
}

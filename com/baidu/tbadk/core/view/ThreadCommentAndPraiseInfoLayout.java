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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
import tbclient.ReportInfo;
/* loaded from: classes.dex */
public class ThreadCommentAndPraiseInfoLayout extends LinearLayout {
    private TbPageContext GO;
    private bg adN;
    private TextView agO;
    private TextView agP;
    private View agQ;
    private TextView agR;
    private TextView agS;
    private TextView agT;
    private TextView agU;
    private TextView agV;
    private FrameLayout agW;
    private List<CharSequence> agX;
    private List<String> agY;
    private boolean agZ;
    private boolean aha;
    private boolean ahb;
    private boolean ahc;
    private boolean ahd;
    private String ahe;
    private String ahf;
    private View.OnClickListener ahg;
    private View.OnClickListener ahh;
    private View.OnClickListener ahi;
    private CustomMessageListener ahj;
    private Context mContext;
    private int mFrom;

    public void setYuelaouLocate(String str) {
        this.ahf = str;
    }

    public void setStType(String str) {
        this.ahe = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.agZ = false;
        this.aha = false;
        this.ahb = true;
        this.ahc = true;
        this.ahd = false;
        this.mFrom = 1;
        this.ahh = new af(this);
        this.ahi = new ag(this);
        this.ahj = new ah(this, CmdConfigCustom.PB_ACTION_PRAISE);
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.agZ = false;
        this.aha = false;
        this.ahb = true;
        this.ahc = true;
        this.ahd = false;
        this.mFrom = 1;
        this.ahh = new af(this);
        this.ahi = new ag(this);
        this.ahj = new ah(this, CmdConfigCustom.PB_ACTION_PRAISE);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(r.h.thread_comment_and_praise_info_layout, (ViewGroup) this, true);
        this.agO = (TextView) inflate.findViewById(r.g.thread_info_bar_name);
        this.agP = (TextView) inflate.findViewById(r.g.thread_info_reply_time);
        this.agQ = inflate.findViewById(r.g.frs_item_location_sep);
        this.agR = (TextView) inflate.findViewById(r.g.frs_item_location_address);
        this.agS = (TextView) inflate.findViewById(r.g.thread_info_praise_num);
        this.agT = (TextView) inflate.findViewById(r.g.thread_info_commont_num);
        this.agU = (TextView) inflate.findViewById(r.g.thread_info_view_num);
        this.agV = (TextView) inflate.findViewById(r.g.thread_info_more);
        this.agW = (FrameLayout) inflate.findViewById(r.g.thread_info_more_frame);
        this.mContext = context;
    }

    public void setShowPraiseNum(boolean z) {
        this.ahb = z;
    }

    public void setBarNameClickEnabled(boolean z) {
        this.ahc = z;
        if (this.agO != null) {
            this.agO.setClickable(this.ahc);
        }
    }

    public boolean wB() {
        return this.agW != null && this.agW.getVisibility() == 0;
    }

    public boolean a(bg bgVar) {
        if (bgVar == null) {
            setVisibility(8);
            return false;
        }
        this.adN = bgVar;
        b(bgVar);
        c(bgVar);
        d(bgVar);
        g(bgVar);
        f(bgVar);
        e(bgVar);
        setVisibility(this.agZ ? 0 : 8);
        return this.agZ;
    }

    private void b(bg bgVar) {
        if (this.agO != null && bgVar != null) {
            if (!StringUtils.isNull(bgVar.rK())) {
                this.agO.setVisibility(0);
                String string = getContext().getString(r.j.chosen_pb_original_bar, UtilHelper.getFixedBarText(bgVar.rK(), 5, true));
                this.agO.setText(string);
                this.agO.setContentDescription(string);
                this.agO.setOnClickListener(this.ahh);
                this.agO.setClickable(this.ahc);
                this.agZ = true;
                return;
            }
            this.agO.setVisibility(8);
        }
    }

    private void c(bg bgVar) {
        String t;
        if (this.agP != null && bgVar != null) {
            if (bgVar.rz() <= 0) {
                this.agP.setVisibility(8);
                return;
            }
            this.agP.setVisibility(0);
            if (this.mFrom == 2) {
                t = av.r(bgVar.rz());
            } else {
                t = av.t(bgVar.rz() * 1000);
            }
            this.agP.setText(t);
            this.agZ = true;
        }
    }

    private void d(bg bgVar) {
        if (this.agR != null && this.agQ != null && bgVar != null) {
            if (this.aha && !bgVar.si() && !StringUtils.isNull(bgVar.getAddress())) {
                this.agR.setVisibility(0);
                if (bgVar.rz() <= 0) {
                    this.agQ.setVisibility(8);
                } else {
                    this.agQ.setVisibility(0);
                }
                this.agR.setText(bgVar.getAddress());
                this.agZ = true;
                return;
            }
            this.agR.setVisibility(8);
            this.agQ.setVisibility(8);
        }
    }

    private void e(bg bgVar) {
        if (this.agT != null && bgVar != null) {
            if (bgVar.rx() > 0) {
                this.agT.setVisibility(0);
                String v = av.v(bgVar.rx());
                this.agT.setText(String.format(this.mContext.getString(r.j.reply_num_tip), v));
                this.agT.setContentDescription(String.valueOf(this.mContext.getString(r.j.reply_num)) + v);
                this.agZ = true;
                return;
            }
            this.agT.setVisibility(8);
        }
    }

    public void f(bg bgVar) {
        if (this.agS != null && bgVar != null) {
            this.agS.setVisibility(8);
        }
    }

    private void g(bg bgVar) {
        if (this.agU != null && bgVar != null) {
            if (this.ahd && bgVar.ry() > 0) {
                this.agU.setVisibility(0);
                String v = av.v(bgVar.ry());
                this.agU.setText(String.format(this.mContext.getString(r.j.view_num_tip), v));
                this.agU.setContentDescription(String.valueOf(this.mContext.getString(r.j.view_num)) + v);
                this.agZ = true;
                return;
            }
            this.agU.setVisibility(8);
        }
    }

    public void e(TbPageContext tbPageContext) {
        this.GO = tbPageContext;
        if (this.agW != null) {
            if (this.adN == null || com.baidu.tbadk.core.util.x.t(this.adN.sF()) || !TbadkCoreApplication.isLogin()) {
                this.agW.setVisibility(8);
                return;
            }
            if (this.agX == null) {
                this.agX = new ArrayList();
            } else {
                this.agX.clear();
            }
            if (this.agY == null) {
                this.agY = new ArrayList();
            } else {
                this.agY.clear();
            }
            boolean z = false;
            for (ReportInfo reportInfo : this.adN.sF()) {
                if (reportInfo != null && !StringUtils.isNull(reportInfo.info) && !StringUtils.isNull(reportInfo.url)) {
                    z = true;
                    this.agX.add(reportInfo.info);
                    this.agY.add(reportInfo.url);
                }
            }
            if (z) {
                this.agW.setOnClickListener(this.ahi);
                this.agW.setVisibility(0);
                return;
            }
            this.agW.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wC() {
        if (this.GO != null) {
            com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(this.GO.getPageActivity());
            cVar.ce(r.j.operation);
            cVar.a(this.agX, new ai(this));
            cVar.d(this.GO);
            cVar.te();
        }
    }

    public void tm() {
        com.baidu.tbadk.core.util.ar.j((View) this.agO, r.d.cp_cont_c);
        com.baidu.tbadk.core.util.ar.j((View) this.agP, r.d.cp_cont_c);
        com.baidu.tbadk.core.util.ar.l(this.agQ, r.d.cp_cont_c);
        com.baidu.tbadk.core.util.ar.j((View) this.agR, r.d.cp_cont_c);
        com.baidu.tbadk.core.util.ar.j((View) this.agS, r.d.cp_cont_c);
        com.baidu.tbadk.core.util.ar.j((View) this.agU, r.d.cp_cont_c);
        com.baidu.tbadk.core.util.ar.j((View) this.agT, r.d.cp_cont_c);
        com.baidu.tbadk.core.util.ar.k(this.agV, r.f.btn_frs_more_selector);
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.ahg = onClickListener;
    }

    public TextView getBarNameTv() {
        return this.agO;
    }

    public void h(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.ahj != null) {
            this.ahj.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.ahj);
        }
    }

    public void setLocationEnabled(boolean z) {
        this.aha = z;
    }

    public void setViewNumEnabled(boolean z) {
        this.ahd = z;
    }

    public View getCommentNumView() {
        return this.agT;
    }

    public void setCommentNumClickListener(View.OnClickListener onClickListener) {
        this.agT.setOnClickListener(onClickListener);
    }
}

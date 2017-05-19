package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
import java.util.List;
/* loaded from: classes.dex */
public class ThreadCommentAndPraiseInfoLayoutNew extends LinearLayout {
    private bk ahV;
    private TbPageContext ajr;
    private TextView alE;
    private TextView alI;
    private TextView alK;
    private FrameLayout alL;
    private List<CharSequence> alM;
    private List<String> alN;
    private boolean alR;
    private View.OnClickListener amc;
    public ClickableHeaderImageView amf;
    public TextView amg;
    public ViewStub amh;
    public TbImageView ami;
    private boolean amj;
    private View.OnClickListener amk;
    private View.OnClickListener aml;
    private Context mContext;
    private int mFrom;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadCommentAndPraiseInfoLayoutNew(Context context) {
        super(context);
        this.alR = true;
        this.amj = false;
        this.mFrom = 1;
        this.amc = new ao(this);
        this.aml = new ap(this);
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayoutNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.alR = true;
        this.amj = false;
        this.mFrom = 1;
        this.amc = new ao(this);
        this.aml = new ap(this);
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayoutNew(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.alR = true;
        this.amj = false;
        this.mFrom = 1;
        this.amc = new ao(this);
        this.aml = new ap(this);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(w.j.thread_comment_and_praise_info_layout_new, (ViewGroup) this, true);
        this.amf = (ClickableHeaderImageView) inflate.findViewById(w.h.card_home_page_normal_thread_user_header);
        this.amh = (ViewStub) inflate.findViewById(w.h.viewstub_headimage_mask);
        this.amg = (TextView) inflate.findViewById(w.h.card_home_page_normal_thread_user_name);
        this.alE = (TextView) inflate.findViewById(w.h.thread_info_reply_time);
        this.alI = (TextView) inflate.findViewById(w.h.thread_info_commont_num);
        this.alK = (TextView) inflate.findViewById(w.h.thread_info_more);
        this.alL = (FrameLayout) inflate.findViewById(w.h.thread_info_more_frame);
        setVerticalGravity(16);
        this.mContext = context;
        wC();
        this.amg.setOnClickListener(this.aml);
    }

    public boolean a(bk bkVar) {
        if (bkVar == null) {
            setVisibility(8);
            return false;
        }
        this.ahV = bkVar;
        h(bkVar);
        i(bkVar);
        e(bkVar);
        c(bkVar);
        setVisibility(0);
        return true;
    }

    private void wC() {
        if (this.amf != null) {
            this.amf.setDefaultResource(17170445);
            this.amf.setDefaultErrorResource(w.g.icon_default_avatar100);
            this.amf.setDefaultBgResource(w.e.cp_bg_line_e);
            this.amf.setIsRound(true);
            this.amf.setAfterClickListener(this.amk);
        }
    }

    private void h(bk bkVar) {
        if (this.amf != null && bkVar != null) {
            if (this.amj) {
                this.amf.setVisibility(8);
                return;
            }
            this.amf.setVisibility(0);
            this.amf.setData(bkVar);
            UserTbVipInfoData rz = bkVar.rz();
            if (rz != null && rz.getvipV_url() != null && this.amh != null) {
                if (this.ami == null) {
                    this.amh.inflate();
                    this.ami = (TbImageView) findViewById(w.h.user_head_mask);
                }
                this.ami.c(rz.getvipV_url(), 10, false);
                this.amf.setIsBigV(true);
            }
        }
    }

    private void i(bk bkVar) {
        if (this.amg != null && bkVar != null && !StringUtils.isNull(this.ahV.getAuthor().getName_show())) {
            this.amg.setText(com.baidu.tbadk.core.util.au.getFixedText(this.ahV.getAuthor().getName_show(), 8, true));
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
        }
    }

    private void e(bk bkVar) {
        if (this.alI != null && bkVar != null) {
            if (bkVar.rr() >= 0) {
                this.alI.setVisibility(0);
                this.alI.setText(String.format(this.mContext.getString(w.l.comment_num_tip), com.baidu.tbadk.core.util.au.t(bkVar.rr())));
                return;
            }
            this.alI.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wB() {
        if (this.ajr != null) {
            com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(this.ajr.getPageActivity());
            cVar.ca(w.l.operation);
            cVar.a(this.alM, new aq(this));
            cVar.d(this.ajr);
            cVar.tg();
        }
    }

    public void onChangeSkinType() {
        com.baidu.tbadk.core.util.aq.i(this.amg, w.e.cp_cont_d);
        com.baidu.tbadk.core.util.aq.i(this.alE, w.e.cp_cont_d);
        com.baidu.tbadk.core.util.aq.i(this.alI, w.e.cp_cont_d);
        com.baidu.tbadk.core.util.aq.j(this.alK, w.g.btn_frs_more_selector);
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

    public void setIsSimpleThread(boolean z) {
        this.amj = z;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.amk = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.amf != null) {
            this.amf.setPageId(bdUniqueId);
        }
    }

    public void wD() {
        this.amf.setClickable(false);
        this.amg.setClickable(false);
    }
}

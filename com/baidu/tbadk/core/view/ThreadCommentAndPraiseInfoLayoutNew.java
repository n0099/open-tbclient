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
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
import java.util.List;
/* loaded from: classes.dex */
public class ThreadCommentAndPraiseInfoLayoutNew extends LinearLayout {
    private bm aiu;
    private TbPageContext ajP;
    private View.OnClickListener amK;
    public ClickableHeaderImageView amN;
    public TextView amO;
    public ViewStub amP;
    public TbImageView amQ;
    private boolean amR;
    private View.OnClickListener amS;
    private View.OnClickListener amT;
    private TextView ami;
    private TextView amm;
    private TextView amp;
    private FrameLayout amq;
    private List<CharSequence> amr;
    private List<String> ams;
    private boolean amw;
    private Context mContext;
    private int mFrom;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadCommentAndPraiseInfoLayoutNew(Context context) {
        super(context);
        this.amw = true;
        this.amR = false;
        this.mFrom = 1;
        this.amK = new ao(this);
        this.amT = new ap(this);
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayoutNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.amw = true;
        this.amR = false;
        this.mFrom = 1;
        this.amK = new ao(this);
        this.amT = new ap(this);
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayoutNew(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.amw = true;
        this.amR = false;
        this.mFrom = 1;
        this.amK = new ao(this);
        this.amT = new ap(this);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(w.j.thread_comment_and_praise_info_layout_new, (ViewGroup) this, true);
        this.amN = (ClickableHeaderImageView) inflate.findViewById(w.h.card_home_page_normal_thread_user_header);
        this.amP = (ViewStub) inflate.findViewById(w.h.viewstub_headimage_mask);
        this.amO = (TextView) inflate.findViewById(w.h.card_home_page_normal_thread_user_name);
        this.ami = (TextView) inflate.findViewById(w.h.thread_info_reply_time);
        this.amm = (TextView) inflate.findViewById(w.h.thread_info_commont_num);
        this.amp = (TextView) inflate.findViewById(w.h.thread_info_more);
        this.amq = (FrameLayout) inflate.findViewById(w.h.thread_info_more_frame);
        setVerticalGravity(16);
        this.mContext = context;
        wQ();
        this.amO.setOnClickListener(this.amT);
    }

    public boolean a(bm bmVar) {
        if (bmVar == null) {
            setVisibility(8);
            return false;
        }
        this.aiu = bmVar;
        i(bmVar);
        j(bmVar);
        e(bmVar);
        c(bmVar);
        setVisibility(0);
        return true;
    }

    private void wQ() {
        if (this.amN != null) {
            this.amN.setDefaultResource(17170445);
            this.amN.setDefaultErrorResource(w.g.icon_default_avatar100);
            this.amN.setDefaultBgResource(w.e.cp_bg_line_e);
            this.amN.setIsRound(true);
            this.amN.setAfterClickListener(this.amS);
        }
    }

    private void i(bm bmVar) {
        if (this.amN != null && bmVar != null) {
            if (this.amR) {
                this.amN.setVisibility(8);
                return;
            }
            this.amN.setVisibility(0);
            this.amN.setData(bmVar);
            UserTbVipInfoData rr = bmVar.rr();
            if (rr != null && rr.getvipV_url() != null && this.amP != null) {
                if (this.amQ == null) {
                    this.amP.inflate();
                    this.amQ = (TbImageView) findViewById(w.h.user_head_mask);
                }
                this.amQ.c(rr.getvipV_url(), 10, false);
                this.amN.setIsBigV(true);
            }
        }
    }

    private void j(bm bmVar) {
        if (this.amO != null && bmVar != null && !StringUtils.isNull(this.aiu.getAuthor().getName_show())) {
            this.amO.setText(com.baidu.tbadk.core.util.aw.getFixedText(this.aiu.getAuthor().getName_show(), 8, true));
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
        }
    }

    private void e(bm bmVar) {
        if (this.amm != null && bmVar != null) {
            if (bmVar.rj() >= 0) {
                this.amm.setVisibility(0);
                this.amm.setText(String.format(this.mContext.getString(w.l.comment_num_tip), com.baidu.tbadk.core.util.aw.t(bmVar.rj())));
                return;
            }
            this.amm.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wP() {
        if (this.ajP != null) {
            com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(this.ajP.getPageActivity());
            cVar.cb(w.l.operation);
            cVar.a(this.amr, new aq(this));
            cVar.d(this.ajP);
            cVar.td();
        }
    }

    public void onChangeSkinType() {
        com.baidu.tbadk.core.util.as.i(this.amO, w.e.cp_cont_d);
        com.baidu.tbadk.core.util.as.i(this.ami, w.e.cp_cont_d);
        com.baidu.tbadk.core.util.as.i(this.amm, w.e.cp_cont_d);
        com.baidu.tbadk.core.util.as.j(this.amp, w.g.btn_frs_more_selector);
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

    public void setIsSimpleThread(boolean z) {
        this.amR = z;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.amS = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.amN != null) {
            this.amN.setPageId(bdUniqueId);
        }
    }

    public void wR() {
        this.amN.setClickable(false);
        this.amO.setClickable(false);
    }
}

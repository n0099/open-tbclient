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
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
import java.util.List;
/* loaded from: classes.dex */
public class ThreadCommentAndPraiseInfoLayoutNew extends LinearLayout {
    private bl ahM;
    private TbPageContext ajh;
    private TextView alA;
    private FrameLayout alB;
    private List<CharSequence> alC;
    private List<String> alD;
    private boolean alH;
    private View.OnClickListener alS;
    public ClickableHeaderImageView alV;
    public TextView alW;
    public ViewStub alX;
    public TbImageView alY;
    private boolean alZ;
    private TextView alu;
    private TextView aly;
    private View.OnClickListener ama;
    private View.OnClickListener amb;
    private Context mContext;
    private int mFrom;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadCommentAndPraiseInfoLayoutNew(Context context) {
        super(context);
        this.alH = true;
        this.alZ = false;
        this.mFrom = 1;
        this.alS = new ao(this);
        this.amb = new ap(this);
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayoutNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.alH = true;
        this.alZ = false;
        this.mFrom = 1;
        this.alS = new ao(this);
        this.amb = new ap(this);
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayoutNew(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.alH = true;
        this.alZ = false;
        this.mFrom = 1;
        this.alS = new ao(this);
        this.amb = new ap(this);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(w.j.thread_comment_and_praise_info_layout_new, (ViewGroup) this, true);
        this.alV = (ClickableHeaderImageView) inflate.findViewById(w.h.card_home_page_normal_thread_user_header);
        this.alX = (ViewStub) inflate.findViewById(w.h.viewstub_headimage_mask);
        this.alW = (TextView) inflate.findViewById(w.h.card_home_page_normal_thread_user_name);
        this.alu = (TextView) inflate.findViewById(w.h.thread_info_reply_time);
        this.aly = (TextView) inflate.findViewById(w.h.thread_info_commont_num);
        this.alA = (TextView) inflate.findViewById(w.h.thread_info_more);
        this.alB = (FrameLayout) inflate.findViewById(w.h.thread_info_more_frame);
        setVerticalGravity(16);
        this.mContext = context;
        wy();
        this.alW.setOnClickListener(this.amb);
    }

    public boolean a(bl blVar) {
        if (blVar == null) {
            setVisibility(8);
            return false;
        }
        this.ahM = blVar;
        h(blVar);
        i(blVar);
        e(blVar);
        c(blVar);
        setVisibility(0);
        return true;
    }

    private void wy() {
        if (this.alV != null) {
            this.alV.setDefaultResource(17170445);
            this.alV.setDefaultErrorResource(w.g.icon_default_avatar100);
            this.alV.setDefaultBgResource(w.e.cp_bg_line_e);
            this.alV.setIsRound(true);
            this.alV.setAfterClickListener(this.ama);
        }
    }

    private void h(bl blVar) {
        if (this.alV != null && blVar != null) {
            if (this.alZ) {
                this.alV.setVisibility(8);
                return;
            }
            this.alV.setVisibility(0);
            this.alV.setData(blVar);
            UserTbVipInfoData rv = blVar.rv();
            if (rv != null && rv.getvipV_url() != null && this.alX != null) {
                if (this.alY == null) {
                    this.alX.inflate();
                    this.alY = (TbImageView) findViewById(w.h.user_head_mask);
                }
                this.alY.c(rv.getvipV_url(), 10, false);
                this.alV.setIsBigV(true);
            }
        }
    }

    private void i(bl blVar) {
        if (this.alW != null && blVar != null && !StringUtils.isNull(this.ahM.getAuthor().getName_show())) {
            this.alW.setText(com.baidu.tbadk.core.util.au.getFixedText(this.ahM.getAuthor().getName_show(), 8, true));
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
        }
    }

    private void e(bl blVar) {
        if (this.aly != null && blVar != null) {
            if (blVar.rn() >= 0) {
                this.aly.setVisibility(0);
                this.aly.setText(String.format(this.mContext.getString(w.l.comment_num_tip), com.baidu.tbadk.core.util.au.t(blVar.rn())));
                return;
            }
            this.aly.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wx() {
        if (this.ajh != null) {
            com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(this.ajh.getPageActivity());
            cVar.cb(w.l.operation);
            cVar.a(this.alC, new aq(this));
            cVar.d(this.ajh);
            cVar.tf();
        }
    }

    public void onChangeSkinType() {
        com.baidu.tbadk.core.util.aq.i(this.alW, w.e.cp_cont_d);
        com.baidu.tbadk.core.util.aq.i(this.alu, w.e.cp_cont_d);
        com.baidu.tbadk.core.util.aq.i(this.aly, w.e.cp_cont_d);
        com.baidu.tbadk.core.util.aq.j(this.alA, w.g.btn_frs_more_selector);
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

    public void setIsSimpleThread(boolean z) {
        this.alZ = z;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.ama = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.alV != null) {
            this.alV.setPageId(bdUniqueId);
        }
    }

    public void wz() {
        this.alV.setClickable(false);
        this.alW.setClickable(false);
    }
}

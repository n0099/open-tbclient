package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.card.ac;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class NewThreadCommentAndPraiseInfoLayout extends ThreadCommentAndPraiseInfoLayout {
    private int ZK;

    private void init(Context context) {
        this.bSN = d.f.icon_home_card_share;
        this.bSM = d.f.icon_home_card_comment;
    }

    public NewThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.ZK = 11;
        init(context);
    }

    public NewThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ZK = 11;
        init(context);
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected View da(Context context) {
        return LayoutInflater.from(context).inflate(d.h.new_thread_comment_and_praise_info_layout, (ViewGroup) this, true);
    }

    public void setShowFlag(int i) {
        this.ZK = i;
        rE();
    }

    private void rE() {
        this.bSl.setVisibility(bB(1) ? 0 : 8);
        this.bSi.setVisibility(bB(2) ? 0 : 8);
        this.bSs.setVisibility(bB(4) ? 0 : 8);
        this.bSf.setVisibility(bB(8) ? 0 : 8);
    }

    private boolean bB(int i) {
        return (this.ZK & i) > 0;
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updatePraiseNum(bg bgVar) {
        if (bgVar.aaE() != null) {
            bgVar.aaE().isInThread = true;
            this.bSf.setData(bgVar.aaE());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void o(bg bgVar) {
        if (this.bSl != null && this.bSj != null && bgVar != null) {
            if (this.bSF) {
                this.bSl.setVisibility(0);
                long aal = bgVar.aal();
                if ((bgVar.ZZ() || bgVar.aac()) && bgVar.Zh() != null) {
                    aal = bgVar.Zh().share_info.share_count;
                }
                this.bSj.setText(aal > 0 ? ap.az(aal) : this.mContext.getString(d.j.share));
                this.bSx = true;
                if (bgVar.bDy != null && bgVar.bDy.isDeleted) {
                    setShareClickable(false);
                    al.k(this.bSk, d.f.icon_card_share_d);
                    al.j(this.bSj, d.C0277d.cp_cont_e);
                    return;
                }
                setShareClickable(true);
                al.k(this.bSk, this.bSN);
                al.j(this.bSj, d.f.selector_comment_and_prise_item_text_color);
                return;
            }
            this.bSl.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void p(bg bgVar) {
        if (this.bSg != null && bgVar != null) {
            if (this.bSD) {
                this.bSi.setVisibility(0);
                if (bgVar.YF() > 0) {
                    this.bSg.setVisibility(0);
                    String az = ap.az(bgVar.YF());
                    if (this.bSB) {
                        this.bSh.setImageDrawable(al.getDrawable(this.bSM));
                        this.bSg.setText(az);
                    } else {
                        this.bSg.setText(String.format(this.mContext.getString(d.j.reply_num_tip), az));
                    }
                    this.bSg.setContentDescription(this.mContext.getString(d.j.reply_num) + az);
                    this.bSx = true;
                    return;
                } else if (this.bSB) {
                    this.bSh.setImageDrawable(al.getDrawable(this.bSM));
                    this.bSg.setText(this.mContext.getString(d.j.action_comment_default));
                    this.bSg.setVisibility(0);
                    this.bSx = true;
                    return;
                } else {
                    this.bSg.setVisibility(8);
                    return;
                }
            }
            this.bSi.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void aH(View view) {
        if (this.bSt == null) {
            this.bSt = new ac(this.mPageContext, bB(16));
        }
        this.bSt.setData(this.XS);
        this.bSt.showDialog();
        TiebaStatic.log(new am("c12711"));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void q(bg bgVar) {
        if (this.bSs != null && bgVar != null) {
            this.bSG = bB(4);
            if (bgVar.bDH != null) {
                this.bSG = false;
            }
            if (this.bSG && (this.bSw == null || this.bSw.getVisibility() == 8)) {
                this.bSs.setVisibility(0);
                String string = this.mContext.getString(d.j.manage);
                this.bSq.setText(string);
                this.bSq.setContentDescription(string);
                this.bSx = true;
                return;
            }
            this.bSs.setVisibility(8);
        }
    }

    public void setAgreeStatisticData(com.baidu.tbadk.core.data.d dVar) {
        if (this.bSf != null) {
            this.bSf.setStatisticData(dVar);
        }
    }
}

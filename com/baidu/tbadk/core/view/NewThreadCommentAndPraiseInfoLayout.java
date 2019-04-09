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
    private int ZL;

    private void init(Context context) {
        this.bSO = d.f.icon_home_card_share;
        this.bSN = d.f.icon_home_card_comment;
    }

    public NewThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.ZL = 11;
        init(context);
    }

    public NewThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ZL = 11;
        init(context);
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected View da(Context context) {
        return LayoutInflater.from(context).inflate(d.h.new_thread_comment_and_praise_info_layout, (ViewGroup) this, true);
    }

    public void setShowFlag(int i) {
        this.ZL = i;
        rE();
    }

    private void rE() {
        this.bSm.setVisibility(bB(1) ? 0 : 8);
        this.bSj.setVisibility(bB(2) ? 0 : 8);
        this.bSt.setVisibility(bB(4) ? 0 : 8);
        this.bSg.setVisibility(bB(8) ? 0 : 8);
    }

    private boolean bB(int i) {
        return (this.ZL & i) > 0;
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updatePraiseNum(bg bgVar) {
        if (bgVar.aaE() != null) {
            bgVar.aaE().isInThread = true;
            this.bSg.setData(bgVar.aaE());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void o(bg bgVar) {
        if (this.bSm != null && this.bSk != null && bgVar != null) {
            if (this.bSG) {
                this.bSm.setVisibility(0);
                long aal = bgVar.aal();
                if ((bgVar.ZZ() || bgVar.aac()) && bgVar.Zh() != null) {
                    aal = bgVar.Zh().share_info.share_count;
                }
                this.bSk.setText(aal > 0 ? ap.az(aal) : this.mContext.getString(d.j.share));
                this.bSy = true;
                if (bgVar.bDz != null && bgVar.bDz.isDeleted) {
                    setShareClickable(false);
                    al.k(this.bSl, d.f.icon_card_share_d);
                    al.j(this.bSk, d.C0277d.cp_cont_e);
                    return;
                }
                setShareClickable(true);
                al.k(this.bSl, this.bSO);
                al.j(this.bSk, d.f.selector_comment_and_prise_item_text_color);
                return;
            }
            this.bSm.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void p(bg bgVar) {
        if (this.bSh != null && bgVar != null) {
            if (this.bSE) {
                this.bSj.setVisibility(0);
                if (bgVar.YF() > 0) {
                    this.bSh.setVisibility(0);
                    String az = ap.az(bgVar.YF());
                    if (this.bSC) {
                        this.bSi.setImageDrawable(al.getDrawable(this.bSN));
                        this.bSh.setText(az);
                    } else {
                        this.bSh.setText(String.format(this.mContext.getString(d.j.reply_num_tip), az));
                    }
                    this.bSh.setContentDescription(this.mContext.getString(d.j.reply_num) + az);
                    this.bSy = true;
                    return;
                } else if (this.bSC) {
                    this.bSi.setImageDrawable(al.getDrawable(this.bSN));
                    this.bSh.setText(this.mContext.getString(d.j.action_comment_default));
                    this.bSh.setVisibility(0);
                    this.bSy = true;
                    return;
                } else {
                    this.bSh.setVisibility(8);
                    return;
                }
            }
            this.bSj.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void aH(View view) {
        if (this.bSu == null) {
            this.bSu = new ac(this.mPageContext, bB(16));
        }
        this.bSu.setData(this.XT);
        this.bSu.showDialog();
        TiebaStatic.log(new am("c12711"));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void q(bg bgVar) {
        if (this.bSt != null && bgVar != null) {
            this.bSH = bB(4);
            if (bgVar.bDI != null) {
                this.bSH = false;
            }
            if (this.bSH && (this.bSx == null || this.bSx.getVisibility() == 8)) {
                this.bSt.setVisibility(0);
                String string = this.mContext.getString(d.j.manage);
                this.bSr.setText(string);
                this.bSr.setContentDescription(string);
                this.bSy = true;
                return;
            }
            this.bSt.setVisibility(8);
        }
    }

    public void setAgreeStatisticData(com.baidu.tbadk.core.data.d dVar) {
        if (this.bSg != null) {
            this.bSg.setStatisticData(dVar);
        }
    }
}

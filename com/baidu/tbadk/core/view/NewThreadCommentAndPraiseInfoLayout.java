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
    private int ZJ;

    private void init(Context context) {
        this.bSL = d.f.icon_home_card_share;
        this.bSK = d.f.icon_home_card_comment;
    }

    public NewThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.ZJ = 11;
        init(context);
    }

    public NewThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ZJ = 11;
        init(context);
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected View da(Context context) {
        return LayoutInflater.from(context).inflate(d.h.new_thread_comment_and_praise_info_layout, (ViewGroup) this, true);
    }

    public void setShowFlag(int i) {
        this.ZJ = i;
        rE();
    }

    private void rE() {
        this.bSj.setVisibility(bC(1) ? 0 : 8);
        this.bSg.setVisibility(bC(2) ? 0 : 8);
        this.bSq.setVisibility(bC(4) ? 0 : 8);
        this.bSd.setVisibility(bC(8) ? 0 : 8);
    }

    private boolean bC(int i) {
        return (this.ZJ & i) > 0;
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updatePraiseNum(bg bgVar) {
        if (bgVar.aaH() != null) {
            bgVar.aaH().isInThread = true;
            this.bSd.setData(bgVar.aaH());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void o(bg bgVar) {
        if (this.bSj != null && this.bSh != null && bgVar != null) {
            if (this.bSD) {
                this.bSj.setVisibility(0);
                long aao = bgVar.aao();
                if ((bgVar.aac() || bgVar.aaf()) && bgVar.Zk() != null) {
                    aao = bgVar.Zk().share_info.share_count;
                }
                this.bSh.setText(aao > 0 ? ap.az(aao) : this.mContext.getString(d.j.share));
                this.bSv = true;
                if (bgVar.bDv != null && bgVar.bDv.isDeleted) {
                    setShareClickable(false);
                    al.k(this.bSi, d.f.icon_card_share_d);
                    al.j(this.bSh, d.C0277d.cp_cont_e);
                    return;
                }
                setShareClickable(true);
                al.k(this.bSi, this.bSL);
                al.j(this.bSh, d.f.selector_comment_and_prise_item_text_color);
                return;
            }
            this.bSj.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void p(bg bgVar) {
        if (this.bSe != null && bgVar != null) {
            if (this.bSB) {
                this.bSg.setVisibility(0);
                if (bgVar.YI() > 0) {
                    this.bSe.setVisibility(0);
                    String az = ap.az(bgVar.YI());
                    if (this.bSz) {
                        this.bSf.setImageDrawable(al.getDrawable(this.bSK));
                        this.bSe.setText(az);
                    } else {
                        this.bSe.setText(String.format(this.mContext.getString(d.j.reply_num_tip), az));
                    }
                    this.bSe.setContentDescription(this.mContext.getString(d.j.reply_num) + az);
                    this.bSv = true;
                    return;
                } else if (this.bSz) {
                    this.bSf.setImageDrawable(al.getDrawable(this.bSK));
                    this.bSe.setText(this.mContext.getString(d.j.action_comment_default));
                    this.bSe.setVisibility(0);
                    this.bSv = true;
                    return;
                } else {
                    this.bSe.setVisibility(8);
                    return;
                }
            }
            this.bSg.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void aH(View view) {
        if (this.bSr == null) {
            this.bSr = new ac(this.mPageContext, bC(16));
        }
        this.bSr.setData(this.XS);
        this.bSr.showDialog();
        TiebaStatic.log(new am("c12711"));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void q(bg bgVar) {
        if (this.bSq != null && bgVar != null) {
            this.bSE = bC(4);
            if (bgVar.bDE != null) {
                this.bSE = false;
            }
            if (this.bSE && (this.bSu == null || this.bSu.getVisibility() == 8)) {
                this.bSq.setVisibility(0);
                String string = this.mContext.getString(d.j.manage);
                this.bSo.setText(string);
                this.bSo.setContentDescription(string);
                this.bSv = true;
                return;
            }
            this.bSq.setVisibility(8);
        }
    }

    public void setAgreeStatisticData(com.baidu.tbadk.core.data.d dVar) {
        if (this.bSd != null) {
            this.bSd.setStatisticData(dVar);
        }
    }
}

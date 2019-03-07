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
    private int ZI;

    private void init(Context context) {
        this.bSK = d.f.icon_home_card_share;
        this.bSJ = d.f.icon_home_card_comment;
    }

    public NewThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.ZI = 11;
        init(context);
    }

    public NewThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ZI = 11;
        init(context);
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected View da(Context context) {
        return LayoutInflater.from(context).inflate(d.h.new_thread_comment_and_praise_info_layout, (ViewGroup) this, true);
    }

    public void setShowFlag(int i) {
        this.ZI = i;
        rE();
    }

    private void rE() {
        this.bSi.setVisibility(bC(1) ? 0 : 8);
        this.bSf.setVisibility(bC(2) ? 0 : 8);
        this.bSp.setVisibility(bC(4) ? 0 : 8);
        this.bSc.setVisibility(bC(8) ? 0 : 8);
    }

    private boolean bC(int i) {
        return (this.ZI & i) > 0;
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updatePraiseNum(bg bgVar) {
        if (bgVar.aaH() != null) {
            bgVar.aaH().isInThread = true;
            this.bSc.setData(bgVar.aaH());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void o(bg bgVar) {
        if (this.bSi != null && this.bSg != null && bgVar != null) {
            if (this.bSC) {
                this.bSi.setVisibility(0);
                long aao = bgVar.aao();
                if ((bgVar.aac() || bgVar.aaf()) && bgVar.Zk() != null) {
                    aao = bgVar.Zk().share_info.share_count;
                }
                this.bSg.setText(aao > 0 ? ap.az(aao) : this.mContext.getString(d.j.share));
                this.bSu = true;
                if (bgVar.bDt != null && bgVar.bDt.isDeleted) {
                    setShareClickable(false);
                    al.k(this.bSh, d.f.icon_card_share_d);
                    al.j(this.bSg, d.C0236d.cp_cont_e);
                    return;
                }
                setShareClickable(true);
                al.k(this.bSh, this.bSK);
                al.j(this.bSg, d.f.selector_comment_and_prise_item_text_color);
                return;
            }
            this.bSi.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void p(bg bgVar) {
        if (this.bSd != null && bgVar != null) {
            if (this.bSA) {
                this.bSf.setVisibility(0);
                if (bgVar.YI() > 0) {
                    this.bSd.setVisibility(0);
                    String az = ap.az(bgVar.YI());
                    if (this.bSy) {
                        this.bSe.setImageDrawable(al.getDrawable(this.bSJ));
                        this.bSd.setText(az);
                    } else {
                        this.bSd.setText(String.format(this.mContext.getString(d.j.reply_num_tip), az));
                    }
                    this.bSd.setContentDescription(this.mContext.getString(d.j.reply_num) + az);
                    this.bSu = true;
                    return;
                } else if (this.bSy) {
                    this.bSe.setImageDrawable(al.getDrawable(this.bSJ));
                    this.bSd.setText(this.mContext.getString(d.j.action_comment_default));
                    this.bSd.setVisibility(0);
                    this.bSu = true;
                    return;
                } else {
                    this.bSd.setVisibility(8);
                    return;
                }
            }
            this.bSf.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void aH(View view) {
        if (this.bSq == null) {
            this.bSq = new ac(this.mPageContext, bC(16));
        }
        this.bSq.setData(this.XR);
        this.bSq.showDialog();
        TiebaStatic.log(new am("c12711"));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void q(bg bgVar) {
        if (this.bSp != null && bgVar != null) {
            this.bSD = bC(4);
            if (bgVar.bDC != null) {
                this.bSD = false;
            }
            if (this.bSD && (this.bSt == null || this.bSt.getVisibility() == 8)) {
                this.bSp.setVisibility(0);
                String string = this.mContext.getString(d.j.manage);
                this.bSn.setText(string);
                this.bSn.setContentDescription(string);
                this.bSu = true;
                return;
            }
            this.bSp.setVisibility(8);
        }
    }

    public void setAgreeStatisticData(com.baidu.tbadk.core.data.d dVar) {
        if (this.bSc != null) {
            this.bSc.setStatisticData(dVar);
        }
    }
}

package com.baidu.tbadk.core.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ac;
/* loaded from: classes3.dex */
public class NewThreadCommentAndPraiseInfoLayout extends ThreadCommentAndPraiseInfoLayout {
    private int HR;
    CustomMessageListener coV;
    CustomMessageListener coW;

    private void init(Context context) {
        this.cqX = R.drawable.icon_home_card_share;
        this.cqW = R.drawable.icon_home_card_comment;
    }

    public NewThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.HR = 11;
        this.coV = new CustomMessageListener(2921416) { // from class: com.baidu.tbadk.core.view.NewThreadCommentAndPraiseInfoLayout.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bh)) {
                    bh bhVar = (bh) customResponsedMessage.getData();
                    if (NewThreadCommentAndPraiseInfoLayout.this.FT != null && bhVar != null && !TextUtils.isEmpty(NewThreadCommentAndPraiseInfoLayout.this.FT.getId()) && NewThreadCommentAndPraiseInfoLayout.this.FT.getId().equals(bhVar.getId())) {
                        NewThreadCommentAndPraiseInfoLayout.this.FT.hI(bhVar.aix());
                        NewThreadCommentAndPraiseInfoLayout.this.r(bhVar);
                    }
                }
            }
        };
        this.coW = new CustomMessageListener(2921417) { // from class: com.baidu.tbadk.core.view.NewThreadCommentAndPraiseInfoLayout.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(str) && NewThreadCommentAndPraiseInfoLayout.this.FT != null && str.equals(NewThreadCommentAndPraiseInfoLayout.this.FT.getId())) {
                        if ((NewThreadCommentAndPraiseInfoLayout.this.FT.ajQ() || NewThreadCommentAndPraiseInfoLayout.this.FT.ajT()) && NewThreadCommentAndPraiseInfoLayout.this.FT.aiZ() != null) {
                            if (NewThreadCommentAndPraiseInfoLayout.this.FT.aiZ() != null && NewThreadCommentAndPraiseInfoLayout.this.FT.aiZ().share_info != null) {
                                NewThreadCommentAndPraiseInfoLayout.this.FT.aiZ().share_info.share_count++;
                            }
                        } else {
                            NewThreadCommentAndPraiseInfoLayout.this.FT.aN(NewThreadCommentAndPraiseInfoLayout.this.FT.akc() + 1);
                        }
                        NewThreadCommentAndPraiseInfoLayout.this.q(NewThreadCommentAndPraiseInfoLayout.this.FT);
                    }
                }
            }
        };
        init(context);
    }

    public NewThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.HR = 11;
        this.coV = new CustomMessageListener(2921416) { // from class: com.baidu.tbadk.core.view.NewThreadCommentAndPraiseInfoLayout.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bh)) {
                    bh bhVar = (bh) customResponsedMessage.getData();
                    if (NewThreadCommentAndPraiseInfoLayout.this.FT != null && bhVar != null && !TextUtils.isEmpty(NewThreadCommentAndPraiseInfoLayout.this.FT.getId()) && NewThreadCommentAndPraiseInfoLayout.this.FT.getId().equals(bhVar.getId())) {
                        NewThreadCommentAndPraiseInfoLayout.this.FT.hI(bhVar.aix());
                        NewThreadCommentAndPraiseInfoLayout.this.r(bhVar);
                    }
                }
            }
        };
        this.coW = new CustomMessageListener(2921417) { // from class: com.baidu.tbadk.core.view.NewThreadCommentAndPraiseInfoLayout.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(str) && NewThreadCommentAndPraiseInfoLayout.this.FT != null && str.equals(NewThreadCommentAndPraiseInfoLayout.this.FT.getId())) {
                        if ((NewThreadCommentAndPraiseInfoLayout.this.FT.ajQ() || NewThreadCommentAndPraiseInfoLayout.this.FT.ajT()) && NewThreadCommentAndPraiseInfoLayout.this.FT.aiZ() != null) {
                            if (NewThreadCommentAndPraiseInfoLayout.this.FT.aiZ() != null && NewThreadCommentAndPraiseInfoLayout.this.FT.aiZ().share_info != null) {
                                NewThreadCommentAndPraiseInfoLayout.this.FT.aiZ().share_info.share_count++;
                            }
                        } else {
                            NewThreadCommentAndPraiseInfoLayout.this.FT.aN(NewThreadCommentAndPraiseInfoLayout.this.FT.akc() + 1);
                        }
                        NewThreadCommentAndPraiseInfoLayout.this.q(NewThreadCommentAndPraiseInfoLayout.this.FT);
                    }
                }
            }
        };
        init(context);
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected View cs(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.new_thread_comment_and_praise_info_layout, (ViewGroup) this, true);
    }

    public void setShowFlag(int i) {
        this.HR = i;
        mc();
    }

    private void mc() {
        this.cqv.setVisibility(aN(1) ? 0 : 8);
        this.cqs.setVisibility(aN(2) ? 0 : 8);
        this.cqC.setVisibility(aN(4) ? 0 : 8);
        this.cqp.setVisibility(aN(8) ? 0 : 8);
    }

    private boolean aN(int i) {
        return (this.HR & i) > 0;
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updatePraiseNum(bh bhVar) {
        if (bhVar.akv() != null) {
            bhVar.akv().isInThread = true;
            this.cqp.setData(bhVar.akv());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void q(bh bhVar) {
        if (this.cqv != null && this.cqt != null && bhVar != null) {
            if (this.cqP) {
                this.cqv.setVisibility(0);
                long akc = bhVar.akc();
                if ((bhVar.ajQ() || bhVar.ajT()) && bhVar.aiZ() != null && bhVar.aiZ().share_info != null) {
                    akc = bhVar.aiZ().share_info.share_count;
                }
                this.cqt.setText(akc > 0 ? aq.numFormatOverWan(akc) : this.mContext.getString(R.string.share));
                this.cqH = true;
                if (bhVar.cec != null && bhVar.cec.isDeleted) {
                    setShareClickable(false);
                    SvgManager.amN().a(this.cqu, R.drawable.icon_pure_pb_bottom_share_h_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    am.setViewTextColor(this.cqt, (int) R.color.cp_cont_e);
                    return;
                }
                setShareClickable(true);
                SvgManager.amN().a(this.cqu, R.drawable.icon_pure_pb_bottom_share_h_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                am.setViewTextColor(this.cqt, (int) R.drawable.selector_comment_and_prise_item_text_color);
                return;
            }
            this.cqv.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void r(bh bhVar) {
        if (this.cqq != null && bhVar != null) {
            if (this.cqN) {
                this.cqs.setVisibility(0);
                if (bhVar.aix() > 0) {
                    this.cqq.setVisibility(0);
                    String numFormatOverWan = aq.numFormatOverWan(bhVar.aix());
                    if (this.cqL) {
                        SvgManager.amN().a(this.cqr, R.drawable.icon_pure_pb_bottom_comment_n_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                        this.cqq.setText(numFormatOverWan);
                    } else {
                        this.cqq.setText(String.format(this.mContext.getString(R.string.reply_num_tip), numFormatOverWan));
                    }
                    this.cqq.setContentDescription(this.mContext.getString(R.string.reply_num) + numFormatOverWan);
                    this.cqH = true;
                    return;
                } else if (this.cqL) {
                    am.getDrawable(this.cqW);
                    SvgManager.amN().a(this.cqr, R.drawable.icon_pure_pb_bottom_comment_n_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    this.cqq.setText(this.mContext.getString(R.string.action_comment_default));
                    this.cqq.setVisibility(0);
                    this.cqH = true;
                    return;
                } else {
                    this.cqq.setVisibility(8);
                    return;
                }
            }
            this.cqs.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void aP(View view) {
        if (this.cqD == null) {
            this.cqD = new ac(this.mPageContext, aN(16));
        }
        this.cqD.setData(this.FT);
        this.cqD.showDialog();
        TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_BAR_MANAGE_CLICK));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void s(bh bhVar) {
        if (this.cqC != null && bhVar != null) {
            this.cqQ = aN(4);
            if (bhVar.cem != null) {
                this.cqQ = false;
            }
            if (this.cqQ && (this.cqG == null || this.cqG.getVisibility() == 8)) {
                this.cqC.setVisibility(0);
                String string = this.mContext.getString(R.string.manage);
                this.cqA.setText(string);
                this.cqA.setContentDescription(string);
                this.cqH = true;
                return;
            }
            this.cqC.setVisibility(8);
        }
    }

    public void setAgreeStatisticData(com.baidu.tbadk.core.data.d dVar) {
        if (this.cqp != null) {
            this.cqp.setStatisticData(dVar);
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void setGameId(int i) {
        super.setGameId(i);
        if (this.cqp != null) {
            this.cqp.setGameId(i);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.coV);
        MessageManager.getInstance().registerListener(this.coW);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.coV);
        MessageManager.getInstance().unRegisterListener(this.coW);
    }
}

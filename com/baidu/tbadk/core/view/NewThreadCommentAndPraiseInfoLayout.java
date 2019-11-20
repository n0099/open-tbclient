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
    private int Hr;
    CustomMessageListener coe;
    CustomMessageListener cof;

    private void init(Context context) {
        this.cqg = R.drawable.icon_home_card_share;
        this.cqf = R.drawable.icon_home_card_comment;
    }

    public NewThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.Hr = 11;
        this.coe = new CustomMessageListener(2921416) { // from class: com.baidu.tbadk.core.view.NewThreadCommentAndPraiseInfoLayout.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bh)) {
                    bh bhVar = (bh) customResponsedMessage.getData();
                    if (NewThreadCommentAndPraiseInfoLayout.this.Fs != null && bhVar != null && !TextUtils.isEmpty(NewThreadCommentAndPraiseInfoLayout.this.Fs.getId()) && NewThreadCommentAndPraiseInfoLayout.this.Fs.getId().equals(bhVar.getId())) {
                        NewThreadCommentAndPraiseInfoLayout.this.Fs.hH(bhVar.aiv());
                        NewThreadCommentAndPraiseInfoLayout.this.r(bhVar);
                    }
                }
            }
        };
        this.cof = new CustomMessageListener(2921417) { // from class: com.baidu.tbadk.core.view.NewThreadCommentAndPraiseInfoLayout.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(str) && NewThreadCommentAndPraiseInfoLayout.this.Fs != null && str.equals(NewThreadCommentAndPraiseInfoLayout.this.Fs.getId())) {
                        if ((NewThreadCommentAndPraiseInfoLayout.this.Fs.ajO() || NewThreadCommentAndPraiseInfoLayout.this.Fs.ajR()) && NewThreadCommentAndPraiseInfoLayout.this.Fs.aiX() != null) {
                            if (NewThreadCommentAndPraiseInfoLayout.this.Fs.aiX() != null && NewThreadCommentAndPraiseInfoLayout.this.Fs.aiX().share_info != null) {
                                NewThreadCommentAndPraiseInfoLayout.this.Fs.aiX().share_info.share_count++;
                            }
                        } else {
                            NewThreadCommentAndPraiseInfoLayout.this.Fs.aM(NewThreadCommentAndPraiseInfoLayout.this.Fs.aka() + 1);
                        }
                        NewThreadCommentAndPraiseInfoLayout.this.q(NewThreadCommentAndPraiseInfoLayout.this.Fs);
                    }
                }
            }
        };
        init(context);
    }

    public NewThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Hr = 11;
        this.coe = new CustomMessageListener(2921416) { // from class: com.baidu.tbadk.core.view.NewThreadCommentAndPraiseInfoLayout.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bh)) {
                    bh bhVar = (bh) customResponsedMessage.getData();
                    if (NewThreadCommentAndPraiseInfoLayout.this.Fs != null && bhVar != null && !TextUtils.isEmpty(NewThreadCommentAndPraiseInfoLayout.this.Fs.getId()) && NewThreadCommentAndPraiseInfoLayout.this.Fs.getId().equals(bhVar.getId())) {
                        NewThreadCommentAndPraiseInfoLayout.this.Fs.hH(bhVar.aiv());
                        NewThreadCommentAndPraiseInfoLayout.this.r(bhVar);
                    }
                }
            }
        };
        this.cof = new CustomMessageListener(2921417) { // from class: com.baidu.tbadk.core.view.NewThreadCommentAndPraiseInfoLayout.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(str) && NewThreadCommentAndPraiseInfoLayout.this.Fs != null && str.equals(NewThreadCommentAndPraiseInfoLayout.this.Fs.getId())) {
                        if ((NewThreadCommentAndPraiseInfoLayout.this.Fs.ajO() || NewThreadCommentAndPraiseInfoLayout.this.Fs.ajR()) && NewThreadCommentAndPraiseInfoLayout.this.Fs.aiX() != null) {
                            if (NewThreadCommentAndPraiseInfoLayout.this.Fs.aiX() != null && NewThreadCommentAndPraiseInfoLayout.this.Fs.aiX().share_info != null) {
                                NewThreadCommentAndPraiseInfoLayout.this.Fs.aiX().share_info.share_count++;
                            }
                        } else {
                            NewThreadCommentAndPraiseInfoLayout.this.Fs.aM(NewThreadCommentAndPraiseInfoLayout.this.Fs.aka() + 1);
                        }
                        NewThreadCommentAndPraiseInfoLayout.this.q(NewThreadCommentAndPraiseInfoLayout.this.Fs);
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
        this.Hr = i;
        mc();
    }

    private void mc() {
        this.cpE.setVisibility(aN(1) ? 0 : 8);
        this.cpB.setVisibility(aN(2) ? 0 : 8);
        this.cpL.setVisibility(aN(4) ? 0 : 8);
        this.cpy.setVisibility(aN(8) ? 0 : 8);
    }

    private boolean aN(int i) {
        return (this.Hr & i) > 0;
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updatePraiseNum(bh bhVar) {
        if (bhVar.akt() != null) {
            bhVar.akt().isInThread = true;
            this.cpy.setData(bhVar.akt());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void q(bh bhVar) {
        if (this.cpE != null && this.cpC != null && bhVar != null) {
            if (this.cpY) {
                this.cpE.setVisibility(0);
                long aka = bhVar.aka();
                if ((bhVar.ajO() || bhVar.ajR()) && bhVar.aiX() != null && bhVar.aiX().share_info != null) {
                    aka = bhVar.aiX().share_info.share_count;
                }
                this.cpC.setText(aka > 0 ? aq.numFormatOverWan(aka) : this.mContext.getString(R.string.share));
                this.cpQ = true;
                if (bhVar.cdl != null && bhVar.cdl.isDeleted) {
                    setShareClickable(false);
                    SvgManager.amL().a(this.cpD, R.drawable.icon_pure_pb_bottom_share_h_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    am.setViewTextColor(this.cpC, (int) R.color.cp_cont_e);
                    return;
                }
                setShareClickable(true);
                SvgManager.amL().a(this.cpD, R.drawable.icon_pure_pb_bottom_share_h_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                am.setViewTextColor(this.cpC, (int) R.drawable.selector_comment_and_prise_item_text_color);
                return;
            }
            this.cpE.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void r(bh bhVar) {
        if (this.cpz != null && bhVar != null) {
            if (this.cpW) {
                this.cpB.setVisibility(0);
                if (bhVar.aiv() > 0) {
                    this.cpz.setVisibility(0);
                    String numFormatOverWan = aq.numFormatOverWan(bhVar.aiv());
                    if (this.cpU) {
                        SvgManager.amL().a(this.cpA, R.drawable.icon_pure_pb_bottom_comment_n_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                        this.cpz.setText(numFormatOverWan);
                    } else {
                        this.cpz.setText(String.format(this.mContext.getString(R.string.reply_num_tip), numFormatOverWan));
                    }
                    this.cpz.setContentDescription(this.mContext.getString(R.string.reply_num) + numFormatOverWan);
                    this.cpQ = true;
                    return;
                } else if (this.cpU) {
                    am.getDrawable(this.cqf);
                    SvgManager.amL().a(this.cpA, R.drawable.icon_pure_pb_bottom_comment_n_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    this.cpz.setText(this.mContext.getString(R.string.action_comment_default));
                    this.cpz.setVisibility(0);
                    this.cpQ = true;
                    return;
                } else {
                    this.cpz.setVisibility(8);
                    return;
                }
            }
            this.cpB.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void aP(View view) {
        if (this.cpM == null) {
            this.cpM = new ac(this.mPageContext, aN(16));
        }
        this.cpM.setData(this.Fs);
        this.cpM.showDialog();
        TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_BAR_MANAGE_CLICK));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void s(bh bhVar) {
        if (this.cpL != null && bhVar != null) {
            this.cpZ = aN(4);
            if (bhVar.cdv != null) {
                this.cpZ = false;
            }
            if (this.cpZ && (this.cpP == null || this.cpP.getVisibility() == 8)) {
                this.cpL.setVisibility(0);
                String string = this.mContext.getString(R.string.manage);
                this.cpJ.setText(string);
                this.cpJ.setContentDescription(string);
                this.cpQ = true;
                return;
            }
            this.cpL.setVisibility(8);
        }
    }

    public void setAgreeStatisticData(com.baidu.tbadk.core.data.d dVar) {
        if (this.cpy != null) {
            this.cpy.setStatisticData(dVar);
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void setGameId(int i) {
        super.setGameId(i);
        if (this.cpy != null) {
            this.cpy.setGameId(i);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.coe);
        MessageManager.getInstance().registerListener(this.cof);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.coe);
        MessageManager.getInstance().unRegisterListener(this.cof);
    }
}

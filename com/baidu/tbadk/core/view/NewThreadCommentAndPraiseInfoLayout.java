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
    private int XX;
    CustomMessageListener car;
    CustomMessageListener cas;

    private void init(Context context) {
        this.ccK = R.drawable.icon_home_card_share;
        this.ccJ = R.drawable.icon_home_card_comment;
    }

    public NewThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.XX = 11;
        this.car = new CustomMessageListener(2921416) { // from class: com.baidu.tbadk.core.view.NewThreadCommentAndPraiseInfoLayout.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bh)) {
                    bh bhVar = (bh) customResponsedMessage.getData();
                    if (NewThreadCommentAndPraiseInfoLayout.this.Wd != null && bhVar != null && !TextUtils.isEmpty(NewThreadCommentAndPraiseInfoLayout.this.Wd.getId()) && NewThreadCommentAndPraiseInfoLayout.this.Wd.getId().equals(bhVar.getId())) {
                        NewThreadCommentAndPraiseInfoLayout.this.Wd.hj(bhVar.aet());
                        NewThreadCommentAndPraiseInfoLayout.this.r(bhVar);
                    }
                }
            }
        };
        this.cas = new CustomMessageListener(2921417) { // from class: com.baidu.tbadk.core.view.NewThreadCommentAndPraiseInfoLayout.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(str) && NewThreadCommentAndPraiseInfoLayout.this.Wd != null && str.equals(NewThreadCommentAndPraiseInfoLayout.this.Wd.getId())) {
                        if ((NewThreadCommentAndPraiseInfoLayout.this.Wd.afN() || NewThreadCommentAndPraiseInfoLayout.this.Wd.afQ()) && NewThreadCommentAndPraiseInfoLayout.this.Wd.aeV() != null) {
                            if (NewThreadCommentAndPraiseInfoLayout.this.Wd.aeV() != null && NewThreadCommentAndPraiseInfoLayout.this.Wd.aeV().share_info != null) {
                                NewThreadCommentAndPraiseInfoLayout.this.Wd.aeV().share_info.share_count++;
                            }
                        } else {
                            NewThreadCommentAndPraiseInfoLayout.this.Wd.au(NewThreadCommentAndPraiseInfoLayout.this.Wd.afZ() + 1);
                        }
                        NewThreadCommentAndPraiseInfoLayout.this.q(NewThreadCommentAndPraiseInfoLayout.this.Wd);
                    }
                }
            }
        };
        init(context);
    }

    public NewThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.XX = 11;
        this.car = new CustomMessageListener(2921416) { // from class: com.baidu.tbadk.core.view.NewThreadCommentAndPraiseInfoLayout.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bh)) {
                    bh bhVar = (bh) customResponsedMessage.getData();
                    if (NewThreadCommentAndPraiseInfoLayout.this.Wd != null && bhVar != null && !TextUtils.isEmpty(NewThreadCommentAndPraiseInfoLayout.this.Wd.getId()) && NewThreadCommentAndPraiseInfoLayout.this.Wd.getId().equals(bhVar.getId())) {
                        NewThreadCommentAndPraiseInfoLayout.this.Wd.hj(bhVar.aet());
                        NewThreadCommentAndPraiseInfoLayout.this.r(bhVar);
                    }
                }
            }
        };
        this.cas = new CustomMessageListener(2921417) { // from class: com.baidu.tbadk.core.view.NewThreadCommentAndPraiseInfoLayout.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(str) && NewThreadCommentAndPraiseInfoLayout.this.Wd != null && str.equals(NewThreadCommentAndPraiseInfoLayout.this.Wd.getId())) {
                        if ((NewThreadCommentAndPraiseInfoLayout.this.Wd.afN() || NewThreadCommentAndPraiseInfoLayout.this.Wd.afQ()) && NewThreadCommentAndPraiseInfoLayout.this.Wd.aeV() != null) {
                            if (NewThreadCommentAndPraiseInfoLayout.this.Wd.aeV() != null && NewThreadCommentAndPraiseInfoLayout.this.Wd.aeV().share_info != null) {
                                NewThreadCommentAndPraiseInfoLayout.this.Wd.aeV().share_info.share_count++;
                            }
                        } else {
                            NewThreadCommentAndPraiseInfoLayout.this.Wd.au(NewThreadCommentAndPraiseInfoLayout.this.Wd.afZ() + 1);
                        }
                        NewThreadCommentAndPraiseInfoLayout.this.q(NewThreadCommentAndPraiseInfoLayout.this.Wd);
                    }
                }
            }
        };
        init(context);
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected View cG(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.new_thread_comment_and_praise_info_layout, (ViewGroup) this, true);
    }

    public void setShowFlag(int i) {
        this.XX = i;
        qX();
    }

    private void qX() {
        this.cch.setVisibility(by(1) ? 0 : 8);
        this.cce.setVisibility(by(2) ? 0 : 8);
        this.cco.setVisibility(by(4) ? 0 : 8);
        this.ccb.setVisibility(by(8) ? 0 : 8);
    }

    private boolean by(int i) {
        return (this.XX & i) > 0;
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updatePraiseNum(bh bhVar) {
        if (bhVar.ags() != null) {
            bhVar.ags().isInThread = true;
            this.ccb.setData(bhVar.ags());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void q(bh bhVar) {
        if (this.cch != null && this.ccf != null && bhVar != null) {
            if (this.ccC) {
                this.cch.setVisibility(0);
                long afZ = bhVar.afZ();
                if ((bhVar.afN() || bhVar.afQ()) && bhVar.aeV() != null && bhVar.aeV().share_info != null) {
                    afZ = bhVar.aeV().share_info.share_count;
                }
                this.ccf.setText(afZ > 0 ? aq.aO(afZ) : this.mContext.getString(R.string.share));
                this.ccu = true;
                if (bhVar.bMt != null && bhVar.bMt.isDeleted) {
                    setShareClickable(false);
                    SvgManager.ajv().a(this.ccg, R.drawable.icon_pure_pb_bottom_share_h_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    am.j(this.ccf, R.color.cp_cont_e);
                    return;
                }
                setShareClickable(true);
                SvgManager.ajv().a(this.ccg, R.drawable.icon_pure_pb_bottom_share_h_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                am.j(this.ccf, R.drawable.selector_comment_and_prise_item_text_color);
                return;
            }
            this.cch.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void r(bh bhVar) {
        if (this.ccc != null && bhVar != null) {
            if (this.ccA) {
                this.cce.setVisibility(0);
                if (bhVar.aet() > 0) {
                    this.ccc.setVisibility(0);
                    String aO = aq.aO(bhVar.aet());
                    if (this.ccy) {
                        SvgManager.ajv().a(this.ccd, R.drawable.icon_pure_pb_bottom_comment_n_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                        this.ccc.setText(aO);
                    } else {
                        this.ccc.setText(String.format(this.mContext.getString(R.string.reply_num_tip), aO));
                    }
                    this.ccc.setContentDescription(this.mContext.getString(R.string.reply_num) + aO);
                    this.ccu = true;
                    return;
                } else if (this.ccy) {
                    am.getDrawable(this.ccJ);
                    SvgManager.ajv().a(this.ccd, R.drawable.icon_pure_pb_bottom_comment_n_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    this.ccc.setText(this.mContext.getString(R.string.action_comment_default));
                    this.ccc.setVisibility(0);
                    this.ccu = true;
                    return;
                } else {
                    this.ccc.setVisibility(8);
                    return;
                }
            }
            this.cce.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void aP(View view) {
        if (this.ccp == null) {
            this.ccp = new ac(this.mPageContext, by(16));
        }
        this.ccp.setData(this.Wd);
        this.ccp.showDialog();
        TiebaStatic.log(new an("c12711"));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void s(bh bhVar) {
        if (this.cco != null && bhVar != null) {
            this.ccD = by(4);
            if (bhVar.bMD != null) {
                this.ccD = false;
            }
            if (this.ccD && (this.cct == null || this.cct.getVisibility() == 8)) {
                this.cco.setVisibility(0);
                String string = this.mContext.getString(R.string.manage);
                this.ccm.setText(string);
                this.ccm.setContentDescription(string);
                this.ccu = true;
                return;
            }
            this.cco.setVisibility(8);
        }
    }

    public void setAgreeStatisticData(com.baidu.tbadk.core.data.d dVar) {
        if (this.ccb != null) {
            this.ccb.setStatisticData(dVar);
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void setGameId(int i) {
        super.setGameId(i);
        if (this.ccb != null) {
            this.ccb.setGameId(i);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.car);
        MessageManager.getInstance().registerListener(this.cas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.car);
        MessageManager.getInstance().unRegisterListener(this.cas);
    }
}

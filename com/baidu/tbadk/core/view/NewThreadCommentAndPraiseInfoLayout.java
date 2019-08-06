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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ac;
/* loaded from: classes3.dex */
public class NewThreadCommentAndPraiseInfoLayout extends ThreadCommentAndPraiseInfoLayout {
    private int XX;
    CustomMessageListener bZy;
    CustomMessageListener bZz;

    private void init(Context context) {
        this.cbQ = R.drawable.icon_home_card_share;
        this.cbP = R.drawable.icon_home_card_comment;
    }

    public NewThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.XX = 11;
        this.bZy = new CustomMessageListener(2921416) { // from class: com.baidu.tbadk.core.view.NewThreadCommentAndPraiseInfoLayout.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bh)) {
                    bh bhVar = (bh) customResponsedMessage.getData();
                    if (NewThreadCommentAndPraiseInfoLayout.this.We != null && bhVar != null && !TextUtils.isEmpty(NewThreadCommentAndPraiseInfoLayout.this.We.getId()) && NewThreadCommentAndPraiseInfoLayout.this.We.getId().equals(bhVar.getId())) {
                        NewThreadCommentAndPraiseInfoLayout.this.We.hi(bhVar.aep());
                        NewThreadCommentAndPraiseInfoLayout.this.q(bhVar);
                    }
                }
            }
        };
        this.bZz = new CustomMessageListener(2921417) { // from class: com.baidu.tbadk.core.view.NewThreadCommentAndPraiseInfoLayout.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(str) && NewThreadCommentAndPraiseInfoLayout.this.We != null && str.equals(NewThreadCommentAndPraiseInfoLayout.this.We.getId())) {
                        if ((NewThreadCommentAndPraiseInfoLayout.this.We.afJ() || NewThreadCommentAndPraiseInfoLayout.this.We.afM()) && NewThreadCommentAndPraiseInfoLayout.this.We.aeR() != null) {
                            if (NewThreadCommentAndPraiseInfoLayout.this.We.aeR() != null && NewThreadCommentAndPraiseInfoLayout.this.We.aeR().share_info != null) {
                                NewThreadCommentAndPraiseInfoLayout.this.We.aeR().share_info.share_count++;
                            }
                        } else {
                            NewThreadCommentAndPraiseInfoLayout.this.We.au(NewThreadCommentAndPraiseInfoLayout.this.We.afV() + 1);
                        }
                        NewThreadCommentAndPraiseInfoLayout.this.p(NewThreadCommentAndPraiseInfoLayout.this.We);
                    }
                }
            }
        };
        init(context);
    }

    public NewThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.XX = 11;
        this.bZy = new CustomMessageListener(2921416) { // from class: com.baidu.tbadk.core.view.NewThreadCommentAndPraiseInfoLayout.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bh)) {
                    bh bhVar = (bh) customResponsedMessage.getData();
                    if (NewThreadCommentAndPraiseInfoLayout.this.We != null && bhVar != null && !TextUtils.isEmpty(NewThreadCommentAndPraiseInfoLayout.this.We.getId()) && NewThreadCommentAndPraiseInfoLayout.this.We.getId().equals(bhVar.getId())) {
                        NewThreadCommentAndPraiseInfoLayout.this.We.hi(bhVar.aep());
                        NewThreadCommentAndPraiseInfoLayout.this.q(bhVar);
                    }
                }
            }
        };
        this.bZz = new CustomMessageListener(2921417) { // from class: com.baidu.tbadk.core.view.NewThreadCommentAndPraiseInfoLayout.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(str) && NewThreadCommentAndPraiseInfoLayout.this.We != null && str.equals(NewThreadCommentAndPraiseInfoLayout.this.We.getId())) {
                        if ((NewThreadCommentAndPraiseInfoLayout.this.We.afJ() || NewThreadCommentAndPraiseInfoLayout.this.We.afM()) && NewThreadCommentAndPraiseInfoLayout.this.We.aeR() != null) {
                            if (NewThreadCommentAndPraiseInfoLayout.this.We.aeR() != null && NewThreadCommentAndPraiseInfoLayout.this.We.aeR().share_info != null) {
                                NewThreadCommentAndPraiseInfoLayout.this.We.aeR().share_info.share_count++;
                            }
                        } else {
                            NewThreadCommentAndPraiseInfoLayout.this.We.au(NewThreadCommentAndPraiseInfoLayout.this.We.afV() + 1);
                        }
                        NewThreadCommentAndPraiseInfoLayout.this.p(NewThreadCommentAndPraiseInfoLayout.this.We);
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
        qW();
    }

    private void qW() {
        this.cbo.setVisibility(by(1) ? 0 : 8);
        this.cbl.setVisibility(by(2) ? 0 : 8);
        this.cbv.setVisibility(by(4) ? 0 : 8);
        this.cbi.setVisibility(by(8) ? 0 : 8);
    }

    private boolean by(int i) {
        return (this.XX & i) > 0;
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updatePraiseNum(bh bhVar) {
        if (bhVar.ago() != null) {
            bhVar.ago().isInThread = true;
            this.cbi.setData(bhVar.ago());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void p(bh bhVar) {
        if (this.cbo != null && this.cbm != null && bhVar != null) {
            if (this.cbI) {
                this.cbo.setVisibility(0);
                long afV = bhVar.afV();
                if ((bhVar.afJ() || bhVar.afM()) && bhVar.aeR() != null) {
                    afV = bhVar.aeR().share_info.share_count;
                }
                this.cbm.setText(afV > 0 ? aq.aO(afV) : this.mContext.getString(R.string.share));
                this.cbA = true;
                if (bhVar.bLV != null && bhVar.bLV.isDeleted) {
                    setShareClickable(false);
                    am.k(this.cbn, R.drawable.icon_card_share_d);
                    am.j(this.cbm, R.color.cp_cont_e);
                    return;
                }
                setShareClickable(true);
                am.k(this.cbn, this.cbQ);
                am.j(this.cbm, R.drawable.selector_comment_and_prise_item_text_color);
                return;
            }
            this.cbo.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void q(bh bhVar) {
        if (this.cbj != null && bhVar != null) {
            if (this.cbG) {
                this.cbl.setVisibility(0);
                if (bhVar.aep() > 0) {
                    this.cbj.setVisibility(0);
                    String aO = aq.aO(bhVar.aep());
                    if (this.cbE) {
                        this.cbk.setImageDrawable(am.getDrawable(this.cbP));
                        this.cbj.setText(aO);
                    } else {
                        this.cbj.setText(String.format(this.mContext.getString(R.string.reply_num_tip), aO));
                    }
                    this.cbj.setContentDescription(this.mContext.getString(R.string.reply_num) + aO);
                    this.cbA = true;
                    return;
                } else if (this.cbE) {
                    this.cbk.setImageDrawable(am.getDrawable(this.cbP));
                    this.cbj.setText(this.mContext.getString(R.string.action_comment_default));
                    this.cbj.setVisibility(0);
                    this.cbA = true;
                    return;
                } else {
                    this.cbj.setVisibility(8);
                    return;
                }
            }
            this.cbl.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void aP(View view) {
        if (this.cbw == null) {
            this.cbw = new ac(this.mPageContext, by(16));
        }
        this.cbw.setData(this.We);
        this.cbw.showDialog();
        TiebaStatic.log(new an("c12711"));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void r(bh bhVar) {
        if (this.cbv != null && bhVar != null) {
            this.cbJ = by(4);
            if (bhVar.bMf != null) {
                this.cbJ = false;
            }
            if (this.cbJ && (this.cbz == null || this.cbz.getVisibility() == 8)) {
                this.cbv.setVisibility(0);
                String string = this.mContext.getString(R.string.manage);
                this.cbt.setText(string);
                this.cbt.setContentDescription(string);
                this.cbA = true;
                return;
            }
            this.cbv.setVisibility(8);
        }
    }

    public void setAgreeStatisticData(com.baidu.tbadk.core.data.d dVar) {
        if (this.cbi != null) {
            this.cbi.setStatisticData(dVar);
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void setGameId(int i) {
        super.setGameId(i);
        if (this.cbi != null) {
            this.cbi.setGameId(i);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.bZy);
        MessageManager.getInstance().registerListener(this.bZz);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.bZy);
        MessageManager.getInstance().unRegisterListener(this.bZz);
    }
}

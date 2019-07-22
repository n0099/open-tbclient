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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ac;
/* loaded from: classes3.dex */
public class NewThreadCommentAndPraiseInfoLayout extends ThreadCommentAndPraiseInfoLayout {
    private int XX;
    CustomMessageListener bZs;
    CustomMessageListener bZt;

    private void init(Context context) {
        this.cbJ = R.drawable.icon_home_card_share;
        this.cbI = R.drawable.icon_home_card_comment;
    }

    public NewThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.XX = 11;
        this.bZs = new CustomMessageListener(2921416) { // from class: com.baidu.tbadk.core.view.NewThreadCommentAndPraiseInfoLayout.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bg)) {
                    bg bgVar = (bg) customResponsedMessage.getData();
                    if (NewThreadCommentAndPraiseInfoLayout.this.We != null && bgVar != null && !TextUtils.isEmpty(NewThreadCommentAndPraiseInfoLayout.this.We.getId()) && NewThreadCommentAndPraiseInfoLayout.this.We.getId().equals(bgVar.getId())) {
                        NewThreadCommentAndPraiseInfoLayout.this.We.hi(bgVar.aeo());
                        NewThreadCommentAndPraiseInfoLayout.this.p(bgVar);
                    }
                }
            }
        };
        this.bZt = new CustomMessageListener(2921417) { // from class: com.baidu.tbadk.core.view.NewThreadCommentAndPraiseInfoLayout.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(str) && NewThreadCommentAndPraiseInfoLayout.this.We != null && str.equals(NewThreadCommentAndPraiseInfoLayout.this.We.getId())) {
                        if ((NewThreadCommentAndPraiseInfoLayout.this.We.afI() || NewThreadCommentAndPraiseInfoLayout.this.We.afL()) && NewThreadCommentAndPraiseInfoLayout.this.We.aeQ() != null) {
                            if (NewThreadCommentAndPraiseInfoLayout.this.We.aeQ() != null && NewThreadCommentAndPraiseInfoLayout.this.We.aeQ().share_info != null) {
                                NewThreadCommentAndPraiseInfoLayout.this.We.aeQ().share_info.share_count++;
                            }
                        } else {
                            NewThreadCommentAndPraiseInfoLayout.this.We.au(NewThreadCommentAndPraiseInfoLayout.this.We.afU() + 1);
                        }
                        NewThreadCommentAndPraiseInfoLayout.this.o(NewThreadCommentAndPraiseInfoLayout.this.We);
                    }
                }
            }
        };
        init(context);
    }

    public NewThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.XX = 11;
        this.bZs = new CustomMessageListener(2921416) { // from class: com.baidu.tbadk.core.view.NewThreadCommentAndPraiseInfoLayout.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bg)) {
                    bg bgVar = (bg) customResponsedMessage.getData();
                    if (NewThreadCommentAndPraiseInfoLayout.this.We != null && bgVar != null && !TextUtils.isEmpty(NewThreadCommentAndPraiseInfoLayout.this.We.getId()) && NewThreadCommentAndPraiseInfoLayout.this.We.getId().equals(bgVar.getId())) {
                        NewThreadCommentAndPraiseInfoLayout.this.We.hi(bgVar.aeo());
                        NewThreadCommentAndPraiseInfoLayout.this.p(bgVar);
                    }
                }
            }
        };
        this.bZt = new CustomMessageListener(2921417) { // from class: com.baidu.tbadk.core.view.NewThreadCommentAndPraiseInfoLayout.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(str) && NewThreadCommentAndPraiseInfoLayout.this.We != null && str.equals(NewThreadCommentAndPraiseInfoLayout.this.We.getId())) {
                        if ((NewThreadCommentAndPraiseInfoLayout.this.We.afI() || NewThreadCommentAndPraiseInfoLayout.this.We.afL()) && NewThreadCommentAndPraiseInfoLayout.this.We.aeQ() != null) {
                            if (NewThreadCommentAndPraiseInfoLayout.this.We.aeQ() != null && NewThreadCommentAndPraiseInfoLayout.this.We.aeQ().share_info != null) {
                                NewThreadCommentAndPraiseInfoLayout.this.We.aeQ().share_info.share_count++;
                            }
                        } else {
                            NewThreadCommentAndPraiseInfoLayout.this.We.au(NewThreadCommentAndPraiseInfoLayout.this.We.afU() + 1);
                        }
                        NewThreadCommentAndPraiseInfoLayout.this.o(NewThreadCommentAndPraiseInfoLayout.this.We);
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
        this.cbh.setVisibility(by(1) ? 0 : 8);
        this.cbe.setVisibility(by(2) ? 0 : 8);
        this.cbo.setVisibility(by(4) ? 0 : 8);
        this.cbb.setVisibility(by(8) ? 0 : 8);
    }

    private boolean by(int i) {
        return (this.XX & i) > 0;
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updatePraiseNum(bg bgVar) {
        if (bgVar.agn() != null) {
            bgVar.agn().isInThread = true;
            this.cbb.setData(bgVar.agn());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void o(bg bgVar) {
        if (this.cbh != null && this.cbf != null && bgVar != null) {
            if (this.cbB) {
                this.cbh.setVisibility(0);
                long afU = bgVar.afU();
                if ((bgVar.afI() || bgVar.afL()) && bgVar.aeQ() != null) {
                    afU = bgVar.aeQ().share_info.share_count;
                }
                this.cbf.setText(afU > 0 ? aq.aO(afU) : this.mContext.getString(R.string.share));
                this.cbt = true;
                if (bgVar.bLQ != null && bgVar.bLQ.isDeleted) {
                    setShareClickable(false);
                    am.k(this.cbg, R.drawable.icon_card_share_d);
                    am.j(this.cbf, R.color.cp_cont_e);
                    return;
                }
                setShareClickable(true);
                am.k(this.cbg, this.cbJ);
                am.j(this.cbf, R.drawable.selector_comment_and_prise_item_text_color);
                return;
            }
            this.cbh.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void p(bg bgVar) {
        if (this.cbc != null && bgVar != null) {
            if (this.cbz) {
                this.cbe.setVisibility(0);
                if (bgVar.aeo() > 0) {
                    this.cbc.setVisibility(0);
                    String aO = aq.aO(bgVar.aeo());
                    if (this.cbx) {
                        this.cbd.setImageDrawable(am.getDrawable(this.cbI));
                        this.cbc.setText(aO);
                    } else {
                        this.cbc.setText(String.format(this.mContext.getString(R.string.reply_num_tip), aO));
                    }
                    this.cbc.setContentDescription(this.mContext.getString(R.string.reply_num) + aO);
                    this.cbt = true;
                    return;
                } else if (this.cbx) {
                    this.cbd.setImageDrawable(am.getDrawable(this.cbI));
                    this.cbc.setText(this.mContext.getString(R.string.action_comment_default));
                    this.cbc.setVisibility(0);
                    this.cbt = true;
                    return;
                } else {
                    this.cbc.setVisibility(8);
                    return;
                }
            }
            this.cbe.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void aP(View view) {
        if (this.cbp == null) {
            this.cbp = new ac(this.mPageContext, by(16));
        }
        this.cbp.setData(this.We);
        this.cbp.showDialog();
        TiebaStatic.log(new an("c12711"));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void q(bg bgVar) {
        if (this.cbo != null && bgVar != null) {
            this.cbC = by(4);
            if (bgVar.bMa != null) {
                this.cbC = false;
            }
            if (this.cbC && (this.cbs == null || this.cbs.getVisibility() == 8)) {
                this.cbo.setVisibility(0);
                String string = this.mContext.getString(R.string.manage);
                this.cbm.setText(string);
                this.cbm.setContentDescription(string);
                this.cbt = true;
                return;
            }
            this.cbo.setVisibility(8);
        }
    }

    public void setAgreeStatisticData(com.baidu.tbadk.core.data.d dVar) {
        if (this.cbb != null) {
            this.cbb.setStatisticData(dVar);
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void setGameId(int i) {
        super.setGameId(i);
        if (this.cbb != null) {
            this.cbb.setGameId(i);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.bZs);
        MessageManager.getInstance().registerListener(this.bZt);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.bZs);
        MessageManager.getInstance().unRegisterListener(this.bZt);
    }
}

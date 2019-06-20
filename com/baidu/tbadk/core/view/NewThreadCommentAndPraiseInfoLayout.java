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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ac;
/* loaded from: classes3.dex */
public class NewThreadCommentAndPraiseInfoLayout extends ThreadCommentAndPraiseInfoLayout {
    private int XC;
    CustomMessageListener bYq;
    CustomMessageListener bYr;

    private void init(Context context) {
        this.caH = R.drawable.icon_home_card_share;
        this.caG = R.drawable.icon_home_card_comment;
    }

    public NewThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.XC = 11;
        this.bYq = new CustomMessageListener(2921416) { // from class: com.baidu.tbadk.core.view.NewThreadCommentAndPraiseInfoLayout.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bg)) {
                    bg bgVar = (bg) customResponsedMessage.getData();
                    if (NewThreadCommentAndPraiseInfoLayout.this.VJ != null && bgVar != null && !TextUtils.isEmpty(NewThreadCommentAndPraiseInfoLayout.this.VJ.getId()) && NewThreadCommentAndPraiseInfoLayout.this.VJ.getId().equals(bgVar.getId())) {
                        NewThreadCommentAndPraiseInfoLayout.this.VJ.hc(bgVar.adm());
                        NewThreadCommentAndPraiseInfoLayout.this.p(bgVar);
                    }
                }
            }
        };
        this.bYr = new CustomMessageListener(2921417) { // from class: com.baidu.tbadk.core.view.NewThreadCommentAndPraiseInfoLayout.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(str) && NewThreadCommentAndPraiseInfoLayout.this.VJ != null && str.equals(NewThreadCommentAndPraiseInfoLayout.this.VJ.getId())) {
                        if ((NewThreadCommentAndPraiseInfoLayout.this.VJ.aeG() || NewThreadCommentAndPraiseInfoLayout.this.VJ.aeJ()) && NewThreadCommentAndPraiseInfoLayout.this.VJ.adO() != null) {
                            if (NewThreadCommentAndPraiseInfoLayout.this.VJ.adO() != null && NewThreadCommentAndPraiseInfoLayout.this.VJ.adO().share_info != null) {
                                NewThreadCommentAndPraiseInfoLayout.this.VJ.adO().share_info.share_count++;
                            }
                        } else {
                            NewThreadCommentAndPraiseInfoLayout.this.VJ.at(NewThreadCommentAndPraiseInfoLayout.this.VJ.aeS() + 1);
                        }
                        NewThreadCommentAndPraiseInfoLayout.this.o(NewThreadCommentAndPraiseInfoLayout.this.VJ);
                    }
                }
            }
        };
        init(context);
    }

    public NewThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.XC = 11;
        this.bYq = new CustomMessageListener(2921416) { // from class: com.baidu.tbadk.core.view.NewThreadCommentAndPraiseInfoLayout.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bg)) {
                    bg bgVar = (bg) customResponsedMessage.getData();
                    if (NewThreadCommentAndPraiseInfoLayout.this.VJ != null && bgVar != null && !TextUtils.isEmpty(NewThreadCommentAndPraiseInfoLayout.this.VJ.getId()) && NewThreadCommentAndPraiseInfoLayout.this.VJ.getId().equals(bgVar.getId())) {
                        NewThreadCommentAndPraiseInfoLayout.this.VJ.hc(bgVar.adm());
                        NewThreadCommentAndPraiseInfoLayout.this.p(bgVar);
                    }
                }
            }
        };
        this.bYr = new CustomMessageListener(2921417) { // from class: com.baidu.tbadk.core.view.NewThreadCommentAndPraiseInfoLayout.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(str) && NewThreadCommentAndPraiseInfoLayout.this.VJ != null && str.equals(NewThreadCommentAndPraiseInfoLayout.this.VJ.getId())) {
                        if ((NewThreadCommentAndPraiseInfoLayout.this.VJ.aeG() || NewThreadCommentAndPraiseInfoLayout.this.VJ.aeJ()) && NewThreadCommentAndPraiseInfoLayout.this.VJ.adO() != null) {
                            if (NewThreadCommentAndPraiseInfoLayout.this.VJ.adO() != null && NewThreadCommentAndPraiseInfoLayout.this.VJ.adO().share_info != null) {
                                NewThreadCommentAndPraiseInfoLayout.this.VJ.adO().share_info.share_count++;
                            }
                        } else {
                            NewThreadCommentAndPraiseInfoLayout.this.VJ.at(NewThreadCommentAndPraiseInfoLayout.this.VJ.aeS() + 1);
                        }
                        NewThreadCommentAndPraiseInfoLayout.this.o(NewThreadCommentAndPraiseInfoLayout.this.VJ);
                    }
                }
            }
        };
        init(context);
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected View cF(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.new_thread_comment_and_praise_info_layout, (ViewGroup) this, true);
    }

    public void setShowFlag(int i) {
        this.XC = i;
        qz();
    }

    private void qz() {
        this.caf.setVisibility(by(1) ? 0 : 8);
        this.cac.setVisibility(by(2) ? 0 : 8);
        this.cam.setVisibility(by(4) ? 0 : 8);
        this.bZZ.setVisibility(by(8) ? 0 : 8);
    }

    private boolean by(int i) {
        return (this.XC & i) > 0;
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updatePraiseNum(bg bgVar) {
        if (bgVar.afl() != null) {
            bgVar.afl().isInThread = true;
            this.bZZ.setData(bgVar.afl());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void o(bg bgVar) {
        if (this.caf != null && this.cad != null && bgVar != null) {
            if (this.caz) {
                this.caf.setVisibility(0);
                long aeS = bgVar.aeS();
                if ((bgVar.aeG() || bgVar.aeJ()) && bgVar.adO() != null) {
                    aeS = bgVar.adO().share_info.share_count;
                }
                this.cad.setText(aeS > 0 ? ap.aN(aeS) : this.mContext.getString(R.string.share));
                this.car = true;
                if (bgVar.bKQ != null && bgVar.bKQ.isDeleted) {
                    setShareClickable(false);
                    al.k(this.cae, R.drawable.icon_card_share_d);
                    al.j(this.cad, R.color.cp_cont_e);
                    return;
                }
                setShareClickable(true);
                al.k(this.cae, this.caH);
                al.j(this.cad, R.drawable.selector_comment_and_prise_item_text_color);
                return;
            }
            this.caf.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void p(bg bgVar) {
        if (this.caa != null && bgVar != null) {
            if (this.cax) {
                this.cac.setVisibility(0);
                if (bgVar.adm() > 0) {
                    this.caa.setVisibility(0);
                    String aN = ap.aN(bgVar.adm());
                    if (this.cav) {
                        this.cab.setImageDrawable(al.getDrawable(this.caG));
                        this.caa.setText(aN);
                    } else {
                        this.caa.setText(String.format(this.mContext.getString(R.string.reply_num_tip), aN));
                    }
                    this.caa.setContentDescription(this.mContext.getString(R.string.reply_num) + aN);
                    this.car = true;
                    return;
                } else if (this.cav) {
                    this.cab.setImageDrawable(al.getDrawable(this.caG));
                    this.caa.setText(this.mContext.getString(R.string.action_comment_default));
                    this.caa.setVisibility(0);
                    this.car = true;
                    return;
                } else {
                    this.caa.setVisibility(8);
                    return;
                }
            }
            this.cac.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void aN(View view) {
        if (this.can == null) {
            this.can = new ac(this.mPageContext, by(16));
        }
        this.can.setData(this.VJ);
        this.can.showDialog();
        TiebaStatic.log(new am("c12711"));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void q(bg bgVar) {
        if (this.cam != null && bgVar != null) {
            this.caA = by(4);
            if (bgVar.bLa != null) {
                this.caA = false;
            }
            if (this.caA && (this.caq == null || this.caq.getVisibility() == 8)) {
                this.cam.setVisibility(0);
                String string = this.mContext.getString(R.string.manage);
                this.cak.setText(string);
                this.cak.setContentDescription(string);
                this.car = true;
                return;
            }
            this.cam.setVisibility(8);
        }
    }

    public void setAgreeStatisticData(com.baidu.tbadk.core.data.d dVar) {
        if (this.bZZ != null) {
            this.bZZ.setStatisticData(dVar);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.bYq);
        MessageManager.getInstance().registerListener(this.bYr);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.bYq);
        MessageManager.getInstance().unRegisterListener(this.bYr);
    }
}

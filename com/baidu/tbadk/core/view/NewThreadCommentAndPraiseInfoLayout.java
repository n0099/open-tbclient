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
    private int XD;
    CustomMessageListener bYp;
    CustomMessageListener bYq;

    private void init(Context context) {
        this.caG = R.drawable.icon_home_card_share;
        this.caF = R.drawable.icon_home_card_comment;
    }

    public NewThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.XD = 11;
        this.bYp = new CustomMessageListener(2921416) { // from class: com.baidu.tbadk.core.view.NewThreadCommentAndPraiseInfoLayout.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bg)) {
                    bg bgVar = (bg) customResponsedMessage.getData();
                    if (NewThreadCommentAndPraiseInfoLayout.this.VK != null && bgVar != null && !TextUtils.isEmpty(NewThreadCommentAndPraiseInfoLayout.this.VK.getId()) && NewThreadCommentAndPraiseInfoLayout.this.VK.getId().equals(bgVar.getId())) {
                        NewThreadCommentAndPraiseInfoLayout.this.VK.hc(bgVar.adm());
                        NewThreadCommentAndPraiseInfoLayout.this.p(bgVar);
                    }
                }
            }
        };
        this.bYq = new CustomMessageListener(2921417) { // from class: com.baidu.tbadk.core.view.NewThreadCommentAndPraiseInfoLayout.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(str) && NewThreadCommentAndPraiseInfoLayout.this.VK != null && str.equals(NewThreadCommentAndPraiseInfoLayout.this.VK.getId())) {
                        if ((NewThreadCommentAndPraiseInfoLayout.this.VK.aeG() || NewThreadCommentAndPraiseInfoLayout.this.VK.aeJ()) && NewThreadCommentAndPraiseInfoLayout.this.VK.adO() != null) {
                            if (NewThreadCommentAndPraiseInfoLayout.this.VK.adO() != null && NewThreadCommentAndPraiseInfoLayout.this.VK.adO().share_info != null) {
                                NewThreadCommentAndPraiseInfoLayout.this.VK.adO().share_info.share_count++;
                            }
                        } else {
                            NewThreadCommentAndPraiseInfoLayout.this.VK.at(NewThreadCommentAndPraiseInfoLayout.this.VK.aeS() + 1);
                        }
                        NewThreadCommentAndPraiseInfoLayout.this.o(NewThreadCommentAndPraiseInfoLayout.this.VK);
                    }
                }
            }
        };
        init(context);
    }

    public NewThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.XD = 11;
        this.bYp = new CustomMessageListener(2921416) { // from class: com.baidu.tbadk.core.view.NewThreadCommentAndPraiseInfoLayout.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bg)) {
                    bg bgVar = (bg) customResponsedMessage.getData();
                    if (NewThreadCommentAndPraiseInfoLayout.this.VK != null && bgVar != null && !TextUtils.isEmpty(NewThreadCommentAndPraiseInfoLayout.this.VK.getId()) && NewThreadCommentAndPraiseInfoLayout.this.VK.getId().equals(bgVar.getId())) {
                        NewThreadCommentAndPraiseInfoLayout.this.VK.hc(bgVar.adm());
                        NewThreadCommentAndPraiseInfoLayout.this.p(bgVar);
                    }
                }
            }
        };
        this.bYq = new CustomMessageListener(2921417) { // from class: com.baidu.tbadk.core.view.NewThreadCommentAndPraiseInfoLayout.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(str) && NewThreadCommentAndPraiseInfoLayout.this.VK != null && str.equals(NewThreadCommentAndPraiseInfoLayout.this.VK.getId())) {
                        if ((NewThreadCommentAndPraiseInfoLayout.this.VK.aeG() || NewThreadCommentAndPraiseInfoLayout.this.VK.aeJ()) && NewThreadCommentAndPraiseInfoLayout.this.VK.adO() != null) {
                            if (NewThreadCommentAndPraiseInfoLayout.this.VK.adO() != null && NewThreadCommentAndPraiseInfoLayout.this.VK.adO().share_info != null) {
                                NewThreadCommentAndPraiseInfoLayout.this.VK.adO().share_info.share_count++;
                            }
                        } else {
                            NewThreadCommentAndPraiseInfoLayout.this.VK.at(NewThreadCommentAndPraiseInfoLayout.this.VK.aeS() + 1);
                        }
                        NewThreadCommentAndPraiseInfoLayout.this.o(NewThreadCommentAndPraiseInfoLayout.this.VK);
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
        this.XD = i;
        qz();
    }

    private void qz() {
        this.cae.setVisibility(by(1) ? 0 : 8);
        this.cab.setVisibility(by(2) ? 0 : 8);
        this.cal.setVisibility(by(4) ? 0 : 8);
        this.bZY.setVisibility(by(8) ? 0 : 8);
    }

    private boolean by(int i) {
        return (this.XD & i) > 0;
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updatePraiseNum(bg bgVar) {
        if (bgVar.afl() != null) {
            bgVar.afl().isInThread = true;
            this.bZY.setData(bgVar.afl());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void o(bg bgVar) {
        if (this.cae != null && this.cac != null && bgVar != null) {
            if (this.cay) {
                this.cae.setVisibility(0);
                long aeS = bgVar.aeS();
                if ((bgVar.aeG() || bgVar.aeJ()) && bgVar.adO() != null) {
                    aeS = bgVar.adO().share_info.share_count;
                }
                this.cac.setText(aeS > 0 ? ap.aN(aeS) : this.mContext.getString(R.string.share));
                this.caq = true;
                if (bgVar.bKP != null && bgVar.bKP.isDeleted) {
                    setShareClickable(false);
                    al.k(this.cad, R.drawable.icon_card_share_d);
                    al.j(this.cac, R.color.cp_cont_e);
                    return;
                }
                setShareClickable(true);
                al.k(this.cad, this.caG);
                al.j(this.cac, R.drawable.selector_comment_and_prise_item_text_color);
                return;
            }
            this.cae.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void p(bg bgVar) {
        if (this.bZZ != null && bgVar != null) {
            if (this.caw) {
                this.cab.setVisibility(0);
                if (bgVar.adm() > 0) {
                    this.bZZ.setVisibility(0);
                    String aN = ap.aN(bgVar.adm());
                    if (this.cau) {
                        this.caa.setImageDrawable(al.getDrawable(this.caF));
                        this.bZZ.setText(aN);
                    } else {
                        this.bZZ.setText(String.format(this.mContext.getString(R.string.reply_num_tip), aN));
                    }
                    this.bZZ.setContentDescription(this.mContext.getString(R.string.reply_num) + aN);
                    this.caq = true;
                    return;
                } else if (this.cau) {
                    this.caa.setImageDrawable(al.getDrawable(this.caF));
                    this.bZZ.setText(this.mContext.getString(R.string.action_comment_default));
                    this.bZZ.setVisibility(0);
                    this.caq = true;
                    return;
                } else {
                    this.bZZ.setVisibility(8);
                    return;
                }
            }
            this.cab.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void aN(View view) {
        if (this.cam == null) {
            this.cam = new ac(this.mPageContext, by(16));
        }
        this.cam.setData(this.VK);
        this.cam.showDialog();
        TiebaStatic.log(new am("c12711"));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void q(bg bgVar) {
        if (this.cal != null && bgVar != null) {
            this.caz = by(4);
            if (bgVar.bKZ != null) {
                this.caz = false;
            }
            if (this.caz && (this.cap == null || this.cap.getVisibility() == 8)) {
                this.cal.setVisibility(0);
                String string = this.mContext.getString(R.string.manage);
                this.caj.setText(string);
                this.caj.setContentDescription(string);
                this.caq = true;
                return;
            }
            this.cal.setVisibility(8);
        }
    }

    public void setAgreeStatisticData(com.baidu.tbadk.core.data.d dVar) {
        if (this.bZY != null) {
            this.bZY.setStatisticData(dVar);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.bYp);
        MessageManager.getInstance().registerListener(this.bYq);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.bYp);
        MessageManager.getInstance().unRegisterListener(this.bYq);
    }
}

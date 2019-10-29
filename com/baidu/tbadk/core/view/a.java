package com.baidu.tbadk.core.view;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class a {
    private bh FT;
    private PraiseView cmm;
    private DisPraiseView cmn;
    private final View.OnClickListener cmo = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.updateUI();
        }
    };
    private CustomMessageListener cmp = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bh bhVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j) && a.this.FT != null && !TextUtils.isEmpty(a.this.FT.getTid()) && (bhVar = ((com.baidu.tbadk.data.j) customResponsedMessage.getData()).cEd) != null && a.this.FT.getTid().equals(bhVar.getTid())) {
                a.this.FT.hR(bhVar.akb());
                a.this.FT.hP(bhVar.aka());
                a.this.FT.aL(bhVar.ajY());
                a.this.FT.aM(bhVar.ajZ());
                a.this.updateUI();
            }
        }
    };
    private CustomMessageListener cmq = new CustomMessageListener(2156670) { // from class: com.baidu.tbadk.core.view.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && ((String) customResponsedMessage.getData()).equals("zan_or_cai_smallflow")) {
                a.this.ans();
                a.this.updateUI();
            }
        }
    };

    public a(PraiseView praiseView, DisPraiseView disPraiseView) {
        this.cmm = praiseView;
        this.cmn = disPraiseView;
    }

    public void ans() {
        if (com.baidu.tbadk.util.a.axp().aoP()) {
            if (this.cmm != null) {
                this.cmm.textResId = R.string.action_like;
                this.cmm.cnd = R.color.cp_cont_j;
                this.cmm.cne = R.color.cp_cont_h;
                this.cmm.drawableResId = R.drawable.icon_card_like_n;
                this.cmm.cnc = R.drawable.icon_card_like_s;
                this.cmm.setAfterClickListener(this.cmo);
                this.cmm.setVisibility(0);
            }
            if (this.cmn != null) {
                this.cmn.textResId = R.string.action_dislike;
                this.cmn.cnd = R.color.cp_cont_j;
                this.cmn.cne = R.color.cp_link_tip_a;
                this.cmn.drawableResId = R.drawable.icon_card_dislike_n;
                this.cmn.cnc = R.drawable.icon_card_dislike_s;
                this.cmn.setAfterClickListener(this.cmo);
                this.cmn.setVisibility(0);
                return;
            }
            return;
        }
        if (this.cmm != null) {
            this.cmm.textResId = R.string.action_praise_default;
            this.cmm.cnd = R.color.cp_cont_j;
            this.cmm.cne = R.color.cp_cont_h;
            this.cmm.drawableResId = ant() ? R.drawable.icon_home_card_like_n_xmas : R.drawable.icon_home_card_like_n;
            this.cmm.cnc = ant() ? R.drawable.icon_home_card_like_s_xmas : R.drawable.icon_home_card_like_s;
            this.cmm.setVisibility(0);
            this.cmm.setAfterClickListener(this.cmo);
        }
        if (this.cmn != null) {
            this.cmn.setAfterClickListener(this.cmo);
            this.cmn.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.cmm != null) {
            this.cmm.onChangeSkinType(i);
        }
        if (this.cmn != null) {
            this.cmn.onChangeSkinType(i);
        }
    }

    private boolean ant() {
        com.baidu.tbadk.coreExtra.data.c activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        return activitySwitch != null && activitySwitch.aoR();
    }

    public void setFrom(int i) {
        if (this.cmm != null) {
            this.cmm.setFrom(i);
        }
        if (this.cmn != null) {
            this.cmn.setFrom(i);
        }
    }

    public void setDisPraiseFrom(int i) {
        if (this.cmm != null) {
            this.cmm.setFrom(i);
        }
        if (this.cmn != null) {
            this.cmn.setFrom(i);
        }
    }

    public void setForumId(String str) {
        if (this.cmm != null) {
            this.cmm.setForumId(str);
        }
        if (this.cmn != null) {
            this.cmn.setForumId(str);
        }
    }

    public void setClickable(boolean z) {
        if (this.cmm != null) {
            this.cmm.setViewEnabled(z);
        }
        if (this.cmn != null) {
            this.cmn.setViewEnabled(z);
        }
    }

    public void p(bh bhVar) {
        this.FT = bhVar;
        if (this.cmm != null) {
            this.cmm.p(bhVar);
        }
        if (this.cmn != null) {
            this.cmn.p(bhVar);
        }
    }

    public void updateUI() {
        if (this.cmm != null) {
            this.cmm.updateUI();
        }
        if (this.cmn != null) {
            this.cmn.updateUI();
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.cmp);
        MessageManager.getInstance().unRegisterListener(this.cmq);
    }

    public void j(BdUniqueId bdUniqueId) {
        this.cmp.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.cmp);
        this.cmq.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.cmq);
    }
}

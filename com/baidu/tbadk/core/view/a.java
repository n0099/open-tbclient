package com.baidu.tbadk.core.view;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class a {
    private bg XS;
    private PraiseView bNs;
    private DisPraiseView bNt;
    private final View.OnClickListener bNu = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.GR();
        }
    };
    private CustomMessageListener bNv = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bg bgVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j) && a.this.XS != null && !TextUtils.isEmpty(a.this.XS.getTid()) && (bgVar = ((com.baidu.tbadk.data.j) customResponsedMessage.getData()).cht) != null && a.this.XS.getTid().equals(bgVar.getTid())) {
                a.this.XS.gA(bgVar.aan());
                a.this.XS.gy(bgVar.aam());
                a.this.XS.af(bgVar.aak());
                a.this.XS.ag(bgVar.aal());
                a.this.GR();
            }
        }
    };
    private CustomMessageListener bNw = new CustomMessageListener(2156670) { // from class: com.baidu.tbadk.core.view.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && ((String) customResponsedMessage.getData()).equals("zan_or_cai_smallflow")) {
                a.this.aec();
                a.this.GR();
            }
        }
    };

    public a(PraiseView praiseView, DisPraiseView disPraiseView) {
        this.bNs = praiseView;
        this.bNt = disPraiseView;
    }

    public void aec() {
        if (com.baidu.tbadk.util.a.apM().afN()) {
            if (this.bNs != null) {
                this.bNs.bOe = d.j.action_like;
                this.bNs.bOh = d.C0277d.cp_cont_j;
                this.bNs.bOi = d.C0277d.cp_cont_h;
                this.bNs.bOf = d.f.icon_card_like_n;
                this.bNs.bOg = d.f.icon_card_like_s;
                this.bNs.setAfterClickListener(this.bNu);
                this.bNs.setVisibility(0);
            }
            if (this.bNt != null) {
                this.bNt.bOe = d.j.action_dislike;
                this.bNt.bOh = d.C0277d.cp_cont_j;
                this.bNt.bOi = d.C0277d.cp_link_tip_a;
                this.bNt.bOf = d.f.icon_card_dislike_n;
                this.bNt.bOg = d.f.icon_card_dislike_s;
                this.bNt.setAfterClickListener(this.bNu);
                this.bNt.setVisibility(0);
                return;
            }
            return;
        }
        if (this.bNs != null) {
            this.bNs.bOe = d.j.action_praise_default;
            this.bNs.bOh = d.C0277d.cp_cont_j;
            this.bNs.bOi = d.C0277d.cp_cont_h;
            this.bNs.bOf = aed() ? d.f.icon_home_card_like_n_xmas : d.f.icon_home_card_like_n;
            this.bNs.bOg = aed() ? d.f.icon_home_card_like_s_xmas : d.f.icon_home_card_like_s;
            this.bNs.setVisibility(0);
            this.bNs.setAfterClickListener(this.bNu);
        }
        if (this.bNt != null) {
            this.bNt.setAfterClickListener(this.bNu);
            this.bNt.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bNs != null) {
            this.bNs.onChangeSkinType(i);
        }
        if (this.bNt != null) {
            this.bNt.onChangeSkinType(i);
        }
    }

    private boolean aed() {
        com.baidu.tbadk.coreExtra.data.c activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        return activitySwitch != null && activitySwitch.afX();
    }

    public void setFrom(int i) {
        if (this.bNs != null) {
            this.bNs.setFrom(i);
        }
        if (this.bNt != null) {
            this.bNt.setFrom(i);
        }
    }

    public void setDisPraiseFrom(int i) {
        if (this.bNs != null) {
            this.bNs.setFrom(i);
        }
        if (this.bNt != null) {
            this.bNt.setFrom(i);
        }
    }

    public void setForumId(String str) {
        if (this.bNs != null) {
            this.bNs.setForumId(str);
        }
        if (this.bNt != null) {
            this.bNt.setForumId(str);
        }
    }

    public void setClickable(boolean z) {
        if (this.bNs != null) {
            this.bNs.setViewEnabled(z);
        }
        if (this.bNt != null) {
            this.bNt.setViewEnabled(z);
        }
    }

    public void n(bg bgVar) {
        this.XS = bgVar;
        if (this.bNs != null) {
            this.bNs.n(bgVar);
        }
        if (this.bNt != null) {
            this.bNt.n(bgVar);
        }
    }

    public void GR() {
        if (this.bNs != null) {
            this.bNs.GR();
        }
        if (this.bNt != null) {
            this.bNt.GR();
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.bNv);
        MessageManager.getInstance().unRegisterListener(this.bNw);
    }

    public void i(BdUniqueId bdUniqueId) {
        this.bNv.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.bNv);
        this.bNw.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.bNw);
    }
}

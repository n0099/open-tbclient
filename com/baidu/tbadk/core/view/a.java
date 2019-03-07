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
    private bg XR;
    private PraiseView bNr;
    private DisPraiseView bNs;
    private final View.OnClickListener bNt = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.GR();
        }
    };
    private CustomMessageListener bNu = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bg bgVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j) && a.this.XR != null && !TextUtils.isEmpty(a.this.XR.getTid()) && (bgVar = ((com.baidu.tbadk.data.j) customResponsedMessage.getData()).cht) != null && a.this.XR.getTid().equals(bgVar.getTid())) {
                a.this.XR.gA(bgVar.aan());
                a.this.XR.gy(bgVar.aam());
                a.this.XR.af(bgVar.aak());
                a.this.XR.ag(bgVar.aal());
                a.this.GR();
            }
        }
    };
    private CustomMessageListener bNv = new CustomMessageListener(2156670) { // from class: com.baidu.tbadk.core.view.a.3
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
        this.bNr = praiseView;
        this.bNs = disPraiseView;
    }

    public void aec() {
        if (com.baidu.tbadk.util.a.apM().afN()) {
            if (this.bNr != null) {
                this.bNr.bOd = d.j.action_like;
                this.bNr.bOg = d.C0236d.cp_cont_j;
                this.bNr.bOh = d.C0236d.cp_cont_h;
                this.bNr.bOe = d.f.icon_card_like_n;
                this.bNr.bOf = d.f.icon_card_like_s;
                this.bNr.setAfterClickListener(this.bNt);
                this.bNr.setVisibility(0);
            }
            if (this.bNs != null) {
                this.bNs.bOd = d.j.action_dislike;
                this.bNs.bOg = d.C0236d.cp_cont_j;
                this.bNs.bOh = d.C0236d.cp_link_tip_a;
                this.bNs.bOe = d.f.icon_card_dislike_n;
                this.bNs.bOf = d.f.icon_card_dislike_s;
                this.bNs.setAfterClickListener(this.bNt);
                this.bNs.setVisibility(0);
                return;
            }
            return;
        }
        if (this.bNr != null) {
            this.bNr.bOd = d.j.action_praise_default;
            this.bNr.bOg = d.C0236d.cp_cont_j;
            this.bNr.bOh = d.C0236d.cp_cont_h;
            this.bNr.bOe = aed() ? d.f.icon_home_card_like_n_xmas : d.f.icon_home_card_like_n;
            this.bNr.bOf = aed() ? d.f.icon_home_card_like_s_xmas : d.f.icon_home_card_like_s;
            this.bNr.setVisibility(0);
            this.bNr.setAfterClickListener(this.bNt);
        }
        if (this.bNs != null) {
            this.bNs.setAfterClickListener(this.bNt);
            this.bNs.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bNr != null) {
            this.bNr.onChangeSkinType(i);
        }
        if (this.bNs != null) {
            this.bNs.onChangeSkinType(i);
        }
    }

    private boolean aed() {
        com.baidu.tbadk.coreExtra.data.c activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        return activitySwitch != null && activitySwitch.afX();
    }

    public void setFrom(int i) {
        if (this.bNr != null) {
            this.bNr.setFrom(i);
        }
        if (this.bNs != null) {
            this.bNs.setFrom(i);
        }
    }

    public void setDisPraiseFrom(int i) {
        if (this.bNr != null) {
            this.bNr.setFrom(i);
        }
        if (this.bNs != null) {
            this.bNs.setFrom(i);
        }
    }

    public void setForumId(String str) {
        if (this.bNr != null) {
            this.bNr.setForumId(str);
        }
        if (this.bNs != null) {
            this.bNs.setForumId(str);
        }
    }

    public void setClickable(boolean z) {
        if (this.bNr != null) {
            this.bNr.setViewEnabled(z);
        }
        if (this.bNs != null) {
            this.bNs.setViewEnabled(z);
        }
    }

    public void n(bg bgVar) {
        this.XR = bgVar;
        if (this.bNr != null) {
            this.bNr.n(bgVar);
        }
        if (this.bNs != null) {
            this.bNs.n(bgVar);
        }
    }

    public void GR() {
        if (this.bNr != null) {
            this.bNr.GR();
        }
        if (this.bNs != null) {
            this.bNs.GR();
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.bNu);
        MessageManager.getInstance().unRegisterListener(this.bNv);
    }

    public void i(BdUniqueId bdUniqueId) {
        this.bNu.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.bNu);
        this.bNv.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.bNv);
    }
}

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
    private PraiseView bNu;
    private DisPraiseView bNv;
    private final View.OnClickListener bNw = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.GP();
        }
    };
    private CustomMessageListener bNx = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bg bgVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j) && a.this.XS != null && !TextUtils.isEmpty(a.this.XS.getTid()) && (bgVar = ((com.baidu.tbadk.data.j) customResponsedMessage.getData()).chv) != null && a.this.XS.getTid().equals(bgVar.getTid())) {
                a.this.XS.gz(bgVar.aak());
                a.this.XS.gx(bgVar.aaj());
                a.this.XS.af(bgVar.aah());
                a.this.XS.ag(bgVar.aai());
                a.this.GP();
            }
        }
    };
    private CustomMessageListener bNy = new CustomMessageListener(2156670) { // from class: com.baidu.tbadk.core.view.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && ((String) customResponsedMessage.getData()).equals("zan_or_cai_smallflow")) {
                a.this.adZ();
                a.this.GP();
            }
        }
    };

    public a(PraiseView praiseView, DisPraiseView disPraiseView) {
        this.bNu = praiseView;
        this.bNv = disPraiseView;
    }

    public void adZ() {
        if (com.baidu.tbadk.util.a.apJ().afK()) {
            if (this.bNu != null) {
                this.bNu.bOg = d.j.action_like;
                this.bNu.bOj = d.C0277d.cp_cont_j;
                this.bNu.bOk = d.C0277d.cp_cont_h;
                this.bNu.bOh = d.f.icon_card_like_n;
                this.bNu.bOi = d.f.icon_card_like_s;
                this.bNu.setAfterClickListener(this.bNw);
                this.bNu.setVisibility(0);
            }
            if (this.bNv != null) {
                this.bNv.bOg = d.j.action_dislike;
                this.bNv.bOj = d.C0277d.cp_cont_j;
                this.bNv.bOk = d.C0277d.cp_link_tip_a;
                this.bNv.bOh = d.f.icon_card_dislike_n;
                this.bNv.bOi = d.f.icon_card_dislike_s;
                this.bNv.setAfterClickListener(this.bNw);
                this.bNv.setVisibility(0);
                return;
            }
            return;
        }
        if (this.bNu != null) {
            this.bNu.bOg = d.j.action_praise_default;
            this.bNu.bOj = d.C0277d.cp_cont_j;
            this.bNu.bOk = d.C0277d.cp_cont_h;
            this.bNu.bOh = aea() ? d.f.icon_home_card_like_n_xmas : d.f.icon_home_card_like_n;
            this.bNu.bOi = aea() ? d.f.icon_home_card_like_s_xmas : d.f.icon_home_card_like_s;
            this.bNu.setVisibility(0);
            this.bNu.setAfterClickListener(this.bNw);
        }
        if (this.bNv != null) {
            this.bNv.setAfterClickListener(this.bNw);
            this.bNv.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bNu != null) {
            this.bNu.onChangeSkinType(i);
        }
        if (this.bNv != null) {
            this.bNv.onChangeSkinType(i);
        }
    }

    private boolean aea() {
        com.baidu.tbadk.coreExtra.data.c activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        return activitySwitch != null && activitySwitch.afU();
    }

    public void setFrom(int i) {
        if (this.bNu != null) {
            this.bNu.setFrom(i);
        }
        if (this.bNv != null) {
            this.bNv.setFrom(i);
        }
    }

    public void setDisPraiseFrom(int i) {
        if (this.bNu != null) {
            this.bNu.setFrom(i);
        }
        if (this.bNv != null) {
            this.bNv.setFrom(i);
        }
    }

    public void setForumId(String str) {
        if (this.bNu != null) {
            this.bNu.setForumId(str);
        }
        if (this.bNv != null) {
            this.bNv.setForumId(str);
        }
    }

    public void setClickable(boolean z) {
        if (this.bNu != null) {
            this.bNu.setViewEnabled(z);
        }
        if (this.bNv != null) {
            this.bNv.setViewEnabled(z);
        }
    }

    public void n(bg bgVar) {
        this.XS = bgVar;
        if (this.bNu != null) {
            this.bNu.n(bgVar);
        }
        if (this.bNv != null) {
            this.bNv.n(bgVar);
        }
    }

    public void GP() {
        if (this.bNu != null) {
            this.bNu.GP();
        }
        if (this.bNv != null) {
            this.bNv.GP();
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.bNx);
        MessageManager.getInstance().unRegisterListener(this.bNy);
    }

    public void i(BdUniqueId bdUniqueId) {
        this.bNx.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.bNx);
        this.bNy.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.bNy);
    }
}

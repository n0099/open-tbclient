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
    private bg XT;
    private PraiseView bNv;
    private DisPraiseView bNw;
    private final View.OnClickListener bNx = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.GP();
        }
    };
    private CustomMessageListener bNy = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bg bgVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j) && a.this.XT != null && !TextUtils.isEmpty(a.this.XT.getTid()) && (bgVar = ((com.baidu.tbadk.data.j) customResponsedMessage.getData()).chw) != null && a.this.XT.getTid().equals(bgVar.getTid())) {
                a.this.XT.gz(bgVar.aak());
                a.this.XT.gx(bgVar.aaj());
                a.this.XT.af(bgVar.aah());
                a.this.XT.ag(bgVar.aai());
                a.this.GP();
            }
        }
    };
    private CustomMessageListener bNz = new CustomMessageListener(2156670) { // from class: com.baidu.tbadk.core.view.a.3
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
        this.bNv = praiseView;
        this.bNw = disPraiseView;
    }

    public void adZ() {
        if (com.baidu.tbadk.util.a.apJ().afK()) {
            if (this.bNv != null) {
                this.bNv.bOh = d.j.action_like;
                this.bNv.bOk = d.C0277d.cp_cont_j;
                this.bNv.bOl = d.C0277d.cp_cont_h;
                this.bNv.bOi = d.f.icon_card_like_n;
                this.bNv.bOj = d.f.icon_card_like_s;
                this.bNv.setAfterClickListener(this.bNx);
                this.bNv.setVisibility(0);
            }
            if (this.bNw != null) {
                this.bNw.bOh = d.j.action_dislike;
                this.bNw.bOk = d.C0277d.cp_cont_j;
                this.bNw.bOl = d.C0277d.cp_link_tip_a;
                this.bNw.bOi = d.f.icon_card_dislike_n;
                this.bNw.bOj = d.f.icon_card_dislike_s;
                this.bNw.setAfterClickListener(this.bNx);
                this.bNw.setVisibility(0);
                return;
            }
            return;
        }
        if (this.bNv != null) {
            this.bNv.bOh = d.j.action_praise_default;
            this.bNv.bOk = d.C0277d.cp_cont_j;
            this.bNv.bOl = d.C0277d.cp_cont_h;
            this.bNv.bOi = aea() ? d.f.icon_home_card_like_n_xmas : d.f.icon_home_card_like_n;
            this.bNv.bOj = aea() ? d.f.icon_home_card_like_s_xmas : d.f.icon_home_card_like_s;
            this.bNv.setVisibility(0);
            this.bNv.setAfterClickListener(this.bNx);
        }
        if (this.bNw != null) {
            this.bNw.setAfterClickListener(this.bNx);
            this.bNw.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bNv != null) {
            this.bNv.onChangeSkinType(i);
        }
        if (this.bNw != null) {
            this.bNw.onChangeSkinType(i);
        }
    }

    private boolean aea() {
        com.baidu.tbadk.coreExtra.data.c activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        return activitySwitch != null && activitySwitch.afU();
    }

    public void setFrom(int i) {
        if (this.bNv != null) {
            this.bNv.setFrom(i);
        }
        if (this.bNw != null) {
            this.bNw.setFrom(i);
        }
    }

    public void setDisPraiseFrom(int i) {
        if (this.bNv != null) {
            this.bNv.setFrom(i);
        }
        if (this.bNw != null) {
            this.bNw.setFrom(i);
        }
    }

    public void setForumId(String str) {
        if (this.bNv != null) {
            this.bNv.setForumId(str);
        }
        if (this.bNw != null) {
            this.bNw.setForumId(str);
        }
    }

    public void setClickable(boolean z) {
        if (this.bNv != null) {
            this.bNv.setViewEnabled(z);
        }
        if (this.bNw != null) {
            this.bNw.setViewEnabled(z);
        }
    }

    public void n(bg bgVar) {
        this.XT = bgVar;
        if (this.bNv != null) {
            this.bNv.n(bgVar);
        }
        if (this.bNw != null) {
            this.bNw.n(bgVar);
        }
    }

    public void GP() {
        if (this.bNv != null) {
            this.bNv.GP();
        }
        if (this.bNw != null) {
            this.bNw.GP();
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.bNy);
        MessageManager.getInstance().unRegisterListener(this.bNz);
    }

    public void i(BdUniqueId bdUniqueId) {
        this.bNy.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.bNy);
        this.bNz.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.bNz);
    }
}

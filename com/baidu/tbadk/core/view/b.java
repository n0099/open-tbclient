package com.baidu.tbadk.core.view;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class b {
    private PraiseView aFd;
    private DisPraiseView aFe;
    private bb aFf;
    private final View.OnClickListener aEZ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.updateUI();
        }
    };
    private CustomMessageListener aFg = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bb bbVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.h) && b.this.aFf != null && !TextUtils.isEmpty(b.this.aFf.getTid()) && (bbVar = ((com.baidu.tbadk.data.h) customResponsedMessage.getData()).aXl) != null && b.this.aFf.getTid().equals(bbVar.getTid())) {
                b.this.aFf.cY(bbVar.AV());
                b.this.aFf.cW(bbVar.AU());
                b.this.aFf.C(bbVar.AS());
                b.this.aFf.D(bbVar.AT());
                b.this.updateUI();
            }
        }
    };
    private CustomMessageListener aFb = new CustomMessageListener(2156670) { // from class: com.baidu.tbadk.core.view.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && ((String) customResponsedMessage.getData()).equals("zan_or_cai_smallflow")) {
                b.this.EF();
                b.this.updateUI();
            }
        }
    };

    public b(PraiseView praiseView, DisPraiseView disPraiseView) {
        this.aFd = praiseView;
        this.aFe = disPraiseView;
    }

    public void EF() {
        if (com.baidu.tbadk.util.a.PH().Gf()) {
            if (this.aFd != null) {
                this.aFd.aFr = e.j.action_like;
                this.aFd.aFu = e.d.cp_cont_j;
                this.aFd.aFv = e.d.cp_cont_h;
                this.aFd.aFs = e.f.icon_card_like_n;
                this.aFd.aFt = e.f.icon_card_like_s;
                this.aFd.setAfterClickListener(this.aEZ);
                this.aFd.setVisibility(0);
            }
            if (this.aFe != null) {
                this.aFe.aFr = e.j.action_dislike;
                this.aFe.aFu = e.d.cp_cont_j;
                this.aFe.aFv = e.d.cp_link_tip_a;
                this.aFe.aFs = e.f.icon_card_dislike_n;
                this.aFe.aFt = e.f.icon_card_dislike_s;
                this.aFe.setAfterClickListener(this.aEZ);
                this.aFe.setVisibility(0);
                return;
            }
            return;
        }
        if (this.aFd != null) {
            this.aFd.aFr = e.j.action_praise_default;
            this.aFd.aFu = e.d.cp_cont_j;
            this.aFd.aFv = e.d.cp_cont_h;
            this.aFd.aFs = EG() ? e.f.icon_home_card_like_n_xmas : e.f.icon_home_card_like_n;
            this.aFd.aFt = EG() ? e.f.icon_home_card_like_s_xmas : e.f.icon_home_card_like_s;
            this.aFd.setVisibility(0);
            this.aFd.setAfterClickListener(this.aEZ);
        }
        if (this.aFe != null) {
            this.aFe.setAfterClickListener(this.aEZ);
            this.aFe.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.aFd != null) {
            this.aFd.onChangeSkinType(i);
        }
        if (this.aFe != null) {
            this.aFe.onChangeSkinType(i);
        }
    }

    private boolean EG() {
        com.baidu.tbadk.coreExtra.data.c activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        return activitySwitch != null && activitySwitch.Gq();
    }

    public void setFrom(int i) {
        if (this.aFd != null) {
            this.aFd.setFrom(i);
        }
        if (this.aFe != null) {
            this.aFe.setFrom(i);
        }
    }

    public void setDisPraiseFrom(int i) {
        if (this.aFd != null) {
            this.aFd.setFrom(i);
        }
        if (this.aFe != null) {
            this.aFe.setFrom(i);
        }
    }

    public void setForumId(String str) {
        if (this.aFd != null) {
            this.aFd.setForumId(str);
        }
        if (this.aFe != null) {
            this.aFe.setForumId(str);
        }
    }

    public void setClickable(boolean z) {
        if (this.aFd != null) {
            this.aFd.setViewEnabled(z);
        }
        if (this.aFe != null) {
            this.aFe.setViewEnabled(z);
        }
    }

    public void a(bb bbVar) {
        this.aFf = bbVar;
        if (this.aFd != null) {
            this.aFd.a(bbVar);
        }
        if (this.aFe != null) {
            this.aFe.a(bbVar);
        }
    }

    public void updateUI() {
        if (this.aFd != null) {
            this.aFd.updateUI();
        }
        if (this.aFe != null) {
            this.aFe.updateUI();
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.aFg);
        MessageManager.getInstance().unRegisterListener(this.aFb);
    }

    public void h(BdUniqueId bdUniqueId) {
        this.aFg.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.aFg);
        this.aFb.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.aFb);
    }
}

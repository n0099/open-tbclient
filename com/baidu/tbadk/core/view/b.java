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
    private PraiseView aAO;
    private DisPraiseView aAP;
    private bb aAQ;
    private final View.OnClickListener aAK = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.updateUI();
        }
    };
    private CustomMessageListener aAR = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bb bbVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.h) && b.this.aAQ != null && !TextUtils.isEmpty(b.this.aAQ.getTid()) && (bbVar = ((com.baidu.tbadk.data.h) customResponsedMessage.getData()).aSY) != null && b.this.aAQ.getTid().equals(bbVar.getTid())) {
                b.this.aAQ.cw(bbVar.zK());
                b.this.aAQ.cu(bbVar.zJ());
                b.this.aAQ.v(bbVar.zH());
                b.this.aAQ.w(bbVar.zI());
                b.this.updateUI();
            }
        }
    };
    private CustomMessageListener aAM = new CustomMessageListener(2156670) { // from class: com.baidu.tbadk.core.view.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && ((String) customResponsedMessage.getData()).equals("zan_or_cai_smallflow")) {
                b.this.Du();
                b.this.updateUI();
            }
        }
    };

    public b(PraiseView praiseView, DisPraiseView disPraiseView) {
        this.aAO = praiseView;
        this.aAP = disPraiseView;
    }

    public void Du() {
        if (com.baidu.tbadk.util.a.Os().EQ()) {
            if (this.aAO != null) {
                this.aAO.aBc = e.j.action_like;
                this.aAO.aBf = e.d.cp_cont_j;
                this.aAO.aBg = e.d.cp_cont_h;
                this.aAO.aBd = e.f.icon_card_like_n;
                this.aAO.aBe = e.f.icon_card_like_s;
                this.aAO.setAfterClickListener(this.aAK);
                this.aAO.setVisibility(0);
            }
            if (this.aAP != null) {
                this.aAP.aBc = e.j.action_dislike;
                this.aAP.aBf = e.d.cp_cont_j;
                this.aAP.aBg = e.d.cp_link_tip_a;
                this.aAP.aBd = e.f.icon_card_dislike_n;
                this.aAP.aBe = e.f.icon_card_dislike_s;
                this.aAP.setAfterClickListener(this.aAK);
                this.aAP.setVisibility(0);
                return;
            }
            return;
        }
        if (this.aAO != null) {
            this.aAO.aBc = e.j.action_praise_default;
            this.aAO.aBf = e.d.cp_cont_j;
            this.aAO.aBg = e.d.cp_cont_h;
            this.aAO.aBd = Dv() ? e.f.icon_home_card_like_n_xmas : e.f.icon_home_card_like_n;
            this.aAO.aBe = Dv() ? e.f.icon_home_card_like_s_xmas : e.f.icon_home_card_like_s;
            this.aAO.setVisibility(0);
            this.aAO.setAfterClickListener(this.aAK);
        }
        if (this.aAP != null) {
            this.aAP.setAfterClickListener(this.aAK);
            this.aAP.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.aAO != null) {
            this.aAO.onChangeSkinType(i);
        }
        if (this.aAP != null) {
            this.aAP.onChangeSkinType(i);
        }
    }

    private boolean Dv() {
        com.baidu.tbadk.coreExtra.data.c activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        return activitySwitch != null && activitySwitch.Fb();
    }

    public void setFrom(int i) {
        if (this.aAO != null) {
            this.aAO.setFrom(i);
        }
        if (this.aAP != null) {
            this.aAP.setFrom(i);
        }
    }

    public void setDisPraiseFrom(int i) {
        if (this.aAO != null) {
            this.aAO.setFrom(i);
        }
        if (this.aAP != null) {
            this.aAP.setFrom(i);
        }
    }

    public void setForumId(String str) {
        if (this.aAO != null) {
            this.aAO.setForumId(str);
        }
        if (this.aAP != null) {
            this.aAP.setForumId(str);
        }
    }

    public void setClickable(boolean z) {
        if (this.aAO != null) {
            this.aAO.setViewEnabled(z);
        }
        if (this.aAP != null) {
            this.aAP.setViewEnabled(z);
        }
    }

    public void a(bb bbVar) {
        this.aAQ = bbVar;
        if (this.aAO != null) {
            this.aAO.a(bbVar);
        }
        if (this.aAP != null) {
            this.aAP.a(bbVar);
        }
    }

    public void updateUI() {
        if (this.aAO != null) {
            this.aAO.updateUI();
        }
        if (this.aAP != null) {
            this.aAP.updateUI();
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.aAR);
        MessageManager.getInstance().unRegisterListener(this.aAM);
    }

    public void h(BdUniqueId bdUniqueId) {
        this.aAR.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.aAR);
        this.aAM.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.aAM);
    }
}

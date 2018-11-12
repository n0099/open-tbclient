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
    private PraiseView aBD;
    private DisPraiseView aBE;
    private bb aBF;
    private final View.OnClickListener aBz = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.updateUI();
        }
    };
    private CustomMessageListener aBG = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bb bbVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.h) && b.this.aBF != null && !TextUtils.isEmpty(b.this.aBF.getTid()) && (bbVar = ((com.baidu.tbadk.data.h) customResponsedMessage.getData()).aTO) != null && b.this.aBF.getTid().equals(bbVar.getTid())) {
                b.this.aBF.cK(bbVar.zR());
                b.this.aBF.cI(bbVar.zQ());
                b.this.aBF.x(bbVar.zO());
                b.this.aBF.y(bbVar.zP());
                b.this.updateUI();
            }
        }
    };
    private CustomMessageListener aBB = new CustomMessageListener(2156670) { // from class: com.baidu.tbadk.core.view.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && ((String) customResponsedMessage.getData()).equals("zan_or_cai_smallflow")) {
                b.this.DB();
                b.this.updateUI();
            }
        }
    };

    public b(PraiseView praiseView, DisPraiseView disPraiseView) {
        this.aBD = praiseView;
        this.aBE = disPraiseView;
    }

    public void DB() {
        if (com.baidu.tbadk.util.a.OB().Fb()) {
            if (this.aBD != null) {
                this.aBD.aBR = e.j.action_like;
                this.aBD.aBU = e.d.cp_cont_j;
                this.aBD.aBV = e.d.cp_cont_h;
                this.aBD.aBS = e.f.icon_card_like_n;
                this.aBD.aBT = e.f.icon_card_like_s;
                this.aBD.setAfterClickListener(this.aBz);
                this.aBD.setVisibility(0);
            }
            if (this.aBE != null) {
                this.aBE.aBR = e.j.action_dislike;
                this.aBE.aBU = e.d.cp_cont_j;
                this.aBE.aBV = e.d.cp_link_tip_a;
                this.aBE.aBS = e.f.icon_card_dislike_n;
                this.aBE.aBT = e.f.icon_card_dislike_s;
                this.aBE.setAfterClickListener(this.aBz);
                this.aBE.setVisibility(0);
                return;
            }
            return;
        }
        if (this.aBD != null) {
            this.aBD.aBR = e.j.action_praise_default;
            this.aBD.aBU = e.d.cp_cont_j;
            this.aBD.aBV = e.d.cp_cont_h;
            this.aBD.aBS = DC() ? e.f.icon_home_card_like_n_xmas : e.f.icon_home_card_like_n;
            this.aBD.aBT = DC() ? e.f.icon_home_card_like_s_xmas : e.f.icon_home_card_like_s;
            this.aBD.setVisibility(0);
            this.aBD.setAfterClickListener(this.aBz);
        }
        if (this.aBE != null) {
            this.aBE.setAfterClickListener(this.aBz);
            this.aBE.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.aBD != null) {
            this.aBD.onChangeSkinType(i);
        }
        if (this.aBE != null) {
            this.aBE.onChangeSkinType(i);
        }
    }

    private boolean DC() {
        com.baidu.tbadk.coreExtra.data.c activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        return activitySwitch != null && activitySwitch.Fm();
    }

    public void setFrom(int i) {
        if (this.aBD != null) {
            this.aBD.setFrom(i);
        }
        if (this.aBE != null) {
            this.aBE.setFrom(i);
        }
    }

    public void setDisPraiseFrom(int i) {
        if (this.aBD != null) {
            this.aBD.setFrom(i);
        }
        if (this.aBE != null) {
            this.aBE.setFrom(i);
        }
    }

    public void setForumId(String str) {
        if (this.aBD != null) {
            this.aBD.setForumId(str);
        }
        if (this.aBE != null) {
            this.aBE.setForumId(str);
        }
    }

    public void setClickable(boolean z) {
        if (this.aBD != null) {
            this.aBD.setViewEnabled(z);
        }
        if (this.aBE != null) {
            this.aBE.setViewEnabled(z);
        }
    }

    public void a(bb bbVar) {
        this.aBF = bbVar;
        if (this.aBD != null) {
            this.aBD.a(bbVar);
        }
        if (this.aBE != null) {
            this.aBE.a(bbVar);
        }
    }

    public void updateUI() {
        if (this.aBD != null) {
            this.aBD.updateUI();
        }
        if (this.aBE != null) {
            this.aBE.updateUI();
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.aBG);
        MessageManager.getInstance().unRegisterListener(this.aBB);
    }

    public void h(BdUniqueId bdUniqueId) {
        this.aBG.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.aBG);
        this.aBB.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.aBB);
    }
}

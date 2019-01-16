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
    private PraiseView aFG;
    private DisPraiseView aFH;
    private bb aFI;
    private final View.OnClickListener aFC = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.updateUI();
        }
    };
    private CustomMessageListener aFJ = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bb bbVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j) && b.this.aFI != null && !TextUtils.isEmpty(b.this.aFI.getTid()) && (bbVar = ((com.baidu.tbadk.data.j) customResponsedMessage.getData()).aXY) != null && b.this.aFI.getTid().equals(bbVar.getTid())) {
                b.this.aFI.cY(bbVar.Bi());
                b.this.aFI.cW(bbVar.Bh());
                b.this.aFI.C(bbVar.Bf());
                b.this.aFI.D(bbVar.Bg());
                b.this.updateUI();
            }
        }
    };
    private CustomMessageListener aFE = new CustomMessageListener(2156670) { // from class: com.baidu.tbadk.core.view.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && ((String) customResponsedMessage.getData()).equals("zan_or_cai_smallflow")) {
                b.this.ES();
                b.this.updateUI();
            }
        }
    };

    public b(PraiseView praiseView, DisPraiseView disPraiseView) {
        this.aFG = praiseView;
        this.aFH = disPraiseView;
    }

    public void ES() {
        if (com.baidu.tbadk.util.a.Qb().Gt()) {
            if (this.aFG != null) {
                this.aFG.aFU = e.j.action_like;
                this.aFG.aFX = e.d.cp_cont_j;
                this.aFG.aFY = e.d.cp_cont_h;
                this.aFG.aFV = e.f.icon_card_like_n;
                this.aFG.aFW = e.f.icon_card_like_s;
                this.aFG.setAfterClickListener(this.aFC);
                this.aFG.setVisibility(0);
            }
            if (this.aFH != null) {
                this.aFH.aFU = e.j.action_dislike;
                this.aFH.aFX = e.d.cp_cont_j;
                this.aFH.aFY = e.d.cp_link_tip_a;
                this.aFH.aFV = e.f.icon_card_dislike_n;
                this.aFH.aFW = e.f.icon_card_dislike_s;
                this.aFH.setAfterClickListener(this.aFC);
                this.aFH.setVisibility(0);
                return;
            }
            return;
        }
        if (this.aFG != null) {
            this.aFG.aFU = e.j.action_praise_default;
            this.aFG.aFX = e.d.cp_cont_j;
            this.aFG.aFY = e.d.cp_cont_h;
            this.aFG.aFV = ET() ? e.f.icon_home_card_like_n_xmas : e.f.icon_home_card_like_n;
            this.aFG.aFW = ET() ? e.f.icon_home_card_like_s_xmas : e.f.icon_home_card_like_s;
            this.aFG.setVisibility(0);
            this.aFG.setAfterClickListener(this.aFC);
        }
        if (this.aFH != null) {
            this.aFH.setAfterClickListener(this.aFC);
            this.aFH.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.aFG != null) {
            this.aFG.onChangeSkinType(i);
        }
        if (this.aFH != null) {
            this.aFH.onChangeSkinType(i);
        }
    }

    private boolean ET() {
        com.baidu.tbadk.coreExtra.data.c activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        return activitySwitch != null && activitySwitch.GE();
    }

    public void setFrom(int i) {
        if (this.aFG != null) {
            this.aFG.setFrom(i);
        }
        if (this.aFH != null) {
            this.aFH.setFrom(i);
        }
    }

    public void setDisPraiseFrom(int i) {
        if (this.aFG != null) {
            this.aFG.setFrom(i);
        }
        if (this.aFH != null) {
            this.aFH.setFrom(i);
        }
    }

    public void setForumId(String str) {
        if (this.aFG != null) {
            this.aFG.setForumId(str);
        }
        if (this.aFH != null) {
            this.aFH.setForumId(str);
        }
    }

    public void setClickable(boolean z) {
        if (this.aFG != null) {
            this.aFG.setViewEnabled(z);
        }
        if (this.aFH != null) {
            this.aFH.setViewEnabled(z);
        }
    }

    public void a(bb bbVar) {
        this.aFI = bbVar;
        if (this.aFG != null) {
            this.aFG.a(bbVar);
        }
        if (this.aFH != null) {
            this.aFH.a(bbVar);
        }
    }

    public void updateUI() {
        if (this.aFG != null) {
            this.aFG.updateUI();
        }
        if (this.aFH != null) {
            this.aFH.updateUI();
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.aFJ);
        MessageManager.getInstance().unRegisterListener(this.aFE);
    }

    public void h(BdUniqueId bdUniqueId) {
        this.aFJ.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.aFJ);
        this.aFE.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.aFE);
    }
}

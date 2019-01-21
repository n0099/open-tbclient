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
    private PraiseView aFH;
    private DisPraiseView aFI;
    private bb aFJ;
    private final View.OnClickListener aFD = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.updateUI();
        }
    };
    private CustomMessageListener aFK = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bb bbVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j) && b.this.aFJ != null && !TextUtils.isEmpty(b.this.aFJ.getTid()) && (bbVar = ((com.baidu.tbadk.data.j) customResponsedMessage.getData()).aXZ) != null && b.this.aFJ.getTid().equals(bbVar.getTid())) {
                b.this.aFJ.cY(bbVar.Bi());
                b.this.aFJ.cW(bbVar.Bh());
                b.this.aFJ.C(bbVar.Bf());
                b.this.aFJ.D(bbVar.Bg());
                b.this.updateUI();
            }
        }
    };
    private CustomMessageListener aFF = new CustomMessageListener(2156670) { // from class: com.baidu.tbadk.core.view.b.3
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
        this.aFH = praiseView;
        this.aFI = disPraiseView;
    }

    public void ES() {
        if (com.baidu.tbadk.util.a.Qb().Gt()) {
            if (this.aFH != null) {
                this.aFH.aFV = e.j.action_like;
                this.aFH.aFY = e.d.cp_cont_j;
                this.aFH.aFZ = e.d.cp_cont_h;
                this.aFH.aFW = e.f.icon_card_like_n;
                this.aFH.aFX = e.f.icon_card_like_s;
                this.aFH.setAfterClickListener(this.aFD);
                this.aFH.setVisibility(0);
            }
            if (this.aFI != null) {
                this.aFI.aFV = e.j.action_dislike;
                this.aFI.aFY = e.d.cp_cont_j;
                this.aFI.aFZ = e.d.cp_link_tip_a;
                this.aFI.aFW = e.f.icon_card_dislike_n;
                this.aFI.aFX = e.f.icon_card_dislike_s;
                this.aFI.setAfterClickListener(this.aFD);
                this.aFI.setVisibility(0);
                return;
            }
            return;
        }
        if (this.aFH != null) {
            this.aFH.aFV = e.j.action_praise_default;
            this.aFH.aFY = e.d.cp_cont_j;
            this.aFH.aFZ = e.d.cp_cont_h;
            this.aFH.aFW = ET() ? e.f.icon_home_card_like_n_xmas : e.f.icon_home_card_like_n;
            this.aFH.aFX = ET() ? e.f.icon_home_card_like_s_xmas : e.f.icon_home_card_like_s;
            this.aFH.setVisibility(0);
            this.aFH.setAfterClickListener(this.aFD);
        }
        if (this.aFI != null) {
            this.aFI.setAfterClickListener(this.aFD);
            this.aFI.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.aFH != null) {
            this.aFH.onChangeSkinType(i);
        }
        if (this.aFI != null) {
            this.aFI.onChangeSkinType(i);
        }
    }

    private boolean ET() {
        com.baidu.tbadk.coreExtra.data.c activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        return activitySwitch != null && activitySwitch.GE();
    }

    public void setFrom(int i) {
        if (this.aFH != null) {
            this.aFH.setFrom(i);
        }
        if (this.aFI != null) {
            this.aFI.setFrom(i);
        }
    }

    public void setDisPraiseFrom(int i) {
        if (this.aFH != null) {
            this.aFH.setFrom(i);
        }
        if (this.aFI != null) {
            this.aFI.setFrom(i);
        }
    }

    public void setForumId(String str) {
        if (this.aFH != null) {
            this.aFH.setForumId(str);
        }
        if (this.aFI != null) {
            this.aFI.setForumId(str);
        }
    }

    public void setClickable(boolean z) {
        if (this.aFH != null) {
            this.aFH.setViewEnabled(z);
        }
        if (this.aFI != null) {
            this.aFI.setViewEnabled(z);
        }
    }

    public void a(bb bbVar) {
        this.aFJ = bbVar;
        if (this.aFH != null) {
            this.aFH.a(bbVar);
        }
        if (this.aFI != null) {
            this.aFI.a(bbVar);
        }
    }

    public void updateUI() {
        if (this.aFH != null) {
            this.aFH.updateUI();
        }
        if (this.aFI != null) {
            this.aFI.updateUI();
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.aFK);
        MessageManager.getInstance().unRegisterListener(this.aFF);
    }

    public void h(BdUniqueId bdUniqueId) {
        this.aFK.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.aFK);
        this.aFF.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.aFF);
    }
}

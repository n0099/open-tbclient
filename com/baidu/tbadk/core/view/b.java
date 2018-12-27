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
    private PraiseView aFe;
    private DisPraiseView aFf;
    private bb aFg;
    private final View.OnClickListener aFa = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.updateUI();
        }
    };
    private CustomMessageListener aFh = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bb bbVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.h) && b.this.aFg != null && !TextUtils.isEmpty(b.this.aFg.getTid()) && (bbVar = ((com.baidu.tbadk.data.h) customResponsedMessage.getData()).aXo) != null && b.this.aFg.getTid().equals(bbVar.getTid())) {
                b.this.aFg.cY(bbVar.AV());
                b.this.aFg.cW(bbVar.AU());
                b.this.aFg.C(bbVar.AS());
                b.this.aFg.D(bbVar.AT());
                b.this.updateUI();
            }
        }
    };
    private CustomMessageListener aFc = new CustomMessageListener(2156670) { // from class: com.baidu.tbadk.core.view.b.3
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
        this.aFe = praiseView;
        this.aFf = disPraiseView;
    }

    public void EF() {
        if (com.baidu.tbadk.util.a.PJ().Gg()) {
            if (this.aFe != null) {
                this.aFe.aFs = e.j.action_like;
                this.aFe.aFv = e.d.cp_cont_j;
                this.aFe.aFw = e.d.cp_cont_h;
                this.aFe.aFt = e.f.icon_card_like_n;
                this.aFe.aFu = e.f.icon_card_like_s;
                this.aFe.setAfterClickListener(this.aFa);
                this.aFe.setVisibility(0);
            }
            if (this.aFf != null) {
                this.aFf.aFs = e.j.action_dislike;
                this.aFf.aFv = e.d.cp_cont_j;
                this.aFf.aFw = e.d.cp_link_tip_a;
                this.aFf.aFt = e.f.icon_card_dislike_n;
                this.aFf.aFu = e.f.icon_card_dislike_s;
                this.aFf.setAfterClickListener(this.aFa);
                this.aFf.setVisibility(0);
                return;
            }
            return;
        }
        if (this.aFe != null) {
            this.aFe.aFs = e.j.action_praise_default;
            this.aFe.aFv = e.d.cp_cont_j;
            this.aFe.aFw = e.d.cp_cont_h;
            this.aFe.aFt = EG() ? e.f.icon_home_card_like_n_xmas : e.f.icon_home_card_like_n;
            this.aFe.aFu = EG() ? e.f.icon_home_card_like_s_xmas : e.f.icon_home_card_like_s;
            this.aFe.setVisibility(0);
            this.aFe.setAfterClickListener(this.aFa);
        }
        if (this.aFf != null) {
            this.aFf.setAfterClickListener(this.aFa);
            this.aFf.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.aFe != null) {
            this.aFe.onChangeSkinType(i);
        }
        if (this.aFf != null) {
            this.aFf.onChangeSkinType(i);
        }
    }

    private boolean EG() {
        com.baidu.tbadk.coreExtra.data.c activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        return activitySwitch != null && activitySwitch.Gr();
    }

    public void setFrom(int i) {
        if (this.aFe != null) {
            this.aFe.setFrom(i);
        }
        if (this.aFf != null) {
            this.aFf.setFrom(i);
        }
    }

    public void setDisPraiseFrom(int i) {
        if (this.aFe != null) {
            this.aFe.setFrom(i);
        }
        if (this.aFf != null) {
            this.aFf.setFrom(i);
        }
    }

    public void setForumId(String str) {
        if (this.aFe != null) {
            this.aFe.setForumId(str);
        }
        if (this.aFf != null) {
            this.aFf.setForumId(str);
        }
    }

    public void setClickable(boolean z) {
        if (this.aFe != null) {
            this.aFe.setViewEnabled(z);
        }
        if (this.aFf != null) {
            this.aFf.setViewEnabled(z);
        }
    }

    public void a(bb bbVar) {
        this.aFg = bbVar;
        if (this.aFe != null) {
            this.aFe.a(bbVar);
        }
        if (this.aFf != null) {
            this.aFf.a(bbVar);
        }
    }

    public void updateUI() {
        if (this.aFe != null) {
            this.aFe.updateUI();
        }
        if (this.aFf != null) {
            this.aFf.updateUI();
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.aFh);
        MessageManager.getInstance().unRegisterListener(this.aFc);
    }

    public void h(BdUniqueId bdUniqueId) {
        this.aFh.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.aFh);
        this.aFc.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.aFc);
    }
}

package com.baidu.tbadk.core.view;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class a {
    private bg VJ;
    private PraiseView bVh;
    private DisPraiseView bVi;
    private final View.OnClickListener bVj = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.Jf();
        }
    };
    private CustomMessageListener bVk = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bg bgVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j) && a.this.VJ != null && !TextUtils.isEmpty(a.this.VJ.getTid()) && (bgVar = ((com.baidu.tbadk.data.j) customResponsedMessage.getData()).cpF) != null && a.this.VJ.getTid().equals(bgVar.getTid())) {
                a.this.VJ.hl(bgVar.aeR());
                a.this.VJ.hj(bgVar.aeQ());
                a.this.VJ.ar(bgVar.aeO());
                a.this.VJ.as(bgVar.aeP());
                a.this.Jf();
            }
        }
    };
    private CustomMessageListener bVl = new CustomMessageListener(2156670) { // from class: com.baidu.tbadk.core.view.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && ((String) customResponsedMessage.getData()).equals("zan_or_cai_smallflow")) {
                a.this.aiY();
                a.this.Jf();
            }
        }
    };

    public a(PraiseView praiseView, DisPraiseView disPraiseView) {
        this.bVh = praiseView;
        this.bVi = disPraiseView;
    }

    public void aiY() {
        if (com.baidu.tbadk.util.a.auN().akJ()) {
            if (this.bVh != null) {
                this.bVh.bVW = R.string.action_like;
                this.bVh.bVZ = R.color.cp_cont_j;
                this.bVh.bWa = R.color.cp_cont_h;
                this.bVh.bVX = R.drawable.icon_card_like_n;
                this.bVh.bVY = R.drawable.icon_card_like_s;
                this.bVh.setAfterClickListener(this.bVj);
                this.bVh.setVisibility(0);
            }
            if (this.bVi != null) {
                this.bVi.bVW = R.string.action_dislike;
                this.bVi.bVZ = R.color.cp_cont_j;
                this.bVi.bWa = R.color.cp_link_tip_a;
                this.bVi.bVX = R.drawable.icon_card_dislike_n;
                this.bVi.bVY = R.drawable.icon_card_dislike_s;
                this.bVi.setAfterClickListener(this.bVj);
                this.bVi.setVisibility(0);
                return;
            }
            return;
        }
        if (this.bVh != null) {
            this.bVh.bVW = R.string.action_praise_default;
            this.bVh.bVZ = R.color.cp_cont_j;
            this.bVh.bWa = R.color.cp_cont_h;
            this.bVh.bVX = aiZ() ? R.drawable.icon_home_card_like_n_xmas : R.drawable.icon_home_card_like_n;
            this.bVh.bVY = aiZ() ? R.drawable.icon_home_card_like_s_xmas : R.drawable.icon_home_card_like_s;
            this.bVh.setVisibility(0);
            this.bVh.setAfterClickListener(this.bVj);
        }
        if (this.bVi != null) {
            this.bVi.setAfterClickListener(this.bVj);
            this.bVi.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bVh != null) {
            this.bVh.onChangeSkinType(i);
        }
        if (this.bVi != null) {
            this.bVi.onChangeSkinType(i);
        }
    }

    private boolean aiZ() {
        com.baidu.tbadk.coreExtra.data.c activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        return activitySwitch != null && activitySwitch.akT();
    }

    public void setFrom(int i) {
        if (this.bVh != null) {
            this.bVh.setFrom(i);
        }
        if (this.bVi != null) {
            this.bVi.setFrom(i);
        }
    }

    public void setDisPraiseFrom(int i) {
        if (this.bVh != null) {
            this.bVh.setFrom(i);
        }
        if (this.bVi != null) {
            this.bVi.setFrom(i);
        }
    }

    public void setForumId(String str) {
        if (this.bVh != null) {
            this.bVh.setForumId(str);
        }
        if (this.bVi != null) {
            this.bVi.setForumId(str);
        }
    }

    public void setClickable(boolean z) {
        if (this.bVh != null) {
            this.bVh.setViewEnabled(z);
        }
        if (this.bVi != null) {
            this.bVi.setViewEnabled(z);
        }
    }

    public void n(bg bgVar) {
        this.VJ = bgVar;
        if (this.bVh != null) {
            this.bVh.n(bgVar);
        }
        if (this.bVi != null) {
            this.bVi.n(bgVar);
        }
    }

    public void Jf() {
        if (this.bVh != null) {
            this.bVh.Jf();
        }
        if (this.bVi != null) {
            this.bVi.Jf();
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.bVk);
        MessageManager.getInstance().unRegisterListener(this.bVl);
    }

    public void i(BdUniqueId bdUniqueId) {
        this.bVk.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.bVk);
        this.bVl.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.bVl);
    }
}

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
    private bg VK;
    private PraiseView bVg;
    private DisPraiseView bVh;
    private final View.OnClickListener bVi = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.Jf();
        }
    };
    private CustomMessageListener bVj = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bg bgVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j) && a.this.VK != null && !TextUtils.isEmpty(a.this.VK.getTid()) && (bgVar = ((com.baidu.tbadk.data.j) customResponsedMessage.getData()).cpE) != null && a.this.VK.getTid().equals(bgVar.getTid())) {
                a.this.VK.hl(bgVar.aeR());
                a.this.VK.hj(bgVar.aeQ());
                a.this.VK.ar(bgVar.aeO());
                a.this.VK.as(bgVar.aeP());
                a.this.Jf();
            }
        }
    };
    private CustomMessageListener bVk = new CustomMessageListener(2156670) { // from class: com.baidu.tbadk.core.view.a.3
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
        this.bVg = praiseView;
        this.bVh = disPraiseView;
    }

    public void aiY() {
        if (com.baidu.tbadk.util.a.auN().akJ()) {
            if (this.bVg != null) {
                this.bVg.bVV = R.string.action_like;
                this.bVg.bVY = R.color.cp_cont_j;
                this.bVg.bVZ = R.color.cp_cont_h;
                this.bVg.bVW = R.drawable.icon_card_like_n;
                this.bVg.bVX = R.drawable.icon_card_like_s;
                this.bVg.setAfterClickListener(this.bVi);
                this.bVg.setVisibility(0);
            }
            if (this.bVh != null) {
                this.bVh.bVV = R.string.action_dislike;
                this.bVh.bVY = R.color.cp_cont_j;
                this.bVh.bVZ = R.color.cp_link_tip_a;
                this.bVh.bVW = R.drawable.icon_card_dislike_n;
                this.bVh.bVX = R.drawable.icon_card_dislike_s;
                this.bVh.setAfterClickListener(this.bVi);
                this.bVh.setVisibility(0);
                return;
            }
            return;
        }
        if (this.bVg != null) {
            this.bVg.bVV = R.string.action_praise_default;
            this.bVg.bVY = R.color.cp_cont_j;
            this.bVg.bVZ = R.color.cp_cont_h;
            this.bVg.bVW = aiZ() ? R.drawable.icon_home_card_like_n_xmas : R.drawable.icon_home_card_like_n;
            this.bVg.bVX = aiZ() ? R.drawable.icon_home_card_like_s_xmas : R.drawable.icon_home_card_like_s;
            this.bVg.setVisibility(0);
            this.bVg.setAfterClickListener(this.bVi);
        }
        if (this.bVh != null) {
            this.bVh.setAfterClickListener(this.bVi);
            this.bVh.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bVg != null) {
            this.bVg.onChangeSkinType(i);
        }
        if (this.bVh != null) {
            this.bVh.onChangeSkinType(i);
        }
    }

    private boolean aiZ() {
        com.baidu.tbadk.coreExtra.data.c activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        return activitySwitch != null && activitySwitch.akT();
    }

    public void setFrom(int i) {
        if (this.bVg != null) {
            this.bVg.setFrom(i);
        }
        if (this.bVh != null) {
            this.bVh.setFrom(i);
        }
    }

    public void setDisPraiseFrom(int i) {
        if (this.bVg != null) {
            this.bVg.setFrom(i);
        }
        if (this.bVh != null) {
            this.bVh.setFrom(i);
        }
    }

    public void setForumId(String str) {
        if (this.bVg != null) {
            this.bVg.setForumId(str);
        }
        if (this.bVh != null) {
            this.bVh.setForumId(str);
        }
    }

    public void setClickable(boolean z) {
        if (this.bVg != null) {
            this.bVg.setViewEnabled(z);
        }
        if (this.bVh != null) {
            this.bVh.setViewEnabled(z);
        }
    }

    public void n(bg bgVar) {
        this.VK = bgVar;
        if (this.bVg != null) {
            this.bVg.n(bgVar);
        }
        if (this.bVh != null) {
            this.bVh.n(bgVar);
        }
    }

    public void Jf() {
        if (this.bVg != null) {
            this.bVg.Jf();
        }
        if (this.bVh != null) {
            this.bVh.Jf();
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.bVj);
        MessageManager.getInstance().unRegisterListener(this.bVk);
    }

    public void i(BdUniqueId bdUniqueId) {
        this.bVj.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.bVj);
        this.bVk.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.bVk);
    }
}

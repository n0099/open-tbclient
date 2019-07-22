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
    private bg We;
    private PraiseView bWi;
    private DisPraiseView bWj;
    private final View.OnClickListener bWk = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.JS();
        }
    };
    private CustomMessageListener bWl = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bg bgVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j) && a.this.We != null && !TextUtils.isEmpty(a.this.We.getTid()) && (bgVar = ((com.baidu.tbadk.data.j) customResponsedMessage.getData()).cqR) != null && a.this.We.getTid().equals(bgVar.getTid())) {
                a.this.We.hr(bgVar.afT());
                a.this.We.hp(bgVar.afS());
                a.this.We.as(bgVar.afQ());
                a.this.We.at(bgVar.afR());
                a.this.JS();
            }
        }
    };
    private CustomMessageListener bWm = new CustomMessageListener(2156670) { // from class: com.baidu.tbadk.core.view.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && ((String) customResponsedMessage.getData()).equals("zan_or_cai_smallflow")) {
                a.this.akc();
                a.this.JS();
            }
        }
    };

    public a(PraiseView praiseView, DisPraiseView disPraiseView) {
        this.bWi = praiseView;
        this.bWj = disPraiseView;
    }

    public void akc() {
        if (com.baidu.tbadk.util.a.avW().alO()) {
            if (this.bWi != null) {
                this.bWi.bWY = R.string.action_like;
                this.bWi.bXb = R.color.cp_cont_j;
                this.bWi.bXc = R.color.cp_cont_h;
                this.bWi.bWZ = R.drawable.icon_card_like_n;
                this.bWi.bXa = R.drawable.icon_card_like_s;
                this.bWi.setAfterClickListener(this.bWk);
                this.bWi.setVisibility(0);
            }
            if (this.bWj != null) {
                this.bWj.bWY = R.string.action_dislike;
                this.bWj.bXb = R.color.cp_cont_j;
                this.bWj.bXc = R.color.cp_link_tip_a;
                this.bWj.bWZ = R.drawable.icon_card_dislike_n;
                this.bWj.bXa = R.drawable.icon_card_dislike_s;
                this.bWj.setAfterClickListener(this.bWk);
                this.bWj.setVisibility(0);
                return;
            }
            return;
        }
        if (this.bWi != null) {
            this.bWi.bWY = R.string.action_praise_default;
            this.bWi.bXb = R.color.cp_cont_j;
            this.bWi.bXc = R.color.cp_cont_h;
            this.bWi.bWZ = akd() ? R.drawable.icon_home_card_like_n_xmas : R.drawable.icon_home_card_like_n;
            this.bWi.bXa = akd() ? R.drawable.icon_home_card_like_s_xmas : R.drawable.icon_home_card_like_s;
            this.bWi.setVisibility(0);
            this.bWi.setAfterClickListener(this.bWk);
        }
        if (this.bWj != null) {
            this.bWj.setAfterClickListener(this.bWk);
            this.bWj.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bWi != null) {
            this.bWi.onChangeSkinType(i);
        }
        if (this.bWj != null) {
            this.bWj.onChangeSkinType(i);
        }
    }

    private boolean akd() {
        com.baidu.tbadk.coreExtra.data.c activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        return activitySwitch != null && activitySwitch.alY();
    }

    public void setFrom(int i) {
        if (this.bWi != null) {
            this.bWi.setFrom(i);
        }
        if (this.bWj != null) {
            this.bWj.setFrom(i);
        }
    }

    public void setDisPraiseFrom(int i) {
        if (this.bWi != null) {
            this.bWi.setFrom(i);
        }
        if (this.bWj != null) {
            this.bWj.setFrom(i);
        }
    }

    public void setForumId(String str) {
        if (this.bWi != null) {
            this.bWi.setForumId(str);
        }
        if (this.bWj != null) {
            this.bWj.setForumId(str);
        }
    }

    public void setClickable(boolean z) {
        if (this.bWi != null) {
            this.bWi.setViewEnabled(z);
        }
        if (this.bWj != null) {
            this.bWj.setViewEnabled(z);
        }
    }

    public void n(bg bgVar) {
        this.We = bgVar;
        if (this.bWi != null) {
            this.bWi.n(bgVar);
        }
        if (this.bWj != null) {
            this.bWj.n(bgVar);
        }
    }

    public void JS() {
        if (this.bWi != null) {
            this.bWi.JS();
        }
        if (this.bWj != null) {
            this.bWj.JS();
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.bWl);
        MessageManager.getInstance().unRegisterListener(this.bWm);
    }

    public void j(BdUniqueId bdUniqueId) {
        this.bWl.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.bWl);
        this.bWm.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.bWm);
    }
}

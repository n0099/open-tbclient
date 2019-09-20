package com.baidu.tbadk.core.view;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class a {
    private bh Wd;
    private PraiseView bXh;
    private DisPraiseView bXi;
    private final View.OnClickListener bXj = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.JW();
        }
    };
    private CustomMessageListener bXk = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bh bhVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j) && a.this.Wd != null && !TextUtils.isEmpty(a.this.Wd.getTid()) && (bhVar = ((com.baidu.tbadk.data.j) customResponsedMessage.getData()).crT) != null && a.this.Wd.getTid().equals(bhVar.getTid())) {
                a.this.Wd.hs(bhVar.afY());
                a.this.Wd.hq(bhVar.afX());
                a.this.Wd.as(bhVar.afV());
                a.this.Wd.at(bhVar.afW());
                a.this.JW();
            }
        }
    };
    private CustomMessageListener bXl = new CustomMessageListener(2156670) { // from class: com.baidu.tbadk.core.view.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && ((String) customResponsedMessage.getData()).equals("zan_or_cai_smallflow")) {
                a.this.akq();
                a.this.JW();
            }
        }
    };

    public a(PraiseView praiseView, DisPraiseView disPraiseView) {
        this.bXh = praiseView;
        this.bXi = disPraiseView;
    }

    public void akq() {
        if (com.baidu.tbadk.util.a.awk().amc()) {
            if (this.bXh != null) {
                this.bXh.bXX = R.string.action_like;
                this.bXh.bYa = R.color.cp_cont_j;
                this.bXh.bYb = R.color.cp_cont_h;
                this.bXh.bXY = R.drawable.icon_card_like_n;
                this.bXh.bXZ = R.drawable.icon_card_like_s;
                this.bXh.setAfterClickListener(this.bXj);
                this.bXh.setVisibility(0);
            }
            if (this.bXi != null) {
                this.bXi.bXX = R.string.action_dislike;
                this.bXi.bYa = R.color.cp_cont_j;
                this.bXi.bYb = R.color.cp_link_tip_a;
                this.bXi.bXY = R.drawable.icon_card_dislike_n;
                this.bXi.bXZ = R.drawable.icon_card_dislike_s;
                this.bXi.setAfterClickListener(this.bXj);
                this.bXi.setVisibility(0);
                return;
            }
            return;
        }
        if (this.bXh != null) {
            this.bXh.bXX = R.string.action_praise_default;
            this.bXh.bYa = R.color.cp_cont_j;
            this.bXh.bYb = R.color.cp_cont_h;
            this.bXh.bXY = akr() ? R.drawable.icon_home_card_like_n_xmas : R.drawable.icon_home_card_like_n;
            this.bXh.bXZ = akr() ? R.drawable.icon_home_card_like_s_xmas : R.drawable.icon_home_card_like_s;
            this.bXh.setVisibility(0);
            this.bXh.setAfterClickListener(this.bXj);
        }
        if (this.bXi != null) {
            this.bXi.setAfterClickListener(this.bXj);
            this.bXi.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bXh != null) {
            this.bXh.onChangeSkinType(i);
        }
        if (this.bXi != null) {
            this.bXi.onChangeSkinType(i);
        }
    }

    private boolean akr() {
        com.baidu.tbadk.coreExtra.data.c activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        return activitySwitch != null && activitySwitch.amm();
    }

    public void setFrom(int i) {
        if (this.bXh != null) {
            this.bXh.setFrom(i);
        }
        if (this.bXi != null) {
            this.bXi.setFrom(i);
        }
    }

    public void setDisPraiseFrom(int i) {
        if (this.bXh != null) {
            this.bXh.setFrom(i);
        }
        if (this.bXi != null) {
            this.bXi.setFrom(i);
        }
    }

    public void setForumId(String str) {
        if (this.bXh != null) {
            this.bXh.setForumId(str);
        }
        if (this.bXi != null) {
            this.bXi.setForumId(str);
        }
    }

    public void setClickable(boolean z) {
        if (this.bXh != null) {
            this.bXh.setViewEnabled(z);
        }
        if (this.bXi != null) {
            this.bXi.setViewEnabled(z);
        }
    }

    public void p(bh bhVar) {
        this.Wd = bhVar;
        if (this.bXh != null) {
            this.bXh.p(bhVar);
        }
        if (this.bXi != null) {
            this.bXi.p(bhVar);
        }
    }

    public void JW() {
        if (this.bXh != null) {
            this.bXh.JW();
        }
        if (this.bXi != null) {
            this.bXi.JW();
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.bXk);
        MessageManager.getInstance().unRegisterListener(this.bXl);
    }

    public void j(BdUniqueId bdUniqueId) {
        this.bXk.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.bXk);
        this.bXl.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.bXl);
    }
}

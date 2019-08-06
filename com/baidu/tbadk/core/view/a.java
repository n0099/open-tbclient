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
    private bh We;
    private PraiseView bWo;
    private DisPraiseView bWp;
    private final View.OnClickListener bWq = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.JS();
        }
    };
    private CustomMessageListener bWr = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bh bhVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j) && a.this.We != null && !TextUtils.isEmpty(a.this.We.getTid()) && (bhVar = ((com.baidu.tbadk.data.j) customResponsedMessage.getData()).cqY) != null && a.this.We.getTid().equals(bhVar.getTid())) {
                a.this.We.hr(bhVar.afU());
                a.this.We.hp(bhVar.afT());
                a.this.We.as(bhVar.afR());
                a.this.We.at(bhVar.afS());
                a.this.JS();
            }
        }
    };
    private CustomMessageListener bWs = new CustomMessageListener(2156670) { // from class: com.baidu.tbadk.core.view.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && ((String) customResponsedMessage.getData()).equals("zan_or_cai_smallflow")) {
                a.this.ake();
                a.this.JS();
            }
        }
    };

    public a(PraiseView praiseView, DisPraiseView disPraiseView) {
        this.bWo = praiseView;
        this.bWp = disPraiseView;
    }

    public void ake() {
        if (com.baidu.tbadk.util.a.avY().alQ()) {
            if (this.bWo != null) {
                this.bWo.bXe = R.string.action_like;
                this.bWo.bXh = R.color.cp_cont_j;
                this.bWo.bXi = R.color.cp_cont_h;
                this.bWo.bXf = R.drawable.icon_card_like_n;
                this.bWo.bXg = R.drawable.icon_card_like_s;
                this.bWo.setAfterClickListener(this.bWq);
                this.bWo.setVisibility(0);
            }
            if (this.bWp != null) {
                this.bWp.bXe = R.string.action_dislike;
                this.bWp.bXh = R.color.cp_cont_j;
                this.bWp.bXi = R.color.cp_link_tip_a;
                this.bWp.bXf = R.drawable.icon_card_dislike_n;
                this.bWp.bXg = R.drawable.icon_card_dislike_s;
                this.bWp.setAfterClickListener(this.bWq);
                this.bWp.setVisibility(0);
                return;
            }
            return;
        }
        if (this.bWo != null) {
            this.bWo.bXe = R.string.action_praise_default;
            this.bWo.bXh = R.color.cp_cont_j;
            this.bWo.bXi = R.color.cp_cont_h;
            this.bWo.bXf = akf() ? R.drawable.icon_home_card_like_n_xmas : R.drawable.icon_home_card_like_n;
            this.bWo.bXg = akf() ? R.drawable.icon_home_card_like_s_xmas : R.drawable.icon_home_card_like_s;
            this.bWo.setVisibility(0);
            this.bWo.setAfterClickListener(this.bWq);
        }
        if (this.bWp != null) {
            this.bWp.setAfterClickListener(this.bWq);
            this.bWp.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bWo != null) {
            this.bWo.onChangeSkinType(i);
        }
        if (this.bWp != null) {
            this.bWp.onChangeSkinType(i);
        }
    }

    private boolean akf() {
        com.baidu.tbadk.coreExtra.data.c activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        return activitySwitch != null && activitySwitch.ama();
    }

    public void setFrom(int i) {
        if (this.bWo != null) {
            this.bWo.setFrom(i);
        }
        if (this.bWp != null) {
            this.bWp.setFrom(i);
        }
    }

    public void setDisPraiseFrom(int i) {
        if (this.bWo != null) {
            this.bWo.setFrom(i);
        }
        if (this.bWp != null) {
            this.bWp.setFrom(i);
        }
    }

    public void setForumId(String str) {
        if (this.bWo != null) {
            this.bWo.setForumId(str);
        }
        if (this.bWp != null) {
            this.bWp.setForumId(str);
        }
    }

    public void setClickable(boolean z) {
        if (this.bWo != null) {
            this.bWo.setViewEnabled(z);
        }
        if (this.bWp != null) {
            this.bWp.setViewEnabled(z);
        }
    }

    public void o(bh bhVar) {
        this.We = bhVar;
        if (this.bWo != null) {
            this.bWo.o(bhVar);
        }
        if (this.bWp != null) {
            this.bWp.o(bhVar);
        }
    }

    public void JS() {
        if (this.bWo != null) {
            this.bWo.JS();
        }
        if (this.bWp != null) {
            this.bWp.JS();
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.bWr);
        MessageManager.getInstance().unRegisterListener(this.bWs);
    }

    public void j(BdUniqueId bdUniqueId) {
        this.bWr.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.bWr);
        this.bWs.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.bWs);
    }
}

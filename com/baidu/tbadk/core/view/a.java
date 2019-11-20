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
    private bh Fs;
    private PraiseView clu;
    private DisPraiseView clv;
    private final View.OnClickListener clw = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.updateUI();
        }
    };
    private CustomMessageListener clx = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bh bhVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j) && a.this.Fs != null && !TextUtils.isEmpty(a.this.Fs.getTid()) && (bhVar = ((com.baidu.tbadk.data.j) customResponsedMessage.getData()).cDm) != null && a.this.Fs.getTid().equals(bhVar.getTid())) {
                a.this.Fs.hQ(bhVar.ajZ());
                a.this.Fs.hO(bhVar.ajY());
                a.this.Fs.aK(bhVar.ajW());
                a.this.Fs.aL(bhVar.ajX());
                a.this.updateUI();
            }
        }
    };
    private CustomMessageListener cly = new CustomMessageListener(2156670) { // from class: com.baidu.tbadk.core.view.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && ((String) customResponsedMessage.getData()).equals("zan_or_cai_smallflow")) {
                a.this.anq();
                a.this.updateUI();
            }
        }
    };

    public a(PraiseView praiseView, DisPraiseView disPraiseView) {
        this.clu = praiseView;
        this.clv = disPraiseView;
    }

    public void anq() {
        if (com.baidu.tbadk.util.a.axn().aoN()) {
            if (this.clu != null) {
                this.clu.textResId = R.string.action_like;
                this.clu.cmm = R.color.cp_cont_j;
                this.clu.cmn = R.color.cp_cont_h;
                this.clu.drawableResId = R.drawable.icon_card_like_n;
                this.clu.cml = R.drawable.icon_card_like_s;
                this.clu.setAfterClickListener(this.clw);
                this.clu.setVisibility(0);
            }
            if (this.clv != null) {
                this.clv.textResId = R.string.action_dislike;
                this.clv.cmm = R.color.cp_cont_j;
                this.clv.cmn = R.color.cp_link_tip_a;
                this.clv.drawableResId = R.drawable.icon_card_dislike_n;
                this.clv.cml = R.drawable.icon_card_dislike_s;
                this.clv.setAfterClickListener(this.clw);
                this.clv.setVisibility(0);
                return;
            }
            return;
        }
        if (this.clu != null) {
            this.clu.textResId = R.string.action_praise_default;
            this.clu.cmm = R.color.cp_cont_j;
            this.clu.cmn = R.color.cp_cont_h;
            this.clu.drawableResId = anr() ? R.drawable.icon_home_card_like_n_xmas : R.drawable.icon_home_card_like_n;
            this.clu.cml = anr() ? R.drawable.icon_home_card_like_s_xmas : R.drawable.icon_home_card_like_s;
            this.clu.setVisibility(0);
            this.clu.setAfterClickListener(this.clw);
        }
        if (this.clv != null) {
            this.clv.setAfterClickListener(this.clw);
            this.clv.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.clu != null) {
            this.clu.onChangeSkinType(i);
        }
        if (this.clv != null) {
            this.clv.onChangeSkinType(i);
        }
    }

    private boolean anr() {
        com.baidu.tbadk.coreExtra.data.c activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        return activitySwitch != null && activitySwitch.aoP();
    }

    public void setFrom(int i) {
        if (this.clu != null) {
            this.clu.setFrom(i);
        }
        if (this.clv != null) {
            this.clv.setFrom(i);
        }
    }

    public void setDisPraiseFrom(int i) {
        if (this.clu != null) {
            this.clu.setFrom(i);
        }
        if (this.clv != null) {
            this.clv.setFrom(i);
        }
    }

    public void setForumId(String str) {
        if (this.clu != null) {
            this.clu.setForumId(str);
        }
        if (this.clv != null) {
            this.clv.setForumId(str);
        }
    }

    public void setClickable(boolean z) {
        if (this.clu != null) {
            this.clu.setViewEnabled(z);
        }
        if (this.clv != null) {
            this.clv.setViewEnabled(z);
        }
    }

    public void p(bh bhVar) {
        this.Fs = bhVar;
        if (this.clu != null) {
            this.clu.p(bhVar);
        }
        if (this.clv != null) {
            this.clv.p(bhVar);
        }
    }

    public void updateUI() {
        if (this.clu != null) {
            this.clu.updateUI();
        }
        if (this.clv != null) {
            this.clv.updateUI();
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.clx);
        MessageManager.getInstance().unRegisterListener(this.cly);
    }

    public void j(BdUniqueId bdUniqueId) {
        this.clx.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.clx);
        this.cly.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.cly);
    }
}

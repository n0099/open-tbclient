package com.baidu.tbadk.core.view;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes6.dex */
public class a {
    protected PostPraiseView aEU;
    protected PostDisPraiseView aEV;
    protected ImageView aEW;
    private PostData aEX;
    private boolean aEY;
    private final View.OnClickListener aEZ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.updateUI();
        }
    };
    private CustomMessageListener aFa = new CustomMessageListener(2016529) { // from class: com.baidu.tbadk.core.view.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PostData postData;
            if ((customResponsedMessage.getData() instanceof PostData) && a.this.aEX != null && !TextUtils.isEmpty(a.this.aEX.getId()) && (postData = (PostData) customResponsedMessage.getData()) != null && a.this.aEX.getId().equals(postData.getId())) {
                a.this.aEX.C(postData.AS());
                a.this.aEX.D(postData.AT());
                a.this.aEX.nv(postData.aDb());
                a.this.aEX.cY(postData.AV());
                a.this.updateUI();
            }
        }
    };
    private CustomMessageListener aFb = new CustomMessageListener(2156670) { // from class: com.baidu.tbadk.core.view.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && ((String) customResponsedMessage.getData()).equals("zan_or_cai_smallflow")) {
                a.this.EF();
                a.this.updateUI();
            }
        }
    };

    public a(PostPraiseView postPraiseView, PostDisPraiseView postDisPraiseView, ImageView imageView) {
        this.aEU = postPraiseView;
        this.aEV = postDisPraiseView;
        this.aEW = imageView;
        setFrom(5);
    }

    public void by(boolean z) {
        this.aEY = z;
    }

    public void EF() {
        if (com.baidu.tbadk.util.a.PH().Gf()) {
            if (this.aEU != null) {
                this.aEU.aFr = e.j.action_like;
                this.aEU.aFu = e.f.selector_comment_and_prise_item_text_color;
                this.aEU.aFv = e.d.cp_cont_h;
                this.aEU.aFs = e.f.icon_card_like_n;
                this.aEU.aFt = e.f.icon_card_like_s;
                this.aEU.setAfterClickListener(this.aEZ);
                this.aEU.setVisibility(0);
            }
            if (this.aEV != null) {
                this.aEV.aFr = e.j.action_dislike;
                this.aEV.aFu = e.d.cp_cont_j;
                this.aEV.aFv = e.d.cp_link_tip_a;
                this.aEV.aFs = e.f.icon_card_dislike_n;
                this.aEV.aFt = e.f.icon_card_dislike_s;
                this.aEV.setAfterClickListener(this.aEZ);
                this.aEV.setVisibility(0);
            }
            if (this.aEW != null) {
                this.aEW.setVisibility(8);
                return;
            }
            return;
        }
        if (this.aEU != null) {
            this.aEU.aFr = e.j.action_praise_default;
            this.aEU.aFu = e.f.selector_comment_and_prise_item_text_color;
            this.aEU.aFv = e.d.cp_cont_h;
            this.aEU.aFs = EG() ? e.f.icon_home_card_like_n_xmas : e.f.icon_home_card_like_n;
            this.aEU.aFt = EG() ? e.f.icon_home_card_like_s_xmas : e.f.icon_home_card_like_s;
            this.aEU.setVisibility(this.aEY ? 8 : 0);
            this.aEU.setAfterClickListener(this.aEZ);
        }
        if (this.aEV != null) {
            this.aEV.setAfterClickListener(this.aEZ);
            this.aEV.setVisibility(8);
        }
        if (this.aEW != null) {
            this.aEW.setVisibility(this.aEY ? 8 : 0);
        }
    }

    private boolean EG() {
        com.baidu.tbadk.coreExtra.data.c activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        return activitySwitch != null && activitySwitch.Gq();
    }

    public void setFrom(int i) {
        if (this.aEU != null) {
            this.aEU.setFrom(i);
        }
        if (this.aEV != null) {
            this.aEV.setFrom(i);
        }
    }

    public void a(PostData postData) {
        if (this.aEX == null) {
            this.aEX = postData;
        }
        if (this.aEU != null) {
            this.aEU.a(postData);
        }
        if (this.aEV != null) {
            this.aEV.a(postData);
        }
    }

    public void updateUI() {
        if (this.aEU != null) {
            this.aEU.updateUI();
        }
        if (this.aEV != null) {
            this.aEV.updateUI();
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        this.aFb.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.aFb);
        this.aFa.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.aFa);
    }
}

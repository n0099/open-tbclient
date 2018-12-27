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
    protected PostPraiseView aEV;
    protected PostDisPraiseView aEW;
    protected ImageView aEX;
    private PostData aEY;
    private boolean aEZ;
    private final View.OnClickListener aFa = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.updateUI();
        }
    };
    private CustomMessageListener aFb = new CustomMessageListener(2016529) { // from class: com.baidu.tbadk.core.view.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PostData postData;
            if ((customResponsedMessage.getData() instanceof PostData) && a.this.aEY != null && !TextUtils.isEmpty(a.this.aEY.getId()) && (postData = (PostData) customResponsedMessage.getData()) != null && a.this.aEY.getId().equals(postData.getId())) {
                a.this.aEY.C(postData.AS());
                a.this.aEY.D(postData.AT());
                a.this.aEY.ny(postData.aDQ());
                a.this.aEY.cY(postData.AV());
                a.this.updateUI();
            }
        }
    };
    private CustomMessageListener aFc = new CustomMessageListener(2156670) { // from class: com.baidu.tbadk.core.view.a.3
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
        this.aEV = postPraiseView;
        this.aEW = postDisPraiseView;
        this.aEX = imageView;
        setFrom(5);
    }

    public void by(boolean z) {
        this.aEZ = z;
    }

    public void EF() {
        if (com.baidu.tbadk.util.a.PJ().Gg()) {
            if (this.aEV != null) {
                this.aEV.aFs = e.j.action_like;
                this.aEV.aFv = e.f.selector_comment_and_prise_item_text_color;
                this.aEV.aFw = e.d.cp_cont_h;
                this.aEV.aFt = e.f.icon_card_like_n;
                this.aEV.aFu = e.f.icon_card_like_s;
                this.aEV.setAfterClickListener(this.aFa);
                this.aEV.setVisibility(0);
            }
            if (this.aEW != null) {
                this.aEW.aFs = e.j.action_dislike;
                this.aEW.aFv = e.d.cp_cont_j;
                this.aEW.aFw = e.d.cp_link_tip_a;
                this.aEW.aFt = e.f.icon_card_dislike_n;
                this.aEW.aFu = e.f.icon_card_dislike_s;
                this.aEW.setAfterClickListener(this.aFa);
                this.aEW.setVisibility(0);
            }
            if (this.aEX != null) {
                this.aEX.setVisibility(8);
                return;
            }
            return;
        }
        if (this.aEV != null) {
            this.aEV.aFs = e.j.action_praise_default;
            this.aEV.aFv = e.f.selector_comment_and_prise_item_text_color;
            this.aEV.aFw = e.d.cp_cont_h;
            this.aEV.aFt = EG() ? e.f.icon_home_card_like_n_xmas : e.f.icon_home_card_like_n;
            this.aEV.aFu = EG() ? e.f.icon_home_card_like_s_xmas : e.f.icon_home_card_like_s;
            this.aEV.setVisibility(this.aEZ ? 8 : 0);
            this.aEV.setAfterClickListener(this.aFa);
        }
        if (this.aEW != null) {
            this.aEW.setAfterClickListener(this.aFa);
            this.aEW.setVisibility(8);
        }
        if (this.aEX != null) {
            this.aEX.setVisibility(this.aEZ ? 8 : 0);
        }
    }

    private boolean EG() {
        com.baidu.tbadk.coreExtra.data.c activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        return activitySwitch != null && activitySwitch.Gr();
    }

    public void setFrom(int i) {
        if (this.aEV != null) {
            this.aEV.setFrom(i);
        }
        if (this.aEW != null) {
            this.aEW.setFrom(i);
        }
    }

    public void a(PostData postData) {
        if (this.aEY == null) {
            this.aEY = postData;
        }
        if (this.aEV != null) {
            this.aEV.a(postData);
        }
        if (this.aEW != null) {
            this.aEW.a(postData);
        }
    }

    public void updateUI() {
        if (this.aEV != null) {
            this.aEV.updateUI();
        }
        if (this.aEW != null) {
            this.aEW.updateUI();
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        this.aFc.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.aFc);
        this.aFb.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.aFb);
    }
}

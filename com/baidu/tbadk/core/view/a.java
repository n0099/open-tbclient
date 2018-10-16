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
    protected PostPraiseView aAF;
    protected PostDisPraiseView aAG;
    protected ImageView aAH;
    private PostData aAI;
    private boolean aAJ;
    private final View.OnClickListener aAK = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.updateUI();
        }
    };
    private CustomMessageListener aAL = new CustomMessageListener(2016529) { // from class: com.baidu.tbadk.core.view.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PostData postData;
            if ((customResponsedMessage.getData() instanceof PostData) && a.this.aAI != null && !TextUtils.isEmpty(a.this.aAI.getId()) && (postData = (PostData) customResponsedMessage.getData()) != null && a.this.aAI.getId().equals(postData.getId())) {
                a.this.aAI.v(postData.zH());
                a.this.aAI.w(postData.zI());
                a.this.aAI.ni(postData.aBT());
                a.this.aAI.cw(postData.zK());
                a.this.updateUI();
            }
        }
    };
    private CustomMessageListener aAM = new CustomMessageListener(2156670) { // from class: com.baidu.tbadk.core.view.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && ((String) customResponsedMessage.getData()).equals("zan_or_cai_smallflow")) {
                a.this.Du();
                a.this.updateUI();
            }
        }
    };

    public a(PostPraiseView postPraiseView, PostDisPraiseView postDisPraiseView, ImageView imageView) {
        this.aAF = postPraiseView;
        this.aAG = postDisPraiseView;
        this.aAH = imageView;
        setFrom(5);
    }

    public void bh(boolean z) {
        this.aAJ = z;
    }

    public void Du() {
        if (com.baidu.tbadk.util.a.Os().EQ()) {
            if (this.aAF != null) {
                this.aAF.aBc = e.j.action_like;
                this.aAF.aBf = e.f.selector_comment_and_prise_item_text_color;
                this.aAF.aBg = e.d.cp_cont_h;
                this.aAF.aBd = e.f.icon_card_like_n;
                this.aAF.aBe = e.f.icon_card_like_s;
                this.aAF.setAfterClickListener(this.aAK);
                this.aAF.setVisibility(0);
            }
            if (this.aAG != null) {
                this.aAG.aBc = e.j.action_dislike;
                this.aAG.aBf = e.d.cp_cont_j;
                this.aAG.aBg = e.d.cp_link_tip_a;
                this.aAG.aBd = e.f.icon_card_dislike_n;
                this.aAG.aBe = e.f.icon_card_dislike_s;
                this.aAG.setAfterClickListener(this.aAK);
                this.aAG.setVisibility(0);
            }
            if (this.aAH != null) {
                this.aAH.setVisibility(8);
                return;
            }
            return;
        }
        if (this.aAF != null) {
            this.aAF.aBc = e.j.action_praise_default;
            this.aAF.aBf = e.f.selector_comment_and_prise_item_text_color;
            this.aAF.aBg = e.d.cp_cont_h;
            this.aAF.aBd = Dv() ? e.f.icon_home_card_like_n_xmas : e.f.icon_home_card_like_n;
            this.aAF.aBe = Dv() ? e.f.icon_home_card_like_s_xmas : e.f.icon_home_card_like_s;
            this.aAF.setVisibility(this.aAJ ? 8 : 0);
            this.aAF.setAfterClickListener(this.aAK);
        }
        if (this.aAG != null) {
            this.aAG.setAfterClickListener(this.aAK);
            this.aAG.setVisibility(8);
        }
        if (this.aAH != null) {
            this.aAH.setVisibility(this.aAJ ? 8 : 0);
        }
    }

    private boolean Dv() {
        com.baidu.tbadk.coreExtra.data.c activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        return activitySwitch != null && activitySwitch.Fb();
    }

    public void setFrom(int i) {
        if (this.aAF != null) {
            this.aAF.setFrom(i);
        }
        if (this.aAG != null) {
            this.aAG.setFrom(i);
        }
    }

    public void a(PostData postData) {
        if (this.aAI == null) {
            this.aAI = postData;
        }
        if (this.aAF != null) {
            this.aAF.a(postData);
        }
        if (this.aAG != null) {
            this.aAG.a(postData);
        }
    }

    public void updateUI() {
        if (this.aAF != null) {
            this.aAF.updateUI();
        }
        if (this.aAG != null) {
            this.aAG.updateUI();
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        this.aAM.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.aAM);
        this.aAL.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.aAL);
    }
}

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
    protected ImageView aFA;
    private PostData aFB;
    private boolean aFC;
    private final View.OnClickListener aFD = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.updateUI();
        }
    };
    private CustomMessageListener aFE = new CustomMessageListener(2016529) { // from class: com.baidu.tbadk.core.view.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PostData postData;
            if ((customResponsedMessage.getData() instanceof PostData) && a.this.aFB != null && !TextUtils.isEmpty(a.this.aFB.getId()) && (postData = (PostData) customResponsedMessage.getData()) != null && a.this.aFB.getId().equals(postData.getId())) {
                a.this.aFB.C(postData.Bf());
                a.this.aFB.D(postData.Bg());
                a.this.aFB.nz(postData.aEn());
                a.this.aFB.cY(postData.Bi());
                a.this.updateUI();
            }
        }
    };
    private CustomMessageListener aFF = new CustomMessageListener(2156670) { // from class: com.baidu.tbadk.core.view.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && ((String) customResponsedMessage.getData()).equals("zan_or_cai_smallflow")) {
                a.this.ES();
                a.this.updateUI();
            }
        }
    };
    protected PostPraiseView aFy;
    protected PostDisPraiseView aFz;

    public a(PostPraiseView postPraiseView, PostDisPraiseView postDisPraiseView, ImageView imageView) {
        this.aFy = postPraiseView;
        this.aFz = postDisPraiseView;
        this.aFA = imageView;
        setFrom(5);
    }

    public void bz(boolean z) {
        this.aFC = z;
    }

    public void ES() {
        if (com.baidu.tbadk.util.a.Qb().Gt()) {
            if (this.aFy != null) {
                this.aFy.aFV = e.j.action_like;
                this.aFy.aFY = e.f.selector_comment_and_prise_item_text_color;
                this.aFy.aFZ = e.d.cp_cont_h;
                this.aFy.aFW = e.f.icon_card_like_n;
                this.aFy.aFX = e.f.icon_card_like_s;
                this.aFy.setAfterClickListener(this.aFD);
                this.aFy.setVisibility(0);
            }
            if (this.aFz != null) {
                this.aFz.aFV = e.j.action_dislike;
                this.aFz.aFY = e.d.cp_cont_j;
                this.aFz.aFZ = e.d.cp_link_tip_a;
                this.aFz.aFW = e.f.icon_card_dislike_n;
                this.aFz.aFX = e.f.icon_card_dislike_s;
                this.aFz.setAfterClickListener(this.aFD);
                this.aFz.setVisibility(0);
            }
            if (this.aFA != null) {
                this.aFA.setVisibility(8);
                return;
            }
            return;
        }
        if (this.aFy != null) {
            this.aFy.aFV = e.j.action_praise_default;
            this.aFy.aFY = e.f.selector_comment_and_prise_item_text_color;
            this.aFy.aFZ = e.d.cp_cont_h;
            this.aFy.aFW = ET() ? e.f.icon_home_card_like_n_xmas : e.f.icon_home_card_like_n;
            this.aFy.aFX = ET() ? e.f.icon_home_card_like_s_xmas : e.f.icon_home_card_like_s;
            this.aFy.setVisibility(this.aFC ? 8 : 0);
            this.aFy.setAfterClickListener(this.aFD);
        }
        if (this.aFz != null) {
            this.aFz.setAfterClickListener(this.aFD);
            this.aFz.setVisibility(8);
        }
        if (this.aFA != null) {
            this.aFA.setVisibility(this.aFC ? 8 : 0);
        }
    }

    private boolean ET() {
        com.baidu.tbadk.coreExtra.data.c activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        return activitySwitch != null && activitySwitch.GE();
    }

    public void setFrom(int i) {
        if (this.aFy != null) {
            this.aFy.setFrom(i);
        }
        if (this.aFz != null) {
            this.aFz.setFrom(i);
        }
    }

    public void a(PostData postData) {
        if (this.aFB == null) {
            this.aFB = postData;
        }
        if (this.aFy != null) {
            this.aFy.a(postData);
        }
        if (this.aFz != null) {
            this.aFz.a(postData);
        }
    }

    public void updateUI() {
        if (this.aFy != null) {
            this.aFy.updateUI();
        }
        if (this.aFz != null) {
            this.aFz.updateUI();
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        this.aFF.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.aFF);
        this.aFE.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.aFE);
    }
}

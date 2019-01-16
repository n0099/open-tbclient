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
    private PostData aFA;
    private boolean aFB;
    private final View.OnClickListener aFC = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.updateUI();
        }
    };
    private CustomMessageListener aFD = new CustomMessageListener(2016529) { // from class: com.baidu.tbadk.core.view.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PostData postData;
            if ((customResponsedMessage.getData() instanceof PostData) && a.this.aFA != null && !TextUtils.isEmpty(a.this.aFA.getId()) && (postData = (PostData) customResponsedMessage.getData()) != null && a.this.aFA.getId().equals(postData.getId())) {
                a.this.aFA.C(postData.Bf());
                a.this.aFA.D(postData.Bg());
                a.this.aFA.nz(postData.aEn());
                a.this.aFA.cY(postData.Bi());
                a.this.updateUI();
            }
        }
    };
    private CustomMessageListener aFE = new CustomMessageListener(2156670) { // from class: com.baidu.tbadk.core.view.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && ((String) customResponsedMessage.getData()).equals("zan_or_cai_smallflow")) {
                a.this.ES();
                a.this.updateUI();
            }
        }
    };
    protected PostPraiseView aFx;
    protected PostDisPraiseView aFy;
    protected ImageView aFz;

    public a(PostPraiseView postPraiseView, PostDisPraiseView postDisPraiseView, ImageView imageView) {
        this.aFx = postPraiseView;
        this.aFy = postDisPraiseView;
        this.aFz = imageView;
        setFrom(5);
    }

    public void bz(boolean z) {
        this.aFB = z;
    }

    public void ES() {
        if (com.baidu.tbadk.util.a.Qb().Gt()) {
            if (this.aFx != null) {
                this.aFx.aFU = e.j.action_like;
                this.aFx.aFX = e.f.selector_comment_and_prise_item_text_color;
                this.aFx.aFY = e.d.cp_cont_h;
                this.aFx.aFV = e.f.icon_card_like_n;
                this.aFx.aFW = e.f.icon_card_like_s;
                this.aFx.setAfterClickListener(this.aFC);
                this.aFx.setVisibility(0);
            }
            if (this.aFy != null) {
                this.aFy.aFU = e.j.action_dislike;
                this.aFy.aFX = e.d.cp_cont_j;
                this.aFy.aFY = e.d.cp_link_tip_a;
                this.aFy.aFV = e.f.icon_card_dislike_n;
                this.aFy.aFW = e.f.icon_card_dislike_s;
                this.aFy.setAfterClickListener(this.aFC);
                this.aFy.setVisibility(0);
            }
            if (this.aFz != null) {
                this.aFz.setVisibility(8);
                return;
            }
            return;
        }
        if (this.aFx != null) {
            this.aFx.aFU = e.j.action_praise_default;
            this.aFx.aFX = e.f.selector_comment_and_prise_item_text_color;
            this.aFx.aFY = e.d.cp_cont_h;
            this.aFx.aFV = ET() ? e.f.icon_home_card_like_n_xmas : e.f.icon_home_card_like_n;
            this.aFx.aFW = ET() ? e.f.icon_home_card_like_s_xmas : e.f.icon_home_card_like_s;
            this.aFx.setVisibility(this.aFB ? 8 : 0);
            this.aFx.setAfterClickListener(this.aFC);
        }
        if (this.aFy != null) {
            this.aFy.setAfterClickListener(this.aFC);
            this.aFy.setVisibility(8);
        }
        if (this.aFz != null) {
            this.aFz.setVisibility(this.aFB ? 8 : 0);
        }
    }

    private boolean ET() {
        com.baidu.tbadk.coreExtra.data.c activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        return activitySwitch != null && activitySwitch.GE();
    }

    public void setFrom(int i) {
        if (this.aFx != null) {
            this.aFx.setFrom(i);
        }
        if (this.aFy != null) {
            this.aFy.setFrom(i);
        }
    }

    public void a(PostData postData) {
        if (this.aFA == null) {
            this.aFA = postData;
        }
        if (this.aFx != null) {
            this.aFx.a(postData);
        }
        if (this.aFy != null) {
            this.aFy.a(postData);
        }
    }

    public void updateUI() {
        if (this.aFx != null) {
            this.aFx.updateUI();
        }
        if (this.aFy != null) {
            this.aFy.updateUI();
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        this.aFE.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.aFE);
        this.aFD.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.aFD);
    }
}

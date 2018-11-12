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
    protected PostPraiseView aBu;
    protected PostDisPraiseView aBv;
    protected ImageView aBw;
    private PostData aBx;
    private boolean aBy;
    private final View.OnClickListener aBz = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.updateUI();
        }
    };
    private CustomMessageListener aBA = new CustomMessageListener(2016529) { // from class: com.baidu.tbadk.core.view.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PostData postData;
            if ((customResponsedMessage.getData() instanceof PostData) && a.this.aBx != null && !TextUtils.isEmpty(a.this.aBx.getId()) && (postData = (PostData) customResponsedMessage.getData()) != null && a.this.aBx.getId().equals(postData.getId())) {
                a.this.aBx.x(postData.zO());
                a.this.aBx.y(postData.zP());
                a.this.aBx.nt(postData.aBr());
                a.this.aBx.cK(postData.zR());
                a.this.updateUI();
            }
        }
    };
    private CustomMessageListener aBB = new CustomMessageListener(2156670) { // from class: com.baidu.tbadk.core.view.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && ((String) customResponsedMessage.getData()).equals("zan_or_cai_smallflow")) {
                a.this.DB();
                a.this.updateUI();
            }
        }
    };

    public a(PostPraiseView postPraiseView, PostDisPraiseView postDisPraiseView, ImageView imageView) {
        this.aBu = postPraiseView;
        this.aBv = postDisPraiseView;
        this.aBw = imageView;
        setFrom(5);
    }

    public void bx(boolean z) {
        this.aBy = z;
    }

    public void DB() {
        if (com.baidu.tbadk.util.a.OB().Fb()) {
            if (this.aBu != null) {
                this.aBu.aBR = e.j.action_like;
                this.aBu.aBU = e.f.selector_comment_and_prise_item_text_color;
                this.aBu.aBV = e.d.cp_cont_h;
                this.aBu.aBS = e.f.icon_card_like_n;
                this.aBu.aBT = e.f.icon_card_like_s;
                this.aBu.setAfterClickListener(this.aBz);
                this.aBu.setVisibility(0);
            }
            if (this.aBv != null) {
                this.aBv.aBR = e.j.action_dislike;
                this.aBv.aBU = e.d.cp_cont_j;
                this.aBv.aBV = e.d.cp_link_tip_a;
                this.aBv.aBS = e.f.icon_card_dislike_n;
                this.aBv.aBT = e.f.icon_card_dislike_s;
                this.aBv.setAfterClickListener(this.aBz);
                this.aBv.setVisibility(0);
            }
            if (this.aBw != null) {
                this.aBw.setVisibility(8);
                return;
            }
            return;
        }
        if (this.aBu != null) {
            this.aBu.aBR = e.j.action_praise_default;
            this.aBu.aBU = e.f.selector_comment_and_prise_item_text_color;
            this.aBu.aBV = e.d.cp_cont_h;
            this.aBu.aBS = DC() ? e.f.icon_home_card_like_n_xmas : e.f.icon_home_card_like_n;
            this.aBu.aBT = DC() ? e.f.icon_home_card_like_s_xmas : e.f.icon_home_card_like_s;
            this.aBu.setVisibility(this.aBy ? 8 : 0);
            this.aBu.setAfterClickListener(this.aBz);
        }
        if (this.aBv != null) {
            this.aBv.setAfterClickListener(this.aBz);
            this.aBv.setVisibility(8);
        }
        if (this.aBw != null) {
            this.aBw.setVisibility(this.aBy ? 8 : 0);
        }
    }

    private boolean DC() {
        com.baidu.tbadk.coreExtra.data.c activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        return activitySwitch != null && activitySwitch.Fm();
    }

    public void setFrom(int i) {
        if (this.aBu != null) {
            this.aBu.setFrom(i);
        }
        if (this.aBv != null) {
            this.aBv.setFrom(i);
        }
    }

    public void a(PostData postData) {
        if (this.aBx == null) {
            this.aBx = postData;
        }
        if (this.aBu != null) {
            this.aBu.a(postData);
        }
        if (this.aBv != null) {
            this.aBv.a(postData);
        }
    }

    public void updateUI() {
        if (this.aBu != null) {
            this.aBu.updateUI();
        }
        if (this.aBv != null) {
            this.aBv.updateUI();
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        this.aBB.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.aBB);
        this.aBA.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.aBA);
    }
}

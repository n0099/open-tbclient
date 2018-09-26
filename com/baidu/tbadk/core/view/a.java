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
/* loaded from: classes2.dex */
public class a {
    protected PostPraiseView avU;
    protected PostDisPraiseView avV;
    protected ImageView avW;
    private PostData avX;
    private boolean avY;
    private final View.OnClickListener avZ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.Bp();
        }
    };
    private CustomMessageListener awa = new CustomMessageListener(2016552) { // from class: com.baidu.tbadk.core.view.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PostData postData;
            if ((customResponsedMessage.getData() instanceof PostData) && a.this.avX != null && !TextUtils.isEmpty(a.this.avX.getId()) && (postData = (PostData) customResponsedMessage.getData()) != null && a.this.avX.getId().equals(postData.getId())) {
                a.this.avX.t(postData.xy());
                a.this.avX.u(postData.xz());
                a.this.avX.mR(postData.ayA());
                a.this.avX.cm(postData.xB());
                a.this.Bp();
            }
        }
    };
    private CustomMessageListener awb = new CustomMessageListener(2156670) { // from class: com.baidu.tbadk.core.view.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && ((String) customResponsedMessage.getData()).equals("zan_or_cai_smallflow")) {
                a.this.Bn();
                a.this.Bp();
            }
        }
    };

    public a(PostPraiseView postPraiseView, PostDisPraiseView postDisPraiseView, ImageView imageView) {
        this.avU = postPraiseView;
        this.avV = postDisPraiseView;
        this.avW = imageView;
        setFrom(5);
    }

    public void aX(boolean z) {
        this.avY = z;
    }

    public void Bn() {
        if (com.baidu.tbadk.util.a.Mu().CM()) {
            if (this.avU != null) {
                this.avU.awr = e.j.action_like;
                this.avU.awu = e.f.selector_comment_and_prise_item_text_color;
                this.avU.awv = e.d.cp_cont_h;
                this.avU.aws = e.f.icon_card_like_n;
                this.avU.awt = e.f.icon_card_like_s;
                this.avU.setAfterClickListener(this.avZ);
                this.avU.setVisibility(0);
            }
            if (this.avV != null) {
                this.avV.awr = e.j.action_dislike;
                this.avV.awu = e.d.cp_cont_j;
                this.avV.awv = e.d.cp_link_tip_a;
                this.avV.aws = e.f.icon_card_dislike_n;
                this.avV.awt = e.f.icon_card_dislike_s;
                this.avV.setAfterClickListener(this.avZ);
                this.avV.setVisibility(0);
            }
            if (this.avW != null) {
                this.avW.setVisibility(8);
                return;
            }
            return;
        }
        if (this.avU != null) {
            this.avU.awr = e.j.action_praise_default;
            this.avU.awu = e.f.selector_comment_and_prise_item_text_color;
            this.avU.awv = e.d.cp_cont_h;
            this.avU.aws = Bo() ? e.f.icon_home_card_like_n_xmas : e.f.icon_home_card_like_n;
            this.avU.awt = Bo() ? e.f.icon_home_card_like_s_xmas : e.f.icon_home_card_like_s;
            this.avU.setVisibility(this.avY ? 8 : 0);
            this.avU.setAfterClickListener(this.avZ);
        }
        if (this.avV != null) {
            this.avV.setAfterClickListener(this.avZ);
            this.avV.setVisibility(8);
        }
        if (this.avW != null) {
            this.avW.setVisibility(this.avY ? 8 : 0);
        }
    }

    private boolean Bo() {
        com.baidu.tbadk.coreExtra.data.c activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        return activitySwitch != null && activitySwitch.CX();
    }

    public void setFrom(int i) {
        if (this.avU != null) {
            this.avU.setFrom(i);
        }
        if (this.avV != null) {
            this.avV.setFrom(i);
        }
    }

    public void a(PostData postData) {
        if (this.avX == null) {
            this.avX = postData;
        }
        if (this.avU != null) {
            this.avU.a(postData);
        }
        if (this.avV != null) {
            this.avV.a(postData);
        }
    }

    public void Bp() {
        if (this.avU != null) {
            this.avU.Bp();
        }
        if (this.avV != null) {
            this.avV.Bp();
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        this.awb.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.awb);
        this.awa.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.awa);
    }
}

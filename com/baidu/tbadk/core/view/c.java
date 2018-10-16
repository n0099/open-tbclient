package com.baidu.tbadk.core.view;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class c {
    private VideoAggregationPraiseView aAT;
    private VideoAggregationDisPraiseView aAU;
    private com.baidu.tieba.frs.aggregation.g aAV;
    private final View.OnClickListener aAK = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.updateUI();
        }
    };
    private CustomMessageListener aAR = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bb bbVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.h) && c.this.aAV != null && !TextUtils.isEmpty(c.this.aAV.getThreadId()) && (bbVar = ((com.baidu.tbadk.data.h) customResponsedMessage.getData()).aSY) != null && c.this.aAV.getThreadId().equals(bbVar.getTid())) {
                c.this.aAV.cw(bbVar.zK());
                c.this.aAV.cu(bbVar.zJ());
                c.this.aAV.v(bbVar.zH());
                c.this.aAV.w(bbVar.zI());
                c.this.updateUI();
            }
        }
    };
    private CustomMessageListener aAM = new CustomMessageListener(2156670) { // from class: com.baidu.tbadk.core.view.c.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && ((String) customResponsedMessage.getData()).equals("zan_or_cai_smallflow")) {
                c.this.Du();
                c.this.updateUI();
            }
        }
    };

    public c(VideoAggregationPraiseView videoAggregationPraiseView, VideoAggregationDisPraiseView videoAggregationDisPraiseView) {
        this.aAT = videoAggregationPraiseView;
        this.aAU = videoAggregationDisPraiseView;
    }

    public void Du() {
        if (com.baidu.tbadk.util.a.Os().EQ()) {
            if (this.aAT != null) {
                this.aAT.aBc = e.j.action_like;
                this.aAT.aBf = e.d.cp_cont_i_alpha70;
                this.aAT.aBg = e.d.cp_cont_h_alpha70;
                this.aAT.aBd = e.f.icon_card_like_video_n;
                this.aAT.aBe = e.f.icon_card_like_video_s;
                this.aAT.setAfterClickListener(this.aAK);
                this.aAT.setVisibility(0);
            }
            if (this.aAU != null) {
                this.aAU.aBf = e.d.cp_cont_i_alpha70;
                this.aAU.aBg = e.d.cp_link_tip_a_alpha70;
                this.aAU.aBd = e.f.icon_card_dislike_white_n;
                this.aAU.aBe = e.f.icon_card_dislike_white_s;
                this.aAU.setAfterClickListener(this.aAK);
                this.aAU.setVisibility(0);
                return;
            }
            return;
        }
        if (this.aAT != null) {
            this.aAT.aBc = e.j.action_praise_default;
            this.aAT.aBf = e.d.cp_cont_i_alpha70;
            this.aAT.aBg = e.d.cp_cont_h_alpha70_1;
            this.aAT.aBd = e.f.icon_card_like_white_n;
            this.aAT.aBe = e.f.icon_home_card_like_s;
            this.aAT.setVisibility(0);
            this.aAT.setAfterClickListener(this.aAK);
        }
        if (this.aAU != null) {
            this.aAU.setAfterClickListener(this.aAK);
            this.aAU.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.aAT != null) {
            this.aAT.onChangeSkinType(i);
        }
        if (this.aAU != null) {
            this.aAU.onChangeSkinType(i);
        }
    }

    public void a(com.baidu.tieba.frs.aggregation.g gVar) {
        this.aAV = gVar;
        if (this.aAT != null) {
            this.aAT.a(gVar);
        }
        if (this.aAU != null) {
            this.aAU.a(gVar);
        }
    }

    public void updateUI() {
        if (this.aAT != null) {
            this.aAT.updateUI();
        }
        if (this.aAU != null) {
            this.aAU.updateUI();
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.aAR);
        MessageManager.getInstance().unRegisterListener(this.aAM);
    }

    public void h(BdUniqueId bdUniqueId) {
        this.aAR.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.aAR);
        this.aAM.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.aAM);
    }
}

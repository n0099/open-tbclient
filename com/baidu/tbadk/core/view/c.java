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
    private VideoAggregationPraiseView aFL;
    private VideoAggregationDisPraiseView aFM;
    private com.baidu.tieba.frs.aggregation.g aFN;
    private final View.OnClickListener aFC = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.updateUI();
        }
    };
    private CustomMessageListener aFJ = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bb bbVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j) && c.this.aFN != null && !TextUtils.isEmpty(c.this.aFN.getThreadId()) && (bbVar = ((com.baidu.tbadk.data.j) customResponsedMessage.getData()).aXY) != null && c.this.aFN.getThreadId().equals(bbVar.getTid())) {
                c.this.aFN.cY(bbVar.Bi());
                c.this.aFN.cW(bbVar.Bh());
                c.this.aFN.C(bbVar.Bf());
                c.this.aFN.D(bbVar.Bg());
                c.this.updateUI();
            }
        }
    };
    private CustomMessageListener aFE = new CustomMessageListener(2156670) { // from class: com.baidu.tbadk.core.view.c.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && ((String) customResponsedMessage.getData()).equals("zan_or_cai_smallflow")) {
                c.this.ES();
                c.this.updateUI();
            }
        }
    };

    public c(VideoAggregationPraiseView videoAggregationPraiseView, VideoAggregationDisPraiseView videoAggregationDisPraiseView) {
        this.aFL = videoAggregationPraiseView;
        this.aFM = videoAggregationDisPraiseView;
    }

    public void ES() {
        if (com.baidu.tbadk.util.a.Qb().Gt()) {
            if (this.aFL != null) {
                this.aFL.aFU = e.j.action_like;
                this.aFL.aFX = e.d.cp_cont_i_alpha70;
                this.aFL.aFY = e.d.cp_cont_h_alpha70;
                this.aFL.aFV = e.f.icon_card_like_video_n;
                this.aFL.aFW = e.f.icon_card_like_video_s;
                this.aFL.setAfterClickListener(this.aFC);
                this.aFL.setVisibility(0);
            }
            if (this.aFM != null) {
                this.aFM.aFX = e.d.cp_cont_i_alpha70;
                this.aFM.aFY = e.d.cp_link_tip_a_alpha70;
                this.aFM.aFV = e.f.icon_card_dislike_white_n;
                this.aFM.aFW = e.f.icon_card_dislike_white_s;
                this.aFM.setAfterClickListener(this.aFC);
                this.aFM.setVisibility(0);
                return;
            }
            return;
        }
        if (this.aFL != null) {
            this.aFL.aFU = e.j.action_praise_default;
            this.aFL.aFX = e.d.cp_cont_i_alpha70;
            this.aFL.aFY = e.d.cp_cont_h_alpha70_1;
            this.aFL.aFV = e.f.icon_card_like_white_n;
            this.aFL.aFW = e.f.icon_home_card_like_s;
            this.aFL.setVisibility(0);
            this.aFL.setAfterClickListener(this.aFC);
        }
        if (this.aFM != null) {
            this.aFM.setAfterClickListener(this.aFC);
            this.aFM.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.aFL != null) {
            this.aFL.onChangeSkinType(i);
        }
        if (this.aFM != null) {
            this.aFM.onChangeSkinType(i);
        }
    }

    public void a(com.baidu.tieba.frs.aggregation.g gVar) {
        this.aFN = gVar;
        if (this.aFL != null) {
            this.aFL.a(gVar);
        }
        if (this.aFM != null) {
            this.aFM.a(gVar);
        }
    }

    public void updateUI() {
        if (this.aFL != null) {
            this.aFL.updateUI();
        }
        if (this.aFM != null) {
            this.aFM.updateUI();
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.aFJ);
        MessageManager.getInstance().unRegisterListener(this.aFE);
    }

    public void h(BdUniqueId bdUniqueId) {
        this.aFJ.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.aFJ);
        this.aFE.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.aFE);
    }
}

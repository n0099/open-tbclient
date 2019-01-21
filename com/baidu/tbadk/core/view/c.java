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
    private VideoAggregationPraiseView aFM;
    private VideoAggregationDisPraiseView aFN;
    private com.baidu.tieba.frs.aggregation.g aFO;
    private final View.OnClickListener aFD = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.updateUI();
        }
    };
    private CustomMessageListener aFK = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bb bbVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j) && c.this.aFO != null && !TextUtils.isEmpty(c.this.aFO.getThreadId()) && (bbVar = ((com.baidu.tbadk.data.j) customResponsedMessage.getData()).aXZ) != null && c.this.aFO.getThreadId().equals(bbVar.getTid())) {
                c.this.aFO.cY(bbVar.Bi());
                c.this.aFO.cW(bbVar.Bh());
                c.this.aFO.C(bbVar.Bf());
                c.this.aFO.D(bbVar.Bg());
                c.this.updateUI();
            }
        }
    };
    private CustomMessageListener aFF = new CustomMessageListener(2156670) { // from class: com.baidu.tbadk.core.view.c.3
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
        this.aFM = videoAggregationPraiseView;
        this.aFN = videoAggregationDisPraiseView;
    }

    public void ES() {
        if (com.baidu.tbadk.util.a.Qb().Gt()) {
            if (this.aFM != null) {
                this.aFM.aFV = e.j.action_like;
                this.aFM.aFY = e.d.cp_cont_i_alpha70;
                this.aFM.aFZ = e.d.cp_cont_h_alpha70;
                this.aFM.aFW = e.f.icon_card_like_video_n;
                this.aFM.aFX = e.f.icon_card_like_video_s;
                this.aFM.setAfterClickListener(this.aFD);
                this.aFM.setVisibility(0);
            }
            if (this.aFN != null) {
                this.aFN.aFY = e.d.cp_cont_i_alpha70;
                this.aFN.aFZ = e.d.cp_link_tip_a_alpha70;
                this.aFN.aFW = e.f.icon_card_dislike_white_n;
                this.aFN.aFX = e.f.icon_card_dislike_white_s;
                this.aFN.setAfterClickListener(this.aFD);
                this.aFN.setVisibility(0);
                return;
            }
            return;
        }
        if (this.aFM != null) {
            this.aFM.aFV = e.j.action_praise_default;
            this.aFM.aFY = e.d.cp_cont_i_alpha70;
            this.aFM.aFZ = e.d.cp_cont_h_alpha70_1;
            this.aFM.aFW = e.f.icon_card_like_white_n;
            this.aFM.aFX = e.f.icon_home_card_like_s;
            this.aFM.setVisibility(0);
            this.aFM.setAfterClickListener(this.aFD);
        }
        if (this.aFN != null) {
            this.aFN.setAfterClickListener(this.aFD);
            this.aFN.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.aFM != null) {
            this.aFM.onChangeSkinType(i);
        }
        if (this.aFN != null) {
            this.aFN.onChangeSkinType(i);
        }
    }

    public void a(com.baidu.tieba.frs.aggregation.g gVar) {
        this.aFO = gVar;
        if (this.aFM != null) {
            this.aFM.a(gVar);
        }
        if (this.aFN != null) {
            this.aFN.a(gVar);
        }
    }

    public void updateUI() {
        if (this.aFM != null) {
            this.aFM.updateUI();
        }
        if (this.aFN != null) {
            this.aFN.updateUI();
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.aFK);
        MessageManager.getInstance().unRegisterListener(this.aFF);
    }

    public void h(BdUniqueId bdUniqueId) {
        this.aFK.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.aFK);
        this.aFF.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.aFF);
    }
}

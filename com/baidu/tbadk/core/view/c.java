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
    private VideoAggregationPraiseView aBI;
    private VideoAggregationDisPraiseView aBJ;
    private com.baidu.tieba.frs.aggregation.g aBK;
    private final View.OnClickListener aBz = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.updateUI();
        }
    };
    private CustomMessageListener aBG = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bb bbVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.h) && c.this.aBK != null && !TextUtils.isEmpty(c.this.aBK.getThreadId()) && (bbVar = ((com.baidu.tbadk.data.h) customResponsedMessage.getData()).aTO) != null && c.this.aBK.getThreadId().equals(bbVar.getTid())) {
                c.this.aBK.cK(bbVar.zR());
                c.this.aBK.cI(bbVar.zQ());
                c.this.aBK.x(bbVar.zO());
                c.this.aBK.y(bbVar.zP());
                c.this.updateUI();
            }
        }
    };
    private CustomMessageListener aBB = new CustomMessageListener(2156670) { // from class: com.baidu.tbadk.core.view.c.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && ((String) customResponsedMessage.getData()).equals("zan_or_cai_smallflow")) {
                c.this.DB();
                c.this.updateUI();
            }
        }
    };

    public c(VideoAggregationPraiseView videoAggregationPraiseView, VideoAggregationDisPraiseView videoAggregationDisPraiseView) {
        this.aBI = videoAggregationPraiseView;
        this.aBJ = videoAggregationDisPraiseView;
    }

    public void DB() {
        if (com.baidu.tbadk.util.a.OB().Fb()) {
            if (this.aBI != null) {
                this.aBI.aBR = e.j.action_like;
                this.aBI.aBU = e.d.cp_cont_i_alpha70;
                this.aBI.aBV = e.d.cp_cont_h_alpha70;
                this.aBI.aBS = e.f.icon_card_like_video_n;
                this.aBI.aBT = e.f.icon_card_like_video_s;
                this.aBI.setAfterClickListener(this.aBz);
                this.aBI.setVisibility(0);
            }
            if (this.aBJ != null) {
                this.aBJ.aBU = e.d.cp_cont_i_alpha70;
                this.aBJ.aBV = e.d.cp_link_tip_a_alpha70;
                this.aBJ.aBS = e.f.icon_card_dislike_white_n;
                this.aBJ.aBT = e.f.icon_card_dislike_white_s;
                this.aBJ.setAfterClickListener(this.aBz);
                this.aBJ.setVisibility(0);
                return;
            }
            return;
        }
        if (this.aBI != null) {
            this.aBI.aBR = e.j.action_praise_default;
            this.aBI.aBU = e.d.cp_cont_i_alpha70;
            this.aBI.aBV = e.d.cp_cont_h_alpha70_1;
            this.aBI.aBS = e.f.icon_card_like_white_n;
            this.aBI.aBT = e.f.icon_home_card_like_s;
            this.aBI.setVisibility(0);
            this.aBI.setAfterClickListener(this.aBz);
        }
        if (this.aBJ != null) {
            this.aBJ.setAfterClickListener(this.aBz);
            this.aBJ.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.aBI != null) {
            this.aBI.onChangeSkinType(i);
        }
        if (this.aBJ != null) {
            this.aBJ.onChangeSkinType(i);
        }
    }

    public void a(com.baidu.tieba.frs.aggregation.g gVar) {
        this.aBK = gVar;
        if (this.aBI != null) {
            this.aBI.a(gVar);
        }
        if (this.aBJ != null) {
            this.aBJ.a(gVar);
        }
    }

    public void updateUI() {
        if (this.aBI != null) {
            this.aBI.updateUI();
        }
        if (this.aBJ != null) {
            this.aBJ.updateUI();
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.aBG);
        MessageManager.getInstance().unRegisterListener(this.aBB);
    }

    public void h(BdUniqueId bdUniqueId) {
        this.aBG.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.aBG);
        this.aBB.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.aBB);
    }
}

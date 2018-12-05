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
    private VideoAggregationPraiseView aFi;
    private VideoAggregationDisPraiseView aFj;
    private com.baidu.tieba.frs.aggregation.g aFk;
    private final View.OnClickListener aEZ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.updateUI();
        }
    };
    private CustomMessageListener aFg = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bb bbVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.h) && c.this.aFk != null && !TextUtils.isEmpty(c.this.aFk.getThreadId()) && (bbVar = ((com.baidu.tbadk.data.h) customResponsedMessage.getData()).aXl) != null && c.this.aFk.getThreadId().equals(bbVar.getTid())) {
                c.this.aFk.cY(bbVar.AV());
                c.this.aFk.cW(bbVar.AU());
                c.this.aFk.C(bbVar.AS());
                c.this.aFk.D(bbVar.AT());
                c.this.updateUI();
            }
        }
    };
    private CustomMessageListener aFb = new CustomMessageListener(2156670) { // from class: com.baidu.tbadk.core.view.c.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && ((String) customResponsedMessage.getData()).equals("zan_or_cai_smallflow")) {
                c.this.EF();
                c.this.updateUI();
            }
        }
    };

    public c(VideoAggregationPraiseView videoAggregationPraiseView, VideoAggregationDisPraiseView videoAggregationDisPraiseView) {
        this.aFi = videoAggregationPraiseView;
        this.aFj = videoAggregationDisPraiseView;
    }

    public void EF() {
        if (com.baidu.tbadk.util.a.PH().Gf()) {
            if (this.aFi != null) {
                this.aFi.aFr = e.j.action_like;
                this.aFi.aFu = e.d.cp_cont_i_alpha70;
                this.aFi.aFv = e.d.cp_cont_h_alpha70;
                this.aFi.aFs = e.f.icon_card_like_video_n;
                this.aFi.aFt = e.f.icon_card_like_video_s;
                this.aFi.setAfterClickListener(this.aEZ);
                this.aFi.setVisibility(0);
            }
            if (this.aFj != null) {
                this.aFj.aFu = e.d.cp_cont_i_alpha70;
                this.aFj.aFv = e.d.cp_link_tip_a_alpha70;
                this.aFj.aFs = e.f.icon_card_dislike_white_n;
                this.aFj.aFt = e.f.icon_card_dislike_white_s;
                this.aFj.setAfterClickListener(this.aEZ);
                this.aFj.setVisibility(0);
                return;
            }
            return;
        }
        if (this.aFi != null) {
            this.aFi.aFr = e.j.action_praise_default;
            this.aFi.aFu = e.d.cp_cont_i_alpha70;
            this.aFi.aFv = e.d.cp_cont_h_alpha70_1;
            this.aFi.aFs = e.f.icon_card_like_white_n;
            this.aFi.aFt = e.f.icon_home_card_like_s;
            this.aFi.setVisibility(0);
            this.aFi.setAfterClickListener(this.aEZ);
        }
        if (this.aFj != null) {
            this.aFj.setAfterClickListener(this.aEZ);
            this.aFj.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.aFi != null) {
            this.aFi.onChangeSkinType(i);
        }
        if (this.aFj != null) {
            this.aFj.onChangeSkinType(i);
        }
    }

    public void a(com.baidu.tieba.frs.aggregation.g gVar) {
        this.aFk = gVar;
        if (this.aFi != null) {
            this.aFi.a(gVar);
        }
        if (this.aFj != null) {
            this.aFj.a(gVar);
        }
    }

    public void updateUI() {
        if (this.aFi != null) {
            this.aFi.updateUI();
        }
        if (this.aFj != null) {
            this.aFj.updateUI();
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.aFg);
        MessageManager.getInstance().unRegisterListener(this.aFb);
    }

    public void h(BdUniqueId bdUniqueId) {
        this.aFg.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.aFg);
        this.aFb.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.aFb);
    }
}

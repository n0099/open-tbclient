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
    private VideoAggregationPraiseView aFj;
    private VideoAggregationDisPraiseView aFk;
    private com.baidu.tieba.frs.aggregation.g aFl;
    private final View.OnClickListener aFa = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.updateUI();
        }
    };
    private CustomMessageListener aFh = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bb bbVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.h) && c.this.aFl != null && !TextUtils.isEmpty(c.this.aFl.getThreadId()) && (bbVar = ((com.baidu.tbadk.data.h) customResponsedMessage.getData()).aXo) != null && c.this.aFl.getThreadId().equals(bbVar.getTid())) {
                c.this.aFl.cY(bbVar.AV());
                c.this.aFl.cW(bbVar.AU());
                c.this.aFl.C(bbVar.AS());
                c.this.aFl.D(bbVar.AT());
                c.this.updateUI();
            }
        }
    };
    private CustomMessageListener aFc = new CustomMessageListener(2156670) { // from class: com.baidu.tbadk.core.view.c.3
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
        this.aFj = videoAggregationPraiseView;
        this.aFk = videoAggregationDisPraiseView;
    }

    public void EF() {
        if (com.baidu.tbadk.util.a.PJ().Gg()) {
            if (this.aFj != null) {
                this.aFj.aFs = e.j.action_like;
                this.aFj.aFv = e.d.cp_cont_i_alpha70;
                this.aFj.aFw = e.d.cp_cont_h_alpha70;
                this.aFj.aFt = e.f.icon_card_like_video_n;
                this.aFj.aFu = e.f.icon_card_like_video_s;
                this.aFj.setAfterClickListener(this.aFa);
                this.aFj.setVisibility(0);
            }
            if (this.aFk != null) {
                this.aFk.aFv = e.d.cp_cont_i_alpha70;
                this.aFk.aFw = e.d.cp_link_tip_a_alpha70;
                this.aFk.aFt = e.f.icon_card_dislike_white_n;
                this.aFk.aFu = e.f.icon_card_dislike_white_s;
                this.aFk.setAfterClickListener(this.aFa);
                this.aFk.setVisibility(0);
                return;
            }
            return;
        }
        if (this.aFj != null) {
            this.aFj.aFs = e.j.action_praise_default;
            this.aFj.aFv = e.d.cp_cont_i_alpha70;
            this.aFj.aFw = e.d.cp_cont_h_alpha70_1;
            this.aFj.aFt = e.f.icon_card_like_white_n;
            this.aFj.aFu = e.f.icon_home_card_like_s;
            this.aFj.setVisibility(0);
            this.aFj.setAfterClickListener(this.aFa);
        }
        if (this.aFk != null) {
            this.aFk.setAfterClickListener(this.aFa);
            this.aFk.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.aFj != null) {
            this.aFj.onChangeSkinType(i);
        }
        if (this.aFk != null) {
            this.aFk.onChangeSkinType(i);
        }
    }

    public void a(com.baidu.tieba.frs.aggregation.g gVar) {
        this.aFl = gVar;
        if (this.aFj != null) {
            this.aFj.a(gVar);
        }
        if (this.aFk != null) {
            this.aFk.a(gVar);
        }
    }

    public void updateUI() {
        if (this.aFj != null) {
            this.aFj.updateUI();
        }
        if (this.aFk != null) {
            this.aFk.updateUI();
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.aFh);
        MessageManager.getInstance().unRegisterListener(this.aFc);
    }

    public void h(BdUniqueId bdUniqueId) {
        this.aFh.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.aFh);
        this.aFc.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.aFc);
    }
}

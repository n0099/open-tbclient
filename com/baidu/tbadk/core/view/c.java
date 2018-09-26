package com.baidu.tbadk.core.view;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tieba.e;
/* loaded from: classes2.dex */
public class c {
    private VideoAggregationPraiseView awi;
    private VideoAggregationDisPraiseView awj;
    private com.baidu.tieba.frs.aggregation.g awk;
    private final View.OnClickListener avZ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.Bp();
        }
    };
    private CustomMessageListener awg = new CustomMessageListener(2016551) { // from class: com.baidu.tbadk.core.view.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bb bbVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.h) && c.this.awk != null && !TextUtils.isEmpty(c.this.awk.getThreadId()) && (bbVar = ((com.baidu.tbadk.data.h) customResponsedMessage.getData()).aOw) != null && c.this.awk.getThreadId().equals(bbVar.getTid())) {
                c.this.awk.cm(bbVar.xB());
                c.this.awk.ck(bbVar.xA());
                c.this.awk.t(bbVar.xy());
                c.this.awk.u(bbVar.xz());
                c.this.Bp();
            }
        }
    };
    private CustomMessageListener awb = new CustomMessageListener(2156670) { // from class: com.baidu.tbadk.core.view.c.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && ((String) customResponsedMessage.getData()).equals("zan_or_cai_smallflow")) {
                c.this.Bn();
                c.this.Bp();
            }
        }
    };

    public c(VideoAggregationPraiseView videoAggregationPraiseView, VideoAggregationDisPraiseView videoAggregationDisPraiseView) {
        this.awi = videoAggregationPraiseView;
        this.awj = videoAggregationDisPraiseView;
    }

    public void Bn() {
        if (com.baidu.tbadk.util.a.Mu().CM()) {
            if (this.awi != null) {
                this.awi.awr = e.j.action_like;
                this.awi.awu = e.d.cp_cont_i_alpha70;
                this.awi.awv = e.d.cp_cont_h_alpha70;
                this.awi.aws = e.f.icon_card_like_video_n;
                this.awi.awt = e.f.icon_card_like_video_s;
                this.awi.setAfterClickListener(this.avZ);
                this.awi.setVisibility(0);
            }
            if (this.awj != null) {
                this.awj.awu = e.d.cp_cont_i_alpha70;
                this.awj.awv = e.d.cp_link_tip_a_alpha70;
                this.awj.aws = e.f.icon_card_dislike_white_n;
                this.awj.awt = e.f.icon_card_dislike_white_s;
                this.awj.setAfterClickListener(this.avZ);
                this.awj.setVisibility(0);
                return;
            }
            return;
        }
        if (this.awi != null) {
            this.awi.awr = e.j.action_praise_default;
            this.awi.awu = e.d.cp_cont_i_alpha70;
            this.awi.awv = e.d.cp_cont_h_alpha70_1;
            this.awi.aws = e.f.icon_card_like_white_n;
            this.awi.awt = e.f.icon_home_card_like_s;
            this.awi.setVisibility(0);
            this.awi.setAfterClickListener(this.avZ);
        }
        if (this.awj != null) {
            this.awj.setAfterClickListener(this.avZ);
            this.awj.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.awi != null) {
            this.awi.onChangeSkinType(i);
        }
        if (this.awj != null) {
            this.awj.onChangeSkinType(i);
        }
    }

    public void a(com.baidu.tieba.frs.aggregation.g gVar) {
        this.awk = gVar;
        if (this.awi != null) {
            this.awi.a(gVar);
        }
        if (this.awj != null) {
            this.awj.a(gVar);
        }
    }

    public void Bp() {
        if (this.awi != null) {
            this.awi.Bp();
        }
        if (this.awj != null) {
            this.awj.Bp();
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.awg);
        MessageManager.getInstance().unRegisterListener(this.awb);
    }

    public void h(BdUniqueId bdUniqueId) {
        this.awg.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.awg);
        this.awb.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.awb);
    }
}

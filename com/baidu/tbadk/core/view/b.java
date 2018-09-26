package com.baidu.tbadk.core.view;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tieba.e;
/* loaded from: classes2.dex */
public class b {
    private PraiseView awd;
    private DisPraiseView awe;
    private bb awf;
    private final View.OnClickListener avZ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.Bp();
        }
    };
    private CustomMessageListener awg = new CustomMessageListener(2016551) { // from class: com.baidu.tbadk.core.view.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bb bbVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.h) && b.this.awf != null && !TextUtils.isEmpty(b.this.awf.getTid()) && (bbVar = ((com.baidu.tbadk.data.h) customResponsedMessage.getData()).aOw) != null && b.this.awf.getTid().equals(bbVar.getTid())) {
                b.this.awf.cm(bbVar.xB());
                b.this.awf.ck(bbVar.xA());
                b.this.awf.t(bbVar.xy());
                b.this.awf.u(bbVar.xz());
                b.this.Bp();
            }
        }
    };
    private CustomMessageListener awb = new CustomMessageListener(2156670) { // from class: com.baidu.tbadk.core.view.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && ((String) customResponsedMessage.getData()).equals("zan_or_cai_smallflow")) {
                b.this.Bn();
                b.this.Bp();
            }
        }
    };

    public b(PraiseView praiseView, DisPraiseView disPraiseView) {
        this.awd = praiseView;
        this.awe = disPraiseView;
    }

    public void Bn() {
        if (com.baidu.tbadk.util.a.Mu().CM()) {
            if (this.awd != null) {
                this.awd.awr = e.j.action_like;
                this.awd.awu = e.d.cp_cont_j;
                this.awd.awv = e.d.cp_cont_h;
                this.awd.aws = e.f.icon_card_like_n;
                this.awd.awt = e.f.icon_card_like_s;
                this.awd.setAfterClickListener(this.avZ);
                this.awd.setVisibility(0);
            }
            if (this.awe != null) {
                this.awe.awr = e.j.action_dislike;
                this.awe.awu = e.d.cp_cont_j;
                this.awe.awv = e.d.cp_link_tip_a;
                this.awe.aws = e.f.icon_card_dislike_n;
                this.awe.awt = e.f.icon_card_dislike_s;
                this.awe.setAfterClickListener(this.avZ);
                this.awe.setVisibility(0);
                return;
            }
            return;
        }
        if (this.awd != null) {
            this.awd.awr = e.j.action_praise_default;
            this.awd.awu = e.d.cp_cont_j;
            this.awd.awv = e.d.cp_cont_h;
            this.awd.aws = Bo() ? e.f.icon_home_card_like_n_xmas : e.f.icon_home_card_like_n;
            this.awd.awt = Bo() ? e.f.icon_home_card_like_s_xmas : e.f.icon_home_card_like_s;
            this.awd.setVisibility(0);
            this.awd.setAfterClickListener(this.avZ);
        }
        if (this.awe != null) {
            this.awe.setAfterClickListener(this.avZ);
            this.awe.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.awd != null) {
            this.awd.onChangeSkinType(i);
        }
        if (this.awe != null) {
            this.awe.onChangeSkinType(i);
        }
    }

    private boolean Bo() {
        com.baidu.tbadk.coreExtra.data.c activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        return activitySwitch != null && activitySwitch.CX();
    }

    public void setFrom(int i) {
        if (this.awd != null) {
            this.awd.setFrom(i);
        }
        if (this.awe != null) {
            this.awe.setFrom(i);
        }
    }

    public void setDisPraiseFrom(int i) {
        if (this.awd != null) {
            this.awd.setFrom(i);
        }
        if (this.awe != null) {
            this.awe.setFrom(i);
        }
    }

    public void setForumId(String str) {
        if (this.awd != null) {
            this.awd.setForumId(str);
        }
        if (this.awe != null) {
            this.awe.setForumId(str);
        }
    }

    public void setClickable(boolean z) {
        if (this.awd != null) {
            this.awd.setViewEnabled(z);
        }
        if (this.awe != null) {
            this.awe.setViewEnabled(z);
        }
    }

    public void a(bb bbVar) {
        this.awf = bbVar;
        if (this.awd != null) {
            this.awd.a(bbVar);
        }
        if (this.awe != null) {
            this.awe.a(bbVar);
        }
    }

    public void Bp() {
        if (this.awd != null) {
            this.awd.Bp();
        }
        if (this.awe != null) {
            this.awe.Bp();
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

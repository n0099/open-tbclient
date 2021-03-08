package com.baidu.card;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.card.a.a;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class u extends c implements p<cb>, q {
    private TextView aiA;
    private cb aiB;
    private boolean aiC = false;
    private boolean aiD = true;
    private CustomMessageListener aiE = new CustomMessageListener(2921402) { // from class: com.baidu.card.u.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof cb) && ((cb) customResponsedMessage.getData()) == u.this.aiB) {
                u.this.sZ();
            }
        }
    };
    private final RelativeLayout aiv;
    private final LinearLayout aiw;
    private View aix;
    private View aiy;
    private ImageView aiz;
    private BdUniqueId mPageId;
    private View mRootView;

    /* JADX INFO: Access modifiers changed from: private */
    public void sZ() {
        int i = 4;
        if (this.aiB != null) {
            this.aix.setVisibility((this.aiB.bpF() || this.aiB.bpG() || !this.aiD) ? 0 : 4);
            if (this.aiC) {
                this.aiy.setVisibility(0);
                this.aiv.setVisibility(0);
                if (this.aiD) {
                    this.aiz.setVisibility(0);
                    this.aiA.setVisibility(0);
                    if (this.aiB.bpF() || this.aiB.bpG()) {
                        WebPManager.a(this.aiz, R.drawable.icon_pure_frs_chosen_22, R.color.CAM_X0304, null);
                    } else {
                        WebPManager.a(this.aiz, R.drawable.icon_pure_frs_select_22, R.color.CAM_X0107, null);
                    }
                    com.baidu.tbadk.core.util.ap.setViewTextColor(this.aiA, (this.aiB.bpF() || this.aiB.bpG()) ? R.color.CAM_X0304 : R.drawable.selector_comment_and_prise_item_text_color);
                    return;
                }
                this.aiz.setVisibility(8);
                this.aiA.setVisibility(8);
                return;
            }
            this.aiv.setVisibility(8);
            View view = this.aiy;
            if (this.aiB.bpF() || this.aiB.bpG()) {
                i = 0;
            }
            view.setVisibility(i);
            this.aiz.setVisibility(8);
            this.aiA.setVisibility(8);
        }
    }

    public u(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.multi_del_decor_layout, (ViewGroup) null);
        this.aix = this.mRootView.findViewById(R.id.multi_del_mask_top_view);
        this.aiw = (LinearLayout) this.mRootView.findViewById(R.id.multi_del_bottom_layout);
        this.aix.setAlpha(0.5f);
        this.aiy = this.mRootView.findViewById(R.id.multi_del_mask_bottom_view);
        this.aiy.setAlpha(0.5f);
        this.aiz = (ImageView) this.mRootView.findViewById(R.id.manage_select_img);
        this.aiv = (RelativeLayout) this.mRootView.findViewById(R.id.multi_del_bottom_root);
        this.aiA = (TextView) this.mRootView.findViewById(R.id.manage_select_txt);
        H(this.mRootView);
        this.mRootView.setFocusable(true);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.u.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (u.this.aiz != null && u.this.aiB != null && u.this.aiA != null && !u.this.aiB.bpH() && u.this.aiD) {
                    if (u.this.aiB.bpF() || !com.baidu.tieba.frs.b.cBE().cBy()) {
                        if (u.this.aiB.bpG() || !com.baidu.tieba.frs.a.cBx().cBy()) {
                            com.baidu.tieba.frs.b.cBE().an(u.this.aiB);
                            u.this.aiB.jA(false);
                            com.baidu.tieba.frs.a.cBx().an(u.this.aiB);
                            u.this.aiB.jB(false);
                        } else if (com.baidu.tieba.frs.a.cBx().am(u.this.aiB)) {
                            u.this.aiB.jB(true);
                        }
                    } else if (com.baidu.tieba.frs.b.cBE().am(u.this.aiB)) {
                        u.this.aiB.jA(true);
                    }
                    u.this.sZ();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921402, u.this.aiB));
                }
            }
        });
        setInsertIndex(-1);
        if (context instanceof BaseActivity) {
            ((BaseActivity) context).registerListener(this.aiE);
        } else if (context instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) context).registerListener(this.aiE);
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.aiB.bpF() || this.aiB.bpG()) {
            WebPManager.a(this.aiz, R.drawable.icon_pure_frs_chosen_22, R.color.CAM_X0304, null);
        } else {
            WebPManager.a(this.aiz, R.drawable.icon_pure_frs_select_22, R.color.CAM_X0107, null);
        }
        com.baidu.tbadk.core.elementsMaven.c.br(this.aix).oh(R.string.J_X06).og(this.aiC ? 2 : 1).setBackGroundColor(R.color.CAM_X0201);
        com.baidu.tbadk.core.elementsMaven.c.br(this.aiy).oh(R.string.J_X06).og(2).setBackGroundColor(R.color.CAM_X0201);
        com.baidu.tbadk.core.elementsMaven.c.br(this.aiA).ob(R.string.F_X01);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.aiA, (this.aiB.bpF() || this.aiB.bpG()) ? R.color.CAM_X0302 : R.drawable.selector_comment_and_prise_item_text_color);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.c
    public void sN() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.c
    public void sR() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: a */
    public void E(cb cbVar) {
        this.aiB = cbVar;
        this.aiD = this.aiB.getType() != cb.eSE && (cbVar == null || cbVar.bnS() == null || !cbVar.bnS().isForumBusinessAccount() || cbVar.isSelf());
        if (com.baidu.tieba.frs.b.cBE().cBy() || com.baidu.tieba.frs.a.cBx().cBy()) {
            this.mRootView.setVisibility(0);
            this.ahG.b(new a.C0095a(4, false));
            sZ();
            return;
        }
        this.ahG.b(new a.C0095a(4, true));
        this.mRootView.setVisibility(8);
    }

    public void aH(boolean z) {
        this.aiC = z;
    }

    public void h(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }

    public void a(int i, al alVar) {
        this.aiw.setWeightSum(i);
        if (this.aiw.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aiw.getLayoutParams()).setMargins(alVar.ajT, alVar.ajR, alVar.ajU, alVar.ajS);
        }
    }
}

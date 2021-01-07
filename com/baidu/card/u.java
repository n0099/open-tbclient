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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class u extends c implements p<bz>, q {
    private final RelativeLayout aig;
    private final LinearLayout aih;
    private View aii;
    private View aij;
    private ImageView aik;
    private TextView ail;
    private bz aim;
    private boolean ain = false;
    private boolean aio = true;
    private CustomMessageListener aip = new CustomMessageListener(2921402) { // from class: com.baidu.card.u.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bz) && ((bz) customResponsedMessage.getData()) == u.this.aim) {
                u.this.tn();
            }
        }
    };
    private BdUniqueId mPageId;
    private View mRootView;

    /* JADX INFO: Access modifiers changed from: private */
    public void tn() {
        int i = 4;
        if (this.aim != null) {
            this.aii.setVisibility((this.aim.btf() || this.aim.btg() || !this.aio) ? 0 : 4);
            if (this.ain) {
                this.aij.setVisibility(0);
                this.aig.setVisibility(0);
                if (this.aio) {
                    this.aik.setVisibility(0);
                    this.ail.setVisibility(0);
                    if (this.aim.btf() || this.aim.btg()) {
                        WebPManager.a(this.aik, R.drawable.icon_pure_frs_chosen_22, R.color.CAM_X0304, null);
                    } else {
                        WebPManager.a(this.aik, R.drawable.icon_pure_frs_select_22, R.color.CAM_X0107, null);
                    }
                    com.baidu.tbadk.core.util.ao.setViewTextColor(this.ail, (this.aim.btf() || this.aim.btg()) ? R.color.CAM_X0304 : R.drawable.selector_comment_and_prise_item_text_color);
                    return;
                }
                this.aik.setVisibility(8);
                this.ail.setVisibility(8);
                return;
            }
            this.aig.setVisibility(8);
            View view = this.aij;
            if (this.aim.btf() || this.aim.btg()) {
                i = 0;
            }
            view.setVisibility(i);
            this.aik.setVisibility(8);
            this.ail.setVisibility(8);
        }
    }

    public u(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.multi_del_decor_layout, (ViewGroup) null);
        this.aii = this.mRootView.findViewById(R.id.multi_del_mask_top_view);
        this.aih = (LinearLayout) this.mRootView.findViewById(R.id.multi_del_bottom_layout);
        this.aii.setAlpha(0.5f);
        this.aij = this.mRootView.findViewById(R.id.multi_del_mask_bottom_view);
        this.aij.setAlpha(0.5f);
        this.aik = (ImageView) this.mRootView.findViewById(R.id.manage_select_img);
        this.aig = (RelativeLayout) this.mRootView.findViewById(R.id.multi_del_bottom_root);
        this.ail = (TextView) this.mRootView.findViewById(R.id.manage_select_txt);
        H(this.mRootView);
        this.mRootView.setFocusable(true);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.u.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (u.this.aik != null && u.this.aim != null && u.this.ail != null && !u.this.aim.bth() && u.this.aio) {
                    if (u.this.aim.btf() || !com.baidu.tieba.frs.b.cDY().cDS()) {
                        if (u.this.aim.btg() || !com.baidu.tieba.frs.a.cDR().cDS()) {
                            com.baidu.tieba.frs.b.cDY().am(u.this.aim);
                            u.this.aim.jC(false);
                            com.baidu.tieba.frs.a.cDR().am(u.this.aim);
                            u.this.aim.jD(false);
                        } else if (com.baidu.tieba.frs.a.cDR().al(u.this.aim)) {
                            u.this.aim.jD(true);
                        }
                    } else if (com.baidu.tieba.frs.b.cDY().al(u.this.aim)) {
                        u.this.aim.jC(true);
                    }
                    u.this.tn();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921402, u.this.aim));
                }
            }
        });
        setInsertIndex(-1);
        if (context instanceof BaseActivity) {
            ((BaseActivity) context).registerListener(this.aip);
        } else if (context instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) context).registerListener(this.aip);
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.aim.btf() || this.aim.btg()) {
            WebPManager.a(this.aik, R.drawable.icon_pure_frs_chosen_22, R.color.CAM_X0304, null);
        } else {
            WebPManager.a(this.aik, R.drawable.icon_pure_frs_select_22, R.color.CAM_X0107, null);
        }
        com.baidu.tbadk.core.elementsMaven.c.bv(this.aii).pK(R.string.J_X06).pJ(this.ain ? 2 : 1).setBackGroundColor(R.color.CAM_X0201);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.aij).pK(R.string.J_X06).pJ(2).setBackGroundColor(R.color.CAM_X0201);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.ail).pE(R.string.F_X01);
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.ail, (this.aim.btf() || this.aim.btg()) ? R.color.CAM_X0302 : R.drawable.selector_comment_and_prise_item_text_color);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.c
    public void tb() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.c
    public void tf() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: a */
    public void D(bz bzVar) {
        this.aim = bzVar;
        this.aio = this.aim.getType() != bz.eTC;
        if (com.baidu.tieba.frs.b.cDY().cDS() || com.baidu.tieba.frs.a.cDR().cDS()) {
            this.mRootView.setVisibility(0);
            this.ahn.b(new a.C0090a(4, false));
            tn();
            return;
        }
        this.ahn.b(new a.C0090a(4, true));
        this.mRootView.setVisibility(8);
    }

    public void aH(boolean z) {
        this.ain = z;
    }

    public void h(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }

    public void a(int i, al alVar) {
        this.aih.setWeightSum(i);
        if (this.aih.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aih.getLayoutParams()).setMargins(alVar.ajE, alVar.ajC, alVar.ajF, alVar.ajD);
        }
    }
}

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
    private final RelativeLayout ahc;
    private final LinearLayout ahd;
    private View ahe;
    private View ahf;
    private ImageView ahg;
    private TextView ahh;
    private cb ahi;
    private boolean ahj = false;
    private boolean ahk = true;
    private CustomMessageListener ahl = new CustomMessageListener(2921402) { // from class: com.baidu.card.u.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof cb) && ((cb) customResponsedMessage.getData()) == u.this.ahi) {
                u.this.sZ();
            }
        }
    };
    private BdUniqueId mPageId;
    private View mRootView;

    /* JADX INFO: Access modifiers changed from: private */
    public void sZ() {
        int i = 4;
        if (this.ahi != null) {
            this.ahe.setVisibility((this.ahi.bpD() || this.ahi.bpE() || !this.ahk) ? 0 : 4);
            if (this.ahj) {
                this.ahf.setVisibility(0);
                this.ahc.setVisibility(0);
                if (this.ahk) {
                    this.ahg.setVisibility(0);
                    this.ahh.setVisibility(0);
                    if (this.ahi.bpD() || this.ahi.bpE()) {
                        WebPManager.a(this.ahg, R.drawable.icon_pure_frs_chosen_22, R.color.CAM_X0304, null);
                    } else {
                        WebPManager.a(this.ahg, R.drawable.icon_pure_frs_select_22, R.color.CAM_X0107, null);
                    }
                    com.baidu.tbadk.core.util.ap.setViewTextColor(this.ahh, (this.ahi.bpD() || this.ahi.bpE()) ? R.color.CAM_X0304 : R.drawable.selector_comment_and_prise_item_text_color);
                    return;
                }
                this.ahg.setVisibility(8);
                this.ahh.setVisibility(8);
                return;
            }
            this.ahc.setVisibility(8);
            View view = this.ahf;
            if (this.ahi.bpD() || this.ahi.bpE()) {
                i = 0;
            }
            view.setVisibility(i);
            this.ahg.setVisibility(8);
            this.ahh.setVisibility(8);
        }
    }

    public u(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.multi_del_decor_layout, (ViewGroup) null);
        this.ahe = this.mRootView.findViewById(R.id.multi_del_mask_top_view);
        this.ahd = (LinearLayout) this.mRootView.findViewById(R.id.multi_del_bottom_layout);
        this.ahe.setAlpha(0.5f);
        this.ahf = this.mRootView.findViewById(R.id.multi_del_mask_bottom_view);
        this.ahf.setAlpha(0.5f);
        this.ahg = (ImageView) this.mRootView.findViewById(R.id.manage_select_img);
        this.ahc = (RelativeLayout) this.mRootView.findViewById(R.id.multi_del_bottom_root);
        this.ahh = (TextView) this.mRootView.findViewById(R.id.manage_select_txt);
        H(this.mRootView);
        this.mRootView.setFocusable(true);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.u.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (u.this.ahg != null && u.this.ahi != null && u.this.ahh != null && !u.this.ahi.bpF() && u.this.ahk) {
                    if (u.this.ahi.bpD() || !com.baidu.tieba.frs.b.cBy().cBs()) {
                        if (u.this.ahi.bpE() || !com.baidu.tieba.frs.a.cBr().cBs()) {
                            com.baidu.tieba.frs.b.cBy().an(u.this.ahi);
                            u.this.ahi.jA(false);
                            com.baidu.tieba.frs.a.cBr().an(u.this.ahi);
                            u.this.ahi.jB(false);
                        } else if (com.baidu.tieba.frs.a.cBr().am(u.this.ahi)) {
                            u.this.ahi.jB(true);
                        }
                    } else if (com.baidu.tieba.frs.b.cBy().am(u.this.ahi)) {
                        u.this.ahi.jA(true);
                    }
                    u.this.sZ();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921402, u.this.ahi));
                }
            }
        });
        setInsertIndex(-1);
        if (context instanceof BaseActivity) {
            ((BaseActivity) context).registerListener(this.ahl);
        } else if (context instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) context).registerListener(this.ahl);
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.ahi.bpD() || this.ahi.bpE()) {
            WebPManager.a(this.ahg, R.drawable.icon_pure_frs_chosen_22, R.color.CAM_X0304, null);
        } else {
            WebPManager.a(this.ahg, R.drawable.icon_pure_frs_select_22, R.color.CAM_X0107, null);
        }
        com.baidu.tbadk.core.elementsMaven.c.br(this.ahe).og(R.string.J_X06).of(this.ahj ? 2 : 1).setBackGroundColor(R.color.CAM_X0201);
        com.baidu.tbadk.core.elementsMaven.c.br(this.ahf).og(R.string.J_X06).of(2).setBackGroundColor(R.color.CAM_X0201);
        com.baidu.tbadk.core.elementsMaven.c.br(this.ahh).oa(R.string.F_X01);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.ahh, (this.ahi.bpD() || this.ahi.bpE()) ? R.color.CAM_X0302 : R.drawable.selector_comment_and_prise_item_text_color);
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
    public void C(cb cbVar) {
        this.ahi = cbVar;
        this.ahk = this.ahi.getType() != cb.eRd && (cbVar == null || cbVar.bnQ() == null || !cbVar.bnQ().isForumBusinessAccount() || cbVar.isSelf());
        if (com.baidu.tieba.frs.b.cBy().cBs() || com.baidu.tieba.frs.a.cBr().cBs()) {
            this.mRootView.setVisibility(0);
            this.ago.b(new a.C0089a(4, false));
            sZ();
            return;
        }
        this.ago.b(new a.C0089a(4, true));
        this.mRootView.setVisibility(8);
    }

    public void aH(boolean z) {
        this.ahj = z;
    }

    public void h(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }

    public void a(int i, al alVar) {
        this.ahd.setWeightSum(i);
        if (this.ahd.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.ahd.getLayoutParams()).setMargins(alVar.aiB, alVar.aiz, alVar.aiC, alVar.aiA);
        }
    }
}

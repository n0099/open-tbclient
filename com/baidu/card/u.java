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
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class u extends d implements p<by>, q {
    private by ahA;
    private boolean ahB = false;
    private CustomMessageListener ahC = new CustomMessageListener(2921402) { // from class: com.baidu.card.u.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof by) && ((by) customResponsedMessage.getData()) == u.this.ahA) {
                u.this.tP();
            }
        }
    };
    private final RelativeLayout ahu;
    private final LinearLayout ahv;
    private View ahw;
    private View ahx;
    private ImageView ahy;
    private TextView ahz;
    private BdUniqueId mPageId;
    private View mRootView;

    /* JADX INFO: Access modifiers changed from: private */
    public void tP() {
        int i = 4;
        if (this.ahA != null) {
            this.ahw.setVisibility((this.ahA.bqC() || this.ahA.bqD()) ? 0 : 4);
            if (this.ahB) {
                this.ahx.setVisibility(0);
                this.ahu.setVisibility(0);
                this.ahy.setVisibility(0);
                this.ahz.setVisibility(0);
                if (this.ahA.bqC() || this.ahA.bqD()) {
                    WebPManager.a(this.ahy, R.drawable.icon_pure_frs_chosen_22, R.color.CAM_X0304, null);
                } else {
                    WebPManager.a(this.ahy, R.drawable.icon_pure_frs_select_22, R.color.CAM_X0107, null);
                }
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.ahz, (this.ahA.bqC() || this.ahA.bqD()) ? R.color.CAM_X0304 : R.drawable.selector_comment_and_prise_item_text_color);
                return;
            }
            this.ahu.setVisibility(8);
            View view = this.ahx;
            if (this.ahA.bqC() || this.ahA.bqD()) {
                i = 0;
            }
            view.setVisibility(i);
            this.ahy.setVisibility(8);
            this.ahz.setVisibility(8);
        }
    }

    public u(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.multi_del_decor_layout, (ViewGroup) null);
        this.ahw = this.mRootView.findViewById(R.id.multi_del_mask_top_view);
        this.ahv = (LinearLayout) this.mRootView.findViewById(R.id.multi_del_bottom_layout);
        this.ahw.setAlpha(0.5f);
        this.ahx = this.mRootView.findViewById(R.id.multi_del_mask_bottom_view);
        this.ahx.setAlpha(0.5f);
        this.ahy = (ImageView) this.mRootView.findViewById(R.id.manage_select_img);
        this.ahu = (RelativeLayout) this.mRootView.findViewById(R.id.multi_del_bottom_root);
        this.ahz = (TextView) this.mRootView.findViewById(R.id.manage_select_txt);
        H(this.mRootView);
        this.mRootView.setFocusable(true);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.u.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (u.this.ahy != null && u.this.ahA != null && u.this.ahz != null && !u.this.ahA.bqE()) {
                    if (u.this.ahA.bqC() || !com.baidu.tieba.frs.b.cBd().cAX()) {
                        if (u.this.ahA.bqD() || !com.baidu.tieba.frs.a.cAW().cAX()) {
                            com.baidu.tieba.frs.b.cBd().am(u.this.ahA);
                            u.this.ahA.jg(false);
                            com.baidu.tieba.frs.a.cAW().am(u.this.ahA);
                            u.this.ahA.jh(false);
                        } else if (com.baidu.tieba.frs.a.cAW().al(u.this.ahA)) {
                            u.this.ahA.jh(true);
                        }
                    } else if (com.baidu.tieba.frs.b.cBd().al(u.this.ahA)) {
                        u.this.ahA.jg(true);
                    }
                    u.this.tP();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921402, u.this.ahA));
                }
            }
        });
        setInsertIndex(-1);
        if (context instanceof BaseActivity) {
            ((BaseActivity) context).registerListener(this.ahC);
        } else if (context instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) context).registerListener(this.ahC);
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.ahA.bqC() || this.ahA.bqD()) {
            WebPManager.a(this.ahy, R.drawable.icon_pure_frs_chosen_22, R.color.CAM_X0304, null);
        } else {
            WebPManager.a(this.ahy, R.drawable.icon_pure_frs_select_22, R.color.CAM_X0107, null);
        }
        com.baidu.tbadk.core.elementsMaven.c.bm(this.ahw).pA(com.baidu.tbadk.a.d.bkA() ? R.string.J_X02 : R.string.J_X06).pz(this.ahB ? 2 : 1).setBackGroundColor(R.color.CAM_X0201);
        com.baidu.tbadk.core.elementsMaven.c.bm(this.ahx).pA(com.baidu.tbadk.a.d.bkA() ? R.string.J_X02 : R.string.J_X06).pz(2).setBackGroundColor(R.color.CAM_X0201);
        com.baidu.tbadk.core.elementsMaven.c.bm(this.ahz).pu(R.string.F_X01);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.ahz, (this.ahA.bqC() || this.ahA.bqD()) ? R.color.CAM_X0302 : R.drawable.selector_comment_and_prise_item_text_color);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.d
    public void tD() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.d
    public void tH() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: a */
    public void H(by byVar) {
        this.ahA = byVar;
        if (com.baidu.tieba.frs.b.cBd().cAX() || com.baidu.tieba.frs.a.cAW().cAX()) {
            this.mRootView.setVisibility(0);
            this.agO.b(new a.C0097a(4, false));
            tP();
            return;
        }
        this.agO.b(new a.C0097a(4, true));
        this.mRootView.setVisibility(8);
    }

    public void aI(boolean z) {
        this.ahB = z;
    }

    public void h(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }

    public void a(int i, al alVar) {
        this.ahv.setWeightSum(i);
        if (this.ahv.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.ahv.getLayoutParams()).setMargins(alVar.aiS, alVar.aiQ, alVar.aiT, alVar.aiR);
        }
    }
}

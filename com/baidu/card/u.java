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
    private final RelativeLayout aho;
    private final LinearLayout ahp;
    private View ahq;
    private View ahr;
    private ImageView ahs;
    private TextView aht;
    private bz ahu;
    private boolean ahv = false;
    private boolean ahw = true;
    private CustomMessageListener ahx = new CustomMessageListener(2921402) { // from class: com.baidu.card.u.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bz) && ((bz) customResponsedMessage.getData()) == u.this.ahu) {
                u.this.tc();
            }
        }
    };
    private BdUniqueId mPageId;
    private View mRootView;

    /* JADX INFO: Access modifiers changed from: private */
    public void tc() {
        int i = 4;
        if (this.ahu != null) {
            this.ahq.setVisibility((this.ahu.bpl() || this.ahu.bpm() || !this.ahw) ? 0 : 4);
            if (this.ahv) {
                this.ahr.setVisibility(0);
                this.aho.setVisibility(0);
                if (this.ahw) {
                    this.ahs.setVisibility(0);
                    this.aht.setVisibility(0);
                    if (this.ahu.bpl() || this.ahu.bpm()) {
                        WebPManager.a(this.ahs, R.drawable.icon_pure_frs_chosen_22, R.color.CAM_X0304, null);
                    } else {
                        WebPManager.a(this.ahs, R.drawable.icon_pure_frs_select_22, R.color.CAM_X0107, null);
                    }
                    com.baidu.tbadk.core.util.ao.setViewTextColor(this.aht, (this.ahu.bpl() || this.ahu.bpm()) ? R.color.CAM_X0304 : R.drawable.selector_comment_and_prise_item_text_color);
                    return;
                }
                this.ahs.setVisibility(8);
                this.aht.setVisibility(8);
                return;
            }
            this.aho.setVisibility(8);
            View view = this.ahr;
            if (this.ahu.bpl() || this.ahu.bpm()) {
                i = 0;
            }
            view.setVisibility(i);
            this.ahs.setVisibility(8);
            this.aht.setVisibility(8);
        }
    }

    public u(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.multi_del_decor_layout, (ViewGroup) null);
        this.ahq = this.mRootView.findViewById(R.id.multi_del_mask_top_view);
        this.ahp = (LinearLayout) this.mRootView.findViewById(R.id.multi_del_bottom_layout);
        this.ahq.setAlpha(0.5f);
        this.ahr = this.mRootView.findViewById(R.id.multi_del_mask_bottom_view);
        this.ahr.setAlpha(0.5f);
        this.ahs = (ImageView) this.mRootView.findViewById(R.id.manage_select_img);
        this.aho = (RelativeLayout) this.mRootView.findViewById(R.id.multi_del_bottom_root);
        this.aht = (TextView) this.mRootView.findViewById(R.id.manage_select_txt);
        H(this.mRootView);
        this.mRootView.setFocusable(true);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.u.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (u.this.ahs != null && u.this.ahu != null && u.this.aht != null && !u.this.ahu.bpn() && u.this.ahw) {
                    if (u.this.ahu.bpl() || !com.baidu.tieba.frs.b.cAg().cAa()) {
                        if (u.this.ahu.bpm() || !com.baidu.tieba.frs.a.czZ().cAa()) {
                            com.baidu.tieba.frs.b.cAg().am(u.this.ahu);
                            u.this.ahu.jy(false);
                            com.baidu.tieba.frs.a.czZ().am(u.this.ahu);
                            u.this.ahu.jz(false);
                        } else if (com.baidu.tieba.frs.a.czZ().al(u.this.ahu)) {
                            u.this.ahu.jz(true);
                        }
                    } else if (com.baidu.tieba.frs.b.cAg().al(u.this.ahu)) {
                        u.this.ahu.jy(true);
                    }
                    u.this.tc();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921402, u.this.ahu));
                }
            }
        });
        setInsertIndex(-1);
        if (context instanceof BaseActivity) {
            ((BaseActivity) context).registerListener(this.ahx);
        } else if (context instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) context).registerListener(this.ahx);
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.ahu.bpl() || this.ahu.bpm()) {
            WebPManager.a(this.ahs, R.drawable.icon_pure_frs_chosen_22, R.color.CAM_X0304, null);
        } else {
            WebPManager.a(this.ahs, R.drawable.icon_pure_frs_select_22, R.color.CAM_X0107, null);
        }
        com.baidu.tbadk.core.elementsMaven.c.bv(this.ahq).od(R.string.J_X06).oc(this.ahv ? 2 : 1).setBackGroundColor(R.color.CAM_X0201);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.ahr).od(R.string.J_X06).oc(2).setBackGroundColor(R.color.CAM_X0201);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.aht).nX(R.string.F_X01);
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.aht, (this.ahu.bpl() || this.ahu.bpm()) ? R.color.CAM_X0302 : R.drawable.selector_comment_and_prise_item_text_color);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.c
    public void sQ() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.c
    public void sU() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: a */
    public void C(bz bzVar) {
        this.ahu = bzVar;
        this.ahw = this.ahu.getType() != bz.eOR;
        if (com.baidu.tieba.frs.b.cAg().cAa() || com.baidu.tieba.frs.a.czZ().cAa()) {
            this.mRootView.setVisibility(0);
            this.agw.b(new a.C0089a(4, false));
            tc();
            return;
        }
        this.agw.b(new a.C0089a(4, true));
        this.mRootView.setVisibility(8);
    }

    public void aH(boolean z) {
        this.ahv = z;
    }

    public void h(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }

    public void a(int i, al alVar) {
        this.ahp.setWeightSum(i);
        if (this.ahp.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.ahp.getLayoutParams()).setMargins(alVar.aiN, alVar.aiL, alVar.aiO, alVar.aiM);
        }
    }
}

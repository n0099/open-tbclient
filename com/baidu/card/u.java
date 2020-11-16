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
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
/* loaded from: classes20.dex */
public class u extends d implements p<bx>, q {
    private TextView agA;
    private bx agB;
    private boolean agC = false;
    private CustomMessageListener agD = new CustomMessageListener(2921402) { // from class: com.baidu.card.u.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bx) && ((bx) customResponsedMessage.getData()) == u.this.agB) {
                u.this.tM();
            }
        }
    };
    private final RelativeLayout agv;
    private final LinearLayout agw;
    private View agx;
    private View agy;
    private ImageView agz;
    private BdUniqueId mPageId;
    private View mRootView;

    /* JADX INFO: Access modifiers changed from: private */
    public void tM() {
        int i = 4;
        if (this.agB != null) {
            this.agx.setVisibility((this.agB.bnp() || this.agB.bnq()) ? 0 : 4);
            if (this.agC) {
                this.agy.setVisibility(0);
                this.agv.setVisibility(0);
                this.agz.setVisibility(0);
                this.agA.setVisibility(0);
                if (this.agB.bnp() || this.agB.bnq()) {
                    WebPManager.a(this.agz, R.drawable.icon_pure_frs_chosen_22, R.color.CAM_X0304, null);
                } else {
                    WebPManager.a(this.agz, R.drawable.icon_pure_frs_select_22, R.color.CAM_X0107, null);
                }
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.agA, (this.agB.bnp() || this.agB.bnq()) ? R.color.CAM_X0304 : R.drawable.selector_comment_and_prise_item_text_color);
                return;
            }
            this.agv.setVisibility(8);
            View view = this.agy;
            if (this.agB.bnp() || this.agB.bnq()) {
                i = 0;
            }
            view.setVisibility(i);
            this.agz.setVisibility(8);
            this.agA.setVisibility(8);
        }
    }

    public u(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.multi_del_decor_layout, (ViewGroup) null);
        this.agx = this.mRootView.findViewById(R.id.multi_del_mask_top_view);
        this.agw = (LinearLayout) this.mRootView.findViewById(R.id.multi_del_bottom_layout);
        this.agx.setAlpha(0.5f);
        this.agy = this.mRootView.findViewById(R.id.multi_del_mask_bottom_view);
        this.agy.setAlpha(0.5f);
        this.agz = (ImageView) this.mRootView.findViewById(R.id.manage_select_img);
        this.agv = (RelativeLayout) this.mRootView.findViewById(R.id.multi_del_bottom_root);
        this.agA = (TextView) this.mRootView.findViewById(R.id.manage_select_txt);
        H(this.mRootView);
        this.mRootView.setFocusable(true);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.u.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (u.this.agz != null && u.this.agB != null && u.this.agA != null && !u.this.agB.bnr()) {
                    if (u.this.agB.bnp() || !com.baidu.tieba.frs.b.cwO().cwI()) {
                        if (u.this.agB.bnq() || !com.baidu.tieba.frs.a.cwH().cwI()) {
                            com.baidu.tieba.frs.b.cwO().am(u.this.agB);
                            u.this.agB.iR(false);
                            com.baidu.tieba.frs.a.cwH().am(u.this.agB);
                            u.this.agB.iS(false);
                        } else if (com.baidu.tieba.frs.a.cwH().al(u.this.agB)) {
                            u.this.agB.iS(true);
                        }
                    } else if (com.baidu.tieba.frs.b.cwO().al(u.this.agB)) {
                        u.this.agB.iR(true);
                    }
                    u.this.tM();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921402, u.this.agB));
                }
            }
        });
        setInsertIndex(-1);
        if (context instanceof BaseActivity) {
            ((BaseActivity) context).registerListener(this.agD);
        } else if (context instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) context).registerListener(this.agD);
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.agB.bnp() || this.agB.bnq()) {
            WebPManager.a(this.agz, R.drawable.icon_pure_frs_chosen_22, R.color.CAM_X0304, null);
        } else {
            WebPManager.a(this.agz, R.drawable.icon_pure_frs_select_22, R.color.CAM_X0107, null);
        }
        com.baidu.tbadk.core.elementsMaven.c.bj(this.agx).pb(com.baidu.tbadk.a.d.bhw() ? R.string.J_X02 : R.string.J_X06).pa(this.agC ? 2 : 1).setBackGroundColor(R.color.CAM_X0201);
        com.baidu.tbadk.core.elementsMaven.c.bj(this.agy).pb(com.baidu.tbadk.a.d.bhw() ? R.string.J_X02 : R.string.J_X06).pa(2).setBackGroundColor(R.color.CAM_X0201);
        com.baidu.tbadk.core.elementsMaven.c.bj(this.agA).oV(R.string.F_X01);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.agA, (this.agB.bnp() || this.agB.bnq()) ? R.color.CAM_X0302 : R.drawable.selector_comment_and_prise_item_text_color);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.d
    public void tA() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.d
    public void tE() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: a */
    public void H(bx bxVar) {
        this.agB = bxVar;
        if (com.baidu.tieba.frs.b.cwO().cwI() || com.baidu.tieba.frs.a.cwH().cwI()) {
            this.mRootView.setVisibility(0);
            this.afS.b(new a.C0096a(4, false));
            tM();
            return;
        }
        this.afS.b(new a.C0096a(4, true));
        this.mRootView.setVisibility(8);
    }

    public void aJ(boolean z) {
        this.agC = z;
    }

    public void h(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }

    public void a(int i, al alVar) {
        this.agw.setWeightSum(i);
        if (this.agw.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.agw.getLayoutParams()).setMargins(alVar.ahS, alVar.ahQ, alVar.ahT, alVar.ahR);
        }
    }
}

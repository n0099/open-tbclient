package com.baidu.card;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class q extends d implements m<bj>, n {
    private static final int KE = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds78);
    private View KF;
    private View KG;
    private ImageView KH;
    private TextView KI;
    private bj KJ;
    private View KK;
    private View mRootView;
    private boolean KL = false;
    private BdUniqueId mPageId = null;
    private a.b KM = new a.b() { // from class: com.baidu.card.q.1
        @Override // com.baidu.card.a.a.b
        public boolean a(a.C0052a c0052a) {
            if (q.this.KK != null && c0052a != null && (c0052a.nq() instanceof Integer)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) q.this.KK.getLayoutParams();
                layoutParams.leftMargin = ((Integer) c0052a.nq()).intValue() + q.KE;
                q.this.KK.setLayoutParams(layoutParams);
            }
            return false;
        }
    };
    private CustomMessageListener KN = new CustomMessageListener(2921402) { // from class: com.baidu.card.q.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bj) && ((bj) customResponsedMessage.getData()) == q.this.KJ) {
                q.this.nb();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void nb() {
        if (this.KJ != null) {
            this.KF.setVisibility(this.KJ.aDV() ? 0 : 4);
            if (this.KL) {
                this.KG.setVisibility(0);
                this.KH.setVisibility(0);
                this.KI.setVisibility(0);
                this.KH.setImageDrawable(am.getDrawable(this.KJ.aDV() ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
                am.setViewTextColor(this.KI, this.KJ.aDV() ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
                return;
            }
            this.KG.setVisibility(this.KJ.aDV() ? 0 : 4);
            this.KH.setVisibility(8);
            this.KI.setVisibility(8);
        }
    }

    public q(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.multi_del_decor_layout, (ViewGroup) null);
        this.KF = this.mRootView.findViewById(R.id.multi_del_mask_top_view);
        this.KF.setAlpha(0.5f);
        this.KG = this.mRootView.findViewById(R.id.multi_del_mask_bottom_view);
        this.KG.setAlpha(0.5f);
        this.KH = (ImageView) this.mRootView.findViewById(R.id.manage_select_img);
        this.KI = (TextView) this.mRootView.findViewById(R.id.manage_select_txt);
        this.KK = this.mRootView.findViewById(R.id.manage_select_container);
        F(this.mRootView);
        this.mRootView.setFocusable(true);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.q.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (q.this.KH != null && q.this.KJ != null && q.this.KI != null && !q.this.KJ.aDW()) {
                    if (!q.this.KJ.aDV()) {
                        if (com.baidu.tieba.frs.a.bCV().ah(q.this.KJ)) {
                            q.this.KJ.fC(true);
                        }
                    } else {
                        com.baidu.tieba.frs.a.bCV().ai(q.this.KJ);
                        q.this.KJ.fC(false);
                    }
                    q.this.nb();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921402, q.this.KJ));
                }
            }
        });
        setInsertIndex(-1);
        if (context instanceof BaseActivity) {
            ((BaseActivity) context).registerListener(this.KN);
        } else if (context instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) context).registerListener(this.KN);
        }
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        am.setBackgroundColor(this.KF, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.KG, R.color.cp_bg_line_d);
        this.KH.setImageDrawable(am.getDrawable(this.KJ.aDV() ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
        am.setViewTextColor(this.KI, this.KJ.aDV() ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.d
    public void mS() {
        this.Ki.a(5, this.KM);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.d
    public void mW() {
        this.Ki.b(5, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: a */
    public void A(bj bjVar) {
        this.KJ = bjVar;
        if (com.baidu.tieba.frs.a.bCV().bCW()) {
            this.mRootView.setVisibility(0);
            this.Ki.b(new a.C0052a(4, false));
            nb();
            return;
        }
        this.Ki.b(new a.C0052a(4, true));
        this.mRootView.setVisibility(8);
    }

    public void ad(boolean z) {
        this.KL = z;
    }

    public void g(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }
}

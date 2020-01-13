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
/* loaded from: classes6.dex */
public class q extends d implements m<bj>, n {
    private static final int Ki = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds78);
    private View Kj;
    private View Kk;
    private ImageView Kl;
    private TextView Km;
    private bj Kn;
    private View Ko;
    private View mRootView;
    private boolean Kp = false;
    private BdUniqueId mPageId = null;
    private a.b Kq = new a.b() { // from class: com.baidu.card.q.1
        @Override // com.baidu.card.a.a.b
        public boolean a(a.C0050a c0050a) {
            if (q.this.Ko != null && c0050a != null && (c0050a.mZ() instanceof Integer)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) q.this.Ko.getLayoutParams();
                layoutParams.leftMargin = ((Integer) c0050a.mZ()).intValue() + q.Ki;
                q.this.Ko.setLayoutParams(layoutParams);
            }
            return false;
        }
    };
    private CustomMessageListener Kr = new CustomMessageListener(2921402) { // from class: com.baidu.card.q.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bj) && ((bj) customResponsedMessage.getData()) == q.this.Kn) {
                q.this.mL();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void mL() {
        if (this.Kn != null) {
            this.Kj.setVisibility(this.Kn.aBG() ? 0 : 4);
            if (this.Kp) {
                this.Kk.setVisibility(0);
                this.Kl.setVisibility(0);
                this.Km.setVisibility(0);
                this.Kl.setImageDrawable(am.getDrawable(this.Kn.aBG() ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
                am.setViewTextColor(this.Km, this.Kn.aBG() ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
                return;
            }
            this.Kk.setVisibility(this.Kn.aBG() ? 0 : 4);
            this.Kl.setVisibility(8);
            this.Km.setVisibility(8);
        }
    }

    public q(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.multi_del_decor_layout, (ViewGroup) null);
        this.Kj = this.mRootView.findViewById(R.id.multi_del_mask_top_view);
        this.Kj.setAlpha(0.5f);
        this.Kk = this.mRootView.findViewById(R.id.multi_del_mask_bottom_view);
        this.Kk.setAlpha(0.5f);
        this.Kl = (ImageView) this.mRootView.findViewById(R.id.manage_select_img);
        this.Km = (TextView) this.mRootView.findViewById(R.id.manage_select_txt);
        this.Ko = this.mRootView.findViewById(R.id.manage_select_container);
        F(this.mRootView);
        this.mRootView.setFocusable(true);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.q.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (q.this.Kl != null && q.this.Kn != null && q.this.Km != null && !q.this.Kn.aBH()) {
                    if (!q.this.Kn.aBG()) {
                        if (com.baidu.tieba.frs.a.bBr().ag(q.this.Kn)) {
                            q.this.Kn.fv(true);
                        }
                    } else {
                        com.baidu.tieba.frs.a.bBr().ah(q.this.Kn);
                        q.this.Kn.fv(false);
                    }
                    q.this.mL();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921402, q.this.Kn));
                }
            }
        });
        setInsertIndex(-1);
        if (context instanceof BaseActivity) {
            ((BaseActivity) context).registerListener(this.Kr);
        } else if (context instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) context).registerListener(this.Kr);
        }
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        am.setBackgroundColor(this.Kj, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.Kk, R.color.cp_bg_line_d);
        this.Kl.setImageDrawable(am.getDrawable(this.Kn.aBG() ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
        am.setViewTextColor(this.Km, this.Kn.aBG() ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.d
    public void mD() {
        this.JM.a(5, this.Kq);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.d
    public void mH() {
        this.JM.b(5, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: a */
    public void A(bj bjVar) {
        this.Kn = bjVar;
        if (com.baidu.tieba.frs.a.bBr().bBs()) {
            this.mRootView.setVisibility(0);
            this.JM.b(new a.C0050a(4, false));
            mL();
            return;
        }
        this.JM.b(new a.C0050a(4, true));
        this.mRootView.setVisibility(8);
    }

    public void aa(boolean z) {
        this.Kp = z;
    }

    public void g(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }
}

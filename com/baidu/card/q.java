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
    private static final int adB = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds78);
    private View adC;
    private View adD;
    private ImageView adE;
    private TextView adF;
    private bj adG;
    private View adH;
    private View mRootView;
    private boolean adI = false;
    private BdUniqueId mPageId = null;
    private a.b adJ = new a.b() { // from class: com.baidu.card.q.1
        @Override // com.baidu.card.a.a.b
        public boolean a(a.C0074a c0074a) {
            if (q.this.adH != null && c0074a != null && (c0074a.rJ() instanceof Integer)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) q.this.adH.getLayoutParams();
                layoutParams.leftMargin = ((Integer) c0074a.rJ()).intValue() + q.adB;
                q.this.adH.setLayoutParams(layoutParams);
            }
            return false;
        }
    };
    private CustomMessageListener adK = new CustomMessageListener(2921402) { // from class: com.baidu.card.q.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bj) && ((bj) customResponsedMessage.getData()) == q.this.adG) {
                q.this.ru();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void ru() {
        if (this.adG != null) {
            this.adC.setVisibility(this.adG.aMn() ? 0 : 4);
            if (this.adI) {
                this.adD.setVisibility(0);
                this.adE.setVisibility(0);
                this.adF.setVisibility(0);
                this.adE.setImageDrawable(am.getDrawable(this.adG.aMn() ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
                am.setViewTextColor(this.adF, this.adG.aMn() ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
                return;
            }
            this.adD.setVisibility(this.adG.aMn() ? 0 : 4);
            this.adE.setVisibility(8);
            this.adF.setVisibility(8);
        }
    }

    public q(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.multi_del_decor_layout, (ViewGroup) null);
        this.adC = this.mRootView.findViewById(R.id.multi_del_mask_top_view);
        this.adC.setAlpha(0.5f);
        this.adD = this.mRootView.findViewById(R.id.multi_del_mask_bottom_view);
        this.adD.setAlpha(0.5f);
        this.adE = (ImageView) this.mRootView.findViewById(R.id.manage_select_img);
        this.adF = (TextView) this.mRootView.findViewById(R.id.manage_select_txt);
        this.adH = this.mRootView.findViewById(R.id.manage_select_container);
        F(this.mRootView);
        this.mRootView.setFocusable(true);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.q.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (q.this.adE != null && q.this.adG != null && q.this.adF != null && !q.this.adG.aMo()) {
                    if (!q.this.adG.aMn()) {
                        if (com.baidu.tieba.frs.a.bND().ak(q.this.adG)) {
                            q.this.adG.gA(true);
                        }
                    } else {
                        com.baidu.tieba.frs.a.bND().al(q.this.adG);
                        q.this.adG.gA(false);
                    }
                    q.this.ru();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921402, q.this.adG));
                }
            }
        });
        setInsertIndex(-1);
        if (context instanceof BaseActivity) {
            ((BaseActivity) context).registerListener(this.adK);
        } else if (context instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) context).registerListener(this.adK);
        }
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        am.setBackgroundColor(this.adC, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.adD, R.color.cp_bg_line_d);
        this.adE.setImageDrawable(am.getDrawable(this.adG.aMn() ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
        am.setViewTextColor(this.adF, this.adG.aMn() ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.d
    public void rk() {
        this.adg.a(5, this.adJ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.d
    public void ro() {
        this.adg.b(5, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: a */
    public void A(bj bjVar) {
        this.adG = bjVar;
        if (com.baidu.tieba.frs.a.bND().bNE()) {
            this.mRootView.setVisibility(0);
            this.adg.b(new a.C0074a(4, false));
            ru();
            return;
        }
        this.adg.b(new a.C0074a(4, true));
        this.mRootView.setVisibility(8);
    }

    public void aC(boolean z) {
        this.adI = z;
    }

    public void g(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }
}

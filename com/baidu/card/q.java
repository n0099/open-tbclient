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
    private static final int adE = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds78);
    private View adF;
    private View adG;
    private ImageView adH;
    private TextView adI;
    private bj adJ;
    private View adK;
    private View mRootView;
    private boolean adL = false;
    private BdUniqueId mPageId = null;
    private a.b adM = new a.b() { // from class: com.baidu.card.q.1
        @Override // com.baidu.card.a.a.b
        public boolean a(a.C0095a c0095a) {
            if (q.this.adK != null && c0095a != null && (c0095a.rJ() instanceof Integer)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) q.this.adK.getLayoutParams();
                layoutParams.leftMargin = ((Integer) c0095a.rJ()).intValue() + q.adE;
                q.this.adK.setLayoutParams(layoutParams);
            }
            return false;
        }
    };
    private CustomMessageListener adN = new CustomMessageListener(2921402) { // from class: com.baidu.card.q.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bj) && ((bj) customResponsedMessage.getData()) == q.this.adJ) {
                q.this.ru();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void ru() {
        if (this.adJ != null) {
            this.adF.setVisibility(this.adJ.aMl() ? 0 : 4);
            if (this.adL) {
                this.adG.setVisibility(0);
                this.adH.setVisibility(0);
                this.adI.setVisibility(0);
                this.adH.setImageDrawable(am.getDrawable(this.adJ.aMl() ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
                am.setViewTextColor(this.adI, this.adJ.aMl() ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
                return;
            }
            this.adG.setVisibility(this.adJ.aMl() ? 0 : 4);
            this.adH.setVisibility(8);
            this.adI.setVisibility(8);
        }
    }

    public q(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.multi_del_decor_layout, (ViewGroup) null);
        this.adF = this.mRootView.findViewById(R.id.multi_del_mask_top_view);
        this.adF.setAlpha(0.5f);
        this.adG = this.mRootView.findViewById(R.id.multi_del_mask_bottom_view);
        this.adG.setAlpha(0.5f);
        this.adH = (ImageView) this.mRootView.findViewById(R.id.manage_select_img);
        this.adI = (TextView) this.mRootView.findViewById(R.id.manage_select_txt);
        this.adK = this.mRootView.findViewById(R.id.manage_select_container);
        F(this.mRootView);
        this.mRootView.setFocusable(true);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.q.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (q.this.adH != null && q.this.adJ != null && q.this.adI != null && !q.this.adJ.aMm()) {
                    if (!q.this.adJ.aMl()) {
                        if (com.baidu.tieba.frs.a.bNC().ak(q.this.adJ)) {
                            q.this.adJ.gA(true);
                        }
                    } else {
                        com.baidu.tieba.frs.a.bNC().al(q.this.adJ);
                        q.this.adJ.gA(false);
                    }
                    q.this.ru();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921402, q.this.adJ));
                }
            }
        });
        setInsertIndex(-1);
        if (context instanceof BaseActivity) {
            ((BaseActivity) context).registerListener(this.adN);
        } else if (context instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) context).registerListener(this.adN);
        }
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        am.setBackgroundColor(this.adF, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.adG, R.color.cp_bg_line_d);
        this.adH.setImageDrawable(am.getDrawable(this.adJ.aMl() ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
        am.setViewTextColor(this.adI, this.adJ.aMl() ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.d
    public void rk() {
        this.adj.a(5, this.adM);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.d
    public void ro() {
        this.adj.b(5, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: a */
    public void B(bj bjVar) {
        this.adJ = bjVar;
        if (com.baidu.tieba.frs.a.bNC().bND()) {
            this.mRootView.setVisibility(0);
            this.adj.b(new a.C0095a(4, false));
            ru();
            return;
        }
        this.adj.b(new a.C0095a(4, true));
        this.mRootView.setVisibility(8);
    }

    public void aC(boolean z) {
        this.adL = z;
    }

    public void g(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }
}

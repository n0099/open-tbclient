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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class s extends d implements n<bu>, o {
    private static final int aeE = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds78);
    private static final int aeF = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private View aeG;
    private View aeH;
    private ImageView aeI;
    private TextView aeJ;
    private bu aeK;
    private View aeL;
    private View mRootView;
    private boolean aeM = false;
    private BdUniqueId mPageId = null;
    private a.b aeN = new a.b() { // from class: com.baidu.card.s.1
        @Override // com.baidu.card.a.a.b
        public boolean a(a.C0098a c0098a) {
            if (s.this.aeL != null && c0098a != null && (c0098a.sk() instanceof Integer)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) s.this.aeL.getLayoutParams();
                layoutParams.leftMargin = (com.baidu.tbadk.a.d.aNM() ? s.aeF : s.aeE) + ((Integer) c0098a.sk()).intValue();
                s.this.aeL.setLayoutParams(layoutParams);
            }
            return false;
        }
    };
    private CustomMessageListener aeO = new CustomMessageListener(2921402) { // from class: com.baidu.card.s.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bu) && ((bu) customResponsedMessage.getData()) == s.this.aeK) {
                s.this.rV();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void rV() {
        int i = 4;
        if (this.aeK != null) {
            this.aeG.setVisibility((this.aeK.aUa() || this.aeK.aUb()) ? 0 : 4);
            if (this.aeM) {
                this.aeH.setVisibility(0);
                this.aeI.setVisibility(0);
                this.aeJ.setVisibility(0);
                this.aeI.setImageDrawable(com.baidu.tbadk.core.util.an.getDrawable((this.aeK.aUa() || this.aeK.aUb()) ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
                com.baidu.tbadk.core.util.an.setViewTextColor(this.aeJ, (this.aeK.aUa() || this.aeK.aUb()) ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
                return;
            }
            View view = this.aeH;
            if (this.aeK.aUa() || this.aeK.aUb()) {
                i = 0;
            }
            view.setVisibility(i);
            this.aeI.setVisibility(8);
            this.aeJ.setVisibility(8);
        }
    }

    public s(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.multi_del_decor_layout, (ViewGroup) null);
        this.aeG = this.mRootView.findViewById(R.id.multi_del_mask_top_view);
        this.aeG.setAlpha(0.5f);
        this.aeH = this.mRootView.findViewById(R.id.multi_del_mask_bottom_view);
        this.aeH.setAlpha(0.5f);
        this.aeI = (ImageView) this.mRootView.findViewById(R.id.manage_select_img);
        this.aeJ = (TextView) this.mRootView.findViewById(R.id.manage_select_txt);
        this.aeL = this.mRootView.findViewById(R.id.manage_select_container);
        F(this.mRootView);
        this.mRootView.setFocusable(true);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.s.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (s.this.aeI != null && s.this.aeK != null && s.this.aeJ != null && !s.this.aeK.aUc()) {
                    if (s.this.aeK.aUa() || !com.baidu.tieba.frs.b.bXc().bWW()) {
                        if (s.this.aeK.aUb() || !com.baidu.tieba.frs.a.bWV().bWW()) {
                            com.baidu.tieba.frs.b.bXc().am(s.this.aeK);
                            s.this.aeK.ha(false);
                            com.baidu.tieba.frs.a.bWV().am(s.this.aeK);
                            s.this.aeK.hb(false);
                        } else if (com.baidu.tieba.frs.a.bWV().al(s.this.aeK)) {
                            s.this.aeK.hb(true);
                        }
                    } else if (com.baidu.tieba.frs.b.bXc().al(s.this.aeK)) {
                        s.this.aeK.ha(true);
                    }
                    s.this.rV();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921402, s.this.aeK));
                }
            }
        });
        setInsertIndex(-1);
        if (context instanceof BaseActivity) {
            ((BaseActivity) context).registerListener(this.aeO);
        } else if (context instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) context).registerListener(this.aeO);
        }
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        com.baidu.tbadk.core.util.an.setBackgroundColor(this.aeG, R.color.cp_bg_line_d);
        com.baidu.tbadk.core.util.an.setBackgroundColor(this.aeH, R.color.cp_bg_line_d);
        this.aeI.setImageDrawable(com.baidu.tbadk.core.util.an.getDrawable((this.aeK.aUa() || this.aeK.aUb()) ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
        com.baidu.tbadk.core.util.an.setViewTextColor(this.aeJ, (this.aeK.aUa() || this.aeK.aUb()) ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.d
    public void rI() {
        this.aef.a(5, this.aeN);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.d
    public void rM() {
        this.aef.b(5, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: a */
    public void D(bu buVar) {
        this.aeK = buVar;
        if (com.baidu.tieba.frs.b.bXc().bWW() || com.baidu.tieba.frs.a.bWV().bWW()) {
            this.mRootView.setVisibility(0);
            this.aef.b(new a.C0098a(4, false));
            rV();
            return;
        }
        this.aef.b(new a.C0098a(4, true));
        this.mRootView.setVisibility(8);
    }

    public void aF(boolean z) {
        this.aeM = z;
    }

    public void h(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }
}

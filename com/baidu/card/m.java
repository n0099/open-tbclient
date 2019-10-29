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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class m extends c implements i<bh>, j {
    private static final int FN = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds78);
    private View FO;
    private View FP;
    private ImageView FQ;
    private TextView FR;
    private bh FT;
    private View FU;
    private View mRootView;
    private boolean FV = false;
    private BdUniqueId mPageId = null;
    private a.b FW = new a.b() { // from class: com.baidu.card.m.1
        @Override // com.baidu.card.a.a.b
        public boolean a(a.C0044a c0044a) {
            if (m.this.FU != null && c0044a != null && (c0044a.mb() instanceof Integer)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) m.this.FU.getLayoutParams();
                layoutParams.leftMargin = ((Integer) c0044a.mb()).intValue() + m.FN;
                m.this.FU.setLayoutParams(layoutParams);
            }
            return false;
        }
    };
    private CustomMessageListener FX = new CustomMessageListener(2921402) { // from class: com.baidu.card.m.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bh) && ((bh) customResponsedMessage.getData()) == m.this.FT && m.this.FV) {
                m.this.FO.setVisibility(m.this.FT.ako() ? 0 : 4);
                m.this.onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    };

    public m(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.multi_del_decor_layout, (ViewGroup) null);
        this.FO = this.mRootView.findViewById(R.id.multi_del_mask_top_view);
        this.FO.setAlpha(0.5f);
        this.FP = this.mRootView.findViewById(R.id.multi_del_mask_bottom_view);
        this.FP.setAlpha(0.5f);
        this.FQ = (ImageView) this.mRootView.findViewById(R.id.manage_select_img);
        this.FR = (TextView) this.mRootView.findViewById(R.id.manage_select_txt);
        this.FU = this.mRootView.findViewById(R.id.manage_select_container);
        F(this.mRootView);
        this.mRootView.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds15));
        this.mRootView.setFocusable(true);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.m.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.FQ != null && m.this.FT != null && m.this.FR != null && !m.this.FT.akp()) {
                    if (!m.this.FT.ako()) {
                        if (com.baidu.tieba.frs.a.biW().Z(m.this.FT)) {
                            m.this.FT.ec(true);
                        }
                    } else {
                        com.baidu.tieba.frs.a.biW().aa(m.this.FT);
                        m.this.FT.ec(false);
                    }
                    m.this.FO.setVisibility(m.this.FT.ako() ? 0 : 4);
                    m.this.FP.setVisibility(m.this.FT.ako() ? 0 : 4);
                    m.this.onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921402, m.this.FT));
                }
            }
        });
        aE(-1);
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        am.setBackgroundColor(this.FO, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.FP, R.color.cp_bg_line_d);
        this.FQ.setImageDrawable(am.getDrawable(this.FT.ako() ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
        am.setViewTextColor(this.FR, this.FT.ako() ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.c
    public void lG() {
        this.Fu.a(5, this.FW);
        if (this.mPageId != null) {
            this.FX.setTag(this.mPageId);
        }
        MessageManager.getInstance().registerListener(this.FX);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.c
    public void lJ() {
        this.Fu.b(5, null);
        MessageManager.getInstance().unRegisterListener(this.FX);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void z(bh bhVar) {
        int i = 4;
        this.FT = bhVar;
        if (com.baidu.tieba.frs.a.biW().biX()) {
            this.mRootView.setVisibility(0);
            this.Fu.b(new a.C0044a(4, false));
            View view = this.FO;
            if (this.FT.ako() || this.FT.akp()) {
                i = 0;
            }
            view.setVisibility(i);
            if (this.FV) {
                this.FP.setVisibility(0);
                this.FQ.setVisibility(0);
                this.FR.setVisibility(0);
                this.FQ.setImageDrawable(am.getDrawable(this.FT.ako() ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
                am.setViewTextColor(this.FR, this.FT.ako() ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
                return;
            }
            this.FQ.setVisibility(8);
            this.FR.setVisibility(8);
            return;
        }
        this.Fu.b(new a.C0044a(4, true));
        this.mRootView.setVisibility(8);
    }

    public void W(boolean z) {
        this.FV = z;
    }

    public void g(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }
}

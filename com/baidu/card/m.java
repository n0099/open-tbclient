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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class m extends c implements i<bg>, j {
    private static final int XO = com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst(), d.e.tbds78);
    private View XP;
    private View XQ;
    private ImageView XR;
    private TextView XS;
    private bg XT;
    private View XU;
    private View mRootView;
    private boolean XV = false;
    private BdUniqueId mPageId = null;
    private a.b XW = new a.b() { // from class: com.baidu.card.m.1
        @Override // com.baidu.card.a.a.b
        public boolean a(a.C0039a c0039a) {
            if (m.this.XU != null && c0039a != null && (c0039a.rD() instanceof Integer)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) m.this.XU.getLayoutParams();
                layoutParams.leftMargin = ((Integer) c0039a.rD()).intValue() + m.XO;
                m.this.XU.setLayoutParams(layoutParams);
            }
            return false;
        }
    };
    private CustomMessageListener XX = new CustomMessageListener(2921402) { // from class: com.baidu.card.m.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bg) && ((bg) customResponsedMessage.getData()) == m.this.XT && m.this.XV) {
                m.this.XP.setVisibility(m.this.XT.aax() ? 0 : 4);
                m.this.onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    };

    public m(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(d.h.multi_del_decor_layout, (ViewGroup) null);
        this.XP = this.mRootView.findViewById(d.g.multi_del_mask_top_view);
        this.XP.setAlpha(0.5f);
        this.XQ = this.mRootView.findViewById(d.g.multi_del_mask_bottom_view);
        this.XQ.setAlpha(0.5f);
        this.XR = (ImageView) this.mRootView.findViewById(d.g.manage_select_img);
        this.XS = (TextView) this.mRootView.findViewById(d.g.manage_select_txt);
        this.XU = this.mRootView.findViewById(d.g.manage_select_container);
        I(this.mRootView);
        this.mRootView.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.h(context, d.e.tbds15));
        this.mRootView.setFocusable(true);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.m.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.XR != null && m.this.XT != null && m.this.XS != null && !m.this.XT.aay()) {
                    if (!m.this.XT.aax()) {
                        if (com.baidu.tieba.frs.a.bbD().Z(m.this.XT)) {
                            m.this.XT.dn(true);
                        }
                    } else {
                        com.baidu.tieba.frs.a.bbD().aa(m.this.XT);
                        m.this.XT.dn(false);
                    }
                    m.this.XP.setVisibility(m.this.XT.aax() ? 0 : 4);
                    m.this.XQ.setVisibility(m.this.XT.aax() ? 0 : 4);
                    m.this.onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921402, m.this.XT));
                }
            }
        });
        bw(-1);
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        al.l(this.XP, d.C0277d.cp_bg_line_d);
        al.l(this.XQ, d.C0277d.cp_bg_line_d);
        this.XR.setImageDrawable(al.getDrawable(this.XT.aax() ? d.f.icon_frs_select_h : d.f.btn_forum_select));
        al.j(this.XS, this.XT.aax() ? d.C0277d.cp_link_tip_a : d.f.selector_comment_and_prise_item_text_color);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.c
    public void rj() {
        this.Xw.a(5, this.XW);
        if (this.mPageId != null) {
            this.XX.setTag(this.mPageId);
        }
        MessageManager.getInstance().registerListener(this.XX);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.c
    public void rm() {
        this.Xw.b(5, null);
        MessageManager.getInstance().unRegisterListener(this.XX);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(bg bgVar) {
        int i = 4;
        this.XT = bgVar;
        if (com.baidu.tieba.frs.a.bbD().bbE()) {
            this.mRootView.setVisibility(0);
            this.Xw.b(new a.C0039a(4, false));
            View view = this.XP;
            if (this.XT.aax() || this.XT.aay()) {
                i = 0;
            }
            view.setVisibility(i);
            if (this.XV) {
                this.XQ.setVisibility(0);
                this.XR.setVisibility(0);
                this.XS.setVisibility(0);
                this.XR.setImageDrawable(al.getDrawable(this.XT.aax() ? d.f.icon_frs_select_h : d.f.btn_forum_select));
                al.j(this.XS, this.XT.aax() ? d.C0277d.cp_link_tip_a : d.f.selector_comment_and_prise_item_text_color);
                return;
            }
            this.XR.setVisibility(8);
            this.XS.setVisibility(8);
            return;
        }
        this.Xw.b(new a.C0039a(4, true));
        this.mRootView.setVisibility(8);
    }

    public void aG(boolean z) {
        this.XV = z;
    }

    public void g(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }
}

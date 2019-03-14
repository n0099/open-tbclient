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
    private static final int XN = com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst(), d.e.tbds78);
    private View XO;
    private View XP;
    private ImageView XQ;
    private TextView XR;
    private bg XS;
    private View XT;
    private View mRootView;
    private boolean XU = false;
    private BdUniqueId mPageId = null;
    private a.b XV = new a.b() { // from class: com.baidu.card.m.1
        @Override // com.baidu.card.a.a.b
        public boolean a(a.C0039a c0039a) {
            if (m.this.XT != null && c0039a != null && (c0039a.rD() instanceof Integer)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) m.this.XT.getLayoutParams();
                layoutParams.leftMargin = ((Integer) c0039a.rD()).intValue() + m.XN;
                m.this.XT.setLayoutParams(layoutParams);
            }
            return false;
        }
    };
    private CustomMessageListener XW = new CustomMessageListener(2921402) { // from class: com.baidu.card.m.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bg) && ((bg) customResponsedMessage.getData()) == m.this.XS && m.this.XU) {
                m.this.XO.setVisibility(m.this.XS.aaA() ? 0 : 4);
                m.this.onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    };

    public m(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(d.h.multi_del_decor_layout, (ViewGroup) null);
        this.XO = this.mRootView.findViewById(d.g.multi_del_mask_top_view);
        this.XO.setAlpha(0.5f);
        this.XP = this.mRootView.findViewById(d.g.multi_del_mask_bottom_view);
        this.XP.setAlpha(0.5f);
        this.XQ = (ImageView) this.mRootView.findViewById(d.g.manage_select_img);
        this.XR = (TextView) this.mRootView.findViewById(d.g.manage_select_txt);
        this.XT = this.mRootView.findViewById(d.g.manage_select_container);
        I(this.mRootView);
        this.mRootView.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.h(context, d.e.tbds15));
        this.mRootView.setFocusable(true);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.m.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.XQ != null && m.this.XS != null && m.this.XR != null && !m.this.XS.aaB()) {
                    if (!m.this.XS.aaA()) {
                        if (com.baidu.tieba.frs.a.bbF().aa(m.this.XS)) {
                            m.this.XS.dn(true);
                        }
                    } else {
                        com.baidu.tieba.frs.a.bbF().ab(m.this.XS);
                        m.this.XS.dn(false);
                    }
                    m.this.XO.setVisibility(m.this.XS.aaA() ? 0 : 4);
                    m.this.XP.setVisibility(m.this.XS.aaA() ? 0 : 4);
                    m.this.onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921402, m.this.XS));
                }
            }
        });
        bx(-1);
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        al.l(this.XO, d.C0277d.cp_bg_line_d);
        al.l(this.XP, d.C0277d.cp_bg_line_d);
        this.XQ.setImageDrawable(al.getDrawable(this.XS.aaA() ? d.f.icon_frs_select_h : d.f.btn_forum_select));
        al.j(this.XR, this.XS.aaA() ? d.C0277d.cp_link_tip_a : d.f.selector_comment_and_prise_item_text_color);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.c
    public void rj() {
        this.Xv.a(5, this.XV);
        if (this.mPageId != null) {
            this.XW.setTag(this.mPageId);
        }
        MessageManager.getInstance().registerListener(this.XW);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.c
    public void rm() {
        this.Xv.b(5, null);
        MessageManager.getInstance().unRegisterListener(this.XW);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(bg bgVar) {
        int i = 4;
        this.XS = bgVar;
        if (com.baidu.tieba.frs.a.bbF().bbG()) {
            this.mRootView.setVisibility(0);
            this.Xv.b(new a.C0039a(4, false));
            View view = this.XO;
            if (this.XS.aaA() || this.XS.aaB()) {
                i = 0;
            }
            view.setVisibility(i);
            if (this.XU) {
                this.XP.setVisibility(0);
                this.XQ.setVisibility(0);
                this.XR.setVisibility(0);
                this.XQ.setImageDrawable(al.getDrawable(this.XS.aaA() ? d.f.icon_frs_select_h : d.f.btn_forum_select));
                al.j(this.XR, this.XS.aaA() ? d.C0277d.cp_link_tip_a : d.f.selector_comment_and_prise_item_text_color);
                return;
            }
            this.XQ.setVisibility(8);
            this.XR.setVisibility(8);
            return;
        }
        this.Xv.b(new a.C0039a(4, true));
        this.mRootView.setVisibility(8);
    }

    public void aG(boolean z) {
        this.XU = z;
    }

    public void g(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }
}

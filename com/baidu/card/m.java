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
    private static final int XM = com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst(), d.e.tbds78);
    private View XN;
    private View XO;
    private ImageView XP;
    private TextView XQ;
    private bg XR;
    private View XS;
    private View mRootView;
    private boolean XT = false;
    private BdUniqueId mPageId = null;
    private a.b XU = new a.b() { // from class: com.baidu.card.m.1
        @Override // com.baidu.card.a.a.b
        public boolean a(a.C0037a c0037a) {
            if (m.this.XS != null && c0037a != null && (c0037a.rD() instanceof Integer)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) m.this.XS.getLayoutParams();
                layoutParams.leftMargin = ((Integer) c0037a.rD()).intValue() + m.XM;
                m.this.XS.setLayoutParams(layoutParams);
            }
            return false;
        }
    };
    private CustomMessageListener XV = new CustomMessageListener(2921402) { // from class: com.baidu.card.m.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bg) && ((bg) customResponsedMessage.getData()) == m.this.XR && m.this.XT) {
                m.this.XN.setVisibility(m.this.XR.aaA() ? 0 : 4);
                m.this.onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    };

    public m(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(d.h.multi_del_decor_layout, (ViewGroup) null);
        this.XN = this.mRootView.findViewById(d.g.multi_del_mask_top_view);
        this.XN.setAlpha(0.5f);
        this.XO = this.mRootView.findViewById(d.g.multi_del_mask_bottom_view);
        this.XO.setAlpha(0.5f);
        this.XP = (ImageView) this.mRootView.findViewById(d.g.manage_select_img);
        this.XQ = (TextView) this.mRootView.findViewById(d.g.manage_select_txt);
        this.XS = this.mRootView.findViewById(d.g.manage_select_container);
        I(this.mRootView);
        this.mRootView.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.h(context, d.e.tbds15));
        this.mRootView.setFocusable(true);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.m.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.XP != null && m.this.XR != null && m.this.XQ != null && !m.this.XR.aaB()) {
                    if (!m.this.XR.aaA()) {
                        if (com.baidu.tieba.frs.a.bbF().aa(m.this.XR)) {
                            m.this.XR.dn(true);
                        }
                    } else {
                        com.baidu.tieba.frs.a.bbF().ab(m.this.XR);
                        m.this.XR.dn(false);
                    }
                    m.this.XN.setVisibility(m.this.XR.aaA() ? 0 : 4);
                    m.this.XO.setVisibility(m.this.XR.aaA() ? 0 : 4);
                    m.this.onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921402, m.this.XR));
                }
            }
        });
        bx(-1);
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        al.l(this.XN, d.C0236d.cp_bg_line_d);
        al.l(this.XO, d.C0236d.cp_bg_line_d);
        this.XP.setImageDrawable(al.getDrawable(this.XR.aaA() ? d.f.icon_frs_select_h : d.f.btn_forum_select));
        al.j(this.XQ, this.XR.aaA() ? d.C0236d.cp_link_tip_a : d.f.selector_comment_and_prise_item_text_color);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.c
    public void rj() {
        this.Xu.a(5, this.XU);
        if (this.mPageId != null) {
            this.XV.setTag(this.mPageId);
        }
        MessageManager.getInstance().registerListener(this.XV);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.c
    public void rm() {
        this.Xu.b(5, null);
        MessageManager.getInstance().unRegisterListener(this.XV);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(bg bgVar) {
        int i = 4;
        this.XR = bgVar;
        if (com.baidu.tieba.frs.a.bbF().bbG()) {
            this.mRootView.setVisibility(0);
            this.Xu.b(new a.C0037a(4, false));
            View view = this.XN;
            if (this.XR.aaA() || this.XR.aaB()) {
                i = 0;
            }
            view.setVisibility(i);
            if (this.XT) {
                this.XO.setVisibility(0);
                this.XP.setVisibility(0);
                this.XQ.setVisibility(0);
                this.XP.setImageDrawable(al.getDrawable(this.XR.aaA() ? d.f.icon_frs_select_h : d.f.btn_forum_select));
                al.j(this.XQ, this.XR.aaA() ? d.C0236d.cp_link_tip_a : d.f.selector_comment_and_prise_item_text_color);
                return;
            }
            this.XP.setVisibility(8);
            this.XQ.setVisibility(8);
            return;
        }
        this.Xu.b(new a.C0037a(4, true));
        this.mRootView.setVisibility(8);
    }

    public void aG(boolean z) {
        this.XT = z;
    }

    public void g(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }
}

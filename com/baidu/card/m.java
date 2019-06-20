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
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class m extends c implements i<bg>, j {
    private static final int VE = com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds78);
    private View VF;
    private View VG;
    private ImageView VH;
    private TextView VI;
    private bg VJ;
    private View VK;
    private View mRootView;
    private boolean VL = false;
    private BdUniqueId mPageId = null;
    private a.b VM = new a.b() { // from class: com.baidu.card.m.1
        @Override // com.baidu.card.a.a.b
        public boolean a(a.C0038a c0038a) {
            if (m.this.VK != null && c0038a != null && (c0038a.qy() instanceof Integer)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) m.this.VK.getLayoutParams();
                layoutParams.leftMargin = ((Integer) c0038a.qy()).intValue() + m.VE;
                m.this.VK.setLayoutParams(layoutParams);
            }
            return false;
        }
    };
    private CustomMessageListener VN = new CustomMessageListener(2921402) { // from class: com.baidu.card.m.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bg) && ((bg) customResponsedMessage.getData()) == m.this.VJ && m.this.VL) {
                m.this.VF.setVisibility(m.this.VJ.afe() ? 0 : 4);
                m.this.onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    };

    public m(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.multi_del_decor_layout, (ViewGroup) null);
        this.VF = this.mRootView.findViewById(R.id.multi_del_mask_top_view);
        this.VF.setAlpha(0.5f);
        this.VG = this.mRootView.findViewById(R.id.multi_del_mask_bottom_view);
        this.VG.setAlpha(0.5f);
        this.VH = (ImageView) this.mRootView.findViewById(R.id.manage_select_img);
        this.VI = (TextView) this.mRootView.findViewById(R.id.manage_select_txt);
        this.VK = this.mRootView.findViewById(R.id.manage_select_container);
        I(this.mRootView);
        this.mRootView.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.g(context, R.dimen.tbds15));
        this.mRootView.setFocusable(true);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.m.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.VH != null && m.this.VJ != null && m.this.VI != null && !m.this.VJ.aff()) {
                    if (!m.this.VJ.afe()) {
                        if (com.baidu.tieba.frs.a.biW().Z(m.this.VJ)) {
                            m.this.VJ.dI(true);
                        }
                    } else {
                        com.baidu.tieba.frs.a.biW().aa(m.this.VJ);
                        m.this.VJ.dI(false);
                    }
                    m.this.VF.setVisibility(m.this.VJ.afe() ? 0 : 4);
                    m.this.VG.setVisibility(m.this.VJ.afe() ? 0 : 4);
                    m.this.onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921402, m.this.VJ));
                }
            }
        });
        bp(-1);
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        al.l(this.VF, R.color.cp_bg_line_d);
        al.l(this.VG, R.color.cp_bg_line_d);
        this.VH.setImageDrawable(al.getDrawable(this.VJ.afe() ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
        al.j(this.VI, this.VJ.afe() ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.c
    public void qe() {
        this.Vm.a(5, this.VM);
        if (this.mPageId != null) {
            this.VN.setTag(this.mPageId);
        }
        MessageManager.getInstance().registerListener(this.VN);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.c
    public void qh() {
        this.Vm.b(5, null);
        MessageManager.getInstance().unRegisterListener(this.VN);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(bg bgVar) {
        int i = 4;
        this.VJ = bgVar;
        if (com.baidu.tieba.frs.a.biW().biX()) {
            this.mRootView.setVisibility(0);
            this.Vm.b(new a.C0038a(4, false));
            View view = this.VF;
            if (this.VJ.afe() || this.VJ.aff()) {
                i = 0;
            }
            view.setVisibility(i);
            if (this.VL) {
                this.VG.setVisibility(0);
                this.VH.setVisibility(0);
                this.VI.setVisibility(0);
                this.VH.setImageDrawable(al.getDrawable(this.VJ.afe() ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
                al.j(this.VI, this.VJ.afe() ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
                return;
            }
            this.VH.setVisibility(8);
            this.VI.setVisibility(8);
            return;
        }
        this.Vm.b(new a.C0038a(4, true));
        this.mRootView.setVisibility(8);
    }

    public void ay(boolean z) {
        this.VL = z;
    }

    public void g(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }
}

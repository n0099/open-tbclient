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
    private static final int VF = com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds78);
    private View VG;
    private View VH;
    private ImageView VI;
    private TextView VJ;
    private bg VK;
    private View VL;
    private View mRootView;
    private boolean VM = false;
    private BdUniqueId mPageId = null;
    private a.b VN = new a.b() { // from class: com.baidu.card.m.1
        @Override // com.baidu.card.a.a.b
        public boolean a(a.C0038a c0038a) {
            if (m.this.VL != null && c0038a != null && (c0038a.qy() instanceof Integer)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) m.this.VL.getLayoutParams();
                layoutParams.leftMargin = ((Integer) c0038a.qy()).intValue() + m.VF;
                m.this.VL.setLayoutParams(layoutParams);
            }
            return false;
        }
    };
    private CustomMessageListener VO = new CustomMessageListener(2921402) { // from class: com.baidu.card.m.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bg) && ((bg) customResponsedMessage.getData()) == m.this.VK && m.this.VM) {
                m.this.VG.setVisibility(m.this.VK.afe() ? 0 : 4);
                m.this.onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    };

    public m(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.multi_del_decor_layout, (ViewGroup) null);
        this.VG = this.mRootView.findViewById(R.id.multi_del_mask_top_view);
        this.VG.setAlpha(0.5f);
        this.VH = this.mRootView.findViewById(R.id.multi_del_mask_bottom_view);
        this.VH.setAlpha(0.5f);
        this.VI = (ImageView) this.mRootView.findViewById(R.id.manage_select_img);
        this.VJ = (TextView) this.mRootView.findViewById(R.id.manage_select_txt);
        this.VL = this.mRootView.findViewById(R.id.manage_select_container);
        I(this.mRootView);
        this.mRootView.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.g(context, R.dimen.tbds15));
        this.mRootView.setFocusable(true);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.m.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.VI != null && m.this.VK != null && m.this.VJ != null && !m.this.VK.aff()) {
                    if (!m.this.VK.afe()) {
                        if (com.baidu.tieba.frs.a.biT().Z(m.this.VK)) {
                            m.this.VK.dI(true);
                        }
                    } else {
                        com.baidu.tieba.frs.a.biT().aa(m.this.VK);
                        m.this.VK.dI(false);
                    }
                    m.this.VG.setVisibility(m.this.VK.afe() ? 0 : 4);
                    m.this.VH.setVisibility(m.this.VK.afe() ? 0 : 4);
                    m.this.onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921402, m.this.VK));
                }
            }
        });
        bp(-1);
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        al.l(this.VG, R.color.cp_bg_line_d);
        al.l(this.VH, R.color.cp_bg_line_d);
        this.VI.setImageDrawable(al.getDrawable(this.VK.afe() ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
        al.j(this.VJ, this.VK.afe() ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.c
    public void qe() {
        this.Vn.a(5, this.VN);
        if (this.mPageId != null) {
            this.VO.setTag(this.mPageId);
        }
        MessageManager.getInstance().registerListener(this.VO);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.c
    public void qh() {
        this.Vn.b(5, null);
        MessageManager.getInstance().unRegisterListener(this.VO);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(bg bgVar) {
        int i = 4;
        this.VK = bgVar;
        if (com.baidu.tieba.frs.a.biT().biU()) {
            this.mRootView.setVisibility(0);
            this.Vn.b(new a.C0038a(4, false));
            View view = this.VG;
            if (this.VK.afe() || this.VK.aff()) {
                i = 0;
            }
            view.setVisibility(i);
            if (this.VM) {
                this.VH.setVisibility(0);
                this.VI.setVisibility(0);
                this.VJ.setVisibility(0);
                this.VI.setImageDrawable(al.getDrawable(this.VK.afe() ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
                al.j(this.VJ, this.VK.afe() ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
                return;
            }
            this.VI.setVisibility(8);
            this.VJ.setVisibility(8);
            return;
        }
        this.Vn.b(new a.C0038a(4, true));
        this.mRootView.setVisibility(8);
    }

    public void ay(boolean z) {
        this.VM = z;
    }

    public void g(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }
}

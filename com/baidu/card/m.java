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
    private static final int VY = com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds78);
    private View VZ;
    private View Wa;
    private ImageView Wb;
    private TextView Wc;
    private bh Wd;
    private View We;
    private View mRootView;
    private boolean Wf = false;
    private BdUniqueId mPageId = null;
    private a.b Wg = new a.b() { // from class: com.baidu.card.m.1
        @Override // com.baidu.card.a.a.b
        public boolean a(a.C0038a c0038a) {
            if (m.this.We != null && c0038a != null && (c0038a.qW() instanceof Integer)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) m.this.We.getLayoutParams();
                layoutParams.leftMargin = ((Integer) c0038a.qW()).intValue() + m.VY;
                m.this.We.setLayoutParams(layoutParams);
            }
            return false;
        }
    };
    private CustomMessageListener Wh = new CustomMessageListener(2921402) { // from class: com.baidu.card.m.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bh) && ((bh) customResponsedMessage.getData()) == m.this.Wd && m.this.Wf) {
                m.this.VZ.setVisibility(m.this.Wd.agl() ? 0 : 4);
                m.this.onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    };

    public m(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.multi_del_decor_layout, (ViewGroup) null);
        this.VZ = this.mRootView.findViewById(R.id.multi_del_mask_top_view);
        this.VZ.setAlpha(0.5f);
        this.Wa = this.mRootView.findViewById(R.id.multi_del_mask_bottom_view);
        this.Wa.setAlpha(0.5f);
        this.Wb = (ImageView) this.mRootView.findViewById(R.id.manage_select_img);
        this.Wc = (TextView) this.mRootView.findViewById(R.id.manage_select_txt);
        this.We = this.mRootView.findViewById(R.id.manage_select_container);
        K(this.mRootView);
        this.mRootView.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.g(context, R.dimen.tbds15));
        this.mRootView.setFocusable(true);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.m.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.Wb != null && m.this.Wd != null && m.this.Wc != null && !m.this.Wd.agm()) {
                    if (!m.this.Wd.agl()) {
                        if (com.baidu.tieba.frs.a.blQ().ab(m.this.Wd)) {
                            m.this.Wd.dM(true);
                        }
                    } else {
                        com.baidu.tieba.frs.a.blQ().ac(m.this.Wd);
                        m.this.Wd.dM(false);
                    }
                    m.this.VZ.setVisibility(m.this.Wd.agl() ? 0 : 4);
                    m.this.Wa.setVisibility(m.this.Wd.agl() ? 0 : 4);
                    m.this.onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921402, m.this.Wd));
                }
            }
        });
        bp(-1);
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        am.l(this.VZ, R.color.cp_bg_line_d);
        am.l(this.Wa, R.color.cp_bg_line_d);
        this.Wb.setImageDrawable(am.getDrawable(this.Wd.agl() ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
        am.j(this.Wc, this.Wd.agl() ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.c
    public void qB() {
        this.VF.a(5, this.Wg);
        if (this.mPageId != null) {
            this.Wh.setTag(this.mPageId);
        }
        MessageManager.getInstance().registerListener(this.Wh);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.c
    public void qE() {
        this.VF.b(5, null);
        MessageManager.getInstance().unRegisterListener(this.Wh);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(bh bhVar) {
        int i = 4;
        this.Wd = bhVar;
        if (com.baidu.tieba.frs.a.blQ().blR()) {
            this.mRootView.setVisibility(0);
            this.VF.b(new a.C0038a(4, false));
            View view = this.VZ;
            if (this.Wd.agl() || this.Wd.agm()) {
                i = 0;
            }
            view.setVisibility(i);
            if (this.Wf) {
                this.Wa.setVisibility(0);
                this.Wb.setVisibility(0);
                this.Wc.setVisibility(0);
                this.Wb.setImageDrawable(am.getDrawable(this.Wd.agl() ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
                am.j(this.Wc, this.Wd.agl() ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
                return;
            }
            this.Wb.setVisibility(8);
            this.Wc.setVisibility(8);
            return;
        }
        this.VF.b(new a.C0038a(4, true));
        this.mRootView.setVisibility(8);
    }

    public void aB(boolean z) {
        this.Wf = z;
    }

    public void g(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }
}

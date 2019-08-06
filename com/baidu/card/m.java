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
    private static final int VZ = com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds78);
    private View Wa;
    private View Wb;
    private ImageView Wc;
    private TextView Wd;
    private bh We;
    private View Wf;
    private View mRootView;
    private boolean Wg = false;
    private BdUniqueId mPageId = null;
    private a.b Wh = new a.b() { // from class: com.baidu.card.m.1
        @Override // com.baidu.card.a.a.b
        public boolean a(a.C0038a c0038a) {
            if (m.this.Wf != null && c0038a != null && (c0038a.qV() instanceof Integer)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) m.this.Wf.getLayoutParams();
                layoutParams.leftMargin = ((Integer) c0038a.qV()).intValue() + m.VZ;
                m.this.Wf.setLayoutParams(layoutParams);
            }
            return false;
        }
    };
    private CustomMessageListener Wi = new CustomMessageListener(2921402) { // from class: com.baidu.card.m.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bh) && ((bh) customResponsedMessage.getData()) == m.this.We && m.this.Wg) {
                m.this.Wa.setVisibility(m.this.We.agh() ? 0 : 4);
                m.this.onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    };

    public m(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.multi_del_decor_layout, (ViewGroup) null);
        this.Wa = this.mRootView.findViewById(R.id.multi_del_mask_top_view);
        this.Wa.setAlpha(0.5f);
        this.Wb = this.mRootView.findViewById(R.id.multi_del_mask_bottom_view);
        this.Wb.setAlpha(0.5f);
        this.Wc = (ImageView) this.mRootView.findViewById(R.id.manage_select_img);
        this.Wd = (TextView) this.mRootView.findViewById(R.id.manage_select_txt);
        this.Wf = this.mRootView.findViewById(R.id.manage_select_container);
        K(this.mRootView);
        this.mRootView.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.g(context, R.dimen.tbds15));
        this.mRootView.setFocusable(true);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.m.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.Wc != null && m.this.We != null && m.this.Wd != null && !m.this.We.agi()) {
                    if (!m.this.We.agh()) {
                        if (com.baidu.tieba.frs.a.blf().aa(m.this.We)) {
                            m.this.We.dM(true);
                        }
                    } else {
                        com.baidu.tieba.frs.a.blf().ab(m.this.We);
                        m.this.We.dM(false);
                    }
                    m.this.Wa.setVisibility(m.this.We.agh() ? 0 : 4);
                    m.this.Wb.setVisibility(m.this.We.agh() ? 0 : 4);
                    m.this.onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921402, m.this.We));
                }
            }
        });
        bp(-1);
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        am.l(this.Wa, R.color.cp_bg_line_d);
        am.l(this.Wb, R.color.cp_bg_line_d);
        this.Wc.setImageDrawable(am.getDrawable(this.We.agh() ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
        am.j(this.Wd, this.We.agh() ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.c
    public void qA() {
        this.VG.a(5, this.Wh);
        if (this.mPageId != null) {
            this.Wi.setTag(this.mPageId);
        }
        MessageManager.getInstance().registerListener(this.Wi);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.c
    public void qD() {
        this.VG.b(5, null);
        MessageManager.getInstance().unRegisterListener(this.Wi);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(bh bhVar) {
        int i = 4;
        this.We = bhVar;
        if (com.baidu.tieba.frs.a.blf().blg()) {
            this.mRootView.setVisibility(0);
            this.VG.b(new a.C0038a(4, false));
            View view = this.Wa;
            if (this.We.agh() || this.We.agi()) {
                i = 0;
            }
            view.setVisibility(i);
            if (this.Wg) {
                this.Wb.setVisibility(0);
                this.Wc.setVisibility(0);
                this.Wd.setVisibility(0);
                this.Wc.setImageDrawable(am.getDrawable(this.We.agh() ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
                am.j(this.Wd, this.We.agh() ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
                return;
            }
            this.Wc.setVisibility(8);
            this.Wd.setVisibility(8);
            return;
        }
        this.VG.b(new a.C0038a(4, true));
        this.mRootView.setVisibility(8);
    }

    public void aB(boolean z) {
        this.Wg = z;
    }

    public void g(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }
}

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
    private static final int Fn = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds78);
    private View Fo;
    private View Fp;
    private ImageView Fq;
    private TextView Fr;
    private bh Fs;
    private View Ft;
    private View mRootView;
    private boolean Fu = false;
    private BdUniqueId mPageId = null;
    private a.b Fv = new a.b() { // from class: com.baidu.card.m.1
        @Override // com.baidu.card.a.a.b
        public boolean a(a.C0044a c0044a) {
            if (m.this.Ft != null && c0044a != null && (c0044a.mb() instanceof Integer)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) m.this.Ft.getLayoutParams();
                layoutParams.leftMargin = ((Integer) c0044a.mb()).intValue() + m.Fn;
                m.this.Ft.setLayoutParams(layoutParams);
            }
            return false;
        }
    };
    private CustomMessageListener Fw = new CustomMessageListener(2921402) { // from class: com.baidu.card.m.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bh) && ((bh) customResponsedMessage.getData()) == m.this.Fs && m.this.Fu) {
                m.this.Fo.setVisibility(m.this.Fs.akm() ? 0 : 4);
                m.this.onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    };

    public m(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.multi_del_decor_layout, (ViewGroup) null);
        this.Fo = this.mRootView.findViewById(R.id.multi_del_mask_top_view);
        this.Fo.setAlpha(0.5f);
        this.Fp = this.mRootView.findViewById(R.id.multi_del_mask_bottom_view);
        this.Fp.setAlpha(0.5f);
        this.Fq = (ImageView) this.mRootView.findViewById(R.id.manage_select_img);
        this.Fr = (TextView) this.mRootView.findViewById(R.id.manage_select_txt);
        this.Ft = this.mRootView.findViewById(R.id.manage_select_container);
        F(this.mRootView);
        this.mRootView.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds15));
        this.mRootView.setFocusable(true);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.m.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.Fq != null && m.this.Fs != null && m.this.Fr != null && !m.this.Fs.akn()) {
                    if (!m.this.Fs.akm()) {
                        if (com.baidu.tieba.frs.a.biU().Z(m.this.Fs)) {
                            m.this.Fs.ec(true);
                        }
                    } else {
                        com.baidu.tieba.frs.a.biU().aa(m.this.Fs);
                        m.this.Fs.ec(false);
                    }
                    m.this.Fo.setVisibility(m.this.Fs.akm() ? 0 : 4);
                    m.this.Fp.setVisibility(m.this.Fs.akm() ? 0 : 4);
                    m.this.onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921402, m.this.Fs));
                }
            }
        });
        aE(-1);
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        am.setBackgroundColor(this.Fo, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.Fp, R.color.cp_bg_line_d);
        this.Fq.setImageDrawable(am.getDrawable(this.Fs.akm() ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
        am.setViewTextColor(this.Fr, this.Fs.akm() ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.c
    public void lG() {
        this.EU.a(5, this.Fv);
        if (this.mPageId != null) {
            this.Fw.setTag(this.mPageId);
        }
        MessageManager.getInstance().registerListener(this.Fw);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.c
    public void lJ() {
        this.EU.b(5, null);
        MessageManager.getInstance().unRegisterListener(this.Fw);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void z(bh bhVar) {
        int i = 4;
        this.Fs = bhVar;
        if (com.baidu.tieba.frs.a.biU().biV()) {
            this.mRootView.setVisibility(0);
            this.EU.b(new a.C0044a(4, false));
            View view = this.Fo;
            if (this.Fs.akm() || this.Fs.akn()) {
                i = 0;
            }
            view.setVisibility(i);
            if (this.Fu) {
                this.Fp.setVisibility(0);
                this.Fq.setVisibility(0);
                this.Fr.setVisibility(0);
                this.Fq.setImageDrawable(am.getDrawable(this.Fs.akm() ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
                am.setViewTextColor(this.Fr, this.Fs.akm() ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
                return;
            }
            this.Fq.setVisibility(8);
            this.Fr.setVisibility(8);
            return;
        }
        this.EU.b(new a.C0044a(4, true));
        this.mRootView.setVisibility(8);
    }

    public void W(boolean z) {
        this.Fu = z;
    }

    public void g(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }
}

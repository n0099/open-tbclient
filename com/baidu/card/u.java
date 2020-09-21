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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tieba.R;
/* loaded from: classes20.dex */
public class u extends d implements p<bw>, q {
    private static final int afX = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds78);
    private static final int afY = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int afZ = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds12);
    private View aga;
    private View agb;
    private ImageView agc;
    private TextView agd;
    private bw agf;
    private View agg;
    private View mRootView;
    private boolean agh = false;
    private BdUniqueId mPageId = null;
    private a.b agi = new a.b() { // from class: com.baidu.card.u.1
        @Override // com.baidu.card.a.a.b
        public boolean a(a.C0096a c0096a) {
            if (u.this.agg != null && c0096a != null && (c0096a.ud() instanceof Integer)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) u.this.agg.getLayoutParams();
                layoutParams.leftMargin = (com.baidu.tbadk.a.d.baI() ? u.afY : u.afX) + ((Integer) c0096a.ud()).intValue();
                if (!u.this.agh) {
                    layoutParams.addRule(15);
                }
                u.this.agg.setLayoutParams(layoutParams);
            }
            return false;
        }
    };
    private CustomMessageListener agj = new CustomMessageListener(2921402) { // from class: com.baidu.card.u.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bw) && ((bw) customResponsedMessage.getData()) == u.this.agf) {
                u.this.tM();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void tM() {
        int i = 4;
        if (this.agf != null) {
            this.aga.setVisibility((this.agf.bhj() || this.agf.bhk()) ? 0 : 4);
            if (this.agh) {
                this.agb.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.agg.getLayoutParams();
                layoutParams.removeRule(15);
                layoutParams.topMargin = afZ;
                this.agg.setLayoutParams(layoutParams);
                this.agc.setVisibility(0);
                this.agd.setVisibility(0);
                this.agc.setImageDrawable(com.baidu.tbadk.core.util.ap.getDrawable((this.agf.bhj() || this.agf.bhk()) ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.agd, (this.agf.bhj() || this.agf.bhk()) ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
                return;
            }
            View view = this.agb;
            if (this.agf.bhj() || this.agf.bhk()) {
                i = 0;
            }
            view.setVisibility(i);
            this.agc.setVisibility(8);
            this.agd.setVisibility(8);
        }
    }

    public u(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.multi_del_decor_layout, (ViewGroup) null);
        this.aga = this.mRootView.findViewById(R.id.multi_del_mask_top_view);
        this.aga.setAlpha(0.5f);
        this.agb = this.mRootView.findViewById(R.id.multi_del_mask_bottom_view);
        this.agb.setAlpha(0.5f);
        this.agc = (ImageView) this.mRootView.findViewById(R.id.manage_select_img);
        this.agd = (TextView) this.mRootView.findViewById(R.id.manage_select_txt);
        this.agg = this.mRootView.findViewById(R.id.manage_select_container);
        H(this.mRootView);
        this.mRootView.setFocusable(true);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.u.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (u.this.agc != null && u.this.agf != null && u.this.agd != null && !u.this.agf.bhl()) {
                    if (u.this.agf.bhj() || !com.baidu.tieba.frs.b.cog().coa()) {
                        if (u.this.agf.bhk() || !com.baidu.tieba.frs.a.cnZ().coa()) {
                            com.baidu.tieba.frs.b.cog().ak(u.this.agf);
                            u.this.agf.hY(false);
                            com.baidu.tieba.frs.a.cnZ().ak(u.this.agf);
                            u.this.agf.hZ(false);
                        } else if (com.baidu.tieba.frs.a.cnZ().aj(u.this.agf)) {
                            u.this.agf.hZ(true);
                        }
                    } else if (com.baidu.tieba.frs.b.cog().aj(u.this.agf)) {
                        u.this.agf.hY(true);
                    }
                    u.this.tM();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921402, u.this.agf));
                }
            }
        });
        setInsertIndex(-1);
        if (context instanceof BaseActivity) {
            ((BaseActivity) context).registerListener(this.agj);
        } else if (context instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) context).registerListener(this.agj);
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        com.baidu.tbadk.core.util.ap.setBackgroundColor(this.aga, R.color.cp_bg_line_d);
        com.baidu.tbadk.core.util.ap.setBackgroundColor(this.agb, R.color.cp_bg_line_d);
        this.agc.setImageDrawable(com.baidu.tbadk.core.util.ap.getDrawable((this.agf.bhj() || this.agf.bhk()) ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.agd, (this.agf.bhj() || this.agf.bhk()) ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.d
    public void tA() {
        this.afv.a(5, this.agi);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.d
    public void tE() {
        this.afv.b(5, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: a */
    public void G(bw bwVar) {
        this.agf = bwVar;
        if (com.baidu.tieba.frs.b.cog().coa() || com.baidu.tieba.frs.a.cnZ().coa()) {
            this.mRootView.setVisibility(0);
            this.afv.b(new a.C0096a(4, false));
            tM();
            return;
        }
        this.afv.b(new a.C0096a(4, true));
        this.mRootView.setVisibility(8);
    }

    public void aI(boolean z) {
        this.agh = z;
    }

    public void h(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }
}

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
/* loaded from: classes21.dex */
public class u extends d implements p<bw>, q {
    private static final int agq = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds78);
    private static final int agr = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int ags = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds12);
    private View agt;
    private View agu;
    private ImageView agv;
    private TextView agw;
    private bw agx;
    private View agy;
    private View mRootView;
    private boolean agz = false;
    private BdUniqueId mPageId = null;
    private a.b agA = new a.b() { // from class: com.baidu.card.u.1
        @Override // com.baidu.card.a.a.b
        public boolean a(a.C0097a c0097a) {
            if (u.this.agy != null && c0097a != null && (c0097a.ud() instanceof Integer)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) u.this.agy.getLayoutParams();
                layoutParams.leftMargin = (com.baidu.tbadk.a.d.bhJ() ? u.agr : u.agq) + ((Integer) c0097a.ud()).intValue();
                if (!u.this.agz) {
                    layoutParams.addRule(15);
                }
                u.this.agy.setLayoutParams(layoutParams);
            }
            return false;
        }
    };
    private CustomMessageListener agB = new CustomMessageListener(2921402) { // from class: com.baidu.card.u.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bw) && ((bw) customResponsedMessage.getData()) == u.this.agx) {
                u.this.tM();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void tM() {
        int i = 4;
        if (this.agx != null) {
            this.agt.setVisibility((this.agx.bol() || this.agx.bom()) ? 0 : 4);
            if (this.agz) {
                this.agu.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.agy.getLayoutParams();
                layoutParams.removeRule(15);
                layoutParams.topMargin = ags;
                this.agy.setLayoutParams(layoutParams);
                this.agv.setVisibility(0);
                this.agw.setVisibility(0);
                this.agv.setImageDrawable(com.baidu.tbadk.core.util.ap.getDrawable((this.agx.bol() || this.agx.bom()) ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.agw, (this.agx.bol() || this.agx.bom()) ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
                return;
            }
            View view = this.agu;
            if (this.agx.bol() || this.agx.bom()) {
                i = 0;
            }
            view.setVisibility(i);
            this.agv.setVisibility(8);
            this.agw.setVisibility(8);
        }
    }

    public u(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.multi_del_decor_layout, (ViewGroup) null);
        this.agt = this.mRootView.findViewById(R.id.multi_del_mask_top_view);
        this.agt.setAlpha(0.5f);
        this.agu = this.mRootView.findViewById(R.id.multi_del_mask_bottom_view);
        this.agu.setAlpha(0.5f);
        this.agv = (ImageView) this.mRootView.findViewById(R.id.manage_select_img);
        this.agw = (TextView) this.mRootView.findViewById(R.id.manage_select_txt);
        this.agy = this.mRootView.findViewById(R.id.manage_select_container);
        H(this.mRootView);
        this.mRootView.setFocusable(true);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.u.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (u.this.agv != null && u.this.agx != null && u.this.agw != null && !u.this.agx.bon()) {
                    if (u.this.agx.bol() || !com.baidu.tieba.frs.b.cxm().cxg()) {
                        if (u.this.agx.bom() || !com.baidu.tieba.frs.a.cxf().cxg()) {
                            com.baidu.tieba.frs.b.cxm().ak(u.this.agx);
                            u.this.agx.iQ(false);
                            com.baidu.tieba.frs.a.cxf().ak(u.this.agx);
                            u.this.agx.iR(false);
                        } else if (com.baidu.tieba.frs.a.cxf().aj(u.this.agx)) {
                            u.this.agx.iR(true);
                        }
                    } else if (com.baidu.tieba.frs.b.cxm().aj(u.this.agx)) {
                        u.this.agx.iQ(true);
                    }
                    u.this.tM();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921402, u.this.agx));
                }
            }
        });
        setInsertIndex(-1);
        if (context instanceof BaseActivity) {
            ((BaseActivity) context).registerListener(this.agB);
        } else if (context instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) context).registerListener(this.agB);
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        com.baidu.tbadk.core.util.ap.setBackgroundColor(this.agt, R.color.cp_bg_line_d);
        com.baidu.tbadk.core.util.ap.setBackgroundColor(this.agu, R.color.cp_bg_line_d);
        this.agv.setImageDrawable(com.baidu.tbadk.core.util.ap.getDrawable((this.agx.bol() || this.agx.bom()) ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.agw, (this.agx.bol() || this.agx.bom()) ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.d
    public void tA() {
        this.afN.a(5, this.agA);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.d
    public void tE() {
        this.afN.b(5, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: a */
    public void H(bw bwVar) {
        this.agx = bwVar;
        if (com.baidu.tieba.frs.b.cxm().cxg() || com.baidu.tieba.frs.a.cxf().cxg()) {
            this.mRootView.setVisibility(0);
            this.afN.b(new a.C0097a(4, false));
            tM();
            return;
        }
        this.afN.b(new a.C0097a(4, true));
        this.mRootView.setVisibility(8);
    }

    public void aI(boolean z) {
        this.agz = z;
    }

    public void h(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }
}

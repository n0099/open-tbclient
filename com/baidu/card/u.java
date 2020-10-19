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
    private static final int agp = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds78);
    private static final int agq = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int agr = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds12);
    private View ags;
    private View agt;
    private ImageView agu;
    private TextView agv;
    private bw agw;
    private View agx;
    private View mRootView;
    private boolean agy = false;
    private BdUniqueId mPageId = null;
    private a.b agz = new a.b() { // from class: com.baidu.card.u.1
        @Override // com.baidu.card.a.a.b
        public boolean a(a.C0097a c0097a) {
            if (u.this.agx != null && c0097a != null && (c0097a.ud() instanceof Integer)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) u.this.agx.getLayoutParams();
                layoutParams.leftMargin = (com.baidu.tbadk.a.d.bdq() ? u.agq : u.agp) + ((Integer) c0097a.ud()).intValue();
                if (!u.this.agy) {
                    layoutParams.addRule(15);
                }
                u.this.agx.setLayoutParams(layoutParams);
            }
            return false;
        }
    };
    private CustomMessageListener agA = new CustomMessageListener(2921402) { // from class: com.baidu.card.u.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bw) && ((bw) customResponsedMessage.getData()) == u.this.agw) {
                u.this.tM();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void tM() {
        int i = 4;
        if (this.agw != null) {
            this.ags.setVisibility((this.agw.bjS() || this.agw.bjT()) ? 0 : 4);
            if (this.agy) {
                this.agt.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.agx.getLayoutParams();
                layoutParams.removeRule(15);
                layoutParams.topMargin = agr;
                this.agx.setLayoutParams(layoutParams);
                this.agu.setVisibility(0);
                this.agv.setVisibility(0);
                this.agu.setImageDrawable(com.baidu.tbadk.core.util.ap.getDrawable((this.agw.bjS() || this.agw.bjT()) ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.agv, (this.agw.bjS() || this.agw.bjT()) ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
                return;
            }
            View view = this.agt;
            if (this.agw.bjS() || this.agw.bjT()) {
                i = 0;
            }
            view.setVisibility(i);
            this.agu.setVisibility(8);
            this.agv.setVisibility(8);
        }
    }

    public u(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.multi_del_decor_layout, (ViewGroup) null);
        this.ags = this.mRootView.findViewById(R.id.multi_del_mask_top_view);
        this.ags.setAlpha(0.5f);
        this.agt = this.mRootView.findViewById(R.id.multi_del_mask_bottom_view);
        this.agt.setAlpha(0.5f);
        this.agu = (ImageView) this.mRootView.findViewById(R.id.manage_select_img);
        this.agv = (TextView) this.mRootView.findViewById(R.id.manage_select_txt);
        this.agx = this.mRootView.findViewById(R.id.manage_select_container);
        H(this.mRootView);
        this.mRootView.setFocusable(true);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.u.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (u.this.agu != null && u.this.agw != null && u.this.agv != null && !u.this.agw.bjU()) {
                    if (u.this.agw.bjS() || !com.baidu.tieba.frs.b.crE().cry()) {
                        if (u.this.agw.bjT() || !com.baidu.tieba.frs.a.crx().cry()) {
                            com.baidu.tieba.frs.b.crE().ak(u.this.agw);
                            u.this.agw.iu(false);
                            com.baidu.tieba.frs.a.crx().ak(u.this.agw);
                            u.this.agw.iv(false);
                        } else if (com.baidu.tieba.frs.a.crx().aj(u.this.agw)) {
                            u.this.agw.iv(true);
                        }
                    } else if (com.baidu.tieba.frs.b.crE().aj(u.this.agw)) {
                        u.this.agw.iu(true);
                    }
                    u.this.tM();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921402, u.this.agw));
                }
            }
        });
        setInsertIndex(-1);
        if (context instanceof BaseActivity) {
            ((BaseActivity) context).registerListener(this.agA);
        } else if (context instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) context).registerListener(this.agA);
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        com.baidu.tbadk.core.util.ap.setBackgroundColor(this.ags, R.color.cp_bg_line_d);
        com.baidu.tbadk.core.util.ap.setBackgroundColor(this.agt, R.color.cp_bg_line_d);
        this.agu.setImageDrawable(com.baidu.tbadk.core.util.ap.getDrawable((this.agw.bjS() || this.agw.bjT()) ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.agv, (this.agw.bjS() || this.agw.bjT()) ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.d
    public void tA() {
        this.afM.a(5, this.agz);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.d
    public void tE() {
        this.afM.b(5, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: a */
    public void H(bw bwVar) {
        this.agw = bwVar;
        if (com.baidu.tieba.frs.b.crE().cry() || com.baidu.tieba.frs.a.crx().cry()) {
            this.mRootView.setVisibility(0);
            this.afM.b(new a.C0097a(4, false));
            tM();
            return;
        }
        this.afM.b(new a.C0097a(4, true));
        this.mRootView.setVisibility(8);
    }

    public void aI(boolean z) {
        this.agy = z;
    }

    public void h(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }
}

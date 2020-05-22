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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class r extends d implements n<bk>, o {
    private static final int adY = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds78);
    private static final int adZ = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private View aea;
    private View aeb;
    private ImageView aec;
    private TextView aed;
    private bk aee;
    private View aef;
    private View mRootView;
    private boolean aeg = false;
    private BdUniqueId mPageId = null;
    private a.b aeh = new a.b() { // from class: com.baidu.card.r.1
        @Override // com.baidu.card.a.a.b
        public boolean a(a.C0097a c0097a) {
            if (r.this.aef != null && c0097a != null && (c0097a.rS() instanceof Integer)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) r.this.aef.getLayoutParams();
                layoutParams.leftMargin = (com.baidu.tbadk.a.d.aMj() ? r.adZ : r.adY) + ((Integer) c0097a.rS()).intValue();
                r.this.aef.setLayoutParams(layoutParams);
            }
            return false;
        }
    };
    private CustomMessageListener aei = new CustomMessageListener(2921402) { // from class: com.baidu.card.r.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bk) && ((bk) customResponsedMessage.getData()) == r.this.aee) {
                r.this.rD();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void rD() {
        if (this.aee != null) {
            this.aea.setVisibility(this.aee.aSk() ? 0 : 4);
            if (this.aeg) {
                this.aeb.setVisibility(0);
                this.aec.setVisibility(0);
                this.aed.setVisibility(0);
                this.aec.setImageDrawable(com.baidu.tbadk.core.util.am.getDrawable(this.aee.aSk() ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
                com.baidu.tbadk.core.util.am.setViewTextColor(this.aed, this.aee.aSk() ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
                return;
            }
            this.aeb.setVisibility(this.aee.aSk() ? 0 : 4);
            this.aec.setVisibility(8);
            this.aed.setVisibility(8);
        }
    }

    public r(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.multi_del_decor_layout, (ViewGroup) null);
        this.aea = this.mRootView.findViewById(R.id.multi_del_mask_top_view);
        this.aea.setAlpha(0.5f);
        this.aeb = this.mRootView.findViewById(R.id.multi_del_mask_bottom_view);
        this.aeb.setAlpha(0.5f);
        this.aec = (ImageView) this.mRootView.findViewById(R.id.manage_select_img);
        this.aed = (TextView) this.mRootView.findViewById(R.id.manage_select_txt);
        this.aef = this.mRootView.findViewById(R.id.manage_select_container);
        F(this.mRootView);
        this.mRootView.setFocusable(true);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.r.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (r.this.aec != null && r.this.aee != null && r.this.aed != null && !r.this.aee.aSl()) {
                    if (!r.this.aee.aSk()) {
                        if (com.baidu.tieba.frs.a.bTX().al(r.this.aee)) {
                            r.this.aee.gS(true);
                        }
                    } else {
                        com.baidu.tieba.frs.a.bTX().am(r.this.aee);
                        r.this.aee.gS(false);
                    }
                    r.this.rD();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921402, r.this.aee));
                }
            }
        });
        setInsertIndex(-1);
        if (context instanceof BaseActivity) {
            ((BaseActivity) context).registerListener(this.aei);
        } else if (context instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) context).registerListener(this.aei);
        }
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        com.baidu.tbadk.core.util.am.setBackgroundColor(this.aea, R.color.cp_bg_line_d);
        com.baidu.tbadk.core.util.am.setBackgroundColor(this.aeb, R.color.cp_bg_line_d);
        this.aec.setImageDrawable(com.baidu.tbadk.core.util.am.getDrawable(this.aee.aSk() ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
        com.baidu.tbadk.core.util.am.setViewTextColor(this.aed, this.aee.aSk() ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.d
    public void rr() {
        this.adB.a(5, this.aeh);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.d
    public void rv() {
        this.adB.b(5, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: a */
    public void D(bk bkVar) {
        this.aee = bkVar;
        if (com.baidu.tieba.frs.a.bTX().bTY()) {
            this.mRootView.setVisibility(0);
            this.adB.b(new a.C0097a(4, false));
            rD();
            return;
        }
        this.adB.b(new a.C0097a(4, true));
        this.mRootView.setVisibility(8);
    }

    public void aE(boolean z) {
        this.aeg = z;
    }

    public void h(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }
}

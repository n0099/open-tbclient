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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class q extends d implements m<bj>, n {
    private static final int Kc = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds78);
    private View Ke;
    private View Kf;
    private ImageView Kg;
    private TextView Kh;
    private bj Ki;
    private View Kj;
    private View mRootView;
    private boolean Kk = false;
    private BdUniqueId mPageId = null;
    private a.b Kl = new a.b() { // from class: com.baidu.card.q.1
        @Override // com.baidu.card.a.a.b
        public boolean a(a.C0050a c0050a) {
            if (q.this.Kj != null && c0050a != null && (c0050a.mY() instanceof Integer)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) q.this.Kj.getLayoutParams();
                layoutParams.leftMargin = ((Integer) c0050a.mY()).intValue() + q.Kc;
                q.this.Kj.setLayoutParams(layoutParams);
            }
            return false;
        }
    };
    private CustomMessageListener Km = new CustomMessageListener(2921402) { // from class: com.baidu.card.q.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bj) && ((bj) customResponsedMessage.getData()) == q.this.Ki && q.this.Kk) {
                q.this.Ke.setVisibility(q.this.Ki.aBn() ? 0 : 4);
                q.this.onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    };

    public q(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.multi_del_decor_layout, (ViewGroup) null);
        this.Ke = this.mRootView.findViewById(R.id.multi_del_mask_top_view);
        this.Ke.setAlpha(0.5f);
        this.Kf = this.mRootView.findViewById(R.id.multi_del_mask_bottom_view);
        this.Kf.setAlpha(0.5f);
        this.Kg = (ImageView) this.mRootView.findViewById(R.id.manage_select_img);
        this.Kh = (TextView) this.mRootView.findViewById(R.id.manage_select_txt);
        this.Kj = this.mRootView.findViewById(R.id.manage_select_container);
        F(this.mRootView);
        this.mRootView.setFocusable(true);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.q.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (q.this.Kg != null && q.this.Ki != null && q.this.Kh != null && !q.this.Ki.aBo()) {
                    if (!q.this.Ki.aBn()) {
                        if (com.baidu.tieba.frs.a.bAp().af(q.this.Ki)) {
                            q.this.Ki.fq(true);
                        }
                    } else {
                        com.baidu.tieba.frs.a.bAp().ag(q.this.Ki);
                        q.this.Ki.fq(false);
                    }
                    q.this.Ke.setVisibility(q.this.Ki.aBn() ? 0 : 4);
                    q.this.Kf.setVisibility(q.this.Ki.aBn() ? 0 : 4);
                    q.this.onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921402, q.this.Ki));
                }
            }
        });
        setInsertIndex(-1);
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        am.setBackgroundColor(this.Ke, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.Kf, R.color.cp_bg_line_d);
        this.Kg.setImageDrawable(am.getDrawable(this.Ki.aBn() ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
        am.setViewTextColor(this.Kh, this.Ki.aBn() ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.d
    public void mD() {
        this.JG.a(5, this.Kl);
        if (this.mPageId != null) {
            this.Km.setTag(this.mPageId);
        }
        MessageManager.getInstance().registerListener(this.Km);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.d
    public void mH() {
        this.JG.b(5, null);
        MessageManager.getInstance().unRegisterListener(this.Km);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: a */
    public void A(bj bjVar) {
        int i = 4;
        this.Ki = bjVar;
        if (com.baidu.tieba.frs.a.bAp().bAq()) {
            this.mRootView.setVisibility(0);
            this.JG.b(new a.C0050a(4, false));
            View view = this.Ke;
            if (this.Ki.aBn() || this.Ki.aBo()) {
                i = 0;
            }
            view.setVisibility(i);
            if (this.Kk) {
                this.Kf.setVisibility(0);
                this.Kg.setVisibility(0);
                this.Kh.setVisibility(0);
                this.Kg.setImageDrawable(am.getDrawable(this.Ki.aBn() ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
                am.setViewTextColor(this.Kh, this.Ki.aBn() ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
                return;
            }
            this.Kg.setVisibility(8);
            this.Kh.setVisibility(8);
            return;
        }
        this.JG.b(new a.C0050a(4, true));
        this.mRootView.setVisibility(8);
    }

    public void aa(boolean z) {
        this.Kk = z;
    }

    public void g(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }
}

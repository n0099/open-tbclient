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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class s extends d implements n<bv>, o {
    private static final int aeu = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds78);
    private static final int aev = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private bv aeA;
    private View aeB;
    private View aew;
    private View aex;
    private ImageView aey;
    private TextView aez;
    private View mRootView;
    private boolean aeC = false;
    private BdUniqueId mPageId = null;
    private a.b aeD = new a.b() { // from class: com.baidu.card.s.1
        @Override // com.baidu.card.a.a.b
        public boolean a(a.C0096a c0096a) {
            if (s.this.aeB != null && c0096a != null && (c0096a.sm() instanceof Integer)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) s.this.aeB.getLayoutParams();
                layoutParams.leftMargin = (com.baidu.tbadk.a.d.aRB() ? s.aev : s.aeu) + ((Integer) c0096a.sm()).intValue();
                s.this.aeB.setLayoutParams(layoutParams);
            }
            return false;
        }
    };
    private CustomMessageListener aeE = new CustomMessageListener(2921402) { // from class: com.baidu.card.s.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bv) && ((bv) customResponsedMessage.getData()) == s.this.aeA) {
                s.this.rW();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void rW() {
        int i = 4;
        if (this.aeA != null) {
            this.aew.setVisibility((this.aeA.aXW() || this.aeA.aXX()) ? 0 : 4);
            if (this.aeC) {
                this.aex.setVisibility(0);
                this.aey.setVisibility(0);
                this.aez.setVisibility(0);
                this.aey.setImageDrawable(com.baidu.tbadk.core.util.ao.getDrawable((this.aeA.aXW() || this.aeA.aXX()) ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
                com.baidu.tbadk.core.util.ao.setViewTextColor(this.aez, (this.aeA.aXW() || this.aeA.aXX()) ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
                return;
            }
            View view = this.aex;
            if (this.aeA.aXW() || this.aeA.aXX()) {
                i = 0;
            }
            view.setVisibility(i);
            this.aey.setVisibility(8);
            this.aez.setVisibility(8);
        }
    }

    public s(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.multi_del_decor_layout, (ViewGroup) null);
        this.aew = this.mRootView.findViewById(R.id.multi_del_mask_top_view);
        this.aew.setAlpha(0.5f);
        this.aex = this.mRootView.findViewById(R.id.multi_del_mask_bottom_view);
        this.aex.setAlpha(0.5f);
        this.aey = (ImageView) this.mRootView.findViewById(R.id.manage_select_img);
        this.aez = (TextView) this.mRootView.findViewById(R.id.manage_select_txt);
        this.aeB = this.mRootView.findViewById(R.id.manage_select_container);
        H(this.mRootView);
        this.mRootView.setFocusable(true);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.s.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (s.this.aey != null && s.this.aeA != null && s.this.aez != null && !s.this.aeA.aXY()) {
                    if (s.this.aeA.aXW() || !com.baidu.tieba.frs.b.caw().caq()) {
                        if (s.this.aeA.aXX() || !com.baidu.tieba.frs.a.cap().caq()) {
                            com.baidu.tieba.frs.b.caw().aj(s.this.aeA);
                            s.this.aeA.hE(false);
                            com.baidu.tieba.frs.a.cap().aj(s.this.aeA);
                            s.this.aeA.hF(false);
                        } else if (com.baidu.tieba.frs.a.cap().ai(s.this.aeA)) {
                            s.this.aeA.hF(true);
                        }
                    } else if (com.baidu.tieba.frs.b.caw().ai(s.this.aeA)) {
                        s.this.aeA.hE(true);
                    }
                    s.this.rW();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921402, s.this.aeA));
                }
            }
        });
        setInsertIndex(-1);
        if (context instanceof BaseActivity) {
            ((BaseActivity) context).registerListener(this.aeE);
        } else if (context instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) context).registerListener(this.aeE);
        }
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        com.baidu.tbadk.core.util.ao.setBackgroundColor(this.aew, R.color.cp_bg_line_d);
        com.baidu.tbadk.core.util.ao.setBackgroundColor(this.aex, R.color.cp_bg_line_d);
        this.aey.setImageDrawable(com.baidu.tbadk.core.util.ao.getDrawable((this.aeA.aXW() || this.aeA.aXX()) ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.aez, (this.aeA.aXW() || this.aeA.aXX()) ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.d
    public void rK() {
        this.adV.a(5, this.aeD);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.d
    public void rO() {
        this.adV.b(5, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: a */
    public void D(bv bvVar) {
        this.aeA = bvVar;
        if (com.baidu.tieba.frs.b.caw().caq() || com.baidu.tieba.frs.a.cap().caq()) {
            this.mRootView.setVisibility(0);
            this.adV.b(new a.C0096a(4, false));
            rW();
            return;
        }
        this.adV.b(new a.C0096a(4, true));
        this.mRootView.setVisibility(8);
    }

    public void aH(boolean z) {
        this.aeC = z;
    }

    public void h(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }
}

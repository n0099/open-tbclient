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
/* loaded from: classes15.dex */
public class t extends d implements o<bw>, p {
    private static final int afF = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds78);
    private static final int afG = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private View afH;
    private View afI;
    private ImageView afJ;
    private TextView afK;
    private bw afL;
    private View afM;
    private View mRootView;
    private boolean afN = false;
    private BdUniqueId mPageId = null;
    private a.b afO = new a.b() { // from class: com.baidu.card.t.1
        @Override // com.baidu.card.a.a.b
        public boolean a(a.C0095a c0095a) {
            if (t.this.afM != null && c0095a != null && (c0095a.tX() instanceof Integer)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) t.this.afM.getLayoutParams();
                layoutParams.leftMargin = (com.baidu.tbadk.a.d.aZS() ? t.afG : t.afF) + ((Integer) c0095a.tX()).intValue();
                t.this.afM.setLayoutParams(layoutParams);
            }
            return false;
        }
    };
    private CustomMessageListener afP = new CustomMessageListener(2921402) { // from class: com.baidu.card.t.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bw) && ((bw) customResponsedMessage.getData()) == t.this.afL) {
                t.this.tH();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void tH() {
        int i = 4;
        if (this.afL != null) {
            this.afH.setVisibility((this.afL.bgp() || this.afL.bgq()) ? 0 : 4);
            if (this.afN) {
                this.afI.setVisibility(0);
                this.afJ.setVisibility(0);
                this.afK.setVisibility(0);
                this.afJ.setImageDrawable(com.baidu.tbadk.core.util.ap.getDrawable((this.afL.bgp() || this.afL.bgq()) ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.afK, (this.afL.bgp() || this.afL.bgq()) ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
                return;
            }
            View view = this.afI;
            if (this.afL.bgp() || this.afL.bgq()) {
                i = 0;
            }
            view.setVisibility(i);
            this.afJ.setVisibility(8);
            this.afK.setVisibility(8);
        }
    }

    public t(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.multi_del_decor_layout, (ViewGroup) null);
        this.afH = this.mRootView.findViewById(R.id.multi_del_mask_top_view);
        this.afH.setAlpha(0.5f);
        this.afI = this.mRootView.findViewById(R.id.multi_del_mask_bottom_view);
        this.afI.setAlpha(0.5f);
        this.afJ = (ImageView) this.mRootView.findViewById(R.id.manage_select_img);
        this.afK = (TextView) this.mRootView.findViewById(R.id.manage_select_txt);
        this.afM = this.mRootView.findViewById(R.id.manage_select_container);
        H(this.mRootView);
        this.mRootView.setFocusable(true);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.t.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (t.this.afJ != null && t.this.afL != null && t.this.afK != null && !t.this.afL.bgr()) {
                    if (t.this.afL.bgp() || !com.baidu.tieba.frs.b.ckT().ckN()) {
                        if (t.this.afL.bgq() || !com.baidu.tieba.frs.a.ckM().ckN()) {
                            com.baidu.tieba.frs.b.ckT().aj(t.this.afL);
                            t.this.afL.ib(false);
                            com.baidu.tieba.frs.a.ckM().aj(t.this.afL);
                            t.this.afL.ic(false);
                        } else if (com.baidu.tieba.frs.a.ckM().ai(t.this.afL)) {
                            t.this.afL.ic(true);
                        }
                    } else if (com.baidu.tieba.frs.b.ckT().ai(t.this.afL)) {
                        t.this.afL.ib(true);
                    }
                    t.this.tH();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921402, t.this.afL));
                }
            }
        });
        setInsertIndex(-1);
        if (context instanceof BaseActivity) {
            ((BaseActivity) context).registerListener(this.afP);
        } else if (context instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) context).registerListener(this.afP);
        }
    }

    @Override // com.baidu.card.p
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        com.baidu.tbadk.core.util.ap.setBackgroundColor(this.afH, R.color.cp_bg_line_d);
        com.baidu.tbadk.core.util.ap.setBackgroundColor(this.afI, R.color.cp_bg_line_d);
        this.afJ.setImageDrawable(com.baidu.tbadk.core.util.ap.getDrawable((this.afL.bgp() || this.afL.bgq()) ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.afK, (this.afL.bgp() || this.afL.bgq()) ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.d
    public void tv() {
        this.afd.a(5, this.afO);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.d
    public void tz() {
        this.afd.b(5, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.o
    /* renamed from: a */
    public void F(bw bwVar) {
        this.afL = bwVar;
        if (com.baidu.tieba.frs.b.ckT().ckN() || com.baidu.tieba.frs.a.ckM().ckN()) {
            this.mRootView.setVisibility(0);
            this.afd.b(new a.C0095a(4, false));
            tH();
            return;
        }
        this.afd.b(new a.C0095a(4, true));
        this.mRootView.setVisibility(8);
    }

    public void aI(boolean z) {
        this.afN = z;
    }

    public void h(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }
}

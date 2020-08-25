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
    private static final int afD = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds78);
    private static final int afE = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private View afF;
    private View afG;
    private ImageView afH;
    private TextView afI;
    private bw afJ;
    private View afK;
    private View mRootView;
    private boolean afL = false;
    private BdUniqueId mPageId = null;
    private a.b afM = new a.b() { // from class: com.baidu.card.t.1
        @Override // com.baidu.card.a.a.b
        public boolean a(a.C0095a c0095a) {
            if (t.this.afK != null && c0095a != null && (c0095a.tX() instanceof Integer)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) t.this.afK.getLayoutParams();
                layoutParams.leftMargin = (com.baidu.tbadk.a.d.aZS() ? t.afE : t.afD) + ((Integer) c0095a.tX()).intValue();
                t.this.afK.setLayoutParams(layoutParams);
            }
            return false;
        }
    };
    private CustomMessageListener afN = new CustomMessageListener(2921402) { // from class: com.baidu.card.t.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bw) && ((bw) customResponsedMessage.getData()) == t.this.afJ) {
                t.this.tH();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void tH() {
        int i = 4;
        if (this.afJ != null) {
            this.afF.setVisibility((this.afJ.bgp() || this.afJ.bgq()) ? 0 : 4);
            if (this.afL) {
                this.afG.setVisibility(0);
                this.afH.setVisibility(0);
                this.afI.setVisibility(0);
                this.afH.setImageDrawable(com.baidu.tbadk.core.util.ap.getDrawable((this.afJ.bgp() || this.afJ.bgq()) ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.afI, (this.afJ.bgp() || this.afJ.bgq()) ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
                return;
            }
            View view = this.afG;
            if (this.afJ.bgp() || this.afJ.bgq()) {
                i = 0;
            }
            view.setVisibility(i);
            this.afH.setVisibility(8);
            this.afI.setVisibility(8);
        }
    }

    public t(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.multi_del_decor_layout, (ViewGroup) null);
        this.afF = this.mRootView.findViewById(R.id.multi_del_mask_top_view);
        this.afF.setAlpha(0.5f);
        this.afG = this.mRootView.findViewById(R.id.multi_del_mask_bottom_view);
        this.afG.setAlpha(0.5f);
        this.afH = (ImageView) this.mRootView.findViewById(R.id.manage_select_img);
        this.afI = (TextView) this.mRootView.findViewById(R.id.manage_select_txt);
        this.afK = this.mRootView.findViewById(R.id.manage_select_container);
        H(this.mRootView);
        this.mRootView.setFocusable(true);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.t.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (t.this.afH != null && t.this.afJ != null && t.this.afI != null && !t.this.afJ.bgr()) {
                    if (t.this.afJ.bgp() || !com.baidu.tieba.frs.b.ckS().ckM()) {
                        if (t.this.afJ.bgq() || !com.baidu.tieba.frs.a.ckL().ckM()) {
                            com.baidu.tieba.frs.b.ckS().aj(t.this.afJ);
                            t.this.afJ.ia(false);
                            com.baidu.tieba.frs.a.ckL().aj(t.this.afJ);
                            t.this.afJ.ib(false);
                        } else if (com.baidu.tieba.frs.a.ckL().ai(t.this.afJ)) {
                            t.this.afJ.ib(true);
                        }
                    } else if (com.baidu.tieba.frs.b.ckS().ai(t.this.afJ)) {
                        t.this.afJ.ia(true);
                    }
                    t.this.tH();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921402, t.this.afJ));
                }
            }
        });
        setInsertIndex(-1);
        if (context instanceof BaseActivity) {
            ((BaseActivity) context).registerListener(this.afN);
        } else if (context instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) context).registerListener(this.afN);
        }
    }

    @Override // com.baidu.card.p
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        com.baidu.tbadk.core.util.ap.setBackgroundColor(this.afF, R.color.cp_bg_line_d);
        com.baidu.tbadk.core.util.ap.setBackgroundColor(this.afG, R.color.cp_bg_line_d);
        this.afH.setImageDrawable(com.baidu.tbadk.core.util.ap.getDrawable((this.afJ.bgp() || this.afJ.bgq()) ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.afI, (this.afJ.bgp() || this.afJ.bgq()) ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.d
    public void tv() {
        this.afb.a(5, this.afM);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.d
    public void tz() {
        this.afb.b(5, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.o
    /* renamed from: a */
    public void F(bw bwVar) {
        this.afJ = bwVar;
        if (com.baidu.tieba.frs.b.ckS().ckM() || com.baidu.tieba.frs.a.ckL().ckM()) {
            this.mRootView.setVisibility(0);
            this.afb.b(new a.C0095a(4, false));
            tH();
            return;
        }
        this.afb.b(new a.C0095a(4, true));
        this.mRootView.setVisibility(8);
    }

    public void aI(boolean z) {
        this.afL = z;
    }

    public void h(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }
}

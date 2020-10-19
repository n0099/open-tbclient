package com.baidu.card.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.card.p;
import com.baidu.card.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.m;
/* loaded from: classes21.dex */
public class BjhArticleLayout extends RelativeLayout implements View.OnClickListener, p<AbsThreadDataSupport>, q {
    private AbsThreadDataSupport afH;
    private View.OnClickListener afI;
    private aa<AbsThreadDataSupport> ahu;
    private TextView aja;
    private TbImageView ajb;
    private View ajc;
    private float ajd;
    private float aje;
    private float ajf;
    private TextView mTitle;
    private int tbds21;
    private int tbds30;

    public BjhArticleLayout(Context context) {
        this(context, null);
    }

    public BjhArticleLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ajd = l.getDimens(context, R.dimen.tbds10);
        this.tbds21 = l.getDimens(context, R.dimen.tbds21);
        this.aje = l.getDimens(context, R.dimen.tbds16);
        this.tbds30 = l.getDimens(context, R.dimen.tbds30);
        this.ajf = l.getDimens(context, R.dimen.tbds44);
        initUI();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(AbsThreadDataSupport absThreadDataSupport) {
        this.afH = absThreadDataSupport;
        bw bfG = absThreadDataSupport.bfG();
        if (bfG.isShareThread && bfG.erY != null) {
            if (bfG.erY.emx) {
                setVisibility(8);
                return;
            }
            bfG = bfG.erY.bgI();
        }
        this.mTitle.setText(bfG.getTitle());
        if (StringUtils.isNull(bfG.bkf())) {
            this.aja.setVisibility(8);
            this.ajb.setVisibility(8);
            this.ajc.setVisibility(8);
        } else {
            this.aja.setVisibility(0);
            this.ajb.setVisibility(0);
            this.ajc.setVisibility(0);
            this.ajb.startLoad(bfG.bkf(), 10, false);
        }
        m.a(this.mTitle, bfG.getId(), this.ajb.getVisibility() == 0 ? R.color.cp_cont_a : R.color.cp_cont_b, R.color.cp_cont_d);
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.bjh_article_layout, (ViewGroup) this, true);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setId(R.id.bjh_content);
        this.mTitle = (TextView) findViewById(R.id.title);
        this.mTitle.setOnClickListener(this);
        this.aja = (TextView) findViewById(R.id.icon);
        this.aja.setOnClickListener(this);
        this.ajb = (TbImageView) findViewById(R.id.cover_img);
        this.ajb.setPlaceHolder(3);
        this.ajb.setOnClickListener(this);
        this.ajc = findViewById(R.id.bottom_mask);
        this.ajc.setOnClickListener(this);
        if (this.ajb.getLayoutParams() != null) {
            this.ajb.getLayoutParams().height = (int) (((l.getEquipmentWidth(getContext()) - (2.0f * this.ajf)) / 16.0f) * 9.0f);
        }
        this.aja.setTranslationY(-this.aje);
        this.ajb.setDrawCorner(true);
        this.ajb.setConrers(15);
        this.ajb.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        com.baidu.tbadk.a.b.a.a(this.mTitle, R.dimen.tbds7, R.dimen.tbds10);
    }

    public void setSubClickListener(aa<AbsThreadDataSupport> aaVar) {
        this.ahu = aaVar;
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        this.afI = onClickListener;
    }

    public TextView getTitle() {
        return this.mTitle;
    }

    public TextView getIcon() {
        return this.aja;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.afI != null) {
            this.afI.onClick(view);
        }
        if (this.ahu != null) {
            this.ahu.a(view, this.afH);
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.afH != null && this.afH.bfG() != null) {
            m.a(this.mTitle, this.afH.bfG().getId(), this.ajb.getVisibility() == 0 ? R.color.cp_cont_a : R.color.cp_cont_b, R.color.cp_cont_d);
        }
        ap.setViewTextColor(this.aja, R.color.cp_cont_a);
        com.baidu.tbadk.core.util.e.a.bnv().oO(0).oQ(R.color.cp_mask_b_alpha42).X(this.ajd).bf(this.aja);
        com.baidu.tbadk.core.util.e.a.bnv().oO(0).j(R.color.cp_mask_b, R.color.cp_mask_b_alpha33).Z(l.getDimens(getContext(), R.dimen.tbds10)).Y(l.getDimens(getContext(), R.dimen.tbds10)).ab(l.getDimens(getContext(), R.dimen.tbds10)).aa(l.getDimens(getContext(), R.dimen.tbds10)).oW(128).bf(this.ajc);
    }
}

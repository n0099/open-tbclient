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
import com.baidu.card.m;
import com.baidu.card.n;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.z;
/* loaded from: classes8.dex */
public class BjhArticleLayout extends RelativeLayout implements View.OnClickListener, m<com.baidu.tbadk.core.data.a>, n {
    private com.baidu.tbadk.core.data.a Kc;
    private View.OnClickListener Ke;
    private z<com.baidu.tbadk.core.data.a> LD;
    private TextView MW;
    private TbImageView MX;
    private View MY;
    private float MZ;
    private float Na;
    private float Nb;
    private TextView mTitle;
    private int tbds21;
    private int tbds30;

    public BjhArticleLayout(Context context) {
        this(context, null);
    }

    public BjhArticleLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.MZ = l.getDimens(context, R.dimen.tbds10);
        this.tbds21 = l.getDimens(context, R.dimen.tbds21);
        this.Na = l.getDimens(context, R.dimen.tbds16);
        this.tbds30 = l.getDimens(context, R.dimen.tbds30);
        this.Nb = l.getDimens(context, R.dimen.tbds44);
        initUI();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void A(com.baidu.tbadk.core.data.a aVar) {
        this.Kc = aVar;
        bj aAj = aVar.aAj();
        if (aAj.isShareThread && aAj.cUe != null) {
            if (aAj.cUe.cOY) {
                setVisibility(8);
                return;
            }
            aAj = aAj.cUe.aAZ();
        }
        this.mTitle.setText(aAj.getTitle());
        if (StringUtils.isNull(aAj.aEo())) {
            this.MW.setVisibility(8);
            this.MX.setVisibility(8);
            this.MY.setVisibility(8);
        } else {
            this.MW.setVisibility(0);
            this.MX.setVisibility(0);
            this.MY.setVisibility(0);
            this.MX.startLoad(aAj.aEo(), 10, false);
        }
        com.baidu.tieba.card.l.a(this.mTitle, aAj.getId(), this.MX.getVisibility() == 0 ? R.color.cp_cont_a : R.color.cp_cont_b, (int) R.color.cp_cont_d);
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.bjh_article_layout, (ViewGroup) this, true);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setId(R.id.bjh_content);
        this.mTitle = (TextView) findViewById(R.id.title);
        this.mTitle.setOnClickListener(this);
        this.MW = (TextView) findViewById(R.id.icon);
        this.MW.setOnClickListener(this);
        this.MX = (TbImageView) findViewById(R.id.cover_img);
        this.MX.setPlaceHolder(3);
        this.MX.setOnClickListener(this);
        this.MY = findViewById(R.id.bottom_mask);
        this.MY.setOnClickListener(this);
        if (this.MX.getLayoutParams() != null) {
            this.MX.getLayoutParams().height = (int) (((l.getEquipmentWidth(getContext()) - (2.0f * this.Nb)) / 16.0f) * 9.0f);
        }
        this.MW.setTranslationY(-this.Na);
        this.MX.setDrawCorner(true);
        this.MX.setConrers(15);
        this.MX.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredHeight = getMeasuredHeight();
        if (this.MY.getLayoutParams() != null) {
            this.MY.getLayoutParams().height = measuredHeight;
        }
    }

    public void setSubClickListener(z<com.baidu.tbadk.core.data.a> zVar) {
        this.LD = zVar;
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        this.Ke = onClickListener;
    }

    public TextView getTitle() {
        return this.mTitle;
    }

    public TextView getIcon() {
        return this.MW;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.Ke != null) {
            this.Ke.onClick(view);
        }
        if (this.LD != null) {
            this.LD.a(view, this.Kc);
        }
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.Kc != null && this.Kc.aAj() != null) {
            com.baidu.tieba.card.l.a(this.mTitle, this.Kc.aAj().getId(), this.MX.getVisibility() == 0 ? R.color.cp_cont_a : R.color.cp_cont_b, (int) R.color.cp_cont_d);
        }
        am.setViewTextColor(this.MW, (int) R.color.cp_cont_a);
        com.baidu.tbadk.core.util.e.a.aHf().kB(0).kD(R.color.cp_mask_b_alpha42).af(this.MZ).aQ(this.MW);
        com.baidu.tbadk.core.util.e.a.aHf().kB(0).i(R.color.cp_mask_b, R.color.cp_mask_b_alpha33).ah(l.getDimens(getContext(), R.dimen.tbds10)).ag(l.getDimens(getContext(), R.dimen.tbds10)).aj(l.getDimens(getContext(), R.dimen.tbds10)).ai(l.getDimens(getContext(), R.dimen.tbds10)).kJ(128).aQ(this.MY);
    }
}

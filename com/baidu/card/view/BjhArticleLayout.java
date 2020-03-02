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
    private TextView MV;
    private TbImageView MW;
    private View MX;
    private float MY;
    private float MZ;
    private float Na;
    private TextView mTitle;
    private int tbds21;
    private int tbds30;

    public BjhArticleLayout(Context context) {
        this(context, null);
    }

    public BjhArticleLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.MY = l.getDimens(context, R.dimen.tbds10);
        this.tbds21 = l.getDimens(context, R.dimen.tbds21);
        this.MZ = l.getDimens(context, R.dimen.tbds16);
        this.tbds30 = l.getDimens(context, R.dimen.tbds30);
        this.Na = l.getDimens(context, R.dimen.tbds44);
        initUI();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void A(com.baidu.tbadk.core.data.a aVar) {
        this.Kc = aVar;
        bj aAg = aVar.aAg();
        if (aAg.isShareThread && aAg.cTQ != null) {
            if (aAg.cTQ.cOK) {
                setVisibility(8);
                return;
            }
            aAg = aAg.cTQ.aAW();
        }
        this.mTitle.setText(aAg.getTitle());
        if (StringUtils.isNull(aAg.aEk())) {
            this.MV.setVisibility(8);
            this.MW.setVisibility(8);
            this.MX.setVisibility(8);
        } else {
            this.MV.setVisibility(0);
            this.MW.setVisibility(0);
            this.MX.setVisibility(0);
            this.MW.startLoad(aAg.aEk(), 10, false);
        }
        com.baidu.tieba.card.l.a(this.mTitle, aAg.getId(), this.MW.getVisibility() == 0 ? R.color.cp_cont_a : R.color.cp_cont_b, (int) R.color.cp_cont_d);
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.bjh_article_layout, (ViewGroup) this, true);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setId(R.id.bjh_content);
        this.mTitle = (TextView) findViewById(R.id.title);
        this.mTitle.setOnClickListener(this);
        this.MV = (TextView) findViewById(R.id.icon);
        this.MV.setOnClickListener(this);
        this.MW = (TbImageView) findViewById(R.id.cover_img);
        this.MW.setPlaceHolder(3);
        this.MW.setOnClickListener(this);
        this.MX = findViewById(R.id.bottom_mask);
        this.MX.setOnClickListener(this);
        if (this.MW.getLayoutParams() != null) {
            this.MW.getLayoutParams().height = (int) (((l.getEquipmentWidth(getContext()) - (2.0f * this.Na)) / 16.0f) * 9.0f);
        }
        this.MV.setTranslationY(-this.MZ);
        this.MW.setDrawCorner(true);
        this.MW.setConrers(15);
        this.MW.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredHeight = getMeasuredHeight();
        if (this.MX.getLayoutParams() != null) {
            this.MX.getLayoutParams().height = measuredHeight;
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
        return this.MV;
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
        if (this.Kc != null && this.Kc.aAg() != null) {
            com.baidu.tieba.card.l.a(this.mTitle, this.Kc.aAg().getId(), this.MW.getVisibility() == 0 ? R.color.cp_cont_a : R.color.cp_cont_b, (int) R.color.cp_cont_d);
        }
        am.setViewTextColor(this.MV, (int) R.color.cp_cont_a);
        com.baidu.tbadk.core.util.f.a.aHa().kB(0).kD(R.color.cp_mask_b_alpha42).af(this.MY).aQ(this.MV);
        com.baidu.tbadk.core.util.f.a.aHa().kB(0).i(R.color.cp_mask_b, R.color.cp_mask_b_alpha33).ah(l.getDimens(getContext(), R.dimen.tbds10)).ag(l.getDimens(getContext(), R.dimen.tbds10)).aj(l.getDimens(getContext(), R.dimen.tbds10)).ai(l.getDimens(getContext(), R.dimen.tbds10)).kJ(128).aQ(this.MX);
    }
}

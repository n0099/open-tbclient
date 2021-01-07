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
import com.baidu.tbadk.a.b.b;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.elementsMaven.c;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.m;
/* loaded from: classes.dex */
public class BjhArticleLayout extends RelativeLayout implements View.OnClickListener, p<com.baidu.tbadk.core.data.a>, q {
    private com.baidu.tbadk.core.data.a ahi;
    private View.OnClickListener ahj;
    private aa<com.baidu.tbadk.core.data.a> ajj;
    private TextView akH;
    private TbImageView akI;
    private View akJ;
    private float akK;
    private float akL;
    private float akM;
    private TextView mTitle;
    private int tbds21;
    private int tbds30;

    public BjhArticleLayout(Context context) {
        this(context, null);
    }

    public BjhArticleLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akK = l.getDimens(context, R.dimen.tbds10);
        this.tbds21 = l.getDimens(context, R.dimen.tbds21);
        this.akL = l.getDimens(context, R.dimen.tbds16);
        this.tbds30 = l.getDimens(context, R.dimen.tbds30);
        this.akM = l.getDimens(context, R.dimen.tbds44);
        initUI();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void D(com.baidu.tbadk.core.data.a aVar) {
        this.ahi = aVar;
        bz boP = aVar.boP();
        if (boP.isShareThread && boP.eVB != null) {
            if (boP.eVB.ePW) {
                setVisibility(8);
                return;
            }
            boP = boP.eVB.bpR();
        }
        this.mTitle.setText(boP.getTitle());
        if (StringUtils.isNull(boP.bts())) {
            this.akH.setVisibility(8);
            this.akI.setVisibility(8);
            this.akJ.setVisibility(8);
        } else {
            this.akH.setVisibility(0);
            this.akI.setVisibility(0);
            this.akJ.setVisibility(0);
            this.akI.startLoad(boP.bts(), 10, false);
        }
        m.a(this.mTitle, boP.getId(), this.akI.getVisibility() == 0 ? R.color.CAM_X0101 : R.color.CAM_X0105, R.color.CAM_X0109);
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.bjh_article_layout, (ViewGroup) this, true);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setId(R.id.bjh_content);
        this.mTitle = (TextView) findViewById(R.id.title);
        c.bv(this.mTitle).pE(R.string.F_X01).pD(R.dimen.T_X06);
        this.mTitle.setOnClickListener(this);
        this.akH = (TextView) findViewById(R.id.icon);
        this.akH.setOnClickListener(this);
        this.akI = (TbImageView) findViewById(R.id.cover_img);
        this.akI.setPlaceHolder(3);
        this.akI.setOnClickListener(this);
        this.akJ = findViewById(R.id.bottom_mask);
        this.akJ.setOnClickListener(this);
        if (this.akI.getLayoutParams() != null) {
            this.akI.getLayoutParams().height = (int) (((l.getEquipmentWidth(getContext()) - (2.0f * this.akM)) / 16.0f) * 9.0f);
        }
        this.akH.setTranslationY(-this.akL);
        this.akI.setDrawCorner(true);
        this.akI.setConrers(15);
        this.akI.setRadiusById(R.string.J_X05);
        b.a(this.mTitle, R.dimen.tbds7, R.dimen.tbds10);
    }

    public void setSubClickListener(aa<com.baidu.tbadk.core.data.a> aaVar) {
        this.ajj = aaVar;
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        this.ahj = onClickListener;
    }

    public TextView getTitle() {
        return this.mTitle;
    }

    public TextView getIcon() {
        return this.akH;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ahj != null) {
            this.ahj.onClick(view);
        }
        if (this.ajj != null) {
            this.ajj.a(view, this.ahi);
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.ahi != null && this.ahi.boP() != null) {
            m.a(this.mTitle, this.ahi.boP().getId(), this.akI.getVisibility() == 0 ? R.color.CAM_X0101 : R.color.CAM_X0105, R.color.CAM_X0109);
        }
        ao.setViewTextColor(this.akH, R.color.CAM_X0101);
        com.baidu.tbadk.core.util.f.a.bwV().qq(0).qt(R.color.CAM_X0606).ae(this.akK).bz(this.akH);
        com.baidu.tbadk.core.util.f.a.bwV().qq(0).n(R.color.CAM_X0611, R.color.CAM_X0605).ag(l.getDimens(getContext(), R.dimen.tbds21)).af(l.getDimens(getContext(), R.dimen.tbds21)).ai(l.getDimens(getContext(), R.dimen.tbds21)).ah(l.getDimens(getContext(), R.dimen.tbds21)).qA(128).bz(this.akJ);
    }
}

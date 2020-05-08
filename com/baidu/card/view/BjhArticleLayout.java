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
    private com.baidu.tbadk.core.data.a ade;
    private View.OnClickListener adf;
    private z<com.baidu.tbadk.core.data.a> aeC;
    private TextView afK;
    private TbImageView afL;
    private View afM;
    private float afN;
    private float afO;
    private float afP;
    private TextView mTitle;
    private int tbds21;
    private int tbds30;

    public BjhArticleLayout(Context context) {
        this(context, null);
    }

    public BjhArticleLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.afN = l.getDimens(context, R.dimen.tbds10);
        this.tbds21 = l.getDimens(context, R.dimen.tbds21);
        this.afO = l.getDimens(context, R.dimen.tbds16);
        this.tbds30 = l.getDimens(context, R.dimen.tbds30);
        this.afP = l.getDimens(context, R.dimen.tbds44);
        initUI();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void B(com.baidu.tbadk.core.data.a aVar) {
        this.ade = aVar;
        bj aIu = aVar.aIu();
        if (aIu.isShareThread && aIu.dtt != null) {
            if (aIu.dtt.doi) {
                setVisibility(8);
                return;
            }
            aIu = aIu.dtt.aJk();
        }
        this.mTitle.setText(aIu.getTitle());
        if (StringUtils.isNull(aIu.aMA())) {
            this.afK.setVisibility(8);
            this.afL.setVisibility(8);
            this.afM.setVisibility(8);
        } else {
            this.afK.setVisibility(0);
            this.afL.setVisibility(0);
            this.afM.setVisibility(0);
            this.afL.startLoad(aIu.aMA(), 10, false);
        }
        com.baidu.tieba.card.l.a(this.mTitle, aIu.getId(), this.afL.getVisibility() == 0 ? R.color.cp_cont_a : R.color.cp_cont_b, (int) R.color.cp_cont_d);
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.bjh_article_layout, (ViewGroup) this, true);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setId(R.id.bjh_content);
        this.mTitle = (TextView) findViewById(R.id.title);
        this.mTitle.setOnClickListener(this);
        this.afK = (TextView) findViewById(R.id.icon);
        this.afK.setOnClickListener(this);
        this.afL = (TbImageView) findViewById(R.id.cover_img);
        this.afL.setPlaceHolder(3);
        this.afL.setOnClickListener(this);
        this.afM = findViewById(R.id.bottom_mask);
        this.afM.setOnClickListener(this);
        if (this.afL.getLayoutParams() != null) {
            this.afL.getLayoutParams().height = (int) (((l.getEquipmentWidth(getContext()) - (2.0f * this.afP)) / 16.0f) * 9.0f);
        }
        this.afK.setTranslationY(-this.afO);
        this.afL.setDrawCorner(true);
        this.afL.setConrers(15);
        this.afL.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredHeight = getMeasuredHeight();
        if (this.afM.getLayoutParams() != null) {
            this.afM.getLayoutParams().height = measuredHeight;
        }
    }

    public void setSubClickListener(z<com.baidu.tbadk.core.data.a> zVar) {
        this.aeC = zVar;
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        this.adf = onClickListener;
    }

    public TextView getTitle() {
        return this.mTitle;
    }

    public TextView getIcon() {
        return this.afK;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.adf != null) {
            this.adf.onClick(view);
        }
        if (this.aeC != null) {
            this.aeC.a(view, this.ade);
        }
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.ade != null && this.ade.aIu() != null) {
            com.baidu.tieba.card.l.a(this.mTitle, this.ade.aIu().getId(), this.afL.getVisibility() == 0 ? R.color.cp_cont_a : R.color.cp_cont_b, (int) R.color.cp_cont_d);
        }
        am.setViewTextColor(this.afK, (int) R.color.cp_cont_a);
        com.baidu.tbadk.core.util.e.a.aPr().kL(0).kN(R.color.cp_mask_b_alpha42).P(this.afN).aR(this.afK);
        com.baidu.tbadk.core.util.e.a.aPr().kL(0).j(R.color.cp_mask_b, R.color.cp_mask_b_alpha33).R(l.getDimens(getContext(), R.dimen.tbds10)).Q(l.getDimens(getContext(), R.dimen.tbds10)).T(l.getDimens(getContext(), R.dimen.tbds10)).S(l.getDimens(getContext(), R.dimen.tbds10)).kT(128).aR(this.afM);
    }
}

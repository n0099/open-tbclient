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
    private com.baidu.tbadk.core.data.a ada;
    private View.OnClickListener adb;
    private z<com.baidu.tbadk.core.data.a> aez;
    private TextView afH;
    private TbImageView afI;
    private View afJ;
    private float afK;
    private float afL;
    private float afM;
    private TextView mTitle;
    private int tbds21;
    private int tbds30;

    public BjhArticleLayout(Context context) {
        this(context, null);
    }

    public BjhArticleLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.afK = l.getDimens(context, R.dimen.tbds10);
        this.tbds21 = l.getDimens(context, R.dimen.tbds21);
        this.afL = l.getDimens(context, R.dimen.tbds16);
        this.tbds30 = l.getDimens(context, R.dimen.tbds30);
        this.afM = l.getDimens(context, R.dimen.tbds44);
        initUI();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void A(com.baidu.tbadk.core.data.a aVar) {
        this.ada = aVar;
        bj aIw = aVar.aIw();
        if (aIw.isShareThread && aIw.dto != null) {
            if (aIw.dto.doe) {
                setVisibility(8);
                return;
            }
            aIw = aIw.dto.aJm();
        }
        this.mTitle.setText(aIw.getTitle());
        if (StringUtils.isNull(aIw.aMC())) {
            this.afH.setVisibility(8);
            this.afI.setVisibility(8);
            this.afJ.setVisibility(8);
        } else {
            this.afH.setVisibility(0);
            this.afI.setVisibility(0);
            this.afJ.setVisibility(0);
            this.afI.startLoad(aIw.aMC(), 10, false);
        }
        com.baidu.tieba.card.l.a(this.mTitle, aIw.getId(), this.afI.getVisibility() == 0 ? R.color.cp_cont_a : R.color.cp_cont_b, (int) R.color.cp_cont_d);
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.bjh_article_layout, (ViewGroup) this, true);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setId(R.id.bjh_content);
        this.mTitle = (TextView) findViewById(R.id.title);
        this.mTitle.setOnClickListener(this);
        this.afH = (TextView) findViewById(R.id.icon);
        this.afH.setOnClickListener(this);
        this.afI = (TbImageView) findViewById(R.id.cover_img);
        this.afI.setPlaceHolder(3);
        this.afI.setOnClickListener(this);
        this.afJ = findViewById(R.id.bottom_mask);
        this.afJ.setOnClickListener(this);
        if (this.afI.getLayoutParams() != null) {
            this.afI.getLayoutParams().height = (int) (((l.getEquipmentWidth(getContext()) - (2.0f * this.afM)) / 16.0f) * 9.0f);
        }
        this.afH.setTranslationY(-this.afL);
        this.afI.setDrawCorner(true);
        this.afI.setConrers(15);
        this.afI.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredHeight = getMeasuredHeight();
        if (this.afJ.getLayoutParams() != null) {
            this.afJ.getLayoutParams().height = measuredHeight;
        }
    }

    public void setSubClickListener(z<com.baidu.tbadk.core.data.a> zVar) {
        this.aez = zVar;
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        this.adb = onClickListener;
    }

    public TextView getTitle() {
        return this.mTitle;
    }

    public TextView getIcon() {
        return this.afH;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.adb != null) {
            this.adb.onClick(view);
        }
        if (this.aez != null) {
            this.aez.a(view, this.ada);
        }
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.ada != null && this.ada.aIw() != null) {
            com.baidu.tieba.card.l.a(this.mTitle, this.ada.aIw().getId(), this.afI.getVisibility() == 0 ? R.color.cp_cont_a : R.color.cp_cont_b, (int) R.color.cp_cont_d);
        }
        am.setViewTextColor(this.afH, (int) R.color.cp_cont_a);
        com.baidu.tbadk.core.util.e.a.aPu().kL(0).kN(R.color.cp_mask_b_alpha42).P(this.afK).aR(this.afH);
        com.baidu.tbadk.core.util.e.a.aPu().kL(0).j(R.color.cp_mask_b, R.color.cp_mask_b_alpha33).R(l.getDimens(getContext(), R.dimen.tbds10)).Q(l.getDimens(getContext(), R.dimen.tbds10)).T(l.getDimens(getContext(), R.dimen.tbds10)).S(l.getDimens(getContext(), R.dimen.tbds10)).kT(128).aR(this.afJ);
    }
}

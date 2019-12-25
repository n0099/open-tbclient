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
import com.baidu.tbadk.core.data.a;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.z;
/* loaded from: classes5.dex */
public class BjhArticleLayout extends RelativeLayout implements View.OnClickListener, m<a>, n {
    private a JB;
    private View.OnClickListener JC;
    private z<a> Lb;
    private TextView Mo;
    private TbImageView Mp;
    private View Mq;
    private float Mr;
    private float Ms;
    private float Mt;
    private TextView mTitle;
    private int tbds21;
    private int tbds30;

    public BjhArticleLayout(Context context) {
        this(context, null);
    }

    public BjhArticleLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Mr = l.getDimens(context, R.dimen.tbds10);
        this.tbds21 = l.getDimens(context, R.dimen.tbds21);
        this.Ms = l.getDimens(context, R.dimen.tbds16);
        this.tbds30 = l.getDimens(context, R.dimen.tbds30);
        this.Mt = l.getDimens(context, R.dimen.tbds44);
        initUI();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void A(a aVar) {
        this.JB = aVar;
        bj axx = aVar.axx();
        if (axx.isShareThread && axx.cPD != null) {
            if (axx.cPD.cKv) {
                setVisibility(8);
                return;
            }
            axx = axx.cPD.ayn();
        }
        this.mTitle.setText(axx.getTitle());
        if (StringUtils.isNull(axx.aBE())) {
            this.Mo.setVisibility(8);
            this.Mp.setVisibility(8);
            this.Mq.setVisibility(8);
        } else {
            this.Mo.setVisibility(0);
            this.Mp.setVisibility(0);
            this.Mq.setVisibility(0);
            this.Mp.startLoad(axx.aBE(), 10, false);
        }
        com.baidu.tieba.card.l.a(this.mTitle, axx.getId(), this.Mp.getVisibility() == 0 ? R.color.cp_cont_a : R.color.cp_cont_b, (int) R.color.cp_cont_d);
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.bjh_article_layout, (ViewGroup) this, true);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setId(R.id.bjh_content);
        this.mTitle = (TextView) findViewById(R.id.title);
        this.mTitle.setOnClickListener(this);
        this.Mo = (TextView) findViewById(R.id.icon);
        this.Mo.setOnClickListener(this);
        this.Mp = (TbImageView) findViewById(R.id.cover_img);
        this.Mp.setPlaceHolder(3);
        this.Mp.setOnClickListener(this);
        this.Mq = findViewById(R.id.bottom_mask);
        this.Mq.setOnClickListener(this);
        if (this.Mp.getLayoutParams() != null) {
            this.Mp.getLayoutParams().height = (int) (((l.getEquipmentWidth(getContext()) - (2.0f * this.Mt)) / 16.0f) * 9.0f);
        }
        this.Mo.setTranslationY(-this.Ms);
        this.Mp.setDrawCorner(true);
        this.Mp.setConrers(15);
        this.Mp.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredHeight = getMeasuredHeight();
        if (this.Mq.getLayoutParams() != null) {
            this.Mq.getLayoutParams().height = measuredHeight;
        }
    }

    public void setSubClickListener(z<a> zVar) {
        this.Lb = zVar;
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        this.JC = onClickListener;
    }

    public TextView getTitle() {
        return this.mTitle;
    }

    public TextView getIcon() {
        return this.Mo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.JC != null) {
            this.JC.onClick(view);
        }
        if (this.Lb != null) {
            this.Lb.a(view, this.JB);
        }
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.JB != null && this.JB.axx() != null) {
            com.baidu.tieba.card.l.a(this.mTitle, this.JB.axx().getId(), this.Mp.getVisibility() == 0 ? R.color.cp_cont_a : R.color.cp_cont_b, (int) R.color.cp_cont_d);
        }
        am.setViewTextColor(this.Mo, (int) R.color.cp_cont_a);
        com.baidu.tbadk.core.util.f.a.aEt().kk(0).km(R.color.cp_mask_b_alpha42).ah(this.Mr).aM(this.Mo);
        com.baidu.tbadk.core.util.f.a.aEt().kk(0).i(R.color.cp_mask_b, R.color.cp_mask_b_alpha33).aj(l.getDimens(getContext(), R.dimen.tbds10)).ai(l.getDimens(getContext(), R.dimen.tbds10)).al(l.getDimens(getContext(), R.dimen.tbds10)).ak(l.getDimens(getContext(), R.dimen.tbds10)).ks(128).aM(this.Mq);
    }
}

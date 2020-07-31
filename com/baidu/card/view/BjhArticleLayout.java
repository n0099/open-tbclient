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
import com.baidu.card.n;
import com.baidu.card.o;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.m;
/* loaded from: classes15.dex */
public class BjhArticleLayout extends RelativeLayout implements View.OnClickListener, n<AbsThreadDataSupport>, o {
    private AbsThreadDataSupport adQ;
    private View.OnClickListener adR;
    private aa<AbsThreadDataSupport> afy;
    private TextView ahc;
    private TbImageView ahd;
    private View ahe;
    private float ahf;
    private float ahg;
    private float ahh;
    private TextView mTitle;
    private int tbds21;
    private int tbds30;

    public BjhArticleLayout(Context context) {
        this(context, null);
    }

    public BjhArticleLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ahf = l.getDimens(context, R.dimen.tbds10);
        this.tbds21 = l.getDimens(context, R.dimen.tbds21);
        this.ahg = l.getDimens(context, R.dimen.tbds16);
        this.tbds30 = l.getDimens(context, R.dimen.tbds30);
        this.ahh = l.getDimens(context, R.dimen.tbds44);
        initUI();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        this.adQ = absThreadDataSupport;
        bv aTN = absThreadDataSupport.aTN();
        if (aTN.isShareThread && aTN.dUi != null) {
            if (aTN.dUi.dOO) {
                setVisibility(8);
                return;
            }
            aTN = aTN.dUi.aUM();
        }
        this.mTitle.setText(aTN.getTitle());
        if (StringUtils.isNull(aTN.aYj())) {
            this.ahc.setVisibility(8);
            this.ahd.setVisibility(8);
            this.ahe.setVisibility(8);
        } else {
            this.ahc.setVisibility(0);
            this.ahd.setVisibility(0);
            this.ahe.setVisibility(0);
            this.ahd.startLoad(aTN.aYj(), 10, false);
        }
        m.a(this.mTitle, aTN.getId(), this.ahd.getVisibility() == 0 ? R.color.cp_cont_a : R.color.cp_cont_b, R.color.cp_cont_d);
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.bjh_article_layout, (ViewGroup) this, true);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setId(R.id.bjh_content);
        this.mTitle = (TextView) findViewById(R.id.title);
        this.mTitle.setOnClickListener(this);
        this.ahc = (TextView) findViewById(R.id.icon);
        this.ahc.setOnClickListener(this);
        this.ahd = (TbImageView) findViewById(R.id.cover_img);
        this.ahd.setPlaceHolder(3);
        this.ahd.setOnClickListener(this);
        this.ahe = findViewById(R.id.bottom_mask);
        this.ahe.setOnClickListener(this);
        if (this.ahd.getLayoutParams() != null) {
            this.ahd.getLayoutParams().height = (int) (((l.getEquipmentWidth(getContext()) - (2.0f * this.ahh)) / 16.0f) * 9.0f);
        }
        this.ahc.setTranslationY(-this.ahg);
        this.ahd.setDrawCorner(true);
        this.ahd.setConrers(15);
        this.ahd.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        com.baidu.tbadk.a.b.a.a(this.mTitle, R.dimen.tbds7, R.dimen.tbds10);
    }

    public void setSubClickListener(aa<AbsThreadDataSupport> aaVar) {
        this.afy = aaVar;
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        this.adR = onClickListener;
    }

    public TextView getTitle() {
        return this.mTitle;
    }

    public TextView getIcon() {
        return this.ahc;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.adR != null) {
            this.adR.onClick(view);
        }
        if (this.afy != null) {
            this.afy.a(view, this.adQ);
        }
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.adQ != null && this.adQ.aTN() != null) {
            m.a(this.mTitle, this.adQ.aTN().getId(), this.ahd.getVisibility() == 0 ? R.color.cp_cont_a : R.color.cp_cont_b, R.color.cp_cont_d);
        }
        ao.setViewTextColor(this.ahc, R.color.cp_cont_a);
        com.baidu.tbadk.core.util.e.a.bbr().ma(0).mc(R.color.cp_mask_b_alpha42).Q(this.ahf).aX(this.ahc);
        com.baidu.tbadk.core.util.e.a.bbr().ma(0).j(R.color.cp_mask_b, R.color.cp_mask_b_alpha33).S(l.getDimens(getContext(), R.dimen.tbds10)).R(l.getDimens(getContext(), R.dimen.tbds10)).U(l.getDimens(getContext(), R.dimen.tbds10)).T(l.getDimens(getContext(), R.dimen.tbds10)).mi(128).aX(this.ahe);
    }
}

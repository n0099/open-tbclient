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
/* loaded from: classes6.dex */
public class BjhArticleLayout extends RelativeLayout implements View.OnClickListener, m<a>, n {
    private a JH;
    private View.OnClickListener JI;
    private z<a> Lh;
    private TextView Mt;
    private TbImageView Mu;
    private View Mv;
    private float Mw;
    private float Mx;
    private float My;
    private TextView mTitle;
    private int tbds21;
    private int tbds30;

    public BjhArticleLayout(Context context) {
        this(context, null);
    }

    public BjhArticleLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Mw = l.getDimens(context, R.dimen.tbds10);
        this.tbds21 = l.getDimens(context, R.dimen.tbds21);
        this.Mx = l.getDimens(context, R.dimen.tbds16);
        this.tbds30 = l.getDimens(context, R.dimen.tbds30);
        this.My = l.getDimens(context, R.dimen.tbds44);
        initUI();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void A(a aVar) {
        this.JH = aVar;
        bj axQ = aVar.axQ();
        if (axQ.isShareThread && axQ.cPN != null) {
            if (axQ.cPN.cKG) {
                setVisibility(8);
                return;
            }
            axQ = axQ.cPN.ayG();
        }
        this.mTitle.setText(axQ.getTitle());
        if (StringUtils.isNull(axQ.aBX())) {
            this.Mt.setVisibility(8);
            this.Mu.setVisibility(8);
            this.Mv.setVisibility(8);
        } else {
            this.Mt.setVisibility(0);
            this.Mu.setVisibility(0);
            this.Mv.setVisibility(0);
            this.Mu.startLoad(axQ.aBX(), 10, false);
        }
        com.baidu.tieba.card.l.a(this.mTitle, axQ.getId(), this.Mu.getVisibility() == 0 ? R.color.cp_cont_a : R.color.cp_cont_b, (int) R.color.cp_cont_d);
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.bjh_article_layout, (ViewGroup) this, true);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setId(R.id.bjh_content);
        this.mTitle = (TextView) findViewById(R.id.title);
        this.mTitle.setOnClickListener(this);
        this.Mt = (TextView) findViewById(R.id.icon);
        this.Mt.setOnClickListener(this);
        this.Mu = (TbImageView) findViewById(R.id.cover_img);
        this.Mu.setPlaceHolder(3);
        this.Mu.setOnClickListener(this);
        this.Mv = findViewById(R.id.bottom_mask);
        this.Mv.setOnClickListener(this);
        if (this.Mu.getLayoutParams() != null) {
            this.Mu.getLayoutParams().height = (int) (((l.getEquipmentWidth(getContext()) - (2.0f * this.My)) / 16.0f) * 9.0f);
        }
        this.Mt.setTranslationY(-this.Mx);
        this.Mu.setDrawCorner(true);
        this.Mu.setConrers(15);
        this.Mu.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredHeight = getMeasuredHeight();
        if (this.Mv.getLayoutParams() != null) {
            this.Mv.getLayoutParams().height = measuredHeight;
        }
    }

    public void setSubClickListener(z<a> zVar) {
        this.Lh = zVar;
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        this.JI = onClickListener;
    }

    public TextView getTitle() {
        return this.mTitle;
    }

    public TextView getIcon() {
        return this.Mt;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.JI != null) {
            this.JI.onClick(view);
        }
        if (this.Lh != null) {
            this.Lh.a(view, this.JH);
        }
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.JH != null && this.JH.axQ() != null) {
            com.baidu.tieba.card.l.a(this.mTitle, this.JH.axQ().getId(), this.Mu.getVisibility() == 0 ? R.color.cp_cont_a : R.color.cp_cont_b, (int) R.color.cp_cont_d);
        }
        am.setViewTextColor(this.Mt, (int) R.color.cp_cont_a);
        com.baidu.tbadk.core.util.f.a.aEM().kk(0).km(R.color.cp_mask_b_alpha42).ag(this.Mw).aQ(this.Mt);
        com.baidu.tbadk.core.util.f.a.aEM().kk(0).i(R.color.cp_mask_b, R.color.cp_mask_b_alpha33).ai(l.getDimens(getContext(), R.dimen.tbds10)).ah(l.getDimens(getContext(), R.dimen.tbds10)).ak(l.getDimens(getContext(), R.dimen.tbds10)).aj(l.getDimens(getContext(), R.dimen.tbds10)).ks(128).aQ(this.Mv);
    }
}

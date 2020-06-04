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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.m;
/* loaded from: classes8.dex */
public class BjhArticleLayout extends RelativeLayout implements View.OnClickListener, n<AbsThreadDataSupport>, o {
    private AbsThreadDataSupport adw;
    private View.OnClickListener adx;
    private aa<AbsThreadDataSupport> aeY;
    private TextView agh;
    private TbImageView agi;
    private View agj;
    private float agk;
    private float agl;
    private float agm;
    private TextView mTitle;
    private int tbds21;
    private int tbds30;

    public BjhArticleLayout(Context context) {
        this(context, null);
    }

    public BjhArticleLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.agk = l.getDimens(context, R.dimen.tbds10);
        this.tbds21 = l.getDimens(context, R.dimen.tbds21);
        this.agl = l.getDimens(context, R.dimen.tbds16);
        this.tbds30 = l.getDimens(context, R.dimen.tbds30);
        this.agm = l.getDimens(context, R.dimen.tbds44);
        initUI();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        this.adw = absThreadDataSupport;
        bk aOi = absThreadDataSupport.aOi();
        if (aOi.isShareThread && aOi.dHm != null) {
            if (aOi.dHm.dCi) {
                setVisibility(8);
                return;
            }
            aOi = aOi.dHm.aPf();
        }
        this.mTitle.setText(aOi.getTitle());
        if (StringUtils.isNull(aOi.aSz())) {
            this.agh.setVisibility(8);
            this.agi.setVisibility(8);
            this.agj.setVisibility(8);
        } else {
            this.agh.setVisibility(0);
            this.agi.setVisibility(0);
            this.agj.setVisibility(0);
            this.agi.startLoad(aOi.aSz(), 10, false);
        }
        m.a(this.mTitle, aOi.getId(), this.agi.getVisibility() == 0 ? R.color.cp_cont_a : R.color.cp_cont_b, (int) R.color.cp_cont_d);
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.bjh_article_layout, (ViewGroup) this, true);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setId(R.id.bjh_content);
        this.mTitle = (TextView) findViewById(R.id.title);
        this.mTitle.setOnClickListener(this);
        this.agh = (TextView) findViewById(R.id.icon);
        this.agh.setOnClickListener(this);
        this.agi = (TbImageView) findViewById(R.id.cover_img);
        this.agi.setPlaceHolder(3);
        this.agi.setOnClickListener(this);
        this.agj = findViewById(R.id.bottom_mask);
        this.agj.setOnClickListener(this);
        if (this.agi.getLayoutParams() != null) {
            this.agi.getLayoutParams().height = (int) (((l.getEquipmentWidth(getContext()) - (2.0f * this.agm)) / 16.0f) * 9.0f);
        }
        this.agh.setTranslationY(-this.agl);
        this.agi.setDrawCorner(true);
        this.agi.setConrers(15);
        this.agi.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredHeight = getMeasuredHeight();
        if (this.agj.getLayoutParams() != null) {
            this.agj.getLayoutParams().height = measuredHeight;
        }
    }

    public void setSubClickListener(aa<AbsThreadDataSupport> aaVar) {
        this.aeY = aaVar;
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        this.adx = onClickListener;
    }

    public TextView getTitle() {
        return this.mTitle;
    }

    public TextView getIcon() {
        return this.agh;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.adx != null) {
            this.adx.onClick(view);
        }
        if (this.aeY != null) {
            this.aeY.a(view, this.adw);
        }
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.adw != null && this.adw.aOi() != null) {
            m.a(this.mTitle, this.adw.aOi().getId(), this.agi.getVisibility() == 0 ? R.color.cp_cont_a : R.color.cp_cont_b, (int) R.color.cp_cont_d);
        }
        am.setViewTextColor(this.agh, (int) R.color.cp_cont_a);
        com.baidu.tbadk.core.util.e.a.aVw().lp(0).lr(R.color.cp_mask_b_alpha42).O(this.agk).aR(this.agh);
        com.baidu.tbadk.core.util.e.a.aVw().lp(0).j(R.color.cp_mask_b, R.color.cp_mask_b_alpha33).Q(l.getDimens(getContext(), R.dimen.tbds10)).P(l.getDimens(getContext(), R.dimen.tbds10)).S(l.getDimens(getContext(), R.dimen.tbds10)).R(l.getDimens(getContext(), R.dimen.tbds10)).lx(128).aR(this.agj);
    }
}

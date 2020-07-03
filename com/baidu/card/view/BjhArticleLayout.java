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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.m;
/* loaded from: classes8.dex */
public class BjhArticleLayout extends RelativeLayout implements View.OnClickListener, n<AbsThreadDataSupport>, o {
    private AbsThreadDataSupport aea;
    private View.OnClickListener aeb;
    private aa<AbsThreadDataSupport> afH;
    private TextView ahl;
    private TbImageView ahm;
    private View ahn;
    private float aho;
    private float ahp;
    private float ahq;
    private TextView mTitle;
    private int tbds21;
    private int tbds30;

    public BjhArticleLayout(Context context) {
        this(context, null);
    }

    public BjhArticleLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aho = l.getDimens(context, R.dimen.tbds10);
        this.tbds21 = l.getDimens(context, R.dimen.tbds21);
        this.ahp = l.getDimens(context, R.dimen.tbds16);
        this.tbds30 = l.getDimens(context, R.dimen.tbds30);
        this.ahq = l.getDimens(context, R.dimen.tbds44);
        initUI();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        this.aea = absThreadDataSupport;
        bu aPS = absThreadDataSupport.aPS();
        if (aPS.isShareThread && aPS.dNX != null) {
            if (aPS.dNX.dID) {
                setVisibility(8);
                return;
            }
            aPS = aPS.dNX.aQQ();
        }
        this.mTitle.setText(aPS.getTitle());
        if (StringUtils.isNull(aPS.aUo())) {
            this.ahl.setVisibility(8);
            this.ahm.setVisibility(8);
            this.ahn.setVisibility(8);
        } else {
            this.ahl.setVisibility(0);
            this.ahm.setVisibility(0);
            this.ahn.setVisibility(0);
            this.ahm.startLoad(aPS.aUo(), 10, false);
        }
        m.a(this.mTitle, aPS.getId(), this.ahm.getVisibility() == 0 ? R.color.cp_cont_a : R.color.cp_cont_b, (int) R.color.cp_cont_d);
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.bjh_article_layout, (ViewGroup) this, true);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setId(R.id.bjh_content);
        this.mTitle = (TextView) findViewById(R.id.title);
        this.mTitle.setOnClickListener(this);
        this.ahl = (TextView) findViewById(R.id.icon);
        this.ahl.setOnClickListener(this);
        this.ahm = (TbImageView) findViewById(R.id.cover_img);
        this.ahm.setPlaceHolder(3);
        this.ahm.setOnClickListener(this);
        this.ahn = findViewById(R.id.bottom_mask);
        this.ahn.setOnClickListener(this);
        if (this.ahm.getLayoutParams() != null) {
            this.ahm.getLayoutParams().height = (int) (((l.getEquipmentWidth(getContext()) - (2.0f * this.ahq)) / 16.0f) * 9.0f);
        }
        this.ahl.setTranslationY(-this.ahp);
        this.ahm.setDrawCorner(true);
        this.ahm.setConrers(15);
        this.ahm.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredHeight = getMeasuredHeight();
        if (this.ahn.getLayoutParams() != null) {
            this.ahn.getLayoutParams().height = measuredHeight;
        }
    }

    public void setSubClickListener(aa<AbsThreadDataSupport> aaVar) {
        this.afH = aaVar;
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        this.aeb = onClickListener;
    }

    public TextView getTitle() {
        return this.mTitle;
    }

    public TextView getIcon() {
        return this.ahl;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aeb != null) {
            this.aeb.onClick(view);
        }
        if (this.afH != null) {
            this.afH.a(view, this.aea);
        }
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.aea != null && this.aea.aPS() != null) {
            m.a(this.mTitle, this.aea.aPS().getId(), this.ahm.getVisibility() == 0 ? R.color.cp_cont_a : R.color.cp_cont_b, (int) R.color.cp_cont_d);
        }
        an.setViewTextColor(this.ahl, (int) R.color.cp_cont_a);
        com.baidu.tbadk.core.util.e.a.aXq().lG(0).lI(R.color.cp_mask_b_alpha42).Q(this.aho).aR(this.ahl);
        com.baidu.tbadk.core.util.e.a.aXq().lG(0).j(R.color.cp_mask_b, R.color.cp_mask_b_alpha33).S(l.getDimens(getContext(), R.dimen.tbds10)).R(l.getDimens(getContext(), R.dimen.tbds10)).U(l.getDimens(getContext(), R.dimen.tbds10)).T(l.getDimens(getContext(), R.dimen.tbds10)).lO(128).aR(this.ahn);
    }
}

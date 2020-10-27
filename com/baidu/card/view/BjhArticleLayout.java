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
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.n;
/* loaded from: classes21.dex */
public class BjhArticleLayout extends RelativeLayout implements View.OnClickListener, p<AbsThreadDataSupport>, q {
    private AbsThreadDataSupport afI;
    private View.OnClickListener afJ;
    private ab<AbsThreadDataSupport> ahv;
    private TextView ajb;
    private TbImageView ajc;
    private View ajd;
    private float aje;
    private float ajf;
    private float ajg;
    private TextView mTitle;
    private int tbds21;
    private int tbds30;

    public BjhArticleLayout(Context context) {
        this(context, null);
    }

    public BjhArticleLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aje = l.getDimens(context, R.dimen.tbds10);
        this.tbds21 = l.getDimens(context, R.dimen.tbds21);
        this.ajf = l.getDimens(context, R.dimen.tbds16);
        this.tbds30 = l.getDimens(context, R.dimen.tbds30);
        this.ajg = l.getDimens(context, R.dimen.tbds44);
        initUI();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(AbsThreadDataSupport absThreadDataSupport) {
        this.afI = absThreadDataSupport;
        bw bhz = absThreadDataSupport.bhz();
        if (bhz.isShareThread && bhz.eAy != null) {
            if (bhz.eAy.euX) {
                setVisibility(8);
                return;
            }
            bhz = bhz.eAy.biB();
        }
        this.mTitle.setText(bhz.getTitle());
        if (StringUtils.isNull(bhz.blY())) {
            this.ajb.setVisibility(8);
            this.ajc.setVisibility(8);
            this.ajd.setVisibility(8);
        } else {
            this.ajb.setVisibility(0);
            this.ajc.setVisibility(0);
            this.ajd.setVisibility(0);
            this.ajc.startLoad(bhz.blY(), 10, false);
        }
        n.a(this.mTitle, bhz.getId(), this.ajc.getVisibility() == 0 ? R.color.cp_cont_a : R.color.cp_cont_b, R.color.cp_cont_d);
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.bjh_article_layout, (ViewGroup) this, true);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setId(R.id.bjh_content);
        this.mTitle = (TextView) findViewById(R.id.title);
        this.mTitle.setOnClickListener(this);
        this.ajb = (TextView) findViewById(R.id.icon);
        this.ajb.setOnClickListener(this);
        this.ajc = (TbImageView) findViewById(R.id.cover_img);
        this.ajc.setPlaceHolder(3);
        this.ajc.setOnClickListener(this);
        this.ajd = findViewById(R.id.bottom_mask);
        this.ajd.setOnClickListener(this);
        if (this.ajc.getLayoutParams() != null) {
            this.ajc.getLayoutParams().height = (int) (((l.getEquipmentWidth(getContext()) - (2.0f * this.ajg)) / 16.0f) * 9.0f);
        }
        this.ajb.setTranslationY(-this.ajf);
        this.ajc.setDrawCorner(true);
        this.ajc.setConrers(15);
        this.ajc.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        com.baidu.tbadk.a.b.a.a(this.mTitle, R.dimen.tbds7, R.dimen.tbds10);
    }

    public void setSubClickListener(ab<AbsThreadDataSupport> abVar) {
        this.ahv = abVar;
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        this.afJ = onClickListener;
    }

    public TextView getTitle() {
        return this.mTitle;
    }

    public TextView getIcon() {
        return this.ajb;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.afJ != null) {
            this.afJ.onClick(view);
        }
        if (this.ahv != null) {
            this.ahv.a(view, this.afI);
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.afI != null && this.afI.bhz() != null) {
            n.a(this.mTitle, this.afI.bhz().getId(), this.ajc.getVisibility() == 0 ? R.color.cp_cont_a : R.color.cp_cont_b, R.color.cp_cont_d);
        }
        ap.setViewTextColor(this.ajb, R.color.cp_cont_a);
        com.baidu.tbadk.core.util.e.a.bpo().oZ(0).pb(R.color.cp_mask_b_alpha42).Z(this.aje).bg(this.ajb);
        com.baidu.tbadk.core.util.e.a.bpo().oZ(0).j(R.color.cp_mask_b, R.color.cp_mask_b_alpha33).ab(l.getDimens(getContext(), R.dimen.tbds10)).aa(l.getDimens(getContext(), R.dimen.tbds10)).ad(l.getDimens(getContext(), R.dimen.tbds10)).ac(l.getDimens(getContext(), R.dimen.tbds10)).ph(128).bg(this.ajd);
    }
}

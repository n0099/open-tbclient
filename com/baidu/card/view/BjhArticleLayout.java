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
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.m;
/* loaded from: classes20.dex */
public class BjhArticleLayout extends RelativeLayout implements View.OnClickListener, p<AbsThreadDataSupport>, q {
    private AbsThreadDataSupport afq;
    private View.OnClickListener afr;
    private aa<AbsThreadDataSupport> ahd;
    private TextView aiI;
    private TbImageView aiJ;
    private View aiK;
    private float aiL;
    private float aiM;
    private float aiN;
    private TextView mTitle;
    private int tbds21;
    private int tbds30;

    public BjhArticleLayout(Context context) {
        this(context, null);
    }

    public BjhArticleLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aiL = l.getDimens(context, R.dimen.tbds10);
        this.tbds21 = l.getDimens(context, R.dimen.tbds21);
        this.aiM = l.getDimens(context, R.dimen.tbds16);
        this.tbds30 = l.getDimens(context, R.dimen.tbds30);
        this.aiN = l.getDimens(context, R.dimen.tbds44);
        initUI();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void G(AbsThreadDataSupport absThreadDataSupport) {
        this.afq = absThreadDataSupport;
        bw bcY = absThreadDataSupport.bcY();
        if (bcY.isShareThread && bcY.efS != null) {
            if (bcY.efS.eav) {
                setVisibility(8);
                return;
            }
            bcY = bcY.efS.bdZ();
        }
        this.mTitle.setText(bcY.getTitle());
        if (StringUtils.isNull(bcY.bhw())) {
            this.aiI.setVisibility(8);
            this.aiJ.setVisibility(8);
            this.aiK.setVisibility(8);
        } else {
            this.aiI.setVisibility(0);
            this.aiJ.setVisibility(0);
            this.aiK.setVisibility(0);
            this.aiJ.startLoad(bcY.bhw(), 10, false);
        }
        m.a(this.mTitle, bcY.getId(), this.aiJ.getVisibility() == 0 ? R.color.cp_cont_a : R.color.cp_cont_b, R.color.cp_cont_d);
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.bjh_article_layout, (ViewGroup) this, true);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setId(R.id.bjh_content);
        this.mTitle = (TextView) findViewById(R.id.title);
        this.mTitle.setOnClickListener(this);
        this.aiI = (TextView) findViewById(R.id.icon);
        this.aiI.setOnClickListener(this);
        this.aiJ = (TbImageView) findViewById(R.id.cover_img);
        this.aiJ.setPlaceHolder(3);
        this.aiJ.setOnClickListener(this);
        this.aiK = findViewById(R.id.bottom_mask);
        this.aiK.setOnClickListener(this);
        if (this.aiJ.getLayoutParams() != null) {
            this.aiJ.getLayoutParams().height = (int) (((l.getEquipmentWidth(getContext()) - (2.0f * this.aiN)) / 16.0f) * 9.0f);
        }
        this.aiI.setTranslationY(-this.aiM);
        this.aiJ.setDrawCorner(true);
        this.aiJ.setConrers(15);
        this.aiJ.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        com.baidu.tbadk.a.b.a.a(this.mTitle, R.dimen.tbds7, R.dimen.tbds10);
    }

    public void setSubClickListener(aa<AbsThreadDataSupport> aaVar) {
        this.ahd = aaVar;
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        this.afr = onClickListener;
    }

    public TextView getTitle() {
        return this.mTitle;
    }

    public TextView getIcon() {
        return this.aiI;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.afr != null) {
            this.afr.onClick(view);
        }
        if (this.ahd != null) {
            this.ahd.a(view, this.afq);
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.afq != null && this.afq.bcY() != null) {
            m.a(this.mTitle, this.afq.bcY().getId(), this.aiJ.getVisibility() == 0 ? R.color.cp_cont_a : R.color.cp_cont_b, R.color.cp_cont_d);
        }
        ap.setViewTextColor(this.aiI, R.color.cp_cont_a);
        com.baidu.tbadk.core.util.e.a.bkL().oq(0).os(R.color.cp_mask_b_alpha42).V(this.aiL).bb(this.aiI);
        com.baidu.tbadk.core.util.e.a.bkL().oq(0).j(R.color.cp_mask_b, R.color.cp_mask_b_alpha33).X(l.getDimens(getContext(), R.dimen.tbds10)).W(l.getDimens(getContext(), R.dimen.tbds10)).Z(l.getDimens(getContext(), R.dimen.tbds10)).Y(l.getDimens(getContext(), R.dimen.tbds10)).oy(128).bb(this.aiK);
    }
}

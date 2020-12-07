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
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.elementsMaven.c;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.n;
/* loaded from: classes21.dex */
public class BjhArticleLayout extends RelativeLayout implements View.OnClickListener, p<com.baidu.tbadk.core.data.a>, q {
    private com.baidu.tbadk.core.data.a agJ;
    private View.OnClickListener agK;
    private ab<com.baidu.tbadk.core.data.a> aix;
    private TextView akf;
    private TbImageView akg;
    private View akh;
    private float aki;
    private float akj;
    private float akk;
    private TextView mTitle;
    private int tbds21;
    private int tbds30;

    public BjhArticleLayout(Context context) {
        this(context, null);
    }

    public BjhArticleLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aki = l.getDimens(context, R.dimen.tbds10);
        this.tbds21 = l.getDimens(context, R.dimen.tbds21);
        this.akj = l.getDimens(context, R.dimen.tbds16);
        this.tbds30 = l.getDimens(context, R.dimen.tbds30);
        this.akk = l.getDimens(context, R.dimen.tbds44);
        initUI();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(com.baidu.tbadk.core.data.a aVar) {
        this.agJ = aVar;
        by bmn = aVar.bmn();
        if (bmn.isShareThread && bmn.eLH != null) {
            if (bmn.eLH.eGg) {
                setVisibility(8);
                return;
            }
            bmn = bmn.eLH.bnq();
        }
        this.mTitle.setText(bmn.getTitle());
        if (StringUtils.isNull(bmn.bqP())) {
            this.akf.setVisibility(8);
            this.akg.setVisibility(8);
            this.akh.setVisibility(8);
        } else {
            this.akf.setVisibility(0);
            this.akg.setVisibility(0);
            this.akh.setVisibility(0);
            this.akg.startLoad(bmn.bqP(), 10, false);
        }
        n.a(this.mTitle, bmn.getId(), this.akg.getVisibility() == 0 ? R.color.CAM_X0101 : R.color.CAM_X0105, R.color.CAM_X0109);
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.bjh_article_layout, (ViewGroup) this, true);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setId(R.id.bjh_content);
        this.mTitle = (TextView) findViewById(R.id.title);
        c.bm(this.mTitle).pu(R.string.F_X01).pt(R.dimen.T_X06);
        this.mTitle.setOnClickListener(this);
        this.akf = (TextView) findViewById(R.id.icon);
        this.akf.setOnClickListener(this);
        this.akg = (TbImageView) findViewById(R.id.cover_img);
        this.akg.setPlaceHolder(3);
        this.akg.setOnClickListener(this);
        this.akh = findViewById(R.id.bottom_mask);
        this.akh.setOnClickListener(this);
        if (this.akg.getLayoutParams() != null) {
            this.akg.getLayoutParams().height = (int) (((l.getEquipmentWidth(getContext()) - (2.0f * this.akk)) / 16.0f) * 9.0f);
        }
        this.akf.setTranslationY(-this.akj);
        this.akg.setDrawCorner(true);
        this.akg.setConrers(15);
        this.akg.setRadiusById(R.string.J_X05);
        com.baidu.tbadk.a.b.a.a(this.mTitle, R.dimen.tbds7, R.dimen.tbds10);
    }

    public void setSubClickListener(ab<com.baidu.tbadk.core.data.a> abVar) {
        this.aix = abVar;
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        this.agK = onClickListener;
    }

    public TextView getTitle() {
        return this.mTitle;
    }

    public TextView getIcon() {
        return this.akf;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.agK != null) {
            this.agK.onClick(view);
        }
        if (this.aix != null) {
            this.aix.a(view, this.agJ);
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.agJ != null && this.agJ.bmn() != null) {
            n.a(this.mTitle, this.agJ.bmn().getId(), this.akg.getVisibility() == 0 ? R.color.CAM_X0101 : R.color.CAM_X0105, R.color.CAM_X0109);
        }
        ap.setViewTextColor(this.akf, R.color.CAM_X0101);
        com.baidu.tbadk.core.util.e.a.buz().qf(0).qi(R.color.CAM_X0606).ac(this.aki).bq(this.akf);
        com.baidu.tbadk.core.util.e.a.buz().qf(0).m(R.color.CAM_X0611, R.color.CAM_X0605).ae(l.getDimens(getContext(), R.dimen.tbds21)).ad(l.getDimens(getContext(), R.dimen.tbds21)).ag(l.getDimens(getContext(), R.dimen.tbds21)).af(l.getDimens(getContext(), R.dimen.tbds21)).qp(128).bq(this.akh);
    }
}

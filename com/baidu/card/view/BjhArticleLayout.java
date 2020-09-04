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
import com.baidu.card.o;
import com.baidu.card.p;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.m;
/* loaded from: classes15.dex */
public class BjhArticleLayout extends RelativeLayout implements View.OnClickListener, o<AbsThreadDataSupport>, p {
    private AbsThreadDataSupport aeY;
    private View.OnClickListener aeZ;
    private aa<AbsThreadDataSupport> agK;
    private TextView aio;
    private TbImageView aip;
    private View aiq;
    private float air;
    private float ais;
    private float ait;
    private TextView mTitle;
    private int tbds21;
    private int tbds30;

    public BjhArticleLayout(Context context) {
        this(context, null);
    }

    public BjhArticleLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.air = l.getDimens(context, R.dimen.tbds10);
        this.tbds21 = l.getDimens(context, R.dimen.tbds21);
        this.ais = l.getDimens(context, R.dimen.tbds16);
        this.tbds30 = l.getDimens(context, R.dimen.tbds30);
        this.ait = l.getDimens(context, R.dimen.tbds44);
        initUI();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.o
    /* renamed from: b */
    public void F(AbsThreadDataSupport absThreadDataSupport) {
        this.aeY = absThreadDataSupport;
        bw bce = absThreadDataSupport.bce();
        if (bce.isShareThread && bce.edI != null) {
            if (bce.edI.dYl) {
                setVisibility(8);
                return;
            }
            bce = bce.edI.bdf();
        }
        this.mTitle.setText(bce.getTitle());
        if (StringUtils.isNull(bce.bgC())) {
            this.aio.setVisibility(8);
            this.aip.setVisibility(8);
            this.aiq.setVisibility(8);
        } else {
            this.aio.setVisibility(0);
            this.aip.setVisibility(0);
            this.aiq.setVisibility(0);
            this.aip.startLoad(bce.bgC(), 10, false);
        }
        m.a(this.mTitle, bce.getId(), this.aip.getVisibility() == 0 ? R.color.cp_cont_a : R.color.cp_cont_b, R.color.cp_cont_d);
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.bjh_article_layout, (ViewGroup) this, true);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setId(R.id.bjh_content);
        this.mTitle = (TextView) findViewById(R.id.title);
        this.mTitle.setOnClickListener(this);
        this.aio = (TextView) findViewById(R.id.icon);
        this.aio.setOnClickListener(this);
        this.aip = (TbImageView) findViewById(R.id.cover_img);
        this.aip.setPlaceHolder(3);
        this.aip.setOnClickListener(this);
        this.aiq = findViewById(R.id.bottom_mask);
        this.aiq.setOnClickListener(this);
        if (this.aip.getLayoutParams() != null) {
            this.aip.getLayoutParams().height = (int) (((l.getEquipmentWidth(getContext()) - (2.0f * this.ait)) / 16.0f) * 9.0f);
        }
        this.aio.setTranslationY(-this.ais);
        this.aip.setDrawCorner(true);
        this.aip.setConrers(15);
        this.aip.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        com.baidu.tbadk.a.b.a.a(this.mTitle, R.dimen.tbds7, R.dimen.tbds10);
    }

    public void setSubClickListener(aa<AbsThreadDataSupport> aaVar) {
        this.agK = aaVar;
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        this.aeZ = onClickListener;
    }

    public TextView getTitle() {
        return this.mTitle;
    }

    public TextView getIcon() {
        return this.aio;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aeZ != null) {
            this.aeZ.onClick(view);
        }
        if (this.agK != null) {
            this.agK.a(view, this.aeY);
        }
    }

    @Override // com.baidu.card.p
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.aeY != null && this.aeY.bce() != null) {
            m.a(this.mTitle, this.aeY.bce().getId(), this.aip.getVisibility() == 0 ? R.color.cp_cont_a : R.color.cp_cont_b, R.color.cp_cont_d);
        }
        ap.setViewTextColor(this.aio, R.color.cp_cont_a);
        com.baidu.tbadk.core.util.e.a.bjQ().oe(0).og(R.color.cp_mask_b_alpha42).V(this.air).aZ(this.aio);
        com.baidu.tbadk.core.util.e.a.bjQ().oe(0).j(R.color.cp_mask_b, R.color.cp_mask_b_alpha33).X(l.getDimens(getContext(), R.dimen.tbds10)).W(l.getDimens(getContext(), R.dimen.tbds10)).Z(l.getDimens(getContext(), R.dimen.tbds10)).Y(l.getDimens(getContext(), R.dimen.tbds10)).om(128).aZ(this.aiq);
    }
}

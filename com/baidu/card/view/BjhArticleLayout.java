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
    private AbsThreadDataSupport aeW;
    private View.OnClickListener aeX;
    private aa<AbsThreadDataSupport> agI;
    private TextView aim;
    private TbImageView ain;
    private View aio;
    private float aip;
    private float aiq;
    private float air;
    private TextView mTitle;
    private int tbds21;
    private int tbds30;

    public BjhArticleLayout(Context context) {
        this(context, null);
    }

    public BjhArticleLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aip = l.getDimens(context, R.dimen.tbds10);
        this.tbds21 = l.getDimens(context, R.dimen.tbds21);
        this.aiq = l.getDimens(context, R.dimen.tbds16);
        this.tbds30 = l.getDimens(context, R.dimen.tbds30);
        this.air = l.getDimens(context, R.dimen.tbds44);
        initUI();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.o
    /* renamed from: b */
    public void F(AbsThreadDataSupport absThreadDataSupport) {
        this.aeW = absThreadDataSupport;
        bw bce = absThreadDataSupport.bce();
        if (bce.isShareThread && bce.edE != null) {
            if (bce.edE.dYh) {
                setVisibility(8);
                return;
            }
            bce = bce.edE.bdf();
        }
        this.mTitle.setText(bce.getTitle());
        if (StringUtils.isNull(bce.bgC())) {
            this.aim.setVisibility(8);
            this.ain.setVisibility(8);
            this.aio.setVisibility(8);
        } else {
            this.aim.setVisibility(0);
            this.ain.setVisibility(0);
            this.aio.setVisibility(0);
            this.ain.startLoad(bce.bgC(), 10, false);
        }
        m.a(this.mTitle, bce.getId(), this.ain.getVisibility() == 0 ? R.color.cp_cont_a : R.color.cp_cont_b, R.color.cp_cont_d);
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.bjh_article_layout, (ViewGroup) this, true);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setId(R.id.bjh_content);
        this.mTitle = (TextView) findViewById(R.id.title);
        this.mTitle.setOnClickListener(this);
        this.aim = (TextView) findViewById(R.id.icon);
        this.aim.setOnClickListener(this);
        this.ain = (TbImageView) findViewById(R.id.cover_img);
        this.ain.setPlaceHolder(3);
        this.ain.setOnClickListener(this);
        this.aio = findViewById(R.id.bottom_mask);
        this.aio.setOnClickListener(this);
        if (this.ain.getLayoutParams() != null) {
            this.ain.getLayoutParams().height = (int) (((l.getEquipmentWidth(getContext()) - (2.0f * this.air)) / 16.0f) * 9.0f);
        }
        this.aim.setTranslationY(-this.aiq);
        this.ain.setDrawCorner(true);
        this.ain.setConrers(15);
        this.ain.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        com.baidu.tbadk.a.b.a.a(this.mTitle, R.dimen.tbds7, R.dimen.tbds10);
    }

    public void setSubClickListener(aa<AbsThreadDataSupport> aaVar) {
        this.agI = aaVar;
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        this.aeX = onClickListener;
    }

    public TextView getTitle() {
        return this.mTitle;
    }

    public TextView getIcon() {
        return this.aim;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aeX != null) {
            this.aeX.onClick(view);
        }
        if (this.agI != null) {
            this.agI.a(view, this.aeW);
        }
    }

    @Override // com.baidu.card.p
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.aeW != null && this.aeW.bce() != null) {
            m.a(this.mTitle, this.aeW.bce().getId(), this.ain.getVisibility() == 0 ? R.color.cp_cont_a : R.color.cp_cont_b, R.color.cp_cont_d);
        }
        ap.setViewTextColor(this.aim, R.color.cp_cont_a);
        com.baidu.tbadk.core.util.e.a.bjQ().oe(0).og(R.color.cp_mask_b_alpha42).V(this.aip).aZ(this.aim);
        com.baidu.tbadk.core.util.e.a.bjQ().oe(0).j(R.color.cp_mask_b, R.color.cp_mask_b_alpha33).X(l.getDimens(getContext(), R.dimen.tbds10)).W(l.getDimens(getContext(), R.dimen.tbds10)).Z(l.getDimens(getContext(), R.dimen.tbds10)).Y(l.getDimens(getContext(), R.dimen.tbds10)).om(128).aZ(this.aio);
    }
}

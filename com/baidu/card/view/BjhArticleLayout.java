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
import com.baidu.tbadk.a.b.b;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.elementsMaven.c;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.m;
/* loaded from: classes.dex */
public class BjhArticleLayout extends RelativeLayout implements View.OnClickListener, p<com.baidu.tbadk.core.data.a>, q {
    private com.baidu.tbadk.core.data.a agr;
    private View.OnClickListener ags;
    private aa<com.baidu.tbadk.core.data.a> ais;
    private TextView ajQ;
    private TbImageView ajR;
    private View ajS;
    private float ajT;
    private float ajU;
    private float ajV;
    private TextView mTitle;
    private int tbds21;
    private int tbds30;

    public BjhArticleLayout(Context context) {
        this(context, null);
    }

    public BjhArticleLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ajT = l.getDimens(context, R.dimen.tbds10);
        this.tbds21 = l.getDimens(context, R.dimen.tbds21);
        this.ajU = l.getDimens(context, R.dimen.tbds16);
        this.tbds30 = l.getDimens(context, R.dimen.tbds30);
        this.ajV = l.getDimens(context, R.dimen.tbds44);
        initUI();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        this.agr = aVar;
        bz bkV = aVar.bkV();
        if (bkV.isShareThread && bkV.eQQ != null) {
            if (bkV.eQQ.eLl) {
                setVisibility(8);
                return;
            }
            bkV = bkV.eQQ.blX();
        }
        this.mTitle.setText(bkV.getTitle());
        if (StringUtils.isNull(bkV.bpy())) {
            this.ajQ.setVisibility(8);
            this.ajR.setVisibility(8);
            this.ajS.setVisibility(8);
        } else {
            this.ajQ.setVisibility(0);
            this.ajR.setVisibility(0);
            this.ajS.setVisibility(0);
            this.ajR.startLoad(bkV.bpy(), 10, false);
        }
        m.a(this.mTitle, bkV.getId(), this.ajR.getVisibility() == 0 ? R.color.CAM_X0101 : R.color.CAM_X0105, R.color.CAM_X0109);
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.bjh_article_layout, (ViewGroup) this, true);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setId(R.id.bjh_content);
        this.mTitle = (TextView) findViewById(R.id.title);
        c.bv(this.mTitle).nX(R.string.F_X01).nW(R.dimen.T_X06);
        this.mTitle.setOnClickListener(this);
        this.ajQ = (TextView) findViewById(R.id.icon);
        this.ajQ.setOnClickListener(this);
        this.ajR = (TbImageView) findViewById(R.id.cover_img);
        this.ajR.setPlaceHolder(3);
        this.ajR.setOnClickListener(this);
        this.ajS = findViewById(R.id.bottom_mask);
        this.ajS.setOnClickListener(this);
        if (this.ajR.getLayoutParams() != null) {
            this.ajR.getLayoutParams().height = (int) (((l.getEquipmentWidth(getContext()) - (2.0f * this.ajV)) / 16.0f) * 9.0f);
        }
        this.ajQ.setTranslationY(-this.ajU);
        this.ajR.setDrawCorner(true);
        this.ajR.setConrers(15);
        this.ajR.setRadiusById(R.string.J_X05);
        b.a(this.mTitle, R.dimen.tbds7, R.dimen.tbds10);
    }

    public void setSubClickListener(aa<com.baidu.tbadk.core.data.a> aaVar) {
        this.ais = aaVar;
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        this.ags = onClickListener;
    }

    public TextView getTitle() {
        return this.mTitle;
    }

    public TextView getIcon() {
        return this.ajQ;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ags != null) {
            this.ags.onClick(view);
        }
        if (this.ais != null) {
            this.ais.a(view, this.agr);
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.agr != null && this.agr.bkV() != null) {
            m.a(this.mTitle, this.agr.bkV().getId(), this.ajR.getVisibility() == 0 ? R.color.CAM_X0101 : R.color.CAM_X0105, R.color.CAM_X0109);
        }
        ao.setViewTextColor(this.ajQ, R.color.CAM_X0101);
        com.baidu.tbadk.core.util.f.a.btb().oJ(0).oM(R.color.CAM_X0606).ae(this.ajT).bz(this.ajQ);
        com.baidu.tbadk.core.util.f.a.btb().oJ(0).n(R.color.CAM_X0611, R.color.CAM_X0605).ag(l.getDimens(getContext(), R.dimen.tbds21)).af(l.getDimens(getContext(), R.dimen.tbds21)).ai(l.getDimens(getContext(), R.dimen.tbds21)).ah(l.getDimens(getContext(), R.dimen.tbds21)).oT(128).bz(this.ajS);
    }
}

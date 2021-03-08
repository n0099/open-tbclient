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
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.elementsMaven.c;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.m;
/* loaded from: classes.dex */
public class BjhArticleLayout extends RelativeLayout implements View.OnClickListener, p<com.baidu.tbadk.core.data.a>, q {
    private com.baidu.tbadk.core.data.a ahB;
    private View.OnClickListener ahC;
    private ab<com.baidu.tbadk.core.data.a> ajy;
    private TextView akX;
    private TbImageView akY;
    private View akZ;
    private float ala;
    private float alb;
    private float alc;
    private TextView mTitle;
    private int tbds21;
    private int tbds30;

    public BjhArticleLayout(Context context) {
        this(context, null);
    }

    public BjhArticleLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ala = l.getDimens(context, R.dimen.tbds10);
        this.tbds21 = l.getDimens(context, R.dimen.tbds21);
        this.alb = l.getDimens(context, R.dimen.tbds16);
        this.tbds30 = l.getDimens(context, R.dimen.tbds30);
        this.alc = l.getDimens(context, R.dimen.tbds44);
        initUI();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void E(com.baidu.tbadk.core.data.a aVar) {
        this.ahB = aVar;
        cb blp = aVar.blp();
        if (blp.isShareThread && blp.eUD != null) {
            if (blp.eUD.eOY) {
                setVisibility(8);
                return;
            }
            blp = blp.eUD.bms();
        }
        this.mTitle.setText(blp.getTitle());
        if (StringUtils.isNull(blp.bpS())) {
            this.akX.setVisibility(8);
            this.akY.setVisibility(8);
            this.akZ.setVisibility(8);
        } else {
            this.akX.setVisibility(0);
            this.akY.setVisibility(0);
            this.akZ.setVisibility(0);
            this.akY.startLoad(blp.bpS(), 10, false);
        }
        m.a(this.mTitle, blp.getId(), this.akY.getVisibility() == 0 ? R.color.CAM_X0101 : R.color.CAM_X0105, R.color.CAM_X0109);
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.bjh_article_layout, (ViewGroup) this, true);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setId(R.id.bjh_content);
        this.mTitle = (TextView) findViewById(R.id.title);
        c.br(this.mTitle).ob(R.string.F_X01).oa(R.dimen.T_X06);
        this.mTitle.setOnClickListener(this);
        this.akX = (TextView) findViewById(R.id.icon);
        this.akX.setOnClickListener(this);
        this.akY = (TbImageView) findViewById(R.id.cover_img);
        this.akY.setPlaceHolder(3);
        this.akY.setOnClickListener(this);
        this.akZ = findViewById(R.id.bottom_mask);
        this.akZ.setOnClickListener(this);
        if (this.akY.getLayoutParams() != null) {
            this.akY.getLayoutParams().height = (int) (((l.getEquipmentWidth(getContext()) - (2.0f * this.alc)) / 16.0f) * 9.0f);
        }
        this.akX.setTranslationY(-this.alb);
        this.akY.setDrawCorner(true);
        this.akY.setConrers(15);
        this.akY.setRadiusById(R.string.J_X05);
        b.a(this.mTitle, R.dimen.tbds7, R.dimen.tbds10);
    }

    public void setSubClickListener(ab<com.baidu.tbadk.core.data.a> abVar) {
        this.ajy = abVar;
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        this.ahC = onClickListener;
    }

    public TextView getTitle() {
        return this.mTitle;
    }

    public TextView getIcon() {
        return this.akX;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ahC != null) {
            this.ahC.onClick(view);
        }
        if (this.ajy != null) {
            this.ajy.a(view, this.ahB);
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.ahB != null && this.ahB.blp() != null) {
            m.a(this.mTitle, this.ahB.blp().getId(), this.akY.getVisibility() == 0 ? R.color.CAM_X0101 : R.color.CAM_X0105, R.color.CAM_X0109);
        }
        ap.setViewTextColor(this.akX, R.color.CAM_X0101);
        com.baidu.tbadk.core.util.f.a.bty().oP(0).oS(R.color.CAM_X0606).aj(this.ala).bv(this.akX);
        com.baidu.tbadk.core.util.f.a.bty().oP(0).n(R.color.CAM_X0611, R.color.CAM_X0605).al(l.getDimens(getContext(), R.dimen.tbds21)).ak(l.getDimens(getContext(), R.dimen.tbds21)).an(l.getDimens(getContext(), R.dimen.tbds21)).am(l.getDimens(getContext(), R.dimen.tbds21)).oZ(128).bv(this.akZ);
    }
}

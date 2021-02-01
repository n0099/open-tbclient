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
    private com.baidu.tbadk.core.data.a agj;
    private View.OnClickListener agk;
    private ab<com.baidu.tbadk.core.data.a> aig;
    private TextView ajF;
    private TbImageView ajG;
    private View ajH;
    private float ajI;
    private float ajJ;
    private float ajK;
    private TextView mTitle;
    private int tbds21;
    private int tbds30;

    public BjhArticleLayout(Context context) {
        this(context, null);
    }

    public BjhArticleLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ajI = l.getDimens(context, R.dimen.tbds10);
        this.tbds21 = l.getDimens(context, R.dimen.tbds21);
        this.ajJ = l.getDimens(context, R.dimen.tbds16);
        this.tbds30 = l.getDimens(context, R.dimen.tbds30);
        this.ajK = l.getDimens(context, R.dimen.tbds44);
        initUI();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        this.agj = aVar;
        cb bln = aVar.bln();
        if (bln.isShareThread && bln.eTc != null) {
            if (bln.eTc.eNx) {
                setVisibility(8);
                return;
            }
            bln = bln.eTc.bmq();
        }
        this.mTitle.setText(bln.getTitle());
        if (StringUtils.isNull(bln.bpQ())) {
            this.ajF.setVisibility(8);
            this.ajG.setVisibility(8);
            this.ajH.setVisibility(8);
        } else {
            this.ajF.setVisibility(0);
            this.ajG.setVisibility(0);
            this.ajH.setVisibility(0);
            this.ajG.startLoad(bln.bpQ(), 10, false);
        }
        m.a(this.mTitle, bln.getId(), this.ajG.getVisibility() == 0 ? R.color.CAM_X0101 : R.color.CAM_X0105, R.color.CAM_X0109);
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.bjh_article_layout, (ViewGroup) this, true);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setId(R.id.bjh_content);
        this.mTitle = (TextView) findViewById(R.id.title);
        c.br(this.mTitle).oa(R.string.F_X01).nZ(R.dimen.T_X06);
        this.mTitle.setOnClickListener(this);
        this.ajF = (TextView) findViewById(R.id.icon);
        this.ajF.setOnClickListener(this);
        this.ajG = (TbImageView) findViewById(R.id.cover_img);
        this.ajG.setPlaceHolder(3);
        this.ajG.setOnClickListener(this);
        this.ajH = findViewById(R.id.bottom_mask);
        this.ajH.setOnClickListener(this);
        if (this.ajG.getLayoutParams() != null) {
            this.ajG.getLayoutParams().height = (int) (((l.getEquipmentWidth(getContext()) - (2.0f * this.ajK)) / 16.0f) * 9.0f);
        }
        this.ajF.setTranslationY(-this.ajJ);
        this.ajG.setDrawCorner(true);
        this.ajG.setConrers(15);
        this.ajG.setRadiusById(R.string.J_X05);
        b.a(this.mTitle, R.dimen.tbds7, R.dimen.tbds10);
    }

    public void setSubClickListener(ab<com.baidu.tbadk.core.data.a> abVar) {
        this.aig = abVar;
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        this.agk = onClickListener;
    }

    public TextView getTitle() {
        return this.mTitle;
    }

    public TextView getIcon() {
        return this.ajF;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.agk != null) {
            this.agk.onClick(view);
        }
        if (this.aig != null) {
            this.aig.a(view, this.agj);
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.agj != null && this.agj.bln() != null) {
            m.a(this.mTitle, this.agj.bln().getId(), this.ajG.getVisibility() == 0 ? R.color.CAM_X0101 : R.color.CAM_X0105, R.color.CAM_X0109);
        }
        ap.setViewTextColor(this.ajF, R.color.CAM_X0101);
        com.baidu.tbadk.core.util.f.a.btv().oO(0).oR(R.color.CAM_X0606).af(this.ajI).bv(this.ajF);
        com.baidu.tbadk.core.util.f.a.btv().oO(0).n(R.color.CAM_X0611, R.color.CAM_X0605).ah(l.getDimens(getContext(), R.dimen.tbds21)).ag(l.getDimens(getContext(), R.dimen.tbds21)).aj(l.getDimens(getContext(), R.dimen.tbds21)).ai(l.getDimens(getContext(), R.dimen.tbds21)).oY(128).bv(this.ajH);
    }
}

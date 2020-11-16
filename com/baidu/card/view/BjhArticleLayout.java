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
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.elementsMaven.c;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.n;
/* loaded from: classes20.dex */
public class BjhArticleLayout extends RelativeLayout implements View.OnClickListener, p<com.baidu.tbadk.core.data.a>, q {
    private com.baidu.tbadk.core.data.a afN;
    private View.OnClickListener afO;
    private ab<com.baidu.tbadk.core.data.a> ahx;
    private TextView ajg;
    private TbImageView ajh;
    private View aji;
    private float ajj;
    private float ajk;
    private float ajl;
    private TextView mTitle;
    private int tbds21;
    private int tbds30;

    public BjhArticleLayout(Context context) {
        this(context, null);
    }

    public BjhArticleLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ajj = l.getDimens(context, R.dimen.tbds10);
        this.tbds21 = l.getDimens(context, R.dimen.tbds21);
        this.ajk = l.getDimens(context, R.dimen.tbds16);
        this.tbds30 = l.getDimens(context, R.dimen.tbds30);
        this.ajl = l.getDimens(context, R.dimen.tbds44);
        initUI();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(com.baidu.tbadk.core.data.a aVar) {
        this.afN = aVar;
        bx bjd = aVar.bjd();
        if (bjd.isShareThread && bjd.eEF != null) {
            if (bjd.eEF.ezh) {
                setVisibility(8);
                return;
            }
            bjd = bjd.eEF.bkd();
        }
        this.mTitle.setText(bjd.getTitle());
        if (StringUtils.isNull(bjd.bnC())) {
            this.ajg.setVisibility(8);
            this.ajh.setVisibility(8);
            this.aji.setVisibility(8);
        } else {
            this.ajg.setVisibility(0);
            this.ajh.setVisibility(0);
            this.aji.setVisibility(0);
            this.ajh.startLoad(bjd.bnC(), 10, false);
        }
        n.a(this.mTitle, bjd.getId(), this.ajh.getVisibility() == 0 ? R.color.CAM_X0101 : R.color.CAM_X0105, R.color.CAM_X0109);
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.bjh_article_layout, (ViewGroup) this, true);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setId(R.id.bjh_content);
        this.mTitle = (TextView) findViewById(R.id.title);
        c.bj(this.mTitle).oV(R.string.F_X01).oU(R.dimen.T_X06);
        this.mTitle.setOnClickListener(this);
        this.ajg = (TextView) findViewById(R.id.icon);
        this.ajg.setOnClickListener(this);
        this.ajh = (TbImageView) findViewById(R.id.cover_img);
        this.ajh.setPlaceHolder(3);
        this.ajh.setOnClickListener(this);
        this.aji = findViewById(R.id.bottom_mask);
        this.aji.setOnClickListener(this);
        if (this.ajh.getLayoutParams() != null) {
            this.ajh.getLayoutParams().height = (int) (((l.getEquipmentWidth(getContext()) - (2.0f * this.ajl)) / 16.0f) * 9.0f);
        }
        this.ajg.setTranslationY(-this.ajk);
        this.ajh.setDrawCorner(true);
        this.ajh.setConrers(15);
        this.ajh.setRadiusById(R.string.J_X05);
        com.baidu.tbadk.a.b.a.a(this.mTitle, R.dimen.tbds7, R.dimen.tbds10);
    }

    public void setSubClickListener(ab<com.baidu.tbadk.core.data.a> abVar) {
        this.ahx = abVar;
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        this.afO = onClickListener;
    }

    public TextView getTitle() {
        return this.mTitle;
    }

    public TextView getIcon() {
        return this.ajg;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.afO != null) {
            this.afO.onClick(view);
        }
        if (this.ahx != null) {
            this.ahx.a(view, this.afN);
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.afN != null && this.afN.bjd() != null) {
            n.a(this.mTitle, this.afN.bjd().getId(), this.ajh.getVisibility() == 0 ? R.color.CAM_X0101 : R.color.CAM_X0105, R.color.CAM_X0109);
        }
        ap.setViewTextColor(this.ajg, R.color.CAM_X0101);
        com.baidu.tbadk.core.util.e.a.brc().pF(0).pI(R.color.CAM_X0606).ac(this.ajj).bn(this.ajg);
        com.baidu.tbadk.core.util.e.a.brc().pF(0).m(R.color.CAM_X0611, R.color.CAM_X0605).ae(l.getDimens(getContext(), R.dimen.tbds21)).ad(l.getDimens(getContext(), R.dimen.tbds21)).ag(l.getDimens(getContext(), R.dimen.tbds21)).af(l.getDimens(getContext(), R.dimen.tbds21)).pP(128).bn(this.aji);
    }
}

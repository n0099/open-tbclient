package com.baidu.card.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.i.p;
import d.a.i.q;
import d.a.m0.b.g.b;
import d.a.m0.r.q.a;
import d.a.m0.r.q.a2;
import d.a.m0.r.u.c;
import d.a.n0.z.b0;
import d.a.n0.z.m;
/* loaded from: classes.dex */
public class BjhArticleLayout extends RelativeLayout implements p<a>, View.OnClickListener, q {

    /* renamed from: e  reason: collision with root package name */
    public TextView f4351e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f4352f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f4353g;

    /* renamed from: h  reason: collision with root package name */
    public View f4354h;

    /* renamed from: i  reason: collision with root package name */
    public a f4355i;
    public float j;
    public float k;
    public float l;
    public b0<a> m;
    public View.OnClickListener n;

    public BjhArticleLayout(Context context) {
        this(context, null);
    }

    public final void b() {
        LayoutInflater.from(getContext()).inflate(R.layout.bjh_article_layout, (ViewGroup) this, true);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setId(R.id.bjh_content);
        TextView textView = (TextView) findViewById(R.id.title);
        this.f4351e = textView;
        c d2 = c.d(textView);
        d2.x(R.string.F_X01);
        d2.w(R.dimen.T_X06);
        this.f4351e.setOnClickListener(this);
        TextView textView2 = (TextView) findViewById(R.id.icon);
        this.f4352f = textView2;
        textView2.setOnClickListener(this);
        TbImageView tbImageView = (TbImageView) findViewById(R.id.cover_img);
        this.f4353g = tbImageView;
        tbImageView.setPlaceHolder(3);
        this.f4353g.setOnClickListener(this);
        View findViewById = findViewById(R.id.bottom_mask);
        this.f4354h = findViewById;
        findViewById.setOnClickListener(this);
        if (this.f4353g.getLayoutParams() != null) {
            this.f4353g.getLayoutParams().height = (int) (((l.k(getContext()) - (this.l * 2.0f)) / 16.0f) * 9.0f);
        }
        this.f4352f.setTranslationY(-this.k);
        this.f4353g.setDrawCorner(true);
        this.f4353g.setConrers(15);
        this.f4353g.setRadiusById(R.string.J_X05);
        b.k(this.f4351e, R.dimen.tbds7, R.dimen.tbds10);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i.p
    /* renamed from: c */
    public void a(a aVar) {
        OriginalThreadInfo originalThreadInfo;
        this.f4355i = aVar;
        a2 m = aVar.m();
        if (m.t1 && (originalThreadInfo = m.s1) != null) {
            if (originalThreadInfo.m) {
                setVisibility(8);
                return;
            }
            m = originalThreadInfo.a();
        }
        this.f4351e.setText(m.z1());
        if (StringUtils.isNull(m.R())) {
            this.f4352f.setVisibility(8);
            this.f4353g.setVisibility(8);
            this.f4354h.setVisibility(8);
        } else {
            this.f4352f.setVisibility(0);
            this.f4353g.setVisibility(0);
            this.f4354h.setVisibility(0);
            this.f4353g.V(m.R(), 10, false);
        }
        m.l(this.f4351e, m.o0(), this.f4353g.getVisibility() == 0 ? R.color.CAM_X0101 : R.color.CAM_X0105, R.color.CAM_X0109);
    }

    public TextView getIcon() {
        return this.f4352f;
    }

    public TextView getTitle() {
        return this.f4351e;
    }

    @Override // d.a.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        a aVar = this.f4355i;
        if (aVar != null && aVar.m() != null) {
            m.l(this.f4351e, this.f4355i.m().o0(), this.f4353g.getVisibility() == 0 ? R.color.CAM_X0101 : R.color.CAM_X0105, R.color.CAM_X0109);
        }
        SkinManager.setViewTextColor(this.f4352f, R.color.CAM_X0101);
        TBSelector.makeDrawableSelector().setShape(0).defaultColorNotAutoChangeSkinType(R.color.CAM_X0606).radius(this.j).into(this.f4352f);
        TBSelector.makeDrawableSelector().setShape(0).gradientLinearNotAutoChangeSkinType(R.color.CAM_X0611, R.color.CAM_X0605).tlRadius(l.g(getContext(), R.dimen.tbds21)).trRadius(l.g(getContext(), R.dimen.tbds21)).blRadius(l.g(getContext(), R.dimen.tbds21)).brRadius(l.g(getContext(), R.dimen.tbds21)).setAlpha(128).into(this.f4354h);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener = this.n;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        b0<a> b0Var = this.m;
        if (b0Var != null) {
            b0Var.a(view, this.f4355i);
        }
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        this.n = onClickListener;
    }

    public void setSubClickListener(b0<a> b0Var) {
        this.m = b0Var;
    }

    public BjhArticleLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = l.g(context, R.dimen.tbds10);
        l.g(context, R.dimen.tbds21);
        this.k = l.g(context, R.dimen.tbds16);
        l.g(context, R.dimen.tbds30);
        this.l = l.g(context, R.dimen.tbds44);
        b();
    }
}

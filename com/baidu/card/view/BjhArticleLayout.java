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
import d.a.n0.b.g.b;
import d.a.n0.r.q.a;
import d.a.n0.r.q.a2;
import d.a.n0.r.u.c;
import d.a.o0.z.b0;
import d.a.o0.z.m;
/* loaded from: classes.dex */
public class BjhArticleLayout extends RelativeLayout implements p<a>, View.OnClickListener, q {

    /* renamed from: e  reason: collision with root package name */
    public TextView f4370e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f4371f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f4372g;

    /* renamed from: h  reason: collision with root package name */
    public View f4373h;

    /* renamed from: i  reason: collision with root package name */
    public a f4374i;
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
        this.f4370e = textView;
        c d2 = c.d(textView);
        d2.x(R.string.F_X01);
        d2.w(R.dimen.T_X06);
        this.f4370e.setOnClickListener(this);
        TextView textView2 = (TextView) findViewById(R.id.icon);
        this.f4371f = textView2;
        textView2.setOnClickListener(this);
        TbImageView tbImageView = (TbImageView) findViewById(R.id.cover_img);
        this.f4372g = tbImageView;
        tbImageView.setPlaceHolder(3);
        this.f4372g.setOnClickListener(this);
        View findViewById = findViewById(R.id.bottom_mask);
        this.f4373h = findViewById;
        findViewById.setOnClickListener(this);
        if (this.f4372g.getLayoutParams() != null) {
            this.f4372g.getLayoutParams().height = (int) (((l.k(getContext()) - (this.l * 2.0f)) / 16.0f) * 9.0f);
        }
        this.f4371f.setTranslationY(-this.k);
        this.f4372g.setDrawCorner(true);
        this.f4372g.setConrers(15);
        this.f4372g.setRadiusById(R.string.J_X05);
        b.k(this.f4370e, R.dimen.tbds7, R.dimen.tbds10);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i.p
    /* renamed from: c */
    public void a(a aVar) {
        OriginalThreadInfo originalThreadInfo;
        this.f4374i = aVar;
        a2 i2 = aVar.i();
        if (i2.u1 && (originalThreadInfo = i2.t1) != null) {
            if (originalThreadInfo.m) {
                setVisibility(8);
                return;
            }
            i2 = originalThreadInfo.a();
        }
        this.f4370e.setText(i2.A1());
        if (StringUtils.isNull(i2.R())) {
            this.f4371f.setVisibility(8);
            this.f4372g.setVisibility(8);
            this.f4373h.setVisibility(8);
        } else {
            this.f4371f.setVisibility(0);
            this.f4372g.setVisibility(0);
            this.f4373h.setVisibility(0);
            this.f4372g.U(i2.R(), 10, false);
        }
        m.l(this.f4370e, i2.o0(), this.f4372g.getVisibility() == 0 ? R.color.CAM_X0101 : R.color.CAM_X0105, R.color.CAM_X0109);
    }

    public TextView getIcon() {
        return this.f4371f;
    }

    public TextView getTitle() {
        return this.f4370e;
    }

    @Override // d.a.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        a aVar = this.f4374i;
        if (aVar != null && aVar.i() != null) {
            m.l(this.f4370e, this.f4374i.i().o0(), this.f4372g.getVisibility() == 0 ? R.color.CAM_X0101 : R.color.CAM_X0105, R.color.CAM_X0109);
        }
        SkinManager.setViewTextColor(this.f4371f, R.color.CAM_X0101);
        TBSelector.makeDrawableSelector().setShape(0).defaultColorNotAutoChangeSkinType(R.color.CAM_X0606).radius(this.j).into(this.f4371f);
        TBSelector.makeDrawableSelector().setShape(0).gradientLinearNotAutoChangeSkinType(R.color.CAM_X0611, R.color.CAM_X0605).tlRadius(l.g(getContext(), R.dimen.tbds21)).trRadius(l.g(getContext(), R.dimen.tbds21)).blRadius(l.g(getContext(), R.dimen.tbds21)).brRadius(l.g(getContext(), R.dimen.tbds21)).setAlpha(128).into(this.f4373h);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener = this.n;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        b0<a> b0Var = this.m;
        if (b0Var != null) {
            b0Var.a(view, this.f4374i);
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

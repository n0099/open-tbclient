package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.i0.r.q.a2;
import d.a.i0.r.q.p0;
import d.a.j0.x.m;
/* loaded from: classes3.dex */
public class ThreadLinkView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f13146e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f13147f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f13148g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f13149h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f13150i;
    public ViewGroup j;
    public View k;
    public BdUniqueId l;

    public ThreadLinkView(Context context) {
        super(context);
        a(context);
    }

    public final void a(Context context) {
        this.f13146e = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.link_thread_item, (ViewGroup) this, true);
        this.j = (ViewGroup) inflate.findViewById(R.id.root_layout);
        TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.link_thread_head_img);
        this.f13147f = tbImageView;
        tbImageView.setDefaultBgResource(R.drawable.icon_card_url_n);
        this.f13148g = (TextView) inflate.findViewById(R.id.link_thread_title);
        this.f13149h = (TextView) inflate.findViewById(R.id.link_thread_abstract);
        this.f13150i = (TextView) inflate.findViewById(R.id.link_thread_url);
        this.k = inflate.findViewById(R.id.link_thread_content);
        this.f13147f.setLongIconSupport(false);
        this.f13147f.setGifIconSupport(false);
        this.f13147f.setRadius(l.g(context, R.dimen.tbds10));
        this.f13147f.setConrers(5);
        d(inflate);
    }

    public void b() {
        SkinManager.setBackgroundColor(this.k, R.color.CAM_X0205);
        SkinManager.setBackgroundResource(this.f13147f, R.drawable.shape_link_thread_head_bg);
    }

    public void c(String str) {
        m.l(this.f13148g, str, R.color.CAM_X0107, R.color.CAM_X0109);
        m.l(this.f13150i, str, R.color.CAM_X0107, R.color.CAM_X0109);
        m.l(this.f13149h, str, R.color.CAM_X0107, R.color.CAM_X0109);
    }

    public final void d(View view) {
        if (this.j == null || this.f13147f == null) {
            return;
        }
        int k = (((l.k(this.f13146e) - (l.g(this.f13146e, R.dimen.tbds44) * 2)) - (l.g(getContext(), R.dimen.tbds26) * 2)) - (l.g(getContext(), R.dimen.tbds10) * 4)) / 5;
        ViewGroup.LayoutParams layoutParams = this.j.getLayoutParams();
        layoutParams.height = k;
        this.j.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.f13147f.getLayoutParams();
        layoutParams2.width = k;
        layoutParams2.height = k;
        this.f13147f.setLayoutParams(layoutParams2);
    }

    public void setData(a2 a2Var) {
        if (a2Var != null && a2Var.H0() != null && !k.isEmpty(a2Var.H0().e())) {
            p0 H0 = a2Var.H0();
            if (!H0.f() && H0.c() != p0.f49229g) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            this.f13147f.setPageId(this.l);
            if (H0.f()) {
                this.f13150i.setVisibility(0);
                this.f13148g.setVisibility(8);
                this.f13149h.setVisibility(8);
                this.f13150i.setText(H0.e());
                this.f13147f.Q();
            } else {
                this.f13150i.setVisibility(8);
                String d2 = H0.d();
                String a2 = H0.a();
                if (!k.isEmpty(d2)) {
                    this.f13148g.setText(d2);
                    this.f13148g.setVisibility(0);
                    this.f13149h.setVisibility(8);
                } else {
                    this.f13148g.setVisibility(8);
                    if (!k.isEmpty(a2)) {
                        this.f13149h.setText(a2);
                        this.f13149h.setVisibility(0);
                    } else {
                        this.f13149h.setVisibility(4);
                    }
                }
                if (!k.isEmpty(H0.b())) {
                    this.f13147f.V(H0.b(), 10, false);
                } else {
                    this.f13147f.Q();
                }
            }
            c(a2Var.o0());
            return;
        }
        setVisibility(8);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.l = bdUniqueId;
    }

    public ThreadLinkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public ThreadLinkView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }
}

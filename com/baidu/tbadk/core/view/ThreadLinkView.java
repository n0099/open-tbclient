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
import d.a.m0.r.q.a2;
import d.a.m0.r.q.p0;
import d.a.n0.z.m;
/* loaded from: classes3.dex */
public class ThreadLinkView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f12452e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f12453f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f12454g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f12455h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f12456i;
    public ViewGroup j;
    public View k;
    public BdUniqueId l;

    public ThreadLinkView(Context context) {
        super(context);
        a(context);
    }

    public final void a(Context context) {
        this.f12452e = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.link_thread_item, (ViewGroup) this, true);
        this.j = (ViewGroup) inflate.findViewById(R.id.root_layout);
        TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.link_thread_head_img);
        this.f12453f = tbImageView;
        tbImageView.setDefaultBgResource(R.drawable.icon_card_url_n);
        this.f12454g = (TextView) inflate.findViewById(R.id.link_thread_title);
        this.f12455h = (TextView) inflate.findViewById(R.id.link_thread_abstract);
        this.f12456i = (TextView) inflate.findViewById(R.id.link_thread_url);
        this.k = inflate.findViewById(R.id.link_thread_content);
        this.f12453f.setLongIconSupport(false);
        this.f12453f.setGifIconSupport(false);
        this.f12453f.setRadius(l.g(context, R.dimen.tbds10));
        this.f12453f.setConrers(5);
        d(inflate);
    }

    public void b() {
        SkinManager.setBackgroundColor(this.k, R.color.CAM_X0205);
        SkinManager.setBackgroundResource(this.f12453f, R.drawable.shape_link_thread_head_bg);
    }

    public void c(String str) {
        m.l(this.f12454g, str, R.color.CAM_X0107, R.color.CAM_X0109);
        m.l(this.f12456i, str, R.color.CAM_X0107, R.color.CAM_X0109);
        m.l(this.f12455h, str, R.color.CAM_X0107, R.color.CAM_X0109);
    }

    public final void d(View view) {
        if (this.j == null || this.f12453f == null) {
            return;
        }
        int k = (((l.k(this.f12452e) - (l.g(this.f12452e, R.dimen.tbds44) * 2)) - (l.g(getContext(), R.dimen.tbds26) * 2)) - (l.g(getContext(), R.dimen.tbds10) * 4)) / 5;
        ViewGroup.LayoutParams layoutParams = this.j.getLayoutParams();
        layoutParams.height = k;
        this.j.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.f12453f.getLayoutParams();
        layoutParams2.width = k;
        layoutParams2.height = k;
        this.f12453f.setLayoutParams(layoutParams2);
    }

    public void setData(a2 a2Var) {
        if (a2Var != null && a2Var.I0() != null && !k.isEmpty(a2Var.I0().e())) {
            p0 I0 = a2Var.I0();
            if (!I0.f() && I0.c() != p0.f53768g) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            this.f12453f.setPageId(this.l);
            if (I0.f()) {
                this.f12456i.setVisibility(0);
                this.f12454g.setVisibility(8);
                this.f12455h.setVisibility(8);
                this.f12456i.setText(I0.e());
                this.f12453f.Q();
            } else {
                this.f12456i.setVisibility(8);
                String d2 = I0.d();
                String a2 = I0.a();
                if (!k.isEmpty(d2)) {
                    this.f12454g.setText(d2);
                    this.f12454g.setVisibility(0);
                    this.f12455h.setVisibility(8);
                } else {
                    this.f12454g.setVisibility(8);
                    if (!k.isEmpty(a2)) {
                        this.f12455h.setText(a2);
                        this.f12455h.setVisibility(0);
                    } else {
                        this.f12455h.setVisibility(4);
                    }
                }
                if (!k.isEmpty(I0.b())) {
                    this.f12453f.U(I0.b(), 10, false);
                } else {
                    this.f12453f.Q();
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

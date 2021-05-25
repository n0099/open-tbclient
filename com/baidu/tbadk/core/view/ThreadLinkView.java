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
    public Context f12390e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f12391f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f12392g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f12393h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f12394i;
    public ViewGroup j;
    public View k;
    public BdUniqueId l;

    public ThreadLinkView(Context context) {
        super(context);
        a(context);
    }

    public final void a(Context context) {
        this.f12390e = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.link_thread_item, (ViewGroup) this, true);
        this.j = (ViewGroup) inflate.findViewById(R.id.root_layout);
        TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.link_thread_head_img);
        this.f12391f = tbImageView;
        tbImageView.setDefaultBgResource(R.drawable.icon_card_url_n);
        this.f12392g = (TextView) inflate.findViewById(R.id.link_thread_title);
        this.f12393h = (TextView) inflate.findViewById(R.id.link_thread_abstract);
        this.f12394i = (TextView) inflate.findViewById(R.id.link_thread_url);
        this.k = inflate.findViewById(R.id.link_thread_content);
        this.f12391f.setLongIconSupport(false);
        this.f12391f.setGifIconSupport(false);
        this.f12391f.setRadius(l.g(context, R.dimen.tbds10));
        this.f12391f.setConrers(5);
        d(inflate);
    }

    public void b() {
        SkinManager.setBackgroundColor(this.k, R.color.CAM_X0205);
        SkinManager.setBackgroundResource(this.f12391f, R.drawable.shape_link_thread_head_bg);
    }

    public void c(String str) {
        m.l(this.f12392g, str, R.color.CAM_X0107, R.color.CAM_X0109);
        m.l(this.f12394i, str, R.color.CAM_X0107, R.color.CAM_X0109);
        m.l(this.f12393h, str, R.color.CAM_X0107, R.color.CAM_X0109);
    }

    public final void d(View view) {
        if (this.j == null || this.f12391f == null) {
            return;
        }
        int k = (((l.k(this.f12390e) - (l.g(this.f12390e, R.dimen.tbds44) * 2)) - (l.g(getContext(), R.dimen.tbds26) * 2)) - (l.g(getContext(), R.dimen.tbds10) * 4)) / 5;
        ViewGroup.LayoutParams layoutParams = this.j.getLayoutParams();
        layoutParams.height = k;
        this.j.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.f12391f.getLayoutParams();
        layoutParams2.width = k;
        layoutParams2.height = k;
        this.f12391f.setLayoutParams(layoutParams2);
    }

    public void setData(a2 a2Var) {
        if (a2Var != null && a2Var.I0() != null && !k.isEmpty(a2Var.I0().e())) {
            p0 I0 = a2Var.I0();
            if (!I0.f() && I0.c() != p0.f50092g) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            this.f12391f.setPageId(this.l);
            if (I0.f()) {
                this.f12394i.setVisibility(0);
                this.f12392g.setVisibility(8);
                this.f12393h.setVisibility(8);
                this.f12394i.setText(I0.e());
                this.f12391f.Q();
            } else {
                this.f12394i.setVisibility(8);
                String d2 = I0.d();
                String a2 = I0.a();
                if (!k.isEmpty(d2)) {
                    this.f12392g.setText(d2);
                    this.f12392g.setVisibility(0);
                    this.f12393h.setVisibility(8);
                } else {
                    this.f12392g.setVisibility(8);
                    if (!k.isEmpty(a2)) {
                        this.f12393h.setText(a2);
                        this.f12393h.setVisibility(0);
                    } else {
                        this.f12393h.setVisibility(4);
                    }
                }
                if (!k.isEmpty(I0.b())) {
                    this.f12391f.V(I0.b(), 10, false);
                } else {
                    this.f12391f.Q();
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

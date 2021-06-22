package com.baidu.card.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.a.c.a.j;
import d.a.i.p;
import d.a.i.q;
import d.a.n0.m.c;
import d.a.n0.r.q.l;
import d.a.n0.r.q.m;
import d.a.n0.r.w.b.d;
import d.a.n0.r.w.b.e;
import java.util.List;
/* loaded from: classes.dex */
public class AutoBannerLayout extends RelativeLayout implements q, p<m> {

    /* renamed from: e  reason: collision with root package name */
    public CoverFlowView<l> f4363e;

    /* renamed from: f  reason: collision with root package name */
    public List<l> f4364f;

    /* renamed from: g  reason: collision with root package name */
    public c f4365g;

    /* renamed from: h  reason: collision with root package name */
    public d<l> f4366h;

    /* renamed from: i  reason: collision with root package name */
    public d<l> f4367i;

    /* loaded from: classes.dex */
    public class a extends d.a.n0.r.w.b.b {
        public a() {
        }

        @Override // d.a.n0.r.w.b.b, d.a.n0.r.w.a
        public d.a.n0.r.w.b.c a() {
            d.a.n0.r.w.b.c cVar = new d.a.n0.r.w.b.c();
            cVar.c(R.drawable.shape_home_feed_banner_dot_n);
            cVar.g(R.drawable.shape_home_feed_banner_dot_s);
            cVar.d(81);
            cVar.e(R.dimen.M_H_X003);
            cVar.h(R.dimen.M_W_X003);
            return cVar;
        }

        @Override // d.a.n0.r.w.b.b, d.a.n0.r.w.a
        public e c() {
            e eVar = new e();
            eVar.a(d.a.c.e.p.l.g(AutoBannerLayout.this.getContext(), R.dimen.tbds209));
            return eVar;
        }

        @Override // d.a.n0.r.w.b.b, d.a.n0.r.w.a
        public TbImageView d(Context context) {
            TbImageView tbImageView = new TbImageView(context);
            tbImageView.setPlaceHolder(2);
            tbImageView.setLongIconSupport(false);
            tbImageView.setGifIconSupport(false);
            tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            tbImageView.setDrawerType(1);
            tbImageView.setRadius(d.a.c.e.p.l.g(AutoBannerLayout.this.getContext(), R.dimen.tbds31));
            return tbImageView;
        }
    }

    /* loaded from: classes.dex */
    public class b implements d<l> {
        public b() {
        }

        @Override // d.a.n0.r.w.b.d
        public void b(int i2, String str) {
            AutoBannerLayout.this.e(str);
            int count = ListUtils.getCount(AutoBannerLayout.this.f4364f);
            if (i2 < 0 || i2 > count || AutoBannerLayout.this.f4366h == null) {
                return;
            }
            AutoBannerLayout.this.f4366h.b(i2, str);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.r.w.b.d
        /* renamed from: c */
        public void a(int i2, l lVar) {
            int count = ListUtils.getCount(AutoBannerLayout.this.f4364f);
            if (i2 < 0 || i2 > count || AutoBannerLayout.this.f4366h == null) {
                return;
            }
            AutoBannerLayout.this.f4366h.a(i2, lVar);
        }
    }

    public AutoBannerLayout(Context context) {
        this(context, null);
    }

    public void d() {
        CoverFlowView<l> coverFlowView = this.f4363e;
        if (coverFlowView != null) {
            coverFlowView.l();
        }
    }

    public void e(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            UrlManager.getInstance().dealOneLink((TbPageContext) j.a(getContext()), new String[]{str});
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void f() {
        this.f4363e = new CoverFlowView<>(getContext());
        a aVar = new a();
        this.f4363e.setPageMargin(d.a.c.e.p.l.g(getContext(), R.dimen.tbds42));
        this.f4363e.setIndicatorNoOffet(false);
        this.f4363e.setDisableParentEvent(false);
        this.f4363e.setCoverFlowFactory(aVar);
        this.f4363e.setIndicatorVisible(0);
        this.f4363e.setIsAutoPlayDragging(false);
        this.f4363e.setCallback(this.f4367i);
        addView(this.f4363e);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i.p
    /* renamed from: g */
    public void a(m mVar) {
        if (mVar != null && !ListUtils.isEmpty(mVar.f53864e)) {
            h(mVar.f53864e);
        } else {
            setVisibility(8);
        }
    }

    public CoverFlowView getCoverFlowView() {
        return this.f4363e;
    }

    public void h(List<l> list) {
        if (list != null && !ListUtils.isEmpty(list)) {
            setVisibility(0);
            this.f4364f = list;
            this.f4363e.setData(list);
            return;
        }
        setVisibility(8);
    }

    @Override // d.a.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        CoverFlowView<l> coverFlowView = this.f4363e;
        if (coverFlowView != null) {
            coverFlowView.s();
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        if (this.f4365g != null) {
            this.f4365g.a(this, i2 == 0, null);
        }
    }

    public void setBannerHeight(int i2) {
        if (this.f4363e != null) {
            e eVar = new e();
            eVar.a(i2);
            this.f4363e.x(eVar);
        }
    }

    public void setIWindowChangedListener(c cVar) {
        this.f4365g = cVar;
    }

    public void setIndicatorVisible(int i2) {
        CoverFlowView<l> coverFlowView = this.f4363e;
        if (coverFlowView != null) {
            coverFlowView.setIndicatorVisible(i2);
        }
    }

    public void setMarqueenTime(long j) {
        CoverFlowView<l> coverFlowView = this.f4363e;
        if (coverFlowView != null) {
            coverFlowView.setMarqueenTime(j);
        }
    }

    public void setOnCoverViewCallback(d<l> dVar) {
        this.f4366h = dVar;
    }

    public void setPageMargin(int i2) {
        CoverFlowView<l> coverFlowView = this.f4363e;
        if (coverFlowView != null) {
            coverFlowView.setPageMargin(i2);
        }
    }

    public AutoBannerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AutoBannerLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f4363e = null;
        this.f4364f = null;
        this.f4367i = new b();
        f();
    }
}

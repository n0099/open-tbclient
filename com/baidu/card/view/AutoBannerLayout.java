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
import d.a.i0.m.c;
import d.a.i0.r.q.l;
import d.a.i0.r.q.m;
import d.a.i0.r.w.b.d;
import d.a.i0.r.w.b.e;
import java.util.List;
/* loaded from: classes.dex */
public class AutoBannerLayout extends RelativeLayout implements q, p<m> {

    /* renamed from: e  reason: collision with root package name */
    public CoverFlowView<l> f4490e;

    /* renamed from: f  reason: collision with root package name */
    public List<l> f4491f;

    /* renamed from: g  reason: collision with root package name */
    public c f4492g;

    /* renamed from: h  reason: collision with root package name */
    public d<l> f4493h;

    /* renamed from: i  reason: collision with root package name */
    public d<l> f4494i;

    /* loaded from: classes.dex */
    public class a extends d.a.i0.r.w.b.b {
        public a() {
        }

        @Override // d.a.i0.r.w.b.b, d.a.i0.r.w.a
        public d.a.i0.r.w.b.c a() {
            d.a.i0.r.w.b.c cVar = new d.a.i0.r.w.b.c();
            cVar.c(R.drawable.icon_banner_gray_n);
            cVar.g(R.drawable.icon_banner_s);
            cVar.d(81);
            cVar.e(R.dimen.tbds26);
            cVar.h(R.dimen.tbds10);
            return cVar;
        }

        @Override // d.a.i0.r.w.b.b, d.a.i0.r.w.a
        public e c() {
            e eVar = new e();
            eVar.a(d.a.c.e.p.l.g(AutoBannerLayout.this.getContext(), R.dimen.tbds209));
            return eVar;
        }

        @Override // d.a.i0.r.w.b.b, d.a.i0.r.w.a
        public TbImageView d(Context context) {
            TbImageView tbImageView = new TbImageView(context);
            tbImageView.setPlaceHolder(2);
            tbImageView.setLongIconSupport(false);
            tbImageView.setGifIconSupport(false);
            tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            tbImageView.setDrawerType(1);
            tbImageView.setRadius(d.a.c.e.p.l.g(AutoBannerLayout.this.getContext(), R.dimen.tbds12));
            return tbImageView;
        }
    }

    /* loaded from: classes.dex */
    public class b implements d<l> {
        public b() {
        }

        @Override // d.a.i0.r.w.b.d
        public void b(int i2, String str) {
            AutoBannerLayout.this.e(str);
            int count = ListUtils.getCount(AutoBannerLayout.this.f4491f);
            if (i2 < 0 || i2 > count || AutoBannerLayout.this.f4493h == null) {
                return;
            }
            AutoBannerLayout.this.f4493h.b(i2, str);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.r.w.b.d
        /* renamed from: c */
        public void a(int i2, l lVar) {
            int count = ListUtils.getCount(AutoBannerLayout.this.f4491f);
            if (i2 < 0 || i2 > count || AutoBannerLayout.this.f4493h == null) {
                return;
            }
            AutoBannerLayout.this.f4493h.a(i2, lVar);
        }
    }

    public AutoBannerLayout(Context context) {
        this(context, null);
    }

    public void d() {
        CoverFlowView<l> coverFlowView = this.f4490e;
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
        this.f4490e = new CoverFlowView<>(getContext());
        a aVar = new a();
        this.f4490e.setPageMargin(d.a.c.e.p.l.g(getContext(), R.dimen.tbds42));
        this.f4490e.setIndicatorNoOffet(false);
        this.f4490e.setDisableParentEvent(false);
        this.f4490e.setCoverFlowFactory(aVar);
        this.f4490e.setIndicatorVisible(0);
        this.f4490e.setIsAutoPlayDragging(false);
        this.f4490e.setCallback(this.f4494i);
        addView(this.f4490e);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i.p
    /* renamed from: g */
    public void a(m mVar) {
        if (mVar != null && !ListUtils.isEmpty(mVar.f49218e)) {
            h(mVar.f49218e);
        } else {
            setVisibility(8);
        }
    }

    public CoverFlowView getCoverFlowView() {
        return this.f4490e;
    }

    public void h(List<l> list) {
        if (list != null && !ListUtils.isEmpty(list)) {
            setVisibility(0);
            this.f4491f = list;
            this.f4490e.setData(list);
            return;
        }
        setVisibility(8);
    }

    @Override // d.a.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        CoverFlowView<l> coverFlowView = this.f4490e;
        if (coverFlowView != null) {
            coverFlowView.s();
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        if (this.f4492g != null) {
            this.f4492g.a(this, i2 == 0, null);
        }
    }

    public void setBannerHeight(int i2) {
        if (this.f4490e != null) {
            e eVar = new e();
            eVar.a(i2);
            this.f4490e.x(eVar);
        }
    }

    public void setIWindowChangedListener(c cVar) {
        this.f4492g = cVar;
    }

    public void setIndicatorVisible(int i2) {
        CoverFlowView<l> coverFlowView = this.f4490e;
        if (coverFlowView != null) {
            coverFlowView.setIndicatorVisible(i2);
        }
    }

    public void setMarqueenTime(long j) {
        CoverFlowView<l> coverFlowView = this.f4490e;
        if (coverFlowView != null) {
            coverFlowView.setMarqueenTime(j);
        }
    }

    public void setOnCoverViewCallback(d<l> dVar) {
        this.f4493h = dVar;
    }

    public void setPageMargin(int i2) {
        CoverFlowView<l> coverFlowView = this.f4490e;
        if (coverFlowView != null) {
            coverFlowView.setPageMargin(i2);
        }
    }

    public AutoBannerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AutoBannerLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f4490e = null;
        this.f4491f = null;
        this.f4494i = new b();
        f();
    }
}

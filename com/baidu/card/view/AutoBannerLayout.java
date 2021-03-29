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
import d.b.b.a.j;
import d.b.h0.m.c;
import d.b.h0.r.q.l;
import d.b.h0.r.q.m;
import d.b.h0.r.w.b.d;
import d.b.h0.r.w.b.e;
import d.b.i.p;
import d.b.i.q;
import java.util.List;
/* loaded from: classes.dex */
public class AutoBannerLayout extends RelativeLayout implements q, p<m> {

    /* renamed from: e  reason: collision with root package name */
    public CoverFlowView<l> f4375e;

    /* renamed from: f  reason: collision with root package name */
    public List<l> f4376f;

    /* renamed from: g  reason: collision with root package name */
    public c f4377g;

    /* renamed from: h  reason: collision with root package name */
    public d<l> f4378h;
    public d<l> i;

    /* loaded from: classes.dex */
    public class a extends d.b.h0.r.w.b.b {
        public a() {
        }

        @Override // d.b.h0.r.w.b.b, d.b.h0.r.w.a
        public d.b.h0.r.w.b.c a() {
            d.b.h0.r.w.b.c cVar = new d.b.h0.r.w.b.c();
            cVar.c(R.drawable.icon_banner_gray_n);
            cVar.g(R.drawable.icon_banner_s);
            cVar.d(81);
            cVar.e(R.dimen.tbds26);
            cVar.h(R.dimen.tbds10);
            return cVar;
        }

        @Override // d.b.h0.r.w.b.b, d.b.h0.r.w.a
        public TbImageView c(Context context) {
            TbImageView tbImageView = new TbImageView(context);
            tbImageView.setPlaceHolder(2);
            tbImageView.setLongIconSupport(false);
            tbImageView.setGifIconSupport(false);
            tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            tbImageView.setDrawerType(1);
            tbImageView.setRadius(d.b.b.e.p.l.g(AutoBannerLayout.this.getContext(), R.dimen.tbds12));
            return tbImageView;
        }

        @Override // d.b.h0.r.w.b.b, d.b.h0.r.w.a
        public e d() {
            e eVar = new e();
            eVar.a(d.b.b.e.p.l.g(AutoBannerLayout.this.getContext(), R.dimen.tbds209));
            return eVar;
        }
    }

    /* loaded from: classes.dex */
    public class b implements d<l> {
        public b() {
        }

        @Override // d.b.h0.r.w.b.d
        public void b(int i, String str) {
            AutoBannerLayout.this.e(str);
            int count = ListUtils.getCount(AutoBannerLayout.this.f4376f);
            if (i < 0 || i > count || AutoBannerLayout.this.f4378h == null) {
                return;
            }
            AutoBannerLayout.this.f4378h.b(i, str);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.r.w.b.d
        /* renamed from: c */
        public void a(int i, l lVar) {
            int count = ListUtils.getCount(AutoBannerLayout.this.f4376f);
            if (i < 0 || i > count || AutoBannerLayout.this.f4378h == null) {
                return;
            }
            AutoBannerLayout.this.f4378h.a(i, lVar);
        }
    }

    public AutoBannerLayout(Context context) {
        this(context, null);
    }

    public void d() {
        CoverFlowView<l> coverFlowView = this.f4375e;
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
        this.f4375e = new CoverFlowView<>(getContext());
        a aVar = new a();
        this.f4375e.setPageMargin(d.b.b.e.p.l.g(getContext(), R.dimen.tbds42));
        this.f4375e.setIndicatorNoOffet(false);
        this.f4375e.setDisableParentEvent(false);
        this.f4375e.setCoverFlowFactory(aVar);
        this.f4375e.setIndicatorVisible(0);
        this.f4375e.setIsAutoPlayDragging(false);
        this.f4375e.setCallback(this.i);
        addView(this.f4375e);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i.p
    /* renamed from: g */
    public void a(m mVar) {
        if (mVar != null && !ListUtils.isEmpty(mVar.f50846e)) {
            h(mVar.f50846e);
        } else {
            setVisibility(8);
        }
    }

    public CoverFlowView getCoverFlowView() {
        return this.f4375e;
    }

    public void h(List<l> list) {
        if (list != null && !ListUtils.isEmpty(list)) {
            setVisibility(0);
            this.f4376f = list;
            this.f4375e.setData(list);
            return;
        }
        setVisibility(8);
    }

    @Override // d.b.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        CoverFlowView<l> coverFlowView = this.f4375e;
        if (coverFlowView != null) {
            coverFlowView.s();
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.f4377g != null) {
            this.f4377g.a(this, i == 0, null);
        }
    }

    public void setBannerHeight(int i) {
        if (this.f4375e != null) {
            e eVar = new e();
            eVar.a(i);
            this.f4375e.x(eVar);
        }
    }

    public void setIWindowChangedListener(c cVar) {
        this.f4377g = cVar;
    }

    public void setIndicatorVisible(int i) {
        CoverFlowView<l> coverFlowView = this.f4375e;
        if (coverFlowView != null) {
            coverFlowView.setIndicatorVisible(i);
        }
    }

    public void setMarqueenTime(long j) {
        CoverFlowView<l> coverFlowView = this.f4375e;
        if (coverFlowView != null) {
            coverFlowView.setMarqueenTime(j);
        }
    }

    public void setOnCoverViewCallback(d<l> dVar) {
        this.f4378h = dVar;
    }

    public void setPageMargin(int i) {
        CoverFlowView<l> coverFlowView = this.f4375e;
        if (coverFlowView != null) {
            coverFlowView.setPageMargin(i);
        }
    }

    public AutoBannerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AutoBannerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4375e = null;
        this.f4376f = null;
        this.i = new b();
        f();
    }
}

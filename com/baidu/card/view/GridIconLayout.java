package com.baidu.card.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.RoundTbImageView;
import com.baidu.tbadk.widget.extend.XGridLayout;
import com.baidu.tieba.R;
import d.b.b.a.j;
import d.b.h0.m.c;
import d.b.h0.m.e;
import d.b.h0.m.f;
import d.b.h0.r.q.k0;
import d.b.h0.r.q.l;
import d.b.i.p;
import d.b.i.q;
import java.util.List;
/* loaded from: classes2.dex */
public class GridIconLayout extends FrameLayout implements q, p<k0> {

    /* renamed from: e  reason: collision with root package name */
    public XGridLayout f4412e;

    /* renamed from: f  reason: collision with root package name */
    public f<l> f4413f;

    /* renamed from: g  reason: collision with root package name */
    public c f4414g;

    /* renamed from: h  reason: collision with root package name */
    public e<l> f4415h;
    public d.b.h0.b1.f.a.a i;

    /* loaded from: classes2.dex */
    public class a implements e<l> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.m.e
        /* renamed from: b */
        public void a(View view, l lVar, int i, long j) {
            if (lVar != null) {
                GridIconLayout.this.c(lVar.c());
            }
            if (GridIconLayout.this.f4413f != null) {
                GridIconLayout.this.f4413f.a(view, lVar, i, j);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends d.b.h0.b1.f.a.a<l> {
        public b(Context context, int i) {
            super(context, i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.b1.f.a.a
        /* renamed from: i */
        public void f(d.b.h0.b1.f.a.c cVar, l lVar, int i) {
            RoundTbImageView roundTbImageView = (RoundTbImageView) cVar.b(R.id.iv_icon);
            roundTbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            roundTbImageView.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
            roundTbImageView.setPlaceHolder(1);
            roundTbImageView.W(lVar.d(), 10, false);
            TextView textView = (TextView) cVar.b(R.id.tv_title);
            SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
            textView.setText(lVar.e());
            if (GridIconLayout.this.f4413f != null) {
                GridIconLayout.this.f4413f.c(cVar.a(), lVar, i, i);
            }
        }
    }

    public GridIconLayout(Context context) {
        this(context, null);
    }

    public void c(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            UrlManager.getInstance().dealOneLink((TbPageContext) j.a(getContext()), new String[]{str});
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void d() {
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        XGridLayout xGridLayout = new XGridLayout(getContext());
        this.f4412e = xGridLayout;
        addView(xGridLayout);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i.p
    /* renamed from: e */
    public void a(k0 k0Var) {
        if (k0Var != null && !ListUtils.isEmpty(k0Var.f50826e)) {
            setVisibility(0);
            List<l> list = k0Var.f50826e;
            this.f4412e.setAutoGridSpan(list, 5);
            this.f4412e.setAdapter(this.i);
            this.i.h(this.f4415h);
            this.i.g(list);
            return;
        }
        setVisibility(8);
    }

    @Override // d.b.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        SkinManager.setBackgroundColor(this, R.color.CAM_X0205);
        XGridLayout xGridLayout = this.f4412e;
        if (xGridLayout != null) {
            xGridLayout.d();
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.f4414g != null) {
            this.f4414g.a(this, i == 0, null);
        }
    }

    public void setHorizontalSpace(int i) {
        this.f4412e.setHorizontalSpace(i);
    }

    public void setIWindowChangedListener(c cVar) {
        this.f4414g = cVar;
    }

    public void setMarginsTop(View view, int i) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if (marginLayoutParams.topMargin != i) {
                marginLayoutParams.topMargin = i;
                view.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public void setMaxItem(int i) {
        this.f4412e.setMaxItem(i);
    }

    public void setOnItemCoverListener(f<l> fVar) {
        this.f4413f = fVar;
    }

    public void setVerticalSpace(int i) {
        this.f4412e.setVerticalSpace(i);
    }

    public GridIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4415h = new a();
        this.i = new b(getContext(), R.layout.grid_icon_item);
        d();
    }
}

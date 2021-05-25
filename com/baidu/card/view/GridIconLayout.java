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
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.extend.XGridLayout;
import com.baidu.tieba.R;
import d.a.c.a.j;
import d.a.i.p;
import d.a.i.q;
import d.a.m0.m.c;
import d.a.m0.m.e;
import d.a.m0.m.f;
import d.a.m0.r.q.k0;
import d.a.m0.r.q.l;
import java.util.List;
/* loaded from: classes.dex */
public class GridIconLayout extends FrameLayout implements q, p<k0> {

    /* renamed from: e  reason: collision with root package name */
    public XGridLayout f4388e;

    /* renamed from: f  reason: collision with root package name */
    public f<l> f4389f;

    /* renamed from: g  reason: collision with root package name */
    public c f4390g;

    /* renamed from: h  reason: collision with root package name */
    public e<l> f4391h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.m0.b1.f.a.a f4392i;

    /* loaded from: classes.dex */
    public class a implements e<l> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.m.e
        /* renamed from: b */
        public void a(View view, l lVar, int i2, long j) {
            if (lVar != null) {
                GridIconLayout.this.c(lVar.c());
            }
            if (GridIconLayout.this.f4389f != null) {
                GridIconLayout.this.f4389f.a(view, lVar, i2, j);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends d.a.m0.b1.f.a.a<l> {
        public b(Context context, int i2) {
            super(context, i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.b1.f.a.a
        /* renamed from: i */
        public void f(d.a.m0.b1.f.a.c cVar, l lVar, int i2) {
            TbImageView tbImageView = (TbImageView) cVar.b(R.id.iv_icon);
            tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            tbImageView.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
            tbImageView.setPlaceHolder(1);
            tbImageView.V(lVar.d(), 10, false);
            TextView textView = (TextView) cVar.b(R.id.tv_title);
            SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
            textView.setText(lVar.e());
            if (GridIconLayout.this.f4389f != null) {
                GridIconLayout.this.f4389f.c(cVar.a(), lVar, i2, i2);
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
        this.f4388e = xGridLayout;
        addView(xGridLayout);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i.p
    /* renamed from: e */
    public void a(k0 k0Var) {
        if (k0Var != null && !ListUtils.isEmpty(k0Var.f50062e)) {
            setVisibility(0);
            List<l> list = k0Var.f50062e;
            if ((list != null ? list.size() : 0) % 4 == 0) {
                this.f4388e.setAutoGridSpan(list, 4);
            } else {
                this.f4388e.setAutoGridSpan(list, 5);
            }
            this.f4388e.setAdapter(this.f4392i);
            this.f4392i.h(this.f4391h);
            this.f4392i.g(list);
            return;
        }
        setVisibility(8);
    }

    @Override // d.a.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        d.a.m0.r.u.c d2 = d.a.m0.r.u.c.d(this);
        d2.m(R.string.J_X06);
        d2.f(R.color.CAM_X0205);
        XGridLayout xGridLayout = this.f4388e;
        if (xGridLayout != null) {
            xGridLayout.d();
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        if (this.f4390g != null) {
            this.f4390g.a(this, i2 == 0, null);
        }
    }

    public void setHorizontalSpace(int i2) {
        this.f4388e.setHorizontalSpace(i2);
    }

    public void setIWindowChangedListener(c cVar) {
        this.f4390g = cVar;
    }

    public void setMarginsTop(View view, int i2) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if (marginLayoutParams.topMargin != i2) {
                marginLayoutParams.topMargin = i2;
                view.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public void setMaxItem(int i2) {
        this.f4388e.setMaxItem(i2);
    }

    public void setOnItemCoverListener(f<l> fVar) {
        this.f4389f = fVar;
    }

    public void setVerticalSpace(int i2) {
        this.f4388e.setVerticalSpace(i2);
    }

    public GridIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4391h = new a();
        this.f4392i = new b(getContext(), R.layout.grid_icon_item);
        d();
    }
}

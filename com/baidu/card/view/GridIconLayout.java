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
import d.a.c.a.j;
import d.a.i.p;
import d.a.i.q;
import d.a.i0.m.c;
import d.a.i0.m.e;
import d.a.i0.m.f;
import d.a.i0.r.q.k0;
import d.a.i0.r.q.l;
import java.util.List;
/* loaded from: classes.dex */
public class GridIconLayout extends FrameLayout implements q, p<k0> {

    /* renamed from: e  reason: collision with root package name */
    public XGridLayout f4534e;

    /* renamed from: f  reason: collision with root package name */
    public f<l> f4535f;

    /* renamed from: g  reason: collision with root package name */
    public c f4536g;

    /* renamed from: h  reason: collision with root package name */
    public e<l> f4537h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.i0.b1.f.a.a f4538i;

    /* loaded from: classes.dex */
    public class a implements e<l> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.m.e
        /* renamed from: b */
        public void a(View view, l lVar, int i2, long j) {
            if (lVar != null) {
                GridIconLayout.this.c(lVar.c());
            }
            if (GridIconLayout.this.f4535f != null) {
                GridIconLayout.this.f4535f.a(view, lVar, i2, j);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends d.a.i0.b1.f.a.a<l> {
        public b(Context context, int i2) {
            super(context, i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.b1.f.a.a
        /* renamed from: i */
        public void f(d.a.i0.b1.f.a.c cVar, l lVar, int i2) {
            RoundTbImageView roundTbImageView = (RoundTbImageView) cVar.b(R.id.iv_icon);
            roundTbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            roundTbImageView.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
            roundTbImageView.setPlaceHolder(1);
            roundTbImageView.V(lVar.d(), 10, false);
            TextView textView = (TextView) cVar.b(R.id.tv_title);
            SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
            textView.setText(lVar.e());
            if (GridIconLayout.this.f4535f != null) {
                GridIconLayout.this.f4535f.c(cVar.a(), lVar, i2, i2);
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
        this.f4534e = xGridLayout;
        addView(xGridLayout);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i.p
    /* renamed from: e */
    public void a(k0 k0Var) {
        if (k0Var != null && !ListUtils.isEmpty(k0Var.f49199e)) {
            setVisibility(0);
            List<l> list = k0Var.f49199e;
            this.f4534e.setAutoGridSpan(list, 5);
            this.f4534e.setAdapter(this.f4538i);
            this.f4538i.h(this.f4537h);
            this.f4538i.g(list);
            return;
        }
        setVisibility(8);
    }

    @Override // d.a.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        SkinManager.setBackgroundColor(this, R.color.CAM_X0205);
        XGridLayout xGridLayout = this.f4534e;
        if (xGridLayout != null) {
            xGridLayout.d();
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        if (this.f4536g != null) {
            this.f4536g.a(this, i2 == 0, null);
        }
    }

    public void setHorizontalSpace(int i2) {
        this.f4534e.setHorizontalSpace(i2);
    }

    public void setIWindowChangedListener(c cVar) {
        this.f4536g = cVar;
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
        this.f4534e.setMaxItem(i2);
    }

    public void setOnItemCoverListener(f<l> fVar) {
        this.f4535f = fVar;
    }

    public void setVerticalSpace(int i2) {
        this.f4534e.setVerticalSpace(i2);
    }

    public GridIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4537h = new a();
        this.f4538i = new b(getContext(), R.layout.grid_icon_item);
        d();
    }
}

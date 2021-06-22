package com.baidu.card.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.ThreadForumEnterButton;
import com.baidu.tbadk.core.view.ThreadForumEnterGoodsButton;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.n0.b.d;
import d.a.n0.r.q.a2;
import d.a.n0.r.u.c;
/* loaded from: classes.dex */
public class ForumEnterLayout extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f4397e;

    /* renamed from: f  reason: collision with root package name */
    public ThreadForumEnterButton f4398f;

    /* renamed from: g  reason: collision with root package name */
    public ThreadForumEnterGoodsButton f4399g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f4400h;

    /* renamed from: i  reason: collision with root package name */
    public EMTextView f4401i;
    public d.a.n0.r.q.a j;
    public Drawable k;
    public final int l;
    public final int m;
    public int n;
    public int o;
    public View.OnClickListener p;
    public final View.OnClickListener q;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == ForumEnterLayout.this.f4400h) {
                ThreadCardUtils.jumpToPBCommentArea(ForumEnterLayout.this.j, view.getContext(), ForumEnterLayout.this.o, 2);
            } else if (view == ForumEnterLayout.this.f4398f && ForumEnterLayout.this.p != null) {
                ForumEnterLayout.this.p.onClick(view);
            }
            if (ForumEnterLayout.this.j != null) {
                ForumEnterLayout forumEnterLayout = ForumEnterLayout.this;
                forumEnterLayout.h(view, forumEnterLayout.j.i());
            }
        }
    }

    public ForumEnterLayout(Context context) {
        super(context);
        this.l = l.g(TbadkApplication.getInst(), R.dimen.tbds44);
        this.m = l.g(TbadkApplication.getInst(), R.dimen.tbds60);
        this.o = 0;
        this.q = new a();
        i(context);
    }

    private Drawable getArrowRight() {
        Drawable drawable = this.k;
        if (drawable == null || drawable.mutate() == null) {
            WebPManager.getPureDrawable(R.drawable.icon_pure_arrow12_right, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        return this.k;
    }

    public void g() {
        int k = (l.k(this.f4397e) - (this.l * 2)) - this.m;
        if (k > 0) {
            this.n = k / 2;
        } else {
            this.n = l.g(this.f4397e, R.dimen.tbds540);
        }
        this.f4400h.setMaxWidth(this.n);
    }

    public final void h(View view, a2 a2Var) {
        if (a2Var == null) {
            return;
        }
        int id = view.getId();
        String str = null;
        if (id == R.id.forum_enter_button) {
            str = "c13693";
        } else if (id == R.id.text_post) {
            str = "c13695";
        }
        int i2 = 0;
        int i3 = this.o;
        if (i3 == 1) {
            i2 = 2;
        } else if (i3 == 2) {
            i2 = 1;
        } else if (i3 == 4) {
            i2 = 3;
        }
        if (str == null || i2 <= 0) {
            return;
        }
        TiebaStatic.log(d.a.o0.d3.a.n(str, a2Var, i2));
    }

    public final void i(Context context) {
        this.f4397e = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.card_home_page_forum_enter_item, (ViewGroup) this, true);
        TextView textView = (TextView) inflate.findViewById(R.id.text_post);
        this.f4400h = textView;
        textView.setCompoundDrawablePadding(l.g(context, R.dimen.tbds10));
        this.f4398f = (ThreadForumEnterButton) inflate.findViewById(R.id.forum_enter_button);
        this.f4399g = (ThreadForumEnterGoodsButton) inflate.findViewById(R.id.forum_enter_goods_button);
        this.f4398f.setAfterClickListener(this.q);
        this.f4399g.setAfterClickListener(this.q);
        this.f4400h.setOnClickListener(this.q);
        this.f4401i = (EMTextView) inflate.findViewById(R.id.tv_ueg);
    }

    public final boolean j(a2 a2Var) {
        return (a2Var == null || a2Var.T() == null || !a2Var.W1 || !d.h() || a2Var.T().hadConcerned() || ThreadCardUtils.isSelf(a2Var)) ? false : true;
    }

    public final boolean k(a2 a2Var) {
        return a2Var != null && a2Var.V1 && a2Var.H2();
    }

    public final boolean l(d.a.n0.r.q.a aVar) {
        return (aVar == null || aVar.i() == null || !aVar.i().D2() || aVar.i().x1() == null) ? false : true;
    }

    public final boolean m(d.a.n0.r.q.a aVar) {
        return (aVar == null || aVar.i() == null || aVar.i().P0() == null || aVar.i().P0().getOptions() == null || aVar.i().P0().getOptions().size() <= 0) ? false : true;
    }

    public void n(TbPageContext tbPageContext, int i2) {
        this.f4398f.d();
        this.f4399g.e();
        this.k = getArrowRight();
        c d2 = c.d(this.f4401i);
        d2.s(R.color.CAM_X0109);
        d2.x(R.string.F_X01);
    }

    public void setData(d.a.n0.r.q.a aVar) {
        boolean z;
        this.j = aVar;
        g();
        a2 i2 = aVar.i();
        if (!k(i2) && ((aVar.q() || !i2.V1) && !StringUtils.isNull(i2.i0()) && !j(i2))) {
            this.f4398f.setVisibility(0);
            this.f4398f.b(i2, this.n);
            z = true;
        } else {
            this.f4398f.setVisibility(8);
            z = false;
        }
        if (!m(aVar) && !l(aVar) && aVar.t() && aVar.i().e2()) {
            this.f4399g.setVisibility(0);
            this.f4399g.a(i2);
            z = true;
        } else {
            this.f4399g.setVisibility(8);
        }
        if (ThreadCardUtils.isSelf(i2) && i2.e2) {
            this.f4400h.setVisibility(0);
            this.f4400h.setTextSize(0, l.g(getContext(), R.dimen.tbds32));
            this.f4400h.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            SkinManager.setViewTextColor(this.f4400h, R.color.CAM_X0109);
            this.f4400h.setText(R.string.private_desc);
            this.f4400h.setOnClickListener(null);
            z = true;
        } else {
            this.f4400h.setVisibility(8);
        }
        int visibility = this.f4400h.getVisibility();
        if (i2.G2 == 1 && i2.Z1) {
            this.f4401i.setVisibility(0);
            this.f4400h.setVisibility(8);
        } else {
            this.f4401i.setVisibility(8);
            this.f4400h.setVisibility(visibility);
        }
        setVisibility(z ? 0 : 8);
    }

    public void setOnAfterClickListener(View.OnClickListener onClickListener) {
        this.p = onClickListener;
    }

    public void setSourceForPb(int i2) {
        this.o = i2;
    }

    public ForumEnterLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.l = l.g(TbadkApplication.getInst(), R.dimen.tbds44);
        this.m = l.g(TbadkApplication.getInst(), R.dimen.tbds60);
        this.o = 0;
        this.q = new a();
        i(context);
    }

    public ForumEnterLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.l = l.g(TbadkApplication.getInst(), R.dimen.tbds44);
        this.m = l.g(TbadkApplication.getInst(), R.dimen.tbds60);
        this.o = 0;
        this.q = new a();
        i(context);
    }
}

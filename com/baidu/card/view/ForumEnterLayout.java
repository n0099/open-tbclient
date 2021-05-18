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
import d.a.j0.b.d;
import d.a.j0.r.q.a2;
import d.a.j0.r.u.c;
/* loaded from: classes.dex */
public class ForumEnterLayout extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f4375e;

    /* renamed from: f  reason: collision with root package name */
    public ThreadForumEnterButton f4376f;

    /* renamed from: g  reason: collision with root package name */
    public ThreadForumEnterGoodsButton f4377g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f4378h;

    /* renamed from: i  reason: collision with root package name */
    public EMTextView f4379i;
    public d.a.j0.r.q.a j;
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
            if (view == ForumEnterLayout.this.f4378h) {
                ThreadCardUtils.jumpToPBCommentArea(ForumEnterLayout.this.j, view.getContext(), ForumEnterLayout.this.o, 2);
            } else if (view == ForumEnterLayout.this.f4376f && ForumEnterLayout.this.p != null) {
                ForumEnterLayout.this.p.onClick(view);
            }
            if (ForumEnterLayout.this.j != null) {
                ForumEnterLayout forumEnterLayout = ForumEnterLayout.this;
                forumEnterLayout.h(view, forumEnterLayout.j.m());
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
        int k = (l.k(this.f4375e) - (this.l * 2)) - this.m;
        if (k > 0) {
            this.n = k / 2;
        } else {
            this.n = l.g(this.f4375e, R.dimen.tbds540);
        }
        this.f4378h.setMaxWidth(this.n);
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
        TiebaStatic.log(d.a.k0.c3.a.n(str, a2Var, i2));
    }

    public final void i(Context context) {
        this.f4375e = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.card_home_page_forum_enter_item, (ViewGroup) this, true);
        TextView textView = (TextView) inflate.findViewById(R.id.text_post);
        this.f4378h = textView;
        textView.setCompoundDrawablePadding(l.g(context, R.dimen.tbds10));
        this.f4376f = (ThreadForumEnterButton) inflate.findViewById(R.id.forum_enter_button);
        this.f4377g = (ThreadForumEnterGoodsButton) inflate.findViewById(R.id.forum_enter_goods_button);
        this.f4376f.setAfterClickListener(this.q);
        this.f4377g.setAfterClickListener(this.q);
        this.f4378h.setOnClickListener(this.q);
        this.f4379i = (EMTextView) inflate.findViewById(R.id.tv_ueg);
    }

    public final boolean j(a2 a2Var) {
        return (a2Var == null || a2Var.T() == null || !a2Var.U1 || !d.h() || a2Var.T().hadConcerned() || ThreadCardUtils.isSelf(a2Var)) ? false : true;
    }

    public final boolean k(d.a.j0.r.q.a aVar) {
        return (aVar == null || aVar.m() == null || !aVar.m().B2() || aVar.m().v1() == null) ? false : true;
    }

    public final boolean l(d.a.j0.r.q.a aVar) {
        return (aVar == null || aVar.m() == null || aVar.m().O0() == null || aVar.m().O0().getOptions() == null || aVar.m().O0().getOptions().size() <= 0) ? false : true;
    }

    public void m(TbPageContext tbPageContext, int i2) {
        this.f4376f.d();
        this.f4377g.e();
        this.k = getArrowRight();
        c d2 = c.d(this.f4379i);
        d2.q(R.color.CAM_X0109);
        d2.v(R.string.F_X01);
    }

    public void setData(d.a.j0.r.q.a aVar) {
        boolean z;
        this.j = aVar;
        g();
        a2 m = aVar.m();
        if (aVar.u() && !m.T1 && !StringUtils.isNull(m.i0()) && !j(m)) {
            this.f4376f.setVisibility(0);
            this.f4376f.b(m, this.n);
            z = true;
        } else {
            this.f4376f.setVisibility(8);
            z = false;
        }
        if (!l(aVar) && !k(aVar) && aVar.v() && aVar.m().c2()) {
            this.f4377g.setVisibility(0);
            this.f4377g.a(m);
            z = true;
        } else {
            this.f4377g.setVisibility(8);
        }
        if (ThreadCardUtils.isSelf(m) && m.b2) {
            this.f4378h.setVisibility(0);
            this.f4378h.setTextSize(0, l.g(getContext(), R.dimen.tbds32));
            this.f4378h.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            SkinManager.setViewTextColor(this.f4378h, R.color.CAM_X0109);
            this.f4378h.setText(R.string.private_desc);
            this.f4378h.setOnClickListener(null);
            z = true;
        } else {
            this.f4378h.setVisibility(8);
        }
        int visibility = this.f4378h.getVisibility();
        if (m.D2 == 1 && m.W1) {
            this.f4379i.setVisibility(0);
            this.f4378h.setVisibility(8);
        } else {
            this.f4379i.setVisibility(8);
            this.f4378h.setVisibility(visibility);
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

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
import d.b.b.e.p.l;
import d.b.h0.b.d;
import d.b.h0.r.q.a2;
import d.b.h0.r.u.c;
/* loaded from: classes2.dex */
public class ForumEnterLayout extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f4403e;

    /* renamed from: f  reason: collision with root package name */
    public ThreadForumEnterButton f4404f;

    /* renamed from: g  reason: collision with root package name */
    public ThreadForumEnterGoodsButton f4405g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f4406h;
    public EMTextView i;
    public d.b.h0.r.q.a j;
    public Drawable k;
    public final int l;
    public final int m;
    public int n;
    public int o;
    public View.OnClickListener p;
    public final View.OnClickListener q;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == ForumEnterLayout.this.f4406h) {
                ThreadCardUtils.jumpToPBCommentArea(ForumEnterLayout.this.j, view.getContext(), ForumEnterLayout.this.o, 2);
            } else if (view == ForumEnterLayout.this.f4404f && ForumEnterLayout.this.p != null) {
                ForumEnterLayout.this.p.onClick(view);
            }
            if (ForumEnterLayout.this.j != null) {
                ForumEnterLayout forumEnterLayout = ForumEnterLayout.this;
                forumEnterLayout.h(view, forumEnterLayout.j.n());
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
        int k = (l.k(this.f4403e) - (this.l * 2)) - this.m;
        if (k > 0) {
            this.n = k / 2;
        } else {
            this.n = l.g(this.f4403e, R.dimen.tbds540);
        }
        this.f4406h.setMaxWidth(this.n);
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
        int i = 0;
        int i2 = this.o;
        if (i2 == 1) {
            i = 2;
        } else if (i2 == 2) {
            i = 1;
        } else if (i2 == 4) {
            i = 3;
        }
        if (str == null || i <= 0) {
            return;
        }
        TiebaStatic.log(d.b.i0.b3.a.n(str, a2Var, i));
    }

    public final void i(Context context) {
        this.f4403e = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.card_home_page_forum_enter_item, (ViewGroup) this, true);
        TextView textView = (TextView) inflate.findViewById(R.id.text_post);
        this.f4406h = textView;
        textView.setCompoundDrawablePadding(l.g(context, R.dimen.tbds10));
        this.f4404f = (ThreadForumEnterButton) inflate.findViewById(R.id.forum_enter_button);
        this.f4405g = (ThreadForumEnterGoodsButton) inflate.findViewById(R.id.forum_enter_goods_button);
        this.f4404f.setAfterClickListener(this.q);
        this.f4405g.setAfterClickListener(this.q);
        this.f4406h.setOnClickListener(this.q);
        this.i = (EMTextView) inflate.findViewById(R.id.tv_ueg);
    }

    public final boolean j(a2 a2Var) {
        return (a2Var == null || a2Var.T() == null || !a2Var.U1 || !d.h() || a2Var.T().hadConcerned() || ThreadCardUtils.isSelf(a2Var)) ? false : true;
    }

    public final boolean k(d.b.h0.r.q.a aVar) {
        return (aVar == null || aVar.n() == null || !aVar.n().y2() || aVar.n().u1() == null) ? false : true;
    }

    public final boolean l(d.b.h0.r.q.a aVar) {
        return (aVar == null || aVar.n() == null || aVar.n().O0() == null || aVar.n().O0().getOptions() == null || aVar.n().O0().getOptions().size() <= 0) ? false : true;
    }

    public void m(TbPageContext tbPageContext, int i) {
        this.f4404f.d();
        this.f4405g.e();
        this.k = getArrowRight();
        c a2 = c.a(this.i);
        a2.n(R.color.CAM_X0109);
        a2.s(R.string.F_X01);
    }

    public void setData(d.b.h0.r.q.a aVar) {
        boolean z;
        this.j = aVar;
        g();
        a2 n = aVar.n();
        if ((aVar.u() || !n.T1) && !StringUtils.isNull(n.i0()) && !j(n)) {
            this.f4404f.setVisibility(0);
            this.f4404f.b(n, this.n);
            z = true;
        } else {
            this.f4404f.setVisibility(8);
            z = false;
        }
        if (!l(aVar) && !k(aVar) && aVar.v() && aVar.n().a2()) {
            this.f4405g.setVisibility(0);
            this.f4405g.a(n);
            z = true;
        } else {
            this.f4405g.setVisibility(8);
        }
        if (ThreadCardUtils.isSelf(n) && n.b2) {
            this.f4406h.setVisibility(0);
            this.f4406h.setTextSize(0, l.g(getContext(), R.dimen.tbds32));
            this.f4406h.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            SkinManager.setViewTextColor(this.f4406h, R.color.CAM_X0109);
            this.f4406h.setText(R.string.private_desc);
            this.f4406h.setOnClickListener(null);
            z = true;
        } else {
            this.f4406h.setVisibility(8);
        }
        int visibility = this.f4406h.getVisibility();
        if (n.D2 == 1 && n.W1) {
            this.i.setVisibility(0);
            this.f4406h.setVisibility(8);
        } else {
            this.i.setVisibility(8);
            this.f4406h.setVisibility(visibility);
        }
        setVisibility(z ? 0 : 8);
    }

    public void setOnAfterClickListener(View.OnClickListener onClickListener) {
        this.p = onClickListener;
    }

    public void setSourceForPb(int i) {
        this.o = i;
    }

    public ForumEnterLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.l = l.g(TbadkApplication.getInst(), R.dimen.tbds44);
        this.m = l.g(TbadkApplication.getInst(), R.dimen.tbds60);
        this.o = 0;
        this.q = new a();
        i(context);
    }

    public ForumEnterLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.l = l.g(TbadkApplication.getInst(), R.dimen.tbds44);
        this.m = l.g(TbadkApplication.getInst(), R.dimen.tbds60);
        this.o = 0;
        this.q = new a();
        i(context);
    }
}

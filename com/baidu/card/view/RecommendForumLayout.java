package com.baidu.card.view;

import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.adapter.HorizontalRecommendForumAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout;
import com.baidu.tbadk.widget.horizontalpullview.RefreshView;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.i.q;
import d.a.m0.g0.b.a;
import d.a.m0.m.f;
import d.a.m0.r.q.n;
import d.a.m0.r.q.n1;
import d.a.m0.r.q.o1;
import d.a.m0.r.u.c;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class RecommendForumLayout extends LinearLayout implements q {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f4492e;

    /* renamed from: f  reason: collision with root package name */
    public PullLeftRefreshLayout f4493f;

    /* renamed from: g  reason: collision with root package name */
    public RecyclerView f4494g;

    /* renamed from: h  reason: collision with root package name */
    public HorizontalRecommendForumAdapter f4495h;

    /* renamed from: i  reason: collision with root package name */
    public FrameLayout f4496i;
    public TextView j;
    public ImageView k;
    public boolean l;
    public boolean m;
    public boolean n;
    public RefreshView o;
    public int p;
    public String q;
    public boolean r;
    public View.OnClickListener s;
    public PullLeftRefreshLayout.f t;

    public RecommendForumLayout(TbPageContext<?> tbPageContext) {
        this(tbPageContext, null);
    }

    public void a(o1 o1Var) {
        this.k.setOnClickListener(this.s);
        if (!TextUtils.isEmpty(o1Var.f50090h) && o1Var.f50091i != 0) {
            this.j.setText(o1Var.f50090h);
        } else {
            this.j.setText(R.string.recommend_forum_title_horizontal);
            if (this.f4496i.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.f4496i.getLayoutParams()).topMargin = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds38);
                this.f4496i.requestLayout();
            }
        }
        if (!this.n) {
            this.k.setVisibility(8);
        }
        if (o1Var != null && o1Var.B() != null && o1Var.B().size() > 0) {
            ArrayList<? extends a> arrayList = new ArrayList<>();
            ArrayList<n1> B = o1Var.B();
            if (this.l) {
                if (this.m) {
                    arrayList.add(new n());
                }
                if (B != null) {
                    arrayList.addAll(B);
                }
            } else {
                if (B != null) {
                    arrayList.addAll(B);
                }
                if (this.m) {
                    arrayList.add(new n());
                }
            }
            this.f4495h.d(arrayList);
        }
        c();
    }

    public final void b() {
        LayoutInflater.from(getContext()).inflate(R.layout.recommend_forum_horizontal_view, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.f4496i = (FrameLayout) findViewById(R.id.title_view);
        TextView textView = (TextView) findViewById(R.id.tv_title);
        this.j = textView;
        c.d(textView).w(R.dimen.T_X07);
        this.k = (ImageView) findViewById(R.id.img_arrow);
        this.f4493f = (PullLeftRefreshLayout) findViewById(R.id.refresh_layout);
        this.f4494g = (RecyclerView) findViewById(R.id.recycler_view);
        HorizontalRecommendForumAdapter horizontalRecommendForumAdapter = new HorizontalRecommendForumAdapter(this.f4492e, this.p);
        this.f4495h = horizontalRecommendForumAdapter;
        int i2 = this.p;
        if (i2 == 0) {
            horizontalRecommendForumAdapter.e(this.r);
        } else if (i2 == 1) {
            horizontalRecommendForumAdapter.g(this.q);
        }
        this.f4494g.setLayoutManager(new LinearLayoutManager(this.f4492e.getPageActivity(), 0, false));
        this.f4494g.setAdapter(this.f4495h);
        this.f4494g.setClipChildren(false);
        this.f4495h.notifyDataSetChanged();
        this.j.setText(this.f4492e.getPageActivity().getString(R.string.recommend_forum_title_horizontal));
        RefreshView refreshView = new RefreshView(getContext());
        this.o = refreshView;
        this.f4493f.setRefreshViewAndListener(refreshView);
        this.f4493f.setCallback(this.t);
    }

    public void c() {
        c d2 = c.d(this);
        d2.m(R.string.J_X06);
        d2.f(R.color.CAM_X0205);
        c.d(this.j).s(R.color.CAM_X0105);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
        this.o.d();
        this.f4495h.notifyDataSetChanged();
    }

    @Override // d.a.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        c();
    }

    public void setData(o1 o1Var) {
        a(o1Var);
    }

    public void setEnableShowInto(boolean z) {
        this.n = z;
    }

    public void setFrom(int i2) {
        this.p = i2;
    }

    public void setHasLikeForum(boolean z) {
        this.r = z;
    }

    public void setOnClickRightArrowListener(View.OnClickListener onClickListener) {
        this.s = onClickListener;
    }

    public void setOnItemCoverListener(f<n1> fVar) {
        this.f4495h.f(fVar);
    }

    public void setOnRullOkCallbackr(PullLeftRefreshLayout.f fVar) {
        this.t = fVar;
        this.f4493f.setCallback(fVar);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
    }

    public void setShowMore(boolean z) {
        PullLeftRefreshLayout pullLeftRefreshLayout = this.f4493f;
        if (pullLeftRefreshLayout != null) {
            pullLeftRefreshLayout.setEnablePull(z);
        }
    }

    public void setShowSquareEntrance(boolean z) {
        this.m = z;
    }

    public void setSquareEntranceAtStart(boolean z) {
        this.l = z;
    }

    public void setTabName(String str) {
        this.q = str;
    }

    public RecommendForumLayout(TbPageContext<?> tbPageContext, @Nullable AttributeSet attributeSet) {
        super(tbPageContext.getPageActivity(), attributeSet);
        this.l = true;
        this.m = true;
        this.n = true;
        this.p = 0;
        this.f4492e = tbPageContext;
        b();
    }
}

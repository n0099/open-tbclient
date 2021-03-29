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
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout;
import com.baidu.tbadk.widget.horizontalpullview.RefreshView;
import com.baidu.tieba.R;
import d.b.b.e.p.l;
import d.b.h0.g0.b.a;
import d.b.h0.m.f;
import d.b.h0.r.q.n;
import d.b.h0.r.q.n1;
import d.b.h0.r.q.o1;
import d.b.i.q;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class RecommendForumLayout extends LinearLayout implements q {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f4506e;

    /* renamed from: f  reason: collision with root package name */
    public PullLeftRefreshLayout f4507f;

    /* renamed from: g  reason: collision with root package name */
    public RecyclerView f4508g;

    /* renamed from: h  reason: collision with root package name */
    public HorizontalRecommendForumAdapter f4509h;
    public FrameLayout i;
    public TextView j;
    public View k;
    public ImageView l;
    public ImageView m;
    public boolean n;
    public boolean o;
    public boolean p;
    public RefreshView q;
    public int r;
    public String s;
    public boolean t;
    public int u;
    public View.OnClickListener v;
    public PullLeftRefreshLayout.f w;

    public RecommendForumLayout(TbPageContext<?> tbPageContext) {
        this(tbPageContext, null);
    }

    public void a(o1 o1Var) {
        this.l.setOnClickListener(this.v);
        this.k.setOnClickListener(this.v);
        if (!TextUtils.isEmpty(o1Var.f50854h) && o1Var.i != 0) {
            this.j.setTextSize(0, l.g(getContext(), R.dimen.tbds37));
            this.j.setText(o1Var.f50854h);
            this.u = o1Var.i;
            this.k.setVisibility(0);
            this.l.setVisibility(8);
            if (this.i.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.i.getLayoutParams()).topMargin = 0;
                this.i.requestLayout();
            }
        } else {
            this.j.setTextSize(0, l.g(getContext(), R.dimen.tbds46));
            this.j.setText(R.string.recommend_forum_title_horizontal);
            this.u = R.color.CAM_X0105;
            this.k.setVisibility(8);
            this.l.setVisibility(0);
            if (this.i.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.i.getLayoutParams()).topMargin = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds38);
                this.i.requestLayout();
            }
        }
        if (!this.p) {
            this.k.setVisibility(8);
            this.l.setVisibility(8);
        }
        if (o1Var != null && o1Var.B() != null && o1Var.B().size() > 0) {
            ArrayList<? extends a> arrayList = new ArrayList<>();
            ArrayList<n1> B = o1Var.B();
            if (this.n) {
                if (this.o) {
                    arrayList.add(new n());
                }
                if (B != null) {
                    arrayList.addAll(B);
                }
            } else {
                if (B != null) {
                    arrayList.addAll(B);
                }
                if (this.o) {
                    arrayList.add(new n());
                }
            }
            this.f4509h.d(arrayList);
        }
        c();
    }

    public final void b() {
        LayoutInflater.from(getContext()).inflate(R.layout.recommend_forum_horizontal_view, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.i = (FrameLayout) findViewById(R.id.title_view);
        this.j = (TextView) findViewById(R.id.tv_title);
        this.k = findViewById(R.id.layout_into);
        this.l = (ImageView) findViewById(R.id.iv_into);
        this.m = (ImageView) findViewById(R.id.iv_into_s);
        this.f4507f = (PullLeftRefreshLayout) findViewById(R.id.refresh_layout);
        this.f4508g = (RecyclerView) findViewById(R.id.recycler_view);
        HorizontalRecommendForumAdapter horizontalRecommendForumAdapter = new HorizontalRecommendForumAdapter(this.f4506e, this.r);
        this.f4509h = horizontalRecommendForumAdapter;
        int i = this.r;
        if (i == 0) {
            horizontalRecommendForumAdapter.e(this.t);
        } else if (i == 1) {
            horizontalRecommendForumAdapter.g(this.s);
        }
        this.f4508g.setLayoutManager(new LinearLayoutManager(this.f4506e.getPageActivity(), 0, false));
        this.f4508g.setAdapter(this.f4509h);
        this.f4508g.setClipChildren(false);
        this.f4509h.notifyDataSetChanged();
        this.j.setText(this.f4506e.getPageActivity().getString(R.string.recommend_forum_title_horizontal));
        this.m.setClickable(false);
        RefreshView refreshView = new RefreshView(getContext());
        this.q = refreshView;
        this.f4507f.setRefreshViewAndListener(refreshView);
        this.f4507f.setCallback(this.w);
    }

    public void c() {
        SkinManager.setViewTextColor(this.j, this.u);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.l, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.m, R.drawable.icon_pure_list_arrow12_right_n_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
        this.q.d();
        this.f4509h.notifyDataSetChanged();
    }

    @Override // d.b.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        c();
    }

    public void setData(o1 o1Var) {
        a(o1Var);
    }

    public void setEnableShowInto(boolean z) {
        this.p = z;
    }

    public void setFrom(int i) {
        this.r = i;
    }

    public void setHasLikeForum(boolean z) {
        this.t = z;
    }

    public void setOnClickRightArrowListener(View.OnClickListener onClickListener) {
        this.v = onClickListener;
    }

    public void setOnItemCoverListener(f<n1> fVar) {
        this.f4509h.f(fVar);
    }

    public void setOnRullOkCallbackr(PullLeftRefreshLayout.f fVar) {
        this.w = fVar;
        this.f4507f.setCallback(fVar);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
    }

    public void setShowMore(boolean z) {
        PullLeftRefreshLayout pullLeftRefreshLayout = this.f4507f;
        if (pullLeftRefreshLayout != null) {
            pullLeftRefreshLayout.setEnablePull(z);
        }
    }

    public void setShowSquareEntrance(boolean z) {
        this.o = z;
    }

    public void setSquareEntranceAtStart(boolean z) {
        this.n = z;
    }

    public void setTabName(String str) {
        this.s = str;
    }

    public RecommendForumLayout(TbPageContext<?> tbPageContext, @Nullable AttributeSet attributeSet) {
        super(tbPageContext.getPageActivity(), attributeSet);
        this.n = true;
        this.o = true;
        this.p = true;
        this.r = 0;
        this.f4506e = tbPageContext;
        b();
    }
}

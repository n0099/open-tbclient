package com.baidu.card.view;

import android.content.Context;
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
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.adapter.HorizontalRecommendForumAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout;
import com.baidu.tbadk.widget.horizontalpullview.RefreshView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
import d.a.k.q;
import d.a.p0.i0.b.a;
import d.a.p0.n.f;
import d.a.p0.s.q.o;
import d.a.p0.s.q.o1;
import d.a.p0.s.q.p1;
import d.a.p0.s.u.c;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class RecommendForumLayout extends LinearLayout implements q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f4584e;

    /* renamed from: f  reason: collision with root package name */
    public PullLeftRefreshLayout f4585f;

    /* renamed from: g  reason: collision with root package name */
    public RecyclerView f4586g;

    /* renamed from: h  reason: collision with root package name */
    public HorizontalRecommendForumAdapter f4587h;

    /* renamed from: i  reason: collision with root package name */
    public FrameLayout f4588i;
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RecommendForumLayout(TbPageContext<?> tbPageContext) {
        this(tbPageContext, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((TbPageContext) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void a(p1 p1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, p1Var) == null) {
            this.k.setOnClickListener(this.s);
            if (!TextUtils.isEmpty(p1Var.f53411h) && p1Var.f53412i != 0) {
                this.j.setText(p1Var.f53411h);
            } else {
                this.j.setText(R.string.recommend_forum_title_horizontal);
                if (this.f4588i.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) this.f4588i.getLayoutParams()).topMargin = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds38);
                    this.f4588i.requestLayout();
                }
            }
            if (!this.n) {
                this.k.setVisibility(8);
            }
            if (p1Var != null && p1Var.e() != null && p1Var.e().size() > 0) {
                ArrayList<? extends a> arrayList = new ArrayList<>();
                ArrayList<o1> e2 = p1Var.e();
                if (this.l) {
                    if (this.m) {
                        arrayList.add(new o());
                    }
                    if (e2 != null) {
                        arrayList.addAll(e2);
                    }
                } else {
                    if (e2 != null) {
                        arrayList.addAll(e2);
                    }
                    if (this.m) {
                        arrayList.add(new o());
                    }
                }
                this.f4587h.e(arrayList);
            }
            c();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.recommend_forum_horizontal_view, (ViewGroup) this, true);
            setOrientation(1);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.f4588i = (FrameLayout) findViewById(R.id.title_view);
            TextView textView = (TextView) findViewById(R.id.tv_title);
            this.j = textView;
            c.d(textView).x(R.dimen.T_X07);
            this.k = (ImageView) findViewById(R.id.img_arrow);
            this.f4585f = (PullLeftRefreshLayout) findViewById(R.id.refresh_layout);
            this.f4586g = (RecyclerView) findViewById(R.id.recycler_view);
            HorizontalRecommendForumAdapter horizontalRecommendForumAdapter = new HorizontalRecommendForumAdapter(this.f4584e, this.p);
            this.f4587h = horizontalRecommendForumAdapter;
            int i2 = this.p;
            if (i2 == 0) {
                horizontalRecommendForumAdapter.f(this.r);
            } else if (i2 == 1) {
                horizontalRecommendForumAdapter.h(this.q);
            }
            this.f4586g.setLayoutManager(new LinearLayoutManager(this.f4584e.getPageActivity(), 0, false));
            this.f4586g.setAdapter(this.f4587h);
            this.f4586g.setClipChildren(false);
            this.f4587h.notifyDataSetChanged();
            this.j.setText(this.f4584e.getPageActivity().getString(R.string.recommend_forum_title_horizontal));
            RefreshView refreshView = new RefreshView(getContext());
            this.o = refreshView;
            this.f4585f.setRefreshViewAndListener(refreshView);
            this.f4585f.setCallback(this.t);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c d2 = c.d(this);
            d2.n(R.string.J_X06);
            d2.f(R.color.CAM_X0205);
            c.d(this.j).t(R.color.CAM_X0105);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
            this.o.d();
            this.f4587h.notifyDataSetChanged();
        }
    }

    @Override // d.a.k.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i2) == null) {
            c();
        }
    }

    public void setData(p1 p1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, p1Var) == null) {
            a(p1Var);
        }
    }

    public void setEnableShowInto(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.n = z;
        }
    }

    public void setFrom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.p = i2;
        }
    }

    public void setHasLikeForum(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.r = z;
        }
    }

    public void setOnClickRightArrowListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onClickListener) == null) {
            this.s = onClickListener;
        }
    }

    public void setOnItemCoverListener(f<o1> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, fVar) == null) {
            this.f4587h.g(fVar);
        }
    }

    public void setOnRullOkCallbackr(PullLeftRefreshLayout.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, fVar) == null) {
            this.t = fVar;
            this.f4585f.setCallback(fVar);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bdUniqueId) == null) {
        }
    }

    public void setShowMore(boolean z) {
        PullLeftRefreshLayout pullLeftRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048588, this, z) == null) || (pullLeftRefreshLayout = this.f4585f) == null) {
            return;
        }
        pullLeftRefreshLayout.setEnablePull(z);
    }

    public void setShowSquareEntrance(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.m = z;
        }
    }

    public void setSquareEntranceAtStart(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.l = z;
        }
    }

    public void setTabName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.q = str;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecommendForumLayout(TbPageContext<?> tbPageContext, @Nullable AttributeSet attributeSet) {
        super(tbPageContext.getPageActivity(), attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.l = true;
        this.m = true;
        this.n = true;
        this.p = 0;
        this.f4584e = tbPageContext;
        b();
    }
}

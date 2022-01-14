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
import c.a.d.f.p.n;
import c.a.l.q;
import c.a.s0.l0.b.a;
import c.a.s0.n.f;
import c.a.s0.s.q.o;
import c.a.s0.s.q.q1;
import c.a.s0.s.q.r1;
import c.a.s0.s.u.c;
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
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class RecommendForumLayout extends LinearLayout implements q {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FROM_MY_BAR_TAB = 0;
    public static final int FROM_TAB_FEED = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f33255e;

    /* renamed from: f  reason: collision with root package name */
    public PullLeftRefreshLayout f33256f;

    /* renamed from: g  reason: collision with root package name */
    public RecyclerView f33257g;

    /* renamed from: h  reason: collision with root package name */
    public HorizontalRecommendForumAdapter f33258h;

    /* renamed from: i  reason: collision with root package name */
    public FrameLayout f33259i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f33260j;
    public ImageView k;
    public boolean l;
    public boolean m;
    public int mFrom;
    public boolean mHasLikeForum;
    public boolean n;
    public RefreshView o;
    public String p;
    public View.OnClickListener q;
    public PullLeftRefreshLayout.f r;

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

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.recommend_forum_horizontal_view, (ViewGroup) this, true);
            setOrientation(1);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.f33259i = (FrameLayout) findViewById(R.id.title_view);
            TextView textView = (TextView) findViewById(R.id.tv_title);
            this.f33260j = textView;
            c.d(textView).z(R.dimen.T_X07);
            this.k = (ImageView) findViewById(R.id.img_arrow);
            this.f33256f = (PullLeftRefreshLayout) findViewById(R.id.refresh_layout);
            this.f33257g = (RecyclerView) findViewById(R.id.recycler_view);
            HorizontalRecommendForumAdapter horizontalRecommendForumAdapter = new HorizontalRecommendForumAdapter(this.f33255e, this.mFrom);
            this.f33258h = horizontalRecommendForumAdapter;
            int i2 = this.mFrom;
            if (i2 == 0) {
                horizontalRecommendForumAdapter.setHasLikeForum(this.mHasLikeForum);
            } else if (i2 == 1) {
                horizontalRecommendForumAdapter.setTabName(this.p);
            }
            this.f33257g.setLayoutManager(new LinearLayoutManager(this.f33255e.getPageActivity(), 0, false));
            this.f33257g.setAdapter(this.f33258h);
            this.f33257g.setClipChildren(false);
            this.f33258h.notifyDataSetChanged();
            this.f33260j.setText(this.f33255e.getPageActivity().getString(R.string.recommend_forum_title_horizontal));
            RefreshView refreshView = new RefreshView(getContext());
            this.o = refreshView;
            this.f33256f.setRefreshViewAndListener(refreshView);
            this.f33256f.setCallback(this.r);
        }
    }

    public void bindData(r1 r1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, r1Var) == null) {
            this.k.setOnClickListener(this.q);
            if (!TextUtils.isEmpty(r1Var.f13486h) && r1Var.f13487i != 0) {
                this.f33260j.setText(r1Var.f13486h);
            } else {
                this.f33260j.setText(R.string.recommend_forum_title_horizontal);
                if (this.f33259i.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) this.f33259i.getLayoutParams()).topMargin = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds38);
                    this.f33259i.requestLayout();
                }
            }
            if (!this.n) {
                this.k.setVisibility(8);
            }
            if (r1Var != null && r1Var.k() != null && r1Var.k().size() > 0) {
                ArrayList<? extends a> arrayList = new ArrayList<>();
                ArrayList<q1> k = r1Var.k();
                if (this.l) {
                    if (this.m) {
                        arrayList.add(new o());
                    }
                    if (k != null) {
                        arrayList.addAll(k);
                    }
                } else {
                    if (k != null) {
                        arrayList.addAll(k);
                    }
                    if (this.m) {
                        arrayList.add(new o());
                    }
                }
                this.f33258h.setData(arrayList);
            }
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c d2 = c.d(this);
            d2.n(R.string.J_X06);
            d2.f(R.color.CAM_X0205);
            c.d(this.f33260j).v(R.color.CAM_X0105);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
            this.o.onChangeSkinType();
            this.f33258h.notifyDataSetChanged();
        }
    }

    public void setData(r1 r1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, r1Var) == null) {
            bindData(r1Var);
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
            this.mFrom = i2;
        }
    }

    public void setHasLikeForum(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.mHasLikeForum = z;
        }
    }

    public void setOnClickRightArrowListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onClickListener) == null) {
            this.q = onClickListener;
        }
    }

    public void setOnItemCoverListener(f<q1> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, fVar) == null) {
            this.f33258h.setOnItemCoverListener(fVar);
        }
    }

    public void setOnRullOkCallbackr(PullLeftRefreshLayout.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, fVar) == null) {
            this.r = fVar;
            this.f33256f.setCallback(fVar);
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
        if (!(interceptable == null || interceptable.invokeZ(1048588, this, z) == null) || (pullLeftRefreshLayout = this.f33256f) == null) {
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
            this.p = str;
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
        this.mFrom = 0;
        this.f33255e = tbPageContext;
        a();
    }

    @Override // c.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i2) == null) {
            onChangeSkinType();
        }
    }
}

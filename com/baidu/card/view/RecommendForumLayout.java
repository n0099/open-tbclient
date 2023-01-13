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
import com.baidu.tieba.ce5;
import com.baidu.tieba.cx4;
import com.baidu.tieba.tu4;
import com.baidu.tieba.us4;
import com.baidu.tieba.uu4;
import com.baidu.tieba.vq4;
import com.baidu.tieba.vx;
import com.baidu.tieba.zi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class RecommendForumLayout extends LinearLayout implements vx {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public PullLeftRefreshLayout b;
    public RecyclerView c;
    public HorizontalRecommendForumAdapter d;
    public FrameLayout e;
    public TextView f;
    public ImageView g;
    public boolean h;
    public boolean i;
    public boolean j;
    public RefreshView k;
    public int l;
    public String m;
    public boolean n;
    public View.OnClickListener o;
    public PullLeftRefreshLayout.f p;

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bdUniqueId) == null) {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RecommendForumLayout(TbPageContext<?> tbPageContext) {
        this(tbPageContext, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((TbPageContext) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.h = true;
        this.i = true;
        this.j = true;
        this.l = 0;
        this.a = tbPageContext;
        b();
    }

    public void a(uu4 uu4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, uu4Var) == null) {
            this.g.setOnClickListener(this.o);
            if (!TextUtils.isEmpty(uu4Var.d) && uu4Var.e != 0) {
                this.f.setText(uu4Var.d);
            } else {
                this.f.setText(R.string.recommend_forum_title_horizontal);
                if (this.e.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) this.e.getLayoutParams()).topMargin = zi.g(TbadkCoreApplication.getInst(), R.dimen.tbds38);
                    this.e.requestLayout();
                }
            }
            if (!this.j) {
                this.g.setVisibility(8);
            }
            if (uu4Var != null && uu4Var.g() != null && uu4Var.g().size() > 0) {
                ArrayList<? extends ce5> arrayList = new ArrayList<>();
                ArrayList<tu4> g = uu4Var.g();
                if (this.h) {
                    if (this.i) {
                        arrayList.add(new us4());
                    }
                    if (g != null) {
                        arrayList.addAll(g);
                    }
                } else {
                    if (g != null) {
                        arrayList.addAll(g);
                    }
                    if (this.i) {
                        arrayList.add(new us4());
                    }
                }
                this.d.e(arrayList);
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
            this.e = (FrameLayout) findViewById(R.id.title_view);
            TextView textView = (TextView) findViewById(R.id.tv_title);
            this.f = textView;
            cx4.d(textView).z(R.dimen.T_X07);
            this.g = (ImageView) findViewById(R.id.img_arrow);
            this.b = (PullLeftRefreshLayout) findViewById(R.id.refresh_layout);
            this.c = (RecyclerView) findViewById(R.id.recycler_view);
            HorizontalRecommendForumAdapter horizontalRecommendForumAdapter = new HorizontalRecommendForumAdapter(this.a, this.l);
            this.d = horizontalRecommendForumAdapter;
            int i = this.l;
            if (i == 0) {
                horizontalRecommendForumAdapter.f(this.n);
            } else if (i == 1) {
                horizontalRecommendForumAdapter.h(this.m);
            }
            this.c.setLayoutManager(new LinearLayoutManager(this.a.getPageActivity(), 0, false));
            this.c.setAdapter(this.d);
            this.c.setClipChildren(false);
            this.d.notifyDataSetChanged();
            this.f.setText(this.a.getPageActivity().getString(R.string.recommend_forum_title_horizontal));
            RefreshView refreshView = new RefreshView(getContext());
            this.k = refreshView;
            this.b.setRefreshViewAndListener(refreshView);
            this.b.setCallback(this.p);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            cx4 d = cx4.d(this);
            d.n(R.string.J_X06);
            d.f(R.color.CAM_X0205);
            cx4.d(this.f).v(R.color.CAM_X0105);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.g, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
            this.k.d();
            this.d.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.vx
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i) == null) {
            c();
        }
    }

    public void setData(uu4 uu4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, uu4Var) == null) {
            a(uu4Var);
        }
    }

    public void setEnableShowInto(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.j = z;
        }
    }

    public void setFrom(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.l = i;
        }
    }

    public void setHasLikeForum(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.n = z;
        }
    }

    public void setOnClickRightArrowListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onClickListener) == null) {
            this.o = onClickListener;
        }
    }

    public void setOnItemCoverListener(vq4<tu4> vq4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, vq4Var) == null) {
            this.d.g(vq4Var);
        }
    }

    public void setOnRullOkCallbackr(PullLeftRefreshLayout.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, fVar) == null) {
            this.p = fVar;
            this.b.setCallback(fVar);
        }
    }

    public void setShowMore(boolean z) {
        PullLeftRefreshLayout pullLeftRefreshLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048588, this, z) == null) && (pullLeftRefreshLayout = this.b) != null) {
            pullLeftRefreshLayout.setEnablePull(z);
        }
    }

    public void setShowSquareEntrance(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.i = z;
        }
    }

    public void setSquareEntranceAtStart(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.h = z;
        }
    }

    public void setTabName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.m = str;
        }
    }
}

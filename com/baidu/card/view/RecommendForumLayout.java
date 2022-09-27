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
import com.baidu.tieba.ej;
import com.baidu.tieba.hv4;
import com.baidu.tieba.mb5;
import com.baidu.tieba.nr4;
import com.baidu.tieba.nt4;
import com.baidu.tieba.ot4;
import com.baidu.tieba.qp4;
import com.baidu.tieba.xx;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class RecommendForumLayout extends LinearLayout implements xx {
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

    public void a(ot4 ot4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ot4Var) == null) {
            this.g.setOnClickListener(this.o);
            if (!TextUtils.isEmpty(ot4Var.d) && ot4Var.e != 0) {
                this.f.setText(ot4Var.d);
            } else {
                this.f.setText(R.string.obfuscated_res_0x7f0f0fbe);
                if (this.e.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) this.e.getLayoutParams()).topMargin = ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds38);
                    this.e.requestLayout();
                }
            }
            if (!this.j) {
                this.g.setVisibility(8);
            }
            if (ot4Var != null && ot4Var.h() != null && ot4Var.h().size() > 0) {
                ArrayList<? extends mb5> arrayList = new ArrayList<>();
                ArrayList<nt4> h = ot4Var.h();
                if (this.h) {
                    if (this.i) {
                        arrayList.add(new nr4());
                    }
                    if (h != null) {
                        arrayList.addAll(h);
                    }
                } else {
                    if (h != null) {
                        arrayList.addAll(h);
                    }
                    if (this.i) {
                        arrayList.add(new nr4());
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
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0770, (ViewGroup) this, true);
            setOrientation(1);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.e = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f09224a);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f092419);
            this.f = textView;
            hv4.d(textView).z(R.dimen.T_X07);
            this.g = (ImageView) findViewById(R.id.obfuscated_res_0x7f090ec8);
            this.b = (PullLeftRefreshLayout) findViewById(R.id.obfuscated_res_0x7f091bc2);
            this.c = (RecyclerView) findViewById(R.id.obfuscated_res_0x7f091bba);
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
            this.f.setText(this.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f0fbe));
            RefreshView refreshView = new RefreshView(getContext());
            this.k = refreshView;
            this.b.setRefreshViewAndListener(refreshView);
            this.b.setCallback(this.p);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            hv4 d = hv4.d(this);
            d.n(R.string.J_X06);
            d.f(R.color.CAM_X0205);
            hv4.d(this.f).v(R.color.CAM_X0105);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.g, R.drawable.obfuscated_res_0x7f0805ff, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
            this.k.d();
            this.d.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.xx
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i) == null) {
            c();
        }
    }

    public void setData(ot4 ot4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ot4Var) == null) {
            a(ot4Var);
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

    public void setOnItemCoverListener(qp4<nt4> qp4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, qp4Var) == null) {
            this.d.g(qp4Var);
        }
    }

    public void setOnRullOkCallbackr(PullLeftRefreshLayout.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, fVar) == null) {
            this.p = fVar;
            this.b.setCallback(fVar);
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
        if (!(interceptable == null || interceptable.invokeZ(1048588, this, z) == null) || (pullLeftRefreshLayout = this.b) == null) {
            return;
        }
        pullLeftRefreshLayout.setEnablePull(z);
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
}

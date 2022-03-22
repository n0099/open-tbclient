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
import c.a.o0.k0.b.a;
import c.a.o0.m.f;
import c.a.o0.r.r.n1;
import c.a.o0.r.r.o;
import c.a.o0.r.r.o1;
import c.a.o0.r.v.c;
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
/* loaded from: classes3.dex */
public class RecommendForumLayout extends LinearLayout implements q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;

    /* renamed from: b  reason: collision with root package name */
    public PullLeftRefreshLayout f25166b;

    /* renamed from: c  reason: collision with root package name */
    public RecyclerView f25167c;

    /* renamed from: d  reason: collision with root package name */
    public HorizontalRecommendForumAdapter f25168d;

    /* renamed from: e  reason: collision with root package name */
    public FrameLayout f25169e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f25170f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f25171g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f25172h;
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

    public void a(o1 o1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, o1Var) == null) {
            this.f25171g.setOnClickListener(this.o);
            if (!TextUtils.isEmpty(o1Var.f10921d) && o1Var.f10922e != 0) {
                this.f25170f.setText(o1Var.f10921d);
            } else {
                this.f25170f.setText(R.string.obfuscated_res_0x7f0f0f47);
                if (this.f25169e.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) this.f25169e.getLayoutParams()).topMargin = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds38);
                    this.f25169e.requestLayout();
                }
            }
            if (!this.j) {
                this.f25171g.setVisibility(8);
            }
            if (o1Var != null && o1Var.i() != null && o1Var.i().size() > 0) {
                ArrayList<? extends a> arrayList = new ArrayList<>();
                ArrayList<n1> i = o1Var.i();
                if (this.f25172h) {
                    if (this.i) {
                        arrayList.add(new o());
                    }
                    if (i != null) {
                        arrayList.addAll(i);
                    }
                } else {
                    if (i != null) {
                        arrayList.addAll(i);
                    }
                    if (this.i) {
                        arrayList.add(new o());
                    }
                }
                this.f25168d.e(arrayList);
            }
            c();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0722, (ViewGroup) this, true);
            setOrientation(1);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.f25169e = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f09205f);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f09221e);
            this.f25170f = textView;
            c.d(textView).z(R.dimen.T_X07);
            this.f25171g = (ImageView) findViewById(R.id.obfuscated_res_0x7f090e9c);
            this.f25166b = (PullLeftRefreshLayout) findViewById(R.id.obfuscated_res_0x7f091a2e);
            this.f25167c = (RecyclerView) findViewById(R.id.obfuscated_res_0x7f091a27);
            HorizontalRecommendForumAdapter horizontalRecommendForumAdapter = new HorizontalRecommendForumAdapter(this.a, this.l);
            this.f25168d = horizontalRecommendForumAdapter;
            int i = this.l;
            if (i == 0) {
                horizontalRecommendForumAdapter.f(this.n);
            } else if (i == 1) {
                horizontalRecommendForumAdapter.h(this.m);
            }
            this.f25167c.setLayoutManager(new LinearLayoutManager(this.a.getPageActivity(), 0, false));
            this.f25167c.setAdapter(this.f25168d);
            this.f25167c.setClipChildren(false);
            this.f25168d.notifyDataSetChanged();
            this.f25170f.setText(this.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f0f47));
            RefreshView refreshView = new RefreshView(getContext());
            this.k = refreshView;
            this.f25166b.setRefreshViewAndListener(refreshView);
            this.f25166b.setCallback(this.p);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c d2 = c.d(this);
            d2.n(R.string.J_X06);
            d2.f(R.color.CAM_X0205);
            c.d(this.f25170f).v(R.color.CAM_X0105);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f25171g, R.drawable.obfuscated_res_0x7f0805f8, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
            this.k.d();
            this.f25168d.notifyDataSetChanged();
        }
    }

    @Override // c.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i) == null) {
            c();
        }
    }

    public void setData(o1 o1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, o1Var) == null) {
            a(o1Var);
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

    public void setOnItemCoverListener(f<n1> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, fVar) == null) {
            this.f25168d.g(fVar);
        }
    }

    public void setOnRullOkCallbackr(PullLeftRefreshLayout.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, fVar) == null) {
            this.p = fVar;
            this.f25166b.setCallback(fVar);
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
        if (!(interceptable == null || interceptable.invokeZ(1048588, this, z) == null) || (pullLeftRefreshLayout = this.f25166b) == null) {
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
            this.f25172h = z;
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
        this.f25172h = true;
        this.i = true;
        this.j = true;
        this.l = 0;
        this.a = tbPageContext;
        b();
    }
}

package com.baidu.card.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.extend.XGridLayout;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.a.j;
import d.a.k.p;
import d.a.k.q;
import d.a.p0.n.c;
import d.a.p0.n.e;
import d.a.p0.n.f;
import d.a.p0.s.q.l0;
import d.a.p0.s.q.m;
import java.util.List;
/* loaded from: classes.dex */
public class GridIconLayout extends FrameLayout implements q, p<l0> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public XGridLayout f4468e;

    /* renamed from: f  reason: collision with root package name */
    public f<m> f4469f;

    /* renamed from: g  reason: collision with root package name */
    public c f4470g;

    /* renamed from: h  reason: collision with root package name */
    public e<m> f4471h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.p0.d1.f.a.a f4472i;

    /* loaded from: classes.dex */
    public class a implements e<m> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GridIconLayout f4473a;

        public a(GridIconLayout gridIconLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gridIconLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4473a = gridIconLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.p0.n.e
        /* renamed from: b */
        public void a(View view, m mVar, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view, mVar, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
                if (mVar != null) {
                    this.f4473a.c(mVar.c());
                }
                if (this.f4473a.f4469f != null) {
                    this.f4473a.f4469f.a(view, mVar, i2, j);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends d.a.p0.d1.f.a.a<m> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ GridIconLayout f4474g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(GridIconLayout gridIconLayout, Context context, int i2) {
            super(context, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gridIconLayout, context, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4474g = gridIconLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.p0.d1.f.a.a
        /* renamed from: i */
        public void f(d.a.p0.d1.f.a.c cVar, m mVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, mVar, i2) == null) {
                TbImageView tbImageView = (TbImageView) cVar.b(R.id.iv_icon);
                tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                tbImageView.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
                tbImageView.setPlaceHolder(1);
                tbImageView.M(mVar.d(), 10, false);
                TextView textView = (TextView) cVar.b(R.id.tv_title);
                SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
                textView.setText(mVar.e());
                if (this.f4474g.f4469f != null) {
                    this.f4474g.f4469f.c(cVar.a(), mVar, i2, i2);
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GridIconLayout(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                UrlManager.getInstance().dealOneLink((TbPageContext) j.a(getContext()), new String[]{str});
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            XGridLayout xGridLayout = new XGridLayout(getContext());
            this.f4468e = xGridLayout;
            addView(xGridLayout);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.k.p
    /* renamed from: e */
    public void a(l0 l0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, l0Var) == null) {
            if (l0Var != null && !ListUtils.isEmpty(l0Var.f53380e)) {
                setVisibility(0);
                List<m> list = l0Var.f53380e;
                int size = list != null ? list.size() : 0;
                if (size != 5 && size >= 4 && size < 9) {
                    this.f4468e.setAutoGridSpan(list, 4);
                } else {
                    this.f4468e.setAutoGridSpan(list, 5);
                }
                this.f4468e.setAdapter(this.f4472i);
                this.f4472i.h(this.f4471h);
                this.f4472i.g(list);
                return;
            }
            setVisibility(8);
        }
    }

    @Override // d.a.k.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, tbPageContext, i2) == null) {
            d.a.p0.s.u.c d2 = d.a.p0.s.u.c.d(this);
            d2.n(R.string.J_X06);
            d2.f(R.color.CAM_X0205);
            XGridLayout xGridLayout = this.f4468e;
            if (xGridLayout != null) {
                xGridLayout.d();
            }
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            super.onWindowVisibilityChanged(i2);
            if (this.f4470g != null) {
                this.f4470g.a(this, i2 == 0, null);
            }
        }
    }

    public void setHorizontalSpace(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f4468e.setHorizontalSpace(i2);
        }
    }

    public void setIWindowChangedListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, cVar) == null) {
            this.f4470g = cVar;
        }
    }

    public void setMarginsTop(View view, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, view, i2) == null) && (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if (marginLayoutParams.topMargin != i2) {
                marginLayoutParams.topMargin = i2;
                view.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public void setMaxItem(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f4468e.setMaxItem(i2);
        }
    }

    public void setOnItemCoverListener(f<m> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, fVar) == null) {
            this.f4469f = fVar;
        }
    }

    public void setVerticalSpace(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f4468e.setVerticalSpace(i2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GridIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
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
        this.f4471h = new a(this);
        this.f4472i = new b(this, getContext(), R.layout.grid_icon_item);
        d();
    }
}

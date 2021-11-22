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
import b.a.e.a.j;
import b.a.l.p;
import b.a.l.q;
import b.a.q0.n.c;
import b.a.q0.n.e;
import b.a.q0.n.f;
import b.a.q0.s.q.l0;
import b.a.q0.s.q.m;
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
import java.util.List;
/* loaded from: classes7.dex */
public class GridIconLayout extends FrameLayout implements q, p<l0> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public XGridLayout f37530e;

    /* renamed from: f  reason: collision with root package name */
    public f<m> f37531f;

    /* renamed from: g  reason: collision with root package name */
    public c f37532g;

    /* renamed from: h  reason: collision with root package name */
    public e<m> f37533h;

    /* renamed from: i  reason: collision with root package name */
    public b.a.q0.e1.f.a.a f37534i;

    /* loaded from: classes7.dex */
    public class a implements e<m> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GridIconLayout f37535a;

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
            this.f37535a = gridIconLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.q0.n.e
        /* renamed from: b */
        public void a(View view, m mVar, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view, mVar, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
                if (mVar != null) {
                    this.f37535a.dealOneLink(mVar.c());
                }
                if (this.f37535a.f37531f != null) {
                    this.f37535a.f37531f.a(view, mVar, i2, j);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends b.a.q0.e1.f.a.a<m> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ GridIconLayout f37536g;

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
            this.f37536g = gridIconLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.q0.e1.f.a.a
        /* renamed from: i */
        public void f(b.a.q0.e1.f.a.c cVar, m mVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, mVar, i2) == null) {
                TbImageView tbImageView = (TbImageView) cVar.b(R.id.iv_icon);
                tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                tbImageView.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
                tbImageView.setPlaceHolder(1);
                tbImageView.startLoad(mVar.d(), 10, false);
                tbImageView.setUseNightOrDarkMask(false);
                TextView textView = (TextView) cVar.b(R.id.tv_title);
                SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
                textView.setText(mVar.e());
                if (this.f37536g.f37531f != null) {
                    this.f37536g.f37531f.c(cVar.a(), mVar, i2, i2);
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

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            XGridLayout xGridLayout = new XGridLayout(getContext());
            this.f37530e = xGridLayout;
            addView(xGridLayout);
        }
    }

    public void dealOneLink(String str) {
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

    @Override // b.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, tbPageContext, i2) == null) {
            b.a.q0.s.u.c d2 = b.a.q0.s.u.c.d(this);
            d2.n(R.string.J_X06);
            d2.f(R.color.CAM_X0205);
            XGridLayout xGridLayout = this.f37530e;
            if (xGridLayout != null) {
                xGridLayout.onChangeSkinType();
            }
        }
    }

    public void onDestroy() {
        XGridLayout xGridLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (xGridLayout = this.f37530e) == null) {
            return;
        }
        xGridLayout.onDestroyed();
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            super.onWindowVisibilityChanged(i2);
            if (this.f37532g != null) {
                this.f37532g.a(this, i2 == 0, null);
            }
        }
    }

    public void setHorizontalSpace(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f37530e.setHorizontalSpace(i2);
        }
    }

    public void setIWindowChangedListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) {
            this.f37532g = cVar;
        }
    }

    public void setMarginsTop(View view, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048585, this, view, i2) == null) && (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if (marginLayoutParams.topMargin != i2) {
                marginLayoutParams.topMargin = i2;
                view.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public void setMaxItem(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.f37530e.setMaxItem(i2);
        }
    }

    public void setOnItemCoverListener(f<m> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, fVar) == null) {
            this.f37531f = fVar;
        }
    }

    public void setVerticalSpace(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.f37530e.setVerticalSpace(i2);
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
        this.f37533h = new a(this);
        this.f37534i = new b(this, getContext(), R.layout.grid_icon_item);
        b();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.l.p
    public void onBindDataToView(l0 l0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, l0Var) == null) {
            if (l0Var != null && !ListUtils.isEmpty(l0Var.f14168e)) {
                setVisibility(0);
                List<m> list = l0Var.f14168e;
                int size = list != null ? list.size() : 0;
                if (size != 5 && size >= 4 && size < 9) {
                    this.f37530e.setAutoGridSpan(list, 4);
                } else {
                    this.f37530e.setAutoGridSpan(list, 5);
                }
                this.f37530e.setAdapter(this.f37534i);
                this.f37534i.h(this.f37533h);
                this.f37534i.g(list);
                return;
            }
            setVisibility(8);
        }
    }
}

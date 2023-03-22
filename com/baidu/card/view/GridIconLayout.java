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
import com.baidu.tieba.g9;
import com.baidu.tieba.gx;
import com.baidu.tieba.hx;
import com.baidu.tieba.n15;
import com.baidu.tieba.nr5;
import com.baidu.tieba.pr5;
import com.baidu.tieba.uu4;
import com.baidu.tieba.uw4;
import com.baidu.tieba.ux4;
import com.baidu.tieba.wu4;
import com.baidu.tieba.xu4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes2.dex */
public class GridIconLayout extends FrameLayout implements hx, gx<ux4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public XGridLayout a;
    public xu4<uw4> b;
    public uu4 c;
    public wu4<uw4> d;
    public nr5 e;

    /* loaded from: classes2.dex */
    public class a implements wu4<uw4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GridIconLayout a;

        public a(GridIconLayout gridIconLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gridIconLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gridIconLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wu4
        /* renamed from: a */
        public void c(View view2, uw4 uw4Var, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, uw4Var, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                if (uw4Var != null) {
                    this.a.c(uw4Var.a());
                }
                if (this.a.b != null) {
                    this.a.b.c(view2, uw4Var, i, j);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends nr5<uw4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GridIconLayout g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(GridIconLayout gridIconLayout, Context context, int i) {
            super(context, i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gridIconLayout, context, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = gridIconLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nr5
        /* renamed from: i */
        public void f(pr5 pr5Var, uw4 uw4Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pr5Var, uw4Var, i) == null) {
                TbImageView tbImageView = (TbImageView) pr5Var.b(R.id.iv_icon);
                tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                tbImageView.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
                tbImageView.setPlaceHolder(1);
                tbImageView.M(uw4Var.b(), 10, false);
                tbImageView.setUseNightOrDarkMask(false);
                TextView textView = (TextView) pr5Var.b(R.id.tv_title);
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0105);
                textView.setText(uw4Var.c());
                if (this.g.b != null) {
                    this.g.b.d(pr5Var.a(), uw4Var, i, i);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
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
        this.d = new a(this);
        this.e = new b(this, getContext(), R.layout.grid_icon_item);
        d();
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) g9.a(getContext()), new String[]{str});
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            super.onWindowVisibilityChanged(i);
            if (this.c != null) {
                if (i == 0) {
                    z = true;
                } else {
                    z = false;
                }
                this.c.a(this, z, null);
            }
        }
    }

    public void setHorizontalSpace(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.a.setHorizontalSpace(i);
        }
    }

    public void setIWindowChangedListener(uu4 uu4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, uu4Var) == null) {
            this.c = uu4Var;
        }
    }

    public void setMaxItem(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.a.setMaxItem(i);
        }
    }

    public void setOnItemCoverListener(xu4<uw4> xu4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, xu4Var) == null) {
            this.b = xu4Var;
        }
    }

    public void setVerticalSpace(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.a.setVerticalSpace(i);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            XGridLayout xGridLayout = new XGridLayout(getContext());
            this.a = xGridLayout;
            addView(xGridLayout);
        }
    }

    public void f() {
        XGridLayout xGridLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (xGridLayout = this.a) != null) {
            xGridLayout.a();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.gx
    /* renamed from: e */
    public void a(ux4 ux4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ux4Var) == null) {
            if (ux4Var != null && !ListUtils.isEmpty(ux4Var.a)) {
                int i = 0;
                setVisibility(0);
                List<uw4> list = ux4Var.a;
                if (list != null) {
                    i = list.size();
                }
                if (i != 5 && i >= 4 && i < 9) {
                    this.a.setAutoGridSpan(list, 4);
                } else {
                    this.a.setAutoGridSpan(list, 5);
                }
                this.a.setAdapter(this.e);
                this.e.h(this.d);
                this.e.g(list);
                return;
            }
            setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.hx
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, tbPageContext, i) == null) {
            n15 d = n15.d(this);
            d.o(R.string.J_X06);
            d.f(R.color.CAM_X0205);
            XGridLayout xGridLayout = this.a;
            if (xGridLayout != null) {
                xGridLayout.e();
            }
        }
    }

    public void setMarginsTop(View view2, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048585, this, view2, i) == null) && (view2.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
            if (marginLayoutParams.topMargin != i) {
                marginLayoutParams.topMargin = i;
                view2.setLayoutParams(marginLayoutParams);
            }
        }
    }
}

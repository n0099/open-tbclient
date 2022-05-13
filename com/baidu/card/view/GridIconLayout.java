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
import com.repackage.f9;
import com.repackage.gs4;
import com.repackage.lp4;
import com.repackage.mo4;
import com.repackage.oy;
import com.repackage.py;
import com.repackage.sm4;
import com.repackage.te5;
import com.repackage.um4;
import com.repackage.ve5;
import com.repackage.vm4;
import java.util.List;
/* loaded from: classes.dex */
public class GridIconLayout extends FrameLayout implements py, oy<lp4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public XGridLayout a;
    public vm4<mo4> b;
    public sm4 c;
    public um4<mo4> d;
    public te5 e;

    /* loaded from: classes.dex */
    public class a implements um4<mo4> {
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
        @Override // com.repackage.um4
        /* renamed from: b */
        public void a(View view2, mo4 mo4Var, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view2, mo4Var, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                if (mo4Var != null) {
                    this.a.c(mo4Var.c());
                }
                if (this.a.b != null) {
                    this.a.b.a(view2, mo4Var, i, j);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends te5<mo4> {
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
        @Override // com.repackage.te5
        /* renamed from: i */
        public void f(ve5 ve5Var, mo4 mo4Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ve5Var, mo4Var, i) == null) {
                TbImageView tbImageView = (TbImageView) ve5Var.b(R.id.obfuscated_res_0x7f090fe0);
                tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                tbImageView.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
                tbImageView.setPlaceHolder(1);
                tbImageView.K(mo4Var.d(), 10, false);
                tbImageView.setUseNightOrDarkMask(false);
                TextView textView = (TextView) ve5Var.b(R.id.obfuscated_res_0x7f09225a);
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0105);
                textView.setText(mo4Var.e());
                if (this.g.b != null) {
                    this.g.b.c(ve5Var.a(), mo4Var, i, i);
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

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                UrlManager.getInstance().dealOneLink((TbPageContext) f9.a(getContext()), new String[]{str});
            } catch (Exception e) {
                e.printStackTrace();
            }
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.oy
    /* renamed from: e */
    public void a(lp4 lp4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, lp4Var) == null) {
            if (lp4Var != null && !ListUtils.isEmpty(lp4Var.a)) {
                setVisibility(0);
                List<mo4> list = lp4Var.a;
                int size = list != null ? list.size() : 0;
                if (size != 5 && size >= 4 && size < 9) {
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

    public void f() {
        XGridLayout xGridLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (xGridLayout = this.a) == null) {
            return;
        }
        xGridLayout.a();
    }

    @Override // com.repackage.py
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, tbPageContext, i) == null) {
            gs4 d = gs4.d(this);
            d.n(R.string.J_X06);
            d.f(R.color.CAM_X0205);
            XGridLayout xGridLayout = this.a;
            if (xGridLayout != null) {
                xGridLayout.e();
            }
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            super.onWindowVisibilityChanged(i);
            if (this.c != null) {
                this.c.a(this, i == 0, null);
            }
        }
    }

    public void setHorizontalSpace(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.a.setHorizontalSpace(i);
        }
    }

    public void setIWindowChangedListener(sm4 sm4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sm4Var) == null) {
            this.c = sm4Var;
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

    public void setMaxItem(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.a.setMaxItem(i);
        }
    }

    public void setOnItemCoverListener(vm4<mo4> vm4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, vm4Var) == null) {
            this.b = vm4Var;
        }
    }

    public void setVerticalSpace(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.a.setVerticalSpace(i);
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
        this.e = new b(this, getContext(), R.layout.obfuscated_res_0x7f0d0381);
        d();
    }
}

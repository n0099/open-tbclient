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
import com.repackage.ao4;
import com.repackage.ff5;
import com.repackage.gm4;
import com.repackage.gx;
import com.repackage.h9;
import com.repackage.hf5;
import com.repackage.hx;
import com.repackage.im4;
import com.repackage.jm4;
import com.repackage.ur4;
import com.repackage.zo4;
import java.util.List;
/* loaded from: classes.dex */
public class GridIconLayout extends FrameLayout implements hx, gx<zo4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public XGridLayout a;
    public jm4<ao4> b;
    public gm4 c;
    public im4<ao4> d;
    public ff5 e;

    /* loaded from: classes.dex */
    public class a implements im4<ao4> {
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
        @Override // com.repackage.im4
        /* renamed from: a */
        public void c(View view2, ao4 ao4Var, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, ao4Var, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                if (ao4Var != null) {
                    this.a.c(ao4Var.c());
                }
                if (this.a.b != null) {
                    this.a.b.c(view2, ao4Var, i, j);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends ff5<ao4> {
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
        @Override // com.repackage.ff5
        /* renamed from: i */
        public void f(hf5 hf5Var, ao4 ao4Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hf5Var, ao4Var, i) == null) {
                TbImageView tbImageView = (TbImageView) hf5Var.b(R.id.obfuscated_res_0x7f090fa2);
                tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                tbImageView.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
                tbImageView.setPlaceHolder(1);
                tbImageView.J(ao4Var.d(), 10, false);
                tbImageView.setUseNightOrDarkMask(false);
                TextView textView = (TextView) hf5Var.b(R.id.obfuscated_res_0x7f0922a1);
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0105);
                textView.setText(ao4Var.e());
                if (this.g.b != null) {
                    this.g.b.d(hf5Var.a(), ao4Var, i, i);
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
                UrlManager.getInstance().dealOneLink((TbPageContext) h9.a(getContext()), new String[]{str});
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
    @Override // com.repackage.gx
    /* renamed from: e */
    public void a(zo4 zo4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, zo4Var) == null) {
            if (zo4Var != null && !ListUtils.isEmpty(zo4Var.a)) {
                setVisibility(0);
                List<ao4> list = zo4Var.a;
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

    @Override // com.repackage.hx
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, tbPageContext, i) == null) {
            ur4 d = ur4.d(this);
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

    public void setIWindowChangedListener(gm4 gm4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, gm4Var) == null) {
            this.c = gm4Var;
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

    public void setOnItemCoverListener(jm4<ao4> jm4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, jm4Var) == null) {
            this.b = jm4Var;
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
        this.e = new b(this, getContext(), R.layout.obfuscated_res_0x7f0d037b);
        d();
    }
}

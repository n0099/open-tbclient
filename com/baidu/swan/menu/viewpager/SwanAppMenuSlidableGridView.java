package com.baidu.swan.menu.viewpager;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.menu.viewpager.SlideableGridView;
import com.baidu.tieba.R;
import com.baidu.tieba.qa4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class SwanAppMenuSlidableGridView extends SlideableGridView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public class a extends WrapContentHeightViewPager {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppMenuSlidableGridView a;

        @Override // androidx.viewpager.widget.ViewPager
        public boolean canScroll(View view2, boolean z, int i, int i2, int i3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{view2, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
                return false;
            }
            return invokeCommon.booleanValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(SwanAppMenuSlidableGridView swanAppMenuSlidableGridView, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppMenuSlidableGridView, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppMenuSlidableGridView;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwanAppMenuSlidableGridView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwanAppMenuSlidableGridView(Context context, AttributeSet attributeSet) {
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
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwanAppMenuSlidableGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.swan.menu.viewpager.SlideableGridView
    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            PointPageIndicator e = new qa4(context).e(R.drawable.obfuscated_res_0x7f080da1, R.drawable.obfuscated_res_0x7f080da2);
            e.f((int) getResources().getDimension(R.dimen.common_grid_indicator_margin));
            this.h = e;
            this.i[0] = (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f0700dd);
            this.i[1] = (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f0700dd);
            addView(this.h, e());
        }
    }

    @Override // com.baidu.swan.menu.viewpager.SlideableGridView
    public void k(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            setOrientation(1);
            b(context);
            Resources resources = context.getResources();
            addView(new View(context), new LinearLayout.LayoutParams(-1, resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0700df)));
            a(context);
            addView(new View(context), new LinearLayout.LayoutParams(-1, resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0700e0)));
        }
    }

    @Override // com.baidu.swan.menu.viewpager.SlideableGridView
    public void c() {
        int c;
        boolean z;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SlideableGridView.a gridItemAdapter = getGridItemAdapter();
            if (gridItemAdapter == null) {
                c = 0;
            } else {
                c = gridItemAdapter.c();
            }
            if (c > 1) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                i = this.i[0];
            } else {
                i = this.i[1];
            }
            if (!z) {
                this.h.setVisibility(8);
                return;
            }
            this.h.setVisibility(0);
            this.h.c(c);
            this.h.getLayoutParams().height = i;
        }
    }

    @Override // com.baidu.swan.menu.viewpager.SlideableGridView
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f0700dd);
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.swan.menu.viewpager.SlideableGridView
    public ViewPager g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            return new a(this, context);
        }
        return (ViewPager) invokeL.objValue;
    }
}

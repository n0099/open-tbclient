package com.baidu.tbadk.core.tabHost;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.R;
import com.baidu.tieba.qq8;
import com.baidu.tieba.va5;
import com.baidu.tieba.yi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class FragmentTabWidget extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View A;
    public String B;
    public va5 C;
    public final Rect a;
    public final Rect b;
    public final Rect c;
    public int d;
    public int e;
    public int f;
    public b g;
    public d h;
    public int i;
    public Paint j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public boolean u;
    public boolean v;
    public boolean w;
    public int x;
    public boolean y;
    public boolean z;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public interface b {
        void onTabSelectionChanged(int i, boolean z);
    }

    /* loaded from: classes3.dex */
    public interface d {
        void onSizeChanged(int i, int i2, int i3, int i4);
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;
        public final /* synthetic */ FragmentTabWidget b;

        public c(FragmentTabWidget fragmentTabWidget, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fragmentTabWidget, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fragmentTabWidget;
            this.a = i;
        }

        public /* synthetic */ c(FragmentTabWidget fragmentTabWidget, int i, a aVar) {
            this(fragmentTabWidget, i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.k(this.a + 1);
                this.b.g.onTabSelectionChanged(this.a, true);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentTabWidget(Context context) {
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
        this.a = new Rect();
        this.b = new Rect();
        this.c = new Rect();
        this.d = 0;
        this.f = -1;
        this.j = new Paint();
        this.n = 0;
        this.u = true;
        this.v = false;
        this.w = false;
        this.y = false;
        this.z = false;
        g();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentTabWidget(Context context, AttributeSet attributeSet) {
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
        this.a = new Rect();
        this.b = new Rect();
        this.c = new Rect();
        this.d = 0;
        this.f = -1;
        this.j = new Paint();
        this.n = 0;
        this.u = true;
        this.v = false;
        this.w = false;
        this.y = false;
        this.z = false;
        g();
    }

    @Override // android.view.ViewGroup
    public void addView(View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, i) == null) {
            e(view2);
            super.addView(view2, i);
            view2.setOnClickListener(new c(this, getChildCount() - 1, null));
        }
    }

    private void setNavigationBarBg(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65541, this, i) == null) {
            Context context = getContext();
            if (context instanceof Activity) {
                int color = SkinManager.getColor(i);
                String dynamicStyleNavBarColor = getDynamicStyleNavBarColor();
                if (StringUtils.isNotNull(dynamicStyleNavBarColor)) {
                    color = qq8.f(dynamicStyleNavBarColor);
                }
                UtilHelper.setNavigationBarBg((Activity) context, color);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            e(view2);
            super.addView(view2);
            view2.setOnClickListener(new c(this, getChildCount() - 1, null));
        }
    }

    public void setAbsoluteWeight(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.y = z;
        }
    }

    public void setBackGroundDrawableResId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.e = i;
        }
    }

    public void setBackGroundStyle(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.d = i;
        }
    }

    public void setDiverColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            this.p = i;
        }
    }

    public void setDviderRectHeight(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.m = i;
        }
    }

    public void setDviderRectWidth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            this.n = i;
        }
    }

    public void setDynamicStyleData(va5 va5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, va5Var) == null) {
            this.C = va5Var;
        }
    }

    public void setForumId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            this.B = str;
        }
    }

    public void setOnSizeChangedListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, dVar) == null) {
            this.h = dVar;
        }
    }

    public void setShouldDrawDividerLine(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.z = z;
        }
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.u = z;
        }
    }

    public void setShouldDrawTopLine(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.v = z;
        }
    }

    public void setTabSelectionListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, bVar) == null) {
            this.g = bVar;
        }
    }

    private String getDynamicStyleNavBarColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            if (this.C != null) {
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    return this.C.f();
                }
                if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                    return this.C.d();
                }
                return this.C.e();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public void c(View view2, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{view2, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            f(view2, z);
            super.addView(view2, i);
            if (z) {
                this.A = view2;
            }
            view2.setOnClickListener(new c(this, getChildCount() - 1, null));
        }
    }

    public void d(int i, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) == null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070258);
            int i2 = this.t;
            int i3 = (i2 - dimensionPixelSize) / 2;
            int i4 = i2 * i;
            this.i = i4;
            int i5 = i4 + ((int) (i2 * f));
            this.i = i5;
            int i6 = this.s;
            int i7 = i6 - this.m;
            int i8 = this.n;
            if (i8 == -2) {
                View childAt = getChildAt(i);
                if (childAt != null && (childAt instanceof TbFragmentTabIndicator)) {
                    View contentTv = ((TbFragmentTabIndicator) childAt).getContentTv();
                    if (contentTv != null) {
                        this.a.set(childAt.getLeft() + contentTv.getLeft(), i7, childAt.getLeft() + contentTv.getRight(), this.s);
                    } else {
                        Rect rect = this.a;
                        int i9 = this.i;
                        int i10 = this.t;
                        int i11 = this.n;
                        rect.set(((i10 / 2) + i9) - (i11 / 2), i7, i9 + (i10 / 2) + (i11 / 2), this.s);
                    }
                } else {
                    Rect rect2 = this.a;
                    int i12 = this.i;
                    int i13 = this.t;
                    int i14 = this.n;
                    rect2.set(((i13 / 2) + i12) - (i14 / 2), i7, i12 + (i13 / 2) + (i14 / 2), this.s);
                }
            } else if (i8 != 0) {
                this.a.set(((i2 / 2) + i5) - (i8 / 2), i7, i5 + (i2 / 2) + (i8 / 2), i6);
            } else {
                this.a.set(i5 + i3, i7, i5 + i3 + dimensionPixelSize, i6);
            }
            postInvalidateDelayed(16L);
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
            super.draw(canvas);
            this.j.setColor(this.o);
            if (this.z) {
                canvas.drawRect(this.b, this.j);
            }
            if (this.v) {
                canvas.drawRect(this.c, this.j);
            }
            if (this.u) {
                this.j.setColor(this.p);
                canvas.drawRoundRect(new RectF(this.a), 10.0f, 10.0f, this.j);
            }
        }
    }

    public void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            int i2 = this.e;
            if (i2 != 0 && this.d == 0) {
                SkinManager.setBackgroundColor(this, i2);
            }
            this.p = SkinManager.getColor(R.color.CAM_X0105);
            this.o = SkinManager.getColor(R.color.CAM_X0204);
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt instanceof FragmentTabIndicator) {
                    ((FragmentTabIndicator) childAt).e(i);
                }
            }
            invalidate();
        }
    }

    public final void e(View view2) {
        LinearLayout.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
            if (this.y) {
                layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
            } else {
                layoutParams = new LinearLayout.LayoutParams(-2, -1, 1.0f);
            }
            layoutParams.setMargins(0, 0, 0, 0);
            if (this.w) {
                view2.setPadding(0, 0, 0, this.x);
            }
            view2.setLayoutParams(layoutParams);
            view2.setFocusable(true);
            view2.setClickable(true);
        }
    }

    public final void k(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048588, this, i) != null) || this.B == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FRS_BOTTOM_BAR_TAB_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.B).param("obj_param1", i));
    }

    public void f(View view2, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048582, this, view2, z) == null) {
            if (this.y) {
                layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
            } else {
                layoutParams = new LinearLayout.LayoutParams(-2, -1, 1.0f);
            }
            layoutParams.setMargins(0, 0, 0, 0);
            if (this.w) {
                view2.setPadding(0, 0, 0, this.x);
            }
            view2.setLayoutParams(layoutParams);
            view2.setFocusable(true);
            view2.setClickable(true);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            Paint paint = new Paint(6);
            this.j = paint;
            paint.setAntiAlias(true);
            this.j.setStyle(Paint.Style.FILL);
            this.k = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070198);
            this.l = yi.d(getContext(), 1.0f);
            this.m = yi.d(getContext(), 2.0f);
            this.x = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070230);
            setWillNotDraw(false);
            this.e = R.color.common_color_10274;
        }
    }

    public View getWriteView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.A;
        }
        return (View) invokeV.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            removeAllViews();
            this.f = -1;
        }
    }

    public void h(boolean z, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            this.e = i;
            if (this.C != null) {
                i2 = R.color.transparent;
            } else {
                i2 = i;
            }
            if (z) {
                this.p = SkinManager.getColor(4, (int) R.color.CAM_X0105);
                this.o = SkinManager.getColor(4, (int) R.color.CAM_X0204);
            } else {
                this.p = SkinManager.getColor(R.color.CAM_X0105);
                this.o = SkinManager.getColor(R.color.CAM_X0204);
            }
            if (this.e != 0 && this.d == 0) {
                SkinManager.setBackgroundColor(this, i2);
                setNavigationBarBg(i);
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            super.onLayout(z, i, i2, i3, i4);
            int childCount = getChildCount();
            this.q = childCount;
            if (childCount == 0) {
                return;
            }
            int i5 = i3 - i;
            this.r = i5;
            this.s = i4 - i2;
            this.t = i5 / childCount;
            int i6 = this.f;
            if (i6 != -1) {
                d(i6, 0.0f);
            }
            int i7 = this.s;
            int i8 = this.k;
            int i9 = i7 - i8;
            this.b.set(0, i9, this.r, i8 + i9);
            this.c.set(0, 0, this.r, this.l);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048590, this, i, i2, i3, i4) == null) {
            super.onSizeChanged(i, i2, i3, i4);
            d dVar = this.h;
            if (dVar != null) {
                dVar.onSizeChanged(i, i2, i3, i4);
            }
        }
    }

    public void setCurrentTab(int i, boolean z, boolean z2) {
        boolean z3;
        boolean z4;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && i >= 0 && i < getChildCount()) {
            if (z2) {
                for (int i2 = 0; i2 < getChildCount(); i2++) {
                    TbFragmentTabIndicator tbFragmentTabIndicator = (TbFragmentTabIndicator) getChildAt(i2);
                    if (i == i2) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    tbFragmentTabIndicator.setCheckDescriptionText(z3);
                    if (i == i2) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    tbFragmentTabIndicator.f(z4);
                }
            }
            int i3 = this.f;
            if (i3 == i) {
                return;
            }
            if (i3 != -1) {
                getChildAt(i3).setSelected(false);
            }
            this.f = i;
            getChildAt(i).setSelected(true);
            if (z) {
                d(this.f, 0.0f);
            }
        }
    }
}

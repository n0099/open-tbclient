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
import com.baidu.adp.lib.util.BdUtilHelper;
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
import com.baidu.tieba.mk5;
import com.baidu.tieba.tua;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class FragmentTabWidget extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View A;
    public String B;
    public HashMap<Integer, View> C;
    public int D;
    public mk5 E;
    public final Rect a;
    public final Rect b;
    public final Rect c;
    public int d;
    public int e;
    public int f;
    public a g;
    public c h;
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

    /* loaded from: classes4.dex */
    public interface a {
        void onTabSelectionChanged(int i, boolean z);
    }

    /* loaded from: classes4.dex */
    public interface c {
        void onSizeChanged(int i, int i2, int i3, int i4);
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public final /* synthetic */ FragmentTabWidget b;

        public b(FragmentTabWidget fragmentTabWidget, int i) {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.b.m(this.a + 1);
            this.b.g.onTabSelectionChanged(this.a, true);
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
        this.C = new HashMap<>();
        h();
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
        this.C = new HashMap<>();
        h();
    }

    @Override // android.view.ViewGroup
    public void addView(View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, i) == null) {
            f(view2);
            super.addView(view2, i);
            k(view2);
        }
    }

    public void d(View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, view2, i) == null) {
            f(view2);
            super.addView(view2, i);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            f(view2);
            super.addView(view2);
            k(view2);
        }
    }

    public final void k(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, view2) == null) {
            int i = this.D;
            this.D = i + 1;
            view2.setOnClickListener(new b(this, i));
            this.C.put(Integer.valueOf(i), view2);
        }
    }

    public void setAbsoluteWeight(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.y = z;
        }
    }

    public void setBackGroundDrawableResId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.e = i;
        }
    }

    public void setBackGroundStyle(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            this.d = i;
        }
    }

    public void setDiverColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            this.p = i;
        }
    }

    public void setDviderRectHeight(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            this.m = i;
        }
    }

    public void setDviderRectWidth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i) == null) {
            this.n = i;
        }
    }

    public void setDynamicStyleData(mk5 mk5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, mk5Var) == null) {
            this.E = mk5Var;
        }
    }

    public void setForumId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            this.B = str;
        }
    }

    public void setOnSizeChangedListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, cVar) == null) {
            this.h = cVar;
        }
    }

    public void setShouldDrawDividerLine(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.z = z;
        }
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            this.u = z;
        }
    }

    public void setShouldDrawTopLine(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            this.v = z;
        }
    }

    public void setTabSelectionListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, aVar) == null) {
            this.g = aVar;
        }
    }

    private String getDynamicStyleNavBarColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            if (this.E != null) {
                if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                    return this.E.d();
                }
                return this.E.e();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public View getWriteView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.A;
        }
        return (View) invokeV.objValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            removeAllViews();
            this.f = -1;
            this.C.clear();
            this.D = 0;
        }
    }

    private void setNavigationBarBg(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65541, this, i) == null) {
            Context context = getContext();
            if (context instanceof Activity) {
                int color = SkinManager.getColor(i);
                String dynamicStyleNavBarColor = getDynamicStyleNavBarColor();
                if (this.E != null && ((color = tua.f(dynamicStyleNavBarColor)) == 0 || color == Integer.MAX_VALUE)) {
                    color = SkinManager.getColor(R.color.CAM_X0205);
                }
                UtilHelper.setNavigationBarBg((Activity) context, color);
            }
        }
    }

    public final void f(View view2) {
        LinearLayout.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view2) == null) {
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

    public final void m(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048590, this, i) != null) || this.B == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FRS_BOTTOM_BAR_TAB_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.B).param("obj_param1", i));
    }

    public void c(View view2, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{view2, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            g(view2, z);
            super.addView(view2, i);
            if (z) {
                this.A = view2;
            }
            k(view2);
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

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            int i2 = this.e;
            if (i2 != 0 && this.d == 0) {
                SkinManager.setBackgroundColor(this, i2);
            }
            this.p = SkinManager.getColor(R.color.CAM_X0105);
            this.o = SkinManager.getColor(R.color.CAM_X0204);
            for (Map.Entry<Integer, View> entry : this.C.entrySet()) {
                View view2 = this.C.get(entry.getKey());
                if (view2 instanceof FragmentTabIndicator) {
                    ((FragmentTabIndicator) view2).onChangeSkin(i);
                }
            }
            invalidate();
        }
    }

    public void e(int i, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) == null) {
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
                View view2 = this.C.get(Integer.valueOf(i));
                if (view2 != null && (view2 instanceof TbFragmentTabIndicator)) {
                    View contentTv = ((TbFragmentTabIndicator) view2).getContentTv();
                    if (contentTv != null) {
                        this.a.set(view2.getLeft() + contentTv.getLeft(), i7, view2.getLeft() + contentTv.getRight(), this.s);
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

    public void g(View view2, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048583, this, view2, z) == null) {
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

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            Paint paint = new Paint(6);
            this.j = paint;
            paint.setAntiAlias(true);
            this.j.setStyle(Paint.Style.FILL);
            this.k = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070198);
            this.l = BdUtilHelper.dip2px(getContext(), 1.0f);
            this.m = BdUtilHelper.dip2px(getContext(), 2.0f);
            this.x = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07035a);
            setWillNotDraw(false);
            this.e = R.color.common_color_10274;
        }
    }

    public void i(boolean z, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            this.e = i;
            if (this.E != null) {
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
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
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
                e(i6, 0.0f);
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
        if (interceptable == null || interceptable.invokeIIII(1048592, this, i, i2, i3, i4) == null) {
            super.onSizeChanged(i, i2, i3, i4);
            c cVar = this.h;
            if (cVar != null) {
                cVar.onSizeChanged(i, i2, i3, i4);
            }
        }
    }

    public void setCurrentTab(int i, boolean z, boolean z2) {
        boolean z3;
        boolean z4;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && i >= 0 && this.C.containsKey(Integer.valueOf(i))) {
            if (z2) {
                for (Map.Entry<Integer, View> entry : this.C.entrySet()) {
                    if (entry.getValue() instanceof TbFragmentTabIndicator) {
                        TbFragmentTabIndicator tbFragmentTabIndicator = (TbFragmentTabIndicator) entry.getValue();
                        if (i == entry.getKey().intValue()) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        tbFragmentTabIndicator.setCheckDescriptionText(z3);
                        if (i == entry.getKey().intValue()) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        tbFragmentTabIndicator.onTabSelected(z4);
                    }
                }
            }
            int i2 = this.f;
            if (i2 == i) {
                return;
            }
            View view2 = this.C.get(Integer.valueOf(i2));
            if (this.f != -1 && view2 != null) {
                view2.setSelected(false);
            }
            this.f = i;
            View view3 = this.C.get(Integer.valueOf(i));
            if (view3 != null) {
                view3.setSelected(true);
            }
            if (z) {
                e(this.f, 0.0f);
            }
        }
    }
}

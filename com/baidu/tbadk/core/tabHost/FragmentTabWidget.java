package com.baidu.tbadk.core.tabHost;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class FragmentTabWidget extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View A;
    public final Rect a;

    /* renamed from: b  reason: collision with root package name */
    public final Rect f29936b;

    /* renamed from: c  reason: collision with root package name */
    public final Rect f29937c;

    /* renamed from: d  reason: collision with root package name */
    public int f29938d;

    /* renamed from: e  reason: collision with root package name */
    public int f29939e;

    /* renamed from: f  reason: collision with root package name */
    public int f29940f;

    /* renamed from: g  reason: collision with root package name */
    public b f29941g;

    /* renamed from: h  reason: collision with root package name */
    public d f29942h;
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
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public interface b {
        void onTabSelectionChanged(int i, boolean z);
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FragmentTabWidget f29943b;

        public /* synthetic */ c(FragmentTabWidget fragmentTabWidget, int i, a aVar) {
            this(fragmentTabWidget, i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f29943b.f29941g.onTabSelectionChanged(this.a, true);
            }
        }

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
            this.f29943b = fragmentTabWidget;
            this.a = i;
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        void onSizeChanged(int i, int i2, int i3, int i4);
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
        this.f29936b = new Rect();
        this.f29937c = new Rect();
        this.f29938d = 0;
        this.f29940f = -1;
        this.j = new Paint();
        this.n = 0;
        this.u = true;
        this.v = false;
        this.w = false;
        this.y = false;
        this.z = true;
        g();
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            e(view);
            super.addView(view);
            view.setOnClickListener(new c(this, getChildCount() - 1, null));
        }
    }

    public void b(View view, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{view, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            f(view, z);
            super.addView(view, i);
            if (z) {
                this.A = view;
            }
            view.setOnClickListener(new c(this, getChildCount() - 1, null));
        }
    }

    public void c(View view, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, view, i) == null) {
            e(view);
            super.addView(view, i);
        }
    }

    public void d(int i, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), Float.valueOf(f2)}) == null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070258);
            int i2 = this.t;
            int i3 = (i2 - dimensionPixelSize) / 2;
            int i4 = i2 * i;
            this.i = i4;
            int i5 = i4 + ((int) (i2 * f2));
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
        if (interceptable == null || interceptable.invokeL(1048581, this, canvas) == null) {
            super.draw(canvas);
            this.j.setColor(this.o);
            if (this.z) {
                canvas.drawRect(this.f29936b, this.j);
            }
            if (this.v) {
                canvas.drawRect(this.f29937c, this.j);
            }
            if (this.u) {
                this.j.setColor(this.p);
                canvas.drawRoundRect(new RectF(this.a), 10.0f, 10.0f, this.j);
            }
        }
    }

    public final void e(View view) {
        LinearLayout.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view) == null) {
            if (this.y) {
                layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
            } else {
                layoutParams = new LinearLayout.LayoutParams(-2, -1, 1.0f);
            }
            layoutParams.setMargins(0, 0, 0, 0);
            if (this.w) {
                view.setPadding(0, 0, 0, this.x);
            }
            view.setLayoutParams(layoutParams);
            view.setFocusable(true);
            view.setClickable(true);
        }
    }

    public void f(View view, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048583, this, view, z) == null) {
            if (this.y) {
                layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
            } else {
                layoutParams = new LinearLayout.LayoutParams(-2, -1, 1.0f);
            }
            layoutParams.setMargins(0, 0, 0, 0);
            if (this.w) {
                view.setPadding(0, 0, 0, this.x);
            }
            view.setLayoutParams(layoutParams);
            view.setFocusable(true);
            view.setClickable(true);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            Paint paint = new Paint(6);
            this.j = paint;
            paint.setAntiAlias(true);
            this.j.setStyle(Paint.Style.FILL);
            this.k = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070198);
            this.l = n.d(getContext(), 1.0f);
            this.m = n.d(getContext(), 2.0f);
            this.x = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070229);
            setWillNotDraw(false);
            this.f29939e = R.color.common_color_10274;
        }
    }

    public View getWriteView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.A : (View) invokeV.objValue;
    }

    public void h(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            this.f29939e = i;
            if (z) {
                this.p = SkinManager.getColor(4, (int) R.color.CAM_X0105);
                this.o = SkinManager.getColor(4, (int) R.color.CAM_X0204);
            } else {
                this.p = SkinManager.getColor(R.color.CAM_X0105);
                this.o = SkinManager.getColor(R.color.CAM_X0204);
            }
            if (this.f29939e == 0 || this.f29938d != 0) {
                return;
            }
            SkinManager.setBackgroundColor(this, i);
        }
    }

    public void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            int i2 = this.f29939e;
            if (i2 != 0 && this.f29938d == 0) {
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

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            removeAllViews();
            this.f29940f = -1;
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
            int i6 = this.f29940f;
            if (i6 != -1) {
                d(i6, 0.0f);
            }
            int i7 = this.s;
            int i8 = this.k;
            int i9 = i7 - i8;
            this.f29936b.set(0, i9, this.r, i8 + i9);
            this.f29937c.set(0, 0, this.r, this.l);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048590, this, i, i2, i3, i4) == null) {
            super.onSizeChanged(i, i2, i3, i4);
            d dVar = this.f29942h;
            if (dVar != null) {
                dVar.onSizeChanged(i, i2, i3, i4);
            }
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
            this.f29939e = i;
        }
    }

    public void setBackGroundStyle(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.f29938d = i;
        }
    }

    public void setCurrentTab(int i, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || i < 0 || i >= getChildCount()) {
            return;
        }
        if (z2) {
            int i2 = 0;
            while (i2 < getChildCount()) {
                TbFragmentTabIndicator tbFragmentTabIndicator = (TbFragmentTabIndicator) getChildAt(i2);
                tbFragmentTabIndicator.setCheckDescriptionText(i == i2);
                tbFragmentTabIndicator.f(i == i2);
                i2++;
            }
        }
        int i3 = this.f29940f;
        if (i3 == i) {
            return;
        }
        if (i3 != -1) {
            getChildAt(i3).setSelected(false);
        }
        this.f29940f = i;
        getChildAt(i).setSelected(true);
        if (z) {
            d(this.f29940f, 0.0f);
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

    public void setOnSizeChangedListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, dVar) == null) {
            this.f29942h = dVar;
        }
    }

    public void setShouldDrawDividerLine(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.z = z;
        }
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.u = z;
        }
    }

    public void setShouldDrawTopLine(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.v = z;
        }
    }

    public void setTabSelectionListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, bVar) == null) {
            this.f29941g = bVar;
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, i) == null) {
            e(view);
            super.addView(view, i);
            view.setOnClickListener(new c(this, getChildCount() - 1, null));
        }
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
        this.f29936b = new Rect();
        this.f29937c = new Rect();
        this.f29938d = 0;
        this.f29940f = -1;
        this.j = new Paint();
        this.n = 0;
        this.u = true;
        this.v = false;
        this.w = false;
        this.y = false;
        this.z = true;
        g();
    }
}

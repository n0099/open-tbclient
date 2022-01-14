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
/* loaded from: classes11.dex */
public class FragmentTabWidget extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public int B;
    public boolean C;
    public boolean D;
    public View E;

    /* renamed from: e  reason: collision with root package name */
    public final Rect f40279e;

    /* renamed from: f  reason: collision with root package name */
    public final Rect f40280f;

    /* renamed from: g  reason: collision with root package name */
    public final Rect f40281g;

    /* renamed from: h  reason: collision with root package name */
    public int f40282h;

    /* renamed from: i  reason: collision with root package name */
    public int f40283i;

    /* renamed from: j  reason: collision with root package name */
    public int f40284j;
    public b k;
    public d l;
    public int m;
    public Paint n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;
    public int w;
    public int x;
    public boolean y;
    public boolean z;

    /* loaded from: classes11.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes11.dex */
    public interface b {
        void onTabSelectionChanged(int i2, boolean z);
    }

    /* loaded from: classes11.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final int f40285e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FragmentTabWidget f40286f;

        public /* synthetic */ c(FragmentTabWidget fragmentTabWidget, int i2, a aVar) {
            this(fragmentTabWidget, i2);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f40286f.k.onTabSelectionChanged(this.f40285e, true);
            }
        }

        public c(FragmentTabWidget fragmentTabWidget, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fragmentTabWidget, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f40286f = fragmentTabWidget;
            this.f40285e = i2;
        }
    }

    /* loaded from: classes11.dex */
    public interface d {
        void onSizeChanged(int i2, int i3, int i4, int i5);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f40279e = new Rect();
        this.f40280f = new Rect();
        this.f40281g = new Rect();
        this.f40282h = 0;
        this.f40284j = -1;
        this.n = new Paint();
        this.r = 0;
        this.y = true;
        this.z = false;
        this.A = false;
        this.C = false;
        this.D = true;
        c();
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            b(view);
            super.addView(view);
            view.setOnClickListener(new c(this, getChildCount() - 1, null));
        }
    }

    public final void b(View view) {
        LinearLayout.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            if (this.C) {
                layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
            } else {
                layoutParams = new LinearLayout.LayoutParams(-2, -1, 1.0f);
            }
            layoutParams.setMargins(0, 0, 0, 0);
            if (this.A) {
                view.setPadding(0, 0, 0, this.B);
            }
            view.setLayoutParams(layoutParams);
            view.setFocusable(true);
            view.setClickable(true);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            Paint paint = new Paint(6);
            this.n = paint;
            paint.setAntiAlias(true);
            this.n.setStyle(Paint.Style.FILL);
            this.o = getResources().getDimensionPixelSize(R.dimen.ds1);
            this.p = n.d(getContext(), 1.0f);
            this.q = n.d(getContext(), 2.0f);
            this.B = getResources().getDimensionPixelSize(R.dimen.ds10);
            setWillNotDraw(false);
            this.f40283i = R.color.common_color_10274;
        }
    }

    public void changeLeft(int i2, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds64);
            int i3 = this.x;
            int i4 = (i3 - dimensionPixelSize) / 2;
            int i5 = i3 * i2;
            this.m = i5;
            int i6 = i5 + ((int) (i3 * f2));
            this.m = i6;
            int i7 = this.w;
            int i8 = i7 - this.q;
            int i9 = this.r;
            if (i9 == -2) {
                View childAt = getChildAt(i2);
                if (childAt != null && (childAt instanceof TbFragmentTabIndicator)) {
                    View contentTv = ((TbFragmentTabIndicator) childAt).getContentTv();
                    if (contentTv != null) {
                        this.f40279e.set(childAt.getLeft() + contentTv.getLeft(), i8, childAt.getLeft() + contentTv.getRight(), this.w);
                    } else {
                        Rect rect = this.f40279e;
                        int i10 = this.m;
                        int i11 = this.x;
                        int i12 = this.r;
                        rect.set(((i11 / 2) + i10) - (i12 / 2), i8, i10 + (i11 / 2) + (i12 / 2), this.w);
                    }
                } else {
                    Rect rect2 = this.f40279e;
                    int i13 = this.m;
                    int i14 = this.x;
                    int i15 = this.r;
                    rect2.set(((i14 / 2) + i13) - (i15 / 2), i8, i13 + (i14 / 2) + (i15 / 2), this.w);
                }
            } else if (i9 != 0) {
                this.f40279e.set(((i3 / 2) + i6) - (i9 / 2), i8, i6 + (i3 / 2) + (i9 / 2), i7);
            } else {
                this.f40279e.set(i6 + i4, i8, i6 + i4 + dimensionPixelSize, i7);
            }
            postInvalidateDelayed(16L);
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, canvas) == null) {
            super.draw(canvas);
            this.n.setColor(this.s);
            if (this.D) {
                canvas.drawRect(this.f40280f, this.n);
            }
            if (this.z) {
                canvas.drawRect(this.f40281g, this.n);
            }
            if (this.y) {
                this.n.setColor(this.t);
                canvas.drawRoundRect(new RectF(this.f40279e), 10.0f, 10.0f, this.n);
            }
        }
    }

    public void fixChildWithMarginTop(View view, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048583, this, view, z) == null) {
            if (this.C) {
                layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
            } else {
                layoutParams = new LinearLayout.LayoutParams(-2, -1, 1.0f);
            }
            layoutParams.setMargins(0, 0, 0, 0);
            if (this.A) {
                view.setPadding(0, 0, 0, this.B);
            }
            view.setLayoutParams(layoutParams);
            view.setFocusable(true);
            view.setClickable(true);
        }
    }

    public View getWriteView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.E : (View) invokeV.objValue;
    }

    public void isTabItemNeedPadding(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.A = z;
        }
    }

    public void makeWidgetDarkSkin(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            this.f40283i = i2;
            if (z) {
                this.t = SkinManager.getColor(4, R.color.CAM_X0105);
                this.s = SkinManager.getColor(4, R.color.CAM_X0204);
            } else {
                this.t = SkinManager.getColor(R.color.CAM_X0105);
                this.s = SkinManager.getColor(R.color.CAM_X0204);
            }
            if (this.f40283i == 0 || this.f40282h != 0) {
                return;
            }
            SkinManager.setBackgroundColor(this, i2);
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            int i3 = this.f40283i;
            if (i3 != 0 && this.f40282h == 0) {
                SkinManager.setBackgroundColor(this, i3);
            }
            this.t = SkinManager.getColor(R.color.CAM_X0105);
            this.s = SkinManager.getColor(R.color.CAM_X0204);
            int childCount = getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (childAt instanceof FragmentTabIndicator) {
                    ((FragmentTabIndicator) childAt).onChangeSkin(i2);
                }
            }
            invalidate();
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.onLayout(z, i2, i3, i4, i5);
            int childCount = getChildCount();
            this.u = childCount;
            if (childCount == 0) {
                return;
            }
            int i6 = i4 - i2;
            this.v = i6;
            this.w = i5 - i3;
            this.x = i6 / childCount;
            int i7 = this.f40284j;
            if (i7 != -1) {
                changeLeft(i7, 0.0f);
            }
            int i8 = this.w;
            int i9 = this.o;
            int i10 = i8 - i9;
            this.f40280f.set(0, i10, this.v, i9 + i10);
            this.f40281g.set(0, 0, this.v, this.p);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048589, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            d dVar = this.l;
            if (dVar != null) {
                dVar.onSizeChanged(i2, i3, i4, i5);
            }
        }
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            removeAllViews();
            this.f40284j = -1;
        }
    }

    public void setAbsoluteWeight(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.C = z;
        }
    }

    public void setBackGroundDrawableResId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.f40283i = i2;
        }
    }

    public void setBackGroundStyle(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.f40282h = i2;
        }
    }

    public void setCurrentTab(int i2, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || i2 < 0 || i2 >= getChildCount()) {
            return;
        }
        if (z2) {
            int i3 = 0;
            while (i3 < getChildCount()) {
                TbFragmentTabIndicator tbFragmentTabIndicator = (TbFragmentTabIndicator) getChildAt(i3);
                tbFragmentTabIndicator.setCheckDescriptionText(i2 == i3);
                tbFragmentTabIndicator.onTabSelected(i2 == i3);
                i3++;
            }
        }
        int i4 = this.f40284j;
        if (i4 == i2) {
            return;
        }
        if (i4 != -1) {
            getChildAt(i4).setSelected(false);
        }
        this.f40284j = i2;
        getChildAt(i2).setSelected(true);
        if (z) {
            changeLeft(this.f40284j, 0.0f);
        }
    }

    public void setDiverColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.t = i2;
        }
    }

    public void setDviderRectHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            this.q = i2;
        }
    }

    public void setDviderRectWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            this.r = i2;
        }
    }

    public void setOnSizeChangedListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, dVar) == null) {
            this.l = dVar;
        }
    }

    public void setShouldDrawDividerLine(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.D = z;
        }
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.y = z;
        }
    }

    public void setShouldDrawTopLine(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.z = z;
        }
    }

    public void setTabSelectionListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, bVar) == null) {
            this.k = bVar;
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, i2) == null) {
            b(view);
            super.addView(view, i2);
            view.setOnClickListener(new c(this, getChildCount() - 1, null));
        }
    }

    public void addView(View view, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{view, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            fixChildWithMarginTop(view, z);
            super.addView(view, i2);
            if (z) {
                this.E = view;
            }
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
        this.f40279e = new Rect();
        this.f40280f = new Rect();
        this.f40281g = new Rect();
        this.f40282h = 0;
        this.f40284j = -1;
        this.n = new Paint();
        this.r = 0;
        this.y = true;
        this.z = false;
        this.A = false;
        this.C = false;
        this.D = true;
        c();
    }
}

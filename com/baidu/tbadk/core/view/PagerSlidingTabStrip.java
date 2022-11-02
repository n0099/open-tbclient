package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class PagerSlidingTabStrip extends HorizontalScrollView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout.LayoutParams a;
    public LinearLayout.LayoutParams b;
    public final d c;
    public ViewPager.OnPageChangeListener d;
    public LinearLayout e;
    public ViewPager f;
    public int g;
    public int h;
    public float i;
    public Paint j;
    public boolean k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public Typeface r;
    public int s;
    public int t;
    public int u;

    /* loaded from: classes3.dex */
    public interface c {
        int a(int i);
    }

    /* loaded from: classes3.dex */
    public static class SavedState extends View.BaseSavedState {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<SavedState> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public int currentPosition;

        /* loaded from: classes3.dex */
        public static class a implements Parcelable.Creator<SavedState> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) {
                    return new SavedState(parcel, null);
                }
                return (SavedState) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public SavedState[] newArray(int i) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                    return new SavedState[i];
                }
                return (SavedState[]) invokeI.objValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1751757160, "Lcom/baidu/tbadk/core/view/PagerSlidingTabStrip$SavedState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1751757160, "Lcom/baidu/tbadk/core/view/PagerSlidingTabStrip$SavedState;");
                    return;
                }
            }
            CREATOR = new a();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavedState(Parcel parcel) {
            super(parcel);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcel};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Parcel) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.currentPosition = parcel.readInt();
        }

        public /* synthetic */ SavedState(Parcel parcel, a aVar) {
            this(parcel);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, parcel, i) == null) {
                super.writeToParcel(parcel, i);
                parcel.writeInt(this.currentPosition);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavedState(Parcelable parcelable) {
            super(parcelable);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcelable};
                interceptable.invokeUnInit(65539, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Parcelable) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PagerSlidingTabStrip a;

        public a(PagerSlidingTabStrip pagerSlidingTabStrip) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pagerSlidingTabStrip};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pagerSlidingTabStrip;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                PagerSlidingTabStrip pagerSlidingTabStrip = this.a;
                pagerSlidingTabStrip.h = pagerSlidingTabStrip.f.getCurrentItem();
                PagerSlidingTabStrip pagerSlidingTabStrip2 = this.a;
                pagerSlidingTabStrip2.l(pagerSlidingTabStrip2.h, 0);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ PagerSlidingTabStrip b;

        public b(PagerSlidingTabStrip pagerSlidingTabStrip, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pagerSlidingTabStrip, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pagerSlidingTabStrip;
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.f.setCurrentItem(this.a);
                this.b.m();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PagerSlidingTabStrip a;

        public d(PagerSlidingTabStrip pagerSlidingTabStrip) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pagerSlidingTabStrip};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pagerSlidingTabStrip;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                ViewPager.OnPageChangeListener onPageChangeListener = this.a.d;
                if (onPageChangeListener != null) {
                    onPageChangeListener.onPageSelected(i);
                }
                this.a.m();
            }
        }

        public /* synthetic */ d(PagerSlidingTabStrip pagerSlidingTabStrip, a aVar) {
            this(pagerSlidingTabStrip);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeI(1048576, this, i) != null) || this.a.e.getChildCount() == 0) {
                return;
            }
            if (i == 0) {
                PagerSlidingTabStrip pagerSlidingTabStrip = this.a;
                pagerSlidingTabStrip.l(pagerSlidingTabStrip.f.getCurrentItem(), 0);
            }
            ViewPager.OnPageChangeListener onPageChangeListener = this.a.d;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageScrollStateChanged(i);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) != null) || this.a.e.getChildCount() == 0) {
                return;
            }
            this.a.h = i;
            this.a.i = f;
            PagerSlidingTabStrip pagerSlidingTabStrip = this.a;
            pagerSlidingTabStrip.l(i, (int) (pagerSlidingTabStrip.e.getChildAt(i).getWidth() * f));
            this.a.invalidate();
            ViewPager.OnPageChangeListener onPageChangeListener = this.a.d;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageScrolled(i, f, i2);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PagerSlidingTabStrip(Context context) {
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
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
        this.c = new d(this, null);
        this.h = 0;
        this.k = false;
        this.l = SkinManager.getColor(R.color.CAM_X0105);
        this.m = SkinManager.getColor(R.color.CAM_X0107);
        SkinManager.getColor(R.color.CAM_X0204);
        this.n = 52;
        this.o = 4;
        this.p = 24;
        this.q = 12;
        this.r = null;
        this.s = 0;
        this.t = 0;
        this.u = R.drawable.obfuscated_res_0x7f080eb3;
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, parcelable) == null) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            this.h = savedState.currentPosition;
            requestLayout();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, onPageChangeListener) == null) {
            this.d = onPageChangeListener;
        }
    }

    public void setViewPager(ViewPager viewPager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, viewPager) == null) {
            this.f = viewPager;
            if (viewPager.getAdapter() == null) {
                return;
            }
            viewPager.setOnPageChangeListener(this.c);
            k();
        }
    }

    public final void h(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
            ImageButton imageButton = new ImageButton(getContext());
            imageButton.setImageResource(i2);
            i(i, imageButton);
        }
    }

    public final void i(int i, View view2) {
        LinearLayout.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, view2) == null) {
            view2.setFocusable(true);
            view2.setOnClickListener(new b(this, i));
            int i2 = this.p;
            view2.setPadding(i2, 0, i2, 0);
            LinearLayout linearLayout = this.e;
            if (this.k) {
                layoutParams = this.b;
            } else {
                layoutParams = this.a;
            }
            linearLayout.addView(view2, i, layoutParams);
        }
    }

    public final void j(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, str) == null) {
            TextView textView = new TextView(getContext());
            textView.setText(str);
            textView.setGravity(17);
            textView.setSingleLine();
            i(i, textView);
        }
    }

    public final void l(int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeII(1048580, this, i, i2) != null) || this.g == 0) {
            return;
        }
        int left = this.e.getChildAt(i).getLeft() + i2;
        if (i > 0 || i2 > 0) {
            left -= this.n;
        }
        if (left != this.t) {
            this.t = left;
            scrollTo(left, 0);
        }
    }

    public void k() {
        ViewPager viewPager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (viewPager = this.f) != null && viewPager.getAdapter() != null && this.f.getAdapter().getCount() != 0) {
            this.e.removeAllViews();
            this.g = this.f.getAdapter().getCount();
            for (int i = 0; i < this.g; i++) {
                if (this.f.getAdapter() instanceof c) {
                    h(i, ((c) this.f.getAdapter()).a(i));
                } else {
                    j(i, this.f.getAdapter().getPageTitle(i).toString());
                }
            }
            m();
            getViewTreeObserver().addOnGlobalLayoutListener(new a(this));
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            for (int i = 0; i < this.g; i++) {
                View childAt = this.e.getChildAt(i);
                if (childAt != null) {
                    childAt.setBackgroundResource(this.u);
                    if (childAt instanceof TextView) {
                        TextView textView = (TextView) childAt;
                        textView.setTextSize(0, this.q);
                        textView.setTypeface(this.r, this.s);
                        if (i == this.f.getCurrentItem()) {
                            textView.setTextColor(this.l);
                        } else {
                            textView.setTextColor(this.m);
                        }
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, canvas) == null) {
            super.onDraw(canvas);
            if (!isInEditMode() && this.g != 0) {
                int height = getHeight();
                int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070258);
                this.j.setColor(this.l);
                View childAt = this.e.getChildAt(this.h);
                float left = childAt.getLeft() + ((childAt.getWidth() - dimensionPixelSize) / 2);
                canvas.drawRoundRect(new RectF(left, height - this.o, dimensionPixelSize + left, height), 10.0f, 10.0f, this.j);
            }
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            SavedState savedState = new SavedState(super.onSaveInstanceState());
            savedState.currentPosition = this.h;
            return savedState;
        }
        return (Parcelable) invokeV.objValue;
    }
}

package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
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
import java.util.Locale;
/* loaded from: classes6.dex */
public class PagerSlidingTabStrip extends HorizontalScrollView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Locale A;
    public ViewPager.OnPageChangeListener delegatePageListener;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout.LayoutParams f47781e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout.LayoutParams f47782f;

    /* renamed from: g  reason: collision with root package name */
    public final d f47783g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f47784h;

    /* renamed from: i  reason: collision with root package name */
    public ViewPager f47785i;

    /* renamed from: j  reason: collision with root package name */
    public int f47786j;
    public int k;
    public float l;
    public Paint m;
    public boolean n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;
    public Typeface w;
    public int x;
    public int y;
    public int z;

    /* loaded from: classes6.dex */
    public static class SavedState extends View.BaseSavedState {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<SavedState> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public int currentPosition;

        /* loaded from: classes6.dex */
        public static class a implements Parcelable.Creator<SavedState> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
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
                return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) ? new SavedState(parcel, null) : (SavedState) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public SavedState[] newArray(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? new SavedState[i2] : (SavedState[]) invokeI.objValue;
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

        public /* synthetic */ SavedState(Parcel parcel, a aVar) {
            this(parcel);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, parcel, i2) == null) {
                super.writeToParcel(parcel, i2);
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Parcelable) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Parcel) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.currentPosition = parcel.readInt();
        }
    }

    /* loaded from: classes6.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PagerSlidingTabStrip f47787e;

        public a(PagerSlidingTabStrip pagerSlidingTabStrip) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pagerSlidingTabStrip};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47787e = pagerSlidingTabStrip;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f47787e.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                PagerSlidingTabStrip pagerSlidingTabStrip = this.f47787e;
                pagerSlidingTabStrip.k = pagerSlidingTabStrip.f47785i.getCurrentItem();
                PagerSlidingTabStrip pagerSlidingTabStrip2 = this.f47787e;
                pagerSlidingTabStrip2.k(pagerSlidingTabStrip2.k, 0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f47788e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PagerSlidingTabStrip f47789f;

        public b(PagerSlidingTabStrip pagerSlidingTabStrip, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pagerSlidingTabStrip, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47789f = pagerSlidingTabStrip;
            this.f47788e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f47789f.f47785i.setCurrentItem(this.f47788e);
                this.f47789f.l();
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface c {
        int a(int i2);
    }

    /* loaded from: classes6.dex */
    public class d implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PagerSlidingTabStrip f47790e;

        public d(PagerSlidingTabStrip pagerSlidingTabStrip) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pagerSlidingTabStrip};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47790e = pagerSlidingTabStrip;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.f47790e.f47784h.getChildCount() == 0) {
                return;
            }
            if (i2 == 0) {
                PagerSlidingTabStrip pagerSlidingTabStrip = this.f47790e;
                pagerSlidingTabStrip.k(pagerSlidingTabStrip.f47785i.getCurrentItem(), 0);
            }
            ViewPager.OnPageChangeListener onPageChangeListener = this.f47790e.delegatePageListener;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageScrollStateChanged(i2);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) || this.f47790e.f47784h.getChildCount() == 0) {
                return;
            }
            this.f47790e.k = i2;
            this.f47790e.l = f2;
            PagerSlidingTabStrip pagerSlidingTabStrip = this.f47790e;
            pagerSlidingTabStrip.k(i2, (int) (pagerSlidingTabStrip.f47784h.getChildAt(i2).getWidth() * f2));
            this.f47790e.invalidate();
            ViewPager.OnPageChangeListener onPageChangeListener = this.f47790e.delegatePageListener;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageScrolled(i2, f2, i3);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                ViewPager.OnPageChangeListener onPageChangeListener = this.f47790e.delegatePageListener;
                if (onPageChangeListener != null) {
                    onPageChangeListener.onPageSelected(i2);
                }
                this.f47790e.l();
            }
        }

        public /* synthetic */ d(PagerSlidingTabStrip pagerSlidingTabStrip, a aVar) {
            this(pagerSlidingTabStrip);
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

    public final void h(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
            ImageButton imageButton = new ImageButton(getContext());
            imageButton.setImageResource(i3);
            i(i2, imageButton);
        }
    }

    public final void i(int i2, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, view) == null) {
            view.setFocusable(true);
            view.setOnClickListener(new b(this, i2));
            int i3 = this.t;
            view.setPadding(i3, 0, i3, 0);
            this.f47784h.addView(view, i2, this.n ? this.f47782f : this.f47781e);
        }
    }

    public void init(int i2, int i3, int i4, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z)}) == null) {
            setFillViewport(true);
            setWillNotDraw(false);
            LinearLayout linearLayout = new LinearLayout(getContext());
            this.f47784h = linearLayout;
            linearLayout.setOrientation(0);
            this.f47784h.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(this.f47784h);
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            this.q = (int) TypedValue.applyDimension(1, this.q, displayMetrics);
            this.s = (int) TypedValue.applyDimension(1, this.s, displayMetrics);
            this.t = (int) TypedValue.applyDimension(1, this.t, displayMetrics);
            this.u = (int) TypedValue.applyDimension(1, this.u, displayMetrics);
            this.v = i2;
            this.r = i4;
            this.n = z;
            Paint paint = new Paint();
            this.m = paint;
            paint.setAntiAlias(true);
            this.m.setStyle(Paint.Style.FILL);
            this.f47781e = new LinearLayout.LayoutParams(-2, -1);
            this.f47782f = new LinearLayout.LayoutParams(0, -1, 1.0f);
            if (this.A == null) {
                this.A = getResources().getConfiguration().locale;
            }
        }
    }

    public final void j(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i2, str) == null) {
            TextView textView = new TextView(getContext());
            textView.setText(str);
            textView.setGravity(17);
            textView.setSingleLine();
            i(i2, textView);
        }
    }

    public final void k(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) || this.f47786j == 0) {
            return;
        }
        int left = this.f47784h.getChildAt(i2).getLeft() + i3;
        if (i2 > 0 || i3 > 0) {
            left -= this.q;
        }
        if (left != this.y) {
            this.y = left;
            scrollTo(left, 0);
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            for (int i2 = 0; i2 < this.f47786j; i2++) {
                View childAt = this.f47784h.getChildAt(i2);
                if (childAt != null) {
                    childAt.setBackgroundResource(this.z);
                    if (childAt instanceof TextView) {
                        TextView textView = (TextView) childAt;
                        textView.setTextSize(0, this.v);
                        textView.setTypeface(this.w, this.x);
                        if (i2 == this.f47785i.getCurrentItem()) {
                            textView.setTextColor(this.o);
                        } else {
                            textView.setTextColor(this.p);
                        }
                    }
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        ViewPager viewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (viewPager = this.f47785i) == null || viewPager.getAdapter() == null || this.f47785i.getAdapter().getCount() == 0) {
            return;
        }
        this.f47784h.removeAllViews();
        this.f47786j = this.f47785i.getAdapter().getCount();
        for (int i2 = 0; i2 < this.f47786j; i2++) {
            if (this.f47785i.getAdapter() instanceof c) {
                h(i2, ((c) this.f47785i.getAdapter()).a(i2));
            } else {
                j(i2, this.f47785i.getAdapter().getPageTitle(i2).toString());
            }
        }
        l();
        getViewTreeObserver().addOnGlobalLayoutListener(new a(this));
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.o = SkinManager.getColor(R.color.CAM_X0105);
            this.p = SkinManager.getColor(R.color.CAM_X0107);
            SkinManager.getColor(R.color.CAM_X0204);
            l();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, canvas) == null) {
            super.onDraw(canvas);
            if (isInEditMode() || this.f47786j == 0) {
                return;
            }
            int height = getHeight();
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds64);
            this.m.setColor(this.o);
            View childAt = this.f47784h.getChildAt(this.k);
            float left = childAt.getLeft() + ((childAt.getWidth() - dimensionPixelSize) / 2);
            canvas.drawRoundRect(new RectF(left, height - this.r, dimensionPixelSize + left, height), 10.0f, 10.0f, this.m);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, parcelable) == null) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            this.k = savedState.currentPosition;
            requestLayout();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            SavedState savedState = new SavedState(super.onSaveInstanceState());
            savedState.currentPosition = this.k;
            return savedState;
        }
        return (Parcelable) invokeV.objValue;
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, onPageChangeListener) == null) {
            this.delegatePageListener = onPageChangeListener;
        }
    }

    public void setViewPager(ViewPager viewPager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, viewPager) == null) {
            this.f47785i = viewPager;
            if (viewPager.getAdapter() == null) {
                return;
            }
            viewPager.setOnPageChangeListener(this.f47783g);
            notifyDataSetChanged();
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f47783g = new d(this, null);
        this.k = 0;
        this.n = false;
        this.o = SkinManager.getColor(R.color.CAM_X0105);
        this.p = SkinManager.getColor(R.color.CAM_X0107);
        SkinManager.getColor(R.color.CAM_X0204);
        this.q = 52;
        this.r = 4;
        this.s = 12;
        this.t = 24;
        this.u = 1;
        this.v = 12;
        this.w = null;
        this.x = 0;
        this.y = 0;
        this.z = R.drawable.pager_sliding_view;
    }
}

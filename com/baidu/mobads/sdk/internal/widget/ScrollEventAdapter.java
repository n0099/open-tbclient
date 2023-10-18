package com.baidu.mobads.sdk.internal.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.internal.widget.ViewPager2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Locale;
/* loaded from: classes3.dex */
public final class ScrollEventAdapter extends RecyclerView.OnScrollListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = 4;
    public static final int f = -1;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewPager2.OnPageChangeCallback g;
    @NonNull
    public final ViewPager2 h;
    @NonNull
    public final RecyclerView i;
    @NonNull
    public final LinearLayoutManager j;
    public int k;
    public int l;
    public ScrollEventValues m;
    public int n;
    public int o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface AdapterState {
    }

    /* loaded from: classes3.dex */
    public static final class ScrollEventValues {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public float b;
        public int c;

        public ScrollEventValues() {
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

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a = -1;
                this.b = 0.0f;
                this.c = 0;
            }
        }
    }

    public ScrollEventAdapter(@NonNull ViewPager2 viewPager2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {viewPager2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = viewPager2;
        RecyclerView recyclerView = viewPager2.j;
        this.i = recyclerView;
        this.j = (LinearLayoutManager) recyclerView.getLayoutManager();
        this.m = new ScrollEventValues();
        i();
    }

    private void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65537, this, i) == null) {
            if ((this.k == 3 && this.l == 0) || this.l == i) {
                return;
            }
            this.l = i;
            ViewPager2.OnPageChangeCallback onPageChangeCallback = this.g;
            if (onPageChangeCallback != null) {
                onPageChangeCallback.onPageScrollStateChanged(i);
            }
        }
    }

    private void b(int i) {
        ViewPager2.OnPageChangeCallback onPageChangeCallback;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i) == null) && (onPageChangeCallback = this.g) != null) {
            onPageChangeCallback.onPageSelected(i);
        }
    }

    private void a(int i, float f2, int i2) {
        ViewPager2.OnPageChangeCallback onPageChangeCallback;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65538, this, new Object[]{Integer.valueOf(i), Float.valueOf(f2), Integer.valueOf(i2)}) == null) && (onPageChangeCallback = this.g) != null) {
            onPageChangeCallback.onPageScrolled(i, f2, i2);
        }
    }

    private void a(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65539, this, z) == null) {
            this.s = z;
            if (z) {
                i = 4;
            } else {
                i = 1;
            }
            this.k = i;
            int i2 = this.o;
            if (i2 != -1) {
                this.n = i2;
                this.o = -1;
            } else if (this.n == -1) {
                this.n = l();
            }
            a(1);
        }
    }

    private void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            this.k = 0;
            this.l = 0;
            this.m.a();
            this.n = -1;
            this.o = -1;
            this.p = false;
            this.q = false;
            this.s = false;
            this.r = false;
        }
    }

    private boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            int i = this.k;
            if (i == 1 || i == 4) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            return this.j.findFirstVisibleItemPosition();
        }
        return invokeV.intValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.r = true;
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.k = 4;
            a(true);
        }
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.l;
        }
        return invokeV.intValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.l == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.l == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.s;
        }
        return invokeV.booleanValue;
    }

    public double h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            j();
            ScrollEventValues scrollEventValues = this.m;
            return scrollEventValues.a + scrollEventValues.b;
        }
        return invokeV.doubleValue;
    }

    private void j() {
        boolean z;
        int top;
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            ScrollEventValues scrollEventValues = this.m;
            int findFirstVisibleItemPosition = this.j.findFirstVisibleItemPosition();
            scrollEventValues.a = findFirstVisibleItemPosition;
            if (findFirstVisibleItemPosition == -1) {
                scrollEventValues.a();
                return;
            }
            View findViewByPosition = this.j.findViewByPosition(findFirstVisibleItemPosition);
            if (findViewByPosition == null) {
                scrollEventValues.a();
                return;
            }
            int leftDecorationWidth = this.j.getLeftDecorationWidth(findViewByPosition);
            int rightDecorationWidth = this.j.getRightDecorationWidth(findViewByPosition);
            int topDecorationHeight = this.j.getTopDecorationHeight(findViewByPosition);
            int bottomDecorationHeight = this.j.getBottomDecorationHeight(findViewByPosition);
            ViewGroup.LayoutParams layoutParams = findViewByPosition.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                leftDecorationWidth += marginLayoutParams.leftMargin;
                rightDecorationWidth += marginLayoutParams.rightMargin;
                topDecorationHeight += marginLayoutParams.topMargin;
                bottomDecorationHeight += marginLayoutParams.bottomMargin;
            }
            int height = findViewByPosition.getHeight() + topDecorationHeight + bottomDecorationHeight;
            int width = findViewByPosition.getWidth() + leftDecorationWidth + rightDecorationWidth;
            if (this.j.getOrientation() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                top = (findViewByPosition.getLeft() - leftDecorationWidth) - this.i.getPaddingLeft();
                if (this.h.c()) {
                    top = -top;
                }
                height = width;
            } else {
                top = (findViewByPosition.getTop() - topDecorationHeight) - this.i.getPaddingTop();
            }
            int i = -top;
            scrollEventValues.c = i;
            if (i < 0) {
                if (new AnimateLayoutChangeDetector(this.j).a()) {
                    throw new IllegalStateException("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
                }
                throw new IllegalStateException(String.format(Locale.US, "Page can only be offset by a positive amount, not by %d", Integer.valueOf(scrollEventValues.c)));
            }
            if (height == 0) {
                f2 = 0.0f;
            } else {
                f2 = i / height;
            }
            scrollEventValues.b = f2;
        }
    }

    public void a(int i, boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            if (z) {
                i2 = 2;
            } else {
                i2 = 3;
            }
            this.k = i2;
            boolean z2 = false;
            this.s = false;
            if (this.o != i) {
                z2 = true;
            }
            this.o = i;
            a(2);
            if (z2) {
                b(i);
            }
        }
    }

    public void a(ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onPageChangeCallback) == null) {
            this.g = onPageChangeCallback;
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (f() && !this.s) {
                return;
            }
            this.s = false;
            j();
            ScrollEventValues scrollEventValues = this.m;
            if (scrollEventValues.c == 0) {
                int i = scrollEventValues.a;
                if (i != this.n) {
                    b(i);
                }
                a(0);
                i();
                return;
            }
            a(2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048586, this, recyclerView, i) == null) {
            boolean z = true;
            if ((this.k != 1 || this.l != 1) && i == 1) {
                a(false);
            } else if (k() && i == 2) {
                if (this.q) {
                    a(2);
                    this.p = true;
                }
            } else {
                if (k() && i == 0) {
                    j();
                    if (!this.q) {
                        int i2 = this.m.a;
                        if (i2 != -1) {
                            a(i2, 0.0f, 0);
                        }
                    } else {
                        ScrollEventValues scrollEventValues = this.m;
                        if (scrollEventValues.c == 0) {
                            int i3 = this.n;
                            int i4 = scrollEventValues.a;
                            if (i3 != i4) {
                                b(i4);
                            }
                        } else {
                            z = false;
                        }
                    }
                    if (z) {
                        a(0);
                        i();
                    }
                }
                if (this.k == 2 && i == 0 && this.r) {
                    j();
                    ScrollEventValues scrollEventValues2 = this.m;
                    if (scrollEventValues2.c == 0) {
                        int i5 = this.o;
                        int i6 = scrollEventValues2.a;
                        if (i5 != i6) {
                            if (i6 == -1) {
                                i6 = 0;
                            }
                            b(i6);
                        }
                        a(0);
                        i();
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0021, code lost:
        if (r6 == r4.h.c()) goto L38;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003d  */
    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
        boolean z;
        int i3;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048587, this, recyclerView, i, i2) == null) {
            this.q = true;
            j();
            if (this.p) {
                this.p = false;
                if (i2 <= 0) {
                    if (i2 == 0) {
                        if (i < 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                    }
                    z = false;
                    if (z) {
                        ScrollEventValues scrollEventValues = this.m;
                        if (scrollEventValues.c != 0) {
                            i3 = scrollEventValues.a + 1;
                            this.o = i3;
                            if (this.n != i3) {
                                b(i3);
                            }
                        }
                    }
                    i3 = this.m.a;
                    this.o = i3;
                    if (this.n != i3) {
                    }
                }
                z = true;
                if (z) {
                }
                i3 = this.m.a;
                this.o = i3;
                if (this.n != i3) {
                }
            } else if (this.k == 0) {
                int i4 = this.m.a;
                if (i4 == -1) {
                    i4 = 0;
                }
                b(i4);
            }
            int i5 = this.m.a;
            if (i5 == -1) {
                i5 = 0;
            }
            ScrollEventValues scrollEventValues2 = this.m;
            a(i5, scrollEventValues2.b, scrollEventValues2.c);
            int i6 = this.m.a;
            int i7 = this.o;
            if ((i6 == i7 || i7 == -1) && this.m.c == 0 && this.l != 1) {
                a(0);
                i();
            }
        }
    }
}

package b.a.q0.f1.e;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class b extends e implements View.OnTouchListener, GestureDetector.OnGestureListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float A;
    public int B;
    public int C;
    public int D;
    public boolean E;
    public ListView F;
    public b.a.q0.f1.e.a G;
    public int H;
    public GestureDetector.OnGestureListener I;

    /* renamed from: i  reason: collision with root package name */
    public int f12306i;
    public boolean j;
    public int k;
    public boolean l;
    public boolean m;
    public GestureDetector n;
    public GestureDetector o;
    public GestureDetector p;
    public int q;
    public int r;
    public int s;
    public int t;
    public int[] u;
    public int v;
    public int w;
    public int x;
    public int y;
    public boolean z;

    /* loaded from: classes4.dex */
    public class a implements GestureDetector.OnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f12307e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12307e = bVar;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                if (!this.f12307e.G.g0() || this.f12307e.G.h0()) {
                    return false;
                }
                this.f12307e.onDown(motionEvent);
                this.f12307e.x = (int) motionEvent.getX();
                this.f12307e.y = (int) motionEvent.getY();
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                return false;
            }
            return invokeCommon.booleanValue;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent) == null) {
                this.f12307e.onLongPress(motionEvent);
            }
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                return false;
            }
            return invokeCommon.booleanValue;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onShowPress(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, motionEvent) == null) {
            }
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, motionEvent)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* renamed from: b.a.q0.f1.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0648b extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f12308e;

        public C0648b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12308e = bVar;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                if (this.f12308e.l && this.f12308e.m) {
                    int width = this.f12308e.F.getWidth() / 5;
                    if (f2 > this.f12308e.A) {
                        if (this.f12308e.H > (-width)) {
                            this.f12308e.G.A0(true, f2);
                        }
                    } else if (f2 < (-this.f12308e.A) && this.f12308e.H < width) {
                        this.f12308e.G.A0(true, f2);
                    }
                    this.f12308e.m = false;
                }
                return false;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(b.a.q0.f1.e.a aVar, ListView listView, int i2, int i3, int i4) {
        this(aVar, listView, i2, i3, i4, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, listView, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((b.a.q0.f1.e.a) objArr2[0], (ListView) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), ((Integer) objArr2[4]).intValue(), ((Integer) objArr2[5]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // b.a.q0.f1.e.a.j
    public void c(View view, Point point, Point point2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048576, this, view, point, point2) == null) && this.l && this.m) {
            this.H = point.x;
        }
    }

    public int n(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) ? x(motionEvent, this.B) : invokeL.intValue;
    }

    public int o(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) ? x(motionEvent, this.D) : invokeL.intValue;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, motionEvent)) == null) {
            if (this.l && this.k == 0) {
                this.t = x(motionEvent, this.C);
            }
            int v = v(motionEvent);
            this.r = v;
            if (v != -1 && this.f12306i == 0) {
                u(v, ((int) motionEvent.getX()) - this.v, ((int) motionEvent.getY()) - this.w);
            }
            this.m = false;
            this.E = true;
            this.H = 0;
            this.s = w(motionEvent);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, motionEvent) == null) && this.r != -1 && this.f12306i == 2) {
            this.F.performHapticFeedback(0);
            u(this.r, this.x - this.v, this.y - this.w);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            if (motionEvent != null && motionEvent2 != null) {
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                int x2 = (int) motionEvent2.getX();
                int y2 = (int) motionEvent2.getY();
                int i2 = x2 - this.v;
                int i3 = y2 - this.w;
                if (this.E && !this.z && (this.r != -1 || this.s != -1)) {
                    if (this.r != -1) {
                        if (this.f12306i == 1 && Math.abs(y2 - y) > this.q && this.j) {
                            u(this.r, i2, i3);
                        } else if (this.f12306i != 0 && Math.abs(x2 - x) > this.q && this.l) {
                            this.m = true;
                            u(this.s, i2, i3);
                        }
                    } else if (this.s != -1) {
                        if (Math.abs(x2 - x) > this.q && this.l) {
                            this.m = true;
                            u(this.s, i2, i3);
                        } else if (Math.abs(y2 - y) > this.q) {
                            this.E = false;
                        }
                    }
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, motionEvent) == null) {
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, motionEvent)) == null) {
            if (this.l && this.k == 0 && (i2 = this.t) != -1) {
                this.G.l0(i2 - this.F.getHeaderViewsCount());
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, view, motionEvent)) == null) {
            if (this.G.g0() && !this.G.h0()) {
                this.n.onTouchEvent(motionEvent);
                if (this.l && this.z && this.k == 1) {
                    this.p.onTouchEvent(motionEvent);
                }
                int action = motionEvent.getAction() & 255;
                if (action == 0) {
                    this.x = (int) motionEvent.getX();
                    this.y = (int) motionEvent.getY();
                } else if (action == 1) {
                    if (this.l && this.m) {
                        int i2 = this.H;
                        if (i2 < 0) {
                            i2 = -i2;
                        }
                        if (i2 > this.F.getWidth() / 2) {
                            this.G.A0(true, 0.0f);
                        }
                    }
                    this.m = false;
                    this.z = false;
                } else if (action == 3) {
                    this.m = false;
                    this.z = false;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public GestureDetector p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.o : (GestureDetector) invokeV.objValue;
    }

    public void q(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f12306i = i2;
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.l = z;
        }
    }

    public void s(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.k = i2;
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.j = z;
        }
    }

    public boolean u(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048591, this, i2, i3, i4)) == null) {
            int i5 = (!this.j || this.m) ? 0 : 12;
            if (this.l && this.m) {
                i5 = i5 | 1 | 2;
            }
            boolean w0 = this.G.w0(i2 - this.F.getHeaderViewsCount(), i5, i3, i4);
            this.z = w0;
            return w0;
        }
        return invokeIII.booleanValue;
    }

    public int v(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, motionEvent)) == null) ? n(motionEvent) : invokeL.intValue;
    }

    public int w(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, motionEvent)) == null) {
            if (this.k == 1) {
                return o(motionEvent);
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public int x(MotionEvent motionEvent, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048594, this, motionEvent, i2)) == null) {
            int pointToPosition = this.F.pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            int headerViewsCount = this.F.getHeaderViewsCount();
            int footerViewsCount = this.F.getFooterViewsCount();
            int count = this.F.getCount();
            if (pointToPosition != -1 && pointToPosition >= headerViewsCount && pointToPosition < count - footerViewsCount) {
                ListView listView = this.F;
                View childAt = listView.getChildAt(pointToPosition - listView.getFirstVisiblePosition());
                int rawX = (int) motionEvent.getRawX();
                int rawY = (int) motionEvent.getRawY();
                View findViewById = i2 == 0 ? childAt : childAt.findViewById(i2);
                if (findViewById != null) {
                    findViewById.getLocationOnScreen(this.u);
                    int[] iArr = this.u;
                    if (rawX > iArr[0] && rawY > iArr[1] && rawX < iArr[0] + findViewById.getWidth() && rawY < this.u[1] + findViewById.getHeight()) {
                        this.v = childAt.getLeft();
                        this.w = childAt.getTop();
                        return pointToPosition;
                    }
                }
            }
            return -1;
        }
        return invokeLI.intValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(b.a.q0.f1.e.a aVar, ListView listView, int i2, int i3, int i4, int i5) {
        this(aVar, listView, i2, i3, i4, i5, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, listView, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i6 = newInitContext.flag;
            if ((i6 & 1) != 0) {
                int i7 = i6 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((b.a.q0.f1.e.a) objArr2[0], (ListView) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), ((Integer) objArr2[4]).intValue(), ((Integer) objArr2[5]).intValue(), ((Integer) objArr2[6]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(b.a.q0.f1.e.a aVar, ListView listView, int i2, int i3, int i4, int i5, int i6) {
        super(listView);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, listView, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i7 = newInitContext.flag;
            if ((i7 & 1) != 0) {
                int i8 = i7 & 2;
                super((ListView) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f12306i = 0;
        this.j = true;
        this.l = false;
        this.m = false;
        this.r = -1;
        this.s = -1;
        this.t = -1;
        this.u = new int[2];
        this.z = false;
        this.A = 500.0f;
        this.I = new C0648b(this);
        this.G = aVar;
        this.F = listView;
        this.n = new GestureDetector(listView.getContext(), this);
        this.o = new GestureDetector(listView.getContext(), new a(this));
        GestureDetector gestureDetector = new GestureDetector(listView.getContext(), this.I);
        this.p = gestureDetector;
        gestureDetector.setIsLongpressEnabled(false);
        this.q = ViewConfiguration.get(listView.getContext()).getScaledTouchSlop();
        this.B = i2;
        this.C = i5;
        this.D = i6;
        s(i4);
        q(i3);
    }
}

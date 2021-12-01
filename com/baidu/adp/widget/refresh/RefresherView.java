package com.baidu.adp.widget.refresh;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.d.m.i;
import com.baidu.adp.R;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
/* loaded from: classes8.dex */
public class RefresherView extends ViewGroup {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c A;
    public c.a.d.m.k.b B;
    public d C;
    public i D;
    public IRefreshable$State E;

    /* renamed from: e  reason: collision with root package name */
    public final int f32002e;

    /* renamed from: f  reason: collision with root package name */
    public final int f32003f;

    /* renamed from: g  reason: collision with root package name */
    public int f32004g;

    /* renamed from: h  reason: collision with root package name */
    public int f32005h;

    /* renamed from: i  reason: collision with root package name */
    public final int f32006i;

    /* renamed from: j  reason: collision with root package name */
    public final int f32007j;

    /* renamed from: k  reason: collision with root package name */
    public final int f32008k;
    public View l;
    public View m;
    public View n;
    public boolean o;
    public boolean p;
    public int q;
    public int r;
    public final int[] s;
    public final int[] t;
    public int u;
    public int v;
    public int w;
    public int x;
    public int y;
    public final b z;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;

        /* renamed from: b  reason: collision with root package name */
        public long f32009b;

        /* renamed from: c  reason: collision with root package name */
        public int f32010c;

        /* renamed from: d  reason: collision with root package name */
        public int f32011d;

        /* renamed from: e  reason: collision with root package name */
        public int f32012e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ RefresherView f32013f;

        public b(RefresherView refresherView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {refresherView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f32013f = refresherView;
        }

        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                this.a = uptimeMillis;
                this.f32009b = uptimeMillis + 16;
                if (i2 == 1000) {
                    this.f32012e = this.f32013f.w - this.f32013f.y;
                    this.f32011d = 0;
                    this.f32010c = Math.max(this.f32013f.f32002e, (this.f32013f.w - this.f32013f.y) * 2);
                    this.f32013f.A.removeMessages(1000);
                    this.f32013f.A.sendEmptyMessageAtTime(1000, this.f32009b);
                } else if (i2 == 1001) {
                    this.f32012e = this.f32013f.f32004g;
                    this.f32011d = 0;
                    this.f32010c = this.f32013f.f32003f;
                    this.f32013f.A.removeMessages(1001);
                    this.f32013f.A.sendEmptyMessageAtTime(1001, this.f32009b);
                }
                this.f32013f.E = IRefreshable$State.animating;
                c.a.d.m.k.b bVar = this.f32013f.B;
                if (bVar != null) {
                    bVar.a(IRefreshable$State.animating);
                }
            }
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                int i2 = (int) (this.f32011d + (this.f32010c * (((float) (uptimeMillis - this.a)) / 1000.0f)));
                this.f32011d = i2;
                if (i2 >= this.f32012e) {
                    RefresherView refresherView = this.f32013f;
                    refresherView.w = refresherView.y;
                    this.f32013f.E = IRefreshable$State.idle;
                    c.a.d.m.k.b bVar = this.f32013f.B;
                    if (bVar != null) {
                        bVar.a(IRefreshable$State.idle);
                    }
                    if (this.f32013f.y == 0 && bVar != null) {
                        bVar.b();
                        this.f32013f.p = false;
                    }
                } else {
                    RefresherView refresherView2 = this.f32013f;
                    int i3 = this.f32012e;
                    refresherView2.w = (int) (refresherView2.y + (i3 * (1.0f - c.a.d.m.a.a.getInterpolation(this.f32011d / i3))));
                    this.a = uptimeMillis;
                    this.f32009b = uptimeMillis + 16;
                    this.f32013f.A.removeMessages(1000);
                    this.f32013f.A.sendEmptyMessageAtTime(1000, this.f32009b);
                }
                this.f32013f.invalidate();
            }
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                int i2 = (int) (this.f32011d + (this.f32010c * (((float) (uptimeMillis - this.a)) / 1000.0f)));
                this.f32011d = i2;
                int i3 = this.f32012e;
                if (i2 >= i3) {
                    RefresherView refresherView = this.f32013f;
                    refresherView.w = refresherView.f32004g;
                    this.f32013f.E = IRefreshable$State.idle;
                    c.a.d.m.k.b bVar = this.f32013f.B;
                    if (bVar != null) {
                        bVar.a(IRefreshable$State.idle);
                        this.f32013f.refresh();
                    }
                } else {
                    this.f32013f.w = c.a.d.m.a.a(i3, i2, false);
                    this.a = uptimeMillis;
                    this.f32009b = uptimeMillis + 16;
                    this.f32013f.A.removeMessages(1001);
                    this.f32013f.A.sendEmptyMessageAtTime(1001, this.f32009b);
                }
                this.f32013f.invalidate();
            }
        }

        public /* synthetic */ b(RefresherView refresherView, a aVar) {
            this(refresherView);
        }
    }

    /* loaded from: classes8.dex */
    public class c extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RefresherView a;

        public c(RefresherView refresherView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {refresherView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = refresherView;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i2 = message.what;
                if (i2 == 1000) {
                    this.a.z.b();
                } else if (i2 == 1001) {
                    this.a.z.c();
                }
            }
        }

        public /* synthetic */ c(RefresherView refresherView, a aVar) {
            this(refresherView);
        }
    }

    /* loaded from: classes8.dex */
    public class d extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final c.a.d.m.k.b a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ RefresherView f32014b;

        public d(RefresherView refresherView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {refresherView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f32014b = refresherView;
            this.a = refresherView.B;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Void r5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, r5) == null) {
                this.f32014b.y = 0;
                this.f32014b.D.c(1000);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.a == null) {
                return;
            }
            RefresherView refresherView = this.f32014b;
            refresherView.y = refresherView.f32004g;
            this.a.d();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, voidArr)) == null) {
                this.f32014b.p = true;
                c.a.d.m.k.b bVar = this.a;
                if (bVar != null) {
                    bVar.c();
                    return null;
                }
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class e extends Handler implements i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final int f32015e;

        /* renamed from: f  reason: collision with root package name */
        public long f32016f;

        /* renamed from: g  reason: collision with root package name */
        public long f32017g;

        /* renamed from: h  reason: collision with root package name */
        public float f32018h;

        /* renamed from: i  reason: collision with root package name */
        public float f32019i;

        /* renamed from: j  reason: collision with root package name */
        public int f32020j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ RefresherView f32021k;

        public e(RefresherView refresherView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {refresherView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f32021k = refresherView;
            this.f32015e = (int) ((refresherView.getResources().getDisplayMetrics().density * 75.0f) + 0.5d);
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0017, code lost:
            if (r0 != 3) goto L9;
         */
        @Override // c.a.d.m.j
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean a(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                int action = motionEvent.getAction() & 255;
                int x = (int) motionEvent.getX();
                if (action != 1) {
                    if (action == 2) {
                        RefresherView refresherView = this.f32021k;
                        refresherView.x = Math.max(0, Math.min((x - refresherView.r) - this.f32015e, this.f32021k.f32005h * 2));
                        if (this.f32021k.x <= this.f32021k.f32004g || this.f32021k.E != IRefreshable$State.pulling_no_refresh) {
                            if (this.f32021k.x < this.f32021k.f32004g && this.f32021k.E == IRefreshable$State.pulling_refresh) {
                                this.f32021k.E = IRefreshable$State.pulling_no_refresh;
                                c.a.d.m.k.b bVar = this.f32021k.B;
                                if (bVar != null) {
                                    bVar.a(IRefreshable$State.pulling_no_refresh);
                                }
                            }
                        } else {
                            this.f32021k.E = IRefreshable$State.pulling_refresh;
                            c.a.d.m.k.b bVar2 = this.f32021k.B;
                            if (bVar2 != null) {
                                bVar2.a(IRefreshable$State.pulling_refresh);
                            }
                        }
                        this.f32021k.invalidate();
                    }
                    return true;
                }
                if (this.f32021k.x <= this.f32021k.f32004g) {
                    this.f32021k.y = 0;
                } else {
                    this.f32021k.refresh();
                }
                c(1000);
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // c.a.d.m.j
        public void b(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
                int i4 = i2 & LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
                int i5 = i3 & LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
                if (this.f32021k.l != null) {
                    RefresherView refresherView = this.f32021k;
                    refresherView.measureChild(refresherView.l, i4 + 1073741824, i5 + 1073741824);
                }
                if (this.f32021k.n != null) {
                    RefresherView refresherView2 = this.f32021k;
                    refresherView2.measureChild(refresherView2.n, i4 - 2147483648, i5 - 2147483648);
                }
                if (this.f32021k.m != null) {
                    RefresherView refresherView3 = this.f32021k;
                    refresherView3.measureChild(refresherView3.m, Integer.MIN_VALUE + i4, 1073741824 + i5);
                }
                this.f32021k.setMeasuredDimension(i4, i5);
            }
        }

        @Override // c.a.d.m.j
        public void c(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                if (i2 == 1000) {
                    f();
                } else if (i2 != 1001) {
                } else {
                    g();
                }
            }
        }

        @Override // c.a.d.m.i
        public void d(boolean z, int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
                int i6 = i4 - i2;
                int i7 = i5 - i3;
                if (this.f32021k.l != null) {
                    this.f32021k.l.layout(0, 0, i6, i7);
                }
                if (this.f32021k.n != null) {
                    this.f32021k.n.layout((i6 - this.f32021k.n.getMeasuredWidth()) / 2, (i7 - this.f32021k.n.getMeasuredHeight()) / 2, (i6 + this.f32021k.n.getMeasuredWidth()) / 2, (this.f32021k.n.getMeasuredHeight() + i7) / 2);
                }
                if (this.f32021k.m != null) {
                    this.f32021k.m.layout(-this.f32021k.m.getMeasuredWidth(), 0, 0, i7);
                }
                RefresherView refresherView = this.f32021k;
                refresherView.getLocationOnScreen(refresherView.t);
                RefresherView refresherView2 = this.f32021k;
                refresherView2.v = refresherView2.t[0];
            }
        }

        @Override // c.a.d.m.j
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, motionEvent)) == null) {
                RefresherView.super.dispatchTouchEvent(motionEvent);
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // c.a.d.m.j
        public void draw(Canvas canvas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, canvas) == null) {
                long drawingTime = this.f32021k.getDrawingTime();
                if (this.f32021k.n != null) {
                    RefresherView refresherView = this.f32021k;
                    refresherView.drawChild(canvas, refresherView.n, drawingTime);
                }
                canvas.save();
                canvas.translate(this.f32021k.x >> 1, 0.0f);
                RefresherView refresherView2 = this.f32021k;
                refresherView2.drawChild(canvas, refresherView2.l, drawingTime);
                if (this.f32021k.x > 0) {
                    RefresherView refresherView3 = this.f32021k;
                    refresherView3.drawChild(canvas, refresherView3.m, drawingTime);
                }
                canvas.restore();
            }
        }

        @Override // c.a.d.m.j
        public boolean e(MotionEvent motionEvent) {
            InterceptResult invokeL;
            View childAt;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, motionEvent)) == null) {
                if (this.f32021k.o && !this.f32021k.p) {
                    int action = motionEvent.getAction() & 255;
                    int x = (int) motionEvent.getX();
                    if (action == 0) {
                        this.f32021k.r = x;
                        removeMessages(1000);
                        removeMessages(1001);
                    } else if (action == 2) {
                        if (!(this.f32021k.l instanceof ViewGroup) || (childAt = ((ViewGroup) this.f32021k.l).getChildAt(0)) == null) {
                            this.f32021k.l.getLocationOnScreen(this.f32021k.s);
                            if (this.f32021k.s[0] == this.f32021k.v && x > this.f32021k.r + this.f32015e) {
                                this.f32021k.E = IRefreshable$State.pulling_no_refresh;
                                c.a.d.m.k.b bVar = this.f32021k.B;
                                if (bVar != null) {
                                    bVar.a(IRefreshable$State.pulling_no_refresh);
                                }
                                return true;
                            }
                        } else {
                            childAt.getLocationOnScreen(this.f32021k.s);
                            if (this.f32021k.s[0] == this.f32021k.v && x > this.f32021k.r + this.f32015e) {
                                this.f32021k.E = IRefreshable$State.pulling_no_refresh;
                                c.a.d.m.k.b bVar2 = this.f32021k.B;
                                if (bVar2 != null) {
                                    bVar2.a(IRefreshable$State.pulling_no_refresh);
                                }
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public final void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                this.f32017g = uptimeMillis;
                this.f32016f = uptimeMillis + 16;
                this.f32019i = this.f32021k.x - this.f32021k.y;
                this.f32018h = 0.0f;
                this.f32020j = Math.max(this.f32021k.f32002e, (this.f32021k.x - this.f32021k.y) * 2);
                removeMessages(1000);
                sendEmptyMessageAtTime(1000, this.f32016f);
            }
        }

        public final void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                this.f32017g = uptimeMillis;
                this.f32016f = uptimeMillis + 16;
                this.f32019i = this.f32021k.f32004g;
                this.f32018h = 0.0f;
                this.f32020j = this.f32021k.f32003f;
                removeMessages(1001);
                sendEmptyMessageAtTime(1001, this.f32016f);
            }
        }

        public final void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                float f2 = this.f32018h + (this.f32020j * (((float) (uptimeMillis - this.f32017g)) / 1000.0f));
                this.f32018h = f2;
                if (f2 >= this.f32019i) {
                    RefresherView refresherView = this.f32021k;
                    refresherView.x = refresherView.y;
                    this.f32021k.E = IRefreshable$State.idle;
                    c.a.d.m.k.b bVar = this.f32021k.B;
                    if (bVar != null) {
                        bVar.a(IRefreshable$State.idle);
                    }
                    if (this.f32021k.y == 0 && bVar != null) {
                        bVar.b();
                        this.f32021k.p = false;
                    }
                } else {
                    RefresherView refresherView2 = this.f32021k;
                    float f3 = this.f32019i;
                    refresherView2.x = (int) (refresherView2.y + (f3 * (1.0f - c.a.d.m.a.a.getInterpolation(this.f32018h / f3))));
                    this.f32017g = uptimeMillis;
                    this.f32016f = uptimeMillis + 16;
                    removeMessages(1000);
                    sendEmptyMessageAtTime(1000, this.f32016f);
                }
                this.f32021k.invalidate();
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, message) == null) {
                int i2 = message.what;
                if (i2 == 1000) {
                    h();
                } else if (i2 != 1001) {
                } else {
                    i();
                }
            }
        }

        public final void i() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                float f2 = this.f32018h + (this.f32020j * (((float) (uptimeMillis - this.f32017g)) / 1000.0f));
                this.f32018h = f2;
                float f3 = this.f32019i;
                if (f2 >= f3) {
                    RefresherView refresherView = this.f32021k;
                    refresherView.x = refresherView.f32004g;
                    this.f32021k.E = IRefreshable$State.idle;
                    c.a.d.m.k.b bVar = this.f32021k.B;
                    if (bVar != null) {
                        bVar.a(IRefreshable$State.idle);
                        this.f32021k.refresh();
                    }
                } else {
                    this.f32021k.x = c.a.d.m.a.a(f3, f2, false);
                    this.f32017g = uptimeMillis;
                    this.f32016f = uptimeMillis + 16;
                    removeMessages(1001);
                    sendEmptyMessageAtTime(1001, this.f32016f);
                }
                this.f32021k.invalidate();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RefresherView f32022e;

        public f(RefresherView refresherView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {refresherView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f32022e = refresherView;
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0017, code lost:
            if (r0 != 3) goto L9;
         */
        @Override // c.a.d.m.j
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean a(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                int action = motionEvent.getAction() & 255;
                int y = (int) motionEvent.getY();
                if (action != 1) {
                    if (action == 2) {
                        RefresherView refresherView = this.f32022e;
                        refresherView.w = Math.max(0, Math.min(y - refresherView.q, this.f32022e.f32005h * 2));
                        if (this.f32022e.w <= this.f32022e.f32004g || this.f32022e.E != IRefreshable$State.pulling_no_refresh) {
                            if (this.f32022e.w < this.f32022e.f32004g && this.f32022e.E == IRefreshable$State.pulling_refresh) {
                                this.f32022e.E = IRefreshable$State.pulling_no_refresh;
                                c.a.d.m.k.b bVar = this.f32022e.B;
                                if (bVar != null) {
                                    bVar.a(IRefreshable$State.pulling_no_refresh);
                                }
                            }
                        } else {
                            this.f32022e.E = IRefreshable$State.pulling_refresh;
                            c.a.d.m.k.b bVar2 = this.f32022e.B;
                            if (bVar2 != null) {
                                bVar2.a(IRefreshable$State.pulling_refresh);
                            }
                        }
                        this.f32022e.invalidate();
                    }
                    return true;
                }
                if (this.f32022e.w <= this.f32022e.f32004g) {
                    this.f32022e.y = 0;
                } else {
                    this.f32022e.refresh();
                }
                c(1000);
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // c.a.d.m.j
        public void b(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
                int i4 = i2 & LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
                int i5 = i3 & LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
                if (this.f32022e.l != null) {
                    RefresherView refresherView = this.f32022e;
                    refresherView.measureChild(refresherView.l, i4 + 1073741824, i5 + 1073741824);
                }
                if (this.f32022e.n != null) {
                    RefresherView refresherView2 = this.f32022e;
                    refresherView2.measureChild(refresherView2.n, i4 - 2147483648, i5 - 2147483648);
                }
                if (this.f32022e.m != null) {
                    RefresherView refresherView3 = this.f32022e;
                    refresherView3.measureChild(refresherView3.m, 1073741824 + i4, Integer.MIN_VALUE + i5);
                }
                this.f32022e.setMeasuredDimension(i4, i5);
            }
        }

        @Override // c.a.d.m.j
        public void c(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                this.f32022e.z.a(i2);
            }
        }

        @Override // c.a.d.m.i
        public void d(boolean z, int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
                int i6 = i4 - i2;
                int i7 = i5 - i3;
                if (this.f32022e.l != null) {
                    this.f32022e.l.layout(0, 0, i6, i7);
                }
                if (this.f32022e.n != null) {
                    this.f32022e.n.layout((i6 - this.f32022e.n.getMeasuredWidth()) / 2, (i7 - this.f32022e.n.getMeasuredHeight()) / 2, (this.f32022e.n.getMeasuredWidth() + i6) / 2, (i7 + this.f32022e.n.getMeasuredHeight()) / 2);
                }
                if (this.f32022e.m != null) {
                    this.f32022e.m.layout(0, -this.f32022e.m.getMeasuredHeight(), i6, 0);
                }
                RefresherView refresherView = this.f32022e;
                refresherView.getLocationOnScreen(refresherView.t);
                RefresherView refresherView2 = this.f32022e;
                refresherView2.u = refresherView2.t[1];
            }
        }

        @Override // c.a.d.m.j
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, motionEvent)) == null) {
                RefresherView.super.dispatchTouchEvent(motionEvent);
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // c.a.d.m.j
        public void draw(Canvas canvas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, canvas) == null) {
                long drawingTime = this.f32022e.getDrawingTime();
                if (this.f32022e.n != null) {
                    RefresherView refresherView = this.f32022e;
                    refresherView.drawChild(canvas, refresherView.n, drawingTime);
                }
                canvas.save();
                canvas.translate(0.0f, this.f32022e.w / 2);
                RefresherView refresherView2 = this.f32022e;
                refresherView2.drawChild(canvas, refresherView2.l, drawingTime);
                if (this.f32022e.w > 0) {
                    RefresherView refresherView3 = this.f32022e;
                    refresherView3.drawChild(canvas, refresherView3.m, drawingTime);
                }
                canvas.restore();
            }
        }

        @Override // c.a.d.m.j
        public boolean e(MotionEvent motionEvent) {
            InterceptResult invokeL;
            View childAt;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, motionEvent)) == null) {
                if (this.f32022e.o && !this.f32022e.p) {
                    int action = motionEvent.getAction() & 255;
                    int y = (int) motionEvent.getY();
                    if (action == 0) {
                        this.f32022e.q = y;
                        this.f32022e.A.removeMessages(1000);
                    } else if (action == 2) {
                        if (!(this.f32022e.l instanceof ViewGroup) || (childAt = ((ViewGroup) this.f32022e.l).getChildAt(0)) == null) {
                            this.f32022e.l.getLocationOnScreen(this.f32022e.s);
                            if (this.f32022e.s[1] == this.f32022e.u && y > this.f32022e.q) {
                                this.f32022e.E = IRefreshable$State.pulling_no_refresh;
                                c.a.d.m.k.b bVar = this.f32022e.B;
                                if (bVar != null) {
                                    bVar.a(IRefreshable$State.pulling_no_refresh);
                                }
                                return true;
                            }
                        } else {
                            childAt.getLocationOnScreen(this.f32022e.s);
                            if (this.f32022e.s[1] == this.f32022e.u && y > this.f32022e.q) {
                                this.f32022e.E = IRefreshable$State.pulling_no_refresh;
                                c.a.d.m.k.b bVar2 = this.f32022e.B;
                                if (bVar2 != null) {
                                    bVar2.a(IRefreshable$State.pulling_no_refresh);
                                }
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public /* synthetic */ f(RefresherView refresherView, a aVar) {
            this(refresherView);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RefresherView(Context context) {
        this(context, null, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            this.D.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) ? this.D.dispatchTouchEvent(motionEvent) : invokeL.booleanValue;
    }

    public View getEmptyView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.n : (View) invokeV.objValue;
    }

    public View getRefresherContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.l : (View) invokeV.objValue;
    }

    public View getRefresherHeader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.m : (View) invokeV.objValue;
    }

    public IRefreshable$State getState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.E : (IRefreshable$State) invokeV.objValue;
    }

    @Override // android.view.View
    public boolean isEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.o : invokeV.booleanValue;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            int i2 = this.f32006i;
            if (i2 != -1) {
                View findViewById = findViewById(i2);
                this.l = findViewById;
                if (findViewById != null) {
                    int i3 = this.f32007j;
                    if (i3 != -1) {
                        View findViewById2 = findViewById(i3);
                        this.m = findViewById2;
                        if (findViewById2 != null) {
                            int i4 = this.f32008k;
                            if (i4 != -1) {
                                View findViewById3 = findViewById(i4);
                                this.n = findViewById3;
                                if (findViewById3 == null) {
                                    throw new RuntimeException("empty view not found in the view tree by the empty view's id");
                                }
                                return;
                            }
                            throw new RuntimeException("empty view id is not set in xml, or call setEmptyView before add it to a view tree");
                        }
                        throw new RuntimeException("refresher header not found in the view tree by the header id.");
                    }
                    throw new RuntimeException("refresher head id is not set in xml, or call setRefresherHeader before add it to a view tree.");
                }
                throw new RuntimeException("refresher content not found in the view tree by the content id.");
            }
            throw new RuntimeException("refresher content id is not set in xml, or call setRefresherContent before add it to a view tree.");
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, motionEvent)) == null) ? this.D.e(motionEvent) : invokeL.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            this.D.d(z, i2, i3, i4, i5);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048586, this, i2, i3) == null) {
            this.D.b(i2, i3);
        }
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, motionEvent)) == null) ? this.D.a(motionEvent) : invokeL.booleanValue;
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            d dVar = this.C;
            if (dVar == null || dVar.getStatus() != BdAsyncTask.BdAsyncTaskStatus.RUNNING) {
                d dVar2 = new d(this);
                this.C = dVar2;
                dVar2.execute(null);
            }
        }
    }

    public void refreshShowingHeader() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || this.p) {
            return;
        }
        this.D.c(1001);
    }

    public void setEmptyView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, view) == null) {
            removeView(this.n);
            this.n = view;
            if (view != null) {
                addView(view);
            }
        }
    }

    public void setEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.o = (!z || this.l == null || this.m == null) ? false : true;
        }
    }

    public void setOnRefreshListener(c.a.d.m.k.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bVar) == null) {
            this.B = bVar;
        }
    }

    public void setRefresherContent(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, viewGroup) == null) {
            removeView(this.l);
            this.l = viewGroup;
            boolean z = false;
            if (viewGroup == null) {
                this.o = false;
                return;
            }
            addView(viewGroup);
            if (this.m != null && this.l != null) {
                z = true;
            }
            this.o = z;
        }
    }

    public void setRefresherHeader(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, view) == null) {
            removeView(this.m);
            this.m = view;
            boolean z = false;
            if (view == null) {
                this.o = false;
                return;
            }
            addView(view);
            if (this.m != null && this.l != null) {
                z = true;
            }
            this.o = z;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RefresherView(Context context, AttributeSet attributeSet) {
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
    public RefresherView(Context context, AttributeSet attributeSet, int i2) {
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
        this.o = true;
        this.s = new int[2];
        this.t = new int[2];
        this.E = IRefreshable$State.idle;
        this.z = new b(this, null);
        this.A = new c(this, null);
        float f2 = getResources().getDisplayMetrics().density;
        this.f32002e = (int) ((100.0f * f2) + 0.5f);
        this.f32003f = (int) ((500.0f * f2) + 0.5f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RefresherView);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RefresherView_threshold_height, -1);
        this.f32004g = dimensionPixelOffset;
        if (dimensionPixelOffset == -1) {
            this.f32004g = (int) ((200.0f * f2) + 0.5f);
        }
        int dimensionPixelOffset2 = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RefresherView_max_height, -1);
        this.f32005h = dimensionPixelOffset2;
        if (dimensionPixelOffset2 == -1) {
            this.f32005h = (int) ((f2 * 400.0f) + 0.5f);
        }
        String string = obtainStyledAttributes.getString(R.styleable.RefresherView_direction);
        if (string == null) {
            this.D = new f(this, null);
        } else if (string.equals("side")) {
            this.D = new e(this);
        } else if (string.equals("top")) {
            this.D = new f(this, null);
        }
        this.f32006i = obtainStyledAttributes.getResourceId(R.styleable.RefresherView_refresher_content, -1);
        this.f32007j = obtainStyledAttributes.getResourceId(R.styleable.RefresherView_refresher_head, -1);
        this.f32008k = obtainStyledAttributes.getResourceId(R.styleable.RefresherView_empty_view, -1);
    }
}

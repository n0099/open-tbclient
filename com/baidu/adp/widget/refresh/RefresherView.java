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
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.gp;
import com.repackage.jp;
import com.repackage.xn;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
/* loaded from: classes.dex */
public class RefresherView extends ViewGroup {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public IRefreshable$State A;
    public final int a;
    public final int b;
    public int c;
    public int d;
    public final int e;
    public final int f;
    public final int g;
    public View h;
    public View i;
    public View j;
    public boolean k;
    public boolean l;
    public int m;
    public int n;
    public final int[] o;
    public final int[] p;
    public int q;
    public int r;
    public int s;
    public int t;
    public int u;
    public final b v;
    public final c w;
    public jp x;
    public d y;
    public gp z;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;
        public long b;
        public int c;
        public int d;
        public int e;
        public final /* synthetic */ RefresherView f;

        public b(RefresherView refresherView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {refresherView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = refresherView;
        }

        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                this.a = uptimeMillis;
                this.b = uptimeMillis + 16;
                if (i == 1000) {
                    this.e = this.f.s - this.f.u;
                    this.d = 0;
                    this.c = Math.max(this.f.a, (this.f.s - this.f.u) * 2);
                    this.f.w.removeMessages(1000);
                    this.f.w.sendEmptyMessageAtTime(1000, this.b);
                } else if (i == 1001) {
                    this.e = this.f.c;
                    this.d = 0;
                    this.c = this.f.b;
                    this.f.w.removeMessages(1001);
                    this.f.w.sendEmptyMessageAtTime(1001, this.b);
                }
                this.f.A = IRefreshable$State.animating;
                jp jpVar = this.f.x;
                if (jpVar != null) {
                    jpVar.a(IRefreshable$State.animating);
                }
            }
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                int i = (int) (this.d + (this.c * (((float) (uptimeMillis - this.a)) / 1000.0f)));
                this.d = i;
                if (i >= this.e) {
                    RefresherView refresherView = this.f;
                    refresherView.s = refresherView.u;
                    this.f.A = IRefreshable$State.idle;
                    jp jpVar = this.f.x;
                    if (jpVar != null) {
                        jpVar.a(IRefreshable$State.idle);
                    }
                    if (this.f.u == 0 && jpVar != null) {
                        jpVar.b();
                        this.f.l = false;
                    }
                } else {
                    RefresherView refresherView2 = this.f;
                    int i2 = this.e;
                    refresherView2.s = (int) (refresherView2.u + (i2 * (1.0f - xn.a.getInterpolation(this.d / i2))));
                    this.a = uptimeMillis;
                    this.b = uptimeMillis + 16;
                    this.f.w.removeMessages(1000);
                    this.f.w.sendEmptyMessageAtTime(1000, this.b);
                }
                this.f.invalidate();
            }
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                int i = (int) (this.d + (this.c * (((float) (uptimeMillis - this.a)) / 1000.0f)));
                this.d = i;
                int i2 = this.e;
                if (i >= i2) {
                    RefresherView refresherView = this.f;
                    refresherView.s = refresherView.c;
                    this.f.A = IRefreshable$State.idle;
                    jp jpVar = this.f.x;
                    if (jpVar != null) {
                        jpVar.a(IRefreshable$State.idle);
                        this.f.W();
                    }
                } else {
                    this.f.s = xn.a(i2, i, false);
                    this.a = uptimeMillis;
                    this.b = uptimeMillis + 16;
                    this.f.w.removeMessages(1001);
                    this.f.w.sendEmptyMessageAtTime(1001, this.b);
                }
                this.f.invalidate();
            }
        }

        public /* synthetic */ b(RefresherView refresherView, a aVar) {
            this(refresherView);
        }
    }

    /* loaded from: classes.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                int i = message.what;
                if (i == 1000) {
                    this.a.v.b();
                } else if (i == 1001) {
                    this.a.v.c();
                }
            }
        }

        public /* synthetic */ c(RefresherView refresherView, a aVar) {
            this(refresherView);
        }
    }

    /* loaded from: classes.dex */
    public class d extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final jp a;
        public final /* synthetic */ RefresherView b;

        public d(RefresherView refresherView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {refresherView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = refresherView;
            this.a = refresherView.x;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Void r5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, r5) == null) {
                this.b.u = 0;
                this.b.z.c(1000);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.a == null) {
                return;
            }
            RefresherView refresherView = this.b;
            refresherView.u = refresherView.c;
            this.a.d();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, voidArr)) == null) {
                this.b.l = true;
                jp jpVar = this.a;
                if (jpVar != null) {
                    jpVar.c();
                    return null;
                }
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class e extends Handler implements gp {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;
        public long b;
        public long c;
        public float d;
        public float e;
        public int f;
        public final /* synthetic */ RefresherView g;

        public e(RefresherView refresherView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {refresherView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = refresherView;
            this.a = (int) ((refresherView.getResources().getDisplayMetrics().density * 75.0f) + 0.5d);
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0017, code lost:
            if (r0 != 3) goto L9;
         */
        @Override // com.repackage.hp
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
                        RefresherView refresherView = this.g;
                        refresherView.t = Math.max(0, Math.min((x - refresherView.n) - this.a, this.g.d * 2));
                        if (this.g.t <= this.g.c || this.g.A != IRefreshable$State.pulling_no_refresh) {
                            if (this.g.t < this.g.c && this.g.A == IRefreshable$State.pulling_refresh) {
                                this.g.A = IRefreshable$State.pulling_no_refresh;
                                jp jpVar = this.g.x;
                                if (jpVar != null) {
                                    jpVar.a(IRefreshable$State.pulling_no_refresh);
                                }
                            }
                        } else {
                            this.g.A = IRefreshable$State.pulling_refresh;
                            jp jpVar2 = this.g.x;
                            if (jpVar2 != null) {
                                jpVar2.a(IRefreshable$State.pulling_refresh);
                            }
                        }
                        this.g.invalidate();
                    }
                    return true;
                }
                if (this.g.t <= this.g.c) {
                    this.g.u = 0;
                } else {
                    this.g.W();
                }
                c(1000);
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // com.repackage.hp
        public void b(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) {
                int i3 = i & LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
                int i4 = i2 & LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
                if (this.g.h != null) {
                    RefresherView refresherView = this.g;
                    refresherView.measureChild(refresherView.h, i3 + 1073741824, i4 + 1073741824);
                }
                if (this.g.j != null) {
                    RefresherView refresherView2 = this.g;
                    refresherView2.measureChild(refresherView2.j, i3 - 2147483648, i4 - 2147483648);
                }
                if (this.g.i != null) {
                    RefresherView refresherView3 = this.g;
                    refresherView3.measureChild(refresherView3.i, Integer.MIN_VALUE + i3, 1073741824 + i4);
                }
                this.g.setMeasuredDimension(i3, i4);
            }
        }

        @Override // com.repackage.hp
        public void c(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                if (i == 1000) {
                    f();
                } else if (i != 1001) {
                } else {
                    g();
                }
            }
        }

        @Override // com.repackage.gp
        public void d(boolean z, int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
                int i5 = i3 - i;
                int i6 = i4 - i2;
                if (this.g.h != null) {
                    this.g.h.layout(0, 0, i5, i6);
                }
                if (this.g.j != null) {
                    this.g.j.layout((i5 - this.g.j.getMeasuredWidth()) / 2, (i6 - this.g.j.getMeasuredHeight()) / 2, (i5 + this.g.j.getMeasuredWidth()) / 2, (this.g.j.getMeasuredHeight() + i6) / 2);
                }
                if (this.g.i != null) {
                    this.g.i.layout(-this.g.i.getMeasuredWidth(), 0, 0, i6);
                }
                RefresherView refresherView = this.g;
                refresherView.getLocationOnScreen(refresherView.p);
                RefresherView refresherView2 = this.g;
                refresherView2.r = refresherView2.p[0];
            }
        }

        @Override // com.repackage.hp
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, motionEvent)) == null) {
                RefresherView.super.dispatchTouchEvent(motionEvent);
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // com.repackage.hp
        public void draw(Canvas canvas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, canvas) == null) {
                long drawingTime = this.g.getDrawingTime();
                if (this.g.j != null) {
                    RefresherView refresherView = this.g;
                    refresherView.drawChild(canvas, refresherView.j, drawingTime);
                }
                canvas.save();
                canvas.translate(this.g.t >> 1, 0.0f);
                RefresherView refresherView2 = this.g;
                refresherView2.drawChild(canvas, refresherView2.h, drawingTime);
                if (this.g.t > 0) {
                    RefresherView refresherView3 = this.g;
                    refresherView3.drawChild(canvas, refresherView3.i, drawingTime);
                }
                canvas.restore();
            }
        }

        @Override // com.repackage.hp
        public boolean e(MotionEvent motionEvent) {
            InterceptResult invokeL;
            View childAt;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, motionEvent)) == null) {
                if (this.g.k && !this.g.l) {
                    int action = motionEvent.getAction() & 255;
                    int x = (int) motionEvent.getX();
                    if (action == 0) {
                        this.g.n = x;
                        removeMessages(1000);
                        removeMessages(1001);
                    } else if (action == 2) {
                        if (!(this.g.h instanceof ViewGroup) || (childAt = ((ViewGroup) this.g.h).getChildAt(0)) == null) {
                            this.g.h.getLocationOnScreen(this.g.o);
                            if (this.g.o[0] == this.g.r && x > this.g.n + this.a) {
                                this.g.A = IRefreshable$State.pulling_no_refresh;
                                jp jpVar = this.g.x;
                                if (jpVar != null) {
                                    jpVar.a(IRefreshable$State.pulling_no_refresh);
                                }
                                return true;
                            }
                        } else {
                            childAt.getLocationOnScreen(this.g.o);
                            if (this.g.o[0] == this.g.r && x > this.g.n + this.a) {
                                this.g.A = IRefreshable$State.pulling_no_refresh;
                                jp jpVar2 = this.g.x;
                                if (jpVar2 != null) {
                                    jpVar2.a(IRefreshable$State.pulling_no_refresh);
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
                this.c = uptimeMillis;
                this.b = uptimeMillis + 16;
                this.e = this.g.t - this.g.u;
                this.d = 0.0f;
                this.f = Math.max(this.g.a, (this.g.t - this.g.u) * 2);
                removeMessages(1000);
                sendEmptyMessageAtTime(1000, this.b);
            }
        }

        public final void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                this.c = uptimeMillis;
                this.b = uptimeMillis + 16;
                this.e = this.g.c;
                this.d = 0.0f;
                this.f = this.g.b;
                removeMessages(1001);
                sendEmptyMessageAtTime(1001, this.b);
            }
        }

        public final void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                float f = this.d + (this.f * (((float) (uptimeMillis - this.c)) / 1000.0f));
                this.d = f;
                if (f >= this.e) {
                    RefresherView refresherView = this.g;
                    refresherView.t = refresherView.u;
                    this.g.A = IRefreshable$State.idle;
                    jp jpVar = this.g.x;
                    if (jpVar != null) {
                        jpVar.a(IRefreshable$State.idle);
                    }
                    if (this.g.u == 0 && jpVar != null) {
                        jpVar.b();
                        this.g.l = false;
                    }
                } else {
                    RefresherView refresherView2 = this.g;
                    float f2 = this.e;
                    refresherView2.t = (int) (refresherView2.u + (f2 * (1.0f - xn.a.getInterpolation(this.d / f2))));
                    this.c = uptimeMillis;
                    this.b = uptimeMillis + 16;
                    removeMessages(1000);
                    sendEmptyMessageAtTime(1000, this.b);
                }
                this.g.invalidate();
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, message) == null) {
                int i = message.what;
                if (i == 1000) {
                    h();
                } else if (i != 1001) {
                } else {
                    i();
                }
            }
        }

        public final void i() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                float f = this.d + (this.f * (((float) (uptimeMillis - this.c)) / 1000.0f));
                this.d = f;
                float f2 = this.e;
                if (f >= f2) {
                    RefresherView refresherView = this.g;
                    refresherView.t = refresherView.c;
                    this.g.A = IRefreshable$State.idle;
                    jp jpVar = this.g.x;
                    if (jpVar != null) {
                        jpVar.a(IRefreshable$State.idle);
                        this.g.W();
                    }
                } else {
                    this.g.t = xn.a(f2, f, false);
                    this.c = uptimeMillis;
                    this.b = uptimeMillis + 16;
                    removeMessages(1001);
                    sendEmptyMessageAtTime(1001, this.b);
                }
                this.g.invalidate();
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements gp {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RefresherView a;

        public f(RefresherView refresherView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {refresherView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = refresherView;
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0017, code lost:
            if (r0 != 3) goto L9;
         */
        @Override // com.repackage.hp
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
                        RefresherView refresherView = this.a;
                        refresherView.s = Math.max(0, Math.min(y - refresherView.m, this.a.d * 2));
                        if (this.a.s <= this.a.c || this.a.A != IRefreshable$State.pulling_no_refresh) {
                            if (this.a.s < this.a.c && this.a.A == IRefreshable$State.pulling_refresh) {
                                this.a.A = IRefreshable$State.pulling_no_refresh;
                                jp jpVar = this.a.x;
                                if (jpVar != null) {
                                    jpVar.a(IRefreshable$State.pulling_no_refresh);
                                }
                            }
                        } else {
                            this.a.A = IRefreshable$State.pulling_refresh;
                            jp jpVar2 = this.a.x;
                            if (jpVar2 != null) {
                                jpVar2.a(IRefreshable$State.pulling_refresh);
                            }
                        }
                        this.a.invalidate();
                    }
                    return true;
                }
                if (this.a.s <= this.a.c) {
                    this.a.u = 0;
                } else {
                    this.a.W();
                }
                c(1000);
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // com.repackage.hp
        public void b(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) {
                int i3 = i & LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
                int i4 = i2 & LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
                if (this.a.h != null) {
                    RefresherView refresherView = this.a;
                    refresherView.measureChild(refresherView.h, i3 + 1073741824, i4 + 1073741824);
                }
                if (this.a.j != null) {
                    RefresherView refresherView2 = this.a;
                    refresherView2.measureChild(refresherView2.j, i3 - 2147483648, i4 - 2147483648);
                }
                if (this.a.i != null) {
                    RefresherView refresherView3 = this.a;
                    refresherView3.measureChild(refresherView3.i, 1073741824 + i3, Integer.MIN_VALUE + i4);
                }
                this.a.setMeasuredDimension(i3, i4);
            }
        }

        @Override // com.repackage.hp
        public void c(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                this.a.v.a(i);
            }
        }

        @Override // com.repackage.gp
        public void d(boolean z, int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
                int i5 = i3 - i;
                int i6 = i4 - i2;
                if (this.a.h != null) {
                    this.a.h.layout(0, 0, i5, i6);
                }
                if (this.a.j != null) {
                    this.a.j.layout((i5 - this.a.j.getMeasuredWidth()) / 2, (i6 - this.a.j.getMeasuredHeight()) / 2, (this.a.j.getMeasuredWidth() + i5) / 2, (i6 + this.a.j.getMeasuredHeight()) / 2);
                }
                if (this.a.i != null) {
                    this.a.i.layout(0, -this.a.i.getMeasuredHeight(), i5, 0);
                }
                RefresherView refresherView = this.a;
                refresherView.getLocationOnScreen(refresherView.p);
                RefresherView refresherView2 = this.a;
                refresherView2.q = refresherView2.p[1];
            }
        }

        @Override // com.repackage.hp
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, motionEvent)) == null) {
                RefresherView.super.dispatchTouchEvent(motionEvent);
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // com.repackage.hp
        public void draw(Canvas canvas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, canvas) == null) {
                long drawingTime = this.a.getDrawingTime();
                if (this.a.j != null) {
                    RefresherView refresherView = this.a;
                    refresherView.drawChild(canvas, refresherView.j, drawingTime);
                }
                canvas.save();
                canvas.translate(0.0f, this.a.s / 2);
                RefresherView refresherView2 = this.a;
                refresherView2.drawChild(canvas, refresherView2.h, drawingTime);
                if (this.a.s > 0) {
                    RefresherView refresherView3 = this.a;
                    refresherView3.drawChild(canvas, refresherView3.i, drawingTime);
                }
                canvas.restore();
            }
        }

        @Override // com.repackage.hp
        public boolean e(MotionEvent motionEvent) {
            InterceptResult invokeL;
            View childAt;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, motionEvent)) == null) {
                if (this.a.k && !this.a.l) {
                    int action = motionEvent.getAction() & 255;
                    int y = (int) motionEvent.getY();
                    if (action == 0) {
                        this.a.m = y;
                        this.a.w.removeMessages(1000);
                    } else if (action == 2) {
                        if (!(this.a.h instanceof ViewGroup) || (childAt = ((ViewGroup) this.a.h).getChildAt(0)) == null) {
                            this.a.h.getLocationOnScreen(this.a.o);
                            if (this.a.o[1] == this.a.q && y > this.a.m) {
                                this.a.A = IRefreshable$State.pulling_no_refresh;
                                jp jpVar = this.a.x;
                                if (jpVar != null) {
                                    jpVar.a(IRefreshable$State.pulling_no_refresh);
                                }
                                return true;
                            }
                        } else {
                            childAt.getLocationOnScreen(this.a.o);
                            if (this.a.o[1] == this.a.q && y > this.a.m) {
                                this.a.A = IRefreshable$State.pulling_no_refresh;
                                jp jpVar2 = this.a.x;
                                if (jpVar2 != null) {
                                    jpVar2.a(IRefreshable$State.pulling_no_refresh);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            d dVar = this.y;
            if (dVar == null || dVar.getStatus() != BdAsyncTask.BdAsyncTaskStatus.RUNNING) {
                d dVar2 = new d(this);
                this.y = dVar2;
                dVar2.execute(null);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            this.z.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) ? this.z.dispatchTouchEvent(motionEvent) : invokeL.booleanValue;
    }

    public View getEmptyView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.j : (View) invokeV.objValue;
    }

    public View getRefresherContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.h : (View) invokeV.objValue;
    }

    public View getRefresherHeader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.i : (View) invokeV.objValue;
    }

    public IRefreshable$State getState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.A : (IRefreshable$State) invokeV.objValue;
    }

    @Override // android.view.View
    public boolean isEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.k : invokeV.booleanValue;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            int i = this.e;
            if (i != -1) {
                View findViewById = findViewById(i);
                this.h = findViewById;
                if (findViewById != null) {
                    int i2 = this.f;
                    if (i2 != -1) {
                        View findViewById2 = findViewById(i2);
                        this.i = findViewById2;
                        if (findViewById2 != null) {
                            int i3 = this.g;
                            if (i3 != -1) {
                                View findViewById3 = findViewById(i3);
                                this.j = findViewById3;
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
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, motionEvent)) == null) ? this.z.e(motionEvent) : invokeL.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            this.z.d(z, i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048587, this, i, i2) == null) {
            this.z.b(i, i2);
        }
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, motionEvent)) == null) ? this.z.a(motionEvent) : invokeL.booleanValue;
    }

    public void setEmptyView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, view2) == null) {
            removeView(this.j);
            this.j = view2;
            if (view2 != null) {
                addView(view2);
            }
        }
    }

    public void setEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.k = (!z || this.h == null || this.i == null) ? false : true;
        }
    }

    public void setOnRefreshListener(jp jpVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, jpVar) == null) {
            this.x = jpVar;
        }
    }

    public void setRefresherContent(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, viewGroup) == null) {
            removeView(this.h);
            this.h = viewGroup;
            boolean z = false;
            if (viewGroup == null) {
                this.k = false;
                return;
            }
            addView(viewGroup);
            if (this.i != null && this.h != null) {
                z = true;
            }
            this.k = z;
        }
    }

    public void setRefresherHeader(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, view2) == null) {
            removeView(this.i);
            this.i = view2;
            boolean z = false;
            if (view2 == null) {
                this.k = false;
                return;
            }
            addView(view2);
            if (this.i != null && this.h != null) {
                z = true;
            }
            this.k = z;
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
    public RefresherView(Context context, AttributeSet attributeSet, int i) {
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
        this.k = true;
        this.o = new int[2];
        this.p = new int[2];
        this.A = IRefreshable$State.idle;
        this.v = new b(this, null);
        this.w = new c(this, null);
        float f2 = getResources().getDisplayMetrics().density;
        this.a = (int) ((100.0f * f2) + 0.5f);
        this.b = (int) ((500.0f * f2) + 0.5f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f0401ef, R.attr.obfuscated_res_0x7f040218, R.attr.obfuscated_res_0x7f040469, R.attr.obfuscated_res_0x7f04052f, R.attr.obfuscated_res_0x7f040530, R.attr.obfuscated_res_0x7f04066f});
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(5, -1);
        this.c = dimensionPixelOffset;
        if (dimensionPixelOffset == -1) {
            this.c = (int) ((200.0f * f2) + 0.5f);
        }
        int dimensionPixelOffset2 = obtainStyledAttributes.getDimensionPixelOffset(2, -1);
        this.d = dimensionPixelOffset2;
        if (dimensionPixelOffset2 == -1) {
            this.d = (int) ((f2 * 400.0f) + 0.5f);
        }
        String string = obtainStyledAttributes.getString(0);
        if (string == null) {
            this.z = new f(this, null);
        } else if (string.equals("side")) {
            this.z = new e(this);
        } else if (string.equals("top")) {
            this.z = new f(this, null);
        }
        this.e = obtainStyledAttributes.getResourceId(3, -1);
        this.f = obtainStyledAttributes.getResourceId(4, -1);
        this.g = obtainStyledAttributes.getResourceId(1, -1);
    }
}

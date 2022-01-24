package c.a.s0.f1.r;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public InterfaceC0856b f12869b;

    /* renamed from: c  reason: collision with root package name */
    public VelocityTracker f12870c;

    /* renamed from: d  reason: collision with root package name */
    public float f12871d;

    /* renamed from: e  reason: collision with root package name */
    public float f12872e;

    /* renamed from: f  reason: collision with root package name */
    public long f12873f;

    /* renamed from: g  reason: collision with root package name */
    public long f12874g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f12875h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f12876i;

    /* renamed from: j  reason: collision with root package name */
    public int f12877j;
    public int k;
    public int l;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f12878e;

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
            this.f12878e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f12878e.f12876i || !this.f12878e.f12875h || this.f12878e.f12869b == null) {
                return;
            }
            this.f12878e.f12869b.onViewClick();
        }
    }

    /* renamed from: c.a.s0.f1.r.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0856b {
        void onViewClick();

        void onViewDoubleClick(float f2, float f3);

        void onViewDragToRight();
    }

    public b(View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = view;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(view.getContext());
        if (viewConfiguration != null) {
            this.l = viewConfiguration.getScaledPagingTouchSlop();
        }
        this.k = ViewConfiguration.getMaximumFlingVelocity();
        this.f12877j = ViewConfiguration.getMinimumFlingVelocity();
    }

    public boolean d(MotionEvent motionEvent) {
        InterceptResult invokeL;
        InterfaceC0856b interfaceC0856b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
            if (this.f12870c == null) {
                this.f12870c = VelocityTracker.obtain();
            }
            this.f12870c.addMovement(motionEvent);
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f12871d = motionEvent.getX();
                this.f12872e = motionEvent.getY();
                this.f12873f = System.currentTimeMillis();
                this.f12875h = true;
            } else if (action == 1) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f12873f < 100 && currentTimeMillis - this.f12874g < 500) {
                    this.f12876i = true;
                } else {
                    this.f12876i = false;
                }
                VelocityTracker velocityTracker = this.f12870c;
                velocityTracker.computeCurrentVelocity(1000, this.k);
                if (Math.abs(velocityTracker.getYVelocity()) > this.f12877j && Math.abs(this.f12872e - motionEvent.getY()) > 50.0f) {
                    this.f12876i = false;
                    this.f12875h = false;
                }
                if (this.f12876i) {
                    InterfaceC0856b interfaceC0856b2 = this.f12869b;
                    if (interfaceC0856b2 != null) {
                        interfaceC0856b2.onViewDoubleClick(motionEvent.getRawX(), motionEvent.getRawY());
                    }
                } else if (Math.abs(this.f12871d - motionEvent.getX()) > this.l && (this.f12871d - motionEvent.getX()) - 50.0f > Math.abs(this.f12872e - motionEvent.getY()) && (interfaceC0856b = this.f12869b) != null) {
                    interfaceC0856b.onViewDragToRight();
                }
                if (!this.f12876i && this.f12875h && Math.abs(this.f12871d - motionEvent.getX()) < 30.0f && Math.abs(this.f12872e - motionEvent.getY()) < 30.0f) {
                    this.a.postDelayed(new a(this), 300L);
                }
                this.f12874g = currentTimeMillis;
                e();
            } else if (action == 3) {
                e();
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void e() {
        VelocityTracker velocityTracker;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (velocityTracker = this.f12870c) == null) {
            return;
        }
        velocityTracker.clear();
        this.f12870c.recycle();
        this.f12870c = null;
    }

    public void f(InterfaceC0856b interfaceC0856b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, interfaceC0856b) == null) {
            this.f12869b = interfaceC0856b;
        }
    }
}

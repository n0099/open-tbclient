package c.a.t0.f1.r;

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
    public InterfaceC0867b f13128b;

    /* renamed from: c  reason: collision with root package name */
    public VelocityTracker f13129c;

    /* renamed from: d  reason: collision with root package name */
    public float f13130d;

    /* renamed from: e  reason: collision with root package name */
    public float f13131e;

    /* renamed from: f  reason: collision with root package name */
    public long f13132f;

    /* renamed from: g  reason: collision with root package name */
    public long f13133g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f13134h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f13135i;

    /* renamed from: j  reason: collision with root package name */
    public int f13136j;
    public int k;
    public int l;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f13137e;

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
            this.f13137e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f13137e.f13135i || !this.f13137e.f13134h || this.f13137e.f13128b == null) {
                return;
            }
            this.f13137e.f13128b.onViewClick();
        }
    }

    /* renamed from: c.a.t0.f1.r.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0867b {
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
        this.f13136j = ViewConfiguration.getMinimumFlingVelocity();
    }

    public boolean d(MotionEvent motionEvent) {
        InterceptResult invokeL;
        InterfaceC0867b interfaceC0867b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
            if (this.f13129c == null) {
                this.f13129c = VelocityTracker.obtain();
            }
            this.f13129c.addMovement(motionEvent);
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f13130d = motionEvent.getX();
                this.f13131e = motionEvent.getY();
                this.f13132f = System.currentTimeMillis();
                this.f13134h = true;
            } else if (action == 1) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f13132f < 100 && currentTimeMillis - this.f13133g < 500) {
                    this.f13135i = true;
                } else {
                    this.f13135i = false;
                }
                VelocityTracker velocityTracker = this.f13129c;
                velocityTracker.computeCurrentVelocity(1000, this.k);
                if (Math.abs(velocityTracker.getYVelocity()) > this.f13136j && Math.abs(this.f13131e - motionEvent.getY()) > 50.0f) {
                    this.f13135i = false;
                    this.f13134h = false;
                }
                if (this.f13135i) {
                    InterfaceC0867b interfaceC0867b2 = this.f13128b;
                    if (interfaceC0867b2 != null) {
                        interfaceC0867b2.onViewDoubleClick(motionEvent.getRawX(), motionEvent.getRawY());
                    }
                } else if (Math.abs(this.f13130d - motionEvent.getX()) > this.l && (this.f13130d - motionEvent.getX()) - 50.0f > Math.abs(this.f13131e - motionEvent.getY()) && (interfaceC0867b = this.f13128b) != null) {
                    interfaceC0867b.onViewDragToRight();
                }
                if (!this.f13135i && this.f13134h && Math.abs(this.f13130d - motionEvent.getX()) < 30.0f && Math.abs(this.f13131e - motionEvent.getY()) < 30.0f) {
                    this.a.postDelayed(new a(this), 300L);
                }
                this.f13133g = currentTimeMillis;
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
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (velocityTracker = this.f13129c) == null) {
            return;
        }
        velocityTracker.clear();
        this.f13129c.recycle();
        this.f13129c = null;
    }

    public void f(InterfaceC0867b interfaceC0867b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, interfaceC0867b) == null) {
            this.f13128b = interfaceC0867b;
        }
    }
}

package c.a.s0.g1.r;

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
    public InterfaceC0838b f13078b;

    /* renamed from: c  reason: collision with root package name */
    public VelocityTracker f13079c;

    /* renamed from: d  reason: collision with root package name */
    public float f13080d;

    /* renamed from: e  reason: collision with root package name */
    public float f13081e;

    /* renamed from: f  reason: collision with root package name */
    public long f13082f;

    /* renamed from: g  reason: collision with root package name */
    public long f13083g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f13084h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f13085i;

    /* renamed from: j  reason: collision with root package name */
    public int f13086j;

    /* renamed from: k  reason: collision with root package name */
    public int f13087k;
    public int l;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f13088e;

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
            this.f13088e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f13088e.f13085i || !this.f13088e.f13084h || this.f13088e.f13078b == null) {
                return;
            }
            this.f13088e.f13078b.onViewClick();
        }
    }

    /* renamed from: c.a.s0.g1.r.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0838b {
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
        this.f13087k = ViewConfiguration.getMaximumFlingVelocity();
        this.f13086j = ViewConfiguration.getMinimumFlingVelocity();
    }

    public boolean d(MotionEvent motionEvent) {
        InterceptResult invokeL;
        InterfaceC0838b interfaceC0838b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
            if (this.f13079c == null) {
                this.f13079c = VelocityTracker.obtain();
            }
            this.f13079c.addMovement(motionEvent);
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f13080d = motionEvent.getX();
                this.f13081e = motionEvent.getY();
                this.f13082f = System.currentTimeMillis();
                this.f13084h = true;
            } else if (action == 1) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f13082f < 100 && currentTimeMillis - this.f13083g < 500) {
                    this.f13085i = true;
                } else {
                    this.f13085i = false;
                }
                VelocityTracker velocityTracker = this.f13079c;
                velocityTracker.computeCurrentVelocity(1000, this.f13087k);
                if (Math.abs(velocityTracker.getYVelocity()) > this.f13086j && Math.abs(this.f13081e - motionEvent.getY()) > 50.0f) {
                    this.f13085i = false;
                    this.f13084h = false;
                }
                if (this.f13085i) {
                    InterfaceC0838b interfaceC0838b2 = this.f13078b;
                    if (interfaceC0838b2 != null) {
                        interfaceC0838b2.onViewDoubleClick(motionEvent.getRawX(), motionEvent.getRawY());
                    }
                } else if (Math.abs(this.f13080d - motionEvent.getX()) > this.l && (this.f13080d - motionEvent.getX()) - 50.0f > Math.abs(this.f13081e - motionEvent.getY()) && (interfaceC0838b = this.f13078b) != null) {
                    interfaceC0838b.onViewDragToRight();
                }
                if (!this.f13085i && this.f13084h && Math.abs(this.f13080d - motionEvent.getX()) < 30.0f && Math.abs(this.f13081e - motionEvent.getY()) < 30.0f) {
                    this.a.postDelayed(new a(this), 300L);
                }
                this.f13083g = currentTimeMillis;
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
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (velocityTracker = this.f13079c) == null) {
            return;
        }
        velocityTracker.clear();
        this.f13079c.recycle();
        this.f13079c = null;
    }

    public void f(InterfaceC0838b interfaceC0838b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, interfaceC0838b) == null) {
            this.f13078b = interfaceC0838b;
        }
    }
}

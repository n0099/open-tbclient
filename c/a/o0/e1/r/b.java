package c.a.o0.e1.r;

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
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public InterfaceC0807b f10257b;

    /* renamed from: c  reason: collision with root package name */
    public VelocityTracker f10258c;

    /* renamed from: d  reason: collision with root package name */
    public float f10259d;

    /* renamed from: e  reason: collision with root package name */
    public float f10260e;

    /* renamed from: f  reason: collision with root package name */
    public long f10261f;

    /* renamed from: g  reason: collision with root package name */
    public long f10262g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f10263h;
    public boolean i;
    public int j;
    public int k;
    public int l;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.i || !this.a.f10263h || this.a.f10257b == null) {
                return;
            }
            this.a.f10257b.onViewClick();
        }
    }

    /* renamed from: c.a.o0.e1.r.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0807b {
        void K(float f2, float f3);

        void onViewClick();

        void onViewDragToRight();
    }

    public b(View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        this.j = ViewConfiguration.getMinimumFlingVelocity();
    }

    public boolean d(MotionEvent motionEvent) {
        InterceptResult invokeL;
        InterfaceC0807b interfaceC0807b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
            if (this.f10258c == null) {
                this.f10258c = VelocityTracker.obtain();
            }
            this.f10258c.addMovement(motionEvent);
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f10259d = motionEvent.getX();
                this.f10260e = motionEvent.getY();
                this.f10261f = System.currentTimeMillis();
                this.f10263h = true;
            } else if (action == 1) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f10261f < 100 && currentTimeMillis - this.f10262g < 500) {
                    this.i = true;
                } else {
                    this.i = false;
                }
                VelocityTracker velocityTracker = this.f10258c;
                velocityTracker.computeCurrentVelocity(1000, this.k);
                if (Math.abs(velocityTracker.getYVelocity()) > this.j && Math.abs(this.f10260e - motionEvent.getY()) > 50.0f) {
                    this.i = false;
                    this.f10263h = false;
                }
                if (this.i) {
                    InterfaceC0807b interfaceC0807b2 = this.f10257b;
                    if (interfaceC0807b2 != null) {
                        interfaceC0807b2.K(motionEvent.getRawX(), motionEvent.getRawY());
                    }
                } else if (Math.abs(this.f10259d - motionEvent.getX()) > this.l && (this.f10259d - motionEvent.getX()) - 50.0f > Math.abs(this.f10260e - motionEvent.getY()) && (interfaceC0807b = this.f10257b) != null) {
                    interfaceC0807b.onViewDragToRight();
                }
                if (!this.i && this.f10263h && Math.abs(this.f10259d - motionEvent.getX()) < 30.0f && Math.abs(this.f10260e - motionEvent.getY()) < 30.0f) {
                    this.a.postDelayed(new a(this), 300L);
                }
                this.f10262g = currentTimeMillis;
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
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (velocityTracker = this.f10258c) == null) {
            return;
        }
        velocityTracker.clear();
        this.f10258c.recycle();
        this.f10258c = null;
    }

    public void f(InterfaceC0807b interfaceC0807b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, interfaceC0807b) == null) {
            this.f10257b = interfaceC0807b;
        }
    }
}

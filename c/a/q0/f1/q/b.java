package c.a.q0.f1.q;

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
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f13389a;

    /* renamed from: b  reason: collision with root package name */
    public InterfaceC0664b f13390b;

    /* renamed from: c  reason: collision with root package name */
    public VelocityTracker f13391c;

    /* renamed from: d  reason: collision with root package name */
    public float f13392d;

    /* renamed from: e  reason: collision with root package name */
    public float f13393e;

    /* renamed from: f  reason: collision with root package name */
    public long f13394f;

    /* renamed from: g  reason: collision with root package name */
    public long f13395g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f13396h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f13397i;

    /* renamed from: j  reason: collision with root package name */
    public int f13398j;
    public int k;
    public int l;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f13399e;

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
            this.f13399e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f13399e.f13397i || !this.f13399e.f13396h || this.f13399e.f13390b == null) {
                return;
            }
            this.f13399e.f13390b.onViewClick();
        }
    }

    /* renamed from: c.a.q0.f1.q.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0664b {
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
        this.f13389a = view;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(view.getContext());
        if (viewConfiguration != null) {
            this.l = viewConfiguration.getScaledPagingTouchSlop();
        }
        this.k = ViewConfiguration.getMaximumFlingVelocity();
        this.f13398j = ViewConfiguration.getMinimumFlingVelocity();
    }

    public boolean d(MotionEvent motionEvent) {
        InterceptResult invokeL;
        InterfaceC0664b interfaceC0664b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
            if (this.f13391c == null) {
                this.f13391c = VelocityTracker.obtain();
            }
            this.f13391c.addMovement(motionEvent);
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f13392d = motionEvent.getX();
                this.f13393e = motionEvent.getY();
                this.f13394f = System.currentTimeMillis();
                this.f13396h = true;
            } else if (action == 1) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f13394f < 100 && currentTimeMillis - this.f13395g < 500) {
                    this.f13397i = true;
                } else {
                    this.f13397i = false;
                }
                VelocityTracker velocityTracker = this.f13391c;
                velocityTracker.computeCurrentVelocity(1000, this.k);
                if (Math.abs(velocityTracker.getYVelocity()) > this.f13398j && Math.abs(this.f13393e - motionEvent.getY()) > 50.0f) {
                    this.f13397i = false;
                    this.f13396h = false;
                }
                if (this.f13397i) {
                    InterfaceC0664b interfaceC0664b2 = this.f13390b;
                    if (interfaceC0664b2 != null) {
                        interfaceC0664b2.onViewDoubleClick(motionEvent.getRawX(), motionEvent.getRawY());
                    }
                } else if (Math.abs(this.f13392d - motionEvent.getX()) > this.l && (this.f13392d - motionEvent.getX()) - 50.0f > Math.abs(this.f13393e - motionEvent.getY()) && (interfaceC0664b = this.f13390b) != null) {
                    interfaceC0664b.onViewDragToRight();
                }
                if (!this.f13397i && this.f13396h && Math.abs(this.f13392d - motionEvent.getX()) < 30.0f && Math.abs(this.f13393e - motionEvent.getY()) < 30.0f) {
                    this.f13389a.postDelayed(new a(this), 300L);
                }
                this.f13395g = currentTimeMillis;
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
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (velocityTracker = this.f13391c) == null) {
            return;
        }
        velocityTracker.clear();
        this.f13391c.recycle();
        this.f13391c = null;
    }

    public void f(InterfaceC0664b interfaceC0664b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, interfaceC0664b) == null) {
            this.f13390b = interfaceC0664b;
        }
    }
}

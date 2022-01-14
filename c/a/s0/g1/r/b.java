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
    public InterfaceC0848b f12758b;

    /* renamed from: c  reason: collision with root package name */
    public VelocityTracker f12759c;

    /* renamed from: d  reason: collision with root package name */
    public float f12760d;

    /* renamed from: e  reason: collision with root package name */
    public float f12761e;

    /* renamed from: f  reason: collision with root package name */
    public long f12762f;

    /* renamed from: g  reason: collision with root package name */
    public long f12763g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f12764h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f12765i;

    /* renamed from: j  reason: collision with root package name */
    public int f12766j;
    public int k;
    public int l;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f12767e;

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
            this.f12767e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f12767e.f12765i || !this.f12767e.f12764h || this.f12767e.f12758b == null) {
                return;
            }
            this.f12767e.f12758b.onViewClick();
        }
    }

    /* renamed from: c.a.s0.g1.r.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0848b {
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
        this.f12766j = ViewConfiguration.getMinimumFlingVelocity();
    }

    public boolean d(MotionEvent motionEvent) {
        InterceptResult invokeL;
        InterfaceC0848b interfaceC0848b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
            if (this.f12759c == null) {
                this.f12759c = VelocityTracker.obtain();
            }
            this.f12759c.addMovement(motionEvent);
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f12760d = motionEvent.getX();
                this.f12761e = motionEvent.getY();
                this.f12762f = System.currentTimeMillis();
                this.f12764h = true;
            } else if (action == 1) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f12762f < 100 && currentTimeMillis - this.f12763g < 500) {
                    this.f12765i = true;
                } else {
                    this.f12765i = false;
                }
                VelocityTracker velocityTracker = this.f12759c;
                velocityTracker.computeCurrentVelocity(1000, this.k);
                if (Math.abs(velocityTracker.getYVelocity()) > this.f12766j && Math.abs(this.f12761e - motionEvent.getY()) > 50.0f) {
                    this.f12765i = false;
                    this.f12764h = false;
                }
                if (this.f12765i) {
                    InterfaceC0848b interfaceC0848b2 = this.f12758b;
                    if (interfaceC0848b2 != null) {
                        interfaceC0848b2.onViewDoubleClick(motionEvent.getRawX(), motionEvent.getRawY());
                    }
                } else if (Math.abs(this.f12760d - motionEvent.getX()) > this.l && (this.f12760d - motionEvent.getX()) - 50.0f > Math.abs(this.f12761e - motionEvent.getY()) && (interfaceC0848b = this.f12758b) != null) {
                    interfaceC0848b.onViewDragToRight();
                }
                if (!this.f12765i && this.f12764h && Math.abs(this.f12760d - motionEvent.getX()) < 30.0f && Math.abs(this.f12761e - motionEvent.getY()) < 30.0f) {
                    this.a.postDelayed(new a(this), 300L);
                }
                this.f12763g = currentTimeMillis;
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
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (velocityTracker = this.f12759c) == null) {
            return;
        }
        velocityTracker.clear();
        this.f12759c.recycle();
        this.f12759c = null;
    }

    public void f(InterfaceC0848b interfaceC0848b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, interfaceC0848b) == null) {
            this.f12758b = interfaceC0848b;
        }
    }
}

package c.a.p0.d1.q;

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
    public View f13339a;

    /* renamed from: b  reason: collision with root package name */
    public InterfaceC0663b f13340b;

    /* renamed from: c  reason: collision with root package name */
    public VelocityTracker f13341c;

    /* renamed from: d  reason: collision with root package name */
    public float f13342d;

    /* renamed from: e  reason: collision with root package name */
    public float f13343e;

    /* renamed from: f  reason: collision with root package name */
    public long f13344f;

    /* renamed from: g  reason: collision with root package name */
    public long f13345g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f13346h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f13347i;

    /* renamed from: j  reason: collision with root package name */
    public int f13348j;
    public int k;
    public int l;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f13349e;

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
            this.f13349e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f13349e.f13347i || !this.f13349e.f13346h || this.f13349e.f13340b == null) {
                return;
            }
            this.f13349e.f13340b.onViewClick();
        }
    }

    /* renamed from: c.a.p0.d1.q.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0663b {
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
        this.f13339a = view;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(view.getContext());
        if (viewConfiguration != null) {
            this.l = viewConfiguration.getScaledPagingTouchSlop();
        }
        this.k = ViewConfiguration.getMaximumFlingVelocity();
        this.f13348j = ViewConfiguration.getMinimumFlingVelocity();
    }

    public boolean d(MotionEvent motionEvent) {
        InterceptResult invokeL;
        InterfaceC0663b interfaceC0663b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
            if (this.f13341c == null) {
                this.f13341c = VelocityTracker.obtain();
            }
            this.f13341c.addMovement(motionEvent);
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f13342d = motionEvent.getX();
                this.f13343e = motionEvent.getY();
                this.f13344f = System.currentTimeMillis();
                this.f13346h = true;
            } else if (action == 1) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f13344f < 100 && currentTimeMillis - this.f13345g < 500) {
                    this.f13347i = true;
                } else {
                    this.f13347i = false;
                }
                VelocityTracker velocityTracker = this.f13341c;
                velocityTracker.computeCurrentVelocity(1000, this.k);
                if (Math.abs(velocityTracker.getYVelocity()) > this.f13348j && Math.abs(this.f13343e - motionEvent.getY()) > 50.0f) {
                    this.f13347i = false;
                    this.f13346h = false;
                }
                if (this.f13347i) {
                    InterfaceC0663b interfaceC0663b2 = this.f13340b;
                    if (interfaceC0663b2 != null) {
                        interfaceC0663b2.onViewDoubleClick(motionEvent.getRawX(), motionEvent.getRawY());
                    }
                } else if (Math.abs(this.f13342d - motionEvent.getX()) > this.l && (this.f13342d - motionEvent.getX()) - 50.0f > Math.abs(this.f13343e - motionEvent.getY()) && (interfaceC0663b = this.f13340b) != null) {
                    interfaceC0663b.onViewDragToRight();
                }
                if (!this.f13347i && this.f13346h && Math.abs(this.f13342d - motionEvent.getX()) < 30.0f && Math.abs(this.f13343e - motionEvent.getY()) < 30.0f) {
                    this.f13339a.postDelayed(new a(this), 300L);
                }
                this.f13345g = currentTimeMillis;
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
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (velocityTracker = this.f13341c) == null) {
            return;
        }
        velocityTracker.clear();
        this.f13341c.recycle();
        this.f13341c = null;
    }

    public void f(InterfaceC0663b interfaceC0663b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, interfaceC0663b) == null) {
            this.f13340b = interfaceC0663b;
        }
    }
}

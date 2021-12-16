package c.a.r0.f1.r;

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
    public InterfaceC0814b f12585b;

    /* renamed from: c  reason: collision with root package name */
    public VelocityTracker f12586c;

    /* renamed from: d  reason: collision with root package name */
    public float f12587d;

    /* renamed from: e  reason: collision with root package name */
    public float f12588e;

    /* renamed from: f  reason: collision with root package name */
    public long f12589f;

    /* renamed from: g  reason: collision with root package name */
    public long f12590g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f12591h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f12592i;

    /* renamed from: j  reason: collision with root package name */
    public int f12593j;

    /* renamed from: k  reason: collision with root package name */
    public int f12594k;
    public int l;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f12595e;

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
            this.f12595e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f12595e.f12592i || !this.f12595e.f12591h || this.f12595e.f12585b == null) {
                return;
            }
            this.f12595e.f12585b.onViewClick();
        }
    }

    /* renamed from: c.a.r0.f1.r.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0814b {
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
        this.f12594k = ViewConfiguration.getMaximumFlingVelocity();
        this.f12593j = ViewConfiguration.getMinimumFlingVelocity();
    }

    public boolean d(MotionEvent motionEvent) {
        InterceptResult invokeL;
        InterfaceC0814b interfaceC0814b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
            if (this.f12586c == null) {
                this.f12586c = VelocityTracker.obtain();
            }
            this.f12586c.addMovement(motionEvent);
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f12587d = motionEvent.getX();
                this.f12588e = motionEvent.getY();
                this.f12589f = System.currentTimeMillis();
                this.f12591h = true;
            } else if (action == 1) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f12589f < 100 && currentTimeMillis - this.f12590g < 500) {
                    this.f12592i = true;
                } else {
                    this.f12592i = false;
                }
                VelocityTracker velocityTracker = this.f12586c;
                velocityTracker.computeCurrentVelocity(1000, this.f12594k);
                if (Math.abs(velocityTracker.getYVelocity()) > this.f12593j && Math.abs(this.f12588e - motionEvent.getY()) > 50.0f) {
                    this.f12592i = false;
                    this.f12591h = false;
                }
                if (this.f12592i) {
                    InterfaceC0814b interfaceC0814b2 = this.f12585b;
                    if (interfaceC0814b2 != null) {
                        interfaceC0814b2.onViewDoubleClick(motionEvent.getRawX(), motionEvent.getRawY());
                    }
                } else if (Math.abs(this.f12587d - motionEvent.getX()) > this.l && (this.f12587d - motionEvent.getX()) - 50.0f > Math.abs(this.f12588e - motionEvent.getY()) && (interfaceC0814b = this.f12585b) != null) {
                    interfaceC0814b.onViewDragToRight();
                }
                if (!this.f12592i && this.f12591h && Math.abs(this.f12587d - motionEvent.getX()) < 30.0f && Math.abs(this.f12588e - motionEvent.getY()) < 30.0f) {
                    this.a.postDelayed(new a(this), 300L);
                }
                this.f12590g = currentTimeMillis;
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
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (velocityTracker = this.f12586c) == null) {
            return;
        }
        velocityTracker.clear();
        this.f12586c.recycle();
        this.f12586c = null;
    }

    public void f(InterfaceC0814b interfaceC0814b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, interfaceC0814b) == null) {
            this.f12585b = interfaceC0814b;
        }
    }
}

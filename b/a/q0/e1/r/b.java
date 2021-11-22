package b.a.q0.e1.r;

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
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f13250a;

    /* renamed from: b  reason: collision with root package name */
    public InterfaceC0693b f13251b;

    /* renamed from: c  reason: collision with root package name */
    public VelocityTracker f13252c;

    /* renamed from: d  reason: collision with root package name */
    public float f13253d;

    /* renamed from: e  reason: collision with root package name */
    public float f13254e;

    /* renamed from: f  reason: collision with root package name */
    public long f13255f;

    /* renamed from: g  reason: collision with root package name */
    public long f13256g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f13257h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f13258i;
    public int j;
    public int k;
    public int l;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f13259e;

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
            this.f13259e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f13259e.f13258i || !this.f13259e.f13257h || this.f13259e.f13251b == null) {
                return;
            }
            this.f13259e.f13251b.onViewClick();
        }
    }

    /* renamed from: b.a.q0.e1.r.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0693b {
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
        this.f13250a = view;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(view.getContext());
        if (viewConfiguration != null) {
            this.l = viewConfiguration.getScaledPagingTouchSlop();
        }
        this.k = ViewConfiguration.getMaximumFlingVelocity();
        this.j = ViewConfiguration.getMinimumFlingVelocity();
    }

    public boolean d(MotionEvent motionEvent) {
        InterceptResult invokeL;
        InterfaceC0693b interfaceC0693b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
            if (this.f13252c == null) {
                this.f13252c = VelocityTracker.obtain();
            }
            this.f13252c.addMovement(motionEvent);
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f13253d = motionEvent.getX();
                this.f13254e = motionEvent.getY();
                this.f13255f = System.currentTimeMillis();
                this.f13257h = true;
            } else if (action == 1) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f13255f < 100 && currentTimeMillis - this.f13256g < 500) {
                    this.f13258i = true;
                } else {
                    this.f13258i = false;
                }
                VelocityTracker velocityTracker = this.f13252c;
                velocityTracker.computeCurrentVelocity(1000, this.k);
                if (Math.abs(velocityTracker.getYVelocity()) > this.j && Math.abs(this.f13254e - motionEvent.getY()) > 50.0f) {
                    this.f13258i = false;
                    this.f13257h = false;
                }
                if (this.f13258i) {
                    InterfaceC0693b interfaceC0693b2 = this.f13251b;
                    if (interfaceC0693b2 != null) {
                        interfaceC0693b2.onViewDoubleClick(motionEvent.getRawX(), motionEvent.getRawY());
                    }
                } else if (Math.abs(this.f13253d - motionEvent.getX()) > this.l && (this.f13253d - motionEvent.getX()) - 50.0f > Math.abs(this.f13254e - motionEvent.getY()) && (interfaceC0693b = this.f13251b) != null) {
                    interfaceC0693b.onViewDragToRight();
                }
                if (!this.f13258i && this.f13257h && Math.abs(this.f13253d - motionEvent.getX()) < 30.0f && Math.abs(this.f13254e - motionEvent.getY()) < 30.0f) {
                    this.f13250a.postDelayed(new a(this), 300L);
                }
                this.f13256g = currentTimeMillis;
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
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (velocityTracker = this.f13252c) == null) {
            return;
        }
        velocityTracker.clear();
        this.f13252c.recycle();
        this.f13252c = null;
    }

    public void f(InterfaceC0693b interfaceC0693b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, interfaceC0693b) == null) {
            this.f13251b = interfaceC0693b;
        }
    }
}

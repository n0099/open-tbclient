package c.a.q0.e1.r;

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
    public InterfaceC0839b f12538b;

    /* renamed from: c  reason: collision with root package name */
    public VelocityTracker f12539c;

    /* renamed from: d  reason: collision with root package name */
    public float f12540d;

    /* renamed from: e  reason: collision with root package name */
    public float f12541e;

    /* renamed from: f  reason: collision with root package name */
    public long f12542f;

    /* renamed from: g  reason: collision with root package name */
    public long f12543g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f12544h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f12545i;

    /* renamed from: j  reason: collision with root package name */
    public int f12546j;
    public int k;
    public int l;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f12547e;

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
            this.f12547e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f12547e.f12545i || !this.f12547e.f12544h || this.f12547e.f12538b == null) {
                return;
            }
            this.f12547e.f12538b.onViewClick();
        }
    }

    /* renamed from: c.a.q0.e1.r.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0839b {
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
        this.f12546j = ViewConfiguration.getMinimumFlingVelocity();
    }

    public boolean d(MotionEvent motionEvent) {
        InterceptResult invokeL;
        InterfaceC0839b interfaceC0839b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
            if (this.f12539c == null) {
                this.f12539c = VelocityTracker.obtain();
            }
            this.f12539c.addMovement(motionEvent);
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f12540d = motionEvent.getX();
                this.f12541e = motionEvent.getY();
                this.f12542f = System.currentTimeMillis();
                this.f12544h = true;
            } else if (action == 1) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f12542f < 100 && currentTimeMillis - this.f12543g < 500) {
                    this.f12545i = true;
                } else {
                    this.f12545i = false;
                }
                VelocityTracker velocityTracker = this.f12539c;
                velocityTracker.computeCurrentVelocity(1000, this.k);
                if (Math.abs(velocityTracker.getYVelocity()) > this.f12546j && Math.abs(this.f12541e - motionEvent.getY()) > 50.0f) {
                    this.f12545i = false;
                    this.f12544h = false;
                }
                if (this.f12545i) {
                    InterfaceC0839b interfaceC0839b2 = this.f12538b;
                    if (interfaceC0839b2 != null) {
                        interfaceC0839b2.onViewDoubleClick(motionEvent.getRawX(), motionEvent.getRawY());
                    }
                } else if (Math.abs(this.f12540d - motionEvent.getX()) > this.l && (this.f12540d - motionEvent.getX()) - 50.0f > Math.abs(this.f12541e - motionEvent.getY()) && (interfaceC0839b = this.f12538b) != null) {
                    interfaceC0839b.onViewDragToRight();
                }
                if (!this.f12545i && this.f12544h && Math.abs(this.f12540d - motionEvent.getX()) < 30.0f && Math.abs(this.f12541e - motionEvent.getY()) < 30.0f) {
                    this.a.postDelayed(new a(this), 300L);
                }
                this.f12543g = currentTimeMillis;
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
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (velocityTracker = this.f12539c) == null) {
            return;
        }
        velocityTracker.clear();
        this.f12539c.recycle();
        this.f12539c = null;
    }

    public void f(InterfaceC0839b interfaceC0839b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, interfaceC0839b) == null) {
            this.f12538b = interfaceC0839b;
        }
    }
}

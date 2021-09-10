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
    public View f13372a;

    /* renamed from: b  reason: collision with root package name */
    public InterfaceC0664b f13373b;

    /* renamed from: c  reason: collision with root package name */
    public VelocityTracker f13374c;

    /* renamed from: d  reason: collision with root package name */
    public float f13375d;

    /* renamed from: e  reason: collision with root package name */
    public float f13376e;

    /* renamed from: f  reason: collision with root package name */
    public long f13377f;

    /* renamed from: g  reason: collision with root package name */
    public long f13378g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f13379h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f13380i;

    /* renamed from: j  reason: collision with root package name */
    public int f13381j;
    public int k;
    public int l;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f13382e;

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
            this.f13382e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f13382e.f13380i || !this.f13382e.f13379h || this.f13382e.f13373b == null) {
                return;
            }
            this.f13382e.f13373b.onViewClick();
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
        this.f13372a = view;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(view.getContext());
        if (viewConfiguration != null) {
            this.l = viewConfiguration.getScaledPagingTouchSlop();
        }
        this.k = ViewConfiguration.getMaximumFlingVelocity();
        this.f13381j = ViewConfiguration.getMinimumFlingVelocity();
    }

    public boolean d(MotionEvent motionEvent) {
        InterceptResult invokeL;
        InterfaceC0664b interfaceC0664b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
            if (this.f13374c == null) {
                this.f13374c = VelocityTracker.obtain();
            }
            this.f13374c.addMovement(motionEvent);
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f13375d = motionEvent.getX();
                this.f13376e = motionEvent.getY();
                this.f13377f = System.currentTimeMillis();
                this.f13379h = true;
            } else if (action == 1) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f13377f < 100 && currentTimeMillis - this.f13378g < 500) {
                    this.f13380i = true;
                } else {
                    this.f13380i = false;
                }
                VelocityTracker velocityTracker = this.f13374c;
                velocityTracker.computeCurrentVelocity(1000, this.k);
                if (Math.abs(velocityTracker.getYVelocity()) > this.f13381j && Math.abs(this.f13376e - motionEvent.getY()) > 50.0f) {
                    this.f13380i = false;
                    this.f13379h = false;
                }
                if (this.f13380i) {
                    InterfaceC0664b interfaceC0664b2 = this.f13373b;
                    if (interfaceC0664b2 != null) {
                        interfaceC0664b2.onViewDoubleClick(motionEvent.getRawX(), motionEvent.getRawY());
                    }
                } else if (Math.abs(this.f13375d - motionEvent.getX()) > this.l && (this.f13375d - motionEvent.getX()) - 50.0f > Math.abs(this.f13376e - motionEvent.getY()) && (interfaceC0664b = this.f13373b) != null) {
                    interfaceC0664b.onViewDragToRight();
                }
                if (!this.f13380i && this.f13379h && Math.abs(this.f13375d - motionEvent.getX()) < 30.0f && Math.abs(this.f13376e - motionEvent.getY()) < 30.0f) {
                    this.f13372a.postDelayed(new a(this), 300L);
                }
                this.f13378g = currentTimeMillis;
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
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (velocityTracker = this.f13374c) == null) {
            return;
        }
        velocityTracker.clear();
        this.f13374c.recycle();
        this.f13374c = null;
    }

    public void f(InterfaceC0664b interfaceC0664b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, interfaceC0664b) == null) {
            this.f13373b = interfaceC0664b;
        }
    }
}

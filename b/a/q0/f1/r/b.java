package b.a.q0.f1.r;

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
    public View f12542a;

    /* renamed from: b  reason: collision with root package name */
    public InterfaceC0660b f12543b;

    /* renamed from: c  reason: collision with root package name */
    public VelocityTracker f12544c;

    /* renamed from: d  reason: collision with root package name */
    public float f12545d;

    /* renamed from: e  reason: collision with root package name */
    public float f12546e;

    /* renamed from: f  reason: collision with root package name */
    public long f12547f;

    /* renamed from: g  reason: collision with root package name */
    public long f12548g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f12549h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f12550i;
    public int j;
    public int k;
    public int l;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f12551e;

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
            this.f12551e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f12551e.f12550i || !this.f12551e.f12549h || this.f12551e.f12543b == null) {
                return;
            }
            this.f12551e.f12543b.onViewClick();
        }
    }

    /* renamed from: b.a.q0.f1.r.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0660b {
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
        this.f12542a = view;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(view.getContext());
        if (viewConfiguration != null) {
            this.l = viewConfiguration.getScaledPagingTouchSlop();
        }
        this.k = ViewConfiguration.getMaximumFlingVelocity();
        this.j = ViewConfiguration.getMinimumFlingVelocity();
    }

    public boolean d(MotionEvent motionEvent) {
        InterceptResult invokeL;
        InterfaceC0660b interfaceC0660b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
            if (this.f12544c == null) {
                this.f12544c = VelocityTracker.obtain();
            }
            this.f12544c.addMovement(motionEvent);
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f12545d = motionEvent.getX();
                this.f12546e = motionEvent.getY();
                this.f12547f = System.currentTimeMillis();
                this.f12549h = true;
            } else if (action == 1) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f12547f < 100 && currentTimeMillis - this.f12548g < 500) {
                    this.f12550i = true;
                } else {
                    this.f12550i = false;
                }
                VelocityTracker velocityTracker = this.f12544c;
                velocityTracker.computeCurrentVelocity(1000, this.k);
                if (Math.abs(velocityTracker.getYVelocity()) > this.j && Math.abs(this.f12546e - motionEvent.getY()) > 50.0f) {
                    this.f12550i = false;
                    this.f12549h = false;
                }
                if (this.f12550i) {
                    InterfaceC0660b interfaceC0660b2 = this.f12543b;
                    if (interfaceC0660b2 != null) {
                        interfaceC0660b2.onViewDoubleClick(motionEvent.getRawX(), motionEvent.getRawY());
                    }
                } else if (Math.abs(this.f12545d - motionEvent.getX()) > this.l && (this.f12545d - motionEvent.getX()) - 50.0f > Math.abs(this.f12546e - motionEvent.getY()) && (interfaceC0660b = this.f12543b) != null) {
                    interfaceC0660b.onViewDragToRight();
                }
                if (!this.f12550i && this.f12549h && Math.abs(this.f12545d - motionEvent.getX()) < 30.0f && Math.abs(this.f12546e - motionEvent.getY()) < 30.0f) {
                    this.f12542a.postDelayed(new a(this), 300L);
                }
                this.f12548g = currentTimeMillis;
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
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (velocityTracker = this.f12544c) == null) {
            return;
        }
        velocityTracker.clear();
        this.f12544c.recycle();
        this.f12544c = null;
    }

    public void f(InterfaceC0660b interfaceC0660b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, interfaceC0660b) == null) {
            this.f12543b = interfaceC0660b;
        }
    }
}

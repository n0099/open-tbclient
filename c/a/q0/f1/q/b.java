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
    public View f13397a;

    /* renamed from: b  reason: collision with root package name */
    public InterfaceC0665b f13398b;

    /* renamed from: c  reason: collision with root package name */
    public VelocityTracker f13399c;

    /* renamed from: d  reason: collision with root package name */
    public float f13400d;

    /* renamed from: e  reason: collision with root package name */
    public float f13401e;

    /* renamed from: f  reason: collision with root package name */
    public long f13402f;

    /* renamed from: g  reason: collision with root package name */
    public long f13403g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f13404h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f13405i;

    /* renamed from: j  reason: collision with root package name */
    public int f13406j;
    public int k;
    public int l;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f13407e;

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
            this.f13407e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f13407e.f13405i || !this.f13407e.f13404h || this.f13407e.f13398b == null) {
                return;
            }
            this.f13407e.f13398b.onViewClick();
        }
    }

    /* renamed from: c.a.q0.f1.q.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0665b {
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
        this.f13397a = view;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(view.getContext());
        if (viewConfiguration != null) {
            this.l = viewConfiguration.getScaledPagingTouchSlop();
        }
        this.k = ViewConfiguration.getMaximumFlingVelocity();
        this.f13406j = ViewConfiguration.getMinimumFlingVelocity();
    }

    public boolean d(MotionEvent motionEvent) {
        InterceptResult invokeL;
        InterfaceC0665b interfaceC0665b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
            if (this.f13399c == null) {
                this.f13399c = VelocityTracker.obtain();
            }
            this.f13399c.addMovement(motionEvent);
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f13400d = motionEvent.getX();
                this.f13401e = motionEvent.getY();
                this.f13402f = System.currentTimeMillis();
                this.f13404h = true;
            } else if (action == 1) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f13402f < 100 && currentTimeMillis - this.f13403g < 500) {
                    this.f13405i = true;
                } else {
                    this.f13405i = false;
                }
                VelocityTracker velocityTracker = this.f13399c;
                velocityTracker.computeCurrentVelocity(1000, this.k);
                if (Math.abs(velocityTracker.getYVelocity()) > this.f13406j && Math.abs(this.f13401e - motionEvent.getY()) > 50.0f) {
                    this.f13405i = false;
                    this.f13404h = false;
                }
                if (this.f13405i) {
                    InterfaceC0665b interfaceC0665b2 = this.f13398b;
                    if (interfaceC0665b2 != null) {
                        interfaceC0665b2.onViewDoubleClick(motionEvent.getRawX(), motionEvent.getRawY());
                    }
                } else if (Math.abs(this.f13400d - motionEvent.getX()) > this.l && (this.f13400d - motionEvent.getX()) - 50.0f > Math.abs(this.f13401e - motionEvent.getY()) && (interfaceC0665b = this.f13398b) != null) {
                    interfaceC0665b.onViewDragToRight();
                }
                if (!this.f13405i && this.f13404h && Math.abs(this.f13400d - motionEvent.getX()) < 30.0f && Math.abs(this.f13401e - motionEvent.getY()) < 30.0f) {
                    this.f13397a.postDelayed(new a(this), 300L);
                }
                this.f13403g = currentTimeMillis;
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
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (velocityTracker = this.f13399c) == null) {
            return;
        }
        velocityTracker.clear();
        this.f13399c.recycle();
        this.f13399c = null;
    }

    public void f(InterfaceC0665b interfaceC0665b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, interfaceC0665b) == null) {
            this.f13398b = interfaceC0665b;
        }
    }
}

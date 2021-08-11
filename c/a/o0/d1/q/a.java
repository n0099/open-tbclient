package c.a.o0.d1.q;

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
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f13048a;

    /* renamed from: b  reason: collision with root package name */
    public b f13049b;

    /* renamed from: c  reason: collision with root package name */
    public VelocityTracker f13050c;

    /* renamed from: d  reason: collision with root package name */
    public float f13051d;

    /* renamed from: e  reason: collision with root package name */
    public float f13052e;

    /* renamed from: f  reason: collision with root package name */
    public long f13053f;

    /* renamed from: g  reason: collision with root package name */
    public long f13054g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f13055h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f13056i;

    /* renamed from: j  reason: collision with root package name */
    public int f13057j;
    public int k;
    public int l;

    /* renamed from: c.a.o0.d1.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0653a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f13058e;

        public RunnableC0653a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13058e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f13058e.f13056i || !this.f13058e.f13055h || this.f13058e.f13049b == null) {
                return;
            }
            this.f13058e.f13049b.onViewClick();
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void onViewClick();

        void onViewDoubleClick(float f2, float f3);

        void onViewDragToRight();
    }

    public a(View view) {
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
        this.f13048a = view;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(view.getContext());
        if (viewConfiguration != null) {
            this.l = viewConfiguration.getScaledPagingTouchSlop();
        }
        this.k = ViewConfiguration.getMaximumFlingVelocity();
        this.f13057j = ViewConfiguration.getMinimumFlingVelocity();
    }

    public boolean d(MotionEvent motionEvent) {
        InterceptResult invokeL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
            if (this.f13050c == null) {
                this.f13050c = VelocityTracker.obtain();
            }
            this.f13050c.addMovement(motionEvent);
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f13051d = motionEvent.getX();
                this.f13052e = motionEvent.getY();
                this.f13053f = System.currentTimeMillis();
                this.f13055h = true;
            } else if (action == 1) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f13053f < 100 && currentTimeMillis - this.f13054g < 500) {
                    this.f13056i = true;
                } else {
                    this.f13056i = false;
                }
                VelocityTracker velocityTracker = this.f13050c;
                velocityTracker.computeCurrentVelocity(1000, this.k);
                if (Math.abs(velocityTracker.getYVelocity()) > this.f13057j && Math.abs(this.f13052e - motionEvent.getY()) > 50.0f) {
                    this.f13056i = false;
                    this.f13055h = false;
                }
                if (this.f13056i) {
                    b bVar2 = this.f13049b;
                    if (bVar2 != null) {
                        bVar2.onViewDoubleClick(motionEvent.getRawX(), motionEvent.getRawY());
                    }
                } else if (Math.abs(this.f13051d - motionEvent.getX()) > this.l && (this.f13051d - motionEvent.getX()) - 50.0f > Math.abs(this.f13052e - motionEvent.getY()) && (bVar = this.f13049b) != null) {
                    bVar.onViewDragToRight();
                }
                if (!this.f13056i && this.f13055h && Math.abs(this.f13051d - motionEvent.getX()) < 30.0f && Math.abs(this.f13052e - motionEvent.getY()) < 30.0f) {
                    this.f13048a.postDelayed(new RunnableC0653a(this), 300L);
                }
                this.f13054g = currentTimeMillis;
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
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (velocityTracker = this.f13050c) == null) {
            return;
        }
        velocityTracker.clear();
        this.f13050c.recycle();
        this.f13050c = null;
    }

    public void f(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f13049b = bVar;
        }
    }
}

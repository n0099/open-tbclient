package c.a.q0.f1.r;

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
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public InterfaceC0778b f12258b;

    /* renamed from: c  reason: collision with root package name */
    public VelocityTracker f12259c;

    /* renamed from: d  reason: collision with root package name */
    public float f12260d;

    /* renamed from: e  reason: collision with root package name */
    public float f12261e;

    /* renamed from: f  reason: collision with root package name */
    public long f12262f;

    /* renamed from: g  reason: collision with root package name */
    public long f12263g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f12264h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f12265i;

    /* renamed from: j  reason: collision with root package name */
    public int f12266j;

    /* renamed from: k  reason: collision with root package name */
    public int f12267k;
    public int l;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f12268e;

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
            this.f12268e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f12268e.f12265i || !this.f12268e.f12264h || this.f12268e.f12258b == null) {
                return;
            }
            this.f12268e.f12258b.onViewClick();
        }
    }

    /* renamed from: c.a.q0.f1.r.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0778b {
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
        this.f12267k = ViewConfiguration.getMaximumFlingVelocity();
        this.f12266j = ViewConfiguration.getMinimumFlingVelocity();
    }

    public boolean d(MotionEvent motionEvent) {
        InterceptResult invokeL;
        InterfaceC0778b interfaceC0778b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
            if (this.f12259c == null) {
                this.f12259c = VelocityTracker.obtain();
            }
            this.f12259c.addMovement(motionEvent);
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f12260d = motionEvent.getX();
                this.f12261e = motionEvent.getY();
                this.f12262f = System.currentTimeMillis();
                this.f12264h = true;
            } else if (action == 1) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f12262f < 100 && currentTimeMillis - this.f12263g < 500) {
                    this.f12265i = true;
                } else {
                    this.f12265i = false;
                }
                VelocityTracker velocityTracker = this.f12259c;
                velocityTracker.computeCurrentVelocity(1000, this.f12267k);
                if (Math.abs(velocityTracker.getYVelocity()) > this.f12266j && Math.abs(this.f12261e - motionEvent.getY()) > 50.0f) {
                    this.f12265i = false;
                    this.f12264h = false;
                }
                if (this.f12265i) {
                    InterfaceC0778b interfaceC0778b2 = this.f12258b;
                    if (interfaceC0778b2 != null) {
                        interfaceC0778b2.onViewDoubleClick(motionEvent.getRawX(), motionEvent.getRawY());
                    }
                } else if (Math.abs(this.f12260d - motionEvent.getX()) > this.l && (this.f12260d - motionEvent.getX()) - 50.0f > Math.abs(this.f12261e - motionEvent.getY()) && (interfaceC0778b = this.f12258b) != null) {
                    interfaceC0778b.onViewDragToRight();
                }
                if (!this.f12265i && this.f12264h && Math.abs(this.f12260d - motionEvent.getX()) < 30.0f && Math.abs(this.f12261e - motionEvent.getY()) < 30.0f) {
                    this.a.postDelayed(new a(this), 300L);
                }
                this.f12263g = currentTimeMillis;
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
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (velocityTracker = this.f12259c) == null) {
            return;
        }
        velocityTracker.clear();
        this.f12259c.recycle();
        this.f12259c = null;
    }

    public void f(InterfaceC0778b interfaceC0778b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, interfaceC0778b) == null) {
            this.f12258b = interfaceC0778b;
        }
    }
}

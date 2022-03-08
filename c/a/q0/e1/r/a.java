package c.a.q0.e1.r;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewConfigurationCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f12529b;

    /* renamed from: c  reason: collision with root package name */
    public int f12530c;

    /* renamed from: d  reason: collision with root package name */
    public float f12531d;

    /* renamed from: e  reason: collision with root package name */
    public float f12532e;

    /* renamed from: f  reason: collision with root package name */
    public float f12533f;

    /* renamed from: g  reason: collision with root package name */
    public int f12534g;

    /* renamed from: h  reason: collision with root package name */
    public VelocityTracker f12535h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    public ViewGroup f12536i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f12537j;

    public a(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {viewGroup};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f12534g = -1;
        this.f12537j = true;
        this.f12536i = viewGroup;
        this.f12530c = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(viewGroup.getContext()));
    }

    @SuppressLint({"LongLogTag"})
    public boolean a(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
            int action = motionEvent.getAction() & 255;
            if (action != 3 && action != 1) {
                if (action != 0) {
                    if (this.a) {
                        return true;
                    }
                    if (this.f12529b) {
                        return false;
                    }
                }
                if (action == 0) {
                    this.f12532e = motionEvent.getX();
                    float y = motionEvent.getY();
                    this.f12533f = y;
                    this.f12531d = y;
                    this.f12534g = MotionEventCompat.getPointerId(motionEvent, 0);
                    this.f12529b = false;
                    this.a = false;
                } else if (action == 2) {
                    int i2 = this.f12534g;
                    if (i2 != -1) {
                        int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i2);
                        if (findPointerIndex >= 0 && findPointerIndex < motionEvent.getPointerCount()) {
                            float y2 = MotionEventCompat.getY(motionEvent, findPointerIndex) - this.f12531d;
                            float abs = Math.abs(y2);
                            float abs2 = Math.abs(MotionEventCompat.getX(motionEvent, findPointerIndex) - this.f12532e);
                            float f2 = this.f12537j ? 0.5f : 3.0f;
                            if (abs > this.f12530c && abs * f2 > abs2) {
                                this.a = true;
                                c(true);
                                this.f12531d = y2 > 0.0f ? this.f12533f + this.f12530c : this.f12533f - this.f12530c;
                            } else if (abs2 > this.f12530c) {
                                this.f12529b = true;
                            }
                        } else {
                            this.a = false;
                        }
                    }
                } else if (action == 6) {
                    b(motionEvent);
                }
                if (this.f12535h == null) {
                    this.f12535h = VelocityTracker.obtain();
                }
                this.f12535h.addMovement(motionEvent);
                return this.a;
            }
            this.a = false;
            this.f12529b = false;
            this.f12534g = -1;
            VelocityTracker velocityTracker = this.f12535h;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f12535h = null;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void b(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent) == null) {
            int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
            if (MotionEventCompat.getPointerId(motionEvent, actionIndex) == this.f12534g) {
                int i2 = actionIndex == 0 ? 1 : 0;
                this.f12531d = MotionEventCompat.getY(motionEvent, i2);
                this.f12534g = MotionEventCompat.getPointerId(motionEvent, i2);
                VelocityTracker velocityTracker = this.f12535h;
                if (velocityTracker != null) {
                    velocityTracker.clear();
                }
            }
        }
    }

    public final void c(boolean z) {
        ViewParent parent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || (parent = this.f12536i.getParent()) == null) {
            return;
        }
        parent.requestDisallowInterceptTouchEvent(z);
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f12537j = z;
        }
    }
}

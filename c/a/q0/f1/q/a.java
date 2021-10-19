package c.a.q0.f1.q;

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
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f13387a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f13388b;

    /* renamed from: c  reason: collision with root package name */
    public int f13389c;

    /* renamed from: d  reason: collision with root package name */
    public float f13390d;

    /* renamed from: e  reason: collision with root package name */
    public float f13391e;

    /* renamed from: f  reason: collision with root package name */
    public float f13392f;

    /* renamed from: g  reason: collision with root package name */
    public int f13393g;

    /* renamed from: h  reason: collision with root package name */
    public VelocityTracker f13394h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    public ViewGroup f13395i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f13396j;

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
        this.f13393g = -1;
        this.f13396j = true;
        this.f13395i = viewGroup;
        this.f13389c = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(viewGroup.getContext()));
    }

    @SuppressLint({"LongLogTag"})
    public boolean a(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
            int action = motionEvent.getAction() & 255;
            if (action != 3 && action != 1) {
                if (action != 0) {
                    if (this.f13387a) {
                        return true;
                    }
                    if (this.f13388b) {
                        return false;
                    }
                }
                if (action == 0) {
                    this.f13391e = motionEvent.getX();
                    float y = motionEvent.getY();
                    this.f13392f = y;
                    this.f13390d = y;
                    this.f13393g = MotionEventCompat.getPointerId(motionEvent, 0);
                    this.f13388b = false;
                    this.f13387a = false;
                } else if (action == 2) {
                    int i2 = this.f13393g;
                    if (i2 != -1) {
                        int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i2);
                        if (findPointerIndex >= 0 && findPointerIndex < motionEvent.getPointerCount()) {
                            float y2 = MotionEventCompat.getY(motionEvent, findPointerIndex) - this.f13390d;
                            float abs = Math.abs(y2);
                            float abs2 = Math.abs(MotionEventCompat.getX(motionEvent, findPointerIndex) - this.f13391e);
                            float f2 = this.f13396j ? 0.5f : 3.0f;
                            if (abs > this.f13389c && abs * f2 > abs2) {
                                this.f13387a = true;
                                c(true);
                                this.f13390d = y2 > 0.0f ? this.f13392f + this.f13389c : this.f13392f - this.f13389c;
                            } else if (abs2 > this.f13389c) {
                                this.f13388b = true;
                            }
                        } else {
                            this.f13387a = false;
                        }
                    }
                } else if (action == 6) {
                    b(motionEvent);
                }
                if (this.f13394h == null) {
                    this.f13394h = VelocityTracker.obtain();
                }
                this.f13394h.addMovement(motionEvent);
                return this.f13387a;
            }
            this.f13387a = false;
            this.f13388b = false;
            this.f13393g = -1;
            VelocityTracker velocityTracker = this.f13394h;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f13394h = null;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void b(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent) == null) {
            int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
            if (MotionEventCompat.getPointerId(motionEvent, actionIndex) == this.f13393g) {
                int i2 = actionIndex == 0 ? 1 : 0;
                this.f13390d = MotionEventCompat.getY(motionEvent, i2);
                this.f13393g = MotionEventCompat.getPointerId(motionEvent, i2);
                VelocityTracker velocityTracker = this.f13394h;
                if (velocityTracker != null) {
                    velocityTracker.clear();
                }
            }
        }
    }

    public final void c(boolean z) {
        ViewParent parent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || (parent = this.f13395i.getParent()) == null) {
            return;
        }
        parent.requestDisallowInterceptTouchEvent(z);
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f13396j = z;
        }
    }
}

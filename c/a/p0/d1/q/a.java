package c.a.p0.d1.q;

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
    public boolean f13329a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f13330b;

    /* renamed from: c  reason: collision with root package name */
    public int f13331c;

    /* renamed from: d  reason: collision with root package name */
    public float f13332d;

    /* renamed from: e  reason: collision with root package name */
    public float f13333e;

    /* renamed from: f  reason: collision with root package name */
    public float f13334f;

    /* renamed from: g  reason: collision with root package name */
    public int f13335g;

    /* renamed from: h  reason: collision with root package name */
    public VelocityTracker f13336h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    public ViewGroup f13337i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f13338j;

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
        this.f13335g = -1;
        this.f13338j = true;
        this.f13337i = viewGroup;
        this.f13331c = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(viewGroup.getContext()));
    }

    public boolean a(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
            int action = motionEvent.getAction() & 255;
            if (action != 3 && action != 1) {
                if (action != 0) {
                    if (this.f13329a) {
                        return true;
                    }
                    if (this.f13330b) {
                        return false;
                    }
                }
                if (action == 0) {
                    this.f13333e = motionEvent.getX();
                    float y = motionEvent.getY();
                    this.f13334f = y;
                    this.f13332d = y;
                    this.f13335g = MotionEventCompat.getPointerId(motionEvent, 0);
                    this.f13330b = false;
                    this.f13329a = false;
                } else if (action == 2) {
                    int i2 = this.f13335g;
                    if (i2 != -1) {
                        int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i2);
                        float y2 = MotionEventCompat.getY(motionEvent, findPointerIndex) - this.f13332d;
                        float abs = Math.abs(y2);
                        float abs2 = Math.abs(MotionEventCompat.getX(motionEvent, findPointerIndex) - this.f13333e);
                        float f2 = this.f13338j ? 0.5f : 3.0f;
                        if (abs > this.f13331c && abs * f2 > abs2) {
                            this.f13329a = true;
                            c(true);
                            this.f13332d = y2 > 0.0f ? this.f13334f + this.f13331c : this.f13334f - this.f13331c;
                        } else if (abs2 > this.f13331c) {
                            this.f13330b = true;
                        }
                    }
                } else if (action == 6) {
                    b(motionEvent);
                }
                if (this.f13336h == null) {
                    this.f13336h = VelocityTracker.obtain();
                }
                this.f13336h.addMovement(motionEvent);
                return this.f13329a;
            }
            this.f13329a = false;
            this.f13330b = false;
            this.f13335g = -1;
            VelocityTracker velocityTracker = this.f13336h;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f13336h = null;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void b(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent) == null) {
            int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
            if (MotionEventCompat.getPointerId(motionEvent, actionIndex) == this.f13335g) {
                int i2 = actionIndex == 0 ? 1 : 0;
                this.f13332d = MotionEventCompat.getY(motionEvent, i2);
                this.f13335g = MotionEventCompat.getPointerId(motionEvent, i2);
                VelocityTracker velocityTracker = this.f13336h;
                if (velocityTracker != null) {
                    velocityTracker.clear();
                }
            }
        }
    }

    public final void c(boolean z) {
        ViewParent parent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || (parent = this.f13337i.getParent()) == null) {
            return;
        }
        parent.requestDisallowInterceptTouchEvent(z);
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f13338j = z;
        }
    }
}

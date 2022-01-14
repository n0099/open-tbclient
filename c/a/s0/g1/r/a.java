package c.a.s0.g1.r;

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
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f12749b;

    /* renamed from: c  reason: collision with root package name */
    public int f12750c;

    /* renamed from: d  reason: collision with root package name */
    public float f12751d;

    /* renamed from: e  reason: collision with root package name */
    public float f12752e;

    /* renamed from: f  reason: collision with root package name */
    public float f12753f;

    /* renamed from: g  reason: collision with root package name */
    public int f12754g;

    /* renamed from: h  reason: collision with root package name */
    public VelocityTracker f12755h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    public ViewGroup f12756i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f12757j;

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
        this.f12754g = -1;
        this.f12757j = true;
        this.f12756i = viewGroup;
        this.f12750c = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(viewGroup.getContext()));
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
                    if (this.f12749b) {
                        return false;
                    }
                }
                if (action == 0) {
                    this.f12752e = motionEvent.getX();
                    float y = motionEvent.getY();
                    this.f12753f = y;
                    this.f12751d = y;
                    this.f12754g = MotionEventCompat.getPointerId(motionEvent, 0);
                    this.f12749b = false;
                    this.a = false;
                } else if (action == 2) {
                    int i2 = this.f12754g;
                    if (i2 != -1) {
                        int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i2);
                        if (findPointerIndex >= 0 && findPointerIndex < motionEvent.getPointerCount()) {
                            float y2 = MotionEventCompat.getY(motionEvent, findPointerIndex) - this.f12751d;
                            float abs = Math.abs(y2);
                            float abs2 = Math.abs(MotionEventCompat.getX(motionEvent, findPointerIndex) - this.f12752e);
                            float f2 = this.f12757j ? 0.5f : 3.0f;
                            if (abs > this.f12750c && abs * f2 > abs2) {
                                this.a = true;
                                c(true);
                                this.f12751d = y2 > 0.0f ? this.f12753f + this.f12750c : this.f12753f - this.f12750c;
                            } else if (abs2 > this.f12750c) {
                                this.f12749b = true;
                            }
                        } else {
                            this.a = false;
                        }
                    }
                } else if (action == 6) {
                    b(motionEvent);
                }
                if (this.f12755h == null) {
                    this.f12755h = VelocityTracker.obtain();
                }
                this.f12755h.addMovement(motionEvent);
                return this.a;
            }
            this.a = false;
            this.f12749b = false;
            this.f12754g = -1;
            VelocityTracker velocityTracker = this.f12755h;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f12755h = null;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void b(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent) == null) {
            int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
            if (MotionEventCompat.getPointerId(motionEvent, actionIndex) == this.f12754g) {
                int i2 = actionIndex == 0 ? 1 : 0;
                this.f12751d = MotionEventCompat.getY(motionEvent, i2);
                this.f12754g = MotionEventCompat.getPointerId(motionEvent, i2);
                VelocityTracker velocityTracker = this.f12755h;
                if (velocityTracker != null) {
                    velocityTracker.clear();
                }
            }
        }
    }

    public final void c(boolean z) {
        ViewParent parent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || (parent = this.f12756i.getParent()) == null) {
            return;
        }
        parent.requestDisallowInterceptTouchEvent(z);
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f12757j = z;
        }
    }
}

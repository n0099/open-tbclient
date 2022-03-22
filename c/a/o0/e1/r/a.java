package c.a.o0.e1.r;

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
    public boolean f10250b;

    /* renamed from: c  reason: collision with root package name */
    public int f10251c;

    /* renamed from: d  reason: collision with root package name */
    public float f10252d;

    /* renamed from: e  reason: collision with root package name */
    public float f10253e;

    /* renamed from: f  reason: collision with root package name */
    public float f10254f;

    /* renamed from: g  reason: collision with root package name */
    public int f10255g;

    /* renamed from: h  reason: collision with root package name */
    public VelocityTracker f10256h;
    @NonNull
    public ViewGroup i;
    public boolean j;

    public a(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {viewGroup};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f10255g = -1;
        this.j = true;
        this.i = viewGroup;
        this.f10251c = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(viewGroup.getContext()));
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
                    if (this.f10250b) {
                        return false;
                    }
                }
                if (action == 0) {
                    this.f10253e = motionEvent.getX();
                    float y = motionEvent.getY();
                    this.f10254f = y;
                    this.f10252d = y;
                    this.f10255g = MotionEventCompat.getPointerId(motionEvent, 0);
                    this.f10250b = false;
                    this.a = false;
                } else if (action == 2) {
                    int i = this.f10255g;
                    if (i != -1) {
                        int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i);
                        if (findPointerIndex >= 0 && findPointerIndex < motionEvent.getPointerCount()) {
                            float y2 = MotionEventCompat.getY(motionEvent, findPointerIndex) - this.f10252d;
                            float abs = Math.abs(y2);
                            float abs2 = Math.abs(MotionEventCompat.getX(motionEvent, findPointerIndex) - this.f10253e);
                            float f2 = this.j ? 0.5f : 3.0f;
                            if (abs > this.f10251c && abs * f2 > abs2) {
                                this.a = true;
                                c(true);
                                this.f10252d = y2 > 0.0f ? this.f10254f + this.f10251c : this.f10254f - this.f10251c;
                            } else if (abs2 > this.f10251c) {
                                this.f10250b = true;
                            }
                        } else {
                            this.a = false;
                        }
                    }
                } else if (action == 6) {
                    b(motionEvent);
                }
                if (this.f10256h == null) {
                    this.f10256h = VelocityTracker.obtain();
                }
                this.f10256h.addMovement(motionEvent);
                return this.a;
            }
            this.a = false;
            this.f10250b = false;
            this.f10255g = -1;
            VelocityTracker velocityTracker = this.f10256h;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f10256h = null;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void b(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent) == null) {
            int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
            if (MotionEventCompat.getPointerId(motionEvent, actionIndex) == this.f10255g) {
                int i = actionIndex == 0 ? 1 : 0;
                this.f10252d = MotionEventCompat.getY(motionEvent, i);
                this.f10255g = MotionEventCompat.getPointerId(motionEvent, i);
                VelocityTracker velocityTracker = this.f10256h;
                if (velocityTracker != null) {
                    velocityTracker.clear();
                }
            }
        }
    }

    public final void c(boolean z) {
        ViewParent parent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || (parent = this.i.getParent()) == null) {
            return;
        }
        parent.requestDisallowInterceptTouchEvent(z);
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.j = z;
        }
    }
}

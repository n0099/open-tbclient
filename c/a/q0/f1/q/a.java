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
    public boolean f13362a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f13363b;

    /* renamed from: c  reason: collision with root package name */
    public int f13364c;

    /* renamed from: d  reason: collision with root package name */
    public float f13365d;

    /* renamed from: e  reason: collision with root package name */
    public float f13366e;

    /* renamed from: f  reason: collision with root package name */
    public float f13367f;

    /* renamed from: g  reason: collision with root package name */
    public int f13368g;

    /* renamed from: h  reason: collision with root package name */
    public VelocityTracker f13369h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    public ViewGroup f13370i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f13371j;

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
        this.f13368g = -1;
        this.f13371j = true;
        this.f13370i = viewGroup;
        this.f13364c = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(viewGroup.getContext()));
    }

    @SuppressLint({"LongLogTag"})
    public boolean a(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
            int action = motionEvent.getAction() & 255;
            if (action != 3 && action != 1) {
                if (action != 0) {
                    if (this.f13362a) {
                        return true;
                    }
                    if (this.f13363b) {
                        return false;
                    }
                }
                if (action == 0) {
                    this.f13366e = motionEvent.getX();
                    float y = motionEvent.getY();
                    this.f13367f = y;
                    this.f13365d = y;
                    this.f13368g = MotionEventCompat.getPointerId(motionEvent, 0);
                    this.f13363b = false;
                    this.f13362a = false;
                } else if (action == 2) {
                    int i2 = this.f13368g;
                    if (i2 != -1) {
                        int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i2);
                        if (findPointerIndex >= 0 && findPointerIndex < motionEvent.getPointerCount()) {
                            float y2 = MotionEventCompat.getY(motionEvent, findPointerIndex) - this.f13365d;
                            float abs = Math.abs(y2);
                            float abs2 = Math.abs(MotionEventCompat.getX(motionEvent, findPointerIndex) - this.f13366e);
                            float f2 = this.f13371j ? 0.5f : 3.0f;
                            if (abs > this.f13364c && abs * f2 > abs2) {
                                this.f13362a = true;
                                c(true);
                                this.f13365d = y2 > 0.0f ? this.f13367f + this.f13364c : this.f13367f - this.f13364c;
                            } else if (abs2 > this.f13364c) {
                                this.f13363b = true;
                            }
                        } else {
                            this.f13362a = false;
                        }
                    }
                } else if (action == 6) {
                    b(motionEvent);
                }
                if (this.f13369h == null) {
                    this.f13369h = VelocityTracker.obtain();
                }
                this.f13369h.addMovement(motionEvent);
                return this.f13362a;
            }
            this.f13362a = false;
            this.f13363b = false;
            this.f13368g = -1;
            VelocityTracker velocityTracker = this.f13369h;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f13369h = null;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void b(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent) == null) {
            int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
            if (MotionEventCompat.getPointerId(motionEvent, actionIndex) == this.f13368g) {
                int i2 = actionIndex == 0 ? 1 : 0;
                this.f13365d = MotionEventCompat.getY(motionEvent, i2);
                this.f13368g = MotionEventCompat.getPointerId(motionEvent, i2);
                VelocityTracker velocityTracker = this.f13369h;
                if (velocityTracker != null) {
                    velocityTracker.clear();
                }
            }
        }
    }

    public final void c(boolean z) {
        ViewParent parent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || (parent = this.f13370i.getParent()) == null) {
            return;
        }
        parent.requestDisallowInterceptTouchEvent(z);
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f13371j = z;
        }
    }
}

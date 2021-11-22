package b.a.q0.e1.r;

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
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f13241a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f13242b;

    /* renamed from: c  reason: collision with root package name */
    public int f13243c;

    /* renamed from: d  reason: collision with root package name */
    public float f13244d;

    /* renamed from: e  reason: collision with root package name */
    public float f13245e;

    /* renamed from: f  reason: collision with root package name */
    public float f13246f;

    /* renamed from: g  reason: collision with root package name */
    public int f13247g;

    /* renamed from: h  reason: collision with root package name */
    public VelocityTracker f13248h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    public ViewGroup f13249i;
    public boolean j;

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
        this.f13247g = -1;
        this.j = true;
        this.f13249i = viewGroup;
        this.f13243c = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(viewGroup.getContext()));
    }

    @SuppressLint({"LongLogTag"})
    public boolean a(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
            int action = motionEvent.getAction() & 255;
            if (action != 3 && action != 1) {
                if (action != 0) {
                    if (this.f13241a) {
                        return true;
                    }
                    if (this.f13242b) {
                        return false;
                    }
                }
                if (action == 0) {
                    this.f13245e = motionEvent.getX();
                    float y = motionEvent.getY();
                    this.f13246f = y;
                    this.f13244d = y;
                    this.f13247g = MotionEventCompat.getPointerId(motionEvent, 0);
                    this.f13242b = false;
                    this.f13241a = false;
                } else if (action == 2) {
                    int i2 = this.f13247g;
                    if (i2 != -1) {
                        int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i2);
                        if (findPointerIndex >= 0 && findPointerIndex < motionEvent.getPointerCount()) {
                            float y2 = MotionEventCompat.getY(motionEvent, findPointerIndex) - this.f13244d;
                            float abs = Math.abs(y2);
                            float abs2 = Math.abs(MotionEventCompat.getX(motionEvent, findPointerIndex) - this.f13245e);
                            float f2 = this.j ? 0.5f : 3.0f;
                            if (abs > this.f13243c && abs * f2 > abs2) {
                                this.f13241a = true;
                                c(true);
                                this.f13244d = y2 > 0.0f ? this.f13246f + this.f13243c : this.f13246f - this.f13243c;
                            } else if (abs2 > this.f13243c) {
                                this.f13242b = true;
                            }
                        } else {
                            this.f13241a = false;
                        }
                    }
                } else if (action == 6) {
                    b(motionEvent);
                }
                if (this.f13248h == null) {
                    this.f13248h = VelocityTracker.obtain();
                }
                this.f13248h.addMovement(motionEvent);
                return this.f13241a;
            }
            this.f13241a = false;
            this.f13242b = false;
            this.f13247g = -1;
            VelocityTracker velocityTracker = this.f13248h;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f13248h = null;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void b(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent) == null) {
            int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
            if (MotionEventCompat.getPointerId(motionEvent, actionIndex) == this.f13247g) {
                int i2 = actionIndex == 0 ? 1 : 0;
                this.f13244d = MotionEventCompat.getY(motionEvent, i2);
                this.f13247g = MotionEventCompat.getPointerId(motionEvent, i2);
                VelocityTracker velocityTracker = this.f13248h;
                if (velocityTracker != null) {
                    velocityTracker.clear();
                }
            }
        }
    }

    public final void c(boolean z) {
        ViewParent parent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || (parent = this.f13249i.getParent()) == null) {
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

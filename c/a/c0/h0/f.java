package c.a.c0.h0;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class f extends TouchDelegate {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<View, a> a;

    /* loaded from: classes.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Rect a;

        /* renamed from: b  reason: collision with root package name */
        public int f2153b;

        /* renamed from: c  reason: collision with root package name */
        public int f2154c;

        /* renamed from: d  reason: collision with root package name */
        public int f2155d;

        /* renamed from: e  reason: collision with root package name */
        public int f2156e;

        /* renamed from: f  reason: collision with root package name */
        public int f2157f;

        /* renamed from: g  reason: collision with root package name */
        public Rect f2158g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f2159h;

        public a(f fVar, Rect rect, int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, rect, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i6 = newInitContext.flag;
                if ((i6 & 1) != 0) {
                    int i7 = i6 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2153b = i2;
            this.a = rect;
            this.f2155d = i3;
            this.f2154c = i4;
            this.f2156e = i5;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(View view, int i2, int i3, int i4, int i5) {
        super(new Rect(), view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i6 = newInitContext.flag;
            if ((i6 & 1) != 0) {
                int i7 = i6 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Rect) objArr2[0], (View) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new HashMap();
        a(view, i2, i3, i4, i5);
    }

    public void a(View view, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            this.a.put(view, new a(this, new Rect(), i2, i3, i4, i5));
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            for (Map.Entry<View, a> entry : this.a.entrySet()) {
                View key = entry.getKey();
                int[] iArr = new int[2];
                key.getLocationOnScreen(iArr);
                int measuredWidth = key.getMeasuredWidth();
                int measuredHeight = key.getMeasuredHeight();
                a value = entry.getValue();
                Rect rect = value.a;
                rect.left = iArr[0] - value.f2153b;
                rect.right = iArr[0] + measuredWidth + value.f2154c;
                rect.top = iArr[1] - value.f2155d;
                rect.bottom = iArr[1] + measuredHeight + value.f2156e;
                value.f2157f = ViewConfiguration.get(key.getContext()).getScaledTouchSlop();
                Rect rect2 = new Rect(value.a);
                value.f2158g = rect2;
                int i2 = value.f2157f;
                rect2.inset(-i2, -i2);
            }
        }
    }

    @Override // android.view.TouchDelegate
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
            b();
            int rawX = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            boolean z = false;
            boolean z2 = false;
            boolean z3 = true;
            for (Map.Entry<View, a> entry : this.a.entrySet()) {
                View key = entry.getKey();
                if (key.getVisibility() != 0) {
                    break;
                }
                a value = entry.getValue();
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action == 1 || action == 2) {
                        z2 = value.f2159h;
                        if (z2 && !value.f2158g.contains(rawX, rawY)) {
                            z3 = false;
                        }
                    } else if (action == 3) {
                        z2 = value.f2159h;
                        value.f2159h = false;
                    }
                } else if (value.a.contains(rawX, rawY)) {
                    value.f2159h = true;
                    z2 = true;
                } else {
                    value.f2159h = false;
                    z2 = false;
                }
                if (z2) {
                    if (z3) {
                        motionEvent.setLocation(key.getWidth() / 2, key.getHeight() / 2);
                    } else {
                        float f2 = -(value.f2157f * 2);
                        motionEvent.setLocation(f2, f2);
                    }
                    z = key.dispatchTouchEvent(motionEvent);
                    continue;
                }
                if (z) {
                    break;
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }
}

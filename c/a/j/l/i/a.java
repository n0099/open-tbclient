package c.a.j.l.i;

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
public class a extends TouchDelegate {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<View, C0200a> a;

    /* renamed from: c.a.j.l.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0200a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Rect a;

        /* renamed from: b  reason: collision with root package name */
        public int f4213b;

        /* renamed from: c  reason: collision with root package name */
        public int f4214c;

        /* renamed from: d  reason: collision with root package name */
        public int f4215d;

        /* renamed from: e  reason: collision with root package name */
        public int f4216e;

        /* renamed from: f  reason: collision with root package name */
        public Rect f4217f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f4218g;

        public C0200a(a aVar, Rect rect, int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, rect, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i6 = newInitContext.flag;
                if ((i6 & 1) != 0) {
                    int i7 = i6 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4213b = i2;
            this.a = rect;
            this.f4214c = i4;
            this.f4215d = i5;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(View view, int i2, int i3, int i4, int i5, Rect rect) {
        super(rect, view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), rect};
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
        b(view, i2, i3, i4, i5);
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (Map.Entry<View, C0200a> entry : this.a.entrySet()) {
                View key = entry.getKey();
                C0200a value = entry.getValue();
                key.getGlobalVisibleRect(value.a);
                Rect rect = value.a;
                int i2 = rect.left;
                int i3 = value.f4213b;
                rect.left = i2 - i3;
                rect.right += value.f4214c;
                rect.top -= i3;
                rect.bottom += value.f4215d;
                value.f4216e = ViewConfiguration.get(key.getContext()).getScaledTouchSlop();
                Rect rect2 = new Rect(value.a);
                value.f4217f = rect2;
                int i4 = value.f4216e;
                rect2.inset(-i4, -i4);
            }
        }
    }

    public void b(View view, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            this.a.put(view, new C0200a(this, new Rect(), i2, i3, i4, i5));
        }
    }

    @Override // android.view.TouchDelegate
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
            a();
            int rawX = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            boolean z = false;
            boolean z2 = false;
            boolean z3 = true;
            for (Map.Entry<View, C0200a> entry : this.a.entrySet()) {
                View key = entry.getKey();
                if (key.getVisibility() != 0) {
                    break;
                }
                C0200a value = entry.getValue();
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action == 1 || action == 2) {
                        z2 = value.f4218g;
                        if (z2 && !value.f4217f.contains(rawX, rawY)) {
                            z3 = false;
                        }
                    } else if (action == 3) {
                        z2 = value.f4218g;
                        value.f4218g = false;
                    }
                } else if (value.a.contains(rawX, rawY)) {
                    value.f4218g = true;
                    z2 = true;
                } else {
                    value.f4218g = false;
                    z2 = false;
                }
                if (z2) {
                    if (z3) {
                        motionEvent.setLocation(key.getWidth() / 2, key.getHeight() / 2);
                    } else {
                        float f2 = -(value.f4216e * 2);
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
